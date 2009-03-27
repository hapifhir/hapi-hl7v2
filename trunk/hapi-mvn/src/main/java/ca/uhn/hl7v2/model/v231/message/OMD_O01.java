package ca.uhn.hl7v2.model.v231.message;

import ca.uhn.log.HapiLogFactory;
import ca.uhn.hl7v2.model.v231.group.*;

import ca.uhn.hl7v2.model.v231.segment.*;

import ca.uhn.hl7v2.HL7Exception;

import ca.uhn.hl7v2.parser.ModelClassFactory;

import ca.uhn.hl7v2.parser.DefaultModelClassFactory;

import ca.uhn.hl7v2.model.AbstractMessage;

/**
 * <p>Represents a OMD_O01 message structure (see chapter 4.6). This structure contains the 
 * following elements: </p>
 * 0: MSH (MSH - message header segment) <b></b><br>
 * 1: NTE (NTE - notes and comments segment) <b>optional repeating</b><br>
 * 2: OMD_O01_PIDPD1NTEPV1PV2IN1IN2IN3GT1AL1 (a Group object) <b>optional </b><br>
 * 3: OMD_O01_ORCODSNTEOBXNTE (a Group object) <b>repeating</b><br>
 * 4: OMD_O01_ORCODTNTE (a Group object) <b>optional repeating</b><br>
 */
public class OMD_O01 extends AbstractMessage  {

	/** 
	 * Creates a new OMD_O01 Group with custom ModelClassFactory.
	 */
	public OMD_O01(ModelClassFactory factory) {
	   super(factory);
	   init(factory);
	}

	/**
	 * Creates a new OMD_O01 Group with DefaultModelClassFactory. 
	 */ 
	public OMD_O01() { 
	   super(new DefaultModelClassFactory());
	   init(new DefaultModelClassFactory());
	}

	private void init(ModelClassFactory factory) {
	   try {
	      this.add(MSH.class, true, false);
	      this.add(NTE.class, false, true);
	      this.add(OMD_O01_PIDPD1NTEPV1PV2IN1IN2IN3GT1AL1.class, false, false);
	      this.add(OMD_O01_ORCODSNTEOBXNTE.class, true, true);
	      this.add(OMD_O01_ORCODTNTE.class, false, true);
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error creating OMD_O01 - this is probably a bug in the source code generator.", e);
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
	 * Returns OMD_O01_PIDPD1NTEPV1PV2IN1IN2IN3GT1AL1 (a Group object) - creates it if necessary
	 */
	public OMD_O01_PIDPD1NTEPV1PV2IN1IN2IN3GT1AL1 getPIDPD1NTEPV1PV2IN1IN2IN3GT1AL1() { 
	   OMD_O01_PIDPD1NTEPV1PV2IN1IN2IN3GT1AL1 ret = null;
	   try {
	      ret = (OMD_O01_PIDPD1NTEPV1PV2IN1IN2IN3GT1AL1)this.get("PIDPD1NTEPV1PV2IN1IN2IN3GT1AL1");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns  first repetition of OMD_O01_ORCODSNTEOBXNTE (a Group object) - creates it if necessary
	 */
	public OMD_O01_ORCODSNTEOBXNTE getORCODSNTEOBXNTE() { 
	   OMD_O01_ORCODSNTEOBXNTE ret = null;
	   try {
	      ret = (OMD_O01_ORCODSNTEOBXNTE)this.get("ORCODSNTEOBXNTE");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns a specific repetition of OMD_O01_ORCODSNTEOBXNTE
	 * (a Group object) - creates it if necessary
	 * throws HL7Exception if the repetition requested is more than one 
	 *     greater than the number of existing repetitions.
	 */
	public OMD_O01_ORCODSNTEOBXNTE getORCODSNTEOBXNTE(int rep) throws HL7Exception { 
	   return (OMD_O01_ORCODSNTEOBXNTE)this.get("ORCODSNTEOBXNTE", rep);
	}

	/** 
	 * Returns the number of existing repetitions of OMD_O01_ORCODSNTEOBXNTE 
	 */ 
	public int getORCODSNTEOBXNTEReps() { 
	    int reps = -1; 
	    try { 
	        reps = this.getAll("ORCODSNTEOBXNTE").length; 
	    } catch (HL7Exception e) { 
	        String message = "Unexpected error accessing data - this is probably a bug in the source code generator."; 
	        HapiLogFactory.getHapiLog(this.getClass()).error(message, e); 
	        throw new RuntimeException(message);
	    } 
	    return reps; 
	} 

	/**
	 * Returns  first repetition of OMD_O01_ORCODTNTE (a Group object) - creates it if necessary
	 */
	public OMD_O01_ORCODTNTE getORCODTNTE() { 
	   OMD_O01_ORCODTNTE ret = null;
	   try {
	      ret = (OMD_O01_ORCODTNTE)this.get("ORCODTNTE");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns a specific repetition of OMD_O01_ORCODTNTE
	 * (a Group object) - creates it if necessary
	 * throws HL7Exception if the repetition requested is more than one 
	 *     greater than the number of existing repetitions.
	 */
	public OMD_O01_ORCODTNTE getORCODTNTE(int rep) throws HL7Exception { 
	   return (OMD_O01_ORCODTNTE)this.get("ORCODTNTE", rep);
	}

	/** 
	 * Returns the number of existing repetitions of OMD_O01_ORCODTNTE 
	 */ 
	public int getORCODTNTEReps() { 
	    int reps = -1; 
	    try { 
	        reps = this.getAll("ORCODTNTE").length; 
	    } catch (HL7Exception e) { 
	        String message = "Unexpected error accessing data - this is probably a bug in the source code generator."; 
	        HapiLogFactory.getHapiLog(this.getClass()).error(message, e); 
	        throw new RuntimeException(message);
	    } 
	    return reps; 
	} 

}
