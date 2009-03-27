package ca.uhn.hl7v2.model.v231.group;

import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.log.HapiLogFactory;
import ca.uhn.hl7v2.model.v231.segment.*;

import ca.uhn.hl7v2.model.*;
/**
 * <p>Represents the OMN_O01_RQDRQ1NTEOBXNTE Group.  A Group is an ordered collection of message 
 * segments that can repeat together or be optionally in/excluded together.
 * This Group contains the following elements: </p>
 * 0: RQD (RQD - requisition detail segment) <b></b><br>
 * 1: RQ1 (RQ1 - requisition detail-1 segment) <b>optional </b><br>
 * 2: NTE (NTE - notes and comments segment) <b>optional repeating</b><br>
 * 3: OMN_O01_OBXNTE (a Group object) <b>optional repeating</b><br>
 */
public class OMN_O01_RQDRQ1NTEOBXNTE extends AbstractGroup {

	/** 
	 * Creates a new OMN_O01_RQDRQ1NTEOBXNTE Group.
	 */
	public OMN_O01_RQDRQ1NTEOBXNTE(Group parent, ModelClassFactory factory) {
	   super(parent, factory);
	   try {
	      this.add(RQD.class, true, false);
	      this.add(RQ1.class, false, false);
	      this.add(NTE.class, false, true);
	      this.add(OMN_O01_OBXNTE.class, false, true);
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error creating OMN_O01_RQDRQ1NTEOBXNTE - this is probably a bug in the source code generator.", e);
	   }
	}

	/**
	 * Returns RQD (RQD - requisition detail segment) - creates it if necessary
	 */
	public RQD getRQD() { 
	   RQD ret = null;
	   try {
	      ret = (RQD)this.get("RQD");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns RQ1 (RQ1 - requisition detail-1 segment) - creates it if necessary
	 */
	public RQ1 getRQ1() { 
	   RQ1 ret = null;
	   try {
	      ret = (RQ1)this.get("RQ1");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns  first repetition of NTE (NTE - notes and comments segment) - creates it if necessary
	 */
	public NTE getNTE() { 
	   NTE ret = null;
	   try {
	      ret = (NTE)this.get("NTE");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns a specific repetition of NTE
	 * (NTE - notes and comments segment) - creates it if necessary
	 * throws HL7Exception if the repetition requested is more than one 
	 *     greater than the number of existing repetitions.
	 */
	public NTE getNTE(int rep) throws HL7Exception { 
	   return (NTE)this.get("NTE", rep);
	}

	/** 
	 * Returns the number of existing repetitions of NTE 
	 */ 
	public int getNTEReps() { 
	    int reps = -1; 
	    try { 
	        reps = this.getAll("NTE").length; 
	    } catch (HL7Exception e) { 
	        String message = "Unexpected error accessing data - this is probably a bug in the source code generator."; 
	        HapiLogFactory.getHapiLog(this.getClass()).error(message, e); 
	        throw new RuntimeException(message);
	    } 
	    return reps; 
	} 

	/**
	 * Returns  first repetition of OMN_O01_OBXNTE (a Group object) - creates it if necessary
	 */
	public OMN_O01_OBXNTE getOBXNTE() { 
	   OMN_O01_OBXNTE ret = null;
	   try {
	      ret = (OMN_O01_OBXNTE)this.get("OBXNTE");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns a specific repetition of OMN_O01_OBXNTE
	 * (a Group object) - creates it if necessary
	 * throws HL7Exception if the repetition requested is more than one 
	 *     greater than the number of existing repetitions.
	 */
	public OMN_O01_OBXNTE getOBXNTE(int rep) throws HL7Exception { 
	   return (OMN_O01_OBXNTE)this.get("OBXNTE", rep);
	}

	/** 
	 * Returns the number of existing repetitions of OMN_O01_OBXNTE 
	 */ 
	public int getOBXNTEReps() { 
	    int reps = -1; 
	    try { 
	        reps = this.getAll("OBXNTE").length; 
	    } catch (HL7Exception e) { 
	        String message = "Unexpected error accessing data - this is probably a bug in the source code generator."; 
	        HapiLogFactory.getHapiLog(this.getClass()).error(message, e); 
	        throw new RuntimeException(message);
	    } 
	    return reps; 
	} 

}
