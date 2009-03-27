package ca.uhn.hl7v2.model.v231.message;

import ca.uhn.log.HapiLogFactory;
import ca.uhn.hl7v2.model.v231.group.*;

import ca.uhn.hl7v2.model.v231.segment.*;

import ca.uhn.hl7v2.HL7Exception;

import ca.uhn.hl7v2.parser.ModelClassFactory;

import ca.uhn.hl7v2.parser.DefaultModelClassFactory;

import ca.uhn.hl7v2.model.AbstractMessage;

/**
 * <p>Represents a ADT_A39 message structure (see chapter ?). This structure contains the 
 * following elements: </p>
 * 0: MSH (MSH - message header segment) <b></b><br>
 * 1: EVN (EVN - event type segment) <b></b><br>
 * 2: ADT_A39_PIDPD1MRGPV1 (a Group object) <b>repeating</b><br>
 */
public class ADT_A39 extends AbstractMessage  {

	/** 
	 * Creates a new ADT_A39 Group with custom ModelClassFactory.
	 */
	public ADT_A39(ModelClassFactory factory) {
	   super(factory);
	   init(factory);
	}

	/**
	 * Creates a new ADT_A39 Group with DefaultModelClassFactory. 
	 */ 
	public ADT_A39() { 
	   super(new DefaultModelClassFactory());
	   init(new DefaultModelClassFactory());
	}

	private void init(ModelClassFactory factory) {
	   try {
	      this.add(MSH.class, true, false);
	      this.add(EVN.class, true, false);
	      this.add(ADT_A39_PIDPD1MRGPV1.class, true, true);
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error creating ADT_A39 - this is probably a bug in the source code generator.", e);
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
	 * Returns  first repetition of ADT_A39_PIDPD1MRGPV1 (a Group object) - creates it if necessary
	 */
	public ADT_A39_PIDPD1MRGPV1 getPIDPD1MRGPV1() { 
	   ADT_A39_PIDPD1MRGPV1 ret = null;
	   try {
	      ret = (ADT_A39_PIDPD1MRGPV1)this.get("PIDPD1MRGPV1");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns a specific repetition of ADT_A39_PIDPD1MRGPV1
	 * (a Group object) - creates it if necessary
	 * throws HL7Exception if the repetition requested is more than one 
	 *     greater than the number of existing repetitions.
	 */
	public ADT_A39_PIDPD1MRGPV1 getPIDPD1MRGPV1(int rep) throws HL7Exception { 
	   return (ADT_A39_PIDPD1MRGPV1)this.get("PIDPD1MRGPV1", rep);
	}

	/** 
	 * Returns the number of existing repetitions of ADT_A39_PIDPD1MRGPV1 
	 */ 
	public int getPIDPD1MRGPV1Reps() { 
	    int reps = -1; 
	    try { 
	        reps = this.getAll("PIDPD1MRGPV1").length; 
	    } catch (HL7Exception e) { 
	        String message = "Unexpected error accessing data - this is probably a bug in the source code generator."; 
	        HapiLogFactory.getHapiLog(this.getClass()).error(message, e); 
	        throw new RuntimeException(message);
	    } 
	    return reps; 
	} 

}
