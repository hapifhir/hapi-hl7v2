package ca.uhn.hl7v2.model.v23.group;

import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.log.HapiLogFactory;
import ca.uhn.hl7v2.model.v23.segment.*;

import ca.uhn.hl7v2.model.*;
/**
 * <p>Represents the SRR_S07_SCHEDULE Group.  A Group is an ordered collection of message 
 * segments that can repeat together or be optionally in/excluded together.
 * This Group contains the following elements: </p>
 * 0: SCH (Schedule Activity Information) <b></b><br>
 * 1: NTE (Notes and comments segment) <b>optional repeating</b><br>
 * 2: SRR_S07_PATIENT (a Group object) <b>optional repeating</b><br>
 * 3: SRR_S07_RESOURCES (a Group object) <b>repeating</b><br>
 */
public class SRR_S07_SCHEDULE extends AbstractGroup {

	/** 
	 * Creates a new SRR_S07_SCHEDULE Group.
	 */
	public SRR_S07_SCHEDULE(Group parent, ModelClassFactory factory) {
	   super(parent, factory);
	   try {
	      this.add(SCH.class, true, false);
	      this.add(NTE.class, false, true);
	      this.add(SRR_S07_PATIENT.class, false, true);
	      this.add(SRR_S07_RESOURCES.class, true, true);
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error creating SRR_S07_SCHEDULE - this is probably a bug in the source code generator.", e);
	   }
	}

	/**
	 * Returns SCH (Schedule Activity Information) - creates it if necessary
	 */
	public SCH getSCH() { 
	   SCH ret = null;
	   try {
	      ret = (SCH)this.get("SCH");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns  first repetition of NTE (Notes and comments segment) - creates it if necessary
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
	 * (Notes and comments segment) - creates it if necessary
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
	 * Returns  first repetition of SRR_S07_PATIENT (a Group object) - creates it if necessary
	 */
	public SRR_S07_PATIENT getPATIENT() { 
	   SRR_S07_PATIENT ret = null;
	   try {
	      ret = (SRR_S07_PATIENT)this.get("PATIENT");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns a specific repetition of SRR_S07_PATIENT
	 * (a Group object) - creates it if necessary
	 * throws HL7Exception if the repetition requested is more than one 
	 *     greater than the number of existing repetitions.
	 */
	public SRR_S07_PATIENT getPATIENT(int rep) throws HL7Exception { 
	   return (SRR_S07_PATIENT)this.get("PATIENT", rep);
	}

	/** 
	 * Returns the number of existing repetitions of SRR_S07_PATIENT 
	 */ 
	public int getPATIENTReps() { 
	    int reps = -1; 
	    try { 
	        reps = this.getAll("PATIENT").length; 
	    } catch (HL7Exception e) { 
	        String message = "Unexpected error accessing data - this is probably a bug in the source code generator."; 
	        HapiLogFactory.getHapiLog(this.getClass()).error(message, e); 
	        throw new RuntimeException(message);
	    } 
	    return reps; 
	} 

	/**
	 * Returns  first repetition of SRR_S07_RESOURCES (a Group object) - creates it if necessary
	 */
	public SRR_S07_RESOURCES getRESOURCES() { 
	   SRR_S07_RESOURCES ret = null;
	   try {
	      ret = (SRR_S07_RESOURCES)this.get("RESOURCES");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns a specific repetition of SRR_S07_RESOURCES
	 * (a Group object) - creates it if necessary
	 * throws HL7Exception if the repetition requested is more than one 
	 *     greater than the number of existing repetitions.
	 */
	public SRR_S07_RESOURCES getRESOURCES(int rep) throws HL7Exception { 
	   return (SRR_S07_RESOURCES)this.get("RESOURCES", rep);
	}

	/** 
	 * Returns the number of existing repetitions of SRR_S07_RESOURCES 
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
