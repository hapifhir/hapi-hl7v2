package ca.uhn.hl7v2.model.v231.group;

import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.log.HapiLogFactory;
import ca.uhn.hl7v2.model.v231.segment.*;

import ca.uhn.hl7v2.model.*;
/**
 * <p>Represents the PEX_P07_PESPEOPCRRXERXRRXARXRPRBOBXNTENK1RXERXRRXARXRPRBOBXCSRCSP Group.  A Group is an ordered collection of message 
 * segments that can repeat together or be optionally in/excluded together.
 * This Group contains the following elements: </p>
 * 0: PES (PES - product experience sender segment) <b></b><br>
 * 1: PEX_P07_PEOPCRRXERXRRXARXRPRBOBXNTENK1RXERXRRXARXRPRBOBXCSRCSP (a Group object) <b>repeating</b><br>
 */
public class PEX_P07_PESPEOPCRRXERXRRXARXRPRBOBXNTENK1RXERXRRXARXRPRBOBXCSRCSP extends AbstractGroup {

	/** 
	 * Creates a new PEX_P07_PESPEOPCRRXERXRRXARXRPRBOBXNTENK1RXERXRRXARXRPRBOBXCSRCSP Group.
	 */
	public PEX_P07_PESPEOPCRRXERXRRXARXRPRBOBXNTENK1RXERXRRXARXRPRBOBXCSRCSP(Group parent, ModelClassFactory factory) {
	   super(parent, factory);
	   try {
	      this.add(PES.class, true, false);
	      this.add(PEX_P07_PEOPCRRXERXRRXARXRPRBOBXNTENK1RXERXRRXARXRPRBOBXCSRCSP.class, true, true);
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error creating PEX_P07_PESPEOPCRRXERXRRXARXRPRBOBXNTENK1RXERXRRXARXRPRBOBXCSRCSP - this is probably a bug in the source code generator.", e);
	   }
	}

	/**
	 * Returns PES (PES - product experience sender segment) - creates it if necessary
	 */
	public PES getPES() { 
	   PES ret = null;
	   try {
	      ret = (PES)this.get("PES");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns  first repetition of PEX_P07_PEOPCRRXERXRRXARXRPRBOBXNTENK1RXERXRRXARXRPRBOBXCSRCSP (a Group object) - creates it if necessary
	 */
	public PEX_P07_PEOPCRRXERXRRXARXRPRBOBXNTENK1RXERXRRXARXRPRBOBXCSRCSP getPEOPCRRXERXRRXARXRPRBOBXNTENK1RXERXRRXARXRPRBOBXCSRCSP() { 
	   PEX_P07_PEOPCRRXERXRRXARXRPRBOBXNTENK1RXERXRRXARXRPRBOBXCSRCSP ret = null;
	   try {
	      ret = (PEX_P07_PEOPCRRXERXRRXARXRPRBOBXNTENK1RXERXRRXARXRPRBOBXCSRCSP)this.get("PEOPCRRXERXRRXARXRPRBOBXNTENK1RXERXRRXARXRPRBOBXCSRCSP");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns a specific repetition of PEX_P07_PEOPCRRXERXRRXARXRPRBOBXNTENK1RXERXRRXARXRPRBOBXCSRCSP
	 * (a Group object) - creates it if necessary
	 * throws HL7Exception if the repetition requested is more than one 
	 *     greater than the number of existing repetitions.
	 */
	public PEX_P07_PEOPCRRXERXRRXARXRPRBOBXNTENK1RXERXRRXARXRPRBOBXCSRCSP getPEOPCRRXERXRRXARXRPRBOBXNTENK1RXERXRRXARXRPRBOBXCSRCSP(int rep) throws HL7Exception { 
	   return (PEX_P07_PEOPCRRXERXRRXARXRPRBOBXNTENK1RXERXRRXARXRPRBOBXCSRCSP)this.get("PEOPCRRXERXRRXARXRPRBOBXNTENK1RXERXRRXARXRPRBOBXCSRCSP", rep);
	}

	/** 
	 * Returns the number of existing repetitions of PEX_P07_PEOPCRRXERXRRXARXRPRBOBXNTENK1RXERXRRXARXRPRBOBXCSRCSP 
	 */ 
	public int getPEOPCRRXERXRRXARXRPRBOBXNTENK1RXERXRRXARXRPRBOBXCSRCSPReps() { 
	    int reps = -1; 
	    try { 
	        reps = this.getAll("PEOPCRRXERXRRXARXRPRBOBXNTENK1RXERXRRXARXRPRBOBXCSRCSP").length; 
	    } catch (HL7Exception e) { 
	        String message = "Unexpected error accessing data - this is probably a bug in the source code generator."; 
	        HapiLogFactory.getHapiLog(this.getClass()).error(message, e); 
	        throw new RuntimeException(message);
	    } 
	    return reps; 
	} 

}
