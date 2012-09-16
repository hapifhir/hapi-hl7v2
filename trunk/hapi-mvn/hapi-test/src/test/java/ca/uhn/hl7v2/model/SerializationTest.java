package ca.uhn.hl7v2.model;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import junit.framework.TestCase;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.parser.EncodingNotSupportedException;
import ca.uhn.hl7v2.parser.Parser;
import ca.uhn.hl7v2.parser.PipeParser;

public class SerializationTest extends TestCase {

	public void testSerialization() throws EncodingNotSupportedException, HL7Exception, IOException, ClassNotFoundException {

		String message = "MSH|^~\\&|IRIS|SANTER|AMB_R|SANTER|200803051508||ADT^A03|263206|P|2.5\r"
				+ "EVN||200803051509||||200803031508\r"
				+ "PID|||5520255^^^PK^PK~ZZZZZZ83M64Z148R^^^CF^CF~ZZZZZZ83M64Z148R^^^SSN^SSN^^20070103^99991231~^^^^TEAM||ZZZ^ZZZ||19830824|F||||||||||||||||||||||N\r"
				+ "PV1||I|6402DH^^^^^^^^MED. 1 - ONCOLOGIA^^OSPEDALE MAGGIORE DI LODI&LODI|||^^^^^^^^^^OSPEDALE MAGGIORE DI LODI&LODI|13936^TEST^TEST||||||||||5068^TEST2^TEST2||2008003369||||||||||||||||||||||||||200803031508\r"
				+ "PR1|1||1111^Mastoplastica|Protesi|20090224|02\r";

		Parser p = new PipeParser();
		Message parsed = p.parse(message);

		ByteArrayOutputStream os = new ByteArrayOutputStream();
		new ObjectOutputStream(os).writeObject(parsed);

		ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(os.toByteArray()));
		Message deser = (Message) ois.readObject();

		String actual = p.encode(deser);

		//System.out.println(message);
		//System.out.println();
		//System.out.println(actual);
		
		assertEquals(message, actual);
	}
	

}
