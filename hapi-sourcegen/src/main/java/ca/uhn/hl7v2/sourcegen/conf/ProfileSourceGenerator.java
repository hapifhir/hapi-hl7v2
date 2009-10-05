/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ca.uhn.hl7v2.sourcegen.conf;

import ca.uhn.hl7v2.conf.ProfileException;
import ca.uhn.hl7v2.conf.parser.ProfileParser;
import ca.uhn.hl7v2.conf.spec.RuntimeProfile;
import ca.uhn.hl7v2.conf.spec.message.AbstractSegmentContainer;
import ca.uhn.hl7v2.conf.spec.message.ProfileStructure;
import ca.uhn.hl7v2.conf.spec.message.Seg;
import ca.uhn.hl7v2.conf.spec.message.SegGroup;
import ca.uhn.hl7v2.conf.spec.message.StaticDef;
import ca.uhn.hl7v2.sourcegen.GroupDef;
import ca.uhn.hl7v2.sourcegen.MessageGenerator;
import ca.uhn.hl7v2.sourcegen.SegmentDef;
import ca.uhn.hl7v2.sourcegen.SourceGenerator;
import ca.uhn.hl7v2.sourcegen.StructureDef;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author t3903uhn
 */
public class ProfileSourceGenerator {
	private final RuntimeProfile myProfile;
	private String myTargetDirectory;
	private String myBasePackage;
	private String myMessageName;
	private final ArrayList<SegmentDef> mySegmentDefs;
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
	}


	public void generate() throws Exception {
		StaticDef staticDef = myProfile.getMessage();
		myMessageName = staticDef.getMsgStructID();

		SourceGenerator.makeDirectory(myTargetDirectory + "/message");
		String fileName = myTargetDirectory + "message/" + staticDef.getMsgStructID() + ".java";


		staticDef.getChildren();

		List<StructureDef> contents = new ArrayList<StructureDef>();
		String chapter = "";
		String version = myProfile.getHL7Version();
		GroupDef group = convertToGroupDef(staticDef);

		MessageGenerator.writeMessage(fileName, group.getStructures(), myMessageName, chapter, version, group, myBasePackage);
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

		String name = segGroup.getName();
		boolean required = segGroup.getMin() > 0;
		boolean repeating = segGroup.getMax() > 1;
		String description = segGroup.getDescription();
		GroupDef retVal = new GroupDef(myMessageName, name, required, repeating, description);
		
		populateChildren(retVal, segGroup);

		return retVal;
	}

	private void populateChildren(GroupDef retVal, AbstractSegmentContainer segGroup) {

		for (int i = 0; i < segGroup.getChildren(); i++) {
			ProfileStructure nextProfileStructure = segGroup.getChild(i + 1);

			if (nextProfileStructure instanceof SegGroup) {

				SegGroup nextSegGroup = (SegGroup)nextProfileStructure;
				GroupDef nextGroupDef = convertToGroupDef(nextSegGroup);
				retVal.addStructure(nextGroupDef);

				myGroupDefs.add(nextGroupDef);

			} else if (nextProfileStructure instanceof Seg) {

				Seg nextSeg = (Seg)nextProfileStructure;
				SegmentDef nextSegmentDef = convertToSegmentDef(nextSeg);
				retVal.addStructure(nextSegmentDef);

				mySegmentDefs.add(nextSegmentDef);
				
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

		return retVal;
	}



	public static void main(String[] args) throws ProfileException, IOException, Exception {
		RuntimeProfile rp = new ProfileParser(false).parseClasspath("james_test_oru_r01.xml");
		new ProfileSourceGenerator(rp, "src/main/resources", "foo.com").generate();
	}
}
