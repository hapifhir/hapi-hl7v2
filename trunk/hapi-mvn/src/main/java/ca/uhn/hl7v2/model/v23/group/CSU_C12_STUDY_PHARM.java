package ca.uhn.hl7v2.model.v23.group;

import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.log.HapiLogFactory;
import ca.uhn.hl7v2.model.v23.segment.*;

import ca.uhn.hl7v2.model.*;
/**
 * <p>Represents the CSU_C12_STUDY_PHARM Group.  A Group is an ordered collection of message 
 * segments that can repeat together or be optionally in/excluded together.
 * This Group contains the following elements: </p>
 * 0: ORC (Common order segment) <b>optional </b><br>
 * 1: CSU_C12_RX_ADMIN (a Group object) <b>repeating</b><br>
 */
public class CSU_C12_STUDY_PHARM extends AbstractGroup {

	/** 
	 * Creates a new CSU_C12_STUDY_PHARM Group.
	 */
	public CSU_C12_STUDY_PHARM(Group parent, ModelClassFactory factory) {
	   super(parent, factory);
	   try {
	      this.add(ORC.class, false, false);
	      this.add(CSU_C12_RX_ADMIN.class, true, true);
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error creating CSU_C12_STUDY_PHARM - this is probably a bug in the source code generator.", e);
	   }
	}

	/**
	 * Returns ORC (Common order segment) - creates it if necessary
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
	 * Returns  first repetition of CSU_C12_RX_ADMIN (a Group object) - creates it if necessary
	 */
	public CSU_C12_RX_ADMIN getRX_ADMIN() { 
	   CSU_C12_RX_ADMIN ret = null;
	   try {
	      ret = (CSU_C12_RX_ADMIN)this.get("RX_ADMIN");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns a specific repetition of CSU_C12_RX_ADMIN
	 * (a Group object) - creates it if necessary
	 * throws HL7Exception if the repetition requested is more than one 
	 *     greater than the number of existing repetitions.
	 */
	public CSU_C12_RX_ADMIN getRX_ADMIN(int rep) throws HL7Exception { 
	   return (CSU_C12_RX_ADMIN)this.get("RX_ADMIN", rep);
	}

	/** 
	 * Returns the number of existing repetitions of CSU_C12_RX_ADMIN 
	 */ 
	public int getRX_ADMINReps() { 
	    int reps = -1; 
	    try { 
	        reps = this.getAll("RX_ADMIN").length; 
	    } catch (HL7Exception e) { 
	        String message = "Unexpected error accessing data - this is probably a bug in the source code generator."; 
	        HapiLogFactory.getHapiLog(this.getClass()).error(message, e); 
	        throw new RuntimeException(message);
	    } 
	    return reps; 
	} 

}
