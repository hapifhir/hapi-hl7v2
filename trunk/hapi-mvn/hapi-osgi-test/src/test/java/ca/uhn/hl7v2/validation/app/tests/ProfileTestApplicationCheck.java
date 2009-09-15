package ca.uhn.hl7v2.validation.app.tests;

import static org.ops4j.pax.exam.CoreOptions.equinox;
import static org.ops4j.pax.exam.CoreOptions.felix;
import static org.ops4j.pax.exam.CoreOptions.frameworks;
import static org.ops4j.pax.exam.CoreOptions.knopflerfish;
import static org.ops4j.pax.exam.CoreOptions.mavenBundle;
import static org.ops4j.pax.exam.CoreOptions.options;
import static org.ops4j.pax.exam.CoreOptions.provision;
import static org.ops4j.pax.exam.CoreOptions.systemProperty;
import static org.ops4j.pax.exam.CoreOptions.wrappedBundle;
import static org.ops4j.pax.exam.container.def.PaxRunnerOptions.logProfile;
import static org.ops4j.pax.exam.container.def.PaxRunnerOptions.scanDir;
import static org.ops4j.pax.exam.container.def.PaxRunnerOptions.vmOption;
import static org.junit.Assert.*;


import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.ops4j.pax.exam.Inject;
import org.ops4j.pax.exam.Option;
import org.ops4j.pax.exam.junit.Configuration;
import org.ops4j.pax.exam.junit.JUnit4TestRunner;
import org.osgi.framework.BundleContext;

import ca.uhn.hl7v2.conf.parser.ProfileParser;
import ca.uhn.hl7v2.conf.store.ProfileStoreFactory;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.parser.PipeParser;
import ca.uhn.hl7v2.util.tests.MessageLibrary;
import ca.uhn.hl7v2.validation.app.ProfileTestApplication;

/**
 * Test case for ProfileTestApplication -- note this requires checking logs so it 
 * isn't self-verifying and isn't a JUnit test.  
 * @author Niranjan Sharma niranjan.sharma@med.ge.com This testcase has been
 *         extended for OSGI environment using Junit4 and PAX-Exam.
 */
@RunWith(JUnit4TestRunner.class)
public class ProfileTestApplicationCheck {
    
    // you get that because you "installed" a log profile in configuration.
    public Log logger = LogFactory.getLog(ProfileTestApplicationCheck.class);
    
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
    public void testProcessMessage() throws Exception {
        ProfileTestApplication app = new ProfileTestApplication();
        addProfileToStore();
        app.processMessage(getTestMessage());            
        System.out.println("Note: profile exception messages should have been logged as per log4j setup");
    }
    
    
    private void addProfileToStore() throws Exception {
        
        URL url = ProfileParser.class.getClassLoader().getResource("ca/uhn/hl7v2/conf/parser/tests/example_ack.xml");
    	URLConnection conn = url.openConnection();
    	BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        StringBuffer profile = new StringBuffer();
        int i;
        while ((i = in.read()) != -1) {
            profile.append( (char) i );
        }
        in.close();
        
        ProfileStoreFactory.getProfileStore().persistProfile("TestProfile", profile.toString());
    }
    
    private Message getTestMessage() throws Exception {
        String message = "MSH|^~\\&|Fake Sending App|Fake Sending Facility||Fake Receiving Facility|200108151718||ACK^A01^ACK|20|P|2.4|||||||||TestProfile|\rMSA|AA\r";
        PipeParser p = new PipeParser();
        return p.parse(message);
    }
    
    public static void main(String args[]) {
        try {
            //System.setProperty("log4j.configuration", "c:/hapi/log4j.xml");
            //System.out.println("log4j.configuration: " + System.getProperty("log4j.configuration"));            
            ProfileTestApplicationCheck check = new ProfileTestApplicationCheck();
            check.testProcessMessage();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
