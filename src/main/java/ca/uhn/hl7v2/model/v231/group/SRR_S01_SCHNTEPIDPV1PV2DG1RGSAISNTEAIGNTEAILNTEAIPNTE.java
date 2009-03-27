package ca.uhn.hl7v2.model.v231.group;

import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.log.HapiLogFactory;
import ca.uhn.hl7v2.model.v231.segment.*;

import ca.uhn.hl7v2.model.*;
/**
 * <p>Represents the SRR_S01_SCHNTEPIDPV1PV2DG1RGSAISNTEAIGNTEAILNTEAIPNTE Group.  A Group is an ordered collection of message 
 * segments that can repeat together or be optionally in/excluded together.
 * This Group contains the following elements: </p>
 * 0: SCH (SCH - schedule activity information segment) <b></b><br>
 * 1: NTE (NTE - notes and comments segment) <b>optional repeating</b><br>
 * 2: SRR_S01_PIDPV1PV2DG1 (a Group object) <b>optional repeating</b><br>
 * 3: SRR_S01_RGSAISNTEAIGNTEAILNTEAIPNTE (a Group object) <b>repeating</b><br>
 */
public class SRR_S01_SCHNTEPIDPV1PV2DG1RGSAISNTEAIGNTEAILNTEAIPNTE extends AbstractGroup {

	/** 
	 * Creates a new SRR_S01_SCHNTEPIDPV1PV2DG1RGSAISNTEAIGNTEAILNTEAIPNTE Group.
	 */
	public SRR_S01_SCHNTEPIDPV1PV2DG1RGSAISNTEAIGNTEAILNTEAIPNTE(Group parent, ModelClassFactory factory) {
	   super(parent, factory);
	   try {
	      this.add(SCH.class, true, false);
	      this.add(NTE.class, false, true);
	      this.add(SRR_S01_PIDPV1PV2DG1.class, false, true);
	      this.add(SRR_S01_RGSAISNTEAIGNTEAILNTEAIPNTE.class, true, true);
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error creating SRR_S01_SCHNTEPIDPV1PV2DG1RGSAISNTEAIGNTEAILNTEAIPNTE - this is probably a bug in the source code generator.", e);
	   }
	}

	/**
	 * Returns SCH (SCH - schedule activity information segment) - creates it if necessary
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
	 * Returns  first repetition of NTE (NTE - notes and comments segment) - creates it if necessary
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
	 * (NTE - notes and comments segment) - creates it if necessary
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
	 * Returns  first repetition of SRR_S01_PIDPV1PV2DG1 (a Group object) - creates it if necessary
	 */
	public SRR_S01_PIDPV1PV2DG1 getPIDPV1PV2DG1() { 
	   SRR_S01_PIDPV1PV2DG1 ret = null;
	   try {
	      ret = (SRR_S01_PIDPV1PV2DG1)this.get("PIDPV1PV2DG1");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns a specific repetition of SRR_S01_PIDPV1PV2DG1
	 * (a Group object) - creates it if necessary
	 * throws HL7Exception if the repetition requested is more than one 
	 *     greater than the number of existing repetitions.
	 */
	public SRR_S01_PIDPV1PV2DG1 getPIDPV1PV2DG1(int rep) throws HL7Exception { 
	   return (SRR_S01_PIDPV1PV2DG1)this.get("PIDPV1PV2DG1", rep);
	}

	/** 
	 * Returns the number of existing repetitions of SRR_S01_PIDPV1PV2DG1 
	 */ 
	public int getPIDPV1PV2DG1Reps() { 
	    int reps = -1; 
	    try { 
	        reps = this.getAll("PIDPV1PV2DG1").length; 
	    } catch (HL7Exception e) { 
	        String message = "Unexpected error accessing data - this is probably a bug in the source code generator."; 
	        HapiLogFactory.getHapiLog(this.getClass()).error(message, e); 
	        throw new RuntimeException(message);
	    } 
	    return reps; 
	} 

	/**
	 * Returns  first repetition of SRR_S01_RGSAISNTEAIGNTEAILNTEAIPNTE (a Group object) - creates it if necessary
	 */
	public SRR_S01_RGSAISNTEAIGNTEAILNTEAIPNTE getRGSAISNTEAIGNTEAILNTEAIPNTE() { 
	   SRR_S01_RGSAISNTEAIGNTEAILNTEAIPNTE ret = null;
	   try {
	      ret = (SRR_S01_RGSAISNTEAIGNTEAILNTEAIPNTE)this.get("RGSAISNTEAIGNTEAILNTEAIPNTE");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns a specific repetition of SRR_S01_RGSAISNTEAIGNTEAILNTEAIPNTE
	 * (a Group object) - creates it if necessary
	 * throws HL7Exception if the repetition requested is more than one 
	 *     greater than the number of existing repetitions.
	 */
	public SRR_S01_RGSAISNTEAIGNTEAILNTEAIPNTE getRGSAISNTEAIGNTEAILNTEAIPNTE(int rep) throws HL7Exception { 
	   return (SRR_S01_RGSAISNTEAIGNTEAILNTEAIPNTE)this.get("RGSAISNTEAIGNTEAILNTEAIPNTE", rep);
	}

	/** 
	 * Returns the number of existing repetitions of SRR_S01_RGSAISNTEAIGNTEAILNTEAIPNTE 
	 */ 
	public int getRGSAISNTEAIGNTEAILNTEAIPNTEReps() { 
	    int reps = -1; 
	    try { 
	        reps = this.getAll("RGSAISNTEAIGNTEAILNTEAIPNTE").length; 
	    } catch (HL7Exception e) { 
	        String message = "Unexpected error accessing data - this is probably a bug in the source code generator."; 
	        HapiLogFactory.getHapiLog(this.getClass()).error(message, e); 
	        throw new RuntimeException(message);
	    } 
	    return reps; 
	} 

}
