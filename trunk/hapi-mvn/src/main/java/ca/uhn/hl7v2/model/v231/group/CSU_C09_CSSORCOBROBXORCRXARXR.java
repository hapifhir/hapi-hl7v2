package ca.uhn.hl7v2.model.v231.group;

import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.log.HapiLogFactory;
import ca.uhn.hl7v2.model.v231.segment.*;

import ca.uhn.hl7v2.model.*;
/**
 * <p>Represents the CSU_C09_CSSORCOBROBXORCRXARXR Group.  A Group is an ordered collection of message 
 * segments that can repeat together or be optionally in/excluded together.
 * This Group contains the following elements: </p>
 * 0: CSS (CSS - clinical study data schedule segment) <b>optional </b><br>
 * 1: CSU_C09_ORCOBROBX (a Group object) <b>repeating</b><br>
 * 2: CSU_C09_ORCRXARXR (a Group object) <b>repeating</b><br>
 */
public class CSU_C09_CSSORCOBROBXORCRXARXR extends AbstractGroup {

	/** 
	 * Creates a new CSU_C09_CSSORCOBROBXORCRXARXR Group.
	 */
	public CSU_C09_CSSORCOBROBXORCRXARXR(Group parent, ModelClassFactory factory) {
	   super(parent, factory);
	   try {
	      this.add(CSS.class, false, false);
	      this.add(CSU_C09_ORCOBROBX.class, true, true);
	      this.add(CSU_C09_ORCRXARXR.class, true, true);
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error creating CSU_C09_CSSORCOBROBXORCRXARXR - this is probably a bug in the source code generator.", e);
	   }
	}

	/**
	 * Returns CSS (CSS - clinical study data schedule segment) - creates it if necessary
	 */
	public CSS getCSS() { 
	   CSS ret = null;
	   try {
	      ret = (CSS)this.get("CSS");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns  first repetition of CSU_C09_ORCOBROBX (a Group object) - creates it if necessary
	 */
	public CSU_C09_ORCOBROBX getORCOBROBX() { 
	   CSU_C09_ORCOBROBX ret = null;
	   try {
	      ret = (CSU_C09_ORCOBROBX)this.get("ORCOBROBX");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns a specific repetition of CSU_C09_ORCOBROBX
	 * (a Group object) - creates it if necessary
	 * throws HL7Exception if the repetition requested is more than one 
	 *     greater than the number of existing repetitions.
	 */
	public CSU_C09_ORCOBROBX getORCOBROBX(int rep) throws HL7Exception { 
	   return (CSU_C09_ORCOBROBX)this.get("ORCOBROBX", rep);
	}

	/** 
	 * Returns the number of existing repetitions of CSU_C09_ORCOBROBX 
	 */ 
	public int getORCOBROBXReps() { 
	    int reps = -1; 
	    try { 
	        reps = this.getAll("ORCOBROBX").length; 
	    } catch (HL7Exception e) { 
	        String message = "Unexpected error accessing data - this is probably a bug in the source code generator."; 
	        HapiLogFactory.getHapiLog(this.getClass()).error(message, e); 
	        throw new RuntimeException(message);
	    } 
	    return reps; 
	} 

	/**
	 * Returns  first repetition of CSU_C09_ORCRXARXR (a Group object) - creates it if necessary
	 */
	public CSU_C09_ORCRXARXR getORCRXARXR() { 
	   CSU_C09_ORCRXARXR ret = null;
	   try {
	      ret = (CSU_C09_ORCRXARXR)this.get("ORCRXARXR");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns a specific repetition of CSU_C09_ORCRXARXR
	 * (a Group object) - creates it if necessary
	 * throws HL7Exception if the repetition requested is more than one 
	 *     greater than the number of existing repetitions.
	 */
	public CSU_C09_ORCRXARXR getORCRXARXR(int rep) throws HL7Exception { 
	   return (CSU_C09_ORCRXARXR)this.get("ORCRXARXR", rep);
	}

	/** 
	 * Returns the number of existing repetitions of CSU_C09_ORCRXARXR 
	 */ 
	public int getORCRXARXRReps() { 
	    int reps = -1; 
	    try { 
	        reps = this.getAll("ORCRXARXR").length; 
	    } catch (HL7Exception e) { 
	        String message = "Unexpected error accessing data - this is probably a bug in the source code generator."; 
	        HapiLogFactory.getHapiLog(this.getClass()).error(message, e); 
	        throw new RuntimeException(message);
	    } 
	    return reps; 
	} 

}
