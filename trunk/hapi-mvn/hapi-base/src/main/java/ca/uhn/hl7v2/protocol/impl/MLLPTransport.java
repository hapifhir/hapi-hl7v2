/*
The contents of this file are subject to the Mozilla Public License Version 1.1 
(the "License"); you may not use this file except in compliance with the License. 
You may obtain a copy of the License at http://www.mozilla.org/MPL/ 
Software distributed under the License is distributed on an "AS IS" basis, 
WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the 
specific language governing rights and limitations under the License. 

The Original Code is "MLLPTransport.java".  Description: 
"An implementation of the HL7 Minimal Lower Layer Protocol." 

The Initial Developer of the Original Code is University Health Network. Copyright (C) 
2004.  All Rights Reserved. 

Contributor(s): ______________________________________. 

Alternatively, the contents of this file may be used under the terms of the 
GNU General Public License (the "GPL"), in which case the provisions of the GPL are 
applicable instead of those above.  If you wish to allow use of your version of this 
file only under the terms of the GPL and not to allow others to use your version 
of this file under the MPL, indicate your decision by deleting  the provisions above 
and replace  them with the notice and other provisions required by the GPL License.  
If you do not delete the provisions above, a recipient may use your version of 
this file under either the MPL or the GPL. 
*/

package ca.uhn.hl7v2.protocol.impl;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import ca.uhn.hl7v2.llp.LLPException;
import ca.uhn.hl7v2.llp.MinLLPReader;
import ca.uhn.hl7v2.llp.MinLLPWriter;
import ca.uhn.hl7v2.protocol.StreamSource;
import ca.uhn.hl7v2.protocol.TransportException;
import ca.uhn.hl7v2.protocol.TransportLayer;
import ca.uhn.hl7v2.protocol.Transportable;

/**
 * An implementation of the HL7 Minimal Lower Layer Protocol (see 
 * HL7 implementation guide appendix C).  Note that this is the most common 
 * protocol used in HL7 interfaces.  
 * 
 * @author <a href="mailto:bryan.tripp@uhn.on.ca">Bryan Tripp</a>
 * @version $Revision: 1.1 $ updated on $Date: 2007-02-19 02:24:26 $ by $Author: jamesagnew $
 */
public class MLLPTransport extends AbstractTransport implements TransportLayer {

    private MinLLPReader myReader;
    private MinLLPWriter myWriter;
    
    private StreamSource myStreamSource;
    private Properties myCharsetMappings;
    
    /**
     * @param theStreamSource the provider of input and output streams connected
     *      to the remote server 
     */
    public MLLPTransport(StreamSource theStreamSource) throws TransportException {
        myStreamSource = theStreamSource;
        myCharsetMappings = loadCharsetMappings();
    }
    
    private static Properties loadCharsetMappings() throws TransportException {
        Properties mappings = new Properties();
        String resource = "ca/uhn/hl7v2/protocol/impl/charset_map.properties";
        InputStream in = MLLPTransport.class.getClassLoader().getResourceAsStream(resource);
        try {
            mappings.load(in);
        } catch (IOException e) {
            throw new TransportException("Can't load character set mappings from " + resource, e);
        }
        return mappings;        
    }

    /** 
     * @see ca.uhn.hl7v2.protocol.AstractTransport#doSend(ca.uhn.hl7v2.protocol.Transportable)
     */
    public void doSend(Transportable theMessage) throws TransportException {
        try {
            String charset = (String) theMessage.getMetadata().get("MSH-18");
            if (charset != null) {
                charset = myCharsetMappings.getProperty(charset, charset); //default to self if no match
                myWriter.writeMessage(theMessage.getMessage(), charset); 
            } else {
                myWriter.writeMessage(theMessage.getMessage());
            }
        } catch (LLPException e) {
            throw new TransportException(e);
        } catch (IOException e) {
            throw new TransportException(e);
        }
    }

    /** 
     * @see ca.uhn.hl7v2.protocol.impl.AbstractTransport#doReceive()
     */
    public Transportable doReceive() throws TransportException {
        Transportable result = null;
        try {
            String message = myReader.getMessage();
            if (message != null) {
                result = new TransportableImpl(message);                
            }
        } catch (LLPException e) {
            throw new TransportException(e);
        } catch (IOException e) {
            throw new TransportException(e);
        }
        return result;
    }
    
    /**
     * @see ca.uhn.hl7v2.protocol.AbstractTransport#doConnect()
     */
    public void doConnect() throws TransportException {
        myStreamSource.connect();
        try {
            myReader = new MinLLPReader(myStreamSource.getInboundStream());
            myWriter = new MinLLPWriter(myStreamSource.getOutboundStream());
        } catch (IOException e) {
            throw new TransportException(e);
        } 
    }

    /**
     * @see ca.uhn.hl7v2.protocol.TransportLayer#disconnect()
     */
    public void doDisconnect() throws TransportException {
        try {
            if (myReader != null) myReader.close();
            if (myWriter != null) myWriter.close();
        } catch (IOException e) {
            throw new TransportException(e);
        } finally {
            myReader = null;
            myWriter = null;
        }        
        myStreamSource.disconnect();
    }
    
}
