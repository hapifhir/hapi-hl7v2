package ca.uhn.hl7v2.model.v231.group;

import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.log.HapiLogFactory;
import ca.uhn.hl7v2.model.v231.segment.*;

import ca.uhn.hl7v2.model.*;
/**
 * <p>Represents the ORR_O02_PIDNTEORCOBRRQDRQ1RXOODSODTNTECTI Group.  A Group is an ordered collection of message 
 * segments that can repeat together or be optionally in/excluded together.
 * This Group contains the following elements: </p>
 * 0: ORR_O02_PIDNTE (a Group object) <b>optional </b><br>
 * 1: ORR_O02_ORCOBRRQDRQ1RXOODSODTNTECTI (a Group object) <b>repeating</b><br>
 */
public class ORR_O02_PIDNTEORCOBRRQDRQ1RXOODSODTNTECTI extends AbstractGroup {

	/** 
	 * Creates a new ORR_O02_PIDNTEORCOBRRQDRQ1RXOODSODTNTECTI Group.
	 */
	public ORR_O02_PIDNTEORCOBRRQDRQ1RXOODSODTNTECTI(Group parent, ModelClassFactory factory) {
	   super(parent, factory);
	   try {
	      this.add(ORR_O02_PIDNTE.class, false, false);
	      this.add(ORR_O02_ORCOBRRQDRQ1RXOODSODTNTECTI.class, true, true);
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error creating ORR_O02_PIDNTEORCOBRRQDRQ1RXOODSODTNTECTI - this is probably a bug in the source code generator.", e);
	   }
	}

	/**
	 * Returns ORR_O02_PIDNTE (a Group object) - creates it if necessary
	 */
	public ORR_O02_PIDNTE getPIDNTE() { 
	   ORR_O02_PIDNTE ret = null;
	   try {
	      ret = (ORR_O02_PIDNTE)this.get("PIDNTE");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns  first repetition of ORR_O02_ORCOBRRQDRQ1RXOODSODTNTECTI (a Group object) - creates it if necessary
	 */
	public ORR_O02_ORCOBRRQDRQ1RXOODSODTNTECTI getORCOBRRQDRQ1RXOODSODTNTECTI() { 
	   ORR_O02_ORCOBRRQDRQ1RXOODSODTNTECTI ret = null;
	   try {
	      ret = (ORR_O02_ORCOBRRQDRQ1RXOODSODTNTECTI)this.get("ORCOBRRQDRQ1RXOODSODTNTECTI");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns a specific repetition of ORR_O02_ORCOBRRQDRQ1RXOODSODTNTECTI
	 * (a Group object) - creates it if necessary
	 * throws HL7Exception if the repetition requested is more than one 
	 *     greater than the number of existing repetitions.
	 */
	public ORR_O02_ORCOBRRQDRQ1RXOODSODTNTECTI getORCOBRRQDRQ1RXOODSODTNTECTI(int rep) throws HL7Exception { 
	   return (ORR_O02_ORCOBRRQDRQ1RXOODSODTNTECTI)this.get("ORCOBRRQDRQ1RXOODSODTNTECTI", rep);
	}

	/** 
	 * Returns the number of existing repetitions of ORR_O02_ORCOBRRQDRQ1RXOODSODTNTECTI 
	 */ 
	public int getORCOBRRQDRQ1RXOODSODTNTECTIReps() { 
	    int reps = -1; 
	    try { 
	        reps = this.getAll("ORCOBRRQDRQ1RXOODSODTNTECTI").length; 
	    } catch (HL7Exception e) { 
	        String message = "Unexpected error accessing data - this is probably a bug in the source code generator."; 
	        HapiLogFactory.getHapiLog(this.getClass()).error(message, e); 
	        throw new RuntimeException(message);
	    } 
	    return reps; 
	} 

}
