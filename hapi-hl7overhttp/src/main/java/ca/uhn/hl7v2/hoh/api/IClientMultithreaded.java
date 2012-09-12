package ca.uhn.hl7v2.hoh.api;

public interface IClientMultithreaded extends IClient {

	/**
	 * <p>
	 * Sets the number of millis to keep an idle socket open before closing it.
	 * This value may be changed at any time.
	 * </p>
	 * <p>
	 * Note that this parameter is respected on a best-effort basis, timeouts
	 * may be different, especially under heavy load
	 * </p>
	 */
	public abstract void setSocketTimeout(long theSocketTimeout);

}