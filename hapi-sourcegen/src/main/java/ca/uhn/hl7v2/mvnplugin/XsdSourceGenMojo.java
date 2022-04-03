/**
 * The contents of this file are subject to the Mozilla Public License Version 1.1
 * (the "License"); you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at http://www.mozilla.org/MPL/
 * Software distributed under the License is distributed on an "AS IS" basis,
 * WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the
 * specific language governing rights and limitations under the License.
 * <p>
 * The Original Code is "DataTypeGenerator.java".  Description:
 * "Generates skeletal source code for Datatype classes based on the
 * HL7 database"
 * <p>
 * The Initial Developer of the Original Code is University Health Network. Copyright (C)
 * 2001.  All Rights Reserved.
 * <p>
 * Contributor(s):  James Agnew
 * <p>
 * Alternatively, the contents of this file may be used under the terms of the
 * GNU General Public License (the  �GPL�), in which case the provisions of the GPL are
 * applicable instead of those above.  If you wish to allow use of your version of this
 * file only under the terms of the GPL and not to allow others to use your version
 * of this file under the MPL, indicate your decision by deleting  the provisions above
 * and replace  them with the notice and other provisions required by the GPL License.
 * If you do not delete the provisions above, a recipient may use your version of
 * this file under either the MPL or the GPL.
 */

package ca.uhn.hl7v2.mvnplugin;

import ca.uhn.hl7v2.sourcegen.XsdSourceGenerator;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.project.MavenProject;

import java.io.File;
import java.util.HashSet;
import java.util.Set;

/**
 * Maven Plugin Mojo for generating HAPI HL7 message/segment/etc source files
 *
 * @author <a href="mailto:jamesagnew@sourceforge.net">James Agnew</a>
 * @goal xsdsourcegen
 * @phase generate-sources
 * @requiresDependencyResolution runtime
 * @requiresProject
 * @inheritedByDefault false
 */
public class XsdSourceGenMojo extends AbstractMojo {
    private static final Set<String> alreadyMade = new HashSet<>();

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
     * The target directory for the generated resources
     *
     * @parameter
     * @required
     */
    private String targetResourceDirectory;

    /**
     * The version for the generated source
     *
     * @parameter
     */
    private String version;

    /**
     * The file
     *
     * @parameter
     */
    private String archiveFile;

    /**
     * The password for decrypting the schema sources
     *
     * @parameter
     */
    private String password;

    /**
     * Should we use the default group names on v2.3.1
     *
     * @parameter
     */
    private boolean forceGroupNames;

    /**
     * Should build be skipped
     *
     * @parameter
     */
    private boolean skip;

    /**
     * The package from which to load the templates
     *
     * @parameter default="ca.uhn.hl7v2.sourcegen.templates"
     */
    private final String templatePackage = "ca.uhn.hl7v2.sourcegen.templates";

    /**
     * Should structures be treated as resources
     *
     * @parameter default="false"
     */
    private boolean structuresAsResources;

    /**
     * {@inheritDoc}
     */
    public void execute() throws MojoExecutionException {

        if (skip) {
            getLog().warn("Configured to skip");
        }

        if (forceGroupNames) {
            System.setProperty("force.group", "true");
        } else {
            System.setProperty("force.group", "false");
        }

        if (new File(targetDirectory).exists()) {
            getLog().warn("Already exists version " + version + ", skipping!");
        } else if (!alreadyMade.contains(version)) {

            // I haven't entirely figured out why, but Maven runs this plugin
            // several times for each version, which takes forever, so we assume
            // that if the directory exists, we don't need to generate again
            alreadyMade.add(version);

            try {
                String targetDir = structuresAsResources ? targetResourceDirectory : targetDirectory;
                XsdSourceGenerator.makeAll(templatePackage, targetDir, targetResourceDirectory, version, password.toCharArray());
            } catch (Exception e) {
                throw new MojoExecutionException("Failed to build source ", e);
            }

        } else {
            getLog().warn("Already made version " + version + ", skipping!");
        }

        if (!structuresAsResources) {
            getLog().info("Adding " + targetDirectory + " to compile source root");
            project.addCompileSourceRoot(targetDirectory);
        }
    }

}
