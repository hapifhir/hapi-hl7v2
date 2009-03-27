package ca.uhn.hl7v2.model.v25.group;

import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.log.HapiLogFactory;
import ca.uhn.hl7v2.model.v25.segment.*;

import ca.uhn.hl7v2.model.*;
/**
 * <p>Represents the EAC_U07_COMMAND Group.  A Group is an ordered collection of message 
 * segments that can repeat together or be optionally in/excluded together.
 * This Group contains the following elements: </p>
 * 0: ECD (Equipment Command) <b></b><br>
 * 1: TQ1 (Timing/Quantity) <b>optional </b><br>
 * 2: EAC_U07_SPECIMEN_CONTAINER (a Group object) <b>optional </b><br>
 * 3: CNS (Clear Notification) <b>optional </b><br>
 */
public class EAC_U07_COMMAND extends AbstractGroup {

	/** 
	 * Creates a new EAC_U07_COMMAND Group.
	 */
	public EAC_U07_COMMAND(Group parent, ModelClassFactory factory) {
	   super(parent, factory);
	   try {
	      this.add(ECD.class, true, false);
	      this.add(TQ1.class, false, false);
	      this.add(EAC_U07_SPECIMEN_CONTAINER.class, false, false);
	      this.add(CNS.class, false, false);
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error creating EAC_U07_COMMAND - this is probably a bug in the source code generator.", e);
	   }
	}

	/**
	 * Returns ECD (Equipment Command) - creates it if necessary
	 */
	public ECD getECD() { 
	   ECD ret = null;
	   try {
	      ret = (ECD)this.get("ECD");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns TQ1 (Timing/Quantity) - creates it if necessary
	 */
	public TQ1 getTQ1() { 
	   TQ1 ret = null;
	   try {
	      ret = (TQ1)this.get("TQ1");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns EAC_U07_SPECIMEN_CONTAINER (a Group object) - creates it if necessary
	 */
	public EAC_U07_SPECIMEN_CONTAINER getSPECIMEN_CONTAINER() { 
	   EAC_U07_SPECIMEN_CONTAINER ret = null;
	   try {
	      ret = (EAC_U07_SPECIMEN_CONTAINER)this.get("SPECIMEN_CONTAINER");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns CNS (Clear Notification) - creates it if necessary
	 */
	public CNS getCNS() { 
	   CNS ret = null;
	   try {
	      ret = (CNS)this.get("CNS");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

}
