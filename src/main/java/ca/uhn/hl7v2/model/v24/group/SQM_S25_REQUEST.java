package ca.uhn.hl7v2.model.v24.group;

import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.log.HapiLogFactory;
import ca.uhn.hl7v2.model.v24.segment.*;

import ca.uhn.hl7v2.model.*;
/**
 * <p>Represents the SQM_S25_REQUEST Group.  A Group is an ordered collection of message 
 * segments that can repeat together or be optionally in/excluded together.
 * This Group contains the following elements: </p>
 * 0: ARQ (Appointment Request) <b></b><br>
 * 1: APR (Appointment Preferences) <b>optional </b><br>
 * 2: PID (Patient identification) <b>optional </b><br>
 * 3: SQM_S25_RESOURCES (a Group object) <b>repeating</b><br>
 */
public class SQM_S25_REQUEST extends AbstractGroup {

	/** 
	 * Creates a new SQM_S25_REQUEST Group.
	 */
	public SQM_S25_REQUEST(Group parent, ModelClassFactory factory) {
	   super(parent, factory);
	   try {
	      this.add(ARQ.class, true, false);
	      this.add(APR.class, false, false);
	      this.add(PID.class, false, false);
	      this.add(SQM_S25_RESOURCES.class, true, true);
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error creating SQM_S25_REQUEST - this is probably a bug in the source code generator.", e);
	   }
	}

	/**
	 * Returns ARQ (Appointment Request) - creates it if necessary
	 */
	public ARQ getARQ() { 
	   ARQ ret = null;
	   try {
	      ret = (ARQ)this.get("ARQ");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns APR (Appointment Preferences) - creates it if necessary
	 */
	public APR getAPR() { 
	   APR ret = null;
	   try {
	      ret = (APR)this.get("APR");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns PID (Patient identification) - creates it if necessary
	 */
	public PID getPID() { 
	   PID ret = null;
	   try {
	      ret = (PID)this.get("PID");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns  first repetition of SQM_S25_RESOURCES (a Group object) - creates it if necessary
	 */
	public SQM_S25_RESOURCES getRESOURCES() { 
	   SQM_S25_RESOURCES ret = null;
	   try {
	      ret = (SQM_S25_RESOURCES)this.get("RESOURCES");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns a specific repetition of SQM_S25_RESOURCES
	 * (a Group object) - creates it if necessary
	 * throws HL7Exception if the repetition requested is more than one 
	 *     greater than the number of existing repetitions.
	 */
	public SQM_S25_RESOURCES getRESOURCES(int rep) throws HL7Exception { 
	   return (SQM_S25_RESOURCES)this.get("RESOURCES", rep);
	}

	/** 
	 * Returns the number of existing repetitions of SQM_S25_RESOURCES 
	 */ 
	public int getRESOURCESReps() { 
	    int reps = -1; 
	    try { 
	        reps = this.getAll("RESOURCES").length; 
	    } catch (HL7Exception e) { 
	        String message = "Unexpected error accessing data - this is probably a bug in the source code generator."; 
	        HapiLogFactory.getHapiLog(this.getClass()).error(message, e); 
	        throw new RuntimeException(message);
	    } 
	    return reps; 
	} 

}
