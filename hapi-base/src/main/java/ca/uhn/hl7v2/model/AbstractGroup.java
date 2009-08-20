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
GNU General Public License (the  �GPL�), in which case the provisions of the GPL are 
applicable instead of those above.  If you wish to allow use of your version of this 
file only under the terms of the GPL and not to allow others to use your version 
of this file under the MPL, indicate your decision by deleting  the provisions above 
and replace  them with the notice and other provisions required by the GPL License.  
If you do not delete the provisions above, a recipient may use your version of 
this file under either the MPL or the GPL. 

*/

package ca.uhn.hl7v2.model;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.parser.ModelClassFactory;


/**
 * A partial implementation of Group.  Subclasses correspond to specific
 * groups of segments (and/or other sub-groups) that are implicitly defined by message structures  
 * in the HL7 specification.  A subclass should define it's group structure by putting repeated calls to 
 * the add(...) method in it's constructor.  Each call to add(...) adds a specific component to the 
 * Group.  
 * @author Bryan Tripp (bryan_tripp@sourceforge.net)
 */
public abstract class AbstractGroup implements Group {
    
    private ArrayList<String> names;
    private HashMap<String, ArrayList<Structure>> structures;
    private HashMap<String, Boolean> required;
    private HashMap<String, Boolean> repeating;
    private HashMap<String, Class<? extends Structure>> classes;
    //protected Message message;
    private Group parent;

	private final ModelClassFactory myFactory;
    
    /** 
     * This constructor should be used by implementing classes that do not 
     * also implement Message.
     *   
     * @param parent the group to which this Group belongs.
     * @param factory the factory for classes of segments, groups, and datatypes under this group
     */
    protected AbstractGroup(Group parent, ModelClassFactory factory) {
        this.parent = parent;
        this.myFactory = factory;
        init();
    }
    
    /** 
     * This constructor should only be used by classes that implement Message directly.
     *  
     * @param factory the factory for classes of segments, groups, and datatypes under this group
     */
    protected AbstractGroup(ModelClassFactory factory) {
        this.myFactory = factory;
        init();
    }
    
    private void init() {
        names = new ArrayList<String>();
        structures = new HashMap<String, ArrayList<Structure>>();
        required = new HashMap<String, Boolean>();
        repeating = new HashMap<String, Boolean>();
        classes = new HashMap<String, Class<? extends Structure>>();        
    }
    
    /**
     * Returns the named structure.  If this Structure is repeating then the first 
     * repetition is returned.  Creates the Structure if necessary.  
     * @throws HL7Exception if the named Structure is not part of this Group. 
     */
    public Structure get(String name) throws HL7Exception {
        return get(name, 0);
    }

    /**
     * Returns a particular repetition of the named Structure. If the given repetition
     * number is one greater than the existing number of repetitions then a new  
     * Structure is created.  
     * @throws HL7Exception if the named Structure is not part of this group, 
     *    if the structure is not repeatable and the given rep is > 0,  
     *    or if the given repetition number is more than one greater than the 
     *    existing number of repetitions.  
     */
    public Structure get(String name,int rep) throws HL7Exception {
    	List<Structure> list = structures.get(name);
        if (list == null) throw new HL7Exception(name + " does not exist in the group " + this.getClass().getName(), HL7Exception.APPLICATION_INTERNAL_ERROR);
        
        Structure ret;
        if (rep < list.size()) {
            // return existing Structure if it exists 
            ret = (Structure)list.get(rep);
        } else if (rep == list.size()) {
            //verify that Structure is repeating ... 
            Boolean repeats = (Boolean)this.repeating.get(name);
            if (!repeats.booleanValue() && list.size() > 0) throw new HL7Exception("Can't create repetition #" + 
                rep + " of Structure " + name + " - this Structure is non-repeating", HL7Exception.APPLICATION_INTERNAL_ERROR);
            
            //create a new Structure, add it to the list, and return it
            Class<? extends Structure> c = classes.get(name); //get class 
            ret = tryToInstantiateStructure(c, name);
            list.add(ret);
        } else {
            throw new HL7Exception("Can't return repetition #" + rep + " of " + name + 
                " - there are only " + list.size() + " repetitions.", HL7Exception.APPLICATION_INTERNAL_ERROR);
        }
        return ret;    
    }
    
    /**
     * Expands the group definition to include a segment that is not 
     * defined by HL7 to be part of this group (eg an unregistered Z segment). 
     * The new segment is slotted at the end of the group.  Thenceforward if 
     * such a segment is encountered it will be parsed into this location. 
     * If the segment name is unrecognized a GenericSegment is used.  The 
     * segment is defined as repeating and not required.  
     */
    public String addNonstandardSegment(String name) throws HL7Exception {
        String version = this.getMessage().getVersion();
        if (version == null) 
            throw new HL7Exception("Need message version to add segment by name; message.getVersion() returns null");        
        Class<? extends Structure> c = myFactory.getSegmentClass(name, version);
        if (c == null) 
            c = GenericSegment.class;
        
        int index = this.getNames().length;
        
        tryToInstantiateStructure(c, name);  //may throw exception
        
        return insert(c, false, true, index, name);
    }
       
	public String addNonstandardSegment(String theName, int theIndex) throws HL7Exception {
    	if (this instanceof Message && theIndex == 0) {
    		throw new HL7Exception("Can not add nonstandard segment \"" + theName + "\" to start of message.");
    	}
    	
        String version = this.getMessage().getVersion();
        if (version == null) 
            throw new HL7Exception("Need message version to add segment by name; message.getVersion() returns null");        
        Class<? extends Structure> c = myFactory.getSegmentClass(theName, version);
        if (c == null) 
            c = GenericSegment.class;
        
        tryToInstantiateStructure(c, theName);  //may throw exception

        return insert(c, false, true, theIndex, theName);
	}
    
    /**
     * Returns an ordered array of the names of the Structures in this 
     * Group.  These names can be used to iterate through the group using 
     * repeated calls to <code>get(name)</code>. 
     */    
    public String[] getNames() {
        String[] retVal = new String[this.names.size()];
        for (int i = 0; i < this.names.size(); i++) {
            retVal[i] = (String)this.names.get(i);
        }
        return retVal;
    }
    
    /**
     * Adds a new Structure (group or segment) to this Group.  A place for the  
     * Structure is added to the group but there are initially zero repetitions.  
     * This method should be used by the constructors of implementing classes 
     * to specify which Structures the Group contains - Structures should be 
     * added in the order in which they appear.  
     * Note that the class is supplied instead of an instance because we want 
     * there initially to be zero instances of each structure but we want the 
     * AbstractGroup code to be able to create instances as necessary to support
     * get(...) calls.
     * @return the actual name used to store this structure (may be appended with 
     *      an integer if there are duplicates in the same Group).  
     */
    protected String add(Class<? extends Structure> c, boolean required, boolean repeating) throws HL7Exception {
        String name = getName(c);
        
        return insert(c, required, repeating, this.names.size(), name);
    }
        
    /** 
     * Returns true if the class name is already being used. 
     */
    private boolean nameExists(String name) {
        boolean exists = false;
        Object o = this.classes.get(name);
        if (o != null) exists = true;
        return exists;
    }
    
    /**
     * Attempts to create an instance of the given class and return 
     * it as a Structure. 
     * @param c the Structure implementing class
     * @param name an optional name of the structure (used by Generic structures; may be null)
     */
    private Structure tryToInstantiateStructure(Class<? extends Structure> c, String name) throws HL7Exception {
        Structure s = null;
        try {
            Object o = null;
            if (GenericSegment.class.isAssignableFrom(c)) {
                s = new GenericSegment(this, name);
            } else if (GenericGroup.class.isAssignableFrom(c)) {
                s = new GenericGroup(this, name, myFactory);
            } else {
                //first try to instantiate using constructor w/ Message args ...
                try {
                    Class<?>[] argClasses = {Group.class, ModelClassFactory.class};
                    Object[] argObjects = {this, myFactory};
                    Constructor<?> con = c.getConstructor(argClasses);
                    o = con.newInstance(argObjects);
                } catch (NoSuchMethodException nme) {
                    o = c.newInstance();
                }
                if (!(o instanceof Structure))
                    throw new HL7Exception("Class " + c.getName() + " does not implement " +
                    "ca.on.uhn.hl7.message.Structure", HL7Exception.APPLICATION_INTERNAL_ERROR);
                s = (Structure)o;
            }
        } catch (Exception e) {
            if (e instanceof HL7Exception) { 
                throw (HL7Exception) e;
            } else {
                throw new HL7Exception( 
                    "Can't instantiate class " + c.getName(), 
                    HL7Exception.APPLICATION_INTERNAL_ERROR, 
                    e);
            }
        }
        return s;
    }
  
    /**
     * Returns the Message to which this segment belongs.
     */
    public Message getMessage() {
        Structure s = this;
        while (!Message.class.isAssignableFrom(s.getClass())) {
            s = s.getParent();
        }
        return (Message) s;
    }
    
    /** Returns the parent group within which this structure exists (may be root
     * message group).
     */
    public Group getParent() {
        return this.parent;
    }
    
    /**
     * Returns true if the named structure is required. 
     */
    public boolean isRequired(String name) throws HL7Exception {
        Object o = required.get(name);
        if (o == null) throw new HL7Exception("The structure " + name + " does not exist in the group " + this.getClass().getName(), HL7Exception.APPLICATION_INTERNAL_ERROR);
        Boolean req = (Boolean)o;
        return req.booleanValue();
    }

    /**
     * Returns true if the named structure is required. 
     */    
    public boolean isRepeating(String name) throws HL7Exception {
        Object o = repeating.get(name);
        if (o == null) throw new HL7Exception("The structure " + name + " does not exist in the group " + this.getClass().getName(), HL7Exception.APPLICATION_INTERNAL_ERROR);
        Boolean rep = (Boolean)o;
        return rep.booleanValue();
    }
    
    /**
     * Returns the number of existing repetitions of the named structure.
     */
    public int currentReps(String name) throws HL7Exception {
        ArrayList<Structure> list = structures.get(name);
        if (list == null) throw new HL7Exception("The structure " + name + " does not exist in the group " + this.getClass().getName(), HL7Exception.APPLICATION_INTERNAL_ERROR);
        return list.size();
    }
    
    /**
     * Returns an array of Structure objects by name.  For example, if the Group contains
     * an MSH segment and "MSH" is supplied then this call would return a 1-element array 
     * containing the MSH segment.  Multiple elements are returned when the segment or 
     * group repeats.  The array may be empty if no repetitions have been accessed
     * yet using the get(...) methods. 
     * @throws HL7Exception if the named Structure is not part of this Group. 
     */
    public Structure[] getAll(String name) throws HL7Exception {
        ArrayList<Structure> list = structures.get(name);
        if (list == null) throw new HL7Exception("The structure " + name + " does not exist in the group " + this.getClass().getName(), HL7Exception.APPLICATION_INTERNAL_ERROR);
        Structure[] all = new Structure[list.size()];
        for (int i = 0; i < list.size(); i++) {
            all[i] = (Structure)list.get(i);
        }
        return all;
    }
    
    /**
     * Returns the Class of the Structure at the given name index.  
     */
    public Class<? extends Structure> getClass(String name) {
        return classes.get(name);
    }
    
    /**
     * Returns the class name (excluding package). 
     * @see Structure#getName() 
     */
    public String getName() {
        return getName(this.getClass());
    }
    
    //returns a name for a class of a Structure in this Message  
    private String getName(Class<? extends Structure> c) {
        String fullName = c.getName();
        int dotLoc = fullName.lastIndexOf('.');
        String name = fullName.substring(dotLoc + 1, fullName.length());  
        
        //remove message name prefix from group names for compatibility with getters ...
        if (Group.class.isAssignableFrom(c) && !Message.class.isAssignableFrom(c)) {
            String messageName = getMessage().getName();
            if (name.startsWith(messageName) && name.length() > messageName.length()) {
                name = name.substring(messageName.length() + 1);
            }            
        }
        
        return name;        
    }
    
    /**
     * Inserts the given structure into this group, at the
     * indicated index number.  This method is used to support handling 
     * of unexpected segments (e.g. Z-segments).  In contrast, specification 
     * of the group's normal children should be done at construction time, using the 
     * add(...) method. 
     */
    private String insert(Class<? extends Structure> c, boolean required, boolean repeating, int index, String name) throws HL7Exception {        
        //tryToInstantiateStructure(c, name);   //may throw exception
        
        //see if there is already something by this name and make a new name if necessary ... 
        if (nameExists(name)) {
            int version = 2;
            String newName = name;
            while (nameExists(newName)) {
                newName = name + version++;
            }
            name = newName;
        }   
        
        this.names.add(index, name);
        this.required.put(name, new Boolean(required));
        this.repeating.put(name, new Boolean(repeating));
        this.classes.put(name, c);
        this.structures.put(name, new ArrayList<Structure>());
        
        return name;      
    }
} 