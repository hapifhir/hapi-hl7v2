package ca.uhn.hl7v2.model.v21.segment;

import ca.uhn.hl7v2.model.*;
import ca.uhn.hl7v2.model.v21.datatype.*;

import ca.uhn.log.HapiLogFactory;
import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.HL7Exception;

/**
 * <p>Represents an HL7 IN1 message segment. 
 * This segment has the following fields:</p><p>
 * IN1-1: SET ID - INSURANCE (SI)<br> 
 * IN1-2: INSURANCE PLAN ID (ID)<br> 
 * IN1-3: INSURANCE COMPANY ID (ST)<br> 
 * IN1-4: INSURANCE COMPANY NAME (ST)<br> 
 * IN1-5: INSURANCE COMPANY ADDRESS (AD)<br> 
 * IN1-6: INSURANCE CO. CONTACT PERS (PN)<br> 
 * IN1-7: INSURANCE CO PHONE NUMBER (TN)<br> 
 * IN1-8: GROUP NUMBER (ST)<br> 
 * IN1-9: GROUP NAME (ST)<br> 
 * IN1-10: INSURED'S GROUP EMP. ID (ST)<br> 
 * IN1-11: INSURED'S GROUP EMP. NAME (ST)<br> 
 * IN1-12: PLAN EFFECTIVE DATE (DT)<br> 
 * IN1-13: PLAN EXPIRATION DATE (DT)<br> 
 * IN1-14: AUTHORIZATION INFORMATION (ST)<br> 
 * IN1-15: PLAN TYPE (ID)<br> 
 * IN1-16: NAME OF INSURED (PN)<br> 
 * IN1-17: INSURED'S RELATIONSHIP TO PATIENT (ID)<br> 
 * IN1-18: INSURED'S DATE OF BIRTH (DT)<br> 
 * IN1-19: INSURED'S ADDRESS (AD)<br> 
 * IN1-20: ASSIGNMENT OF BENEFITS (ID)<br> 
 * IN1-21: COORDINATION OF BENEFITS (ID)<br> 
 * IN1-22: COORD OF BEN. PRIORITY (ST)<br> 
 * IN1-23: NOTICE OF ADMISSION CODE (ID)<br> 
 * IN1-24: NOTICE OF ADMISSION DATE (DT)<br> 
 * IN1-25: RPT OF ELIGIBILITY CODE (ID)<br> 
 * IN1-26: RPT OF ELIGIBILITY DATE (DT)<br> 
 * IN1-27: RELEASE INFORMATION CODE (ID)<br> 
 * IN1-28: PRE-ADMIT CERT. (PAC) (ST)<br> 
 * IN1-29: VERIFICATION DATE (DT)<br> 
 * IN1-30: VERIFICATION BY (CM)<br> 
 * IN1-31: TYPE OF AGREEMENT CODE (ID)<br> 
 * IN1-32: BILLING STATUS (ID)<br> 
 * IN1-33: LIFETIME RESERVE DAYS (NM)<br> 
 * IN1-34: DELAY BEFORE L. R. DAY (NM)<br> 
 * IN1-35: COMPANY PLAN CODE (ST)<br> 
 * IN1-36: POLICY NUMBER (ST)<br> 
 * IN1-37: POLICY DEDUCTIBLE (NM)<br> 
 * IN1-38: POLICY LIMIT - AMOUNT (NM)<br> 
 * IN1-39: POLICY LIMIT - DAYS (NM)<br> 
 * IN1-40: ROOM RATE - SEMI-PRIVATE (NM)<br> 
 * IN1-41: ROOM RATE - PRIVATE (NM)<br> 
 * IN1-42: INSURED'S EMPLOYMENT STATUS (ID)<br> 
 * IN1-43: INSURED'S SEX (ID)<br> 
 * IN1-44: INSURED'S EMPLOYER ADDRESS (AD)<br> 
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
       this.add(ST.class, true, 1, 6, new Object[]{message});
       this.add(ST.class, false, 1, 45, new Object[]{message});
       this.add(AD.class, false, 1, 106, new Object[]{message});
       this.add(PN.class, false, 1, 48, new Object[]{message});
       this.add(TN.class, false, 1, 40, new Object[]{message});
       this.add(ST.class, false, 1, 12, new Object[]{message});
       this.add(ST.class, false, 1, 35, new Object[]{message});
       this.add(ST.class, false, 1, 12, new Object[]{message});
       this.add(ST.class, false, 1, 45, new Object[]{message});
       this.add(DT.class, false, 1, 8, new Object[]{message});
       this.add(DT.class, false, 1, 8, new Object[]{message});
       this.add(ST.class, false, 1, 55, new Object[]{message});
       this.add(ID.class, false, 1, 2, new Object[]{message, new Integer(86)});
       this.add(PN.class, false, 1, 48, new Object[]{message});
       this.add(ID.class, false, 1, 2, new Object[]{message, new Integer(63)});
       this.add(DT.class, false, 1, 8, new Object[]{message});
       this.add(AD.class, false, 1, 106, new Object[]{message});
       this.add(ID.class, false, 1, 2, new Object[]{message, new Integer(0)});
       this.add(ID.class, false, 1, 2, new Object[]{message, new Integer(0)});
       this.add(ST.class, false, 1, 2, new Object[]{message});
       this.add(ID.class, false, 1, 2, new Object[]{message, new Integer(81)});
       this.add(DT.class, false, 1, 8, new Object[]{message});
       this.add(ID.class, false, 1, 2, new Object[]{message, new Integer(94)});
       this.add(DT.class, false, 1, 8, new Object[]{message});
       this.add(ID.class, false, 1, 2, new Object[]{message, new Integer(93)});
       this.add(ST.class, false, 1, 15, new Object[]{message});
       this.add(DT.class, false, 1, 8, new Object[]{message});
       this.add(CM.class, false, 1, 60, new Object[]{message});
       this.add(ID.class, false, 1, 2, new Object[]{message, new Integer(98)});
       this.add(ID.class, false, 1, 2, new Object[]{message, new Integer(22)});
       this.add(NM.class, false, 1, 4, new Object[]{message});
       this.add(NM.class, false, 1, 4, new Object[]{message});
       this.add(ST.class, false, 1, 8, new Object[]{message});
       this.add(ST.class, false, 1, 15, new Object[]{message});
       this.add(NM.class, false, 1, 12, new Object[]{message});
       this.add(NM.class, false, 1, 12, new Object[]{message});
       this.add(NM.class, false, 1, 4, new Object[]{message});
       this.add(NM.class, false, 1, 12, new Object[]{message});
       this.add(NM.class, false, 1, 12, new Object[]{message});
       this.add(ID.class, false, 1, 1, new Object[]{message, new Integer(66)});
       this.add(ID.class, false, 1, 1, new Object[]{message, new Integer(1)});
       this.add(AD.class, false, 1, 106, new Object[]{message});
    } catch (HL7Exception he) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Can't instantiate " + this.getClass().getName(), he);
    }
  }

  /**
   * Returns SET ID - INSURANCE (IN1-1).
   */
  public SI getSETIDINSURANCE()  {
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
   * Returns INSURANCE PLAN ID (IN1-2).
   */
  public ID getINSURANCEPLANID()  {
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
   * Returns INSURANCE COMPANY ID (IN1-3).
   */
  public ST getINSURANCECOMPANYID()  {
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
   * Returns INSURANCE COMPANY NAME (IN1-4).
   */
  public ST getINSURANCECOMPANYNAME()  {
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
   * Returns INSURANCE COMPANY ADDRESS (IN1-5).
   */
  public AD getINSURANCECOMPANYADDRESS()  {
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
   * Returns INSURANCE CO. CONTACT PERS (IN1-6).
   */
  public PN getINSURANCECOCONTACTPERS()  {
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
   * Returns INSURANCE CO PHONE NUMBER (IN1-7).
   */
  public TN getINSURANCECOPHONENUMBER()  {
    TN ret = null;
    try {
        Type t = this.getField(7, 0);
        ret = (TN)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    } catch (HL7Exception he) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", he);
        throw new RuntimeException(he);
    }
    return ret;
  }

  /**
   * Returns GROUP NUMBER (IN1-8).
   */
  public ST getGROUPNUMBER()  {
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
   * Returns GROUP NAME (IN1-9).
   */
  public ST getGROUPNAME()  {
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
   * Returns INSURED'S GROUP EMP. ID (IN1-10).
   */
  public ST getINSUREDSGROUPEMPID()  {
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
   * Returns INSURED'S GROUP EMP. NAME (IN1-11).
   */
  public ST getINSUREDSGROUPEMPNAME()  {
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
   * Returns PLAN EFFECTIVE DATE (IN1-12).
   */
  public DT getPLANEFFECTIVEDATE()  {
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
   * Returns PLAN EXPIRATION DATE (IN1-13).
   */
  public DT getPLANEXPIRATIONDATE()  {
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
   * Returns AUTHORIZATION INFORMATION (IN1-14).
   */
  public ST getAUTHORIZATIONINFORMATION()  {
    ST ret = null;
    try {
        Type t = this.getField(14, 0);
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
   * Returns PLAN TYPE (IN1-15).
   */
  public ID getPLANTYPE()  {
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
   * Returns NAME OF INSURED (IN1-16).
   */
  public PN getNAMEOFINSURED()  {
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
   * Returns INSURED'S RELATIONSHIP TO PATIENT (IN1-17).
   */
  public ID getINSUREDSRELATIONSHIPTOPATIENT()  {
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
   * Returns INSURED'S DATE OF BIRTH (IN1-18).
   */
  public DT getINSUREDSDATEOFBIRTH()  {
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
   * Returns INSURED'S ADDRESS (IN1-19).
   */
  public AD getINSUREDSADDRESS()  {
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
   * Returns ASSIGNMENT OF BENEFITS (IN1-20).
   */
  public ID getASSIGNMENTOFBENEFITS()  {
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
   * Returns COORDINATION OF BENEFITS (IN1-21).
   */
  public ID getCOORDINATIONOFBENEFITS()  {
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
   * Returns COORD OF BEN. PRIORITY (IN1-22).
   */
  public ST getCOORDOFBENPRIORITY()  {
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
   * Returns NOTICE OF ADMISSION CODE (IN1-23).
   */
  public ID getNOTICEOFADMISSIONCODE()  {
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
   * Returns NOTICE OF ADMISSION DATE (IN1-24).
   */
  public DT getNOTICEOFADMISSIONDATE()  {
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
   * Returns RPT OF ELIGIBILITY CODE (IN1-25).
   */
  public ID getRPTOFELIGIBILITYCODE()  {
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
   * Returns RPT OF ELIGIBILITY DATE (IN1-26).
   */
  public DT getRPTOFELIGIBILITYDATE()  {
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
   * Returns RELEASE INFORMATION CODE (IN1-27).
   */
  public ID getRELEASEINFORMATIONCODE()  {
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
   * Returns PRE-ADMIT CERT. (PAC) (IN1-28).
   */
  public ST getPREADMITCERT()  {
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
   * Returns VERIFICATION DATE (IN1-29).
   */
  public DT getVERIFICATIONDATE()  {
    DT ret = null;
    try {
        Type t = this.getField(29, 0);
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
   * Returns VERIFICATION BY (IN1-30).
   */
  public CM getVERIFICATIONBY()  {
    CM ret = null;
    try {
        Type t = this.getField(30, 0);
        ret = (CM)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    } catch (HL7Exception he) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", he);
        throw new RuntimeException(he);
    }
    return ret;
  }

  /**
   * Returns TYPE OF AGREEMENT CODE (IN1-31).
   */
  public ID getTYPEOFAGREEMENTCODE()  {
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
   * Returns BILLING STATUS (IN1-32).
   */
  public ID getBILLINGSTATUS()  {
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
   * Returns LIFETIME RESERVE DAYS (IN1-33).
   */
  public NM getLIFETIMERESERVEDAYS()  {
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
   * Returns DELAY BEFORE L. R. DAY (IN1-34).
   */
  public NM getDELAYBEFORELRDAY()  {
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
   * Returns COMPANY PLAN CODE (IN1-35).
   */
  public ST getCOMPANYPLANCODE()  {
    ST ret = null;
    try {
        Type t = this.getField(35, 0);
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
   * Returns POLICY NUMBER (IN1-36).
   */
  public ST getPOLICYNUMBER()  {
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
   * Returns POLICY DEDUCTIBLE (IN1-37).
   */
  public NM getPOLICYDEDUCTIBLE()  {
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
   * Returns POLICY LIMIT - AMOUNT (IN1-38).
   */
  public NM getPOLICYLIMITAMOUNT()  {
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
   * Returns POLICY LIMIT - DAYS (IN1-39).
   */
  public NM getPOLICYLIMITDAYS()  {
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
   * Returns ROOM RATE - SEMI-PRIVATE (IN1-40).
   */
  public NM getROOMRATESEMIPRIVATE()  {
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
   * Returns ROOM RATE - PRIVATE (IN1-41).
   */
  public NM getROOMRATEPRIVATE()  {
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
   * Returns INSURED'S EMPLOYMENT STATUS (IN1-42).
   */
  public ID getINSUREDSEMPLOYMENTSTATUS()  {
    ID ret = null;
    try {
        Type t = this.getField(42, 0);
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
   * Returns INSURED'S SEX (IN1-43).
   */
  public ID getINSUREDSSEX()  {
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
   * Returns INSURED'S EMPLOYER ADDRESS (IN1-44).
   */
  public AD getINSUREDSEMPLOYERADDRESS()  {
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

}