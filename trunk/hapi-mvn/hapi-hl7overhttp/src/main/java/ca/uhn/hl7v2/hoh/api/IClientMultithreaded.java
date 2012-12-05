package ca.uhn.hl7v2.hoh.api;

import ca.uhn.hl7v2.hoh.raw.client.HohRawClientMultithreaded;

public interface IClientMultithreaded extends IClient {

	/**
	 * <p>
	 * Sets the number of millis to keep an idle socket open before closing it.
	 * This value may be changed at any time. Default is
	 * {@link HohRawClientMultithreaded#DEFAULT_SOCKET_TIMEOUT}
	 * </p>
	 * <p>
	 * A value of -1 indicates that connections do not time out (use with caution).
	 * </p>
	 * <p>
	 * Note that this parameter is respected on a best-effort basis, timeouts
	 * may be different, especially under heavy load
	 * </p>
	 */
	public abstract void setSocketTimeout(long theSocketTimeout);

	/**
	 * <p>
	 * Returns the number of millis to keep an idle socket open before closing it.
	 * </p>
	 */
	public abstract long getSocketTimeout();

}