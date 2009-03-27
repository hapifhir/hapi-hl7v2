package ca.uhn.hl7v2.model.v25.group;

import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.log.HapiLogFactory;
import ca.uhn.hl7v2.model.v25.segment.*;

import ca.uhn.hl7v2.model.*;
/**
 * <p>Represents the TCU_U10_TEST_CONFIGURATION Group.  A Group is an ordered collection of message 
 * segments that can repeat together or be optionally in/excluded together.
 * This Group contains the following elements: </p>
 * 0: SPM (Specimen) <b>optional </b><br>
 * 1: TCC (Test Code Configuration) <b>repeating</b><br>
 */
public class TCU_U10_TEST_CONFIGURATION extends AbstractGroup {

	/** 
	 * Creates a new TCU_U10_TEST_CONFIGURATION Group.
	 */
	public TCU_U10_TEST_CONFIGURATION(Group parent, ModelClassFactory factory) {
	   super(parent, factory);
	   try {
	      this.add(SPM.class, false, false);
	      this.add(TCC.class, true, true);
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error creating TCU_U10_TEST_CONFIGURATION - this is probably a bug in the source code generator.", e);
	   }
	}

	/**
	 * Returns SPM (Specimen) - creates it if necessary
	 */
	public SPM getSPM() { 
	   SPM ret = null;
	   try {
	      ret = (SPM)this.get("SPM");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns  first repetition of TCC (Test Code Configuration) - creates it if necessary
	 */
	public TCC getTCC() { 
	   TCC ret = null;
	   try {
	      ret = (TCC)this.get("TCC");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns a specific repetition of TCC
	 * (Test Code Configuration) - creates it if necessary
	 * throws HL7Exception if the repetition requested is more than one 
	 *     greater than the number of existing repetitions.
	 */
	public TCC getTCC(int rep) throws HL7Exception { 
	   return (TCC)this.get("TCC", rep);
	}

	/** 
	 * Returns the number of existing repetitions of TCC 
	 */ 
	public int getTCCReps() { 
	    int reps = -1; 
	    try { 
	        reps = this.getAll("TCC").length; 
	    } catch (HL7Exception e) { 
	        String message = "Unexpected error accessing data - this is probably a bug in the source code generator."; 
	        HapiLogFactory.getHapiLog(this.getClass()).error(message, e); 
	        throw new RuntimeException(message);
	    } 
	    return reps; 
	} 

}
