package ca.uhn.hl7v2.model.v24.group;

import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.log.HapiLogFactory;
import ca.uhn.hl7v2.model.v24.segment.*;

import ca.uhn.hl7v2.model.*;
/**
 * <p>Represents the SUR_P09_PRODUCT Group.  A Group is an ordered collection of message 
 * segments that can repeat together or be optionally in/excluded together.
 * This Group contains the following elements: </p>
 * 0: PSH (Product Summary Header) <b></b><br>
 * 1: PDC (Product Detail Country) <b></b><br>
 */
public class SUR_P09_PRODUCT extends AbstractGroup {

	/** 
	 * Creates a new SUR_P09_PRODUCT Group.
	 */
	public SUR_P09_PRODUCT(Group parent, ModelClassFactory factory) {
	   super(parent, factory);
	   try {
	      this.add(PSH.class, true, false);
	      this.add(PDC.class, true, false);
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error creating SUR_P09_PRODUCT - this is probably a bug in the source code generator.", e);
	   }
	}

	/**
	 * Returns PSH (Product Summary Header) - creates it if necessary
	 */
	public PSH getPSH() { 
	   PSH ret = null;
	   try {
	      ret = (PSH)this.get("PSH");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns PDC (Product Detail Country) - creates it if necessary
	 */
	public PDC getPDC() { 
	   PDC ret = null;
	   try {
	      ret = (PDC)this.get("PDC");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

}
