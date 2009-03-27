package ca.uhn.hl7v2.model.v21.message;

import ca.uhn.log.HapiLogFactory;
import ca.uhn.hl7v2.model.v21.group.*;

import ca.uhn.hl7v2.model.v21.segment.*;

import ca.uhn.hl7v2.HL7Exception;

import ca.uhn.hl7v2.parser.ModelClassFactory;

import ca.uhn.hl7v2.parser.DefaultModelClassFactory;

import ca.uhn.hl7v2.model.AbstractMessage;

/**
 * <p>Represents a ORU_R03 message structure (see chapter ?). This structure contains the 
 * following elements: </p>
 * 0: MSH (MESSAGE HEADER) <b></b><br>
 * 1: ORU_R03_PATIENT_RESULT (a Group object) <b>repeating</b><br>
 * 2: DSC (CONTINUATION POINTER) <b>optional </b><br>
 */
public class ORU_R03 extends AbstractMessage  {

	/** 
	 * Creates a new ORU_R03 Group with custom ModelClassFactory.
	 */
	public ORU_R03(ModelClassFactory factory) {
	   super(factory);
	   init(factory);
	}

	/**
	 * Creates a new ORU_R03 Group with DefaultModelClassFactory. 
	 */ 
	public ORU_R03() { 
	   super(new DefaultModelClassFactory());
	   init(new DefaultModelClassFactory());
	}

	private void init(ModelClassFactory factory) {
	   try {
	      this.add(MSH.class, true, false);
	      this.add(ORU_R03_PATIENT_RESULT.class, true, true);
	      this.add(DSC.class, false, false);
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error creating ORU_R03 - this is probably a bug in the source code generator.", e);
	   }
	}

	/**
	 * Returns MSH (MESSAGE HEADER) - creates it if necessary
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
	 * Returns  first repetition of ORU_R03_PATIENT_RESULT (a Group object) - creates it if necessary
	 */
	public ORU_R03_PATIENT_RESULT getPATIENT_RESULT() { 
	   ORU_R03_PATIENT_RESULT ret = null;
	   try {
	      ret = (ORU_R03_PATIENT_RESULT)this.get("PATIENT_RESULT");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns a specific repetition of ORU_R03_PATIENT_RESULT
	 * (a Group object) - creates it if necessary
	 * throws HL7Exception if the repetition requested is more than one 
	 *     greater than the number of existing repetitions.
	 */
	public ORU_R03_PATIENT_RESULT getPATIENT_RESULT(int rep) throws HL7Exception { 
	   return (ORU_R03_PATIENT_RESULT)this.get("PATIENT_RESULT", rep);
	}

	/** 
	 * Returns the number of existing repetitions of ORU_R03_PATIENT_RESULT 
	 */ 
	public int getPATIENT_RESULTReps() { 
	    int reps = -1; 
	    try { 
	        reps = this.getAll("PATIENT_RESULT").length; 
	    } catch (HL7Exception e) { 
	        String message = "Unexpected error accessing data - this is probably a bug in the source code generator."; 
	        HapiLogFactory.getHapiLog(this.getClass()).error(message, e); 
	        throw new RuntimeException(message);
	    } 
	    return reps; 
	} 

	/**
	 * Returns DSC (CONTINUATION POINTER) - creates it if necessary
	 */
	public DSC getDSC() { 
	   DSC ret = null;
	   try {
	      ret = (DSC)this.get("DSC");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

}
