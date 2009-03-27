package ca.uhn.hl7v2.model.v25.group;

import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.log.HapiLogFactory;
import ca.uhn.hl7v2.model.v25.segment.*;

import ca.uhn.hl7v2.model.*;
/**
 * <p>Represents the BRP_O30_ORDER Group.  A Group is an ordered collection of message 
 * segments that can repeat together or be optionally in/excluded together.
 * This Group contains the following elements: </p>
 * 0: ORC (Common Order) <b></b><br>
 * 1: BRP_O30_TIMING (a Group object) <b>optional repeating</b><br>
 * 2: BPO (Blood product order) <b>optional </b><br>
 * 3: BPX (Blood product dispense status) <b>optional repeating</b><br>
 */
public class BRP_O30_ORDER extends AbstractGroup {

	/** 
	 * Creates a new BRP_O30_ORDER Group.
	 */
	public BRP_O30_ORDER(Group parent, ModelClassFactory factory) {
	   super(parent, factory);
	   try {
	      this.add(ORC.class, true, false);
	      this.add(BRP_O30_TIMING.class, false, true);
	      this.add(BPO.class, false, false);
	      this.add(BPX.class, false, true);
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error creating BRP_O30_ORDER - this is probably a bug in the source code generator.", e);
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
	 * Returns  first repetition of BRP_O30_TIMING (a Group object) - creates it if necessary
	 */
	public BRP_O30_TIMING getTIMING() { 
	   BRP_O30_TIMING ret = null;
	   try {
	      ret = (BRP_O30_TIMING)this.get("TIMING");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns a specific repetition of BRP_O30_TIMING
	 * (a Group object) - creates it if necessary
	 * throws HL7Exception if the repetition requested is more than one 
	 *     greater than the number of existing repetitions.
	 */
	public BRP_O30_TIMING getTIMING(int rep) throws HL7Exception { 
	   return (BRP_O30_TIMING)this.get("TIMING", rep);
	}

	/** 
	 * Returns the number of existing repetitions of BRP_O30_TIMING 
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
	 * Returns BPO (Blood product order) - creates it if necessary
	 */
	public BPO getBPO() { 
	   BPO ret = null;
	   try {
	      ret = (BPO)this.get("BPO");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns  first repetition of BPX (Blood product dispense status) - creates it if necessary
	 */
	public BPX getBPX() { 
	   BPX ret = null;
	   try {
	      ret = (BPX)this.get("BPX");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns a specific repetition of BPX
	 * (Blood product dispense status) - creates it if necessary
	 * throws HL7Exception if the repetition requested is more than one 
	 *     greater than the number of existing repetitions.
	 */
	public BPX getBPX(int rep) throws HL7Exception { 
	   return (BPX)this.get("BPX", rep);
	}

	/** 
	 * Returns the number of existing repetitions of BPX 
	 */ 
	public int getBPXReps() { 
	    int reps = -1; 
	    try { 
	        reps = this.getAll("BPX").length; 
	    } catch (HL7Exception e) { 
	        String message = "Unexpected error accessing data - this is probably a bug in the source code generator."; 
	        HapiLogFactory.getHapiLog(this.getClass()).error(message, e); 
	        throw new RuntimeException(message);
	    } 
	    return reps; 
	} 

}
