package ca.uhn.hl7v2.model.v21.segment;

import ca.uhn.hl7v2.model.*;
import ca.uhn.hl7v2.model.v21.datatype.*;

import ca.uhn.log.HapiLogFactory;
import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.HL7Exception;

/**
 * <p>Represents an HL7 BLG message segment. 
 * This segment has the following fields:</p><p>
 * BLG-1: WHEN TO CHARGE (CM)<br> 
 * BLG-2: CHARGE TYPE (ID)<br> 
 * BLG-3: ACCOUNT ID (CM)<br> 
 * </p><p>The get...() methods return data from individual fields.  These methods 
 * do not throw exceptions and may therefore have to handle exceptions internally.  
 * If an exception is handled internally, it is logged and null is returned.  
 * This is not expected to happen - if it does happen this indicates not so much 
 * an exceptional circumstance as a bug in the code for this class.</p>    
 */
public class BLG extends AbstractSegment  {

  /**
   * Creates a BLG (BILLING) segment object that belongs to the given 
   * message.  
   */
  public BLG(Group parent, ModelClassFactory factory) {
    super(parent, factory);
    Message message = getMessage();
    try {
       this.add(CM.class, false, 1, 15, new Object[]{message});
       this.add(ID.class, false, 1, 50, new Object[]{message, new Integer(122)});
       this.add(CM.class, false, 1, 100, new Object[]{message});
    } catch (HL7Exception he) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Can't instantiate " + this.getClass().getName(), he);
    }
  }

  /**
   * Returns WHEN TO CHARGE (BLG-1).
   */
  public CM getWHENTOCHARGE()  {
    CM ret = null;
    try {
        Type t = this.getField(1, 0);
        ret = (CM)t;
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
   * Returns CHARGE TYPE (BLG-2).
   */
  public ID getCHARGETYPE()  {
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

  /**
   * Returns ACCOUNT ID (BLG-3).
   */
  public CM getACCOUNTID()  {
    CM ret = null;
    try {
        Type t = this.getField(3, 0);
        ret = (CM)t;
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