package ca.uhn.hl7v2.hoh.hapi.client;

import java.net.URL;
import java.util.concurrent.ScheduledExecutorService;

import ca.uhn.hl7v2.hoh.api.IClientMultithreaded;
import ca.uhn.hl7v2.hoh.raw.client.HohRawClientMultithreaded;
import ca.uhn.hl7v2.parser.Parser;

/**
 * <p>
 * Message sender using the HL7 over HTTP specification which uses a 
 * {@link ScheduledExecutorService} to provide advanced functionality such
 * as persistent connections which time out and close automatically.
 * </p>
 * <p>
 * This connector uses an executor service which can start worker threads, 
 * so use caution if embedding within a J2EE container.
 * </p>
 */
public class HohClientMultithreaded extends AbstractClient<HohRawClientMultithreaded> implements IClientMultithreaded {

	/**
	 * Constructor
	 */
	public HohClientMultithreaded() {
		super(new HohRawClientMultithreaded());
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
	 */
	public HohClientMultithreaded(String theHost, int thePort, String theUriPath) {
		super(new HohRawClientMultithreaded(theHost, thePort, theUriPath), null);
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
	public HohClientMultithreaded(String theHost, int thePort, String theUriPath, Parser theParser) {
		super(new HohRawClientMultithreaded(theHost, thePort, theUriPath), theParser);
	}

	/**
	 * Constructor
	 * 
	 * @param theUrl
	 *            The URL to send messages to
	 */
	public HohClientMultithreaded(URL theUrl) {
		super(new HohRawClientMultithreaded(theUrl), null);
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
	public HohClientMultithreaded(URL theUrl, Parser theParser) {
		super(new HohRawClientMultithreaded(theUrl), theParser);
	}

	/**
	 * {@inheritDoc}
	 */
	public long getSocketTimeout() {
		return getRawClient().getSocketTimeout();
	}

	/**
	 * {@inheritDoc}
	 */
	public void setSocketTimeout(long theSocketTimeout) {
		getRawClient().setSocketTimeout(theSocketTimeout);
	}

}
