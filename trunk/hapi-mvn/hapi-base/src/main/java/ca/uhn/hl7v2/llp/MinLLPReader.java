/**
The contents of this file are subject to the Mozilla Public License Version 1.1 
(the "License"); you may not use this file except in compliance with the License. 
You may obtain a copy of the License at http://www.mozilla.org/MPL/ 
Software distributed under the License is distributed on an "AS IS" basis, 
WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the 
specific language governing rights and limitations under the License. 

The Original Code is "MinLLPReader.java".  Description: 
"Title:        HL7Reader
  Description:  A buffered reader specifically designed for use in reading
                HL7 ASCII strings" 

The Initial Developer of the Original Code is University Health Network. Copyright (C) 
2001.  All Rights Reserved. 

Contributor(s): ______________________________________. 

Alternatively, the contents of this file may be used under the terms of the 
GNU General Public License (the  �GPL�), in which case the provisions of the GPL are 
applicable instead of those above.  If you wish to allow use of your version of this 
file only under the terms of the GPL and not to allow others to use your version 
of this file under the MPL, indicate your decision by deleting  the provisions above 
and replace  them with the notice and other provisions required by the GPL License.  
If you do not delete the provisions above, a recipient may use your version of 
this file under either the MPL or the GPL. 

*/

package ca.uhn.hl7v2.llp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.nio.charset.Charset;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Title:        HL7Reader
 * Description:  A buffered reader specifically designed for use in reading
 *               HL7 ASCII strings. This class assumes that the minimal lower
 *               layer protocol is being used.
 * Copyright:    Copyright (c) 2001
 * Company:      University Health Network
 * @author       Damian Horton (damian.horton@uhn.on.ca); mods by Bryan Tripp
 */

public class MinLLPReader implements HL7Reader
{
    
    /**
     *<p>
     * System property: If a value is set for this property, the value
     * is interpreted as a character set, and this characterset is 
     * used. A possible example is "UTF-8" if you are receiving messages
     * from a system that transmits in UTF-8.
     * </p>
     * <p>
     * If the system property is set to a value of "default" (in other words, a
     * string containing only the word default), then the platform default
     * is used.
     * </p>
     * <p>
     * If the system property is not set, US-ASCII encoding is used.
     * </p>
     */
    public static final String CHARSET_KEY = "ca.uhn.hl7v2.llp.charset";

    private static final Logger log = LoggerFactory.getLogger(MinLLPReader.class);
    
    private BufferedReader myReader;

	private Charset charset;

    /**
     * Character indicating the termination of an HL7 message
     */
    public static final char END_MESSAGE = '\u001c'; 
    
    /**
     * character indicating the start of an HL7 message
     */
    public static final char START_MESSAGE = '\u000b';
    
    /**
     * The final character of a message: a carriage return. NB: This is per the minimal lower layer protocol.
     */
    public static final char LAST_CHARACTER = 13;

    /** Creates a MinLLPReader with no setup - setInputStream must be set later. 
    */
    public MinLLPReader() 
    {
    }
    
    /** Creates a MinLLPReader which reads from the given InputStream. The stream
     *  is assumed to be an ASCII bit stream.
     */
    public MinLLPReader(InputStream in) throws IOException
    {
        setInputStream(in);
    }

    /** Creates a MinLLPReader which reads from the given InputStream. The stream
     *  is assumed to be an ASCII bit stream.
     */
    public MinLLPReader(InputStream in, Charset theCharset) throws IOException
    {
    	charset = theCharset;
        setInputStream(in);
    }

    /**
     * Sets the InputStream from which to read messages.  The InputStream must be set 
     * before any calls to <code>getMessage()</code>.
     */
    public synchronized void setInputStream(InputStream in) throws IOException 
    {
        if (charset != null) {
            myReader = new BufferedReader(new InputStreamReader(in, charset));
        } else { 
        	String charsetString = System.getProperty(CHARSET_KEY, "US-ASCII");
        	if (charsetString.equals("default")) {
	            myReader = new BufferedReader(new InputStreamReader(in));
	        } else {
	            myReader = new BufferedReader(new InputStreamReader(in, charsetString));
	        }
        }
    }

    /** Calls the same method in the underlying BufferedReader. */
    /**private int read(char[] parm1, int parm2, int parm3) throws java.io.IOException
    {
        return myReader.read(parm1, parm2, parm3);
    }*/

    /** Reads an HL7 encoded message from this Reader's InputStream.
        @return The message, in string format, without the lower level
        protocol delimeters. Returns null if a -1 is received on the initial
         read.
     */
    public synchronized String getMessage() throws LLPException, IOException 
    {
        StringBuffer s_buffer = new StringBuffer();

        boolean end_of_message = false;
                        
            int c = 0;
            try {
                c = myReader.read();  
            } catch (SocketTimeoutException e) {
                log.debug("SocketTimeoutException on read() attempt.");
                return null;               
            } catch (SocketException e) {
                log.info("SocketException on read() attempt.  Socket appears to have been closed: " + e.getMessage());
                throw e;
            }

            //trying to read when there is no data (stream may have been closed at other end)
            if (c == -1) {
                log.info("End of input stream reached.");
                throw new SocketException("End of input stream reached."); 
            }
            LowerLayerProtocol.logCharacterReceived(c);

            if (c != START_MESSAGE)
            {
                throw new LLPException("Message violates the "+
                    "minimal lower layer protocol: no start of message indicator "+
                    "received. Received: " + c);
            }

            while (! end_of_message)
            {
                c = myReader.read();

                if (c == -1)
                {
                    throw new LLPException("Message violates the "+
                        "minimal lower protocol: message terminated without "+
                        "a terminating character.");
                }
                LowerLayerProtocol.logCharacterReceived(c);
                
                if (c == END_MESSAGE)
                {
                    //subsequent character should be a carriage return
                    c = myReader.read();
                    if (c >= 0) LowerLayerProtocol.logCharacterReceived(c);
                    if (c != LAST_CHARACTER)
                    {
                        throw new LLPException("Message "+
                            "violates the minimal lower layer protocol: "+
                            "message terminator not followed by a return "+
                            "character.");
                    }
                    end_of_message = true;
                }
                else
                {
                //the character wasn't the end of message, append it to the message
                    s_buffer.append((char) c);
                }
            } //end while

        return s_buffer.toString();
    }

    /** Test driver for the program. Bounces a message off of an echo socket,
     *  and ascertaines whether or not this class works.
     */
    public static void main(String args[])
    {
        try
        {
            Socket s = new Socket("142.224.51.2", 7);

            HL7Reader in = new MinLLPReader(s.getInputStream());
            HL7Writer out = new MinLLPWriter(s.getOutputStream());

            out.writeMessage("Some message.");
            System.out.println("wrote");
            String str = in.getMessage();
            System.out.println("read");

            System.out.println(str);
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }

    /** 
     * Closes the underlying BufferedReader.
     */
    public synchronized void close() throws java.io.IOException
    {
        myReader.close();
    }
    
        
}

