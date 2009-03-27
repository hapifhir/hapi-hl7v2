package ca.uhn.hl7v2.model.v231.group;

import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.log.HapiLogFactory;
import ca.uhn.hl7v2.model.v231.segment.*;

import ca.uhn.hl7v2.model.*;
/**
 * <p>Represents the SUR_P09_FACPSHPDCPSHFACPDCNTE Group.  A Group is an ordered collection of message 
 * segments that can repeat together or be optionally in/excluded together.
 * This Group contains the following elements: </p>
 * 0: FAC (FAC - facility segment) <b></b><br>
 * 1: SUR_P09_PSHPDC (a Group object) <b>repeating</b><br>
 * 2: PSH (PSH - product summary header segment) <b></b><br>
 * 3: SUR_P09_FACPDCNTE (a Group object) <b>repeating</b><br>
 */
public class SUR_P09_FACPSHPDCPSHFACPDCNTE extends AbstractGroup {

	/** 
	 * Creates a new SUR_P09_FACPSHPDCPSHFACPDCNTE Group.
	 */
	public SUR_P09_FACPSHPDCPSHFACPDCNTE(Group parent, ModelClassFactory factory) {
	   super(parent, factory);
	   try {
	      this.add(FAC.class, true, false);
	      this.add(SUR_P09_PSHPDC.class, true, true);
	      this.add(PSH.class, true, false);
	      this.add(SUR_P09_FACPDCNTE.class, true, true);
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error creating SUR_P09_FACPSHPDCPSHFACPDCNTE - this is probably a bug in the source code generator.", e);
	   }
	}

	/**
	 * Returns FAC (FAC - facility segment) - creates it if necessary
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
	 * Returns  first repetition of SUR_P09_PSHPDC (a Group object) - creates it if necessary
	 */
	public SUR_P09_PSHPDC getPSHPDC() { 
	   SUR_P09_PSHPDC ret = null;
	   try {
	      ret = (SUR_P09_PSHPDC)this.get("PSHPDC");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns a specific repetition of SUR_P09_PSHPDC
	 * (a Group object) - creates it if necessary
	 * throws HL7Exception if the repetition requested is more than one 
	 *     greater than the number of existing repetitions.
	 */
	public SUR_P09_PSHPDC getPSHPDC(int rep) throws HL7Exception { 
	   return (SUR_P09_PSHPDC)this.get("PSHPDC", rep);
	}

	/** 
	 * Returns the number of existing repetitions of SUR_P09_PSHPDC 
	 */ 
	public int getPSHPDCReps() { 
	    int reps = -1; 
	    try { 
	        reps = this.getAll("PSHPDC").length; 
	    } catch (HL7Exception e) { 
	        String message = "Unexpected error accessing data - this is probably a bug in the source code generator."; 
	        HapiLogFactory.getHapiLog(this.getClass()).error(message, e); 
	        throw new RuntimeException(message);
	    } 
	    return reps; 
	} 

	/**
	 * Returns PSH (PSH - product summary header segment) - creates it if necessary
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
	 * Returns  first repetition of SUR_P09_FACPDCNTE (a Group object) - creates it if necessary
	 */
	public SUR_P09_FACPDCNTE getFACPDCNTE() { 
	   SUR_P09_FACPDCNTE ret = null;
	   try {
	      ret = (SUR_P09_FACPDCNTE)this.get("FACPDCNTE");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns a specific repetition of SUR_P09_FACPDCNTE
	 * (a Group object) - creates it if necessary
	 * throws HL7Exception if the repetition requested is more than one 
	 *     greater than the number of existing repetitions.
	 */
	public SUR_P09_FACPDCNTE getFACPDCNTE(int rep) throws HL7Exception { 
	   return (SUR_P09_FACPDCNTE)this.get("FACPDCNTE", rep);
	}

	/** 
	 * Returns the number of existing repetitions of SUR_P09_FACPDCNTE 
	 */ 
	public int getFACPDCNTEReps() { 
	    int reps = -1; 
	    try { 
	        reps = this.getAll("FACPDCNTE").length; 
	    } catch (HL7Exception e) { 
	        String message = "Unexpected error accessing data - this is probably a bug in the source code generator."; 
	        HapiLogFactory.getHapiLog(this.getClass()).error(message, e); 
	        throw new RuntimeException(message);
	    } 
	    return reps; 
	} 

}
