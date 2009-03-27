package ca.uhn.hl7v2.model.v22.segment;

import ca.uhn.hl7v2.model.*;
import ca.uhn.hl7v2.model.v22.datatype.*;

import ca.uhn.log.HapiLogFactory;
import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.HL7Exception;

/**
 * <p>Represents an HL7 NPU message segment. 
 * This segment has the following fields:</p><p>
 * NPU-1: Bed Location (CM_INTERNAL_LOCATION)<br> 
 * NPU-2: Bed Status (ID)<br> 
 * </p><p>The get...() methods return data from individual fields.  These methods 
 * do not throw exceptions and may therefore have to handle exceptions internally.  
 * If an exception is handled internally, it is logged and null is returned.  
 * This is not expected to happen - if it does happen this indicates not so much 
 * an exceptional circumstance as a bug in the code for this class.</p>    
 */
public class NPU extends AbstractSegment  {

  /**
   * Creates a NPU (BED STATUS UPDATE) segment object that belongs to the given 
   * message.  
   */
  public NPU(Group parent, ModelClassFactory factory) {
    super(parent, factory);
    Message message = getMessage();
    try {
       this.add(CM_INTERNAL_LOCATION.class, true, 1, 12, new Object[]{message});
       this.add(ID.class, false, 1, 1, new Object[]{message, new Integer(116)});
    } catch (HL7Exception he) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Can't instantiate " + this.getClass().getName(), he);
    }
  }

  /**
   * Returns Bed Location (NPU-1).
   */
  public CM_INTERNAL_LOCATION getBedLocation()  {
    CM_INTERNAL_LOCATION ret = null;
    try {
        Type t = this.getField(1, 0);
        ret = (CM_INTERNAL_LOCATION)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    } catch (HL7Exception he) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", he);
        throw new RuntimeException(he);
    }
    return ret;
  }

  /**
   * Returns Bed Status (NPU-2).
   */
  public ID getBedStatus()  {
    ID ret = null;
    try {
        Type t = this.getField(2, 0);
        ret = (ID)t;
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