package ca.uhn.hl7v2.model.v231.message;

import ca.uhn.log.HapiLogFactory;
import ca.uhn.hl7v2.model.v231.group.*;

import ca.uhn.hl7v2.model.v231.segment.*;

import ca.uhn.hl7v2.HL7Exception;

import ca.uhn.hl7v2.parser.ModelClassFactory;

import ca.uhn.hl7v2.parser.DefaultModelClassFactory;

import ca.uhn.hl7v2.model.AbstractMessage;

/**
 * <p>Represents a PPR_PC1 message structure (see chapter null). This structure contains the 
 * following elements: </p>
 * 0: MSH (MSH - message header segment) <b></b><br>
 * 1: PID (PID - patient identification segment) <b></b><br>
 * 2: PPR_PC1_PV1PV2 (a Group object) <b>optional </b><br>
 * 3: PPR_PC1_PRBNTEVARROLVARPTHVAROBXNTEGOLNTEVARROLVAROBXNTEORCOBRRXONTEVAROBXNTEVAR (a Group object) <b>repeating</b><br>
 */
public class PPR_PC1 extends AbstractMessage  {

	/** 
	 * Creates a new PPR_PC1 Group with custom ModelClassFactory.
	 */
	public PPR_PC1(ModelClassFactory factory) {
	   super(factory);
	   init(factory);
	}

	/**
	 * Creates a new PPR_PC1 Group with DefaultModelClassFactory. 
	 */ 
	public PPR_PC1() { 
	   super(new DefaultModelClassFactory());
	   init(new DefaultModelClassFactory());
	}

	private void init(ModelClassFactory factory) {
	   try {
	      this.add(MSH.class, true, false);
	      this.add(PID.class, true, false);
	      this.add(PPR_PC1_PV1PV2.class, false, false);
	      this.add(PPR_PC1_PRBNTEVARROLVARPTHVAROBXNTEGOLNTEVARROLVAROBXNTEORCOBRRXONTEVAROBXNTEVAR.class, true, true);
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error creating PPR_PC1 - this is probably a bug in the source code generator.", e);
	   }
	}

	/**
	 * Returns MSH (MSH - message header segment) - creates it if necessary
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
	 * Returns PID (PID - patient identification segment) - creates it if necessary
	 */
	public PID getPID() { 
	   PID ret = null;
	   try {
	      ret = (PID)this.get("PID");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns PPR_PC1_PV1PV2 (a Group object) - creates it if necessary
	 */
	public PPR_PC1_PV1PV2 getPV1PV2() { 
	   PPR_PC1_PV1PV2 ret = null;
	   try {
	      ret = (PPR_PC1_PV1PV2)this.get("PV1PV2");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns  first repetition of PPR_PC1_PRBNTEVARROLVARPTHVAROBXNTEGOLNTEVARROLVAROBXNTEORCOBRRXONTEVAROBXNTEVAR (a Group object) - creates it if necessary
	 */
	public PPR_PC1_PRBNTEVARROLVARPTHVAROBXNTEGOLNTEVARROLVAROBXNTEORCOBRRXONTEVAROBXNTEVAR getPRBNTEVARROLVARPTHVAROBXNTEGOLNTEVARROLVAROBXNTEORCOBRRXONTEVAROBXNTEVAR() { 
	   PPR_PC1_PRBNTEVARROLVARPTHVAROBXNTEGOLNTEVARROLVAROBXNTEORCOBRRXONTEVAROBXNTEVAR ret = null;
	   try {
	      ret = (PPR_PC1_PRBNTEVARROLVARPTHVAROBXNTEGOLNTEVARROLVAROBXNTEORCOBRRXONTEVAROBXNTEVAR)this.get("PRBNTEVARROLVARPTHVAROBXNTEGOLNTEVARROLVAROBXNTEORCOBRRXONTEVAROBXNTEVAR");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns a specific repetition of PPR_PC1_PRBNTEVARROLVARPTHVAROBXNTEGOLNTEVARROLVAROBXNTEORCOBRRXONTEVAROBXNTEVAR
	 * (a Group object) - creates it if necessary
	 * throws HL7Exception if the repetition requested is more than one 
	 *     greater than the number of existing repetitions.
	 */
	public PPR_PC1_PRBNTEVARROLVARPTHVAROBXNTEGOLNTEVARROLVAROBXNTEORCOBRRXONTEVAROBXNTEVAR getPRBNTEVARROLVARPTHVAROBXNTEGOLNTEVARROLVAROBXNTEORCOBRRXONTEVAROBXNTEVAR(int rep) throws HL7Exception { 
	   return (PPR_PC1_PRBNTEVARROLVARPTHVAROBXNTEGOLNTEVARROLVAROBXNTEORCOBRRXONTEVAROBXNTEVAR)this.get("PRBNTEVARROLVARPTHVAROBXNTEGOLNTEVARROLVAROBXNTEORCOBRRXONTEVAROBXNTEVAR", rep);
	}

	/** 
	 * Returns the number of existing repetitions of PPR_PC1_PRBNTEVARROLVARPTHVAROBXNTEGOLNTEVARROLVAROBXNTEORCOBRRXONTEVAROBXNTEVAR 
	 */ 
	public int getPRBNTEVARROLVARPTHVAROBXNTEGOLNTEVARROLVAROBXNTEORCOBRRXONTEVAROBXNTEVARReps() { 
	    int reps = -1; 
	    try { 
	        reps = this.getAll("PRBNTEVARROLVARPTHVAROBXNTEGOLNTEVARROLVAROBXNTEORCOBRRXONTEVAROBXNTEVAR").length; 
	    } catch (HL7Exception e) { 
	        String message = "Unexpected error accessing data - this is probably a bug in the source code generator."; 
	        HapiLogFactory.getHapiLog(this.getClass()).error(message, e); 
	        throw new RuntimeException(message);
	    } 
	    return reps; 
	} 

}
