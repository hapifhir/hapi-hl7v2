package ca.uhn.hl7v2.model.v231.group;

import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.log.HapiLogFactory;
import ca.uhn.hl7v2.model.v231.segment.*;

import ca.uhn.hl7v2.model.*;
/**
 * <p>Represents the NMD_N02_NCKNTENSTNTENSCNTE Group.  A Group is an ordered collection of message 
 * segments that can repeat together or be optionally in/excluded together.
 * This Group contains the following elements: </p>
 * 0: NMD_N02_NCKNTE (a Group object) <b>optional </b><br>
 * 1: NMD_N02_NSTNTE (a Group object) <b>optional </b><br>
 * 2: NMD_N02_NSCNTE (a Group object) <b>optional </b><br>
 */
public class NMD_N02_NCKNTENSTNTENSCNTE extends AbstractGroup {

	/** 
	 * Creates a new NMD_N02_NCKNTENSTNTENSCNTE Group.
	 */
	public NMD_N02_NCKNTENSTNTENSCNTE(Group parent, ModelClassFactory factory) {
	   super(parent, factory);
	   try {
	      this.add(NMD_N02_NCKNTE.class, false, false);
	      this.add(NMD_N02_NSTNTE.class, false, false);
	      this.add(NMD_N02_NSCNTE.class, false, false);
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error creating NMD_N02_NCKNTENSTNTENSCNTE - this is probably a bug in the source code generator.", e);
	   }
	}

	/**
	 * Returns NMD_N02_NCKNTE (a Group object) - creates it if necessary
	 */
	public NMD_N02_NCKNTE getNCKNTE() { 
	   NMD_N02_NCKNTE ret = null;
	   try {
	      ret = (NMD_N02_NCKNTE)this.get("NCKNTE");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns NMD_N02_NSTNTE (a Group object) - creates it if necessary
	 */
	public NMD_N02_NSTNTE getNSTNTE() { 
	   NMD_N02_NSTNTE ret = null;
	   try {
	      ret = (NMD_N02_NSTNTE)this.get("NSTNTE");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns NMD_N02_NSCNTE (a Group object) - creates it if necessary
	 */
	public NMD_N02_NSCNTE getNSCNTE() { 
	   NMD_N02_NSCNTE ret = null;
	   try {
	      ret = (NMD_N02_NSCNTE)this.get("NSCNTE");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

}
