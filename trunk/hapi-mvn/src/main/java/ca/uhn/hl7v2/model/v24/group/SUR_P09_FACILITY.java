package ca.uhn.hl7v2.model.v24.group;

import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.log.HapiLogFactory;
import ca.uhn.hl7v2.model.v24.segment.*;

import ca.uhn.hl7v2.model.*;
/**
 * <p>Represents the SUR_P09_FACILITY Group.  A Group is an ordered collection of message 
 * segments that can repeat together or be optionally in/excluded together.
 * This Group contains the following elements: </p>
 * 0: FAC (Facility) <b></b><br>
 * 1: SUR_P09_PRODUCT (a Group object) <b>repeating</b><br>
 * 2: PSH (Product Summary Header) <b></b><br>
 * 3: SUR_P09_FACILITY_DETAIL (a Group object) <b>repeating</b><br>
 */
public class SUR_P09_FACILITY extends AbstractGroup {

	/** 
	 * Creates a new SUR_P09_FACILITY Group.
	 */
	public SUR_P09_FACILITY(Group parent, ModelClassFactory factory) {
	   super(parent, factory);
	   try {
	      this.add(FAC.class, true, false);
	      this.add(SUR_P09_PRODUCT.class, true, true);
	      this.add(PSH.class, true, false);
	      this.add(SUR_P09_FACILITY_DETAIL.class, true, true);
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error creating SUR_P09_FACILITY - this is probably a bug in the source code generator.", e);
	   }
	}

	/**
	 * Returns FAC (Facility) - creates it if necessary
	 */
	public FAC getFAC() { 
	   FAC ret = null;
	   try {
	      ret = (FAC)this.get("FAC");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns  first repetition of SUR_P09_PRODUCT (a Group object) - creates it if necessary
	 */
	public SUR_P09_PRODUCT getPRODUCT() { 
	   SUR_P09_PRODUCT ret = null;
	   try {
	      ret = (SUR_P09_PRODUCT)this.get("PRODUCT");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns a specific repetition of SUR_P09_PRODUCT
	 * (a Group object) - creates it if necessary
	 * throws HL7Exception if the repetition requested is more than one 
	 *     greater than the number of existing repetitions.
	 */
	public SUR_P09_PRODUCT getPRODUCT(int rep) throws HL7Exception { 
	   return (SUR_P09_PRODUCT)this.get("PRODUCT", rep);
	}

	/** 
	 * Returns the number of existing repetitions of SUR_P09_PRODUCT 
	 */ 
	public int getPRODUCTReps() { 
	    int reps = -1; 
	    try { 
	        reps = this.getAll("PRODUCT").length; 
	    } catch (HL7Exception e) { 
	        String message = "Unexpected error accessing data - this is probably a bug in the source code generator."; 
	        HapiLogFactory.getHapiLog(this.getClass()).error(message, e); 
	        throw new RuntimeException(message);
	    } 
	    return reps; 
	} 

	/**
	 * Returns PSH (Product Summary Header) - creates it if necessary
	 */
	public PSH getPSH() { 
	   PSH ret = null;
	   try {
	      ret = (PSH)this.get("PSH");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns  first repetition of SUR_P09_FACILITY_DETAIL (a Group object) - creates it if necessary
	 */
	public SUR_P09_FACILITY_DETAIL getFACILITY_DETAIL() { 
	   SUR_P09_FACILITY_DETAIL ret = null;
	   try {
	      ret = (SUR_P09_FACILITY_DETAIL)this.get("FACILITY_DETAIL");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns a specific repetition of SUR_P09_FACILITY_DETAIL
	 * (a Group object) - creates it if necessary
	 * throws HL7Exception if the repetition requested is more than one 
	 *     greater than the number of existing repetitions.
	 */
	public SUR_P09_FACILITY_DETAIL getFACILITY_DETAIL(int rep) throws HL7Exception { 
	   return (SUR_P09_FACILITY_DETAIL)this.get("FACILITY_DETAIL", rep);
	}

	/** 
	 * Returns the number of existing repetitions of SUR_P09_FACILITY_DETAIL 
	 */ 
	public int getFACILITY_DETAILReps() { 
	    int reps = -1; 
	    try { 
	        reps = this.getAll("FACILITY_DETAIL").length; 
	    } catch (HL7Exception e) { 
	        String message = "Unexpected error accessing data - this is probably a bug in the source code generator."; 
	        HapiLogFactory.getHapiLog(this.getClass()).error(message, e); 
	        throw new RuntimeException(message);
	    } 
	    return reps; 
	} 

}
