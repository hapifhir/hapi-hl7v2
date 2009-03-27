package ca.uhn.hl7v2.model.v25.group;

import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.log.HapiLogFactory;
import ca.uhn.hl7v2.model.v25.segment.*;

import ca.uhn.hl7v2.model.*;
/**
 * <p>Represents the RAS_O17_ORDER Group.  A Group is an ordered collection of message 
 * segments that can repeat together or be optionally in/excluded together.
 * This Group contains the following elements: </p>
 * 0: ORC (Common Order) <b></b><br>
 * 1: RAS_O17_TIMING (a Group object) <b>optional repeating</b><br>
 * 2: RAS_O17_ORDER_DETAIL (a Group object) <b>optional </b><br>
 * 3: RAS_O17_ENCODING (a Group object) <b>optional </b><br>
 * 4: RAS_O17_ADMINISTRATION (a Group object) <b>repeating</b><br>
 * 5: CTI (Clinical Trial Identification) <b>optional repeating</b><br>
 */
public class RAS_O17_ORDER extends AbstractGroup {

	/** 
	 * Creates a new RAS_O17_ORDER Group.
	 */
	public RAS_O17_ORDER(Group parent, ModelClassFactory factory) {
	   super(parent, factory);
	   try {
	      this.add(ORC.class, true, false);
	      this.add(RAS_O17_TIMING.class, false, true);
	      this.add(RAS_O17_ORDER_DETAIL.class, false, false);
	      this.add(RAS_O17_ENCODING.class, false, false);
	      this.add(RAS_O17_ADMINISTRATION.class, true, true);
	      this.add(CTI.class, false, true);
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error creating RAS_O17_ORDER - this is probably a bug in the source code generator.", e);
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
	 * Returns  first repetition of RAS_O17_TIMING (a Group object) - creates it if necessary
	 */
	public RAS_O17_TIMING getTIMING() { 
	   RAS_O17_TIMING ret = null;
	   try {
	      ret = (RAS_O17_TIMING)this.get("TIMING");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns a specific repetition of RAS_O17_TIMING
	 * (a Group object) - creates it if necessary
	 * throws HL7Exception if the repetition requested is more than one 
	 *     greater than the number of existing repetitions.
	 */
	public RAS_O17_TIMING getTIMING(int rep) throws HL7Exception { 
	   return (RAS_O17_TIMING)this.get("TIMING", rep);
	}

	/** 
	 * Returns the number of existing repetitions of RAS_O17_TIMING 
	 */ 
	public int getTIMINGReps() { 
	    int reps = -1; 
	    try { 
	        reps = this.getAll("TIMING").length; 
	    } catch (HL7Exception e) { 
	        String message = "Unexpected error accessing data - this is probably a bug in the source code generator."; 
	        HapiLogFactory.getHapiLog(this.getClass()).error(message, e); 
	        throw new RuntimeException(message);
	    } 
	    return reps; 
	} 

	/**
	 * Returns RAS_O17_ORDER_DETAIL (a Group object) - creates it if necessary
	 */
	public RAS_O17_ORDER_DETAIL getORDER_DETAIL() { 
	   RAS_O17_ORDER_DETAIL ret = null;
	   try {
	      ret = (RAS_O17_ORDER_DETAIL)this.get("ORDER_DETAIL");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns RAS_O17_ENCODING (a Group object) - creates it if necessary
	 */
	public RAS_O17_ENCODING getENCODING() { 
	   RAS_O17_ENCODING ret = null;
	   try {
	      ret = (RAS_O17_ENCODING)this.get("ENCODING");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns  first repetition of RAS_O17_ADMINISTRATION (a Group object) - creates it if necessary
	 */
	public RAS_O17_ADMINISTRATION getADMINISTRATION() { 
	   RAS_O17_ADMINISTRATION ret = null;
	   try {
	      ret = (RAS_O17_ADMINISTRATION)this.get("ADMINISTRATION");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns a specific repetition of RAS_O17_ADMINISTRATION
	 * (a Group object) - creates it if necessary
	 * throws HL7Exception if the repetition requested is more than one 
	 *     greater than the number of existing repetitions.
	 */
	public RAS_O17_ADMINISTRATION getADMINISTRATION(int rep) throws HL7Exception { 
	   return (RAS_O17_ADMINISTRATION)this.get("ADMINISTRATION", rep);
	}

	/** 
	 * Returns the number of existing repetitions of RAS_O17_ADMINISTRATION 
	 */ 
	public int getADMINISTRATIONReps() { 
	    int reps = -1; 
	    try { 
	        reps = this.getAll("ADMINISTRATION").length; 
	    } catch (HL7Exception e) { 
	        String message = "Unexpected error accessing data - this is probably a bug in the source code generator."; 
	        HapiLogFactory.getHapiLog(this.getClass()).error(message, e); 
	        throw new RuntimeException(message);
	    } 
	    return reps; 
	} 

	/**
	 * Returns  first repetition of CTI (Clinical Trial Identification) - creates it if necessary
	 */
	public CTI getCTI() { 
	   CTI ret = null;
	   try {
	      ret = (CTI)this.get("CTI");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns a specific repetition of CTI
	 * (Clinical Trial Identification) - creates it if necessary
	 * throws HL7Exception if the repetition requested is more than one 
	 *     greater than the number of existing repetitions.
	 */
	public CTI getCTI(int rep) throws HL7Exception { 
	   return (CTI)this.get("CTI", rep);
	}

	/** 
	 * Returns the number of existing repetitions of CTI 
	 */ 
	public int getCTIReps() { 
	    int reps = -1; 
	    try { 
	        reps = this.getAll("CTI").length; 
	    } catch (HL7Exception e) { 
	        String message = "Unexpected error accessing data - this is probably a bug in the source code generator."; 
	        HapiLogFactory.getHapiLog(this.getClass()).error(message, e); 
	        throw new RuntimeException(message);
	    } 
	    return reps; 
	} 

}
