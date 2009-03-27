package ca.uhn.hl7v2.model.v25.group;

import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.log.HapiLogFactory;
import ca.uhn.hl7v2.model.v25.segment.*;

import ca.uhn.hl7v2.model.*;
/**
 * <p>Represents the OMD_O03_ORDER_DIET Group.  A Group is an ordered collection of message 
 * segments that can repeat together or be optionally in/excluded together.
 * This Group contains the following elements: </p>
 * 0: ORC (Common Order) <b></b><br>
 * 1: OMD_O03_TIMING_DIET (a Group object) <b>optional repeating</b><br>
 * 2: OMD_O03_DIET (a Group object) <b>optional </b><br>
 */
public class OMD_O03_ORDER_DIET extends AbstractGroup {

	/** 
	 * Creates a new OMD_O03_ORDER_DIET Group.
	 */
	public OMD_O03_ORDER_DIET(Group parent, ModelClassFactory factory) {
	   super(parent, factory);
	   try {
	      this.add(ORC.class, true, false);
	      this.add(OMD_O03_TIMING_DIET.class, false, true);
	      this.add(OMD_O03_DIET.class, false, false);
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error creating OMD_O03_ORDER_DIET - this is probably a bug in the source code generator.", e);
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
	 * Returns  first repetition of OMD_O03_TIMING_DIET (a Group object) - creates it if necessary
	 */
	public OMD_O03_TIMING_DIET getTIMING_DIET() { 
	   OMD_O03_TIMING_DIET ret = null;
	   try {
	      ret = (OMD_O03_TIMING_DIET)this.get("TIMING_DIET");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns a specific repetition of OMD_O03_TIMING_DIET
	 * (a Group object) - creates it if necessary
	 * throws HL7Exception if the repetition requested is more than one 
	 *     greater than the number of existing repetitions.
	 */
	public OMD_O03_TIMING_DIET getTIMING_DIET(int rep) throws HL7Exception { 
	   return (OMD_O03_TIMING_DIET)this.get("TIMING_DIET", rep);
	}

	/** 
	 * Returns the number of existing repetitions of OMD_O03_TIMING_DIET 
	 */ 
	public int getTIMING_DIETReps() { 
	    int reps = -1; 
	    try { 
	        reps = this.getAll("TIMING_DIET").length; 
	    } catch (HL7Exception e) { 
	        String message = "Unexpected error accessing data - this is probably a bug in the source code generator."; 
	        HapiLogFactory.getHapiLog(this.getClass()).error(message, e); 
	        throw new RuntimeException(message);
	    } 
	    return reps; 
	} 

	/**
	 * Returns OMD_O03_DIET (a Group object) - creates it if necessary
	 */
	public OMD_O03_DIET getDIET() { 
	   OMD_O03_DIET ret = null;
	   try {
	      ret = (OMD_O03_DIET)this.get("DIET");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

}
