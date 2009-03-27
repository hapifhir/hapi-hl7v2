package ca.uhn.hl7v2.model.v25.group;

import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.log.HapiLogFactory;
import ca.uhn.hl7v2.model.v25.segment.*;

import ca.uhn.hl7v2.model.*;
/**
 * <p>Represents the RRG_O16_RESPONSE Group.  A Group is an ordered collection of message 
 * segments that can repeat together or be optionally in/excluded together.
 * This Group contains the following elements: </p>
 * 0: RRG_O16_PATIENT (a Group object) <b>optional </b><br>
 * 1: RRG_O16_ORDER (a Group object) <b>repeating</b><br>
 */
public class RRG_O16_RESPONSE extends AbstractGroup {

	/** 
	 * Creates a new RRG_O16_RESPONSE Group.
	 */
	public RRG_O16_RESPONSE(Group parent, ModelClassFactory factory) {
	   super(parent, factory);
	   try {
	      this.add(RRG_O16_PATIENT.class, false, false);
	      this.add(RRG_O16_ORDER.class, true, true);
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error creating RRG_O16_RESPONSE - this is probably a bug in the source code generator.", e);
	   }
	}

	/**
	 * Returns RRG_O16_PATIENT (a Group object) - creates it if necessary
	 */
	public RRG_O16_PATIENT getPATIENT() { 
	   RRG_O16_PATIENT ret = null;
	   try {
	      ret = (RRG_O16_PATIENT)this.get("PATIENT");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns  first repetition of RRG_O16_ORDER (a Group object) - creates it if necessary
	 */
	public RRG_O16_ORDER getORDER() { 
	   RRG_O16_ORDER ret = null;
	   try {
	      ret = (RRG_O16_ORDER)this.get("ORDER");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns a specific repetition of RRG_O16_ORDER
	 * (a Group object) - creates it if necessary
	 * throws HL7Exception if the repetition requested is more than one 
	 *     greater than the number of existing repetitions.
	 */
	public RRG_O16_ORDER getORDER(int rep) throws HL7Exception { 
	   return (RRG_O16_ORDER)this.get("ORDER", rep);
	}

	/** 
	 * Returns the number of existing repetitions of RRG_O16_ORDER 
	 */ 
	public int getORDERReps() { 
	    int reps = -1; 
	    try { 
	        reps = this.getAll("ORDER").length; 
	    } catch (HL7Exception e) { 
	        String message = "Unexpected error accessing data - this is probably a bug in the source code generator."; 
	        HapiLogFactory.getHapiLog(this.getClass()).error(message, e); 
	        throw new RuntimeException(message);
	    } 
	    return reps; 
	} 

}
