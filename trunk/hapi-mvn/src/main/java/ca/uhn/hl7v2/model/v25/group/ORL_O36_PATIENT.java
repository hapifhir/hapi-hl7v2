package ca.uhn.hl7v2.model.v25.group;

import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.log.HapiLogFactory;
import ca.uhn.hl7v2.model.v25.segment.*;

import ca.uhn.hl7v2.model.*;
/**
 * <p>Represents the ORL_O36_PATIENT Group.  A Group is an ordered collection of message 
 * segments that can repeat together or be optionally in/excluded together.
 * This Group contains the following elements: </p>
 * 0: PID (Patient Identification) <b></b><br>
 * 1: ORL_O36_SPECIMEN (a Group object) <b>repeating</b><br>
 */
public class ORL_O36_PATIENT extends AbstractGroup {

	/** 
	 * Creates a new ORL_O36_PATIENT Group.
	 */
	public ORL_O36_PATIENT(Group parent, ModelClassFactory factory) {
	   super(parent, factory);
	   try {
	      this.add(PID.class, true, false);
	      this.add(ORL_O36_SPECIMEN.class, true, true);
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error creating ORL_O36_PATIENT - this is probably a bug in the source code generator.", e);
	   }
	}

	/**
	 * Returns PID (Patient Identification) - creates it if necessary
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
	 * Returns  first repetition of ORL_O36_SPECIMEN (a Group object) - creates it if necessary
	 */
	public ORL_O36_SPECIMEN getSPECIMEN() { 
	   ORL_O36_SPECIMEN ret = null;
	   try {
	      ret = (ORL_O36_SPECIMEN)this.get("SPECIMEN");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns a specific repetition of ORL_O36_SPECIMEN
	 * (a Group object) - creates it if necessary
	 * throws HL7Exception if the repetition requested is more than one 
	 *     greater than the number of existing repetitions.
	 */
	public ORL_O36_SPECIMEN getSPECIMEN(int rep) throws HL7Exception { 
	   return (ORL_O36_SPECIMEN)this.get("SPECIMEN", rep);
	}

	/** 
	 * Returns the number of existing repetitions of ORL_O36_SPECIMEN 
	 */ 
	public int getSPECIMENReps() { 
	    int reps = -1; 
	    try { 
	        reps = this.getAll("SPECIMEN").length; 
	    } catch (HL7Exception e) { 
	        String message = "Unexpected error accessing data - this is probably a bug in the source code generator."; 
	        HapiLogFactory.getHapiLog(this.getClass()).error(message, e); 
	        throw new RuntimeException(message);
	    } 
	    return reps; 
	} 

}
