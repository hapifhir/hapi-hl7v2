package ca.uhn.hl7v2.model.v231.message;

import ca.uhn.log.HapiLogFactory;
import ca.uhn.hl7v2.model.v231.group.*;

import ca.uhn.hl7v2.model.v231.segment.*;

import ca.uhn.hl7v2.HL7Exception;

import ca.uhn.hl7v2.parser.ModelClassFactory;

import ca.uhn.hl7v2.parser.DefaultModelClassFactory;

import ca.uhn.hl7v2.model.AbstractMessage;

/**
 * <p>Represents a SQR_S25 message structure (see chapter ?). This structure contains the 
 * following elements: </p>
 * 0: MSH (MSH - message header segment) <b></b><br>
 * 1: MSA (MSA - message acknowledgment segment) <b></b><br>
 * 2: ERR (ERR - error segment) <b>optional </b><br>
 * 3: QAK (Query Acknowledgement) <b></b><br>
 * 4: SQR_S25_SCHNTEPIDPV1PV2DG1RGSAISNTEAIGNTEAIPNTEAILNTE (a Group object) <b>optional repeating</b><br>
 * 5: DSC (DSC - Continuation pointer segment) <b>optional </b><br>
 */
public class SQR_S25 extends AbstractMessage  {

	/** 
	 * Creates a new SQR_S25 Group with custom ModelClassFactory.
	 */
	public SQR_S25(ModelClassFactory factory) {
	   super(factory);
	   init(factory);
	}

	/**
	 * Creates a new SQR_S25 Group with DefaultModelClassFactory. 
	 */ 
	public SQR_S25() { 
	   super(new DefaultModelClassFactory());
	   init(new DefaultModelClassFactory());
	}

	private void init(ModelClassFactory factory) {
	   try {
	      this.add(MSH.class, true, false);
	      this.add(MSA.class, true, false);
	      this.add(ERR.class, false, false);
	      this.add(QAK.class, true, false);
	      this.add(SQR_S25_SCHNTEPIDPV1PV2DG1RGSAISNTEAIGNTEAIPNTEAILNTE.class, false, true);
	      this.add(DSC.class, false, false);
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error creating SQR_S25 - this is probably a bug in the source code generator.", e);
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
	 * Returns MSA (MSA - message acknowledgment segment) - creates it if necessary
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
	 * Returns ERR (ERR - error segment) - creates it if necessary
	 */
	public ERR getERR() { 
	   ERR ret = null;
	   try {
	      ret = (ERR)this.get("ERR");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns QAK (Query Acknowledgement) - creates it if necessary
	 */
	public QAK getQAK() { 
	   QAK ret = null;
	   try {
	      ret = (QAK)this.get("QAK");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns  first repetition of SQR_S25_SCHNTEPIDPV1PV2DG1RGSAISNTEAIGNTEAIPNTEAILNTE (a Group object) - creates it if necessary
	 */
	public SQR_S25_SCHNTEPIDPV1PV2DG1RGSAISNTEAIGNTEAIPNTEAILNTE getSCHNTEPIDPV1PV2DG1RGSAISNTEAIGNTEAIPNTEAILNTE() { 
	   SQR_S25_SCHNTEPIDPV1PV2DG1RGSAISNTEAIGNTEAIPNTEAILNTE ret = null;
	   try {
	      ret = (SQR_S25_SCHNTEPIDPV1PV2DG1RGSAISNTEAIGNTEAIPNTEAILNTE)this.get("SCHNTEPIDPV1PV2DG1RGSAISNTEAIGNTEAIPNTEAILNTE");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns a specific repetition of SQR_S25_SCHNTEPIDPV1PV2DG1RGSAISNTEAIGNTEAIPNTEAILNTE
	 * (a Group object) - creates it if necessary
	 * throws HL7Exception if the repetition requested is more than one 
	 *     greater than the number of existing repetitions.
	 */
	public SQR_S25_SCHNTEPIDPV1PV2DG1RGSAISNTEAIGNTEAIPNTEAILNTE getSCHNTEPIDPV1PV2DG1RGSAISNTEAIGNTEAIPNTEAILNTE(int rep) throws HL7Exception { 
	   return (SQR_S25_SCHNTEPIDPV1PV2DG1RGSAISNTEAIGNTEAIPNTEAILNTE)this.get("SCHNTEPIDPV1PV2DG1RGSAISNTEAIGNTEAIPNTEAILNTE", rep);
	}

	/** 
	 * Returns the number of existing repetitions of SQR_S25_SCHNTEPIDPV1PV2DG1RGSAISNTEAIGNTEAIPNTEAILNTE 
	 */ 
	public int getSCHNTEPIDPV1PV2DG1RGSAISNTEAIGNTEAIPNTEAILNTEReps() { 
	    int reps = -1; 
	    try { 
	        reps = this.getAll("SCHNTEPIDPV1PV2DG1RGSAISNTEAIGNTEAIPNTEAILNTE").length; 
	    } catch (HL7Exception e) { 
	        String message = "Unexpected error accessing data - this is probably a bug in the source code generator."; 
	        HapiLogFactory.getHapiLog(this.getClass()).error(message, e); 
	        throw new RuntimeException(message);
	    } 
	    return reps; 
	} 

	/**
	 * Returns DSC (DSC - Continuation pointer segment) - creates it if necessary
	 */
	public DSC getDSC() { 
	   DSC ret = null;
	   try {
	      ret = (DSC)this.get("DSC");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

}
