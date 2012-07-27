package ca.uhn.hl7v2.validation.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import ca.uhn.hl7v2.validation.ValidationException;

/**
 * Unit tests for <code>ValidatesAgainstSchema</code>.
 * 
 * @author Bryan Tripp
 * @author Christian Ohr
 */
public class XMLSchemaRuleTest {

	private XMLSchemaRule rule;
	private Map<String, String> locations;

	@Before
	public void setupBefore() {
		locations = new HashMap<String, String>();
		URL res = getClass().getClassLoader().getResource("ca/uhn/hl7v2/validation/impl/ACK.xsd");
		String resPath = res.toString().replace("file:", "").replace("/ACK.xsd", "");
		locations.put("2.5", resPath);
		rule = new XMLSchemaRule();
		rule.setSchemaLocations(locations);
	}

	@Test
	public void testStaticSucceeds() throws IOException {
		ValidationException[] errors = rule.test(getMessage1());
		assertEquals(Arrays.asList(errors).toString(), 0, errors.length);
	}

	@Test
	public void testStaticFails() throws IOException {
		ValidationException[] errors = rule.test(getMessage2());
		assertEquals(Arrays.asList(errors).toString(), 1, errors.length);
		assertTrue(errors[0].getMessage().contains("MSA.XXXXXXXX"));
	}

	@Test
	public void testStaticNotFound() throws IOException {
		rule.getSchemaLocations().put("2.5", "dgjkn(/§$&f09e");
		ValidationException[] errors = rule.test(getMessage2());
		assertEquals(Arrays.asList(errors).toString(), 1, errors.length);
		assertTrue(errors[0].getCause() instanceof IOException);
	}

	@Test
	public void testStaticNotFound2() throws IOException {
		rule.getSchemaLocations().clear();
		ValidationException[] errors = rule.test(getMessage2());
		assertEquals(Arrays.asList(errors).toString(), 1, errors.length);
		assertTrue(errors[0].getCause() instanceof IOException);
	}

	@Test
	public void testDynamicFails() throws IOException {
		String msg = getMessage3().replace("@@@", locations.get("2.5"));
		ValidationException[] errors = rule.test(msg);
		assertEquals(Arrays.asList(errors).toString(), 1, errors.length);
		assertTrue(errors[0].getMessage().contains("MSA.XXXXXXXX"));
	}

	@Test
	public void testDynamicNotFound() throws IOException {
		String msg = getMessage3(); // unknown location, override with locations property
		ValidationException[] errors = rule.test(msg);
		assertEquals(Arrays.asList(errors).toString(), 1, errors.length);
		assertTrue(errors[0].getMessage().contains("MSA.XXXXXXXX"));
	}

	// TODO add tests using dynamic location detection, missing schema files etc.

	// TODO externalize
	private String getMessage1() {
		return "<?xml version=\"1.0\"?>" + " <ACK " + "  xmlns=\"urn:hl7-org:v2xml\">"
				+ "     <MSH>" + "         <MSH.1>|</MSH.1>" + "         <MSH.2>^~\\&amp;</MSH.2>"
				+ "         <MSH.7>" + "             <TS.1>20050621103250.424-0500</TS.1>"
				+ "         </MSH.7>" + "         <MSH.9>" + "             <MSG.1>ACK</MSG.1>"
				+ "         </MSH.9>" + "         <MSH.10>1</MSH.10>" + "         <MSH.11>"
				+ "             <PT.1>P</PT.1>" + "         </MSH.11>" + "         <MSH.12>"
				+ "             <VID.1>2.5</VID.1>" + "         </MSH.12>" + "     </MSH>"
				+ "     <MSA>" + "         <MSA.1>AA</MSA.1>" + "         <MSA.2>100</MSA.2>"
				+ "     </MSA>" + " </ACK>";
	}

	private String getMessage2() {
		return "<?xml version=\"1.0\"?>" + " <ACK " + "  xmlns=\"urn:hl7-org:v2xml\">"
				+ "     <MSH>" + "         <MSH.1>|</MSH.1>" + "         <MSH.2>^~\\&amp;</MSH.2>"
				+ "         <MSH.7>" + "             <TS.1>20050621103250.424-0500</TS.1>"
				+ "         </MSH.7>" + "         <MSH.9>" + "             <MSG.1>ACK</MSG.1>"
				+ "         </MSH.9>" + "         <MSH.10>1</MSH.10>" + "         <MSH.11>"
				+ "             <PT.1>P</PT.1>" + "         </MSH.11>" + "         <MSH.12>"
				+ "             <VID.1>2.5</VID.1>" + "         </MSH.12>" + "     </MSH>"
				+ "     <MSA>" + "         <MSA.XXXXXXXX>AA</MSA.XXXXXXXX>"
				+ "         <MSA.2>100</MSA.2>" + "     </MSA>" + " </ACK>";
	}

	private String getMessage3() {
		return "<?xml version=\"1.0\"?>"
				+ " <ACK "
				+ "  xmlns=\"urn:hl7-org:v2xml\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\" urn:hl7-org:v2xml @@@\">"
				+ "     <MSH>" + "         <MSH.1>|</MSH.1>" + "         <MSH.2>^~\\&amp;</MSH.2>"
				+ "         <MSH.7>" + "             <TS.1>20050621103250.424-0500</TS.1>"
				+ "         </MSH.7>" + "         <MSH.9>" + "             <MSG.1>ACK</MSG.1>"
				+ "         </MSH.9>" + "         <MSH.10>1</MSH.10>" + "         <MSH.11>"
				+ "             <PT.1>P</PT.1>" + "         </MSH.11>" + "         <MSH.12>"
				+ "             <VID.1>2.5</VID.1>" + "         </MSH.12>" + "     </MSH>"
				+ "     <MSA>" + "         <MSA.XXXXXXXX>AA</MSA.XXXXXXXX>"
				+ "         <MSA.2>100</MSA.2>" + "     </MSA>" + " </ACK>";
	}
}
