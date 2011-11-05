/**
The contents of this file are subject to the Mozilla Public License Version 1.1 
(the "License"); you may not use this file except in compliance with the License. 
You may obtain a copy of the License at http://www.mozilla.org/MPL/ 
Software distributed under the License is distributed on an "AS IS" basis, 
WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the 
specific language governing rights and limitations under the License. 

The Original Code is "GeneratedClass.java".  Description: 
"This Class generates a Class File which is used by the Conformance Builder Classes" 

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
import java.util.*;
import ca.uhn.hl7v2.conf.classes.generator.builders.*;

/** This Class generates a Class File which is used by the Conformance Builder Classes
 * @author <table><tr>James Agnew</tr>
 *                <tr>Paul Brohman</tr>
 *                <tr>Mitch Delachevrotiere</tr>
 *                <tr>Shawn Dyck</tr>
 * 				  <tr>Cory Metcalf</tr></table>
 */
public class GeneratedClass {

   private static final String INDENT = "   ";
   private Vector<String> classComments;
   private Vector<String> classImports;
   private String classPackage;
   private GeneratedMethod constructor;
   private Vector<String> license;
   private Vector<String> memberVariables;
   private Vector<GeneratedMethod> methods;
   private String name;
   private String properties;

   /** Creates a new instance of GeneratedClass,
    *  creates a new instance of the all the memberVariables 
    */
   public GeneratedClass() {
      classImports = new Vector<String>();
      memberVariables = new Vector<String>();
      methods = new Vector<GeneratedMethod>();
      classComments = new Vector<String>();
      license = new Vector<String>();
      constructor = new GeneratedMethod();
      constructor.setVisibility("public");
      classPackage = "";
      properties = "";
   }

   /** This method adds a new comment to the class contained within the generated Java source file
    *  @param classComment adds a comment to the class
    */
   public void addClassComment(String classComment) {
      this.classComments.add(classComment);
   }

   /** This method adds a new import statement to the class contained within the generated Java source file
    *  @param classImport the import path to import
    */
   public void addClassImport(String classImport) {
      this.classImports.add("import " + classImport + ";");
   }

   /** This method adds a new member variable to the class contained within the generated Java source file
    *  @param memberVariable the member variable to add
    */
   public void addMemberVariable(String memberVariable) {
      memberVariables.add(memberVariable);
   }

   /** This method adds a new method to the class contained within the generated Java source file
    *  @param method the generated method to add
    */
   public void addMethod(GeneratedMethod method) {
      methods.add(method);
   }

   /** This method sets the class comments for the class contained within the generated Java source file
    *  @param comments the comments to add to the class comments
    */
   public void addToClassComments(String comments) {
      this.classComments.add(comments);
   }

   /** This method returns the constructor for the class contained within the generated Java source file
    *  @return the generated methods constructor
    */
   public GeneratedMethod getConstructor() {
      return this.constructor;
   }

   /** This method returns the class name of the class contained within the generated Java source file
    *  @return the class name
    */
   public String getName() {
      return this.name;
   }

   /** This method sets the classPackage for the class contained within the generated Java source file
    *  @param classPackage the classPackage to set
    */
   public void setClassPackage(String classPackage) {
      if (classPackage != null)
         this.classPackage = classPackage;
      else
         this.classPackage = "";
   }

   /** This method sets the constructor for the class contained within the generated Java source file
     *  @return the generated methods constructor
    */
   public void setConstructor(GeneratedMethod constructor) {
      this.constructor = constructor;
   }

   /** This method sets the class name for the class contained within the generated Java source file
    *  @param the class name
    */
   public void setName(String name) {
      this.name = name + " ";
      this.constructor.setName(name);
   }

   /** This method sets the class properties for the class contained within the generated Java source file
    *  @param propertie to set
    */
   public void setProperties(String properties) {
      if (properties != null)
         this.properties = properties + " ";
      else
         this.properties = "";
   }

   /** This method will return a String representation of the class contained within the generated 
    * Java source file 
    * @return a String representation of the class
    */
   public String toString() {
      String theClass = new String();

      theClass += DocumentationBuilder.getDocumentationBuilder().getGeneratedClassHeader();
      theClass += vectorToString(0, license, "").concat("\n\n"); // License block
      theClass += "package " + classPackage + ";\n\n"; // Package statement
      theClass += vectorToString(0, classImports, "").concat("\n\n"); // Package and import statements
      theClass += "/**\n" + vectorToString(0, classComments, " * ").concat(" */\n"); // Class comments

      theClass += "public class " + name + properties + "{\n\n"; // Class statement
      theClass += vectorToString(1, memberVariables, "").concat("\n\n"); // member variables
      theClass += constructor.toString() + "\n\n"; // Constructor
      theClass += vectorToString(0, methods, "").concat("\n"); // methods (no indentation because methods indent themselves)
      theClass += "}\n";
      return theClass;
   }

   /** Creates a string based on a vector representing the individual lines of a string
    * @param indentLevel the indentation level to use. For example, a level of 2 would use two "tabs" before each line.
    * @param vec the vector to be converted
    * @param prefix a string to prepend to each line (ie <example>" * "</example> for a comment)
    * @return the generated string
    */
   private String vectorToString(int indentLevel, Vector<?> vec, String prefix) {
      String pString = "";
      String indent = "".concat(prefix);

      // Create indentation string
      for (int i = 0; i < indentLevel; i++)
         indent = INDENT + indent;

      // Convert the vector to a string
      for (int i = 0; i < vec.size(); i++)
         pString += indent + vec.get(i).toString() + "\n";
      return pString;
   }

}
