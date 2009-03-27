package ca.uhn.hl7v2.model.v24.group;

import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.log.HapiLogFactory;
import ca.uhn.hl7v2.model.v24.segment.*;

import ca.uhn.hl7v2.model.*;
/**
 * <p>Represents the NMD_N02_CLOCK_AND_STATS_WITH_NOTES Group.  A Group is an ordered collection of message 
 * segments that can repeat together or be optionally in/excluded together.
 * This Group contains the following elements: </p>
 * 0: NMD_N02_CLOCK (a Group object) <b>optional </b><br>
 * 1: NMD_N02_APP_STATS (a Group object) <b>optional </b><br>
 * 2: NMD_N02_APP_STATUS (a Group object) <b>optional </b><br>
 */
public class NMD_N02_CLOCK_AND_STATS_WITH_NOTES extends AbstractGroup {

	/** 
	 * Creates a new NMD_N02_CLOCK_AND_STATS_WITH_NOTES Group.
	 */
	public NMD_N02_CLOCK_AND_STATS_WITH_NOTES(Group parent, ModelClassFactory factory) {
	   super(parent, factory);
	   try {
	      this.add(NMD_N02_CLOCK.class, false, false);
	      this.add(NMD_N02_APP_STATS.class, false, false);
	      this.add(NMD_N02_APP_STATUS.class, false, false);
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error creating NMD_N02_CLOCK_AND_STATS_WITH_NOTES - this is probably a bug in the source code generator.", e);
	   }
	}

	/**
	 * Returns NMD_N02_CLOCK (a Group object) - creates it if necessary
	 */
	public NMD_N02_CLOCK getCLOCK() { 
	   NMD_N02_CLOCK ret = null;
	   try {
	      ret = (NMD_N02_CLOCK)this.get("CLOCK");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns NMD_N02_APP_STATS (a Group object) - creates it if necessary
	 */
	public NMD_N02_APP_STATS getAPP_STATS() { 
	   NMD_N02_APP_STATS ret = null;
	   try {
	      ret = (NMD_N02_APP_STATS)this.get("APP_STATS");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

	/**
	 * Returns NMD_N02_APP_STATUS (a Group object) - creates it if necessary
	 */
	public NMD_N02_APP_STATUS getAPP_STATUS() { 
	   NMD_N02_APP_STATUS ret = null;
	   try {
	      ret = (NMD_N02_APP_STATUS)this.get("APP_STATUS");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

}
