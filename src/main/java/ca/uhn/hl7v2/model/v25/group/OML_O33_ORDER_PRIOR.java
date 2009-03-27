package ca.uhn.hl7v2.model.v25.group;

import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.log.HapiLogFactory;
import ca.uhn.hl7v2.model.v25.segment.*;

import ca.uhn.hl7v2.model.*;
/**
 * <p>Represents the OML_O33_ORDER_PRIOR Group.  A Group is an ordered collection of message 
 * segments that can repeat together or be optionally in/excluded together.
 * This Group contains the following elements: </p>
 * 0: ORC (Common Order) <b>optional </b><br>
 * 1: OBR (Observation Request) <b></b><br>
 * 2: NTE (Notes and Comments) <b>optional repeating</b><br>
 * 3: OML_O33_TIMING_PRIOR (a Group object) <b>optional repeating</b><br>
 * 4: OML_O33_OBSERVATION_PRIOR (a Group object) <b>repeating</b><br>
 */
public class OML_O33_ORDER_PRIOR extends AbstractGroup {

	/** 
	 * Creates a new OML_O33_ORDER_PRIOR Group.
	 */
	public OML_O33_ORDER_PRIOR(Group parent, ModelClassFactory factory) {
	   super(parent, factory);
	   try {
	      this.add(ORC.class, false, false);
	      this.add(OBR.class, true, false);
	      this.add(NTE.class, false, true);
	      this.add(OML_O33_TIMING_PRIOR.class, false, true);
	      this.add(OML_O33_OBSERVATION_PRIOR.class, true, true);
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error creating OML_O33_ORDER_PRIOR - this is probably a bug in the source code generator.", e);
	   }
	}

	/**
	 * Returns ORC (Common Order) - creates it if necessary
	 */
	public ORC getORC() { 
	   ORC ret = null;
	   try {
	      ret = (ORC)this.get("ORC");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns OBR (Observation Request) - creates it if necessary
	 */
	public OBR getOBR() { 
	   OBR ret = null;
	   try {
	      ret = (OBR)this.get("OBR");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
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
	 * Returns  first repetition of OML_O33_TIMING_PRIOR (a Group object) - creates it if necessary
	 */
	public OML_O33_TIMING_PRIOR getTIMING_PRIOR() { 
	   OML_O33_TIMING_PRIOR ret = null;
	   try {
	      ret = (OML_O33_TIMING_PRIOR)this.get("TIMING_PRIOR");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns a specific repetition of OML_O33_TIMING_PRIOR
	 * (a Group object) - creates it if necessary
	 * throws HL7Exception if the repetition requested is more than one 
	 *     greater than the number of existing repetitions.
	 */
	public OML_O33_TIMING_PRIOR getTIMING_PRIOR(int rep) throws HL7Exception { 
	   return (OML_O33_TIMING_PRIOR)this.get("TIMING_PRIOR", rep);
	}

	/** 
	 * Returns the number of existing repetitions of OML_O33_TIMING_PRIOR 
	 */ 
	public int getTIMING_PRIORReps() { 
	    int reps = -1; 
	    try { 
	        reps = this.getAll("TIMING_PRIOR").length; 
	    } catch (HL7Exception e) { 
	        String message = "Unexpected error accessing data - this is probably a bug in the source code generator."; 
	        HapiLogFactory.getHapiLog(this.getClass()).error(message, e); 
	        throw new RuntimeException(message);
	    } 
	    return reps; 
	} 

	/**
	 * Returns  first repetition of OML_O33_OBSERVATION_PRIOR (a Group object) - creates it if necessary
	 */
	public OML_O33_OBSERVATION_PRIOR getOBSERVATION_PRIOR() { 
	   OML_O33_OBSERVATION_PRIOR ret = null;
	   try {
	      ret = (OML_O33_OBSERVATION_PRIOR)this.get("OBSERVATION_PRIOR");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns a specific repetition of OML_O33_OBSERVATION_PRIOR
	 * (a Group object) - creates it if necessary
	 * throws HL7Exception if the repetition requested is more than one 
	 *     greater than the number of existing repetitions.
	 */
	public OML_O33_OBSERVATION_PRIOR getOBSERVATION_PRIOR(int rep) throws HL7Exception { 
	   return (OML_O33_OBSERVATION_PRIOR)this.get("OBSERVATION_PRIOR", rep);
	}

	/** 
	 * Returns the number of existing repetitions of OML_O33_OBSERVATION_PRIOR 
	 */ 
	public int getOBSERVATION_PRIORReps() { 
	    int reps = -1; 
	    try { 
	        reps = this.getAll("OBSERVATION_PRIOR").length; 
	    } catch (HL7Exception e) { 
	        String message = "Unexpected error accessing data - this is probably a bug in the source code generator."; 
	        HapiLogFactory.getHapiLog(this.getClass()).error(message, e); 
	        throw new RuntimeException(message);
	    } 
	    return reps; 
	} 

}
