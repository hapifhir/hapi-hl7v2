package ca.uhn.hl7v2.parser;

import junit.framework.TestCase;

public class ParserConfigurationTest extends TestCase {

	
	public void testAddForcedEncodeValidatesInput() {
		
		ParserConfiguration pc = new ParserConfiguration();

		pc.addForcedEncode("ORDER/RXR-22");
		
		try {
			pc.addForcedEncode("A");
			fail();
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}

		try {
			pc.addForcedEncode("AA");
			fail();
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}

		try {
			pc.addForcedEncode("AAA/");
			fail();
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}

		try {
			pc.addForcedEncode("AAA-A");
			fail();
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}

		try {
			pc.addForcedEncode("AAA-123-");
			fail();
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
}
