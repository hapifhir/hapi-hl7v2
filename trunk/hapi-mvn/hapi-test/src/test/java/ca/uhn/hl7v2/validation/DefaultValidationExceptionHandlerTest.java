package ca.uhn.hl7v2.validation;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import ca.uhn.hl7v2.HL7Exception;

public class DefaultValidationExceptionHandlerTest {

	@Test
	public void testHandler() throws HL7Exception {
		ValidationExceptionHandler<Boolean> handler = new DefaultValidationExceptionHandler();
		assertTrue(handler.result());
		handler.onExceptions(new ValidationException[] {
				new ValidationException("test")
		});
		assertFalse(handler.result());
	}

}
