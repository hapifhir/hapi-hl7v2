package ca.uhn.hl7v2.model.v231.group;

import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.log.HapiLogFactory;
import ca.uhn.hl7v2.model.v231.segment.*;

import ca.uhn.hl7v2.model.*;
/**
 * <p>Represents the OSR_Q06_PIDNTEORCOBRRXORQDRQ1ODSODTNTECTI Group.  A Group is an ordered collection of message 
 * segments that can repeat together or be optionally in/excluded together.
 * This Group contains the following elements: </p>
 * 0: OSR_Q06_PIDNTE (a Group object) <b>optional </b><br>
 * 1: OSR_Q06_ORCOBRRXORQDRQ1ODSODTNTECTI (a Group object) <b>repeating</b><br>
 */
public class OSR_Q06_PIDNTEORCOBRRXORQDRQ1ODSODTNTECTI extends AbstractGroup {

	/** 
	 * Creates a new OSR_Q06_PIDNTEORCOBRRXORQDRQ1ODSODTNTECTI Group.
	 */
	public OSR_Q06_PIDNTEORCOBRRXORQDRQ1ODSODTNTECTI(Group parent, ModelClassFactory factory) {
	   super(parent, factory);
	   try {
	      this.add(OSR_Q06_PIDNTE.class, false, false);
	      this.add(OSR_Q06_ORCOBRRXORQDRQ1ODSODTNTECTI.class, true, true);
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error creating OSR_Q06_PIDNTEORCOBRRXORQDRQ1ODSODTNTECTI - this is probably a bug in the source code generator.", e);
	   }
	}

	/**
	 * Returns OSR_Q06_PIDNTE (a Group object) - creates it if necessary
	 */
	public OSR_Q06_PIDNTE getPIDNTE() { 
	   OSR_Q06_PIDNTE ret = null;
	   try {
	      ret = (OSR_Q06_PIDNTE)this.get("PIDNTE");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns  first repetition of OSR_Q06_ORCOBRRXORQDRQ1ODSODTNTECTI (a Group object) - creates it if necessary
	 */
	public OSR_Q06_ORCOBRRXORQDRQ1ODSODTNTECTI getORCOBRRXORQDRQ1ODSODTNTECTI() { 
	   OSR_Q06_ORCOBRRXORQDRQ1ODSODTNTECTI ret = null;
	   try {
	      ret = (OSR_Q06_ORCOBRRXORQDRQ1ODSODTNTECTI)this.get("ORCOBRRXORQDRQ1ODSODTNTECTI");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns a specific repetition of OSR_Q06_ORCOBRRXORQDRQ1ODSODTNTECTI
	 * (a Group object) - creates it if necessary
	 * throws HL7Exception if the repetition requested is more than one 
	 *     greater than the number of existing repetitions.
	 */
	public OSR_Q06_ORCOBRRXORQDRQ1ODSODTNTECTI getORCOBRRXORQDRQ1ODSODTNTECTI(int rep) throws HL7Exception { 
	   return (OSR_Q06_ORCOBRRXORQDRQ1ODSODTNTECTI)this.get("ORCOBRRXORQDRQ1ODSODTNTECTI", rep);
	}

	/** 
	 * Returns the number of existing repetitions of OSR_Q06_ORCOBRRXORQDRQ1ODSODTNTECTI 
	 */ 
	public int getORCOBRRXORQDRQ1ODSODTNTECTIReps() { 
	    int reps = -1; 
	    try { 
	        reps = this.getAll("ORCOBRRXORQDRQ1ODSODTNTECTI").length; 
	    } catch (HL7Exception e) { 
	        String message = "Unexpected error accessing data - this is probably a bug in the source code generator."; 
	        HapiLogFactory.getHapiLog(this.getClass()).error(message, e); 
	        throw new RuntimeException(message);
	    } 
	    return reps; 
	} 

}
