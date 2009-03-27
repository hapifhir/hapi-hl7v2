package ca.uhn.hl7v2.model.v24.group;

import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.log.HapiLogFactory;
import ca.uhn.hl7v2.model.v24.segment.*;

import ca.uhn.hl7v2.model.*;
/**
 * <p>Represents the PPV_PCA_PATIENT_VISIT Group.  A Group is an ordered collection of message 
 * segments that can repeat together or be optionally in/excluded together.
 * This Group contains the following elements: </p>
 * 0: PV1 (Patient visit) <b></b><br>
 * 1: PV2 (Patient visit - additional information) <b>optional </b><br>
 */
public class PPV_PCA_PATIENT_VISIT extends AbstractGroup {

	/** 
	 * Creates a new PPV_PCA_PATIENT_VISIT Group.
	 */
	public PPV_PCA_PATIENT_VISIT(Group parent, ModelClassFactory factory) {
	   super(parent, factory);
	   try {
	      this.add(PV1.class, true, false);
	      this.add(PV2.class, false, false);
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error creating PPV_PCA_PATIENT_VISIT - this is probably a bug in the source code generator.", e);
	   }
	}

	/**
	 * Returns PV1 (Patient visit) - creates it if necessary
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

	/**
	 * Returns PV2 (Patient visit - additional information) - creates it if necessary
	 */
	public PV2 getPV2() { 
	   PV2 ret = null;
	   try {
	      ret = (PV2)this.get("PV2");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

}
