package ca.uhn.hl7v2.model.v22.segment;

import ca.uhn.hl7v2.model.*;
import ca.uhn.hl7v2.model.v22.datatype.*;

import ca.uhn.log.HapiLogFactory;
import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.HL7Exception;

/**
 * <p>Represents an HL7 IN1 message segment. 
 * This segment has the following fields:</p><p>
 * IN1-1: Set ID - insurance (SI)<br> 
 * IN1-2: Insurance plan ID (ID)<br> 
 * IN1-3: Insurance company ID (ST)<br> 
 * IN1-4: Insurance company name (ST)<br> 
 * IN1-5: Insurance company address (AD)<br> 
 * IN1-6: Insurance company contact pers (PN)<br> 
 * IN1-7: Insurance company phone number (TN)<br> 
 * IN1-8: Group number (ST)<br> 
 * IN1-9: Group name (ST)<br> 
 * IN1-10: Insured's group employer ID (ST)<br> 
 * IN1-11: Insured's group employer name (ST)<br> 
 * IN1-12: Plan effective date (DT)<br> 
 * IN1-13: Plan expiration date (DT)<br> 
 * IN1-14: Authorization information (CM_AUI)<br> 
 * IN1-15: Plan type (ID)<br> 
 * IN1-16: Name of insured (PN)<br> 
 * IN1-17: Insured's relationship to patient (ID)<br> 
 * IN1-18: Insured's date of birth (DT)<br> 
 * IN1-19: Insured's address (AD)<br> 
 * IN1-20: Assignment of benefits (ID)<br> 
 * IN1-21: Coordination of benefits (ID)<br> 
 * IN1-22: Coordination of benefits - priority (ST)<br> 
 * IN1-23: Notice of admission code (ID)<br> 
 * IN1-24: Notice of admission date (DT)<br> 
 * IN1-25: Report of eligibility code (ID)<br> 
 * IN1-26: Report of eligibility date (DT)<br> 
 * IN1-27: Release information code (ID)<br> 
 * IN1-28: Pre-admit certification (PAC) (ST)<br> 
 * IN1-29: Verification date / time (TS)<br> 
 * IN1-30: Verification by (CN)<br> 
 * IN1-31: Type of agreement code (ID)<br> 
 * IN1-32: Billing status (ID)<br> 
 * IN1-33: Lifetime reserve days (NM)<br> 
 * IN1-34: Delay before lifetime reserve days (NM)<br> 
 * IN1-35: Company plan code (ID)<br> 
 * IN1-36: Policy number (ST)<br> 
 * IN1-37: Policy deductible (NM)<br> 
 * IN1-38: Policy limit - amount (NM)<br> 
 * IN1-39: Policy limit - days (NM)<br> 
 * IN1-40: Room rate - semi-private (NM)<br> 
 * IN1-41: Room rate - private (NM)<br> 
 * IN1-42: Insured's employment status (CE)<br> 
 * IN1-43: Insured's sex (ID)<br> 
 * IN1-44: Insured's employer address (AD)<br> 
 * IN1-45: Verification status (ST)<br> 
 * IN1-46: Prior insurance plan ID (ID)<br> 
 * </p><p>The get...() methods return data from individual fields.  These methods 
 * do not throw exceptions and may therefore have to handle exceptions internally.  
 * If an exception is handled internally, it is logged and null is returned.  
 * This is not expected to happen - if it does happen this indicates not so much 
 * an exceptional circumstance as a bug in the code for this class.</p>    
 */
public class IN1 extends AbstractSegment  {

  /**
   * Creates a IN1 (INSURANCE) segment object that belongs to the given 
   * message.  
   */
  public IN1(Group parent, ModelClassFactory factory) {
    super(parent, factory);
    Message message = getMessage();
    try {
       this.add(SI.class, true, 1, 4, new Object[]{message});
       this.add(ID.class, true, 1, 8, new Object[]{message, new Integer(72)});
       this.add(ST.class, true, 1, 9, new Object[]{message});
       this.add(ST.class, false, 1, 45, new Object[]{message});
       this.add(AD.class, false, 1, 106, new Object[]{message});
       this.add(PN.class, false, 1, 48, new Object[]{message});
       this.add(TN.class, false, 3, 40, new Object[]{message});
       this.add(ST.class, false, 1, 12, new Object[]{message});
       this.add(ST.class, false, 1, 35, new Object[]{message});
       this.add(ST.class, false, 1, 12, new Object[]{message});
       this.add(ST.class, false, 1, 45, new Object[]{message});
       this.add(DT.class, false, 1, 8, new Object[]{message});
       this.add(DT.class, false, 1, 8, new Object[]{message});
       this.add(CM_AUI.class, false, 1, 55, new Object[]{message});
       this.add(ID.class, false, 1, 5, new Object[]{message, new Integer(86)});
       this.add(PN.class, false, 1, 48, new Object[]{message});
       this.add(ID.class, false, 1, 2, new Object[]{message, new Integer(63)});
       this.add(DT.class, false, 1, 8, new Object[]{message});
       this.add(AD.class, false, 1, 106, new Object[]{message});
       this.add(ID.class, false, 1, 2, new Object[]{message, new Integer(135)});
       this.add(ID.class, false, 1, 2, new Object[]{message, new Integer(173)});
       this.add(ST.class, false, 1, 2, new Object[]{message});
       this.add(ID.class, false, 1, 2, new Object[]{message, new Integer(136)});
       this.add(DT.class, false, 1, 8, new Object[]{message});
       this.add(ID.class, false, 1, 4, new Object[]{message, new Integer(0)});
       this.add(DT.class, false, 1, 8, new Object[]{message});
       this.add(ID.class, false, 1, 2, new Object[]{message, new Integer(93)});
       this.add(ST.class, false, 1, 15, new Object[]{message});
       this.add(TS.class, false, 1, 26, new Object[]{message});
       this.add(CN.class, false, 1, 60, new Object[]{message});
       this.add(ID.class, false, 1, 2, new Object[]{message, new Integer(98)});
       this.add(ID.class, false, 1, 2, new Object[]{message, new Integer(22)});
       this.add(NM.class, false, 1, 4, new Object[]{message});
       this.add(NM.class, false, 1, 4, new Object[]{message});
       this.add(ID.class, false, 1, 8, new Object[]{message, new Integer(42)});
       this.add(ST.class, false, 1, 15, new Object[]{message});
       this.add(NM.class, false, 1, 12, new Object[]{message});
       this.add(NM.class, false, 1, 12, new Object[]{message});
       this.add(NM.class, false, 1, 4, new Object[]{message});
       this.add(NM.class, false, 1, 12, new Object[]{message});
       this.add(NM.class, false, 1, 12, new Object[]{message});
       this.add(CE.class, false, 1, 60, new Object[]{message});
       this.add(ID.class, false, 1, 1, new Object[]{message, new Integer(1)});
       this.add(AD.class, false, 1, 106, new Object[]{message});
       this.add(ST.class, false, 1, 2, new Object[]{message});
       this.add(ID.class, false, 1, 8, new Object[]{message, new Integer(72)});
    } catch (HL7Exception he) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Can't instantiate " + this.getClass().getName(), he);
    }
  }

  /**
   * Returns Set ID - insurance (IN1-1).
   */
  public SI getSetIDInsurance()  {
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
   * Returns Insurance plan ID (IN1-2).
   */
  public ID getInsurancePlanID()  {
    ID ret = null;
    try {
        Type t = this.getField(2, 0);
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
   * Returns Insurance company ID (IN1-3).
   */
  public ST getInsuranceCompanyID()  {
    ST ret = null;
    try {
        Type t = this.getField(3, 0);
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
   * Returns Insurance company name (IN1-4).
   */
  public ST getInsuranceCompanyName()  {
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
   * Returns Insurance company address (IN1-5).
   */
  public AD getInsuranceCompanyAddress()  {
    AD ret = null;
    try {
        Type t = this.getField(5, 0);
        ret = (AD)t;
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
   * Returns Insurance company contact pers (IN1-6).
   */
  public PN getInsuranceCompanyContactPers()  {
    PN ret = null;
    try {
        Type t = this.getField(6, 0);
        ret = (PN)t;
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
   * Returns a single repetition of Insurance company phone number (IN1-7).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public TN getInsuranceCompanyPhoneNumber(int rep) throws HL7Exception {
    TN ret = null;
    try {
        Type t = this.getField(7, rep);
        ret = (TN)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    }
    return ret;
  }

  /**
   * Returns all repetitions of Insurance company phone number (IN1-7).
   */
  public TN[] getInsuranceCompanyPhoneNumber() {
     TN[] ret = null;
    try {
        Type[] t = this.getField(7);  
        ret = new TN[t.length];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = (TN)t[i];
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
   * Returns Group number (IN1-8).
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
   * Returns Group name (IN1-9).
   */
  public ST getGroupName()  {
    ST ret = null;
    try {
        Type t = this.getField(9, 0);
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
   * Returns Insured's group employer ID (IN1-10).
   */
  public ST getInsuredSGroupEmployerID()  {
    ST ret = null;
    try {
        Type t = this.getField(10, 0);
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
   * Returns Insured's group employer name (IN1-11).
   */
  public ST getInsuredSGroupEmployerName()  {
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
   * Returns Plan effective date (IN1-12).
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
   * Returns Plan expiration date (IN1-13).
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
   * Returns Authorization information (IN1-14).
   */
  public CM_AUI getAuthorizationInformation()  {
    CM_AUI ret = null;
    try {
        Type t = this.getField(14, 0);
        ret = (CM_AUI)t;
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
   * Returns Plan type (IN1-15).
   */
  public ID getPlanType()  {
    ID ret = null;
    try {
        Type t = this.getField(15, 0);
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
   * Returns Name of insured (IN1-16).
   */
  public PN getNameOfInsured()  {
    PN ret = null;
    try {
        Type t = this.getField(16, 0);
        ret = (PN)t;
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
   * Returns Insured's relationship to patient (IN1-17).
   */
  public ID getInsuredSRelationshipToPatient()  {
    ID ret = null;
    try {
        Type t = this.getField(17, 0);
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
   * Returns Insured's date of birth (IN1-18).
   */
  public DT getInsuredSDateOfBirth()  {
    DT ret = null;
    try {
        Type t = this.getField(18, 0);
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
   * Returns Insured's address (IN1-19).
   */
  public AD getInsuredSAddress()  {
    AD ret = null;
    try {
        Type t = this.getField(19, 0);
        ret = (AD)t;
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
   * Returns Assignment of benefits (IN1-20).
   */
  public ID getAssignmentOfBenefits()  {
    ID ret = null;
    try {
        Type t = this.getField(20, 0);
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
   * Returns Coordination of benefits (IN1-21).
   */
  public ID getCoordinationOfBenefits()  {
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
   * Returns Coordination of benefits - priority (IN1-22).
   */
  public ST getCoordinationOfBenefitsPriority()  {
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
   * Returns Notice of admission code (IN1-23).
   */
  public ID getNoticeOfAdmissionCode()  {
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
   * Returns Notice of admission date (IN1-24).
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
   * Returns Report of eligibility code (IN1-25).
   */
  public ID getReportOfEligibilityCode()  {
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
   * Returns Report of eligibility date (IN1-26).
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
   * Returns Release information code (IN1-27).
   */
  public ID getReleaseInformationCode()  {
    ID ret = null;
    try {
        Type t = this.getField(27, 0);
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
   * Returns Pre-admit certification (PAC) (IN1-28).
   */
  public ST getPreAdmitCertification()  {
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
   * Returns Verification date / time (IN1-29).
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
   * Returns Verification by (IN1-30).
   */
  public CN getVerificationBy()  {
    CN ret = null;
    try {
        Type t = this.getField(30, 0);
        ret = (CN)t;
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
   * Returns Type of agreement code (IN1-31).
   */
  public ID getTypeOfAgreementCode()  {
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
   * Returns Billing status (IN1-32).
   */
  public ID getBillingStatus()  {
    ID ret = null;
    try {
        Type t = this.getField(32, 0);
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
   * Returns Lifetime reserve days (IN1-33).
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
   * Returns Delay before lifetime reserve days (IN1-34).
   */
  public NM getDelayBeforeLifetimeReserveDays()  {
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
   * Returns Company plan code (IN1-35).
   */
  public ID getCompanyPlanCode()  {
    ID ret = null;
    try {
        Type t = this.getField(35, 0);
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
   * Returns Policy number (IN1-36).
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
   * Returns Policy deductible (IN1-37).
   */
  public NM getPolicyDeductible()  {
    NM ret = null;
    try {
        Type t = this.getField(37, 0);
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
   * Returns Policy limit - amount (IN1-38).
   */
  public NM getPolicyLimitAmount()  {
    NM ret = null;
    try {
        Type t = this.getField(38, 0);
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
   * Returns Policy limit - days (IN1-39).
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
   * Returns Room rate - semi-private (IN1-40).
   */
  public NM getRoomRateSemiPrivate()  {
    NM ret = null;
    try {
        Type t = this.getField(40, 0);
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
   * Returns Room rate - private (IN1-41).
   */
  public NM getRoomRatePrivate()  {
    NM ret = null;
    try {
        Type t = this.getField(41, 0);
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
   * Returns Insured's employment status (IN1-42).
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
   * Returns Insured's sex (IN1-43).
   */
  public ID getInsuredSSex()  {
    ID ret = null;
    try {
        Type t = this.getField(43, 0);
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
   * Returns Insured's employer address (IN1-44).
   */
  public AD getInsuredSEmployerAddress()  {
    AD ret = null;
    try {
        Type t = this.getField(44, 0);
        ret = (AD)t;
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
   * Returns Verification status (IN1-45).
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
   * Returns Prior insurance plan ID (IN1-46).
   */
  public ID getPriorInsurancePlanID()  {
    ID ret = null;
    try {
        Type t = this.getField(46, 0);
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