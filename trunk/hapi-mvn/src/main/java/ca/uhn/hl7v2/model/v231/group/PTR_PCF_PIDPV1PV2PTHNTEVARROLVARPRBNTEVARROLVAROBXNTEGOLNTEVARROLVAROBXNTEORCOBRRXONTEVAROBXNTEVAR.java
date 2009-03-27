package ca.uhn.hl7v2.model.v231.group;

import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.log.HapiLogFactory;
import ca.uhn.hl7v2.model.v231.segment.*;

import ca.uhn.hl7v2.model.*;
/**
 * <p>Represents the PTR_PCF_PIDPV1PV2PTHNTEVARROLVARPRBNTEVARROLVAROBXNTEGOLNTEVARROLVAROBXNTEORCOBRRXONTEVAROBXNTEVAR Group.  A Group is an ordered collection of message 
 * segments that can repeat together or be optionally in/excluded together.
 * This Group contains the following elements: </p>
 * 0: PID (PID - patient identification segment) <b></b><br>
 * 1: PTR_PCF_PV1PV2 (a Group object) <b>optional </b><br>
 * 2: PTR_PCF_PTHNTEVARROLVARPRBNTEVARROLVAROBXNTEGOLNTEVARROLVAROBXNTEORCOBRRXONTEVAROBXNTEVAR (a Group object) <b>repeating</b><br>
 */
public class PTR_PCF_PIDPV1PV2PTHNTEVARROLVARPRBNTEVARROLVAROBXNTEGOLNTEVARROLVAROBXNTEORCOBRRXONTEVAROBXNTEVAR extends AbstractGroup {

	/** 
	 * Creates a new PTR_PCF_PIDPV1PV2PTHNTEVARROLVARPRBNTEVARROLVAROBXNTEGOLNTEVARROLVAROBXNTEORCOBRRXONTEVAROBXNTEVAR Group.
	 */
	public PTR_PCF_PIDPV1PV2PTHNTEVARROLVARPRBNTEVARROLVAROBXNTEGOLNTEVARROLVAROBXNTEORCOBRRXONTEVAROBXNTEVAR(Group parent, ModelClassFactory factory) {
	   super(parent, factory);
	   try {
	      this.add(PID.class, true, false);
	      this.add(PTR_PCF_PV1PV2.class, false, false);
	      this.add(PTR_PCF_PTHNTEVARROLVARPRBNTEVARROLVAROBXNTEGOLNTEVARROLVAROBXNTEORCOBRRXONTEVAROBXNTEVAR.class, true, true);
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error creating PTR_PCF_PIDPV1PV2PTHNTEVARROLVARPRBNTEVARROLVAROBXNTEGOLNTEVARROLVAROBXNTEORCOBRRXONTEVAROBXNTEVAR - this is probably a bug in the source code generator.", e);
	   }
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
	 * Returns PTR_PCF_PV1PV2 (a Group object) - creates it if necessary
	 */
	public PTR_PCF_PV1PV2 getPV1PV2() { 
	   PTR_PCF_PV1PV2 ret = null;
	   try {
	      ret = (PTR_PCF_PV1PV2)this.get("PV1PV2");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns  first repetition of PTR_PCF_PTHNTEVARROLVARPRBNTEVARROLVAROBXNTEGOLNTEVARROLVAROBXNTEORCOBRRXONTEVAROBXNTEVAR (a Group object) - creates it if necessary
	 */
	public PTR_PCF_PTHNTEVARROLVARPRBNTEVARROLVAROBXNTEGOLNTEVARROLVAROBXNTEORCOBRRXONTEVAROBXNTEVAR getPTHNTEVARROLVARPRBNTEVARROLVAROBXNTEGOLNTEVARROLVAROBXNTEORCOBRRXONTEVAROBXNTEVAR() { 
	   PTR_PCF_PTHNTEVARROLVARPRBNTEVARROLVAROBXNTEGOLNTEVARROLVAROBXNTEORCOBRRXONTEVAROBXNTEVAR ret = null;
	   try {
	      ret = (PTR_PCF_PTHNTEVARROLVARPRBNTEVARROLVAROBXNTEGOLNTEVARROLVAROBXNTEORCOBRRXONTEVAROBXNTEVAR)this.get("PTHNTEVARROLVARPRBNTEVARROLVAROBXNTEGOLNTEVARROLVAROBXNTEORCOBRRXONTEVAROBXNTEVAR");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns a specific repetition of PTR_PCF_PTHNTEVARROLVARPRBNTEVARROLVAROBXNTEGOLNTEVARROLVAROBXNTEORCOBRRXONTEVAROBXNTEVAR
	 * (a Group object) - creates it if necessary
	 * throws HL7Exception if the repetition requested is more than one 
	 *     greater than the number of existing repetitions.
	 */
	public PTR_PCF_PTHNTEVARROLVARPRBNTEVARROLVAROBXNTEGOLNTEVARROLVAROBXNTEORCOBRRXONTEVAROBXNTEVAR getPTHNTEVARROLVARPRBNTEVARROLVAROBXNTEGOLNTEVARROLVAROBXNTEORCOBRRXONTEVAROBXNTEVAR(int rep) throws HL7Exception { 
	   return (PTR_PCF_PTHNTEVARROLVARPRBNTEVARROLVAROBXNTEGOLNTEVARROLVAROBXNTEORCOBRRXONTEVAROBXNTEVAR)this.get("PTHNTEVARROLVARPRBNTEVARROLVAROBXNTEGOLNTEVARROLVAROBXNTEORCOBRRXONTEVAROBXNTEVAR", rep);
	}

	/** 
	 * Returns the number of existing repetitions of PTR_PCF_PTHNTEVARROLVARPRBNTEVARROLVAROBXNTEGOLNTEVARROLVAROBXNTEORCOBRRXONTEVAROBXNTEVAR 
	 */ 
	public int getPTHNTEVARROLVARPRBNTEVARROLVAROBXNTEGOLNTEVARROLVAROBXNTEORCOBRRXONTEVAROBXNTEVARReps() { 
	    int reps = -1; 
	    try { 
	        reps = this.getAll("PTHNTEVARROLVARPRBNTEVARROLVAROBXNTEGOLNTEVARROLVAROBXNTEORCOBRRXONTEVAROBXNTEVAR").length; 
	    } catch (HL7Exception e) { 
	        String message = "Unexpected error accessing data - this is probably a bug in the source code generator."; 
	        HapiLogFactory.getHapiLog(this.getClass()).error(message, e); 
	        throw new RuntimeException(message);
	    } 
	    return reps; 
	} 

}
