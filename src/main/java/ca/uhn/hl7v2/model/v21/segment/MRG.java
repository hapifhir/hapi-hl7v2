package ca.uhn.hl7v2.model.v21.segment;

import ca.uhn.hl7v2.model.*;
import ca.uhn.hl7v2.model.v21.datatype.*;

import ca.uhn.log.HapiLogFactory;
import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.HL7Exception;

/**
 * <p>Represents an HL7 MRG message segment. 
 * This segment has the following fields:</p><p>
 * MRG-1: PRIOR PATIENT ID - INTERNAL (CK)<br> 
 * MRG-2: PRIOR ALTERNATE PATIENT ID (CK)<br> 
 * MRG-3: PRIOR PATIENT ACCOUNT NUMBER (CK)<br> 
 * </p><p>The get...() methods return data from individual fields.  These methods 
 * do not throw exceptions and may therefore have to handle exceptions internally.  
 * If an exception is handled internally, it is logged and null is returned.  
 * This is not expected to happen - if it does happen this indicates not so much 
 * an exceptional circumstance as a bug in the code for this class.</p>    
 */
public class MRG extends AbstractSegment  {

  /**
   * Creates a MRG (MERGE PATIENT INFORMATION) segment object that belongs to the given 
   * message.  
   */
  public MRG(Group parent, ModelClassFactory factory) {
    super(parent, factory);
    Message message = getMessage();
    try {
       this.add(CK.class, true, 1, 16, new Object[]{message});
       this.add(CK.class, false, 1, 16, new Object[]{message});
       this.add(CK.class, false, 1, 20, new Object[]{message});
    } catch (HL7Exception he) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Can't instantiate " + this.getClass().getName(), he);
    }
  }

  /**
   * Returns PRIOR PATIENT ID - INTERNAL (MRG-1).
   */
  public CK getPRIORPATIENTIDINTERNAL()  {
    CK ret = null;
    try {
        Type t = this.getField(1, 0);
        ret = (CK)t;
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
   * Returns PRIOR ALTERNATE PATIENT ID (MRG-2).
   */
  public CK getPRIORALTERNATEPATIENTID()  {
    CK ret = null;
    try {
        Type t = this.getField(2, 0);
        ret = (CK)t;
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
   * Returns PRIOR PATIENT ACCOUNT NUMBER (MRG-3).
   */
  public CK getPRIORPATIENTACCOUNTNUMBER()  {
    CK ret = null;
    try {
        Type t = this.getField(3, 0);
        ret = (CK)t;
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