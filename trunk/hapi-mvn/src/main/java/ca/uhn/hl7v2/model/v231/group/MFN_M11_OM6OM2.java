package ca.uhn.hl7v2.model.v231.group;

import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.log.HapiLogFactory;
import ca.uhn.hl7v2.model.v231.segment.*;

import ca.uhn.hl7v2.model.*;
/**
 * <p>Represents the MFN_M11_OM6OM2 Group.  A Group is an ordered collection of message 
 * segments that can repeat together or be optionally in/excluded together.
 * This Group contains the following elements: </p>
 * 0: OM6 (OM6 - Observations that are calculated from other observations segment) <b></b><br>
 * 1: OM2 (OM2 - numeric observation segment) <b></b><br>
 */
public class MFN_M11_OM6OM2 extends AbstractGroup {

	/** 
	 * Creates a new MFN_M11_OM6OM2 Group.
	 */
	public MFN_M11_OM6OM2(Group parent, ModelClassFactory factory) {
	   super(parent, factory);
	   try {
	      this.add(OM6.class, true, false);
	      this.add(OM2.class, true, false);
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error creating MFN_M11_OM6OM2 - this is probably a bug in the source code generator.", e);
	   }
	}

	/**
	 * Returns OM6 (OM6 - Observations that are calculated from other observations segment) - creates it if necessary
	 */
	public OM6 getOM6() { 
	   OM6 ret = null;
	   try {
	      ret = (OM6)this.get("OM6");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns OM2 (OM2 - numeric observation segment) - creates it if necessary
	 */
	public OM2 getOM2() { 
	   OM2 ret = null;
	   try {
	      ret = (OM2)this.get("OM2");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

}
