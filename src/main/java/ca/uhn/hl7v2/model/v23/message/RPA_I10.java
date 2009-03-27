package ca.uhn.hl7v2.model.v23.message;

import ca.uhn.log.HapiLogFactory;
import ca.uhn.hl7v2.model.v23.group.*;

import ca.uhn.hl7v2.model.v23.segment.*;

import ca.uhn.hl7v2.HL7Exception;

import ca.uhn.hl7v2.parser.ModelClassFactory;

import ca.uhn.hl7v2.parser.DefaultModelClassFactory;

import ca.uhn.hl7v2.model.AbstractMessage;

/**
 * <p>Represents a RPA_I10 message structure (see chapter ?). This structure contains the 
 * following elements: </p>
 * 0: MSH (Message header segment) <b></b><br>
 * 1: MSA (Message acknowledgement segment) <b></b><br>
 * 2: RF1 (Referral Information Segment) <b>optional </b><br>
 * 3: RPA_I10_AUTHORIZATION (a Group object) <b>optional </b><br>
 * 4: RPA_I10_PROVIDER (a Group object) <b>repeating</b><br>
 * 5: PID (Patient Identification) <b></b><br>
 * 6: NK1 (Next of kin) <b>optional repeating</b><br>
 * 7: GT1 (Guarantor) <b>optional repeating</b><br>
 * 8: RPA_I10_INSURANCE (a Group object) <b>optional repeating</b><br>
 * 9: ACC (Accident) <b>optional </b><br>
 * 10: DG1 (Diagnosis) <b>optional repeating</b><br>
 * 11: DRG (Diagnosis Related Group) <b>optional repeating</b><br>
 * 12: AL1 (Patient allergy information) <b>optional repeating</b><br>
 * 13: RPA_I10_PROCEDURE (a Group object) <b>repeating</b><br>
 * 14: RPA_I10_RESULTS (a Group object) <b>optional repeating</b><br>
 * 15: RPA_I10_VISIT (a Group object) <b>optional </b><br>
 */
public class RPA_I10 extends AbstractMessage  {

	/** 
	 * Creates a new RPA_I10 Group with custom ModelClassFactory.
	 */
	public RPA_I10(ModelClassFactory factory) {
	   super(factory);
	   init(factory);
	}

	/**
	 * Creates a new RPA_I10 Group with DefaultModelClassFactory. 
	 */ 
	public RPA_I10() { 
	   super(new DefaultModelClassFactory());
	   init(new DefaultModelClassFactory());
	}

	private void init(ModelClassFactory factory) {
	   try {
	      this.add(MSH.class, true, false);
	      this.add(MSA.class, true, false);
	      this.add(RF1.class, false, false);
	      this.add(RPA_I10_AUTHORIZATION.class, false, false);
	      this.add(RPA_I10_PROVIDER.class, true, true);
	      this.add(PID.class, true, false);
	      this.add(NK1.class, false, true);
	      this.add(GT1.class, false, true);
	      this.add(RPA_I10_INSURANCE.class, false, true);
	      this.add(ACC.class, false, false);
	      this.add(DG1.class, false, true);
	      this.add(DRG.class, false, true);
	      this.add(AL1.class, false, true);
	      this.add(RPA_I10_PROCEDURE.class, true, true);
	      this.add(RPA_I10_RESULTS.class, false, true);
	      this.add(RPA_I10_VISIT.class, false, false);
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error creating RPA_I10 - this is probably a bug in the source code generator.", e);
	   }
	}

	/**
	 * Returns MSH (Message header segment) - creates it if necessary
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
	 * Returns MSA (Message acknowledgement segment) - creates it if necessary
	 */
	public MSA getMSA() { 
	   MSA ret = null;
	   try {
	      ret = (MSA)this.get("MSA");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns RF1 (Referral Information Segment) - creates it if necessary
	 */
	public RF1 getRF1() { 
	   RF1 ret = null;
	   try {
	      ret = (RF1)this.get("RF1");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns RPA_I10_AUTHORIZATION (a Group object) - creates it if necessary
	 */
	public RPA_I10_AUTHORIZATION getAUTHORIZATION() { 
	   RPA_I10_AUTHORIZATION ret = null;
	   try {
	      ret = (RPA_I10_AUTHORIZATION)this.get("AUTHORIZATION");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns  first repetition of RPA_I10_PROVIDER (a Group object) - creates it if necessary
	 */
	public RPA_I10_PROVIDER getPROVIDER() { 
	   RPA_I10_PROVIDER ret = null;
	   try {
	      ret = (RPA_I10_PROVIDER)this.get("PROVIDER");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns a specific repetition of RPA_I10_PROVIDER
	 * (a Group object) - creates it if necessary
	 * throws HL7Exception if the repetition requested is more than one 
	 *     greater than the number of existing repetitions.
	 */
	public RPA_I10_PROVIDER getPROVIDER(int rep) throws HL7Exception { 
	   return (RPA_I10_PROVIDER)this.get("PROVIDER", rep);
	}

	/** 
	 * Returns the number of existing repetitions of RPA_I10_PROVIDER 
	 */ 
	public int getPROVIDERReps() { 
	    int reps = -1; 
	    try { 
	        reps = this.getAll("PROVIDER").length; 
	    } catch (HL7Exception e) { 
	        String message = "Unexpected error accessing data - this is probably a bug in the source code generator."; 
	        HapiLogFactory.getHapiLog(this.getClass()).error(message, e); 
	        throw new RuntimeException(message);
	    } 
	    return reps; 
	} 

	/**
	 * Returns PID (Patient Identification) - creates it if necessary
	 */
	public PID getPID() { 
	   PID ret = null;
	   try {
	      ret = (PID)this.get("PID");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns  first repetition of NK1 (Next of kin) - creates it if necessary
	 */
	public NK1 getNK1() { 
	   NK1 ret = null;
	   try {
	      ret = (NK1)this.get("NK1");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns a specific repetition of NK1
	 * (Next of kin) - creates it if necessary
	 * throws HL7Exception if the repetition requested is more than one 
	 *     greater than the number of existing repetitions.
	 */
	public NK1 getNK1(int rep) throws HL7Exception { 
	   return (NK1)this.get("NK1", rep);
	}

	/** 
	 * Returns the number of existing repetitions of NK1 
	 */ 
	public int getNK1Reps() { 
	    int reps = -1; 
	    try { 
	        reps = this.getAll("NK1").length; 
	    } catch (HL7Exception e) { 
	        String message = "Unexpected error accessing data - this is probably a bug in the source code generator."; 
	        HapiLogFactory.getHapiLog(this.getClass()).error(message, e); 
	        throw new RuntimeException(message);
	    } 
	    return reps; 
	} 

	/**
	 * Returns  first repetition of GT1 (Guarantor) - creates it if necessary
	 */
	public GT1 getGT1() { 
	   GT1 ret = null;
	   try {
	      ret = (GT1)this.get("GT1");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns a specific repetition of GT1
	 * (Guarantor) - creates it if necessary
	 * throws HL7Exception if the repetition requested is more than one 
	 *     greater than the number of existing repetitions.
	 */
	public GT1 getGT1(int rep) throws HL7Exception { 
	   return (GT1)this.get("GT1", rep);
	}

	/** 
	 * Returns the number of existing repetitions of GT1 
	 */ 
	public int getGT1Reps() { 
	    int reps = -1; 
	    try { 
	        reps = this.getAll("GT1").length; 
	    } catch (HL7Exception e) { 
	        String message = "Unexpected error accessing data - this is probably a bug in the source code generator."; 
	        HapiLogFactory.getHapiLog(this.getClass()).error(message, e); 
	        throw new RuntimeException(message);
	    } 
	    return reps; 
	} 

	/**
	 * Returns  first repetition of RPA_I10_INSURANCE (a Group object) - creates it if necessary
	 */
	public RPA_I10_INSURANCE getINSURANCE() { 
	   RPA_I10_INSURANCE ret = null;
	   try {
	      ret = (RPA_I10_INSURANCE)this.get("INSURANCE");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns a specific repetition of RPA_I10_INSURANCE
	 * (a Group object) - creates it if necessary
	 * throws HL7Exception if the repetition requested is more than one 
	 *     greater than the number of existing repetitions.
	 */
	public RPA_I10_INSURANCE getINSURANCE(int rep) throws HL7Exception { 
	   return (RPA_I10_INSURANCE)this.get("INSURANCE", rep);
	}

	/** 
	 * Returns the number of existing repetitions of RPA_I10_INSURANCE 
	 */ 
	public int getINSURANCEReps() { 
	    int reps = -1; 
	    try { 
	        reps = this.getAll("INSURANCE").length; 
	    } catch (HL7Exception e) { 
	        String message = "Unexpected error accessing data - this is probably a bug in the source code generator."; 
	        HapiLogFactory.getHapiLog(this.getClass()).error(message, e); 
	        throw new RuntimeException(message);
	    } 
	    return reps; 
	} 

	/**
	 * Returns ACC (Accident) - creates it if necessary
	 */
	public ACC getACC() { 
	   ACC ret = null;
	   try {
	      ret = (ACC)this.get("ACC");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns  first repetition of DG1 (Diagnosis) - creates it if necessary
	 */
	public DG1 getDG1() { 
	   DG1 ret = null;
	   try {
	      ret = (DG1)this.get("DG1");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns a specific repetition of DG1
	 * (Diagnosis) - creates it if necessary
	 * throws HL7Exception if the repetition requested is more than one 
	 *     greater than the number of existing repetitions.
	 */
	public DG1 getDG1(int rep) throws HL7Exception { 
	   return (DG1)this.get("DG1", rep);
	}

	/** 
	 * Returns the number of existing repetitions of DG1 
	 */ 
	public int getDG1Reps() { 
	    int reps = -1; 
	    try { 
	        reps = this.getAll("DG1").length; 
	    } catch (HL7Exception e) { 
	        String message = "Unexpected error accessing data - this is probably a bug in the source code generator."; 
	        HapiLogFactory.getHapiLog(this.getClass()).error(message, e); 
	        throw new RuntimeException(message);
	    } 
	    return reps; 
	} 

	/**
	 * Returns  first repetition of DRG (Diagnosis Related Group) - creates it if necessary
	 */
	public DRG getDRG() { 
	   DRG ret = null;
	   try {
	      ret = (DRG)this.get("DRG");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns a specific repetition of DRG
	 * (Diagnosis Related Group) - creates it if necessary
	 * throws HL7Exception if the repetition requested is more than one 
	 *     greater than the number of existing repetitions.
	 */
	public DRG getDRG(int rep) throws HL7Exception { 
	   return (DRG)this.get("DRG", rep);
	}

	/** 
	 * Returns the number of existing repetitions of DRG 
	 */ 
	public int getDRGReps() { 
	    int reps = -1; 
	    try { 
	        reps = this.getAll("DRG").length; 
	    } catch (HL7Exception e) { 
	        String message = "Unexpected error accessing data - this is probably a bug in the source code generator."; 
	        HapiLogFactory.getHapiLog(this.getClass()).error(message, e); 
	        throw new RuntimeException(message);
	    } 
	    return reps; 
	} 

	/**
	 * Returns  first repetition of AL1 (Patient allergy information) - creates it if necessary
	 */
	public AL1 getAL1() { 
	   AL1 ret = null;
	   try {
	      ret = (AL1)this.get("AL1");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns a specific repetition of AL1
	 * (Patient allergy information) - creates it if necessary
	 * throws HL7Exception if the repetition requested is more than one 
	 *     greater than the number of existing repetitions.
	 */
	public AL1 getAL1(int rep) throws HL7Exception { 
	   return (AL1)this.get("AL1", rep);
	}

	/** 
	 * Returns the number of existing repetitions of AL1 
	 */ 
	public int getAL1Reps() { 
	    int reps = -1; 
	    try { 
	        reps = this.getAll("AL1").length; 
	    } catch (HL7Exception e) { 
	        String message = "Unexpected error accessing data - this is probably a bug in the source code generator."; 
	        HapiLogFactory.getHapiLog(this.getClass()).error(message, e); 
	        throw new RuntimeException(message);
	    } 
	    return reps; 
	} 

	/**
	 * Returns  first repetition of RPA_I10_PROCEDURE (a Group object) - creates it if necessary
	 */
	public RPA_I10_PROCEDURE getPROCEDURE() { 
	   RPA_I10_PROCEDURE ret = null;
	   try {
	      ret = (RPA_I10_PROCEDURE)this.get("PROCEDURE");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns a specific repetition of RPA_I10_PROCEDURE
	 * (a Group object) - creates it if necessary
	 * throws HL7Exception if the repetition requested is more than one 
	 *     greater than the number of existing repetitions.
	 */
	public RPA_I10_PROCEDURE getPROCEDURE(int rep) throws HL7Exception { 
	   return (RPA_I10_PROCEDURE)this.get("PROCEDURE", rep);
	}

	/** 
	 * Returns the number of existing repetitions of RPA_I10_PROCEDURE 
	 */ 
	public int getPROCEDUREReps() { 
	    int reps = -1; 
	    try { 
	        reps = this.getAll("PROCEDURE").length; 
	    } catch (HL7Exception e) { 
	        String message = "Unexpected error accessing data - this is probably a bug in the source code generator."; 
	        HapiLogFactory.getHapiLog(this.getClass()).error(message, e); 
	        throw new RuntimeException(message);
	    } 
	    return reps; 
	} 

	/**
	 * Returns  first repetition of RPA_I10_RESULTS (a Group object) - creates it if necessary
	 */
	public RPA_I10_RESULTS getRESULTS() { 
	   RPA_I10_RESULTS ret = null;
	   try {
	      ret = (RPA_I10_RESULTS)this.get("RESULTS");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns a specific repetition of RPA_I10_RESULTS
	 * (a Group object) - creates it if necessary
	 * throws HL7Exception if the repetition requested is more than one 
	 *     greater than the number of existing repetitions.
	 */
	public RPA_I10_RESULTS getRESULTS(int rep) throws HL7Exception { 
	   return (RPA_I10_RESULTS)this.get("RESULTS", rep);
	}

	/** 
	 * Returns the number of existing repetitions of RPA_I10_RESULTS 
	 */ 
	public int getRESULTSReps() { 
	    int reps = -1; 
	    try { 
	        reps = this.getAll("RESULTS").length; 
	    } catch (HL7Exception e) { 
	        String message = "Unexpected error accessing data - this is probably a bug in the source code generator."; 
	        HapiLogFactory.getHapiLog(this.getClass()).error(message, e); 
	        throw new RuntimeException(message);
	    } 
	    return reps; 
	} 

	/**
	 * Returns RPA_I10_VISIT (a Group object) - creates it if necessary
	 */
	public RPA_I10_VISIT getVISIT() { 
	   RPA_I10_VISIT ret = null;
	   try {
	      ret = (RPA_I10_VISIT)this.get("VISIT");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

}
