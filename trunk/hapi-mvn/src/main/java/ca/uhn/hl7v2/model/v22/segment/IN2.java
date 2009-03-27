package ca.uhn.hl7v2.model.v22.segment;

import ca.uhn.hl7v2.model.*;
import ca.uhn.hl7v2.model.v22.datatype.*;

import ca.uhn.log.HapiLogFactory;
import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.HL7Exception;

/**
 * <p>Represents an HL7 IN2 message segment. 
 * This segment has the following fields:</p><p>
 * IN2-1: Insured's employee ID (ST)<br> 
 * IN2-2: Insured's social security number (ST)<br> 
 * IN2-3: Insured's employer name (CN)<br> 
 * IN2-4: Employer information data (ID)<br> 
 * IN2-5: Mail claim party (ID)<br> 
 * IN2-6: Medicare health insurance card number (NM)<br> 
 * IN2-7: Medicaid case name (PN)<br> 
 * IN2-8: Medicaid case number (NM)<br> 
 * IN2-9: Champus sponsor name (PN)<br> 
 * IN2-10: Champus ID number (NM)<br> 
 * IN2-11: Dependent of champus recipient (ID)<br> 
 * IN2-12: Champus organization (ST)<br> 
 * IN2-13: Champus station (ST)<br> 
 * IN2-14: Champus service (ID)<br> 
 * IN2-15: Champus rank / grade (ID)<br> 
 * IN2-16: Champus status (ID)<br> 
 * IN2-17: Champus retire date (DT)<br> 
 * IN2-18: Champus non-availability certification on file (ID)<br> 
 * IN2-19: Baby coverage (ID)<br> 
 * IN2-20: Combine baby bill (ID)<br> 
 * IN2-21: Blood deductible (NM)<br> 
 * IN2-22: Special coverage approval name (PN)<br> 
 * IN2-23: Special coverage approval title (ST)<br> 
 * IN2-24: Non-covered insurance code (ID)<br> 
 * IN2-25: Payor ID (ST)<br> 
 * IN2-26: Payor subscriber ID (ST)<br> 
 * IN2-27: Eligibility source (ID)<br> 
 * IN2-28: Room coverage type / amount (CM_RMC)<br> 
 * IN2-29: Policy type / amount (CM_PTA)<br> 
 * IN2-30: Daily deductible (CM_DDI)<br> 
 * </p><p>The get...() methods return data from individual fields.  These methods 
 * do not throw exceptions and may therefore have to handle exceptions internally.  
 * If an exception is handled internally, it is logged and null is returned.  
 * This is not expected to happen - if it does happen this indicates not so much 
 * an exceptional circumstance as a bug in the code for this class.</p>    
 */
public class IN2 extends AbstractSegment  {

  /**
   * Creates a IN2 (INSURANCE ADDITIONAL INFO) segment object that belongs to the given 
   * message.  
   */
  public IN2(Group parent, ModelClassFactory factory) {
    super(parent, factory);
    Message message = getMessage();
    try {
       this.add(ST.class, false, 1, 15, new Object[]{message});
       this.add(ST.class, false, 1, 9, new Object[]{message});
       this.add(CN.class, false, 1, 60, new Object[]{message});
       this.add(ID.class, false, 1, 1, new Object[]{message, new Integer(139)});
       this.add(ID.class, false, 1, 1, new Object[]{message, new Integer(137)});
       this.add(NM.class, false, 1, 15, new Object[]{message});
       this.add(PN.class, false, 1, 48, new Object[]{message});
       this.add(NM.class, false, 1, 15, new Object[]{message});
       this.add(PN.class, false, 1, 48, new Object[]{message});
       this.add(NM.class, false, 1, 20, new Object[]{message});
       this.add(ID.class, false, 1, 1, new Object[]{message, new Integer(0)});
       this.add(ST.class, false, 1, 25, new Object[]{message});
       this.add(ST.class, false, 1, 25, new Object[]{message});
       this.add(ID.class, false, 1, 14, new Object[]{message, new Integer(140)});
       this.add(ID.class, false, 1, 2, new Object[]{message, new Integer(141)});
       this.add(ID.class, false, 1, 3, new Object[]{message, new Integer(142)});
       this.add(DT.class, false, 1, 8, new Object[]{message});
       this.add(ID.class, false, 1, 1, new Object[]{message, new Integer(136)});
       this.add(ID.class, false, 1, 1, new Object[]{message, new Integer(136)});
       this.add(ID.class, false, 1, 1, new Object[]{message, new Integer(136)});
       this.add(NM.class, false, 1, 1, new Object[]{message});
       this.add(PN.class, false, 1, 48, new Object[]{message});
       this.add(ST.class, false, 1, 30, new Object[]{message});
       this.add(ID.class, false, 0, 8, new Object[]{message, new Integer(143)});
       this.add(ST.class, false, 1, 6, new Object[]{message});
       this.add(ST.class, false, 1, 6, new Object[]{message});
       this.add(ID.class, false, 1, 1, new Object[]{message, new Integer(144)});
       this.add(CM_RMC.class, false, 0, 25, new Object[]{message});
       this.add(CM_PTA.class, false, 0, 25, new Object[]{message});
       this.add(CM_DDI.class, false, 1, 25, new Object[]{message});
    } catch (HL7Exception he) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Can't instantiate " + this.getClass().getName(), he);
    }
  }

  /**
   * Returns Insured's employee ID (IN2-1).
   */
  public ST getInsuredSEmployeeID()  {
    ST ret = null;
    try {
        Type t = this.getField(1, 0);
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
   * Returns Insured's social security number (IN2-2).
   */
  public ST getInsuredSSocialSecurityNumber()  {
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
   * Returns Insured's employer name (IN2-3).
   */
  public CN getInsuredSEmployerName()  {
    CN ret = null;
    try {
        Type t = this.getField(3, 0);
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
   * Returns Employer information data (IN2-4).
   */
  public ID getEmployerInformationData()  {
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
   * Returns Mail claim party (IN2-5).
   */
  public ID getMailClaimParty()  {
    ID ret = null;
    try {
        Type t = this.getField(5, 0);
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
   * Returns Medicare health insurance card number (IN2-6).
   */
  public NM getMedicareHealthInsuranceCardNumber()  {
    NM ret = null;
    try {
        Type t = this.getField(6, 0);
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
   * Returns Medicaid case name (IN2-7).
   */
  public PN getMedicaidCaseName()  {
    PN ret = null;
    try {
        Type t = this.getField(7, 0);
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
   * Returns Medicaid case number (IN2-8).
   */
  public NM getMedicaidCaseNumber()  {
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
   * Returns Champus sponsor name (IN2-9).
   */
  public PN getChampusSponsorName()  {
    PN ret = null;
    try {
        Type t = this.getField(9, 0);
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
   * Returns Champus ID number (IN2-10).
   */
  public NM getChampusIDNumber()  {
    NM ret = null;
    try {
        Type t = this.getField(10, 0);
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
   * Returns Dependent of champus recipient (IN2-11).
   */
  public ID getDependentOfChampusRecipient()  {
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
   * Returns Champus organization (IN2-12).
   */
  public ST getChampusOrganization()  {
    ST ret = null;
    try {
        Type t = this.getField(12, 0);
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
   * Returns Champus station (IN2-13).
   */
  public ST getChampusStation()  {
    ST ret = null;
    try {
        Type t = this.getField(13, 0);
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
   * Returns Champus service (IN2-14).
   */
  public ID getChampusService()  {
    ID ret = null;
    try {
        Type t = this.getField(14, 0);
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
   * Returns Champus rank / grade (IN2-15).
   */
  public ID getChampusRankGrade()  {
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
   * Returns Champus status (IN2-16).
   */
  public ID getChampusStatus()  {
    ID ret = null;
    try {
        Type t = this.getField(16, 0);
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
   * Returns Champus retire date (IN2-17).
   */
  public DT getChampusRetireDate()  {
    DT ret = null;
    try {
        Type t = this.getField(17, 0);
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
   * Returns Champus non-availability certification on file (IN2-18).
   */
  public ID getChampusNonAvailabilityCertificationOnFile()  {
    ID ret = null;
    try {
        Type t = this.getField(18, 0);
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
   * Returns Baby coverage (IN2-19).
   */
  public ID getBabyCoverage()  {
    ID ret = null;
    try {
        Type t = this.getField(19, 0);
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
   * Returns Combine baby bill (IN2-20).
   */
  public ID getCombineBabyBill()  {
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
   * Returns Blood deductible (IN2-21).
   */
  public NM getBloodDeductible()  {
    NM ret = null;
    try {
        Type t = this.getField(21, 0);
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
   * Returns Special coverage approval name (IN2-22).
   */
  public PN getSpecialCoverageApprovalName()  {
    PN ret = null;
    try {
        Type t = this.getField(22, 0);
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
   * Returns Special coverage approval title (IN2-23).
   */
  public ST getSpecialCoverageApprovalTitle()  {
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
   * Returns a single repetition of Non-covered insurance code (IN2-24).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public ID getNonCoveredInsuranceCode(int rep) throws HL7Exception {
    ID ret = null;
    try {
        Type t = this.getField(24, rep);
        ret = (ID)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    }
    return ret;
  }

  /**
   * Returns all repetitions of Non-covered insurance code (IN2-24).
   */
  public ID[] getNonCoveredInsuranceCode() {
     ID[] ret = null;
    try {
        Type[] t = this.getField(24);  
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
   * Returns Payor ID (IN2-25).
   */
  public ST getPayorID()  {
    ST ret = null;
    try {
        Type t = this.getField(25, 0);
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
   * Returns Payor subscriber ID (IN2-26).
   */
  public ST getPayorSubscriberID()  {
    ST ret = null;
    try {
        Type t = this.getField(26, 0);
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
   * Returns Eligibility source (IN2-27).
   */
  public ID getEligibilitySource()  {
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
   * Returns a single repetition of Room coverage type / amount (IN2-28).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public CM_RMC getRoomCoverageTypeAmount(int rep) throws HL7Exception {
    CM_RMC ret = null;
    try {
        Type t = this.getField(28, rep);
        ret = (CM_RMC)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    }
    return ret;
  }

  /**
   * Returns all repetitions of Room coverage type / amount (IN2-28).
   */
  public CM_RMC[] getRoomCoverageTypeAmount() {
     CM_RMC[] ret = null;
    try {
        Type[] t = this.getField(28);  
        ret = new CM_RMC[t.length];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = (CM_RMC)t[i];
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
   * Returns a single repetition of Policy type / amount (IN2-29).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public CM_PTA getPolicyTypeAmount(int rep) throws HL7Exception {
    CM_PTA ret = null;
    try {
        Type t = this.getField(29, rep);
        ret = (CM_PTA)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    }
    return ret;
  }

  /**
   * Returns all repetitions of Policy type / amount (IN2-29).
   */
  public CM_PTA[] getPolicyTypeAmount() {
     CM_PTA[] ret = null;
    try {
        Type[] t = this.getField(29);  
        ret = new CM_PTA[t.length];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = (CM_PTA)t[i];
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
   * Returns Daily deductible (IN2-30).
   */
  public CM_DDI getDailyDeductible()  {
    CM_DDI ret = null;
    try {
        Type t = this.getField(30, 0);
        ret = (CM_DDI)t;
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