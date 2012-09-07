package ca.uhn.hl7v2.validation;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import ca.uhn.hl7v2.HL7Exception;

public class ReportingValidationExceptionHandlerTest {

	@Test
	public void testHandlerWithoutThrowing() throws HL7Exception {
		ReportingValidationExceptionHandler handler = new ReportingValidationExceptionHandler(false);
		testCollectExceptions(handler);
		assertFalse(handler.validationPassed());
	}
	
	@Test(expected=HL7Exception.class)
	public void testHandlerWithThrowing() throws HL7Exception {
		ReportingValidationExceptionHandler handler = new ReportingValidationExceptionHandler(true);
		testCollectExceptions(handler);
		handler.validationPassed();
	}	
	
	private void testCollectExceptions(ReportingValidationExceptionHandler handler)
			throws HL7Exception {
		assertTrue(handler.validationPassed());
		ValidationException ve1 = new ValidationException("test1");
		ValidationException ve2 = new ValidationException("test2");
		ValidationException ve3 = new ValidationException("test3");
		handler.onValidationExceptions(new ValidationException[] { ve1 });
		handler.onValidationExceptions(new ValidationException[] { ve2, ve3 });
		List<ValidationException> exceptions = handler.getExceptions();
		assertSame(ve1, exceptions.get(0));
		assertSame(ve2, exceptions.get(1));
		assertSame(ve3, exceptions.get(2));
	}

}
