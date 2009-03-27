package ca.uhn.hl7v2.model.v231.group;

import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.log.HapiLogFactory;
import ca.uhn.hl7v2.model.v231.segment.*;

import ca.uhn.hl7v2.model.*;
/**
 * <p>Represents the OMD_O01_ORCODSNTEOBXNTE Group.  A Group is an ordered collection of message 
 * segments that can repeat together or be optionally in/excluded together.
 * This Group contains the following elements: </p>
 * 0: ORC (ORC - common order segment) <b></b><br>
 * 1: OMD_O01_ODSNTEOBXNTE (a Group object) <b>optional </b><br>
 */
public class OMD_O01_ORCODSNTEOBXNTE extends AbstractGroup {

	/** 
	 * Creates a new OMD_O01_ORCODSNTEOBXNTE Group.
	 */
	public OMD_O01_ORCODSNTEOBXNTE(Group parent, ModelClassFactory factory) {
	   super(parent, factory);
	   try {
	      this.add(ORC.class, true, false);
	      this.add(OMD_O01_ODSNTEOBXNTE.class, false, false);
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error creating OMD_O01_ORCODSNTEOBXNTE - this is probably a bug in the source code generator.", e);
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
	 * Returns OMD_O01_ODSNTEOBXNTE (a Group object) - creates it if necessary
	 */
	public OMD_O01_ODSNTEOBXNTE getODSNTEOBXNTE() { 
	   OMD_O01_ODSNTEOBXNTE ret = null;
	   try {
	      ret = (OMD_O01_ODSNTEOBXNTE)this.get("ODSNTEOBXNTE");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

}
