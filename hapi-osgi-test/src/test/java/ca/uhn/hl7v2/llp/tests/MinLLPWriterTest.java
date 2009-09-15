/**
 * The contents of this file are subject to the Mozilla Public License Version 1.1
 * (the "License"); you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at http://www.mozilla.org/MPL/
 * Software distributed under the License is distributed on an "AS IS" basis,
 * WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the
 * specific language governing rights and limitations under the License.
 *
 * The Original Code is "MinLLPWriterTest.java".  Description:
 * "Unit test class for ca.uhn.hl7v2.llp.tests.MinLLPWriter"
 *
 * The Initial Developer of the Original Code is Leslie Mann. Copyright (C)
 * 2002.  All Rights Reserved.
 *
 * Contributor(s): ______________________________________.
 *
 * Alternatively, the contents of this file may be used under the terms of the
 * GNU General Public License (the  “GPL”), in which case the provisions of the GPL are
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
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.ops4j.pax.exam.CoreOptions.equinox;
import static org.ops4j.pax.exam.CoreOptions.felix;
import static org.ops4j.pax.exam.CoreOptions.frameworks;
import static org.ops4j.pax.exam.CoreOptions.knopflerfish;
import static org.ops4j.pax.exam.CoreOptions.mavenBundle;
import static org.ops4j.pax.exam.CoreOptions.options;
import static org.ops4j.pax.exam.CoreOptions.systemProperty;
import static org.ops4j.pax.exam.CoreOptions.wrappedBundle;
import static org.ops4j.pax.exam.container.def.PaxRunnerOptions.logProfile;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;

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

import ca.uhn.hl7v2.llp.LLPException;
import ca.uhn.hl7v2.llp.MinLLPWriter;
import ca.uhn.hl7v2.util.tests.LibraryEntry;
import ca.uhn.hl7v2.util.tests.MessageLibrary;

/**
 * Unit test class for ca.uhn.hl7v2.llp.tests.MinLLPWriter
 * 
 * @author Leslie Mann
 * @author Niranjan Sharma niranjan.sharma@med.ge.com This testcase has been
 *         extended for OSGI environment using Junit4 and PAX-Exam.
 */

@RunWith(JUnit4TestRunner.class)
public class MinLLPWriterTest {
    
    // you get that because you "installed" a log profile in configuration.
    public Log logger = LogFactory.getLog(MinLLPWriterTest.class);
    
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
    
    // NB: Per the minimal lower layer protocol.
    // character indicating the termination of an HL7 message
    private final char END_MESSAGE = '\u001c';
    // character indicating the start of an HL7 message
    private final char START_MESSAGE = '\u000b';
    // the final character of a message: a carriage return
    private final char LAST_CHARACTER = 13;
    
    private String message;
    private MinLLPWriter minLLPWriter;
    private ByteArrayOutputStream outputStream;
    MessageLibrary msgLib;
    
    @Before
    public void BeforeTheTest() {
	logger.info("*****************************BeforeTheTest******************************************");
	message = "This is a test HL7 message";
	minLLPWriter = new MinLLPWriter();
	outputStream = new ByteArrayOutputStream();
	// only want to setup once
	if (msgLib == null) {
	    msgLib = new MessageLibrary("ca/uhn/hl7v2/util/tests/messages.txt", "VB");
	}
	
    }
    
    @After
    public void AfterTheTest() {
	logger.info("*****************************AfterTheTest******************************************");
	message = null;
	minLLPWriter = null;
	outputStream = null;
	msgLib = null;
    }
    
    /*
     * ********************************************************* Test Cases
     * *********************************************************
     */

    @Test
    public void TestCtx() {
	System.out.println("*****************************Bundle Context is Good******************************************");
	assertNotNull("Bundle Context is Null", bundleContext);
	
    }
    
    /**
     * Test default constructor
     */
    @Test
    public void testConstructor() {
	assertNotNull("Should have a valid MinLLPWriter object", minLLPWriter);
    }
    
    /**
     * Test constructor with output stream
     */
    @Test
    public void testConstructorWithOutputStream() throws IOException {
	minLLPWriter = new MinLLPWriter(outputStream);
	assertNotNull("Should have a valid MinLLPWriter object", minLLPWriter);
    }
    
    /**
     * Ensure constructor validates inputs. Pass a null outputStream
     */
    @Test
    public void testConstructorWithNullOutputStream() {
	ByteArrayOutputStream nullOutputStream = null;
	
	try {
	    minLLPWriter = new MinLLPWriter(nullOutputStream);
	    fail("Should not be able to create a MinLLPWriter with a null input stream");
	} catch (IOException ioe) {
	} catch (NullPointerException e) {
	}
    }
    
    /**
     * Ensure setOutputStream validates inputs. Pass a null outputStream
     */
    @Test
    public void testSetNullOutputStream() {
	ByteArrayOutputStream nullOutputStream = null;
	
	try {
	    minLLPWriter.setOutputStream(nullOutputStream);
	    fail("Should not be able to set a null output stream");
	} catch (IOException ioe) {
	} catch (NullPointerException e) {
	}
    }
    
    /**
     * Attempt to write a message without calling - <code>setOutputStream</code>
     */
    @Test
    public void testWriteMessageWithoutOutputStream() throws LLPException {
	try {
	    minLLPWriter.writeMessage(message);
	    fail("Writer should be initialized before use");
	} catch (IOException ioe) {
	} catch (NullPointerException e) {
	}
    }
    
    /**
     * Test writeMessage with MessageLibrary contents
     */
    @Test
    public void testWriteLibraryMessages() throws IOException, LLPException {
	minLLPWriter.setOutputStream(outputStream);
	int mismatch = 0;
	for (int i = 0; i < msgLib.size(); i++) {
	    String msg = ((LibraryEntry) msgLib.get(i)).messageString();
	    minLLPWriter.writeMessage(msg);
	    String llpMessage = outputStream.toString();
	    outputStream.reset();
	    // minLLPWriter adds minimum lower layer protocol characters
	    if (!(START_MESSAGE + msg + END_MESSAGE + LAST_CHARACTER).equals(llpMessage)) {
		mismatch++;
	    }
	}
	
	assertEquals("HL7 message should equal oded message", 0, mismatch);
    }
    
    /**
     * Testing writeMessage with various messages.
     */
    @Test
    public void testWriteMessages() {
	class TestSpec {
	    String writeMessage;
	    String recvMessage;
	    Object outcome;
	    
	    TestSpec(String message, Object outcome) {
		if (message != null)
		    this.writeMessage = message;
		else
		    this.writeMessage = null;
		this.outcome = outcome;
	    }
	    
	    public String toString() {
		return "[" + (writeMessage != null ? writeMessage.toString() : "null") + ":" + outcome + "]";
	    }
	    
	    public boolean executeTest() {
		try {
		    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		    MinLLPWriter minLLPWriter = new MinLLPWriter(outputStream);
		    minLLPWriter.writeMessage(writeMessage);
		    return outputStream.toString().equals(outcome);
		} catch (Exception e) {
		    return (e.getClass().equals(outcome));
		}
	    }
	}// inner class
	
	TestSpec[] tests = { new TestSpec(null, NullPointerException.class), new TestSpec("", START_MESSAGE + "" + END_MESSAGE + LAST_CHARACTER), new TestSpec(message, START_MESSAGE + message + END_MESSAGE + LAST_CHARACTER), };
	
	ArrayList failedTests = new ArrayList();
	
	for (int i = 0; i < tests.length; i++) {
	    if (!tests[i].executeTest())
		failedTests.add(tests[i]);
	}
	
	assertEquals("readMessages failures: " + failedTests, 0, failedTests.size());
    }
    
    /**
     * Test closing writer with as if private access
     */
    @Test
    public void testClosePrivateWriter() {
	try {
	    minLLPWriter = new MinLLPWriter(outputStream);
	    minLLPWriter.close();
	} catch (IOException ioe) {
	    fail("Problem setting up test conditions");
	}
	try {
	    minLLPWriter.writeMessage(message);
	    fail("Output stream should be closed");
	} catch (IOException ioe) {
	} catch (LLPException llpe) {
	}
    }
    
    @Test
    public void testWithSpecifiedCharset() throws Exception {
	String test = "foo";
	String charset = "UTF-16"; // makes "foo" look like "???" with default
	// charset
	ByteArrayOutputStream out = new ByteArrayOutputStream();
	MinLLPWriter writer = new MinLLPWriter(out);
	writer.writeMessage(test, charset);
	assertTrue(out.toString(charset).indexOf(test) >= 0);
    }
    
    @Test
    public void testWithCharsetProperty() throws Exception {
	String test = "foo";
	String charset = "UTF-16"; // makes "foo" look like "???" with default
				   // charset
	
	String before = System.getProperty(MinLLPWriter.CHARSET_KEY);
	System.setProperty(MinLLPWriter.CHARSET_KEY, charset);
	
	ByteArrayOutputStream out = new ByteArrayOutputStream();
	MinLLPWriter writer = new MinLLPWriter(out);
	writer.writeMessage(test);
	assertTrue(out.toString(charset).indexOf(test) >= 0);
	
	if (before != null) {
	    System.setProperty(MinLLPWriter.CHARSET_KEY, before);
	}
    }
}
