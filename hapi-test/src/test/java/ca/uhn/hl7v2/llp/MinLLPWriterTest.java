/**
 * The contents of this file are subject to the Mozilla Public License Version 1.1
 * (the "License"); you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at http://www.mozilla.org/MPL/
 * Software distributed under the License is distributed on an "AS IS" basis,
 * WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the
 * specific language governing rights and limitations under the License.
 *
 * The Original Code is "MinLLPWriterTest.java".  Description:
 * "Unit test class for ca.uhn.hl7v2.llp.MinLLPWriter"
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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ca.uhn.hl7v2.DefaultHapiContext;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.app.Connection;
import ca.uhn.hl7v2.model.v25.message.ADT_A01;
import ca.uhn.hl7v2.util.LibraryEntry;
import ca.uhn.hl7v2.util.MessageLibrary;
import ca.uhn.hl7v2.util.RandomServerPortProvider;

/**
 * Unit test class for ca.uhn.hl7v2.llp.MinLLPWriter
 *
 * @author Leslie Mann
 */
public class MinLLPWriterTest {

    private static MessageLibrary messageLib;

    // character indicating the start of an HL7 message
    private String message;
    private MinLLPWriter minLLPWriter;
    private Throwable myException;

    private int myPacketCount;

    private ByteArrayOutputStream outputStream;


    @Before
    public void setUp() throws Exception {
        message = "This is a test HL7 message";
        minLLPWriter = new MinLLPWriter();
        outputStream = new ByteArrayOutputStream();
    }


    @After
    public void tearDown() throws Exception {
        message = null;
        minLLPWriter = null;
        outputStream = null;
    }

    /**
     * Test default constructor
     */
    @Test
    public void testConstructor() {
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
     * Test constructor with output stream
     */
    @Test
    public void testConstructorWithOutputStream() throws IOException {
        minLLPWriter = new MinLLPWriter(outputStream);
        assertNotNull("Should have a valid MinLLPWriter object", minLLPWriter);
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

    @Test
    public void testWithUTF8() throws Exception {
        String test = "foo";
        String charset = "UTF-8";
        // charset

        String before = System.getProperty(MllpConstants.CHARSET_KEY);
        System.setProperty(MllpConstants.CHARSET_KEY, charset);

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        MinLLPWriter writer = new MinLLPWriter(out);
        writer.writeMessage(test);
        String encoded = out.toString(charset);
        assertTrue(encoded.indexOf(test) >= 0);

        if (before != null) {
            System.setProperty(MllpConstants.CHARSET_KEY, before);
        } else {
            System.clearProperty(MllpConstants.CHARSET_KEY);
        }
    }

    @Test
    public void testWithUTF16() throws Exception {
        String test = "foo";
        String charset = "UTF-16"; // makes "foo" look like "???" with default
        // charset

        String before = System.getProperty(MllpConstants.CHARSET_KEY);
        System.setProperty(MllpConstants.CHARSET_KEY, charset);

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        MinLLPWriter writer = new MinLLPWriter(out);
        writer.writeMessage(test);
        byte[] bytes = test.getBytes(charset);
        int pos = indexOf(out.toByteArray(), bytes);
        assertEquals(1, pos);

        if (before != null) {
            System.setProperty(MllpConstants.CHARSET_KEY, before);
        } else {
            System.clearProperty(MllpConstants.CHARSET_KEY);
        }
    }

    @Test
    public void testWithUTF16WithoutBOM() throws Exception {
        String test = "foo";
        String charset = "UTF-16BE"; // big-endian -> no byte-order mark!
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        // Endianess not defined -> BOM would be written if not disabled
        MinLLPWriter writer = new MinLLPWriter(out, Charset.forName("UTF-16"), true);
        writer.writeMessage(test);
        byte[] bytes = test.getBytes(charset);
        int pos = indexOf(out.toByteArray(), bytes);
        assertEquals(1, pos);
    }

    // trivial byte search
    private static int indexOf(byte[] src, byte[] pattern) {
        outer: for (int i = 0; i < src.length - pattern.length; i++) {
            if (src[i] == pattern[0]) {
                for (int j = 0; j < pattern.length; j++) {
                    if (src[i + j] != pattern[j]) {
                        continue outer;
                    }
                }
                return i;
            }
        }
        return -1;
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


    /**
     * Test writeMessage with MessageLibrary contents
     */
    @Test
    public void testWriteLibraryMessages() throws IOException, LLPException {
        minLLPWriter.setOutputStream(outputStream);
        int mismatch = 0;
        for (int i = 0; i < getMessageLib().size(); i++) {
            String msg = ((LibraryEntry) getMessageLib().get(i)).messageString();
            minLLPWriter.writeMessage(msg);
            String llpMessage = outputStream.toString();
            outputStream.reset();
            // minLLPWriter adds minimum lower layer protocol characters
            if (!(MllpConstants.START_BYTE + msg + MllpConstants.END_BYTE1 + MllpConstants.END_BYTE2).equals(llpMessage)) {
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
            Object outcome;
            String writeMessage;


            TestSpec(String message, Object outcome) {
                if (message != null)
                    this.writeMessage = message;
                else
                    this.writeMessage = null;
                this.outcome = outcome;
            }


            public boolean executeTest() {
                try {
                    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                    MinLLPWriter minLLPWriter = new MinLLPWriter(outputStream);
                    minLLPWriter.writeMessage(writeMessage);
                    String string = outputStream.toString();
                    boolean equals = string.equals(outcome);
                    return equals;
                } catch (Exception e) {
                    return (e.getClass().equals(outcome));
                }
            }


            public String toString() {
                return "[" + (writeMessage != null ? writeMessage.toString() : "null") + ":" + outcome + "]";
            }
        }// inner class

        TestSpec[] tests = {new TestSpec(null, NullPointerException.class),
                new TestSpec("", MllpConstants.START_BYTE + "" + MllpConstants.END_BYTE1 + MllpConstants.END_BYTE2),
                new TestSpec(message, MllpConstants.START_BYTE + message + MllpConstants.END_BYTE1 + MllpConstants.END_BYTE2)};

        List<TestSpec> failedTests = new ArrayList<TestSpec>();

        for (int i = 0; i < tests.length; i++) {
            if (!tests[i].executeTest())
                failedTests.add(tests[i]);
        }

        assertEquals("readMessages failures: " + failedTests, 0, failedTests.size());
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
     * This is a weird test- On old OS's we want to make sure that the entire MLLP block is
     * sent in a single packet for a small message, because ancient versions of Websphere on AIX
     * behave badly if we don't. Sigh!
     */
    @Test
    public void testWritesHappenInOnePacket() throws IOException, HL7Exception, LLPException {
        myException = null;
        myPacketCount = 0;
        int port = RandomServerPortProvider.findFreePort();
        final ServerSocket ss = new ServerSocket(port);
        ss.setSoTimeout(50);
        try {
            // start listening
            ss.accept();
        } catch (Exception e) {
            // ignore
        }

        Thread t = new Thread() {
            @Override
            public void run() {
                try {
                    Socket s;
                    do {
                        try {
                            s = ss.accept();
                        } catch (Exception e) {
                            s = null;
                        }
                    } while (s == null);
                    InputStream is = s.getInputStream();
                    while (true) {
                        int count = is.available();
                        if (count > 0) {
                            myPacketCount++;
                            System.out.println("Count:" + count);
                            byte[] array = new byte[count];
                            is.read(array, 0, count);
                            System.out.println(Arrays.toString(array));
                        }
                    }

                } catch (Throwable t) {
                    t.printStackTrace();
                    myException = t;
                }
            }
        };
        t.start();

        ADT_A01 msg = new ADT_A01();
        msg.initQuickstart("ADT", "A01", "T");

        Connection client = new DefaultHapiContext().newClient("localhost", port, false);
        client.getInitiator().setTimeoutMillis(100);
        try {
            client.getInitiator().sendAndReceive(msg);
        } catch (Exception e) {
            // expected timeout
        }

        assertTrue(myException == null);
        assertEquals(1, myPacketCount);
    }


    public static MessageLibrary getMessageLib() {
        // only want to setup once
        if (messageLib == null) {
            String path = "ca/uhn/hl7v2/util/messages.txt";
            messageLib = new MessageLibrary(path, "VB");
        }

        return messageLib;
    }
}