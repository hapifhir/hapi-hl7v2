package ca.uhn.hl7v2.model.v25.group;

import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.log.HapiLogFactory;
import ca.uhn.hl7v2.model.v25.segment.*;

import ca.uhn.hl7v2.model.*;
/**
 * <p>Represents the OUL_R23_CONTAINER Group.  A Group is an ordered collection of message 
 * segments that can repeat together or be optionally in/excluded together.
 * This Group contains the following elements: </p>
 * 0: SAC (Specimen Container detail) <b></b><br>
 * 1: INV (Inventory Detail) <b>optional </b><br>
 * 2: OUL_R23_ORDER (a Group object) <b>repeating</b><br>
 */
public class OUL_R23_CONTAINER extends AbstractGroup {

	/** 
	 * Creates a new OUL_R23_CONTAINER Group.
	 */
	public OUL_R23_CONTAINER(Group parent, ModelClassFactory factory) {
	   super(parent, factory);
	   try {
	      this.add(SAC.class, true, false);
	      this.add(INV.class, false, false);
	      this.add(OUL_R23_ORDER.class, true, true);
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error creating OUL_R23_CONTAINER - this is probably a bug in the source code generator.", e);
	   }
	}

	/**
	 * Returns SAC (Specimen Container detail) - creates it if necessary
	 */
	public SAC getSAC() { 
	   SAC ret = null;
	   try {
	      ret = (SAC)this.get("SAC");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns INV (Inventory Detail) - creates it if necessary
	 */
	public INV getINV() { 
	   INV ret = null;
	   try {
	      ret = (INV)this.get("INV");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns  first repetition of OUL_R23_ORDER (a Group object) - creates it if necessary
	 */
	public OUL_R23_ORDER getORDER() { 
	   OUL_R23_ORDER ret = null;
	   try {
	      ret = (OUL_R23_ORDER)this.get("ORDER");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns a specific repetition of OUL_R23_ORDER
	 * (a Group object) - creates it if necessary
	 * throws HL7Exception if the repetition requested is more than one 
	 *     greater than the number of existing repetitions.
	 */
	public OUL_R23_ORDER getORDER(int rep) throws HL7Exception { 
	   return (OUL_R23_ORDER)this.get("ORDER", rep);
	}

	/** 
	 * Returns the number of existing repetitions of OUL_R23_ORDER 
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
