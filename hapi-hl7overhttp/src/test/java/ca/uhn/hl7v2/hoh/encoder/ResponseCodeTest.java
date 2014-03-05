package ca.uhn.hl7v2.hoh.encoder;

import static org.junit.Assert.*;

import org.junit.Test;

import ca.uhn.hl7v2.AcknowledgmentCode;
import ca.uhn.hl7v2.hoh.encoder.ResponseCode;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.v25.message.ADT_A05;
import ca.uhn.hl7v2.parser.DefaultXMLParser;

public class ResponseCodeTest {

	@Test
	public void testDetectEr7() throws Exception {
		
		String message = "MSH|^~\\&|||||200803051508||ADT^A31|2|P|2.5\r"
				+ "EVN||200803051509\r"
				+ "PID|||ZZZZZZ83M64Z148R^^^SSN^SSN^^20070103\r";
		ADT_A05 a05 = new ADT_A05();
		a05.parse(message);
		
		Message ack = a05.generateACK(AcknowledgmentCode.AA, null);
		String ackString = ack.encode();
		assertEquals(ResponseCode.HTTP_200_OK, ResponseCode.detect(ackString));
		
		ack = a05.generateACK(AcknowledgmentCode.AE, null);
		ackString = ack.encode();
		assertEquals(ResponseCode.HTTP_200_OK, ResponseCode.detect(ackString));
		
		ack = a05.generateACK(AcknowledgmentCode.AR, null);
		ackString = ack.encode();
		assertEquals(ResponseCode.HTTP_200_OK, ResponseCode.detect(ackString));

	}

	@Test
	public void testDetectXml() throws Exception {
		
		String message = "MSH|^~\\&|||||200803051508||ADT^A31|2|P|2.5\r"
				+ "EVN||200803051509\r"
				+ "PID|||ZZZZZZ83M64Z148R^^^SSN^SSN^^20070103\r";
		ADT_A05 a05 = new ADT_A05();
		a05.parse(message);
		a05.setParser(new DefaultXMLParser());

		String encoded = a05.encode();
		assertTrue(encoded, encoded.contains("<MSH"));

		Message ack = a05.generateACK(AcknowledgmentCode.AA, null);
		String ackString = ack.encode();
		assertTrue(ackString, ackString.contains("<MSH"));
		assertEquals(ResponseCode.HTTP_200_OK, ResponseCode.detect(ackString));
		
		ack = a05.generateACK(AcknowledgmentCode.AE, null);
		ackString = ack.encode();
		assertEquals(ResponseCode.HTTP_200_OK, ResponseCode.detect(ackString));
		
		ack = a05.generateACK(AcknowledgmentCode.AR, null);
		ackString = ack.encode();
		assertEquals(ResponseCode.HTTP_200_OK, ResponseCode.detect(ackString));

	}

}
