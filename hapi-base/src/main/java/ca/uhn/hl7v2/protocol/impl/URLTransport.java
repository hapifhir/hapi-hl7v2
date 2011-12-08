/*
The contents of this file are subject to the Mozilla Public License Version 1.1 
(the "License"); you may not use this file except in compliance with the License. 
You may obtain a copy of the License at http://www.mozilla.org/MPL/ 
Software distributed under the License is distributed on an "AS IS" basis, 
WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the 
specific language governing rights and limitations under the License. 

The Original Code is "URLTransport.java".  Description: 
"A TransportLayer that reads and writes from an URL." 

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

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.net.URL;
import java.net.URLConnection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ca.uhn.hl7v2.protocol.TransportException;
import ca.uhn.hl7v2.protocol.TransportLayer;
import ca.uhn.hl7v2.protocol.Transportable;

/**
 * A <code>TransportLayer</code> that reads and writes from an URL (for example
 * over HTTP).    
 * 
 * @author <a href="mailto:bryan.tripp@uhn.on.ca">Bryan Tripp</a>
 * @author <a href="mailto:alexei.guevara@uhn.on.ca">Alexei Guevara</a>
 * @version $Revision: 1.1 $ updated on $Date: 2007-02-19 02:24:26 $ by $Author: jamesagnew $
 */
public class URLTransport extends AbstractTransport implements TransportLayer {
    
    private static final Logger log = LoggerFactory.getLogger(URLTransport.class);    

    /**
     * Key in Transportable metadata map under which URL is stored.  
     */
    public static final String URL_KEY = "URL";

    private String myContentType = "application/hl7+doc+xml";
    private URL myURL;
    private URLConnection myConnection;
    protected int myBufferSize = 3000;
    
    private final boolean myConnectOnSend;
    private final boolean myConnectOnReceive;
    private final boolean myConnectOnConnect;

    /**
     * The boolean configuration flags determine when new connections are made.  For example if this 
     * transport is being used for query/response, you might set connectOnSend to true and
     * the others to false, so that each query/response is done over a fresh connection.  If 
     * you are using a transport just to read data from a URL, you might set connectOnReceive to 
     * true and the others to false.  
     *  
     * @param theURL the URL at which messages are to be read and written 
     * @param connectOnSend makes a new connection before each send  
     * @param connectOnReceive makes a new connection before each receive 
     * @param connectOnConnect makes a new connection when connect() is called 
     */
    public URLTransport(URL theURL, boolean connectOnSend, boolean connectOnReceive, boolean connectOnConnect) {
        myURL = theURL;
        getCommonMetadata().put(URL_KEY, theURL);
        
        myConnectOnSend = connectOnSend;
        myConnectOnReceive = connectOnReceive;
        myConnectOnConnect = connectOnConnect;
    }

    /** 
     * Writes the given message to the URL. 
     * 
     * @param theMessage the message to send 
     * @see ca.uhn.hl7v2.protocol.AbstractTransport#doSend(ca.uhn.hl7v2.protocol.Transportable)
     */
    public void doSend(Transportable theMessage) throws TransportException {
        if (myConnectOnSend) {
            makeConnection();
        }

        try {
            Writer out = new OutputStreamWriter(new BufferedOutputStream(myConnection.getOutputStream()));
            out.write(theMessage.getMessage());
            out.flush();
        } catch (IOException e) {
            throw new TransportException(e);
        }
    }

    /**
     * @see ca.uhn.hl7v2.protocol.AbstractTransport#doReceive()
     */
    public Transportable doReceive() throws TransportException {
        
        if (myConnectOnReceive) {
            makeConnection();
        }

        StringBuffer response = new StringBuffer();

        try {
            log.debug("Getting InputStream from URLConnection");
            Reader in = new InputStreamReader(new BufferedInputStream(myConnection.getInputStream()));
            log.debug("Got InputStream from URLConnection");

            char[] buf = new char[myBufferSize];
            int bytesRead = 0;

            IntRef bytesReadRef = new IntRef();

            while (bytesRead >= 0) {

                try {
                    ReaderThread readerThread = new ReaderThread(in, buf, bytesReadRef);
                    readerThread.start();
                    readerThread.join(10000);

                    bytesRead = bytesReadRef.getValue();

                    if (bytesRead == 0) {
                        throw new TransportException("Timeout waiting for response");
                    }
                }
                catch (InterruptedException x) {
                }

                if (bytesRead > 0) {
                    response.append(buf, 0, bytesRead);
                }

            }

            in.close();
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        }

        if (response.length() == 0) {
            throw new TransportException("Timeout waiting for response");
        }

        return new TransportableImpl(response.toString());
    }


    /** 
     * Calls openConnection() on the underlying URL and configures the connection, 
     * if this transport is configured to connect when connect() is called (see 
     * constructor params).
     *   
     * @see ca.uhn.hl7v2.protocol.AbstractTransport#doConnect()
     */
    public void doConnect() throws TransportException {
        if (myConnectOnConnect) {
            makeConnection();
        }
    }
    
    //makes new connection 
    private void makeConnection() throws TransportException {
        try {
            myConnection = myURL.openConnection();
            myConnection.setDoOutput(true);
            myConnection.setDoInput(true);
            myConnection.setRequestProperty("Content-Type", getContentType());
            myConnection.connect();
        } catch (IOException e) {
            throw new TransportException(e);
        }     
        log.debug("Made connection to {}", myURL.toExternalForm());
    }
    
    /**
     * @return the string used in the request property "Content-Type" (defaults to 
     *      "application/hl7+doc+xml")
     */
    public String getContentType() {
        return myContentType;
    }
    
    /**
     * @param theContentType the string to be used in the request property "Content-Type" 
     *      (defaults to "application/hl7+doc+xml")
     */
    public void setContentType(String theContentType) {
        myContentType = theContentType;
    }

    /** 
     * @see ca.uhn.hl7v2.protocol.TransportLayer#disconnect()
     */
    public void doDisconnect() throws TransportException {
        myConnection = null;
    }
    
}
