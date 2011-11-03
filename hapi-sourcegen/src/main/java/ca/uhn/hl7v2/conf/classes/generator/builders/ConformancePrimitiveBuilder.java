/**
The contents of this file are subject to the Mozilla Public License Version 1.1 
(the "License"); you may not use this file except in compliance with the License. 
You may obtain a copy of the License at http://www.mozilla.org/MPL/ 
Software distributed under the License is distributed on an "AS IS" basis, 
WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the 
specific language governing rights and limitations under the License. 

The Original Code is "DBTableRepository.java".  Description: 
"Implements TableRepository by looking up values from the default HL7
  normative database" 

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

/** This Class builds Conformance Primitive Classes
 * @author <table><tr>James Agnew</tr>
 *                 <tr>Paul Brohman</tr>
 *                 <tr>Mitch Delachevrotiere</tr>
 *                 <tr>Shawn Dyck</tr>
 * 				   <tr>Cory Metcalf</tr></table>
 */
public class ConformancePrimitiveBuilder {
   private DeploymentManager depManager; // The deployment manager
   private DocumentationBuilder docBuilder; // The documentation builder

   private String packageName; // Represents the Package that this Segment will go in

   /** This constructor will create a new ConformancePrimitiveBuilder
    */
   public ConformancePrimitiveBuilder(String packageName, DeploymentManager depManager) {
      super();
      this.packageName = packageName;
      this.docBuilder = DocumentationBuilder.getDocumentationBuilder();
      this.depManager = depManager;
   }

   /** This method will build a primitive conformance class (ST, NM, etc) which is
    * a Component or Subcomponent. 
    */
   public void buildClass(ca.uhn.hl7v2.conf.spec.message.AbstractComponent primitive, int profileType) {
      GeneratedPrimitive genClass = new GeneratedPrimitive();
      ProfileName profileName = new ProfileName(primitive.getName(), profileType);

      // Set up class
      genClass.setClassPackage(packageName);
      genClass.addClassImport("ca.uhn.hl7v2.model.*");
      genClass.addClassImport("ca.uhn.hl7v2.conf.classes.abs.*");
      genClass.setProperties("extends AbstractConformanceDataType");

      genClass.setName(profileName.getClassName());
	  docBuilder.decorateConstructor( genClass.getConstructor(), profileName.getClassName() );
	  	  
      if (primitive.getConstantValue() != null && primitive.getConstantValue().length() > 0) {
			// Add constant value constraints if there are any
         genClass.addConstantValue(primitive.getConstantValue());
      } else {
      	// if no constant value, then we add a setter method
         GeneratedMethod setter = new GeneratedMethod();
         setter.addParam("java.lang.String value");
         setter.addToThrows("ConfDataException");
         setter.addToBody("super.setValue( value );");
         setter.setReturnType("void");
         setter.setVisibility("public");
         setter.setName("setValue");
         docBuilder.decorateSetValue(setter, primitive.getLength());
         genClass.addMethod(setter);

         genClass.addClassImport("ca.uhn.hl7v2.conf.classes.exceptions.*");
      }
      genClass.addMaxLength(primitive.getLength());

      // Decorate with comments
      docBuilder.decoratePrimitive(genClass, primitive);
      if (depManager.getVerbose())
         System.out.println("Generating Primitive: " + packageName + "." + genClass.getName());

      depManager.generateFile(genClass, packageName, genClass.getName());

   }

   /** This method will build a primitive conformance class (ST, NM, etc) which is
    * a Field. 
    */
   public void buildClass(ca.uhn.hl7v2.conf.spec.message.Field primitive, String parentUnderlyingType, ProfileName profileName) {
      GeneratedPrimitive genClass = new GeneratedPrimitive();

      // Check for possible snags in the Runtime Profile Component
      if (primitive.getName() == null || primitive.getName().length() < 1)
         throw new ConformanceError("Error building ConformanceSegment: Runtime AbstractComponent does not contain a name.");

      GeneratedMethod theConstructor = new GeneratedMethod();
      genClass.setConstructor(theConstructor);
      genClass.addClassImport("ca.uhn.hl7v2.model.*");

      UnderlyingAccessor underlyingAccessor = new UnderlyingAccessor(parentUnderlyingType, profileName.getAccessorName());
      theConstructor.addParam(parentUnderlyingType + " parentSeg", "The parent underlying data type");
      theConstructor.addParam("int rep", "The desired repetition");
      theConstructor.setName(profileName.getClassName());
      theConstructor.setVisibility("public ");
      theConstructor.addToThrows("ca.uhn.hl7v2.HL7Exception");
      theConstructor.addToBody("super( (Primitive)parentSeg." + underlyingAccessor + " );");
      theConstructor.addToBody("if ( parentSeg." + underlyingAccessor + " == null )");
      theConstructor.addToBody("   throw new ca.uhn.hl7v2.HL7Exception( \"Error accussing underlying object. This is a bug.\", 0 );");

      // Set up class
      genClass.setClassPackage(packageName);
      //genClass.addClassImport("ca.uhn.hl7v2.model.*");
      genClass.addClassImport("ca.uhn.hl7v2.conf.classes.abs.*");
      //genClass.addClassImport( "ca.uhn.hl7v2.conf.classes.exceptions.*" );
      genClass.setProperties("extends AbstractConformanceDataType implements Repeatable");

      // Add min and max reps stuff
      genClass.setMinMaxReps(primitive.getMin(), primitive.getMax());

      genClass.setName(profileName.getClassName());
	  docBuilder.decorateConstructor( genClass.getConstructor(), profileName.getClassName() );
	  
      // Add constant value constraints if there are any, if not, add a setter method
      if (primitive.getConstantValue() != null && primitive.getConstantValue().length() > 0) {
         genClass.addConstantValue(primitive.getConstantValue());
      } else {
         GeneratedMethod setter = new GeneratedMethod();
         setter.addParam("java.lang.String value");
         setter.addToThrows("ConfDataException");
         setter.addToBody("super.setValue( value );");
         setter.setReturnType("void");
         setter.setVisibility("public");
         setter.setName("setValue");
         docBuilder.decorateSetValue(setter, primitive.getLength());
         genClass.addMethod(setter);

         genClass.addClassImport("ca.uhn.hl7v2.conf.classes.exceptions.*");
      }
      genClass.addMaxLength(primitive.getLength());

      // Decorate with comments
      docBuilder.decoratePrimitive(genClass, primitive);
      if (depManager.getVerbose())
         System.out.println("Generating Primitive: " + packageName + "." + genClass.getName());

      depManager.generateFile(genClass, packageName, genClass.getName());
   }

}
