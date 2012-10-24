/**
The contents of this file are subject to the Mozilla Public License Version 1.1 
(the "License"); you may not use this file except in compliance with the License. 
You may obtain a copy of the License at http://www.mozilla.org/MPL/ 
Software distributed under the License is distributed on an "AS IS" basis, 
WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the 
specific language governing rights and limitations under the License. 

The Original Code is "AbstractGroup.java".  Description: 
"A partial implementation of Group" 

The Initial Developer of the Original Code is University Health Network. Copyright (C) 
2001.  All Rights Reserved. 

Contributor(s): ______________________________________. 

Alternatively, the contents of this file may be used under the terms of the 
GNU General Public License (the  "GPL"), in which case the provisions of the GPL are 
applicable instead of those above.  If you wish to allow use of your version of this 
file only under the terms of the GPL and not to allow others to use your version 
of this file under the MPL, indicate your decision by deleting  the provisions above 
and replace  them with the notice and other provisions required by the GPL License.  
If you do not delete the provisions above, a recipient may use your version of 
this file under either the MPL or the GPL. 

 */

package ca.uhn.hl7v2.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.VersionLogger;
import ca.uhn.hl7v2.parser.EncodingCharacters;
import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.parser.PipeParser;
import ca.uhn.hl7v2.util.ReflectionUtil;

/**
 * A partial implementation of Group. Subclasses correspond to specific groups of segments (and/or
 * other sub-groups) that are implicitly defined by message structures in the HL7 specification. A
 * subclass should define it's group structure by putting repeated calls to the add(...) method in
 * it's constructor. Each call to add(...) adds a specific component to the Group.
 * 
 * @author Bryan Tripp (bryan_tripp@sourceforge.net)
 */
public abstract class AbstractGroup extends AbstractStructure implements Group {

    private static final long serialVersionUID = 1772720246448224363L;

    private List<String> names;
    private Map<String, List<Structure>> structures;
    private Map<String, Boolean> required;
    private Map<String, Boolean> repeating;
    private Map<String, Class<? extends Structure>> classes;
    // protected Message message;
    private Set<String> nonStandardNames;
    private final ModelClassFactory myFactory;

    static {
        VersionLogger.init();
    }

    /**
     * This constructor should be used by implementing classes that do not also implement Message.
     * 
     * @param parent the group to which this Group belongs.
     * @param factory the factory for classes of segments, groups, and datatypes under this group
     */
    protected AbstractGroup(Group parent, ModelClassFactory factory) {
        super(parent);
        this.myFactory = factory;
        init();
    }

    private void init() {
        names = new ArrayList<String>();
        structures = new HashMap<String, List<Structure>>();
        required = new HashMap<String, Boolean>();
        repeating = new HashMap<String, Boolean>();
        classes = new HashMap<String, Class<? extends Structure>>();
    }

    /**
     * Returns the named structure. If this Structure is repeating then the first repetition is
     * returned. Creates the Structure if necessary.
     * 
     * @throws HL7Exception if the named Structure is not part of this Group.
     */
    public Structure get(String name) throws HL7Exception {
        return get(name, 0);
    }

    protected <T extends Structure> T getTyped(String name, Class<T> type) {
        try {
            @SuppressWarnings("unchecked")
            T ret = (T) get(name);
            return ret;
        } catch (HL7Exception e) {
            log.error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
            throw new RuntimeException(e);
        }
    }

    /**
     * Returns a particular repetition of the named Structure. If the given repetition number is one
     * greater than the existing number of repetitions then a new Structure is created.
     * 
     * @throws HL7Exception if the named Structure is not part of this group, if the structure is
     *             not repeatable and the given rep is > 0, or if the given repetition number is
     *             more than one greater than the existing number of repetitions.
     */
    public Structure get(String name, int rep) throws HL7Exception {
        List<Structure> list = structures.get(name);
        if (list == null)
            throw new HL7Exception(name + " does not exist in the group " + this.getClass().getName());

        Structure ret;
        if (rep < list.size()) {
            // return existing Structure if it exists
            ret = list.get(rep);
        } else if (rep == list.size()) {
            // verify that Structure is repeating ...
            Boolean repeats = this.repeating.get(name);
            if (!repeats && list.size() > 0)
                throw new HL7Exception("Can't create repetition #" + rep + " of Structure " + name
                        + " - this Structure is non-repeating");

            // create a new Structure, add it to the list, and return it
            Class<? extends Structure> c = classes.get(name); // get class
            ret = tryToInstantiateStructure(c, name);
            list.add(ret);
        } else {
            throw new HL7Exception("Can't return repetition #" + rep + " of " + name + " - there are only "
                    + list.size() + " repetitions.");
        }
        return ret;
    }

    /**
     * {@inheritDoc}
     */
    public boolean isEmpty() throws HL7Exception {
        for (String name : getNames()) {
            if (!get(name).isEmpty())
                return false;
        }
        return true;
    }

    protected <T extends Structure> T getTyped(String name, int rep, Class<T> type) {
        try {
            @SuppressWarnings("unchecked")
            T ret = (T) get(name, rep);
            return ret;
        } catch (HL7Exception e) {
            log.error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
            throw new RuntimeException(e);
        }
    }

    protected int getReps(String name) {
        try {
            return getAll(name).length;
        } catch (HL7Exception e) {
            String message = "Unexpected error accessing data - this is probably a bug in the source code generator.";
            log.error(message, e);
            throw new RuntimeException(message);
        }
    }

    /**
     * Expands the group definition to include a segment that is not defined by HL7 to be part of
     * this group (eg an unregistered Z segment). The new segment is slotted at the end of the
     * group. Thenceforward if such a segment is encountered it will be parsed into this location.
     * If the segment name is unrecognized a GenericSegment is used. The segment is defined as
     * repeating and not required.
     */
    public String addNonstandardSegment(String name) throws HL7Exception {
        String version = this.getMessage().getVersion();
        if (version == null)
            throw new HL7Exception("Need message version to add segment by name; message.getVersion() returns null");
        Class<? extends Segment> c = myFactory.getSegmentClass(name, version);
        if (c == null)
            c = GenericSegment.class;

        int index = this.getNames().length;

        tryToInstantiateStructure(c, name); // may throw exception

        String newName = insert(c, false, true, index, name);
        if (this.nonStandardNames == null) {
            this.nonStandardNames = new HashSet<String>();
        }
        this.nonStandardNames.add(newName);

        return newName;
    }

    public String addNonstandardSegment(String theName, int theIndex) throws HL7Exception {
        if (this instanceof Message && theIndex == 0) {
            throw new HL7Exception("Can not add nonstandard segment \"" + theName + "\" to start of message.");
        }

        String version = this.getMessage().getVersion();
        if (version == null)
            throw new HL7Exception("Need message version to add segment by name; message.getVersion() returns null");
        Class<? extends Segment> c = myFactory.getSegmentClass(theName, version);

        if (c == null) {
            c = GenericSegment.class;
        }

        tryToInstantiateStructure(c, theName); // may throw exception

        String newName = insert(c, false, true, theIndex, theName);
        if (this.nonStandardNames == null) {
            this.nonStandardNames = new HashSet<String>();
        }
        this.nonStandardNames.add(newName);

        return newName;
    }

    /**
     * Returns a Set containing the names of all non-standard structures which have been added to
     * this structure
     */
    public Set<String> getNonStandardNames() {
        if (nonStandardNames == null) {
            return Collections.emptySet();
        }
        return Collections.unmodifiableSet(nonStandardNames);
    }

    /**
     * Returns an ordered array of the names of the Structures in this Group. These names can be
     * used to iterate through the group using repeated calls to <code>get(name)</code>.
     */
    public String[] getNames() {
        String[] retVal = new String[this.names.size()];
        for (int i = 0; i < this.names.size(); i++) {
            retVal[i] = this.names.get(i);
        }
        return retVal;
    }

    /**
     * Adds a new Structure (group or segment) to this Group. A place for the Structure is added to
     * the group but there are initially zero repetitions. This method should be used by the
     * constructors of implementing classes to specify which Structures the Group contains -
     * Structures should be added in the order in which they appear. Note that the class is supplied
     * instead of an instance because we want there initially to be zero instances of each structure
     * but we want the AbstractGroup code to be able to create instances as necessary to support
     * get(...) calls.
     * 
     * @return the actual name used to store this structure (may be appended with an integer if
     *         there are duplicates in the same Group).
     */
    protected String add(Class<? extends Structure> c, boolean required, boolean repeating) throws HL7Exception {
        String name = getName(c);
        return insert(c, required, repeating, this.names.size(), name);
    }

    /**
     * Adds a new Structure (group or segment) to this Group. A place for the Structure is added to
     * the group but there are initially zero repetitions. This method should be used by the
     * constructors of implementing classes to specify which Structures the Group contains -
     * Structures should be added in the order in which they appear. Note that the class is supplied
     * instead of an instance because we want there initially to be zero instances of each structure
     * but we want the AbstractGroup code to be able to create instances as necessary to support
     * get(...) calls.
     * 
     * @return the actual name used to store this structure (may be appended with an integer if
     *         there are duplicates in the same Group).
     */
    protected String add(Class<? extends Structure> c, boolean required, boolean repeating, int index)
            throws HL7Exception {
        String name = getName(c);
        return insert(c, required, repeating, index, name);
    }

    /**
     * Returns true if the class name is already being used.
     */
    private boolean nameExists(String name) {
        return this.classes.get(name) != null;
    }

    /**
     * Attempts to create an instance of the given class and return it as a Structure.
     * 
     * @param c the Structure implementing class
     * @param name an optional name of the structure (used by Generic structures; may be null)
     */
    protected Structure tryToInstantiateStructure(Class<? extends Structure> c, String name) throws HL7Exception {
        if (GenericSegment.class.isAssignableFrom(c)) {
            String genericName = name;
            if (genericName.length() > 3) {
                genericName = genericName.substring(0, 3);
            }
            return new GenericSegment(this, genericName);
        }
        if (GenericGroup.class.isAssignableFrom(c)) {
            return new GenericGroup(this, name, myFactory);
        }
        try {
            return ReflectionUtil.instantiateStructure(c, this, myFactory);
        } catch (Exception e) {
            return ReflectionUtil.instantiate(c);
        }

    }

    /**
     * Returns true if the named structure is a group
     */
    public boolean isGroup(String name) throws HL7Exception {
        Class<? extends Structure> clazz = classes.get(name);
        if (clazz == null)
            throw new HL7Exception("The structure " + name + " does not exist in the group "
                    + this.getClass().getName());
        return Group.class.isAssignableFrom(clazz);
    }

    /**
     * Returns true if the named structure is required.
     */
    public boolean isRequired(String name) throws HL7Exception {
        Boolean req = required.get(name);
        if (req == null)
            throw new HL7Exception("The structure " + name + " does not exist in the group "
                    + this.getClass().getName());
        return req;
    }

    /**
     * Returns true if the named structure is required.
     */
    public boolean isRepeating(String name) throws HL7Exception {
        Boolean rep = repeating.get(name);
        if (rep == null)
            throw new HL7Exception("The structure " + name + " does not exist in the group "
                    + this.getClass().getName());
        return rep;
    }

    /**
     * Returns the number of existing repetitions of the named structure.
     */
    public int currentReps(String name) throws HL7Exception {
        List<Structure> list = structures.get(name);
        if (list == null)
            throw new HL7Exception("The structure " + name + " does not exist in the group "
                    + this.getClass().getName());
        return list.size();
    }

    /**
     * Returns an array of Structure objects by name. For example, if the Group contains an MSH
     * segment and "MSH" is supplied then this call would return a 1-element array containing the
     * MSH segment. Multiple elements are returned when the segment or group repeats. The array may
     * be empty if no repetitions have been accessed yet using the get(...) methods.
     * 
     * @throws HL7Exception if the named Structure is not part of this Group.
     */
    public Structure[] getAll(String name) throws HL7Exception {
        List<Structure> list = structures.get(name);
        if (list == null) {
            throw new HL7Exception("The structure " + name + " does not exist in the group "
                    + this.getClass().getName());
        }
        return list.toArray(new Structure[list.size()]);
    }

    /**
     * Returns a list containing all existing repetitions of the structure identified by name
     * 
     * @throws HL7Exception if the named Structure is not part of this Group.
     */
    @SuppressWarnings("unchecked")
    protected <T extends Structure> List<T> getAllAsList(String name, Class<T> theType) throws HL7Exception {
        Class<? extends Structure> clazz = classes.get(name);

        if (!theType.equals(clazz)) {
            throw new HL7Exception("Structure with name \"" + name + "\" has type " + clazz.getName()
                    + " but should be " + theType);
        }
        List<T> retVal = new ArrayList<T>();
        for (Structure next : structures.get(name)) {
            retVal.add((T) next);
        }
        return Collections.unmodifiableList(retVal);
    }

    /**
     * Removes a repetition of a given Structure objects by name. For example, if the Group contains
     * 10 repititions an OBX segment and "OBX" is supplied with an index of 2, then this call would
     * remove the 3rd repetition. Note that in this case, the Set ID field in the OBX segments would
     * also need to be renumbered manually.
     * 
     * @return The removed structure
     * @throws HL7Exception if the named Structure is not part of this Group.
     */
    public Structure removeRepetition(String name, int index) throws HL7Exception {
        List<Structure> list = structures.get(name);
        if (list == null) {
            throw new HL7Exception("The structure " + name + " does not exist in the group "
                    + this.getClass().getName());
        }
        if (list.size() == 0) {
            throw new HL7Exception("Invalid index: " + index + ", structure " + name + " has no repetitions");
        }
        if (list.size() <= index) {
            throw new HL7Exception("Invalid index: " + index + ", structure " + name + " must be between 0 and "
                    + (list.size() - 1));
        }

        return list.remove(index);
    }

    /**
     * Inserts a repetition of a given Structure into repetitions of that structure by name. For
     * example, if the Group contains 10 repetitions an OBX segment and an OBX is supplied with an
     * index of 2, then this call would insert the new repetition at index 2. (Note that in this
     * example, the Set ID field in the OBX segments would also need to be renumbered manually).
     * 
     * @throws HL7Exception if the named Structure is not part of this Group.
     */
    protected void insertRepetition(String name, Structure structure, int index) throws HL7Exception {
        if (structure == null) {
            throw new NullPointerException("Structure may not be null");
        }

        if (structure.getMessage() != this.getMessage()) {
            throw new HL7Exception("Structure does not belong to this message");
        }

        List<Structure> list = structures.get(name);

        if (list == null) {
            throw new HL7Exception("The structure " + name + " does not exist in the group "
                    + this.getClass().getName());
        }
        if (list.size() < index) {
            throw new HL7Exception("Invalid index: " + index + ", structure " + name + " must be between 0 and "
                    + (list.size()));
        }

        list.add(index, structure);
    }

    /**
     * Inserts a repetition of a given Structure into repetitions of that structure by name. For
     * example, if the Group contains 10 repititions an OBX segment and an OBX is supplied with an
     * index of 2, then this call would insert the new repetition at index 2. Note that in this
     * case, the Set ID field in the OBX segments would also need to be renumbered manually.
     * 
     * @return The removed structure
     * @throws HL7Exception if the named Structure is not part of this Group.
     */
    public Structure insertRepetition(String name, int index) throws HL7Exception {
        if (name == null || name.length() == 0) {
            throw new NullPointerException("Name may not be null/empty");
        }

        Class<? extends Structure> structureClass = this.classes.get(name);
        if (structureClass == null) {
            throw new HL7Exception("Group " + this.getClass().getName() + " has no structure named " + name
                    + ": Valid names: " + this.classes.keySet());
        }

        Structure rep = tryToInstantiateStructure(structureClass, name);
        insertRepetition(name, rep, index);

        return rep;
    }

    /**
     * Given a child structure name, returns the child index (which is 1-indexed, meaning that the
     * first child is at index 1
     */
    public int getFieldNumForName(String name) throws HL7Exception {
        int retVal = names.indexOf(name);
        if (retVal == -1) {
            throw new HL7Exception("Unknown name: " + name);
        }
        return retVal + 1;
    }

    /**
     * Returns the Class of the Structure at the given name index.
     */
    public Class<? extends Structure> getClass(String name) {
        return classes.get(name);
    }

    /**
     * Returns the class name (excluding package).
     * 
     * @see Structure#getName()
     */
    public String getName() {
        return getName(getClass());
    }

    // returns a name for a class of a Structure in this Message
    private String getName(Class<? extends Structure> c) {
        String fullName = c.getName();
        int dotLoc = fullName.lastIndexOf('.');
        String name = fullName.substring(dotLoc + 1, fullName.length());

        // remove message name prefix from group names for compatibility with
        // getters ...
        if (Group.class.isAssignableFrom(c) && !Message.class.isAssignableFrom(c)) {
            String messageName = getMessage().getName();
            if (name.startsWith(messageName) && name.length() > messageName.length()) {
                name = name.substring(messageName.length() + 1);
            }
        }

        return name;
    }

    /**
     * Inserts the given structure into this group, at the indicated index number. This method is
     * used to support handling of unexpected segments (e.g. Z-segments). In contrast, specification
     * of the group's normal children should be done at construction time, using the add(...)
     * method.
     */
    protected String insert(Class<? extends Structure> c, boolean required, boolean repeating, int index, String name)
            throws HL7Exception {
        // tryToInstantiateStructure(c, name); //may throw exception

        // see if there is already something by this name and make a new name if
        // necessary ...
        if (nameExists(name)) {
            int version = 2;
            String newName = name;
            while (nameExists(newName)) {
                newName = name + version++;
            }
            name = newName;
        }

        if (index > this.names.size()) {
            throw new HL7Exception("Invalid index " + index + " - Should be <= " + this.names.size());
        }

        this.names.add(index, name);
        this.required.put(name, new Boolean(required));
        this.repeating.put(name, new Boolean(repeating));
        this.classes.put(name, c);
        this.structures.put(name, new ArrayList<Structure>());

        return name;
    }

    /**
     * Clears all data from this structure.
     */
    public void clear() {
        for (List<Structure> next : structures.values()) {
            if (next != null) {
                next.clear();
            }
        }
    }

    /**
     * Returns the {@link ModelClassFactory} associated with this structure
     */
    public final ModelClassFactory getModelClassFactory() {
        return myFactory;
    }

    /**
     * <p>
     * Appends a description of this group's structure and all children's structure to a string
     * builder.
     * </p>
     * <p>
     * Note that this method is intended only to be called by
     * {@link AbstractMessage#printStructure()}. Please use caution if calling this method directly,
     * as the method signature and/or behaviour may change in the future.
     * </p>
     */
    void appendStructureDescription(StringBuilder theStringBuilder, int theIndent, boolean theOptional,
            boolean theRepeating, boolean theAddStartName, boolean theAddEndName) throws HL7Exception {
        String lineSeparator = System.getProperty("line.separator");

        if (theAddStartName) {
            indent(theStringBuilder, theIndent);
            theStringBuilder.append(getName()).append(" (start)").append(lineSeparator);
        }

        if (theOptional || theRepeating) {
            indent(theStringBuilder, theIndent);
            if (theOptional) {
                theStringBuilder.append("[");
            }
            if (theRepeating) {
                theStringBuilder.append("{");
            }
            theStringBuilder.append(lineSeparator);
        }

        for (String nextName : getNames()) {

            Class<? extends Structure> nextClass = classes.get(nextName);

            boolean nextOptional = !isRequired(nextName);
            boolean nextRepeating = isRepeating(nextName);

            if (AbstractGroup.class.isAssignableFrom(nextClass)) {

                Structure[] nextChildren = getAll(nextName);
                for (int i = 0; i < nextChildren.length; i++) {

                    Structure structure = nextChildren[i];
                    boolean addStartName = (i == 0);
                    boolean addEndName = (i == (nextChildren.length - 1));
                    ((AbstractGroup) structure).appendStructureDescription(theStringBuilder, theIndent + 3,
                            nextOptional, nextRepeating, addStartName, addEndName);

                }

                if (nextChildren.length == 0) {
                    Structure structure = tryToInstantiateStructure(nextClass, nextName);
                    ((AbstractGroup) structure).appendStructureDescription(theStringBuilder, theIndent + 3,
                            nextOptional, nextRepeating, true, true);
                }

            } else if (Segment.class.isAssignableFrom(nextClass)) {

                int currentIndent = theStringBuilder.length();

                StringBuilder structurePrefix = new StringBuilder();
                indent(structurePrefix, theIndent + 3);
                if (nextOptional) {
                    structurePrefix.append("[ ");
                }
                if (nextRepeating) {
                    structurePrefix.append("{ ");
                }
                structurePrefix.append(nextName);
                if (nextRepeating) {
                    structurePrefix.append(" }");
                }
                if (nextOptional) {
                    structurePrefix.append(" ]");
                }

                if (this.nonStandardNames != null && this.nonStandardNames.contains(nextName)) {
                    structurePrefix.append(" (non-standard)");
                }
                structurePrefix.append(" - ");

                currentIndent = theStringBuilder.length() - currentIndent;
                List<Structure> nextStructureList = structures.get(nextName);
                theStringBuilder.append(structurePrefix);
                if (nextStructureList == null || nextStructureList.isEmpty()) {
                    theStringBuilder.append("Not populated");
                    theStringBuilder.append(lineSeparator);
                } else {
                    for (int i = 0; i < nextStructureList.size(); i++) {
                        if (i > 0) {
                            indent(theStringBuilder, currentIndent + structurePrefix.length());
                        }
                        Segment nextSegment = (Segment) nextStructureList.get(i);
                        theStringBuilder.append(new PipeParser().doEncode(nextSegment,
                                EncodingCharacters.getInstance(getMessage())));
                        theStringBuilder.append(lineSeparator);

                    }
                }

            }
        }

        if (theOptional || theRepeating) {
            indent(theStringBuilder, theIndent);
            if (theRepeating) {
                theStringBuilder.append("}");
            }
            if (theOptional) {
                theStringBuilder.append("]");
            }
            theStringBuilder.append(lineSeparator);
        }

        if (theAddEndName) {
            indent(theStringBuilder, theIndent);
            theStringBuilder.append(getName()).append(" (end)").append(lineSeparator);
        }
    }

    private void indent(StringBuilder theStringBuilder, int theIndent) {
        for (int i = 0; i < theIndent; i++) {
            theStringBuilder.append(' ');
        }
    }
}