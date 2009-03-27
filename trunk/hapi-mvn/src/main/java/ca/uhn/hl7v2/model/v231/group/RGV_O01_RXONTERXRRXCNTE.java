package ca.uhn.hl7v2.model.v231.group;

import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.log.HapiLogFactory;
import ca.uhn.hl7v2.model.v231.segment.*;

import ca.uhn.hl7v2.model.*;
/**
 * <p>Represents the RGV_O01_RXONTERXRRXCNTE Group.  A Group is an ordered collection of message 
 * segments that can repeat together or be optionally in/excluded together.
 * This Group contains the following elements: </p>
 * 0: RXO (RXO - pharmacy/treatment order segment) <b></b><br>
 * 1: RGV_O01_NTERXRRXCNTE (a Group object) <b>optional </b><br>
 */
public class RGV_O01_RXONTERXRRXCNTE extends AbstractGroup {

	/** 
	 * Creates a new RGV_O01_RXONTERXRRXCNTE Group.
	 */
	public RGV_O01_RXONTERXRRXCNTE(Group parent, ModelClassFactory factory) {
	   super(parent, factory);
	   try {
	      this.add(RXO.class, true, false);
	      this.add(RGV_O01_NTERXRRXCNTE.class, false, false);
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error creating RGV_O01_RXONTERXRRXCNTE - this is probably a bug in the source code generator.", e);
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
	 * Returns RGV_O01_NTERXRRXCNTE (a Group object) - creates it if necessary
	 */
	public RGV_O01_NTERXRRXCNTE getNTERXRRXCNTE() { 
	   RGV_O01_NTERXRRXCNTE ret = null;
	   try {
	      ret = (RGV_O01_NTERXRRXCNTE)this.get("NTERXRRXCNTE");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

}
