/**
The contents of this file are subject to the Mozilla Public License Version 1.1 
(the "License"); you may not use this file except in compliance with the License. 
You may obtain a copy of the License at http://www.mozilla.org/MPL/ 
Software distributed under the License is distributed on an "AS IS" basis, 
WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the 
specific language governing rights and limitations under the License. 

The Initial Developer of the Original Code is University Health Network. Copyright (C) 
2001.  All Rights Reserved. 

Contributor(s): Jens Kristian Villadsen from Cetrea A/S

Alternatively, the contents of this file may be used under the terms of the 
GNU General Public License (the "GPL"), in which case the provisions of the GPL are 
applicable instead of those above.  If you wish to allow use of your version of this 
file only under the terms of the GPL and not to allow others to use your version 
of this file under the MPL, indicate your decision by deleting  the provisions above 
and replace  them with the notice and other provisions required by the GPL License.  
If you do not delete the provisions above, a recipient may use your version of 
this file under either the MPL or the GPL. 

*/

package ca.uhn.hl7v2.llp;

import static ca.uhn.hl7v2.llp.MinLLPReader.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.nio.charset.Charset;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ca.uhn.hl7v2.preparser.PreParser;

/**
 * Charset-aware MLLP stream reader
 * 
 * @see ExtendedMinLowerLayerProtocol
 * @author Jens Kristian Villadsen from Cetrea A/S
 */
public class ExtendedMinLLPReader implements HL7Reader
{

	private static final Logger log = LoggerFactory.getLogger(ExtendedMinLLPReader.class);

	private InputStream inputStream;
	private Charset myLastCharset;
	private InputStreamReader myReader;

	/**
	 * Creates a MinLLPReader with no setup - setInputStream must be set later.
	 */
	public ExtendedMinLLPReader()
	{
		super();
	}

	/**
	 * Creates a MinLLPReader which reads from the given InputStream. The stream is assumed to be an ASCII bit stream.
	 */
	public ExtendedMinLLPReader(InputStream in) throws IOException
	{
		setInputStream(in);
	}

	/**
	 * Closes the underlying BufferedReader.
	 */
	public synchronized void close() throws java.io.IOException
	{
		myReader.close();
	}

	private Charset getCharacterEncoding(InputStream in) throws IOException
	{
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		int next = in.read();
		while((next != -1 || bos.size() == 0) && next != END_MESSAGE && next != LAST_CHARACTER)
		{
			bos.write(next);
			next = in.read();
		}
		bos.flush();
		
		try
		{
			String firstLine;
			if ((bos.toByteArray()[0] == -2 && bos.toByteArray()[1] == -1) ||
					bos.toByteArray()[1] == -2 && bos.toByteArray()[0] == -1) {
				
				// if the string is little endian, then we will be missing the second byte of the 
				// last character (a "\r"), so add it manually
				if (bos.toByteArray()[1] == -2 && bos.toByteArray()[0] == -1) {
					bos.write(0);
				}
				
				firstLine = bos.toString("UTF-16");
			} else {
				firstLine = bos.toString("US-ASCII");
			}
			
			String[] fields = PreParser.getFields(firstLine, "MSH-18(0)");
			String charset = stripNonLowAscii(fields[0]);
			Charset javaCs = CharSetUtil.convertHL7CharacterEncodingToCharSetvalue(charset);			
			log.debug("Detected MSH-18 value \"{}\" so using charset {}", charset, javaCs.displayName());			
			return javaCs;
		}
		catch(Exception e)
		{
			log.warn("Nonvalid charset - defaulting to US-ASCII", e);
		}
		finally
		{
			bos.close();
		}
		return Charset.forName("US-ASCII");
	}

	private String stripNonLowAscii(String theString) {
		if (theString == null) return "";
		StringBuilder b = new StringBuilder();
		
		for (int i = 0; i < theString.length(); i++) {
			char next = theString.charAt(i);
			if (next > 0 && next < 127) {
				b.append(next);
			}
		}
		
		return b.toString();
	}

	/**
	 * @return the lastCharset
	 */
	public Charset getLastCharset() {
		return myLastCharset;
	}

	public synchronized String getMessage() throws LLPException, IOException
	{
		ByteArrayOutputStream baos = null;
		baos = verifyAndCopyToOutputStream(this.inputStream);

		if(baos == null)
			return null;
		
		byte[] byteArray = baos.toByteArray();
		myLastCharset = getCharacterEncoding(new ByteArrayInputStream(byteArray));

		myReader = new InputStreamReader(new ByteArrayInputStream(byteArray), myLastCharset);
		baos.close();

		StringBuffer s_buffer = new StringBuffer();

		int c = myReader.read();
		while(c != -1)
		{
			s_buffer.append((char) c);
			c = myReader.read();
		}
		return s_buffer.toString();
	}

	/**
	 * Sets the InputStream from which to read messages. The InputStream must be set before any calls to <code>getMessage()</code>.
	 */
	public synchronized void setInputStream(InputStream in) throws IOException
	{
		this.inputStream = in;
	}

	private ByteArrayOutputStream verifyAndCopyToOutputStream(InputStream stream) throws IOException, LLPException
	{
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		boolean end_of_message = false;

		int c = 0;
		try
		{
			c = stream.read();
		}
		catch(SocketException e)
		{
			log.info("SocketException on read() attempt.  Socket appears to have been closed: {}", e.getMessage());
			throw e;
		}
		catch(SocketTimeoutException e)
		{
			log.debug("SocketTimeoutException on read() attempt.");
			return null;
		}
		// trying to read when there is no data (stream may have been closed at other end)
		if(c == -1)
		{
			log.info("End of input stream reached.");
			throw new SocketException("End of input stream reached");
		}
		LowerLayerProtocol.logCharacterReceived(c);

		if(c != START_MESSAGE)
		{
			throw new LLPException("Message violates the " + "minimal lower layer protocol: no start of message indicator " + "received. Received: " + c);
		}

		while(!end_of_message)
		{
			c = stream.read();

			if(c == -1)
			{
				throw new LLPException("Message violates the " + "minimal lower protocol: message terminated without " + "a terminating character.");
			}
			LowerLayerProtocol.logCharacterReceived(c);

			if(c == END_MESSAGE)
			{
				// subsequent character should be a carriage return
				c = stream.read();
				if(c >= 0)
					LowerLayerProtocol.logCharacterReceived(c);
				if(c != LAST_CHARACTER)
				{
					throw new LLPException("Message " + "violates the minimal lower layer protocol: " + "message terminator not followed by a return " + "character.");
				}
				end_of_message = true;
			}
			else
			{
				// the character wasn't the end of message, append it to the message
				bos.write(c);
			}
		}

		bos.flush();
		return bos;
	}
}
