package ca.uhn.hl7v2.model.v231.segment;

import ca.uhn.hl7v2.model.*;
import ca.uhn.hl7v2.model.v231.datatype.*;

import ca.uhn.log.HapiLogFactory;
import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.HL7Exception;

/**
 * <p>Represents an HL7 RDT message segment. 
 * This segment has the following fields:</p><p>
 * RDT-1: Column Value (varies)<br> 
 * </p><p>The get...() methods return data from individual fields.  These methods 
 * do not throw exceptions and may therefore have to handle exceptions internally.  
 * If an exception is handled internally, it is logged and null is returned.  
 * This is not expected to happen - if it does happen this indicates not so much 
 * an exceptional circumstance as a bug in the code for this class.</p>    
 */
public class RDT extends AbstractSegment  {

  /**
   * Creates a RDT (RDT - table row data segment) segment object that belongs to the given 
   * message.  
   */
  public RDT(Group parent, ModelClassFactory factory) {
    super(parent, factory);
    Message message = getMessage();
    try {
       this.add(Varies.class, false, 1, 0, new Object[]{message});
    } catch (HL7Exception he) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Can't instantiate " + this.getClass().getName(), he);
    }
  }

  /**
   * Returns Column Value (RDT-1).
   */
  public Varies getColumnValue()  {
    Varies ret = null;
    try {
        Type t = this.getField(1, 0);
        ret = (Varies)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    } catch (HL7Exception he) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", he);
        throw new RuntimeException(he);
    }
    return ret;
  }

}