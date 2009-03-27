package ca.uhn.hl7v2.model.v231.group;

import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.log.HapiLogFactory;
import ca.uhn.hl7v2.model.v231.segment.*;

import ca.uhn.hl7v2.model.*;
/**
 * <p>Represents the CSU_C09_PIDPD1NTEPV1PV2CSRCSPCSSORCOBROBXORCRXARXR Group.  A Group is an ordered collection of message 
 * segments that can repeat together or be optionally in/excluded together.
 * This Group contains the following elements: </p>
 * 0: PID (PID - patient identification segment) <b></b><br>
 * 1: PD1 (PD1 - patient additional demographic segment) <b>optional </b><br>
 * 2: NTE (NTE - notes and comments segment) <b>optional repeating</b><br>
 * 3: CSU_C09_PV1PV2 (a Group object) <b>optional </b><br>
 * 4: CSR (CSR - clinical study registration segment) <b></b><br>
 * 5: CSU_C09_CSPCSSORCOBROBXORCRXARXR (a Group object) <b>repeating</b><br>
 */
public class CSU_C09_PIDPD1NTEPV1PV2CSRCSPCSSORCOBROBXORCRXARXR extends AbstractGroup {

	/** 
	 * Creates a new CSU_C09_PIDPD1NTEPV1PV2CSRCSPCSSORCOBROBXORCRXARXR Group.
	 */
	public CSU_C09_PIDPD1NTEPV1PV2CSRCSPCSSORCOBROBXORCRXARXR(Group parent, ModelClassFactory factory) {
	   super(parent, factory);
	   try {
	      this.add(PID.class, true, false);
	      this.add(PD1.class, false, false);
	      this.add(NTE.class, false, true);
	      this.add(CSU_C09_PV1PV2.class, false, false);
	      this.add(CSR.class, true, false);
	      this.add(CSU_C09_CSPCSSORCOBROBXORCRXARXR.class, true, true);
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error creating CSU_C09_PIDPD1NTEPV1PV2CSRCSPCSSORCOBROBXORCRXARXR - this is probably a bug in the source code generator.", e);
	   }
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
	 * Returns PD1 (PD1 - patient additional demographic segment) - creates it if necessary
	 */
	public PD1 getPD1() { 
	   PD1 ret = null;
	   try {
	      ret = (PD1)this.get("PD1");
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
	 * Returns CSU_C09_PV1PV2 (a Group object) - creates it if necessary
	 */
	public CSU_C09_PV1PV2 getPV1PV2() { 
	   CSU_C09_PV1PV2 ret = null;
	   try {
	      ret = (CSU_C09_PV1PV2)this.get("PV1PV2");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns CSR (CSR - clinical study registration segment) - creates it if necessary
	 */
	public CSR getCSR() { 
	   CSR ret = null;
	   try {
	      ret = (CSR)this.get("CSR");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns  first repetition of CSU_C09_CSPCSSORCOBROBXORCRXARXR (a Group object) - creates it if necessary
	 */
	public CSU_C09_CSPCSSORCOBROBXORCRXARXR getCSPCSSORCOBROBXORCRXARXR() { 
	   CSU_C09_CSPCSSORCOBROBXORCRXARXR ret = null;
	   try {
	      ret = (CSU_C09_CSPCSSORCOBROBXORCRXARXR)this.get("CSPCSSORCOBROBXORCRXARXR");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns a specific repetition of CSU_C09_CSPCSSORCOBROBXORCRXARXR
	 * (a Group object) - creates it if necessary
	 * throws HL7Exception if the repetition requested is more than one 
	 *     greater than the number of existing repetitions.
	 */
	public CSU_C09_CSPCSSORCOBROBXORCRXARXR getCSPCSSORCOBROBXORCRXARXR(int rep) throws HL7Exception { 
	   return (CSU_C09_CSPCSSORCOBROBXORCRXARXR)this.get("CSPCSSORCOBROBXORCRXARXR", rep);
	}

	/** 
	 * Returns the number of existing repetitions of CSU_C09_CSPCSSORCOBROBXORCRXARXR 
	 */ 
	public int getCSPCSSORCOBROBXORCRXARXRReps() { 
	    int reps = -1; 
	    try { 
	        reps = this.getAll("CSPCSSORCOBROBXORCRXARXR").length; 
	    } catch (HL7Exception e) { 
	        String message = "Unexpected error accessing data - this is probably a bug in the source code generator."; 
	        HapiLogFactory.getHapiLog(this.getClass()).error(message, e); 
	        throw new RuntimeException(message);
	    } 
	    return reps; 
	} 

}
