package ca.uhn.hl7v2.model.v231.group;

import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.log.HapiLogFactory;
import ca.uhn.hl7v2.model.v231.segment.*;

import ca.uhn.hl7v2.model.*;
/**
 * <p>Represents the SQM_S25_ARQAPRPIDRGSAISAPRAIGAPRAIPAPRAILAPR Group.  A Group is an ordered collection of message 
 * segments that can repeat together or be optionally in/excluded together.
 * This Group contains the following elements: </p>
 * 0: ARQ (ARQ - appointment request segment) <b></b><br>
 * 1: APR (APR - appointment preferences segment) <b>optional </b><br>
 * 2: PID (PID - patient identification segment) <b>optional </b><br>
 * 3: SQM_S25_RGSAISAPRAIGAPRAIPAPRAILAPR (a Group object) <b>repeating</b><br>
 */
public class SQM_S25_ARQAPRPIDRGSAISAPRAIGAPRAIPAPRAILAPR extends AbstractGroup {

	/** 
	 * Creates a new SQM_S25_ARQAPRPIDRGSAISAPRAIGAPRAIPAPRAILAPR Group.
	 */
	public SQM_S25_ARQAPRPIDRGSAISAPRAIGAPRAIPAPRAILAPR(Group parent, ModelClassFactory factory) {
	   super(parent, factory);
	   try {
	      this.add(ARQ.class, true, false);
	      this.add(APR.class, false, false);
	      this.add(PID.class, false, false);
	      this.add(SQM_S25_RGSAISAPRAIGAPRAIPAPRAILAPR.class, true, true);
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error creating SQM_S25_ARQAPRPIDRGSAISAPRAIGAPRAIPAPRAILAPR - this is probably a bug in the source code generator.", e);
	   }
	}

	/**
	 * Returns ARQ (ARQ - appointment request segment) - creates it if necessary
	 */
	public ARQ getARQ() { 
	   ARQ ret = null;
	   try {
	      ret = (ARQ)this.get("ARQ");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns APR (APR - appointment preferences segment) - creates it if necessary
	 */
	public APR getAPR() { 
	   APR ret = null;
	   try {
	      ret = (APR)this.get("APR");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns PID (PID - patient identification segment) - creates it if necessary
	 */
	public PID getPID() { 
	   PID ret = null;
	   try {
	      ret = (PID)this.get("PID");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns  first repetition of SQM_S25_RGSAISAPRAIGAPRAIPAPRAILAPR (a Group object) - creates it if necessary
	 */
	public SQM_S25_RGSAISAPRAIGAPRAIPAPRAILAPR getRGSAISAPRAIGAPRAIPAPRAILAPR() { 
	   SQM_S25_RGSAISAPRAIGAPRAIPAPRAILAPR ret = null;
	   try {
	      ret = (SQM_S25_RGSAISAPRAIGAPRAIPAPRAILAPR)this.get("RGSAISAPRAIGAPRAIPAPRAILAPR");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns a specific repetition of SQM_S25_RGSAISAPRAIGAPRAIPAPRAILAPR
	 * (a Group object) - creates it if necessary
	 * throws HL7Exception if the repetition requested is more than one 
	 *     greater than the number of existing repetitions.
	 */
	public SQM_S25_RGSAISAPRAIGAPRAIPAPRAILAPR getRGSAISAPRAIGAPRAIPAPRAILAPR(int rep) throws HL7Exception { 
	   return (SQM_S25_RGSAISAPRAIGAPRAIPAPRAILAPR)this.get("RGSAISAPRAIGAPRAIPAPRAILAPR", rep);
	}

	/** 
	 * Returns the number of existing repetitions of SQM_S25_RGSAISAPRAIGAPRAIPAPRAILAPR 
	 */ 
	public int getRGSAISAPRAIGAPRAIPAPRAILAPRReps() { 
	    int reps = -1; 
	    try { 
	        reps = this.getAll("RGSAISAPRAIGAPRAIPAPRAILAPR").length; 
	    } catch (HL7Exception e) { 
	        String message = "Unexpected error accessing data - this is probably a bug in the source code generator."; 
	        HapiLogFactory.getHapiLog(this.getClass()).error(message, e); 
	        throw new RuntimeException(message);
	    } 
	    return reps; 
	} 

}
