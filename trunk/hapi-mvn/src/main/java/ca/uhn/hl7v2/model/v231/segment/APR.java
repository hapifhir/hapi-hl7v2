package ca.uhn.hl7v2.model.v231.segment;

import ca.uhn.hl7v2.model.*;
import ca.uhn.hl7v2.model.v231.datatype.*;

import ca.uhn.log.HapiLogFactory;
import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.HL7Exception;

/**
 * <p>Represents an HL7 APR message segment. 
 * This segment has the following fields:</p><p>
 * APR-1: Time Selection Criteria (SCV)<br> 
 * APR-2: Resource Selection Criteria (SCV)<br> 
 * APR-3: Location Selection Criteria (SCV)<br> 
 * APR-4: Slot Spacing Criteria (NM)<br> 
 * APR-5: Filler Override Criteria (SCV)<br> 
 * </p><p>The get...() methods return data from individual fields.  These methods 
 * do not throw exceptions and may therefore have to handle exceptions internally.  
 * If an exception is handled internally, it is logged and null is returned.  
 * This is not expected to happen - if it does happen this indicates not so much 
 * an exceptional circumstance as a bug in the code for this class.</p>    
 */
public class APR extends AbstractSegment  {

  /**
   * Creates a APR (APR - appointment preferences segment) segment object that belongs to the given 
   * message.  
   */
  public APR(Group parent, ModelClassFactory factory) {
    super(parent, factory);
    Message message = getMessage();
    try {
       this.add(SCV.class, false, 0, 80, new Object[]{message});
       this.add(SCV.class, false, 0, 80, new Object[]{message});
       this.add(SCV.class, false, 0, 80, new Object[]{message});
       this.add(NM.class, false, 1, 5, new Object[]{message});
       this.add(SCV.class, false, 0, 80, new Object[]{message});
    } catch (HL7Exception he) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Can't instantiate " + this.getClass().getName(), he);
    }
  }

  /**
   * Returns a single repetition of Time Selection Criteria (APR-1).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public SCV getTimeSelectionCriteria(int rep) throws HL7Exception {
    SCV ret = null;
    try {
        Type t = this.getField(1, rep);
        ret = (SCV)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    }
    return ret;
  }

  /**
   * Returns all repetitions of Time Selection Criteria (APR-1).
   */
  public SCV[] getTimeSelectionCriteria() {
     SCV[] ret = null;
    try {
        Type[] t = this.getField(1);  
        ret = new SCV[t.length];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = (SCV)t[i];
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
   * Returns a single repetition of Resource Selection Criteria (APR-2).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public SCV getResourceSelectionCriteria(int rep) throws HL7Exception {
    SCV ret = null;
    try {
        Type t = this.getField(2, rep);
        ret = (SCV)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    }
    return ret;
  }

  /**
   * Returns all repetitions of Resource Selection Criteria (APR-2).
   */
  public SCV[] getResourceSelectionCriteria() {
     SCV[] ret = null;
    try {
        Type[] t = this.getField(2);  
        ret = new SCV[t.length];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = (SCV)t[i];
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
   * Returns a single repetition of Location Selection Criteria (APR-3).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public SCV getLocationSelectionCriteria(int rep) throws HL7Exception {
    SCV ret = null;
    try {
        Type t = this.getField(3, rep);
        ret = (SCV)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    }
    return ret;
  }

  /**
   * Returns all repetitions of Location Selection Criteria (APR-3).
   */
  public SCV[] getLocationSelectionCriteria() {
     SCV[] ret = null;
    try {
        Type[] t = this.getField(3);  
        ret = new SCV[t.length];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = (SCV)t[i];
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
   * Returns Slot Spacing Criteria (APR-4).
   */
  public NM getSlotSpacingCriteria()  {
    NM ret = null;
    try {
        Type t = this.getField(4, 0);
        ret = (NM)t;
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
   * Returns a single repetition of Filler Override Criteria (APR-5).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public SCV getFillerOverrideCriteria(int rep) throws HL7Exception {
    SCV ret = null;
    try {
        Type t = this.getField(5, rep);
        ret = (SCV)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    }
    return ret;
  }

  /**
   * Returns all repetitions of Filler Override Criteria (APR-5).
   */
  public SCV[] getFillerOverrideCriteria() {
     SCV[] ret = null;
    try {
        Type[] t = this.getField(5);  
        ret = new SCV[t.length];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = (SCV)t[i];
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

}