package ca.uhn.hl7v2.model.v23.group;

import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.log.HapiLogFactory;
import ca.uhn.hl7v2.model.v23.segment.*;

import ca.uhn.hl7v2.model.*;
/**
 * <p>Represents the MFN_M09_MF_TEST_CATEGORICAL Group.  A Group is an ordered collection of message 
 * segments that can repeat together or be optionally in/excluded together.
 * This Group contains the following elements: </p>
 * 0: MFE (Master file entry segment) <b></b><br>
 * 1: MFN_M09_MF_TEST_CAT_DETAIL (a Group object) <b>optional </b><br>
 */
public class MFN_M09_MF_TEST_CATEGORICAL extends AbstractGroup {

	/** 
	 * Creates a new MFN_M09_MF_TEST_CATEGORICAL Group.
	 */
	public MFN_M09_MF_TEST_CATEGORICAL(Group parent, ModelClassFactory factory) {
	   super(parent, factory);
	   try {
	      this.add(MFE.class, true, false);
	      this.add(MFN_M09_MF_TEST_CAT_DETAIL.class, false, false);
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error creating MFN_M09_MF_TEST_CATEGORICAL - this is probably a bug in the source code generator.", e);
	   }
	}

	/**
	 * Returns MFE (Master file entry segment) - creates it if necessary
	 */
	public MFE getMFE() { 
	   MFE ret = null;
	   try {
	      ret = (MFE)this.get("MFE");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns MFN_M09_MF_TEST_CAT_DETAIL (a Group object) - creates it if necessary
	 */
	public MFN_M09_MF_TEST_CAT_DETAIL getMF_TEST_CAT_DETAIL() { 
	   MFN_M09_MF_TEST_CAT_DETAIL ret = null;
	   try {
	      ret = (MFN_M09_MF_TEST_CAT_DETAIL)this.get("MF_TEST_CAT_DETAIL");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

}
