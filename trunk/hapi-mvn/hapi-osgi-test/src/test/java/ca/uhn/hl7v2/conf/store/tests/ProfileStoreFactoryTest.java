package ca.uhn.hl7v2.conf.store.tests;

import static org.junit.Assert.assertTrue;
import static org.ops4j.pax.exam.CoreOptions.equinox;
import static org.ops4j.pax.exam.CoreOptions.felix;
import static org.ops4j.pax.exam.CoreOptions.frameworks;
import static org.ops4j.pax.exam.CoreOptions.knopflerfish;
import static org.ops4j.pax.exam.CoreOptions.mavenBundle;
import static org.ops4j.pax.exam.CoreOptions.options;
import static org.ops4j.pax.exam.CoreOptions.systemProperty;
import static org.ops4j.pax.exam.CoreOptions.wrappedBundle;
import static org.ops4j.pax.exam.container.def.PaxRunnerOptions.logProfile;

import java.net.URL;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.ops4j.pax.exam.Inject;
import org.ops4j.pax.exam.Option;
import org.ops4j.pax.exam.junit.Configuration;
import org.ops4j.pax.exam.junit.JUnit4TestRunner;
import org.osgi.framework.BundleContext;

import ca.uhn.hl7v2.conf.store.CodeStore;
import ca.uhn.hl7v2.conf.store.ProfileCodeStore;
import ca.uhn.hl7v2.conf.store.ProfileStoreFactory;

/**
 * JUnit test cases for ProfileStoreFactory 
 * @author Bryan Tripp
 * @author Niranjan Sharma niranjan.sharma@med.ge.com This testcase has been
 *         extended for OSGI environment using Junit4 and PAX-Exam.
 */
@RunWith(JUnit4TestRunner.class)
public class ProfileStoreFactoryTest {
     
 // you get that because you "installed" a log profile in configuration.
    public Log logger = LogFactory.getLog(ProfileStoreFactoryTest.class);
    
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
    
    

    @Test
    public void testCodeStoreRegistration() throws Exception {
        URL specURLAll = this.getClass().getClassLoader().getResource("ca/uhn/hl7v2/conf/store/tests/sampleTables.xml");        
	URL specURL1 = this.getClass().getClassLoader().getResource("ca/uhn/hl7v2/conf/store/tests/sampleTable1.xml");        
	URL specURL61 = this.getClass().getClassLoader().getResource("ca/uhn/hl7v2/conf/store/tests/sampleTable61.xml");        
        CodeStore cs1 = new ProfileCodeStore(specURLAll);
        CodeStore cs2 = new ProfileCodeStore(specURL1);
        CodeStore cs3 = new ProfileCodeStore(specURL61);
        
        ProfileStoreFactory.addCodeStore(cs1, "foo"); //for foo profile
        ProfileStoreFactory.addCodeStore(cs2, ".*test.*"); 
        ProfileStoreFactory.addCodeStore(cs3);  //for all profiles
        
        CodeStore codeStore = ProfileStoreFactory.getCodeStore("foo", "HL70001");
        assertTrue(codeStore.knowsCodes("HL70396"));
        
        assertTrue( ! ProfileStoreFactory.getCodeStore("xxxtestxxx", "HL70001").knowsCodes("HL70061") );
        assertTrue( ! ProfileStoreFactory.getCodeStore("xxx", "HL70061").knowsCodes("HL70001"));
        assertTrue(null == ProfileStoreFactory.getCodeStore("xxx", "xxx"));
        
    }
}
