package ca.uhn.hl7v2.model.v23.group;

import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.log.HapiLogFactory;
import ca.uhn.hl7v2.model.v23.segment.*;

import ca.uhn.hl7v2.model.*;
/**
 * <p>Represents the MFN_M06_MF_PHASE_SCHED_DETAIL Group.  A Group is an ordered collection of message 
 * segments that can repeat together or be optionally in/excluded together.
 * This Group contains the following elements: </p>
 * 0: CM1 (Clinical Study Phase Master) <b></b><br>
 * 1: CM2 (Clinical Study Schedule Master) <b>optional repeating</b><br>
 */
public class MFN_M06_MF_PHASE_SCHED_DETAIL extends AbstractGroup {

	/** 
	 * Creates a new MFN_M06_MF_PHASE_SCHED_DETAIL Group.
	 */
	public MFN_M06_MF_PHASE_SCHED_DETAIL(Group parent, ModelClassFactory factory) {
	   super(parent, factory);
	   try {
	      this.add(CM1.class, true, false);
	      this.add(CM2.class, false, true);
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error creating MFN_M06_MF_PHASE_SCHED_DETAIL - this is probably a bug in the source code generator.", e);
	   }
	}

	/**
	 * Returns CM1 (Clinical Study Phase Master) - creates it if necessary
	 */
	public CM1 getCM1() { 
	   CM1 ret = null;
	   try {
	      ret = (CM1)this.get("CM1");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns  first repetition of CM2 (Clinical Study Schedule Master) - creates it if necessary
	 */
	public CM2 getCM2() { 
	   CM2 ret = null;
	   try {
	      ret = (CM2)this.get("CM2");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns a specific repetition of CM2
	 * (Clinical Study Schedule Master) - creates it if necessary
	 * throws HL7Exception if the repetition requested is more than one 
	 *     greater than the number of existing repetitions.
	 */
	public CM2 getCM2(int rep) throws HL7Exception { 
	   return (CM2)this.get("CM2", rep);
	}

	/** 
	 * Returns the number of existing repetitions of CM2 
	 */ 
	public int getCM2Reps() { 
	    int reps = -1; 
	    try { 
	        reps = this.getAll("CM2").length; 
	    } catch (HL7Exception e) { 
	        String message = "Unexpected error accessing data - this is probably a bug in the source code generator."; 
	        HapiLogFactory.getHapiLog(this.getClass()).error(message, e); 
	        throw new RuntimeException(message);
	    } 
	    return reps; 
	} 

}
