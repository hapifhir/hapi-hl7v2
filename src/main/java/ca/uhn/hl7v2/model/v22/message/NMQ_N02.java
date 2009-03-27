package ca.uhn.hl7v2.model.v22.message;

import ca.uhn.log.HapiLogFactory;
import ca.uhn.hl7v2.model.v22.group.*;

import ca.uhn.hl7v2.model.v22.segment.*;

import ca.uhn.hl7v2.HL7Exception;

import ca.uhn.hl7v2.parser.ModelClassFactory;

import ca.uhn.hl7v2.parser.DefaultModelClassFactory;

import ca.uhn.hl7v2.model.AbstractMessage;

/**
 * <p>Represents a NMQ_N02 message structure (see chapter ?). This structure contains the 
 * following elements: </p>
 * 0: MSH (MESSAGE HEADER) <b></b><br>
 * 1: NMQ_N02_QRY_WITH_DETAIL (a Group object) <b>optional </b><br>
 * 2: NMQ_N02_CLOCK_AND_STATISTICS (a Group object) <b>repeating</b><br>
 */
public class NMQ_N02 extends AbstractMessage  {

	/** 
	 * Creates a new NMQ_N02 Group with custom ModelClassFactory.
	 */
	public NMQ_N02(ModelClassFactory factory) {
	   super(factory);
	   init(factory);
	}

	/**
	 * Creates a new NMQ_N02 Group with DefaultModelClassFactory. 
	 */ 
	public NMQ_N02() { 
	   super(new DefaultModelClassFactory());
	   init(new DefaultModelClassFactory());
	}

	private void init(ModelClassFactory factory) {
	   try {
	      this.add(MSH.class, true, false);
	      this.add(NMQ_N02_QRY_WITH_DETAIL.class, false, false);
	      this.add(NMQ_N02_CLOCK_AND_STATISTICS.class, true, true);
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error creating NMQ_N02 - this is probably a bug in the source code generator.", e);
	   }
	}

	/**
	 * Returns MSH (MESSAGE HEADER) - creates it if necessary
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
	 * Returns NMQ_N02_QRY_WITH_DETAIL (a Group object) - creates it if necessary
	 */
	public NMQ_N02_QRY_WITH_DETAIL getQRY_WITH_DETAIL() { 
	   NMQ_N02_QRY_WITH_DETAIL ret = null;
	   try {
	      ret = (NMQ_N02_QRY_WITH_DETAIL)this.get("QRY_WITH_DETAIL");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns  first repetition of NMQ_N02_CLOCK_AND_STATISTICS (a Group object) - creates it if necessary
	 */
	public NMQ_N02_CLOCK_AND_STATISTICS getCLOCK_AND_STATISTICS() { 
	   NMQ_N02_CLOCK_AND_STATISTICS ret = null;
	   try {
	      ret = (NMQ_N02_CLOCK_AND_STATISTICS)this.get("CLOCK_AND_STATISTICS");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns a specific repetition of NMQ_N02_CLOCK_AND_STATISTICS
	 * (a Group object) - creates it if necessary
	 * throws HL7Exception if the repetition requested is more than one 
	 *     greater than the number of existing repetitions.
	 */
	public NMQ_N02_CLOCK_AND_STATISTICS getCLOCK_AND_STATISTICS(int rep) throws HL7Exception { 
	   return (NMQ_N02_CLOCK_AND_STATISTICS)this.get("CLOCK_AND_STATISTICS", rep);
	}

	/** 
	 * Returns the number of existing repetitions of NMQ_N02_CLOCK_AND_STATISTICS 
	 */ 
	public int getCLOCK_AND_STATISTICSReps() { 
	    int reps = -1; 
	    try { 
	        reps = this.getAll("CLOCK_AND_STATISTICS").length; 
	    } catch (HL7Exception e) { 
	        String message = "Unexpected error accessing data - this is probably a bug in the source code generator."; 
	        HapiLogFactory.getHapiLog(this.getClass()).error(message, e); 
	        throw new RuntimeException(message);
	    } 
	    return reps; 
	} 

}
