package ca.uhn.hl7v2.model.v23.group;

import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.log.HapiLogFactory;
import ca.uhn.hl7v2.model.v23.segment.*;

import ca.uhn.hl7v2.model.*;
/**
 * <p>Represents the RGR_RGR_DEFINITION Group.  A Group is an ordered collection of message 
 * segments that can repeat together or be optionally in/excluded together.
 * This Group contains the following elements: </p>
 * 0: QRD (Query definition segment) <b></b><br>
 * 1: QRF (Query filter segment) <b>optional </b><br>
 * 2: RGR_RGR_PATIENT (a Group object) <b>optional </b><br>
 * 3: RGR_RGR_ORDER (a Group object) <b>repeating</b><br>
 */
public class RGR_RGR_DEFINITION extends AbstractGroup {

	/** 
	 * Creates a new RGR_RGR_DEFINITION Group.
	 */
	public RGR_RGR_DEFINITION(Group parent, ModelClassFactory factory) {
	   super(parent, factory);
	   try {
	      this.add(QRD.class, true, false);
	      this.add(QRF.class, false, false);
	      this.add(RGR_RGR_PATIENT.class, false, false);
	      this.add(RGR_RGR_ORDER.class, true, true);
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error creating RGR_RGR_DEFINITION - this is probably a bug in the source code generator.", e);
	   }
	}

	/**
	 * Returns QRD (Query definition segment) - creates it if necessary
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
	 * Returns QRF (Query filter segment) - creates it if necessary
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
	 * Returns RGR_RGR_PATIENT (a Group object) - creates it if necessary
	 */
	public RGR_RGR_PATIENT getPATIENT() { 
	   RGR_RGR_PATIENT ret = null;
	   try {
	      ret = (RGR_RGR_PATIENT)this.get("PATIENT");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns  first repetition of RGR_RGR_ORDER (a Group object) - creates it if necessary
	 */
	public RGR_RGR_ORDER getORDER() { 
	   RGR_RGR_ORDER ret = null;
	   try {
	      ret = (RGR_RGR_ORDER)this.get("ORDER");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns a specific repetition of RGR_RGR_ORDER
	 * (a Group object) - creates it if necessary
	 * throws HL7Exception if the repetition requested is more than one 
	 *     greater than the number of existing repetitions.
	 */
	public RGR_RGR_ORDER getORDER(int rep) throws HL7Exception { 
	   return (RGR_RGR_ORDER)this.get("ORDER", rep);
	}

	/** 
	 * Returns the number of existing repetitions of RGR_RGR_ORDER 
	 */ 
	public int getORDERReps() { 
	    int reps = -1; 
	    try { 
	        reps = this.getAll("ORDER").length; 
	    } catch (HL7Exception e) { 
	        String message = "Unexpected error accessing data - this is probably a bug in the source code generator."; 
	        HapiLogFactory.getHapiLog(this.getClass()).error(message, e); 
	        throw new RuntimeException(message);
	    } 
	    return reps; 
	} 

}
