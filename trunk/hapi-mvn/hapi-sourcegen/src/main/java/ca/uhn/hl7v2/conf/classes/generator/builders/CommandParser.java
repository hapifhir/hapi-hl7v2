/**
The contents of this file are subject to the Mozilla Public License Version 1.1 
(the "License"); you may not use this file except in compliance with the License. 
You may obtain a copy of the License at http://www.mozilla.org/MPL/ 
Software distributed under the License is distributed on an "AS IS" basis, 
WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the 
specific language governing rights and limitations under the License. 

The Original Code is "CommandParse.java".  Description: 
"This class parses the command line argument for the command line tool ConfGen.java" 

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

import java.util.ArrayList;
import java.util.List;

/** This class parses the command line argument for the command line tool ConfGen.java
 * @author <table><tr>James Agnew</tr>
 *                <tr>Paul Brohman</tr>
 *                <tr>Mitch Delachevrotiere</tr>
 *                <tr>Shawn Dyck</tr>
 * 				  <tr>Cory Metcalf</tr></table>
 */
public class CommandParser {
   private boolean errFlag = false;
   private String errorType;
   private boolean helpFlag = false;
   private List<String> params;

   // option flags
   private boolean testFlag = false;
   private boolean verbFlag = false;

   /** creates a new vector to store the command line arguments into 
    */
   public CommandParser() {
      this.params = new ArrayList<String>();
   }

   /** returns the location where the genrated files are going to be stored into 
    * @return the location where the genrated files are going to be stored into   
    */
   public String getDest() {
      return params.get(1).toString();
   }
   /** returns true if the error flag is set or false if it is not
    * @return true if the error flag is set or false if it is not  
    */
   public boolean getErrFlag() {
      return errFlag;
   }

   /** returns the error type if there is an error in the command line arguments 
    * @return the error type if there is an error in the command line arguments 
    */
   public String getError() {
      return errorType;
   }

   /** returns true if the help flag is set or false if it is not
    * @return true if the help flag is set or false if it is not  
    */
   public boolean getHelpFlag() {
      return helpFlag;
   }
   
   /** returns the pakage name to use for the generated source 
    * @return the pakage name to use for the generated source 
    */
   public String getPackage() {
      return params.get(2).toString();
   }

   /** returns the location of the XML profile 
    * @return the location of the XML profile  
    */
   public String getSource() {
      return params.get(0).toString();
   }
   /** returns true if the test flag is set or false if it is not
    * @return true if the test flag is set or false if it is not  
    */
   public boolean getTestFlag() {
      return testFlag;
   }

   /** returns true if the verbose flag is set or false if it is not
    * @return true if the verbose flag is set or false if it is not  
    */
   public boolean getVerbFlag() {
      return verbFlag;
   }

   /** this method parses the command line for the ConfGen.java command line tool
    * @param args[] the commnad line arguments
    */
   public void parse(String args[]) {
      int i = 0;
      String arg;
      char flag;

      while (i < args.length && args[i].startsWith("-")) {
         arg = args[i++];

         // use this type of check for a series of flag arguments			
         for (int j = 1; j < arg.length(); j++) {
            flag = arg.charAt(j);
            switch (flag) {
               case 'v' : // -v = verbose
                  verbFlag = true;
                  break;
               case 'h' : // -h = help
                  helpFlag = true;
                  break;
               case 't' : // -t = test
                  testFlag = true;
                  break;
               default :
                  errFlag = true;
                  errorType = "invalid command line argument";
                  break;
            }
         }
      }

      while (i < args.length && params.size() < 3) {
         params.add(args[i++]);
      }

      if (params.size() < 3) {
         errFlag = true;
         errorType = "invalid parameters, source destination and package required";
      }
   }
}
