package ca.uhn.hl7v2.model.v231.group;

import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.log.HapiLogFactory;
import ca.uhn.hl7v2.model.v231.segment.*;

import ca.uhn.hl7v2.model.*;
/**
 * <p>Represents the RRD_O02_ORCRXDRXRRXC Group.  A Group is an ordered collection of message 
 * segments that can repeat together or be optionally in/excluded together.
 * This Group contains the following elements: </p>
 * 0: ORC (ORC - common order segment) <b></b><br>
 * 1: RRD_O02_RXDRXRRXC (a Group object) <b>optional </b><br>
 */
public class RRD_O02_ORCRXDRXRRXC extends AbstractGroup {

	/** 
	 * Creates a new RRD_O02_ORCRXDRXRRXC Group.
	 */
	public RRD_O02_ORCRXDRXRRXC(Group parent, ModelClassFactory factory) {
	   super(parent, factory);
	   try {
	      this.add(ORC.class, true, false);
	      this.add(RRD_O02_RXDRXRRXC.class, false, false);
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error creating RRD_O02_ORCRXDRXRRXC - this is probably a bug in the source code generator.", e);
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
	 * Returns RRD_O02_RXDRXRRXC (a Group object) - creates it if necessary
	 */
	public RRD_O02_RXDRXRRXC getRXDRXRRXC() { 
	   RRD_O02_RXDRXRRXC ret = null;
	   try {
	      ret = (RRD_O02_RXDRXRRXC)this.get("RXDRXRRXC");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

}
