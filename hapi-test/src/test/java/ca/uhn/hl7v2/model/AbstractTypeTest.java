package ca.uhn.hl7v2.model;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.model.v25.message.ADT_A01;
import ca.uhn.hl7v2.parser.DefaultXMLParser;

public class AbstractTypeTest {

	@Test
	public void testToStringOnXmlMessage() throws HL7Exception, IOException {
		
		ADT_A01 a01 = new ADT_A01();
		a01.initQuickstart("ADT", "A01", "T");
		a01.setParser(new DefaultXMLParser());
		
		String messageType = a01.getMSH().getMessageType().toString();
		Assert.assertTrue(messageType.contains("ADT^A01"));
		
	}
	
}
