package ca.uhn.hl7v2.model.v23.message;

import ca.uhn.log.HapiLogFactory;
import ca.uhn.hl7v2.model.v23.group.*;

import ca.uhn.hl7v2.model.v23.segment.*;

import ca.uhn.hl7v2.HL7Exception;

import ca.uhn.hl7v2.parser.ModelClassFactory;

import ca.uhn.hl7v2.parser.DefaultModelClassFactory;

import ca.uhn.hl7v2.model.AbstractMessage;

/**
 * <p>Represents a PPP_PCC message structure (see chapter ?). This structure contains the 
 * following elements: </p>
 * 0: MSH (Message header segment) <b></b><br>
 * 1: PID (Patient Identification) <b></b><br>
 * 2: PPP_PCC_PATIENT_VISIT (a Group object) <b>optional </b><br>
 * 3: PPP_PCC_PATHWAY (a Group object) <b>repeating</b><br>
 */
public class PPP_PCC extends AbstractMessage  {

	/** 
	 * Creates a new PPP_PCC Group with custom ModelClassFactory.
	 */
	public PPP_PCC(ModelClassFactory factory) {
	   super(factory);
	   init(factory);
	}

	/**
	 * Creates a new PPP_PCC Group with DefaultModelClassFactory. 
	 */ 
	public PPP_PCC() { 
	   super(new DefaultModelClassFactory());
	   init(new DefaultModelClassFactory());
	}

	private void init(ModelClassFactory factory) {
	   try {
	      this.add(MSH.class, true, false);
	      this.add(PID.class, true, false);
	      this.add(PPP_PCC_PATIENT_VISIT.class, false, false);
	      this.add(PPP_PCC_PATHWAY.class, true, true);
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error creating PPP_PCC - this is probably a bug in the source code generator.", e);
	   }
	}

	/**
	 * Returns MSH (Message header segment) - creates it if necessary
	 */
	public MSH getMSH() { 
	   MSH ret = null;
	   try {
	      ret = (MSH)this.get("MSH");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
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
	 * Returns PPP_PCC_PATIENT_VISIT (a Group object) - creates it if necessary
	 */
	public PPP_PCC_PATIENT_VISIT getPATIENT_VISIT() { 
	   PPP_PCC_PATIENT_VISIT ret = null;
	   try {
	      ret = (PPP_PCC_PATIENT_VISIT)this.get("PATIENT_VISIT");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns  first repetition of PPP_PCC_PATHWAY (a Group object) - creates it if necessary
	 */
	public PPP_PCC_PATHWAY getPATHWAY() { 
	   PPP_PCC_PATHWAY ret = null;
	   try {
	      ret = (PPP_PCC_PATHWAY)this.get("PATHWAY");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns a specific repetition of PPP_PCC_PATHWAY
	 * (a Group object) - creates it if necessary
	 * throws HL7Exception if the repetition requested is more than one 
	 *     greater than the number of existing repetitions.
	 */
	public PPP_PCC_PATHWAY getPATHWAY(int rep) throws HL7Exception { 
	   return (PPP_PCC_PATHWAY)this.get("PATHWAY", rep);
	}

	/** 
	 * Returns the number of existing repetitions of PPP_PCC_PATHWAY 
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
