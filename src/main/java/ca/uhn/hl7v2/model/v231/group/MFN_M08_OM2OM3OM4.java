package ca.uhn.hl7v2.model.v231.group;

import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.log.HapiLogFactory;
import ca.uhn.hl7v2.model.v231.segment.*;

import ca.uhn.hl7v2.model.*;
/**
 * <p>Represents the MFN_M08_OM2OM3OM4 Group.  A Group is an ordered collection of message 
 * segments that can repeat together or be optionally in/excluded together.
 * This Group contains the following elements: </p>
 * 0: OM2 (OM2 - numeric observation segment) <b>optional </b><br>
 * 1: OM3 (OM3 - categorical test/observation segment) <b>optional </b><br>
 * 2: OM4 (OM4 - observations that require specimens segment) <b>optional </b><br>
 */
public class MFN_M08_OM2OM3OM4 extends AbstractGroup {

	/** 
	 * Creates a new MFN_M08_OM2OM3OM4 Group.
	 */
	public MFN_M08_OM2OM3OM4(Group parent, ModelClassFactory factory) {
	   super(parent, factory);
	   try {
	      this.add(OM2.class, false, false);
	      this.add(OM3.class, false, false);
	      this.add(OM4.class, false, false);
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error creating MFN_M08_OM2OM3OM4 - this is probably a bug in the source code generator.", e);
	   }
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

	/**
	 * Returns OM3 (OM3 - categorical test/observation segment) - creates it if necessary
	 */
	public OM3 getOM3() { 
	   OM3 ret = null;
	   try {
	      ret = (OM3)this.get("OM3");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns OM4 (OM4 - observations that require specimens segment) - creates it if necessary
	 */
	public OM4 getOM4() { 
	   OM4 ret = null;
	   try {
	      ret = (OM4)this.get("OM4");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

}
