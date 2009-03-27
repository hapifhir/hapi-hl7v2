package ca.uhn.hl7v2.model.v25.group;

import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.log.HapiLogFactory;
import ca.uhn.hl7v2.model.v25.segment.*;

import ca.uhn.hl7v2.model.*;
/**
 * <p>Represents the PEX_P07_ASSOCIATED_PERSON Group.  A Group is an ordered collection of message 
 * segments that can repeat together or be optionally in/excluded together.
 * This Group contains the following elements: </p>
 * 0: NK1 (Next of Kin / Associated Parties) <b></b><br>
 * 1: PEX_P07_ASSOCIATED_RX_ORDER (a Group object) <b>optional </b><br>
 * 2: PEX_P07_ASSOCIATED_RX_ADMIN (a Group object) <b>optional repeating</b><br>
 * 3: PRB (Problem Details) <b>optional repeating</b><br>
 * 4: OBX (Observation/Result) <b>optional repeating</b><br>
 */
public class PEX_P07_ASSOCIATED_PERSON extends AbstractGroup {

	/** 
	 * Creates a new PEX_P07_ASSOCIATED_PERSON Group.
	 */
	public PEX_P07_ASSOCIATED_PERSON(Group parent, ModelClassFactory factory) {
	   super(parent, factory);
	   try {
	      this.add(NK1.class, true, false);
	      this.add(PEX_P07_ASSOCIATED_RX_ORDER.class, false, false);
	      this.add(PEX_P07_ASSOCIATED_RX_ADMIN.class, false, true);
	      this.add(PRB.class, false, true);
	      this.add(OBX.class, false, true);
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error creating PEX_P07_ASSOCIATED_PERSON - this is probably a bug in the source code generator.", e);
	   }
	}

	/**
	 * Returns NK1 (Next of Kin / Associated Parties) - creates it if necessary
	 */
	public NK1 getNK1() { 
	   NK1 ret = null;
	   try {
	      ret = (NK1)this.get("NK1");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns PEX_P07_ASSOCIATED_RX_ORDER (a Group object) - creates it if necessary
	 */
	public PEX_P07_ASSOCIATED_RX_ORDER getASSOCIATED_RX_ORDER() { 
	   PEX_P07_ASSOCIATED_RX_ORDER ret = null;
	   try {
	      ret = (PEX_P07_ASSOCIATED_RX_ORDER)this.get("ASSOCIATED_RX_ORDER");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns  first repetition of PEX_P07_ASSOCIATED_RX_ADMIN (a Group object) - creates it if necessary
	 */
	public PEX_P07_ASSOCIATED_RX_ADMIN getASSOCIATED_RX_ADMIN() { 
	   PEX_P07_ASSOCIATED_RX_ADMIN ret = null;
	   try {
	      ret = (PEX_P07_ASSOCIATED_RX_ADMIN)this.get("ASSOCIATED_RX_ADMIN");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns a specific repetition of PEX_P07_ASSOCIATED_RX_ADMIN
	 * (a Group object) - creates it if necessary
	 * throws HL7Exception if the repetition requested is more than one 
	 *     greater than the number of existing repetitions.
	 */
	public PEX_P07_ASSOCIATED_RX_ADMIN getASSOCIATED_RX_ADMIN(int rep) throws HL7Exception { 
	   return (PEX_P07_ASSOCIATED_RX_ADMIN)this.get("ASSOCIATED_RX_ADMIN", rep);
	}

	/** 
	 * Returns the number of existing repetitions of PEX_P07_ASSOCIATED_RX_ADMIN 
	 */ 
	public int getASSOCIATED_RX_ADMINReps() { 
	    int reps = -1; 
	    try { 
	        reps = this.getAll("ASSOCIATED_RX_ADMIN").length; 
	    } catch (HL7Exception e) { 
	        String message = "Unexpected error accessing data - this is probably a bug in the source code generator."; 
	        HapiLogFactory.getHapiLog(this.getClass()).error(message, e); 
	        throw new RuntimeException(message);
	    } 
	    return reps; 
	} 

	/**
	 * Returns  first repetition of PRB (Problem Details) - creates it if necessary
	 */
	public PRB getPRB() { 
	   PRB ret = null;
	   try {
	      ret = (PRB)this.get("PRB");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns a specific repetition of PRB
	 * (Problem Details) - creates it if necessary
	 * throws HL7Exception if the repetition requested is more than one 
	 *     greater than the number of existing repetitions.
	 */
	public PRB getPRB(int rep) throws HL7Exception { 
	   return (PRB)this.get("PRB", rep);
	}

	/** 
	 * Returns the number of existing repetitions of PRB 
	 */ 
	public int getPRBReps() { 
	    int reps = -1; 
	    try { 
	        reps = this.getAll("PRB").length; 
	    } catch (HL7Exception e) { 
	        String message = "Unexpected error accessing data - this is probably a bug in the source code generator."; 
	        HapiLogFactory.getHapiLog(this.getClass()).error(message, e); 
	        throw new RuntimeException(message);
	    } 
	    return reps; 
	} 

	/**
	 * Returns  first repetition of OBX (Observation/Result) - creates it if necessary
	 */
	public OBX getOBX() { 
	   OBX ret = null;
	   try {
	      ret = (OBX)this.get("OBX");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns a specific repetition of OBX
	 * (Observation/Result) - creates it if necessary
	 * throws HL7Exception if the repetition requested is more than one 
	 *     greater than the number of existing repetitions.
	 */
	public OBX getOBX(int rep) throws HL7Exception { 
	   return (OBX)this.get("OBX", rep);
	}

	/** 
	 * Returns the number of existing repetitions of OBX 
	 */ 
	public int getOBXReps() { 
	    int reps = -1; 
	    try { 
	        reps = this.getAll("OBX").length; 
	    } catch (HL7Exception e) { 
	        String message = "Unexpected error accessing data - this is probably a bug in the source code generator."; 
	        HapiLogFactory.getHapiLog(this.getClass()).error(message, e); 
	        throw new RuntimeException(message);
	    } 
	    return reps; 
	} 

}
