package ca.uhn.hl7v2.model.v25.group;

import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.log.HapiLogFactory;
import ca.uhn.hl7v2.model.v25.segment.*;

import ca.uhn.hl7v2.model.*;
/**
 * <p>Represents the MFN_M07_MF_CLIN_STUDY_SCHED Group.  A Group is an ordered collection of message 
 * segments that can repeat together or be optionally in/excluded together.
 * This Group contains the following elements: </p>
 * 0: MFE (Master File Entry) <b></b><br>
 * 1: CM0 (Clinical Study Master) <b></b><br>
 * 2: CM2 (Clinical Study Schedule Master) <b>optional repeating</b><br>
 */
public class MFN_M07_MF_CLIN_STUDY_SCHED extends AbstractGroup {

	/** 
	 * Creates a new MFN_M07_MF_CLIN_STUDY_SCHED Group.
	 */
	public MFN_M07_MF_CLIN_STUDY_SCHED(Group parent, ModelClassFactory factory) {
	   super(parent, factory);
	   try {
	      this.add(MFE.class, true, false);
	      this.add(CM0.class, true, false);
	      this.add(CM2.class, false, true);
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error creating MFN_M07_MF_CLIN_STUDY_SCHED - this is probably a bug in the source code generator.", e);
	   }
	}

	/**
	 * Returns MFE (Master File Entry) - creates it if necessary
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
	 * Returns CM0 (Clinical Study Master) - creates it if necessary
	 */
	public CM0 getCM0() { 
	   CM0 ret = null;
	   try {
	      ret = (CM0)this.get("CM0");
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
