package ca.uhn.hl7v2.model.v231.group;

import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.log.HapiLogFactory;
import ca.uhn.hl7v2.model.v231.segment.*;

import ca.uhn.hl7v2.model.*;
/**
 * <p>Represents the NMR_N01_NCKNTENSTNTENSCNTE Group.  A Group is an ordered collection of message 
 * segments that can repeat together or be optionally in/excluded together.
 * This Group contains the following elements: </p>
 * 0: NCK (System Clock) <b>optional </b><br>
 * 1: NTE (NTE - notes and comments segment) <b>optional repeating</b><br>
 * 2: NST (Application control level statistics) <b>optional </b><br>
 * 3: NTE (NTE - notes and comments segment) <b>optional repeating</b><br>
 * 4: NSC (Application status change) <b>optional </b><br>
 * 5: NTE (NTE - notes and comments segment) <b>optional repeating</b><br>
 */
public class NMR_N01_NCKNTENSTNTENSCNTE extends AbstractGroup {

	/** 
	 * Creates a new NMR_N01_NCKNTENSTNTENSCNTE Group.
	 */
	public NMR_N01_NCKNTENSTNTENSCNTE(Group parent, ModelClassFactory factory) {
	   super(parent, factory);
	   try {
	      this.add(NCK.class, false, false);
	      this.add(NTE.class, false, true);
	      this.add(NST.class, false, false);
	      this.add(NTE.class, false, true);
	      this.add(NSC.class, false, false);
	      this.add(NTE.class, false, true);
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error creating NMR_N01_NCKNTENSTNTENSCNTE - this is probably a bug in the source code generator.", e);
	   }
	}

	/**
	 * Returns NCK (System Clock) - creates it if necessary
	 */
	public NCK getNCK() { 
	   NCK ret = null;
	   try {
	      ret = (NCK)this.get("NCK");
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
	 * Returns NST (Application control level statistics) - creates it if necessary
	 */
	public NST getNST() { 
	   NST ret = null;
	   try {
	      ret = (NST)this.get("NST");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns  first repetition of NTE2 (NTE - notes and comments segment) - creates it if necessary
	 */
	public NTE getNTE2() { 
	   NTE ret = null;
	   try {
	      ret = (NTE)this.get("NTE2");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns a specific repetition of NTE2
	 * (NTE - notes and comments segment) - creates it if necessary
	 * throws HL7Exception if the repetition requested is more than one 
	 *     greater than the number of existing repetitions.
	 */
	public NTE getNTE2(int rep) throws HL7Exception { 
	   return (NTE)this.get("NTE2", rep);
	}

	/** 
	 * Returns the number of existing repetitions of NTE2 
	 */ 
	public int getNTE2Reps() { 
	    int reps = -1; 
	    try { 
	        reps = this.getAll("NTE2").length; 
	    } catch (HL7Exception e) { 
	        String message = "Unexpected error accessing data - this is probably a bug in the source code generator."; 
	        HapiLogFactory.getHapiLog(this.getClass()).error(message, e); 
	        throw new RuntimeException(message);
	    } 
	    return reps; 
	} 

	/**
	 * Returns NSC (Application status change) - creates it if necessary
	 */
	public NSC getNSC() { 
	   NSC ret = null;
	   try {
	      ret = (NSC)this.get("NSC");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns  first repetition of NTE3 (NTE - notes and comments segment) - creates it if necessary
	 */
	public NTE getNTE3() { 
	   NTE ret = null;
	   try {
	      ret = (NTE)this.get("NTE3");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns a specific repetition of NTE3
	 * (NTE - notes and comments segment) - creates it if necessary
	 * throws HL7Exception if the repetition requested is more than one 
	 *     greater than the number of existing repetitions.
	 */
	public NTE getNTE3(int rep) throws HL7Exception { 
	   return (NTE)this.get("NTE3", rep);
	}

	/** 
	 * Returns the number of existing repetitions of NTE3 
	 */ 
	public int getNTE3Reps() { 
	    int reps = -1; 
	    try { 
	        reps = this.getAll("NTE3").length; 
	    } catch (HL7Exception e) { 
	        String message = "Unexpected error accessing data - this is probably a bug in the source code generator."; 
	        HapiLogFactory.getHapiLog(this.getClass()).error(message, e); 
	        throw new RuntimeException(message);
	    } 
	    return reps; 
	} 

}
