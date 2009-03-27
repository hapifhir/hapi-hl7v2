package ca.uhn.hl7v2.model.v231.message;

import ca.uhn.log.HapiLogFactory;
import ca.uhn.hl7v2.model.v231.group.*;

import ca.uhn.hl7v2.model.v231.segment.*;

import ca.uhn.hl7v2.HL7Exception;

import ca.uhn.hl7v2.parser.ModelClassFactory;

import ca.uhn.hl7v2.parser.DefaultModelClassFactory;

import ca.uhn.hl7v2.model.AbstractMessage;

/**
 * <p>Represents a RDO_O01 message structure (see chapter 4.8.1). This structure contains the 
 * following elements: </p>
 * 0: MSH (MSH - message header segment) <b></b><br>
 * 1: NTE (NTE - notes and comments segment) <b>optional repeating</b><br>
 * 2: RDO_O01_PIDPD1NTEPV1PV2IN1IN2IN3GT1AL1 (a Group object) <b>optional </b><br>
 * 3: RDO_O01_ORCRXONTERXRRXCNTEOBXNTEBLG (a Group object) <b>repeating</b><br>
 */
public class RDO_O01 extends AbstractMessage  {

	/** 
	 * Creates a new RDO_O01 Group with custom ModelClassFactory.
	 */
	public RDO_O01(ModelClassFactory factory) {
	   super(factory);
	   init(factory);
	}

	/**
	 * Creates a new RDO_O01 Group with DefaultModelClassFactory. 
	 */ 
	public RDO_O01() { 
	   super(new DefaultModelClassFactory());
	   init(new DefaultModelClassFactory());
	}

	private void init(ModelClassFactory factory) {
	   try {
	      this.add(MSH.class, true, false);
	      this.add(NTE.class, false, true);
	      this.add(RDO_O01_PIDPD1NTEPV1PV2IN1IN2IN3GT1AL1.class, false, false);
	      this.add(RDO_O01_ORCRXONTERXRRXCNTEOBXNTEBLG.class, true, true);
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error creating RDO_O01 - this is probably a bug in the source code generator.", e);
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
	 * Returns RDO_O01_PIDPD1NTEPV1PV2IN1IN2IN3GT1AL1 (a Group object) - creates it if necessary
	 */
	public RDO_O01_PIDPD1NTEPV1PV2IN1IN2IN3GT1AL1 getPIDPD1NTEPV1PV2IN1IN2IN3GT1AL1() { 
	   RDO_O01_PIDPD1NTEPV1PV2IN1IN2IN3GT1AL1 ret = null;
	   try {
	      ret = (RDO_O01_PIDPD1NTEPV1PV2IN1IN2IN3GT1AL1)this.get("PIDPD1NTEPV1PV2IN1IN2IN3GT1AL1");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns  first repetition of RDO_O01_ORCRXONTERXRRXCNTEOBXNTEBLG (a Group object) - creates it if necessary
	 */
	public RDO_O01_ORCRXONTERXRRXCNTEOBXNTEBLG getORCRXONTERXRRXCNTEOBXNTEBLG() { 
	   RDO_O01_ORCRXONTERXRRXCNTEOBXNTEBLG ret = null;
	   try {
	      ret = (RDO_O01_ORCRXONTERXRRXCNTEOBXNTEBLG)this.get("ORCRXONTERXRRXCNTEOBXNTEBLG");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns a specific repetition of RDO_O01_ORCRXONTERXRRXCNTEOBXNTEBLG
	 * (a Group object) - creates it if necessary
	 * throws HL7Exception if the repetition requested is more than one 
	 *     greater than the number of existing repetitions.
	 */
	public RDO_O01_ORCRXONTERXRRXCNTEOBXNTEBLG getORCRXONTERXRRXCNTEOBXNTEBLG(int rep) throws HL7Exception { 
	   return (RDO_O01_ORCRXONTERXRRXCNTEOBXNTEBLG)this.get("ORCRXONTERXRRXCNTEOBXNTEBLG", rep);
	}

	/** 
	 * Returns the number of existing repetitions of RDO_O01_ORCRXONTERXRRXCNTEOBXNTEBLG 
	 */ 
	public int getORCRXONTERXRRXCNTEOBXNTEBLGReps() { 
	    int reps = -1; 
	    try { 
	        reps = this.getAll("ORCRXONTERXRRXCNTEOBXNTEBLG").length; 
	    } catch (HL7Exception e) { 
	        String message = "Unexpected error accessing data - this is probably a bug in the source code generator."; 
	        HapiLogFactory.getHapiLog(this.getClass()).error(message, e); 
	        throw new RuntimeException(message);
	    } 
	    return reps; 
	} 

}
