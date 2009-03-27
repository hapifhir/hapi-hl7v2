package ca.uhn.hl7v2.model.v231.group;

import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.log.HapiLogFactory;
import ca.uhn.hl7v2.model.v231.segment.*;

import ca.uhn.hl7v2.model.*;
/**
 * <p>Represents the ORU_R01_PIDPD1NK1NTEPV1PV2ORCOBRNTEOBXNTECTI Group.  A Group is an ordered collection of message 
 * segments that can repeat together or be optionally in/excluded together.
 * This Group contains the following elements: </p>
 * 0: ORU_R01_PIDPD1NK1NTEPV1PV2 (a Group object) <b>optional </b><br>
 * 1: ORU_R01_ORCOBRNTEOBXNTECTI (a Group object) <b>repeating</b><br>
 */
public class ORU_R01_PIDPD1NK1NTEPV1PV2ORCOBRNTEOBXNTECTI extends AbstractGroup {

	/** 
	 * Creates a new ORU_R01_PIDPD1NK1NTEPV1PV2ORCOBRNTEOBXNTECTI Group.
	 */
	public ORU_R01_PIDPD1NK1NTEPV1PV2ORCOBRNTEOBXNTECTI(Group parent, ModelClassFactory factory) {
	   super(parent, factory);
	   try {
	      this.add(ORU_R01_PIDPD1NK1NTEPV1PV2.class, false, false);
	      this.add(ORU_R01_ORCOBRNTEOBXNTECTI.class, true, true);
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error creating ORU_R01_PIDPD1NK1NTEPV1PV2ORCOBRNTEOBXNTECTI - this is probably a bug in the source code generator.", e);
	   }
	}

	/**
	 * Returns ORU_R01_PIDPD1NK1NTEPV1PV2 (a Group object) - creates it if necessary
	 */
	public ORU_R01_PIDPD1NK1NTEPV1PV2 getPIDPD1NK1NTEPV1PV2() { 
	   ORU_R01_PIDPD1NK1NTEPV1PV2 ret = null;
	   try {
	      ret = (ORU_R01_PIDPD1NK1NTEPV1PV2)this.get("PIDPD1NK1NTEPV1PV2");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns  first repetition of ORU_R01_ORCOBRNTEOBXNTECTI (a Group object) - creates it if necessary
	 */
	public ORU_R01_ORCOBRNTEOBXNTECTI getORCOBRNTEOBXNTECTI() { 
	   ORU_R01_ORCOBRNTEOBXNTECTI ret = null;
	   try {
	      ret = (ORU_R01_ORCOBRNTEOBXNTECTI)this.get("ORCOBRNTEOBXNTECTI");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns a specific repetition of ORU_R01_ORCOBRNTEOBXNTECTI
	 * (a Group object) - creates it if necessary
	 * throws HL7Exception if the repetition requested is more than one 
	 *     greater than the number of existing repetitions.
	 */
	public ORU_R01_ORCOBRNTEOBXNTECTI getORCOBRNTEOBXNTECTI(int rep) throws HL7Exception { 
	   return (ORU_R01_ORCOBRNTEOBXNTECTI)this.get("ORCOBRNTEOBXNTECTI", rep);
	}

	/** 
	 * Returns the number of existing repetitions of ORU_R01_ORCOBRNTEOBXNTECTI 
	 */ 
	public int getORCOBRNTEOBXNTECTIReps() { 
	    int reps = -1; 
	    try { 
	        reps = this.getAll("ORCOBRNTEOBXNTECTI").length; 
	    } catch (HL7Exception e) { 
	        String message = "Unexpected error accessing data - this is probably a bug in the source code generator."; 
	        HapiLogFactory.getHapiLog(this.getClass()).error(message, e); 
	        throw new RuntimeException(message);
	    } 
	    return reps; 
	} 

}
