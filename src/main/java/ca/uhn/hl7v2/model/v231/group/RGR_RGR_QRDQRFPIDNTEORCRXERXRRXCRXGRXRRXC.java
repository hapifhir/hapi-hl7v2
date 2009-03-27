package ca.uhn.hl7v2.model.v231.group;

import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.log.HapiLogFactory;
import ca.uhn.hl7v2.model.v231.segment.*;

import ca.uhn.hl7v2.model.*;
/**
 * <p>Represents the RGR_RGR_QRDQRFPIDNTEORCRXERXRRXCRXGRXRRXC Group.  A Group is an ordered collection of message 
 * segments that can repeat together or be optionally in/excluded together.
 * This Group contains the following elements: </p>
 * 0: QRD (QRD - original-style query definition segment) <b></b><br>
 * 1: QRF (QRF - original style query filter segment) <b>optional </b><br>
 * 2: RGR_RGR_PIDNTE (a Group object) <b>optional </b><br>
 * 3: RGR_RGR_ORCRXERXRRXCRXGRXRRXC (a Group object) <b>repeating</b><br>
 */
public class RGR_RGR_QRDQRFPIDNTEORCRXERXRRXCRXGRXRRXC extends AbstractGroup {

	/** 
	 * Creates a new RGR_RGR_QRDQRFPIDNTEORCRXERXRRXCRXGRXRRXC Group.
	 */
	public RGR_RGR_QRDQRFPIDNTEORCRXERXRRXCRXGRXRRXC(Group parent, ModelClassFactory factory) {
	   super(parent, factory);
	   try {
	      this.add(QRD.class, true, false);
	      this.add(QRF.class, false, false);
	      this.add(RGR_RGR_PIDNTE.class, false, false);
	      this.add(RGR_RGR_ORCRXERXRRXCRXGRXRRXC.class, true, true);
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error creating RGR_RGR_QRDQRFPIDNTEORCRXERXRRXCRXGRXRRXC - this is probably a bug in the source code generator.", e);
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
	 * Returns RGR_RGR_PIDNTE (a Group object) - creates it if necessary
	 */
	public RGR_RGR_PIDNTE getPIDNTE() { 
	   RGR_RGR_PIDNTE ret = null;
	   try {
	      ret = (RGR_RGR_PIDNTE)this.get("PIDNTE");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns  first repetition of RGR_RGR_ORCRXERXRRXCRXGRXRRXC (a Group object) - creates it if necessary
	 */
	public RGR_RGR_ORCRXERXRRXCRXGRXRRXC getORCRXERXRRXCRXGRXRRXC() { 
	   RGR_RGR_ORCRXERXRRXCRXGRXRRXC ret = null;
	   try {
	      ret = (RGR_RGR_ORCRXERXRRXCRXGRXRRXC)this.get("ORCRXERXRRXCRXGRXRRXC");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns a specific repetition of RGR_RGR_ORCRXERXRRXCRXGRXRRXC
	 * (a Group object) - creates it if necessary
	 * throws HL7Exception if the repetition requested is more than one 
	 *     greater than the number of existing repetitions.
	 */
	public RGR_RGR_ORCRXERXRRXCRXGRXRRXC getORCRXERXRRXCRXGRXRRXC(int rep) throws HL7Exception { 
	   return (RGR_RGR_ORCRXERXRRXCRXGRXRRXC)this.get("ORCRXERXRRXCRXGRXRRXC", rep);
	}

	/** 
	 * Returns the number of existing repetitions of RGR_RGR_ORCRXERXRRXCRXGRXRRXC 
	 */ 
	public int getORCRXERXRRXCRXGRXRRXCReps() { 
	    int reps = -1; 
	    try { 
	        reps = this.getAll("ORCRXERXRRXCRXGRXRRXC").length; 
	    } catch (HL7Exception e) { 
	        String message = "Unexpected error accessing data - this is probably a bug in the source code generator."; 
	        HapiLogFactory.getHapiLog(this.getClass()).error(message, e); 
	        throw new RuntimeException(message);
	    } 
	    return reps; 
	} 

}
