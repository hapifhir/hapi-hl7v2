package ca.uhn.hl7v2.model.v23.group;

import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.log.HapiLogFactory;
import ca.uhn.hl7v2.model.v23.segment.*;

import ca.uhn.hl7v2.model.*;
/**
 * <p>Represents the CRM_C02_PATIENT Group.  A Group is an ordered collection of message 
 * segments that can repeat together or be optionally in/excluded together.
 * This Group contains the following elements: </p>
 * 0: PID (Patient Identification) <b></b><br>
 * 1: PV1 (Patient visit) <b>optional </b><br>
 * 2: CSR (Clinical Study Registration) <b></b><br>
 * 3: CSP (Clinical Study Phase) <b>optional repeating</b><br>
 */
public class CRM_C02_PATIENT extends AbstractGroup {

	/** 
	 * Creates a new CRM_C02_PATIENT Group.
	 */
	public CRM_C02_PATIENT(Group parent, ModelClassFactory factory) {
	   super(parent, factory);
	   try {
	      this.add(PID.class, true, false);
	      this.add(PV1.class, false, false);
	      this.add(CSR.class, true, false);
	      this.add(CSP.class, false, true);
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error creating CRM_C02_PATIENT - this is probably a bug in the source code generator.", e);
	   }
	}

	/**
	 * Returns PID (Patient Identification) - creates it if necessary
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
	 * Returns PV1 (Patient visit) - creates it if necessary
	 */
	public PV1 getPV1() { 
	   PV1 ret = null;
	   try {
	      ret = (PV1)this.get("PV1");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns CSR (Clinical Study Registration) - creates it if necessary
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
	 * Returns  first repetition of CSP (Clinical Study Phase) - creates it if necessary
	 */
	public CSP getCSP() { 
	   CSP ret = null;
	   try {
	      ret = (CSP)this.get("CSP");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns a specific repetition of CSP
	 * (Clinical Study Phase) - creates it if necessary
	 * throws HL7Exception if the repetition requested is more than one 
	 *     greater than the number of existing repetitions.
	 */
	public CSP getCSP(int rep) throws HL7Exception { 
	   return (CSP)this.get("CSP", rep);
	}

	/** 
	 * Returns the number of existing repetitions of CSP 
	 */ 
	public int getCSPReps() { 
	    int reps = -1; 
	    try { 
	        reps = this.getAll("CSP").length; 
	    } catch (HL7Exception e) { 
	        String message = "Unexpected error accessing data - this is probably a bug in the source code generator."; 
	        HapiLogFactory.getHapiLog(this.getClass()).error(message, e); 
	        throw new RuntimeException(message);
	    } 
	    return reps; 
	} 

}
