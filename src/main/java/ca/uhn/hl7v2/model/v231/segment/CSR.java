package ca.uhn.hl7v2.model.v231.segment;

import ca.uhn.hl7v2.model.*;
import ca.uhn.hl7v2.model.v231.datatype.*;

import ca.uhn.log.HapiLogFactory;
import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.HL7Exception;

/**
 * <p>Represents an HL7 CSR message segment. 
 * This segment has the following fields:</p><p>
 * CSR-1: Sponsor Study ID (EI)<br> 
 * CSR-2: Alternate Study ID (EI)<br> 
 * CSR-3: Institution Registering the Patient (CE)<br> 
 * CSR-4: Sponsor Patient ID (CX)<br> 
 * CSR-5: Alternate Patient ID - CSR (CX)<br> 
 * CSR-6: Date/Time Of Patient Study Registration (TS)<br> 
 * CSR-7: Person Performing Study Registration (XCN)<br> 
 * CSR-8: Study Authorizing Provider (XCN)<br> 
 * CSR-9: Date/time Patient Study Consent Signed (TS)<br> 
 * CSR-10: Patient Study Eligibility Status (CE)<br> 
 * CSR-11: Study Randomization Date/time (TS)<br> 
 * CSR-12: Randomized Study Arm (CE)<br> 
 * CSR-13: Stratum for Study Randomization (CE)<br> 
 * CSR-14: Patient Evaluability Status (CE)<br> 
 * CSR-15: Date/time Ended Study (TS)<br> 
 * CSR-16: Reason Ended Study (CE)<br> 
 * </p><p>The get...() methods return data from individual fields.  These methods 
 * do not throw exceptions and may therefore have to handle exceptions internally.  
 * If an exception is handled internally, it is logged and null is returned.  
 * This is not expected to happen - if it does happen this indicates not so much 
 * an exceptional circumstance as a bug in the code for this class.</p>    
 */
public class CSR extends AbstractSegment  {

  /**
   * Creates a CSR (CSR - clinical study registration segment) segment object that belongs to the given 
   * message.  
   */
  public CSR(Group parent, ModelClassFactory factory) {
    super(parent, factory);
    Message message = getMessage();
    try {
       this.add(EI.class, true, 1, 60, new Object[]{message});
       this.add(EI.class, false, 1, 60, new Object[]{message});
       this.add(CE.class, false, 1, 60, new Object[]{message});
       this.add(CX.class, true, 1, 30, new Object[]{message});
       this.add(CX.class, false, 1, 30, new Object[]{message});
       this.add(TS.class, true, 1, 26, new Object[]{message});
       this.add(XCN.class, false, 0, 60, new Object[]{message});
       this.add(XCN.class, true, 0, 60, new Object[]{message});
       this.add(TS.class, false, 1, 26, new Object[]{message});
       this.add(CE.class, false, 1, 60, new Object[]{message});
       this.add(TS.class, false, 3, 26, new Object[]{message});
       this.add(CE.class, false, 3, 200, new Object[]{message});
       this.add(CE.class, false, 3, 200, new Object[]{message});
       this.add(CE.class, false, 1, 60, new Object[]{message});
       this.add(TS.class, false, 1, 26, new Object[]{message});
       this.add(CE.class, false, 1, 60, new Object[]{message});
    } catch (HL7Exception he) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Can't instantiate " + this.getClass().getName(), he);
    }
  }

  /**
   * Returns Sponsor Study ID (CSR-1).
   */
  public EI getSponsorStudyID()  {
    EI ret = null;
    try {
        Type t = this.getField(1, 0);
        ret = (EI)t;
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
   * Returns Alternate Study ID (CSR-2).
   */
  public EI getAlternateStudyID()  {
    EI ret = null;
    try {
        Type t = this.getField(2, 0);
        ret = (EI)t;
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
   * Returns Institution Registering the Patient (CSR-3).
   */
  public CE getInstitutionRegisteringThePatient()  {
    CE ret = null;
    try {
        Type t = this.getField(3, 0);
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
   * Returns Sponsor Patient ID (CSR-4).
   */
  public CX getSponsorPatientID()  {
    CX ret = null;
    try {
        Type t = this.getField(4, 0);
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
   * Returns Alternate Patient ID - CSR (CSR-5).
   */
  public CX getAlternatePatientIDCSR()  {
    CX ret = null;
    try {
        Type t = this.getField(5, 0);
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
   * Returns Date/Time Of Patient Study Registration (CSR-6).
   */
  public TS getDateTimeOfPatientStudyRegistration()  {
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
   * Returns a single repetition of Person Performing Study Registration (CSR-7).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public XCN getPersonPerformingStudyRegistration(int rep) throws HL7Exception {
    XCN ret = null;
    try {
        Type t = this.getField(7, rep);
        ret = (XCN)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    }
    return ret;
  }

  /**
   * Returns all repetitions of Person Performing Study Registration (CSR-7).
   */
  public XCN[] getPersonPerformingStudyRegistration() {
     XCN[] ret = null;
    try {
        Type[] t = this.getField(7);  
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
   * Returns a single repetition of Study Authorizing Provider (CSR-8).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public XCN getStudyAuthorizingProvider(int rep) throws HL7Exception {
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
   * Returns all repetitions of Study Authorizing Provider (CSR-8).
   */
  public XCN[] getStudyAuthorizingProvider() {
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
   * Returns Date/time Patient Study Consent Signed (CSR-9).
   */
  public TS getDateTimePatientStudyConsentSigned()  {
    TS ret = null;
    try {
        Type t = this.getField(9, 0);
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
   * Returns Patient Study Eligibility Status (CSR-10).
   */
  public CE getPatientStudyEligibilityStatus()  {
    CE ret = null;
    try {
        Type t = this.getField(10, 0);
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
   * Returns a single repetition of Study Randomization Date/time (CSR-11).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public TS getStudyRandomizationDateTime(int rep) throws HL7Exception {
    TS ret = null;
    try {
        Type t = this.getField(11, rep);
        ret = (TS)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    }
    return ret;
  }

  /**
   * Returns all repetitions of Study Randomization Date/time (CSR-11).
   */
  public TS[] getStudyRandomizationDateTime() {
     TS[] ret = null;
    try {
        Type[] t = this.getField(11);  
        ret = new TS[t.length];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = (TS)t[i];
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
   * Returns a single repetition of Randomized Study Arm (CSR-12).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public CE getRandomizedStudyArm(int rep) throws HL7Exception {
    CE ret = null;
    try {
        Type t = this.getField(12, rep);
        ret = (CE)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    }
    return ret;
  }

  /**
   * Returns all repetitions of Randomized Study Arm (CSR-12).
   */
  public CE[] getRandomizedStudyArm() {
     CE[] ret = null;
    try {
        Type[] t = this.getField(12);  
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
   * Returns a single repetition of Stratum for Study Randomization (CSR-13).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public CE getStratumForStudyRandomization(int rep) throws HL7Exception {
    CE ret = null;
    try {
        Type t = this.getField(13, rep);
        ret = (CE)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    }
    return ret;
  }

  /**
   * Returns all repetitions of Stratum for Study Randomization (CSR-13).
   */
  public CE[] getStratumForStudyRandomization() {
     CE[] ret = null;
    try {
        Type[] t = this.getField(13);  
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
   * Returns Patient Evaluability Status (CSR-14).
   */
  public CE getPatientEvaluabilityStatus()  {
    CE ret = null;
    try {
        Type t = this.getField(14, 0);
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
   * Returns Date/time Ended Study (CSR-15).
   */
  public TS getDateTimeEndedStudy()  {
    TS ret = null;
    try {
        Type t = this.getField(15, 0);
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
   * Returns Reason Ended Study (CSR-16).
   */
  public CE getReasonEndedStudy()  {
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

}