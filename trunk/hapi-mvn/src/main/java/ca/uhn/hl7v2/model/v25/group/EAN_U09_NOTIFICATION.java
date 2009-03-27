package ca.uhn.hl7v2.model.v25.group;

import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.log.HapiLogFactory;
import ca.uhn.hl7v2.model.v25.segment.*;

import ca.uhn.hl7v2.model.*;
/**
 * <p>Represents the EAN_U09_NOTIFICATION Group.  A Group is an ordered collection of message 
 * segments that can repeat together or be optionally in/excluded together.
 * This Group contains the following elements: </p>
 * 0: NDS (Notification Detail) <b></b><br>
 * 1: NTE (Notes and Comments) <b>optional </b><br>
 */
public class EAN_U09_NOTIFICATION extends AbstractGroup {

	/** 
	 * Creates a new EAN_U09_NOTIFICATION Group.
	 */
	public EAN_U09_NOTIFICATION(Group parent, ModelClassFactory factory) {
	   super(parent, factory);
	   try {
	      this.add(NDS.class, true, false);
	      this.add(NTE.class, false, false);
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error creating EAN_U09_NOTIFICATION - this is probably a bug in the source code generator.", e);
	   }
	}

	/**
	 * Returns NDS (Notification Detail) - creates it if necessary
	 */
	public NDS getNDS() { 
	   NDS ret = null;
	   try {
	      ret = (NDS)this.get("NDS");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns NTE (Notes and Comments) - creates it if necessary
	 */
	public NTE getNTE() { 
	   NTE ret = null;
	   try {
	      ret = (NTE)this.get("NTE");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

}
