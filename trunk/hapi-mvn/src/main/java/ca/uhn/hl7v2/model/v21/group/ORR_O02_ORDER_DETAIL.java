package ca.uhn.hl7v2.model.v21.group;

import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.log.HapiLogFactory;
import ca.uhn.hl7v2.model.v21.segment.*;

import ca.uhn.hl7v2.model.*;
/**
 * <p>Represents the ORR_O02_ORDER_DETAIL Group.  A Group is an ordered collection of message 
 * segments that can repeat together or be optionally in/excluded together.
 * This Group contains the following elements: </p>
 * 0: OBR (OBSERVATION REQUEST) <b></b><br>
 * 1: ORO (ORDER OTHER) <b></b><br>
 * 2: RX1 (PHARMACY ORDER) <b></b><br>
 */
public class ORR_O02_ORDER_DETAIL extends AbstractGroup {

	/** 
	 * Creates a new ORR_O02_ORDER_DETAIL Group.
	 */
	public ORR_O02_ORDER_DETAIL(Group parent, ModelClassFactory factory) {
	   super(parent, factory);
	   try {
	      this.add(OBR.class, true, false);
	      this.add(ORO.class, true, false);
	      this.add(RX1.class, true, false);
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error creating ORR_O02_ORDER_DETAIL - this is probably a bug in the source code generator.", e);
	   }
	}

	/**
	 * Returns OBR (OBSERVATION REQUEST) - creates it if necessary
	 */
	public OBR getOBR() { 
	   OBR ret = null;
	   try {
	      ret = (OBR)this.get("OBR");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns ORO (ORDER OTHER) - creates it if necessary
	 */
	public ORO getORO() { 
	   ORO ret = null;
	   try {
	      ret = (ORO)this.get("ORO");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns RX1 (PHARMACY ORDER) - creates it if necessary
	 */
	public RX1 getRX1() { 
	   RX1 ret = null;
	   try {
	      ret = (RX1)this.get("RX1");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

}
