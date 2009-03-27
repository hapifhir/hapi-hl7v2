package ca.uhn.hl7v2.model.v24.message;

import ca.uhn.log.HapiLogFactory;
import ca.uhn.hl7v2.model.v24.group.*;

import ca.uhn.hl7v2.model.v24.segment.*;

import ca.uhn.hl7v2.HL7Exception;

import ca.uhn.hl7v2.parser.ModelClassFactory;

import ca.uhn.hl7v2.parser.DefaultModelClassFactory;

import ca.uhn.hl7v2.model.AbstractMessage;

/**
 * <p>Represents a LSU_U12 message structure (see chapter 13). This structure contains the 
 * following elements: </p>
 * 0: MSH (Message Header) <b></b><br>
 * 1: EQU (Equipment Detail) <b></b><br>
 * 2: EQP (Equipment/log Service) <b>repeating</b><br>
 * 3: ROL (Role) <b>optional </b><br>
 */
public class LSU_U12 extends AbstractMessage  {

	/** 
	 * Creates a new LSU_U12 Group with custom ModelClassFactory.
	 */
	public LSU_U12(ModelClassFactory factory) {
	   super(factory);
	   init(factory);
	}

	/**
	 * Creates a new LSU_U12 Group with DefaultModelClassFactory. 
	 */ 
	public LSU_U12() { 
	   super(new DefaultModelClassFactory());
	   init(new DefaultModelClassFactory());
	}

	private void init(ModelClassFactory factory) {
	   try {
	      this.add(MSH.class, true, false);
	      this.add(EQU.class, true, false);
	      this.add(EQP.class, true, true);
	      this.add(ROL.class, false, false);
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error creating LSU_U12 - this is probably a bug in the source code generator.", e);
	   }
	}

	/**
	 * Returns MSH (Message Header) - creates it if necessary
	 */
	public MSH getMSH() { 
	   MSH ret = null;
	   try {
	      ret = (MSH)this.get("MSH");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns EQU (Equipment Detail) - creates it if necessary
	 */
	public EQU getEQU() { 
	   EQU ret = null;
	   try {
	      ret = (EQU)this.get("EQU");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns  first repetition of EQP (Equipment/log Service) - creates it if necessary
	 */
	public EQP getEQP() { 
	   EQP ret = null;
	   try {
	      ret = (EQP)this.get("EQP");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns a specific repetition of EQP
	 * (Equipment/log Service) - creates it if necessary
	 * throws HL7Exception if the repetition requested is more than one 
	 *     greater than the number of existing repetitions.
	 */
	public EQP getEQP(int rep) throws HL7Exception { 
	   return (EQP)this.get("EQP", rep);
	}

	/** 
	 * Returns the number of existing repetitions of EQP 
	 */ 
	public int getEQPReps() { 
	    int reps = -1; 
	    try { 
	        reps = this.getAll("EQP").length; 
	    } catch (HL7Exception e) { 
	        String message = "Unexpected error accessing data - this is probably a bug in the source code generator."; 
	        HapiLogFactory.getHapiLog(this.getClass()).error(message, e); 
	        throw new RuntimeException(message);
	    } 
	    return reps; 
	} 

	/**
	 * Returns ROL (Role) - creates it if necessary
	 */
	public ROL getROL() { 
	   ROL ret = null;
	   try {
	      ret = (ROL)this.get("ROL");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

}
