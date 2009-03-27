package ca.uhn.hl7v2.model.v25.segment;

import ca.uhn.hl7v2.model.*;
import ca.uhn.hl7v2.model.v25.datatype.*;

import ca.uhn.log.HapiLogFactory;
import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.HL7Exception;

/**
 * <p>Represents an HL7 GP1 message segment. 
 * This segment has the following fields:</p><p>
 * GP1-1: Type of Bill Code (IS)<br> 
 * GP1-2: Revenue Code (IS)<br> 
 * GP1-3: Overall Claim Disposition Code (IS)<br> 
 * GP1-4: OCE Edits per Visit Code (IS)<br> 
 * GP1-5: Outlier Cost (CP)<br> 
 * </p><p>The get...() methods return data from individual fields.  These methods 
 * do not throw exceptions and may therefore have to handle exceptions internally.  
 * If an exception is handled internally, it is logged and null is returned.  
 * This is not expected to happen - if it does happen this indicates not so much 
 * an exceptional circumstance as a bug in the code for this class.</p>    
 */
public class GP1 extends AbstractSegment  {

  /**
   * Creates a GP1 (Grouping/Reimbursement - Visit) segment object that belongs to the given 
   * message.  
   */
  public GP1(Group parent, ModelClassFactory factory) {
    super(parent, factory);
    Message message = getMessage();
    try {
       this.add(IS.class, true, 1, 3, new Object[]{message, new Integer(455)});
       this.add(IS.class, false, 0, 3, new Object[]{message, new Integer(456)});
       this.add(IS.class, false, 1, 1, new Object[]{message, new Integer(457)});
       this.add(IS.class, false, 0, 2, new Object[]{message, new Integer(458)});
       this.add(CP.class, false, 1, 12, new Object[]{message});
    } catch (HL7Exception he) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Can't instantiate " + this.getClass().getName(), he);
    }
  }

  /**
   * Returns Type of Bill Code (GP1-1).
   */
  public IS getTypeOfBillCode()  {
    IS ret = null;
    try {
        Type t = this.getField(1, 0);
        ret = (IS)t;
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
   * Returns a single repetition of Revenue Code (GP1-2).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public IS getRevenueCode(int rep) throws HL7Exception {
    IS ret = null;
    try {
        Type t = this.getField(2, rep);
        ret = (IS)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    }
    return ret;
  }

  /**
   * Returns all repetitions of Revenue Code (GP1-2).
   */
  public IS[] getRevenueCode() {
     IS[] ret = null;
    try {
        Type[] t = this.getField(2);  
        ret = new IS[t.length];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = (IS)t[i];
        }
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
   * Returns Overall Claim Disposition Code (GP1-3).
   */
  public IS getOverallClaimDispositionCode()  {
    IS ret = null;
    try {
        Type t = this.getField(3, 0);
        ret = (IS)t;
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
   * Returns a single repetition of OCE Edits per Visit Code (GP1-4).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public IS getOCEEditsPerVisitCode(int rep) throws HL7Exception {
    IS ret = null;
    try {
        Type t = this.getField(4, rep);
        ret = (IS)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    }
    return ret;
  }

  /**
   * Returns all repetitions of OCE Edits per Visit Code (GP1-4).
   */
  public IS[] getOCEEditsPerVisitCode() {
     IS[] ret = null;
    try {
        Type[] t = this.getField(4);  
        ret = new IS[t.length];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = (IS)t[i];
        }
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
   * Returns Outlier Cost (GP1-5).
   */
  public CP getOutlierCost()  {
    CP ret = null;
    try {
        Type t = this.getField(5, 0);
        ret = (CP)t;
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