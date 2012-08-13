package ca.uhn.hl7v2.testpanel.util;

public interface IProgressCallback {

	void activityStarted();

	void activityStopped();

	void progressUpdate(double theProgress) throws OperationCancelRequestedException;
	
	/**
	 * Thrown if the UI is requesting a cancel
	 */
	public class OperationCancelRequestedException extends Exception
	{
		/**
		 * Constructor
		 */
		public OperationCancelRequestedException() {
			super();
		}
	}
	
}
