package ca.uhn.hl7v2.model.v25.segment;

import ca.uhn.hl7v2.model.*;
import ca.uhn.hl7v2.model.v25.datatype.*;

import ca.uhn.log.HapiLogFactory;
import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.HL7Exception;

/**
 * <p>Represents an HL7 UB2 message segment. 
 * This segment has the following fields:</p><p>
 * UB2-1: Set ID - UB2 (SI)<br> 
 * UB2-2: Co-Insurance Days (9) (ST)<br> 
 * UB2-3: Condition Code (24-30) (IS)<br> 
 * UB2-4: Covered Days (7) (ST)<br> 
 * UB2-5: Non-Covered Days (8) (ST)<br> 
 * UB2-6: Value Amount & Code (UVC)<br> 
 * UB2-7: Occurrence Code & Date (32-35) (OCD)<br> 
 * UB2-8: Occurrence Span Code/Dates (36) (OSP)<br> 
 * UB2-9: UB92 Locator 2 (State) (ST)<br> 
 * UB2-10: UB92 Locator 11 (State) (ST)<br> 
 * UB2-11: UB92 Locator 31 (National) (ST)<br> 
 * UB2-12: Document Control Number (ST)<br> 
 * UB2-13: UB92 Locator 49 (National) (ST)<br> 
 * UB2-14: UB92 Locator 56 (State) (ST)<br> 
 * UB2-15: UB92 Locator 57 (National) (ST)<br> 
 * UB2-16: UB92 Locator 78 (State) (ST)<br> 
 * UB2-17: Special Visit Count (NM)<br> 
 * </p><p>The get...() methods return data from individual fields.  These methods 
 * do not throw exceptions and may therefore have to handle exceptions internally.  
 * If an exception is handled internally, it is logged and null is returned.  
 * This is not expected to happen - if it does happen this indicates not so much 
 * an exceptional circumstance as a bug in the code for this class.</p>    
 */
public class UB2 extends AbstractSegment  {

  /**
   * Creates a UB2 (UB92 Data) segment object that belongs to the given 
   * message.  
   */
  public UB2(Group parent, ModelClassFactory factory) {
    super(parent, factory);
    Message message = getMessage();
    try {
       this.add(SI.class, false, 1, 4, new Object[]{message});
       this.add(ST.class, false, 1, 3, new Object[]{message});
       this.add(IS.class, false, 0, 2, new Object[]{message, new Integer(43)});
       this.add(ST.class, false, 1, 3, new Object[]{message});
       this.add(ST.class, false, 1, 4, new Object[]{message});
       this.add(UVC.class, false, 0, 41, new Object[]{message});
       this.add(OCD.class, false, 0, 259, new Object[]{message});
       this.add(OSP.class, false, 0, 268, new Object[]{message});
       this.add(ST.class, false, 0, 29, new Object[]{message});
       this.add(ST.class, false, 0, 12, new Object[]{message});
       this.add(ST.class, false, 1, 5, new Object[]{message});
       this.add(ST.class, false, 0, 23, new Object[]{message});
       this.add(ST.class, false, 0, 4, new Object[]{message});
       this.add(ST.class, false, 0, 14, new Object[]{message});
       this.add(ST.class, false, 1, 27, new Object[]{message});
       this.add(ST.class, false, 0, 2, new Object[]{message});
       this.add(NM.class, false, 1, 3, new Object[]{message});
    } catch (HL7Exception he) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Can't instantiate " + this.getClass().getName(), he);
    }
  }

  /**
   * Returns Set ID - UB2 (UB2-1).
   */
  public SI getSetIDUB2()  {
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
   * Returns Co-Insurance Days (9) (UB2-2).
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
   * Returns a single repetition of Condition Code (24-30) (UB2-3).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public IS getConditionCode2430(int rep) throws HL7Exception {
    IS ret = null;
    try {
        Type t = this.getField(3, rep);
        ret = (IS)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    }
    return ret;
  }

  /**
   * Returns all repetitions of Condition Code (24-30) (UB2-3).
   */
  public IS[] getConditionCode2430() {
     IS[] ret = null;
    try {
        Type[] t = this.getField(3);  
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
   * Returns Covered Days (7) (UB2-4).
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
   * Returns Non-Covered Days (8) (UB2-5).
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
   * Returns a single repetition of Value Amount & Code (UB2-6).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public UVC getValueAmountCode(int rep) throws HL7Exception {
    UVC ret = null;
    try {
        Type t = this.getField(6, rep);
        ret = (UVC)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    }
    return ret;
  }

  /**
   * Returns all repetitions of Value Amount & Code (UB2-6).
   */
  public UVC[] getValueAmountCode() {
     UVC[] ret = null;
    try {
        Type[] t = this.getField(6);  
        ret = new UVC[t.length];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = (UVC)t[i];
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
   * Returns a single repetition of Occurrence Code & Date (32-35) (UB2-7).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public OCD getOccurrenceCodeDate3235(int rep) throws HL7Exception {
    OCD ret = null;
    try {
        Type t = this.getField(7, rep);
        ret = (OCD)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    }
    return ret;
  }

  /**
   * Returns all repetitions of Occurrence Code & Date (32-35) (UB2-7).
   */
  public OCD[] getOccurrenceCodeDate3235() {
     OCD[] ret = null;
    try {
        Type[] t = this.getField(7);  
        ret = new OCD[t.length];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = (OCD)t[i];
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
   * Returns a single repetition of Occurrence Span Code/Dates (36) (UB2-8).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public OSP getOccurrenceSpanCodeDates(int rep) throws HL7Exception {
    OSP ret = null;
    try {
        Type t = this.getField(8, rep);
        ret = (OSP)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    }
    return ret;
  }

  /**
   * Returns all repetitions of Occurrence Span Code/Dates (36) (UB2-8).
   */
  public OSP[] getOccurrenceSpanCodeDates() {
     OSP[] ret = null;
    try {
        Type[] t = this.getField(8);  
        ret = new OSP[t.length];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = (OSP)t[i];
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
   * Returns a single repetition of UB92 Locator 2 (State) (UB2-9).
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
   * Returns all repetitions of UB92 Locator 2 (State) (UB2-9).
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
   * Returns a single repetition of UB92 Locator 11 (State) (UB2-10).
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
   * Returns all repetitions of UB92 Locator 11 (State) (UB2-10).
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
   * Returns UB92 Locator 31 (National) (UB2-11).
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
   * Returns a single repetition of Document Control Number (UB2-12).
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
   * Returns all repetitions of Document Control Number (UB2-12).
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
   * Returns a single repetition of UB92 Locator 49 (National) (UB2-13).
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
   * Returns all repetitions of UB92 Locator 49 (National) (UB2-13).
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
   * Returns a single repetition of UB92 Locator 56 (State) (UB2-14).
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
   * Returns all repetitions of UB92 Locator 56 (State) (UB2-14).
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
   * Returns UB92 Locator 57 (National) (UB2-15).
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
   * Returns a single repetition of UB92 Locator 78 (State) (UB2-16).
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
   * Returns all repetitions of UB92 Locator 78 (State) (UB2-16).
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

  /**
   * Returns Special Visit Count (UB2-17).
   */
  public NM getSpecialVisitCount()  {
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

}