package ca.uhn.hl7v2.model.v231.group;

import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.log.HapiLogFactory;
import ca.uhn.hl7v2.model.v231.segment.*;

import ca.uhn.hl7v2.model.*;
/**
 * <p>Represents the RDS_O01_ORCRXONTERXRRXCNTERXERXRRXCRXDRXRRXCOBXNTE Group.  A Group is an ordered collection of message 
 * segments that can repeat together or be optionally in/excluded together.
 * This Group contains the following elements: </p>
 * 0: ORC (ORC - common order segment) <b></b><br>
 * 1: RDS_O01_RXONTERXRRXCNTE (a Group object) <b>optional </b><br>
 * 2: RDS_O01_RXERXRRXC (a Group object) <b>optional </b><br>
 * 3: RXD (RXD - pharmacy/treatment dispense segment) <b></b><br>
 * 4: RXR (RXR - pharmacy/treatment route segment) <b>repeating</b><br>
 * 5: RXC (RXC - pharmacy/treatment component order segment) <b>optional repeating</b><br>
 * 6: RDS_O01_OBXNTE (a Group object) <b>optional repeating</b><br>
 */
public class RDS_O01_ORCRXONTERXRRXCNTERXERXRRXCRXDRXRRXCOBXNTE extends AbstractGroup {

	/** 
	 * Creates a new RDS_O01_ORCRXONTERXRRXCNTERXERXRRXCRXDRXRRXCOBXNTE Group.
	 */
	public RDS_O01_ORCRXONTERXRRXCNTERXERXRRXCRXDRXRRXCOBXNTE(Group parent, ModelClassFactory factory) {
	   super(parent, factory);
	   try {
	      this.add(ORC.class, true, false);
	      this.add(RDS_O01_RXONTERXRRXCNTE.class, false, false);
	      this.add(RDS_O01_RXERXRRXC.class, false, false);
	      this.add(RXD.class, true, false);
	      this.add(RXR.class, true, true);
	      this.add(RXC.class, false, true);
	      this.add(RDS_O01_OBXNTE.class, false, true);
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error creating RDS_O01_ORCRXONTERXRRXCNTERXERXRRXCRXDRXRRXCOBXNTE - this is probably a bug in the source code generator.", e);
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
	 * Returns RDS_O01_RXONTERXRRXCNTE (a Group object) - creates it if necessary
	 */
	public RDS_O01_RXONTERXRRXCNTE getRXONTERXRRXCNTE() { 
	   RDS_O01_RXONTERXRRXCNTE ret = null;
	   try {
	      ret = (RDS_O01_RXONTERXRRXCNTE)this.get("RXONTERXRRXCNTE");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns RDS_O01_RXERXRRXC (a Group object) - creates it if necessary
	 */
	public RDS_O01_RXERXRRXC getRXERXRRXC() { 
	   RDS_O01_RXERXRRXC ret = null;
	   try {
	      ret = (RDS_O01_RXERXRRXC)this.get("RXERXRRXC");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns RXD (RXD - pharmacy/treatment dispense segment) - creates it if necessary
	 */
	public RXD getRXD() { 
	   RXD ret = null;
	   try {
	      ret = (RXD)this.get("RXD");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns  first repetition of RXR (RXR - pharmacy/treatment route segment) - creates it if necessary
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
	 * Returns a specific repetition of RXR
	 * (RXR - pharmacy/treatment route segment) - creates it if necessary
	 * throws HL7Exception if the repetition requested is more than one 
	 *     greater than the number of existing repetitions.
	 */
	public RXR getRXR(int rep) throws HL7Exception { 
	   return (RXR)this.get("RXR", rep);
	}

	/** 
	 * Returns the number of existing repetitions of RXR 
	 */ 
	public int getRXRReps() { 
	    int reps = -1; 
	    try { 
	        reps = this.getAll("RXR").length; 
	    } catch (HL7Exception e) { 
	        String message = "Unexpected error accessing data - this is probably a bug in the source code generator."; 
	        HapiLogFactory.getHapiLog(this.getClass()).error(message, e); 
	        throw new RuntimeException(message);
	    } 
	    return reps; 
	} 

	/**
	 * Returns  first repetition of RXC (RXC - pharmacy/treatment component order segment) - creates it if necessary
	 */
	public RXC getRXC() { 
	   RXC ret = null;
	   try {
	      ret = (RXC)this.get("RXC");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns a specific repetition of RXC
	 * (RXC - pharmacy/treatment component order segment) - creates it if necessary
	 * throws HL7Exception if the repetition requested is more than one 
	 *     greater than the number of existing repetitions.
	 */
	public RXC getRXC(int rep) throws HL7Exception { 
	   return (RXC)this.get("RXC", rep);
	}

	/** 
	 * Returns the number of existing repetitions of RXC 
	 */ 
	public int getRXCReps() { 
	    int reps = -1; 
	    try { 
	        reps = this.getAll("RXC").length; 
	    } catch (HL7Exception e) { 
	        String message = "Unexpected error accessing data - this is probably a bug in the source code generator."; 
	        HapiLogFactory.getHapiLog(this.getClass()).error(message, e); 
	        throw new RuntimeException(message);
	    } 
	    return reps; 
	} 

	/**
	 * Returns  first repetition of RDS_O01_OBXNTE (a Group object) - creates it if necessary
	 */
	public RDS_O01_OBXNTE getOBXNTE() { 
	   RDS_O01_OBXNTE ret = null;
	   try {
	      ret = (RDS_O01_OBXNTE)this.get("OBXNTE");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns a specific repetition of RDS_O01_OBXNTE
	 * (a Group object) - creates it if necessary
	 * throws HL7Exception if the repetition requested is more than one 
	 *     greater than the number of existing repetitions.
	 */
	public RDS_O01_OBXNTE getOBXNTE(int rep) throws HL7Exception { 
	   return (RDS_O01_OBXNTE)this.get("OBXNTE", rep);
	}

	/** 
	 * Returns the number of existing repetitions of RDS_O01_OBXNTE 
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

}
