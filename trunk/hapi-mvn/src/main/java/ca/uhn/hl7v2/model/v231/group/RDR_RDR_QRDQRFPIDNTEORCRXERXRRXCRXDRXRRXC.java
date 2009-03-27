package ca.uhn.hl7v2.model.v231.group;

import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.log.HapiLogFactory;
import ca.uhn.hl7v2.model.v231.segment.*;

import ca.uhn.hl7v2.model.*;
/**
 * <p>Represents the RDR_RDR_QRDQRFPIDNTEORCRXERXRRXCRXDRXRRXC Group.  A Group is an ordered collection of message 
 * segments that can repeat together or be optionally in/excluded together.
 * This Group contains the following elements: </p>
 * 0: QRD (QRD - original-style query definition segment) <b></b><br>
 * 1: QRF (QRF - original style query filter segment) <b>optional </b><br>
 * 2: RDR_RDR_PIDNTE (a Group object) <b>optional </b><br>
 * 3: RDR_RDR_ORCRXERXRRXCRXDRXRRXC (a Group object) <b>repeating</b><br>
 */
public class RDR_RDR_QRDQRFPIDNTEORCRXERXRRXCRXDRXRRXC extends AbstractGroup {

	/** 
	 * Creates a new RDR_RDR_QRDQRFPIDNTEORCRXERXRRXCRXDRXRRXC Group.
	 */
	public RDR_RDR_QRDQRFPIDNTEORCRXERXRRXCRXDRXRRXC(Group parent, ModelClassFactory factory) {
	   super(parent, factory);
	   try {
	      this.add(QRD.class, true, false);
	      this.add(QRF.class, false, false);
	      this.add(RDR_RDR_PIDNTE.class, false, false);
	      this.add(RDR_RDR_ORCRXERXRRXCRXDRXRRXC.class, true, true);
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error creating RDR_RDR_QRDQRFPIDNTEORCRXERXRRXCRXDRXRRXC - this is probably a bug in the source code generator.", e);
	   }
	}

	/**
	 * Returns QRD (QRD - original-style query definition segment) - creates it if necessary
	 */
	public QRD getQRD() { 
	   QRD ret = null;
	   try {
	      ret = (QRD)this.get("QRD");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns QRF (QRF - original style query filter segment) - creates it if necessary
	 */
	public QRF getQRF() { 
	   QRF ret = null;
	   try {
	      ret = (QRF)this.get("QRF");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns RDR_RDR_PIDNTE (a Group object) - creates it if necessary
	 */
	public RDR_RDR_PIDNTE getPIDNTE() { 
	   RDR_RDR_PIDNTE ret = null;
	   try {
	      ret = (RDR_RDR_PIDNTE)this.get("PIDNTE");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns  first repetition of RDR_RDR_ORCRXERXRRXCRXDRXRRXC (a Group object) - creates it if necessary
	 */
	public RDR_RDR_ORCRXERXRRXCRXDRXRRXC getORCRXERXRRXCRXDRXRRXC() { 
	   RDR_RDR_ORCRXERXRRXCRXDRXRRXC ret = null;
	   try {
	      ret = (RDR_RDR_ORCRXERXRRXCRXDRXRRXC)this.get("ORCRXERXRRXCRXDRXRRXC");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns a specific repetition of RDR_RDR_ORCRXERXRRXCRXDRXRRXC
	 * (a Group object) - creates it if necessary
	 * throws HL7Exception if the repetition requested is more than one 
	 *     greater than the number of existing repetitions.
	 */
	public RDR_RDR_ORCRXERXRRXCRXDRXRRXC getORCRXERXRRXCRXDRXRRXC(int rep) throws HL7Exception { 
	   return (RDR_RDR_ORCRXERXRRXCRXDRXRRXC)this.get("ORCRXERXRRXCRXDRXRRXC", rep);
	}

	/** 
	 * Returns the number of existing repetitions of RDR_RDR_ORCRXERXRRXCRXDRXRRXC 
	 */ 
	public int getORCRXERXRRXCRXDRXRRXCReps() { 
	    int reps = -1; 
	    try { 
	        reps = this.getAll("ORCRXERXRRXCRXDRXRRXC").length; 
	    } catch (HL7Exception e) { 
	        String message = "Unexpected error accessing data - this is probably a bug in the source code generator."; 
	        HapiLogFactory.getHapiLog(this.getClass()).error(message, e); 
	        throw new RuntimeException(message);
	    } 
	    return reps; 
	} 

}
