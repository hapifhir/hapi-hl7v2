package ca.uhn.hl7v2.model.v231.group;

import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.log.HapiLogFactory;
import ca.uhn.hl7v2.model.v231.segment.*;

import ca.uhn.hl7v2.model.*;
/**
 * <p>Represents the ORM_O01_ORCOBRRQDRQ1ODSODTRXONTEDG1RXRRXCNTEOBXNTECTIBLG Group.  A Group is an ordered collection of message 
 * segments that can repeat together or be optionally in/excluded together.
 * This Group contains the following elements: </p>
 * 0: ORC (ORC - common order segment) <b></b><br>
 * 1: ORM_O01_OBRRQDRQ1ODSODTRXONTEDG1RXRRXCNTEOBXNTE (a Group object) <b>optional </b><br>
 * 2: CTI (CTI - clinical trial identification segment) <b>optional repeating</b><br>
 * 3: BLG (BLG - billing segment) <b>optional </b><br>
 */
public class ORM_O01_ORCOBRRQDRQ1ODSODTRXONTEDG1RXRRXCNTEOBXNTECTIBLG extends AbstractGroup {

	/** 
	 * Creates a new ORM_O01_ORCOBRRQDRQ1ODSODTRXONTEDG1RXRRXCNTEOBXNTECTIBLG Group.
	 */
	public ORM_O01_ORCOBRRQDRQ1ODSODTRXONTEDG1RXRRXCNTEOBXNTECTIBLG(Group parent, ModelClassFactory factory) {
	   super(parent, factory);
	   try {
	      this.add(ORC.class, true, false);
	      this.add(ORM_O01_OBRRQDRQ1ODSODTRXONTEDG1RXRRXCNTEOBXNTE.class, false, false);
	      this.add(CTI.class, false, true);
	      this.add(BLG.class, false, false);
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error creating ORM_O01_ORCOBRRQDRQ1ODSODTRXONTEDG1RXRRXCNTEOBXNTECTIBLG - this is probably a bug in the source code generator.", e);
	   }
	}

	/**
	 * Returns ORC (ORC - common order segment) - creates it if necessary
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
	 * Returns ORM_O01_OBRRQDRQ1ODSODTRXONTEDG1RXRRXCNTEOBXNTE (a Group object) - creates it if necessary
	 */
	public ORM_O01_OBRRQDRQ1ODSODTRXONTEDG1RXRRXCNTEOBXNTE getOBRRQDRQ1ODSODTRXONTEDG1RXRRXCNTEOBXNTE() { 
	   ORM_O01_OBRRQDRQ1ODSODTRXONTEDG1RXRRXCNTEOBXNTE ret = null;
	   try {
	      ret = (ORM_O01_OBRRQDRQ1ODSODTRXONTEDG1RXRRXCNTEOBXNTE)this.get("OBRRQDRQ1ODSODTRXONTEDG1RXRRXCNTEOBXNTE");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns  first repetition of CTI (CTI - clinical trial identification segment) - creates it if necessary
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
	 * (CTI - clinical trial identification segment) - creates it if necessary
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

	/**
	 * Returns BLG (BLG - billing segment) - creates it if necessary
	 */
	public BLG getBLG() { 
	   BLG ret = null;
	   try {
	      ret = (BLG)this.get("BLG");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

}
