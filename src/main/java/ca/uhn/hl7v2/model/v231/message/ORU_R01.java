package ca.uhn.hl7v2.model.v231.message;

import ca.uhn.log.HapiLogFactory;
import ca.uhn.hl7v2.model.v231.group.*;

import ca.uhn.hl7v2.model.v231.segment.*;

import ca.uhn.hl7v2.HL7Exception;

import ca.uhn.hl7v2.parser.ModelClassFactory;

import ca.uhn.hl7v2.parser.DefaultModelClassFactory;

import ca.uhn.hl7v2.model.AbstractMessage;

/**
 * <p>Represents a ORU_R01 message structure (see chapter ?). This structure contains the 
 * following elements: </p>
 * 0: MSH (MSH - message header segment) <b></b><br>
 * 1: ORU_R01_PIDPD1NK1NTEPV1PV2ORCOBRNTEOBXNTECTI (a Group object) <b>repeating</b><br>
 * 2: DSC (DSC - Continuation pointer segment) <b>optional </b><br>
 */
public class ORU_R01 extends AbstractMessage  {

	/** 
	 * Creates a new ORU_R01 Group with custom ModelClassFactory.
	 */
	public ORU_R01(ModelClassFactory factory) {
	   super(factory);
	   init(factory);
	}

	/**
	 * Creates a new ORU_R01 Group with DefaultModelClassFactory. 
	 */ 
	public ORU_R01() { 
	   super(new DefaultModelClassFactory());
	   init(new DefaultModelClassFactory());
	}

	private void init(ModelClassFactory factory) {
	   try {
	      this.add(MSH.class, true, false);
	      this.add(ORU_R01_PIDPD1NK1NTEPV1PV2ORCOBRNTEOBXNTECTI.class, true, true);
	      this.add(DSC.class, false, false);
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error creating ORU_R01 - this is probably a bug in the source code generator.", e);
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
	 * Returns  first repetition of ORU_R01_PIDPD1NK1NTEPV1PV2ORCOBRNTEOBXNTECTI (a Group object) - creates it if necessary
	 */
	public ORU_R01_PIDPD1NK1NTEPV1PV2ORCOBRNTEOBXNTECTI getPIDPD1NK1NTEPV1PV2ORCOBRNTEOBXNTECTI() { 
	   ORU_R01_PIDPD1NK1NTEPV1PV2ORCOBRNTEOBXNTECTI ret = null;
	   try {
	      ret = (ORU_R01_PIDPD1NK1NTEPV1PV2ORCOBRNTEOBXNTECTI)this.get("PIDPD1NK1NTEPV1PV2ORCOBRNTEOBXNTECTI");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns a specific repetition of ORU_R01_PIDPD1NK1NTEPV1PV2ORCOBRNTEOBXNTECTI
	 * (a Group object) - creates it if necessary
	 * throws HL7Exception if the repetition requested is more than one 
	 *     greater than the number of existing repetitions.
	 */
	public ORU_R01_PIDPD1NK1NTEPV1PV2ORCOBRNTEOBXNTECTI getPIDPD1NK1NTEPV1PV2ORCOBRNTEOBXNTECTI(int rep) throws HL7Exception { 
	   return (ORU_R01_PIDPD1NK1NTEPV1PV2ORCOBRNTEOBXNTECTI)this.get("PIDPD1NK1NTEPV1PV2ORCOBRNTEOBXNTECTI", rep);
	}

	/** 
	 * Returns the number of existing repetitions of ORU_R01_PIDPD1NK1NTEPV1PV2ORCOBRNTEOBXNTECTI 
	 */ 
	public int getPIDPD1NK1NTEPV1PV2ORCOBRNTEOBXNTECTIReps() { 
	    int reps = -1; 
	    try { 
	        reps = this.getAll("PIDPD1NK1NTEPV1PV2ORCOBRNTEOBXNTECTI").length; 
	    } catch (HL7Exception e) { 
	        String message = "Unexpected error accessing data - this is probably a bug in the source code generator."; 
	        HapiLogFactory.getHapiLog(this.getClass()).error(message, e); 
	        throw new RuntimeException(message);
	    } 
	    return reps; 
	} 

	/**
	 * Returns DSC (DSC - Continuation pointer segment) - creates it if necessary
	 */
	public DSC getDSC() { 
	   DSC ret = null;
	   try {
	      ret = (DSC)this.get("DSC");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

}
