package ca.uhn.hl7v2.model.v23.group;

import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.log.HapiLogFactory;
import ca.uhn.hl7v2.model.v23.segment.*;

import ca.uhn.hl7v2.model.*;
/**
 * <p>Represents the MFK_M01_MF Group.  A Group is an ordered collection of message 
 * segments that can repeat together or be optionally in/excluded together.
 * This Group contains the following elements: </p>
 * 0: MFA (Master file acknowledgement segment) <b>optional </b><br>
 */
public class MFK_M01_MF extends AbstractGroup {

	/** 
	 * Creates a new MFK_M01_MF Group.
	 */
	public MFK_M01_MF(Group parent, ModelClassFactory factory) {
	   super(parent, factory);
	   try {
	      this.add(MFA.class, false, false);
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error creating MFK_M01_MF - this is probably a bug in the source code generator.", e);
	   }
	}

	/**
	 * Returns MFA (Master file acknowledgement segment) - creates it if necessary
	 */
	public MFA getMFA() { 
	   MFA ret = null;
	   try {
	      ret = (MFA)this.get("MFA");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

}
