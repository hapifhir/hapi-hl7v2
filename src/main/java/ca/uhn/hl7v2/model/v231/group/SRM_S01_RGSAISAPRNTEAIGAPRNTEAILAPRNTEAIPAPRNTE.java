package ca.uhn.hl7v2.model.v231.group;

import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.log.HapiLogFactory;
import ca.uhn.hl7v2.model.v231.segment.*;

import ca.uhn.hl7v2.model.*;
/**
 * <p>Represents the SRM_S01_RGSAISAPRNTEAIGAPRNTEAILAPRNTEAIPAPRNTE Group.  A Group is an ordered collection of message 
 * segments that can repeat together or be optionally in/excluded together.
 * This Group contains the following elements: </p>
 * 0: RGS (RGS - resource group segment) <b></b><br>
 * 1: SRM_S01_AISAPRNTE (a Group object) <b>optional repeating</b><br>
 * 2: SRM_S01_AIGAPRNTE (a Group object) <b>optional repeating</b><br>
 * 3: SRM_S01_AILAPRNTE (a Group object) <b>optional repeating</b><br>
 * 4: SRM_S01_AIPAPRNTE (a Group object) <b>optional repeating</b><br>
 */
public class SRM_S01_RGSAISAPRNTEAIGAPRNTEAILAPRNTEAIPAPRNTE extends AbstractGroup {

	/** 
	 * Creates a new SRM_S01_RGSAISAPRNTEAIGAPRNTEAILAPRNTEAIPAPRNTE Group.
	 */
	public SRM_S01_RGSAISAPRNTEAIGAPRNTEAILAPRNTEAIPAPRNTE(Group parent, ModelClassFactory factory) {
	   super(parent, factory);
	   try {
	      this.add(RGS.class, true, false);
	      this.add(SRM_S01_AISAPRNTE.class, false, true);
	      this.add(SRM_S01_AIGAPRNTE.class, false, true);
	      this.add(SRM_S01_AILAPRNTE.class, false, true);
	      this.add(SRM_S01_AIPAPRNTE.class, false, true);
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error creating SRM_S01_RGSAISAPRNTEAIGAPRNTEAILAPRNTEAIPAPRNTE - this is probably a bug in the source code generator.", e);
	   }
	}

	/**
	 * Returns RGS (RGS - resource group segment) - creates it if necessary
	 */
	public RGS getRGS() { 
	   RGS ret = null;
	   try {
	      ret = (RGS)this.get("RGS");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns  first repetition of SRM_S01_AISAPRNTE (a Group object) - creates it if necessary
	 */
	public SRM_S01_AISAPRNTE getAISAPRNTE() { 
	   SRM_S01_AISAPRNTE ret = null;
	   try {
	      ret = (SRM_S01_AISAPRNTE)this.get("AISAPRNTE");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns a specific repetition of SRM_S01_AISAPRNTE
	 * (a Group object) - creates it if necessary
	 * throws HL7Exception if the repetition requested is more than one 
	 *     greater than the number of existing repetitions.
	 */
	public SRM_S01_AISAPRNTE getAISAPRNTE(int rep) throws HL7Exception { 
	   return (SRM_S01_AISAPRNTE)this.get("AISAPRNTE", rep);
	}

	/** 
	 * Returns the number of existing repetitions of SRM_S01_AISAPRNTE 
	 */ 
	public int getAISAPRNTEReps() { 
	    int reps = -1; 
	    try { 
	        reps = this.getAll("AISAPRNTE").length; 
	    } catch (HL7Exception e) { 
	        String message = "Unexpected error accessing data - this is probably a bug in the source code generator."; 
	        HapiLogFactory.getHapiLog(this.getClass()).error(message, e); 
	        throw new RuntimeException(message);
	    } 
	    return reps; 
	} 

	/**
	 * Returns  first repetition of SRM_S01_AIGAPRNTE (a Group object) - creates it if necessary
	 */
	public SRM_S01_AIGAPRNTE getAIGAPRNTE() { 
	   SRM_S01_AIGAPRNTE ret = null;
	   try {
	      ret = (SRM_S01_AIGAPRNTE)this.get("AIGAPRNTE");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns a specific repetition of SRM_S01_AIGAPRNTE
	 * (a Group object) - creates it if necessary
	 * throws HL7Exception if the repetition requested is more than one 
	 *     greater than the number of existing repetitions.
	 */
	public SRM_S01_AIGAPRNTE getAIGAPRNTE(int rep) throws HL7Exception { 
	   return (SRM_S01_AIGAPRNTE)this.get("AIGAPRNTE", rep);
	}

	/** 
	 * Returns the number of existing repetitions of SRM_S01_AIGAPRNTE 
	 */ 
	public int getAIGAPRNTEReps() { 
	    int reps = -1; 
	    try { 
	        reps = this.getAll("AIGAPRNTE").length; 
	    } catch (HL7Exception e) { 
	        String message = "Unexpected error accessing data - this is probably a bug in the source code generator."; 
	        HapiLogFactory.getHapiLog(this.getClass()).error(message, e); 
	        throw new RuntimeException(message);
	    } 
	    return reps; 
	} 

	/**
	 * Returns  first repetition of SRM_S01_AILAPRNTE (a Group object) - creates it if necessary
	 */
	public SRM_S01_AILAPRNTE getAILAPRNTE() { 
	   SRM_S01_AILAPRNTE ret = null;
	   try {
	      ret = (SRM_S01_AILAPRNTE)this.get("AILAPRNTE");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns a specific repetition of SRM_S01_AILAPRNTE
	 * (a Group object) - creates it if necessary
	 * throws HL7Exception if the repetition requested is more than one 
	 *     greater than the number of existing repetitions.
	 */
	public SRM_S01_AILAPRNTE getAILAPRNTE(int rep) throws HL7Exception { 
	   return (SRM_S01_AILAPRNTE)this.get("AILAPRNTE", rep);
	}

	/** 
	 * Returns the number of existing repetitions of SRM_S01_AILAPRNTE 
	 */ 
	public int getAILAPRNTEReps() { 
	    int reps = -1; 
	    try { 
	        reps = this.getAll("AILAPRNTE").length; 
	    } catch (HL7Exception e) { 
	        String message = "Unexpected error accessing data - this is probably a bug in the source code generator."; 
	        HapiLogFactory.getHapiLog(this.getClass()).error(message, e); 
	        throw new RuntimeException(message);
	    } 
	    return reps; 
	} 

	/**
	 * Returns  first repetition of SRM_S01_AIPAPRNTE (a Group object) - creates it if necessary
	 */
	public SRM_S01_AIPAPRNTE getAIPAPRNTE() { 
	   SRM_S01_AIPAPRNTE ret = null;
	   try {
	      ret = (SRM_S01_AIPAPRNTE)this.get("AIPAPRNTE");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns a specific repetition of SRM_S01_AIPAPRNTE
	 * (a Group object) - creates it if necessary
	 * throws HL7Exception if the repetition requested is more than one 
	 *     greater than the number of existing repetitions.
	 */
	public SRM_S01_AIPAPRNTE getAIPAPRNTE(int rep) throws HL7Exception { 
	   return (SRM_S01_AIPAPRNTE)this.get("AIPAPRNTE", rep);
	}

	/** 
	 * Returns the number of existing repetitions of SRM_S01_AIPAPRNTE 
	 */ 
	public int getAIPAPRNTEReps() { 
	    int reps = -1; 
	    try { 
	        reps = this.getAll("AIPAPRNTE").length; 
	    } catch (HL7Exception e) { 
	        String message = "Unexpected error accessing data - this is probably a bug in the source code generator."; 
	        HapiLogFactory.getHapiLog(this.getClass()).error(message, e); 
	        throw new RuntimeException(message);
	    } 
	    return reps; 
	} 

}
