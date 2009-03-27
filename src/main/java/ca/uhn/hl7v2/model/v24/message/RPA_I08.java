package ca.uhn.hl7v2.model.v24.message;

import ca.uhn.log.HapiLogFactory;
import ca.uhn.hl7v2.model.v24.group.*;

import ca.uhn.hl7v2.model.v24.segment.*;

import ca.uhn.hl7v2.HL7Exception;

import ca.uhn.hl7v2.parser.ModelClassFactory;

import ca.uhn.hl7v2.parser.DefaultModelClassFactory;

import ca.uhn.hl7v2.model.AbstractMessage;

/**
 * <p>Represents a RPA_I08 message structure (see chapter 11). This structure contains the 
 * following elements: </p>
 * 0: MSH (Message Header) <b></b><br>
 * 1: MSA (Message Acknowledgment) <b></b><br>
 * 2: RF1 (Referral Information) <b>optional </b><br>
 * 3: RPA_I08_AUTHORIZATION (a Group object) <b>optional </b><br>
 * 4: RPA_I08_PROVIDER (a Group object) <b>repeating</b><br>
 * 5: PID (Patient identification) <b></b><br>
 * 6: NK1 (Next of kin / associated parties) <b>optional repeating</b><br>
 * 7: GT1 (Guarantor) <b>optional repeating</b><br>
 * 8: RPA_I08_INSURANCE (a Group object) <b>optional repeating</b><br>
 * 9: ACC (Accident) <b>optional </b><br>
 * 10: DG1 (Diagnosis) <b>optional repeating</b><br>
 * 11: DRG (Diagnosis Related Group) <b>optional repeating</b><br>
 * 12: AL1 (Patient allergy information) <b>optional repeating</b><br>
 * 13: RPA_I08_PROCEDURE (a Group object) <b>repeating</b><br>
 * 14: RPA_I08_OBSERVATION (a Group object) <b>optional repeating</b><br>
 * 15: RPA_I08_VISIT (a Group object) <b>optional </b><br>
 * 16: NTE (Notes and Comments) <b>optional repeating</b><br>
 */
public class RPA_I08 extends AbstractMessage  {

	/** 
	 * Creates a new RPA_I08 Group with custom ModelClassFactory.
	 */
	public RPA_I08(ModelClassFactory factory) {
	   super(factory);
	   init(factory);
	}

	/**
	 * Creates a new RPA_I08 Group with DefaultModelClassFactory. 
	 */ 
	public RPA_I08() { 
	   super(new DefaultModelClassFactory());
	   init(new DefaultModelClassFactory());
	}

	private void init(ModelClassFactory factory) {
	   try {
	      this.add(MSH.class, true, false);
	      this.add(MSA.class, true, false);
	      this.add(RF1.class, false, false);
	      this.add(RPA_I08_AUTHORIZATION.class, false, false);
	      this.add(RPA_I08_PROVIDER.class, true, true);
	      this.add(PID.class, true, false);
	      this.add(NK1.class, false, true);
	      this.add(GT1.class, false, true);
	      this.add(RPA_I08_INSURANCE.class, false, true);
	      this.add(ACC.class, false, false);
	      this.add(DG1.class, false, true);
	      this.add(DRG.class, false, true);
	      this.add(AL1.class, false, true);
	      this.add(RPA_I08_PROCEDURE.class, true, true);
	      this.add(RPA_I08_OBSERVATION.class, false, true);
	      this.add(RPA_I08_VISIT.class, false, false);
	      this.add(NTE.class, false, true);
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error creating RPA_I08 - this is probably a bug in the source code generator.", e);
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
	 * Returns MSA (Message Acknowledgment) - creates it if necessary
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
	 * Returns RF1 (Referral Information) - creates it if necessary
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
	 * Returns RPA_I08_AUTHORIZATION (a Group object) - creates it if necessary
	 */
	public RPA_I08_AUTHORIZATION getAUTHORIZATION() { 
	   RPA_I08_AUTHORIZATION ret = null;
	   try {
	      ret = (RPA_I08_AUTHORIZATION)this.get("AUTHORIZATION");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns  first repetition of RPA_I08_PROVIDER (a Group object) - creates it if necessary
	 */
	public RPA_I08_PROVIDER getPROVIDER() { 
	   RPA_I08_PROVIDER ret = null;
	   try {
	      ret = (RPA_I08_PROVIDER)this.get("PROVIDER");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns a specific repetition of RPA_I08_PROVIDER
	 * (a Group object) - creates it if necessary
	 * throws HL7Exception if the repetition requested is more than one 
	 *     greater than the number of existing repetitions.
	 */
	public RPA_I08_PROVIDER getPROVIDER(int rep) throws HL7Exception { 
	   return (RPA_I08_PROVIDER)this.get("PROVIDER", rep);
	}

	/** 
	 * Returns the number of existing repetitions of RPA_I08_PROVIDER 
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
	 * Returns PID (Patient identification) - creates it if necessary
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
	 * Returns  first repetition of NK1 (Next of kin / associated parties) - creates it if necessary
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
	 * (Next of kin / associated parties) - creates it if necessary
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
	 * Returns  first repetition of RPA_I08_INSURANCE (a Group object) - creates it if necessary
	 */
	public RPA_I08_INSURANCE getINSURANCE() { 
	   RPA_I08_INSURANCE ret = null;
	   try {
	      ret = (RPA_I08_INSURANCE)this.get("INSURANCE");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns a specific repetition of RPA_I08_INSURANCE
	 * (a Group object) - creates it if necessary
	 * throws HL7Exception if the repetition requested is more than one 
	 *     greater than the number of existing repetitions.
	 */
	public RPA_I08_INSURANCE getINSURANCE(int rep) throws HL7Exception { 
	   return (RPA_I08_INSURANCE)this.get("INSURANCE", rep);
	}

	/** 
	 * Returns the number of existing repetitions of RPA_I08_INSURANCE 
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
	 * Returns  first repetition of RPA_I08_PROCEDURE (a Group object) - creates it if necessary
	 */
	public RPA_I08_PROCEDURE getPROCEDURE() { 
	   RPA_I08_PROCEDURE ret = null;
	   try {
	      ret = (RPA_I08_PROCEDURE)this.get("PROCEDURE");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns a specific repetition of RPA_I08_PROCEDURE
	 * (a Group object) - creates it if necessary
	 * throws HL7Exception if the repetition requested is more than one 
	 *     greater than the number of existing repetitions.
	 */
	public RPA_I08_PROCEDURE getPROCEDURE(int rep) throws HL7Exception { 
	   return (RPA_I08_PROCEDURE)this.get("PROCEDURE", rep);
	}

	/** 
	 * Returns the number of existing repetitions of RPA_I08_PROCEDURE 
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
	 * Returns  first repetition of RPA_I08_OBSERVATION (a Group object) - creates it if necessary
	 */
	public RPA_I08_OBSERVATION getOBSERVATION() { 
	   RPA_I08_OBSERVATION ret = null;
	   try {
	      ret = (RPA_I08_OBSERVATION)this.get("OBSERVATION");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns a specific repetition of RPA_I08_OBSERVATION
	 * (a Group object) - creates it if necessary
	 * throws HL7Exception if the repetition requested is more than one 
	 *     greater than the number of existing repetitions.
	 */
	public RPA_I08_OBSERVATION getOBSERVATION(int rep) throws HL7Exception { 
	   return (RPA_I08_OBSERVATION)this.get("OBSERVATION", rep);
	}

	/** 
	 * Returns the number of existing repetitions of RPA_I08_OBSERVATION 
	 */ 
	public int getOBSERVATIONReps() { 
	    int reps = -1; 
	    try { 
	        reps = this.getAll("OBSERVATION").length; 
	    } catch (HL7Exception e) { 
	        String message = "Unexpected error accessing data - this is probably a bug in the source code generator."; 
	        HapiLogFactory.getHapiLog(this.getClass()).error(message, e); 
	        throw new RuntimeException(message);
	    } 
	    return reps; 
	} 

	/**
	 * Returns RPA_I08_VISIT (a Group object) - creates it if necessary
	 */
	public RPA_I08_VISIT getVISIT() { 
	   RPA_I08_VISIT ret = null;
	   try {
	      ret = (RPA_I08_VISIT)this.get("VISIT");
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

}
