package ca.uhn.hl7v2.model.v231.message;

import ca.uhn.log.HapiLogFactory;
import ca.uhn.hl7v2.model.v231.group.*;

import ca.uhn.hl7v2.model.v231.segment.*;

import ca.uhn.hl7v2.HL7Exception;

import ca.uhn.hl7v2.parser.ModelClassFactory;

import ca.uhn.hl7v2.parser.DefaultModelClassFactory;

import ca.uhn.hl7v2.model.AbstractMessage;

/**
 * <p>Represents a SRM_S01 message structure (see chapter null). This structure contains the 
 * following elements: </p>
 * 0: MSH (MSH - message header segment) <b></b><br>
 * 1: ARQ (ARQ - appointment request segment) <b></b><br>
 * 2: APR (APR - appointment preferences segment) <b>optional </b><br>
 * 3: NTE (NTE - notes and comments segment) <b>optional repeating</b><br>
 * 4: SRM_S01_PIDPV1PV2OBXDG1 (a Group object) <b>optional repeating</b><br>
 * 5: SRM_S01_RGSAISAPRNTEAIGAPRNTEAILAPRNTEAIPAPRNTE (a Group object) <b>repeating</b><br>
 */
public class SRM_S01 extends AbstractMessage  {

	/** 
	 * Creates a new SRM_S01 Group with custom ModelClassFactory.
	 */
	public SRM_S01(ModelClassFactory factory) {
	   super(factory);
	   init(factory);
	}

	/**
	 * Creates a new SRM_S01 Group with DefaultModelClassFactory. 
	 */ 
	public SRM_S01() { 
	   super(new DefaultModelClassFactory());
	   init(new DefaultModelClassFactory());
	}

	private void init(ModelClassFactory factory) {
	   try {
	      this.add(MSH.class, true, false);
	      this.add(ARQ.class, true, false);
	      this.add(APR.class, false, false);
	      this.add(NTE.class, false, true);
	      this.add(SRM_S01_PIDPV1PV2OBXDG1.class, false, true);
	      this.add(SRM_S01_RGSAISAPRNTEAIGAPRNTEAILAPRNTEAIPAPRNTE.class, true, true);
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error creating SRM_S01 - this is probably a bug in the source code generator.", e);
	   }
	}

	/**
	 * Returns MSH (MSH - message header segment) - creates it if necessary
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
	 * Returns ARQ (ARQ - appointment request segment) - creates it if necessary
	 */
	public ARQ getARQ() { 
	   ARQ ret = null;
	   try {
	      ret = (ARQ)this.get("ARQ");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns APR (APR - appointment preferences segment) - creates it if necessary
	 */
	public APR getAPR() { 
	   APR ret = null;
	   try {
	      ret = (APR)this.get("APR");
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
	 * Returns  first repetition of SRM_S01_PIDPV1PV2OBXDG1 (a Group object) - creates it if necessary
	 */
	public SRM_S01_PIDPV1PV2OBXDG1 getPIDPV1PV2OBXDG1() { 
	   SRM_S01_PIDPV1PV2OBXDG1 ret = null;
	   try {
	      ret = (SRM_S01_PIDPV1PV2OBXDG1)this.get("PIDPV1PV2OBXDG1");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns a specific repetition of SRM_S01_PIDPV1PV2OBXDG1
	 * (a Group object) - creates it if necessary
	 * throws HL7Exception if the repetition requested is more than one 
	 *     greater than the number of existing repetitions.
	 */
	public SRM_S01_PIDPV1PV2OBXDG1 getPIDPV1PV2OBXDG1(int rep) throws HL7Exception { 
	   return (SRM_S01_PIDPV1PV2OBXDG1)this.get("PIDPV1PV2OBXDG1", rep);
	}

	/** 
	 * Returns the number of existing repetitions of SRM_S01_PIDPV1PV2OBXDG1 
	 */ 
	public int getPIDPV1PV2OBXDG1Reps() { 
	    int reps = -1; 
	    try { 
	        reps = this.getAll("PIDPV1PV2OBXDG1").length; 
	    } catch (HL7Exception e) { 
	        String message = "Unexpected error accessing data - this is probably a bug in the source code generator."; 
	        HapiLogFactory.getHapiLog(this.getClass()).error(message, e); 
	        throw new RuntimeException(message);
	    } 
	    return reps; 
	} 

	/**
	 * Returns  first repetition of SRM_S01_RGSAISAPRNTEAIGAPRNTEAILAPRNTEAIPAPRNTE (a Group object) - creates it if necessary
	 */
	public SRM_S01_RGSAISAPRNTEAIGAPRNTEAILAPRNTEAIPAPRNTE getRGSAISAPRNTEAIGAPRNTEAILAPRNTEAIPAPRNTE() { 
	   SRM_S01_RGSAISAPRNTEAIGAPRNTEAILAPRNTEAIPAPRNTE ret = null;
	   try {
	      ret = (SRM_S01_RGSAISAPRNTEAIGAPRNTEAILAPRNTEAIPAPRNTE)this.get("RGSAISAPRNTEAIGAPRNTEAILAPRNTEAIPAPRNTE");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns a specific repetition of SRM_S01_RGSAISAPRNTEAIGAPRNTEAILAPRNTEAIPAPRNTE
	 * (a Group object) - creates it if necessary
	 * throws HL7Exception if the repetition requested is more than one 
	 *     greater than the number of existing repetitions.
	 */
	public SRM_S01_RGSAISAPRNTEAIGAPRNTEAILAPRNTEAIPAPRNTE getRGSAISAPRNTEAIGAPRNTEAILAPRNTEAIPAPRNTE(int rep) throws HL7Exception { 
	   return (SRM_S01_RGSAISAPRNTEAIGAPRNTEAILAPRNTEAIPAPRNTE)this.get("RGSAISAPRNTEAIGAPRNTEAILAPRNTEAIPAPRNTE", rep);
	}

	/** 
	 * Returns the number of existing repetitions of SRM_S01_RGSAISAPRNTEAIGAPRNTEAILAPRNTEAIPAPRNTE 
	 */ 
	public int getRGSAISAPRNTEAIGAPRNTEAILAPRNTEAIPAPRNTEReps() { 
	    int reps = -1; 
	    try { 
	        reps = this.getAll("RGSAISAPRNTEAIGAPRNTEAILAPRNTEAIPAPRNTE").length; 
	    } catch (HL7Exception e) { 
	        String message = "Unexpected error accessing data - this is probably a bug in the source code generator."; 
	        HapiLogFactory.getHapiLog(this.getClass()).error(message, e); 
	        throw new RuntimeException(message);
	    } 
	    return reps; 
	} 

}
