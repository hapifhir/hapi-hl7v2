package ca.uhn.hl7v2.hoh.api;

import java.net.Socket;
import java.net.URL;
import java.nio.charset.Charset;

import ca.uhn.hl7v2.hoh.sign.ISigner;
import ca.uhn.hl7v2.hoh.sockets.ISocketFactory;
import ca.uhn.hl7v2.hoh.sockets.StandardSocketFactory;

public interface IClient {

	/**
	 * Getter for the host (e.g. "10.0.0.111" or "localhost")
	 */
	String getHost();

	/**
	 * Getter for the port (e.g. 80 for standard HTTP)
	 */
	int getPort();

	/**
	 * Returns the socket factory used by this client
	 */
	ISocketFactory getSocketFactory();

	/**
	 * Getter for the "Path" portion of the URL. This is the path portion which
	 * comes after the host and port, so for example if this client is being
	 * used to send messages to
	 * <code>http://somehost.com:8888/messaging/receiver.jsp</code>, the URI
	 * path portion would be <code>/messaging/receiver.jsp</code>
	 */
	String getUriPath();

	/**
	 * Getter for the URL to send messages to. 
	 */
	URL getUrl();

	/**
	 * If set, provides a callback which will be used to se the username and
	 * password associated with the request
	 */
	void setAuthorizationCallback(IAuthorizationClientCallback theAuthorizationCallback);

	/**
	 * <p>
	 * Sets the charset to use for requests from this client. May be changed at
	 * any time.
	 * </p>
	 * <p>
	 * Default is UTF-8
	 * </p>
	 */
	void setCharset(Charset theCharset);

	/**
	 * Setter for the host (e.g. "10.0.0.111" or "localhost")
	 */
	void setHost(String theHost);

	/**
	 * Configures the TCP KeepAlive flag for new connections
	 * 
	 * @see Socket#getKeepAlive()
	 */
	void setKeepAlive(boolean theKeepAlive);

	/**
	 * Returns the TCP KeepAlive flag for new connections
	 * 
	 * @see Socket#getKeepAlive()
	 */
	boolean isKeepAlive();

	/**
	 * Sets the TCP SO Timeout setting for new connections
	 * 
	 * @see Socket#getSoTimeout()
	 */
	void setSoTimeout(int theSoTimeout);

	/**
	 * Returns the TCP SO Timeout setting for new connections
	 * 
	 * @see Socket#getSoTimeout()
	 */
	int getSoTimeout();

	/**
	 * Setter for the "Path" portion of the URL. This is the path portion which
	 * comes after the host and port, so for example if this client is being
	 * used to send messages to
	 * <code>http://somehost.com:8888/messaging/receiver.jsp</code>, the URI
	 * path portion would be <code>/messaging/receiver.jsp</code>
	 */
	void setUriPath(String thePath);

	/**
	 * Getter for the port (e.g. 80 for standard HTTP)
	 */
	void setPort(int thePort);

	/**
	 * Sets the number of milliseconds before timing out. Default is
	 * {@link #DEFAULT_RESPONSE_TIMEOUT}
	 * 
	 * @param theResponseTimeout
	 *            The millis to wait before timeout.
	 * @see #DEFAULT_RESPONSE_TIMEOUT
	 */
	void setResponseTimeout(long theResponseTimeout);

	/**
	 * @param theSigner
	 *            If provided, sets the Signature Profile signer implementation
	 *            to use. See <a href=
	 *            "http://hl7api.sourceforge.net/hapi-hl7overhttp/specification.html#SIGNATURE_PROFILE"
	 *            >http://hl7api.sourceforge.net/hapi-hl7overhttp/specification.
	 *            html#SIGNATURE_PROFILE</a>
	 */
	void setSigner(ISigner theSigner);

	/**
	 * Sets the socket factory used by this client. Default is
	 * {@link StandardSocketFactory}.
	 * 
	 * @see ISocketFactory
	 */
	void setSocketFactory(ISocketFactory theSocketFactory);

	/**
	 * Setter for the URL to send messages to. 
	 * Note that invoking this method replaces any values that have been 
	 * provided to {@link #setHost(String)}, {@link #setPort(int)}, or {@link #setUriPath(String)}
	 */
	void setUrl(URL theUrl);

	/**
	 * Setter for the URL to send messages to. 
	 * Note that invoking this method replaces any values that have been 
	 * provided to {@link #setHost(String)}, {@link #setPort(int)}, or {@link #setUriPath(String)}
	 */
	void setUrlString(String theString);

	/**
	 * Getter for the URL to send messages to. 
	 */
	String getUrlString();

}