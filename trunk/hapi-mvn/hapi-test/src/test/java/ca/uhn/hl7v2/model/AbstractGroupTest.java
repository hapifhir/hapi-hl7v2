package ca.uhn.hl7v2.model;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.model.v24.message.ADT_A01;
import ca.uhn.hl7v2.model.v24.segment.ARQ;
import ca.uhn.hl7v2.model.v25.group.ORU_R01_OBSERVATION;
import ca.uhn.hl7v2.model.v25.message.ACK;
import ca.uhn.hl7v2.model.v25.message.ORU_R01;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * JUnit test cases for AbstractGroup
 * @author bryan
 */
public class AbstractGroupTest {
    
    @Test
    public void testAddNonstandardSegment() throws Exception {
        ADT_A01 message = new ADT_A01();

        //test known segment
        message.addNonstandardSegment("ARQ");
        message.get("ARQ", 0);
        Structure arq1 = message.get("ARQ", 1);
        assertEquals(ARQ.class.getName(), arq1.getClass().getName());
        
        //test unknown segment
        message.addNonstandardSegment("ZZZ");
        Structure z = message.get("ZZZ");
        assertEquals(GenericSegment.class.getName(), z.getClass().getName());
    }
    
    @Test
    public void testErrorMessage() {
    	
    	ACK ack = new ACK();
    	try {
    		ack.getERR(1);
    	} catch (Exception e) {
    		assertTrue(e.getMessage().contains("no repetitions"));
    		assertTrue(e.getMessage().contains("must be 0"));
    	}
    	
		ack.getERR(0);
		ack.getERR(1);

    	try {
    		ack.getERR(3);
    	} catch (Exception e) {
    		assertTrue(e.getMessage().contains("only 2 repetitions"));
    		assertTrue(e.getMessage().contains("must be between 0 and 2"));
    	}

    }
    

    @Test
    public void testInsertNewRepetition() throws HL7Exception {

        String string = "MSH|^~\\&|ULTRA|TML|OLIS|OLIS|200905011130||ORU^R01|20169838|T|2.5\r"
				+ "PID|||7005728^^^TML^MR||TEST^RACHEL^DIAMOND||19310313|F|||200 ANYWHERE ST^^TORONTO^ON^M6G 2T9||(416)888-8888||||||1014071185^KR\r"
				+ "PV1|1||OLIS||||OLIST^BLAKE^DONALD^THOR^^^^^921379^^^^OLIST\r"
				+ "ORC|RE||T09-100442-RET-0^^OLIS_Site_ID^ISO|||||||||OLIST^BLAKE^DONALD^THOR^^^^L^921379\r"
				+ "OBR|0||T09-100442-RET-0^^OLIS_Site_ID^ISO|RET^RETICULOCYTE COUNT^HL79901 literal|||200905011106|||||||200905011106||OLIST^BLAKE^DONALD^THOR^^^^L^921379||7870279|7870279|T09-100442|MOHLTC|200905011130||B7|F||1^^^200905011106^^R\r"
				+ "OBX|1\r"
				+ "OBX|3\r"
				+ "OBX|4\r";
        ORU_R01 oruR01 = new ORU_R01();
        oruR01.parse(string);

        ORU_R01_OBSERVATION newGroup = oruR01.getPATIENT_RESULT().getORDER_OBSERVATION().insertOBSERVATION(1);
        newGroup.getOBX().getSetIDOBX().setValue("2");

        String expected = "MSH|^~\\&|ULTRA|TML|OLIS|OLIS|200905011130||ORU^R01|20169838|T|2.5\r"
				+ "PID|||7005728^^^TML^MR||TEST^RACHEL^DIAMOND||19310313|F|||200 ANYWHERE ST^^TORONTO^ON^M6G 2T9||(416)888-8888||||||1014071185^KR\r"
				+ "PV1|1||OLIS||||OLIST^BLAKE^DONALD^THOR^^^^^921379^^^^OLIST\r"
				+ "ORC|RE||T09-100442-RET-0^^OLIS_Site_ID^ISO|||||||||OLIST^BLAKE^DONALD^THOR^^^^L^921379\r"
				+ "OBR|0||T09-100442-RET-0^^OLIS_Site_ID^ISO|RET^RETICULOCYTE COUNT^HL79901 literal|||200905011106|||||||200905011106||OLIST^BLAKE^DONALD^THOR^^^^L^921379||7870279|7870279|T09-100442|MOHLTC|200905011130||B7|F||1^^^200905011106^^R\r"
				+ "OBX|1\r"
				+ "OBX|2\r"
				+ "OBX|3\r"
				+ "OBX|4\r";
        assertEquals(expected, oruR01.encode());
    }


    @Test
    public void testInsertRepetition() throws HL7Exception {

        String string = "MSH|^~\\&|ULTRA|TML|OLIS|OLIS|200905011130||ORU^R01|20169838|T|2.5\r"
				+ "PID|||7005728^^^TML^MR||TEST^RACHEL^DIAMOND||19310313|F|||200 ANYWHERE ST^^TORONTO^ON^M6G 2T9||(416)888-8888||||||1014071185^KR\r"
				+ "PV1|1||OLIS||||OLIST^BLAKE^DONALD^THOR^^^^^921379^^^^OLIST\r"
				+ "ORC|RE||T09-100442-RET-0^^OLIS_Site_ID^ISO|||||||||OLIST^BLAKE^DONALD^THOR^^^^L^921379\r"
				+ "OBR|0||T09-100442-RET-0^^OLIS_Site_ID^ISO|RET^RETICULOCYTE COUNT^HL79901 literal|||200905011106|||||||200905011106||OLIST^BLAKE^DONALD^THOR^^^^L^921379||7870279|7870279|T09-100442|MOHLTC|200905011130||B7|F||1^^^200905011106^^R\r"
				+ "OBX|1\r"
				+ "OBX|3\r"
				+ "OBX|4\r";
        ORU_R01 oruR01 = new ORU_R01();
        oruR01.parse(string);


        ORU_R01_OBSERVATION newGroup = new ORU_R01_OBSERVATION(oruR01.getPATIENT_RESULT().getORDER_OBSERVATION(), oruR01.getParser().getFactory());
        oruR01.getPATIENT_RESULT().getORDER_OBSERVATION().insertOBSERVATION(newGroup, 1);
        newGroup.getOBX().getSetIDOBX().setValue("2");

        String expected = "MSH|^~\\&|ULTRA|TML|OLIS|OLIS|200905011130||ORU^R01|20169838|T|2.5\r"
				+ "PID|||7005728^^^TML^MR||TEST^RACHEL^DIAMOND||19310313|F|||200 ANYWHERE ST^^TORONTO^ON^M6G 2T9||(416)888-8888||||||1014071185^KR\r"
				+ "PV1|1||OLIS||||OLIST^BLAKE^DONALD^THOR^^^^^921379^^^^OLIST\r"
				+ "ORC|RE||T09-100442-RET-0^^OLIS_Site_ID^ISO|||||||||OLIST^BLAKE^DONALD^THOR^^^^L^921379\r"
				+ "OBR|0||T09-100442-RET-0^^OLIS_Site_ID^ISO|RET^RETICULOCYTE COUNT^HL79901 literal|||200905011106|||||||200905011106||OLIST^BLAKE^DONALD^THOR^^^^L^921379||7870279|7870279|T09-100442|MOHLTC|200905011130||B7|F||1^^^200905011106^^R\r"
				+ "OBX|1\r"
				+ "OBX|2\r"
				+ "OBX|3\r"
				+ "OBX|4\r";
        assertEquals(expected, oruR01.encode());
    }


    @Test
    public void testRemoveRepetition() throws HL7Exception {

        String string = "MSH|^~\\&|ULTRA|TML|OLIS|OLIS|200905011130||ORU^R01|20169838|T|2.5\r"
				+ "PID|||7005728^^^TML^MR||TEST^RACHEL^DIAMOND||19310313|F|||200 ANYWHERE ST^^TORONTO^ON^M6G 2T9||(416)888-8888||||||1014071185^KR\r"
				+ "PV1|1||OLIS||||OLIST^BLAKE^DONALD^THOR^^^^^921379^^^^OLIST\r"
				+ "ORC|RE||T09-100442-RET-0^^OLIS_Site_ID^ISO|||||||||OLIST^BLAKE^DONALD^THOR^^^^L^921379\r"
				+ "OBR|0||T09-100442-RET-0^^OLIS_Site_ID^ISO|RET^RETICULOCYTE COUNT^HL79901 literal|||200905011106|||||||200905011106||OLIST^BLAKE^DONALD^THOR^^^^L^921379||7870279|7870279|T09-100442|MOHLTC|200905011130||B7|F||1^^^200905011106^^R\r"
				+ "OBX|1\r"
				+ "OBX|2\r"
				+ "OBX|3\r";
        ORU_R01 oruR01 = new ORU_R01();
        oruR01.parse(string);


        ORU_R01_OBSERVATION obx = oruR01.getPATIENT_RESULT().getORDER_OBSERVATION().removeOBSERVATION(1);
        assertEquals("OBX|2", obx.getOBX().encode());

        String expected = "MSH|^~\\&|ULTRA|TML|OLIS|OLIS|200905011130||ORU^R01|20169838|T|2.5\r"
				+ "PID|||7005728^^^TML^MR||TEST^RACHEL^DIAMOND||19310313|F|||200 ANYWHERE ST^^TORONTO^ON^M6G 2T9||(416)888-8888||||||1014071185^KR\r"
				+ "PV1|1||OLIS||||OLIST^BLAKE^DONALD^THOR^^^^^921379^^^^OLIST\r"
				+ "ORC|RE||T09-100442-RET-0^^OLIS_Site_ID^ISO|||||||||OLIST^BLAKE^DONALD^THOR^^^^L^921379\r"
				+ "OBR|0||T09-100442-RET-0^^OLIS_Site_ID^ISO|RET^RETICULOCYTE COUNT^HL79901 literal|||200905011106|||||||200905011106||OLIST^BLAKE^DONALD^THOR^^^^L^921379||7870279|7870279|T09-100442|MOHLTC|200905011130||B7|F||1^^^200905011106^^R\r"
				+ "OBX|1\r"
				+ "OBX|3\r";
        assertEquals(expected, oruR01.encode());
    }

}
