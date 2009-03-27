package ca.uhn.hl7v2.model.v231.group;

import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.log.HapiLogFactory;
import ca.uhn.hl7v2.model.v231.segment.*;

import ca.uhn.hl7v2.model.*;
/**
 * <p>Represents the PPT_PCL_PIDPV1PV2PTHNTEVARROLVARGOLNTEVARROLVAROBXNTEPRBNTEVARROLVAROBXNTEORCOBRRXONTEVAROBXNTEVAR Group.  A Group is an ordered collection of message 
 * segments that can repeat together or be optionally in/excluded together.
 * This Group contains the following elements: </p>
 * 0: PID (PID - patient identification segment) <b></b><br>
 * 1: PPT_PCL_PV1PV2 (a Group object) <b>optional </b><br>
 * 2: PPT_PCL_PTHNTEVARROLVARGOLNTEVARROLVAROBXNTEPRBNTEVARROLVAROBXNTEORCOBRRXONTEVAROBXNTEVAR (a Group object) <b>repeating</b><br>
 */
public class PPT_PCL_PIDPV1PV2PTHNTEVARROLVARGOLNTEVARROLVAROBXNTEPRBNTEVARROLVAROBXNTEORCOBRRXONTEVAROBXNTEVAR extends AbstractGroup {

	/** 
	 * Creates a new PPT_PCL_PIDPV1PV2PTHNTEVARROLVARGOLNTEVARROLVAROBXNTEPRBNTEVARROLVAROBXNTEORCOBRRXONTEVAROBXNTEVAR Group.
	 */
	public PPT_PCL_PIDPV1PV2PTHNTEVARROLVARGOLNTEVARROLVAROBXNTEPRBNTEVARROLVAROBXNTEORCOBRRXONTEVAROBXNTEVAR(Group parent, ModelClassFactory factory) {
	   super(parent, factory);
	   try {
	      this.add(PID.class, true, false);
	      this.add(PPT_PCL_PV1PV2.class, false, false);
	      this.add(PPT_PCL_PTHNTEVARROLVARGOLNTEVARROLVAROBXNTEPRBNTEVARROLVAROBXNTEORCOBRRXONTEVAROBXNTEVAR.class, true, true);
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error creating PPT_PCL_PIDPV1PV2PTHNTEVARROLVARGOLNTEVARROLVAROBXNTEPRBNTEVARROLVAROBXNTEORCOBRRXONTEVAROBXNTEVAR - this is probably a bug in the source code generator.", e);
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
	 * Returns PPT_PCL_PV1PV2 (a Group object) - creates it if necessary
	 */
	public PPT_PCL_PV1PV2 getPV1PV2() { 
	   PPT_PCL_PV1PV2 ret = null;
	   try {
	      ret = (PPT_PCL_PV1PV2)this.get("PV1PV2");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns  first repetition of PPT_PCL_PTHNTEVARROLVARGOLNTEVARROLVAROBXNTEPRBNTEVARROLVAROBXNTEORCOBRRXONTEVAROBXNTEVAR (a Group object) - creates it if necessary
	 */
	public PPT_PCL_PTHNTEVARROLVARGOLNTEVARROLVAROBXNTEPRBNTEVARROLVAROBXNTEORCOBRRXONTEVAROBXNTEVAR getPTHNTEVARROLVARGOLNTEVARROLVAROBXNTEPRBNTEVARROLVAROBXNTEORCOBRRXONTEVAROBXNTEVAR() { 
	   PPT_PCL_PTHNTEVARROLVARGOLNTEVARROLVAROBXNTEPRBNTEVARROLVAROBXNTEORCOBRRXONTEVAROBXNTEVAR ret = null;
	   try {
	      ret = (PPT_PCL_PTHNTEVARROLVARGOLNTEVARROLVAROBXNTEPRBNTEVARROLVAROBXNTEORCOBRRXONTEVAROBXNTEVAR)this.get("PTHNTEVARROLVARGOLNTEVARROLVAROBXNTEPRBNTEVARROLVAROBXNTEORCOBRRXONTEVAROBXNTEVAR");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns a specific repetition of PPT_PCL_PTHNTEVARROLVARGOLNTEVARROLVAROBXNTEPRBNTEVARROLVAROBXNTEORCOBRRXONTEVAROBXNTEVAR
	 * (a Group object) - creates it if necessary
	 * throws HL7Exception if the repetition requested is more than one 
	 *     greater than the number of existing repetitions.
	 */
	public PPT_PCL_PTHNTEVARROLVARGOLNTEVARROLVAROBXNTEPRBNTEVARROLVAROBXNTEORCOBRRXONTEVAROBXNTEVAR getPTHNTEVARROLVARGOLNTEVARROLVAROBXNTEPRBNTEVARROLVAROBXNTEORCOBRRXONTEVAROBXNTEVAR(int rep) throws HL7Exception { 
	   return (PPT_PCL_PTHNTEVARROLVARGOLNTEVARROLVAROBXNTEPRBNTEVARROLVAROBXNTEORCOBRRXONTEVAROBXNTEVAR)this.get("PTHNTEVARROLVARGOLNTEVARROLVAROBXNTEPRBNTEVARROLVAROBXNTEORCOBRRXONTEVAROBXNTEVAR", rep);
	}

	/** 
	 * Returns the number of existing repetitions of PPT_PCL_PTHNTEVARROLVARGOLNTEVARROLVAROBXNTEPRBNTEVARROLVAROBXNTEORCOBRRXONTEVAROBXNTEVAR 
	 */ 
	public int getPTHNTEVARROLVARGOLNTEVARROLVAROBXNTEPRBNTEVARROLVAROBXNTEORCOBRRXONTEVAROBXNTEVARReps() { 
	    int reps = -1; 
	    try { 
	        reps = this.getAll("PTHNTEVARROLVARGOLNTEVARROLVAROBXNTEPRBNTEVARROLVAROBXNTEORCOBRRXONTEVAROBXNTEVAR").length; 
	    } catch (HL7Exception e) { 
	        String message = "Unexpected error accessing data - this is probably a bug in the source code generator."; 
	        HapiLogFactory.getHapiLog(this.getClass()).error(message, e); 
	        throw new RuntimeException(message);
	    } 
	    return reps; 
	} 

}
