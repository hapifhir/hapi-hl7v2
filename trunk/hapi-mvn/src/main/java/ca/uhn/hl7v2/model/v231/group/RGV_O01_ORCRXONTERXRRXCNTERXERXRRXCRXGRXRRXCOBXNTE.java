package ca.uhn.hl7v2.model.v231.group;

import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.log.HapiLogFactory;
import ca.uhn.hl7v2.model.v231.segment.*;

import ca.uhn.hl7v2.model.*;
/**
 * <p>Represents the RGV_O01_ORCRXONTERXRRXCNTERXERXRRXCRXGRXRRXCOBXNTE Group.  A Group is an ordered collection of message 
 * segments that can repeat together or be optionally in/excluded together.
 * This Group contains the following elements: </p>
 * 0: ORC (ORC - common order segment) <b></b><br>
 * 1: RGV_O01_RXONTERXRRXCNTE (a Group object) <b>optional </b><br>
 * 2: RGV_O01_RXERXRRXC (a Group object) <b>optional </b><br>
 * 3: RGV_O01_RXGRXRRXCOBXNTE (a Group object) <b>repeating</b><br>
 */
public class RGV_O01_ORCRXONTERXRRXCNTERXERXRRXCRXGRXRRXCOBXNTE extends AbstractGroup {

	/** 
	 * Creates a new RGV_O01_ORCRXONTERXRRXCNTERXERXRRXCRXGRXRRXCOBXNTE Group.
	 */
	public RGV_O01_ORCRXONTERXRRXCNTERXERXRRXCRXGRXRRXCOBXNTE(Group parent, ModelClassFactory factory) {
	   super(parent, factory);
	   try {
	      this.add(ORC.class, true, false);
	      this.add(RGV_O01_RXONTERXRRXCNTE.class, false, false);
	      this.add(RGV_O01_RXERXRRXC.class, false, false);
	      this.add(RGV_O01_RXGRXRRXCOBXNTE.class, true, true);
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error creating RGV_O01_ORCRXONTERXRRXCNTERXERXRRXCRXGRXRRXCOBXNTE - this is probably a bug in the source code generator.", e);
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
	 * Returns RGV_O01_RXONTERXRRXCNTE (a Group object) - creates it if necessary
	 */
	public RGV_O01_RXONTERXRRXCNTE getRXONTERXRRXCNTE() { 
	   RGV_O01_RXONTERXRRXCNTE ret = null;
	   try {
	      ret = (RGV_O01_RXONTERXRRXCNTE)this.get("RXONTERXRRXCNTE");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns RGV_O01_RXERXRRXC (a Group object) - creates it if necessary
	 */
	public RGV_O01_RXERXRRXC getRXERXRRXC() { 
	   RGV_O01_RXERXRRXC ret = null;
	   try {
	      ret = (RGV_O01_RXERXRRXC)this.get("RXERXRRXC");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns  first repetition of RGV_O01_RXGRXRRXCOBXNTE (a Group object) - creates it if necessary
	 */
	public RGV_O01_RXGRXRRXCOBXNTE getRXGRXRRXCOBXNTE() { 
	   RGV_O01_RXGRXRRXCOBXNTE ret = null;
	   try {
	      ret = (RGV_O01_RXGRXRRXCOBXNTE)this.get("RXGRXRRXCOBXNTE");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns a specific repetition of RGV_O01_RXGRXRRXCOBXNTE
	 * (a Group object) - creates it if necessary
	 * throws HL7Exception if the repetition requested is more than one 
	 *     greater than the number of existing repetitions.
	 */
	public RGV_O01_RXGRXRRXCOBXNTE getRXGRXRRXCOBXNTE(int rep) throws HL7Exception { 
	   return (RGV_O01_RXGRXRRXCOBXNTE)this.get("RXGRXRRXCOBXNTE", rep);
	}

	/** 
	 * Returns the number of existing repetitions of RGV_O01_RXGRXRRXCOBXNTE 
	 */ 
	public int getRXGRXRRXCOBXNTEReps() { 
	    int reps = -1; 
	    try { 
	        reps = this.getAll("RXGRXRRXCOBXNTE").length; 
	    } catch (HL7Exception e) { 
	        String message = "Unexpected error accessing data - this is probably a bug in the source code generator."; 
	        HapiLogFactory.getHapiLog(this.getClass()).error(message, e); 
	        throw new RuntimeException(message);
	    } 
	    return reps; 
	} 

}
