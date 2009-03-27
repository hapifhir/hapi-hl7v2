package ca.uhn.hl7v2.model.v24.group;

import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.log.HapiLogFactory;
import ca.uhn.hl7v2.model.v24.segment.*;

import ca.uhn.hl7v2.model.*;
/**
 * <p>Represents the MFN_M10_MF_TEST_BATT_DETAIL Group.  A Group is an ordered collection of message 
 * segments that can repeat together or be optionally in/excluded together.
 * This Group contains the following elements: </p>
 * 0: OM5 (Observation Batteries (Sets)) <b></b><br>
 * 1: OM4 (Observations that Require Specimens) <b>optional repeating</b><br>
 */
public class MFN_M10_MF_TEST_BATT_DETAIL extends AbstractGroup {

	/** 
	 * Creates a new MFN_M10_MF_TEST_BATT_DETAIL Group.
	 */
	public MFN_M10_MF_TEST_BATT_DETAIL(Group parent, ModelClassFactory factory) {
	   super(parent, factory);
	   try {
	      this.add(OM5.class, true, false);
	      this.add(OM4.class, false, true);
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error creating MFN_M10_MF_TEST_BATT_DETAIL - this is probably a bug in the source code generator.", e);
	   }
	}

	/**
	 * Returns OM5 (Observation Batteries (Sets)) - creates it if necessary
	 */
	public OM5 getOM5() { 
	   OM5 ret = null;
	   try {
	      ret = (OM5)this.get("OM5");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns  first repetition of OM4 (Observations that Require Specimens) - creates it if necessary
	 */
	public OM4 getOM4() { 
	   OM4 ret = null;
	   try {
	      ret = (OM4)this.get("OM4");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns a specific repetition of OM4
	 * (Observations that Require Specimens) - creates it if necessary
	 * throws HL7Exception if the repetition requested is more than one 
	 *     greater than the number of existing repetitions.
	 */
	public OM4 getOM4(int rep) throws HL7Exception { 
	   return (OM4)this.get("OM4", rep);
	}

	/** 
	 * Returns the number of existing repetitions of OM4 
	 */ 
	public int getOM4Reps() { 
	    int reps = -1; 
	    try { 
	        reps = this.getAll("OM4").length; 
	    } catch (HL7Exception e) { 
	        String message = "Unexpected error accessing data - this is probably a bug in the source code generator."; 
	        HapiLogFactory.getHapiLog(this.getClass()).error(message, e); 
	        throw new RuntimeException(message);
	    } 
	    return reps; 
	} 

}
