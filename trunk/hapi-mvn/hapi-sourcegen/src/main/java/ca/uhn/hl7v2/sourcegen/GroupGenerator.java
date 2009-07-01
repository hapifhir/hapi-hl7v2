/**
The contents of this file are subject to the Mozilla Public License Version 1.1 
(the "License"); you may not use this file except in compliance with the License. 
You may obtain a copy of the License at http://www.mozilla.org/MPL/ 
Software distributed under the License is distributed on an "AS IS" basis, 
WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the 
specific language governing rights and limitations under the License. 

The Original Code is "GroupGenerator.java".  Description: 
"Creates source code for Group classes - these are aggregations of 
  segments and/or other groups that may repeat together within a message.
  Source code is generated from the normative database" 

The Initial Developer of the Original Code is University Health Network. Copyright (C) 
2001.  All Rights Reserved. 

Contributor(s):  Eric Poiseau. 

Alternatively, the contents of this file may be used under the terms of the 
GNU General Public License (the  �GPL�), in which case the provisions of the GPL are 
applicable instead of those above.  If you wish to allow use of your version of this 
file only under the terms of the GPL and not to allow others to use your version 
of this file under the MPL, indicate your decision by deleting  the provisions above 
and replace  them with the notice and other provisions required by the GPL License.  
If you do not delete the provisions above, a recipient may use your version of 
this file under either the MPL or the GPL. 

*/

package ca.uhn.hl7v2.sourcegen;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.parser.DefaultModelClassFactory;
import ca.uhn.log.HapiLog;
import ca.uhn.log.HapiLogFactory;

/**
 * Creates source code for Group classes - these are aggregations of 
 * segments and/or other groups that may repeat together within a message.
 * Source code is generated from the normative database.  
 * 
 * @author Bryan Tripp (bryan_tripp@sourceforge.net)
 * @author Eric Poiseau
 */
public class GroupGenerator extends java.lang.Object {
    
    private static final HapiLog log = HapiLogFactory.getHapiLog(GroupGenerator.class);
    
    /** Creates new GroupGenerator */
    public GroupGenerator() {
    }

    /**
     * <p>Creates source code for a Group and returns a GroupDef object that 
     * describes the Group's name, optionality, repeatability.  The source 
     * code is written under the given directory.</p>  
     * <p>The structures list may contain [] and {} pairs representing 
     * nested groups and their optionality and repeastability.  In these cases
     * this method is called recursively.</p>
     * <p>If the given structures list begins and ends with repetition and/or 
     * optionality markers the repetition and optionality of the returned 
     * GroupDef are set accordingly.</p>  
     * @param structures a list of the structures that comprise this group - must 
     *      be at least 2 long
     * @param baseDirectory the directory to which files should be written
     * @param message the message to which this group belongs
     * @throws HL7Exception if the repetition and optionality markers are not 
     *      properly nested.  
     */
    public static GroupDef writeGroup(StructureDef[] structures, String groupName, String baseDirectory, String version, String message) 
            throws HL7Exception, IOException {

        //make base directory
        if (!(baseDirectory.endsWith("\\") || baseDirectory.endsWith("/"))) { 
            baseDirectory = baseDirectory + "/";
        }
        File targetDir = SourceGenerator.makeDirectory(baseDirectory + DefaultModelClassFactory.getVersionPackagePath(version) + "group"); 

        GroupDef group = getGroupDef(structures, groupName, baseDirectory, version, message);
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(targetDir.getPath() + "/" 
                + group.getName() + ".java", false), SourceGenerator.ENCODING));
        out.write(makePreamble(group, version));
        out.write(makeConstructor(group, version));
        
        StructureDef[] shallow = group.getStructures();
        for (int i = 0; i < shallow.length; i++) {
            out.write(makeAccessor(group, i));
        }
        out.write("}\r\n");
        out.flush();
        out.close();

        return group;
    }
    
    /**
     * <p>Given a list of structures defining the deep content of a group (as provided in 
     * the normative database, some being pairs of optionality and repetition markers
     * and segments nested within) returns a GroupDef including a short list of the shallow contents of the 
     * group (including segments and groups that are immediate children).</p> 
     * <p>For example given MSH [PID PV1] {[ERR NTE]}, short list would be something like 
     * MSH PID_GROUP ERR_GROUP (with PID_GROUP marked as optional and ERR_GROUP marked as 
     * optional and repeating).</p>
     * <p>This method calls writeGroup(...) where necessary in order to create source code for 
     * any nested groups before returning corresponding GroupDefs.</p>
     */
    public static GroupDef getGroupDef(StructureDef[] structures, String groupName, String baseDirectory, 
            String version, String message) throws HL7Exception, IOException {
        GroupDef ret = null;
        boolean required = true;
        boolean repeating = false;
        boolean rep_opt = false;

        int len = structures.length;
        StructureDef[] shortList = new StructureDef[len];  //place to put final list of groups/seg's w/o opt & rep markers
        int currShortListPos = 0; 
        int currLongListPos = 0;
        
        try {
            //check for rep and opt (see if start & end elements are [] or {} AND they are each others' pair) ... 
	        //System.out.println(len + " " + structures[0].getName() +structures[1].getName()+ ".." +structures[len-2].getName() + structures[len-1].getName()+ " " + message);
            String struct0name = structures[0].getName();
            String struct1name = structures[1].getName();            
            String structLastName = structures[len-1].getName();
            String structSecondLastName = structures[len-2].getName();
            
            if (optMarkers(struct0name, structLastName) && (findGroupEnd(message, structures, 0) == len-1)) required = false;
            if (repMarkers(struct0name, structLastName) && (findGroupEnd(message, structures, 0) == len-1)) repeating = true;
            if (repoptMarkers(struct0name, structLastName) && (findGroupEnd(message, structures, 0) == len-1)) rep_opt= true;
            
            if (repeating  || !required  ) {
                if (optMarkers(struct1name, structSecondLastName) && (findGroupEnd(message, structures, 1) == len-2)) required = false;
                if (repMarkers(struct1name, structSecondLastName) && (findGroupEnd(message, structures, 1) == len-2)) repeating = true;
            }
            
            //loop through, recurse nested groups, and build short list of structures for this group
            int skip = 0;
            if (!required) skip++;
            if (repeating) skip++;
            if (rep_opt) skip++;
            currLongListPos = skip;          
            while (currLongListPos < len - skip) {
                String currSegName = structures[currLongListPos].getName();
                if (currSegName.equals("[") || currSegName.equals("{") || currSegName.equals("[{")) {                    
                    //this is the opening of a new group ... 
                    String name = ((SegmentDef) structures[currLongListPos]).getGroupName();
                    int endOfNewGroup = findGroupEnd(message, structures, currLongListPos);
                    StructureDef[] newGroupStructures = new StructureDef[endOfNewGroup - currLongListPos + 1];
                    System.arraycopy(structures, currLongListPos, newGroupStructures, 0, newGroupStructures.length);
                    shortList[currShortListPos] = writeGroup(newGroupStructures, name, baseDirectory, version, message);
                    currLongListPos = endOfNewGroup + 1;
                } else {
                    //copy verbatim into short list ... 
                    shortList[currShortListPos] = structures[currLongListPos];
                    currLongListPos++;
                } 
                currShortListPos++;
            }
        } catch(IllegalArgumentException e) {
            throw new HL7Exception("Problem creating nested group: " + e.getClass().getName() + ": " + e.getMessage(), HL7Exception.APPLICATION_INTERNAL_ERROR);
        }
        
        if (rep_opt) {
            ret = new GroupDef(message, groupName, false, true, "a Group object");
        } else {
            ret = new GroupDef(message, groupName, required, repeating, "a Group object");
        }
        
        StructureDef[] finalList = new StructureDef[currShortListPos];  //note: incremented after last assignment
        System.arraycopy(shortList, 0, finalList, 0, currShortListPos);
        for (int i = 0; i < finalList.length; i++) {
            ret.addStructure(finalList[i]);
        }
        
        return ret;
    }
    
    /**
     * Returns true if opening is "[{" and closing is "}]"
     */
    private static boolean repoptMarkers(String opening, String closing) {
       boolean ret = false;
       if (opening.equals("[{") && closing.equals("}]")) {
           ret = true;
       }
       return ret;       
    }

    
    /**
     * Returns true if opening is "[" and closing is "]"
     */
    private static boolean optMarkers(String opening, String closing) {
       boolean ret = false;
       if (opening.equals("[") && closing.equals("]")) {
           ret = true;
       }
       return ret;       
    }
    
    /**
     * Returns true if opening is "{" and closing is "}"
     */
    private static boolean repMarkers(String opening, String closing) {
       boolean ret = false;
       if (opening.equals("{") && closing.equals("}")) {
           ret = true;
       }
       return ret;       
    }
    
    /**
     * Returns heading material for class source code (package, imports, JavaDoc, class
     * declaration).
     */
    public static String makePreamble(GroupDef group, String version) throws HL7Exception {
        StringBuffer preamble = new StringBuffer();
        preamble.append("package ");
        preamble.append(DefaultModelClassFactory.getVersionPackageName(version));
        preamble.append("group;\r\n\r\n");
        preamble.append("import ca.uhn.hl7v2.parser.ModelClassFactory;\r\n");
        preamble.append("import ca.uhn.hl7v2.HL7Exception;\r\n");
        preamble.append("import ca.uhn.log.HapiLogFactory;\r\n");
        preamble.append("import ");
        preamble.append(DefaultModelClassFactory.getVersionPackageName(version));
        preamble.append("segment.*;\r\n\r\n");
        preamble.append("import ca.uhn.hl7v2.model.*;\r\n");
        preamble.append("/**\r\n");
        preamble.append(" * <p>Represents the ");
        preamble.append(group.getName());
        preamble.append(" Group.  A Group is an ordered collection of message \r\n");
        preamble.append(" * segments that can repeat together or be optionally in/excluded together.\r\n");
        preamble.append(" * This Group contains the following elements: </p>\r\n");
        preamble.append(makeElementsDoc(group.getStructures()));
        preamble.append(" */\r\n");
        preamble.append("public class ");
        preamble.append(group.getName());
        preamble.append(" extends AbstractGroup {\r\n\r\n");
        
        return preamble.toString();
    }
    
    
    /**
     * Returns source code for the contructor for this Group class. 
     */
    public static String makeConstructor(GroupDef group, String version) {
       boolean useFactory 
           = System.getProperty(MessageGenerator.MODEL_CLASS_FACTORY_KEY, "FALSE").equalsIgnoreCase("TRUE");

       StringBuffer source = new StringBuffer();
       
       source.append("\t/** \r\n");
       source.append("\t * Creates a new ");
       source.append(group.getName());
       source.append(" Group.\r\n");
       source.append("\t */\r\n");
       source.append("\tpublic ");
       source.append(group.getName());
       source.append("(Group parent, ModelClassFactory factory) {\r\n");
       source.append("\t   super(parent, factory);\r\n");           
       source.append("\t   try {\r\n");
       StructureDef[] structs = group.getStructures();
       int numStructs = structs.length;
       for (int i = 0; i < numStructs; i++) {
           StructureDef def = structs[i];
           
           if (def.getName().equals("?")) {
               source.append("\t      this.addNonstandardSegment(\"ANY\");\r\n");
           } else  {
               if (useFactory) {
                   source.append("\t      this.add(factory.get");
                   source.append((def instanceof GroupDef) ? "Group" : "Segment");
                   source.append("Class(\"");
                   source.append(def.getName());
                   source.append("\", \"");
                   source.append(version);
                   source.append("\"), ");               
               } else {
                   source.append("\t      this.add(");
                   source.append(def.getName());
                   source.append(".class, ");               
               }
               
               source.append(def.isRequired());
               source.append(", ");
               source.append(def.isRepeating());
               source.append(");\r\n");
           }
       }
       source.append("\t   } catch(HL7Exception e) {\r\n"); 
       source.append("\t      HapiLogFactory.getHapiLog(this.getClass()).error(\"Unexpected error creating ");
       source.append(group.getName());
       source.append(" - this is probably a bug in the source code generator.\", e);\r\n");
       source.append("\t   }\r\n");
       source.append("\t}\r\n\r\n");
       return source.toString();
    }

    /**
     * Returns source code for a JavaDoc snippet listing the contents of a Group 
     * or Message.  
     */
    public static String makeElementsDoc(StructureDef[] structures) {
        StringBuffer elements = new StringBuffer();
        for (int i = 0; i < structures.length; i++) {
            StructureDef def = structures[i];
            elements.append(" * ");
            elements.append(i);
            elements.append(": ");
            elements.append(def.getName());
            elements.append(" (");
            elements.append(def.getDescription());
            elements.append(") <b>");
            if (!def.isRequired()) elements.append("optional ");
            if (def.isRepeating()) elements.append("repeating");
            elements.append("</b><br>\r\n");
        }

        return elements.toString();
    }
    
    /** 
     * Returns source code for an accessor method for a particular Structure. 
     */
    public static String makeAccessor(GroupDef group, int structure) throws IndexOutOfBoundsException {
        StringBuffer source = new StringBuffer();
        
        StructureDef def = group.getStructures()[structure];
        
        String name = def.getName();
        String indexName = group.getIndexName(name);
        String getterName = indexName;
        if (def instanceof GroupDef) {
            String unqualifiedName = ((GroupDef) def).getUnqualifiedName();
            getterName = group.getIndexName(unqualifiedName);
        }
        
        //make accessor for first (or only) rep ... 
        source.append("\t/**\r\n");
        source.append("\t * Returns ");
        if (def.isRepeating()) source.append(" first repetition of " );
        source.append(indexName);
        source.append(" (");
        source.append(def.getDescription());
        source.append(") - creates it if necessary\r\n");
        source.append("\t */\r\n");
        source.append("\tpublic ");
        source.append(def.getName());
        source.append(" get");
        source.append(getterName);
        source.append("() { \r\n");
        source.append("\t   ");
        source.append(def.getName());
        source.append(" ret = null;\r\n");        
        source.append("\t   try {\r\n");        
        source.append("\t      ret = (");
        source.append(def.getName());
        source.append(")this.get(\"");
        source.append(getterName);
        source.append("\");\r\n");
        source.append("\t   } catch(HL7Exception e) {\r\n"); 
        source.append("\t      HapiLogFactory.getHapiLog(this.getClass()).error(\"Unexpected error accessing data - this is probably a bug in the source code generator.\", e);\r\n");
        source.append("\t      throw new RuntimeException(e);\r\n");
        source.append("\t   }\r\n");
        source.append("\t   return ret;\r\n");
        source.append("\t}\r\n\r\n");
        
        if (def.isRepeating()) {
            //make accessor for specific rep ... 
            source.append("\t/**\r\n");
            source.append("\t * Returns a specific repetition of ");
            source.append(indexName);
            source.append("\r\n");
            source.append("\t * (");
            source.append(def.getDescription());
            source.append(") - creates it if necessary\r\n");
            source.append("\t * throws HL7Exception if the repetition requested is more than one \r\n");
            source.append("\t *     greater than the number of existing repetitions.\r\n");
            source.append("\t */\r\n");
            source.append("\tpublic ");
            source.append(def.getName());
            source.append(" get");
            source.append(getterName);
            source.append("(int rep) throws HL7Exception { \r\n");
            source.append("\t   return (");
            source.append(def.getName());
            source.append(")this.get(\"");
            source.append(getterName);
            source.append("\", rep);\r\n");
            source.append("\t}\r\n\r\n");     
            
            //make accessor for number of reps
            source.append("\t/** \r\n");
            source.append("\t * Returns the number of existing repetitions of ");
            source.append(indexName);            
            source.append(" \r\n");
            source.append("\t */ \r\n");
            source.append("\tpublic int get");
            source.append(getterName);
            source.append("Reps() { \r\n");
            source.append("\t    int reps = -1; \r\n");
            source.append("\t    try { \r\n");
            source.append("\t        reps = this.getAll(\"");
            source.append(getterName);
            source.append("\").length; \r\n");
            source.append("\t    } catch (HL7Exception e) { \r\n");
            source.append("\t        String message = \"Unexpected error accessing data - this is probably a bug in the source code generator.\"; \r\n");
            source.append("\t        HapiLogFactory.getHapiLog(this.getClass()).error(message, e); \r\n");
            source.append("\t        throw new RuntimeException(message);\r\n");
            source.append("\t    } \r\n");
            source.append("\t    return reps; \r\n");
            source.append("\t} \r\n\r\n");
        }
        
        return source.toString();
    }
    
    /**
     * Given a list of structures and the position of a SegmentDef that 
     * indicates the start of a group (ie "{" or "["), returns the position
     * of the corresponding end of the group.  Nested group markers are ignored.  
     * @param message The current message
     * @throws IllegalArgumentException if groupStart is out of range or does not 
     *      point to a group opening marker. 
     * @throws HL7Exception if the end of the group is not found or if other pairs 
     *      are not properly nested inside this one.  
     */ 
    public static int findGroupEnd(String message, StructureDef[] structures, int groupStart) throws IllegalArgumentException, HL7Exception {
        
        //  {} is rep; [] is optionality
        String endMarker = null;
        String startMarker;
        try {
            startMarker = structures[groupStart].getName();
            if (startMarker.equals("[")) {
                endMarker = "]";
            } else if (startMarker.equals("{")) {
                endMarker = "}";
            } else if (startMarker.equals("[{")) {
                endMarker = "}]";
            } else { 
                log.error("Problem starting at " + groupStart);
                for (int i = 0; i < structures.length; i++) {
                    log.error("Structure " + i + ": " + structures[i].getName());
                }
                throw new IllegalArgumentException("The segment " + startMarker + " does not begin a group - must be [ or {");
            }
        } catch (IndexOutOfBoundsException e) {
            throw new IllegalArgumentException("The given start location is out of bounds");
        } 
        
        //loop, increment and decrement opening and closing markers until we get back to 0 
        String segName = null;
        int offset = 0;
        try {
            int nestedInside = 1;
            while (nestedInside > 0) {
                offset++;
                segName = structures[groupStart + offset].getName();
                if (segName.equals("{") || segName.equals("[") || segName.equals("[{") ) {
                    nestedInside++;
                } else if (segName.equals("}") || segName.equals("]")|| segName.equals("}]")) {
                    nestedInside--;
                } 
            }
        } catch (IndexOutOfBoundsException e) {
            throw new HL7Exception("Couldn't find end of group index " + groupStart + " for msg " + message, HL7Exception.APPLICATION_INTERNAL_ERROR);
        }
        if (!endMarker.equals(segName)) {
        	StringBuffer buf = new StringBuffer();
        	for (int i = 0; i < structures.length; i++) {
        		buf.append("\r\n").append(i).append(" - ").append(structures[i].toString());
        	}
        	String msg = "Group markers for group indexes " + groupStart + "-" + (groupStart + offset) + " are not nested properly for message " + message + ": " + buf.toString();
			throw new HL7Exception(msg, HL7Exception.APPLICATION_INTERNAL_ERROR);
        }
        return groupStart + offset;        
    }

}
