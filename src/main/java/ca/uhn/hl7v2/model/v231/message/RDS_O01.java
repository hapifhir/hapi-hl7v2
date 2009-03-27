package ca.uhn.hl7v2.model.v231.message;

import ca.uhn.log.HapiLogFactory;
import ca.uhn.hl7v2.model.v231.group.*;

import ca.uhn.hl7v2.model.v231.segment.*;

import ca.uhn.hl7v2.HL7Exception;

import ca.uhn.hl7v2.parser.ModelClassFactory;

import ca.uhn.hl7v2.parser.DefaultModelClassFactory;

import ca.uhn.hl7v2.model.AbstractMessage;

/**
 * <p>Represents a RDS_O01 message structure (see chapter ?). This structure contains the 
 * following elements: </p>
 * 0: MSH (MSH - message header segment) <b></b><br>
 * 1: NTE (NTE - notes and comments segment) <b>optional repeating</b><br>
 * 2: RDS_O01_PIDPD1NTEAL1PV1PV2 (a Group object) <b>optional </b><br>
 * 3: RDS_O01_ORCRXONTERXRRXCNTERXERXRRXCRXDRXRRXCOBXNTE (a Group object) <b>repeating</b><br>
 */
public class RDS_O01 extends AbstractMessage  {

	/** 
	 * Creates a new RDS_O01 Group with custom ModelClassFactory.
	 */
	public RDS_O01(ModelClassFactory factory) {
	   super(factory);
	   init(factory);
	}

	/**
	 * Creates a new RDS_O01 Group with DefaultModelClassFactory. 
	 */ 
	public RDS_O01() { 
	   super(new DefaultModelClassFactory());
	   init(new DefaultModelClassFactory());
	}

	private void init(ModelClassFactory factory) {
	   try {
	      this.add(MSH.class, true, false);
	      this.add(NTE.class, false, true);
	      this.add(RDS_O01_PIDPD1NTEAL1PV1PV2.class, false, false);
	      this.add(RDS_O01_ORCRXONTERXRRXCNTERXERXRRXCRXDRXRRXCOBXNTE.class, true, true);
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error creating RDS_O01 - this is probably a bug in the source code generator.", e);
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
	 * Returns RDS_O01_PIDPD1NTEAL1PV1PV2 (a Group object) - creates it if necessary
	 */
	public RDS_O01_PIDPD1NTEAL1PV1PV2 getPIDPD1NTEAL1PV1PV2() { 
	   RDS_O01_PIDPD1NTEAL1PV1PV2 ret = null;
	   try {
	      ret = (RDS_O01_PIDPD1NTEAL1PV1PV2)this.get("PIDPD1NTEAL1PV1PV2");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns  first repetition of RDS_O01_ORCRXONTERXRRXCNTERXERXRRXCRXDRXRRXCOBXNTE (a Group object) - creates it if necessary
	 */
	public RDS_O01_ORCRXONTERXRRXCNTERXERXRRXCRXDRXRRXCOBXNTE getORCRXONTERXRRXCNTERXERXRRXCRXDRXRRXCOBXNTE() { 
	   RDS_O01_ORCRXONTERXRRXCNTERXERXRRXCRXDRXRRXCOBXNTE ret = null;
	   try {
	      ret = (RDS_O01_ORCRXONTERXRRXCNTERXERXRRXCRXDRXRRXCOBXNTE)this.get("ORCRXONTERXRRXCNTERXERXRRXCRXDRXRRXCOBXNTE");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns a specific repetition of RDS_O01_ORCRXONTERXRRXCNTERXERXRRXCRXDRXRRXCOBXNTE
	 * (a Group object) - creates it if necessary
	 * throws HL7Exception if the repetition requested is more than one 
	 *     greater than the number of existing repetitions.
	 */
	public RDS_O01_ORCRXONTERXRRXCNTERXERXRRXCRXDRXRRXCOBXNTE getORCRXONTERXRRXCNTERXERXRRXCRXDRXRRXCOBXNTE(int rep) throws HL7Exception { 
	   return (RDS_O01_ORCRXONTERXRRXCNTERXERXRRXCRXDRXRRXCOBXNTE)this.get("ORCRXONTERXRRXCNTERXERXRRXCRXDRXRRXCOBXNTE", rep);
	}

	/** 
	 * Returns the number of existing repetitions of RDS_O01_ORCRXONTERXRRXCNTERXERXRRXCRXDRXRRXCOBXNTE 
	 */ 
	public int getORCRXONTERXRRXCNTERXERXRRXCRXDRXRRXCOBXNTEReps() { 
	    int reps = -1; 
	    try { 
	        reps = this.getAll("ORCRXONTERXRRXCNTERXERXRRXCRXDRXRRXCOBXNTE").length; 
	    } catch (HL7Exception e) { 
	        String message = "Unexpected error accessing data - this is probably a bug in the source code generator."; 
	        HapiLogFactory.getHapiLog(this.getClass()).error(message, e); 
	        throw new RuntimeException(message);
	    } 
	    return reps; 
	} 

}
