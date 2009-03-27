package ca.uhn.hl7v2.model.v25.group;

import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.log.HapiLogFactory;
import ca.uhn.hl7v2.model.v25.segment.*;

import ca.uhn.hl7v2.model.*;
/**
 * <p>Represents the ORL_O36_ORDER Group.  A Group is an ordered collection of message 
 * segments that can repeat together or be optionally in/excluded together.
 * This Group contains the following elements: </p>
 * 0: ORC (Common Order) <b></b><br>
 * 1: ORL_O36_TIMING (a Group object) <b>optional repeating</b><br>
 * 2: ORL_O36_OBSERVATION_REQUEST (a Group object) <b>optional </b><br>
 */
public class ORL_O36_ORDER extends AbstractGroup {

	/** 
	 * Creates a new ORL_O36_ORDER Group.
	 */
	public ORL_O36_ORDER(Group parent, ModelClassFactory factory) {
	   super(parent, factory);
	   try {
	      this.add(ORC.class, true, false);
	      this.add(ORL_O36_TIMING.class, false, true);
	      this.add(ORL_O36_OBSERVATION_REQUEST.class, false, false);
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error creating ORL_O36_ORDER - this is probably a bug in the source code generator.", e);
	   }
	}

	/**
	 * Returns ORC (Common Order) - creates it if necessary
	 */
	public ORC getORC() { 
	   ORC ret = null;
	   try {
	      ret = (ORC)this.get("ORC");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns  first repetition of ORL_O36_TIMING (a Group object) - creates it if necessary
	 */
	public ORL_O36_TIMING getTIMING() { 
	   ORL_O36_TIMING ret = null;
	   try {
	      ret = (ORL_O36_TIMING)this.get("TIMING");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns a specific repetition of ORL_O36_TIMING
	 * (a Group object) - creates it if necessary
	 * throws HL7Exception if the repetition requested is more than one 
	 *     greater than the number of existing repetitions.
	 */
	public ORL_O36_TIMING getTIMING(int rep) throws HL7Exception { 
	   return (ORL_O36_TIMING)this.get("TIMING", rep);
	}

	/** 
	 * Returns the number of existing repetitions of ORL_O36_TIMING 
	 */ 
	public int getTIMINGReps() { 
	    int reps = -1; 
	    try { 
	        reps = this.getAll("TIMING").length; 
	    } catch (HL7Exception e) { 
	        String message = "Unexpected error accessing data - this is probably a bug in the source code generator."; 
	        HapiLogFactory.getHapiLog(this.getClass()).error(message, e); 
	        throw new RuntimeException(message);
	    } 
	    return reps; 
	} 

	/**
	 * Returns ORL_O36_OBSERVATION_REQUEST (a Group object) - creates it if necessary
	 */
	public ORL_O36_OBSERVATION_REQUEST getOBSERVATION_REQUEST() { 
	   ORL_O36_OBSERVATION_REQUEST ret = null;
	   try {
	      ret = (ORL_O36_OBSERVATION_REQUEST)this.get("OBSERVATION_REQUEST");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

}
