package ca.uhn.hl7v2.model.v231.group;

import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.log.HapiLogFactory;
import ca.uhn.hl7v2.model.v231.segment.*;

import ca.uhn.hl7v2.model.*;
/**
 * <p>Represents the RQI_I03_GT1IN1IN2IN3 Group.  A Group is an ordered collection of message 
 * segments that can repeat together or be optionally in/excluded together.
 * This Group contains the following elements: </p>
 * 0: GT1 (GT1 - guarantor segment) <b>optional repeating</b><br>
 * 1: RQI_I03_IN1IN2IN3 (a Group object) <b>repeating</b><br>
 */
public class RQI_I03_GT1IN1IN2IN3 extends AbstractGroup {

	/** 
	 * Creates a new RQI_I03_GT1IN1IN2IN3 Group.
	 */
	public RQI_I03_GT1IN1IN2IN3(Group parent, ModelClassFactory factory) {
	   super(parent, factory);
	   try {
	      this.add(GT1.class, false, true);
	      this.add(RQI_I03_IN1IN2IN3.class, true, true);
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error creating RQI_I03_GT1IN1IN2IN3 - this is probably a bug in the source code generator.", e);
	   }
	}

	/**
	 * Returns  first repetition of GT1 (GT1 - guarantor segment) - creates it if necessary
	 */
	public GT1 getGT1() { 
	   GT1 ret = null;
	   try {
	      ret = (GT1)this.get("GT1");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns a specific repetition of GT1
	 * (GT1 - guarantor segment) - creates it if necessary
	 * throws HL7Exception if the repetition requested is more than one 
	 *     greater than the number of existing repetitions.
	 */
	public GT1 getGT1(int rep) throws HL7Exception { 
	   return (GT1)this.get("GT1", rep);
	}

	/** 
	 * Returns the number of existing repetitions of GT1 
	 */ 
	public int getGT1Reps() { 
	    int reps = -1; 
	    try { 
	        reps = this.getAll("GT1").length; 
	    } catch (HL7Exception e) { 
	        String message = "Unexpected error accessing data - this is probably a bug in the source code generator."; 
	        HapiLogFactory.getHapiLog(this.getClass()).error(message, e); 
	        throw new RuntimeException(message);
	    } 
	    return reps; 
	} 

	/**
	 * Returns  first repetition of RQI_I03_IN1IN2IN3 (a Group object) - creates it if necessary
	 */
	public RQI_I03_IN1IN2IN3 getIN1IN2IN3() { 
	   RQI_I03_IN1IN2IN3 ret = null;
	   try {
	      ret = (RQI_I03_IN1IN2IN3)this.get("IN1IN2IN3");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns a specific repetition of RQI_I03_IN1IN2IN3
	 * (a Group object) - creates it if necessary
	 * throws HL7Exception if the repetition requested is more than one 
	 *     greater than the number of existing repetitions.
	 */
	public RQI_I03_IN1IN2IN3 getIN1IN2IN3(int rep) throws HL7Exception { 
	   return (RQI_I03_IN1IN2IN3)this.get("IN1IN2IN3", rep);
	}

	/** 
	 * Returns the number of existing repetitions of RQI_I03_IN1IN2IN3 
	 */ 
	public int getIN1IN2IN3Reps() { 
	    int reps = -1; 
	    try { 
	        reps = this.getAll("IN1IN2IN3").length; 
	    } catch (HL7Exception e) { 
	        String message = "Unexpected error accessing data - this is probably a bug in the source code generator."; 
	        HapiLogFactory.getHapiLog(this.getClass()).error(message, e); 
	        throw new RuntimeException(message);
	    } 
	    return reps; 
	} 

}
