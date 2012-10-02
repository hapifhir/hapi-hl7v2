/**
The contents of this file are subject to the Mozilla Public License Version 1.1 
(the "License"); you may not use this file except in compliance with the License. 
You may obtain a copy of the License at http://www.mozilla.org/MPL/ 
Software distributed under the License is distributed on an "AS IS" basis, 
WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the 
specific language governing rights and limitations under the License. 

The Original Code is "DefaultApplication.java".  Description: 
"An Application that does nothing with the message and returns an Application 
 Reject message in response." 

The Initial Developer of the Original Code is University Health Network. Copyright (C) 
2002.  All Rights Reserved. 

Contributor(s): ______________________________________. 

Alternatively, the contents of this file may be used under the terms of the 
GNU General Public License (the  "GPL"), in which case the provisions of the GPL are 
applicable instead of those above.  If you wish to allow use of your version of this 
file only under the terms of the GPL and not to allow others to use your version 
of this file under the MPL, indicate your decision by deleting  the provisions above 
and replace  them with the notice and other provisions required by the GPL License.  
If you do not delete the provisions above, a recipient may use your version of 
this file under either the MPL or the GPL. 
 */

package ca.uhn.hl7v2.app;

import java.io.IOException;

import ca.uhn.hl7v2.AcknowledgmentCode;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.model.DataTypeException;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.Segment;
import ca.uhn.hl7v2.util.DeepCopy;

/**
 * An Application that does nothing with the message and returns an Application
 * Reject message in response. To be used when there are no other Applications
 * that can process a given message.
 * 
 * @author Bryan Tripp
 * @author Christian Ohr
 */
public class DefaultApplication implements Application {

	public DefaultApplication() {
	}

	/**
	 * Returns true.
	 */
	public boolean canProcess(Message in) {
		return true;
	}

	/**
	 * Creates and returns a negative acknowledgement  
	 */
	public Message processMessage(Message in) throws ApplicationException {
		try {
			// get default ACK
			return in.generateACK(
					AcknowledgmentCode.AR, 
					new HL7Exception("No appropriate destination could be found to which this message could be routed."));
		} catch (Exception e) {
			throw new ApplicationException("Couldn't create response message: "
					+ e.getMessage());
		}
	}

	/**
	 * Creates an ACK message with the minimum required information from an
	 * inbound message. Optional fields can be filled in afterwards, before the
	 * message is returned. Please note that MSH-10, the outbound message
	 * control ID, is also set using the class
	 * <code>ca.uhn.hl7v2.util.MessageIDGenerator</code>. Also note that the ACK
	 * messages returned is the same version as the version stated in the
	 * inbound MSH if there is a generic ACK for that version, otherwise a
	 * version 2.4 ACK is returned. MSA-1 is set to AA by default.
	 * 
	 * @param inboundHeader
	 *            the MSH segment if the inbound message
	 * @throws IOException
	 *             if there is a problem reading or writing the message ID file
	 * @throws DataTypeException
	 *             if there is a problem setting ACK values
	 * 
	 * @deprecated use {@link Message#generateACK()}
	 */
	public static Message makeACK(Message message) throws HL7Exception, IOException {
		return message.generateACK();
	}
	
	/**
	 * @deprecated use {@link Message#generateACK()}
	 */
	public static Message makeACK(Segment inboundHeader) throws HL7Exception,
			IOException {
		// Make sure that the referenced message is not just a dummy
		DeepCopy.copy(inboundHeader, (Segment)inboundHeader.getMessage().get("MSH"));
		return inboundHeader.getMessage().generateACK();
	}

}
