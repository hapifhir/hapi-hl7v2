package ca.uhn.hl7v2.validation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;

import ca.uhn.hl7v2.AcknowledgmentCode;
import ca.uhn.hl7v2.DefaultHapiContext;
import ca.uhn.hl7v2.HapiContext;
import ca.uhn.hl7v2.Location;
import ca.uhn.hl7v2.MockitoTest;
import ca.uhn.hl7v2.Version;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.v23.message.ADT_A02;
import ca.uhn.hl7v2.model.v26.message.ADT_A01;
import ca.uhn.hl7v2.validation.builder.ValidationRuleBuilder;
import ca.uhn.hl7v2.validation.impl.ValidationContextFactory;

public class RespondingValidationExceptionHandlerTest extends MockitoTest {

	@Test
	public void testPassingHandler() throws Exception {
		ADT_A01 a01 = new ADT_A01();
		a01.initQuickstart("ADT", "A01", "P");
		String messageId = a01.getMSH().getMessageControlID().getValue();
		HapiContext context = new DefaultHapiContext();
		context.setValidationExceptionHandlerFactory(new RespondingValidationExceptionHandler(context));
		Validator<Message> validator = context.getMessageValidator();
		Message msg = validator.validate(a01);
		ca.uhn.hl7v2.model.v26.message.ACK ack = (ca.uhn.hl7v2.model.v26.message.ACK) msg;
		assertEquals(messageId, ack.getMSA().getMessageControlID().getValue());
		assertEquals(AcknowledgmentCode.AA.name(), ack.getMSA().getAcknowledgmentCode().getValue());
	}

	@Test
	public void testFailingHandler26() throws Exception {
		ADT_A01 a01 = new ADT_A01();
		a01.initQuickstart("ADT", "A01", "P");

		HapiContext context = new DefaultHapiContext();
		context.setValidationContext(context(failingMessageRule("PID-1", "PV1-44"), "ADT", "A01",
				Version.V26));
		RespondingValidationExceptionHandler handler = new RespondingValidationExceptionHandler(
				context);
		handler.setErrorAcknowledgementCode(AcknowledgmentCode.AR);

		Validator<Message> validator = context.getMessageValidator();
		assertNotNull(validator.validate(a01, handler));
		ca.uhn.hl7v2.model.v26.message.ACK ack = (ca.uhn.hl7v2.model.v26.message.ACK) handler
				.result();
		String messageId = a01.getMSH().getMessageControlID().getValue();
		assertEquals(messageId, ack.getMSA().getMessageControlID().getValue());
		assertEquals(AcknowledgmentCode.AR.name(), ack.getMSA().getAcknowledgmentCode().getValue());
		assertEquals("PID", ack.getERR(0).getErrorLocation(0).getSegmentID().getValue());
		assertEquals("1", ack.getERR(0).getErrorLocation(0).getFieldPosition().getValue());
		assertEquals("207", ack.getERR(0).getHL7ErrorCode().getIdentifier().getValue());
		assertEquals("PV1", ack.getERR(1).getErrorLocation(0).getSegmentID().getValue());
		assertEquals("44", ack.getERR(1).getErrorLocation(0).getFieldPosition().getValue());
		assertEquals("207", ack.getERR(1).getHL7ErrorCode().getIdentifier().getValue());
		// System.out.println(ack.encode());
	}

	@Test
	public void testFailingHandler23() throws Exception {
		ADT_A02 a02 = new ADT_A02();
		a02.initQuickstart("ADT", "A02", "P");

		HapiContext context = new DefaultHapiContext();
		context.setValidationContext(context(failingMessageRule("PID-1", "PV1-44"), "ADT", "A02",
				Version.V23));
		context.setValidationExceptionHandlerFactory(new RespondingValidationExceptionHandler(context));
		Validator<Message> validator = context.getMessageValidator();
		Message msg = validator.validate(a02);
		ca.uhn.hl7v2.model.v23.message.ACK ack = (ca.uhn.hl7v2.model.v23.message.ACK) msg;
		String messageId = a02.getMSH().getMessageControlID().getValue();
		assertEquals(messageId, ack.getMSA().getMessageControlID().getValue());
		assertEquals(AcknowledgmentCode.AE.name(), ack.getMSA().getAcknowledgementCode().getValue());
		assertEquals("PID", ack.getERR().getErrorCodeAndLocation(0).getSegmentID().getValue());
		assertEquals("1", ack.getERR().getErrorCodeAndLocation(0).getFieldPosition().getValue());
		assertEquals("207", ack.getERR().getErrorCodeAndLocation(0).getCodeIdentifyingError()
				.getIdentifier().getValue());
		assertEquals("PV1", ack.getERR().getErrorCodeAndLocation(1).getSegmentID().getValue());
		assertEquals("44", ack.getERR().getErrorCodeAndLocation(1).getFieldPosition().getValue());
		assertEquals("207", ack.getERR().getErrorCodeAndLocation(1).getCodeIdentifyingError()
				.getIdentifier().getValue());
		// System.out.println(ack.encode());
	}

	private ValidationContext context(final MessageRule rule, final String eventType,
			final String trigger, final Version version) {
		return ValidationContextFactory.fromBuilder(new ValidationRuleBuilder() {

			@Override
			protected void configure() {
				forVersion(version).message(eventType, trigger).test(rule);
			}

		});
	}
	
	private MessageRule failingMessageRule(String... locations) {
		MessageRule rule = mock(MessageRule.class);
		ValidationException[] exceptions = new ValidationException[locations.length];
		for (int i = 0; i < locations.length; i++) {
			String[] s = locations[i].split("-");
			Location l = new Location()
			    .withSegmentName(s[0])
			    .withField(Integer.parseInt(s[1]));
			ValidationException ve = new ValidationException();
			ve.setLocation(l);
			exceptions[i] = ve;
		}
		when(rule.apply(any(Message.class))).thenReturn(exceptions);
		return rule;
	}	
}
