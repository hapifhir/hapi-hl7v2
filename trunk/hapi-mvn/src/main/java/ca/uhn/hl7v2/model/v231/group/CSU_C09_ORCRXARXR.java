package ca.uhn.hl7v2.model.v231.group;

import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.log.HapiLogFactory;
import ca.uhn.hl7v2.model.v231.segment.*;

import ca.uhn.hl7v2.model.*;
/**
 * <p>Represents the CSU_C09_ORCRXARXR Group.  A Group is an ordered collection of message 
 * segments that can repeat together or be optionally in/excluded together.
 * This Group contains the following elements: </p>
 * 0: ORC (ORC - common order segment) <b>optional </b><br>
 * 1: CSU_C09_RXARXR (a Group object) <b>repeating</b><br>
 */
public class CSU_C09_ORCRXARXR extends AbstractGroup {

	/** 
	 * Creates a new CSU_C09_ORCRXARXR Group.
	 */
	public CSU_C09_ORCRXARXR(Group parent, ModelClassFactory factory) {
	   super(parent, factory);
	   try {
	      this.add(ORC.class, false, false);
	      this.add(CSU_C09_RXARXR.class, true, true);
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error creating CSU_C09_ORCRXARXR - this is probably a bug in the source code generator.", e);
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
	 * Returns  first repetition of CSU_C09_RXARXR (a Group object) - creates it if necessary
	 */
	public CSU_C09_RXARXR getRXARXR() { 
	   CSU_C09_RXARXR ret = null;
	   try {
	      ret = (CSU_C09_RXARXR)this.get("RXARXR");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns a specific repetition of CSU_C09_RXARXR
	 * (a Group object) - creates it if necessary
	 * throws HL7Exception if the repetition requested is more than one 
	 *     greater than the number of existing repetitions.
	 */
	public CSU_C09_RXARXR getRXARXR(int rep) throws HL7Exception { 
	   return (CSU_C09_RXARXR)this.get("RXARXR", rep);
	}

	/** 
	 * Returns the number of existing repetitions of CSU_C09_RXARXR 
	 */ 
	public int getRXARXRReps() { 
	    int reps = -1; 
	    try { 
	        reps = this.getAll("RXARXR").length; 
	    } catch (HL7Exception e) { 
	        String message = "Unexpected error accessing data - this is probably a bug in the source code generator."; 
	        HapiLogFactory.getHapiLog(this.getClass()).error(message, e); 
	        throw new RuntimeException(message);
	    } 
	    return reps; 
	} 

}
