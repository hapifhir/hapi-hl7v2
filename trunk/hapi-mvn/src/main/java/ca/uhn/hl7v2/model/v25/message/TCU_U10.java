package ca.uhn.hl7v2.model.v25.message;

import ca.uhn.log.HapiLogFactory;
import ca.uhn.hl7v2.model.v25.group.*;

import ca.uhn.hl7v2.model.v25.segment.*;

import ca.uhn.hl7v2.HL7Exception;

import ca.uhn.hl7v2.parser.ModelClassFactory;

import ca.uhn.hl7v2.parser.DefaultModelClassFactory;

import ca.uhn.hl7v2.model.AbstractMessage;

/**
 * <p>Represents a TCU_U10 message structure (see chapter 13.3.10). This structure contains the 
 * following elements: </p>
 * 0: MSH (Message Header) <b></b><br>
 * 1: SFT (Software Segment) <b>optional repeating</b><br>
 * 2: EQU (Equipment Detail) <b></b><br>
 * 3: TCU_U10_TEST_CONFIGURATION (a Group object) <b>repeating</b><br>
 * 4: ROL (Role) <b>optional </b><br>
 */
public class TCU_U10 extends AbstractMessage  {

	/** 
	 * Creates a new TCU_U10 Group with custom ModelClassFactory.
	 */
	public TCU_U10(ModelClassFactory factory) {
	   super(factory);
	   init(factory);
	}

	/**
	 * Creates a new TCU_U10 Group with DefaultModelClassFactory. 
	 */ 
	public TCU_U10() { 
	   super(new DefaultModelClassFactory());
	   init(new DefaultModelClassFactory());
	}

	private void init(ModelClassFactory factory) {
	   try {
	      this.add(MSH.class, true, false);
	      this.add(SFT.class, false, true);
	      this.add(EQU.class, true, false);
	      this.add(TCU_U10_TEST_CONFIGURATION.class, true, true);
	      this.add(ROL.class, false, false);
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error creating TCU_U10 - this is probably a bug in the source code generator.", e);
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
	 * Returns  first repetition of SFT (Software Segment) - creates it if necessary
	 */
	public SFT getSFT() { 
	   SFT ret = null;
	   try {
	      ret = (SFT)this.get("SFT");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns a specific repetition of SFT
	 * (Software Segment) - creates it if necessary
	 * throws HL7Exception if the repetition requested is more than one 
	 *     greater than the number of existing repetitions.
	 */
	public SFT getSFT(int rep) throws HL7Exception { 
	   return (SFT)this.get("SFT", rep);
	}

	/** 
	 * Returns the number of existing repetitions of SFT 
	 */ 
	public int getSFTReps() { 
	    int reps = -1; 
	    try { 
	        reps = this.getAll("SFT").length; 
	    } catch (HL7Exception e) { 
	        String message = "Unexpected error accessing data - this is probably a bug in the source code generator."; 
	        HapiLogFactory.getHapiLog(this.getClass()).error(message, e); 
	        throw new RuntimeException(message);
	    } 
	    return reps; 
	} 

	/**
	 * Returns EQU (Equipment Detail) - creates it if necessary
	 */
	public EQU getEQU() { 
	   EQU ret = null;
	   try {
	      ret = (EQU)this.get("EQU");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns  first repetition of TCU_U10_TEST_CONFIGURATION (a Group object) - creates it if necessary
	 */
	public TCU_U10_TEST_CONFIGURATION getTEST_CONFIGURATION() { 
	   TCU_U10_TEST_CONFIGURATION ret = null;
	   try {
	      ret = (TCU_U10_TEST_CONFIGURATION)this.get("TEST_CONFIGURATION");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns a specific repetition of TCU_U10_TEST_CONFIGURATION
	 * (a Group object) - creates it if necessary
	 * throws HL7Exception if the repetition requested is more than one 
	 *     greater than the number of existing repetitions.
	 */
	public TCU_U10_TEST_CONFIGURATION getTEST_CONFIGURATION(int rep) throws HL7Exception { 
	   return (TCU_U10_TEST_CONFIGURATION)this.get("TEST_CONFIGURATION", rep);
	}

	/** 
	 * Returns the number of existing repetitions of TCU_U10_TEST_CONFIGURATION 
	 */ 
	public int getTEST_CONFIGURATIONReps() { 
	    int reps = -1; 
	    try { 
	        reps = this.getAll("TEST_CONFIGURATION").length; 
	    } catch (HL7Exception e) { 
	        String message = "Unexpected error accessing data - this is probably a bug in the source code generator."; 
	        HapiLogFactory.getHapiLog(this.getClass()).error(message, e); 
	        throw new RuntimeException(message);
	    } 
	    return reps; 
	} 

	/**
	 * Returns ROL (Role) - creates it if necessary
	 */
	public ROL getROL() { 
	   ROL ret = null;
	   try {
	      ret = (ROL)this.get("ROL");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

}
