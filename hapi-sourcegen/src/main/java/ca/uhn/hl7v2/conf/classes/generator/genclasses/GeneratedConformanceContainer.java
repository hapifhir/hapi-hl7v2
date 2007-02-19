/**
The contents of this file are subject to the Mozilla Public License Version 1.1 
(the "License"); you may not use this file except in compliance with the License. 
You may obtain a copy of the License at http://www.mozilla.org/MPL/ 
Software distributed under the License is distributed on an "AS IS" basis, 
WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the 
specific language governing rights and limitations under the License. 

The Original Code is "GeneratedConformanceContainer.java".  Description: 
"This Class is used to addChildren of types Component, SubComponent and to set min and max reps" 

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
package ca.uhn.hl7v2.conf.classes.generator.genclasses;

import ca.uhn.hl7v2.conf.classes.generator.builders.*;

/** This class is used to addChildren of types Component, SubComponent and to set min and max reps
 * @author <table><tr>James Agnew</tr>
 *                <tr>Paul Brohman</tr>
 *                <tr>Mitch Delachevrotiere</tr>
 *                <tr>Shawn Dyck</tr>
 * 				  <tr>Cory Metcalf</tr></table>
 */
public class GeneratedConformanceContainer extends GeneratedClass {

   /** Default constructor */
   public GeneratedConformanceContainer() {
   }

   /** Adds a Component to a conformance Message
   * adds a line to the constructor to instantiate that member variable
   * @param profileName this is the profile name associated with this Class
   * @param componentNumber the number associated with the component in the profile 
   * @param childGetter adds this line to the constructor to instantiate Conformance Component class
   */
   private void addChild(ProfileName profileName, int componentNumber, String childGetter) {

      // Add member variable to class for holding Conformance Component class
      this.addMemberVariable("private " + profileName.getClassName() + " " + profileName.getMemberName() + ";");

      // Add line to constructor to instantiate Conformance Component class
      this.getConstructor().addToBody(childGetter);

      // Add method for retrieving Conformance Component Class
      GeneratedMethod getChildMethod = new GeneratedMethod();
      getChildMethod.addToComments("Provides access to the " + profileName.getOriginalName() + " component child");
      getChildMethod.addToComments("@return " + profileName.getClassName() + " The " + profileName.getOriginalName() + " component child");
      getChildMethod.setVisibility("public");
      getChildMethod.setReturnType(profileName.getClassName());
      getChildMethod.setName(profileName.getAccessorName());
      getChildMethod.addToBody("return " + profileName.getMemberName() + ";");
      this.addMethod(getChildMethod);
   }

   /** Adds a Component to a conformance Message
   * adds a line to the constructor to instantiate that member variable
   * @param profileName this is the profile name associated with this Class
   */
   public void addComponent(ProfileName profileName, int componentNumber, boolean hasChildren) {
      String underlyingType = hasChildren ? "Composite" : "Primitive";
      String childGetter = "   " + profileName.getMemberName() + " = new " + profileName.getClassName() + "( (" + underlyingType + ")hapiType.getComponent(" + componentNumber + ") );";
      this.addChild(profileName, componentNumber, childGetter);
   }

   /** Adds a SubComponent to a conformance class
    * adds a line to the constructor to instantiate that member variable
    * @param profileName this is the profile name associated with this Class
    * @param subComponentNumber representing the number representing the subComponent to add
    */
   public void addSubComponent(ProfileName profileName, int subComponentNumber) {
      this.addComponent(profileName, subComponentNumber, false);
   }

   /** Special case for adding a subcomponent which is a TS type, because the TS
    * underlying type is represented as a Composite, which shouldn't exist at
    * the SubComponent level, but does due to ambiguity in the HL7 spec.
    * @param profileName this is the profile name associated with this Class
    */
   public void addTSSubComponent(ProfileName profileName, int componentNumber, String hl7Version) {

      String componentOneAccessor = "(Primitive)((ca.uhn.hl7v2.model." + hl7Version + ".datatype.TS)(hapiType.getComponent(" + componentNumber + "))).getComponent(0)";
      String childGetter = "   " + profileName.getMemberName() + " = new " + profileName.getClassName() + "( " + componentOneAccessor + " );";
      this.addChild(profileName, componentNumber, childGetter);
   }

   /**Adds min and max reps to the genrated classes
   * @param minReps the Minimum Repetitions
   * @param maxReps Maximum Repetitions
   */
   public void setMinMaxReps(short minReps, short maxReps) {

      GeneratedMethod maxRepsMethod = new GeneratedMethod();
      GeneratedMethod minRepsMethod = new GeneratedMethod();

      this.addMemberVariable("private final short MAX_REPS = " + maxReps + ";");
      this.addMemberVariable("private final short MIN_REPS = " + minReps + ";");

      // Creates the methos to return the maximum number of repitions for the generated Class
      DocumentationBuilder.getDocumentationBuilder().decorateMaxReps(maxRepsMethod);
      maxRepsMethod.setVisibility("public");
      maxRepsMethod.setReturnType("short");
      maxRepsMethod.setName("getMaxReps");
      maxRepsMethod.addToBody("return this.MAX_REPS;");
      this.addMethod(maxRepsMethod);

      // Creates the method to return the maximum number of repitions for the generated Class
      DocumentationBuilder.getDocumentationBuilder().decorateMaxReps(minRepsMethod);
      minRepsMethod.setVisibility("public");
      minRepsMethod.setReturnType("short");
      minRepsMethod.setName("getMinReps");
      minRepsMethod.addToBody("return this.MIN_REPS;");
      this.addMethod(minRepsMethod);
   }

}
