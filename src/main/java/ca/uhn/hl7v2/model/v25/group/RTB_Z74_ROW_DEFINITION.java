package ca.uhn.hl7v2.model.v25.group;

import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.log.HapiLogFactory;
import ca.uhn.hl7v2.model.v25.segment.*;

import ca.uhn.hl7v2.model.*;
/**
 * <p>Represents the RTB_Z74_ROW_DEFINITION Group.  A Group is an ordered collection of message 
 * segments that can repeat together or be optionally in/excluded together.
 * This Group contains the following elements: </p>
 * 0: RDF (Table Row Definition) <b></b><br>
 * 1: RDT (Table Row Data) <b>optional repeating</b><br>
 */
public class RTB_Z74_ROW_DEFINITION extends AbstractGroup {

	/** 
	 * Creates a new RTB_Z74_ROW_DEFINITION Group.
	 */
	public RTB_Z74_ROW_DEFINITION(Group parent, ModelClassFactory factory) {
	   super(parent, factory);
	   try {
	      this.add(RDF.class, true, false);
	      this.add(RDT.class, false, true);
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error creating RTB_Z74_ROW_DEFINITION - this is probably a bug in the source code generator.", e);
	   }
	}

	/**
	 * Returns RDF (Table Row Definition) - creates it if necessary
	 */
	public RDF getRDF() { 
	   RDF ret = null;
	   try {
	      ret = (RDF)this.get("RDF");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns  first repetition of RDT (Table Row Data) - creates it if necessary
	 */
	public RDT getRDT() { 
	   RDT ret = null;
	   try {
	      ret = (RDT)this.get("RDT");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns a specific repetition of RDT
	 * (Table Row Data) - creates it if necessary
	 * throws HL7Exception if the repetition requested is more than one 
	 *     greater than the number of existing repetitions.
	 */
	public RDT getRDT(int rep) throws HL7Exception { 
	   return (RDT)this.get("RDT", rep);
	}

	/** 
	 * Returns the number of existing repetitions of RDT 
	 */ 
	public int getRDTReps() { 
	    int reps = -1; 
	    try { 
	        reps = this.getAll("RDT").length; 
	    } catch (HL7Exception e) { 
	        String message = "Unexpected error accessing data - this is probably a bug in the source code generator."; 
	        HapiLogFactory.getHapiLog(this.getClass()).error(message, e); 
	        throw new RuntimeException(message);
	    } 
	    return reps; 
	} 

}
