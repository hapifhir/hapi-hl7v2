package ca.uhn.hl7v2.hoh.hapi.client;

import java.io.IOException;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.hoh.api.DecodeException;
import ca.uhn.hl7v2.hoh.api.EncodeException;
import ca.uhn.hl7v2.hoh.api.IReceivable;
import ca.uhn.hl7v2.hoh.api.ISendable;
import ca.uhn.hl7v2.hoh.hapi.api.MessageReceivable;
import ca.uhn.hl7v2.hoh.raw.client.HohRawClientSimple;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.parser.EncodingNotSupportedException;
import ca.uhn.hl7v2.parser.Parser;

public class HohClientSimple extends HohRawClientSimple {

	private Parser myParser;

	/**
	 * Constructor
	 * 
	 * @param theHost
	 *            The HOST (name/address). E.g. "192.168.1.1"
	 * @param thePort
	 *            The PORT. E.g. "8080"
	 * @param theUri
	 *            The URI being requested (must either be blank or start with
	 *            '/' and contain a path). E.g. "/Apps/Receiver.jsp"
	 */
	public HohClientSimple(String theHost, int thePort, String theUri, Parser theParser) {
		super(theHost, thePort, theUri);
		myParser = theParser;

		if (myParser == null) {
			throw new NullPointerException("Parser may not be null");
		}
	}

	/**
	 * Sends a message, waits for the response, and then returns the response if
	 * any
	 * 
	 * @param theMessageToSend
	 *            The message to send
	 * @return The returned message, as well as associated metadata
	 * @throws DecodeException
	 *             If a problem occurs (read error, socket disconnect, etc.)
	 *             during communication, or the response is invalid in some way.
	 *             Note that IO errors in trying to connect to the remote host
	 *             or sending the message are thrown directly (i.e. as
	 *             {@link IOException}), but IO errors in reading the response
	 *             are thrown as DecodeException
	 * @throws IOException
	 *             If the client is unable to connect to the remote host
	 * @throws EncodeException
	 *             If a failure occurs while encoding the message into a
	 *             sendable HTTP request
	 * @throws HL7Exception
	 *             If the response can not be parsed
	 * @throws EncodingNotSupportedException
	 *             If the encoding is not supported
	 */
	public IReceivable<Message> sendAndReceiveMessage(ISendable theMessageToSend) throws DecodeException, IOException, EncodeException, EncodingNotSupportedException, HL7Exception {
		IReceivable<String> response = super.doSendAndReceive(theMessageToSend);
		return new MessageReceivable(myParser.parse(response.getRawMessage()));
	}

}
