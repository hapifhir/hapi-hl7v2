package ca.uhn.hl7v2.hoh.api;

public interface IClientSimple extends IClient {

	/**
	 * If a socket exists and it is connected, closes the socket. Only required
	 * if {@link #isAutoClose() auto close} mode is false
	 */
	public abstract void close();

	/**
	 * @return Should the socket auto-close
	 * @see #setAutoClose(boolean)
	 */
	public abstract boolean isAutoClose();

	/**
	 * @return Returns true if there is a socket, and it appears to be connected
	 *         and not shut down
	 */
	public abstract boolean isConnected();

	/**
	 * <p>
	 * Sets the auto-close property. If set to true (which is the default), the
	 * client will close the socket between each request. If set to
	 * <code>false</code>, the client will keep the socket open between
	 * requests.
	 * </p>
	 * <p>
	 * If auto-close is disabled, sockets will never automatically disconnect,
	 * which some servers may not like. The socket can still be closed by
	 * calling {@link #close()}.
	 * </p>
	 */
	public abstract void setAutoClose(boolean theAutoClose);

}