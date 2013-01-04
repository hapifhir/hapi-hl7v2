package ca.uhn.hl7v2.hoh.hapi.client;

import java.net.URL;

import ca.uhn.hl7v2.hoh.api.IClientSimple;
import ca.uhn.hl7v2.hoh.raw.client.HohRawClientSimple;
import ca.uhn.hl7v2.parser.Parser;

public class HohClientSimple extends AbstractClient<HohRawClientSimple> implements IClientSimple {
	/**
	 * Constructor
	 * 
	 * @param theHost
	 *            The HOST (name/address). E.g. "192.168.1.1"
	 * @param thePort
	 *            The PORT. E.g. "8080"
	 * @param theUriPath
	 *            The URI being requested (must either be blank or start with
	 *            '/' and contain a path). E.g. "/Apps/Receiver.jsp"
	 */
	public HohClientSimple(String theHost, int thePort, String theUriPath) {
		super(new HohRawClientSimple(theHost, thePort, theUriPath), null);
	}

	/**
	 * Constructor
	 * 
	 * @param theHost
	 *            The HOST (name/address). E.g. "192.168.1.1"
	 * @param thePort
	 *            The PORT. E.g. "8080"
	 * @param theUriPath
	 *            The URI being requested (must either be blank or start with
	 *            '/' and contain a path). E.g. "/Apps/Receiver.jsp"
	 * @param theParser
	 *            The Parser to use, or <code>null</code> in which case a
	 *            PipeParser will be used
	 */
	public HohClientSimple(String theHost, int thePort, String theUriPath, Parser theParser) {
		super(new HohRawClientSimple(theHost, thePort, theUriPath), theParser);
	}

	/**
	 * Constructor
	 * 
	 * @param theUrl
	 *            The URL to send messages to
	 */
	public HohClientSimple(URL theUrl) {
		super(new HohRawClientSimple(theUrl), null);
	}

	/**
	 * Constructor
	 * 
	 * @param theUrl
	 *            The URL to send messages to
	 * @param theParser
	 *            The Parser to use, or <code>null</code> in which case a
	 *            PipeParser will be used
	 */
	public HohClientSimple(URL theUrl, Parser theParser) {
		super(new HohRawClientSimple(theUrl), theParser);
	}

	/**
	 * {@inheritDoc}
	 */
	public void close() {
		getRawClient().close();
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean isAutoClose() {
		return getRawClient().isAutoClose();
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean isConnected() {
		return getRawClient().isConnected();
	}

	/**
	 * {@inheritDoc}
	 */
	public void setAutoClose(boolean theAutoClose) {
		getRawClient().setAutoClose(theAutoClose);
	}

}
