package ca.uhn.hl7v2.hoh.encoder;

/**
 * This exception is intended to communicate that no message arrived
 * at a time when none might yet be expected (e.g. because the other
 * system is taking a long time processing).
 */
public class NoMessageReceivedException extends Exception {

	private static final long serialVersionUID = 1L;

}
