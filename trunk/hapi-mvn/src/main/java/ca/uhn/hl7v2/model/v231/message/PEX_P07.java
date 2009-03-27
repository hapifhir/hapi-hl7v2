package ca.uhn.hl7v2.model.v231.message;

import ca.uhn.log.HapiLogFactory;
import ca.uhn.hl7v2.model.v231.group.*;

import ca.uhn.hl7v2.model.v231.segment.*;

import ca.uhn.hl7v2.HL7Exception;

import ca.uhn.hl7v2.parser.ModelClassFactory;

import ca.uhn.hl7v2.parser.DefaultModelClassFactory;

import ca.uhn.hl7v2.model.AbstractMessage;

/**
 * <p>Represents a PEX_P07 message structure (see chapter null). This structure contains the 
 * following elements: </p>
 * 0: MSH (MSH - message header segment) <b></b><br>
 * 1: EVN (EVN - event type segment) <b></b><br>
 * 2: PID (PID - patient identification segment) <b></b><br>
 * 3: PD1 (PD1 - patient additional demographic segment) <b>optional </b><br>
 * 4: NTE (NTE - notes and comments segment) <b>optional repeating</b><br>
 * 5: PEX_P07_PV1PV2 (a Group object) <b>optional </b><br>
 * 6: PEX_P07_PESPEOPCRRXERXRRXARXRPRBOBXNTENK1RXERXRRXARXRPRBOBXCSRCSP (a Group object) <b>repeating</b><br>
 */
public class PEX_P07 extends AbstractMessage  {

	/** 
	 * Creates a new PEX_P07 Group with custom ModelClassFactory.
	 */
	public PEX_P07(ModelClassFactory factory) {
	   super(factory);
	   init(factory);
	}

	/**
	 * Creates a new PEX_P07 Group with DefaultModelClassFactory. 
	 */ 
	public PEX_P07() { 
	   super(new DefaultModelClassFactory());
	   init(new DefaultModelClassFactory());
	}

	private void init(ModelClassFactory factory) {
	   try {
	      this.add(MSH.class, true, false);
	      this.add(EVN.class, true, false);
	      this.add(PID.class, true, false);
	      this.add(PD1.class, false, false);
	      this.add(NTE.class, false, true);
	      this.add(PEX_P07_PV1PV2.class, false, false);
	      this.add(PEX_P07_PESPEOPCRRXERXRRXARXRPRBOBXNTENK1RXERXRRXARXRPRBOBXCSRCSP.class, true, true);
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error creating PEX_P07 - this is probably a bug in the source code generator.", e);
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
	 * Returns EVN (EVN - event type segment) - creates it if necessary
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
	 * Returns PID (PID - patient identification segment) - creates it if necessary
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
	 * Returns PD1 (PD1 - patient additional demographic segment) - creates it if necessary
	 */
	public PD1 getPD1() { 
	   PD1 ret = null;
	   try {
	      ret = (PD1)this.get("PD1");
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
	 * Returns PEX_P07_PV1PV2 (a Group object) - creates it if necessary
	 */
	public PEX_P07_PV1PV2 getPV1PV2() { 
	   PEX_P07_PV1PV2 ret = null;
	   try {
	      ret = (PEX_P07_PV1PV2)this.get("PV1PV2");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns  first repetition of PEX_P07_PESPEOPCRRXERXRRXARXRPRBOBXNTENK1RXERXRRXARXRPRBOBXCSRCSP (a Group object) - creates it if necessary
	 */
	public PEX_P07_PESPEOPCRRXERXRRXARXRPRBOBXNTENK1RXERXRRXARXRPRBOBXCSRCSP getPESPEOPCRRXERXRRXARXRPRBOBXNTENK1RXERXRRXARXRPRBOBXCSRCSP() { 
	   PEX_P07_PESPEOPCRRXERXRRXARXRPRBOBXNTENK1RXERXRRXARXRPRBOBXCSRCSP ret = null;
	   try {
	      ret = (PEX_P07_PESPEOPCRRXERXRRXARXRPRBOBXNTENK1RXERXRRXARXRPRBOBXCSRCSP)this.get("PESPEOPCRRXERXRRXARXRPRBOBXNTENK1RXERXRRXARXRPRBOBXCSRCSP");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns a specific repetition of PEX_P07_PESPEOPCRRXERXRRXARXRPRBOBXNTENK1RXERXRRXARXRPRBOBXCSRCSP
	 * (a Group object) - creates it if necessary
	 * throws HL7Exception if the repetition requested is more than one 
	 *     greater than the number of existing repetitions.
	 */
	public PEX_P07_PESPEOPCRRXERXRRXARXRPRBOBXNTENK1RXERXRRXARXRPRBOBXCSRCSP getPESPEOPCRRXERXRRXARXRPRBOBXNTENK1RXERXRRXARXRPRBOBXCSRCSP(int rep) throws HL7Exception { 
	   return (PEX_P07_PESPEOPCRRXERXRRXARXRPRBOBXNTENK1RXERXRRXARXRPRBOBXCSRCSP)this.get("PESPEOPCRRXERXRRXARXRPRBOBXNTENK1RXERXRRXARXRPRBOBXCSRCSP", rep);
	}

	/** 
	 * Returns the number of existing repetitions of PEX_P07_PESPEOPCRRXERXRRXARXRPRBOBXNTENK1RXERXRRXARXRPRBOBXCSRCSP 
	 */ 
	public int getPESPEOPCRRXERXRRXARXRPRBOBXNTENK1RXERXRRXARXRPRBOBXCSRCSPReps() { 
	    int reps = -1; 
	    try { 
	        reps = this.getAll("PESPEOPCRRXERXRRXARXRPRBOBXNTENK1RXERXRRXARXRPRBOBXCSRCSP").length; 
	    } catch (HL7Exception e) { 
	        String message = "Unexpected error accessing data - this is probably a bug in the source code generator."; 
	        HapiLogFactory.getHapiLog(this.getClass()).error(message, e); 
	        throw new RuntimeException(message);
	    } 
	    return reps; 
	} 

}
