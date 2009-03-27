package ca.uhn.hl7v2.model.v25.group;

import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.log.HapiLogFactory;
import ca.uhn.hl7v2.model.v25.segment.*;

import ca.uhn.hl7v2.model.*;
/**
 * <p>Represents the MFN_M09_MF_TEST_CAT_DETAIL Group.  A Group is an ordered collection of message 
 * segments that can repeat together or be optionally in/excluded together.
 * This Group contains the following elements: </p>
 * 0: OM3 (Categorical Service/Test/Observation) <b></b><br>
 * 1: OM4 (Observations that Require Specimens) <b>optional repeating</b><br>
 */
public class MFN_M09_MF_TEST_CAT_DETAIL extends AbstractGroup {

	/** 
	 * Creates a new MFN_M09_MF_TEST_CAT_DETAIL Group.
	 */
	public MFN_M09_MF_TEST_CAT_DETAIL(Group parent, ModelClassFactory factory) {
	   super(parent, factory);
	   try {
	      this.add(OM3.class, true, false);
	      this.add(OM4.class, false, true);
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error creating MFN_M09_MF_TEST_CAT_DETAIL - this is probably a bug in the source code generator.", e);
	   }
	}

	/**
	 * Returns OM3 (Categorical Service/Test/Observation) - creates it if necessary
	 */
	public OM3 getOM3() { 
	   OM3 ret = null;
	   try {
	      ret = (OM3)this.get("OM3");
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
