package ca.uhn.hl7v2.protocol;


public class MetadataKeys {

	private MetadataKeys() {
		// nothing
	}
	
	/**
	 * Contains the raw message as it was received
	 */
	public static final String IN_RAW_MESSAGE = "raw-message";

	/**
	 * Charset (MSH-18)
	 */
	public static final String IN_MESSAGE_CHARSET = "MSH-18";

	/**
	 * Message control ID (MSH-10)
	 */
	public static final String IN_MESSAGE_CONTROL_ID = "/MSH-10";
	
    /**
	 * Provides the IP of the sending system for a given message
	 */
	public static final String IN_SENDING_IP = "SENDING_IP";

}
