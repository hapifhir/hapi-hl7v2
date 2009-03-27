package ca.uhn.hl7v2.model.v23.segment;

import ca.uhn.hl7v2.model.*;
import ca.uhn.hl7v2.model.v23.datatype.*;

import ca.uhn.log.HapiLogFactory;
import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.HL7Exception;

/**
 * <p>Represents an HL7 GT1 message segment. 
 * This segment has the following fields:</p><p>
 * GT1-1: Set ID - Guarantor (SI)<br> 
 * GT1-2: Guarantor Number (CX)<br> 
 * GT1-3: Guarantor Name (XPN)<br> 
 * GT1-4: Guarantor Spouse Name (XPN)<br> 
 * GT1-5: Guarantor Address (XAD)<br> 
 * GT1-6: Guarantor Ph Num- Home (XTN)<br> 
 * GT1-7: Guarantor Ph Num-Business (XTN)<br> 
 * GT1-8: Guarantor Date/Time of Birth (TS)<br> 
 * GT1-9: Guarantor Sex (IS)<br> 
 * GT1-10: Guarantor Type (IS)<br> 
 * GT1-11: Guarantor Relationship (IS)<br> 
 * GT1-12: Guarantor SSN (ST)<br> 
 * GT1-13: Guarantor Date - Begin (DT)<br> 
 * GT1-14: Guarantor Date - End (DT)<br> 
 * GT1-15: Guarantor Priority (NM)<br> 
 * GT1-16: Guarantor Employer Name (XPN)<br> 
 * GT1-17: Guarantor Employer Address (XAD)<br> 
 * GT1-18: Guarantor Employ Phone Number (XTN)<br> 
 * GT1-19: Guarantor Employee ID Number (CX)<br> 
 * GT1-20: Guarantor Employment Status (IS)<br> 
 * GT1-21: Guarantor Organization (XON)<br> 
 * GT1-22: Guarantor Billing Hold Flag (ID)<br> 
 * GT1-23: Guarantor Credit Rating Code (CE)<br> 
 * GT1-24: Guarantor Death Date And Time (TS)<br> 
 * GT1-25: Guarantor Death Flag (ID)<br> 
 * GT1-26: Guarantor Charge Adjustment Code (CE)<br> 
 * GT1-27: Guarantor Household Annual Income (CP)<br> 
 * GT1-28: Guarantor Household Size (NM)<br> 
 * GT1-29: Guarantor Employer ID Number (CX)<br> 
 * GT1-30: Guarantor Marital Status Code (IS)<br> 
 * GT1-31: Guarantor Hire Effective Date (DT)<br> 
 * GT1-32: Employment Stop Date (DT)<br> 
 * GT1-33: Living Dependency (IS)<br> 
 * GT1-34: Ambulatory Status (IS)<br> 
 * GT1-35: Citizenship (IS)<br> 
 * GT1-36: Primary Language (CE)<br> 
 * GT1-37: Living Arrangement (IS)<br> 
 * GT1-38: Publicity Indicator (CE)<br> 
 * GT1-39: Protection Indicator (ID)<br> 
 * GT1-40: Student Indicator (IS)<br> 
 * GT1-41: Religion (IS)<br> 
 * GT1-42: Mother’s Maiden Name (XPN)<br> 
 * GT1-43: Nationality Code (CE)<br> 
 * GT1-44: Ethnic Group (IS)<br> 
 * GT1-45: Contact Person's Name (XPN)<br> 
 * GT1-46: Contact Person’s Telephone Number (XTN)<br> 
 * GT1-47: Contact Reason (CE)<br> 
 * GT1-48: Contact Relationship Code (IS)<br> 
 * GT1-49: Job Title (ST)<br> 
 * GT1-50: Job Code/Class (JCC)<br> 
 * GT1-51: Guarantor Employer's Organization Name (XON)<br> 
 * GT1-52: Handicap (IS)<br> 
 * GT1-53: Job Status (IS)<br> 
 * GT1-54: Guarantor Financial Class (FC)<br> 
 * GT1-55: Guarantor Race (IS)<br> 
 * </p><p>The get...() methods return data from individual fields.  These methods 
 * do not throw exceptions and may therefore have to handle exceptions internally.  
 * If an exception is handled internally, it is logged and null is returned.  
 * This is not expected to happen - if it does happen this indicates not so much 
 * an exceptional circumstance as a bug in the code for this class.</p>    
 */
public class GT1 extends AbstractSegment  {

  /**
   * Creates a GT1 (Guarantor) segment object that belongs to the given 
   * message.  
   */
  public GT1(Group parent, ModelClassFactory factory) {
    super(parent, factory);
    Message message = getMessage();
    try {
       this.add(SI.class, true, 1, 4, new Object[]{message});
       this.add(CX.class, false, 0, 59, new Object[]{message});
       this.add(XPN.class, true, 0, 48, new Object[]{message});
       this.add(XPN.class, false, 0, 48, new Object[]{message});
       this.add(XAD.class, false, 0, 106, new Object[]{message});
       this.add(XTN.class, false, 0, 40, new Object[]{message});
       this.add(XTN.class, false, 0, 40, new Object[]{message});
       this.add(TS.class, false, 1, 26, new Object[]{message});
       this.add(IS.class, false, 1, 1, new Object[]{message, new Integer(1)});
       this.add(IS.class, false, 1, 2, new Object[]{message, new Integer(68)});
       this.add(IS.class, false, 1, 2, new Object[]{message, new Integer(63)});
       this.add(ST.class, false, 1, 11, new Object[]{message});
       this.add(DT.class, false, 1, 8, new Object[]{message});
       this.add(DT.class, false, 1, 8, new Object[]{message});
       this.add(NM.class, false, 1, 2, new Object[]{message});
       this.add(XPN.class, false, 0, 130, new Object[]{message});
       this.add(XAD.class, false, 0, 106, new Object[]{message});
       this.add(XTN.class, false, 0, 40, new Object[]{message});
       this.add(CX.class, false, 0, 20, new Object[]{message});
       this.add(IS.class, false, 1, 2, new Object[]{message, new Integer(66)});
       this.add(XON.class, false, 0, 130, new Object[]{message});
       this.add(ID.class, false, 1, 1, new Object[]{message, new Integer(136)});
       this.add(CE.class, false, 1, 80, new Object[]{message});
       this.add(TS.class, false, 1, 26, new Object[]{message});
       this.add(ID.class, false, 1, 1, new Object[]{message, new Integer(136)});
       this.add(CE.class, false, 1, 80, new Object[]{message});
       this.add(CP.class, false, 1, 10, new Object[]{message});
       this.add(NM.class, false, 1, 3, new Object[]{message});
       this.add(CX.class, false, 0, 20, new Object[]{message});
       this.add(IS.class, false, 1, 1, new Object[]{message, new Integer(0)});
       this.add(DT.class, false, 1, 8, new Object[]{message});
       this.add(DT.class, false, 1, 8, new Object[]{message});
       this.add(IS.class, false, 1, 2, new Object[]{message, new Integer(223)});
       this.add(IS.class, false, 1, 2, new Object[]{message, new Integer(9)});
       this.add(IS.class, false, 1, 4, new Object[]{message, new Integer(171)});
       this.add(CE.class, false, 1, 60, new Object[]{message});
       this.add(IS.class, false, 1, 2, new Object[]{message, new Integer(220)});
       this.add(CE.class, false, 1, 1, new Object[]{message});
       this.add(ID.class, false, 1, 1, new Object[]{message, new Integer(136)});
       this.add(IS.class, false, 1, 2, new Object[]{message, new Integer(231)});
       this.add(IS.class, false, 1, 3, new Object[]{message, new Integer(6)});
       this.add(XPN.class, false, 1, 48, new Object[]{message});
       this.add(CE.class, false, 1, 80, new Object[]{message});
       this.add(IS.class, false, 1, 1, new Object[]{message, new Integer(189)});
       this.add(XPN.class, false, 0, 48, new Object[]{message});
       this.add(XTN.class, false, 0, 40, new Object[]{message});
       this.add(CE.class, false, 1, 2, new Object[]{message});
       this.add(IS.class, false, 1, 2, new Object[]{message, new Integer(63)});
       this.add(ST.class, false, 1, 20, new Object[]{message});
       this.add(JCC.class, false, 1, 20, new Object[]{message});
       this.add(XON.class, false, 0, 130, new Object[]{message});
       this.add(IS.class, false, 1, 2, new Object[]{message, new Integer(310)});
       this.add(IS.class, false, 1, 2, new Object[]{message, new Integer(311)});
       this.add(FC.class, false, 1, 50, new Object[]{message});
       this.add(IS.class, false, 1, 1, new Object[]{message, new Integer(5)});
    } catch (HL7Exception he) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Can't instantiate " + this.getClass().getName(), he);
    }
  }

  /**
   * Returns Set ID - Guarantor (GT1-1).
   */
  public SI getSetIDGuarantor()  {
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
   * Returns a single repetition of Guarantor Number (GT1-2).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public CX getGuarantorNumber(int rep) throws HL7Exception {
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
   * Returns all repetitions of Guarantor Number (GT1-2).
   */
  public CX[] getGuarantorNumber() {
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
   * Returns a single repetition of Guarantor Name (GT1-3).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public XPN getGuarantorName(int rep) throws HL7Exception {
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
   * Returns all repetitions of Guarantor Name (GT1-3).
   */
  public XPN[] getGuarantorName() {
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
   * Returns a single repetition of Guarantor Spouse Name (GT1-4).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public XPN getGuarantorSpouseName(int rep) throws HL7Exception {
    XPN ret = null;
    try {
        Type t = this.getField(4, rep);
        ret = (XPN)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    }
    return ret;
  }

  /**
   * Returns all repetitions of Guarantor Spouse Name (GT1-4).
   */
  public XPN[] getGuarantorSpouseName() {
     XPN[] ret = null;
    try {
        Type[] t = this.getField(4);  
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
   * Returns a single repetition of Guarantor Address (GT1-5).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public XAD getGuarantorAddress(int rep) throws HL7Exception {
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
   * Returns all repetitions of Guarantor Address (GT1-5).
   */
  public XAD[] getGuarantorAddress() {
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
   * Returns a single repetition of Guarantor Ph Num- Home (GT1-6).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public XTN getGuarantorPhNumHome(int rep) throws HL7Exception {
    XTN ret = null;
    try {
        Type t = this.getField(6, rep);
        ret = (XTN)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    }
    return ret;
  }

  /**
   * Returns all repetitions of Guarantor Ph Num- Home (GT1-6).
   */
  public XTN[] getGuarantorPhNumHome() {
     XTN[] ret = null;
    try {
        Type[] t = this.getField(6);  
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
   * Returns a single repetition of Guarantor Ph Num-Business (GT1-7).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public XTN getGuarantorPhNumBusiness(int rep) throws HL7Exception {
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
   * Returns all repetitions of Guarantor Ph Num-Business (GT1-7).
   */
  public XTN[] getGuarantorPhNumBusiness() {
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
   * Returns Guarantor Date/Time of Birth (GT1-8).
   */
  public TS getGuarantorDateTimeOfBirth()  {
    TS ret = null;
    try {
        Type t = this.getField(8, 0);
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
   * Returns Guarantor Sex (GT1-9).
   */
  public IS getGuarantorSex()  {
    IS ret = null;
    try {
        Type t = this.getField(9, 0);
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
   * Returns Guarantor Type (GT1-10).
   */
  public IS getGuarantorType()  {
    IS ret = null;
    try {
        Type t = this.getField(10, 0);
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
   * Returns Guarantor Relationship (GT1-11).
   */
  public IS getGuarantorRelationship()  {
    IS ret = null;
    try {
        Type t = this.getField(11, 0);
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
   * Returns Guarantor SSN (GT1-12).
   */
  public ST getGuarantorSSN()  {
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
   * Returns Guarantor Date - Begin (GT1-13).
   */
  public DT getGuarantorDateBegin()  {
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
   * Returns Guarantor Date - End (GT1-14).
   */
  public DT getGuarantorDateEnd()  {
    DT ret = null;
    try {
        Type t = this.getField(14, 0);
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
   * Returns Guarantor Priority (GT1-15).
   */
  public NM getGuarantorPriority()  {
    NM ret = null;
    try {
        Type t = this.getField(15, 0);
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
   * Returns a single repetition of Guarantor Employer Name (GT1-16).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public XPN getGuarantorEmployerName(int rep) throws HL7Exception {
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
   * Returns all repetitions of Guarantor Employer Name (GT1-16).
   */
  public XPN[] getGuarantorEmployerName() {
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
   * Returns a single repetition of Guarantor Employer Address (GT1-17).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public XAD getGuarantorEmployerAddress(int rep) throws HL7Exception {
    XAD ret = null;
    try {
        Type t = this.getField(17, rep);
        ret = (XAD)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    }
    return ret;
  }

  /**
   * Returns all repetitions of Guarantor Employer Address (GT1-17).
   */
  public XAD[] getGuarantorEmployerAddress() {
     XAD[] ret = null;
    try {
        Type[] t = this.getField(17);  
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
   * Returns a single repetition of Guarantor Employ Phone Number (GT1-18).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public XTN getGuarantorEmployPhoneNumber(int rep) throws HL7Exception {
    XTN ret = null;
    try {
        Type t = this.getField(18, rep);
        ret = (XTN)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    }
    return ret;
  }

  /**
   * Returns all repetitions of Guarantor Employ Phone Number (GT1-18).
   */
  public XTN[] getGuarantorEmployPhoneNumber() {
     XTN[] ret = null;
    try {
        Type[] t = this.getField(18);  
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
   * Returns a single repetition of Guarantor Employee ID Number (GT1-19).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public CX getGuarantorEmployeeIDNumber(int rep) throws HL7Exception {
    CX ret = null;
    try {
        Type t = this.getField(19, rep);
        ret = (CX)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    }
    return ret;
  }

  /**
   * Returns all repetitions of Guarantor Employee ID Number (GT1-19).
   */
  public CX[] getGuarantorEmployeeIDNumber() {
     CX[] ret = null;
    try {
        Type[] t = this.getField(19);  
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
   * Returns Guarantor Employment Status (GT1-20).
   */
  public IS getGuarantorEmploymentStatus()  {
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
   * Returns a single repetition of Guarantor Organization (GT1-21).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public XON getGuarantorOrganization(int rep) throws HL7Exception {
    XON ret = null;
    try {
        Type t = this.getField(21, rep);
        ret = (XON)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    }
    return ret;
  }

  /**
   * Returns all repetitions of Guarantor Organization (GT1-21).
   */
  public XON[] getGuarantorOrganization() {
     XON[] ret = null;
    try {
        Type[] t = this.getField(21);  
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
   * Returns Guarantor Billing Hold Flag (GT1-22).
   */
  public ID getGuarantorBillingHoldFlag()  {
    ID ret = null;
    try {
        Type t = this.getField(22, 0);
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
   * Returns Guarantor Credit Rating Code (GT1-23).
   */
  public CE getGuarantorCreditRatingCode()  {
    CE ret = null;
    try {
        Type t = this.getField(23, 0);
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
   * Returns Guarantor Death Date And Time (GT1-24).
   */
  public TS getGuarantorDeathDateAndTime()  {
    TS ret = null;
    try {
        Type t = this.getField(24, 0);
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
   * Returns Guarantor Death Flag (GT1-25).
   */
  public ID getGuarantorDeathFlag()  {
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
   * Returns Guarantor Charge Adjustment Code (GT1-26).
   */
  public CE getGuarantorChargeAdjustmentCode()  {
    CE ret = null;
    try {
        Type t = this.getField(26, 0);
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
   * Returns Guarantor Household Annual Income (GT1-27).
   */
  public CP getGuarantorHouseholdAnnualIncome()  {
    CP ret = null;
    try {
        Type t = this.getField(27, 0);
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
   * Returns Guarantor Household Size (GT1-28).
   */
  public NM getGuarantorHouseholdSize()  {
    NM ret = null;
    try {
        Type t = this.getField(28, 0);
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
   * Returns a single repetition of Guarantor Employer ID Number (GT1-29).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public CX getGuarantorEmployerIDNumber(int rep) throws HL7Exception {
    CX ret = null;
    try {
        Type t = this.getField(29, rep);
        ret = (CX)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    }
    return ret;
  }

  /**
   * Returns all repetitions of Guarantor Employer ID Number (GT1-29).
   */
  public CX[] getGuarantorEmployerIDNumber() {
     CX[] ret = null;
    try {
        Type[] t = this.getField(29);  
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
   * Returns Guarantor Marital Status Code (GT1-30).
   */
  public IS getGuarantorMaritalStatusCode()  {
    IS ret = null;
    try {
        Type t = this.getField(30, 0);
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
   * Returns Guarantor Hire Effective Date (GT1-31).
   */
  public DT getGuarantorHireEffectiveDate()  {
    DT ret = null;
    try {
        Type t = this.getField(31, 0);
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
   * Returns Employment Stop Date (GT1-32).
   */
  public DT getEmploymentStopDate()  {
    DT ret = null;
    try {
        Type t = this.getField(32, 0);
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
   * Returns Living Dependency (GT1-33).
   */
  public IS getLivingDependency()  {
    IS ret = null;
    try {
        Type t = this.getField(33, 0);
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
   * Returns Ambulatory Status (GT1-34).
   */
  public IS getAmbulatoryStatus()  {
    IS ret = null;
    try {
        Type t = this.getField(34, 0);
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
   * Returns Citizenship (GT1-35).
   */
  public IS getCitizenship()  {
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
   * Returns Primary Language (GT1-36).
   */
  public CE getPrimaryLanguage()  {
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
   * Returns Living Arrangement (GT1-37).
   */
  public IS getLivingArrangement()  {
    IS ret = null;
    try {
        Type t = this.getField(37, 0);
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
   * Returns Publicity Indicator (GT1-38).
   */
  public CE getPublicityIndicator()  {
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
   * Returns Protection Indicator (GT1-39).
   */
  public ID getProtectionIndicator()  {
    ID ret = null;
    try {
        Type t = this.getField(39, 0);
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
   * Returns Student Indicator (GT1-40).
   */
  public IS getStudentIndicator()  {
    IS ret = null;
    try {
        Type t = this.getField(40, 0);
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
   * Returns Religion (GT1-41).
   */
  public IS getReligion()  {
    IS ret = null;
    try {
        Type t = this.getField(41, 0);
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
   * Returns Mother’s Maiden Name (GT1-42).
   */
  public XPN getMotherSMaidenName()  {
    XPN ret = null;
    try {
        Type t = this.getField(42, 0);
        ret = (XPN)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    } catch (HL7Exception he) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", he);
        throw new RuntimeException(he);
    }
    return ret;
  }

  /**
   * Returns Nationality Code (GT1-43).
   */
  public CE getNationalityCode()  {
    CE ret = null;
    try {
        Type t = this.getField(43, 0);
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
   * Returns Ethnic Group (GT1-44).
   */
  public IS getEthnicGroup()  {
    IS ret = null;
    try {
        Type t = this.getField(44, 0);
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
   * Returns a single repetition of Contact Person's Name (GT1-45).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public XPN getContactPersonSName(int rep) throws HL7Exception {
    XPN ret = null;
    try {
        Type t = this.getField(45, rep);
        ret = (XPN)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    }
    return ret;
  }

  /**
   * Returns all repetitions of Contact Person's Name (GT1-45).
   */
  public XPN[] getContactPersonSName() {
     XPN[] ret = null;
    try {
        Type[] t = this.getField(45);  
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
   * Returns a single repetition of Contact Person’s Telephone Number (GT1-46).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public XTN getContactPersonSTelephoneNumber(int rep) throws HL7Exception {
    XTN ret = null;
    try {
        Type t = this.getField(46, rep);
        ret = (XTN)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    }
    return ret;
  }

  /**
   * Returns all repetitions of Contact Person’s Telephone Number (GT1-46).
   */
  public XTN[] getContactPersonSTelephoneNumber() {
     XTN[] ret = null;
    try {
        Type[] t = this.getField(46);  
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
   * Returns Contact Reason (GT1-47).
   */
  public CE getContactReason()  {
    CE ret = null;
    try {
        Type t = this.getField(47, 0);
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
   * Returns Contact Relationship Code (GT1-48).
   */
  public IS getContactRelationshipCode()  {
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
   * Returns Job Title (GT1-49).
   */
  public ST getJobTitle()  {
    ST ret = null;
    try {
        Type t = this.getField(49, 0);
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
   * Returns Job Code/Class (GT1-50).
   */
  public JCC getJobCodeClass()  {
    JCC ret = null;
    try {
        Type t = this.getField(50, 0);
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
   * Returns a single repetition of Guarantor Employer's Organization Name (GT1-51).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public XON getGuarantorEmployerSOrganizationName(int rep) throws HL7Exception {
    XON ret = null;
    try {
        Type t = this.getField(51, rep);
        ret = (XON)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    }
    return ret;
  }

  /**
   * Returns all repetitions of Guarantor Employer's Organization Name (GT1-51).
   */
  public XON[] getGuarantorEmployerSOrganizationName() {
     XON[] ret = null;
    try {
        Type[] t = this.getField(51);  
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
   * Returns Handicap (GT1-52).
   */
  public IS getHandicap()  {
    IS ret = null;
    try {
        Type t = this.getField(52, 0);
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
   * Returns Job Status (GT1-53).
   */
  public IS getJobStatus()  {
    IS ret = null;
    try {
        Type t = this.getField(53, 0);
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
   * Returns Guarantor Financial Class (GT1-54).
   */
  public FC getGuarantorFinancialClass()  {
    FC ret = null;
    try {
        Type t = this.getField(54, 0);
        ret = (FC)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    } catch (HL7Exception he) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", he);
        throw new RuntimeException(he);
    }
    return ret;
  }

  /**
   * Returns Guarantor Race (GT1-55).
   */
  public IS getGuarantorRace()  {
    IS ret = null;
    try {
        Type t = this.getField(55, 0);
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

}