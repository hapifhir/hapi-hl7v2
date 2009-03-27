package ca.uhn.hl7v2.model.v231.group;

import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.log.HapiLogFactory;
import ca.uhn.hl7v2.model.v231.segment.*;

import ca.uhn.hl7v2.model.*;
/**
 * <p>Represents the PTR_PCF_ORCOBRRXONTEVAROBXNTEVAR Group.  A Group is an ordered collection of message 
 * segments that can repeat together or be optionally in/excluded together.
 * This Group contains the following elements: </p>
 * 0: ORC (ORC - common order segment) <b></b><br>
 * 1: PTR_PCF_OBRRXONTEVAROBXNTEVAR (a Group object) <b>optional </b><br>
 */
public class PTR_PCF_ORCOBRRXONTEVAROBXNTEVAR extends AbstractGroup {

	/** 
	 * Creates a new PTR_PCF_ORCOBRRXONTEVAROBXNTEVAR Group.
	 */
	public PTR_PCF_ORCOBRRXONTEVAROBXNTEVAR(Group parent, ModelClassFactory factory) {
	   super(parent, factory);
	   try {
	      this.add(ORC.class, true, false);
	      this.add(PTR_PCF_OBRRXONTEVAROBXNTEVAR.class, false, false);
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error creating PTR_PCF_ORCOBRRXONTEVAROBXNTEVAR - this is probably a bug in the source code generator.", e);
	   }
	}

	/**
	 * Returns ORC (ORC - common order segment) - creates it if necessary
	 */
	public ORC getORC() { 
	   ORC ret = null;
	   try {
	      ret = (ORC)this.get("ORC");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns PTR_PCF_OBRRXONTEVAROBXNTEVAR (a Group object) - creates it if necessary
	 */
	public PTR_PCF_OBRRXONTEVAROBXNTEVAR getOBRRXONTEVAROBXNTEVAR() { 
	   PTR_PCF_OBRRXONTEVAROBXNTEVAR ret = null;
	   try {
	      ret = (PTR_PCF_OBRRXONTEVAROBXNTEVAR)this.get("OBRRXONTEVAROBXNTEVAR");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

}
