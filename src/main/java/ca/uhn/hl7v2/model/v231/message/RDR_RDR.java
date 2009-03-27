package ca.uhn.hl7v2.model.v231.message;

import ca.uhn.log.HapiLogFactory;
import ca.uhn.hl7v2.model.v231.group.*;

import ca.uhn.hl7v2.model.v231.segment.*;

import ca.uhn.hl7v2.HL7Exception;

import ca.uhn.hl7v2.parser.ModelClassFactory;

import ca.uhn.hl7v2.parser.DefaultModelClassFactory;

import ca.uhn.hl7v2.model.AbstractMessage;

/**
 * <p>Represents a RDR_RDR message structure (see chapter ?). This structure contains the 
 * following elements: </p>
 * 0: MSH (MSH - message header segment) <b></b><br>
 * 1: MSA (MSA - message acknowledgment segment) <b></b><br>
 * 2: ERR (ERR - error segment) <b>optional </b><br>
 * 3: RDR_RDR_QRDQRFPIDNTEORCRXERXRRXCRXDRXRRXC (a Group object) <b>repeating</b><br>
 * 4: DSC (DSC - Continuation pointer segment) <b>optional </b><br>
 */
public class RDR_RDR extends AbstractMessage  {

	/** 
	 * Creates a new RDR_RDR Group with custom ModelClassFactory.
	 */
	public RDR_RDR(ModelClassFactory factory) {
	   super(factory);
	   init(factory);
	}

	/**
	 * Creates a new RDR_RDR Group with DefaultModelClassFactory. 
	 */ 
	public RDR_RDR() { 
	   super(new DefaultModelClassFactory());
	   init(new DefaultModelClassFactory());
	}

	private void init(ModelClassFactory factory) {
	   try {
	      this.add(MSH.class, true, false);
	      this.add(MSA.class, true, false);
	      this.add(ERR.class, false, false);
	      this.add(RDR_RDR_QRDQRFPIDNTEORCRXERXRRXCRXDRXRRXC.class, true, true);
	      this.add(DSC.class, false, false);
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error creating RDR_RDR - this is probably a bug in the source code generator.", e);
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
	 * Returns  first repetition of RDR_RDR_QRDQRFPIDNTEORCRXERXRRXCRXDRXRRXC (a Group object) - creates it if necessary
	 */
	public RDR_RDR_QRDQRFPIDNTEORCRXERXRRXCRXDRXRRXC getQRDQRFPIDNTEORCRXERXRRXCRXDRXRRXC() { 
	   RDR_RDR_QRDQRFPIDNTEORCRXERXRRXCRXDRXRRXC ret = null;
	   try {
	      ret = (RDR_RDR_QRDQRFPIDNTEORCRXERXRRXCRXDRXRRXC)this.get("QRDQRFPIDNTEORCRXERXRRXCRXDRXRRXC");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns a specific repetition of RDR_RDR_QRDQRFPIDNTEORCRXERXRRXCRXDRXRRXC
	 * (a Group object) - creates it if necessary
	 * throws HL7Exception if the repetition requested is more than one 
	 *     greater than the number of existing repetitions.
	 */
	public RDR_RDR_QRDQRFPIDNTEORCRXERXRRXCRXDRXRRXC getQRDQRFPIDNTEORCRXERXRRXCRXDRXRRXC(int rep) throws HL7Exception { 
	   return (RDR_RDR_QRDQRFPIDNTEORCRXERXRRXCRXDRXRRXC)this.get("QRDQRFPIDNTEORCRXERXRRXCRXDRXRRXC", rep);
	}

	/** 
	 * Returns the number of existing repetitions of RDR_RDR_QRDQRFPIDNTEORCRXERXRRXCRXDRXRRXC 
	 */ 
	public int getQRDQRFPIDNTEORCRXERXRRXCRXDRXRRXCReps() { 
	    int reps = -1; 
	    try { 
	        reps = this.getAll("QRDQRFPIDNTEORCRXERXRRXCRXDRXRRXC").length; 
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
