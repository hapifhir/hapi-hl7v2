package ca.uhn.hl7v2.model.v25.group;

import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.log.HapiLogFactory;
import ca.uhn.hl7v2.model.v25.segment.*;

import ca.uhn.hl7v2.model.*;
/**
 * <p>Represents the BRP_O30_RESPONSE Group.  A Group is an ordered collection of message 
 * segments that can repeat together or be optionally in/excluded together.
 * This Group contains the following elements: </p>
 * 0: BRP_O30_PATIENT (a Group object) <b>optional </b><br>
 */
public class BRP_O30_RESPONSE extends AbstractGroup {

	/** 
	 * Creates a new BRP_O30_RESPONSE Group.
	 */
	public BRP_O30_RESPONSE(Group parent, ModelClassFactory factory) {
	   super(parent, factory);
	   try {
	      this.add(BRP_O30_PATIENT.class, false, false);
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error creating BRP_O30_RESPONSE - this is probably a bug in the source code generator.", e);
	   }
	}

	/**
	 * Returns BRP_O30_PATIENT (a Group object) - creates it if necessary
	 */
	public BRP_O30_PATIENT getPATIENT() { 
	   BRP_O30_PATIENT ret = null;
	   try {
	      ret = (BRP_O30_PATIENT)this.get("PATIENT");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

}
