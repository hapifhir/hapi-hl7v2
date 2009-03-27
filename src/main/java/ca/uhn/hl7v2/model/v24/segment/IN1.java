package ca.uhn.hl7v2.model.v24.segment;

import ca.uhn.hl7v2.model.*;
import ca.uhn.hl7v2.model.v24.datatype.*;

import ca.uhn.log.HapiLogFactory;
import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.HL7Exception;

/**
 * <p>Represents an HL7 IN1 message segment. 
 * This segment has the following fields:</p><p>
 * IN1-1: Set ID - IN1 (SI)<br> 
 * IN1-2: Insurance Plan ID (CE)<br> 
 * IN1-3: Insurance Company ID (CX)<br> 
 * IN1-4: Insurance Company Name (XON)<br> 
 * IN1-5: Insurance Company Address (XAD)<br> 
 * IN1-6: Insurance Co Contact Person (XPN)<br> 
 * IN1-7: Insurance Co Phone Number (XTN)<br> 
 * IN1-8: Group Number (ST)<br> 
 * IN1-9: Group Name (XON)<br> 
 * IN1-10: Insured's Group Emp ID (CX)<br> 
 * IN1-11: Insured's Group Emp Name (XON)<br> 
 * IN1-12: Plan Effective Date (DT)<br> 
 * IN1-13: Plan Expiration Date (DT)<br> 
 * IN1-14: Authorization Information (AUI)<br> 
 * IN1-15: Plan Type (IS)<br> 
 * IN1-16: Name Of Insured (XPN)<br> 
 * IN1-17: Insured's Relationship To Patient (CE)<br> 
 * IN1-18: Insured's Date Of Birth (TS)<br> 
 * IN1-19: Insured's Address (XAD)<br> 
 * IN1-20: Assignment Of Benefits (IS)<br> 
 * IN1-21: Coordination Of Benefits (IS)<br> 
 * IN1-22: Coord Of Ben. Priority (ST)<br> 
 * IN1-23: Notice Of Admission Flag (ID)<br> 
 * IN1-24: Notice Of Admission Date (DT)<br> 
 * IN1-25: Report Of Eligibility Flag (ID)<br> 
 * IN1-26: Report Of Eligibility Date (DT)<br> 
 * IN1-27: Release Information Code (IS)<br> 
 * IN1-28: Pre-Admit Cert (PAC) (ST)<br> 
 * IN1-29: Verification Date/Time (TS)<br> 
 * IN1-30: Verification By (XCN)<br> 
 * IN1-31: Type Of Agreement Code (IS)<br> 
 * IN1-32: Billing Status (IS)<br> 
 * IN1-33: Lifetime Reserve Days (NM)<br> 
 * IN1-34: Delay Before L.R. Day (NM)<br> 
 * IN1-35: Company Plan Code (IS)<br> 
 * IN1-36: Policy Number (ST)<br> 
 * IN1-37: Policy Deductible (CP)<br> 
 * IN1-38: Policy Limit - Amount (CP)<br> 
 * IN1-39: Policy Limit - Days (NM)<br> 
 * IN1-40: Room Rate - Semi-Private (CP)<br> 
 * IN1-41: Room Rate - Private (CP)<br> 
 * IN1-42: Insured's Employment Status (CE)<br> 
 * IN1-43: Insured's Administrative Sex (IS)<br> 
 * IN1-44: Insured's Employer's Address (XAD)<br> 
 * IN1-45: Verification Status (ST)<br> 
 * IN1-46: Prior Insurance Plan ID (IS)<br> 
 * IN1-47: Coverage Type (IS)<br> 
 * IN1-48: Handicap (IS)<br> 
 * IN1-49: Insured's ID Number (CX)<br> 
 * </p><p>The get...() methods return data from individual fields.  These methods 
 * do not throw exceptions and may therefore have to handle exceptions internally.  
 * If an exception is handled internally, it is logged and null is returned.  
 * This is not expected to happen - if it does happen this indicates not so much 
 * an exceptional circumstance as a bug in the code for this class.</p>    
 */
public class IN1 extends AbstractSegment  {

  /**
   * Creates a IN1 (Insurance) segment object that belongs to the given 
   * message.  
   */
  public IN1(Group parent, ModelClassFactory factory) {
    super(parent, factory);
    Message message = getMessage();
    try {
       this.add(SI.class, true, 1, 4, new Object[]{message});
       this.add(CE.class, true, 1, 250, new Object[]{message});
       this.add(CX.class, true, 0, 250, new Object[]{message});
       this.add(XON.class, false, 0, 250, new Object[]{message});
       this.add(XAD.class, false, 0, 250, new Object[]{message});
       this.add(XPN.class, false, 0, 250, new Object[]{message});
       this.add(XTN.class, false, 0, 250, new Object[]{message});
       this.add(ST.class, false, 1, 12, new Object[]{message});
       this.add(XON.class, false, 0, 250, new Object[]{message});
       this.add(CX.class, false, 0, 250, new Object[]{message});
       this.add(XON.class, false, 0, 250, new Object[]{message});
       this.add(DT.class, false, 1, 8, new Object[]{message});
       this.add(DT.class, false, 1, 8, new Object[]{message});
       this.add(AUI.class, false, 1, 250, new Object[]{message});
       this.add(IS.class, false, 1, 3, new Object[]{message, new Integer(86)});
       this.add(XPN.class, false, 0, 250, new Object[]{message});
       this.add(CE.class, false, 1, 250, new Object[]{message});
       this.add(TS.class, false, 1, 26, new Object[]{message});
       this.add(XAD.class, false, 0, 250, new Object[]{message});
       this.add(IS.class, false, 1, 2, new Object[]{message, new Integer(135)});
       this.add(IS.class, false, 1, 2, new Object[]{message, new Integer(173)});
       this.add(ST.class, false, 1, 2, new Object[]{message});
       this.add(ID.class, false, 1, 1, new Object[]{message, new Integer(136)});
       this.add(DT.class, false, 1, 8, new Object[]{message});
       this.add(ID.class, false, 1, 1, new Object[]{message, new Integer(136)});
       this.add(DT.class, false, 1, 8, new Object[]{message});
       this.add(IS.class, false, 1, 2, new Object[]{message, new Integer(93)});
       this.add(ST.class, false, 1, 15, new Object[]{message});
       this.add(TS.class, false, 1, 26, new Object[]{message});
       this.add(XCN.class, false, 0, 250, new Object[]{message});
       this.add(IS.class, false, 1, 2, new Object[]{message, new Integer(98)});
       this.add(IS.class, false, 1, 2, new Object[]{message, new Integer(22)});
       this.add(NM.class, false, 1, 4, new Object[]{message});
       this.add(NM.class, false, 1, 4, new Object[]{message});
       this.add(IS.class, false, 1, 8, new Object[]{message, new Integer(42)});
       this.add(ST.class, false, 1, 15, new Object[]{message});
       this.add(CP.class, false, 1, 12, new Object[]{message});
       this.add(CP.class, false, 1, 12, new Object[]{message});
       this.add(NM.class, false, 1, 4, new Object[]{message});
       this.add(CP.class, false, 1, 12, new Object[]{message});
       this.add(CP.class, false, 1, 12, new Object[]{message});
       this.add(CE.class, false, 1, 250, new Object[]{message});
       this.add(IS.class, false, 1, 1, new Object[]{message, new Integer(1)});
       this.add(XAD.class, false, 0, 250, new Object[]{message});
       this.add(ST.class, false, 1, 2, new Object[]{message});
       this.add(IS.class, false, 1, 8, new Object[]{message, new Integer(72)});
       this.add(IS.class, false, 1, 3, new Object[]{message, new Integer(309)});
       this.add(IS.class, false, 1, 2, new Object[]{message, new Integer(295)});
       this.add(CX.class, false, 0, 250, new Object[]{message});
    } catch (HL7Exception he) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Can't instantiate " + this.getClass().getName(), he);
    }
  }

  /**
   * Returns Set ID - IN1 (IN1-1).
   */
  public SI getSetIDIN1()  {
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
   * Returns Insurance Plan ID (IN1-2).
   */
  public CE getInsurancePlanID()  {
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
   * Returns a single repetition of Insurance Company ID (IN1-3).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public CX getInsuranceCompanyID(int rep) throws HL7Exception {
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
   * Returns all repetitions of Insurance Company ID (IN1-3).
   */
  public CX[] getInsuranceCompanyID() {
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
   * Returns a single repetition of Insurance Company Name (IN1-4).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public XON getInsuranceCompanyName(int rep) throws HL7Exception {
    XON ret = null;
    try {
        Type t = this.getField(4, rep);
        ret = (XON)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    }
    return ret;
  }

  /**
   * Returns all repetitions of Insurance Company Name (IN1-4).
   */
  public XON[] getInsuranceCompanyName() {
     XON[] ret = null;
    try {
        Type[] t = this.getField(4);  
        ret = new XON[t.length];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = (XON)t[i];
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
   * Returns a single repetition of Insurance Company Address (IN1-5).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public XAD getInsuranceCompanyAddress(int rep) throws HL7Exception {
    XAD ret = null;
    try {
        Type t = this.getField(5, rep);
        ret = (XAD)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    }
    return ret;
  }

  /**
   * Returns all repetitions of Insurance Company Address (IN1-5).
   */
  public XAD[] getInsuranceCompanyAddress() {
     XAD[] ret = null;
    try {
        Type[] t = this.getField(5);  
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
   * Returns a single repetition of Insurance Co Contact Person (IN1-6).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public XPN getInsuranceCoContactPerson(int rep) throws HL7Exception {
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
   * Returns all repetitions of Insurance Co Contact Person (IN1-6).
   */
  public XPN[] getInsuranceCoContactPerson() {
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
   * Returns a single repetition of Insurance Co Phone Number (IN1-7).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public XTN getInsuranceCoPhoneNumber(int rep) throws HL7Exception {
    XTN ret = null;
    try {
        Type t = this.getField(7, rep);
        ret = (XTN)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    }
    return ret;
  }

  /**
   * Returns all repetitions of Insurance Co Phone Number (IN1-7).
   */
  public XTN[] getInsuranceCoPhoneNumber() {
     XTN[] ret = null;
    try {
        Type[] t = this.getField(7);  
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
   * Returns Group Number (IN1-8).
   */
  public ST getGroupNumber()  {
    ST ret = null;
    try {
        Type t = this.getField(8, 0);
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
   * Returns a single repetition of Group Name (IN1-9).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public XON getGroupName(int rep) throws HL7Exception {
    XON ret = null;
    try {
        Type t = this.getField(9, rep);
        ret = (XON)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    }
    return ret;
  }

  /**
   * Returns all repetitions of Group Name (IN1-9).
   */
  public XON[] getGroupName() {
     XON[] ret = null;
    try {
        Type[] t = this.getField(9);  
        ret = new XON[t.length];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = (XON)t[i];
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
   * Returns a single repetition of Insured's Group Emp ID (IN1-10).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public CX getInsuredSGroupEmpID(int rep) throws HL7Exception {
    CX ret = null;
    try {
        Type t = this.getField(10, rep);
        ret = (CX)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    }
    return ret;
  }

  /**
   * Returns all repetitions of Insured's Group Emp ID (IN1-10).
   */
  public CX[] getInsuredSGroupEmpID() {
     CX[] ret = null;
    try {
        Type[] t = this.getField(10);  
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
   * Returns a single repetition of Insured's Group Emp Name (IN1-11).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public XON getInsuredSGroupEmpName(int rep) throws HL7Exception {
    XON ret = null;
    try {
        Type t = this.getField(11, rep);
        ret = (XON)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    }
    return ret;
  }

  /**
   * Returns all repetitions of Insured's Group Emp Name (IN1-11).
   */
  public XON[] getInsuredSGroupEmpName() {
     XON[] ret = null;
    try {
        Type[] t = this.getField(11);  
        ret = new XON[t.length];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = (XON)t[i];
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
   * Returns Plan Effective Date (IN1-12).
   */
  public DT getPlanEffectiveDate()  {
    DT ret = null;
    try {
        Type t = this.getField(12, 0);
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
   * Returns Plan Expiration Date (IN1-13).
   */
  public DT getPlanExpirationDate()  {
    DT ret = null;
    try {
        Type t = this.getField(13, 0);
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
   * Returns Authorization Information (IN1-14).
   */
  public AUI getAuthorizationInformation()  {
    AUI ret = null;
    try {
        Type t = this.getField(14, 0);
        ret = (AUI)t;
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
   * Returns Plan Type (IN1-15).
   */
  public IS getPlanType()  {
    IS ret = null;
    try {
        Type t = this.getField(15, 0);
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
   * Returns a single repetition of Name Of Insured (IN1-16).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public XPN getNameOfInsured(int rep) throws HL7Exception {
    XPN ret = null;
    try {
        Type t = this.getField(16, rep);
        ret = (XPN)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    }
    return ret;
  }

  /**
   * Returns all repetitions of Name Of Insured (IN1-16).
   */
  public XPN[] getNameOfInsured() {
     XPN[] ret = null;
    try {
        Type[] t = this.getField(16);  
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
   * Returns Insured's Relationship To Patient (IN1-17).
   */
  public CE getInsuredSRelationshipToPatient()  {
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
   * Returns Insured's Date Of Birth (IN1-18).
   */
  public TS getInsuredSDateOfBirth()  {
    TS ret = null;
    try {
        Type t = this.getField(18, 0);
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
   * Returns a single repetition of Insured's Address (IN1-19).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public XAD getInsuredSAddress(int rep) throws HL7Exception {
    XAD ret = null;
    try {
        Type t = this.getField(19, rep);
        ret = (XAD)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    }
    return ret;
  }

  /**
   * Returns all repetitions of Insured's Address (IN1-19).
   */
  public XAD[] getInsuredSAddress() {
     XAD[] ret = null;
    try {
        Type[] t = this.getField(19);  
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
   * Returns Assignment Of Benefits (IN1-20).
   */
  public IS getAssignmentOfBenefits()  {
    IS ret = null;
    try {
        Type t = this.getField(20, 0);
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
   * Returns Coordination Of Benefits (IN1-21).
   */
  public IS getCoordinationOfBenefits()  {
    IS ret = null;
    try {
        Type t = this.getField(21, 0);
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
   * Returns Coord Of Ben. Priority (IN1-22).
   */
  public ST getCoordOfBenPriority()  {
    ST ret = null;
    try {
        Type t = this.getField(22, 0);
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
   * Returns Notice Of Admission Flag (IN1-23).
   */
  public ID getNoticeOfAdmissionFlag()  {
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
   * Returns Notice Of Admission Date (IN1-24).
   */
  public DT getNoticeOfAdmissionDate()  {
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
   * Returns Report Of Eligibility Flag (IN1-25).
   */
  public ID getReportOfEligibilityFlag()  {
    ID ret = null;
    try {
        Type t = this.getField(25, 0);
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
   * Returns Report Of Eligibility Date (IN1-26).
   */
  public DT getReportOfEligibilityDate()  {
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
   * Returns Release Information Code (IN1-27).
   */
  public IS getReleaseInformationCode()  {
    IS ret = null;
    try {
        Type t = this.getField(27, 0);
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
   * Returns Pre-Admit Cert (PAC) (IN1-28).
   */
  public ST getPreAdmitCert()  {
    ST ret = null;
    try {
        Type t = this.getField(28, 0);
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
   * Returns Verification Date/Time (IN1-29).
   */
  public TS getVerificationDateTime()  {
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
   * Returns a single repetition of Verification By (IN1-30).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public XCN getVerificationBy(int rep) throws HL7Exception {
    XCN ret = null;
    try {
        Type t = this.getField(30, rep);
        ret = (XCN)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    }
    return ret;
  }

  /**
   * Returns all repetitions of Verification By (IN1-30).
   */
  public XCN[] getVerificationBy() {
     XCN[] ret = null;
    try {
        Type[] t = this.getField(30);  
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
   * Returns Type Of Agreement Code (IN1-31).
   */
  public IS getTypeOfAgreementCode()  {
    IS ret = null;
    try {
        Type t = this.getField(31, 0);
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
   * Returns Billing Status (IN1-32).
   */
  public IS getBillingStatus()  {
    IS ret = null;
    try {
        Type t = this.getField(32, 0);
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
   * Returns Lifetime Reserve Days (IN1-33).
   */
  public NM getLifetimeReserveDays()  {
    NM ret = null;
    try {
        Type t = this.getField(33, 0);
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
   * Returns Delay Before L.R. Day (IN1-34).
   */
  public NM getDelayBeforeLRDay()  {
    NM ret = null;
    try {
        Type t = this.getField(34, 0);
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
   * Returns Company Plan Code (IN1-35).
   */
  public IS getCompanyPlanCode()  {
    IS ret = null;
    try {
        Type t = this.getField(35, 0);
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
   * Returns Policy Number (IN1-36).
   */
  public ST getPolicyNumber()  {
    ST ret = null;
    try {
        Type t = this.getField(36, 0);
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
   * Returns Policy Deductible (IN1-37).
   */
  public CP getPolicyDeductible()  {
    CP ret = null;
    try {
        Type t = this.getField(37, 0);
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

  /**
   * Returns Policy Limit - Amount (IN1-38).
   */
  public CP getPolicyLimitAmount()  {
    CP ret = null;
    try {
        Type t = this.getField(38, 0);
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

  /**
   * Returns Policy Limit - Days (IN1-39).
   */
  public NM getPolicyLimitDays()  {
    NM ret = null;
    try {
        Type t = this.getField(39, 0);
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
   * Returns Room Rate - Semi-Private (IN1-40).
   */
  public CP getRoomRateSemiPrivate()  {
    CP ret = null;
    try {
        Type t = this.getField(40, 0);
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

  /**
   * Returns Room Rate - Private (IN1-41).
   */
  public CP getRoomRatePrivate()  {
    CP ret = null;
    try {
        Type t = this.getField(41, 0);
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

  /**
   * Returns Insured's Employment Status (IN1-42).
   */
  public CE getInsuredSEmploymentStatus()  {
    CE ret = null;
    try {
        Type t = this.getField(42, 0);
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
   * Returns Insured's Administrative Sex (IN1-43).
   */
  public IS getInsuredSAdministrativeSex()  {
    IS ret = null;
    try {
        Type t = this.getField(43, 0);
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
   * Returns a single repetition of Insured's Employer's Address (IN1-44).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public XAD getInsuredSEmployerSAddress(int rep) throws HL7Exception {
    XAD ret = null;
    try {
        Type t = this.getField(44, rep);
        ret = (XAD)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    }
    return ret;
  }

  /**
   * Returns all repetitions of Insured's Employer's Address (IN1-44).
   */
  public XAD[] getInsuredSEmployerSAddress() {
     XAD[] ret = null;
    try {
        Type[] t = this.getField(44);  
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
   * Returns Verification Status (IN1-45).
   */
  public ST getVerificationStatus()  {
    ST ret = null;
    try {
        Type t = this.getField(45, 0);
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
   * Returns Prior Insurance Plan ID (IN1-46).
   */
  public IS getPriorInsurancePlanID()  {
    IS ret = null;
    try {
        Type t = this.getField(46, 0);
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
   * Returns Coverage Type (IN1-47).
   */
  public IS getCoverageType()  {
    IS ret = null;
    try {
        Type t = this.getField(47, 0);
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
   * Returns Handicap (IN1-48).
   */
  public IS getHandicap()  {
    IS ret = null;
    try {
        Type t = this.getField(48, 0);
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
   * Returns a single repetition of Insured's ID Number (IN1-49).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public CX getInsuredSIDNumber(int rep) throws HL7Exception {
    CX ret = null;
    try {
        Type t = this.getField(49, rep);
        ret = (CX)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    }
    return ret;
  }

  /**
   * Returns all repetitions of Insured's ID Number (IN1-49).
   */
  public CX[] getInsuredSIDNumber() {
     CX[] ret = null;
    try {
        Type[] t = this.getField(49);  
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

}