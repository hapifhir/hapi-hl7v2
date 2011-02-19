package ca.uhn.hl7v2.sourcegen;

import junit.framework.TestCase;
import ca.uhn.hl7v2.model.DataTypeException;
import ca.uhn.hl7v2.model.Type;
import ca.uhn.hl7v2.model.v26.message.MDM_T02;

/**
 * Check particular corner cases of generated classes
 */
public class CheckParticularsTest extends TestCase {

	private void failIfExists(String className) {
        try {
            Class.forName(className);
			fail("Shouldn't exist: " + className);
		} catch (ClassNotFoundException e) {
			// pass
			return;
		}
    }

    /**
	 * This segment is invalid and shouldn't be generated.. The DB contains it for some reason
	 */
	public void testEdSegmentNewDb() {
        String className = "ca.uhn.hl7v2.model.v251.segment.ED";
	    failIfExists(className);
	}

    /**
	 * This segment is invalid and shouldn't be generated.. The DB contains it for some reason
	 */
	public void testEdSegmentOldDb() {
		try {
			Class.forName("ca.uhn.hl7v2.model.v231.segment.ED");
			fail();
		} catch (ClassNotFoundException e) {
			// pass
			return;
		}
	}
	
	
	public void testMdmMessage() {
	    
	    MDM_T02 mdm = new MDM_T02();
	    mdm.getOBSERVATION();
	    
	}

	/**
     * Timing is spelled incorrectly a few times in the DB
     */
    public void testTimingSpelling() {
        failIfExists("ca.uhn.hl7v2.model.v25.group.OML_O21_TIIMING");
        failIfExists("ca.uhn.hl7v2.model.v25.group.OML_O33_TIIMING");
        failIfExists("ca.uhn.hl7v2.model.v25.group.OML_O35_TIIMING");
        failIfExists("ca.uhn.hl7v2.model.v251.group.OML_O21_TIIMING");
        failIfExists("ca.uhn.hl7v2.model.v251.group.OML_O33_TIIMING");
        failIfExists("ca.uhn.hl7v2.model.v251.group.OML_O35_TIIMING");
        failIfExists("ca.uhn.hl7v2.model.v26.group.OML_O21_TIIMING");
        failIfExists("ca.uhn.hl7v2.model.v26.group.OML_O33_TIIMING");
        failIfExists("ca.uhn.hl7v2.model.v26.group.OML_O35_TIIMING");
    }
	
	/**
	 * The first component of TS should be TSComponentOne in older versions of HL7
	 * @throws DataTypeException 
	 */
	public void testTSComponentOne22() throws DataTypeException {
		ca.uhn.hl7v2.model.v22.message.ORU_R01 msg = new ca.uhn.hl7v2.model.v22.message.ORU_R01();
		ca.uhn.hl7v2.model.v22.datatype.TS ts = new ca.uhn.hl7v2.model.v22.datatype.TS(msg);
		Type componentOne = ts.getComponent(0);
		assertEquals(ca.uhn.hl7v2.model.v22.datatype.TSComponentOne.class, componentOne.getClass());
		
	}

	/**
	 * The first component of TS should be TSComponentOne in older versions of HL7
	 * @throws DataTypeException 
	 */
	public void testTSComponentOne23() throws DataTypeException {
		ca.uhn.hl7v2.model.v23.message.ORU_R01 msg = new ca.uhn.hl7v2.model.v23.message.ORU_R01();
		ca.uhn.hl7v2.model.v23.datatype.TS ts = new ca.uhn.hl7v2.model.v23.datatype.TS(msg);
		Type componentOne = ts.getComponent(0);
		assertEquals(ca.uhn.hl7v2.model.v23.datatype.TSComponentOne.class, componentOne.getClass());
		
	}

	/**
	 * The first component of TS should be TSComponentOne in older versions of HL7
	 * @throws DataTypeException 
	 */
	public void testTSComponentOne231() throws DataTypeException {
		ca.uhn.hl7v2.model.v231.message.ORU_R01 msg = new ca.uhn.hl7v2.model.v231.message.ORU_R01();
		ca.uhn.hl7v2.model.v231.datatype.TS ts = new ca.uhn.hl7v2.model.v231.datatype.TS(msg);
		Type componentOne = ts.getComponent(0);
		assertEquals(ca.uhn.hl7v2.model.v231.datatype.TSComponentOne.class, componentOne.getClass());
		
	}

	
	/**
	 * The first component of TS should be TSComponentOne in older versions of HL7
	 * @throws DataTypeException 
	 */
	public void testTSComponentOne24() throws DataTypeException {
		ca.uhn.hl7v2.model.v24.message.ORU_R01 msg = new ca.uhn.hl7v2.model.v24.message.ORU_R01();
		ca.uhn.hl7v2.model.v24.datatype.TS ts = new ca.uhn.hl7v2.model.v24.datatype.TS(msg);
		Type componentOne = ts.getComponent(0);
		assertEquals(ca.uhn.hl7v2.model.v24.datatype.TSComponentOne.class, componentOne.getClass());
		
	}

	

}
