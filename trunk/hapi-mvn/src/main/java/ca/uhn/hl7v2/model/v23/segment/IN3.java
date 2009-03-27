package ca.uhn.hl7v2.model.v23.segment;

import ca.uhn.hl7v2.model.*;
import ca.uhn.hl7v2.model.v23.datatype.*;

import ca.uhn.log.HapiLogFactory;
import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.HL7Exception;

/**
 * <p>Represents an HL7 IN3 message segment. 
 * This segment has the following fields:</p><p>
 * IN3-1: Set ID - Insurance Certification (SI)<br> 
 * IN3-2: Certification Number (CX)<br> 
 * IN3-3: Certified By (XCN)<br> 
 * IN3-4: Certification Required (ID)<br> 
 * IN3-5: Penalty (CM_PEN)<br> 
 * IN3-6: Certification Date/Time (TS)<br> 
 * IN3-7: Certification Modify Date/Time (TS)<br> 
 * IN3-8: Operator (XCN)<br> 
 * IN3-9: Certification Begin Date (DT)<br> 
 * IN3-10: Certification End Date (DT)<br> 
 * IN3-11: Days (CM_DTN)<br> 
 * IN3-12: Non-Concur Code/Description (CE)<br> 
 * IN3-13: Non-Concur Effective Date/Time (TS)<br> 
 * IN3-14: Physician Reviewer (XCN)<br> 
 * IN3-15: Certification Contact (ST)<br> 
 * IN3-16: Certification Contact Phone Number (XTN)<br> 
 * IN3-17: Appeal Reason (CE)<br> 
 * IN3-18: Certification Agency (CE)<br> 
 * IN3-19: Certification Agency Phone Number (XTN)<br> 
 * IN3-20: Pre-Certification required/Window (CM_PCF)<br> 
 * IN3-21: Case Manager (ST)<br> 
 * IN3-22: Second Opinion Date (DT)<br> 
 * IN3-23: Second Opinion Status (IS)<br> 
 * IN3-24: Second Opinion Documentation Received (IS)<br> 
 * IN3-25: Second Opinion Physician (XCN)<br> 
 * </p><p>The get...() methods return data from individual fields.  These methods 
 * do not throw exceptions and may therefore have to handle exceptions internally.  
 * If an exception is handled internally, it is logged and null is returned.  
 * This is not expected to happen - if it does happen this indicates not so much 
 * an exceptional circumstance as a bug in the code for this class.</p>    
 */
public class IN3 extends AbstractSegment  {

  /**
   * Creates a IN3 (Insurance additional info - certification) segment object that belongs to the given 
   * message.  
   */
  public IN3(Group parent, ModelClassFactory factory) {
    super(parent, factory);
    Message message = getMessage();
    try {
       this.add(SI.class, true, 1, 4, new Object[]{message});
       this.add(CX.class, false, 1, 59, new Object[]{message});
       this.add(XCN.class, false, 0, 60, new Object[]{message});
       this.add(ID.class, false, 1, 1, new Object[]{message, new Integer(136)});
       this.add(CM_PEN.class, false, 1, 10, new Object[]{message});
       this.add(TS.class, false, 1, 26, new Object[]{message});
       this.add(TS.class, false, 1, 26, new Object[]{message});
       this.add(XCN.class, false, 0, 60, new Object[]{message});
       this.add(DT.class, false, 1, 8, new Object[]{message});
       this.add(DT.class, false, 1, 8, new Object[]{message});
       this.add(CM_DTN.class, false, 1, 3, new Object[]{message});
       this.add(CE.class, false, 1, 60, new Object[]{message});
       this.add(TS.class, false, 1, 26, new Object[]{message});
       this.add(XCN.class, false, 0, 60, new Object[]{message});
       this.add(ST.class, false, 1, 48, new Object[]{message});
       this.add(XTN.class, false, 0, 40, new Object[]{message});
       this.add(CE.class, false, 1, 60, new Object[]{message});
       this.add(CE.class, false, 1, 60, new Object[]{message});
       this.add(XTN.class, false, 0, 40, new Object[]{message});
       this.add(CM_PCF.class, false, 0, 40, new Object[]{message});
       this.add(ST.class, false, 1, 48, new Object[]{message});
       this.add(DT.class, false, 1, 8, new Object[]{message});
       this.add(IS.class, false, 1, 1, new Object[]{message, new Integer(151)});
       this.add(IS.class, false, 0, 1, new Object[]{message, new Integer(152)});
       this.add(XCN.class, false, 0, 60, new Object[]{message});
    } catch (HL7Exception he) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Can't instantiate " + this.getClass().getName(), he);
    }
  }

  /**
   * Returns Set ID - Insurance Certification (IN3-1).
   */
  public SI getSetIDInsuranceCertification()  {
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
   * Returns Certification Number (IN3-2).
   */
  public CX getCertificationNumber()  {
    CX ret = null;
    try {
        Type t = this.getField(2, 0);
        ret = (CX)t;
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
   * Returns a single repetition of Certified By (IN3-3).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public XCN getCertifiedBy(int rep) throws HL7Exception {
    XCN ret = null;
    try {
        Type t = this.getField(3, rep);
        ret = (XCN)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    }
    return ret;
  }

  /**
   * Returns all repetitions of Certified By (IN3-3).
   */
  public XCN[] getCertifiedBy() {
     XCN[] ret = null;
    try {
        Type[] t = this.getField(3);  
        ret = new XCN[t.length];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = (XCN)t[i];
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
   * Returns Certification Required (IN3-4).
   */
  public ID getCertificationRequired()  {
    ID ret = null;
    try {
        Type t = this.getField(4, 0);
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
   * Returns Penalty (IN3-5).
   */
  public CM_PEN getPenalty()  {
    CM_PEN ret = null;
    try {
        Type t = this.getField(5, 0);
        ret = (CM_PEN)t;
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
   * Returns Certification Date/Time (IN3-6).
   */
  public TS getCertificationDateTime()  {
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
   * Returns Certification Modify Date/Time (IN3-7).
   */
  public TS getCertificationModifyDateTime()  {
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
   * Returns a single repetition of Operator (IN3-8).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public XCN getOperator(int rep) throws HL7Exception {
    XCN ret = null;
    try {
        Type t = this.getField(8, rep);
        ret = (XCN)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    }
    return ret;
  }

  /**
   * Returns all repetitions of Operator (IN3-8).
   */
  public XCN[] getOperator() {
     XCN[] ret = null;
    try {
        Type[] t = this.getField(8);  
        ret = new XCN[t.length];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = (XCN)t[i];
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
   * Returns Certification Begin Date (IN3-9).
   */
  public DT getCertificationBeginDate()  {
    DT ret = null;
    try {
        Type t = this.getField(9, 0);
        ret = (DT)t;
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
   * Returns Certification End Date (IN3-10).
   */
  public DT getCertificationEndDate()  {
    DT ret = null;
    try {
        Type t = this.getField(10, 0);
        ret = (DT)t;
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
   * Returns Days (IN3-11).
   */
  public CM_DTN getDays()  {
    CM_DTN ret = null;
    try {
        Type t = this.getField(11, 0);
        ret = (CM_DTN)t;
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
   * Returns Non-Concur Code/Description (IN3-12).
   */
  public CE getNonConcurCodeDescription()  {
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
   * Returns Non-Concur Effective Date/Time (IN3-13).
   */
  public TS getNonConcurEffectiveDateTime()  {
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
   * Returns a single repetition of Physician Reviewer (IN3-14).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public XCN getPhysicianReviewer(int rep) throws HL7Exception {
    XCN ret = null;
    try {
        Type t = this.getField(14, rep);
        ret = (XCN)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    }
    return ret;
  }

  /**
   * Returns all repetitions of Physician Reviewer (IN3-14).
   */
  public XCN[] getPhysicianReviewer() {
     XCN[] ret = null;
    try {
        Type[] t = this.getField(14);  
        ret = new XCN[t.length];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = (XCN)t[i];
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
   * Returns Certification Contact (IN3-15).
   */
  public ST getCertificationContact()  {
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
   * Returns a single repetition of Certification Contact Phone Number (IN3-16).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public XTN getCertificationContactPhoneNumber(int rep) throws HL7Exception {
    XTN ret = null;
    try {
        Type t = this.getField(16, rep);
        ret = (XTN)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    }
    return ret;
  }

  /**
   * Returns all repetitions of Certification Contact Phone Number (IN3-16).
   */
  public XTN[] getCertificationContactPhoneNumber() {
     XTN[] ret = null;
    try {
        Type[] t = this.getField(16);  
        ret = new XTN[t.length];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = (XTN)t[i];
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
   * Returns Appeal Reason (IN3-17).
   */
  public CE getAppealReason()  {
    CE ret = null;
    try {
        Type t = this.getField(17, 0);
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
   * Returns Certification Agency (IN3-18).
   */
  public CE getCertificationAgency()  {
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
   * Returns a single repetition of Certification Agency Phone Number (IN3-19).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public XTN getCertificationAgencyPhoneNumber(int rep) throws HL7Exception {
    XTN ret = null;
    try {
        Type t = this.getField(19, rep);
        ret = (XTN)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    }
    return ret;
  }

  /**
   * Returns all repetitions of Certification Agency Phone Number (IN3-19).
   */
  public XTN[] getCertificationAgencyPhoneNumber() {
     XTN[] ret = null;
    try {
        Type[] t = this.getField(19);  
        ret = new XTN[t.length];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = (XTN)t[i];
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
   * Returns a single repetition of Pre-Certification required/Window (IN3-20).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public CM_PCF getPreCertificationRequiredWindow(int rep) throws HL7Exception {
    CM_PCF ret = null;
    try {
        Type t = this.getField(20, rep);
        ret = (CM_PCF)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    }
    return ret;
  }

  /**
   * Returns all repetitions of Pre-Certification required/Window (IN3-20).
   */
  public CM_PCF[] getPreCertificationRequiredWindow() {
     CM_PCF[] ret = null;
    try {
        Type[] t = this.getField(20);  
        ret = new CM_PCF[t.length];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = (CM_PCF)t[i];
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
   * Returns Case Manager (IN3-21).
   */
  public ST getCaseManager()  {
    ST ret = null;
    try {
        Type t = this.getField(21, 0);
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
   * Returns Second Opinion Date (IN3-22).
   */
  public DT getSecondOpinionDate()  {
    DT ret = null;
    try {
        Type t = this.getField(22, 0);
        ret = (DT)t;
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
   * Returns Second Opinion Status (IN3-23).
   */
  public IS getSecondOpinionStatus()  {
    IS ret = null;
    try {
        Type t = this.getField(23, 0);
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
   * Returns a single repetition of Second Opinion Documentation Received (IN3-24).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public IS getSecondOpinionDocumentationReceived(int rep) throws HL7Exception {
    IS ret = null;
    try {
        Type t = this.getField(24, rep);
        ret = (IS)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    }
    return ret;
  }

  /**
   * Returns all repetitions of Second Opinion Documentation Received (IN3-24).
   */
  public IS[] getSecondOpinionDocumentationReceived() {
     IS[] ret = null;
    try {
        Type[] t = this.getField(24);  
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
   * Returns a single repetition of Second Opinion Physician (IN3-25).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public XCN getSecondOpinionPhysician(int rep) throws HL7Exception {
    XCN ret = null;
    try {
        Type t = this.getField(25, rep);
        ret = (XCN)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    }
    return ret;
  }

  /**
   * Returns all repetitions of Second Opinion Physician (IN3-25).
   */
  public XCN[] getSecondOpinionPhysician() {
     XCN[] ret = null;
    try {
        Type[] t = this.getField(25);  
        ret = new XCN[t.length];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = (XCN)t[i];
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