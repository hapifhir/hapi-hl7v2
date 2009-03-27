package ca.uhn.hl7v2.model.v25.group;

import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.log.HapiLogFactory;
import ca.uhn.hl7v2.model.v25.segment.*;

import ca.uhn.hl7v2.model.*;
/**
 * <p>Represents the ADT_A45_MERGE_INFO Group.  A Group is an ordered collection of message 
 * segments that can repeat together or be optionally in/excluded together.
 * This Group contains the following elements: </p>
 * 0: MRG (Merge Patient Information) <b></b><br>
 * 1: PV1 (Patient Visit) <b></b><br>
 */
public class ADT_A45_MERGE_INFO extends AbstractGroup {

	/** 
	 * Creates a new ADT_A45_MERGE_INFO Group.
	 */
	public ADT_A45_MERGE_INFO(Group parent, ModelClassFactory factory) {
	   super(parent, factory);
	   try {
	      this.add(MRG.class, true, false);
	      this.add(PV1.class, true, false);
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error creating ADT_A45_MERGE_INFO - this is probably a bug in the source code generator.", e);
	   }
	}

	/**
	 * Returns MRG (Merge Patient Information) - creates it if necessary
	 */
	public MRG getMRG() { 
	   MRG ret = null;
	   try {
	      ret = (MRG)this.get("MRG");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns PV1 (Patient Visit) - creates it if necessary
	 */
	public PV1 getPV1() { 
	   PV1 ret = null;
	   try {
	      ret = (PV1)this.get("PV1");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

}
