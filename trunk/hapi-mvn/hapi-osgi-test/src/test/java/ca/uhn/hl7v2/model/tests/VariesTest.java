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
import ca.uhn.hl7v2.model.Varies;
import ca.uhn.hl7v2.model.v24.datatype.CE;
import ca.uhn.hl7v2.parser.DefaultXMLParser;
import ca.uhn.hl7v2.parser.EncodingCharacters;
import ca.uhn.hl7v2.parser.Parser;


/**
 * A JUnit test harness for Varies 
 * @author Bryan Tripp
 * @author Niranjan Sharma niranjan.sharma@med.ge.com This testcase has been
 *         extended for OSGI environment using Junit4 and PAX-Exam.
 */
@RunWith(JUnit4TestRunner.class)
public class VariesTest {
    // you get that because you "installed" a log profile in configuration.
    public Log logger = LogFactory.getLog(VariesTest.class);
    
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
    
    private Parser parser = null;
    private EncodingCharacters ec = null;
    
    @Before
    public void BeforeTheTest() throws Exception {
        this.parser = new DefaultXMLParser();
        ec = new EncodingCharacters('|', "^~\\&");
    }
    
    @Test
    public void testParse() throws HL7Exception {
        Varies varies = new Varies(null);
        CE data = new CE(null);
        data.getIdentifier().setValue("foo");
        varies.setData(data);
        assertEquals("foo", ((CE)varies.getData()).getIdentifier().getValue()); //existing primitive will NOT copy over "foo" as of Nov 2002
        data.getIdentifier().setValue("foo");
        assertEquals("foo", ((CE)varies.getData()).getIdentifier().getValue()); 
    }
    
}
