package ca.uhn.hl7v2.model.v231.group;

import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.log.HapiLogFactory;
import ca.uhn.hl7v2.model.v231.segment.*;

import ca.uhn.hl7v2.model.*;
/**
 * <p>Represents the RDR_RDR_ORCRXERXRRXCRXDRXRRXC Group.  A Group is an ordered collection of message 
 * segments that can repeat together or be optionally in/excluded together.
 * This Group contains the following elements: </p>
 * 0: ORC (ORC - common order segment) <b></b><br>
 * 1: RDR_RDR_RXERXRRXC (a Group object) <b>optional </b><br>
 * 2: RDR_RDR_RXDRXRRXC (a Group object) <b>repeating</b><br>
 */
public class RDR_RDR_ORCRXERXRRXCRXDRXRRXC extends AbstractGroup {

	/** 
	 * Creates a new RDR_RDR_ORCRXERXRRXCRXDRXRRXC Group.
	 */
	public RDR_RDR_ORCRXERXRRXCRXDRXRRXC(Group parent, ModelClassFactory factory) {
	   super(parent, factory);
	   try {
	      this.add(ORC.class, true, false);
	      this.add(RDR_RDR_RXERXRRXC.class, false, false);
	      this.add(RDR_RDR_RXDRXRRXC.class, true, true);
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error creating RDR_RDR_ORCRXERXRRXCRXDRXRRXC - this is probably a bug in the source code generator.", e);
	   }
	}

	/**
	 * Returns ORC (ORC - common order segment) - creates it if necessary
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
	 * Returns RDR_RDR_RXERXRRXC (a Group object) - creates it if necessary
	 */
	public RDR_RDR_RXERXRRXC getRXERXRRXC() { 
	   RDR_RDR_RXERXRRXC ret = null;
	   try {
	      ret = (RDR_RDR_RXERXRRXC)this.get("RXERXRRXC");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns  first repetition of RDR_RDR_RXDRXRRXC (a Group object) - creates it if necessary
	 */
	public RDR_RDR_RXDRXRRXC getRXDRXRRXC() { 
	   RDR_RDR_RXDRXRRXC ret = null;
	   try {
	      ret = (RDR_RDR_RXDRXRRXC)this.get("RXDRXRRXC");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns a specific repetition of RDR_RDR_RXDRXRRXC
	 * (a Group object) - creates it if necessary
	 * throws HL7Exception if the repetition requested is more than one 
	 *     greater than the number of existing repetitions.
	 */
	public RDR_RDR_RXDRXRRXC getRXDRXRRXC(int rep) throws HL7Exception { 
	   return (RDR_RDR_RXDRXRRXC)this.get("RXDRXRRXC", rep);
	}

	/** 
	 * Returns the number of existing repetitions of RDR_RDR_RXDRXRRXC 
	 */ 
	public int getRXDRXRRXCReps() { 
	    int reps = -1; 
	    try { 
	        reps = this.getAll("RXDRXRRXC").length; 
	    } catch (HL7Exception e) { 
	        String message = "Unexpected error accessing data - this is probably a bug in the source code generator."; 
	        HapiLogFactory.getHapiLog(this.getClass()).error(message, e); 
	        throw new RuntimeException(message);
	    } 
	    return reps; 
	} 

}
