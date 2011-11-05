/**
The contents of this file are subject to the Mozilla Public License Version 1.1 
(the "License"); you may not use this file except in compliance with the License. 
You may obtain a copy of the License at http://www.mozilla.org/MPL/ 
Software distributed under the License is distributed on an "AS IS" basis, 
WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the 
specific language governing rights and limitations under the License. 

The Original Code is "GeneratedMethod.java".  Description: 
"This class will allows the creation of a method.  All members are set, then the 
 toString method is called to return the String representation of the created method." 

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

import java.util.Vector;

/** This class will allows the creation of a method.  All members
 * are set, then the toString method is called to return the String
 * representation of the created method.
 * @author <table><tr>James Agnew</tr>
 *                <tr>Paul Brohman</tr>
 *                <tr>Mitch Delachevrotiere</tr>
 *                <tr>Shawn Dyck</tr>
 * 				  <tr>Cory Metcalf</tr></table>
 */
public class GeneratedMethod {
   private Vector<String> body;
   private Vector<String> comments;
   private Vector<String> description;
   protected final String INDENT = "   ";
   private String name;
   private Vector<String> params;
   private String returnType;
   private String throwing;
   private String visibility;

   /** Creates a new instance of GeneratedMethod */
   public GeneratedMethod() {
      body = new Vector<String>();
      comments = new Vector<String>();
      params = new Vector<String>();
      description = new Vector<String>();
   }

   /** A method to set the parameters of the method
    * @param param the parameters of the created method
    */
   public void addParam(String param) {
      this.params.add(param);
   }

   /** A method to set the parameters of the method
    * @param param the parameters of the created method
    * @param description the describing this method (for use in the JavaDoc comments)
    */
   public void addParam(String param, String description) {
      this.params.add(param);
      this.addToComments("@param " + param + " " + description);
   }

   /** A method to set the body of the method
    * @param line a line of code to be added to the body of the created method
    * @return a reference to the GeneratedMethod object being modified
    */
   public GeneratedMethod addToBody(String line) {
      this.body.add(line);
      return this;
   }

   /** A method to set the comments of the method
    * @param comments a comment to be added the comments of the created method
    */
   public void addToComments(String comments) {
      this.comments.add(comments);
   }

   /** A method to set the body of the method
    * @param line a description to be added to the created method
    */
   public void addToDescription(String line) {
      this.description.add(line);
   }

   /** A method to set the throws of the method
    * @param throwing sets the throws of the created method
    */
   public void addToThrows(String throwing) {
      this.throwing = throwing;
   }

   /** A method to set the name of the method
    * @param name the name of the created method
    */
   public void setName(String name) {
      this.name = name;
   }

   /** A method to set the return type of the method
    * @param returnType the return type of the created method
    */
   public void setReturnType(String returnType) {
      this.returnType = returnType + " ";
   }

   /** A method to set the visibility of the method
    * @param visibility the visibility of the created method
    */
   public void setVisibility(String visibility) {
      this.visibility = visibility + " ";
   }

   /** creates a method with the filled member variables
    * @return the String representation of the created method
    */
   public String toString() {
      String theMethod;

      // add the comments and visibility to the method 
      theMethod = INDENT + "/**\n" + vectorToString(1, description, " * ") + vectorToString(1, comments, " * ") + "    */\n";
      theMethod += INDENT + visibility;

      // check if its a constructor
      if (returnType != null)
         theMethod += returnType;

      // add the paramters to the method
      theMethod += name;
      if (params.size() > 0)
         theMethod += "(" + params.toString().replace('[', ' ').replace(']', ' ') + ")";
      else
         theMethod += "()";

      // check if its throwing an exception
      if (throwing != null)
         theMethod += " throws " + throwing;

      // create the body of the method
      theMethod += " {\n" + vectorToString(2, body, "") + INDENT + "}\n";
      return theMethod;
   }

   /** Creates a string based on a vector representing the individual lines of a string
    * @param indentLevel the indentation level to use. For example, a level of 2 would use two "tabs" before each line.
    * @param vec the vector to be converted
    * @param prefix a String to prepend to each line 
    *        example " * " for a comment)
    * @return The generated string
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
