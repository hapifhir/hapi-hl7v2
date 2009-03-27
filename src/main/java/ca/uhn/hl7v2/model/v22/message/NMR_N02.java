package ca.uhn.hl7v2.model.v22.message;

import ca.uhn.log.HapiLogFactory;
import ca.uhn.hl7v2.model.v22.group.*;

import ca.uhn.hl7v2.model.v22.segment.*;

import ca.uhn.hl7v2.HL7Exception;

import ca.uhn.hl7v2.parser.ModelClassFactory;

import ca.uhn.hl7v2.parser.DefaultModelClassFactory;

import ca.uhn.hl7v2.model.AbstractMessage;

/**
 * <p>Represents a NMR_N02 message structure (see chapter ?). This structure contains the 
 * following elements: </p>
 * 0: MSH (MESSAGE HEADER) <b></b><br>
 * 1: MSA (MESSAGE ACKNOWLEDGMENT) <b></b><br>
 * 2: ERR (ERROR) <b>optional </b><br>
 * 3: QRD (QUERY DEFINITION) <b>optional </b><br>
 * 4: NMR_N02_CLOCK_AND_STATS_WITH_NOTES_ALT (a Group object) <b>repeating</b><br>
 */
public class NMR_N02 extends AbstractMessage  {

	/** 
	 * Creates a new NMR_N02 Group with custom ModelClassFactory.
	 */
	public NMR_N02(ModelClassFactory factory) {
	   super(factory);
	   init(factory);
	}

	/**
	 * Creates a new NMR_N02 Group with DefaultModelClassFactory. 
	 */ 
	public NMR_N02() { 
	   super(new DefaultModelClassFactory());
	   init(new DefaultModelClassFactory());
	}

	private void init(ModelClassFactory factory) {
	   try {
	      this.add(MSH.class, true, false);
	      this.add(MSA.class, true, false);
	      this.add(ERR.class, false, false);
	      this.add(QRD.class, false, false);
	      this.add(NMR_N02_CLOCK_AND_STATS_WITH_NOTES_ALT.class, true, true);
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error creating NMR_N02 - this is probably a bug in the source code generator.", e);
	   }
	}

	/**
	 * Returns MSH (MESSAGE HEADER) - creates it if necessary
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
	 * Returns MSA (MESSAGE ACKNOWLEDGMENT) - creates it if necessary
	 */
	public MSA getMSA() { 
	   MSA ret = null;
	   try {
	      ret = (MSA)this.get("MSA");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns ERR (ERROR) - creates it if necessary
	 */
	public ERR getERR() { 
	   ERR ret = null;
	   try {
	      ret = (ERR)this.get("ERR");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns QRD (QUERY DEFINITION) - creates it if necessary
	 */
	public QRD getQRD() { 
	   QRD ret = null;
	   try {
	      ret = (QRD)this.get("QRD");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns  first repetition of NMR_N02_CLOCK_AND_STATS_WITH_NOTES_ALT (a Group object) - creates it if necessary
	 */
	public NMR_N02_CLOCK_AND_STATS_WITH_NOTES_ALT getCLOCK_AND_STATS_WITH_NOTES_ALT() { 
	   NMR_N02_CLOCK_AND_STATS_WITH_NOTES_ALT ret = null;
	   try {
	      ret = (NMR_N02_CLOCK_AND_STATS_WITH_NOTES_ALT)this.get("CLOCK_AND_STATS_WITH_NOTES_ALT");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns a specific repetition of NMR_N02_CLOCK_AND_STATS_WITH_NOTES_ALT
	 * (a Group object) - creates it if necessary
	 * throws HL7Exception if the repetition requested is more than one 
	 *     greater than the number of existing repetitions.
	 */
	public NMR_N02_CLOCK_AND_STATS_WITH_NOTES_ALT getCLOCK_AND_STATS_WITH_NOTES_ALT(int rep) throws HL7Exception { 
	   return (NMR_N02_CLOCK_AND_STATS_WITH_NOTES_ALT)this.get("CLOCK_AND_STATS_WITH_NOTES_ALT", rep);
	}

	/** 
	 * Returns the number of existing repetitions of NMR_N02_CLOCK_AND_STATS_WITH_NOTES_ALT 
	 */ 
	public int getCLOCK_AND_STATS_WITH_NOTES_ALTReps() { 
	    int reps = -1; 
	    try { 
	        reps = this.getAll("CLOCK_AND_STATS_WITH_NOTES_ALT").length; 
	    } catch (HL7Exception e) { 
	        String message = "Unexpected error accessing data - this is probably a bug in the source code generator."; 
	        HapiLogFactory.getHapiLog(this.getClass()).error(message, e); 
	        throw new RuntimeException(message);
	    } 
	    return reps; 
	} 

}
