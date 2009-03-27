package ca.uhn.hl7v2.model.v231.group;

import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.log.HapiLogFactory;
import ca.uhn.hl7v2.model.v231.segment.*;

import ca.uhn.hl7v2.model.*;
/**
 * <p>Represents the RER_RER_QRDQRFPIDNTEORCRXERXRRXC Group.  A Group is an ordered collection of message 
 * segments that can repeat together or be optionally in/excluded together.
 * This Group contains the following elements: </p>
 * 0: QRD (QRD - original-style query definition segment) <b></b><br>
 * 1: QRF (QRF - original style query filter segment) <b>optional </b><br>
 * 2: RER_RER_PIDNTE (a Group object) <b>optional </b><br>
 * 3: RER_RER_ORCRXERXRRXC (a Group object) <b>repeating</b><br>
 */
public class RER_RER_QRDQRFPIDNTEORCRXERXRRXC extends AbstractGroup {

	/** 
	 * Creates a new RER_RER_QRDQRFPIDNTEORCRXERXRRXC Group.
	 */
	public RER_RER_QRDQRFPIDNTEORCRXERXRRXC(Group parent, ModelClassFactory factory) {
	   super(parent, factory);
	   try {
	      this.add(QRD.class, true, false);
	      this.add(QRF.class, false, false);
	      this.add(RER_RER_PIDNTE.class, false, false);
	      this.add(RER_RER_ORCRXERXRRXC.class, true, true);
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error creating RER_RER_QRDQRFPIDNTEORCRXERXRRXC - this is probably a bug in the source code generator.", e);
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
	 * Returns RER_RER_PIDNTE (a Group object) - creates it if necessary
	 */
	public RER_RER_PIDNTE getPIDNTE() { 
	   RER_RER_PIDNTE ret = null;
	   try {
	      ret = (RER_RER_PIDNTE)this.get("PIDNTE");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns  first repetition of RER_RER_ORCRXERXRRXC (a Group object) - creates it if necessary
	 */
	public RER_RER_ORCRXERXRRXC getORCRXERXRRXC() { 
	   RER_RER_ORCRXERXRRXC ret = null;
	   try {
	      ret = (RER_RER_ORCRXERXRRXC)this.get("ORCRXERXRRXC");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns a specific repetition of RER_RER_ORCRXERXRRXC
	 * (a Group object) - creates it if necessary
	 * throws HL7Exception if the repetition requested is more than one 
	 *     greater than the number of existing repetitions.
	 */
	public RER_RER_ORCRXERXRRXC getORCRXERXRRXC(int rep) throws HL7Exception { 
	   return (RER_RER_ORCRXERXRRXC)this.get("ORCRXERXRRXC", rep);
	}

	/** 
	 * Returns the number of existing repetitions of RER_RER_ORCRXERXRRXC 
	 */ 
	public int getORCRXERXRRXCReps() { 
	    int reps = -1; 
	    try { 
	        reps = this.getAll("ORCRXERXRRXC").length; 
	    } catch (HL7Exception e) { 
	        String message = "Unexpected error accessing data - this is probably a bug in the source code generator."; 
	        HapiLogFactory.getHapiLog(this.getClass()).error(message, e); 
	        throw new RuntimeException(message);
	    } 
	    return reps; 
	} 

}
