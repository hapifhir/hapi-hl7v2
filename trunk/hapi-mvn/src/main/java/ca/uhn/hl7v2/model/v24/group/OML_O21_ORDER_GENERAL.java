package ca.uhn.hl7v2.model.v24.group;

import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.log.HapiLogFactory;
import ca.uhn.hl7v2.model.v24.segment.*;

import ca.uhn.hl7v2.model.*;
/**
 * <p>Represents the OML_O21_ORDER_GENERAL Group.  A Group is an ordered collection of message 
 * segments that can repeat together or be optionally in/excluded together.
 * This Group contains the following elements: </p>
 * 0: OML_O21_CONTAINER_1 (a Group object) <b>optional </b><br>
 * 1: OML_O21_ORDER (a Group object) <b>repeating</b><br>
 */
public class OML_O21_ORDER_GENERAL extends AbstractGroup {

	/** 
	 * Creates a new OML_O21_ORDER_GENERAL Group.
	 */
	public OML_O21_ORDER_GENERAL(Group parent, ModelClassFactory factory) {
	   super(parent, factory);
	   try {
	      this.add(OML_O21_CONTAINER_1.class, false, false);
	      this.add(OML_O21_ORDER.class, true, true);
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error creating OML_O21_ORDER_GENERAL - this is probably a bug in the source code generator.", e);
	   }
	}

	/**
	 * Returns OML_O21_CONTAINER_1 (a Group object) - creates it if necessary
	 */
	public OML_O21_CONTAINER_1 getCONTAINER_1() { 
	   OML_O21_CONTAINER_1 ret = null;
	   try {
	      ret = (OML_O21_CONTAINER_1)this.get("CONTAINER_1");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns  first repetition of OML_O21_ORDER (a Group object) - creates it if necessary
	 */
	public OML_O21_ORDER getORDER() { 
	   OML_O21_ORDER ret = null;
	   try {
	      ret = (OML_O21_ORDER)this.get("ORDER");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns a specific repetition of OML_O21_ORDER
	 * (a Group object) - creates it if necessary
	 * throws HL7Exception if the repetition requested is more than one 
	 *     greater than the number of existing repetitions.
	 */
	public OML_O21_ORDER getORDER(int rep) throws HL7Exception { 
	   return (OML_O21_ORDER)this.get("ORDER", rep);
	}

	/** 
	 * Returns the number of existing repetitions of OML_O21_ORDER 
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
