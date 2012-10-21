package ca.uhn.hl7v2.model;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.model.v25.message.ADT_A01;

public class ExtraComponentsTest {
	
	@Test
	public void testClear() throws HL7Exception, IOException {
		
		ADT_A01 msg = new ADT_A01();
		msg.initQuickstart("ADT", "A01", "T");
		
		msg.getMSH().getContinuationPointer().parse("AAA^BBB");
		
		Assert.assertTrue(msg.encode().replace("\r", "\n"), msg.encode().contains("AAA^BBB"));
		msg.getMSH().getContinuationPointer().getExtraComponents().clear();
		Assert.assertTrue(msg.encode().replace("\r", "\n"), msg.encode().contains("AAA"));
		Assert.assertFalse(msg.encode().replace("\r", "\n"), msg.encode().contains("BBB"));
	}
	
	@Test
	public void testComponentClear() throws HL7Exception, IOException {
		
		ADT_A01 msg = new ADT_A01();
		msg.initQuickstart("ADT", "A01", "T");
		
		msg.getMSH().getContinuationPointer().parse("AAA^BBB");
		
		Assert.assertTrue(msg.encode().replace("\r", "\n"), msg.encode().contains("AAA^BBB"));
		msg.getMSH().getContinuationPointer().getExtraComponents().getComponent(0).clear();
		Assert.assertTrue(msg.encode().replace("\r", "\n"), msg.encode().contains("AAA"));
		Assert.assertFalse(msg.encode().replace("\r", "\n"), msg.encode().contains("BBB"));
	}

}
