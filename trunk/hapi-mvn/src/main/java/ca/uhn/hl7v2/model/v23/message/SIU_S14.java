package ca.uhn.hl7v2.model.v23.message;

import ca.uhn.log.HapiLogFactory;
import ca.uhn.hl7v2.model.v23.group.*;

import ca.uhn.hl7v2.model.v23.segment.*;

import ca.uhn.hl7v2.HL7Exception;

import ca.uhn.hl7v2.parser.ModelClassFactory;

import ca.uhn.hl7v2.parser.DefaultModelClassFactory;

import ca.uhn.hl7v2.model.AbstractMessage;

/**
 * <p>Represents a SIU_S14 message structure (see chapter ?). This structure contains the 
 * following elements: </p>
 * 0: MSH (Message header segment) <b></b><br>
 * 1: SCH (Schedule Activity Information) <b></b><br>
 * 2: NTE (Notes and comments segment) <b>optional repeating</b><br>
 * 3: SIU_S14_PATIENT (a Group object) <b>optional repeating</b><br>
 * 4: SIU_S14_RESOURCES (a Group object) <b>repeating</b><br>
 */
public class SIU_S14 extends AbstractMessage  {

	/** 
	 * Creates a new SIU_S14 Group with custom ModelClassFactory.
	 */
	public SIU_S14(ModelClassFactory factory) {
	   super(factory);
	   init(factory);
	}

	/**
	 * Creates a new SIU_S14 Group with DefaultModelClassFactory. 
	 */ 
	public SIU_S14() { 
	   super(new DefaultModelClassFactory());
	   init(new DefaultModelClassFactory());
	}

	private void init(ModelClassFactory factory) {
	   try {
	      this.add(MSH.class, true, false);
	      this.add(SCH.class, true, false);
	      this.add(NTE.class, false, true);
	      this.add(SIU_S14_PATIENT.class, false, true);
	      this.add(SIU_S14_RESOURCES.class, true, true);
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error creating SIU_S14 - this is probably a bug in the source code generator.", e);
	   }
	}

	/**
	 * Returns MSH (Message header segment) - creates it if necessary
	 */
	public MSH getMSH() { 
	   MSH ret = null;
	   try {
	      ret = (MSH)this.get("MSH");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
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
	 * Returns  first repetition of SIU_S14_PATIENT (a Group object) - creates it if necessary
	 */
	public SIU_S14_PATIENT getPATIENT() { 
	   SIU_S14_PATIENT ret = null;
	   try {
	      ret = (SIU_S14_PATIENT)this.get("PATIENT");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns a specific repetition of SIU_S14_PATIENT
	 * (a Group object) - creates it if necessary
	 * throws HL7Exception if the repetition requested is more than one 
	 *     greater than the number of existing repetitions.
	 */
	public SIU_S14_PATIENT getPATIENT(int rep) throws HL7Exception { 
	   return (SIU_S14_PATIENT)this.get("PATIENT", rep);
	}

	/** 
	 * Returns the number of existing repetitions of SIU_S14_PATIENT 
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
	 * Returns  first repetition of SIU_S14_RESOURCES (a Group object) - creates it if necessary
	 */
	public SIU_S14_RESOURCES getRESOURCES() { 
	   SIU_S14_RESOURCES ret = null;
	   try {
	      ret = (SIU_S14_RESOURCES)this.get("RESOURCES");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns a specific repetition of SIU_S14_RESOURCES
	 * (a Group object) - creates it if necessary
	 * throws HL7Exception if the repetition requested is more than one 
	 *     greater than the number of existing repetitions.
	 */
	public SIU_S14_RESOURCES getRESOURCES(int rep) throws HL7Exception { 
	   return (SIU_S14_RESOURCES)this.get("RESOURCES", rep);
	}

	/** 
	 * Returns the number of existing repetitions of SIU_S14_RESOURCES 
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
