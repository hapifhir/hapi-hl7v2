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
import java.util.Date;
import java.util.GregorianCalendar;

import ca.uhn.hl7v2.AcknowledgementCode;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.Version;
import ca.uhn.hl7v2.model.DataTypeException;
import ca.uhn.hl7v2.model.GenericMessage;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.Segment;
import ca.uhn.hl7v2.model.primitive.CommonTS;
import ca.uhn.hl7v2.parser.DefaultModelClassFactory;
import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.parser.Parser;
import ca.uhn.hl7v2.util.Terser;

/**
 * An Application that does nothing with the message and returns an Application
 * Reject message in response. To be used when there are no other Applications
 * that can process a given message.
 * 
 * @author Bryan Tripp
 */
public class DefaultApplication implements Application {

	/** Creates a new instance of DefaultApplication */
	public DefaultApplication() {
	}

	/**
	 * Returns true.
	 */
	public boolean canProcess(Message in) {
		return true;
	}

	/**
	 * Creates and returns an acknowledgement -- the details are determined by
	 * fillDetails().
	 */
	public Message processMessage(Message in) throws ApplicationException {
		try {
			// get default ACK
			Message out = makeACK(in);
			new HL7Exception("No appropriate destination could be found to which this message could be routed.")
				.populateResponse(out, AcknowledgementCode.AR, 0);
			return out;
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
	 * TODO this should be refactored as instance method in AbstractMessage. This
	 * method can forward and become deprecated
	 */
	public static Message makeACK(Message message) throws HL7Exception, IOException {
		return makeACK((Segment)message.get("MSH"));
	}
	
	// TODO this should be refactored as instance method in AbstractMessage
	// This method can forward and become deprecated
	public static Message makeACK(Segment inboundHeader) throws HL7Exception,
			IOException {
		if (!inboundHeader.getName().equals("MSH"))
			throw new HL7Exception(
					"Need an MSH segment to create a response ACK (got "
							+ inboundHeader.getName() + ")");

		// make ACK of correct version
		Class<? extends Message> clazz = null;
		try {
			Message inbound = inboundHeader.getMessage();
			Parser p = inbound.getParser();
			ModelClassFactory mcf = p != null ? p.getFactory() : new DefaultModelClassFactory();
			String version = inbound.getVersion();
			Message out = null;
			Version versionEnum = Version.versionOf(version);
			if (version != null && versionEnum != null && versionEnum.available()) {
				clazz = mcf.getMessageClass("ACK", version, false);
				if (clazz != null) {
					out = clazz.newInstance();
				}
			}
			if (out == null) {
				out = new GenericMessage.UnknownVersion(mcf);
				out.addNonstandardSegment("MSA");
				out.addNonstandardSegment("ERR");
			}
			Terser terser = new Terser(out);

			// populate outbound MSH using data from inbound message ...
			Segment outHeader = (Segment) out.get("MSH");
			fillResponseHeader(inboundHeader, outHeader);

			terser.set("/MSH-9-1", "ACK");
			terser.set("/MSH-9-2", Terser.get(inboundHeader, 9, 0, 2, 1));
			if (!Version.V25.isGreaterThan(versionEnum)) {
				terser.set("/MSH-9-3", "ACK");
			}
			terser.set("/MSH-12", Terser.get(inboundHeader, 12, 0, 1, 1));
			terser.set("/MSA-1", AcknowledgementCode.AA.name());
			terser.set("/MSA-2", Terser.get(inboundHeader, 10, 0, 1, 1));
			return out;

		} catch (Exception e) {
			throw new HL7Exception("Can't instantiate ACK", e);
		}

	}

	/**
	 * Populates certain required fields in a response message header, using
	 * information from the corresponding inbound message. The current time is
	 * used for the message time field, and <code>MessageIDGenerator</code> is
	 * used to create a unique message ID. Version and message type fields are
	 * not populated.
	 * 
	 * TODO move to AbstractMessage and deprecated
	 */
	public static void fillResponseHeader(Segment inbound, Segment outbound)
			throws HL7Exception, IOException {
		if (!inbound.getName().equals("MSH")
				|| !outbound.getName().equals("MSH"))
			throw new HL7Exception("Need MSH segments.  Got "
					+ inbound.getName() + " and " + outbound.getName());

		// get MSH data from incoming message ...
		String encChars = Terser.get(inbound, 2, 0, 1, 1);
		String fieldSep = Terser.get(inbound, 1, 0, 1, 1);
		String procID = Terser.get(inbound, 11, 0, 1, 1);

		// populate outbound MSH using data from inbound message ...
		Terser.set(outbound, 2, 0, 1, 1, encChars);
		Terser.set(outbound, 1, 0, 1, 1, fieldSep);
		GregorianCalendar now = new GregorianCalendar();
		now.setTime(new Date());
		Terser.set(outbound, 7, 0, 1, 1, CommonTS.toHl7TSFormat(now));
		Terser.set(outbound, 10, 0, 1, 1, inbound.getMessage().getParser().getParserConfiguration().getIdGenerator().getID());
		Terser.set(outbound, 11, 0, 1, 1, procID);

		// revert sender and receiver
		Terser.set(outbound, 3, 0, 1, 1, Terser.get(inbound, 5, 0, 1, 1));
		Terser.set(outbound, 4, 0, 1, 1, Terser.get(inbound, 6, 0, 1, 1));
		Terser.set(outbound, 5, 0, 1, 1, Terser.get(inbound, 3, 0, 1, 1));
		Terser.set(outbound, 6, 0, 1, 1, Terser.get(inbound, 4, 0, 1, 1));
	}

}
