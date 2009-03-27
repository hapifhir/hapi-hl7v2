package ca.uhn.hl7v2.model.v231.group;

import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.log.HapiLogFactory;
import ca.uhn.hl7v2.model.v231.segment.*;

import ca.uhn.hl7v2.model.*;
/**
 * <p>Represents the RRD_O02_PIDNTEORCRXDRXRRXC Group.  A Group is an ordered collection of message 
 * segments that can repeat together or be optionally in/excluded together.
 * This Group contains the following elements: </p>
 * 0: RRD_O02_PIDNTE (a Group object) <b>optional </b><br>
 * 1: RRD_O02_ORCRXDRXRRXC (a Group object) <b>repeating</b><br>
 */
public class RRD_O02_PIDNTEORCRXDRXRRXC extends AbstractGroup {

	/** 
	 * Creates a new RRD_O02_PIDNTEORCRXDRXRRXC Group.
	 */
	public RRD_O02_PIDNTEORCRXDRXRRXC(Group parent, ModelClassFactory factory) {
	   super(parent, factory);
	   try {
	      this.add(RRD_O02_PIDNTE.class, false, false);
	      this.add(RRD_O02_ORCRXDRXRRXC.class, true, true);
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error creating RRD_O02_PIDNTEORCRXDRXRRXC - this is probably a bug in the source code generator.", e);
	   }
	}

	/**
	 * Returns RRD_O02_PIDNTE (a Group object) - creates it if necessary
	 */
	public RRD_O02_PIDNTE getPIDNTE() { 
	   RRD_O02_PIDNTE ret = null;
	   try {
	      ret = (RRD_O02_PIDNTE)this.get("PIDNTE");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns  first repetition of RRD_O02_ORCRXDRXRRXC (a Group object) - creates it if necessary
	 */
	public RRD_O02_ORCRXDRXRRXC getORCRXDRXRRXC() { 
	   RRD_O02_ORCRXDRXRRXC ret = null;
	   try {
	      ret = (RRD_O02_ORCRXDRXRRXC)this.get("ORCRXDRXRRXC");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns a specific repetition of RRD_O02_ORCRXDRXRRXC
	 * (a Group object) - creates it if necessary
	 * throws HL7Exception if the repetition requested is more than one 
	 *     greater than the number of existing repetitions.
	 */
	public RRD_O02_ORCRXDRXRRXC getORCRXDRXRRXC(int rep) throws HL7Exception { 
	   return (RRD_O02_ORCRXDRXRRXC)this.get("ORCRXDRXRRXC", rep);
	}

	/** 
	 * Returns the number of existing repetitions of RRD_O02_ORCRXDRXRRXC 
	 */ 
	public int getORCRXDRXRRXCReps() { 
	    int reps = -1; 
	    try { 
	        reps = this.getAll("ORCRXDRXRRXC").length; 
	    } catch (HL7Exception e) { 
	        String message = "Unexpected error accessing data - this is probably a bug in the source code generator."; 
	        HapiLogFactory.getHapiLog(this.getClass()).error(message, e); 
	        throw new RuntimeException(message);
	    } 
	    return reps; 
	} 

}
