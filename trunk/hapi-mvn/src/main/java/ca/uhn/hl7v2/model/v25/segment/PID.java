package ca.uhn.hl7v2.model.v25.segment;

import ca.uhn.hl7v2.model.*;
import ca.uhn.hl7v2.model.v25.datatype.*;

import ca.uhn.log.HapiLogFactory;
import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.HL7Exception;

/**
 * <p>Represents an HL7 PID message segment. 
 * This segment has the following fields:</p><p>
 * PID-1: Set ID - PID (SI)<br> 
 * PID-2: Patient ID (CX)<br> 
 * PID-3: Patient Identifier List (CX)<br> 
 * PID-4: Alternate Patient ID - PID (CX)<br> 
 * PID-5: Patient Name (XPN)<br> 
 * PID-6: Mother's Maiden Name (XPN)<br> 
 * PID-7: Date/Time of Birth (TS)<br> 
 * PID-8: Administrative Sex (IS)<br> 
 * PID-9: Patient Alias (XPN)<br> 
 * PID-10: Race (CE)<br> 
 * PID-11: Patient Address (XAD)<br> 
 * PID-12: County Code (IS)<br> 
 * PID-13: Phone Number - Home (XTN)<br> 
 * PID-14: Phone Number - Business (XTN)<br> 
 * PID-15: Primary Language (CE)<br> 
 * PID-16: Marital Status (CE)<br> 
 * PID-17: Religion (CE)<br> 
 * PID-18: Patient Account Number (CX)<br> 
 * PID-19: SSN Number - Patient (ST)<br> 
 * PID-20: Driver's License Number - Patient (DLN)<br> 
 * PID-21: Mother's Identifier (CX)<br> 
 * PID-22: Ethnic Group (CE)<br> 
 * PID-23: Birth Place (ST)<br> 
 * PID-24: Multiple Birth Indicator (ID)<br> 
 * PID-25: Birth Order (NM)<br> 
 * PID-26: Citizenship (CE)<br> 
 * PID-27: Veterans Military Status (CE)<br> 
 * PID-28: Nationality (CE)<br> 
 * PID-29: Patient Death Date and Time (TS)<br> 
 * PID-30: Patient Death Indicator (ID)<br> 
 * PID-31: Identity Unknown Indicator (ID)<br> 
 * PID-32: Identity Reliability Code (IS)<br> 
 * PID-33: Last Update Date/Time (TS)<br> 
 * PID-34: Last Update Facility (HD)<br> 
 * PID-35: Species Code (CE)<br> 
 * PID-36: Breed Code (CE)<br> 
 * PID-37: Strain (ST)<br> 
 * PID-38: Production Class Code (CE)<br> 
 * PID-39: Tribal Citizenship (CWE)<br> 
 * </p><p>The get...() methods return data from individual fields.  These methods 
 * do not throw exceptions and may therefore have to handle exceptions internally.  
 * If an exception is handled internally, it is logged and null is returned.  
 * This is not expected to happen - if it does happen this indicates not so much 
 * an exceptional circumstance as a bug in the code for this class.</p>    
 */
public class PID extends AbstractSegment  {

  /**
   * Creates a PID (Patient Identification) segment object that belongs to the given 
   * message.  
   */
  public PID(Group parent, ModelClassFactory factory) {
    super(parent, factory);
    Message message = getMessage();
    try {
       this.add(SI.class, false, 1, 4, new Object[]{message});
       this.add(CX.class, false, 1, 20, new Object[]{message});
       this.add(CX.class, true, 0, 250, new Object[]{message});
       this.add(CX.class, false, 0, 20, new Object[]{message});
       this.add(XPN.class, true, 0, 250, new Object[]{message});
       this.add(XPN.class, false, 0, 250, new Object[]{message});
       this.add(TS.class, false, 1, 26, new Object[]{message});
       this.add(IS.class, false, 1, 1, new Object[]{message, new Integer(1)});
       this.add(XPN.class, false, 0, 250, new Object[]{message});
       this.add(CE.class, false, 0, 250, new Object[]{message});
       this.add(XAD.class, false, 0, 250, new Object[]{message});
       this.add(IS.class, false, 1, 4, new Object[]{message, new Integer(289)});
       this.add(XTN.class, false, 0, 250, new Object[]{message});
       this.add(XTN.class, false, 0, 250, new Object[]{message});
       this.add(CE.class, false, 1, 250, new Object[]{message});
       this.add(CE.class, false, 1, 250, new Object[]{message});
       this.add(CE.class, false, 1, 250, new Object[]{message});
       this.add(CX.class, false, 1, 250, new Object[]{message});
       this.add(ST.class, false, 1, 16, new Object[]{message});
       this.add(DLN.class, false, 1, 25, new Object[]{message});
       this.add(CX.class, false, 0, 250, new Object[]{message});
       this.add(CE.class, false, 0, 250, new Object[]{message});
       this.add(ST.class, false, 1, 250, new Object[]{message});
       this.add(ID.class, false, 1, 1, new Object[]{message, new Integer(136)});
       this.add(NM.class, false, 1, 2, new Object[]{message});
       this.add(CE.class, false, 0, 250, new Object[]{message});
       this.add(CE.class, false, 1, 250, new Object[]{message});
       this.add(CE.class, false, 1, 250, new Object[]{message});
       this.add(TS.class, false, 1, 26, new Object[]{message});
       this.add(ID.class, false, 1, 1, new Object[]{message, new Integer(136)});
       this.add(ID.class, false, 1, 1, new Object[]{message, new Integer(136)});
       this.add(IS.class, false, 0, 20, new Object[]{message, new Integer(445)});
       this.add(TS.class, false, 1, 26, new Object[]{message});
       this.add(HD.class, false, 1, 241, new Object[]{message});
       this.add(CE.class, false, 1, 250, new Object[]{message});
       this.add(CE.class, false, 1, 250, new Object[]{message});
       this.add(ST.class, false, 1, 80, new Object[]{message});
       this.add(CE.class, false, 1, 250, new Object[]{message});
       this.add(CWE.class, false, 0, 250, new Object[]{message});
    } catch (HL7Exception he) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Can't instantiate " + this.getClass().getName(), he);
    }
  }

  /**
   * Returns Set ID - PID (PID-1).
   */
  public SI getSetIDPID()  {
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
   * Returns Patient ID (PID-2).
   */
  public CX getPatientID()  {
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
   * Returns a single repetition of Patient Identifier List (PID-3).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public CX getPatientIdentifierList(int rep) throws HL7Exception {
    CX ret = null;
    try {
        Type t = this.getField(3, rep);
        ret = (CX)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    }
    return ret;
  }

  /**
   * Returns all repetitions of Patient Identifier List (PID-3).
   */
  public CX[] getPatientIdentifierList() {
     CX[] ret = null;
    try {
        Type[] t = this.getField(3);  
        ret = new CX[t.length];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = (CX)t[i];
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
   * Returns a single repetition of Alternate Patient ID - PID (PID-4).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public CX getAlternatePatientIDPID(int rep) throws HL7Exception {
    CX ret = null;
    try {
        Type t = this.getField(4, rep);
        ret = (CX)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    }
    return ret;
  }

  /**
   * Returns all repetitions of Alternate Patient ID - PID (PID-4).
   */
  public CX[] getAlternatePatientIDPID() {
     CX[] ret = null;
    try {
        Type[] t = this.getField(4);  
        ret = new CX[t.length];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = (CX)t[i];
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
   * Returns a single repetition of Patient Name (PID-5).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public XPN getPatientName(int rep) throws HL7Exception {
    XPN ret = null;
    try {
        Type t = this.getField(5, rep);
        ret = (XPN)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    }
    return ret;
  }

  /**
   * Returns all repetitions of Patient Name (PID-5).
   */
  public XPN[] getPatientName() {
     XPN[] ret = null;
    try {
        Type[] t = this.getField(5);  
        ret = new XPN[t.length];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = (XPN)t[i];
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
   * Returns a single repetition of Mother's Maiden Name (PID-6).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public XPN getMotherSMaidenName(int rep) throws HL7Exception {
    XPN ret = null;
    try {
        Type t = this.getField(6, rep);
        ret = (XPN)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    }
    return ret;
  }

  /**
   * Returns all repetitions of Mother's Maiden Name (PID-6).
   */
  public XPN[] getMotherSMaidenName() {
     XPN[] ret = null;
    try {
        Type[] t = this.getField(6);  
        ret = new XPN[t.length];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = (XPN)t[i];
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
   * Returns Date/Time of Birth (PID-7).
   */
  public TS getDateTimeOfBirth()  {
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
   * Returns Administrative Sex (PID-8).
   */
  public IS getAdministrativeSex()  {
    IS ret = null;
    try {
        Type t = this.getField(8, 0);
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
   * Returns a single repetition of Patient Alias (PID-9).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public XPN getPatientAlias(int rep) throws HL7Exception {
    XPN ret = null;
    try {
        Type t = this.getField(9, rep);
        ret = (XPN)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    }
    return ret;
  }

  /**
   * Returns all repetitions of Patient Alias (PID-9).
   */
  public XPN[] getPatientAlias() {
     XPN[] ret = null;
    try {
        Type[] t = this.getField(9);  
        ret = new XPN[t.length];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = (XPN)t[i];
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
   * Returns a single repetition of Race (PID-10).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public CE getRace(int rep) throws HL7Exception {
    CE ret = null;
    try {
        Type t = this.getField(10, rep);
        ret = (CE)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    }
    return ret;
  }

  /**
   * Returns all repetitions of Race (PID-10).
   */
  public CE[] getRace() {
     CE[] ret = null;
    try {
        Type[] t = this.getField(10);  
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
   * Returns a single repetition of Patient Address (PID-11).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public XAD getPatientAddress(int rep) throws HL7Exception {
    XAD ret = null;
    try {
        Type t = this.getField(11, rep);
        ret = (XAD)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    }
    return ret;
  }

  /**
   * Returns all repetitions of Patient Address (PID-11).
   */
  public XAD[] getPatientAddress() {
     XAD[] ret = null;
    try {
        Type[] t = this.getField(11);  
        ret = new XAD[t.length];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = (XAD)t[i];
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
   * Returns County Code (PID-12).
   */
  public IS getCountyCode()  {
    IS ret = null;
    try {
        Type t = this.getField(12, 0);
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
   * Returns a single repetition of Phone Number - Home (PID-13).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public XTN getPhoneNumberHome(int rep) throws HL7Exception {
    XTN ret = null;
    try {
        Type t = this.getField(13, rep);
        ret = (XTN)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    }
    return ret;
  }

  /**
   * Returns all repetitions of Phone Number - Home (PID-13).
   */
  public XTN[] getPhoneNumberHome() {
     XTN[] ret = null;
    try {
        Type[] t = this.getField(13);  
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
   * Returns a single repetition of Phone Number - Business (PID-14).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public XTN getPhoneNumberBusiness(int rep) throws HL7Exception {
    XTN ret = null;
    try {
        Type t = this.getField(14, rep);
        ret = (XTN)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    }
    return ret;
  }

  /**
   * Returns all repetitions of Phone Number - Business (PID-14).
   */
  public XTN[] getPhoneNumberBusiness() {
     XTN[] ret = null;
    try {
        Type[] t = this.getField(14);  
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
   * Returns Primary Language (PID-15).
   */
  public CE getPrimaryLanguage()  {
    CE ret = null;
    try {
        Type t = this.getField(15, 0);
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
   * Returns Marital Status (PID-16).
   */
  public CE getMaritalStatus()  {
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
   * Returns Religion (PID-17).
   */
  public CE getReligion()  {
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
   * Returns Patient Account Number (PID-18).
   */
  public CX getPatientAccountNumber()  {
    CX ret = null;
    try {
        Type t = this.getField(18, 0);
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
   * Returns SSN Number - Patient (PID-19).
   */
  public ST getSSNNumberPatient()  {
    ST ret = null;
    try {
        Type t = this.getField(19, 0);
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
   * Returns Driver's License Number - Patient (PID-20).
   */
  public DLN getDriverSLicenseNumberPatient()  {
    DLN ret = null;
    try {
        Type t = this.getField(20, 0);
        ret = (DLN)t;
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
   * Returns a single repetition of Mother's Identifier (PID-21).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public CX getMotherSIdentifier(int rep) throws HL7Exception {
    CX ret = null;
    try {
        Type t = this.getField(21, rep);
        ret = (CX)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    }
    return ret;
  }

  /**
   * Returns all repetitions of Mother's Identifier (PID-21).
   */
  public CX[] getMotherSIdentifier() {
     CX[] ret = null;
    try {
        Type[] t = this.getField(21);  
        ret = new CX[t.length];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = (CX)t[i];
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
   * Returns a single repetition of Ethnic Group (PID-22).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public CE getEthnicGroup(int rep) throws HL7Exception {
    CE ret = null;
    try {
        Type t = this.getField(22, rep);
        ret = (CE)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    }
    return ret;
  }

  /**
   * Returns all repetitions of Ethnic Group (PID-22).
   */
  public CE[] getEthnicGroup() {
     CE[] ret = null;
    try {
        Type[] t = this.getField(22);  
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
   * Returns Birth Place (PID-23).
   */
  public ST getBirthPlace()  {
    ST ret = null;
    try {
        Type t = this.getField(23, 0);
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
   * Returns Multiple Birth Indicator (PID-24).
   */
  public ID getMultipleBirthIndicator()  {
    ID ret = null;
    try {
        Type t = this.getField(24, 0);
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
   * Returns Birth Order (PID-25).
   */
  public NM getBirthOrder()  {
    NM ret = null;
    try {
        Type t = this.getField(25, 0);
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
   * Returns a single repetition of Citizenship (PID-26).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public CE getCitizenship(int rep) throws HL7Exception {
    CE ret = null;
    try {
        Type t = this.getField(26, rep);
        ret = (CE)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    }
    return ret;
  }

  /**
   * Returns all repetitions of Citizenship (PID-26).
   */
  public CE[] getCitizenship() {
     CE[] ret = null;
    try {
        Type[] t = this.getField(26);  
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
   * Returns Veterans Military Status (PID-27).
   */
  public CE getVeteransMilitaryStatus()  {
    CE ret = null;
    try {
        Type t = this.getField(27, 0);
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
   * Returns Nationality (PID-28).
   */
  public CE getNationality()  {
    CE ret = null;
    try {
        Type t = this.getField(28, 0);
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
   * Returns Patient Death Date and Time (PID-29).
   */
  public TS getPatientDeathDateAndTime()  {
    TS ret = null;
    try {
        Type t = this.getField(29, 0);
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
   * Returns Patient Death Indicator (PID-30).
   */
  public ID getPatientDeathIndicator()  {
    ID ret = null;
    try {
        Type t = this.getField(30, 0);
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
   * Returns Identity Unknown Indicator (PID-31).
   */
  public ID getIdentityUnknownIndicator()  {
    ID ret = null;
    try {
        Type t = this.getField(31, 0);
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
   * Returns a single repetition of Identity Reliability Code (PID-32).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public IS getIdentityReliabilityCode(int rep) throws HL7Exception {
    IS ret = null;
    try {
        Type t = this.getField(32, rep);
        ret = (IS)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    }
    return ret;
  }

  /**
   * Returns all repetitions of Identity Reliability Code (PID-32).
   */
  public IS[] getIdentityReliabilityCode() {
     IS[] ret = null;
    try {
        Type[] t = this.getField(32);  
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
   * Returns Last Update Date/Time (PID-33).
   */
  public TS getLastUpdateDateTime()  {
    TS ret = null;
    try {
        Type t = this.getField(33, 0);
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
   * Returns Last Update Facility (PID-34).
   */
  public HD getLastUpdateFacility()  {
    HD ret = null;
    try {
        Type t = this.getField(34, 0);
        ret = (HD)t;
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
   * Returns Species Code (PID-35).
   */
  public CE getSpeciesCode()  {
    CE ret = null;
    try {
        Type t = this.getField(35, 0);
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
   * Returns Breed Code (PID-36).
   */
  public CE getBreedCode()  {
    CE ret = null;
    try {
        Type t = this.getField(36, 0);
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
   * Returns Strain (PID-37).
   */
  public ST getStrain()  {
    ST ret = null;
    try {
        Type t = this.getField(37, 0);
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
   * Returns Production Class Code (PID-38).
   */
  public CE getProductionClassCode()  {
    CE ret = null;
    try {
        Type t = this.getField(38, 0);
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
   * Returns a single repetition of Tribal Citizenship (PID-39).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public CWE getTribalCitizenship(int rep) throws HL7Exception {
    CWE ret = null;
    try {
        Type t = this.getField(39, rep);
        ret = (CWE)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    }
    return ret;
  }

  /**
   * Returns all repetitions of Tribal Citizenship (PID-39).
   */
  public CWE[] getTribalCitizenship() {
     CWE[] ret = null;
    try {
        Type[] t = this.getField(39);  
        ret = new CWE[t.length];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = (CWE)t[i];
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