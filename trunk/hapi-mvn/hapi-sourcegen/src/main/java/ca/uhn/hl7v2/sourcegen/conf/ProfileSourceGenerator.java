/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ca.uhn.hl7v2.sourcegen.conf;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import ca.uhn.hl7v2.conf.ProfileException;
import ca.uhn.hl7v2.conf.parser.ProfileParser;
import ca.uhn.hl7v2.conf.spec.RuntimeProfile;
import ca.uhn.hl7v2.conf.spec.message.AbstractSegmentContainer;
import ca.uhn.hl7v2.conf.spec.message.Component;
import ca.uhn.hl7v2.conf.spec.message.Field;
import ca.uhn.hl7v2.conf.spec.message.ProfileStructure;
import ca.uhn.hl7v2.conf.spec.message.Seg;
import ca.uhn.hl7v2.conf.spec.message.SegGroup;
import ca.uhn.hl7v2.conf.spec.message.StaticDef;
import ca.uhn.hl7v2.conf.spec.message.SubComponent;
import ca.uhn.hl7v2.parser.DefaultModelClassFactory;
import ca.uhn.hl7v2.sourcegen.DataTypeGenerator;
import ca.uhn.hl7v2.sourcegen.DatatypeComponentDef;
import ca.uhn.hl7v2.sourcegen.DatatypeDef;
import ca.uhn.hl7v2.sourcegen.GroupDef;
import ca.uhn.hl7v2.sourcegen.GroupGenerator;
import ca.uhn.hl7v2.sourcegen.MessageGenerator;
import ca.uhn.hl7v2.sourcegen.SegmentDef;
import ca.uhn.hl7v2.sourcegen.SegmentElement;
import ca.uhn.hl7v2.sourcegen.SegmentGenerator;
import ca.uhn.hl7v2.sourcegen.SourceGenerator;

/**
 * Generates HAPI custom model classes using HL7 conformance profiles
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
    private GenerateDataTypesEnum myGenerateDataTypes;

    public ProfileSourceGenerator(RuntimeProfile theProfile, String theTargetDirectory, String theBasePackage, GenerateDataTypesEnum theGenDt) {
        myProfile = theProfile;
        myGenerateDataTypes = theGenDt;

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

        String chapter = "";
        String version = myProfile.getHL7Version();
        GroupDef group = convertToGroupDef(staticDef, version);

        String basePackageName = DefaultModelClassFactory.getVersionPackageName(version);
        String[] datatypePackages;

        switch (myGenerateDataTypes) {
        default:
        case NONE:
            datatypePackages = new String[] { basePackageName + "datatype" };
            break;
        case SINGLE:
            datatypePackages = new String[] { myBasePackage + "datatype" };
            SourceGenerator.makeDirectory(myTargetDirectory + "/datatype");
        }

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
            GroupGenerator.writeGroup(next.getName(), fileName, next, version, myBasePackage);
        }

        // Write Segments
        Set<String> alreadyWrittenDatatypes = new HashSet<String>();
        for (SegmentDef next : mySegmentDefs) {

            String fileName = myTargetDirectory + "segment/" + next.getName() + ".java";
            ourLog.info("Writing Segment file: " + fileName);
            String segmentName = next.getName();
            String description = next.getDescription();
            ArrayList<SegmentElement> elements = mySegmentNameToSegmentElements.get(segmentName);

            for (SegmentElement nextElement : elements) {
                if ("*".equals(nextElement.type) || "VARIES".equals(nextElement.type)) {
                    nextElement.type = "Varies";
                }
            }

            SegmentGenerator.writeSegment(fileName, version, segmentName, elements, description, myBasePackage, datatypePackages);

            switch (myGenerateDataTypes) {
            case SINGLE:
                for (DatatypeDef nextFieldDef : next.getFieldDefs()) {
                    writeDatatype(nextFieldDef, alreadyWrittenDatatypes, version);
                }
            }

        }

    }

    private void writeDatatype(DatatypeDef theFieldDef, Set<String> theAlreadyWrittenDatatypes, String version) throws Exception {
        if (theAlreadyWrittenDatatypes != null) {
            if (theAlreadyWrittenDatatypes.contains(theFieldDef.getType())) {
                return;
            } else {
                theAlreadyWrittenDatatypes.add(theFieldDef.getType());
            }
        }

        String fileName = myTargetDirectory + "datatype/" + theFieldDef.getType() + ".java";
        DataTypeGenerator.writeDatatype(fileName, version, theFieldDef, myBasePackage);
        
        for (DatatypeDef next : theFieldDef.getSubComponentDefs()) {
            writeDatatype(next, theAlreadyWrittenDatatypes, version);
        }
    }

    private GroupDef convertToGroupDef(StaticDef staticDef, String theVersion) {

        boolean required = true;
        boolean repeating = true;
        String description = staticDef.getDescription();
        GroupDef retVal = new GroupDef(myMessageName, null, required, repeating, description);

        populateChildren(retVal, staticDef, theVersion);

        return retVal;
    }

    private GroupDef convertToGroupDef(GroupDef theParent, SegGroup segGroup, String theVersion) {

        /*
         * MWB exports optional repeating groups as an optional group with a
         * single child which is a required repeating group If we encounter
         * this, we flatten this to be an optional repeating group
         */
        boolean required = true;
        if (segGroup.getChildren() == 1 && segGroup.getChild(1) instanceof SegGroup) {
            required = segGroup.getMin() > 0;
            segGroup = (SegGroup) segGroup.getChild(1);
        }

        String name = segGroup.getName();
        required = required && (segGroup.getMin() > 0);
        boolean repeating = segGroup.getMax() != 1;
        String description = segGroup.getLongName();

        GroupDef retVal = new GroupDef(myMessageName, name, required, repeating, description);

        populateChildren(retVal, segGroup, theVersion);

        if (!myGroupDefNames.contains(name)) {
            myGroupDefNames.add(name);
            myGroupDefs.add(retVal);
        }

        return retVal;
    }

    private void populateChildren(GroupDef retVal, AbstractSegmentContainer segGroup, String theVersion) {

        for (int i = 0; i < segGroup.getChildren(); i++) {
            ProfileStructure nextProfileStructure = segGroup.getChild(i + 1);

            if (nextProfileStructure instanceof SegGroup) {

                SegGroup nextSegGroup = (SegGroup) nextProfileStructure;
                GroupDef nextGroupDef = convertToGroupDef(retVal, nextSegGroup, theVersion);
                retVal.addStructure(nextGroupDef);

            } else if (nextProfileStructure instanceof Seg) {

                Seg nextSeg = (Seg) nextProfileStructure;
                SegmentDef nextSegmentDef = convertToSegmentDef(retVal, nextSeg, theVersion);
                retVal.addStructure(nextSegmentDef);

            } else {

                throw new IllegalStateException("Unknown profile structure: " + nextProfileStructure);

            } // if-else

        } // for

    }

    private SegmentDef convertToSegmentDef(GroupDef theParent, Seg nextSeg, String theVersion) {
        String name = nextSeg.getName();
        String groupName = null;
        boolean required = nextSeg.getMin() > 0;
        boolean repeating = nextSeg.getMax() > 1 || nextSeg.getMax() == -1;
        String description = nextSeg.getLongName();

        SegmentDef retVal = new SegmentDef(name, groupName, required, repeating, description);
        ArrayList<SegmentElement> segmentElements = new ArrayList<SegmentElement>();

        // Extract fields from the segment definition
        for (int i = 0; i < nextSeg.getFields(); i++) {
            Field nextField = nextSeg.getField(i + 1);

            DatatypeDef nextFieldDef = convertToDatatypeDef(nextField);
            retVal.addFieldDef(nextFieldDef);

            SegmentElement nextSegmentElement = new SegmentElement(name, theVersion, i);

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

    private DatatypeDef convertToDatatypeDef(Field theField) {
        String type = theField.getDatatype();
        String name = theField.getName();

        DatatypeDef retVal = new DatatypeDef(type, name);

        for (int i = 0; i < theField.getComponents(); i++) {
            Component nextComponent = theField.getComponent(i + 1);
            DatatypeComponentDef nextDef = convertToDatatypeComponentDef(nextComponent, type, i);
            retVal.addSubcomponentDef(nextDef);
        }

        return retVal;
    }

    private DatatypeComponentDef convertToDatatypeComponentDef(Component theComponent, String parentType, int indexWithinParent) {

        String type = theComponent.getDatatype();
        String name = theComponent.getName();

        int table = 0;
        if (StringUtils.isNotBlank(theComponent.getTable())) {
            try {
                table = Integer.parseInt(theComponent.getTable());
            } catch (NumberFormatException e) {
                // TODO: handle this somehow?
            }
        }

        DatatypeComponentDef retVal = new DatatypeComponentDef(parentType, indexWithinParent, type, name, table);

        for (int i = 0; i < theComponent.getSubComponents(); i++) {
            SubComponent next = theComponent.getSubComponent(i + 1);
            DatatypeComponentDef def = convertToDatatypeComponentDef(next, type, i);
            retVal.addSubcomponentDef(def);
        }

        return retVal;
    }

    private DatatypeComponentDef convertToDatatypeComponentDef(SubComponent theComponent, String parentType, int indexWithinParent) {

        String type = theComponent.getDatatype();
        String desc = theComponent.getName();

        int table = 0;
        if (StringUtils.isNotBlank(theComponent.getTable())) {
            try {
                table = Integer.parseInt(theComponent.getTable());
            } catch (NumberFormatException e) {
                // TODO: handle this somehow?
            }
        }

        DatatypeComponentDef retVal = new DatatypeComponentDef(parentType, indexWithinParent, type, desc, table);
        return retVal;
    }

    public static void main(String[] args) throws ProfileException, IOException, Exception {
        RuntimeProfile rp = new ProfileParser(false).parseClasspath("ca/uhn/hl7v2/conf/parser/ADT_A01.xml");
        new ProfileSourceGenerator(rp, "hapi-test/target/generated-sources/confgen", "hapi.on.olis", GenerateDataTypesEnum.SINGLE).generate();
    }
}
