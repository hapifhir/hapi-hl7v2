package ca.uhn.hl7v2.model.v231.group;

import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.log.HapiLogFactory;
import ca.uhn.hl7v2.model.v231.segment.*;

import ca.uhn.hl7v2.model.*;
/**
 * <p>Represents the RRO_O02_ORCRXONTERXRRXCNTE Group.  A Group is an ordered collection of message 
 * segments that can repeat together or be optionally in/excluded together.
 * This Group contains the following elements: </p>
 * 0: ORC (ORC - common order segment) <b></b><br>
 * 1: RRO_O02_RXONTERXRRXCNTE (a Group object) <b>optional </b><br>
 */
public class RRO_O02_ORCRXONTERXRRXCNTE extends AbstractGroup {

	/** 
	 * Creates a new RRO_O02_ORCRXONTERXRRXCNTE Group.
	 */
	public RRO_O02_ORCRXONTERXRRXCNTE(Group parent, ModelClassFactory factory) {
	   super(parent, factory);
	   try {
	      this.add(ORC.class, true, false);
	      this.add(RRO_O02_RXONTERXRRXCNTE.class, false, false);
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error creating RRO_O02_ORCRXONTERXRRXCNTE - this is probably a bug in the source code generator.", e);
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
	 * Returns RRO_O02_RXONTERXRRXCNTE (a Group object) - creates it if necessary
	 */
	public RRO_O02_RXONTERXRRXCNTE getRXONTERXRRXCNTE() { 
	   RRO_O02_RXONTERXRRXCNTE ret = null;
	   try {
	      ret = (RRO_O02_RXONTERXRRXCNTE)this.get("RXONTERXRRXCNTE");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

}
