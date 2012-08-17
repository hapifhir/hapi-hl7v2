package ca.uhn.hl7v2.model;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.HapiContext;
import ca.uhn.hl7v2.model.v25.group.ADT_A01_INSURANCE;
import ca.uhn.hl7v2.parser.CustomModelClassFactory;
import ca.uhn.hl7v2.parser.EncodingNotSupportedException;
import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.parser.PipeParser;
import ca.uhn.hl7v2.unittest.custommodel.v25.message.ADT_A01;
import ca.uhn.hl7v2.unittest.custommodel.v25.message.ZDT_A01;

public class CustomModelClassTest {

	@Test
	public void testDirectSubclass() throws EncodingNotSupportedException, HL7Exception {
		
		String msg = "MSH|^~\\&|DATASERVICES|CORPORATE|||20120711120510.2-0500||ADT^A01^ADT_A01|9c906177-dfca-4bbe-9abd-d8eb43df93a0|D|2.5\r" + 
				"EVN||20120701000000-0500\r" + 
				"PID|1||397979797^^^SN^SN~4242^^^BKDMDM^PI~1000^^^YARDI^PI||Williams^Rory^H^^^^A||19641028000000-0600|M||||||||||31592^^^YARDI^AN\r" + 
				"NK1|1|Pond^Amelia^Q^^^^A|SPO|1234 Main St^^Sussex^WI^53089|^PRS^CP^^^^^^^^^555-1212||N\r" + 
				"NK1|2|Smith^John^^^^^A~^The Doctor^^^^^A|FND|1234 S Water St^^New London^WI^54961||^WPN^PH^^^^^^^^^555-9999|C\r" + 
				"PV1|2|I||R\r" + 
				"GT1|1||Doe^John^A^^^^A||5678 Maple Ave^^Sussex^WI^53089|^PRS^PH^^^^^^^^^555-9999|||||OTH\r" + 
				"IN1|1|CAP1000|YYDN|ACME HealthCare||||GR0000001|||||||HMO|||||||||||||||||||||PCY-0000042\r" + 
				"IN1|2||||||||||||||Medicare|||||||||||||||||||||123-45-6789-A\r" + 
				"IN1|3||||||||||||||Medicaid|||||||||||||||||||||987654321L\r" + 
				"ZFA|6|31592|12345|YARDI|20120201000000-0600";
		
		ModelClassFactory mcf = new CustomModelClassFactory("ca.uhn.hl7v2.unittest.custommodel");
		Message parsed = new PipeParser(mcf).parse(msg);
		
		assertEquals(ca.uhn.hl7v2.unittest.custommodel.v25.message.ADT_A01.class, parsed.getClass());
		
		ADT_A01 parsedMsg = (ca.uhn.hl7v2.unittest.custommodel.v25.message.ADT_A01)parsed;
		
		assertEquals("1", parsedMsg.getINSURANCE().getIN1().getIn11_SetIDIN1().getValue());
		
		List<ADT_A01_INSURANCE> ins = parsedMsg.getINSURANCEAll();
		assertEquals(3, ins.size());
		
	}
	
	/**
	 * Test for issue 3558962
	 * 
	 * @see https://sourceforge.net/tracker/?func=detail&aid=3558962&group_id=38899&atid=423835
	 */
	@Test
	public void testRenamedSubclass() throws EncodingNotSupportedException, HL7Exception {
		
		String msg = "MSH|^~\\&|DATASERVICES|CORPORATE|||20120711120510.2-0500||ZDT^A01^ZDT_A01|9c906177-dfca-4bbe-9abd-d8eb43df93a0|D|2.5\r" + 
				"EVN||20120701000000-0500\r" + 
				"PID|1||397979797^^^SN^SN~4242^^^BKDMDM^PI~1000^^^YARDI^PI||Williams^Rory^H^^^^A||19641028000000-0600|M||||||||||31592^^^YARDI^AN\r" + 
				"NK1|1|Pond^Amelia^Q^^^^A|SPO|1234 Main St^^Sussex^WI^53089|^PRS^CP^^^^^^^^^555-1212||N\r" + 
				"NK1|2|Smith^John^^^^^A~^The Doctor^^^^^A|FND|1234 S Water St^^New London^WI^54961||^WPN^PH^^^^^^^^^555-9999|C\r" + 
				"PV1|2|I||R\r" + 
				"GT1|1||Doe^John^A^^^^A||5678 Maple Ave^^Sussex^WI^53089|^PRS^PH^^^^^^^^^555-9999|||||OTH\r" + 
				"IN1|1|CAP1000|YYDN|ACME HealthCare||||GR0000001|||||||HMO|||||||||||||||||||||PCY-0000042\r" + 
				"IN1|2||||||||||||||Medicare|||||||||||||||||||||123-45-6789-A\r" + 
				"IN1|3||||||||||||||Medicaid|||||||||||||||||||||987654321L\r" + 
				"ZFA|6|31592|12345|YARDI|20120201000000-0600";
		
		ModelClassFactory mcf = new CustomModelClassFactory("ca.uhn.hl7v2.unittest.custommodel");
		Message parsed = new PipeParser(mcf).parse(msg);
		
		assertEquals(ca.uhn.hl7v2.unittest.custommodel.v25.message.ZDT_A01.class, parsed.getClass());
		
		ZDT_A01 parsedMsg = (ca.uhn.hl7v2.unittest.custommodel.v25.message.ZDT_A01)parsed;
		
		assertEquals("1", parsedMsg.getINSURANCE().getIN1().getIn11_SetIDIN1().getValue());
		
		List<ADT_A01_INSURANCE> ins = parsedMsg.getINSURANCEAll();
		assertEquals(3, ins.size());
		
	}

}
