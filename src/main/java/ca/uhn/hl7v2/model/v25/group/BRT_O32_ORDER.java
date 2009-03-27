package ca.uhn.hl7v2.model.v25.group;

import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.log.HapiLogFactory;
import ca.uhn.hl7v2.model.v25.segment.*;

import ca.uhn.hl7v2.model.*;
/**
 * <p>Represents the BRT_O32_ORDER Group.  A Group is an ordered collection of message 
 * segments that can repeat together or be optionally in/excluded together.
 * This Group contains the following elements: </p>
 * 0: ORC (Common Order) <b></b><br>
 * 1: BRT_O32_TIMING (a Group object) <b>optional repeating</b><br>
 * 2: BPO (Blood product order) <b>optional </b><br>
 * 3: BTX (Blood Product Transfusion/Disposition) <b>optional repeating</b><br>
 */
public class BRT_O32_ORDER extends AbstractGroup {

	/** 
	 * Creates a new BRT_O32_ORDER Group.
	 */
	public BRT_O32_ORDER(Group parent, ModelClassFactory factory) {
	   super(parent, factory);
	   try {
	      this.add(ORC.class, true, false);
	      this.add(BRT_O32_TIMING.class, false, true);
	      this.add(BPO.class, false, false);
	      this.add(BTX.class, false, true);
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error creating BRT_O32_ORDER - this is probably a bug in the source code generator.", e);
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
	 * Returns  first repetition of BRT_O32_TIMING (a Group object) - creates it if necessary
	 */
	public BRT_O32_TIMING getTIMING() { 
	   BRT_O32_TIMING ret = null;
	   try {
	      ret = (BRT_O32_TIMING)this.get("TIMING");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns a specific repetition of BRT_O32_TIMING
	 * (a Group object) - creates it if necessary
	 * throws HL7Exception if the repetition requested is more than one 
	 *     greater than the number of existing repetitions.
	 */
	public BRT_O32_TIMING getTIMING(int rep) throws HL7Exception { 
	   return (BRT_O32_TIMING)this.get("TIMING", rep);
	}

	/** 
	 * Returns the number of existing repetitions of BRT_O32_TIMING 
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
	 * Returns  first repetition of BTX (Blood Product Transfusion/Disposition) - creates it if necessary
	 */
	public BTX getBTX() { 
	   BTX ret = null;
	   try {
	      ret = (BTX)this.get("BTX");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns a specific repetition of BTX
	 * (Blood Product Transfusion/Disposition) - creates it if necessary
	 * throws HL7Exception if the repetition requested is more than one 
	 *     greater than the number of existing repetitions.
	 */
	public BTX getBTX(int rep) throws HL7Exception { 
	   return (BTX)this.get("BTX", rep);
	}

	/** 
	 * Returns the number of existing repetitions of BTX 
	 */ 
	public int getBTXReps() { 
	    int reps = -1; 
	    try { 
	        reps = this.getAll("BTX").length; 
	    } catch (HL7Exception e) { 
	        String message = "Unexpected error accessing data - this is probably a bug in the source code generator."; 
	        HapiLogFactory.getHapiLog(this.getClass()).error(message, e); 
	        throw new RuntimeException(message);
	    } 
	    return reps; 
	} 

}
