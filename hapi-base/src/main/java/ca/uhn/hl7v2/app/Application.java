/**
The contents of this file are subject to the Mozilla Public License Version 1.1 
(the "License"); you may not use this file except in compliance with the License. 
You may obtain a copy of the License at http://www.mozilla.org/MPL/ 
Software distributed under the License is distributed on an "AS IS" basis, 
WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the 
specific language governing rights and limitations under the License. 

The Original Code is "Application.java".  Description: 
"From an HL7 messaging perspective, a consumer of a messages" 

The Initial Developer of the Original Code is University Health Network. Copyright (C) 
2002.  All Rights Reserved. 

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

package ca.uhn.hl7v2.app;

import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.HL7Exception;

/**
 * <p>From an HL7 messaging perspective, an Application is a consumer of a messages. 
 * Once a parser parses an incoming message, the message would normally be forwarded 
 * to an Application of some sort (e.g. a lab system) which would process the 
 * message in some way meaningful for it, and then return a response.</p>  
 * <p>If you are wondering how to integrate HAPI into an existing server application, 
 * this is probably the place.  Create a class that implements Application, then look 
 * at Responder and SimpleServer to see how to get HAPI to listen for messages on 
 * a socket and pass them to your Application.</p>
 * @author  Bryan Tripp
 * 
 * @see ApplicationExceptionHandler
 * @see DefaultApplication
 * 
 */
public interface Application {

    /**
     * Uses the contents of the message for whatever purpose the Application 
     * has for this message, and returns an appropriate response message.   
     */
    public Message processMessage(Message in) throws ApplicationException, HL7Exception;
    
    /** 
     * Returns true if this Application wishes to accept the message.  By returning
     * true, this Application declares itself the recipient of the message, accepts 
     * responsibility for it, and must be able to respond appropriately to the sending system.  
     */
    public boolean canProcess(Message in);
}

