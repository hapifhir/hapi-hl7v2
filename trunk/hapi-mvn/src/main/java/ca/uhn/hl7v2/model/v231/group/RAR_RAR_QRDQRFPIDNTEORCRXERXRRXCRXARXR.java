package ca.uhn.hl7v2.model.v231.group;

import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.log.HapiLogFactory;
import ca.uhn.hl7v2.model.v231.segment.*;

import ca.uhn.hl7v2.model.*;
/**
 * <p>Represents the RAR_RAR_QRDQRFPIDNTEORCRXERXRRXCRXARXR Group.  A Group is an ordered collection of message 
 * segments that can repeat together or be optionally in/excluded together.
 * This Group contains the following elements: </p>
 * 0: QRD (QRD - original-style query definition segment) <b></b><br>
 * 1: QRF (QRF - original style query filter segment) <b>optional </b><br>
 * 2: RAR_RAR_PIDNTE (a Group object) <b>optional </b><br>
 * 3: RAR_RAR_ORCRXERXRRXCRXARXR (a Group object) <b>repeating</b><br>
 */
public class RAR_RAR_QRDQRFPIDNTEORCRXERXRRXCRXARXR extends AbstractGroup {

	/** 
	 * Creates a new RAR_RAR_QRDQRFPIDNTEORCRXERXRRXCRXARXR Group.
	 */
	public RAR_RAR_QRDQRFPIDNTEORCRXERXRRXCRXARXR(Group parent, ModelClassFactory factory) {
	   super(parent, factory);
	   try {
	      this.add(QRD.class, true, false);
	      this.add(QRF.class, false, false);
	      this.add(RAR_RAR_PIDNTE.class, false, false);
	      this.add(RAR_RAR_ORCRXERXRRXCRXARXR.class, true, true);
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error creating RAR_RAR_QRDQRFPIDNTEORCRXERXRRXCRXARXR - this is probably a bug in the source code generator.", e);
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
	 * Returns RAR_RAR_PIDNTE (a Group object) - creates it if necessary
	 */
	public RAR_RAR_PIDNTE getPIDNTE() { 
	   RAR_RAR_PIDNTE ret = null;
	   try {
	      ret = (RAR_RAR_PIDNTE)this.get("PIDNTE");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns  first repetition of RAR_RAR_ORCRXERXRRXCRXARXR (a Group object) - creates it if necessary
	 */
	public RAR_RAR_ORCRXERXRRXCRXARXR getORCRXERXRRXCRXARXR() { 
	   RAR_RAR_ORCRXERXRRXCRXARXR ret = null;
	   try {
	      ret = (RAR_RAR_ORCRXERXRRXCRXARXR)this.get("ORCRXERXRRXCRXARXR");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns a specific repetition of RAR_RAR_ORCRXERXRRXCRXARXR
	 * (a Group object) - creates it if necessary
	 * throws HL7Exception if the repetition requested is more than one 
	 *     greater than the number of existing repetitions.
	 */
	public RAR_RAR_ORCRXERXRRXCRXARXR getORCRXERXRRXCRXARXR(int rep) throws HL7Exception { 
	   return (RAR_RAR_ORCRXERXRRXCRXARXR)this.get("ORCRXERXRRXCRXARXR", rep);
	}

	/** 
	 * Returns the number of existing repetitions of RAR_RAR_ORCRXERXRRXCRXARXR 
	 */ 
	public int getORCRXERXRRXCRXARXRReps() { 
	    int reps = -1; 
	    try { 
	        reps = this.getAll("ORCRXERXRRXCRXARXR").length; 
	    } catch (HL7Exception e) { 
	        String message = "Unexpected error accessing data - this is probably a bug in the source code generator."; 
	        HapiLogFactory.getHapiLog(this.getClass()).error(message, e); 
	        throw new RuntimeException(message);
	    } 
	    return reps; 
	} 

}
