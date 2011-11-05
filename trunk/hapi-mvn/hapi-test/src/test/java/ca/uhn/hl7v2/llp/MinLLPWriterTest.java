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

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import ca.uhn.hl7v2.util.LibraryEntry;
import ca.uhn.hl7v2.util.MessageLibrary;

import junit.framework.TestCase;

/**
 * Unit test class for ca.uhn.hl7v2.llp.MinLLPWriter
 *
 * @author Leslie Mann
 */
public class MinLLPWriterTest extends TestCase {
    // NB: Per the minimal lower layer protocol.
	// character indicating the termination of an HL7 message
    private static final char END_MESSAGE = '\u001c'; 
    // character indicating the start of an HL7 message
    private static final char START_MESSAGE = '\u000b';
     // the final character of a message: a carriage return
    private static final char LAST_CHARACTER = 13;

	private String message;
	private MinLLPWriter minLLPWriter;
	private ByteArrayOutputStream outputStream;
	private static MessageLibrary messageLib;

	/**
	 * Constructor for MinLLPWriterTest.
	 * @param testName
	 */
	public MinLLPWriterTest(String testName) {
		super(testName);
	}

	public static void main(String[] args) {
		junit.textui.TestRunner.run(MinLLPWriterTest.class);
	}

	/**
	 * @see TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();
		message = "This is a test HL7 message";
		minLLPWriter = new MinLLPWriter();
		outputStream = new ByteArrayOutputStream();
	}

	/**
	 * @see TestCase#tearDown()
	 */
	protected void tearDown() throws Exception {
		super.tearDown();
		message = null;
		minLLPWriter = null;
		outputStream = null;
	}

	/*
	 ********************************************************** 
	 * Test Cases
	 ********************************************************** 
	 */

	/**
	 * Test default constructor
	 */	 
	public void testConstructor() {
		assertNotNull("Should have a valid MinLLPWriter object", minLLPWriter);
	}

	/**
	 * Test constructor with output stream
	 */
	public void testConstructorWithOutputStream() throws IOException {
		minLLPWriter = new MinLLPWriter(outputStream);
		assertNotNull("Should have a valid MinLLPWriter object", minLLPWriter);
	}

	/**
	 * Ensure constructor validates inputs. Pass a null outputStream
	 */
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
	public void testWriteMessageWithoutOutputStream() throws LLPException {
		try {
			minLLPWriter.writeMessage(message);
			fail("Writer should be initialized before use");
		} catch (IOException ioe) {
	    } catch (NullPointerException e) {
        }
	}

	public static MessageLibrary getMessageLib() {
        //only want to setup once
        if (messageLib == null) {
            String path = "ca/uhn/hl7v2/util/messages.txt";
            messageLib = new MessageLibrary(path, "VB");
        }
	    
        return messageLib;
	}
	
	/**
	 * Test writeMessage with MessageLibrary contents
	 */
	public void testWriteLibraryMessages() throws IOException, LLPException {
		minLLPWriter.setOutputStream(outputStream);
		int mismatch = 0;
		for (int i=0; i<getMessageLib().size(); i++) {
			String msg = ((LibraryEntry) getMessageLib().get(i)).messageString();
			minLLPWriter.writeMessage(msg);
			String llpMessage = outputStream.toString();
			outputStream.reset();
			//minLLPWriter adds minimum lower layer protocol characters
			if (!(START_MESSAGE + msg + END_MESSAGE + LAST_CHARACTER).equals(llpMessage)) {
				mismatch++;
			}
		}
		
		assertEquals("HL7 message should equal oded message", 0, mismatch);
	}

	/**
	 * Testing writeMessage with various messages.
	 */
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
		}//inner class
		
		TestSpec [] tests = {
			new TestSpec(null, NullPointerException.class),
			new TestSpec("", START_MESSAGE + "" + END_MESSAGE + LAST_CHARACTER),
			new TestSpec(message, START_MESSAGE + message + END_MESSAGE + LAST_CHARACTER),
		};
		
		ArrayList failedTests = new ArrayList();

		for (int i = 0; i < tests.length ; i++) {
			if ( ! tests[ i ].executeTest() ) 
         		failedTests.add( tests[ i ] );
		}

   		assertEquals("readMessages failures: " + failedTests, 0, failedTests.size()); 
	}

	/**
	 * Test closing writer with as if private access
	 */
	public void testClosePrivateWriter() {
		try {
			minLLPWriter= new MinLLPWriter(outputStream);
			minLLPWriter.close();
		} catch (IOException ioe) {
			fail("Problem setting up test conditions");
		}
		try {
			minLLPWriter.writeMessage(message);
			fail("Output stream should be closed");
		} catch (IOException ioe) {
		} catch (LLPException llpe) {}
	}
    
    public void testWithSpecifiedCharset() throws Exception {
        String test = "foo";
        String charset = "UTF-16"; //makes "foo" look like "???" with default charset
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        MinLLPWriter writer = new MinLLPWriter(out);
        writer.writeMessage(test, charset);
        assertTrue(out.toString(charset).indexOf(test) >= 0);
    }
    
    public void testWithCharsetProperty() throws Exception {
        String test = "foo";
        String charset = "UTF-16"; //makes "foo" look like "???" with default charset

        String before = System.getProperty(MinLLPWriter.CHARSET_KEY);
        System.setProperty(MinLLPWriter.CHARSET_KEY, charset);

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        MinLLPWriter writer = new MinLLPWriter(out);
        writer.writeMessage(test);
        assertTrue(out.toString(charset).indexOf(test) >= 0);
        
        if (before != null) {
            System.setProperty(MinLLPWriter.CHARSET_KEY, before);
        } else {
            System.clearProperty(MinLLPWriter.CHARSET_KEY);
        }
    }
}