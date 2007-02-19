/**
The contents of this file are subject to the Mozilla Public License Version 1.1 
(the "License"); you may not use this file except in compliance with the License. 
You may obtain a copy of the License at http://www.mozilla.org/MPL/ 
Software distributed under the License is distributed on an "AS IS" basis, 
WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the 
specific language governing rights and limitations under the License. 

The Original Code is "ConformanceSegGroupBuilder.java".  Description: 
"This Class builds Conformance SegGroup Classes" 

The Initial Developer of the Original Code is University Health Network. Copyright (C) 
2001.  All Rights Reserved. 

Contributor(s): James Agnew
                Paul Brohman
                Mitch Delachevrotiere
                Shawn Dyck
  				Cory Metcalf
  				
Alternatively, the contents of this file may be used under the terms of the 
GNU General Public License (the  ?GPL?), in which case the provisions of the GPL are 
applicable instead of those above.  If you wish to allow use of your version of this 
file only under the terms of the GPL and not to allow others to use your version 
of this file under the MPL, indicate your decision by deleting  the provisions above 
and replace  them with the notice and other provisions required by the GPL License.  
If you do not delete the provisions above, a recipient may use your version of 
this file under either the MPL or the GPL. 

*/
package ca.uhn.hl7v2.conf.classes.generator.builders;

import ca.uhn.hl7v2.conf.classes.generator.genclasses.*;
import ca.uhn.hl7v2.conf.spec.message.*;

/** This Class builds Conformance SegGroup Classes
 * @author <table><tr>James Agnew</tr>
 *                <tr>Paul Brohman</tr>
 *                <tr>Mitch Delachevrotiere</tr>
 *                <tr>Shawn Dyck</tr>
 * 				  <tr>Cory Metcalf</tr></table>
 */
public class ConformanceSegGroupBuilder {

   private DeploymentManager depManager; // The deployment manager
   private DocumentationBuilder docBuilder; // The documentation builder

   private String packageName; // Represents the Package that this Segment will go in
   private String structID; // The struct ID of the message type
   private String version; // The HAPI version

   /** This constructor will create a new ConformanceSegmentBuilder
    * @param packageName the name of the package
    * @param versionString the version of HL7 which these classes are conforming to
    * @param depManager the instance of DeploymentManager
    */
   public ConformanceSegGroupBuilder(String packageName, String version, DeploymentManager depManager, String structID) {
      super();
      this.packageName = packageName;
      this.version = version;
      this.docBuilder = DocumentationBuilder.getDocumentationBuilder();
      this.depManager = depManager;
      this.structID = structID;
   }

   /** This method will build all the field children for this Segment
    * @param segGroup the SegGroup to build
    * @param parentUnderlyingType the data type of the parent Message for this field
    *        example "ca.uhn.hl7v2.model.v24.group.ADR_A19_..."  
    * @param profileName this is the profile name associated with this Class
    */
   public void buildClass(SegGroup segGroup, String parentUnderlyingType, ProfileName profileName) {
      GeneratedConformanceContainer gcc = new GeneratedConformanceContainer();
      ConformanceSegmentBuilder confSegBuilder = new ConformanceSegmentBuilder(packageName + "." + profileName.getPackageName(), version, depManager);
      ConformanceSegGroupBuilder confSegGroupBuilder = new ConformanceSegGroupBuilder(packageName + "." + profileName.getPackageName(), version, depManager, structID);

      String underlyingDataType = structID + "_" + generateSegGroupName(segGroup);
      String underlyingPackageType = "ca.uhn.hl7v2.model." + version + ".group." + underlyingDataType;

      // Set up class
      gcc.setClassPackage(packageName);
      gcc.addClassImport("ca.uhn.hl7v2.conf.classes.abs.*");
      gcc.addClassImport("ca.uhn.hl7v2.conf.classes.exceptions.*");
      gcc.addClassImport("ca.uhn.hl7v2.*");
      gcc.addClassImport(packageName + "." + profileName.getPackageName() + ".*");

      gcc.setName(profileName.getClassName());
      gcc.setProperties("extends AbstractConformanceContainer implements Repeatable");
      gcc.setMinMaxReps(segGroup.getMin(), segGroup.getMax());
      gcc.addMemberVariable("private " + underlyingPackageType + " hapiSegGroup;");

      // Set up underlying Segment type
      GeneratedMethod theConstructor = gcc.getConstructor();
	  docBuilder.decorateConstructor( theConstructor, profileName.getClassName() );
      theConstructor.addParam(parentUnderlyingType + " underlyingMessage", "The underlying message object");
      theConstructor.addParam("int rep", "The underlying rep number");
      theConstructor.addToThrows("HL7Exception");

      UnderlyingAccessor underlyingAccessor = new UnderlyingAccessor(parentUnderlyingType, "get" + underlyingDataType);
      theConstructor.addToBody("this.hapiSegGroup = underlyingMessage." + underlyingAccessor.toString() + ";");

      for (int i = 1; i <= segGroup.getChildren(); i++) {
		 //don't build not supported, backward, or unknown types
		 String usage = segGroup.getChild(i).getUsage();
		 if( usage != null && (usage.equals("X") || usage.equals("B") || usage.equals("U")) )
			continue;
			
         if (segGroup.getChild(i) instanceof Seg) {
            ProfileName childProfileName = profileName.newInstance(segGroup.getChild(i).getName(), ProfileName.PS_SEG);

            // Add the member variable vector to hold them
            gcc.addMemberVariable("private FiniteList " + childProfileName.getMemberName() + ";");
            theConstructor.addToBody(childProfileName.getMemberName() + " = new FiniteList( " + childProfileName.getClassName() + ".class, hapiSegGroup );");
				UnderlyingAccessor childAccessor = new UnderlyingAccessor(underlyingPackageType, childProfileName.getAccessorName());
            GeneratedRepGetter repGetter = new GeneratedRepGetter(childProfileName, childAccessor.getAcceptsRep());

            docBuilder.decorateRepGetter(repGetter, (Seg) segGroup.getChild(i), childProfileName.getOriginalName());
            gcc.addMethod(repGetter);
            if (depManager.getVerbose())
               System.out.println("Generating Segment: " + packageName + "." + gcc.getName());

            confSegBuilder.buildClass((Seg) segGroup.getChild(i), underlyingPackageType, childProfileName.clearNameMap());

         } else
            if (segGroup.getChild(i) instanceof SegGroup) {
               ProfileName childProfileName = profileName.newInstance(segGroup.getChild(i).getName(), ProfileName.PS_SEGG);

               // Add the member variable vector to hold them
               gcc.addMemberVariable("private FiniteList " + childProfileName.getMemberName() + ";");
               theConstructor.addToBody(childProfileName.getMemberName() + " = new FiniteList( " + childProfileName.getClassName() + ".class, hapiSegGroup );");

					String underlyingAccessorName = "get" + structID + "_" + ConformanceSegGroupBuilder.generateSegGroupName((SegGroup)segGroup.getChild(i));
					UnderlyingAccessor childAccessor = new UnderlyingAccessor(underlyingPackageType, underlyingAccessorName);
               GeneratedRepGetter repGetter = new GeneratedRepGetter(childProfileName, childAccessor.getAcceptsRep());

               docBuilder.decorateRepGetter(repGetter, (SegGroup) segGroup.getChild(i), childProfileName.getOriginalName());
               gcc.addMethod(repGetter);
               if (depManager.getVerbose())
                  System.out.println("Generating SegGroup: " + packageName + "." + gcc.getName());

               confSegGroupBuilder.buildClass((SegGroup) segGroup.getChild(i), underlyingPackageType, childProfileName.clearNameMap());
            }

      }

      depManager.generateFile(gcc, packageName, profileName.getClassName());

   }

	/** This method creates the segment group name which is comprised of all the 
	 * underlying segments names put together
	 * @param segGroup the SegGroup to build
	 */
	public static String generateSegGroupName(SegGroup segGroup) {
		String name = new String();

		for (int i = 1; i <= segGroup.getChildren(); i++) {
			ProfileStructure child = segGroup.getChild(i);
			if (child instanceof Seg)
				name += child.getName();
			else
				name += generateSegGroupName((SegGroup) child);
		}

		return name;
	}

}
