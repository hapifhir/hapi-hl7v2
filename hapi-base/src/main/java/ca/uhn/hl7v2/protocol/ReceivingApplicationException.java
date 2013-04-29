/**
The contents of this file are subject to the Mozilla Public License Version 1.1 
(the "License"); you may not use this file except in compliance with the License. 
You may obtain a copy of the License at http://www.mozilla.org/MPL/ 
Software distributed under the License is distributed on an "AS IS" basis, 
WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the 
specific language governing rights and limitations under the License. 

The Original Code is "ReceivingApplicationException.java".  Description: 
"Represents any problem encountered during processing of a message by a 
ReceivingApplication" 

The Initial Developer of the Original Code is University Health Network. Copyright (C) 
2002, 2005.  All Rights Reserved. 

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
package ca.uhn.hl7v2.protocol;

import java.util.Map;

/**
 * Represents any problem encountered during processing of a message by a 
 * <code>ReceivingApplication</code>.
 * 
 * Note that this replaces ca.uhn.hl7v2.app.ApplicationException in HAPI 0.5.  
 *   
 * @author <a href="mailto:bryan.tripp@uhn.on.ca">Bryan Tripp</a>
 * @version $Revision: 1.1 $ updated on $Date: 2007-02-19 02:24:38 $ by $Author: jamesagnew $
 */
public class ReceivingApplicationException extends Exception {

    private String incomingMessage;
    private String outgoingMessage;
    private Map<String, Object> incomingMetadata;

    /**
     * Constructs an instance of <code>ReceivingApplicationException</code> with the specified detail message.
     */
    public ReceivingApplicationException(String msg) {
        super(msg);
    }
    
    /**
     * Constructs a new exception with the specified underlying cause.
     *  
     * @param cause an exception that is the reason for this exception
     */
    public ReceivingApplicationException(Throwable cause) {
        super(cause);
    }
    
    /**
     * Constructs a new exception with the specified underlying cause
     * and detail message.
     *  
     * @param msg detail message 
     * @param cause an exception that is the reason for this exception
     */
    public ReceivingApplicationException(String msg, Throwable cause) {
        super(msg, cause);
    }

    public ReceivingApplicationException(Throwable cause, String incomingMessage, String outgoingMessage, Map<String, Object> incomingMetadata) {
        super(cause);
        this.incomingMessage = incomingMessage;
        this.outgoingMessage = outgoingMessage;
        this.incomingMetadata = incomingMetadata;
    }

    public String getIncomingMessage() {
        return incomingMessage;
    }


    public String getOutgoingMessage() {
        return outgoingMessage;
    }

    public Map<String, Object> getIncomingMetadata() {
        return incomingMetadata;
    }

}
