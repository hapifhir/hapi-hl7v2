package ca.uhn.hl7v2.model.v25.group;

import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.log.HapiLogFactory;
import ca.uhn.hl7v2.model.v25.segment.*;

import ca.uhn.hl7v2.model.*;
/**
 * <p>Represents the MFN_M11_MF_TEST_CALC_DETAIL Group.  A Group is an ordered collection of message 
 * segments that can repeat together or be optionally in/excluded together.
 * This Group contains the following elements: </p>
 * 0: OM6 (Observations that are Calculated from Other Observations) <b></b><br>
 * 1: OM2 (Numeric Observation) <b></b><br>
 */
public class MFN_M11_MF_TEST_CALC_DETAIL extends AbstractGroup {

	/** 
	 * Creates a new MFN_M11_MF_TEST_CALC_DETAIL Group.
	 */
	public MFN_M11_MF_TEST_CALC_DETAIL(Group parent, ModelClassFactory factory) {
	   super(parent, factory);
	   try {
	      this.add(OM6.class, true, false);
	      this.add(OM2.class, true, false);
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error creating MFN_M11_MF_TEST_CALC_DETAIL - this is probably a bug in the source code generator.", e);
	   }
	}

	/**
	 * Returns OM6 (Observations that are Calculated from Other Observations) - creates it if necessary
	 */
	public OM6 getOM6() { 
	   OM6 ret = null;
	   try {
	      ret = (OM6)this.get("OM6");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns OM2 (Numeric Observation) - creates it if necessary
	 */
	public OM2 getOM2() { 
	   OM2 ret = null;
	   try {
	      ret = (OM2)this.get("OM2");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

}
