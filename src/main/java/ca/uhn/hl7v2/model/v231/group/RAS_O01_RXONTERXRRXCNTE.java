package ca.uhn.hl7v2.model.v231.group;

import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.log.HapiLogFactory;
import ca.uhn.hl7v2.model.v231.segment.*;

import ca.uhn.hl7v2.model.*;
/**
 * <p>Represents the RAS_O01_RXONTERXRRXCNTE Group.  A Group is an ordered collection of message 
 * segments that can repeat together or be optionally in/excluded together.
 * This Group contains the following elements: </p>
 * 0: RXO (RXO - pharmacy/treatment order segment) <b></b><br>
 * 1: RAS_O01_NTERXRRXCNTE (a Group object) <b>optional </b><br>
 */
public class RAS_O01_RXONTERXRRXCNTE extends AbstractGroup {

	/** 
	 * Creates a new RAS_O01_RXONTERXRRXCNTE Group.
	 */
	public RAS_O01_RXONTERXRRXCNTE(Group parent, ModelClassFactory factory) {
	   super(parent, factory);
	   try {
	      this.add(RXO.class, true, false);
	      this.add(RAS_O01_NTERXRRXCNTE.class, false, false);
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error creating RAS_O01_RXONTERXRRXCNTE - this is probably a bug in the source code generator.", e);
	   }
	}

	/**
	 * Returns RXO (RXO - pharmacy/treatment order segment) - creates it if necessary
	 */
	public RXO getRXO() { 
	   RXO ret = null;
	   try {
	      ret = (RXO)this.get("RXO");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns RAS_O01_NTERXRRXCNTE (a Group object) - creates it if necessary
	 */
	public RAS_O01_NTERXRRXCNTE getNTERXRRXCNTE() { 
	   RAS_O01_NTERXRRXCNTE ret = null;
	   try {
	      ret = (RAS_O01_NTERXRRXCNTE)this.get("NTERXRRXCNTE");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

}
