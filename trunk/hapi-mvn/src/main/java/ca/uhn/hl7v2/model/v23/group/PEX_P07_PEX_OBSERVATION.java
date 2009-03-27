package ca.uhn.hl7v2.model.v23.group;

import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.log.HapiLogFactory;
import ca.uhn.hl7v2.model.v23.segment.*;

import ca.uhn.hl7v2.model.*;
/**
 * <p>Represents the PEX_P07_PEX_OBSERVATION Group.  A Group is an ordered collection of message 
 * segments that can repeat together or be optionally in/excluded together.
 * This Group contains the following elements: </p>
 * 0: PEO (Product Experience Observation) <b></b><br>
 * 1: PEX_P07_PEX_CAUSE (a Group object) <b>repeating</b><br>
 */
public class PEX_P07_PEX_OBSERVATION extends AbstractGroup {

	/** 
	 * Creates a new PEX_P07_PEX_OBSERVATION Group.
	 */
	public PEX_P07_PEX_OBSERVATION(Group parent, ModelClassFactory factory) {
	   super(parent, factory);
	   try {
	      this.add(PEO.class, true, false);
	      this.add(PEX_P07_PEX_CAUSE.class, true, true);
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error creating PEX_P07_PEX_OBSERVATION - this is probably a bug in the source code generator.", e);
	   }
	}

	/**
	 * Returns PEO (Product Experience Observation) - creates it if necessary
	 */
	public PEO getPEO() { 
	   PEO ret = null;
	   try {
	      ret = (PEO)this.get("PEO");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns  first repetition of PEX_P07_PEX_CAUSE (a Group object) - creates it if necessary
	 */
	public PEX_P07_PEX_CAUSE getPEX_CAUSE() { 
	   PEX_P07_PEX_CAUSE ret = null;
	   try {
	      ret = (PEX_P07_PEX_CAUSE)this.get("PEX_CAUSE");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns a specific repetition of PEX_P07_PEX_CAUSE
	 * (a Group object) - creates it if necessary
	 * throws HL7Exception if the repetition requested is more than one 
	 *     greater than the number of existing repetitions.
	 */
	public PEX_P07_PEX_CAUSE getPEX_CAUSE(int rep) throws HL7Exception { 
	   return (PEX_P07_PEX_CAUSE)this.get("PEX_CAUSE", rep);
	}

	/** 
	 * Returns the number of existing repetitions of PEX_P07_PEX_CAUSE 
	 */ 
	public int getPEX_CAUSEReps() { 
	    int reps = -1; 
	    try { 
	        reps = this.getAll("PEX_CAUSE").length; 
	    } catch (HL7Exception e) { 
	        String message = "Unexpected error accessing data - this is probably a bug in the source code generator."; 
	        HapiLogFactory.getHapiLog(this.getClass()).error(message, e); 
	        throw new RuntimeException(message);
	    } 
	    return reps; 
	} 

}
