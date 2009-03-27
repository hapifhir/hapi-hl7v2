package ca.uhn.hl7v2.model.v231.group;

import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.log.HapiLogFactory;
import ca.uhn.hl7v2.model.v231.segment.*;

import ca.uhn.hl7v2.model.*;
/**
 * <p>Represents the CSU_C09_CSPCSSORCOBROBXORCRXARXR Group.  A Group is an ordered collection of message 
 * segments that can repeat together or be optionally in/excluded together.
 * This Group contains the following elements: </p>
 * 0: CSP (CSP - clinical study phase segment) <b>optional </b><br>
 * 1: CSU_C09_CSSORCOBROBXORCRXARXR (a Group object) <b>repeating</b><br>
 */
public class CSU_C09_CSPCSSORCOBROBXORCRXARXR extends AbstractGroup {

	/** 
	 * Creates a new CSU_C09_CSPCSSORCOBROBXORCRXARXR Group.
	 */
	public CSU_C09_CSPCSSORCOBROBXORCRXARXR(Group parent, ModelClassFactory factory) {
	   super(parent, factory);
	   try {
	      this.add(CSP.class, false, false);
	      this.add(CSU_C09_CSSORCOBROBXORCRXARXR.class, true, true);
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error creating CSU_C09_CSPCSSORCOBROBXORCRXARXR - this is probably a bug in the source code generator.", e);
	   }
	}

	/**
	 * Returns CSP (CSP - clinical study phase segment) - creates it if necessary
	 */
	public CSP getCSP() { 
	   CSP ret = null;
	   try {
	      ret = (CSP)this.get("CSP");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns  first repetition of CSU_C09_CSSORCOBROBXORCRXARXR (a Group object) - creates it if necessary
	 */
	public CSU_C09_CSSORCOBROBXORCRXARXR getCSSORCOBROBXORCRXARXR() { 
	   CSU_C09_CSSORCOBROBXORCRXARXR ret = null;
	   try {
	      ret = (CSU_C09_CSSORCOBROBXORCRXARXR)this.get("CSSORCOBROBXORCRXARXR");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns a specific repetition of CSU_C09_CSSORCOBROBXORCRXARXR
	 * (a Group object) - creates it if necessary
	 * throws HL7Exception if the repetition requested is more than one 
	 *     greater than the number of existing repetitions.
	 */
	public CSU_C09_CSSORCOBROBXORCRXARXR getCSSORCOBROBXORCRXARXR(int rep) throws HL7Exception { 
	   return (CSU_C09_CSSORCOBROBXORCRXARXR)this.get("CSSORCOBROBXORCRXARXR", rep);
	}

	/** 
	 * Returns the number of existing repetitions of CSU_C09_CSSORCOBROBXORCRXARXR 
	 */ 
	public int getCSSORCOBROBXORCRXARXRReps() { 
	    int reps = -1; 
	    try { 
	        reps = this.getAll("CSSORCOBROBXORCRXARXR").length; 
	    } catch (HL7Exception e) { 
	        String message = "Unexpected error accessing data - this is probably a bug in the source code generator."; 
	        HapiLogFactory.getHapiLog(this.getClass()).error(message, e); 
	        throw new RuntimeException(message);
	    } 
	    return reps; 
	} 

}
