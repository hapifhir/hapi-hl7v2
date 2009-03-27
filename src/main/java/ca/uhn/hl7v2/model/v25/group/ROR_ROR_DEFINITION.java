package ca.uhn.hl7v2.model.v25.group;

import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.log.HapiLogFactory;
import ca.uhn.hl7v2.model.v25.segment.*;

import ca.uhn.hl7v2.model.*;
/**
 * <p>Represents the ROR_ROR_DEFINITION Group.  A Group is an ordered collection of message 
 * segments that can repeat together or be optionally in/excluded together.
 * This Group contains the following elements: </p>
 * 0: QRD (Original-Style Query Definition) <b></b><br>
 * 1: QRF (Original style query filter) <b>optional </b><br>
 * 2: ROR_ROR_PATIENT (a Group object) <b>optional </b><br>
 * 3: ROR_ROR_ORDER (a Group object) <b>repeating</b><br>
 */
public class ROR_ROR_DEFINITION extends AbstractGroup {

	/** 
	 * Creates a new ROR_ROR_DEFINITION Group.
	 */
	public ROR_ROR_DEFINITION(Group parent, ModelClassFactory factory) {
	   super(parent, factory);
	   try {
	      this.add(QRD.class, true, false);
	      this.add(QRF.class, false, false);
	      this.add(ROR_ROR_PATIENT.class, false, false);
	      this.add(ROR_ROR_ORDER.class, true, true);
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error creating ROR_ROR_DEFINITION - this is probably a bug in the source code generator.", e);
	   }
	}

	/**
	 * Returns QRD (Original-Style Query Definition) - creates it if necessary
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
	 * Returns QRF (Original style query filter) - creates it if necessary
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
	 * Returns ROR_ROR_PATIENT (a Group object) - creates it if necessary
	 */
	public ROR_ROR_PATIENT getPATIENT() { 
	   ROR_ROR_PATIENT ret = null;
	   try {
	      ret = (ROR_ROR_PATIENT)this.get("PATIENT");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns  first repetition of ROR_ROR_ORDER (a Group object) - creates it if necessary
	 */
	public ROR_ROR_ORDER getORDER() { 
	   ROR_ROR_ORDER ret = null;
	   try {
	      ret = (ROR_ROR_ORDER)this.get("ORDER");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns a specific repetition of ROR_ROR_ORDER
	 * (a Group object) - creates it if necessary
	 * throws HL7Exception if the repetition requested is more than one 
	 *     greater than the number of existing repetitions.
	 */
	public ROR_ROR_ORDER getORDER(int rep) throws HL7Exception { 
	   return (ROR_ROR_ORDER)this.get("ORDER", rep);
	}

	/** 
	 * Returns the number of existing repetitions of ROR_ROR_ORDER 
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
