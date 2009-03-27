package ca.uhn.hl7v2.model.v231.group;

import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.log.HapiLogFactory;
import ca.uhn.hl7v2.model.v231.segment.*;

import ca.uhn.hl7v2.model.*;
/**
 * <p>Represents the RRI_I12_AUTCTD Group.  A Group is an ordered collection of message 
 * segments that can repeat together or be optionally in/excluded together.
 * This Group contains the following elements: </p>
 * 0: AUT (Authorization Information) <b></b><br>
 * 1: CTD (Contact Data) <b>optional </b><br>
 */
public class RRI_I12_AUTCTD extends AbstractGroup {

	/** 
	 * Creates a new RRI_I12_AUTCTD Group.
	 */
	public RRI_I12_AUTCTD(Group parent, ModelClassFactory factory) {
	   super(parent, factory);
	   try {
	      this.add(AUT.class, true, false);
	      this.add(CTD.class, false, false);
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error creating RRI_I12_AUTCTD - this is probably a bug in the source code generator.", e);
	   }
	}

	/**
	 * Returns AUT (Authorization Information) - creates it if necessary
	 */
	public AUT getAUT() { 
	   AUT ret = null;
	   try {
	      ret = (AUT)this.get("AUT");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns CTD (Contact Data) - creates it if necessary
	 */
	public CTD getCTD() { 
	   CTD ret = null;
	   try {
	      ret = (CTD)this.get("CTD");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

}
