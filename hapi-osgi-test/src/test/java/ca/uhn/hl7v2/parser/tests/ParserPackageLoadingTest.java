/**
The contents of this file are subject to the Mozilla Public License Version 1.1 
(the "License"); you may not use this file except in compliance with the License. 
You may obtain a copy of the License at http://www.mozilla.org/MPL/ 
Software distributed under the License is distributed on an "AS IS" basis, 
WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the 
specific language governing rights and limitations under the License. 

The Original Code is "DBTableRepository.java".  Description: 
"Implements TableRepository by looking up values from the default HL7
  normative database" 

The Initial Developer of the Original Code is University Health Network. Copyright (C) 
2001.  All Rights Reserved. 

Contributor(s): ______________________________________. 

Alternatively, the contents of this file may be used under the terms of the 
GNU General Public License (the  “GPL”), in which case the provisions of the GPL are 
applicable instead of those above.  If you wish to allow use of your version of this 
file only under the terms of the GPL and not to allow others to use your version 
of this file under the MPL, indicate your decision by deleting  the provisions above 
and replace  them with the notice and other provisions required by the GPL License.  
If you do not delete the provisions above, a recipient may use your version of 
this file under either the MPL or the GPL. 
*/
package ca.uhn.hl7v2.parser.tests;

import static org.junit.Assert.assertArrayEquals;
import static org.ops4j.pax.exam.CoreOptions.equinox;
import static org.ops4j.pax.exam.CoreOptions.felix;
import static org.ops4j.pax.exam.CoreOptions.frameworks;
import static org.ops4j.pax.exam.CoreOptions.knopflerfish;
import static org.ops4j.pax.exam.CoreOptions.mavenBundle;
import static org.ops4j.pax.exam.CoreOptions.options;
import static org.ops4j.pax.exam.CoreOptions.systemProperty;
import static org.ops4j.pax.exam.CoreOptions.wrappedBundle;
import static org.ops4j.pax.exam.container.def.PaxRunnerOptions.logProfile;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.text.MessageFormat;

import junitx.util.PrivateAccessor;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.ops4j.pax.exam.Inject;
import org.ops4j.pax.exam.Option;
import org.ops4j.pax.exam.junit.Configuration;
import org.ops4j.pax.exam.junit.JUnit4TestRunner;
import org.osgi.framework.BundleContext;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.parser.DefaultModelClassFactory;
import ca.uhn.hl7v2.parser.mock.tests.MockClassLoader;


/**
 * Test the package list loading from the classpath.  
 * 
 * @author <a href="mailto:alexei.guevara@uhn.on.ca">Alexei Guevara</a>
 * @version $Revision: 1.2 $ updated on $Date: 2009-09-15 12:11:18 $ by $Author: jamesagnew $
 * @author Niranjan Sharma niranjan.sharma@med.ge.com This testcase has been
 *         extended for OSGI environment using Junit4 and PAX-Exam.
 */
@RunWith(JUnit4TestRunner.class)
public class ParserPackageLoadingTest {
    
    // you get that because you "installed" a log profile in configuration.
    public Log logger = LogFactory.getLog(ParserPackageLoadingTest.class);
    
    
    @Inject
    BundleContext bundleContext;
    
    @Configuration
    public static Option[] configure() {
	return options(frameworks(equinox(), felix(), knopflerfish())
		, logProfile()
		, systemProperty("org.ops4j.pax.logging.DefaultServiceLog.level").value("INFO")
		, mavenBundle().groupId("org.ops4j.pax.url").artifactId("pax-url-mvn").version("0.4.0")
		, wrappedBundle(mavenBundle().groupId("org.ops4j.base").artifactId("ops4j-base-util").version("0.5.3"))
		, mavenBundle().groupId("ca.uhn.hapi").artifactId("hapi-osgi-base").version("1.0-beta1")
//		, vmOption("-Xrunjdwp:transport=dt_socket,server=y,suspend=y,address=5006" )


	);
    } 
    
    
    private String myPackageListResourceNameTemplate;

    @Before
    public void BeforeTheTest() throws NoSuchFieldException {
	//avoid code duplication using the private accessor.
    	myPackageListResourceNameTemplate =
    		(String) PrivateAccessor.getField( DefaultModelClassFactory.class, "CUSTOM_PACKAGES_RESOURCE_NAME_TEMPLATE" );
    }
	
    
	/*
	 * not a test case
	 */
    @Test
    public void testPackageList( String theVersion ) throws HL7Exception, NoSuchFieldException {
    	
    	String versionPackage1 = "foo.bar.1"; 
    	String versionPackage2 = "foo.bar.2";
    	String versionPackage3 = "foo.bar.3";
    	
    	String packageListResourceName = 
    		MessageFormat.format( myPackageListResourceNameTemplate, new Object[] { theVersion } );
    	 
    	InputStream packageListStream =
	    	new ByteArrayInputStream(
	    		(versionPackage1 + "\n" +
				 versionPackage2 + "\n" +
				 versionPackage3).getBytes()
	    	);
    	
    	ClassLoader mockClassLoader = new MockClassLoader( packageListResourceName, packageListStream );
        
        Thread.currentThread().setContextClassLoader( mockClassLoader );
        
        DefaultModelClassFactory.reloadPackages();
        String[] packages = DefaultModelClassFactory.packageList( theVersion );
        
        String[] expectedPackages = 
        	new String[] { 
        		versionPackage1, 
        		versionPackage2, 
        		versionPackage3, 
        		DefaultModelClassFactory.getVersionPackageName(theVersion) };
        
        assertArrayEquals("Package Mismatch", expectedPackages, packages);
    }
    
    @Test
    public void testPackageListV2_1() throws Exception {
    	testPackageList( "2.1" );
    }

    @Test
    public void testPackageListV2_2() throws Exception {
    	testPackageList( "2.2" );
    }

    @Test
    public void testPackageListV2_3() throws Exception {
    	testPackageList( "2.3" );
    }

    @Test
    public void testPackageListV2_3_1() throws Exception {
    	testPackageList( "2.3.1" );
    }

    @Test
    public void testPackageListV2_4() throws Exception {
    	testPackageList( "2.4" );
    }
    
    @Test
    public void testPackageListV2_5() throws Exception {
    	testPackageList( "2.5" );
    }

    @Test
    public void testPackageListV2_5_1() throws Exception {
    	testPackageList( "2.5.1" );
    }
    
    @Test
    public void testPackageListV2_6() throws Exception {
    	testPackageList( "2.6" );
    }
}