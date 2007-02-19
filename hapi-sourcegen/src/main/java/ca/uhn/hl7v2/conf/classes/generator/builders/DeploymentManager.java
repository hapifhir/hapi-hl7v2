/**
The contents of this file are subject to the Mozilla Public License Version 1.1 
(the "License"); you may not use this file except in compliance with the License. 
You may obtain a copy of the License at http://www.mozilla.org/MPL/ 
Software distributed under the License is distributed on an "AS IS" basis, 
WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the 
specific language governing rights and limitations under the License. 

The Original Code is "DeploymentManager.java".  Description: 
"This Class Starts the build process and generates the Class files" 

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

import java.io.*;
import ca.uhn.hl7v2.conf.parser.ProfileParser;
import ca.uhn.hl7v2.conf.spec.*;
import ca.uhn.hl7v2.conf.classes.generator.genclasses.*;
import ca.uhn.hl7v2.conf.classes.exceptions.*;

/** This Class Starts the build process and generates the Class files
 * @author <table><tr>James Agnew</tr>
 *                <tr>Paul Brohman</tr>
 *                <tr>Mitch Delachevrotiere</tr>
 *                <tr>Shawn Dyck</tr>
 * 				  <tr>Cory Metcalf</tr></table>
 */
public class DeploymentManager {

   private ConformanceMessageBuilder confMsgBuilder;
   private FileGenerator fg;
   private String packageName;
   private boolean verbose = false;

   /** Creates a new instance of DeploymentManager */
   public DeploymentManager(String dest, String packageName) {
      this.fg = new FileGenerator(dest);
      this.packageName = packageName;
      this.confMsgBuilder = new ConformanceMessageBuilder(packageName);
   }

   /** This method generates a Java representation of an XML profile message
    * @param xml an XML representation of a profile message
    */
   public void generate(String xml) throws ConformanceException{
      try {
         ProfileParser pp = new ProfileParser(false);
         AntGenerator an = new AntGenerator();
         RuntimeProfile spec = pp.parse(xml);

		 if( spec.getHL7Version() == null || spec.getHL7Version().equals("") )
		    throw new ConformanceException("Error: Runtime Profile does not specify HL7Version");
		   
		 if( spec.getMessage().getMsgStructID() == null || spec.getMessage().getMsgStructID().equals("") )
		 	throw new ConformanceException("Error: Runtime Profile does not specify MsgStructID");
		 		 	
         this.confMsgBuilder.buildClass(spec, this);
         an.createAnt(fg.getBasePath(), packageName);

      } catch (ca.uhn.hl7v2.conf.ProfileException e) {
      	e.printStackTrace();
      	System.out.println(e.getCause().toString());
      	e.getCause().printStackTrace();
         System.out.println("ProfileException: " + e.toString());
      }

   }

   /** This method is used to generate a file containng the Generated Class
    * @param gc the Generated Class
    * @param packageName the name of the package
    * @param filename the name to save the generated class under
    */
   public void generateFile(GeneratedClass gc, String packageName, String filename) {
      //fg.storeFile(gc, filename, packageName);
      try {
         fg.storeFile(gc, packageName, filename);
      } catch (IOException e) {
         System.err.println(e.getMessage());
      }
   }

   /** This method returns the value of the member variable verbose
   * @return the value of the verbose flag of either true or false
   */
   public boolean getVerbose() {
      return this.verbose;
   }

   /** This method sets the member variable verbose
    * @param verbose sets verbose flag to true or false
    */
   public void setVerbose(boolean verbose) {
      this.verbose = verbose;
   }

}