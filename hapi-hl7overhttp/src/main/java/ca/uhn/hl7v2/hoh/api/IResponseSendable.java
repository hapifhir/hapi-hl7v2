package ca.uhn.hl7v2.hoh.api;

import ca.uhn.hl7v2.hoh.encoder.ResponseCode;

/**
 * <p>
 * Response message to be returned by a server application.
 * </p>
 */
public interface IResponseSendable<T> extends ISendable<T> {

	ResponseCode getResponseCode();
	
}
