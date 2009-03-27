package ca.uhn.hl7v2.model.v23.group;

import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.log.HapiLogFactory;
import ca.uhn.hl7v2.model.v23.segment.*;

import ca.uhn.hl7v2.model.*;
/**
 * <p>Represents the RRD_O02_PATIENT Group.  A Group is an ordered collection of message 
 * segments that can repeat together or be optionally in/excluded together.
 * This Group contains the following elements: </p>
 * 0: RRD_O02_RESPONSE (a Group object) <b>optional </b><br>
 * 1: RRD_O02_ORDER (a Group object) <b>repeating</b><br>
 */
public class RRD_O02_PATIENT extends AbstractGroup {

	/** 
	 * Creates a new RRD_O02_PATIENT Group.
	 */
	public RRD_O02_PATIENT(Group parent, ModelClassFactory factory) {
	   super(parent, factory);
	   try {
	      this.add(RRD_O02_RESPONSE.class, false, false);
	      this.add(RRD_O02_ORDER.class, true, true);
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error creating RRD_O02_PATIENT - this is probably a bug in the source code generator.", e);
	   }
	}

	/**
	 * Returns RRD_O02_RESPONSE (a Group object) - creates it if necessary
	 */
	public RRD_O02_RESPONSE getRESPONSE() { 
	   RRD_O02_RESPONSE ret = null;
	   try {
	      ret = (RRD_O02_RESPONSE)this.get("RESPONSE");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns  first repetition of RRD_O02_ORDER (a Group object) - creates it if necessary
	 */
	public RRD_O02_ORDER getORDER() { 
	   RRD_O02_ORDER ret = null;
	   try {
	      ret = (RRD_O02_ORDER)this.get("ORDER");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns a specific repetition of RRD_O02_ORDER
	 * (a Group object) - creates it if necessary
	 * throws HL7Exception if the repetition requested is more than one 
	 *     greater than the number of existing repetitions.
	 */
	public RRD_O02_ORDER getORDER(int rep) throws HL7Exception { 
	   return (RRD_O02_ORDER)this.get("ORDER", rep);
	}

	/** 
	 * Returns the number of existing repetitions of RRD_O02_ORDER 
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
