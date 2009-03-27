package ca.uhn.hl7v2.model.v231.group;

import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.log.HapiLogFactory;
import ca.uhn.hl7v2.model.v231.segment.*;

import ca.uhn.hl7v2.model.*;
/**
 * <p>Represents the ADT_A01_IN1IN2IN3 Group.  A Group is an ordered collection of message 
 * segments that can repeat together or be optionally in/excluded together.
 * This Group contains the following elements: </p>
 * 0: IN1 (IN1 - insurance segment) <b></b><br>
 * 1: IN2 (IN2 - insurance additional information segment) <b>optional </b><br>
 * 2: IN3 (IN3 - insurance additional information, certification segment) <b>optional repeating</b><br>
 */
public class ADT_A01_IN1IN2IN3 extends AbstractGroup {

	/** 
	 * Creates a new ADT_A01_IN1IN2IN3 Group.
	 */
	public ADT_A01_IN1IN2IN3(Group parent, ModelClassFactory factory) {
	   super(parent, factory);
	   try {
	      this.add(IN1.class, true, false);
	      this.add(IN2.class, false, false);
	      this.add(IN3.class, false, true);
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error creating ADT_A01_IN1IN2IN3 - this is probably a bug in the source code generator.", e);
	   }
	}

	/**
	 * Returns IN1 (IN1 - insurance segment) - creates it if necessary
	 */
	public IN1 getIN1() { 
	   IN1 ret = null;
	   try {
	      ret = (IN1)this.get("IN1");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns IN2 (IN2 - insurance additional information segment) - creates it if necessary
	 */
	public IN2 getIN2() { 
	   IN2 ret = null;
	   try {
	      ret = (IN2)this.get("IN2");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns  first repetition of IN3 (IN3 - insurance additional information, certification segment) - creates it if necessary
	 */
	public IN3 getIN3() { 
	   IN3 ret = null;
	   try {
	      ret = (IN3)this.get("IN3");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns a specific repetition of IN3
	 * (IN3 - insurance additional information, certification segment) - creates it if necessary
	 * throws HL7Exception if the repetition requested is more than one 
	 *     greater than the number of existing repetitions.
	 */
	public IN3 getIN3(int rep) throws HL7Exception { 
	   return (IN3)this.get("IN3", rep);
	}

	/** 
	 * Returns the number of existing repetitions of IN3 
	 */ 
	public int getIN3Reps() { 
	    int reps = -1; 
	    try { 
	        reps = this.getAll("IN3").length; 
	    } catch (HL7Exception e) { 
	        String message = "Unexpected error accessing data - this is probably a bug in the source code generator."; 
	        HapiLogFactory.getHapiLog(this.getClass()).error(message, e); 
	        throw new RuntimeException(message);
	    } 
	    return reps; 
	} 

}
