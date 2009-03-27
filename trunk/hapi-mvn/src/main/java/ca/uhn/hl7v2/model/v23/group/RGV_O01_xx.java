package ca.uhn.hl7v2.model.v23.group;

import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.log.HapiLogFactory;
import ca.uhn.hl7v2.model.v23.segment.*;

import ca.uhn.hl7v2.model.*;
/**
 * <p>Represents the RGV_O01_xx Group.  A Group is an ordered collection of message 
 * segments that can repeat together or be optionally in/excluded together.
 * This Group contains the following elements: </p>
 * 0: AL1 (Patient allergy information) <b>repeating</b><br>
 * 1: RGV_O01_PATIENT_VISIT (a Group object) <b>optional </b><br>
 */
public class RGV_O01_xx extends AbstractGroup {

	/** 
	 * Creates a new RGV_O01_xx Group.
	 */
	public RGV_O01_xx(Group parent, ModelClassFactory factory) {
	   super(parent, factory);
	   try {
	      this.add(AL1.class, true, true);
	      this.add(RGV_O01_PATIENT_VISIT.class, false, false);
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error creating RGV_O01_xx - this is probably a bug in the source code generator.", e);
	   }
	}

	/**
	 * Returns  first repetition of AL1 (Patient allergy information) - creates it if necessary
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
	 * (Patient allergy information) - creates it if necessary
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
	 * Returns RGV_O01_PATIENT_VISIT (a Group object) - creates it if necessary
	 */
	public RGV_O01_PATIENT_VISIT getPATIENT_VISIT() { 
	   RGV_O01_PATIENT_VISIT ret = null;
	   try {
	      ret = (RGV_O01_PATIENT_VISIT)this.get("PATIENT_VISIT");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

}
