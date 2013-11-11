package ca.uhn.hl7v2.app;


/**
 * Contains configuration which will be applied to any servers which are created using the given
 * HAPI Context.
 * 
 * @see ca.uhn.hl7v2.HapiContext#getServerConfiguration()
 */
public class ServerConfiguration {

	private ApplicationExceptionPolicy myApplicationExceptionPolicy = ApplicationExceptionPolicy.DEFAULT;


	
	/**
	 * @see #setApplicationExceptionPolicy(ApplicationExceptionPolicy)
	 */
	public ApplicationExceptionPolicy getApplicationExceptionPolicy() {
		return myApplicationExceptionPolicy;
	}

	/**
	 * Sets the server behaviour when a {@link ca.uhn.hl7v2.protocol.ReceivingApplication} throws an exception while
	 * processing a message.
	 * <p>
	 * The {@link ApplicationExceptionPolicy#DEFAULT default} behaviour is to invoke the 
	 * {@link ca.uhn.hl7v2.protocol.ReceivingApplicationExceptionHandler exception handler} if one has been
	 * {@link HL7Service#setExceptionHandler(ca.uhn.hl7v2.protocol.ReceivingApplicationExceptionHandler) registered} 
	 * with the server, and then return the ACK/NAK message it provides. If no exception handler has
	 * been provided, HAPI will generate a NAK message using the default implementation and an
	 * {@link ca.uhn.hl7v2.protocol.impl.ApplicationRouterImpl#DEFAULT_EXCEPTION_ACKNOWLEDGEMENT_CODE AE} acknowlegement code.
	 * </p>
	 * 
	 * @see ApplicationExceptionPolicy For other possible values
	 */
	// NB: The default explanation part of this javadoc is duplicated below! Keep in sync!
	public void setApplicationExceptionPolicy(ApplicationExceptionPolicy applicationExceptionPolicy) {
		if (applicationExceptionPolicy == null) {
			throw new NullPointerException("Application Exception Policy must not be null");
		}
		myApplicationExceptionPolicy = applicationExceptionPolicy;
	}


	/**
	 * @see ServerConfiguration#setApplicationExceptionPolicy(ApplicationExceptionPolicy)
	 */
	public static enum ApplicationExceptionPolicy
	{

		/**
		 * The <code>DEFAULT</code> behaviour is to invoke the 
		 * {@link ca.uhn.hl7v2.protocol.ReceivingApplicationExceptionHandler exception handler} if one has been
		 * {@link HL7Service#setExceptionHandler(ca.uhn.hl7v2.protocol.ReceivingApplicationExceptionHandler) registered} 
		 * with the server, and then return the ACK/NAK message it provides. If no exception handler has
		 * been provided, HAPI will generate a NAK message using the default implementation and an
		 * {@link ca.uhn.hl7v2.protocol.impl.ApplicationRouterImpl#DEFAULT_EXCEPTION_ACKNOWLEDGEMENT_CODE AE} acknowlegement code.
		 */
		// NB: this javadoc is duplicated above! Keep in sync!
		DEFAULT,
		
		/**
		 * If set to <code>DO_NOT_RESPOND</code>, the server will simply not provide any response to the
		 * client in the event that an application exception is thrown. 
		 * <p>
		 * Note that this is not generally good practice, but it may be neccesary when 
		 * dealing with some systems that don't behave correctly when they receive 
		 * a negative acknowledment (NAK) message. Use with caution!
		 * </p>
		 */
		DO_NOT_RESPOND
		
	}
	
}
