package ca.uhn.hl7v2.model.v24.group;

import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.log.HapiLogFactory;
import ca.uhn.hl7v2.model.v24.segment.*;

import ca.uhn.hl7v2.model.*;
/**
 * <p>Represents the SRM_S01_RESOURCES Group.  A Group is an ordered collection of message 
 * segments that can repeat together or be optionally in/excluded together.
 * This Group contains the following elements: </p>
 * 0: RGS (Resource Group) <b></b><br>
 * 1: SRM_S01_SERVICE (a Group object) <b>optional repeating</b><br>
 * 2: SRM_S01_GENERAL_RESOURCE (a Group object) <b>optional repeating</b><br>
 * 3: SRM_S01_LOCATION_RESOURCE (a Group object) <b>optional repeating</b><br>
 * 4: SRM_S01_PERSONNEL_RESOURCE (a Group object) <b>optional repeating</b><br>
 */
public class SRM_S01_RESOURCES extends AbstractGroup {

	/** 
	 * Creates a new SRM_S01_RESOURCES Group.
	 */
	public SRM_S01_RESOURCES(Group parent, ModelClassFactory factory) {
	   super(parent, factory);
	   try {
	      this.add(RGS.class, true, false);
	      this.add(SRM_S01_SERVICE.class, false, true);
	      this.add(SRM_S01_GENERAL_RESOURCE.class, false, true);
	      this.add(SRM_S01_LOCATION_RESOURCE.class, false, true);
	      this.add(SRM_S01_PERSONNEL_RESOURCE.class, false, true);
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error creating SRM_S01_RESOURCES - this is probably a bug in the source code generator.", e);
	   }
	}

	/**
	 * Returns RGS (Resource Group) - creates it if necessary
	 */
	public RGS getRGS() { 
	   RGS ret = null;
	   try {
	      ret = (RGS)this.get("RGS");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns  first repetition of SRM_S01_SERVICE (a Group object) - creates it if necessary
	 */
	public SRM_S01_SERVICE getSERVICE() { 
	   SRM_S01_SERVICE ret = null;
	   try {
	      ret = (SRM_S01_SERVICE)this.get("SERVICE");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns a specific repetition of SRM_S01_SERVICE
	 * (a Group object) - creates it if necessary
	 * throws HL7Exception if the repetition requested is more than one 
	 *     greater than the number of existing repetitions.
	 */
	public SRM_S01_SERVICE getSERVICE(int rep) throws HL7Exception { 
	   return (SRM_S01_SERVICE)this.get("SERVICE", rep);
	}

	/** 
	 * Returns the number of existing repetitions of SRM_S01_SERVICE 
	 */ 
	public int getSERVICEReps() { 
	    int reps = -1; 
	    try { 
	        reps = this.getAll("SERVICE").length; 
	    } catch (HL7Exception e) { 
	        String message = "Unexpected error accessing data - this is probably a bug in the source code generator."; 
	        HapiLogFactory.getHapiLog(this.getClass()).error(message, e); 
	        throw new RuntimeException(message);
	    } 
	    return reps; 
	} 

	/**
	 * Returns  first repetition of SRM_S01_GENERAL_RESOURCE (a Group object) - creates it if necessary
	 */
	public SRM_S01_GENERAL_RESOURCE getGENERAL_RESOURCE() { 
	   SRM_S01_GENERAL_RESOURCE ret = null;
	   try {
	      ret = (SRM_S01_GENERAL_RESOURCE)this.get("GENERAL_RESOURCE");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns a specific repetition of SRM_S01_GENERAL_RESOURCE
	 * (a Group object) - creates it if necessary
	 * throws HL7Exception if the repetition requested is more than one 
	 *     greater than the number of existing repetitions.
	 */
	public SRM_S01_GENERAL_RESOURCE getGENERAL_RESOURCE(int rep) throws HL7Exception { 
	   return (SRM_S01_GENERAL_RESOURCE)this.get("GENERAL_RESOURCE", rep);
	}

	/** 
	 * Returns the number of existing repetitions of SRM_S01_GENERAL_RESOURCE 
	 */ 
	public int getGENERAL_RESOURCEReps() { 
	    int reps = -1; 
	    try { 
	        reps = this.getAll("GENERAL_RESOURCE").length; 
	    } catch (HL7Exception e) { 
	        String message = "Unexpected error accessing data - this is probably a bug in the source code generator."; 
	        HapiLogFactory.getHapiLog(this.getClass()).error(message, e); 
	        throw new RuntimeException(message);
	    } 
	    return reps; 
	} 

	/**
	 * Returns  first repetition of SRM_S01_LOCATION_RESOURCE (a Group object) - creates it if necessary
	 */
	public SRM_S01_LOCATION_RESOURCE getLOCATION_RESOURCE() { 
	   SRM_S01_LOCATION_RESOURCE ret = null;
	   try {
	      ret = (SRM_S01_LOCATION_RESOURCE)this.get("LOCATION_RESOURCE");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns a specific repetition of SRM_S01_LOCATION_RESOURCE
	 * (a Group object) - creates it if necessary
	 * throws HL7Exception if the repetition requested is more than one 
	 *     greater than the number of existing repetitions.
	 */
	public SRM_S01_LOCATION_RESOURCE getLOCATION_RESOURCE(int rep) throws HL7Exception { 
	   return (SRM_S01_LOCATION_RESOURCE)this.get("LOCATION_RESOURCE", rep);
	}

	/** 
	 * Returns the number of existing repetitions of SRM_S01_LOCATION_RESOURCE 
	 */ 
	public int getLOCATION_RESOURCEReps() { 
	    int reps = -1; 
	    try { 
	        reps = this.getAll("LOCATION_RESOURCE").length; 
	    } catch (HL7Exception e) { 
	        String message = "Unexpected error accessing data - this is probably a bug in the source code generator."; 
	        HapiLogFactory.getHapiLog(this.getClass()).error(message, e); 
	        throw new RuntimeException(message);
	    } 
	    return reps; 
	} 

	/**
	 * Returns  first repetition of SRM_S01_PERSONNEL_RESOURCE (a Group object) - creates it if necessary
	 */
	public SRM_S01_PERSONNEL_RESOURCE getPERSONNEL_RESOURCE() { 
	   SRM_S01_PERSONNEL_RESOURCE ret = null;
	   try {
	      ret = (SRM_S01_PERSONNEL_RESOURCE)this.get("PERSONNEL_RESOURCE");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns a specific repetition of SRM_S01_PERSONNEL_RESOURCE
	 * (a Group object) - creates it if necessary
	 * throws HL7Exception if the repetition requested is more than one 
	 *     greater than the number of existing repetitions.
	 */
	public SRM_S01_PERSONNEL_RESOURCE getPERSONNEL_RESOURCE(int rep) throws HL7Exception { 
	   return (SRM_S01_PERSONNEL_RESOURCE)this.get("PERSONNEL_RESOURCE", rep);
	}

	/** 
	 * Returns the number of existing repetitions of SRM_S01_PERSONNEL_RESOURCE 
	 */ 
	public int getPERSONNEL_RESOURCEReps() { 
	    int reps = -1; 
	    try { 
	        reps = this.getAll("PERSONNEL_RESOURCE").length; 
	    } catch (HL7Exception e) { 
	        String message = "Unexpected error accessing data - this is probably a bug in the source code generator."; 
	        HapiLogFactory.getHapiLog(this.getClass()).error(message, e); 
	        throw new RuntimeException(message);
	    } 
	    return reps; 
	} 

}
