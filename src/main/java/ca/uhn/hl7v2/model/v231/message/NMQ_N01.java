package ca.uhn.hl7v2.model.v231.message;

import ca.uhn.log.HapiLogFactory;
import ca.uhn.hl7v2.model.v231.group.*;

import ca.uhn.hl7v2.model.v231.segment.*;

import ca.uhn.hl7v2.HL7Exception;

import ca.uhn.hl7v2.parser.ModelClassFactory;

import ca.uhn.hl7v2.parser.DefaultModelClassFactory;

import ca.uhn.hl7v2.model.AbstractMessage;

/**
 * <p>Represents a NMQ_N01 message structure (see chapter 14). This structure contains the 
 * following elements: </p>
 * 0: MSH (MSH - message header segment) <b></b><br>
 * 1: NMQ_N01_QRDQRF (a Group object) <b>optional </b><br>
 * 2: NMQ_N01_NCKNSTNSC (a Group object) <b>repeating</b><br>
 */
public class NMQ_N01 extends AbstractMessage  {

	/** 
	 * Creates a new NMQ_N01 Group with custom ModelClassFactory.
	 */
	public NMQ_N01(ModelClassFactory factory) {
	   super(factory);
	   init(factory);
	}

	/**
	 * Creates a new NMQ_N01 Group with DefaultModelClassFactory. 
	 */ 
	public NMQ_N01() { 
	   super(new DefaultModelClassFactory());
	   init(new DefaultModelClassFactory());
	}

	private void init(ModelClassFactory factory) {
	   try {
	      this.add(MSH.class, true, false);
	      this.add(NMQ_N01_QRDQRF.class, false, false);
	      this.add(NMQ_N01_NCKNSTNSC.class, true, true);
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error creating NMQ_N01 - this is probably a bug in the source code generator.", e);
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
	 * Returns NMQ_N01_QRDQRF (a Group object) - creates it if necessary
	 */
	public NMQ_N01_QRDQRF getQRDQRF() { 
	   NMQ_N01_QRDQRF ret = null;
	   try {
	      ret = (NMQ_N01_QRDQRF)this.get("QRDQRF");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns  first repetition of NMQ_N01_NCKNSTNSC (a Group object) - creates it if necessary
	 */
	public NMQ_N01_NCKNSTNSC getNCKNSTNSC() { 
	   NMQ_N01_NCKNSTNSC ret = null;
	   try {
	      ret = (NMQ_N01_NCKNSTNSC)this.get("NCKNSTNSC");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns a specific repetition of NMQ_N01_NCKNSTNSC
	 * (a Group object) - creates it if necessary
	 * throws HL7Exception if the repetition requested is more than one 
	 *     greater than the number of existing repetitions.
	 */
	public NMQ_N01_NCKNSTNSC getNCKNSTNSC(int rep) throws HL7Exception { 
	   return (NMQ_N01_NCKNSTNSC)this.get("NCKNSTNSC", rep);
	}

	/** 
	 * Returns the number of existing repetitions of NMQ_N01_NCKNSTNSC 
	 */ 
	public int getNCKNSTNSCReps() { 
	    int reps = -1; 
	    try { 
	        reps = this.getAll("NCKNSTNSC").length; 
	    } catch (HL7Exception e) { 
	        String message = "Unexpected error accessing data - this is probably a bug in the source code generator."; 
	        HapiLogFactory.getHapiLog(this.getClass()).error(message, e); 
	        throw new RuntimeException(message);
	    } 
	    return reps; 
	} 

}
