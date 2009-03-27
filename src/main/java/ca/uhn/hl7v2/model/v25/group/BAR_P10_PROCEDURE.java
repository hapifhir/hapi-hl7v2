package ca.uhn.hl7v2.model.v25.group;

import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.log.HapiLogFactory;
import ca.uhn.hl7v2.model.v25.segment.*;

import ca.uhn.hl7v2.model.*;
/**
 * <p>Represents the BAR_P10_PROCEDURE Group.  A Group is an ordered collection of message 
 * segments that can repeat together or be optionally in/excluded together.
 * This Group contains the following elements: </p>
 * 0: PR1 (Procedures) <b></b><br>
 * 1: GP2 (Grouping/Reimbursement - Procedure Line Item) <b>optional </b><br>
 */
public class BAR_P10_PROCEDURE extends AbstractGroup {

	/** 
	 * Creates a new BAR_P10_PROCEDURE Group.
	 */
	public BAR_P10_PROCEDURE(Group parent, ModelClassFactory factory) {
	   super(parent, factory);
	   try {
	      this.add(PR1.class, true, false);
	      this.add(GP2.class, false, false);
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error creating BAR_P10_PROCEDURE - this is probably a bug in the source code generator.", e);
	   }
	}

	/**
	 * Returns PR1 (Procedures) - creates it if necessary
	 */
	public PR1 getPR1() { 
	   PR1 ret = null;
	   try {
	      ret = (PR1)this.get("PR1");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns GP2 (Grouping/Reimbursement - Procedure Line Item) - creates it if necessary
	 */
	public GP2 getGP2() { 
	   GP2 ret = null;
	   try {
	      ret = (GP2)this.get("GP2");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

}
