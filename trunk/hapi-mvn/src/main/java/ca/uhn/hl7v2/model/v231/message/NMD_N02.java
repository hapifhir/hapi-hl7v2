package ca.uhn.hl7v2.model.v231.message;

import ca.uhn.log.HapiLogFactory;
import ca.uhn.hl7v2.model.v231.group.*;

import ca.uhn.hl7v2.model.v231.segment.*;

import ca.uhn.hl7v2.HL7Exception;

import ca.uhn.hl7v2.parser.ModelClassFactory;

import ca.uhn.hl7v2.parser.DefaultModelClassFactory;

import ca.uhn.hl7v2.model.AbstractMessage;

/**
 * <p>Represents a NMD_N02 message structure (see chapter 14). This structure contains the 
 * following elements: </p>
 * 0: MSH (MSH - message header segment) <b></b><br>
 * 1: NMD_N02_NCKNTENSTNTENSCNTE (a Group object) <b>repeating</b><br>
 */
public class NMD_N02 extends AbstractMessage  {

	/** 
	 * Creates a new NMD_N02 Group with custom ModelClassFactory.
	 */
	public NMD_N02(ModelClassFactory factory) {
	   super(factory);
	   init(factory);
	}

	/**
	 * Creates a new NMD_N02 Group with DefaultModelClassFactory. 
	 */ 
	public NMD_N02() { 
	   super(new DefaultModelClassFactory());
	   init(new DefaultModelClassFactory());
	}

	private void init(ModelClassFactory factory) {
	   try {
	      this.add(MSH.class, true, false);
	      this.add(NMD_N02_NCKNTENSTNTENSCNTE.class, true, true);
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error creating NMD_N02 - this is probably a bug in the source code generator.", e);
	   }
	}

	/**
	 * Returns MSH (MSH - message header segment) - creates it if necessary
	 */
	public MSH getMSH() { 
	   MSH ret = null;
	   try {
	      ret = (MSH)this.get("MSH");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns  first repetition of NMD_N02_NCKNTENSTNTENSCNTE (a Group object) - creates it if necessary
	 */
	public NMD_N02_NCKNTENSTNTENSCNTE getNCKNTENSTNTENSCNTE() { 
	   NMD_N02_NCKNTENSTNTENSCNTE ret = null;
	   try {
	      ret = (NMD_N02_NCKNTENSTNTENSCNTE)this.get("NCKNTENSTNTENSCNTE");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns a specific repetition of NMD_N02_NCKNTENSTNTENSCNTE
	 * (a Group object) - creates it if necessary
	 * throws HL7Exception if the repetition requested is more than one 
	 *     greater than the number of existing repetitions.
	 */
	public NMD_N02_NCKNTENSTNTENSCNTE getNCKNTENSTNTENSCNTE(int rep) throws HL7Exception { 
	   return (NMD_N02_NCKNTENSTNTENSCNTE)this.get("NCKNTENSTNTENSCNTE", rep);
	}

	/** 
	 * Returns the number of existing repetitions of NMD_N02_NCKNTENSTNTENSCNTE 
	 */ 
	public int getNCKNTENSTNTENSCNTEReps() { 
	    int reps = -1; 
	    try { 
	        reps = this.getAll("NCKNTENSTNTENSCNTE").length; 
	    } catch (HL7Exception e) { 
	        String message = "Unexpected error accessing data - this is probably a bug in the source code generator."; 
	        HapiLogFactory.getHapiLog(this.getClass()).error(message, e); 
	        throw new RuntimeException(message);
	    } 
	    return reps; 
	} 

}
