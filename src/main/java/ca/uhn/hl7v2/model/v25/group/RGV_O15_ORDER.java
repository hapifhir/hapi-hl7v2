package ca.uhn.hl7v2.model.v25.group;

import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.log.HapiLogFactory;
import ca.uhn.hl7v2.model.v25.segment.*;

import ca.uhn.hl7v2.model.*;
/**
 * <p>Represents the RGV_O15_ORDER Group.  A Group is an ordered collection of message 
 * segments that can repeat together or be optionally in/excluded together.
 * This Group contains the following elements: </p>
 * 0: ORC (Common Order) <b></b><br>
 * 1: RGV_O15_TIMING (a Group object) <b>optional repeating</b><br>
 * 2: RGV_O15_ORDER_DETAIL (a Group object) <b>optional </b><br>
 * 3: RGV_O15_ENCODING (a Group object) <b>optional </b><br>
 * 4: RGV_O15_GIVE (a Group object) <b>repeating</b><br>
 */
public class RGV_O15_ORDER extends AbstractGroup {

	/** 
	 * Creates a new RGV_O15_ORDER Group.
	 */
	public RGV_O15_ORDER(Group parent, ModelClassFactory factory) {
	   super(parent, factory);
	   try {
	      this.add(ORC.class, true, false);
	      this.add(RGV_O15_TIMING.class, false, true);
	      this.add(RGV_O15_ORDER_DETAIL.class, false, false);
	      this.add(RGV_O15_ENCODING.class, false, false);
	      this.add(RGV_O15_GIVE.class, true, true);
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error creating RGV_O15_ORDER - this is probably a bug in the source code generator.", e);
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
	 * Returns  first repetition of RGV_O15_TIMING (a Group object) - creates it if necessary
	 */
	public RGV_O15_TIMING getTIMING() { 
	   RGV_O15_TIMING ret = null;
	   try {
	      ret = (RGV_O15_TIMING)this.get("TIMING");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns a specific repetition of RGV_O15_TIMING
	 * (a Group object) - creates it if necessary
	 * throws HL7Exception if the repetition requested is more than one 
	 *     greater than the number of existing repetitions.
	 */
	public RGV_O15_TIMING getTIMING(int rep) throws HL7Exception { 
	   return (RGV_O15_TIMING)this.get("TIMING", rep);
	}

	/** 
	 * Returns the number of existing repetitions of RGV_O15_TIMING 
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
	 * Returns RGV_O15_ORDER_DETAIL (a Group object) - creates it if necessary
	 */
	public RGV_O15_ORDER_DETAIL getORDER_DETAIL() { 
	   RGV_O15_ORDER_DETAIL ret = null;
	   try {
	      ret = (RGV_O15_ORDER_DETAIL)this.get("ORDER_DETAIL");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns RGV_O15_ENCODING (a Group object) - creates it if necessary
	 */
	public RGV_O15_ENCODING getENCODING() { 
	   RGV_O15_ENCODING ret = null;
	   try {
	      ret = (RGV_O15_ENCODING)this.get("ENCODING");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns  first repetition of RGV_O15_GIVE (a Group object) - creates it if necessary
	 */
	public RGV_O15_GIVE getGIVE() { 
	   RGV_O15_GIVE ret = null;
	   try {
	      ret = (RGV_O15_GIVE)this.get("GIVE");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns a specific repetition of RGV_O15_GIVE
	 * (a Group object) - creates it if necessary
	 * throws HL7Exception if the repetition requested is more than one 
	 *     greater than the number of existing repetitions.
	 */
	public RGV_O15_GIVE getGIVE(int rep) throws HL7Exception { 
	   return (RGV_O15_GIVE)this.get("GIVE", rep);
	}

	/** 
	 * Returns the number of existing repetitions of RGV_O15_GIVE 
	 */ 
	public int getGIVEReps() { 
	    int reps = -1; 
	    try { 
	        reps = this.getAll("GIVE").length; 
	    } catch (HL7Exception e) { 
	        String message = "Unexpected error accessing data - this is probably a bug in the source code generator."; 
	        HapiLogFactory.getHapiLog(this.getClass()).error(message, e); 
	        throw new RuntimeException(message);
	    } 
	    return reps; 
	} 

}
