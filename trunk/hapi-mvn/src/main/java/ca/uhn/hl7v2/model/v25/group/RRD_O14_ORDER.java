package ca.uhn.hl7v2.model.v25.group;

import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.log.HapiLogFactory;
import ca.uhn.hl7v2.model.v25.segment.*;

import ca.uhn.hl7v2.model.*;
/**
 * <p>Represents the RRD_O14_ORDER Group.  A Group is an ordered collection of message 
 * segments that can repeat together or be optionally in/excluded together.
 * This Group contains the following elements: </p>
 * 0: ORC (Common Order) <b></b><br>
 * 1: RRD_O14_TIMING (a Group object) <b>optional repeating</b><br>
 * 2: RRD_O14_DISPENSE (a Group object) <b>optional </b><br>
 */
public class RRD_O14_ORDER extends AbstractGroup {

	/** 
	 * Creates a new RRD_O14_ORDER Group.
	 */
	public RRD_O14_ORDER(Group parent, ModelClassFactory factory) {
	   super(parent, factory);
	   try {
	      this.add(ORC.class, true, false);
	      this.add(RRD_O14_TIMING.class, false, true);
	      this.add(RRD_O14_DISPENSE.class, false, false);
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error creating RRD_O14_ORDER - this is probably a bug in the source code generator.", e);
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
	 * Returns  first repetition of RRD_O14_TIMING (a Group object) - creates it if necessary
	 */
	public RRD_O14_TIMING getTIMING() { 
	   RRD_O14_TIMING ret = null;
	   try {
	      ret = (RRD_O14_TIMING)this.get("TIMING");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns a specific repetition of RRD_O14_TIMING
	 * (a Group object) - creates it if necessary
	 * throws HL7Exception if the repetition requested is more than one 
	 *     greater than the number of existing repetitions.
	 */
	public RRD_O14_TIMING getTIMING(int rep) throws HL7Exception { 
	   return (RRD_O14_TIMING)this.get("TIMING", rep);
	}

	/** 
	 * Returns the number of existing repetitions of RRD_O14_TIMING 
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
	 * Returns RRD_O14_DISPENSE (a Group object) - creates it if necessary
	 */
	public RRD_O14_DISPENSE getDISPENSE() { 
	   RRD_O14_DISPENSE ret = null;
	   try {
	      ret = (RRD_O14_DISPENSE)this.get("DISPENSE");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

}
