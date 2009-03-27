package ca.uhn.hl7v2.model.v22.segment;

import ca.uhn.hl7v2.model.*;
import ca.uhn.hl7v2.model.v22.datatype.*;

import ca.uhn.log.HapiLogFactory;
import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.HL7Exception;

/**
 * <p>Represents an HL7 UB2 message segment. 
 * This segment has the following fields:</p><p>
 * UB2-1: Set ID - UB92 (SI)<br> 
 * UB2-2: Co-insurance days (9) (ST)<br> 
 * UB2-3: Condition code (24-30) (ID)<br> 
 * UB2-4: Covered days (7) (ST)<br> 
 * UB2-5: Non-covered days (8) (ST)<br> 
 * UB2-6: Value amount and code (39-41) (CM_UVC)<br> 
 * UB2-7: Occurrence code and date (32-35) (CM_OCD)<br> 
 * UB2-8: Occurrence span code / dates (36) (CM_OSP)<br> 
 * UB2-9: UB92 locator 2 (state) (ST)<br> 
 * UB2-10: UB92 locator 11 (state) (ST)<br> 
 * UB2-11: UB92 locator 31 (national) (ST)<br> 
 * UB2-12: Document control number (37) (ST)<br> 
 * UB2-13: UB92 locator 49 (national) (ST)<br> 
 * UB2-14: UB92 locator 56 (state) (ST)<br> 
 * UB2-15: UB92 locator 57 (national) (ST)<br> 
 * UB2-16: UB92 Locator 78 (state) (ST)<br> 
 * </p><p>The get...() methods return data from individual fields.  These methods 
 * do not throw exceptions and may therefore have to handle exceptions internally.  
 * If an exception is handled internally, it is logged and null is returned.  
 * This is not expected to happen - if it does happen this indicates not so much 
 * an exceptional circumstance as a bug in the code for this class.</p>    
 */
public class UB2 extends AbstractSegment  {

  /**
   * Creates a UB2 (UB92 DATA) segment object that belongs to the given 
   * message.  
   */
  public UB2(Group parent, ModelClassFactory factory) {
    super(parent, factory);
    Message message = getMessage();
    try {
       this.add(SI.class, false, 1, 4, new Object[]{message});
       this.add(ST.class, false, 1, 3, new Object[]{message});
       this.add(ID.class, false, 7, 2, new Object[]{message, new Integer(43)});
       this.add(ST.class, false, 1, 3, new Object[]{message});
       this.add(ST.class, false, 1, 4, new Object[]{message});
       this.add(CM_UVC.class, false, 12, 11, new Object[]{message});
       this.add(CM_OCD.class, false, 8, 11, new Object[]{message});
       this.add(CM_OSP.class, false, 2, 28, new Object[]{message});
       this.add(ST.class, false, 2, 29, new Object[]{message});
       this.add(ST.class, false, 2, 12, new Object[]{message});
       this.add(ST.class, false, 1, 5, new Object[]{message});
       this.add(ST.class, false, 3, 23, new Object[]{message});
       this.add(ST.class, false, 23, 4, new Object[]{message});
       this.add(ST.class, false, 5, 14, new Object[]{message});
       this.add(ST.class, false, 1, 27, new Object[]{message});
       this.add(ST.class, false, 2, 2, new Object[]{message});
    } catch (HL7Exception he) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Can't instantiate " + this.getClass().getName(), he);
    }
  }

  /**
   * Returns Set ID - UB92 (UB2-1).
   */
  public SI getSetIDUB92()  {
    SI ret = null;
    try {
        Type t = this.getField(1, 0);
        ret = (SI)t;
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
   * Returns Co-insurance days (9) (UB2-2).
   */
  public ST getCoInsuranceDays9()  {
    ST ret = null;
    try {
        Type t = this.getField(2, 0);
        ret = (ST)t;
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
   * Returns a single repetition of Condition code (24-30) (UB2-3).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public ID getConditionCode2430(int rep) throws HL7Exception {
    ID ret = null;
    try {
        Type t = this.getField(3, rep);
        ret = (ID)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    }
    return ret;
  }

  /**
   * Returns all repetitions of Condition code (24-30) (UB2-3).
   */
  public ID[] getConditionCode2430() {
     ID[] ret = null;
    try {
        Type[] t = this.getField(3);  
        ret = new ID[t.length];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = (ID)t[i];
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
   * Returns Covered days (7) (UB2-4).
   */
  public ST getCoveredDays7()  {
    ST ret = null;
    try {
        Type t = this.getField(4, 0);
        ret = (ST)t;
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
   * Returns Non-covered days (8) (UB2-5).
   */
  public ST getNonCoveredDays8()  {
    ST ret = null;
    try {
        Type t = this.getField(5, 0);
        ret = (ST)t;
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
   * Returns a single repetition of Value amount and code (39-41) (UB2-6).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public CM_UVC getValueAmountAndCode3941(int rep) throws HL7Exception {
    CM_UVC ret = null;
    try {
        Type t = this.getField(6, rep);
        ret = (CM_UVC)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    }
    return ret;
  }

  /**
   * Returns all repetitions of Value amount and code (39-41) (UB2-6).
   */
  public CM_UVC[] getValueAmountAndCode3941() {
     CM_UVC[] ret = null;
    try {
        Type[] t = this.getField(6);  
        ret = new CM_UVC[t.length];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = (CM_UVC)t[i];
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
   * Returns a single repetition of Occurrence code and date (32-35) (UB2-7).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public CM_OCD getOccurrenceCodeAndDate3235(int rep) throws HL7Exception {
    CM_OCD ret = null;
    try {
        Type t = this.getField(7, rep);
        ret = (CM_OCD)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    }
    return ret;
  }

  /**
   * Returns all repetitions of Occurrence code and date (32-35) (UB2-7).
   */
  public CM_OCD[] getOccurrenceCodeAndDate3235() {
     CM_OCD[] ret = null;
    try {
        Type[] t = this.getField(7);  
        ret = new CM_OCD[t.length];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = (CM_OCD)t[i];
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
   * Returns a single repetition of Occurrence span code / dates (36) (UB2-8).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public CM_OSP getOccurrenceSpanCodeDates(int rep) throws HL7Exception {
    CM_OSP ret = null;
    try {
        Type t = this.getField(8, rep);
        ret = (CM_OSP)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    }
    return ret;
  }

  /**
   * Returns all repetitions of Occurrence span code / dates (36) (UB2-8).
   */
  public CM_OSP[] getOccurrenceSpanCodeDates() {
     CM_OSP[] ret = null;
    try {
        Type[] t = this.getField(8);  
        ret = new CM_OSP[t.length];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = (CM_OSP)t[i];
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
   * Returns a single repetition of UB92 locator 2 (state) (UB2-9).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public ST getUB92Locator2State(int rep) throws HL7Exception {
    ST ret = null;
    try {
        Type t = this.getField(9, rep);
        ret = (ST)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    }
    return ret;
  }

  /**
   * Returns all repetitions of UB92 locator 2 (state) (UB2-9).
   */
  public ST[] getUB92Locator2State() {
     ST[] ret = null;
    try {
        Type[] t = this.getField(9);  
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
   * Returns a single repetition of UB92 locator 11 (state) (UB2-10).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public ST getUB92Locator11State(int rep) throws HL7Exception {
    ST ret = null;
    try {
        Type t = this.getField(10, rep);
        ret = (ST)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    }
    return ret;
  }

  /**
   * Returns all repetitions of UB92 locator 11 (state) (UB2-10).
   */
  public ST[] getUB92Locator11State() {
     ST[] ret = null;
    try {
        Type[] t = this.getField(10);  
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
   * Returns UB92 locator 31 (national) (UB2-11).
   */
  public ST getUB92Locator31National()  {
    ST ret = null;
    try {
        Type t = this.getField(11, 0);
        ret = (ST)t;
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
   * Returns a single repetition of Document control number (37) (UB2-12).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public ST getDocumentControlNumber(int rep) throws HL7Exception {
    ST ret = null;
    try {
        Type t = this.getField(12, rep);
        ret = (ST)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    }
    return ret;
  }

  /**
   * Returns all repetitions of Document control number (37) (UB2-12).
   */
  public ST[] getDocumentControlNumber() {
     ST[] ret = null;
    try {
        Type[] t = this.getField(12);  
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
   * Returns a single repetition of UB92 locator 49 (national) (UB2-13).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public ST getUB92Locator49National(int rep) throws HL7Exception {
    ST ret = null;
    try {
        Type t = this.getField(13, rep);
        ret = (ST)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    }
    return ret;
  }

  /**
   * Returns all repetitions of UB92 locator 49 (national) (UB2-13).
   */
  public ST[] getUB92Locator49National() {
     ST[] ret = null;
    try {
        Type[] t = this.getField(13);  
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
   * Returns a single repetition of UB92 locator 56 (state) (UB2-14).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public ST getUB92Locator56State(int rep) throws HL7Exception {
    ST ret = null;
    try {
        Type t = this.getField(14, rep);
        ret = (ST)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    }
    return ret;
  }

  /**
   * Returns all repetitions of UB92 locator 56 (state) (UB2-14).
   */
  public ST[] getUB92Locator56State() {
     ST[] ret = null;
    try {
        Type[] t = this.getField(14);  
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
   * Returns UB92 locator 57 (national) (UB2-15).
   */
  public ST getUB92Locator57National()  {
    ST ret = null;
    try {
        Type t = this.getField(15, 0);
        ret = (ST)t;
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
   * Returns a single repetition of UB92 Locator 78 (state) (UB2-16).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public ST getUB92Locator78State(int rep) throws HL7Exception {
    ST ret = null;
    try {
        Type t = this.getField(16, rep);
        ret = (ST)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    }
    return ret;
  }

  /**
   * Returns all repetitions of UB92 Locator 78 (state) (UB2-16).
   */
  public ST[] getUB92Locator78State() {
     ST[] ret = null;
    try {
        Type[] t = this.getField(16);  
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

}