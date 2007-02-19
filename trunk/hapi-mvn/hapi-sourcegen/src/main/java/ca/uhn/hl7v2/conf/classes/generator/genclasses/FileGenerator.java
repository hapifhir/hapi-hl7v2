/**
The contents of this file are subject to the Mozilla Public License Version 1.1 
(the "License"); you may not use this file except in compliance with the License. 
You may obtain a copy of the License at http://www.mozilla.org/MPL/ 
Software distributed under the License is distributed on an "AS IS" basis, 
WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the 
specific language governing rights and limitations under the License. 

The Original Code is "FileGenerator.java".  Description: 
"This class writes a GeneratedClass object to a file" 

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

import java.io.*;

/** This class writes a GeneratedClass object to a file
 * @author <table><tr>James Agnew</tr>
 *                 <tr>Paul Brohman</tr>
 *                 <tr>Mitch Delachevrotiere</tr>
 *                 <tr>Shawn Dyck</tr>
 * 				   <tr>Cory Metcalf</tr></table>
 */
public class FileGenerator {
   private String basePath;

   /** Initialize member variable setting the base file path
    * @param basePath representing base path location
    */
   public FileGenerator(String basePath) {
      // make sure there is a \ appended to ouput director path
      System.out.println(basePath);
      this.basePath = basePath.replace('\\', '/');
      if ((basePath.charAt(basePath.length() - 1)) != '/')
         basePath = basePath + "/";

   }
   
   /** This method returns the Base Path
    * @return the Base Path
    */
   public String getBasePath(){
   		return basePath;
   }
   
   /** this method writes the GeneratedClass object to disk
    * @param gc the object to be written to disk
    * @param packageName representing the packageName
    * @param fileName representing the file name
    * @exception IOException if unable to create file
    */
   public void storeFile(GeneratedClass gc, String packageName, String fileName) throws IOException {

      //format package name
      packageName = packageName.replace('.', '/');

      // set the file path
      fileName = fileName.replaceAll(" ", "") + ".java";
      String filePath = basePath + "/" + packageName + "/" + fileName;
      File f = new File(filePath);
      StringBuffer dir = new StringBuffer();

      //check if file exist
      // TODO: Reactivate this once everything works!
      //if(f.exists())
      //	throw new IOException("File already exists");

      //create subfolders
      int i = 0;
      while (i < filePath.length()) {
         if (filePath.charAt(i) != '/') {
            dir.append(filePath.charAt(i));
         } else {
            dir.append(filePath.charAt(i));
            File d = new File(dir.toString());
            d.mkdir();
         }
         ++i;
      }

      FileOutputStream fstream = new FileOutputStream(f); /* open file stream */
      DataOutputStream ostream = new DataOutputStream(fstream); /* open object stream */
      ostream.writeBytes(gc.toString());

      /* clean-up */
      ostream.flush();
      fstream.close();
   }
}
