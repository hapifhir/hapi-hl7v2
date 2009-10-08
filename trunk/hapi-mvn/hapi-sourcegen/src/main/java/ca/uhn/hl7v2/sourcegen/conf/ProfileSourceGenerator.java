/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ca.uhn.hl7v2.sourcegen.conf;

import ca.uhn.hl7v2.conf.ProfileException;
import ca.uhn.hl7v2.conf.parser.ProfileParser;
import ca.uhn.hl7v2.conf.spec.RuntimeProfile;
import ca.uhn.hl7v2.conf.spec.message.AbstractSegmentContainer;
import ca.uhn.hl7v2.conf.spec.message.Field;
import ca.uhn.hl7v2.conf.spec.message.ProfileStructure;
import ca.uhn.hl7v2.conf.spec.message.Seg;
import ca.uhn.hl7v2.conf.spec.message.SegGroup;
import ca.uhn.hl7v2.conf.spec.message.StaticDef;
import ca.uhn.hl7v2.parser.DefaultModelClassFactory;
import ca.uhn.hl7v2.sourcegen.GroupDef;
import ca.uhn.hl7v2.sourcegen.GroupGenerator;
import ca.uhn.hl7v2.sourcegen.MessageGenerator;
import ca.uhn.hl7v2.sourcegen.SegmentDef;
import ca.uhn.hl7v2.sourcegen.SegmentElement;
import ca.uhn.hl7v2.sourcegen.SegmentGenerator;
import ca.uhn.hl7v2.sourcegen.SourceGenerator;
import ca.uhn.hl7v2.sourcegen.StructureDef;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 *
 * @author t3903uhn
 */
public class ProfileSourceGenerator {

	private static final Log ourLog = LogFactory.getLog(ProfileSourceGenerator.class);

	private final RuntimeProfile myProfile;
	private String myTargetDirectory;
	private String myBasePackage;
	private String myMessageName;
	private Set<String> mySegmentDefNames;
	private Set<String> myGroupDefNames;
	private final ArrayList<SegmentDef> mySegmentDefs;
	private final Map<String, ArrayList<SegmentElement>> mySegmentNameToSegmentElements;
	private final ArrayList<GroupDef> myGroupDefs;


	public ProfileSourceGenerator(RuntimeProfile theProfile, String theTargetDirectory, String theBasePackage) {
		myProfile = theProfile;

		myTargetDirectory = theTargetDirectory;
		if (!myTargetDirectory.endsWith("/")) {
			myTargetDirectory += "/";
		}

		myBasePackage = theBasePackage;
		if (!myBasePackage.endsWith(".")) {
			myBasePackage += ".";
		}

		myTargetDirectory += myBasePackage.replaceAll("\\.", "/");

		mySegmentDefs = new ArrayList<SegmentDef>();
		myGroupDefs = new ArrayList<GroupDef>();
		mySegmentNameToSegmentElements = new HashMap<String, ArrayList<SegmentElement>>();
		mySegmentDefNames = new HashSet<String>();
		myGroupDefNames = new HashSet<String>();
	}


	public void generate() throws Exception {
		StaticDef staticDef = myProfile.getMessage();
		myMessageName = staticDef.getMsgStructID();

		SourceGenerator.makeDirectory(myTargetDirectory + "/message");
		SourceGenerator.makeDirectory(myTargetDirectory + "/segment");
		SourceGenerator.makeDirectory(myTargetDirectory + "/group");
		SourceGenerator.makeDirectory(myTargetDirectory + "/datatype");

		List<StructureDef> contents = new ArrayList<StructureDef>();
		String chapter = "";
		String version = myProfile.getHL7Version();
		GroupDef group = convertToGroupDef(staticDef);

		String basePackageName = DefaultModelClassFactory.getVersionPackageName(version);
		String[] datatypePackages = { basePackageName + "datatype" };

        boolean haveGroups = myGroupDefs.size() > 0;
        
		// Write Message
		{
			String fileName = myTargetDirectory + "message/" + staticDef.getMsgStructID() + ".java";
			ourLog.info("Writing Message file: " + fileName);
			MessageGenerator.writeMessage(fileName, group.getStructures(), myMessageName, chapter, version, group, myBasePackage, haveGroups);
		}

		for (GroupDef next : myGroupDefs) {
			String fileName = myTargetDirectory + "group/" + next.getName() + ".java";
			ourLog.info("Writing Group file: " + fileName);
			GroupGenerator.writeGroup(fileName, next, version, myBasePackage);
		}

		// Write Segments
		for (SegmentDef next : mySegmentDefs) {
			String fileName = myTargetDirectory + "segment/" + next.getName() + ".java";
			ourLog.info("Writing Segment file: " + fileName);
			String segmentName = next.getName();
			String description = next.getDescription();
			ArrayList<SegmentElement> elements = mySegmentNameToSegmentElements.get(segmentName);
			SegmentGenerator.writeSegment(fileName, version, segmentName, elements, description, myBasePackage, datatypePackages );
		}
	}

	private GroupDef convertToGroupDef(StaticDef staticDef) {

		boolean required = true;
		boolean repeating = true;
		String description = staticDef.getDescription();
		GroupDef retVal = new GroupDef(myMessageName, null, required, repeating, description);

		populateChildren(retVal, staticDef);

		return retVal;
	}

	private GroupDef convertToGroupDef(SegGroup segGroup) {

		/*
		 * MWB exports optional repeating groups as an optional group with a single child which is a required repeating group
		 * If we encounter this, we flatten this to be an optional repeating group
		 */
		boolean required = true;
		if (segGroup.getChildren() == 1 && segGroup.getChild(1) instanceof SegGroup) {
			required = segGroup.getMin() > 0;
			segGroup = (SegGroup) segGroup.getChild(1);
		}

		String name = segGroup.getName();
		required = required && (segGroup.getMin() > 0);
		boolean repeating = segGroup.getMax() != 1;
		String description = segGroup.getDescription();
		GroupDef retVal = new GroupDef(myMessageName, name, required, repeating, description);
		
		populateChildren(retVal, segGroup);

		if (!myGroupDefNames.contains(name)) {
			myGroupDefNames.add(name);
			myGroupDefs.add(retVal);
		}

		return retVal;
	}

	private void populateChildren(GroupDef retVal, AbstractSegmentContainer segGroup) {

		for (int i = 0; i < segGroup.getChildren(); i++) {
			ProfileStructure nextProfileStructure = segGroup.getChild(i + 1);

			if (nextProfileStructure instanceof SegGroup) {

				SegGroup nextSegGroup = (SegGroup)nextProfileStructure;
				GroupDef nextGroupDef = convertToGroupDef(nextSegGroup);
				retVal.addStructure(nextGroupDef);

			} else if (nextProfileStructure instanceof Seg) {

				Seg nextSeg = (Seg)nextProfileStructure;
				SegmentDef nextSegmentDef = convertToSegmentDef(nextSeg);
				retVal.addStructure(nextSegmentDef);
				
			} else {
				
				throw new IllegalStateException("Unknown profile structure: "  + nextProfileStructure);

			} // if-else

		} // for

	}

	private SegmentDef convertToSegmentDef(Seg nextSeg) {
		String name = nextSeg.getName();
		String groupName = null;
		boolean required = nextSeg.getMin() > 0;
		boolean repeating = nextSeg.getMax() > 1;
		String description = nextSeg.getDescription();

		SegmentDef retVal = new SegmentDef(name, groupName, required, repeating, description);
		ArrayList<SegmentElement> segmentElements = new ArrayList<SegmentElement>();

		// Extract fields from the segment definition
		for (int i = 0; i < nextSeg.getFields(); i++) {
			Field nextField = nextSeg.getField(i + 1);

			SegmentElement nextSegmentElement = new SegmentElement();
			
			nextSegmentElement.desc = nextField.getName();
			nextSegmentElement.field = i + 1;
			nextSegmentElement.length = (int) nextField.getLength();
			nextSegmentElement.opt = nextField.getUsage();
			nextSegmentElement.rep = (nextField.getMax() != 1) ? "Y" : "N";
			nextSegmentElement.repetitions = nextField.getMax();
			String table = nextField.getTable();
			if (table != null && table.length() > 0) {
				nextSegmentElement.table = Integer.parseInt(table);
			}
			nextSegmentElement.type = nextField.getDatatype();

            if (nextSegmentElement.type.startsWith("CM_")) {
                nextSegmentElement.type = nextSegmentElement.type.substring(3);
            }

			segmentElements.add(nextSegmentElement);
		}

		if (!mySegmentDefNames.contains(name)) {
			mySegmentDefNames.add(name);
			mySegmentDefs.add(retVal);
			mySegmentNameToSegmentElements.put(name, segmentElements);
		}

		return retVal;
	}



	public static void main(String[] args) throws ProfileException, IOException, Exception {
		RuntimeProfile rp = new ProfileParser(false).parseClasspath("OLIS HL7 Structure-ORU_R01.xml");
		new ProfileSourceGenerator(rp, "src/main/resources", "hapi.on.olis").generate();
	}
}
