package ca.uhn.hl7v2.model.v231.group;

import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.log.HapiLogFactory;
import ca.uhn.hl7v2.model.v231.segment.*;

import ca.uhn.hl7v2.model.*;
/**
 * <p>Represents the ORF_R04_PIDNTEORCOBRNTEOBXNTECTI Group.  A Group is an ordered collection of message 
 * segments that can repeat together or be optionally in/excluded together.
 * This Group contains the following elements: </p>
 * 0: ORF_R04_PIDNTE (a Group object) <b>optional </b><br>
 * 1: ORF_R04_ORCOBRNTEOBXNTECTI (a Group object) <b>repeating</b><br>
 */
public class ORF_R04_PIDNTEORCOBRNTEOBXNTECTI extends AbstractGroup {

	/** 
	 * Creates a new ORF_R04_PIDNTEORCOBRNTEOBXNTECTI Group.
	 */
	public ORF_R04_PIDNTEORCOBRNTEOBXNTECTI(Group parent, ModelClassFactory factory) {
	   super(parent, factory);
	   try {
	      this.add(ORF_R04_PIDNTE.class, false, false);
	      this.add(ORF_R04_ORCOBRNTEOBXNTECTI.class, true, true);
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error creating ORF_R04_PIDNTEORCOBRNTEOBXNTECTI - this is probably a bug in the source code generator.", e);
	   }
	}

	/**
	 * Returns ORF_R04_PIDNTE (a Group object) - creates it if necessary
	 */
	public ORF_R04_PIDNTE getPIDNTE() { 
	   ORF_R04_PIDNTE ret = null;
	   try {
	      ret = (ORF_R04_PIDNTE)this.get("PIDNTE");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns  first repetition of ORF_R04_ORCOBRNTEOBXNTECTI (a Group object) - creates it if necessary
	 */
	public ORF_R04_ORCOBRNTEOBXNTECTI getORCOBRNTEOBXNTECTI() { 
	   ORF_R04_ORCOBRNTEOBXNTECTI ret = null;
	   try {
	      ret = (ORF_R04_ORCOBRNTEOBXNTECTI)this.get("ORCOBRNTEOBXNTECTI");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns a specific repetition of ORF_R04_ORCOBRNTEOBXNTECTI
	 * (a Group object) - creates it if necessary
	 * throws HL7Exception if the repetition requested is more than one 
	 *     greater than the number of existing repetitions.
	 */
	public ORF_R04_ORCOBRNTEOBXNTECTI getORCOBRNTEOBXNTECTI(int rep) throws HL7Exception { 
	   return (ORF_R04_ORCOBRNTEOBXNTECTI)this.get("ORCOBRNTEOBXNTECTI", rep);
	}

	/** 
	 * Returns the number of existing repetitions of ORF_R04_ORCOBRNTEOBXNTECTI 
	 */ 
	public int getORCOBRNTEOBXNTECTIReps() { 
	    int reps = -1; 
	    try { 
	        reps = this.getAll("ORCOBRNTEOBXNTECTI").length; 
	    } catch (HL7Exception e) { 
	        String message = "Unexpected error accessing data - this is probably a bug in the source code generator."; 
	        HapiLogFactory.getHapiLog(this.getClass()).error(message, e); 
	        throw new RuntimeException(message);
	    } 
	    return reps; 
	} 

}
