package ca.uhn.hl7v2.model.v23.group;

import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.log.HapiLogFactory;
import ca.uhn.hl7v2.model.v23.segment.*;

import ca.uhn.hl7v2.model.*;
/**
 * <p>Represents the CSU_C10_STUDY_SCHEDULE Group.  A Group is an ordered collection of message 
 * segments that can repeat together or be optionally in/excluded together.
 * This Group contains the following elements: </p>
 * 0: CSS (Clinical Study Data Schedule) <b>optional </b><br>
 * 1: CSU_C10_STUDY_OBSERVATION (a Group object) <b>optional repeating</b><br>
 * 2: CSU_C10_STUDY_PHARM (a Group object) <b>repeating</b><br>
 */
public class CSU_C10_STUDY_SCHEDULE extends AbstractGroup {

	/** 
	 * Creates a new CSU_C10_STUDY_SCHEDULE Group.
	 */
	public CSU_C10_STUDY_SCHEDULE(Group parent, ModelClassFactory factory) {
	   super(parent, factory);
	   try {
	      this.add(CSS.class, false, false);
	      this.add(CSU_C10_STUDY_OBSERVATION.class, false, true);
	      this.add(CSU_C10_STUDY_PHARM.class, true, true);
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error creating CSU_C10_STUDY_SCHEDULE - this is probably a bug in the source code generator.", e);
	   }
	}

	/**
	 * Returns CSS (Clinical Study Data Schedule) - creates it if necessary
	 */
	public CSS getCSS() { 
	   CSS ret = null;
	   try {
	      ret = (CSS)this.get("CSS");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns  first repetition of CSU_C10_STUDY_OBSERVATION (a Group object) - creates it if necessary
	 */
	public CSU_C10_STUDY_OBSERVATION getSTUDY_OBSERVATION() { 
	   CSU_C10_STUDY_OBSERVATION ret = null;
	   try {
	      ret = (CSU_C10_STUDY_OBSERVATION)this.get("STUDY_OBSERVATION");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns a specific repetition of CSU_C10_STUDY_OBSERVATION
	 * (a Group object) - creates it if necessary
	 * throws HL7Exception if the repetition requested is more than one 
	 *     greater than the number of existing repetitions.
	 */
	public CSU_C10_STUDY_OBSERVATION getSTUDY_OBSERVATION(int rep) throws HL7Exception { 
	   return (CSU_C10_STUDY_OBSERVATION)this.get("STUDY_OBSERVATION", rep);
	}

	/** 
	 * Returns the number of existing repetitions of CSU_C10_STUDY_OBSERVATION 
	 */ 
	public int getSTUDY_OBSERVATIONReps() { 
	    int reps = -1; 
	    try { 
	        reps = this.getAll("STUDY_OBSERVATION").length; 
	    } catch (HL7Exception e) { 
	        String message = "Unexpected error accessing data - this is probably a bug in the source code generator."; 
	        HapiLogFactory.getHapiLog(this.getClass()).error(message, e); 
	        throw new RuntimeException(message);
	    } 
	    return reps; 
	} 

	/**
	 * Returns  first repetition of CSU_C10_STUDY_PHARM (a Group object) - creates it if necessary
	 */
	public CSU_C10_STUDY_PHARM getSTUDY_PHARM() { 
	   CSU_C10_STUDY_PHARM ret = null;
	   try {
	      ret = (CSU_C10_STUDY_PHARM)this.get("STUDY_PHARM");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns a specific repetition of CSU_C10_STUDY_PHARM
	 * (a Group object) - creates it if necessary
	 * throws HL7Exception if the repetition requested is more than one 
	 *     greater than the number of existing repetitions.
	 */
	public CSU_C10_STUDY_PHARM getSTUDY_PHARM(int rep) throws HL7Exception { 
	   return (CSU_C10_STUDY_PHARM)this.get("STUDY_PHARM", rep);
	}

	/** 
	 * Returns the number of existing repetitions of CSU_C10_STUDY_PHARM 
	 */ 
	public int getSTUDY_PHARMReps() { 
	    int reps = -1; 
	    try { 
	        reps = this.getAll("STUDY_PHARM").length; 
	    } catch (HL7Exception e) { 
	        String message = "Unexpected error accessing data - this is probably a bug in the source code generator."; 
	        HapiLogFactory.getHapiLog(this.getClass()).error(message, e); 
	        throw new RuntimeException(message);
	    } 
	    return reps; 
	} 

}
