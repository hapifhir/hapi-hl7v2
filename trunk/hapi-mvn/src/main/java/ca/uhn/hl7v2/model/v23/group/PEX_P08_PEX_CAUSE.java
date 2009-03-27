package ca.uhn.hl7v2.model.v23.group;

import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.log.HapiLogFactory;
import ca.uhn.hl7v2.model.v23.segment.*;

import ca.uhn.hl7v2.model.*;
/**
 * <p>Represents the PEX_P08_PEX_CAUSE Group.  A Group is an ordered collection of message 
 * segments that can repeat together or be optionally in/excluded together.
 * This Group contains the following elements: </p>
 * 0: PCR (Possible Causal Relationship) <b></b><br>
 * 1: PEX_P08_RX_ORDER (a Group object) <b>optional </b><br>
 * 2: PEX_P08_RX_ADMINISTRATION (a Group object) <b>optional repeating</b><br>
 * 3: PRB (Problem Detail) <b>optional repeating</b><br>
 * 4: OBX (Observation segment) <b>optional repeating</b><br>
 * 5: NTE (Notes and comments segment) <b>optional repeating</b><br>
 * 6: PEX_P08_ASSOCIATED_PERSON (a Group object) <b>optional </b><br>
 * 7: PEX_P08_STUDY (a Group object) <b>optional repeating</b><br>
 */
public class PEX_P08_PEX_CAUSE extends AbstractGroup {

	/** 
	 * Creates a new PEX_P08_PEX_CAUSE Group.
	 */
	public PEX_P08_PEX_CAUSE(Group parent, ModelClassFactory factory) {
	   super(parent, factory);
	   try {
	      this.add(PCR.class, true, false);
	      this.add(PEX_P08_RX_ORDER.class, false, false);
	      this.add(PEX_P08_RX_ADMINISTRATION.class, false, true);
	      this.add(PRB.class, false, true);
	      this.add(OBX.class, false, true);
	      this.add(NTE.class, false, true);
	      this.add(PEX_P08_ASSOCIATED_PERSON.class, false, false);
	      this.add(PEX_P08_STUDY.class, false, true);
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error creating PEX_P08_PEX_CAUSE - this is probably a bug in the source code generator.", e);
	   }
	}

	/**
	 * Returns PCR (Possible Causal Relationship) - creates it if necessary
	 */
	public PCR getPCR() { 
	   PCR ret = null;
	   try {
	      ret = (PCR)this.get("PCR");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns PEX_P08_RX_ORDER (a Group object) - creates it if necessary
	 */
	public PEX_P08_RX_ORDER getRX_ORDER() { 
	   PEX_P08_RX_ORDER ret = null;
	   try {
	      ret = (PEX_P08_RX_ORDER)this.get("RX_ORDER");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns  first repetition of PEX_P08_RX_ADMINISTRATION (a Group object) - creates it if necessary
	 */
	public PEX_P08_RX_ADMINISTRATION getRX_ADMINISTRATION() { 
	   PEX_P08_RX_ADMINISTRATION ret = null;
	   try {
	      ret = (PEX_P08_RX_ADMINISTRATION)this.get("RX_ADMINISTRATION");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns a specific repetition of PEX_P08_RX_ADMINISTRATION
	 * (a Group object) - creates it if necessary
	 * throws HL7Exception if the repetition requested is more than one 
	 *     greater than the number of existing repetitions.
	 */
	public PEX_P08_RX_ADMINISTRATION getRX_ADMINISTRATION(int rep) throws HL7Exception { 
	   return (PEX_P08_RX_ADMINISTRATION)this.get("RX_ADMINISTRATION", rep);
	}

	/** 
	 * Returns the number of existing repetitions of PEX_P08_RX_ADMINISTRATION 
	 */ 
	public int getRX_ADMINISTRATIONReps() { 
	    int reps = -1; 
	    try { 
	        reps = this.getAll("RX_ADMINISTRATION").length; 
	    } catch (HL7Exception e) { 
	        String message = "Unexpected error accessing data - this is probably a bug in the source code generator."; 
	        HapiLogFactory.getHapiLog(this.getClass()).error(message, e); 
	        throw new RuntimeException(message);
	    } 
	    return reps; 
	} 

	/**
	 * Returns  first repetition of PRB (Problem Detail) - creates it if necessary
	 */
	public PRB getPRB() { 
	   PRB ret = null;
	   try {
	      ret = (PRB)this.get("PRB");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns a specific repetition of PRB
	 * (Problem Detail) - creates it if necessary
	 * throws HL7Exception if the repetition requested is more than one 
	 *     greater than the number of existing repetitions.
	 */
	public PRB getPRB(int rep) throws HL7Exception { 
	   return (PRB)this.get("PRB", rep);
	}

	/** 
	 * Returns the number of existing repetitions of PRB 
	 */ 
	public int getPRBReps() { 
	    int reps = -1; 
	    try { 
	        reps = this.getAll("PRB").length; 
	    } catch (HL7Exception e) { 
	        String message = "Unexpected error accessing data - this is probably a bug in the source code generator."; 
	        HapiLogFactory.getHapiLog(this.getClass()).error(message, e); 
	        throw new RuntimeException(message);
	    } 
	    return reps; 
	} 

	/**
	 * Returns  first repetition of OBX (Observation segment) - creates it if necessary
	 */
	public OBX getOBX() { 
	   OBX ret = null;
	   try {
	      ret = (OBX)this.get("OBX");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns a specific repetition of OBX
	 * (Observation segment) - creates it if necessary
	 * throws HL7Exception if the repetition requested is more than one 
	 *     greater than the number of existing repetitions.
	 */
	public OBX getOBX(int rep) throws HL7Exception { 
	   return (OBX)this.get("OBX", rep);
	}

	/** 
	 * Returns the number of existing repetitions of OBX 
	 */ 
	public int getOBXReps() { 
	    int reps = -1; 
	    try { 
	        reps = this.getAll("OBX").length; 
	    } catch (HL7Exception e) { 
	        String message = "Unexpected error accessing data - this is probably a bug in the source code generator."; 
	        HapiLogFactory.getHapiLog(this.getClass()).error(message, e); 
	        throw new RuntimeException(message);
	    } 
	    return reps; 
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
	 * Returns PEX_P08_ASSOCIATED_PERSON (a Group object) - creates it if necessary
	 */
	public PEX_P08_ASSOCIATED_PERSON getASSOCIATED_PERSON() { 
	   PEX_P08_ASSOCIATED_PERSON ret = null;
	   try {
	      ret = (PEX_P08_ASSOCIATED_PERSON)this.get("ASSOCIATED_PERSON");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns  first repetition of PEX_P08_STUDY (a Group object) - creates it if necessary
	 */
	public PEX_P08_STUDY getSTUDY() { 
	   PEX_P08_STUDY ret = null;
	   try {
	      ret = (PEX_P08_STUDY)this.get("STUDY");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns a specific repetition of PEX_P08_STUDY
	 * (a Group object) - creates it if necessary
	 * throws HL7Exception if the repetition requested is more than one 
	 *     greater than the number of existing repetitions.
	 */
	public PEX_P08_STUDY getSTUDY(int rep) throws HL7Exception { 
	   return (PEX_P08_STUDY)this.get("STUDY", rep);
	}

	/** 
	 * Returns the number of existing repetitions of PEX_P08_STUDY 
	 */ 
	public int getSTUDYReps() { 
	    int reps = -1; 
	    try { 
	        reps = this.getAll("STUDY").length; 
	    } catch (HL7Exception e) { 
	        String message = "Unexpected error accessing data - this is probably a bug in the source code generator."; 
	        HapiLogFactory.getHapiLog(this.getClass()).error(message, e); 
	        throw new RuntimeException(message);
	    } 
	    return reps; 
	} 

}
