package ca.uhn.hl7v2.model.primitive;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.model.Varies;
import ca.uhn.hl7v2.model.v231.datatype.ST;
import ca.uhn.hl7v2.model.v25.message.ORU_R01;

public class PrimitiveTest {

    @Test
	public void testParseClearsExtraComponents() throws HL7Exception, IOException {
		
		ORU_R01 msg = new ORU_R01();
		msg.initQuickstart("ORU", "R01", "T");
		
		ST f1c1 = new ST(msg);
		Varies obx5 = msg.getPATIENT_RESULT().getORDER_OBSERVATION().getOBSERVATION().getOBX().getObx5_ObservationValue(0);
		
		obx5.setData(f1c1);
		f1c1.setValue("F1C1");
		
		ST f2c1 = new ST(msg);
		f1c1.getExtraComponents().getComponent(0).setData(f2c1);
		f2c1.setValue("F2C1");

		ST f2c2 = new ST(msg);
		f1c1.getExtraComponents().getComponent(0).getExtraComponents().getComponent(0).setData(f2c2);
		f2c2.setValue("F2C2");

		String encode = obx5.encode();
		assertEquals("F1C1^F2C1&F2C2", encode);
		
		System.out.println("Message: " + msg.encode().replace("\r", "\n"));
		
		obx5.parse("NF1^NF2");
		encode = obx5.encode();
		assertEquals("NF1^NF2", encode);
		
	}

    @Test
	public void testEncodeIncludesExtraComponents() throws HL7Exception, IOException {
		
		ORU_R01 msg = new ORU_R01();
		msg.initQuickstart("ORU", "R01", "T");
		
		ST f1c1 = new ST(msg);
		Varies obx5 = msg.getPATIENT_RESULT().getORDER_OBSERVATION().getOBSERVATION().getOBX().getObx5_ObservationValue(0);
		
		obx5.setData(f1c1);
		f1c1.setValue("F1C1");
		
		ST f2c1 = new ST(msg);
		f1c1.getExtraComponents().getComponent(0).setData(f2c1);
		f2c1.setValue("F2C1");

		ST f2c2 = new ST(msg);
		f1c1.getExtraComponents().getComponent(0).getExtraComponents().getComponent(0).setData(f2c2);
		f2c2.setValue("F2C2");

		String encode = f1c1.encode();
		assertEquals("F1C1^F2C1&F2C2", encode);
				
	}

    @Test
	public void testParseNull() throws HL7Exception, IOException {
		
		ORU_R01 msg = new ORU_R01();
		msg.initQuickstart("ORU", "R01", "T");
		
		assertTrue(msg.getMSH().getMessageControlID().getValue().length() > 0);
		msg.getMSH().getMessageControlID().parse(null);
		
		assertNull(msg.getMSH().getMessageControlID().getValue());
		
	}
	
}
