package ca.uhn.hl7v2.model.v231.group;

import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.log.HapiLogFactory;
import ca.uhn.hl7v2.model.v231.segment.*;

import ca.uhn.hl7v2.model.*;
/**
 * <p>Represents the OMS_O01_ORCRQDNTEOBXNTEBLG Group.  A Group is an ordered collection of message 
 * segments that can repeat together or be optionally in/excluded together.
 * This Group contains the following elements: </p>
 * 0: ORC (ORC - common order segment) <b></b><br>
 * 1: OMS_O01_RQDNTEOBXNTE (a Group object) <b>optional </b><br>
 * 2: BLG (BLG - billing segment) <b>optional </b><br>
 */
public class OMS_O01_ORCRQDNTEOBXNTEBLG extends AbstractGroup {

	/** 
	 * Creates a new OMS_O01_ORCRQDNTEOBXNTEBLG Group.
	 */
	public OMS_O01_ORCRQDNTEOBXNTEBLG(Group parent, ModelClassFactory factory) {
	   super(parent, factory);
	   try {
	      this.add(ORC.class, true, false);
	      this.add(OMS_O01_RQDNTEOBXNTE.class, false, false);
	      this.add(BLG.class, false, false);
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error creating OMS_O01_ORCRQDNTEOBXNTEBLG - this is probably a bug in the source code generator.", e);
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
	 * Returns OMS_O01_RQDNTEOBXNTE (a Group object) - creates it if necessary
	 */
	public OMS_O01_RQDNTEOBXNTE getRQDNTEOBXNTE() { 
	   OMS_O01_RQDNTEOBXNTE ret = null;
	   try {
	      ret = (OMS_O01_RQDNTEOBXNTE)this.get("RQDNTEOBXNTE");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns BLG (BLG - billing segment) - creates it if necessary
	 */
	public BLG getBLG() { 
	   BLG ret = null;
	   try {
	      ret = (BLG)this.get("BLG");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

}
