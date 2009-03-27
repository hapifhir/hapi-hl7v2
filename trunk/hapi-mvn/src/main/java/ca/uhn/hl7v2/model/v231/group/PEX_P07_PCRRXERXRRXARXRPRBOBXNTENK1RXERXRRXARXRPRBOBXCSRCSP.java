package ca.uhn.hl7v2.model.v231.group;

import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.log.HapiLogFactory;
import ca.uhn.hl7v2.model.v231.segment.*;

import ca.uhn.hl7v2.model.*;
/**
 * <p>Represents the PEX_P07_PCRRXERXRRXARXRPRBOBXNTENK1RXERXRRXARXRPRBOBXCSRCSP Group.  A Group is an ordered collection of message 
 * segments that can repeat together or be optionally in/excluded together.
 * This Group contains the following elements: </p>
 * 0: PCR (PCR - possible causal relationship segment) <b></b><br>
 * 1: PEX_P07_RXERXR (a Group object) <b>optional </b><br>
 * 2: PEX_P07_RXARXR (a Group object) <b>optional repeating</b><br>
 * 3: PRB (Problem Detail) <b>optional repeating</b><br>
 * 4: OBX (OBX - observation/result segment) <b>optional repeating</b><br>
 * 5: NTE (NTE - notes and comments segment) <b>optional repeating</b><br>
 * 6: PEX_P07_NK1RXERXRRXARXRPRBOBX (a Group object) <b>optional </b><br>
 * 7: PEX_P07_CSRCSP (a Group object) <b>optional repeating</b><br>
 */
public class PEX_P07_PCRRXERXRRXARXRPRBOBXNTENK1RXERXRRXARXRPRBOBXCSRCSP extends AbstractGroup {

	/** 
	 * Creates a new PEX_P07_PCRRXERXRRXARXRPRBOBXNTENK1RXERXRRXARXRPRBOBXCSRCSP Group.
	 */
	public PEX_P07_PCRRXERXRRXARXRPRBOBXNTENK1RXERXRRXARXRPRBOBXCSRCSP(Group parent, ModelClassFactory factory) {
	   super(parent, factory);
	   try {
	      this.add(PCR.class, true, false);
	      this.add(PEX_P07_RXERXR.class, false, false);
	      this.add(PEX_P07_RXARXR.class, false, true);
	      this.add(PRB.class, false, true);
	      this.add(OBX.class, false, true);
	      this.add(NTE.class, false, true);
	      this.add(PEX_P07_NK1RXERXRRXARXRPRBOBX.class, false, false);
	      this.add(PEX_P07_CSRCSP.class, false, true);
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error creating PEX_P07_PCRRXERXRRXARXRPRBOBXNTENK1RXERXRRXARXRPRBOBXCSRCSP - this is probably a bug in the source code generator.", e);
	   }
	}

	/**
	 * Returns PCR (PCR - possible causal relationship segment) - creates it if necessary
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
	 * Returns PEX_P07_RXERXR (a Group object) - creates it if necessary
	 */
	public PEX_P07_RXERXR getRXERXR() { 
	   PEX_P07_RXERXR ret = null;
	   try {
	      ret = (PEX_P07_RXERXR)this.get("RXERXR");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns  first repetition of PEX_P07_RXARXR (a Group object) - creates it if necessary
	 */
	public PEX_P07_RXARXR getRXARXR() { 
	   PEX_P07_RXARXR ret = null;
	   try {
	      ret = (PEX_P07_RXARXR)this.get("RXARXR");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns a specific repetition of PEX_P07_RXARXR
	 * (a Group object) - creates it if necessary
	 * throws HL7Exception if the repetition requested is more than one 
	 *     greater than the number of existing repetitions.
	 */
	public PEX_P07_RXARXR getRXARXR(int rep) throws HL7Exception { 
	   return (PEX_P07_RXARXR)this.get("RXARXR", rep);
	}

	/** 
	 * Returns the number of existing repetitions of PEX_P07_RXARXR 
	 */ 
	public int getRXARXRReps() { 
	    int reps = -1; 
	    try { 
	        reps = this.getAll("RXARXR").length; 
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
	 * Returns  first repetition of OBX (OBX - observation/result segment) - creates it if necessary
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
	 * (OBX - observation/result segment) - creates it if necessary
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
	 * Returns PEX_P07_NK1RXERXRRXARXRPRBOBX (a Group object) - creates it if necessary
	 */
	public PEX_P07_NK1RXERXRRXARXRPRBOBX getNK1RXERXRRXARXRPRBOBX() { 
	   PEX_P07_NK1RXERXRRXARXRPRBOBX ret = null;
	   try {
	      ret = (PEX_P07_NK1RXERXRRXARXRPRBOBX)this.get("NK1RXERXRRXARXRPRBOBX");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns  first repetition of PEX_P07_CSRCSP (a Group object) - creates it if necessary
	 */
	public PEX_P07_CSRCSP getCSRCSP() { 
	   PEX_P07_CSRCSP ret = null;
	   try {
	      ret = (PEX_P07_CSRCSP)this.get("CSRCSP");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns a specific repetition of PEX_P07_CSRCSP
	 * (a Group object) - creates it if necessary
	 * throws HL7Exception if the repetition requested is more than one 
	 *     greater than the number of existing repetitions.
	 */
	public PEX_P07_CSRCSP getCSRCSP(int rep) throws HL7Exception { 
	   return (PEX_P07_CSRCSP)this.get("CSRCSP", rep);
	}

	/** 
	 * Returns the number of existing repetitions of PEX_P07_CSRCSP 
	 */ 
	public int getCSRCSPReps() { 
	    int reps = -1; 
	    try { 
	        reps = this.getAll("CSRCSP").length; 
	    } catch (HL7Exception e) { 
	        String message = "Unexpected error accessing data - this is probably a bug in the source code generator."; 
	        HapiLogFactory.getHapiLog(this.getClass()).error(message, e); 
	        throw new RuntimeException(message);
	    } 
	    return reps; 
	} 

}
