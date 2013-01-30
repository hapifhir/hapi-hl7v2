package ca.uhn.hl7v2.conf.parser;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.junit.Before;
import org.junit.Test;

import ca.uhn.hl7v2.conf.ProfileException;
import ca.uhn.hl7v2.conf.spec.RuntimeProfile;
import ca.uhn.hl7v2.conf.spec.message.Component;
import ca.uhn.hl7v2.conf.spec.message.Field;
import ca.uhn.hl7v2.conf.spec.message.Seg;
import ca.uhn.hl7v2.conf.spec.message.StaticDef;
import ca.uhn.hl7v2.conf.spec.message.SubComponent;

/**
 * JUnit tests for conformance profile parser
 * 
 * @author bryan
 */
public class ProfileParserTest {

	@Before
	public void setUp() throws Exception {
		// System.out.println(profileString);
	}

	@Test
	public void testParseFailed() throws ProfileException, IOException {
		
		ProfileParser p = new ProfileParser(false);
		p.parseClasspath("ca/uhn/hl7v2/conf/parser/ADT_A01_with_problem.xml");
		
		
	}
	
	@Test
	public void testParse() throws Exception {
		ClassLoader cl = ProfileParser.class.getClassLoader();
		InputStream instream = cl.getResourceAsStream("ca/uhn/hl7v2/conf/parser/example_ack.xml");
		if (instream == null)
			throw new Exception("can't find the xml file");
		BufferedReader in = new BufferedReader(new InputStreamReader(instream));
		int tmp = 0;
		StringBuffer buf = new StringBuffer();
		while ((tmp = in.read()) != -1) {
			buf.append((char) tmp);
		}
		String profileString = buf.toString();
		
		ProfileParser pp = new ProfileParser(true);
		RuntimeProfile rp = pp.parse(profileString);
		assertEquals("2.4", rp.getHL7Version());
		StaticDef p = rp.getMessage();

		assertEquals("ACK", p.getMsgType());
		assertEquals("ACK", p.getMsgStructID());
		assertTrue(p.getEventDesc().indexOf("general") > 1);

		Seg sp = (Seg) p.getChild(1);
		assertEquals("MSH", sp.getName());
		assertEquals("Message Header", sp.getLongName());
		assertEquals("R", sp.getUsage());
		assertEquals(1, sp.getMin());
		assertEquals(1, sp.getMax());
		Field fieldSep = sp.getField(1);
		assertEquals("Field Separator", fieldSep.getName());
		assertEquals("R", fieldSep.getUsage());
		assertEquals(1, fieldSep.getMin());
		assertEquals(1, fieldSep.getMax());
		assertEquals("ST", fieldSep.getDatatype());
		assertEquals(1, fieldSep.getLength());
		assertEquals(1, fieldSep.getItemNo());
		assertEquals("2.16.9.1", fieldSep.getReference());
		Field VID = sp.getField(12);
		Component vid = VID.getComponent(1);
		assertEquals("version ID", vid.getName());
		assertEquals("O", vid.getUsage());
		assertEquals("ID", vid.getDatatype());
		assertEquals(3, vid.getLength());
		assertEquals("0104", vid.getTable());
		assertEquals(3, VID.getComponents());
		assertEquals(6, VID.getComponent(2).getSubComponents());
		SubComponent name = VID.getComponent(2).getSubComponent(3);
		assertEquals("name of coding system", name.getName());
		assertEquals("O", name.getUsage());
		assertEquals("IS", name.getDatatype());
		assertEquals(3, name.getLength());
		assertEquals("0396-X", name.getTable());

		sp = (Seg) p.getChild(2);
		assertEquals("MSA", sp.getName());

		sp = (Seg) p.getChild(3);
		assertEquals("ERR", sp.getName());

	}

}
