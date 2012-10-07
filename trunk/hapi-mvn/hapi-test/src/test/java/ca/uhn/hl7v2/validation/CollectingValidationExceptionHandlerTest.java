package ca.uhn.hl7v2.validation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

import java.util.List;

import org.junit.Test;

import ca.uhn.hl7v2.DefaultHapiContext;
import ca.uhn.hl7v2.HL7Exception;

public class CollectingValidationExceptionHandlerTest {

	@Test
	public void testHandler() throws HL7Exception {
		TestHandler handler = new TestHandler();
		assertEquals(0, handler.result().size());
		ValidationException ve1 = new ValidationException("test1");
		ValidationException ve2 = new ValidationException("test2");
		ValidationException ve3 = new ValidationException("test3");
		handler.onExceptions(new ValidationException[] { ve1 });
		handler.onExceptions(new ValidationException[] { ve2, ve3 });
		assertEquals(3, handler.result().size());
		assertSame(ve1, handler.result().get(0));
		assertSame(ve2, handler.result().get(1));
		assertSame(ve3, handler.result().get(2));
	}
	
	private class TestHandler extends CollectingValidationExceptionHandler<List<ValidationException>> {

		public TestHandler() {
            super(new DefaultHapiContext());
        }

        public List<ValidationException> result() throws HL7Exception {
			return getExceptions();
		}
		
	}

}
