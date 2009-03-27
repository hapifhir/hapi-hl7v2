package ca.uhn.hl7v2.model.v231.group;

import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.log.HapiLogFactory;
import ca.uhn.hl7v2.model.v231.segment.*;

import ca.uhn.hl7v2.model.*;
/**
 * <p>Represents the ORM_O01_RXCNTE Group.  A Group is an ordered collection of message 
 * segments that can repeat together or be optionally in/excluded together.
 * This Group contains the following elements: </p>
 * 0: RXC (RXC - pharmacy/treatment component order segment) <b></b><br>
 * 1: NTE (NTE - notes and comments segment) <b></b><br>
 */
public class ORM_O01_RXCNTE extends AbstractGroup {

	/** 
	 * Creates a new ORM_O01_RXCNTE Group.
	 */
	public ORM_O01_RXCNTE(Group parent, ModelClassFactory factory) {
	   super(parent, factory);
	   try {
	      this.add(RXC.class, true, false);
	      this.add(NTE.class, true, false);
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error creating ORM_O01_RXCNTE - this is probably a bug in the source code generator.", e);
	   }
	}

	/**
	 * Returns RXC (RXC - pharmacy/treatment component order segment) - creates it if necessary
	 */
	public RXC getRXC() { 
	   RXC ret = null;
	   try {
	      ret = (RXC)this.get("RXC");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns NTE (NTE - notes and comments segment) - creates it if necessary
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
