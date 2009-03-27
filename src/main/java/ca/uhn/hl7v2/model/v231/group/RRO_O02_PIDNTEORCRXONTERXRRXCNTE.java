package ca.uhn.hl7v2.model.v231.group;

import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.log.HapiLogFactory;
import ca.uhn.hl7v2.model.v231.segment.*;

import ca.uhn.hl7v2.model.*;
/**
 * <p>Represents the RRO_O02_PIDNTEORCRXONTERXRRXCNTE Group.  A Group is an ordered collection of message 
 * segments that can repeat together or be optionally in/excluded together.
 * This Group contains the following elements: </p>
 * 0: RRO_O02_PIDNTE (a Group object) <b>optional </b><br>
 * 1: RRO_O02_ORCRXONTERXRRXCNTE (a Group object) <b>repeating</b><br>
 */
public class RRO_O02_PIDNTEORCRXONTERXRRXCNTE extends AbstractGroup {

	/** 
	 * Creates a new RRO_O02_PIDNTEORCRXONTERXRRXCNTE Group.
	 */
	public RRO_O02_PIDNTEORCRXONTERXRRXCNTE(Group parent, ModelClassFactory factory) {
	   super(parent, factory);
	   try {
	      this.add(RRO_O02_PIDNTE.class, false, false);
	      this.add(RRO_O02_ORCRXONTERXRRXCNTE.class, true, true);
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error creating RRO_O02_PIDNTEORCRXONTERXRRXCNTE - this is probably a bug in the source code generator.", e);
	   }
	}

	/**
	 * Returns RRO_O02_PIDNTE (a Group object) - creates it if necessary
	 */
	public RRO_O02_PIDNTE getPIDNTE() { 
	   RRO_O02_PIDNTE ret = null;
	   try {
	      ret = (RRO_O02_PIDNTE)this.get("PIDNTE");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns  first repetition of RRO_O02_ORCRXONTERXRRXCNTE (a Group object) - creates it if necessary
	 */
	public RRO_O02_ORCRXONTERXRRXCNTE getORCRXONTERXRRXCNTE() { 
	   RRO_O02_ORCRXONTERXRRXCNTE ret = null;
	   try {
	      ret = (RRO_O02_ORCRXONTERXRRXCNTE)this.get("ORCRXONTERXRRXCNTE");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns a specific repetition of RRO_O02_ORCRXONTERXRRXCNTE
	 * (a Group object) - creates it if necessary
	 * throws HL7Exception if the repetition requested is more than one 
	 *     greater than the number of existing repetitions.
	 */
	public RRO_O02_ORCRXONTERXRRXCNTE getORCRXONTERXRRXCNTE(int rep) throws HL7Exception { 
	   return (RRO_O02_ORCRXONTERXRRXCNTE)this.get("ORCRXONTERXRRXCNTE", rep);
	}

	/** 
	 * Returns the number of existing repetitions of RRO_O02_ORCRXONTERXRRXCNTE 
	 */ 
	public int getORCRXONTERXRRXCNTEReps() { 
	    int reps = -1; 
	    try { 
	        reps = this.getAll("ORCRXONTERXRRXCNTE").length; 
	    } catch (HL7Exception e) { 
	        String message = "Unexpected error accessing data - this is probably a bug in the source code generator."; 
	        HapiLogFactory.getHapiLog(this.getClass()).error(message, e); 
	        throw new RuntimeException(message);
	    } 
	    return reps; 
	} 

}
