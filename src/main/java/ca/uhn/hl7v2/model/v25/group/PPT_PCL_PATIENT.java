package ca.uhn.hl7v2.model.v25.group;

import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.log.HapiLogFactory;
import ca.uhn.hl7v2.model.v25.segment.*;

import ca.uhn.hl7v2.model.*;
/**
 * <p>Represents the PPT_PCL_PATIENT Group.  A Group is an ordered collection of message 
 * segments that can repeat together or be optionally in/excluded together.
 * This Group contains the following elements: </p>
 * 0: PID (Patient Identification) <b></b><br>
 * 1: PPT_PCL_PATIENT_VISIT (a Group object) <b>optional </b><br>
 * 2: PPT_PCL_PATHWAY (a Group object) <b>repeating</b><br>
 */
public class PPT_PCL_PATIENT extends AbstractGroup {

	/** 
	 * Creates a new PPT_PCL_PATIENT Group.
	 */
	public PPT_PCL_PATIENT(Group parent, ModelClassFactory factory) {
	   super(parent, factory);
	   try {
	      this.add(PID.class, true, false);
	      this.add(PPT_PCL_PATIENT_VISIT.class, false, false);
	      this.add(PPT_PCL_PATHWAY.class, true, true);
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error creating PPT_PCL_PATIENT - this is probably a bug in the source code generator.", e);
	   }
	}

	/**
	 * Returns PID (Patient Identification) - creates it if necessary
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
	 * Returns PPT_PCL_PATIENT_VISIT (a Group object) - creates it if necessary
	 */
	public PPT_PCL_PATIENT_VISIT getPATIENT_VISIT() { 
	   PPT_PCL_PATIENT_VISIT ret = null;
	   try {
	      ret = (PPT_PCL_PATIENT_VISIT)this.get("PATIENT_VISIT");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns  first repetition of PPT_PCL_PATHWAY (a Group object) - creates it if necessary
	 */
	public PPT_PCL_PATHWAY getPATHWAY() { 
	   PPT_PCL_PATHWAY ret = null;
	   try {
	      ret = (PPT_PCL_PATHWAY)this.get("PATHWAY");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns a specific repetition of PPT_PCL_PATHWAY
	 * (a Group object) - creates it if necessary
	 * throws HL7Exception if the repetition requested is more than one 
	 *     greater than the number of existing repetitions.
	 */
	public PPT_PCL_PATHWAY getPATHWAY(int rep) throws HL7Exception { 
	   return (PPT_PCL_PATHWAY)this.get("PATHWAY", rep);
	}

	/** 
	 * Returns the number of existing repetitions of PPT_PCL_PATHWAY 
	 */ 
	public int getPATHWAYReps() { 
	    int reps = -1; 
	    try { 
	        reps = this.getAll("PATHWAY").length; 
	    } catch (HL7Exception e) { 
	        String message = "Unexpected error accessing data - this is probably a bug in the source code generator."; 
	        HapiLogFactory.getHapiLog(this.getClass()).error(message, e); 
	        throw new RuntimeException(message);
	    } 
	    return reps; 
	} 

}
