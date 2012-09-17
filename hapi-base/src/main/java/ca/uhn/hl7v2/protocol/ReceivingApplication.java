/**
The contents of this file are subject to the Mozilla Public License Version 1.1 
(the "License"); you may not use this file except in compliance with the License. 
You may obtain a copy of the License at http://www.mozilla.org/MPL/ 
Software distributed under the License is distributed on an "AS IS" basis, 
WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the 
specific language governing rights and limitations under the License. 

The Original Code is "ReceivingApplication.java".  Description: 
"From an HL7 messaging perspective, a consumer of a messages" 

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

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.model.Message;

/**
 * <p>From an HL7 messaging perspective, a ReceivingApplication is a consumer of a messages. 
 * Once a parser parses an incoming message, the message would normally be forwarded 
 * to an application of some sort (e.g. a lab system) which would process the 
 * message in some way meaningful for it, and then return a response.</p>
 *   
 * <p>If you are wondering how to integrate HAPI into an existing server application, 
 * this is probably the place.  Create a class that implements ReceivingApplication, then look 
 * at HL7Server and ApplicationRouter to see how to get HAPI to listen for messages on 
 * a socket and pass them to your ReceivingApplication.</p>
 * 
 * Note that this interface replaces ca.uhn.hl7v2.app.Application in HAPI 0.5.   
 *   
 * @author <a href="mailto:bryan.tripp@uhn.on.ca">Bryan Tripp</a>
 * @version $Revision: 1.1 $ updated on $Date: 2007-02-19 02:24:38 $ by $Author: jamesagnew $
 */
public interface ReceivingApplication {

    /**
     * Uses the contents of the message for whatever purpose the application 
     * has for this message, and returns an appropriate response message.
     * 
     * @param theMessage an inbound HL7 message 
     * @param theMetadata message metadata (which may include information about where the message comes 
     *      from, etc).  This is the same metadata as in {@link ca.uhn.hl7v2.protocol.Transportable#getMetadata()}.  
     * 
     * @return an appropriate application response (for example an application ACK or query response). 
     *      Appropriate responses to different types of incoming messages are defined by HL7. 
     * 
     * @throws ReceivingApplicationException if there is a problem internal to the application (for example 
     *      a database problem)
     * @throws HL7Exception if there is a problem with the message 
     */
    public Message processMessage(Message theMessage, Map<String, Object> theMetadata) 
            throws ReceivingApplicationException, HL7Exception;
    
    /** 
     * @param theMessage an inbound HL7 message 
     * @return true if this ReceivingApplication wishes to accept the message.  By returning
     *      true, this Application declares itself the recipient of the message, accepts 
     *      responsibility for it, and must be able to respond appropriately to the sending system.  
     */
    public boolean canProcess(Message theMessage);

}
