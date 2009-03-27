package ca.uhn.hl7v2.model.v25.group;

import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.log.HapiLogFactory;
import ca.uhn.hl7v2.model.v25.segment.*;

import ca.uhn.hl7v2.model.*;
/**
 * <p>Represents the RRE_O12_ORDER Group.  A Group is an ordered collection of message 
 * segments that can repeat together or be optionally in/excluded together.
 * This Group contains the following elements: </p>
 * 0: ORC (Common Order) <b></b><br>
 * 1: RRE_O12_TIMING (a Group object) <b>optional repeating</b><br>
 * 2: RRE_O12_ENCODING (a Group object) <b>optional </b><br>
 */
public class RRE_O12_ORDER extends AbstractGroup {

	/** 
	 * Creates a new RRE_O12_ORDER Group.
	 */
	public RRE_O12_ORDER(Group parent, ModelClassFactory factory) {
	   super(parent, factory);
	   try {
	      this.add(ORC.class, true, false);
	      this.add(RRE_O12_TIMING.class, false, true);
	      this.add(RRE_O12_ENCODING.class, false, false);
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error creating RRE_O12_ORDER - this is probably a bug in the source code generator.", e);
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
	 * Returns  first repetition of RRE_O12_TIMING (a Group object) - creates it if necessary
	 */
	public RRE_O12_TIMING getTIMING() { 
	   RRE_O12_TIMING ret = null;
	   try {
	      ret = (RRE_O12_TIMING)this.get("TIMING");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns a specific repetition of RRE_O12_TIMING
	 * (a Group object) - creates it if necessary
	 * throws HL7Exception if the repetition requested is more than one 
	 *     greater than the number of existing repetitions.
	 */
	public RRE_O12_TIMING getTIMING(int rep) throws HL7Exception { 
	   return (RRE_O12_TIMING)this.get("TIMING", rep);
	}

	/** 
	 * Returns the number of existing repetitions of RRE_O12_TIMING 
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
	 * Returns RRE_O12_ENCODING (a Group object) - creates it if necessary
	 */
	public RRE_O12_ENCODING getENCODING() { 
	   RRE_O12_ENCODING ret = null;
	   try {
	      ret = (RRE_O12_ENCODING)this.get("ENCODING");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

}
