package ca.uhn.hl7v2.model.v231.group;

import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.log.HapiLogFactory;
import ca.uhn.hl7v2.model.v231.segment.*;

import ca.uhn.hl7v2.model.*;
/**
 * <p>Represents the RRG_O02_PIDNTEORCRXGRXRRXC Group.  A Group is an ordered collection of message 
 * segments that can repeat together or be optionally in/excluded together.
 * This Group contains the following elements: </p>
 * 0: RRG_O02_PIDNTE (a Group object) <b>optional </b><br>
 * 1: RRG_O02_ORCRXGRXRRXC (a Group object) <b>repeating</b><br>
 */
public class RRG_O02_PIDNTEORCRXGRXRRXC extends AbstractGroup {

	/** 
	 * Creates a new RRG_O02_PIDNTEORCRXGRXRRXC Group.
	 */
	public RRG_O02_PIDNTEORCRXGRXRRXC(Group parent, ModelClassFactory factory) {
	   super(parent, factory);
	   try {
	      this.add(RRG_O02_PIDNTE.class, false, false);
	      this.add(RRG_O02_ORCRXGRXRRXC.class, true, true);
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error creating RRG_O02_PIDNTEORCRXGRXRRXC - this is probably a bug in the source code generator.", e);
	   }
	}

	/**
	 * Returns RRG_O02_PIDNTE (a Group object) - creates it if necessary
	 */
	public RRG_O02_PIDNTE getPIDNTE() { 
	   RRG_O02_PIDNTE ret = null;
	   try {
	      ret = (RRG_O02_PIDNTE)this.get("PIDNTE");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns  first repetition of RRG_O02_ORCRXGRXRRXC (a Group object) - creates it if necessary
	 */
	public RRG_O02_ORCRXGRXRRXC getORCRXGRXRRXC() { 
	   RRG_O02_ORCRXGRXRRXC ret = null;
	   try {
	      ret = (RRG_O02_ORCRXGRXRRXC)this.get("ORCRXGRXRRXC");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns a specific repetition of RRG_O02_ORCRXGRXRRXC
	 * (a Group object) - creates it if necessary
	 * throws HL7Exception if the repetition requested is more than one 
	 *     greater than the number of existing repetitions.
	 */
	public RRG_O02_ORCRXGRXRRXC getORCRXGRXRRXC(int rep) throws HL7Exception { 
	   return (RRG_O02_ORCRXGRXRRXC)this.get("ORCRXGRXRRXC", rep);
	}

	/** 
	 * Returns the number of existing repetitions of RRG_O02_ORCRXGRXRRXC 
	 */ 
	public int getORCRXGRXRRXCReps() { 
	    int reps = -1; 
	    try { 
	        reps = this.getAll("ORCRXGRXRRXC").length; 
	    } catch (HL7Exception e) { 
	        String message = "Unexpected error accessing data - this is probably a bug in the source code generator."; 
	        HapiLogFactory.getHapiLog(this.getClass()).error(message, e); 
	        throw new RuntimeException(message);
	    } 
	    return reps; 
	} 

}
