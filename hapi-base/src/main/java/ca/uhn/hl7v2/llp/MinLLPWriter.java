/**
The contents of this file are subject to the Mozilla Public License Version 1.1 
(the "License"); you may not use this file except in compliance with the License. 
You may obtain a copy of the License at http://www.mozilla.org/MPL/ 
Software distributed under the License is distributed on an "AS IS" basis, 
WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the 
specific language governing rights and limitations under the License. 

The Original Code is "MinLLPWriter.java".  Description: 
"Title:        MinLLPWriter
  Description:  Writes HL7 messages to an OutputStream
  Copyright:    Copyright (c) 2001
  Company:      University Health Network
  @author       Damian Horton
  @version 1.1" 

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

import java.io.*;
import java.nio.charset.Charset;

/**
 * Title:        MinLLPWriter
 * Description:  Writes HL7 messages to an OutputStream.  The character set defaults to US-ASCII.  
 * It can be chaged by setting the system property ca.uhn.hl7v2.llp.charset to another value that 
 * is the name of a valid java.nio.charset.Charset.  If this property is set to "default", then 
 * the system default is used. 
 * 
 * Copyright:    Copyright (c) 2001
 * Company:      University Health Network
 * @author       Damian Horton; mods by Bryan Tripp
 * @version 1.1
 */

public class MinLLPWriter implements HL7Writer
{
	/**
	 * @see MinLLPReader#CHARSET_KEY
	 */
    public static final String CHARSET_KEY = MinLLPReader.CHARSET_KEY;
    
    BufferedWriter myWriter; //reads from the input stream given in the
                             //constructor
    boolean messageStarted = false; //whether or not the necessary characters to
                            //initialize the message have already been buffered

    private OutputStream myOutputStream;

	private Charset charset;

    /**
     * Creates a MinLLPWriter with no output stream specified - <code>setOutputStream</code>
     * must be called before attempting to write any messages. 
     */
    public MinLLPWriter() {
    }
    
    /** 
     * Creates a MinLLPWriter, specifying the underlying output stream.
     */
    public MinLLPWriter(OutputStream out) throws IOException {
        setOutputStream(out);
    }
    
    /** 
     * Creates a MinLLPWriter, specifying the underlying output stream.
     */
    public MinLLPWriter(OutputStream out, Charset theCharset) throws IOException {
    	charset = theCharset;
        setOutputStream(out);
    }

    /** 
     * Sets the underlying output stream to which messages are written. 
     */
    public synchronized void setOutputStream(OutputStream out) throws IOException  
    {
        myOutputStream = out;
       	myWriter = new BufferedWriter(getWriter(out));
    }

    /** 
     * Sends a complete message to the underlying output stream, delimited 
     * according to the minimal lower layer protocol.  
     */
    public synchronized void writeMessage(String message) throws LLPException, IOException 
    {
        myWriter.write('\u000b');
        myWriter.write(message);
        myWriter.write('\u001c' + "\r");
        myWriter.flush();            
    }

    /** 
     * Sends a complete message to the underlying output stream, delimited 
     * according to the minimal lower layer protocol, using the specified character set. 
     */
    public synchronized void writeMessage(String message, String charset) throws LLPException, IOException 
    {
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(myOutputStream, charset));
        writer.write('\u000b');
        writer.write(message);
        writer.write('\u001c' + "\r");
        writer.flush();
    }

    public synchronized void close() throws java.io.IOException
    {
        myWriter.close();
    }
    
    private OutputStreamWriter getWriter(OutputStream theStream) throws IOException {
        
        if (charset != null) {
            return new OutputStreamWriter(theStream, charset);
        } else {
        	String charsetString = System.getProperty(CHARSET_KEY, "US-ASCII");
	        if (charsetString.equals("default")) {
	            return new OutputStreamWriter(theStream);
	        } else {
	            return new OutputStreamWriter(theStream, charsetString);
	        }
        }
    }
    
}