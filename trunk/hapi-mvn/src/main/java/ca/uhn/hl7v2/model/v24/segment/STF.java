package ca.uhn.hl7v2.model.v24.segment;

import ca.uhn.hl7v2.model.*;
import ca.uhn.hl7v2.model.v24.datatype.*;

import ca.uhn.log.HapiLogFactory;
import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.HL7Exception;

/**
 * <p>Represents an HL7 STF message segment. 
 * This segment has the following fields:</p><p>
 * STF-1: Primary Key Value - STF (CE)<br> 
 * STF-2: Staff ID Code (CX)<br> 
 * STF-3: Staff Name (XPN)<br> 
 * STF-4: Staff Type (IS)<br> 
 * STF-5: Administrative Sex (IS)<br> 
 * STF-6: Date/Time Of Birth (TS)<br> 
 * STF-7: Active/Inactive Flag (ID)<br> 
 * STF-8: Department (CE)<br> 
 * STF-9: Hospital Service (CE)<br> 
 * STF-10: Phone (XTN)<br> 
 * STF-11: Office/Home Address (XAD)<br> 
 * STF-12: Institution Activation Date (DIN)<br> 
 * STF-13: Institution Inactivation Date (DIN)<br> 
 * STF-14: Backup Person ID (CE)<br> 
 * STF-15: E-Mail Address (ST)<br> 
 * STF-16: Preferred Method of Contact (CE)<br> 
 * STF-17: Marital Status (CE)<br> 
 * STF-18: Job Title (ST)<br> 
 * STF-19: Job Code/Class (JCC)<br> 
 * STF-20: Employment Status Code (CE)<br> 
 * STF-21: Additional Insured on  Auto (ID)<br> 
 * STF-22: Driver's License Number - Staff (DLN)<br> 
 * STF-23: Copy  Auto Ins (ID)<br> 
 * STF-24: Auto Ins. Expires (DT)<br> 
 * STF-25: Date Last DMV Review (DT)<br> 
 * STF-26: Date Next DMV Review (DT)<br> 
 * STF-27: Race (CE)<br> 
 * STF-28: Ethnic Group (CE)<br> 
 * STF-29: Re-activation Approval Indicator (ID)<br> 
 * </p><p>The get...() methods return data from individual fields.  These methods 
 * do not throw exceptions and may therefore have to handle exceptions internally.  
 * If an exception is handled internally, it is logged and null is returned.  
 * This is not expected to happen - if it does happen this indicates not so much 
 * an exceptional circumstance as a bug in the code for this class.</p>    
 */
public class STF extends AbstractSegment  {

  /**
   * Creates a STF (Staff Identification) segment object that belongs to the given 
   * message.  
   */
  public STF(Group parent, ModelClassFactory factory) {
    super(parent, factory);
    Message message = getMessage();
    try {
       this.add(CE.class, false, 1, 250, new Object[]{message});
       this.add(CX.class, false, 0, 60, new Object[]{message});
       this.add(XPN.class, false, 0, 250, new Object[]{message});
       this.add(IS.class, false, 0, 2, new Object[]{message, new Integer(182)});
       this.add(IS.class, false, 1, 1, new Object[]{message, new Integer(1)});
       this.add(TS.class, false, 1, 26, new Object[]{message});
       this.add(ID.class, false, 1, 1, new Object[]{message, new Integer(183)});
       this.add(CE.class, false, 0, 250, new Object[]{message});
       this.add(CE.class, false, 0, 250, new Object[]{message});
       this.add(XTN.class, false, 0, 250, new Object[]{message});
       this.add(XAD.class, false, 0, 250, new Object[]{message});
       this.add(DIN.class, false, 0, 26, new Object[]{message});
       this.add(DIN.class, false, 0, 26, new Object[]{message});
       this.add(CE.class, false, 0, 250, new Object[]{message});
       this.add(ST.class, false, 0, 40, new Object[]{message});
       this.add(CE.class, false, 1, 250, new Object[]{message});
       this.add(CE.class, false, 1, 250, new Object[]{message});
       this.add(ST.class, false, 1, 20, new Object[]{message});
       this.add(JCC.class, false, 1, 20, new Object[]{message});
       this.add(CE.class, false, 1, 2, new Object[]{message});
       this.add(ID.class, false, 1, 1, new Object[]{message, new Integer(136)});
       this.add(DLN.class, false, 1, 25, new Object[]{message});
       this.add(ID.class, false, 1, 1, new Object[]{message, new Integer(136)});
       this.add(DT.class, false, 1, 8, new Object[]{message});
       this.add(DT.class, false, 1, 8, new Object[]{message});
       this.add(DT.class, false, 1, 8, new Object[]{message});
       this.add(CE.class, false, 1, 250, new Object[]{message});
       this.add(CE.class, false, 1, 250, new Object[]{message});
       this.add(ID.class, false, 1, 1, new Object[]{message, new Integer(136)});
    } catch (HL7Exception he) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Can't instantiate " + this.getClass().getName(), he);
    }
  }

  /**
   * Returns Primary Key Value - STF (STF-1).
   */
  public CE getPrimaryKeyValueSTF()  {
    CE ret = null;
    try {
        Type t = this.getField(1, 0);
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
   * Returns a single repetition of Staff ID Code (STF-2).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public CX getStaffIDCode(int rep) throws HL7Exception {
    CX ret = null;
    try {
        Type t = this.getField(2, rep);
        ret = (CX)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    }
    return ret;
  }

  /**
   * Returns all repetitions of Staff ID Code (STF-2).
   */
  public CX[] getStaffIDCode() {
     CX[] ret = null;
    try {
        Type[] t = this.getField(2);  
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
   * Returns a single repetition of Staff Name (STF-3).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public XPN getStaffName(int rep) throws HL7Exception {
    XPN ret = null;
    try {
        Type t = this.getField(3, rep);
        ret = (XPN)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    }
    return ret;
  }

  /**
   * Returns all repetitions of Staff Name (STF-3).
   */
  public XPN[] getStaffName() {
     XPN[] ret = null;
    try {
        Type[] t = this.getField(3);  
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
   * Returns a single repetition of Staff Type (STF-4).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public IS getStaffType(int rep) throws HL7Exception {
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
   * Returns all repetitions of Staff Type (STF-4).
   */
  public IS[] getStaffType() {
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
   * Returns Administrative Sex (STF-5).
   */
  public IS getAdministrativeSex()  {
    IS ret = null;
    try {
        Type t = this.getField(5, 0);
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
   * Returns Date/Time Of Birth (STF-6).
   */
  public TS getDateTimeOfBirth()  {
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
   * Returns Active/Inactive Flag (STF-7).
   */
  public ID getActiveInactiveFlag()  {
    ID ret = null;
    try {
        Type t = this.getField(7, 0);
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
   * Returns a single repetition of Department (STF-8).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public CE getDepartment(int rep) throws HL7Exception {
    CE ret = null;
    try {
        Type t = this.getField(8, rep);
        ret = (CE)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    }
    return ret;
  }

  /**
   * Returns all repetitions of Department (STF-8).
   */
  public CE[] getDepartment() {
     CE[] ret = null;
    try {
        Type[] t = this.getField(8);  
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
   * Returns a single repetition of Hospital Service (STF-9).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public CE getHospitalService(int rep) throws HL7Exception {
    CE ret = null;
    try {
        Type t = this.getField(9, rep);
        ret = (CE)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    }
    return ret;
  }

  /**
   * Returns all repetitions of Hospital Service (STF-9).
   */
  public CE[] getHospitalService() {
     CE[] ret = null;
    try {
        Type[] t = this.getField(9);  
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
   * Returns a single repetition of Phone (STF-10).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public XTN getPhone(int rep) throws HL7Exception {
    XTN ret = null;
    try {
        Type t = this.getField(10, rep);
        ret = (XTN)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    }
    return ret;
  }

  /**
   * Returns all repetitions of Phone (STF-10).
   */
  public XTN[] getPhone() {
     XTN[] ret = null;
    try {
        Type[] t = this.getField(10);  
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
   * Returns a single repetition of Office/Home Address (STF-11).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public XAD getOfficeHomeAddress(int rep) throws HL7Exception {
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
   * Returns all repetitions of Office/Home Address (STF-11).
   */
  public XAD[] getOfficeHomeAddress() {
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
   * Returns a single repetition of Institution Activation Date (STF-12).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public DIN getInstitutionActivationDate(int rep) throws HL7Exception {
    DIN ret = null;
    try {
        Type t = this.getField(12, rep);
        ret = (DIN)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    }
    return ret;
  }

  /**
   * Returns all repetitions of Institution Activation Date (STF-12).
   */
  public DIN[] getInstitutionActivationDate() {
     DIN[] ret = null;
    try {
        Type[] t = this.getField(12);  
        ret = new DIN[t.length];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = (DIN)t[i];
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
   * Returns a single repetition of Institution Inactivation Date (STF-13).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public DIN getInstitutionInactivationDate(int rep) throws HL7Exception {
    DIN ret = null;
    try {
        Type t = this.getField(13, rep);
        ret = (DIN)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    }
    return ret;
  }

  /**
   * Returns all repetitions of Institution Inactivation Date (STF-13).
   */
  public DIN[] getInstitutionInactivationDate() {
     DIN[] ret = null;
    try {
        Type[] t = this.getField(13);  
        ret = new DIN[t.length];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = (DIN)t[i];
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
   * Returns a single repetition of Backup Person ID (STF-14).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public CE getBackupPersonID(int rep) throws HL7Exception {
    CE ret = null;
    try {
        Type t = this.getField(14, rep);
        ret = (CE)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    }
    return ret;
  }

  /**
   * Returns all repetitions of Backup Person ID (STF-14).
   */
  public CE[] getBackupPersonID() {
     CE[] ret = null;
    try {
        Type[] t = this.getField(14);  
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
   * Returns a single repetition of E-Mail Address (STF-15).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public ST getEMailAddress(int rep) throws HL7Exception {
    ST ret = null;
    try {
        Type t = this.getField(15, rep);
        ret = (ST)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    }
    return ret;
  }

  /**
   * Returns all repetitions of E-Mail Address (STF-15).
   */
  public ST[] getEMailAddress() {
     ST[] ret = null;
    try {
        Type[] t = this.getField(15);  
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
   * Returns Preferred Method of Contact (STF-16).
   */
  public CE getPreferredMethodOfContact()  {
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
   * Returns Marital Status (STF-17).
   */
  public CE getMaritalStatus()  {
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
   * Returns Job Title (STF-18).
   */
  public ST getJobTitle()  {
    ST ret = null;
    try {
        Type t = this.getField(18, 0);
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
   * Returns Job Code/Class (STF-19).
   */
  public JCC getJobCodeClass()  {
    JCC ret = null;
    try {
        Type t = this.getField(19, 0);
        ret = (JCC)t;
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
   * Returns Employment Status Code (STF-20).
   */
  public CE getEmploymentStatusCode()  {
    CE ret = null;
    try {
        Type t = this.getField(20, 0);
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
   * Returns Additional Insured on  Auto (STF-21).
   */
  public ID getAdditionalInsuredOnAuto()  {
    ID ret = null;
    try {
        Type t = this.getField(21, 0);
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
   * Returns Driver's License Number - Staff (STF-22).
   */
  public DLN getDriverSLicenseNumberStaff()  {
    DLN ret = null;
    try {
        Type t = this.getField(22, 0);
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
   * Returns Copy  Auto Ins (STF-23).
   */
  public ID getCopyAutoIns()  {
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
   * Returns Auto Ins. Expires (STF-24).
   */
  public DT getAutoInsExpires()  {
    DT ret = null;
    try {
        Type t = this.getField(24, 0);
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
   * Returns Date Last DMV Review (STF-25).
   */
  public DT getDateLastDMVReview()  {
    DT ret = null;
    try {
        Type t = this.getField(25, 0);
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
   * Returns Date Next DMV Review (STF-26).
   */
  public DT getDateNextDMVReview()  {
    DT ret = null;
    try {
        Type t = this.getField(26, 0);
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
   * Returns Race (STF-27).
   */
  public CE getRace()  {
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
   * Returns Ethnic Group (STF-28).
   */
  public CE getEthnicGroup()  {
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
   * Returns Re-activation Approval Indicator (STF-29).
   */
  public ID getReActivationApprovalIndicator()  {
    ID ret = null;
    try {
        Type t = this.getField(29, 0);
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

}