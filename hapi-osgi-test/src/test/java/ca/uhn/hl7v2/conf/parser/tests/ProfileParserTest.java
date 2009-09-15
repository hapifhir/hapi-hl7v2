package ca.uhn.hl7v2.conf.parser.tests;

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
import java.net.URLConnection;

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
import ca.uhn.hl7v2.conf.spec.RuntimeProfile;
import ca.uhn.hl7v2.conf.spec.message.Component;
import ca.uhn.hl7v2.conf.spec.message.Field;
import ca.uhn.hl7v2.conf.spec.message.Seg;
import ca.uhn.hl7v2.conf.spec.message.StaticDef;
import ca.uhn.hl7v2.conf.spec.message.SubComponent;
import ca.uhn.hl7v2.util.tests.MessageLibrary;

/**
 * JUnit tests for conformance profile parser 
 * @author bryan
 * @author Niranjan Sharma niranjan.sharma@med.ge.com This testcase has been
 *         extended for OSGI environment using Junit4 and PAX-Exam.
 */
@RunWith(JUnit4TestRunner.class)
public class ProfileParserTest{
    
    String profileString;
    
 // you get that because you "installed" a log profile in configuration.
    public Log logger = LogFactory.getLog(ProfileParserTest.class);
    
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
    
    @Before
    public void BeforeTheTest() throws Exception {
     
      	URL url = ProfileParserTest.class.getClassLoader().getResource("ca/uhn/hl7v2/conf/parser/tests/example_ack.xml");
    	URLConnection conn = url.openConnection();
    	InputStream instream = conn.getInputStream();           
        if (instream == null) throw new Exception("can't find the xml file");
        BufferedReader in = new BufferedReader(new InputStreamReader(instream));
        int tmp = 0;
        StringBuffer buf = new StringBuffer();
        while ((tmp = in.read()) != -1) {
            buf.append((char) tmp);
        }        
        profileString = buf.toString();
        //System.out.println(profileString);
    }
    
    @Test
    public void testParse() throws Exception {
        ProfileParser pp = new ProfileParser(true);
        RuntimeProfile rp = pp.parse(profileString);
        assertEquals("2.4", rp.getHL7Version());
        StaticDef p = rp.getMessage();
        
        assertEquals("ACK", p.getMsgType());
        assertEquals("ACK", p.getMsgStructID());
        assertTrue(p.getEventDesc().indexOf("general") > 1);
        
        Seg sp = (Seg) p.getChild(1);
        assertEquals("MSH", sp.getName());
        assertEquals("Message Header", sp.getLongName());
        assertEquals("R", sp.getUsage());
        assertEquals(1, sp.getMin());
        assertEquals(1, sp.getMax());
        Field fieldSep = sp.getField(1);
        assertEquals("Field Separator", fieldSep.getName());
        assertEquals("R", fieldSep.getUsage());
        assertEquals(1, fieldSep.getMin());
        assertEquals(1, fieldSep.getMax());
        assertEquals("ST", fieldSep.getDatatype());
        assertEquals(1, fieldSep.getLength());
        assertEquals(1, fieldSep.getItemNo());
        assertEquals("2.16.9.1", fieldSep.getReference());
        Field VID = sp.getField(12);
        Component vid = VID.getComponent(1);
        assertEquals("version ID", vid.getName());
        assertEquals("O", vid.getUsage());
        assertEquals("ID", vid.getDatatype());
        assertEquals(3, vid.getLength());
        assertEquals("0104", vid.getTable());
        assertEquals(3, VID.getComponents());
        assertEquals(6, VID.getComponent(2).getSubComponents());
        SubComponent name = VID.getComponent(2).getSubComponent(3);
        assertEquals("name of coding system", name.getName());        
        assertEquals("O", name.getUsage());
        assertEquals("IS", name.getDatatype());
        assertEquals(3, name.getLength());
        assertEquals("0396-X", name.getTable());

        sp = (Seg) p.getChild(2);
        assertEquals("MSA", sp.getName());

        sp = (Seg) p.getChild(3);
        assertEquals("ERR", sp.getName());
        
    }
        
    
}
