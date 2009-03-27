package ca.uhn.hl7v2.model.v23.group;

import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.log.HapiLogFactory;
import ca.uhn.hl7v2.model.v23.segment.*;

import ca.uhn.hl7v2.model.*;
/**
 * <p>Represents the DFT_P03_FINANCIAL Group.  A Group is an ordered collection of message 
 * segments that can repeat together or be optionally in/excluded together.
 * This Group contains the following elements: </p>
 * 0: FT1 (Financial transaction) <b></b><br>
 * 1: DFT_P03_FINANCIAL_PROCEDURE (a Group object) <b>optional repeating</b><br>
 */
public class DFT_P03_FINANCIAL extends AbstractGroup {

	/** 
	 * Creates a new DFT_P03_FINANCIAL Group.
	 */
	public DFT_P03_FINANCIAL(Group parent, ModelClassFactory factory) {
	   super(parent, factory);
	   try {
	      this.add(FT1.class, true, false);
	      this.add(DFT_P03_FINANCIAL_PROCEDURE.class, false, true);
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error creating DFT_P03_FINANCIAL - this is probably a bug in the source code generator.", e);
	   }
	}

	/**
	 * Returns FT1 (Financial transaction) - creates it if necessary
	 */
	public FT1 getFT1() { 
	   FT1 ret = null;
	   try {
	      ret = (FT1)this.get("FT1");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns  first repetition of DFT_P03_FINANCIAL_PROCEDURE (a Group object) - creates it if necessary
	 */
	public DFT_P03_FINANCIAL_PROCEDURE getFINANCIAL_PROCEDURE() { 
	   DFT_P03_FINANCIAL_PROCEDURE ret = null;
	   try {
	      ret = (DFT_P03_FINANCIAL_PROCEDURE)this.get("FINANCIAL_PROCEDURE");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns a specific repetition of DFT_P03_FINANCIAL_PROCEDURE
	 * (a Group object) - creates it if necessary
	 * throws HL7Exception if the repetition requested is more than one 
	 *     greater than the number of existing repetitions.
	 */
	public DFT_P03_FINANCIAL_PROCEDURE getFINANCIAL_PROCEDURE(int rep) throws HL7Exception { 
	   return (DFT_P03_FINANCIAL_PROCEDURE)this.get("FINANCIAL_PROCEDURE", rep);
	}

	/** 
	 * Returns the number of existing repetitions of DFT_P03_FINANCIAL_PROCEDURE 
	 */ 
	public int getFINANCIAL_PROCEDUREReps() { 
	    int reps = -1; 
	    try { 
	        reps = this.getAll("FINANCIAL_PROCEDURE").length; 
	    } catch (HL7Exception e) { 
	        String message = "Unexpected error accessing data - this is probably a bug in the source code generator."; 
	        HapiLogFactory.getHapiLog(this.getClass()).error(message, e); 
	        throw new RuntimeException(message);
	    } 
	    return reps; 
	} 

}
