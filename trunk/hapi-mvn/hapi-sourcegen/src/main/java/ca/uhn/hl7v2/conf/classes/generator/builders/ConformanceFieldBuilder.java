/**
The contents of this file are subject to the Mozilla Public License Version 1.1 
(the "License"); you may not use this file except in compliance with the License. 
You may obtain a copy of the License at http://www.mozilla.org/MPL/ 
Software distributed under the License is distributed on an "AS IS" basis, 
WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the 
specific language governing rights and limitations under the License. 

The Original Code is "ConformanceFieldBuilder.java".  Description: 
"/** This class is builds Conformance Field Classes" 

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

/** This class builds Conformance Field Classes
 * @author <table><tr>James Agnew</tr>
 *                <tr>Paul Brohman</tr>
 *                <tr>Mitch Delachevrotiere</tr>
 *                <tr>Shawn Dyck</tr>
 * 				  <tr>Cory Metcalf</tr></table>
 */
public class ConformanceFieldBuilder {
   private DeploymentManager depManager;
   private DocumentationBuilder docBuilder; // The documentation builder

   private String packageName; // Represents the Package that this Segment will go in
   private String underlyingType; // The underlying HAPI Type
   private String versionString; // The HAPI version

   /** This constructor will create a new ConformanceFieldBuilder
    * @param packageName the name of the package
    * @param versionString the version of HL7 which these classes are conforming to
    * @param depManager the instance of DeploymentManager
    */
   public ConformanceFieldBuilder(String packageName, String versionString, DeploymentManager depManager) {
      super();
      this.packageName = packageName;
      this.docBuilder = DocumentationBuilder.getDocumentationBuilder();
      this.depManager = depManager;
      this.versionString = versionString;
   }

   /** This method builds a Conformance Field Class
    * @param field the Field to build
    * @param parentUnderlyingType the data type of the parent Segment for this field
    *        example "ca.uhn.hl7v2.model.v24.segment.MSH"  
    * @param profileName  ProfileName
    */
   public void buildClass(Field field, String parentUnderlyingType, ProfileName profileName) {
      GeneratedConformanceContainer gcc = new GeneratedConformanceContainer();
      GeneratedMethod gm = new GeneratedMethod();

      // Check for possible snags in the Runtime Profile Segment
      if (field.getName() == null || field.getName().length() < 1)
         throw new ConformanceError("Error building ConformanceField: Runtime Field does not contain a name.");

      // Set up class
      gcc.setClassPackage(packageName);
      gcc.addClassImport("ca.uhn.hl7v2.conf.classes.abs.*");
      gcc.addClassImport("ca.uhn.hl7v2.conf.classes.exceptions.*");
      gcc.addClassImport("ca.uhn.hl7v2.model.*");
      gcc.addClassImport("ca.uhn.hl7v2.*");

      if (field.getComponents() > 0)
         gcc.addClassImport(packageName + "." + profileName.getPackageName() + ".*");

      gcc.setName(profileName.getClassName());

      gcc.setProperties("extends AbstractConformanceContainer implements Repeatable");
      gcc.setMinMaxReps(field.getMin(), field.getMax());
      underlyingType = "ca.uhn.hl7v2.model." + versionString + ".datatype." + field.getDatatype();
      gcc.addMemberVariable(underlyingType + " hapiType;");
      gcc.addMemberVariable("private final short MAX_LENGTH = " + field.getLength() + ";");
      gm.setReturnType("long");
      gm.setVisibility("public");
      gm.setName("getMaxLength");
      gm.addToBody("return this.MAX_LENGTH;");
	  docBuilder.decorateMaxLength(gm);
      gcc.addMethod(gm);

      // Set up underlying Field type
      gcc.getConstructor().addParam(parentUnderlyingType + " hapiSegment", "The underlying HAPI field object");

      gcc.getConstructor().addParam("int rep", "The desired repetition");
      gcc.getConstructor().addToBody("try {");

      UnderlyingAccessor underlyingAccessor = new UnderlyingAccessor(parentUnderlyingType, profileName.getAccessorName());
      gcc.getConstructor().addToBody("   this.hapiType = hapiSegment." + underlyingAccessor + ";");

	  docBuilder.decorateConstructor( gcc.getConstructor(), profileName.getClassName() );
	  
      // Create the getters and member variables associated with each child
      for (int i = 1; i <= field.getComponents(); i++) {
		 //don't build not supported, backward, or unknown types
		 String usage = field.getComponent(i).getUsage();
		 if( usage != null && (usage.equals("X") || usage.equals("B") || usage.equals("U")) )
			continue;
			
         boolean hasChildren = (field.getComponent(i).getSubComponents() > 0) ? true : false;
         ProfileName childProfileName = new ProfileName(field.getComponent(i).getName(), ProfileName.PS_COMP);
         gcc.addComponent(childProfileName, (short) (i - 1), hasChildren);
      }

      gcc.getConstructor().addToBody("} catch ( HL7Exception e ) {");
      gcc.getConstructor().addToBody("   throw new ConformanceError( \"Invalid Attempt to access a rep. This is a bug.\" );");
      gcc.getConstructor().addToBody("}");

      // Decorate with comments
      docBuilder.decorateField(gcc, field);

      if (depManager.getVerbose())
         System.out.println("Generating Field: " + packageName + "." + gcc.getName());

      // Create the components
      for (int i = 1; i <= field.getComponents(); i++) {
         if (field.getComponent(i).getSubComponents() == 0) {
            ConformancePrimitiveBuilder childBuilder = new ConformancePrimitiveBuilder(packageName + "." + profileName.getPackageName(), depManager);
            childBuilder.buildClass(field.getComponent(i), ProfileName.PS_COMP);
         } else {
            ConformanceComponentBuilder childBuilder = new ConformanceComponentBuilder(packageName + "." + profileName.getPackageName(), depManager, versionString);
            childBuilder.buildClass(field.getComponent(i));
         }

      }
      depManager.generateFile(gcc, packageName, gcc.getName());
   }
}
