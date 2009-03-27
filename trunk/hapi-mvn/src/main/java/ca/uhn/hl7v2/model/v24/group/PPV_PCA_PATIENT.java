package ca.uhn.hl7v2.model.v24.group;

import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.log.HapiLogFactory;
import ca.uhn.hl7v2.model.v24.segment.*;

import ca.uhn.hl7v2.model.*;
/**
 * <p>Represents the PPV_PCA_PATIENT Group.  A Group is an ordered collection of message 
 * segments that can repeat together or be optionally in/excluded together.
 * This Group contains the following elements: </p>
 * 0: PID (Patient identification) <b></b><br>
 * 1: PPV_PCA_PATIENT_VISIT (a Group object) <b>optional </b><br>
 * 2: PPV_PCA_GOAL (a Group object) <b>repeating</b><br>
 */
public class PPV_PCA_PATIENT extends AbstractGroup {

	/** 
	 * Creates a new PPV_PCA_PATIENT Group.
	 */
	public PPV_PCA_PATIENT(Group parent, ModelClassFactory factory) {
	   super(parent, factory);
	   try {
	      this.add(PID.class, true, false);
	      this.add(PPV_PCA_PATIENT_VISIT.class, false, false);
	      this.add(PPV_PCA_GOAL.class, true, true);
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error creating PPV_PCA_PATIENT - this is probably a bug in the source code generator.", e);
	   }
	}

	/**
	 * Returns PID (Patient identification) - creates it if necessary
	 */
	public PID getPID() { 
	   PID ret = null;
	   try {
	      ret = (PID)this.get("PID");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns PPV_PCA_PATIENT_VISIT (a Group object) - creates it if necessary
	 */
	public PPV_PCA_PATIENT_VISIT getPATIENT_VISIT() { 
	   PPV_PCA_PATIENT_VISIT ret = null;
	   try {
	      ret = (PPV_PCA_PATIENT_VISIT)this.get("PATIENT_VISIT");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns  first repetition of PPV_PCA_GOAL (a Group object) - creates it if necessary
	 */
	public PPV_PCA_GOAL getGOAL() { 
	   PPV_PCA_GOAL ret = null;
	   try {
	      ret = (PPV_PCA_GOAL)this.get("GOAL");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns a specific repetition of PPV_PCA_GOAL
	 * (a Group object) - creates it if necessary
	 * throws HL7Exception if the repetition requested is more than one 
	 *     greater than the number of existing repetitions.
	 */
	public PPV_PCA_GOAL getGOAL(int rep) throws HL7Exception { 
	   return (PPV_PCA_GOAL)this.get("GOAL", rep);
	}

	/** 
	 * Returns the number of existing repetitions of PPV_PCA_GOAL 
	 */ 
	public int getGOALReps() { 
	    int reps = -1; 
	    try { 
	        reps = this.getAll("GOAL").length; 
	    } catch (HL7Exception e) { 
	        String message = "Unexpected error accessing data - this is probably a bug in the source code generator."; 
	        HapiLogFactory.getHapiLog(this.getClass()).error(message, e); 
	        throw new RuntimeException(message);
	    } 
	    return reps; 
	} 

}
