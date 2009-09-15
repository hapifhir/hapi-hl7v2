/**
 * The contents of this file are subject to the Mozilla Public License Version 1.1
 * (the "License"); you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at http://www.mozilla.org/MPL/
 * Software distributed under the License is distributed on an "AS IS" basis,
 * WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the
 * specific language governing rights and limitations under the License.
 *
 * The Original Code is "MinLowerLayerProtocolTest.java".  Description:
 * "Unit test class for ca.uhn.hl7v2.llp.tests.MinLowerLayerProtocol"
 *
 * The Initial Developer of the Original Code is Leslie Mann. Copyright (C)
 * 2002.  All Rights Reserved.
 *
 * Contributor(s): ______________________________________.
 *
 * Alternatively, the contents of this file may be used under the terms of the
 * GNU General Public License (the  �GPL�), in which case the provisions of the GPL are
 * applicable instead of those above.  If you wish to allow use of your version of this
 * file only under the terms of the GPL and not to allow others to use your version
 * of this file under the MPL, indicate your decision by deleting  the provisions above
 * and replace  them with the notice and other provisions required by the GPL License.
 * If you do not delete the provisions above, a recipient may use your version of
 * this file under either the MPL or the GPL.
 *
 */
package ca.uhn.hl7v2.llp.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
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
import java.io.PrintStream;

import junit.framework.TestCase;

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

import ca.uhn.hl7v2.llp.HL7Reader;
import ca.uhn.hl7v2.llp.HL7Writer;
import ca.uhn.hl7v2.llp.LLPException;
import ca.uhn.hl7v2.llp.LowerLayerProtocol;
import ca.uhn.hl7v2.llp.MinLowerLayerProtocol;

/**
 * Unit test class for ca.uhn.hl7v2.llp.tests.MinLowerLayerProtocol
 * 
 * @author Leslie Mann
 * @author Niranjan Sharma niranjan.sharma@med.ge.com This testcase has been
 *         extended for OSGI environment using Junit4 and PAX-Exam.
 */

@RunWith(JUnit4TestRunner.class)
public class MinLowerLayerProtocolTest {
    
    // you get that because you "installed" a log profile in configuration.
    public Log logger = LogFactory.getLog(MinLowerLayerProtocolTest.class);
    
    // NB: Per the minimal lower layer protocol.
    // character indicating the termination of an HL7 message
    private static final char END_MESSAGE = '\u001c';
    // character indicating the start of an HL7 message
    private static final char START_MESSAGE = '\u000b';
    // the final character of a message: a carriage return
    private static final char LAST_CHARACTER = 13;
    
    private static MinLowerLayerProtocol minLowerLayerProtocol;
    private static ByteArrayInputStream inputStream;
    private static ByteArrayOutputStream outputStream;
    private static String message;
    private static byte[] llpEncodedMessage;
    
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
    
    /**
     * @see TestCase#setUp()
     */
    
    @Before
    public void BeforeTheTest() throws Exception {
	logger.info("*****************************BeforeTheTest******************************************");
	System.setProperty("ca.uhn.hl7v2.llp.tests.logBytesRead", "FALSE");
	System.setProperty("ca.uhn.hl7v2.util.tests.tests.status.out", "");
	minLowerLayerProtocol = new MinLowerLayerProtocol();
	message = "This is a test HL7 message";
	llpEncodedMessage = (START_MESSAGE + message + END_MESSAGE + LAST_CHARACTER).getBytes();
	inputStream = new ByteArrayInputStream(llpEncodedMessage);
	outputStream = new ByteArrayOutputStream();
    }
    
    /**
     * @see TestCase#tearDown()
     */
    
    @After
    public void AfterTheTest() throws Exception {
	logger.info("*****************************AfterTheTest******************************************");
	minLowerLayerProtocol = null;
	message = null;
	llpEncodedMessage = null;
	inputStream = null;
	outputStream = null;
    }
    
    /*
     * ********************************************************* Test Cases
     * *********************************************************
     */

    @Test
    public void TestCtx() {
	System.out.println("*****************************BundleContext is Good******************************************");
	assertNotNull("Bundle Context is Null", bundleContext);
    }
    
    /**
     * Testing default constructor
     */
    @Test
    public void testConstructor() {
	assertNotNull("Should have a MinLowerLayerProtocol object", minLowerLayerProtocol);
    }
    
    /**
     * Testing getReader
     */
    @Test
    public void testGetReader() throws LLPException {
	HL7Reader reader = minLowerLayerProtocol.getReader(inputStream);
	assertNotNull("Should have a valid HL7Reader object", reader);
    }
    
    /**
     * Testing getWriter
     */
    @Test
    public void testGetWriter() throws LLPException {
	HL7Writer writer = minLowerLayerProtocol.getWriter(outputStream);
	assertNotNull("Should have a valid HL7Writer object", writer);
    }
    
    /**
     * Testing subclass MakeLLP() method
     */
    @Test
    public void testMakeLLP() {
	LowerLayerProtocol lowerLayerProtocol = MinLowerLayerProtocol.makeLLP();
	assertNotNull("Should have a valid LowerLayerProtocol object", lowerLayerProtocol);
    }
    
    /**
     * Testing subclass LogCharacterReceived() method
     */
    public void testLogCharacterReceived() {
	int c = 'A';
	
	// Set properties to generate a status message
	System.setProperty("ca.uhn.hl7v2.llp.tests.logBytesRead", "TRUE");
	System.setProperty("ca.uhn.hl7v2.util.tests.tests.status.out", "");
	
	minLowerLayerProtocol = new MinLowerLayerProtocol();
	
	// redirect System.out
	ByteArrayOutputStream statusMsgStream = new ByteArrayOutputStream();
	PrintStream ps = new PrintStream(statusMsgStream);
	PrintStream oldOut = System.out;
	System.setOut(ps);
	
	MinLowerLayerProtocol.logCharacterReceived(c);
	
	// reset System.out
	System.setOut(oldOut);
	// trim to remove \n at end of logging message
	String statusMessage = statusMsgStream.toString().trim();
	
	assertEquals("Should have character logging message", "Char received: " + c + " (" + (char) c + ")", statusMessage);
    }
}
