/**
 * The contents of this file are subject to the Mozilla Public License Version 1.1
 * (the "License"); you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at http://www.mozilla.org/MPL/
 * Software distributed under the License is distributed on an "AS IS" basis,
 * WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the
 * specific language governing rights and limitations under the License.
 *
 * The Original Code is "MinLLPReaderTest.java".  Description:
 * "Unit test class for ca.uhn.hl7v2.llp.tests.MinLLPReader"
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
import static org.junit.Assert.assertNull;
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

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
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
import ca.uhn.hl7v2.llp.MinLLPReader;
import ca.uhn.hl7v2.util.tests.MessageLibrary;

/**
 * Unit test class for ca.uhn.hl7v2.llp.tests.MinLLPReader
 * 
 * @author Leslie Mann
 * @author Niranjan Sharma niranjan.sharma@med.ge.com This testcase has been
 *         extended for OSGI environment using Junit4 and PAX-Exam.
 */
@RunWith(JUnit4TestRunner.class)
public class MinLLPReaderTest {
    
    // you get that because you "installed" a log profile in configuration.
    public Log logger = LogFactory.getLog(MinLLPReaderTest.class);
    
    // NB: Per the minimal lower layer protocol.
    // character indicating the termination of an HL7 message
    private static final char END_MESSAGE = '\u001c';
    // character indicating the start of an HL7 message
    private static final char START_MESSAGE = '\u000b';
    // the final character of a message: a carriage return
    private static final char LAST_CHARACTER = 13;
    
    private String message = null;
    private byte[] sendMessage = null;
    private MinLLPReader minLLPReader = null;
    private ByteArrayInputStream inputStream = null;
    MessageLibrary msgLib = null;
    
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
    public void BeforeTheTest() {
	logger.info("*****************************BeforeTheTest******************************************");
	message = "This is a test HL7 message";
	sendMessage = (START_MESSAGE + message + END_MESSAGE + LAST_CHARACTER).getBytes();
	minLLPReader = new MinLLPReader();
	
	// only want to setup once
	if (msgLib == null) {
	    msgLib = new MessageLibrary("ca/uhn/hl7v2/util/tests/messages.txt", "VB");
	    inputStream = msgLib.getAsByteArrayInputStream();
	}
    }
    
    @After
    public void AfterTheTest() {
	logger.info("*****************************AfterTheTest******************************************");
	message = null;
	minLLPReader = null;
	inputStream = null;
    }
    
    /*
     * ********************************************************* Test Cases
     * *********************************************************
     */

    /**
     * Test default constructor
     */
    @Test
    public void testConstructor() {
	assertNotNull("Should have a valid MinLLPReader object", minLLPReader);
    }
    
    /**
     * Test constructor with input stream
     */
    @Test
    public void testConstructorWithInputStream() throws IOException {
	minLLPReader = new MinLLPReader(inputStream);
	assertNotNull("Should have a valid MinLLPReader object", minLLPReader);
    }
    
    /**
     * Ensure constructor validates inputs. Pass a null inputStream
     */
    @Test
    public void testConstructorWithNullInputStream() {
	ByteArrayInputStream nullInputStream = null;
	
	try {
	    minLLPReader = new MinLLPReader(nullInputStream);
	    fail("Should not be able to create a MinLLPReader with a null input stream");
	} catch (IOException ioe) {
	} catch (NullPointerException ioe) {
	}
    }
    
    /**
     * Ensure setInputStream validates inputs. Pass a null inputStream
     */
    @Test
    public void testSetNullInputStream() {
	ByteArrayInputStream nullInputStream = null;
	
	try {
	    minLLPReader.setInputStream(nullInputStream);
	    fail("Should not be able to set a null input stream");
	} catch (IOException ioe) {
	} catch (NullPointerException ioe) {
	}
    }
    
    /**
     * Testing readMessage method with a null input stream
     */
    @Test
    public void testSetReadMessageNullInputStream() throws LLPException {
	ByteArrayInputStream nullInputStream = null;
	
	try {
	    minLLPReader.setInputStream(nullInputStream);
	    String recvMessage = minLLPReader.getMessage();
	    assertNull("Should not be able to read message from null input stream", recvMessage);
	} catch (IOException ioe) {
	} catch (NullPointerException ioe) {
	}
    }
    
    /**
     * Attempt to read a message without calling - <code>setInputStream</code>
     */
    @Test
    public void testReadMessageWithoutOutputStream() throws LLPException {
	try {
	    minLLPReader.getMessage();
	    fail("Reader should be initialized before use");
	} catch (IOException ioe) {
	} catch (NullPointerException ioe) {
	}
    }
    
    /**
     * Test readMessage with MessageLibrary contents
     */
    @Test
    public void testReadLibraryMessages() throws IOException, LLPException {
	minLLPReader.setInputStream(inputStream);
	int mismatch = 0;
	for (int i = 0; i < 10; i++) {
	    String recvMessage = minLLPReader.getMessage();
	    String temp = ((ca.uhn.hl7v2.util.tests.LibraryEntry) msgLib.get(i)).messageString();
	    if (!temp.equals(recvMessage)) {
		mismatch++;
	    }
	}
	
	assertEquals("HL7 message should equal input llp decoded message", 0, mismatch);
    }
    
    /**
     * Testing readMessage with well and malformed llp encoded input messages.
     */
    @Test
    public void testReadMessages() {
	class TestSpec {
	    byte[] sendMessage;
	    Object outcome;
	    
	    TestSpec(String message, Object outcome) {
		if (message != null)
		    this.sendMessage = message.getBytes();
		else
		    this.sendMessage = null;
		this.outcome = outcome;
	    }
	    
	    public String toString() {
		return "[" + (sendMessage != null ? sendMessage.toString() : "null") + ":" + outcome + "]";
	    }
	    
	    public boolean executeTest() {
		try {
		    ByteArrayInputStream inputStream = new ByteArrayInputStream(this.sendMessage);
		    MinLLPReader reader = new MinLLPReader(inputStream);
		    String recvMessage = reader.getMessage();
		    return recvMessage.equals(outcome);
		} catch (Exception e) {
		    return (e.getClass().equals(outcome));
		}
	    }
	}// inner class
	
	TestSpec[] tests = { new TestSpec(null, NullPointerException.class), new TestSpec(START_MESSAGE + message + END_MESSAGE + LAST_CHARACTER, message), new TestSpec(START_MESSAGE + message + END_MESSAGE, LLPException.class), new TestSpec(START_MESSAGE + message, LLPException.class), new TestSpec(Integer.toString(START_MESSAGE), LLPException.class), new TestSpec(message, LLPException.class), new TestSpec(message + END_MESSAGE + LAST_CHARACTER, LLPException.class), new TestSpec(Integer.toString(END_MESSAGE) + Integer.toString(LAST_CHARACTER), LLPException.class), new TestSpec(Integer.toString(LAST_CHARACTER), LLPException.class), new TestSpec(Integer.toString(START_MESSAGE) + Integer.toString(END_MESSAGE) + Integer.toString(LAST_CHARACTER), LLPException.class), };
	
	ArrayList failedTests = new ArrayList();
	
	for (int i = 0; i < tests.length; i++) {
	    if (!tests[i].executeTest())
		failedTests.add(tests[i]);
	}
	
	assertEquals("readMessages failures: " + failedTests, 0, failedTests.size());
    }
    
    /**
     * Test closing reader
     */
    @Test
    public void testClose() {
	try {
	    minLLPReader = new MinLLPReader(inputStream);
	    minLLPReader.close();
	} catch (IOException ioe) {
	    fail("Problem setting up test conditions");
	}
	try {
	    String recvMessage = minLLPReader.getMessage();
	    fail("Input stream should be closed");
	} catch (IOException ioe) {
	} catch (LLPException llpe) {
	}
    }
    /**
     * Test reading from closed stream
     * @throws LLPException
     * @throws IOException
     */
    @Test
    public void testReadFromClosedStream() throws LLPException, IOException {
        InputStream in = new ByteArrayInputStream("".getBytes()); //will return -1 as if closed remotely
        MinLLPReader reader = new MinLLPReader(in);
        String message = reader.getMessage();
        assertEquals(null, message);
    }
}