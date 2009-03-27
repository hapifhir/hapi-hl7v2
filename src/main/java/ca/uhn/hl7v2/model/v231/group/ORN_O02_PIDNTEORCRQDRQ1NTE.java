package ca.uhn.hl7v2.model.v231.group;

import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.log.HapiLogFactory;
import ca.uhn.hl7v2.model.v231.segment.*;

import ca.uhn.hl7v2.model.*;
/**
 * <p>Represents the ORN_O02_PIDNTEORCRQDRQ1NTE Group.  A Group is an ordered collection of message 
 * segments that can repeat together or be optionally in/excluded together.
 * This Group contains the following elements: </p>
 * 0: ORN_O02_PIDNTE (a Group object) <b>optional </b><br>
 * 1: ORN_O02_ORCRQDRQ1NTE (a Group object) <b>repeating</b><br>
 */
public class ORN_O02_PIDNTEORCRQDRQ1NTE extends AbstractGroup {

	/** 
	 * Creates a new ORN_O02_PIDNTEORCRQDRQ1NTE Group.
	 */
	public ORN_O02_PIDNTEORCRQDRQ1NTE(Group parent, ModelClassFactory factory) {
	   super(parent, factory);
	   try {
	      this.add(ORN_O02_PIDNTE.class, false, false);
	      this.add(ORN_O02_ORCRQDRQ1NTE.class, true, true);
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error creating ORN_O02_PIDNTEORCRQDRQ1NTE - this is probably a bug in the source code generator.", e);
	   }
	}

	/**
	 * Returns ORN_O02_PIDNTE (a Group object) - creates it if necessary
	 */
	public ORN_O02_PIDNTE getPIDNTE() { 
	   ORN_O02_PIDNTE ret = null;
	   try {
	      ret = (ORN_O02_PIDNTE)this.get("PIDNTE");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns  first repetition of ORN_O02_ORCRQDRQ1NTE (a Group object) - creates it if necessary
	 */
	public ORN_O02_ORCRQDRQ1NTE getORCRQDRQ1NTE() { 
	   ORN_O02_ORCRQDRQ1NTE ret = null;
	   try {
	      ret = (ORN_O02_ORCRQDRQ1NTE)this.get("ORCRQDRQ1NTE");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns a specific repetition of ORN_O02_ORCRQDRQ1NTE
	 * (a Group object) - creates it if necessary
	 * throws HL7Exception if the repetition requested is more than one 
	 *     greater than the number of existing repetitions.
	 */
	public ORN_O02_ORCRQDRQ1NTE getORCRQDRQ1NTE(int rep) throws HL7Exception { 
	   return (ORN_O02_ORCRQDRQ1NTE)this.get("ORCRQDRQ1NTE", rep);
	}

	/** 
	 * Returns the number of existing repetitions of ORN_O02_ORCRQDRQ1NTE 
	 */ 
	public int getORCRQDRQ1NTEReps() { 
	    int reps = -1; 
	    try { 
	        reps = this.getAll("ORCRQDRQ1NTE").length; 
	    } catch (HL7Exception e) { 
	        String message = "Unexpected error accessing data - this is probably a bug in the source code generator."; 
	        HapiLogFactory.getHapiLog(this.getClass()).error(message, e); 
	        throw new RuntimeException(message);
	    } 
	    return reps; 
	} 

}
