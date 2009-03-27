package ca.uhn.hl7v2.model.v231.message;

import ca.uhn.log.HapiLogFactory;
import ca.uhn.hl7v2.model.v231.group.*;

import ca.uhn.hl7v2.model.v231.segment.*;

import ca.uhn.hl7v2.HL7Exception;

import ca.uhn.hl7v2.parser.ModelClassFactory;

import ca.uhn.hl7v2.parser.DefaultModelClassFactory;

import ca.uhn.hl7v2.model.AbstractMessage;

/**
 * <p>Represents a BAR_P02 message structure (see chapter ?). This structure contains the 
 * following elements: </p>
 * 0: MSH (MSH - message header segment) <b></b><br>
 * 1: EVN (EVN - event type segment) <b></b><br>
 * 2: BAR_P02_PIDPD1PV1DB1 (a Group object) <b>repeating</b><br>
 */
public class BAR_P02 extends AbstractMessage  {

	/** 
	 * Creates a new BAR_P02 Group with custom ModelClassFactory.
	 */
	public BAR_P02(ModelClassFactory factory) {
	   super(factory);
	   init(factory);
	}

	/**
	 * Creates a new BAR_P02 Group with DefaultModelClassFactory. 
	 */ 
	public BAR_P02() { 
	   super(new DefaultModelClassFactory());
	   init(new DefaultModelClassFactory());
	}

	private void init(ModelClassFactory factory) {
	   try {
	      this.add(MSH.class, true, false);
	      this.add(EVN.class, true, false);
	      this.add(BAR_P02_PIDPD1PV1DB1.class, true, true);
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error creating BAR_P02 - this is probably a bug in the source code generator.", e);
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
	 * Returns  first repetition of BAR_P02_PIDPD1PV1DB1 (a Group object) - creates it if necessary
	 */
	public BAR_P02_PIDPD1PV1DB1 getPIDPD1PV1DB1() { 
	   BAR_P02_PIDPD1PV1DB1 ret = null;
	   try {
	      ret = (BAR_P02_PIDPD1PV1DB1)this.get("PIDPD1PV1DB1");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns a specific repetition of BAR_P02_PIDPD1PV1DB1
	 * (a Group object) - creates it if necessary
	 * throws HL7Exception if the repetition requested is more than one 
	 *     greater than the number of existing repetitions.
	 */
	public BAR_P02_PIDPD1PV1DB1 getPIDPD1PV1DB1(int rep) throws HL7Exception { 
	   return (BAR_P02_PIDPD1PV1DB1)this.get("PIDPD1PV1DB1", rep);
	}

	/** 
	 * Returns the number of existing repetitions of BAR_P02_PIDPD1PV1DB1 
	 */ 
	public int getPIDPD1PV1DB1Reps() { 
	    int reps = -1; 
	    try { 
	        reps = this.getAll("PIDPD1PV1DB1").length; 
	    } catch (HL7Exception e) { 
	        String message = "Unexpected error accessing data - this is probably a bug in the source code generator."; 
	        HapiLogFactory.getHapiLog(this.getClass()).error(message, e); 
	        throw new RuntimeException(message);
	    } 
	    return reps; 
	} 

}
