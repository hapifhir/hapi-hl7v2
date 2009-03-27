package ca.uhn.hl7v2.model.v231.group;

import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.log.HapiLogFactory;
import ca.uhn.hl7v2.model.v231.segment.*;

import ca.uhn.hl7v2.model.*;
/**
 * <p>Represents the ORD_O02_PIDNTEORCODSNTEORCODTNTE Group.  A Group is an ordered collection of message 
 * segments that can repeat together or be optionally in/excluded together.
 * This Group contains the following elements: </p>
 * 0: ORD_O02_PIDNTE (a Group object) <b>optional </b><br>
 * 1: ORD_O02_ORCODSNTE (a Group object) <b>repeating</b><br>
 * 2: ORD_O02_ORCODTNTE (a Group object) <b>optional repeating</b><br>
 */
public class ORD_O02_PIDNTEORCODSNTEORCODTNTE extends AbstractGroup {

	/** 
	 * Creates a new ORD_O02_PIDNTEORCODSNTEORCODTNTE Group.
	 */
	public ORD_O02_PIDNTEORCODSNTEORCODTNTE(Group parent, ModelClassFactory factory) {
	   super(parent, factory);
	   try {
	      this.add(ORD_O02_PIDNTE.class, false, false);
	      this.add(ORD_O02_ORCODSNTE.class, true, true);
	      this.add(ORD_O02_ORCODTNTE.class, false, true);
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error creating ORD_O02_PIDNTEORCODSNTEORCODTNTE - this is probably a bug in the source code generator.", e);
	   }
	}

	/**
	 * Returns ORD_O02_PIDNTE (a Group object) - creates it if necessary
	 */
	public ORD_O02_PIDNTE getPIDNTE() { 
	   ORD_O02_PIDNTE ret = null;
	   try {
	      ret = (ORD_O02_PIDNTE)this.get("PIDNTE");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns  first repetition of ORD_O02_ORCODSNTE (a Group object) - creates it if necessary
	 */
	public ORD_O02_ORCODSNTE getORCODSNTE() { 
	   ORD_O02_ORCODSNTE ret = null;
	   try {
	      ret = (ORD_O02_ORCODSNTE)this.get("ORCODSNTE");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns a specific repetition of ORD_O02_ORCODSNTE
	 * (a Group object) - creates it if necessary
	 * throws HL7Exception if the repetition requested is more than one 
	 *     greater than the number of existing repetitions.
	 */
	public ORD_O02_ORCODSNTE getORCODSNTE(int rep) throws HL7Exception { 
	   return (ORD_O02_ORCODSNTE)this.get("ORCODSNTE", rep);
	}

	/** 
	 * Returns the number of existing repetitions of ORD_O02_ORCODSNTE 
	 */ 
	public int getORCODSNTEReps() { 
	    int reps = -1; 
	    try { 
	        reps = this.getAll("ORCODSNTE").length; 
	    } catch (HL7Exception e) { 
	        String message = "Unexpected error accessing data - this is probably a bug in the source code generator."; 
	        HapiLogFactory.getHapiLog(this.getClass()).error(message, e); 
	        throw new RuntimeException(message);
	    } 
	    return reps; 
	} 

	/**
	 * Returns  first repetition of ORD_O02_ORCODTNTE (a Group object) - creates it if necessary
	 */
	public ORD_O02_ORCODTNTE getORCODTNTE() { 
	   ORD_O02_ORCODTNTE ret = null;
	   try {
	      ret = (ORD_O02_ORCODTNTE)this.get("ORCODTNTE");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns a specific repetition of ORD_O02_ORCODTNTE
	 * (a Group object) - creates it if necessary
	 * throws HL7Exception if the repetition requested is more than one 
	 *     greater than the number of existing repetitions.
	 */
	public ORD_O02_ORCODTNTE getORCODTNTE(int rep) throws HL7Exception { 
	   return (ORD_O02_ORCODTNTE)this.get("ORCODTNTE", rep);
	}

	/** 
	 * Returns the number of existing repetitions of ORD_O02_ORCODTNTE 
	 */ 
	public int getORCODTNTEReps() { 
	    int reps = -1; 
	    try { 
	        reps = this.getAll("ORCODTNTE").length; 
	    } catch (HL7Exception e) { 
	        String message = "Unexpected error accessing data - this is probably a bug in the source code generator."; 
	        HapiLogFactory.getHapiLog(this.getClass()).error(message, e); 
	        throw new RuntimeException(message);
	    } 
	    return reps; 
	} 

}
