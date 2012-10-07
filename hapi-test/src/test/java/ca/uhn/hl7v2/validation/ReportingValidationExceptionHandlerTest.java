package ca.uhn.hl7v2.validation;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import ca.uhn.hl7v2.HL7Exception;

public class ReportingValidationExceptionHandlerTest {

	@Test
	public void testHandlerWithoutThrowing() throws HL7Exception {
		ReportingValidationExceptionHandler handler = new ReportingValidationExceptionHandler(false);
		testCollectExceptions(handler);
		assertFalse(handler.result());
	}
	
	@Test(expected=HL7Exception.class)
	public void testHandlerWithThrowing() throws HL7Exception {
		ReportingValidationExceptionHandler handler = new ReportingValidationExceptionHandler(true);
		testCollectExceptions(handler);
		handler.result();
	}	
	
	private void testCollectExceptions(ReportingValidationExceptionHandler handler)
			throws HL7Exception {
		assertTrue(handler.result());
		ValidationException ve1 = new ValidationException("test1");
		ValidationException ve2 = new ValidationException("test2");
		ValidationException ve3 = new ValidationException("test3");
		handler.onExceptions(new ValidationException[] { ve1 });
		handler.onExceptions(new ValidationException[] { ve2, ve3 });
	}

}
