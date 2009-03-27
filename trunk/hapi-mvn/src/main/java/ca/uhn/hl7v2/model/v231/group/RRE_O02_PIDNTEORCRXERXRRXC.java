package ca.uhn.hl7v2.model.v231.group;

import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.log.HapiLogFactory;
import ca.uhn.hl7v2.model.v231.segment.*;

import ca.uhn.hl7v2.model.*;
/**
 * <p>Represents the RRE_O02_PIDNTEORCRXERXRRXC Group.  A Group is an ordered collection of message 
 * segments that can repeat together or be optionally in/excluded together.
 * This Group contains the following elements: </p>
 * 0: RRE_O02_PIDNTE (a Group object) <b>optional </b><br>
 * 1: RRE_O02_ORCRXERXRRXC (a Group object) <b>repeating</b><br>
 */
public class RRE_O02_PIDNTEORCRXERXRRXC extends AbstractGroup {

	/** 
	 * Creates a new RRE_O02_PIDNTEORCRXERXRRXC Group.
	 */
	public RRE_O02_PIDNTEORCRXERXRRXC(Group parent, ModelClassFactory factory) {
	   super(parent, factory);
	   try {
	      this.add(RRE_O02_PIDNTE.class, false, false);
	      this.add(RRE_O02_ORCRXERXRRXC.class, true, true);
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error creating RRE_O02_PIDNTEORCRXERXRRXC - this is probably a bug in the source code generator.", e);
	   }
	}

	/**
	 * Returns RRE_O02_PIDNTE (a Group object) - creates it if necessary
	 */
	public RRE_O02_PIDNTE getPIDNTE() { 
	   RRE_O02_PIDNTE ret = null;
	   try {
	      ret = (RRE_O02_PIDNTE)this.get("PIDNTE");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns  first repetition of RRE_O02_ORCRXERXRRXC (a Group object) - creates it if necessary
	 */
	public RRE_O02_ORCRXERXRRXC getORCRXERXRRXC() { 
	   RRE_O02_ORCRXERXRRXC ret = null;
	   try {
	      ret = (RRE_O02_ORCRXERXRRXC)this.get("ORCRXERXRRXC");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns a specific repetition of RRE_O02_ORCRXERXRRXC
	 * (a Group object) - creates it if necessary
	 * throws HL7Exception if the repetition requested is more than one 
	 *     greater than the number of existing repetitions.
	 */
	public RRE_O02_ORCRXERXRRXC getORCRXERXRRXC(int rep) throws HL7Exception { 
	   return (RRE_O02_ORCRXERXRRXC)this.get("ORCRXERXRRXC", rep);
	}

	/** 
	 * Returns the number of existing repetitions of RRE_O02_ORCRXERXRRXC 
	 */ 
	public int getORCRXERXRRXCReps() { 
	    int reps = -1; 
	    try { 
	        reps = this.getAll("ORCRXERXRRXC").length; 
	    } catch (HL7Exception e) { 
	        String message = "Unexpected error accessing data - this is probably a bug in the source code generator."; 
	        HapiLogFactory.getHapiLog(this.getClass()).error(message, e); 
	        throw new RuntimeException(message);
	    } 
	    return reps; 
	} 

}
