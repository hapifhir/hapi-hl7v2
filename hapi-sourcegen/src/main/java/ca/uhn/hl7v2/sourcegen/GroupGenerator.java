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
import java.io.OutputStreamWriter;
import java.util.Arrays;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.context.Context;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.Version;
import ca.uhn.hl7v2.parser.DefaultModelClassFactory;
import ca.uhn.hl7v2.sourcegen.util.VelocityFactory;

/**
 * Creates source code for Group classes - these are aggregations of segments
 * and/or other groups that may repeat together within a message. Source code is
 * generated from the normative database.
 * 
 * @author Bryan Tripp (bryan_tripp@sourceforge.net)
 * @author Eric Poiseau
 */
public class GroupGenerator extends java.lang.Object {

    private static final Logger log = LoggerFactory.getLogger(GroupGenerator.class);


    public static void writeGroup(String groupName, String fileName, GroupDef group, String version, String basePackageName, String theTemplatePackage, String theDescription) throws Exception {

        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName, false), SourceGenerator.ENCODING));

        theTemplatePackage = theTemplatePackage.replace(".", "/");
        Template template = VelocityFactory.getClasspathTemplateInstance(theTemplatePackage + "/group.vsm");
        Context ctx = new VelocityContext();
        ctx.put("groupName", groupName);
        ctx.put("specVersion", version);
        ctx.put("typeDescription", theDescription);
        ctx.put("basePackageName", basePackageName);
        ctx.put("groups", Arrays.asList(group.getStructures()));
        ctx.put("chapter", "");
        
        template.merge(ctx, out);

        out.flush();
        out.close();
        
//        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName, false), SourceGenerator.ENCODING));
//        out.write(makePreamble(group, version, basePackageName));
//        out.write(makeConstructor(group, version));
//        StructureDef[] shallow = group.getStructures();
//        for (int i = 0; i < shallow.length; i++) {
//            out.write(makeAccessor(group, i));
//        }
//        out.write("}\r\n");
//        out.flush();
//        out.close();
    }


    /** Creates new GroupGenerator */
    public GroupGenerator() {
    }


    /**
     * <p>
     * Creates source code for a Group and returns a GroupDef object that
     * describes the Group's name, optionality, repeatability. The source code
     * is written under the given directory.
     * </p>
     * <p>
     * The structures list may contain [] and {} pairs representing nested
     * groups and their optionality and repeastability. In these cases this
     * method is called recursively.
     * </p>
     * <p>
     * If the given structures list begins and ends with repetition and/or
     * optionality markers the repetition and optionality of the returned
     * GroupDef are set accordingly.
     * </p>
     * 
     * @param structures
     *            a list of the structures that comprise this group - must be at
     *            least 2 long
     * @param baseDirectory
     *            the directory to which files should be written
     * @param message
     *            the message to which this group belongs
     * @param theTemplatePackage 
     * @throws Exception 
     */
    public static GroupDef writeGroup(StructureDef[] structures, String groupName, String baseDirectory, String version, String message, String theTemplatePackage, String theFileExt) throws Exception {

        // make base directory
        if (!(baseDirectory.endsWith("\\") || baseDirectory.endsWith("/"))) {
            baseDirectory = baseDirectory + "/";
        }
        File targetDir = SourceGenerator.makeDirectory(baseDirectory + DefaultModelClassFactory.getVersionPackagePath(version) + "group");

        GroupDef group = getGroupDef(structures, groupName, baseDirectory, version, message, theTemplatePackage, theFileExt);

        String fileName = targetDir.getPath() + "/" + group.getName() + "." + theFileExt;
        writeGroup(group.getName(), fileName, group, version, DefaultModelClassFactory.getVersionPackageName(version), theTemplatePackage, group.getDescription());

        return group;
    }


    /**
     * <p>
     * Given a list of structures defining the deep content of a group (as
     * provided in the normative database, some being pairs of optionality and
     * repetition markers and segments nested within) returns a GroupDef
     * including a short list of the shallow contents of the group (including
     * segments and groups that are immediate children).
     * </p>
     * <p>
     * For example given MSH [PID PV1] {[ERR NTE]}, short list would be
     * something like MSH PID_GROUP ERR_GROUP (with PID_GROUP marked as optional
     * and ERR_GROUP marked as optional and repeating).
     * </p>
     * <p>
     * This method calls writeGroup(...) where necessary in order to create
     * source code for any nested groups before returning corresponding
     * GroupDefs.
     * </p>
     */
    public static GroupDef getGroupDef(StructureDef[] structures, String groupName, String baseDirectory, String version, String message, String theTemplatePackage, String theFileExt) throws Exception {
        GroupDef ret = null;
        boolean required = true;
        boolean repeating = false;
        boolean rep_opt = false;

        int len = structures.length;
        StructureDef[] shortList = new StructureDef[len]; // place to put final
                                                          // list of
                                                          // groups/seg's w/o
                                                          // opt & rep markers
        int currShortListPos = 0;
        int currLongListPos = 0;

        try {
            // check for rep and opt (see if start & end elements are [] or {}
            // AND they are each others' pair) ...
            // System.out.println(len + " " + structures[0].getName()
            // +structures[1].getName()+ ".." +structures[len-2].getName() +
            // structures[len-1].getName()+ " " + message);
            String struct0name = structures[0].getName();
            String struct1name = structures[1].getName();
            String structLastName = structures[len - 1].getName();
            String structSecondLastName = structures[len - 2].getName();

            if (optMarkers(struct0name, structLastName) && (findGroupEnd(message, structures, 0) == len - 1))
                required = false;
            if (repMarkers(struct0name, structLastName) && (findGroupEnd(message, structures, 0) == len - 1))
                repeating = true;
            if (repoptMarkers(struct0name, structLastName) && (findGroupEnd(message, structures, 0) == len - 1))
                rep_opt = true;

            if (repeating || !required) {
                if (optMarkers(struct1name, structSecondLastName) && (findGroupEnd(message, structures, 1) == len - 2))
                    required = false;
                if (repMarkers(struct1name, structSecondLastName) && (findGroupEnd(message, structures, 1) == len - 2))
                    repeating = true;
            }

            // loop through, recurse nested groups, and build short list of
            // structures for this group
            int skip = 0;
            if (!required)
                skip++;
            if (repeating)
                skip++;
            if (rep_opt)
                skip++;
            currLongListPos = skip;
            while (currLongListPos < len - skip) {
                String currSegName = structures[currLongListPos].getName();
                if (currSegName.equals("[") || currSegName.equals("{") || currSegName.equals("[{")) {
                    // this is the opening of a new group ...
                    String name = ((SegmentDef) structures[currLongListPos]).getGroupName();
                    
                    // Fix mistakes in DB
                    if (name != null) {
                    	name = name.replace("TIIMING", "TIMING");
                    }

//                    log.info("Name is: " + name + " - Message is: " + message);
                    
                    int endOfNewGroup = findGroupEnd(message, structures, currLongListPos);
                    StructureDef[] newGroupStructures = new StructureDef[endOfNewGroup - currLongListPos + 1];
                    System.arraycopy(structures, currLongListPos, newGroupStructures, 0, newGroupStructures.length);
                    shortList[currShortListPos] = writeGroup(newGroupStructures, name, baseDirectory, version, message, theTemplatePackage, theFileExt);
                    currLongListPos = endOfNewGroup + 1;
                } else {
                    // copy verbatim into short list ...
                    shortList[currShortListPos] = structures[currLongListPos];
                    currLongListPos++;
                }
                currShortListPos++;
            }
        } catch (IllegalArgumentException e) {
            throw new HL7Exception("Problem creating nested group: " + e.getClass().getName() + ": " + e.getMessage(), HL7Exception.APPLICATION_INTERNAL_ERROR);
        }

        if (rep_opt) {
            ret = new GroupDef(message, groupName, false, true, "a Group object");
        } else {
            ret = new GroupDef(message, groupName, required, repeating, "a Group object");
        }

        StructureDef[] finalList = new StructureDef[currShortListPos]; // note:
                                                                       // incremented
                                                                       // after
                                                                       // last
                                                                       // assignment
        System.arraycopy(shortList, 0, finalList, 0, currShortListPos);
        for (int i = 0; i < finalList.length; i++) {
        	StructureDef nextStruct = finalList[i];
        	
        	// Fix mistakes in the DB
			if (nextStruct.getUnqualifiedName().equals("ED")) {
        		continue;
        	}
        	if (nextStruct instanceof GroupDef && ((GroupDef)nextStruct).getRawGroupName() != null && ((GroupDef)nextStruct).getRawGroupName().contains("TIIMING")) {
        		((GroupDef)nextStruct).setRawGroupName(((GroupDef)nextStruct).getRawGroupName().replace("TIIMING", "TIMING"));
        	}
        	
        	/*
        	 * Versions 2.5 through 2.6 have two definitions of RSP_K21 (the second is under
        	 * trigger K22 - see chapter 3) and the second definition shows this group as
        	 * repeatable. See bug 3520523.
        	 * 
        	 * This issue has been corrected in 2.7
        	 */
        	String nextName = nextStruct.getUnqualifiedName();
            if ("QUERY_RESPONSE".equals(nextName)) {
            	if ("RSP_K21".equals(message)) {
            		if (Version.versionOf(version) == Version.V25 || Version.versionOf(version) == Version.V251
            				|| Version.versionOf(version) == Version.V26) {
                        log.info("Forcing repeatable group");
            			((GroupDef)nextStruct).setRepeating(true);
            		}
            	}
            }
        	
            ret.addStructure(nextStruct);
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
     * Given a list of structures and the position of a SegmentDef that
     * indicates the start of a group (ie "{" or "["), returns the position of
     * the corresponding end of the group. Nested group markers are ignored.
     * 
     * @param message
     *            The current message
     * @throws IllegalArgumentException
     *             if groupStart is out of range or does not point to a group
     *             opening marker.
     * @throws HL7Exception
     *             if the end of the group is not found or if other pairs are
     *             not properly nested inside this one.
     */
    public static int findGroupEnd(String message, StructureDef[] structures, int groupStart) throws IllegalArgumentException, HL7Exception {

        // {} is rep; [] is optionality
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
                log.error("Problem starting at {}", groupStart);
                for (int i = 0; i < structures.length; i++) {
                    log.error("Structure {}: ", i, structures[i].getName());
                }
                throw new IllegalArgumentException("The segment " + startMarker + " does not begin a group - must be [ or {");
            }
        } catch (IndexOutOfBoundsException e) {
            throw new IllegalArgumentException("The given start location is out of bounds");
        }

        // loop, increment and decrement opening and closing markers until we
        // get back to 0
        String segName = null;
        int offset = 0;
        try {
            int nestedInside = 1;
            while (nestedInside > 0) {
                offset++;
                segName = structures[groupStart + offset].getName();
                if (segName.equals("{") || segName.equals("[") || segName.equals("[{")) {
                    nestedInside++;
                } else if (segName.equals("}") || segName.equals("]") || segName.equals("}]")) {
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
