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

import ca.uhn.hl7v2.IndexedErrorCollector;
import ca.uhn.hl7v2.TestSpec;
import ca.uhn.hl7v2.util.MessageLibrary;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static ca.uhn.hl7v2.TestSpecBuilder.buildSpecs;
import static ca.uhn.hl7v2.llp.MllpConstants.*;
import static org.junit.Assert.*;

/**
 * Unit test class for ca.uhn.hl7v2.llp.MllpReader
 *
 * @author Christian Ohr
 */
public class MinLLPReaderTest {

    private String message;
    private MinLLPReader minLLPReader;
    private ByteArrayInputStream inputStream;

    @Rule
    public IndexedErrorCollector collector = new IndexedErrorCollector();

    @Before
    public void setUp() throws Exception {
        message = "This is a test HL7 message";
        minLLPReader = new MinLLPReader();
        inputStream = MinLLPWriterTest.getMessageLib().getAsByteArrayInputStream();
    }

    @After
    public void tearDown() throws Exception {
        message = null;
        minLLPReader = null;
    }

    /*
     * *********************************************************
     * Test Cases
     * *********************************************************
     */

    /**
     * Test default constructor
     */
    @Test
    public void testConstructor() {
        assertNotNull("Should have a valid MllpReader object", minLLPReader);
    }

    /**
     * Test constructor with input stream
     */
    @Test
    public void testConstructorWithInputStream() throws IOException {
        minLLPReader = new MinLLPReader(inputStream);
        assertNotNull("Should have a valid MllpReader object", minLLPReader);
    }

    /**
     * Ensure constructor validates inputs. Pass a null inputStream
     */
    @Test(expected = NullPointerException.class)
    public void testConstructorWithNullInputStream() throws IOException {
        new MinLLPReader(null);
    }

    /**
     * Ensure setInputStream validates inputs. Pass a null inputStream
     */
    @Test(expected = NullPointerException.class)
    public void testSetNullInputStream() throws IOException, LLPException {
        minLLPReader.setInputStream(null);
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
    @Test(expected = NullPointerException.class)
    public void testReadMessageWithoutOutputStream() throws IOException, LLPException {
        minLLPReader.getMessage();
    }

    /**
     * Test readMessage with MessageLibrary contents
     */
    @Test
    public void testReadLibraryMessages() throws IOException, LLPException {
        minLLPReader.setInputStream(inputStream);
        MessageLibrary lib = MinLLPWriterTest.getMessageLib();
        for (int i = 0; i < 10; i++) {
            String recvMessage = minLLPReader.getMessage();
            String temp = lib.get(i).messageString();
            assertEquals(temp, recvMessage);
        }
    }

    public static class ReadSpec extends TestSpec<String, String> {

        @Override
        protected String transform(String input) throws Throwable {
            byte[] sendMessage = input != null ? input.getBytes() : null;
            ByteArrayInputStream inputStream = new ByteArrayInputStream(sendMessage);
            MinLLPReader reader = new MinLLPReader(inputStream);
            return reader.getMessage();
        }

    }

    /**
     * Testing readMessage with well and malformed llp encoded input messages.
     */
    @Test
    public void testReadMessages() {

        buildSpecs(ReadSpec.class)
                .add(null, NullPointerException.class)
                .add(START_BYTE + message + END_BYTE1 + END_BYTE2, message)
                .add(START_BYTE + message + END_BYTE1, LLPException.class)
                .add(START_BYTE + message, LLPException.class)
                .add(Integer.toString(START_BYTE), LLPException.class)
                .add(message, LLPException.class)
                .add(message + END_BYTE1 + END_BYTE2, LLPException.class)
                .add(Integer.toString(END_BYTE1) + Integer.toString(END_BYTE2), LLPException.class)
                .add(Integer.toString(END_BYTE2), LLPException.class)
                .add(Integer.toString(START_BYTE) + Integer.toString(END_BYTE1) + Integer.toString(END_BYTE2), LLPException.class)
                .executeTests(collector);
    }

    /**
     * Test closing reader
     */
    @Test
    public void testClose() throws IOException {
        minLLPReader = new MinLLPReader(inputStream);
        minLLPReader.close();

        try {
            minLLPReader.getMessage();
            fail("Input stream should be closed");
        } catch (IOException ioe) {
        } catch (LLPException llpe) {
        }
    }

    @Test(expected = SocketException.class)
    public void testReadFromClosedStream() throws LLPException, IOException {
        InputStream in = new ByteArrayInputStream("".getBytes()); // will return -1 as if closed remotely
        MinLLPReader reader = new MinLLPReader(in);
        reader.getMessage();
    }
}