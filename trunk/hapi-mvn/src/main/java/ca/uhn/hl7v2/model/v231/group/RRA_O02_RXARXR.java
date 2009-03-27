package ca.uhn.hl7v2.model.v231.group;

import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.log.HapiLogFactory;
import ca.uhn.hl7v2.model.v231.segment.*;

import ca.uhn.hl7v2.model.*;
/**
 * <p>Represents the RRA_O02_RXARXR Group.  A Group is an ordered collection of message 
 * segments that can repeat together or be optionally in/excluded together.
 * This Group contains the following elements: </p>
 * 0: RXA (RXA - pharmacy/treatment administration segment) <b>repeating</b><br>
 * 1: RXR (RXR - pharmacy/treatment route segment) <b></b><br>
 */
public class RRA_O02_RXARXR extends AbstractGroup {

	/** 
	 * Creates a new RRA_O02_RXARXR Group.
	 */
	public RRA_O02_RXARXR(Group parent, ModelClassFactory factory) {
	   super(parent, factory);
	   try {
	      this.add(RXA.class, true, true);
	      this.add(RXR.class, true, false);
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error creating RRA_O02_RXARXR - this is probably a bug in the source code generator.", e);
	   }
	}

	/**
	 * Returns  first repetition of RXA (RXA - pharmacy/treatment administration segment) - creates it if necessary
	 */
	public RXA getRXA() { 
	   RXA ret = null;
	   try {
	      ret = (RXA)this.get("RXA");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns a specific repetition of RXA
	 * (RXA - pharmacy/treatment administration segment) - creates it if necessary
	 * throws HL7Exception if the repetition requested is more than one 
	 *     greater than the number of existing repetitions.
	 */
	public RXA getRXA(int rep) throws HL7Exception { 
	   return (RXA)this.get("RXA", rep);
	}

	/** 
	 * Returns the number of existing repetitions of RXA 
	 */ 
	public int getRXAReps() { 
	    int reps = -1; 
	    try { 
	        reps = this.getAll("RXA").length; 
	    } catch (HL7Exception e) { 
	        String message = "Unexpected error accessing data - this is probably a bug in the source code generator."; 
	        HapiLogFactory.getHapiLog(this.getClass()).error(message, e); 
	        throw new RuntimeException(message);
	    } 
	    return reps; 
	} 

	/**
	 * Returns RXR (RXR - pharmacy/treatment route segment) - creates it if necessary
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

}
