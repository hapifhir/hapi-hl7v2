/**
The contents of this file are subject to the Mozilla Public License Version 1.1 
(the "License"); you may not use this file except in compliance with the License. 
You may obtain a copy of the License at http://www.mozilla.org/MPL/ 
Software distributed under the License is distributed on an "AS IS" basis, 
WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the 
specific language governing rights and limitations under the License. 

The Original Code is "ConformanceSegmentBuilder.java".  Description: 
"This Class builds Conformance Segment Classes" 

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
import ca.uhn.hl7v2.conf.classes.exceptions.*;
import ca.uhn.hl7v2.conf.spec.message.*;

/** This Class builds Conformance Segment Classes
 * @author <table><tr>James Agnew</tr>
 *                <tr>Paul Brohman</tr>
 *                <tr>Mitch Delachevrotiere</tr>
 *                <tr>Shawn Dyck</tr>
 * 				  <tr>Cory Metcalf</tr></table>
 */
public class ConformanceSegmentBuilder {
   private DeploymentManager depManager; // The deployment manager
   private DocumentationBuilder docBuilder; // The documentation builder
   private String packageName; // Represents the Package that this Segment will go in

   private String versionString; // The HAPI version

   /** This constructor will create a new ConformanceSegmentBuilder
    * @param packageName the name of the package
    * @param versionString the version of HL7 which these classes are conforming to
    * @param depManager the instance of DeploymentManager
    */
   public ConformanceSegmentBuilder(String packageName, String versionString, DeploymentManager depManager) {
      super();
      this.packageName = packageName;
      this.versionString = versionString;
      this.docBuilder = DocumentationBuilder.getDocumentationBuilder();
      this.depManager = depManager;
   }

   /** This method builds a Conformance Segment Class
    * @param seg the Segment to build
    * @param parentUnderlyingType the data type of the parent Message or SegGroup for this segment
    *        example "ca.uhn.hl7v2.model.v24.group.ADR_A19_..."    
    * @param profileName this is the profile name associated with this Class
    */
   public void buildClass(Seg seg, String parentUnderlyingType, ProfileName profileName) {
      GeneratedConformanceContainer gcc = new GeneratedConformanceContainer();
		String underlyingDataType; // The underlying HAPI Type

      // Check for possible snags in the Runtime Profile Segment
      if (seg.getName() == null || seg.getName().length() < 1)
         throw new ConformanceError("Error building ConformanceSegment: Runtime Segment does not contain a name.");

      // Set up class
      gcc.setClassPackage(packageName);
      gcc.addClassImport("ca.uhn.hl7v2.conf.classes.abs.*");
      gcc.addClassImport("ca.uhn.hl7v2.conf.classes.exceptions.*");
      gcc.addClassImport("ca.uhn.hl7v2.*");
      gcc.addClassImport(packageName + "." + profileName.getPackageName() + ".*");

      gcc.setName(profileName.getClassName());
      gcc.setProperties("extends AbstractConformanceContainer implements Repeatable");
      gcc.setMinMaxReps(seg.getMin(), seg.getMax());
      underlyingDataType = "ca.uhn.hl7v2.model." + versionString + ".segment." + seg.getName();

      String segClassName = UnderlyingAccessor.getHapiModelClass(underlyingDataType).getName();
      gcc.addMemberVariable("private " + segClassName + " hapiSegment;");

	  docBuilder.decorateConstructor( gcc.getConstructor(), profileName.getClassName() );
	  
      // Set up underlying Segment type
      GeneratedMethod theConstructor = gcc.getConstructor();
      theConstructor.addParam(parentUnderlyingType + " underlyingMessage", "The underlying message object");
      theConstructor.addParam("int rep", "The underlying rep number");
      UnderlyingAccessor underlyingAccessor = new UnderlyingAccessor(parentUnderlyingType, profileName.getAccessorName());
      theConstructor.addToBody("this.hapiSegment = (" + segClassName + ") underlyingMessage." + underlyingAccessor.toString() + ";");
      theConstructor.addToThrows("HL7Exception");

      // Loop through each child. Note that array is 1-offset
      for (int i = 1; i <= seg.getFields(); i++) {
		 //don't build not supported, backward, or unknown types
		 String usage = seg.getField(i).getUsage();
		 if( usage != null && (usage.equals("X") || usage.equals("B") || usage.equals("U")) )
			continue;
			
         // Create the names for each type of child
//         //CHANGED to use field # instead of name, in support of Z-segments 
//         ProfileName childProfileName = profileName.newInstance(String.valueOf(i), ProfileName.PS_FIELD);
         ProfileName childProfileName = profileName.newInstance(seg.getField(i).getName(), ProfileName.PS_FIELD);
         
         // Add the member variable vector to hold them
         gcc.addMemberVariable("private FiniteList " + childProfileName.getMemberName() + ";");

         // Set up the constructor
         theConstructor.addToBody(childProfileName.getMemberName() + " = new FiniteList( " + childProfileName.getClassName() + ".class, hapiSegment );");

         // Add the getter
			UnderlyingAccessor childAccessor = new UnderlyingAccessor(underlyingDataType, childProfileName.getAccessorName());
         GeneratedRepGetter repGetter = new GeneratedRepGetter(childProfileName, childAccessor.getAcceptsRep());
         docBuilder.decorateRepGetter(repGetter, seg.getField(i), childProfileName.getClassName());
         gcc.addMethod(repGetter);

         // If the field has no components it is a primitive, so build as such.
         if (seg.getField(i).getComponents() > 0) {
            ConformanceFieldBuilder childBuilder = new ConformanceFieldBuilder(packageName + "." + profileName.getPackageName(), versionString, depManager);
            childBuilder.buildClass(seg.getField(i), segClassName, childProfileName.clearNameMap());
         } else {
            ConformancePrimitiveBuilder childBuilder = new ConformancePrimitiveBuilder(packageName + "." + profileName.getPackageName(), depManager);
            childBuilder.buildClass(seg.getField(i), segClassName, childProfileName.clearNameMap());
         }

      }

      // Decorate with comments
      docBuilder.decorateSegment(gcc, seg);

      if (depManager.getVerbose())
         System.out.println("Generating Segment: " + packageName + "." + gcc.getName());

      depManager.generateFile(gcc, packageName, profileName.getClassName());

   }
}
