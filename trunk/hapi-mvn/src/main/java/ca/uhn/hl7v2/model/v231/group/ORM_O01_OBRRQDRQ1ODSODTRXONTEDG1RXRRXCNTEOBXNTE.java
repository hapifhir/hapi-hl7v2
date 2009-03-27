package ca.uhn.hl7v2.model.v231.group;

import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.log.HapiLogFactory;
import ca.uhn.hl7v2.model.v231.segment.*;

import ca.uhn.hl7v2.model.*;
/**
 * <p>Represents the ORM_O01_OBRRQDRQ1ODSODTRXONTEDG1RXRRXCNTEOBXNTE Group.  A Group is an ordered collection of message 
 * segments that can repeat together or be optionally in/excluded together.
 * This Group contains the following elements: </p>
 * 0: OBR (OBR - observation request segment) <b></b><br>
 * 1: RQD (RQD - requisition detail segment) <b></b><br>
 * 2: RQ1 (RQ1 - requisition detail-1 segment) <b></b><br>
 * 3: ODS (ODS - dietary orders, supplements, and preferences segment) <b></b><br>
 * 4: ODT (ODT - diet tray instructions segment) <b></b><br>
 * 5: RXO (RXO - pharmacy/treatment order segment) <b></b><br>
 * 6: NTE (NTE - notes and comments segment) <b>optional repeating</b><br>
 * 7: DG1 (DG1 - diagnosis segment) <b>optional repeating</b><br>
 * 8: RXR (RXR - pharmacy/treatment route segment) <b>repeating</b><br>
 * 9: ORM_O01_RXCNTE (a Group object) <b>optional </b><br>
 * 10: ORM_O01_OBXNTE (a Group object) <b>optional repeating</b><br>
 */
public class ORM_O01_OBRRQDRQ1ODSODTRXONTEDG1RXRRXCNTEOBXNTE extends AbstractGroup {

	/** 
	 * Creates a new ORM_O01_OBRRQDRQ1ODSODTRXONTEDG1RXRRXCNTEOBXNTE Group.
	 */
	public ORM_O01_OBRRQDRQ1ODSODTRXONTEDG1RXRRXCNTEOBXNTE(Group parent, ModelClassFactory factory) {
	   super(parent, factory);
	   try {
	      this.add(OBR.class, true, false);
	      this.add(RQD.class, true, false);
	      this.add(RQ1.class, true, false);
	      this.add(ODS.class, true, false);
	      this.add(ODT.class, true, false);
	      this.add(RXO.class, true, false);
	      this.add(NTE.class, false, true);
	      this.add(DG1.class, false, true);
	      this.add(RXR.class, true, true);
	      this.add(ORM_O01_RXCNTE.class, false, false);
	      this.add(ORM_O01_OBXNTE.class, false, true);
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error creating ORM_O01_OBRRQDRQ1ODSODTRXONTEDG1RXRRXCNTEOBXNTE - this is probably a bug in the source code generator.", e);
	   }
	}

	/**
	 * Returns OBR (OBR - observation request segment) - creates it if necessary
	 */
	public OBR getOBR() { 
	   OBR ret = null;
	   try {
	      ret = (OBR)this.get("OBR");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
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
	 * Returns ODS (ODS - dietary orders, supplements, and preferences segment) - creates it if necessary
	 */
	public ODS getODS() { 
	   ODS ret = null;
	   try {
	      ret = (ODS)this.get("ODS");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns ODT (ODT - diet tray instructions segment) - creates it if necessary
	 */
	public ODT getODT() { 
	   ODT ret = null;
	   try {
	      ret = (ODT)this.get("ODT");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns RXO (RXO - pharmacy/treatment order segment) - creates it if necessary
	 */
	public RXO getRXO() { 
	   RXO ret = null;
	   try {
	      ret = (RXO)this.get("RXO");
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
	 * Returns  first repetition of DG1 (DG1 - diagnosis segment) - creates it if necessary
	 */
	public DG1 getDG1() { 
	   DG1 ret = null;
	   try {
	      ret = (DG1)this.get("DG1");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns a specific repetition of DG1
	 * (DG1 - diagnosis segment) - creates it if necessary
	 * throws HL7Exception if the repetition requested is more than one 
	 *     greater than the number of existing repetitions.
	 */
	public DG1 getDG1(int rep) throws HL7Exception { 
	   return (DG1)this.get("DG1", rep);
	}

	/** 
	 * Returns the number of existing repetitions of DG1 
	 */ 
	public int getDG1Reps() { 
	    int reps = -1; 
	    try { 
	        reps = this.getAll("DG1").length; 
	    } catch (HL7Exception e) { 
	        String message = "Unexpected error accessing data - this is probably a bug in the source code generator."; 
	        HapiLogFactory.getHapiLog(this.getClass()).error(message, e); 
	        throw new RuntimeException(message);
	    } 
	    return reps; 
	} 

	/**
	 * Returns  first repetition of RXR (RXR - pharmacy/treatment route segment) - creates it if necessary
	 */
	public RXR getRXR() { 
	   RXR ret = null;
	   try {
	      ret = (RXR)this.get("RXR");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns a specific repetition of RXR
	 * (RXR - pharmacy/treatment route segment) - creates it if necessary
	 * throws HL7Exception if the repetition requested is more than one 
	 *     greater than the number of existing repetitions.
	 */
	public RXR getRXR(int rep) throws HL7Exception { 
	   return (RXR)this.get("RXR", rep);
	}

	/** 
	 * Returns the number of existing repetitions of RXR 
	 */ 
	public int getRXRReps() { 
	    int reps = -1; 
	    try { 
	        reps = this.getAll("RXR").length; 
	    } catch (HL7Exception e) { 
	        String message = "Unexpected error accessing data - this is probably a bug in the source code generator."; 
	        HapiLogFactory.getHapiLog(this.getClass()).error(message, e); 
	        throw new RuntimeException(message);
	    } 
	    return reps; 
	} 

	/**
	 * Returns ORM_O01_RXCNTE (a Group object) - creates it if necessary
	 */
	public ORM_O01_RXCNTE getRXCNTE() { 
	   ORM_O01_RXCNTE ret = null;
	   try {
	      ret = (ORM_O01_RXCNTE)this.get("RXCNTE");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns  first repetition of ORM_O01_OBXNTE (a Group object) - creates it if necessary
	 */
	public ORM_O01_OBXNTE getOBXNTE() { 
	   ORM_O01_OBXNTE ret = null;
	   try {
	      ret = (ORM_O01_OBXNTE)this.get("OBXNTE");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns a specific repetition of ORM_O01_OBXNTE
	 * (a Group object) - creates it if necessary
	 * throws HL7Exception if the repetition requested is more than one 
	 *     greater than the number of existing repetitions.
	 */
	public ORM_O01_OBXNTE getOBXNTE(int rep) throws HL7Exception { 
	   return (ORM_O01_OBXNTE)this.get("OBXNTE", rep);
	}

	/** 
	 * Returns the number of existing repetitions of ORM_O01_OBXNTE 
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
