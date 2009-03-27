package ca.uhn.hl7v2.model.v23.group;

import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.log.HapiLogFactory;
import ca.uhn.hl7v2.model.v23.segment.*;

import ca.uhn.hl7v2.model.*;
/**
 * <p>Represents the CSU_C12_STUDY_PHASE Group.  A Group is an ordered collection of message 
 * segments that can repeat together or be optionally in/excluded together.
 * This Group contains the following elements: </p>
 * 0: CSP (Clinical Study Phase) <b>optional </b><br>
 * 1: CSU_C12_STUDY_SCHEDULE (a Group object) <b>repeating</b><br>
 */
public class CSU_C12_STUDY_PHASE extends AbstractGroup {

	/** 
	 * Creates a new CSU_C12_STUDY_PHASE Group.
	 */
	public CSU_C12_STUDY_PHASE(Group parent, ModelClassFactory factory) {
	   super(parent, factory);
	   try {
	      this.add(CSP.class, false, false);
	      this.add(CSU_C12_STUDY_SCHEDULE.class, true, true);
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error creating CSU_C12_STUDY_PHASE - this is probably a bug in the source code generator.", e);
	   }
	}

	/**
	 * Returns CSP (Clinical Study Phase) - creates it if necessary
	 */
	public CSP getCSP() { 
	   CSP ret = null;
	   try {
	      ret = (CSP)this.get("CSP");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns  first repetition of CSU_C12_STUDY_SCHEDULE (a Group object) - creates it if necessary
	 */
	public CSU_C12_STUDY_SCHEDULE getSTUDY_SCHEDULE() { 
	   CSU_C12_STUDY_SCHEDULE ret = null;
	   try {
	      ret = (CSU_C12_STUDY_SCHEDULE)this.get("STUDY_SCHEDULE");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns a specific repetition of CSU_C12_STUDY_SCHEDULE
	 * (a Group object) - creates it if necessary
	 * throws HL7Exception if the repetition requested is more than one 
	 *     greater than the number of existing repetitions.
	 */
	public CSU_C12_STUDY_SCHEDULE getSTUDY_SCHEDULE(int rep) throws HL7Exception { 
	   return (CSU_C12_STUDY_SCHEDULE)this.get("STUDY_SCHEDULE", rep);
	}

	/** 
	 * Returns the number of existing repetitions of CSU_C12_STUDY_SCHEDULE 
	 */ 
	public int getSTUDY_SCHEDULEReps() { 
	    int reps = -1; 
	    try { 
	        reps = this.getAll("STUDY_SCHEDULE").length; 
	    } catch (HL7Exception e) { 
	        String message = "Unexpected error accessing data - this is probably a bug in the source code generator."; 
	        HapiLogFactory.getHapiLog(this.getClass()).error(message, e); 
	        throw new RuntimeException(message);
	    } 
	    return reps; 
	} 

}
