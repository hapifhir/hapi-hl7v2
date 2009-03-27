package ca.uhn.hl7v2.model.v24.group;

import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.log.HapiLogFactory;
import ca.uhn.hl7v2.model.v24.segment.*;

import ca.uhn.hl7v2.model.*;
/**
 * <p>Represents the MFN_M04_MF_CDM Group.  A Group is an ordered collection of message 
 * segments that can repeat together or be optionally in/excluded together.
 * This Group contains the following elements: </p>
 * 0: MFE (Master File Entry) <b></b><br>
 * 1: CDM (Charge Description Master) <b></b><br>
 * 2: PRC (Pricing) <b>optional repeating</b><br>
 */
public class MFN_M04_MF_CDM extends AbstractGroup {

	/** 
	 * Creates a new MFN_M04_MF_CDM Group.
	 */
	public MFN_M04_MF_CDM(Group parent, ModelClassFactory factory) {
	   super(parent, factory);
	   try {
	      this.add(MFE.class, true, false);
	      this.add(CDM.class, true, false);
	      this.add(PRC.class, false, true);
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error creating MFN_M04_MF_CDM - this is probably a bug in the source code generator.", e);
	   }
	}

	/**
	 * Returns MFE (Master File Entry) - creates it if necessary
	 */
	public MFE getMFE() { 
	   MFE ret = null;
	   try {
	      ret = (MFE)this.get("MFE");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns CDM (Charge Description Master) - creates it if necessary
	 */
	public CDM getCDM() { 
	   CDM ret = null;
	   try {
	      ret = (CDM)this.get("CDM");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns  first repetition of PRC (Pricing) - creates it if necessary
	 */
	public PRC getPRC() { 
	   PRC ret = null;
	   try {
	      ret = (PRC)this.get("PRC");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns a specific repetition of PRC
	 * (Pricing) - creates it if necessary
	 * throws HL7Exception if the repetition requested is more than one 
	 *     greater than the number of existing repetitions.
	 */
	public PRC getPRC(int rep) throws HL7Exception { 
	   return (PRC)this.get("PRC", rep);
	}

	/** 
	 * Returns the number of existing repetitions of PRC 
	 */ 
	public int getPRCReps() { 
	    int reps = -1; 
	    try { 
	        reps = this.getAll("PRC").length; 
	    } catch (HL7Exception e) { 
	        String message = "Unexpected error accessing data - this is probably a bug in the source code generator."; 
	        HapiLogFactory.getHapiLog(this.getClass()).error(message, e); 
	        throw new RuntimeException(message);
	    } 
	    return reps; 
	} 

}
