package ca.uhn.hl7v2.parser.tests;

import static org.ops4j.pax.exam.CoreOptions.equinox;
import static org.ops4j.pax.exam.CoreOptions.felix;
import static org.ops4j.pax.exam.CoreOptions.frameworks;
import static org.ops4j.pax.exam.CoreOptions.knopflerfish;
import static org.ops4j.pax.exam.CoreOptions.mavenBundle;
import static org.ops4j.pax.exam.CoreOptions.options;
import static org.ops4j.pax.exam.CoreOptions.systemProperty;
import static org.ops4j.pax.exam.CoreOptions.wrappedBundle;
import static org.ops4j.pax.exam.container.def.PaxRunnerOptions.logProfile;

import java.io.*;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.ops4j.pax.exam.Inject;
import org.ops4j.pax.exam.Option;
import org.ops4j.pax.exam.junit.Configuration;
import org.ops4j.pax.exam.junit.JUnit4TestRunner;
import org.osgi.framework.BundleContext;

import ca.uhn.hl7v2.parser.EncodingCharacters;
import ca.uhn.hl7v2.parser.Escape;

/**
 * JUnit test cases for Escape.
 * 
 * @author bryan
 * @author Niranjan Sharma niranjan.sharma@med.ge.com This testcase has been
 *         extended for OSGI environment using Junit4 and PAX-Exam.
 */

@RunWith(JUnit4TestRunner.class)
public class EscapeTest {
    
    // you get that because you "installed" a log profile in configuration.
    public Log logger = LogFactory.getLog(EscapeTest.class);
    
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
    
    private EncodingCharacters enc;
    
    @Before
    public void BeforeTheTest() {
	this.enc = new EncodingCharacters('|', null);
    }
    
    @After
    public void AfterTheTest() {
	this.enc = null;
    }
    
    @Test
    public void testUnescape() throws Exception {
	String uu = getUuencodedEscapedString();
	String result = Escape.unescape(uu, enc);
	// System.out.println(uu);
	// System.out.println(result);
	// BufferedWriter out = new BufferedWriter(new
	// FileWriter("c:/hapi/foo.txt"));
	// out.write(result);
	// out.close();
    }
    
    /**
     * Loads an escaped, uuencoded string from a file -- this is real data
     * provided by Mark Lee of Skeva Tech.
     */
    
    
    private String getUuencodedEscapedString() throws IOException {
	ClassLoader loader = this.getClass().getClassLoader();
	InputStream inStream = loader.getResourceAsStream("ca/uhn/hl7v2/parser/tests/uuencoded_escaped.txt");
	BufferedReader in = new BufferedReader(new InputStreamReader(inStream));
	String line = null;
	StringBuffer content = new StringBuffer();
	while ((line = in.readLine()) != null) {
	    content.append(line);
	}
	in.close();
	return content.toString();
    }
    
    /**
     * Loads a uuencoded string from a file (not escaped) -- this is real data
     * provided by Mark Lee of Skeva Tech.
     */

    private String getUuencodedString() throws IOException {
	ClassLoader loader = this.getClass().getClassLoader();
	InputStream inStream = loader.getResourceAsStream("ca/uhn/hl7v2/parser/tests/uuencoded.txt");
	BufferedReader in = new BufferedReader(new InputStreamReader(inStream));
	String line = null;
	StringBuffer content = new StringBuffer();
	while ((line = in.readLine()) != null) {
	    content.append(line);
	}
	in.close();
	return content.toString();
    }
    
}
