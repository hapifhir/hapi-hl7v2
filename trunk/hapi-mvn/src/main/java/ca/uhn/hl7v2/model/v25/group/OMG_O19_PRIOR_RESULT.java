package ca.uhn.hl7v2.model.v25.group;

import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.log.HapiLogFactory;
import ca.uhn.hl7v2.model.v25.segment.*;

import ca.uhn.hl7v2.model.*;
/**
 * <p>Represents the OMG_O19_PRIOR_RESULT Group.  A Group is an ordered collection of message 
 * segments that can repeat together or be optionally in/excluded together.
 * This Group contains the following elements: </p>
 * 0: OMG_O19_PATIENT_PRIOR (a Group object) <b>optional </b><br>
 * 1: OMG_O19_PATIENT_VISIT_PRIOR (a Group object) <b>optional </b><br>
 * 2: AL1 (Patient Allergy Information) <b>optional repeating</b><br>
 * 3: OMG_O19_ORDER_PRIOR (a Group object) <b>repeating</b><br>
 */
public class OMG_O19_PRIOR_RESULT extends AbstractGroup {

	/** 
	 * Creates a new OMG_O19_PRIOR_RESULT Group.
	 */
	public OMG_O19_PRIOR_RESULT(Group parent, ModelClassFactory factory) {
	   super(parent, factory);
	   try {
	      this.add(OMG_O19_PATIENT_PRIOR.class, false, false);
	      this.add(OMG_O19_PATIENT_VISIT_PRIOR.class, false, false);
	      this.add(AL1.class, false, true);
	      this.add(OMG_O19_ORDER_PRIOR.class, true, true);
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error creating OMG_O19_PRIOR_RESULT - this is probably a bug in the source code generator.", e);
	   }
	}

	/**
	 * Returns OMG_O19_PATIENT_PRIOR (a Group object) - creates it if necessary
	 */
	public OMG_O19_PATIENT_PRIOR getPATIENT_PRIOR() { 
	   OMG_O19_PATIENT_PRIOR ret = null;
	   try {
	      ret = (OMG_O19_PATIENT_PRIOR)this.get("PATIENT_PRIOR");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns OMG_O19_PATIENT_VISIT_PRIOR (a Group object) - creates it if necessary
	 */
	public OMG_O19_PATIENT_VISIT_PRIOR getPATIENT_VISIT_PRIOR() { 
	   OMG_O19_PATIENT_VISIT_PRIOR ret = null;
	   try {
	      ret = (OMG_O19_PATIENT_VISIT_PRIOR)this.get("PATIENT_VISIT_PRIOR");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns  first repetition of AL1 (Patient Allergy Information) - creates it if necessary
	 */
	public AL1 getAL1() { 
	   AL1 ret = null;
	   try {
	      ret = (AL1)this.get("AL1");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns a specific repetition of AL1
	 * (Patient Allergy Information) - creates it if necessary
	 * throws HL7Exception if the repetition requested is more than one 
	 *     greater than the number of existing repetitions.
	 */
	public AL1 getAL1(int rep) throws HL7Exception { 
	   return (AL1)this.get("AL1", rep);
	}

	/** 
	 * Returns the number of existing repetitions of AL1 
	 */ 
	public int getAL1Reps() { 
	    int reps = -1; 
	    try { 
	        reps = this.getAll("AL1").length; 
	    } catch (HL7Exception e) { 
	        String message = "Unexpected error accessing data - this is probably a bug in the source code generator."; 
	        HapiLogFactory.getHapiLog(this.getClass()).error(message, e); 
	        throw new RuntimeException(message);
	    } 
	    return reps; 
	} 

	/**
	 * Returns  first repetition of OMG_O19_ORDER_PRIOR (a Group object) - creates it if necessary
	 */
	public OMG_O19_ORDER_PRIOR getORDER_PRIOR() { 
	   OMG_O19_ORDER_PRIOR ret = null;
	   try {
	      ret = (OMG_O19_ORDER_PRIOR)this.get("ORDER_PRIOR");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns a specific repetition of OMG_O19_ORDER_PRIOR
	 * (a Group object) - creates it if necessary
	 * throws HL7Exception if the repetition requested is more than one 
	 *     greater than the number of existing repetitions.
	 */
	public OMG_O19_ORDER_PRIOR getORDER_PRIOR(int rep) throws HL7Exception { 
	   return (OMG_O19_ORDER_PRIOR)this.get("ORDER_PRIOR", rep);
	}

	/** 
	 * Returns the number of existing repetitions of OMG_O19_ORDER_PRIOR 
	 */ 
	public int getORDER_PRIORReps() { 
	    int reps = -1; 
	    try { 
	        reps = this.getAll("ORDER_PRIOR").length; 
	    } catch (HL7Exception e) { 
	        String message = "Unexpected error accessing data - this is probably a bug in the source code generator."; 
	        HapiLogFactory.getHapiLog(this.getClass()).error(message, e); 
	        throw new RuntimeException(message);
	    } 
	    return reps; 
	} 

}
