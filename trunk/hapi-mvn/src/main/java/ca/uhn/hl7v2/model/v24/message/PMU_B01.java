package ca.uhn.hl7v2.model.v24.message;

import ca.uhn.log.HapiLogFactory;
import ca.uhn.hl7v2.model.v24.group.*;

import ca.uhn.hl7v2.model.v24.segment.*;

import ca.uhn.hl7v2.HL7Exception;

import ca.uhn.hl7v2.parser.ModelClassFactory;

import ca.uhn.hl7v2.parser.DefaultModelClassFactory;

import ca.uhn.hl7v2.model.AbstractMessage;

/**
 * <p>Represents a PMU_B01 message structure (see chapter 15). This structure contains the 
 * following elements: </p>
 * 0: MSH (Message Header) <b></b><br>
 * 1: EVN (Event Type) <b></b><br>
 * 2: STF (Staff Identification) <b></b><br>
 * 3: PRA (Practitioner Detail) <b>optional repeating</b><br>
 * 4: ORG (Practitioner Organization Unit) <b>optional repeating</b><br>
 * 5: AFF (Professional Affiliation) <b>optional repeating</b><br>
 * 6: LAN (Language Detail) <b>optional repeating</b><br>
 * 7: EDU (Educational Detail) <b>optional repeating</b><br>
 */
public class PMU_B01 extends AbstractMessage  {

	/** 
	 * Creates a new PMU_B01 Group with custom ModelClassFactory.
	 */
	public PMU_B01(ModelClassFactory factory) {
	   super(factory);
	   init(factory);
	}

	/**
	 * Creates a new PMU_B01 Group with DefaultModelClassFactory. 
	 */ 
	public PMU_B01() { 
	   super(new DefaultModelClassFactory());
	   init(new DefaultModelClassFactory());
	}

	private void init(ModelClassFactory factory) {
	   try {
	      this.add(MSH.class, true, false);
	      this.add(EVN.class, true, false);
	      this.add(STF.class, true, false);
	      this.add(PRA.class, false, true);
	      this.add(ORG.class, false, true);
	      this.add(AFF.class, false, true);
	      this.add(LAN.class, false, true);
	      this.add(EDU.class, false, true);
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error creating PMU_B01 - this is probably a bug in the source code generator.", e);
	   }
	}

	/**
	 * Returns MSH (Message Header) - creates it if necessary
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
	 * Returns EVN (Event Type) - creates it if necessary
	 */
	public EVN getEVN() { 
	   EVN ret = null;
	   try {
	      ret = (EVN)this.get("EVN");
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

}
