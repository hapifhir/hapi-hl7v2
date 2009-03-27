package ca.uhn.hl7v2.model.v23.group;

import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.log.HapiLogFactory;
import ca.uhn.hl7v2.model.v23.segment.*;

import ca.uhn.hl7v2.model.*;
/**
 * <p>Represents the SUR_P09_FACILITY_DETAIL Group.  A Group is an ordered collection of message 
 * segments that can repeat together or be optionally in/excluded together.
 * This Group contains the following elements: </p>
 * 0: FAC (Facility) <b></b><br>
 * 1: PDC (Product Detail Country) <b></b><br>
 * 2: NTE (Notes and comments segment) <b></b><br>
 */
public class SUR_P09_FACILITY_DETAIL extends AbstractGroup {

	/** 
	 * Creates a new SUR_P09_FACILITY_DETAIL Group.
	 */
	public SUR_P09_FACILITY_DETAIL(Group parent, ModelClassFactory factory) {
	   super(parent, factory);
	   try {
	      this.add(FAC.class, true, false);
	      this.add(PDC.class, true, false);
	      this.add(NTE.class, true, false);
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error creating SUR_P09_FACILITY_DETAIL - this is probably a bug in the source code generator.", e);
	   }
	}

	/**
	 * Returns FAC (Facility) - creates it if necessary
	 */
	public FAC getFAC() { 
	   FAC ret = null;
	   try {
	      ret = (FAC)this.get("FAC");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns PDC (Product Detail Country) - creates it if necessary
	 */
	public PDC getPDC() { 
	   PDC ret = null;
	   try {
	      ret = (PDC)this.get("PDC");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns NTE (Notes and comments segment) - creates it if necessary
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

}
