package ca.uhn.hl7v2.model.v25.segment;

import ca.uhn.hl7v2.model.*;
import ca.uhn.hl7v2.model.v25.datatype.*;

import ca.uhn.log.HapiLogFactory;
import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.HL7Exception;

/**
 * <p>Represents an HL7 OM7 message segment. 
 * This segment has the following fields:</p><p>
 * OM7-1: Sequence Number - Test/Observation Master File (NM)<br> 
 * OM7-2: Universal Service Identifier (CE)<br> 
 * OM7-3: Category Identifier (CE)<br> 
 * OM7-4: Category Description (TX)<br> 
 * OM7-5: Category Synonym (ST)<br> 
 * OM7-6: Effective Test/Service Start Date/Time (TS)<br> 
 * OM7-7: Effective Test/Service End Date/Time (TS)<br> 
 * OM7-8: Test/Service Default Duration Quantity (NM)<br> 
 * OM7-9: Test/Service Default Duration Units (CE)<br> 
 * OM7-10: Test/Service Default Frequency (IS)<br> 
 * OM7-11: Consent Indicator (ID)<br> 
 * OM7-12: Consent Identifier (CE)<br> 
 * OM7-13: Consent Effective Start Date/Time (TS)<br> 
 * OM7-14: Consent Effective End Date/Time (TS)<br> 
 * OM7-15: Consent Interval Quantity (NM)<br> 
 * OM7-16: Consent Interval Units (CE)<br> 
 * OM7-17: Consent Waiting Period Quantity (NM)<br> 
 * OM7-18: Consent Waiting Period Units (CE)<br> 
 * OM7-19: Effective Date/Time of Change (TS)<br> 
 * OM7-20: Entered By (XCN)<br> 
 * OM7-21: Orderable-at Location (PL)<br> 
 * OM7-22: Formulary Status (IS)<br> 
 * OM7-23: Special Order Indicator (ID)<br> 
 * OM7-24: Primary Key Value - CDM (CE)<br> 
 * </p><p>The get...() methods return data from individual fields.  These methods 
 * do not throw exceptions and may therefore have to handle exceptions internally.  
 * If an exception is handled internally, it is logged and null is returned.  
 * This is not expected to happen - if it does happen this indicates not so much 
 * an exceptional circumstance as a bug in the code for this class.</p>    
 */
public class OM7 extends AbstractSegment  {

  /**
   * Creates a OM7 (Additional Basic Attributes) segment object that belongs to the given 
   * message.  
   */
  public OM7(Group parent, ModelClassFactory factory) {
    super(parent, factory);
    Message message = getMessage();
    try {
       this.add(NM.class, true, 1, 4, new Object[]{message});
       this.add(CE.class, true, 1, 250, new Object[]{message});
       this.add(CE.class, false, 0, 250, new Object[]{message});
       this.add(TX.class, false, 1, 200, new Object[]{message});
       this.add(ST.class, false, 0, 200, new Object[]{message});
       this.add(TS.class, false, 1, 26, new Object[]{message});
       this.add(TS.class, false, 1, 26, new Object[]{message});
       this.add(NM.class, false, 1, 5, new Object[]{message});
       this.add(CE.class, false, 1, 250, new Object[]{message});
       this.add(IS.class, false, 1, 60, new Object[]{message, new Integer(335)});
       this.add(ID.class, false, 1, 1, new Object[]{message, new Integer(136)});
       this.add(CE.class, false, 1, 250, new Object[]{message});
       this.add(TS.class, false, 1, 26, new Object[]{message});
       this.add(TS.class, false, 1, 26, new Object[]{message});
       this.add(NM.class, false, 1, 5, new Object[]{message});
       this.add(CE.class, false, 1, 250, new Object[]{message});
       this.add(NM.class, false, 1, 5, new Object[]{message});
       this.add(CE.class, false, 1, 250, new Object[]{message});
       this.add(TS.class, false, 1, 26, new Object[]{message});
       this.add(XCN.class, false, 1, 250, new Object[]{message});
       this.add(PL.class, false, 0, 200, new Object[]{message});
       this.add(IS.class, false, 1, 1, new Object[]{message, new Integer(473)});
       this.add(ID.class, false, 1, 1, new Object[]{message, new Integer(136)});
       this.add(CE.class, false, 0, 250, new Object[]{message});
    } catch (HL7Exception he) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Can't instantiate " + this.getClass().getName(), he);
    }
  }

  /**
   * Returns Sequence Number - Test/Observation Master File (OM7-1).
   */
  public NM getSequenceNumberTestObservationMasterFile()  {
    NM ret = null;
    try {
        Type t = this.getField(1, 0);
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
   * Returns Universal Service Identifier (OM7-2).
   */
  public CE getUniversalServiceIdentifier()  {
    CE ret = null;
    try {
        Type t = this.getField(2, 0);
        ret = (CE)t;
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
   * Returns a single repetition of Category Identifier (OM7-3).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public CE getCategoryIdentifier(int rep) throws HL7Exception {
    CE ret = null;
    try {
        Type t = this.getField(3, rep);
        ret = (CE)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    }
    return ret;
  }

  /**
   * Returns all repetitions of Category Identifier (OM7-3).
   */
  public CE[] getCategoryIdentifier() {
     CE[] ret = null;
    try {
        Type[] t = this.getField(3);  
        ret = new CE[t.length];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = (CE)t[i];
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
   * Returns Category Description (OM7-4).
   */
  public TX getCategoryDescription()  {
    TX ret = null;
    try {
        Type t = this.getField(4, 0);
        ret = (TX)t;
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
   * Returns a single repetition of Category Synonym (OM7-5).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public ST getCategorySynonym(int rep) throws HL7Exception {
    ST ret = null;
    try {
        Type t = this.getField(5, rep);
        ret = (ST)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    }
    return ret;
  }

  /**
   * Returns all repetitions of Category Synonym (OM7-5).
   */
  public ST[] getCategorySynonym() {
     ST[] ret = null;
    try {
        Type[] t = this.getField(5);  
        ret = new ST[t.length];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = (ST)t[i];
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
   * Returns Effective Test/Service Start Date/Time (OM7-6).
   */
  public TS getEffectiveTestServiceStartDateTime()  {
    TS ret = null;
    try {
        Type t = this.getField(6, 0);
        ret = (TS)t;
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
   * Returns Effective Test/Service End Date/Time (OM7-7).
   */
  public TS getEffectiveTestServiceEndDateTime()  {
    TS ret = null;
    try {
        Type t = this.getField(7, 0);
        ret = (TS)t;
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
   * Returns Test/Service Default Duration Quantity (OM7-8).
   */
  public NM getTestServiceDefaultDurationQuantity()  {
    NM ret = null;
    try {
        Type t = this.getField(8, 0);
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
   * Returns Test/Service Default Duration Units (OM7-9).
   */
  public CE getTestServiceDefaultDurationUnits()  {
    CE ret = null;
    try {
        Type t = this.getField(9, 0);
        ret = (CE)t;
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
   * Returns Test/Service Default Frequency (OM7-10).
   */
  public IS getTestServiceDefaultFrequency()  {
    IS ret = null;
    try {
        Type t = this.getField(10, 0);
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
   * Returns Consent Indicator (OM7-11).
   */
  public ID getConsentIndicator()  {
    ID ret = null;
    try {
        Type t = this.getField(11, 0);
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
   * Returns Consent Identifier (OM7-12).
   */
  public CE getConsentIdentifier()  {
    CE ret = null;
    try {
        Type t = this.getField(12, 0);
        ret = (CE)t;
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
   * Returns Consent Effective Start Date/Time (OM7-13).
   */
  public TS getConsentEffectiveStartDateTime()  {
    TS ret = null;
    try {
        Type t = this.getField(13, 0);
        ret = (TS)t;
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
   * Returns Consent Effective End Date/Time (OM7-14).
   */
  public TS getConsentEffectiveEndDateTime()  {
    TS ret = null;
    try {
        Type t = this.getField(14, 0);
        ret = (TS)t;
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
   * Returns Consent Interval Quantity (OM7-15).
   */
  public NM getConsentIntervalQuantity()  {
    NM ret = null;
    try {
        Type t = this.getField(15, 0);
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
   * Returns Consent Interval Units (OM7-16).
   */
  public CE getConsentIntervalUnits()  {
    CE ret = null;
    try {
        Type t = this.getField(16, 0);
        ret = (CE)t;
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
   * Returns Consent Waiting Period Quantity (OM7-17).
   */
  public NM getConsentWaitingPeriodQuantity()  {
    NM ret = null;
    try {
        Type t = this.getField(17, 0);
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
   * Returns Consent Waiting Period Units (OM7-18).
   */
  public CE getConsentWaitingPeriodUnits()  {
    CE ret = null;
    try {
        Type t = this.getField(18, 0);
        ret = (CE)t;
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
   * Returns Effective Date/Time of Change (OM7-19).
   */
  public TS getEffectiveDateTimeOfChange()  {
    TS ret = null;
    try {
        Type t = this.getField(19, 0);
        ret = (TS)t;
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
   * Returns Entered By (OM7-20).
   */
  public XCN getEnteredBy()  {
    XCN ret = null;
    try {
        Type t = this.getField(20, 0);
        ret = (XCN)t;
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
   * Returns a single repetition of Orderable-at Location (OM7-21).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public PL getOrderableAtLocation(int rep) throws HL7Exception {
    PL ret = null;
    try {
        Type t = this.getField(21, rep);
        ret = (PL)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    }
    return ret;
  }

  /**
   * Returns all repetitions of Orderable-at Location (OM7-21).
   */
  public PL[] getOrderableAtLocation() {
     PL[] ret = null;
    try {
        Type[] t = this.getField(21);  
        ret = new PL[t.length];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = (PL)t[i];
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
   * Returns Formulary Status (OM7-22).
   */
  public IS getFormularyStatus()  {
    IS ret = null;
    try {
        Type t = this.getField(22, 0);
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
   * Returns Special Order Indicator (OM7-23).
   */
  public ID getSpecialOrderIndicator()  {
    ID ret = null;
    try {
        Type t = this.getField(23, 0);
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
   * Returns a single repetition of Primary Key Value - CDM (OM7-24).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public CE getPrimaryKeyValueCDM(int rep) throws HL7Exception {
    CE ret = null;
    try {
        Type t = this.getField(24, rep);
        ret = (CE)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    }
    return ret;
  }

  /**
   * Returns all repetitions of Primary Key Value - CDM (OM7-24).
   */
  public CE[] getPrimaryKeyValueCDM() {
     CE[] ret = null;
    try {
        Type[] t = this.getField(24);  
        ret = new CE[t.length];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = (CE)t[i];
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