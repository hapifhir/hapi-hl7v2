package ca.uhn.hl7v2.hoh.hapi.client;

import java.io.IOException;
import java.net.URL;
import java.nio.charset.Charset;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.hoh.api.DecodeException;
import ca.uhn.hl7v2.hoh.api.EncodeException;
import ca.uhn.hl7v2.hoh.api.IAuthorizationClientCallback;
import ca.uhn.hl7v2.hoh.api.IClient;
import ca.uhn.hl7v2.hoh.api.IReceivable;
import ca.uhn.hl7v2.hoh.api.ISendable;
import ca.uhn.hl7v2.hoh.hapi.api.MessageReceivable;
import ca.uhn.hl7v2.hoh.hapi.api.MessageSendable;
import ca.uhn.hl7v2.hoh.raw.client.AbstractRawClient;
import ca.uhn.hl7v2.hoh.sign.ISigner;
import ca.uhn.hl7v2.hoh.sockets.ISocketFactory;
import ca.uhn.hl7v2.hoh.util.Validate;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.parser.EncodingNotSupportedException;
import ca.uhn.hl7v2.parser.Parser;

public abstract class AbstractClient<T extends AbstractRawClient> implements IClient {

	private Parser myParser;
	private T myRawClient;

	/**
	 * Constructor
	 * 
	 * @param theRawClient
	 *            The Raw client to wrap (may not be null)
	 */
	public AbstractClient(T theRawClient) {
		this(theRawClient, null);
	}

	/**
	 * {@inheritDoc}
	 */
	public void setKeepAlive(boolean theKeepAlive) {
		getRawClient().setKeepAlive(theKeepAlive);
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean isKeepAlive() {
		return getRawClient().isKeepAlive();
	}

	/**
	 * {@inheritDoc}
	 */
	public void setSoTimeout(int theSoTimeout) {
		getRawClient().setSoTimeout(theSoTimeout);
	}

	/**
	 * {@inheritDoc}
	 */
	public int getSoTimeout() {
		return getRawClient().getSoTimeout();
	}

	/**
	 * Constructor
	 * 
	 * @param theRawClient
	 *            The Raw client to wrap (may not be null)
	 * @param theParser
	 *            The parser to use (may be null, in which case the parser
	 *            contained within the sent message will be used
	 */
	protected AbstractClient(T theRawClient, Parser theParser) {
		Validate.notNull(theRawClient, "rawClient");
		myRawClient = theRawClient;
		myParser = theParser;
	}

	public String getHost() {
		return myRawClient.getHost();
	}

	/**
	 * Returns the {@link Parser} to use to parsing and encoding messages within
	 * this client (may return null)
	 */
	public Parser getParser() {
		return myParser;
	}

	/**
	 * {@inheritDoc}
	 */
	public int getPort() {
		return myRawClient.getPort();
	}

	/**
	 * {@inheritDoc}
	 */
	protected T getRawClient() {
		return myRawClient;
	}

	/**
	 * {@inheritDoc}
	 */
	public ISocketFactory getSocketFactory() {
		return myRawClient.getSocketFactory();
	}

	/**
	 * {@inheritDoc}
	 */
	public String getUriPath() {
		return myRawClient.getUriPath();
	}

	/**
	 * {@inheritDoc}
	 */
	public URL getUrl() {
		return myRawClient.getUrl();
	}

	/**
	 * {@inheritDoc}
	 */
	public String getUrlString() {
		return myRawClient.getUrlString();
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
	public IReceivable<Message> sendAndReceiveMessage(ISendable<Message> theMessageToSend) throws DecodeException, IOException, EncodeException, EncodingNotSupportedException, HL7Exception {
		IReceivable<String> response = myRawClient.sendAndReceive(theMessageToSend);
		Parser parser = myParser != null ? myParser : theMessageToSend.getMessage().getParser();
		return new MessageReceivable(parser.parse(response.getMessage()));
	}

	/**
	 * Sends a message, waits for the response, and then returns the response if
	 * any (this method is a convenience method for {@link #sendAndReceiveMessage(ISendable)}
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
	public IReceivable<Message> sendAndReceiveMessage(Message theMessageToSend) throws DecodeException, IOException, EncodeException, EncodingNotSupportedException, HL7Exception {
		MessageSendable sendable = new MessageSendable(theMessageToSend);
		return sendAndReceiveMessage(sendable);
	}

	/**
	 * {@inheritDoc}
	 */
	public void setAuthorizationCallback(IAuthorizationClientCallback theAuthorizationCallback) {
		myRawClient.setAuthorizationCallback(theAuthorizationCallback);
	}

	/**
	 * {@inheritDoc}
	 */
	public void setCharset(Charset theCharset) {
		myRawClient.setCharset(theCharset);
	}

	/**
	 * {@inheritDoc}
	 */
	public void setHost(String theHost) {
		myRawClient.setHost(theHost);
	}

	/**
	 * Sets the {@link Parser} to use to parsing and encoding messages within
	 * this client
	 */
	public void setParser(Parser theParser) {
		Validate.notNull(theParser, "parser");
		myParser = theParser;
	}

	/**
	 * {@inheritDoc}
	 */
	public void setUriPath(String thePath) {
		myRawClient.setUriPath(thePath);
	}

	/**
	 * {@inheritDoc}
	 */
	public void setPort(int thePort) {
		myRawClient.setPort(thePort);
	}

	/**
	 * {@inheritDoc}
	 */
	public void setResponseTimeout(long theResponseTimeout) {
		myRawClient.setResponseTimeout(theResponseTimeout);
	}

	/**
	 * {@inheritDoc}
	 */
	public void setSigner(ISigner theSigner) {
		myRawClient.setSigner(theSigner);
	}

	/**
	 * {@inheritDoc}
	 */
	public void setSocketFactory(ISocketFactory theSocketFactory) {
		myRawClient.setSocketFactory(theSocketFactory);
	}

	/**
	 * {@inheritDoc}
	 */
	public void setUrl(URL theUrl) {
		myRawClient.setUrl(theUrl);
	}

	/**
	 * {@inheritDoc}
	 */
	public void setUrlString(String theString) {
		myRawClient.setUrlString(theString);
	}

}
