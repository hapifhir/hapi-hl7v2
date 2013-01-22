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
import java.util.Map;

import ca.uhn.hl7v2.AcknowledgmentCode;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.Segment;
import ca.uhn.hl7v2.protocol.ReceivingApplication;
import ca.uhn.hl7v2.protocol.ReceivingApplicationException;
import ca.uhn.hl7v2.util.DeepCopy;

/**
 * An Application that does nothing with the message and returns an Application
 * Reject message in response. To be used when there are no other Applications
 * that can process a given message.
 * 
 * @author Bryan Tripp
 * @author Christian Ohr
 */
public class DefaultApplication implements Application, ReceivingApplication {

	public static final String MSG_INTERNAL_ERROR = "Application internal error";
	public static final String MSG_NO_APPROPRIATE_DEST = "No appropriate destination could be found to which this message could be routed.";
	
	private final AcknowledgmentCode myAcknowledgmentCode;
	private final String myMessage;
	
	/**
	 * New instance which always returns an acknowledgment code of {@link AcknowledgmentCode#AR} and
	 * a message indicating that no appropriate handler could be found.
	 * 
	 * @see #MSG_NO_APPROPRIATE_DEST
	 */
	public DefaultApplication() {
		this(AcknowledgmentCode.AR);
	}

	/**
	 * <p>
	 * New instance which always uses the given acknowledgment code, and generates an
	 * appropriate message for the given code, according to the following rules:
	 * </p>
	 * <table>
	 * <tr><th>Code</th><th>Message</th></tr>
	 * <tr>
	 * 		<td>{@link AcknowledgmentCode#AA}<br/>{@link AcknowledgmentCode#AA}</td>
	 * 		<td><code>null</code> (no message)</td>
	 * </tr>
	 * <tr>
	 * 		<td>{@link AcknowledgmentCode#AR}<br/>{@link AcknowledgmentCode#AR}</td>
	 * 		<td>{@link #MSG_NO_APPROPRIATE_DEST}</td>
	 * </tr>
	 * <tr>
	 * 		<td>{@link AcknowledgmentCode#AE}<br/>{@link AcknowledgmentCode#AE}</td>
	 * 		<td>{@link #MSG_INTERNAL_ERROR}</td>
	 * </tr>
	 * </table>
	 * 
	 * @param theAcknowledgmentCode The code to always use (must not be null)
	 */
	public DefaultApplication(AcknowledgmentCode theAcknowledgmentCode) {
		this(theAcknowledgmentCode, defaultMessage(theAcknowledgmentCode));
	}

	/**
	 * New instance which always uses the given acknowledgment code and message
	 *  
	 * @param theAcknowledgmentCode The code to always use (must not be null)
	 * @param theMessage The message (may be null, in which case no message will be given)
	 */
	public DefaultApplication(AcknowledgmentCode theAcknowledgmentCode, String theMessage) {
		if (theAcknowledgmentCode == null) {
			throw new NullPointerException("Acknowledgment code must not be null");
		}
		myAcknowledgmentCode = theAcknowledgmentCode;
		myMessage = theMessage;
	}

	private static String defaultMessage(AcknowledgmentCode theAr) {
		switch (theAr) {
		case AA:
		case CA:
			return null;
		case AR:
		case CR:
			return MSG_NO_APPROPRIATE_DEST;
		case AE:
		case CE:
		default:
			return MSG_INTERNAL_ERROR;
		}
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
			return processMessage(in, null);
		} catch (ReceivingApplicationException e) {
			throw new ApplicationException(e.getMessage(), e);
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
	 * @param message message
	 *            the MSH segment if the inbound message
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

	public Message processMessage(Message theMessage, Map<String, Object> theMetadata) throws ReceivingApplicationException {
		try {
			if (myMessage != null) {
				return theMessage.generateACK(myAcknowledgmentCode, new HL7Exception(myMessage));
			} else {
				return theMessage.generateACK(myAcknowledgmentCode, null);
			}
		} catch (Exception e) {
			throw new ReceivingApplicationException("Couldn't create response message: "
					+ e.getMessage());
		}
	}

}
