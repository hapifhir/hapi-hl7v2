/*
 * Created on 28-Apr-2004
 */
package ca.uhn.hl7v2.preparser.tests;

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

import ca.uhn.hl7v2.preparser.PreParser;


/**
 * Unit tests of PreParser with ER7-encoded messages. 
 * 
 * @author <a href="mailto:bryan.tripp@uhn.on.ca">Bryan Tripp</a>
 * @version $Revision: 1.2 $ updated on $Date: 2009-09-15 12:11:20 $ by $Author: jamesagnew $
 * @author Niranjan Sharma niranjan.sharma@med.ge.com This testcase has been
 *         extended for OSGI environment using Junit4 and PAX-Exam.
 */
@RunWith(JUnit4TestRunner.class)
public class PreParserER7Test  {

 // you get that because you "installed" a log profile in configuration.
    public Log logger = LogFactory.getLog(PreParserER7Test.class);
    
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
    
    private String myMessage;
        
    @Before
    public void BeforeTheTest() {
        myMessage = "MSH|^~\\&|x|x|x|x|199904140038||ADT^A01||P|2.2\r"
            + "PID|||||Smith&Booth&Jones^X^Y\r"
            + "NTE|a||one~two~three\r"
            + "NTE|b||four\r";
    }
   
    
   
    
    @Test
    public void testFirstSegmentRep() throws Exception {
        String[] result = PreParser.getFields(myMessage, new String[]{"NTE(0)-1"});
        assertEquals("a", result[0]);
    }
    
    @Test
    public void testSecondSegmentRep() throws Exception  {
        String[] result = PreParser.getFields(myMessage, new String[]{"NTE(1)-1"});
        assertEquals("b", result[0]);        
    }

    @Test
    public void testFirstFieldRep() throws Exception  {
        String[] result = PreParser.getFields(myMessage, new String[]{"NTE-3(0)"});
        assertEquals("one", result[0]);        
    }
    
    @Test
    public void testSecondFieldRep() throws Exception  {
        String[] result = PreParser.getFields(myMessage, new String[]{"NTE-3(1)"});
        assertEquals("two", result[0]);                
    }
    
    @Test
    public void testFirstCompSubcompInexplicit() throws Exception  {
        String[] result = PreParser.getFields(myMessage, new String[]{"PID-5"});
        assertEquals("Smith", result[0]);         
    }
    
    @Test
    public void testFirstCompSubcompExplicit() throws Exception  {
        String[] result = PreParser.getFields(myMessage, new String[]{"PID-5-1-1"});
        assertEquals("Smith", result[0]);         
    }
    
    @Test
    public void testSecondComp() throws Exception  {
        String[] result = PreParser.getFields(myMessage, new String[]{"MSH-9-2"});
        assertEquals("A01", result[0]);                
    }
    
    @Test
    public void testSecondSubcomp() throws Exception  {
        String[] result = PreParser.getFields(myMessage, new String[]{"PID-5-1-2"});
        assertEquals("Booth", result[0]);                
    }
    
}
