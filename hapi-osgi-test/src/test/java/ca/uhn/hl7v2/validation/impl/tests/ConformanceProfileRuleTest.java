/*
 * Created on 27-Jun-2005
 */
package ca.uhn.hl7v2.validation.impl.tests;

import static org.junit.Assert.assertEquals;
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

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

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

import ca.uhn.hl7v2.conf.parser.ProfileParser;
import ca.uhn.hl7v2.conf.store.ProfileStoreFactory;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.parser.Parser;
import ca.uhn.hl7v2.parser.PipeParser;
import ca.uhn.hl7v2.validation.ValidationException;
import ca.uhn.hl7v2.validation.impl.ConformanceProfileRule;


/**
 * Unit tests for ConformanceProfileRule. 
 * 
 * @author <a href="mailto:bryan.tripp@uhn.on.ca">Bryan Tripp</a>
 * @version $Revision: 1.2 $ updated on $Date: 2009-09-15 12:11:18 $ by $Author: jamesagnew $
 * @author Niranjan Sharma niranjan.sharma@med.ge.com This testcase has been
 *         extended for OSGI environment using Junit4 and PAX-Exam.
 */


@RunWith(JUnit4TestRunner.class)
public class ConformanceProfileRuleTest {

    // you get that because you "installed" a log profile in configuration.
    public Log logger = LogFactory.getLog(ConformanceProfileRuleTest.class);
    
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
    
    
    private static String PROFILE_ID = "TestProfile";
    
    private ConformanceProfileRule myRule1;
    private ConformanceProfileRule myRule2;
    
    @Before
    public void BeforeTheTes() throws Exception {
        
        myRule1 = new ConformanceProfileRule(PROFILE_ID);
        myRule2 = new ConformanceProfileRule();
        addProfileToStore();
    }


    @Test
    public void testTest() throws Exception {
        Parser p = new PipeParser();        
        Message m1 = p.parse(getMessage1());
        Message m2 = p.parse(getMessage2());
        Message m3 = p.parse(getMessage3());
        
        ValidationException[] errors = myRule1.test(m1);
        assertEquals(10, errors.length);
        
        errors = myRule1.test(m2);
        assertEquals(9, errors.length);
        
        errors = myRule1.test(m3);
        assertEquals(6, errors.length);
        
        errors = myRule2.test(m1);
        assertEquals(10, errors.length);
        
        errors = myRule2.test(m2);
        assertEquals(0, errors.length);
        
        errors = myRule2.test(m3);
        assertEquals(12, errors.length); //gets tested twice
    }
    
    private void addProfileToStore() throws Exception {
        InputStream instream = ProfileParser.class.getClassLoader().getResourceAsStream("ca/uhn/hl7v2/conf/parser/tests/example_ack.xml");
        BufferedReader in = new BufferedReader(new InputStreamReader(instream));
        StringBuffer profile = new StringBuffer();
        int i;
        while ((i = in.read()) != -1) {
            profile.append( (char) i );
        }
        in.close();
        
        ProfileStoreFactory.getProfileStore().persistProfile(PROFILE_ID, profile.toString());
    }

    private String getMessage1() {
        return "MSH|^~\\&|Fake Sending App|Fake Sending Facility||Fake Receiving Facility|200108151718||ACK^A01^ACK|20|P|2.4|||||||||TestProfile|\rMSA|AA\r";
    }

    private String getMessage2() {
        return "MSH|^~\\&|Fake Sending App|Fake Sending Facility||Fake Receiving Facility|200108151718||ACK^A01^ACK|20|P|2.4||||||||||\rMSA|AA\r";
    }

    private String getMessage3() {
        return "MSH|^~\\&|A|B||C|||ACK^A01^ACK|20|P|2.4|||||||||TestProfile~TestProfile|\rMSA|AA|1\r";
    }
}
