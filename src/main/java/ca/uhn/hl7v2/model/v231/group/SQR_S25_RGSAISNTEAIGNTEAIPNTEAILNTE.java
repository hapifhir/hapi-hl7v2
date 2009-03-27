package ca.uhn.hl7v2.model.v231.group;

import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.log.HapiLogFactory;
import ca.uhn.hl7v2.model.v231.segment.*;

import ca.uhn.hl7v2.model.*;
/**
 * <p>Represents the SQR_S25_RGSAISNTEAIGNTEAIPNTEAILNTE Group.  A Group is an ordered collection of message 
 * segments that can repeat together or be optionally in/excluded together.
 * This Group contains the following elements: </p>
 * 0: RGS (RGS - resource group segment) <b></b><br>
 * 1: SQR_S25_AISNTE (a Group object) <b>optional repeating</b><br>
 * 2: SQR_S25_AIGNTE (a Group object) <b>optional repeating</b><br>
 * 3: SQR_S25_AIPNTE (a Group object) <b>optional repeating</b><br>
 * 4: SQR_S25_AILNTE (a Group object) <b>optional repeating</b><br>
 */
public class SQR_S25_RGSAISNTEAIGNTEAIPNTEAILNTE extends AbstractGroup {

	/** 
	 * Creates a new SQR_S25_RGSAISNTEAIGNTEAIPNTEAILNTE Group.
	 */
	public SQR_S25_RGSAISNTEAIGNTEAIPNTEAILNTE(Group parent, ModelClassFactory factory) {
	   super(parent, factory);
	   try {
	      this.add(RGS.class, true, false);
	      this.add(SQR_S25_AISNTE.class, false, true);
	      this.add(SQR_S25_AIGNTE.class, false, true);
	      this.add(SQR_S25_AIPNTE.class, false, true);
	      this.add(SQR_S25_AILNTE.class, false, true);
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error creating SQR_S25_RGSAISNTEAIGNTEAIPNTEAILNTE - this is probably a bug in the source code generator.", e);
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
	 * Returns  first repetition of SQR_S25_AISNTE (a Group object) - creates it if necessary
	 */
	public SQR_S25_AISNTE getAISNTE() { 
	   SQR_S25_AISNTE ret = null;
	   try {
	      ret = (SQR_S25_AISNTE)this.get("AISNTE");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns a specific repetition of SQR_S25_AISNTE
	 * (a Group object) - creates it if necessary
	 * throws HL7Exception if the repetition requested is more than one 
	 *     greater than the number of existing repetitions.
	 */
	public SQR_S25_AISNTE getAISNTE(int rep) throws HL7Exception { 
	   return (SQR_S25_AISNTE)this.get("AISNTE", rep);
	}

	/** 
	 * Returns the number of existing repetitions of SQR_S25_AISNTE 
	 */ 
	public int getAISNTEReps() { 
	    int reps = -1; 
	    try { 
	        reps = this.getAll("AISNTE").length; 
	    } catch (HL7Exception e) { 
	        String message = "Unexpected error accessing data - this is probably a bug in the source code generator."; 
	        HapiLogFactory.getHapiLog(this.getClass()).error(message, e); 
	        throw new RuntimeException(message);
	    } 
	    return reps; 
	} 

	/**
	 * Returns  first repetition of SQR_S25_AIGNTE (a Group object) - creates it if necessary
	 */
	public SQR_S25_AIGNTE getAIGNTE() { 
	   SQR_S25_AIGNTE ret = null;
	   try {
	      ret = (SQR_S25_AIGNTE)this.get("AIGNTE");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns a specific repetition of SQR_S25_AIGNTE
	 * (a Group object) - creates it if necessary
	 * throws HL7Exception if the repetition requested is more than one 
	 *     greater than the number of existing repetitions.
	 */
	public SQR_S25_AIGNTE getAIGNTE(int rep) throws HL7Exception { 
	   return (SQR_S25_AIGNTE)this.get("AIGNTE", rep);
	}

	/** 
	 * Returns the number of existing repetitions of SQR_S25_AIGNTE 
	 */ 
	public int getAIGNTEReps() { 
	    int reps = -1; 
	    try { 
	        reps = this.getAll("AIGNTE").length; 
	    } catch (HL7Exception e) { 
	        String message = "Unexpected error accessing data - this is probably a bug in the source code generator."; 
	        HapiLogFactory.getHapiLog(this.getClass()).error(message, e); 
	        throw new RuntimeException(message);
	    } 
	    return reps; 
	} 

	/**
	 * Returns  first repetition of SQR_S25_AIPNTE (a Group object) - creates it if necessary
	 */
	public SQR_S25_AIPNTE getAIPNTE() { 
	   SQR_S25_AIPNTE ret = null;
	   try {
	      ret = (SQR_S25_AIPNTE)this.get("AIPNTE");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns a specific repetition of SQR_S25_AIPNTE
	 * (a Group object) - creates it if necessary
	 * throws HL7Exception if the repetition requested is more than one 
	 *     greater than the number of existing repetitions.
	 */
	public SQR_S25_AIPNTE getAIPNTE(int rep) throws HL7Exception { 
	   return (SQR_S25_AIPNTE)this.get("AIPNTE", rep);
	}

	/** 
	 * Returns the number of existing repetitions of SQR_S25_AIPNTE 
	 */ 
	public int getAIPNTEReps() { 
	    int reps = -1; 
	    try { 
	        reps = this.getAll("AIPNTE").length; 
	    } catch (HL7Exception e) { 
	        String message = "Unexpected error accessing data - this is probably a bug in the source code generator."; 
	        HapiLogFactory.getHapiLog(this.getClass()).error(message, e); 
	        throw new RuntimeException(message);
	    } 
	    return reps; 
	} 

	/**
	 * Returns  first repetition of SQR_S25_AILNTE (a Group object) - creates it if necessary
	 */
	public SQR_S25_AILNTE getAILNTE() { 
	   SQR_S25_AILNTE ret = null;
	   try {
	      ret = (SQR_S25_AILNTE)this.get("AILNTE");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns a specific repetition of SQR_S25_AILNTE
	 * (a Group object) - creates it if necessary
	 * throws HL7Exception if the repetition requested is more than one 
	 *     greater than the number of existing repetitions.
	 */
	public SQR_S25_AILNTE getAILNTE(int rep) throws HL7Exception { 
	   return (SQR_S25_AILNTE)this.get("AILNTE", rep);
	}

	/** 
	 * Returns the number of existing repetitions of SQR_S25_AILNTE 
	 */ 
	public int getAILNTEReps() { 
	    int reps = -1; 
	    try { 
	        reps = this.getAll("AILNTE").length; 
	    } catch (HL7Exception e) { 
	        String message = "Unexpected error accessing data - this is probably a bug in the source code generator."; 
	        HapiLogFactory.getHapiLog(this.getClass()).error(message, e); 
	        throw new RuntimeException(message);
	    } 
	    return reps; 
	} 

}
