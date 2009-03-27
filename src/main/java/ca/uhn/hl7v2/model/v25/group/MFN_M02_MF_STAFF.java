package ca.uhn.hl7v2.model.v25.group;

import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.log.HapiLogFactory;
import ca.uhn.hl7v2.model.v25.segment.*;

import ca.uhn.hl7v2.model.*;
/**
 * <p>Represents the MFN_M02_MF_STAFF Group.  A Group is an ordered collection of message 
 * segments that can repeat together or be optionally in/excluded together.
 * This Group contains the following elements: </p>
 * 0: MFE (Master File Entry) <b></b><br>
 * 1: STF (Staff Identification) <b></b><br>
 * 2: PRA (Practitioner Detail) <b>optional repeating</b><br>
 * 3: ORG (Practitioner Organization Unit) <b>optional repeating</b><br>
 * 4: AFF (Professional Affiliation) <b>optional repeating</b><br>
 * 5: LAN (Language Detail) <b>optional repeating</b><br>
 * 6: EDU (Educational Detail) <b>optional repeating</b><br>
 * 7: CER (Certificate Detail) <b>optional repeating</b><br>
 * 8: NTE (Notes and Comments) <b>optional repeating</b><br>
 */
public class MFN_M02_MF_STAFF extends AbstractGroup {

	/** 
	 * Creates a new MFN_M02_MF_STAFF Group.
	 */
	public MFN_M02_MF_STAFF(Group parent, ModelClassFactory factory) {
	   super(parent, factory);
	   try {
	      this.add(MFE.class, true, false);
	      this.add(STF.class, true, false);
	      this.add(PRA.class, false, true);
	      this.add(ORG.class, false, true);
	      this.add(AFF.class, false, true);
	      this.add(LAN.class, false, true);
	      this.add(EDU.class, false, true);
	      this.add(CER.class, false, true);
	      this.add(NTE.class, false, true);
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error creating MFN_M02_MF_STAFF - this is probably a bug in the source code generator.", e);
	   }
	}

	/**
	 * Returns MFE (Master File Entry) - creates it if necessary
	 */
	public MFE getMFE() { 
	   MFE ret = null;
	   try {
	      ret = (MFE)this.get("MFE");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns STF (Staff Identification) - creates it if necessary
	 */
	public STF getSTF() { 
	   STF ret = null;
	   try {
	      ret = (STF)this.get("STF");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns  first repetition of PRA (Practitioner Detail) - creates it if necessary
	 */
	public PRA getPRA() { 
	   PRA ret = null;
	   try {
	      ret = (PRA)this.get("PRA");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns a specific repetition of PRA
	 * (Practitioner Detail) - creates it if necessary
	 * throws HL7Exception if the repetition requested is more than one 
	 *     greater than the number of existing repetitions.
	 */
	public PRA getPRA(int rep) throws HL7Exception { 
	   return (PRA)this.get("PRA", rep);
	}

	/** 
	 * Returns the number of existing repetitions of PRA 
	 */ 
	public int getPRAReps() { 
	    int reps = -1; 
	    try { 
	        reps = this.getAll("PRA").length; 
	    } catch (HL7Exception e) { 
	        String message = "Unexpected error accessing data - this is probably a bug in the source code generator."; 
	        HapiLogFactory.getHapiLog(this.getClass()).error(message, e); 
	        throw new RuntimeException(message);
	    } 
	    return reps; 
	} 

	/**
	 * Returns  first repetition of ORG (Practitioner Organization Unit) - creates it if necessary
	 */
	public ORG getORG() { 
	   ORG ret = null;
	   try {
	      ret = (ORG)this.get("ORG");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns a specific repetition of ORG
	 * (Practitioner Organization Unit) - creates it if necessary
	 * throws HL7Exception if the repetition requested is more than one 
	 *     greater than the number of existing repetitions.
	 */
	public ORG getORG(int rep) throws HL7Exception { 
	   return (ORG)this.get("ORG", rep);
	}

	/** 
	 * Returns the number of existing repetitions of ORG 
	 */ 
	public int getORGReps() { 
	    int reps = -1; 
	    try { 
	        reps = this.getAll("ORG").length; 
	    } catch (HL7Exception e) { 
	        String message = "Unexpected error accessing data - this is probably a bug in the source code generator."; 
	        HapiLogFactory.getHapiLog(this.getClass()).error(message, e); 
	        throw new RuntimeException(message);
	    } 
	    return reps; 
	} 

	/**
	 * Returns  first repetition of AFF (Professional Affiliation) - creates it if necessary
	 */
	public AFF getAFF() { 
	   AFF ret = null;
	   try {
	      ret = (AFF)this.get("AFF");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns a specific repetition of AFF
	 * (Professional Affiliation) - creates it if necessary
	 * throws HL7Exception if the repetition requested is more than one 
	 *     greater than the number of existing repetitions.
	 */
	public AFF getAFF(int rep) throws HL7Exception { 
	   return (AFF)this.get("AFF", rep);
	}

	/** 
	 * Returns the number of existing repetitions of AFF 
	 */ 
	public int getAFFReps() { 
	    int reps = -1; 
	    try { 
	        reps = this.getAll("AFF").length; 
	    } catch (HL7Exception e) { 
	        String message = "Unexpected error accessing data - this is probably a bug in the source code generator."; 
	        HapiLogFactory.getHapiLog(this.getClass()).error(message, e); 
	        throw new RuntimeException(message);
	    } 
	    return reps; 
	} 

	/**
	 * Returns  first repetition of LAN (Language Detail) - creates it if necessary
	 */
	public LAN getLAN() { 
	   LAN ret = null;
	   try {
	      ret = (LAN)this.get("LAN");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns a specific repetition of LAN
	 * (Language Detail) - creates it if necessary
	 * throws HL7Exception if the repetition requested is more than one 
	 *     greater than the number of existing repetitions.
	 */
	public LAN getLAN(int rep) throws HL7Exception { 
	   return (LAN)this.get("LAN", rep);
	}

	/** 
	 * Returns the number of existing repetitions of LAN 
	 */ 
	public int getLANReps() { 
	    int reps = -1; 
	    try { 
	        reps = this.getAll("LAN").length; 
	    } catch (HL7Exception e) { 
	        String message = "Unexpected error accessing data - this is probably a bug in the source code generator."; 
	        HapiLogFactory.getHapiLog(this.getClass()).error(message, e); 
	        throw new RuntimeException(message);
	    } 
	    return reps; 
	} 

	/**
	 * Returns  first repetition of EDU (Educational Detail) - creates it if necessary
	 */
	public EDU getEDU() { 
	   EDU ret = null;
	   try {
	      ret = (EDU)this.get("EDU");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns a specific repetition of EDU
	 * (Educational Detail) - creates it if necessary
	 * throws HL7Exception if the repetition requested is more than one 
	 *     greater than the number of existing repetitions.
	 */
	public EDU getEDU(int rep) throws HL7Exception { 
	   return (EDU)this.get("EDU", rep);
	}

	/** 
	 * Returns the number of existing repetitions of EDU 
	 */ 
	public int getEDUReps() { 
	    int reps = -1; 
	    try { 
	        reps = this.getAll("EDU").length; 
	    } catch (HL7Exception e) { 
	        String message = "Unexpected error accessing data - this is probably a bug in the source code generator."; 
	        HapiLogFactory.getHapiLog(this.getClass()).error(message, e); 
	        throw new RuntimeException(message);
	    } 
	    return reps; 
	} 

	/**
	 * Returns  first repetition of CER (Certificate Detail) - creates it if necessary
	 */
	public CER getCER() { 
	   CER ret = null;
	   try {
	      ret = (CER)this.get("CER");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns a specific repetition of CER
	 * (Certificate Detail) - creates it if necessary
	 * throws HL7Exception if the repetition requested is more than one 
	 *     greater than the number of existing repetitions.
	 */
	public CER getCER(int rep) throws HL7Exception { 
	   return (CER)this.get("CER", rep);
	}

	/** 
	 * Returns the number of existing repetitions of CER 
	 */ 
	public int getCERReps() { 
	    int reps = -1; 
	    try { 
	        reps = this.getAll("CER").length; 
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

}
