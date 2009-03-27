package ca.uhn.hl7v2.model.v231.group;

import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.log.HapiLogFactory;
import ca.uhn.hl7v2.model.v231.segment.*;

import ca.uhn.hl7v2.model.*;
/**
 * <p>Represents the ORS_O02_PIDNTEORCRQDNTE Group.  A Group is an ordered collection of message 
 * segments that can repeat together or be optionally in/excluded together.
 * This Group contains the following elements: </p>
 * 0: ORS_O02_PIDNTE (a Group object) <b>optional </b><br>
 * 1: ORS_O02_ORCRQDNTE (a Group object) <b>repeating</b><br>
 */
public class ORS_O02_PIDNTEORCRQDNTE extends AbstractGroup {

	/** 
	 * Creates a new ORS_O02_PIDNTEORCRQDNTE Group.
	 */
	public ORS_O02_PIDNTEORCRQDNTE(Group parent, ModelClassFactory factory) {
	   super(parent, factory);
	   try {
	      this.add(ORS_O02_PIDNTE.class, false, false);
	      this.add(ORS_O02_ORCRQDNTE.class, true, true);
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error creating ORS_O02_PIDNTEORCRQDNTE - this is probably a bug in the source code generator.", e);
	   }
	}

	/**
	 * Returns ORS_O02_PIDNTE (a Group object) - creates it if necessary
	 */
	public ORS_O02_PIDNTE getPIDNTE() { 
	   ORS_O02_PIDNTE ret = null;
	   try {
	      ret = (ORS_O02_PIDNTE)this.get("PIDNTE");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns  first repetition of ORS_O02_ORCRQDNTE (a Group object) - creates it if necessary
	 */
	public ORS_O02_ORCRQDNTE getORCRQDNTE() { 
	   ORS_O02_ORCRQDNTE ret = null;
	   try {
	      ret = (ORS_O02_ORCRQDNTE)this.get("ORCRQDNTE");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns a specific repetition of ORS_O02_ORCRQDNTE
	 * (a Group object) - creates it if necessary
	 * throws HL7Exception if the repetition requested is more than one 
	 *     greater than the number of existing repetitions.
	 */
	public ORS_O02_ORCRQDNTE getORCRQDNTE(int rep) throws HL7Exception { 
	   return (ORS_O02_ORCRQDNTE)this.get("ORCRQDNTE", rep);
	}

	/** 
	 * Returns the number of existing repetitions of ORS_O02_ORCRQDNTE 
	 */ 
	public int getORCRQDNTEReps() { 
	    int reps = -1; 
	    try { 
	        reps = this.getAll("ORCRQDNTE").length; 
	    } catch (HL7Exception e) { 
	        String message = "Unexpected error accessing data - this is probably a bug in the source code generator."; 
	        HapiLogFactory.getHapiLog(this.getClass()).error(message, e); 
	        throw new RuntimeException(message);
	    } 
	    return reps; 
	} 

}
