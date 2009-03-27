package ca.uhn.hl7v2.model.v231.message;

import ca.uhn.log.HapiLogFactory;
import ca.uhn.hl7v2.model.v231.group.*;

import ca.uhn.hl7v2.model.v231.segment.*;

import ca.uhn.hl7v2.HL7Exception;

import ca.uhn.hl7v2.parser.ModelClassFactory;

import ca.uhn.hl7v2.parser.DefaultModelClassFactory;

import ca.uhn.hl7v2.model.AbstractMessage;

/**
 * <p>Represents a RGR_RGR message structure (see chapter ?). This structure contains the 
 * following elements: </p>
 * 0: MSH (MSH - message header segment) <b></b><br>
 * 1: MSA (MSA - message acknowledgment segment) <b></b><br>
 * 2: ERR (ERR - error segment) <b>optional </b><br>
 * 3: RGR_RGR_QRDQRFPIDNTEORCRXERXRRXCRXGRXRRXC (a Group object) <b>repeating</b><br>
 * 4: DSC (DSC - Continuation pointer segment) <b>optional </b><br>
 */
public class RGR_RGR extends AbstractMessage  {

	/** 
	 * Creates a new RGR_RGR Group with custom ModelClassFactory.
	 */
	public RGR_RGR(ModelClassFactory factory) {
	   super(factory);
	   init(factory);
	}

	/**
	 * Creates a new RGR_RGR Group with DefaultModelClassFactory. 
	 */ 
	public RGR_RGR() { 
	   super(new DefaultModelClassFactory());
	   init(new DefaultModelClassFactory());
	}

	private void init(ModelClassFactory factory) {
	   try {
	      this.add(MSH.class, true, false);
	      this.add(MSA.class, true, false);
	      this.add(ERR.class, false, false);
	      this.add(RGR_RGR_QRDQRFPIDNTEORCRXERXRRXCRXGRXRRXC.class, true, true);
	      this.add(DSC.class, false, false);
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error creating RGR_RGR - this is probably a bug in the source code generator.", e);
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
	 * Returns MSA (MSA - message acknowledgment segment) - creates it if necessary
	 */
	public MSA getMSA() { 
	   MSA ret = null;
	   try {
	      ret = (MSA)this.get("MSA");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns ERR (ERR - error segment) - creates it if necessary
	 */
	public ERR getERR() { 
	   ERR ret = null;
	   try {
	      ret = (ERR)this.get("ERR");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns  first repetition of RGR_RGR_QRDQRFPIDNTEORCRXERXRRXCRXGRXRRXC (a Group object) - creates it if necessary
	 */
	public RGR_RGR_QRDQRFPIDNTEORCRXERXRRXCRXGRXRRXC getQRDQRFPIDNTEORCRXERXRRXCRXGRXRRXC() { 
	   RGR_RGR_QRDQRFPIDNTEORCRXERXRRXCRXGRXRRXC ret = null;
	   try {
	      ret = (RGR_RGR_QRDQRFPIDNTEORCRXERXRRXCRXGRXRRXC)this.get("QRDQRFPIDNTEORCRXERXRRXCRXGRXRRXC");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns a specific repetition of RGR_RGR_QRDQRFPIDNTEORCRXERXRRXCRXGRXRRXC
	 * (a Group object) - creates it if necessary
	 * throws HL7Exception if the repetition requested is more than one 
	 *     greater than the number of existing repetitions.
	 */
	public RGR_RGR_QRDQRFPIDNTEORCRXERXRRXCRXGRXRRXC getQRDQRFPIDNTEORCRXERXRRXCRXGRXRRXC(int rep) throws HL7Exception { 
	   return (RGR_RGR_QRDQRFPIDNTEORCRXERXRRXCRXGRXRRXC)this.get("QRDQRFPIDNTEORCRXERXRRXCRXGRXRRXC", rep);
	}

	/** 
	 * Returns the number of existing repetitions of RGR_RGR_QRDQRFPIDNTEORCRXERXRRXCRXGRXRRXC 
	 */ 
	public int getQRDQRFPIDNTEORCRXERXRRXCRXGRXRRXCReps() { 
	    int reps = -1; 
	    try { 
	        reps = this.getAll("QRDQRFPIDNTEORCRXERXRRXCRXGRXRRXC").length; 
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
