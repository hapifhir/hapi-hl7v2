/**
The contents of this file are subject to the Mozilla Public License Version 1.1 
(the "License"); you may not use this file except in compliance with the License. 
You may obtain a copy of the License at http://www.mozilla.org/MPL/ 
Software distributed under the License is distributed on an "AS IS" basis, 
WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the 
specific language governing rights and limitations under the License. 

The Original Code is "DataTypeGenerator.java".  Description: 
"Generates skeletal source code for Datatype classes based on the 
  HL7 database" 

The Initial Developer of the Original Code is University Health Network. Copyright (C) 
2001.  All Rights Reserved. 

Contributor(s):  James Agnew 

Alternatively, the contents of this file may be used under the terms of the 
GNU General Public License (the  �GPL�), in which case the provisions of the GPL are 
applicable instead of those above.  If you wish to allow use of your version of this 
file only under the terms of the GPL and not to allow others to use your version 
of this file under the MPL, indicate your decision by deleting  the provisions above 
and replace  them with the notice and other provisions required by the GPL License.  
If you do not delete the provisions above, a recipient may use your version of 
this file under either the MPL or the GPL. 

 */

package ca.uhn.hl7v2.mvnplugin;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.project.MavenProject;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.type.filter.AssignableTypeFilter;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.Version;
import ca.uhn.hl7v2.model.GenericComposite;
import ca.uhn.hl7v2.model.Group;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.parser.DefaultModelClassFactory;
import ca.uhn.hl7v2.sourcegen.GroupDef;
import ca.uhn.hl7v2.sourcegen.GroupGenerator;
import ca.uhn.hl7v2.sourcegen.MessageGenerator;
import ca.uhn.hl7v2.sourcegen.SegmentDef;
import ca.uhn.hl7v2.sourcegen.StructureDef;
import ca.uhn.hl7v2.util.ReflectionUtil;

/**
 * Maven Plugin Mojo for generating HAPI HL7 message/segment/etc source files
 * 
 * @author <a href="mailto:jamesagnew@sourceforge.net">James Agnew</a>
 * @goal superstructuregen
 * @phase generate-sources
 * @requiresDependencyResolution runtime
 * @requiresProject
 * @inheritedByDefault false
 */
public class SuperStructureMojo extends AbstractMojo {

	/**
	 * The maven project.
	 * 
	 * @parameter property="project"
	 * @required
	 * @readonly
	 */
	private MavenProject project;

	/**
	 * Should build be skipped
	 * 
	 * @parameter
	 */
	private boolean skip;

	/**
	 * Structures to merge
	 * 
	 * @parameter
	 */
	private List<String> structures;

	/**
	 * The target directory for the generated source
	 * 
	 * @parameter
	 * @required
	 */
	private String targetDirectory;

	/**
	 * The target structure name (e.g "ADT_AXX")
	 * 
	 * @parameter
	 * @required
	 */
	private String targetStructureName;

	private String templatePackage = "ca.uhn.hl7v2.sourcegen.templates";

	/**
	 * The version for the generated source
	 * 
	 * @parameter
	 */
	private String version;

	/**
	 * {@inheritDoc}
	 */
	public void execute() throws MojoExecutionException, MojoFailureException {

		if (skip) {
			getLog().warn("Configured to skip");
		}

		try {
			List<String> allStructures = new ArrayList<String>();
			DefaultModelClassFactory mcf = new DefaultModelClassFactory();

			// We want a sorted and unique list of all structures
			Version versionOf = Version.versionOf(version);
			if (versionOf == null) {
				throw new MojoExecutionException("Unknown version: " + version);
			}

//			Map<String, String> eventMap = mcf.getEventMapForVersion(versionOf);
//			if (eventMap == null) {
//				throw new MojoExecutionException("Failed to load structures for version " + version + ". Do you have the right dependencies configured for this plugin?");
//			}
//
//			Set<String> allStructuresSet = new HashSet<String>();
//			allStructuresSet.addAll(eventMap.values());
//			allStructures.addAll(allStructuresSet);
//			Collections.sort(allStructures);

			ClassPathScanningCandidateComponentProvider scanner = new ClassPathScanningCandidateComponentProvider(true);
			DefaultResourceLoader resourceLoader = new DefaultResourceLoader(GenericComposite.class.getClassLoader());
			scanner.setResourceLoader(resourceLoader);
			scanner.addIncludeFilter(new AssignableTypeFilter(Message.class));
			Set<BeanDefinition> components = scanner.findCandidateComponents("ca/uhn/hl7v2/model/" + versionOf.getPackageVersion() + "/message");
			for (BeanDefinition beanDefinition : components) {
				String nextName = Class.forName(beanDefinition.getBeanClassName()).getSimpleName();
				if (nextName.equals(targetStructureName)) {
					continue;
				}
				allStructures.add(nextName);
			}
			
			getLog().info("Found " + allStructures.size() + " message classes for version: " + version);
			
			List<Message> messagesToMerge = new ArrayList<Message>();

			Collections.sort(allStructures);
			for (String nextStructure : allStructures) {
				for (String nextStructureToMerge : structures) {
					if (nextStructure.matches(nextStructureToMerge)) {
						Class<? extends Message> clazz = mcf.getMessageClass(nextStructure, version, true);
						messagesToMerge.add(ReflectionUtil.instantiateMessage(clazz, mcf));
					}
				}
			}

			if (messagesToMerge.isEmpty()) {
				throw new MojoFailureException("No messages match pattern(s): " + structures);
			}
			
			ListOfStructureDefsAndMapOfStructreNames mergedMessages = mergeGroups(messagesToMerge, messagesToMerge);
			List<StructureDef> structures = mergedMessages.myStructureDefs;
			if (structures.isEmpty()) {
				throw new MojoExecutionException("No structures found matching structures to merge");
			}

			getLog().info("Creating directory: " + targetDirectory);
			new File(targetDirectory).mkdirs();

			boolean haveGroups = false;
			for (StructureDef structureDef : structures) {
				if (structureDef.isGroup()) {
					haveGroups = true;
					writeGroup((GroupDef) structureDef);
				}
			}

			String fileName = MessageGenerator.determineTargetDir(targetDirectory + "/", version) + "/" + targetStructureName + ".java";
			getLog().info("Filename will be: " + fileName);

			StructureDef[] contents = structures.toArray(new StructureDef[structures.size()]);
			String basePackageName = DefaultModelClassFactory.getVersionPackageName(version);
			MessageGenerator.writeMessage(fileName, contents, targetStructureName, "", version, basePackageName, haveGroups, templatePackage, mergedMessages.myStructureNameToChildNames);

		} catch (Exception e) {
			throw new MojoFailureException("Failed to generate structure", e);
		}
		getLog().info("Adding " + targetDirectory + " to compile source root");
		project.addCompileSourceRoot(targetDirectory);

	}

	private void writeGroup(GroupDef theStructureDef) throws Exception {

		StructureDef[] structures = theStructureDef.getStructures();
		String groupName = theStructureDef.getUnqualifiedName();
		GroupGenerator.writeGroup(structures, groupName, targetDirectory, version, targetStructureName, templatePackage, "java");

		for (StructureDef structureDef : structures) {
			if (structureDef instanceof GroupDef) {
				writeGroup((GroupDef) structureDef);
			}
		}

	}

	private class ListOfStructureDefsAndMapOfStructreNames {
		private List<StructureDef> myStructureDefs;
		private Map<String, List<String>> myStructureNameToChildNames;
	}

	private ListOfStructureDefsAndMapOfStructreNames mergeGroups(List<? extends Group> theGroupsToMerge, List<Message> theAssociatedStructures) throws HL7Exception {
		ArrayList<StructureDef> retValStructureDefs = new ArrayList<StructureDef>();

		List<List<String>> allNameLists = new ArrayList<List<String>>();
		for (Group nextGroup : theGroupsToMerge) {
			List<String> nextList = Arrays.asList(nextGroup.getNames());
			// for (int i = 0; i < nextList.size(); i++) {
			// if (nextGroup.isGroup(nextList.get(i)) == false) {
			// nextList.set(i, nextList.get(i).substring(0, 3));
			// }
			// }
			allNameLists.add(nextList);
		}

		ArrayList<String> structureNames = mergeStringLists(allNameLists);
		int currentStructureIdx = 0;
		for (String nextStructureName : structureNames) {

			/*
			 * Don't have the same name a second time. This mainly prevents a
			 * second OBX in ADT messages, so it should be ok since there is an
			 * appropriate OBX in a PROCEDURE group right before the second
			 * one..?
			 */
			if (structureNames.subList(0, currentStructureIdx++).contains(nextStructureName)) {
				continue;
			}

			boolean required = true;
			boolean repeating = false;
			boolean group = false;
			boolean choice = false;
			List<Group> childGroups = new ArrayList<Group>();
			List<Message> associatedChildStructures = new ArrayList<Message>();

			int idx = 0;
			for (Group nextGroup : theGroupsToMerge) {
				if (Arrays.asList(nextGroup.getNames()).contains(nextStructureName)) {

					if (theAssociatedStructures != null) {
						associatedChildStructures.add(theAssociatedStructures.get(idx));
					}

					repeating |= nextGroup.isRepeating(nextStructureName);
					choice |= nextGroup.isChoiceElement(nextStructureName);
					required &= nextGroup.isRequired(nextStructureName);
					if (nextGroup.isGroup(nextStructureName)) {
						group = true;
						childGroups.add((Group) nextGroup.get(nextStructureName));
					}
				} else {
					required = false;
				}

				idx++;
			}

			if (group == false) {
				SegmentDef seg = new SegmentDef(nextStructureName.substring(0, 3), "", required, repeating, choice, "");
				retValStructureDefs.add(seg);

				/*
				 * Use the event map to turn each asociated message (e.g.
				 * ADT_A01.class) into associated structure names (e.g.
				 * "ADT_A01", "ADT_A04")
				 */
				for (Message next : associatedChildStructures) {
					seg.addAssociatedStructure(next.getName());
					Map<String, String> evtMap = new TreeMap<String, String>(new DefaultModelClassFactory().getEventMapForVersion(Version.versionOf(version)));
					for (Map.Entry<String, String> nextEntry : evtMap.entrySet()) {
						String value = nextEntry.getValue();
						String name = next.getName();
						if (value.equals(name)) {
							seg.addAssociatedStructure(nextEntry.getValue());
							seg.addAssociatedStructure(nextEntry.getKey());
						}
					}
				}

				seg.setIndexName(nextStructureName);

				continue;
			}

			if (group) {
				GroupDef grp = new GroupDef(targetStructureName, nextStructureName, required, repeating, "");
				grp.setIndexName(nextStructureName);
				List<StructureDef> children = mergeGroups(childGroups, null).myStructureDefs;

				/*
				 * Use the event map to turn each asociated message (e.g.
				 * ADT_A01.class) into associated structure names (e.g.
				 * "ADT_A01", "ADT_A04")
				 */
				for (Message next : associatedChildStructures) {
					Map<String, String> evtMap = new DefaultModelClassFactory().getEventMapForVersion(Version.versionOf(version));
					for (Map.Entry<String, String> nextEntry : evtMap.entrySet()) {
						if (nextEntry.getValue().equals(next.getName())) {
							grp.addAssociatedStructure(nextEntry.getKey());
						}
					}
				}

				for (StructureDef structureDef : children) {
					grp.addStructure(structureDef);
				}
				retValStructureDefs.add(grp);
			}

		}

		ListOfStructureDefsAndMapOfStructreNames retVal = new ListOfStructureDefsAndMapOfStructreNames();
		retVal.myStructureDefs = retValStructureDefs;

		if (theAssociatedStructures != null) {
			HashMap<String, List<String>> retValMap = new HashMap<String, List<String>>();
			for (Message next : theAssociatedStructures) {
				retValMap.put(next.getName(), Arrays.asList(next.getNames()));
			}
			retVal.myStructureNameToChildNames = retValMap;
		}

		return retVal;
	}

	ArrayList<String> mergeStringLists(List<List<String>> allNameLists) {
		ArrayList<String> baseList = new ArrayList<String>(allNameLists.remove(0));
		getLog().debug("Base list is: "+ baseList);

		for (List<String> nextCompareList : allNameLists) {

			getLog().debug("Next compare list: "+ nextCompareList);

			int baseIndex = 0;
			int compareIndex = 0;

			while (compareIndex < nextCompareList.size()) {

				String currentBase = baseList.get(baseIndex);
				String currentCompare = nextCompareList.get(compareIndex);
				if (currentBase.equals(currentCompare)) {
					if (baseIndex + 1 < baseList.size()) {
						baseIndex++;
					}
					compareIndex++;
					continue;
				}

				List<String> subList = baseList.subList(baseIndex, baseList.size());

				// Find next match
				List<String> toAdd = null;
				for (int searchCompareIndex = compareIndex + 1; searchCompareIndex < nextCompareList.size(); searchCompareIndex++) {
					String find = nextCompareList.get(searchCompareIndex);
					int foundAt = subList.indexOf(find);
					if (foundAt != -1) {
						foundAt += (baseIndex);
						toAdd = nextCompareList.subList(compareIndex, searchCompareIndex);
						break;
					}
				}

				int addAtIndex = baseIndex;

				if (toAdd == null) {

					toAdd = nextCompareList.subList(compareIndex, nextCompareList.size());
					addAtIndex = baseList.size();

					int foundInBaseAtIndex = subList.indexOf(currentCompare);
					if (foundInBaseAtIndex != -1) {
						baseIndex += foundInBaseAtIndex;
						compareIndex++;
						continue;
					}

				} else {

					int foundInBaseAtIndex = subList.indexOf(currentCompare);
					if (foundInBaseAtIndex != -1) {
						baseIndex += foundInBaseAtIndex;
						// compareIndex++;
						continue;
					}

				}

				baseList.addAll(addAtIndex, toAdd);
				baseIndex += toAdd.size();
				compareIndex += toAdd.size();

				// if (toAdd.size() == 0) {
				// break;
				// }
			}
			getLog().debug("Base list is now: "+ baseList);

		}

		getLog().debug("Merged name list: "+ baseList);
		return baseList;
	}

	public static void main(String[] args) throws MojoExecutionException, MojoFailureException {
		
		SuperStructureMojo m = new SuperStructureMojo();
		m.structures = new ArrayList<String>();
		m.structures.add("ADT_A[0-9]{2}");

		m.targetDirectory = "target/merge";
		m.targetStructureName = "ADT_AXX";
		m.version = "2.3.1";
		m.execute();
	}

}
