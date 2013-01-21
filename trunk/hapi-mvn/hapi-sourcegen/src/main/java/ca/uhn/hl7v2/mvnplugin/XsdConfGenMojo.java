package ca.uhn.hl7v2.mvnplugin;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.commons.lang.StringUtils;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.project.MavenProject;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.tools.generic.EscapeTool;
import org.codehaus.plexus.util.IOUtil;

import ca.uhn.hl7v2.VersionLogger;
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
import ca.uhn.hl7v2.sourcegen.util.VelocityFactory;
import ca.uhn.hl7v2.util.XMLUtils;

/**
 * @author <a href="mailto:jamesagnew@sourceforge.net">James Agnew</a>
 * @goal xsdconfgen
 * @phase generate-sources
 * @requiresDependencyResolution runtime
 * @requiresProject
 * @inheritedByDefault false
 */
public class XsdConfGenMojo extends AbstractMojo {

	private static final org.slf4j.Logger ourLog = org.slf4j.LoggerFactory.getLogger(XsdConfGenMojo.class);

	/**
	 * The conformance profiles (XML file paths) to use
	 * 
	 * @parameter
	 * @required
	 */
	private List<String> profiles;

	/**
	 * The maven project.
	 * 
	 * @parameter expression="${project}"
	 * @required
	 * @readonly
	 */
	private MavenProject project;

	/**
	 * The target directory for the generated source
	 * 
	 * @parameter
	 * @required
	 */
	private String targetDirectory;

	/**
	 * The Message Workbench tool generally creates segment groups as two
	 * level structures, with an outer group which has only a single
	 * child which is the actual group. If this is set to true (which is
	 * the default), these "bogus" groups are filtered. 
	 * 
	 * @parameter
	 * @required
	 */
	private boolean filterBogusGroups = true;

	/**
	 * The file name for the generated file (file will be placed in the
	 * targetDirectory)
	 * 
	 * @parameter
	 * @required
	 */
	private String targetFile;

	/**
	 * The file name for the generated file (file will be placed in the
	 * targetDirectory)
	 * 
	 * @parameter
	 * @required
	 */
	private boolean constrain;

	private Map<String, String> linkTriggerToStructure;

	/**
	 * The package from which to load the templates
	 * 
	 * @parameter default="ca.uhn.hl7v2.sourcegen.templates.xsd"
	 */
	private String templatePackage = "ca.uhn.hl7v2.sourcegen.templates.xsd";

	private static final Set<String> ourConstrainedUsageTypes = new HashSet<String>(new ArrayList<String>(Arrays.asList(new String[] {"R", "RE", "O", "C" })));

	/**
	 * {@inheritDoc}
	 */
	public void execute() throws MojoExecutionException, MojoFailureException {

		try {

			List<RuntimeProfile> parsedProfiles = new ArrayList<RuntimeProfile>();
			for (String nextProfile : profiles) {

				ourLog.info("Reading profile: {}", nextProfile);
				FileReader reader = new FileReader(nextProfile);
				String profileString = IOUtil.toString(reader);

				ProfileParser profileParser = new ProfileParser(false);
				RuntimeProfile runtimeProfile = profileParser.parse(profileString);

				if (constrain) {
					for (int i = 0; i < runtimeProfile.getMessage().getChildrenAsList().size(); i++) {
						ProfileStructure next = runtimeProfile.getMessage().getChildrenAsList().get(i);
						if (!ourConstrainedUsageTypes.contains(next.getUsage())) {
							runtimeProfile.getMessage().getChildrenAsList().remove(i);
							i--;
						} else {
							if (next instanceof Seg) {
								constrainSeg((Seg) next);
							} else {
								constrainSegGroup((SegGroup) next);
							}
						}
					}
				}

				if (filterBogusGroups) {
					StaticDef staticDef = runtimeProfile.getMessage();
					filterBogusGroups(staticDef);
				}
				
				parsedProfiles.add(runtimeProfile);
			}

			if (linkTriggerToStructure == null) {
				linkTriggerToStructure = new HashMap<String, String>();
			}

			linkTriggerToStructure = new TreeMap<String, String>(linkTriggerToStructure);

			VelocityContext ctx = new VelocityContext();
			ctx.put("runtimeProfiles", parsedProfiles);
			ctx.put("hapiVersion", StringUtils.defaultString(VersionLogger.getVersion(), "X.X"));
			ctx.put("segmentDefs", new HashSet<String>());
			ctx.put("fieldDefs", new HashSet<String>());
			ctx.put("esc", new EscapeTool());
			ctx.put("compositeFieldDefs", new HashSet<String>());
			ctx.put("triggerMappings", linkTriggerToStructure);

			Template template = VelocityFactory.getClasspathTemplateInstance(templatePackage.replace('.', '/') + "/message_xml_its.vm");

			File targetFileDef = new File(targetDirectory, targetFile);
			ourLog.info("Generating: {}", targetFileDef.getAbsolutePath());

			StringWriter sw = new StringWriter();
			template.merge(ctx, sw);
			sw.close();

			FileWriter w3 = new FileWriter(targetFileDef, false);
			w3.write(sw.toString());
			w3.close();

			ourLog.info("DOcument: " + sw.toString());
			String xml = XMLUtils.serialize(XMLUtils.parse(sw.toString()));

			FileWriter w = new FileWriter(targetFileDef, false);
			w.write(xml);
			w.close();

		} catch (Exception e) {
			throw new MojoExecutionException(e.getMessage(), e);
		}

		if (project != null) {
			project.addCompileSourceRoot(targetDirectory);
		}

	}

	private void filterBogusGroups(AbstractSegmentContainer theParent) {
		List<ProfileStructure> children = theParent.getChildrenAsList();
		
		for (int childIndex = 0; childIndex < children.size(); childIndex++) {
			ProfileStructure nextChild = children.get(childIndex);
			if (nextChild instanceof SegGroup) {
				SegGroup nextChildSg = (SegGroup) nextChild;
				if (nextChildSg.getChildren() == 1 && nextChildSg.getChild(1) instanceof SegGroup) {
					SegGroup newNextChildSg = (SegGroup) nextChildSg.getChild(1);
					ourLog.info("Replacing bogus group {} with {}", newNextChildSg.toString(), nextChildSg.toString());
					nextChildSg = newNextChildSg;
					children.set(childIndex, nextChildSg);
				}
				
				filterBogusGroups(nextChildSg);
			}
		}
		
	}
	

	private void constrainSegGroup(SegGroup theNext) throws ProfileException {
		for (int i = 0; i < theNext.getChildrenAsList().size(); i++) {
			ProfileStructure next = theNext.getChildrenAsList().get(i);
			if (!ourConstrainedUsageTypes.contains(next.getUsage())) {
				theNext.getChildrenAsList().remove(i);
				i--;
			} else {
				if (next instanceof Seg) {
					constrainSeg((Seg) next);
				} else {
					constrainSegGroup((SegGroup) next);
				}
			}
		}
	}

	private void constrainSeg(Seg theNext) throws ProfileException {
		for (int i = 0; i < theNext.getFieldsAsList().size(); i++) {
			Field next = theNext.getFieldsAsList().get(i);
			if (!ourConstrainedUsageTypes.contains(next.getUsage())) {
				Field unsupField = new Field();
				unsupField.setDatatype("ST");
				unsupField.setDescription("Unsupported");
				unsupField.setMax((short) 0);
				unsupField.setMin((short) 0);
				unsupField.setName("Unsupported");
				unsupField.setUsage("X");
				theNext.getFieldsAsList().set(i, unsupField);
			} else {
				for (int j = 0; j < next.getChildrenAsList().size(); j++) {
					Component nextComponent = next.getChildrenAsList().get(j);
					if (!ourConstrainedUsageTypes.contains(nextComponent.getUsage())) {
						nextComponent.setName("Unsupported");
						nextComponent.setDescription("Unsupported");
						for (SubComponent nextSub : nextComponent.getChildrenAsList()) {
							nextSub.setName("Unsupported");
							nextSub.setDescription("Unsupported");
						}
					} else {
						for (SubComponent nextSub : nextComponent.getChildrenAsList()) {
							if (!ourConstrainedUsageTypes.contains(nextSub.getUsage())) {
								nextSub.setName("Unsupported");
								nextSub.setDescription("Unsupported");
							}
						}
					}
				}
			}
		}
	}

	public static void main(String[] args) throws MojoExecutionException, MojoFailureException {

		XsdConfGenMojo tst;
		// tst = new XsdConfGenMojo();
		// tst.targetDirectory = "hapi-test/target/generated-sources/confgen";
		// tst.targetFile = "ADT_All_Other_Triggers.xsd";
		// tst.profile =
		// "hapi-test/src/test/resources/ca/uhn/hl7v2/conf/parser/cgta-adt_a01.xml";
		// tst.templatePackage = "ca.uhn.hl7v2.sourcegen.templates.xsd";
		// tst.execute();
		//
		// tst = new XsdConfGenMojo();
		// tst.targetDirectory = "hapi-test/target/generated-sources/confgen";
		// tst.targetFile = "ADT_A17_a37.xsd";
		// tst.profile =
		// "hapi-test/src/test/resources/ca/uhn/hl7v2/conf/parser/cgta-adt_a17_a37.xml";
		// tst.templatePackage = "ca.uhn.hl7v2.sourcegen.templates.xsd";
		// tst.execute();

		tst = new XsdConfGenMojo();
		tst.targetDirectory = "hapi-test/target/generated-sources/confgen";
		tst.targetFile = "CGTA_INPUT_HL7V2.xsd";
		tst.profiles = new ArrayList<String>();
		tst.linkTriggerToStructure = new HashMap<String, String>();

		tst.profiles.add("/eclipse/workspace/CGTA_Input_Tester_gc/ConverterLibrary/src/main/resources/ca/cgta/input/conf/cgta-adt_a01.xml");
		tst.linkTriggerToStructure.put("ADT_A02", "ADT_A01");
		tst.linkTriggerToStructure.put("ADT_A03", "ADT_A01");
		tst.linkTriggerToStructure.put("ADT_A04", "ADT_A01");
		tst.linkTriggerToStructure.put("ADT_A05", "ADT_A01");
		tst.linkTriggerToStructure.put("ADT_A06", "ADT_A01");
		tst.linkTriggerToStructure.put("ADT_A07", "ADT_A01");
		tst.linkTriggerToStructure.put("ADT_A08", "ADT_A01");
		tst.linkTriggerToStructure.put("ADT_A10", "ADT_A01");
		tst.linkTriggerToStructure.put("ADT_A11", "ADT_A01");
		tst.linkTriggerToStructure.put("ADT_A13", "ADT_A01");
		tst.linkTriggerToStructure.put("ADT_A28", "ADT_A01");
		tst.linkTriggerToStructure.put("ADT_A31", "ADT_A01");
		tst.linkTriggerToStructure.put("ADT_A37", "ADT_A01");
		tst.linkTriggerToStructure.put("ADT_A40", "ADT_A01");
		tst.linkTriggerToStructure.put("ADT_A42", "ADT_A01");
		tst.linkTriggerToStructure.put("ADT_A45", "ADT_A01");
		tst.linkTriggerToStructure.put("ADT_A60", "ADT_A01");

		tst.profiles.add("/eclipse/workspace//CGTA_Input_Tester_gc/ConverterLibrary/src/main/resources/ca/cgta/input/conf/cgta-adt_a17_a37.xml");
		tst.linkTriggerToStructure.put("ADT_A37", "ADT_A17");

		tst.profiles.add("/eclipse/workspace//CGTA_Input_Tester_gc/ConverterLibrary/src/main/resources/ca/cgta/input/conf/cgta-oru_r01.xml");

		tst.profiles.add("/eclipse/workspace//CGTA_Input_Tester_gc/ConverterLibrary/src/main/resources/ca/cgta/input/conf/cgta-rde_o11.xml");

		tst.profiles.add("/eclipse/workspace//CGTA_Input_Tester_gc/ConverterLibrary/src/main/resources/ca/cgta/input/conf/cgta-ras_o17.xml");

		tst.templatePackage = "ca.uhn.hl7v2.sourcegen.templates.xsd";
		
		tst.constrain = true;
		tst.execute();

	}

}
