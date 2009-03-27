package ca.uhn.hl7v2.model.v24.group;

import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.log.HapiLogFactory;
import ca.uhn.hl7v2.model.v24.segment.*;

import ca.uhn.hl7v2.model.*;
/**
 * <p>Represents the NMQ_N01_CLOCK_AND_STATISTICS Group.  A Group is an ordered collection of message 
 * segments that can repeat together or be optionally in/excluded together.
 * This Group contains the following elements: </p>
 * 0: NCK (System clock) <b>optional </b><br>
 * 1: NST (Application control level statistics) <b>optional </b><br>
 * 2: NSC (Application status change) <b>optional </b><br>
 */
public class NMQ_N01_CLOCK_AND_STATISTICS extends AbstractGroup {

	/** 
	 * Creates a new NMQ_N01_CLOCK_AND_STATISTICS Group.
	 */
	public NMQ_N01_CLOCK_AND_STATISTICS(Group parent, ModelClassFactory factory) {
	   super(parent, factory);
	   try {
	      this.add(NCK.class, false, false);
	      this.add(NST.class, false, false);
	      this.add(NSC.class, false, false);
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error creating NMQ_N01_CLOCK_AND_STATISTICS - this is probably a bug in the source code generator.", e);
	   }
	}

	/**
	 * Returns NCK (System clock) - creates it if necessary
	 */
	public NCK getNCK() { 
	   NCK ret = null;
	   try {
	      ret = (NCK)this.get("NCK");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns NST (Application control level statistics) - creates it if necessary
	 */
	public NST getNST() { 
	   NST ret = null;
	   try {
	      ret = (NST)this.get("NST");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns NSC (Application status change) - creates it if necessary
	 */
	public NSC getNSC() { 
	   NSC ret = null;
	   try {
	      ret = (NSC)this.get("NSC");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

}
