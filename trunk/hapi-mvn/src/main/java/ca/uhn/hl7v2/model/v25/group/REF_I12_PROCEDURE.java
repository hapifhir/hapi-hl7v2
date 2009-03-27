package ca.uhn.hl7v2.model.v25.group;

import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.log.HapiLogFactory;
import ca.uhn.hl7v2.model.v25.segment.*;

import ca.uhn.hl7v2.model.*;
/**
 * <p>Represents the REF_I12_PROCEDURE Group.  A Group is an ordered collection of message 
 * segments that can repeat together or be optionally in/excluded together.
 * This Group contains the following elements: </p>
 * 0: PR1 (Procedures) <b></b><br>
 * 1: REF_I12_AUTHORIZATION_CONTACT (a Group object) <b>optional </b><br>
 */
public class REF_I12_PROCEDURE extends AbstractGroup {

	/** 
	 * Creates a new REF_I12_PROCEDURE Group.
	 */
	public REF_I12_PROCEDURE(Group parent, ModelClassFactory factory) {
	   super(parent, factory);
	   try {
	      this.add(PR1.class, true, false);
	      this.add(REF_I12_AUTHORIZATION_CONTACT.class, false, false);
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error creating REF_I12_PROCEDURE - this is probably a bug in the source code generator.", e);
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
	 * Returns REF_I12_AUTHORIZATION_CONTACT (a Group object) - creates it if necessary
	 */
	public REF_I12_AUTHORIZATION_CONTACT getAUTHORIZATION_CONTACT() { 
	   REF_I12_AUTHORIZATION_CONTACT ret = null;
	   try {
	      ret = (REF_I12_AUTHORIZATION_CONTACT)this.get("AUTHORIZATION_CONTACT");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

}
