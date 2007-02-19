/**
The contents of this file are subject to the Mozilla Public License Version 1.1 
(the "License"); you may not use this file except in compliance with the License. 
You may obtain a copy of the License at http://www.mozilla.org/MPL/ 
Software distributed under the License is distributed on an "AS IS" basis, 
WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the 
specific language governing rights and limitations under the License. 

The Original Code is "AntGenerator.java".  Description: 
"This class creates an ANT build.xml file" 

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

/** This class creates an ANT build.xml file
 * @author <table><tr>James Agnew</tr>
 *                <tr>Paul Brohman</tr>
 *                <tr>Mitch Delachevrotiere</tr>
 *                <tr>Shawn Dyck</tr>
 * 				  <tr>Cory Metcalf</tr></table>
 */
public class AntGenerator {
   private String baseDir;
   private String name;
		
   /** Returns a String representation of the ANT build.xml file
	* @return a String representation of the ANT build.xml file
	*/
   private String antString(){
      String classPath[] = System.getProperty("java.class.path",".").split(";", -1);
		
      String ant = 
         "<!-- Build file for the Conformance Classes -->\n" +
			"<project name=\"" + name + "\" default=\"dist\" basedir=\"" + baseDir + "\">\n" +
				"<!--  set global properties for this build -->\n" +
	  			"<property name=\"src\" value=\".\" />\n" +
				"<property name=\"build\" value=\"${basedir}/build\" />\n" +
	  			"<property name=\"classes\" value=\"${build}/classes\" />\n" +
	  			"<property name=\"docs\" value=\"${build}/docs\" />\n" +
	  			"<property name=\"dist\" value=\"${basedir}/dist\" />\n" +    
				"<property name=\"build\" value=\"ca\" />\n" +

	  			"<!-- The class path -->\n" +
				"<path id=\"class.path\">\n"+
    				"<pathelement path=\"${src}\" />\n" + 
     				"<pathelement path=\"${classes}\" />\n";
     				
	     			// add locations on the class path
     				for(int i = 0; i < classPath.length; i++){
        					ant += "<pathelement location=\"" + classPath[i] + "\" />\n";
        			}
    				
    				ant += "<pathelement location=\"${java.home}/jre/lib/rt.jar\" />\n" +
  					"</path>\n" +
 
  				"<!-- Compile the project -->\n" +
  				"<target name=\"compile_core\">\n" +
    				"<mkdir dir=\"${classes}\" />\n" +
    				"<javac srcdir=\"${src}\" destdir=\"${classes}\" includes=\"**\">\n" +
      					"<classpath refid=\"class.path\" />\n" +
    				"</javac>\n" +
  				"</target>\n" +
 
  				"<!--  Creates JavaDoc documentation (core classes only)   -->\n" +
  				"<target name=\"doc\">\n" +
    				"<mkdir dir=\"${docs}\" />\n" +
      				"<javadoc packagenames=\"*\" classpathref=\"class.path\" sourcepath=\"${src}\" destdir=\"${docs}\" windowtitle=\"HAPI API Documentation\" />\n" +
  				"</target>\n" +
   
	  		    "<!-- Add the files to a Jar Archive -->\n" +
			    "<target name=\"jar\" depends=\"compile_core, doc\">\n" +
			      "<mkdir dir=\"${dist}\" />\n" +
			        "<jar jarfile=\"${dist}/" + name + ".jar\" basedir=\"${classes}\">\n" +
			          "<fileset dir=\"${docs}\" />\n" +
			        "</jar>\n" +
			    "</target>\n" +
			  
			
			    "<target name=\"dist\" depends=\"jar,doc\" />\n" +
			    "<target name=\"clean\">\n" +
			      "<delete>\n" +
			        "<fileset dir=\"${build}\" />\n" +
			      "</delete>\n" +
			    "</target>\n" +
			  "</project>\n";
			  
      return ant;
   }
	
   /** Creates the ANT build.xml file
	* @param baseDir the directory where the ANT build.xml file will be saved
	* @param name the name of the project
	*/
   public void createAnt(String baseDir, String name){
      this.baseDir = baseDir;
	  this.name = name;
      FileOutputStream fstream;
	  try{	
         File f = new File( baseDir + File.separator + "build.xml");
         fstream = new FileOutputStream( f ); /* open file stream */
      } catch ( FileNotFoundException e ) {
         System.out.println("Filenotfoundexception: " + e.toString() );
         return;
      }
      
      DataOutputStream ostream = null;
      try {
         ostream = new DataOutputStream( fstream );   /* open object stream */
         ostream.writeBytes( this.antString() );
	  } catch ( IOException e ) {
	     System.out.println("IOexception:\n" + e.toString() + "\n" );
	  } finally {
         try {
            /* clean-up */
            ostream.flush();
            fstream.close();
         } catch (Exception e1) {
            e1.printStackTrace();
         }
      }
   }
}
