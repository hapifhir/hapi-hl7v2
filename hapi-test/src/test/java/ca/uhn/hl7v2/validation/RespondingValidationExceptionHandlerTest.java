package ca.uhn.hl7v2.validation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import ca.uhn.hl7v2.AcknowledgmentCode;
import ca.uhn.hl7v2.DefaultHapiContext;
import ca.uhn.hl7v2.HapiContext;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.v23.message.ADT_A02;
import ca.uhn.hl7v2.model.v26.message.ADT_A01;

public class RespondingValidationExceptionHandlerTest {

	private DefaultValidator<Message> validator;
	
	@Before
	public void setup() {
		final HapiContext context = new DefaultHapiContext();
		validator = (new DefaultValidator<Message>(context) {

			@Override
			protected ValidationExceptionHandler<Message> initializeHandler() {
				return new RespondingValidationExceptionHandler(context);
			}
		});
	}
	
	@Test
	public void testPassingHandler() throws Exception {
		ADT_A01 a01 = new ADT_A01();
		a01.initQuickstart("ADT", "A01", "P");
		String messageId = a01.getMSH().getMessageControlID().getValue();

		Message msg = validator.validate(a01);
		ca.uhn.hl7v2.model.v26.message.ACK ack = (ca.uhn.hl7v2.model.v26.message.ACK) msg;
		assertEquals(messageId, ack.getMSA().getMessageControlID().getValue());
		assertEquals(AcknowledgmentCode.AA.name(), ack.getMSA().getAcknowledgmentCode().getValue());
	}

	@Test
	public void testFailingHandler26() throws Exception {
		ADT_A01 a01 = new ADT_A01();
		a01.initQuickstart("ADT", "A01", "P");

		// Add two mistakes
		a01.getPID().getSetIDPID().setValue("blorg");
		a01.getPV1().getAdmitDateTime().setValue("gablorg");

		String messageId = a01.getMSH().getMessageControlID().getValue();
		HapiContext context = new DefaultHapiContext();
		RespondingValidationExceptionHandler handler = new RespondingValidationExceptionHandler(context);
		handler.setErrorAcknowledgementCode(AcknowledgmentCode.AR);

		Validator<Message> validator = context.getMessageValidator();
		assertNotNull(validator.validate(a01, handler));
		ca.uhn.hl7v2.model.v26.message.ACK ack = (ca.uhn.hl7v2.model.v26.message.ACK) handler
				.result();
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

		// Add two mistakes
		a02.getPID().getSetIDPatientID().setValue("blorg");
		a02.getPV1().getAdmitDateTime().getTimeOfAnEvent().setValue("gablorg");

		String messageId = a02.getMSH().getMessageControlID().getValue();
		Message msg = validator.validate(a02);
		ca.uhn.hl7v2.model.v23.message.ACK ack = (ca.uhn.hl7v2.model.v23.message.ACK) msg;
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

}
