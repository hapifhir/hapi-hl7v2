package ca.uhn.hl7v2.model;

import org.junit.Test;

import static org.junit.Assert.*;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.model.v22.message.ADT_A01;
import ca.uhn.hl7v2.model.v23.message.ORU_R01;
import ca.uhn.hl7v2.model.v24.segment.MSH;
import ca.uhn.hl7v2.parser.DefaultModelClassFactory;
import ca.uhn.hl7v2.parser.ModelClassFactory;

/**
 * JUnit test cases for AbstractSegment
 * @author bryan
 */
public class AbstractSegmentTest {
    private static final org.slf4j.Logger ourLog = org.slf4j.LoggerFactory.getLogger(AbstractSegmentTest.class);
    
    // Add test methods here, they have to start with 'test' name.
    // for example:
    // public void testHello() {}
	@Test
    public void testEnsureEnoughFields() throws Exception {
        ModelClassFactory factory = new DefaultModelClassFactory();
        MSH msh = new MSH(new GenericMessage.V25(factory), factory);
        int n = msh.numFields();
        msh.getField(n + 3, 0);
        assertEquals("ca.uhn.hl7v2.model.Varies", msh.getField(n+1, 0).getClass().getName());
        assertEquals("ca.uhn.hl7v2.model.Varies", msh.getField(n+2, 0).getClass().getName());
        assertEquals("ca.uhn.hl7v2.model.Varies", msh.getField(n+3, 0).getClass().getName());
    }
    
	@Test
    public void testUnexpectedFieldReps() throws Exception {
        ModelClassFactory factory = new DefaultModelClassFactory();
        MSH msh = new MSH(new GenericMessage.V25(factory), new DefaultModelClassFactory());
        msh.getField(1, 0);
        msh.getField(1, 1);        
        assertEquals(2, msh.getField(1).length);
    }


	@Test
	public void testParseEmpty() throws HL7Exception {

        String string = "MSH|^~\\&|LABGL1||DMCRES||19951002185200||ADT^A01|LABGL1199510021852632|P|2.2\r"
                + "PID|||T12345||TEST^PATIENT^P||19601002|M||||||||||123456\r"
                + "PV1|||NER|||||||GSU||||||||E||||||||||||||||||||||||||19951002174900|19951006\r";

        ADT_A01 a01 = new ADT_A01();
        a01.parse(string);

		assertEquals(string, a01.encode());

		a01.getPID().parse("PID");

        string = "MSH|^~\\&|LABGL1||DMCRES||19951002185200||ADT^A01|LABGL1199510021852632|P|2.2\r"
                + "PV1|||NER|||||||GSU||||||||E||||||||||||||||||||||||||19951002174900|19951006\r";

		String encode = a01.encode();
		
		System.out.println("Message is:\n" + encode.replace("\r", "\n"));
		
		assertEquals(string, encode);

	}

	@Test
	public void testParseNull() throws HL7Exception {

        String string = "MSH|^~\\&|LABGL1||DMCRES||19951002185200||ADT^A01|LABGL1199510021852632|P|2.2\r"
                + "PID|||T12345||TEST^PATIENT^P||19601002|M||||||||||123456\r"
                + "PV1|||NER|||||||GSU||||||||E||||||||||||||||||||||||||19951002174900|19951006\r";
        ADT_A01 a01 = new ADT_A01();
        a01.parse(string);

        try {
        	a01.getPID().parse(null);
        	fail();
        } catch (NullPointerException e) {
        	// expected
        }

	}

	@Test
	public void testInsertRepetition() throws HL7Exception {

        String string = "MSH|^~\\&|ULTRA|TML|OLIS|OLIS|200905011130||ORU^R01|20169838|T|2.3\r"
            + "PID|||1000\r"
            + "PV1|1||OLIS||||OLIST^BLAKE^DONALD^THOR^^^^^921379^^^^OLIST\r"
            + "ORC|RE||T09-100442-RET-0^^OLIS_Site_ID^ISO|||||||||OLIST^BLAKE^DONALD^THOR^^^^L^921379\r"
            + "OBR|0||T09-100442-RET-0^^OLIS_Site_ID^ISO|RET^RETICULOCYTE COUNT^HL79901 literal|||200905011106|||||||200905011106||OLIST^BLAKE^DONALD^THOR^^^^L^921379||7870279|7870279|T09-100442|MOHLTC|200905011130||B7|F||1^^^200905011106^^R\r"
            + "OBX|8|DT|GDT-00108^Device Implant Date^GDT-LATITUDE||20090505||||||F||\r";

        ORU_R01 msg = new ORU_R01();
        msg.parse(string);
        
        assertEquals("PID|||1000", msg.getRESPONSE(0).getPATIENT().getPID().encode());
        
        msg.getRESPONSE(0).getPATIENT().getPID().insertPid3_PatientIDInternalID(1).parse("1001");
        assertEquals("PID|||1000~1001", msg.getRESPONSE(0).getPATIENT().getPID().encode());

        msg.getRESPONSE(0).getPATIENT().getPID().insertPid3_PatientIDInternalID(0).parse("0999");
        assertEquals("PID|||0999~1000~1001", msg.getRESPONSE(0).getPATIENT().getPID().encode());

	}
	
	
	@Test
	public void testParseMshWithNoContent() {
		
		try {
			ADT_A01 msg = new ADT_A01();
			msg.getMSH().parse("MSH|^~\\&|ULTRA|TML|OLIS|OLIS|200905011130||ADT^A01|20169838|T|2.3\r");
			fail();
		} catch (HL7Exception e) {
			ourLog.error("Caught exception, as we should", e);
		}
		
	}
	
}
