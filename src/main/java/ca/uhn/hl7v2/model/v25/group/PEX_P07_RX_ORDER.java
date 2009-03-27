package ca.uhn.hl7v2.model.v25.group;

import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.log.HapiLogFactory;
import ca.uhn.hl7v2.model.v25.segment.*;

import ca.uhn.hl7v2.model.*;
/**
 * <p>Represents the PEX_P07_RX_ORDER Group.  A Group is an ordered collection of message 
 * segments that can repeat together or be optionally in/excluded together.
 * This Group contains the following elements: </p>
 * 0: RXE (Pharmacy/Treatment Encoded Order) <b></b><br>
 * 1: PEX_P07_TIMING_QTY (a Group object) <b>repeating</b><br>
 * 2: RXR (Pharmacy/Treatment Route) <b>optional repeating</b><br>
 */
public class PEX_P07_RX_ORDER extends AbstractGroup {

	/** 
	 * Creates a new PEX_P07_RX_ORDER Group.
	 */
	public PEX_P07_RX_ORDER(Group parent, ModelClassFactory factory) {
	   super(parent, factory);
	   try {
	      this.add(RXE.class, true, false);
	      this.add(PEX_P07_TIMING_QTY.class, true, true);
	      this.add(RXR.class, false, true);
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error creating PEX_P07_RX_ORDER - this is probably a bug in the source code generator.", e);
	   }
	}

	/**
	 * Returns RXE (Pharmacy/Treatment Encoded Order) - creates it if necessary
	 */
	public RXE getRXE() { 
	   RXE ret = null;
	   try {
	      ret = (RXE)this.get("RXE");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns  first repetition of PEX_P07_TIMING_QTY (a Group object) - creates it if necessary
	 */
	public PEX_P07_TIMING_QTY getTIMING_QTY() { 
	   PEX_P07_TIMING_QTY ret = null;
	   try {
	      ret = (PEX_P07_TIMING_QTY)this.get("TIMING_QTY");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns a specific repetition of PEX_P07_TIMING_QTY
	 * (a Group object) - creates it if necessary
	 * throws HL7Exception if the repetition requested is more than one 
	 *     greater than the number of existing repetitions.
	 */
	public PEX_P07_TIMING_QTY getTIMING_QTY(int rep) throws HL7Exception { 
	   return (PEX_P07_TIMING_QTY)this.get("TIMING_QTY", rep);
	}

	/** 
	 * Returns the number of existing repetitions of PEX_P07_TIMING_QTY 
	 */ 
	public int getTIMING_QTYReps() { 
	    int reps = -1; 
	    try { 
	        reps = this.getAll("TIMING_QTY").length; 
	    } catch (HL7Exception e) { 
	        String message = "Unexpected error accessing data - this is probably a bug in the source code generator."; 
	        HapiLogFactory.getHapiLog(this.getClass()).error(message, e); 
	        throw new RuntimeException(message);
	    } 
	    return reps; 
	} 

	/**
	 * Returns  first repetition of RXR (Pharmacy/Treatment Route) - creates it if necessary
	 */
	public RXR getRXR() { 
	   RXR ret = null;
	   try {
	      ret = (RXR)this.get("RXR");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns a specific repetition of RXR
	 * (Pharmacy/Treatment Route) - creates it if necessary
	 * throws HL7Exception if the repetition requested is more than one 
	 *     greater than the number of existing repetitions.
	 */
	public RXR getRXR(int rep) throws HL7Exception { 
	   return (RXR)this.get("RXR", rep);
	}

	/** 
	 * Returns the number of existing repetitions of RXR 
	 */ 
	public int getRXRReps() { 
	    int reps = -1; 
	    try { 
	        reps = this.getAll("RXR").length; 
	    } catch (HL7Exception e) { 
	        String message = "Unexpected error accessing data - this is probably a bug in the source code generator."; 
	        HapiLogFactory.getHapiLog(this.getClass()).error(message, e); 
	        throw new RuntimeException(message);
	    } 
	    return reps; 
	} 

}
