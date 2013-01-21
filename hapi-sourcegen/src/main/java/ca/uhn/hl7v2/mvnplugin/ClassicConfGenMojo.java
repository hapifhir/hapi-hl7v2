/**
The contents of this file are subject to the Mozilla Public License Version 1.1 
(the "License"); you may not use this file except in compliance with the License. 
You may obtain a copy of the License at http://www.mozilla.org/MPL/ 
Software distributed under the License is distributed on an "AS IS" basis, 
WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the 
specific language governing rights and limitations under the License. 

The Original Code is "DataTypeGenerator.java".  Description: 
"Generates skeletal source code for Datatype classes based on the 
  HL7 database" 

The Initial Developer of the Original Code is University Health Network. Copyright (C) 
2001.  All Rights Reserved. 

Contributor(s):  James Agnew 

Alternatively, the contents of this file may be used under the terms of the 
GNU General Public License (the  �GPL�), in which case the provisions of the GPL are 
applicable instead of those above.  If you wish to allow use of your version of this 
file only under the terms of the GPL and not to allow others to use your version 
of this file under the MPL, indicate your decision by deleting  the provisions above 
and replace  them with the notice and other provisions required by the GPL License.  
If you do not delete the provisions above, a recipient may use your version of 
this file under either the MPL or the GPL. 

*/

package ca.uhn.hl7v2.mvnplugin;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.project.MavenProject;
import org.codehaus.plexus.util.IOUtil;

import ca.uhn.hl7v2.conf.classes.exceptions.ConformanceException;
import ca.uhn.hl7v2.conf.classes.generator.builders.DeploymentManager;

/**
 * Maven Plugin Mojo for generating HAPI conformance classes
 * 
 * @author <a href="mailto:jamesagnew@sourceforge.net">James Agnew</a>
 * @goal confgen-classic
 * @phase generate-sources
 * @requiresDependencyResolution runtime
 * @requiresProject
 * @inheritedByDefault false
 */
public class ClassicConfGenMojo extends AbstractMojo
{
    
    /**
     * The maven project.
     * 
     * @parameter property="project"
     * @required
     * @readonly
     */
    private MavenProject project;

    
    /**
     * The target directory for the generated source
     * 
     * @parameter
     * @required
     */
    private String targetDirectory;


    /**
     * The conformance profile (XML file path) to use
     * 
     * @parameter
     * @required
     */
    private String profile;

    
    /**
     * The package for the generated source
     * 
     * @parameter
     * @required
     */
    private String packageName;
    
    
    /**
     * {@inheritDoc}
     */
    public void execute() throws MojoExecutionException, MojoFailureException {

    	try {
    		String profileString;
			FileReader reader = new FileReader(profile);
			profileString = IOUtil.toString(reader);
			
	    	DeploymentManager dm = new DeploymentManager(targetDirectory, packageName);
	    	dm.generate(profileString);

		} catch (FileNotFoundException e) {
			throw new MojoExecutionException(e.getMessage(), e);
		} catch (IOException e) {
			throw new MojoExecutionException(e.getMessage(), e);
		} catch (ConformanceException e) {
			throw new MojoExecutionException(e.getMessage(), e);
		}
		
        project.addCompileSourceRoot(targetDirectory);

    }

}
