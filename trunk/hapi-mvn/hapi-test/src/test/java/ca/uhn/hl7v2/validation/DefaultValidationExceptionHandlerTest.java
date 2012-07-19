package ca.uhn.hl7v2.validation;

import static org.junit.Assert.*;

import org.junit.Test;

import ca.uhn.hl7v2.HL7Exception;

public class DefaultValidationExceptionHandlerTest {

	@Test
	public void testHandler() throws HL7Exception {
		ValidationExceptionHandler handler = new DefaultValidationExceptionHandler();
		assertTrue(handler.validationPassed());
		handler.onValidationExceptions(new ValidationException[] {
				new ValidationException("test")
		});
		assertFalse(handler.validationPassed());
	}

}
