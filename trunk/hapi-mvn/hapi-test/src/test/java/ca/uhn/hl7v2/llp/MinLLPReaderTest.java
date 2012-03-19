/**
 * The contents of this file are subject to the Mozilla Public License Version 1.1
 * (the "License"); you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at http://www.mozilla.org/MPL/
 * Software distributed under the License is distributed on an "AS IS" basis,
 * WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the
 * specific language governing rights and limitations under the License.
 *
 * The Original Code is "MinLLPReaderTest.java".  Description:
 * "Unit test class for ca.uhn.hl7v2.llp.MinLLPReader"
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
package ca.uhn.hl7v2.llp;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.SocketException;
import java.util.ArrayList;

import junit.framework.TestCase;
import ca.uhn.hl7v2.util.MessageLibrary;

/**
 * Unit test class for ca.uhn.hl7v2.llp.MinLLPReader
 * 
 * @author Leslie Mann
 */
public class MinLLPReaderTest extends TestCase {
    // NB: Per the minimal lower layer protocol.
    // character indicating the termination of an HL7 message
    static final char END_MESSAGE = '\u001c';
    // character indicating the start of an HL7 message
    static final char START_MESSAGE = '\u000b';
    // the final character of a message: a carriage return
    static final char LAST_CHARACTER = 13;

    private String message;
//    private byte[] sendMessage;
    private MinLLPReader minLLPReader;
    private ByteArrayInputStream inputStream;

    /**
     * Constructor for MinLLPReaderTest.
     * 
     * @param testName
     */
    public MinLLPReaderTest(String testName) {
        super(testName);
    }

    public static void main(String[] args) {
        junit.textui.TestRunner.run(MinLLPReaderTest.class);
    }

    /**
     * @see TestCase#setUp()
     */
    protected void setUp() throws Exception {
        super.setUp();
        message = "This is a test HL7 message";
//        sendMessage = (START_MESSAGE + message + END_MESSAGE + LAST_CHARACTER).getBytes();
        minLLPReader = new MinLLPReader();
        inputStream = MinLLPWriterTest.getMessageLib().getAsByteArrayInputStream();
    }

    /**
     * @see TestCase#tearDown()
     */
    protected void tearDown() throws Exception {
        super.tearDown();
        message = null;
//        sendMessage = null;
        minLLPReader = null;
    }

    /*
     * *********************************************************
     * Test Cases*********************************************************
     */

    /**
     * Test default constructor
     */
    public void testConstructor() {
        assertNotNull("Should have a valid MinLLPReader object", minLLPReader);
    }

    /**
     * Test constructor with input stream
     */
    public void testConstructorWithInputStream() throws IOException {
        minLLPReader = new MinLLPReader(inputStream);
        assertNotNull("Should have a valid MinLLPReader object", minLLPReader);
    }

    /**
     * Ensure constructor validates inputs. Pass a null inputStream
     */
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
    public void testReadLibraryMessages() throws IOException, LLPException {
        minLLPReader.setInputStream(inputStream);
        int mismatch = 0;
        MessageLibrary lib = MinLLPWriterTest.getMessageLib();
        for (int i = 0; i < 10; i++) {
            String recvMessage = minLLPReader.getMessage();
            String temp = lib.get(i).messageString();
            if (!temp.equals(recvMessage)) {
                mismatch++;
            }
        }

        assertEquals("HL7 message should equal input llp decoded message", 0, mismatch);
    }

    /**
     * Testing readMessage with well and malformed llp encoded input messages.
     */
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

        TestSpec[] tests = { new TestSpec(null, NullPointerException.class), new TestSpec(START_MESSAGE + message + END_MESSAGE + LAST_CHARACTER, message),
                new TestSpec(START_MESSAGE + message + END_MESSAGE, LLPException.class), new TestSpec(START_MESSAGE + message, LLPException.class),
                new TestSpec(Integer.toString(START_MESSAGE), LLPException.class), new TestSpec(message, LLPException.class),
                new TestSpec(message + END_MESSAGE + LAST_CHARACTER, LLPException.class),
                new TestSpec(Integer.toString(END_MESSAGE) + Integer.toString(LAST_CHARACTER), LLPException.class),
                new TestSpec(Integer.toString(LAST_CHARACTER), LLPException.class),
                new TestSpec(Integer.toString(START_MESSAGE) + Integer.toString(END_MESSAGE) + Integer.toString(LAST_CHARACTER), LLPException.class), };

        ArrayList<TestSpec> failedTests = new ArrayList<TestSpec>();

        for (int i = 0; i < tests.length; i++) {
            if (!tests[i].executeTest())
                failedTests.add(tests[i]);
        }

        assertEquals("readMessages failures: " + failedTests, 0, failedTests.size());
    }

    /**
     * Test closing reader
     */
    public void testClose() {
        try {
            minLLPReader = new MinLLPReader(inputStream);
            minLLPReader.close();
        } catch (IOException ioe) {
            fail("Problem setting up test conditions");
        }
        try {
            minLLPReader.getMessage();
            fail("Input stream should be closed");
        } catch (IOException ioe) {
        } catch (LLPException llpe) {
        }
    }

    public void testReadFromClosedStream() throws LLPException, IOException {
        InputStream in = new ByteArrayInputStream("".getBytes()); // will return
                                                                  // -1 as if
                                                                  // closed
                                                                  // remotely
        MinLLPReader reader = new MinLLPReader(in);

        try {
        reader.getMessage();
        fail();
        } catch (SocketException e) {
        	return;
        }
    }
}
