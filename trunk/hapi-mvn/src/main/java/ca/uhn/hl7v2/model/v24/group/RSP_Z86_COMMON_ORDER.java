package ca.uhn.hl7v2.model.v24.group;

import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.log.HapiLogFactory;
import ca.uhn.hl7v2.model.v24.segment.*;

import ca.uhn.hl7v2.model.*;
/**
 * <p>Represents the RSP_Z86_COMMON_ORDER Group.  A Group is an ordered collection of message 
 * segments that can repeat together or be optionally in/excluded together.
 * This Group contains the following elements: </p>
 * 0: ORC (Common Order) <b></b><br>
 * 1: RSP_Z86_ORDER_DETAIL (a Group object) <b>optional </b><br>
 * 2: RSP_Z86_ENCODED_ORDER (a Group object) <b>optional </b><br>
 * 3: RSP_Z86_DISPENSE (a Group object) <b>optional </b><br>
 * 4: RSP_Z86_GIVE (a Group object) <b>optional </b><br>
 * 5: RSP_Z86_ADMINISTRATION (a Group object) <b>optional </b><br>
 * 6: RSP_Z86_OBSERVATION (a Group object) <b>repeating</b><br>
 */
public class RSP_Z86_COMMON_ORDER extends AbstractGroup {

	/** 
	 * Creates a new RSP_Z86_COMMON_ORDER Group.
	 */
	public RSP_Z86_COMMON_ORDER(Group parent, ModelClassFactory factory) {
	   super(parent, factory);
	   try {
	      this.add(ORC.class, true, false);
	      this.add(RSP_Z86_ORDER_DETAIL.class, false, false);
	      this.add(RSP_Z86_ENCODED_ORDER.class, false, false);
	      this.add(RSP_Z86_DISPENSE.class, false, false);
	      this.add(RSP_Z86_GIVE.class, false, false);
	      this.add(RSP_Z86_ADMINISTRATION.class, false, false);
	      this.add(RSP_Z86_OBSERVATION.class, true, true);
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error creating RSP_Z86_COMMON_ORDER - this is probably a bug in the source code generator.", e);
	   }
	}

	/**
	 * Returns ORC (Common Order) - creates it if necessary
	 */
	public ORC getORC() { 
	   ORC ret = null;
	   try {
	      ret = (ORC)this.get("ORC");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns RSP_Z86_ORDER_DETAIL (a Group object) - creates it if necessary
	 */
	public RSP_Z86_ORDER_DETAIL getORDER_DETAIL() { 
	   RSP_Z86_ORDER_DETAIL ret = null;
	   try {
	      ret = (RSP_Z86_ORDER_DETAIL)this.get("ORDER_DETAIL");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns RSP_Z86_ENCODED_ORDER (a Group object) - creates it if necessary
	 */
	public RSP_Z86_ENCODED_ORDER getENCODED_ORDER() { 
	   RSP_Z86_ENCODED_ORDER ret = null;
	   try {
	      ret = (RSP_Z86_ENCODED_ORDER)this.get("ENCODED_ORDER");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns RSP_Z86_DISPENSE (a Group object) - creates it if necessary
	 */
	public RSP_Z86_DISPENSE getDISPENSE() { 
	   RSP_Z86_DISPENSE ret = null;
	   try {
	      ret = (RSP_Z86_DISPENSE)this.get("DISPENSE");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns RSP_Z86_GIVE (a Group object) - creates it if necessary
	 */
	public RSP_Z86_GIVE getGIVE() { 
	   RSP_Z86_GIVE ret = null;
	   try {
	      ret = (RSP_Z86_GIVE)this.get("GIVE");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns RSP_Z86_ADMINISTRATION (a Group object) - creates it if necessary
	 */
	public RSP_Z86_ADMINISTRATION getADMINISTRATION() { 
	   RSP_Z86_ADMINISTRATION ret = null;
	   try {
	      ret = (RSP_Z86_ADMINISTRATION)this.get("ADMINISTRATION");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns  first repetition of RSP_Z86_OBSERVATION (a Group object) - creates it if necessary
	 */
	public RSP_Z86_OBSERVATION getOBSERVATION() { 
	   RSP_Z86_OBSERVATION ret = null;
	   try {
	      ret = (RSP_Z86_OBSERVATION)this.get("OBSERVATION");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns a specific repetition of RSP_Z86_OBSERVATION
	 * (a Group object) - creates it if necessary
	 * throws HL7Exception if the repetition requested is more than one 
	 *     greater than the number of existing repetitions.
	 */
	public RSP_Z86_OBSERVATION getOBSERVATION(int rep) throws HL7Exception { 
	   return (RSP_Z86_OBSERVATION)this.get("OBSERVATION", rep);
	}

	/** 
	 * Returns the number of existing repetitions of RSP_Z86_OBSERVATION 
	 */ 
	public int getOBSERVATIONReps() { 
	    int reps = -1; 
	    try { 
	        reps = this.getAll("OBSERVATION").length; 
	    } catch (HL7Exception e) { 
	        String message = "Unexpected error accessing data - this is probably a bug in the source code generator."; 
	        HapiLogFactory.getHapiLog(this.getClass()).error(message, e); 
	        throw new RuntimeException(message);
	    } 
	    return reps; 
	} 

}
