/**
The contents of this file are subject to the Mozilla Public License Version 1.1 
(the "License"); you may not use this file except in compliance with the License. 
You may obtain a copy of the License at http://www.mozilla.org/MPL/ 
Software distributed under the License is distributed on an "AS IS" basis, 
WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the 
specific language governing rights and limitations under the License. 

The Original Code is "GeneratedPrimitive.java".  Description: 
"This Class adds the necessary functionality to a primitive Class" 

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

/** This Class adds the necessary functionality to a primitive Class
 * @author <table><tr>James Agnew</tr>
 *                <tr>Paul Brohman</tr>
 *                <tr>Mitch Delachevrotiere</tr>
 *                <tr>Shawn Dyck</tr>
 * 				  <tr>Cory Metcalf</tr></table>
 */
public class GeneratedPrimitive extends GeneratedConformanceContainer {
   private DocumentationBuilder docBuilder; // The documentation builder

   private boolean hasConstantValue;

   /** Genrates a primitive class
    */
   public GeneratedPrimitive() {
      super();

      docBuilder = DocumentationBuilder.getDocumentationBuilder();

      hasConstantValue = false;

      // Set up constructor
      this.getConstructor().addParam("Primitive hapiPrimitive", "Reference to the underlying HAPI <CODE>Primitive</CODE> data type.");
      this.getConstructor().addToBody("super( hapiPrimitive );");

      GeneratedMethod getMaxLength = new GeneratedMethod();
      getMaxLength.setName("getMaxLength");
      getMaxLength.addToBody("return MAX_LENGTH;");
      getMaxLength.setReturnType("long");
      getMaxLength.setVisibility("public");
      docBuilder.decorateMaxLength(getMaxLength);
      this.addMethod(getMaxLength);

      GeneratedMethod getConstantValue = new GeneratedMethod();
      getConstantValue.setName("getConstantValue");
      getConstantValue.addToBody("return CONSTANT_VALUE;");
      getConstantValue.setReturnType("String");
      getConstantValue.setVisibility("public");
      docBuilder.decorateConstantValue(getConstantValue);
      this.addMethod(getConstantValue);

   }

   /** adds the constant value member variable to the primitive class
    * @param constantValue the value to enforce
    */
   public void addConstantValue(String constantValue) {
      hasConstantValue = true;

      if (constantValue != null) {
         constantValue = "\"" + constantValue + "\"";
      } else
         constantValue = "null";

      this.addMemberVariable("private final String CONSTANT_VALUE = " + constantValue + ";");
   }

   /** adds the constant member variable to the primitive class representing the maximum length
    * @param maxLength the maximum length to enforce
    */
   public void addMaxLength(long maxLength) {
      this.addMemberVariable("private final int MAX_LENGTH = " + maxLength + ";");
   }

   /** adds the constant value member variable to the primitive class
    * @return a String representation of the constant value
    */
   public String toString() {
      if (!hasConstantValue)
         addConstantValue(null);

      return super.toString();
   }

}
