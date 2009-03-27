package ca.uhn.hl7v2.model.v231.group;

import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.log.HapiLogFactory;
import ca.uhn.hl7v2.model.v231.segment.*;

import ca.uhn.hl7v2.model.*;
/**
 * <p>Represents the SQM_S25_RGSAISAPRAIGAPRAIPAPRAILAPR Group.  A Group is an ordered collection of message 
 * segments that can repeat together or be optionally in/excluded together.
 * This Group contains the following elements: </p>
 * 0: RGS (RGS - resource group segment) <b></b><br>
 * 1: SQM_S25_AISAPR (a Group object) <b>optional repeating</b><br>
 * 2: SQM_S25_AIGAPR (a Group object) <b>optional repeating</b><br>
 * 3: SQM_S25_AIPAPR (a Group object) <b>optional repeating</b><br>
 * 4: SQM_S25_AILAPR (a Group object) <b>optional repeating</b><br>
 */
public class SQM_S25_RGSAISAPRAIGAPRAIPAPRAILAPR extends AbstractGroup {

	/** 
	 * Creates a new SQM_S25_RGSAISAPRAIGAPRAIPAPRAILAPR Group.
	 */
	public SQM_S25_RGSAISAPRAIGAPRAIPAPRAILAPR(Group parent, ModelClassFactory factory) {
	   super(parent, factory);
	   try {
	      this.add(RGS.class, true, false);
	      this.add(SQM_S25_AISAPR.class, false, true);
	      this.add(SQM_S25_AIGAPR.class, false, true);
	      this.add(SQM_S25_AIPAPR.class, false, true);
	      this.add(SQM_S25_AILAPR.class, false, true);
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error creating SQM_S25_RGSAISAPRAIGAPRAIPAPRAILAPR - this is probably a bug in the source code generator.", e);
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
	 * Returns  first repetition of SQM_S25_AISAPR (a Group object) - creates it if necessary
	 */
	public SQM_S25_AISAPR getAISAPR() { 
	   SQM_S25_AISAPR ret = null;
	   try {
	      ret = (SQM_S25_AISAPR)this.get("AISAPR");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns a specific repetition of SQM_S25_AISAPR
	 * (a Group object) - creates it if necessary
	 * throws HL7Exception if the repetition requested is more than one 
	 *     greater than the number of existing repetitions.
	 */
	public SQM_S25_AISAPR getAISAPR(int rep) throws HL7Exception { 
	   return (SQM_S25_AISAPR)this.get("AISAPR", rep);
	}

	/** 
	 * Returns the number of existing repetitions of SQM_S25_AISAPR 
	 */ 
	public int getAISAPRReps() { 
	    int reps = -1; 
	    try { 
	        reps = this.getAll("AISAPR").length; 
	    } catch (HL7Exception e) { 
	        String message = "Unexpected error accessing data - this is probably a bug in the source code generator."; 
	        HapiLogFactory.getHapiLog(this.getClass()).error(message, e); 
	        throw new RuntimeException(message);
	    } 
	    return reps; 
	} 

	/**
	 * Returns  first repetition of SQM_S25_AIGAPR (a Group object) - creates it if necessary
	 */
	public SQM_S25_AIGAPR getAIGAPR() { 
	   SQM_S25_AIGAPR ret = null;
	   try {
	      ret = (SQM_S25_AIGAPR)this.get("AIGAPR");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns a specific repetition of SQM_S25_AIGAPR
	 * (a Group object) - creates it if necessary
	 * throws HL7Exception if the repetition requested is more than one 
	 *     greater than the number of existing repetitions.
	 */
	public SQM_S25_AIGAPR getAIGAPR(int rep) throws HL7Exception { 
	   return (SQM_S25_AIGAPR)this.get("AIGAPR", rep);
	}

	/** 
	 * Returns the number of existing repetitions of SQM_S25_AIGAPR 
	 */ 
	public int getAIGAPRReps() { 
	    int reps = -1; 
	    try { 
	        reps = this.getAll("AIGAPR").length; 
	    } catch (HL7Exception e) { 
	        String message = "Unexpected error accessing data - this is probably a bug in the source code generator."; 
	        HapiLogFactory.getHapiLog(this.getClass()).error(message, e); 
	        throw new RuntimeException(message);
	    } 
	    return reps; 
	} 

	/**
	 * Returns  first repetition of SQM_S25_AIPAPR (a Group object) - creates it if necessary
	 */
	public SQM_S25_AIPAPR getAIPAPR() { 
	   SQM_S25_AIPAPR ret = null;
	   try {
	      ret = (SQM_S25_AIPAPR)this.get("AIPAPR");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns a specific repetition of SQM_S25_AIPAPR
	 * (a Group object) - creates it if necessary
	 * throws HL7Exception if the repetition requested is more than one 
	 *     greater than the number of existing repetitions.
	 */
	public SQM_S25_AIPAPR getAIPAPR(int rep) throws HL7Exception { 
	   return (SQM_S25_AIPAPR)this.get("AIPAPR", rep);
	}

	/** 
	 * Returns the number of existing repetitions of SQM_S25_AIPAPR 
	 */ 
	public int getAIPAPRReps() { 
	    int reps = -1; 
	    try { 
	        reps = this.getAll("AIPAPR").length; 
	    } catch (HL7Exception e) { 
	        String message = "Unexpected error accessing data - this is probably a bug in the source code generator."; 
	        HapiLogFactory.getHapiLog(this.getClass()).error(message, e); 
	        throw new RuntimeException(message);
	    } 
	    return reps; 
	} 

	/**
	 * Returns  first repetition of SQM_S25_AILAPR (a Group object) - creates it if necessary
	 */
	public SQM_S25_AILAPR getAILAPR() { 
	   SQM_S25_AILAPR ret = null;
	   try {
	      ret = (SQM_S25_AILAPR)this.get("AILAPR");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns a specific repetition of SQM_S25_AILAPR
	 * (a Group object) - creates it if necessary
	 * throws HL7Exception if the repetition requested is more than one 
	 *     greater than the number of existing repetitions.
	 */
	public SQM_S25_AILAPR getAILAPR(int rep) throws HL7Exception { 
	   return (SQM_S25_AILAPR)this.get("AILAPR", rep);
	}

	/** 
	 * Returns the number of existing repetitions of SQM_S25_AILAPR 
	 */ 
	public int getAILAPRReps() { 
	    int reps = -1; 
	    try { 
	        reps = this.getAll("AILAPR").length; 
	    } catch (HL7Exception e) { 
	        String message = "Unexpected error accessing data - this is probably a bug in the source code generator."; 
	        HapiLogFactory.getHapiLog(this.getClass()).error(message, e); 
	        throw new RuntimeException(message);
	    } 
	    return reps; 
	} 

}
