package ca.uhn.hl7v2.model.v24.group;

import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.log.HapiLogFactory;
import ca.uhn.hl7v2.model.v24.segment.*;

import ca.uhn.hl7v2.model.*;
/**
 * <p>Represents the OMD_O03_DIET Group.  A Group is an ordered collection of message 
 * segments that can repeat together or be optionally in/excluded together.
 * This Group contains the following elements: </p>
 * 0: ODS (Dietary Orders, Supplements, and Preferences) <b>repeating</b><br>
 * 1: NTE (Notes and Comments) <b>optional repeating</b><br>
 * 2: OMD_O03_OBSERVATION (a Group object) <b>optional repeating</b><br>
 */
public class OMD_O03_DIET extends AbstractGroup {

	/** 
	 * Creates a new OMD_O03_DIET Group.
	 */
	public OMD_O03_DIET(Group parent, ModelClassFactory factory) {
	   super(parent, factory);
	   try {
	      this.add(ODS.class, true, true);
	      this.add(NTE.class, false, true);
	      this.add(OMD_O03_OBSERVATION.class, false, true);
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error creating OMD_O03_DIET - this is probably a bug in the source code generator.", e);
	   }
	}

	/**
	 * Returns  first repetition of ODS (Dietary Orders, Supplements, and Preferences) - creates it if necessary
	 */
	public ODS getODS() { 
	   ODS ret = null;
	   try {
	      ret = (ODS)this.get("ODS");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns a specific repetition of ODS
	 * (Dietary Orders, Supplements, and Preferences) - creates it if necessary
	 * throws HL7Exception if the repetition requested is more than one 
	 *     greater than the number of existing repetitions.
	 */
	public ODS getODS(int rep) throws HL7Exception { 
	   return (ODS)this.get("ODS", rep);
	}

	/** 
	 * Returns the number of existing repetitions of ODS 
	 */ 
	public int getODSReps() { 
	    int reps = -1; 
	    try { 
	        reps = this.getAll("ODS").length; 
	    } catch (HL7Exception e) { 
	        String message = "Unexpected error accessing data - this is probably a bug in the source code generator."; 
	        HapiLogFactory.getHapiLog(this.getClass()).error(message, e); 
	        throw new RuntimeException(message);
	    } 
	    return reps; 
	} 

	/**
	 * Returns  first repetition of NTE (Notes and Comments) - creates it if necessary
	 */
	public NTE getNTE() { 
	   NTE ret = null;
	   try {
	      ret = (NTE)this.get("NTE");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns a specific repetition of NTE
	 * (Notes and Comments) - creates it if necessary
	 * throws HL7Exception if the repetition requested is more than one 
	 *     greater than the number of existing repetitions.
	 */
	public NTE getNTE(int rep) throws HL7Exception { 
	   return (NTE)this.get("NTE", rep);
	}

	/** 
	 * Returns the number of existing repetitions of NTE 
	 */ 
	public int getNTEReps() { 
	    int reps = -1; 
	    try { 
	        reps = this.getAll("NTE").length; 
	    } catch (HL7Exception e) { 
	        String message = "Unexpected error accessing data - this is probably a bug in the source code generator."; 
	        HapiLogFactory.getHapiLog(this.getClass()).error(message, e); 
	        throw new RuntimeException(message);
	    } 
	    return reps; 
	} 

	/**
	 * Returns  first repetition of OMD_O03_OBSERVATION (a Group object) - creates it if necessary
	 */
	public OMD_O03_OBSERVATION getOBSERVATION() { 
	   OMD_O03_OBSERVATION ret = null;
	   try {
	      ret = (OMD_O03_OBSERVATION)this.get("OBSERVATION");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns a specific repetition of OMD_O03_OBSERVATION
	 * (a Group object) - creates it if necessary
	 * throws HL7Exception if the repetition requested is more than one 
	 *     greater than the number of existing repetitions.
	 */
	public OMD_O03_OBSERVATION getOBSERVATION(int rep) throws HL7Exception { 
	   return (OMD_O03_OBSERVATION)this.get("OBSERVATION", rep);
	}

	/** 
	 * Returns the number of existing repetitions of OMD_O03_OBSERVATION 
	 */ 
	public int getOBSERVATIONReps() { 
	    int reps = -1; 
	    try { 
	        reps = this.getAll("OBSERVATION").length; 
	    } catch (HL7Exception e) { 
	        String message = "Unexpected error accessing data - this is probably a bug in the source code generator."; 
	        HapiLogFactory.getHapiLog(this.getClass()).error(message, e); 
	        throw new RuntimeException(message);
	    } 
	    return reps; 
	} 

}
