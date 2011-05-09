package ca.uhn.hl7v2.model;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.model.v22.message.ADT_A01;
import junit.framework.*;
import ca.uhn.hl7v2.model.v24.segment.MSH;
import ca.uhn.hl7v2.parser.DefaultModelClassFactory;
import ca.uhn.hl7v2.parser.ModelClassFactory;

/**
 * JUnit test cases for AbstractSegment
 * @author bryan
 */
public class AbstractSegmentTest extends TestCase {
    
    public AbstractSegmentTest(java.lang.String testName) {
        super(testName);
    }
    
    public static void main(java.lang.String[] args) {
        junit.textui.TestRunner.run(suite());
    }
    
    public static Test suite() {
        TestSuite suite = new TestSuite(AbstractSegmentTest.class);
        return suite;
    }
    
    // Add test methods here, they have to start with 'test' name.
    // for example:
    // public void testHello() {}
    public void testEnsureEnoughFields() throws Exception {
        ModelClassFactory factory = new DefaultModelClassFactory();
        MSH msh = new MSH(new GenericMessage.V25(factory), factory);
        int n = msh.numFields();
        msh.getField(n + 3, 0);
        assertEquals("ca.uhn.hl7v2.model.Varies", msh.getField(n+1, 0).getClass().getName());
        assertEquals("ca.uhn.hl7v2.model.Varies", msh.getField(n+2, 0).getClass().getName());
        assertEquals("ca.uhn.hl7v2.model.Varies", msh.getField(n+3, 0).getClass().getName());
    }
    
    public void testUnexpectedFieldReps() throws Exception {
        ModelClassFactory factory = new DefaultModelClassFactory();
        MSH msh = new MSH(new GenericMessage.V25(factory), new DefaultModelClassFactory());
        msh.getField(1, 0);
        msh.getField(1, 1);        
        assertEquals(2, msh.getField(1).length);
    }


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

    
}
