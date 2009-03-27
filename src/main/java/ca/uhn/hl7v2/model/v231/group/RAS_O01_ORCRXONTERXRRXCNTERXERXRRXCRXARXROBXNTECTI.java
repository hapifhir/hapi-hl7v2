package ca.uhn.hl7v2.model.v231.group;

import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.log.HapiLogFactory;
import ca.uhn.hl7v2.model.v231.segment.*;

import ca.uhn.hl7v2.model.*;
/**
 * <p>Represents the RAS_O01_ORCRXONTERXRRXCNTERXERXRRXCRXARXROBXNTECTI Group.  A Group is an ordered collection of message 
 * segments that can repeat together or be optionally in/excluded together.
 * This Group contains the following elements: </p>
 * 0: ORC (ORC - common order segment) <b></b><br>
 * 1: RAS_O01_RXONTERXRRXCNTE (a Group object) <b>optional </b><br>
 * 2: RAS_O01_RXERXRRXC (a Group object) <b>optional </b><br>
 * 3: RXA (RXA - pharmacy/treatment administration segment) <b>repeating</b><br>
 * 4: RXR (RXR - pharmacy/treatment route segment) <b></b><br>
 * 5: RAS_O01_OBXNTE (a Group object) <b>optional repeating</b><br>
 * 6: CTI (CTI - clinical trial identification segment) <b>optional repeating</b><br>
 */
public class RAS_O01_ORCRXONTERXRRXCNTERXERXRRXCRXARXROBXNTECTI extends AbstractGroup {

	/** 
	 * Creates a new RAS_O01_ORCRXONTERXRRXCNTERXERXRRXCRXARXROBXNTECTI Group.
	 */
	public RAS_O01_ORCRXONTERXRRXCNTERXERXRRXCRXARXROBXNTECTI(Group parent, ModelClassFactory factory) {
	   super(parent, factory);
	   try {
	      this.add(ORC.class, true, false);
	      this.add(RAS_O01_RXONTERXRRXCNTE.class, false, false);
	      this.add(RAS_O01_RXERXRRXC.class, false, false);
	      this.add(RXA.class, true, true);
	      this.add(RXR.class, true, false);
	      this.add(RAS_O01_OBXNTE.class, false, true);
	      this.add(CTI.class, false, true);
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error creating RAS_O01_ORCRXONTERXRRXCNTERXERXRRXCRXARXROBXNTECTI - this is probably a bug in the source code generator.", e);
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
	 * Returns RAS_O01_RXONTERXRRXCNTE (a Group object) - creates it if necessary
	 */
	public RAS_O01_RXONTERXRRXCNTE getRXONTERXRRXCNTE() { 
	   RAS_O01_RXONTERXRRXCNTE ret = null;
	   try {
	      ret = (RAS_O01_RXONTERXRRXCNTE)this.get("RXONTERXRRXCNTE");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns RAS_O01_RXERXRRXC (a Group object) - creates it if necessary
	 */
	public RAS_O01_RXERXRRXC getRXERXRRXC() { 
	   RAS_O01_RXERXRRXC ret = null;
	   try {
	      ret = (RAS_O01_RXERXRRXC)this.get("RXERXRRXC");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns  first repetition of RXA (RXA - pharmacy/treatment administration segment) - creates it if necessary
	 */
	public RXA getRXA() { 
	   RXA ret = null;
	   try {
	      ret = (RXA)this.get("RXA");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns a specific repetition of RXA
	 * (RXA - pharmacy/treatment administration segment) - creates it if necessary
	 * throws HL7Exception if the repetition requested is more than one 
	 *     greater than the number of existing repetitions.
	 */
	public RXA getRXA(int rep) throws HL7Exception { 
	   return (RXA)this.get("RXA", rep);
	}

	/** 
	 * Returns the number of existing repetitions of RXA 
	 */ 
	public int getRXAReps() { 
	    int reps = -1; 
	    try { 
	        reps = this.getAll("RXA").length; 
	    } catch (HL7Exception e) { 
	        String message = "Unexpected error accessing data - this is probably a bug in the source code generator."; 
	        HapiLogFactory.getHapiLog(this.getClass()).error(message, e); 
	        throw new RuntimeException(message);
	    } 
	    return reps; 
	} 

	/**
	 * Returns RXR (RXR - pharmacy/treatment route segment) - creates it if necessary
	 */
	public RXR getRXR() { 
	   RXR ret = null;
	   try {
	      ret = (RXR)this.get("RXR");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns  first repetition of RAS_O01_OBXNTE (a Group object) - creates it if necessary
	 */
	public RAS_O01_OBXNTE getOBXNTE() { 
	   RAS_O01_OBXNTE ret = null;
	   try {
	      ret = (RAS_O01_OBXNTE)this.get("OBXNTE");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns a specific repetition of RAS_O01_OBXNTE
	 * (a Group object) - creates it if necessary
	 * throws HL7Exception if the repetition requested is more than one 
	 *     greater than the number of existing repetitions.
	 */
	public RAS_O01_OBXNTE getOBXNTE(int rep) throws HL7Exception { 
	   return (RAS_O01_OBXNTE)this.get("OBXNTE", rep);
	}

	/** 
	 * Returns the number of existing repetitions of RAS_O01_OBXNTE 
	 */ 
	public int getOBXNTEReps() { 
	    int reps = -1; 
	    try { 
	        reps = this.getAll("OBXNTE").length; 
	    } catch (HL7Exception e) { 
	        String message = "Unexpected error accessing data - this is probably a bug in the source code generator."; 
	        HapiLogFactory.getHapiLog(this.getClass()).error(message, e); 
	        throw new RuntimeException(message);
	    } 
	    return reps; 
	} 

	/**
	 * Returns  first repetition of CTI (CTI - clinical trial identification segment) - creates it if necessary
	 */
	public CTI getCTI() { 
	   CTI ret = null;
	   try {
	      ret = (CTI)this.get("CTI");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns a specific repetition of CTI
	 * (CTI - clinical trial identification segment) - creates it if necessary
	 * throws HL7Exception if the repetition requested is more than one 
	 *     greater than the number of existing repetitions.
	 */
	public CTI getCTI(int rep) throws HL7Exception { 
	   return (CTI)this.get("CTI", rep);
	}

	/** 
	 * Returns the number of existing repetitions of CTI 
	 */ 
	public int getCTIReps() { 
	    int reps = -1; 
	    try { 
	        reps = this.getAll("CTI").length; 
	    } catch (HL7Exception e) { 
	        String message = "Unexpected error accessing data - this is probably a bug in the source code generator."; 
	        HapiLogFactory.getHapiLog(this.getClass()).error(message, e); 
	        throw new RuntimeException(message);
	    } 
	    return reps; 
	} 

}
