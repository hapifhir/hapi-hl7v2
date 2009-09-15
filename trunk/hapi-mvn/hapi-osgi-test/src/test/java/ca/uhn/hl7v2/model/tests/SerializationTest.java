package ca.uhn.hl7v2.model.tests;

import static org.junit.Assert.assertEquals;
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
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.ops4j.pax.exam.Inject;
import org.ops4j.pax.exam.Option;
import org.ops4j.pax.exam.junit.Configuration;
import org.ops4j.pax.exam.junit.JUnit4TestRunner;
import org.osgi.framework.BundleContext;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.parser.EncodingNotSupportedException;
import ca.uhn.hl7v2.parser.Parser;
import ca.uhn.hl7v2.parser.ng.NewPipeParser;
/**
* @author Niranjan Sharma niranjan.sharma@med.ge.com This testcase has been
*         extended for OSGI environment using Junit4 and PAX-Exam.
*/
@RunWith(JUnit4TestRunner.class)
public class SerializationTest {

        // you get that because you "installed" a log profile in configuration.
        public Log logger = LogFactory.getLog(SerializationTest.class);
        
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
    	public void testSerialization() throws EncodingNotSupportedException, HL7Exception, IOException, ClassNotFoundException {

		String message = "MSH|^~\\&|IRIS|SANTER|AMB_R|SANTER|200803051508||ADT^A03|263206|P|2.5\r"
				+ "EVN||200803051509||||200803031508\r"
				+ "PID|||5520255^^^PK^PK~ZZZZZZ83M64Z148R^^^CF^CF~ZZZZZZ83M64Z148R^^^SSN^SSN^^20070103^99991231~^^^^TEAM||ZZZ^ZZZ||19830824|F||||||||||||||||||||||N\r"
				+ "PV1||I|6402DH^^^^^^^^MED. 1 - ONCOLOGIA^^OSPEDALE MAGGIORE DI LODI&LODI|||^^^^^^^^^^OSPEDALE MAGGIORE DI LODI&LODI|13936^TEST^TEST||||||||||5068^TEST2^TEST2||2008003369||||||||||||||||||||||||||200803031508\r"
				+ "PR1|1||1111^Mastoplastica|Protesi|20090224|02\r";

		Parser p = new NewPipeParser();
		Message parsed = p.parse(message);

		ByteArrayOutputStream os = new ByteArrayOutputStream();
		new ObjectOutputStream(os).writeObject(parsed);

		ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(os.toByteArray()));
		Message deser = (Message) ois.readObject();

		String actual = p.encode(deser);

		System.out.println(message);
		System.out.println();
		System.out.println(actual);
		
		assertEquals(message, actual);
	}
}
