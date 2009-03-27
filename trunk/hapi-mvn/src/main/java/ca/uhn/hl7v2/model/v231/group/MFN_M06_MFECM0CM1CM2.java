package ca.uhn.hl7v2.model.v231.group;

import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.log.HapiLogFactory;
import ca.uhn.hl7v2.model.v231.segment.*;

import ca.uhn.hl7v2.model.*;
/**
 * <p>Represents the MFN_M06_MFECM0CM1CM2 Group.  A Group is an ordered collection of message 
 * segments that can repeat together or be optionally in/excluded together.
 * This Group contains the following elements: </p>
 * 0: MFE (MFE - master file entry segment) <b></b><br>
 * 1: CM0 (CM0 - clinical study master segment) <b></b><br>
 * 2: MFN_M06_CM1CM2 (a Group object) <b>optional repeating</b><br>
 */
public class MFN_M06_MFECM0CM1CM2 extends AbstractGroup {

	/** 
	 * Creates a new MFN_M06_MFECM0CM1CM2 Group.
	 */
	public MFN_M06_MFECM0CM1CM2(Group parent, ModelClassFactory factory) {
	   super(parent, factory);
	   try {
	      this.add(MFE.class, true, false);
	      this.add(CM0.class, true, false);
	      this.add(MFN_M06_CM1CM2.class, false, true);
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error creating MFN_M06_MFECM0CM1CM2 - this is probably a bug in the source code generator.", e);
	   }
	}

	/**
	 * Returns MFE (MFE - master file entry segment) - creates it if necessary
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
	 * Returns CM0 (CM0 - clinical study master segment) - creates it if necessary
	 */
	public CM0 getCM0() { 
	   CM0 ret = null;
	   try {
	      ret = (CM0)this.get("CM0");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns  first repetition of MFN_M06_CM1CM2 (a Group object) - creates it if necessary
	 */
	public MFN_M06_CM1CM2 getCM1CM2() { 
	   MFN_M06_CM1CM2 ret = null;
	   try {
	      ret = (MFN_M06_CM1CM2)this.get("CM1CM2");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns a specific repetition of MFN_M06_CM1CM2
	 * (a Group object) - creates it if necessary
	 * throws HL7Exception if the repetition requested is more than one 
	 *     greater than the number of existing repetitions.
	 */
	public MFN_M06_CM1CM2 getCM1CM2(int rep) throws HL7Exception { 
	   return (MFN_M06_CM1CM2)this.get("CM1CM2", rep);
	}

	/** 
	 * Returns the number of existing repetitions of MFN_M06_CM1CM2 
	 */ 
	public int getCM1CM2Reps() { 
	    int reps = -1; 
	    try { 
	        reps = this.getAll("CM1CM2").length; 
	    } catch (HL7Exception e) { 
	        String message = "Unexpected error accessing data - this is probably a bug in the source code generator."; 
	        HapiLogFactory.getHapiLog(this.getClass()).error(message, e); 
	        throw new RuntimeException(message);
	    } 
	    return reps; 
	} 

}
