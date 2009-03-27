package ca.uhn.hl7v2.model.v24.group;

import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.log.HapiLogFactory;
import ca.uhn.hl7v2.model.v24.segment.*;

import ca.uhn.hl7v2.model.*;
/**
 * <p>Represents the ORD_O04_RESPONSE Group.  A Group is an ordered collection of message 
 * segments that can repeat together or be optionally in/excluded together.
 * This Group contains the following elements: </p>
 * 0: ORD_O04_PATIENT (a Group object) <b>optional </b><br>
 * 1: ORD_O04_ORDER_DIET (a Group object) <b>repeating</b><br>
 * 2: ORD_O04_ORDER_TRAY (a Group object) <b>optional repeating</b><br>
 */
public class ORD_O04_RESPONSE extends AbstractGroup {

	/** 
	 * Creates a new ORD_O04_RESPONSE Group.
	 */
	public ORD_O04_RESPONSE(Group parent, ModelClassFactory factory) {
	   super(parent, factory);
	   try {
	      this.add(ORD_O04_PATIENT.class, false, false);
	      this.add(ORD_O04_ORDER_DIET.class, true, true);
	      this.add(ORD_O04_ORDER_TRAY.class, false, true);
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error creating ORD_O04_RESPONSE - this is probably a bug in the source code generator.", e);
	   }
	}

	/**
	 * Returns ORD_O04_PATIENT (a Group object) - creates it if necessary
	 */
	public ORD_O04_PATIENT getPATIENT() { 
	   ORD_O04_PATIENT ret = null;
	   try {
	      ret = (ORD_O04_PATIENT)this.get("PATIENT");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns  first repetition of ORD_O04_ORDER_DIET (a Group object) - creates it if necessary
	 */
	public ORD_O04_ORDER_DIET getORDER_DIET() { 
	   ORD_O04_ORDER_DIET ret = null;
	   try {
	      ret = (ORD_O04_ORDER_DIET)this.get("ORDER_DIET");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns a specific repetition of ORD_O04_ORDER_DIET
	 * (a Group object) - creates it if necessary
	 * throws HL7Exception if the repetition requested is more than one 
	 *     greater than the number of existing repetitions.
	 */
	public ORD_O04_ORDER_DIET getORDER_DIET(int rep) throws HL7Exception { 
	   return (ORD_O04_ORDER_DIET)this.get("ORDER_DIET", rep);
	}

	/** 
	 * Returns the number of existing repetitions of ORD_O04_ORDER_DIET 
	 */ 
	public int getORDER_DIETReps() { 
	    int reps = -1; 
	    try { 
	        reps = this.getAll("ORDER_DIET").length; 
	    } catch (HL7Exception e) { 
	        String message = "Unexpected error accessing data - this is probably a bug in the source code generator."; 
	        HapiLogFactory.getHapiLog(this.getClass()).error(message, e); 
	        throw new RuntimeException(message);
	    } 
	    return reps; 
	} 

	/**
	 * Returns  first repetition of ORD_O04_ORDER_TRAY (a Group object) - creates it if necessary
	 */
	public ORD_O04_ORDER_TRAY getORDER_TRAY() { 
	   ORD_O04_ORDER_TRAY ret = null;
	   try {
	      ret = (ORD_O04_ORDER_TRAY)this.get("ORDER_TRAY");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns a specific repetition of ORD_O04_ORDER_TRAY
	 * (a Group object) - creates it if necessary
	 * throws HL7Exception if the repetition requested is more than one 
	 *     greater than the number of existing repetitions.
	 */
	public ORD_O04_ORDER_TRAY getORDER_TRAY(int rep) throws HL7Exception { 
	   return (ORD_O04_ORDER_TRAY)this.get("ORDER_TRAY", rep);
	}

	/** 
	 * Returns the number of existing repetitions of ORD_O04_ORDER_TRAY 
	 */ 
	public int getORDER_TRAYReps() { 
	    int reps = -1; 
	    try { 
	        reps = this.getAll("ORDER_TRAY").length; 
	    } catch (HL7Exception e) { 
	        String message = "Unexpected error accessing data - this is probably a bug in the source code generator."; 
	        HapiLogFactory.getHapiLog(this.getClass()).error(message, e); 
	        throw new RuntimeException(message);
	    } 
	    return reps; 
	} 

}
