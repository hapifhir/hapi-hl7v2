package ca.uhn.hl7v2.model.v24.group;

import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.log.HapiLogFactory;
import ca.uhn.hl7v2.model.v24.segment.*;

import ca.uhn.hl7v2.model.*;
/**
 * <p>Represents the ORL_O22_GENERAL_ORDER Group.  A Group is an ordered collection of message 
 * segments that can repeat together or be optionally in/excluded together.
 * This Group contains the following elements: </p>
 * 0: ORL_O22_CONTAINER (a Group object) <b>optional </b><br>
 * 1: ORL_O22_ORDER (a Group object) <b>optional repeating</b><br>
 */
public class ORL_O22_GENERAL_ORDER extends AbstractGroup {

	/** 
	 * Creates a new ORL_O22_GENERAL_ORDER Group.
	 */
	public ORL_O22_GENERAL_ORDER(Group parent, ModelClassFactory factory) {
	   super(parent, factory);
	   try {
	      this.add(ORL_O22_CONTAINER.class, false, false);
	      this.add(ORL_O22_ORDER.class, false, true);
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error creating ORL_O22_GENERAL_ORDER - this is probably a bug in the source code generator.", e);
	   }
	}

	/**
	 * Returns ORL_O22_CONTAINER (a Group object) - creates it if necessary
	 */
	public ORL_O22_CONTAINER getCONTAINER() { 
	   ORL_O22_CONTAINER ret = null;
	   try {
	      ret = (ORL_O22_CONTAINER)this.get("CONTAINER");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns  first repetition of ORL_O22_ORDER (a Group object) - creates it if necessary
	 */
	public ORL_O22_ORDER getORDER() { 
	   ORL_O22_ORDER ret = null;
	   try {
	      ret = (ORL_O22_ORDER)this.get("ORDER");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns a specific repetition of ORL_O22_ORDER
	 * (a Group object) - creates it if necessary
	 * throws HL7Exception if the repetition requested is more than one 
	 *     greater than the number of existing repetitions.
	 */
	public ORL_O22_ORDER getORDER(int rep) throws HL7Exception { 
	   return (ORL_O22_ORDER)this.get("ORDER", rep);
	}

	/** 
	 * Returns the number of existing repetitions of ORL_O22_ORDER 
	 */ 
	public int getORDERReps() { 
	    int reps = -1; 
	    try { 
	        reps = this.getAll("ORDER").length; 
	    } catch (HL7Exception e) { 
	        String message = "Unexpected error accessing data - this is probably a bug in the source code generator."; 
	        HapiLogFactory.getHapiLog(this.getClass()).error(message, e); 
	        throw new RuntimeException(message);
	    } 
	    return reps; 
	} 

}
