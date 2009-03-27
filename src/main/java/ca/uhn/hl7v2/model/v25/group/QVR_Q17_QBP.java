package ca.uhn.hl7v2.model.v25.group;

import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.log.HapiLogFactory;
import ca.uhn.hl7v2.model.v25.segment.*;

import ca.uhn.hl7v2.model.*;
/**
 * <p>Represents the QVR_Q17_QBP Group.  A Group is an ordered collection of message 
 * segments that can repeat together or be optionally in/excluded together.
 * This Group contains the following elements: </p>
 * 0: Hxx (any HL7 segment) <b>optional </b><br>
 */
public class QVR_Q17_QBP extends AbstractGroup {

	/** 
	 * Creates a new QVR_Q17_QBP Group.
	 */
	public QVR_Q17_QBP(Group parent, ModelClassFactory factory) {
	   super(parent, factory);
	   try {
	      this.add(Hxx.class, false, false);
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error creating QVR_Q17_QBP - this is probably a bug in the source code generator.", e);
	   }
	}

	/**
	 * Returns Hxx (any HL7 segment) - creates it if necessary
	 */
	public Hxx getHxx() { 
	   Hxx ret = null;
	   try {
	      ret = (Hxx)this.get("Hxx");
	   } catch(HL7Exception e) {
	      HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected error accessing data - this is probably a bug in the source code generator.", e);
	      throw new RuntimeException(e);
	   }
	   return ret;
	}

}
