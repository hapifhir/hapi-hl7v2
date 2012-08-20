package ca.uhn.hl7v2.parser;

import static org.junit.Assert.*;

import org.junit.Test;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.model.Message;

public class GenericParserTest {

	@Test
	public void testMessageSetAppropriatelyForParse() throws EncodingNotSupportedException, HL7Exception {
		
		String message = // -
		"MSH|^~\\&|||||200803051508||ADT^A31|2|P|2.5\r" + // -
				"EVN||200803051509\r" + // -
				"PID|||ZZZZZZ83M64Z148R^^^SSN^SSN^^20070103\r"; // -

		Message parsed = new GenericParser().parse(message);
		assertEquals(PipeParser.class, parsed.getParser().getClass());
		
		message = new DefaultXMLParser().encode(PipeParser.getInstanceWithNoValidation().parse(message));

		parsed = new GenericParser().parse(message);
		assertEquals(DefaultXMLParser.class, parsed.getParser().getClass());
		
	}

}
