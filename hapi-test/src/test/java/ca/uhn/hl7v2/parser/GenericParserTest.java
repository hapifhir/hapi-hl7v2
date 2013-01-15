package ca.uhn.hl7v2.parser;

import static org.junit.Assert.*;

import java.io.PrintWriter;
import java.io.StringWriter;

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
	
	/**
	 * https://sourceforge.net/p/hl7api/bugs/92/
	 */
	@Test
	public void testAmpersandCorrectlyParsed() throws HL7Exception {
		
		StringWriter message = new StringWriter();
		PrintWriter out = new PrintWriter(message);

		out.println("MSH|^~\\&|OADD||DADD||20090511130702||ORU^R01|91310000023|P|2.3||||");
		out.println("PID|||2278111^^^6||CSCXBOB^LAB^||19480205|M|^^||^^, ^^|||||||||");
		out.println("PV1||O|CSC^||||2499^LAST^^FIRST I MD|^||||||||||OP|35848990||||||||||||||||||||6|||||200904130000|200904140000|");
		out.println("ORC|RE|59761179|M3541|||||||||2499^LAST^^FIRST I MD||||^|");
		out.println("OBR|1|59761179|M3541^OADD|CR^Cell study|||200905110800||||||||^|2499^LAST^^FIRST I MD||||||||H|F||^^^^^R|^||||^^|^^||");
		out.println("OBX|1|ST|CR^Cell study|1|(note)||||||F|||200905111306|MMC^Tacoma General H|7^LASTNAME^FIRSTNAME|");
		out.println("OBX|2|ST|CR^Cell study|1|WBCS: Adequate in number & normal in appearance||||||F|||200905111306|MMC^Tacoma General H|7^LASTNAME^FIRSTNAME|");
		out.println("OBX|3|ST|CR^Cell study|1|RBC: Occasional \"target\" cells||||||F|||200905111306|MMC^Tacoma General H|7^LASTNAME^FIRSTNAME|");

		Parser p = new GenericParser();
		Message hMsg = p.parse(message.toString());

		String enc = p.encode(hMsg);
		assertTrue(enc, enc.contains("|WBCS: Adequate in number & normal in appearance|"));
	}

}
