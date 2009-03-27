package ca.uhn.hl7v2.model.v23.group;

import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.log.HapiLogFactory;
import ca.uhn.hl7v2.model.v23.segment.*;

import ca.uhn.hl7v2.model.*;
/**
 * <p>Represents the SQM_S25_LOCATION_RESOURCE Group.  A Group is an ordered collection of message 
 * segments that can repeat together or be optionally in/excluded together.
 * This Group contains the following elements: </p>
 * 0: AIL (Appointment Information - Location Resource) <b></b><br>
 * 1: APR (Appointment Preferences) <b>optional </b><br>
 */
public class SQM_S25_LOCATION_RESOURCE extends AbstractGroup {

	/** 
	 * Creates a new SQM_S25_LOCATION_RESOURCE Group.
	 */
	public SQM_S25_LOCATION_RESOURCE(Group parent, ModelClassFactory factory) {
	   super(parent, factory);
	   try {
	      this.add(AIL.class, true, false);
	      this.add(APR.class, false, false);
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error creating SQM_S25_LOCATION_RESOURCE - this is probably a bug in the source code generator.", e);
	   }
	}

	/**
	 * Returns AIL (Appointment Information - Location Resource) - creates it if necessary
	 */
	public AIL getAIL() { 
	   AIL ret = null;
	   try {
	      ret = (AIL)this.get("AIL");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns APR (Appointment Preferences) - creates it if necessary
	 */
	public APR getAPR() { 
	   APR ret = null;
	   try {
	      ret = (APR)this.get("APR");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

}
