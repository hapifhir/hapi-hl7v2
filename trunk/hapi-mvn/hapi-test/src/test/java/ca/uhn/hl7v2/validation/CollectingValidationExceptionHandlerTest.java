package ca.uhn.hl7v2.validation;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import ca.uhn.hl7v2.HL7Exception;

public class CollectingValidationExceptionHandlerTest {

	@Test
	public void testHandler() throws HL7Exception {
		CollectingValidationExceptionHandler handler = new CollectingValidationExceptionHandler();
		assertTrue(handler.validationPassed());
		ValidationException ve1 = new ValidationException("test1");
		ValidationException ve2 = new ValidationException("test2");
		ValidationException ve3 = new ValidationException("test3");
		handler.onValidationExceptions(new ValidationException[] { ve1 });
		handler.onValidationExceptions(new ValidationException[] { ve2, ve3 });
		assertFalse(handler.validationPassed());
		List<ValidationException> exceptions = handler.getExceptions();
		assertSame(ve1, exceptions.get(0));
		assertSame(ve2, exceptions.get(1));
		assertSame(ve3, exceptions.get(2));
	}

}
