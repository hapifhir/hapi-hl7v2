package ca.uhn.hl7v2.conf.check.tests;

import static org.junit.Assert.assertEquals;
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

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

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
import ca.uhn.hl7v2.conf.check.DefaultValidator;
import ca.uhn.hl7v2.conf.parser.ProfileParser;
import ca.uhn.hl7v2.conf.spec.RuntimeProfile;
import ca.uhn.hl7v2.conf.spec.message.Seg;
import ca.uhn.hl7v2.conf.store.CodeStore;
import ca.uhn.hl7v2.conf.store.ProfileCodeStore;
import ca.uhn.hl7v2.conf.store.ProfileStoreFactory;
import ca.uhn.hl7v2.model.v24.message.ACK;
import ca.uhn.hl7v2.parser.PipeParser;

/**
 * JUnit tests for DefaultValidator
 * @author Bryan Tripp
 * @author Niranjan Sharma niranjan.sharma@med.ge.com This testcase has been
 *         extended for OSGI environment using Junit4 and PAX-Exam.
 */

@RunWith(JUnit4TestRunner.class)
public class DefaultValidatorTest {
    
    // you get that because you "installed" a log profile in configuration.
    public Log logger = LogFactory.getLog(DefaultValidatorTest.class);
    
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
    
    
    private RuntimeProfile profile;
    private ACK msg;
    

    @Before
    public void BeforeTheTest() throws Exception {
        ClassLoader cl = ProfileParser.class.getClassLoader();
        InputStream instream = cl.getResourceAsStream("ca/uhn/hl7v2/conf/parser/tests/example_ack.xml");
        if (instream == null) throw new Exception("can't find the xml file");
        BufferedReader in = new BufferedReader(new InputStreamReader(instream));
        int tmp = 0;
        StringBuffer buf = new StringBuffer();
        while ((tmp = in.read()) != -1) {
            buf.append((char) tmp);
        }        
        String profileString = buf.toString();
        //System.out.println(profileString);
        ProfileParser parser = new ProfileParser(false);
        profile = parser.parse(profileString);

        URL specURL = this.getClass().getClassLoader().getResource("ca/uhn/hl7v2/conf/store/tests/sampleTables.xml");
        CodeStore store = new ProfileCodeStore(specURL);
        ProfileStoreFactory.addCodeStore(store, ".*ConfSig.*"); //need qualifier to avoid collision with ProfileStoreFactpryTest    
        
        String message = "MSH|^~\\&|||||||ACK^A01|1|D|2.4|||||CAN|wrong|F^^HL70001^x^^HL78888|\r"; //note HL7888 doesn't exist
        msg =  (ACK) (new PipeParser()).parse(message);
    }    
    
    @Test
    public void testTableValidation() throws Exception {
        DefaultValidator v = new DefaultValidator();
        Seg mshProfile = (Seg) profile.getMessage().getChild(1);
        String profileID = "{ConfSig(1) CCO(1) 2.4(7) static-profile(1) ADT(3) A01(1) null(0) ADT_A01(4) HL7 2.4(1) Sender(1)}";

        HL7Exception[] e = v.testField(msg.getMSH().getCountryCode(), mshProfile.getField(17), false, profileID);
        printExceptions(e);
        assertEquals(0, e.length);
        
        //should return an exception saying that the code "wrong" is not found 
        e = v.testField(msg.getMSH().getCharacterSet(0), mshProfile.getField(18), false, profileID);
        assertEquals(1, e.length);        
        assertTrue(e[0].getMessage().indexOf("wrong") >= 0);
        
        e = v.testField(msg.getMSH().getPrincipalLanguageOfMessage(), mshProfile.getField(19), false, profileID);

        printExceptions(e);

        //HEY!  this will fail if something unrelated goes wrong ... check output of the above to see what it is
        assertEquals(0, e.length);
    }
    
    public void printExceptions(Exception[] e) {
        for (int i = 0; i < e.length; i++) {
            System.out.println(e[i].getClass().getName() + ": " + e[i].getMessage());
        }        
    }
    
}
