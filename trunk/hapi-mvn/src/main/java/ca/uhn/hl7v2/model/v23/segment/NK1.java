package ca.uhn.hl7v2.model.v23.segment;

import ca.uhn.hl7v2.model.*;
import ca.uhn.hl7v2.model.v23.datatype.*;

import ca.uhn.log.HapiLogFactory;
import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.HL7Exception;

/**
 * <p>Represents an HL7 NK1 message segment. 
 * This segment has the following fields:</p><p>
 * NK1-1: Set ID - Next of Kin (SI)<br> 
 * NK1-2: NK Name (XPN)<br> 
 * NK1-3: Relationship (CE)<br> 
 * NK1-4: Address (XAD)<br> 
 * NK1-5: Phone Number (XTN)<br> 
 * NK1-6: Business Phone Number (XTN)<br> 
 * NK1-7: Contact Role (CE)<br> 
 * NK1-8: Start Date (DT)<br> 
 * NK1-9: End Date (DT)<br> 
 * NK1-10: Next of Kin/Associated Parties Job Title (ST)<br> 
 * NK1-11: Next of Kin Job/Associated Parties Code/Class (JCC)<br> 
 * NK1-12: Next of Kin/Associated Parties Employee Number (CX)<br> 
 * NK1-13: Organization Name (XON)<br> 
 * NK1-14: Marital Status (IS)<br> 
 * NK1-15: Sex (IS)<br> 
 * NK1-16: Date of Birth (TS)<br> 
 * NK1-17: Living Dependency (IS)<br> 
 * NK1-18: Ambulatory Status (IS)<br> 
 * NK1-19: Citizenship (IS)<br> 
 * NK1-20: Primary Language (CE)<br> 
 * NK1-21: Living Arrangement (IS)<br> 
 * NK1-22: Publicity Indicator (CE)<br> 
 * NK1-23: Protection Indicator (ID)<br> 
 * NK1-24: Student Indicator (IS)<br> 
 * NK1-25: Religion (IS)<br> 
 * NK1-26: Mother’s Maiden Name (XPN)<br> 
 * NK1-27: Nationality Code (CE)<br> 
 * NK1-28: Ethnic Group (IS)<br> 
 * NK1-29: Contact Reason (CE)<br> 
 * NK1-30: Contact Person's Name (XPN)<br> 
 * NK1-31: Contact Person’s Telephone Number (XTN)<br> 
 * NK1-32: Contact Person’s Address (XAD)<br> 
 * NK1-33: Associated Party’s Identifiers (CX)<br> 
 * NK1-34: Job Status (IS)<br> 
 * NK1-35: Race (IS)<br> 
 * NK1-36: Handicap (IS)<br> 
 * NK1-37: Contact Person Social Security Number (ST)<br> 
 * </p><p>The get...() methods return data from individual fields.  These methods 
 * do not throw exceptions and may therefore have to handle exceptions internally.  
 * If an exception is handled internally, it is logged and null is returned.  
 * This is not expected to happen - if it does happen this indicates not so much 
 * an exceptional circumstance as a bug in the code for this class.</p>    
 */
public class NK1 extends AbstractSegment  {

  /**
   * Creates a NK1 (Next of kin) segment object that belongs to the given 
   * message.  
   */
  public NK1(Group parent, ModelClassFactory factory) {
    super(parent, factory);
    Message message = getMessage();
    try {
       this.add(SI.class, true, 1, 4, new Object[]{message});
       this.add(XPN.class, false, 0, 48, new Object[]{message});
       this.add(CE.class, false, 1, 60, new Object[]{message});
       this.add(XAD.class, false, 0, 106, new Object[]{message});
       this.add(XTN.class, false, 0, 40, new Object[]{message});
       this.add(XTN.class, false, 0, 40, new Object[]{message});
       this.add(CE.class, true, 1, 60, new Object[]{message});
       this.add(DT.class, false, 1, 8, new Object[]{message});
       this.add(DT.class, false, 1, 8, new Object[]{message});
       this.add(ST.class, false, 1, 60, new Object[]{message});
       this.add(JCC.class, false, 1, 20, new Object[]{message});
       this.add(CX.class, false, 1, 20, new Object[]{message});
       this.add(XON.class, false, 0, 60, new Object[]{message});
       this.add(IS.class, false, 0, 1, new Object[]{message, new Integer(2)});
       this.add(IS.class, false, 1, 1, new Object[]{message, new Integer(1)});
       this.add(TS.class, false, 1, 26, new Object[]{message});
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
       this.add(CE.class, false, 1, 2, new Object[]{message});
       this.add(XPN.class, false, 0, 48, new Object[]{message});
       this.add(XTN.class, false, 0, 40, new Object[]{message});
       this.add(XAD.class, false, 0, 106, new Object[]{message});
       this.add(CX.class, false, 0, 32, new Object[]{message});
       this.add(IS.class, false, 1, 2, new Object[]{message, new Integer(311)});
       this.add(IS.class, false, 1, 1, new Object[]{message, new Integer(5)});
       this.add(IS.class, false, 1, 2, new Object[]{message, new Integer(310)});
       this.add(ST.class, false, 1, 16, new Object[]{message});
    } catch (HL7Exception he) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Can't instantiate " + this.getClass().getName(), he);
    }
  }

  /**
   * Returns Set ID - Next of Kin (NK1-1).
   */
  public SI getSetIDNextOfKin()  {
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
   * Returns a single repetition of NK Name (NK1-2).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public XPN getNKName(int rep) throws HL7Exception {
    XPN ret = null;
    try {
        Type t = this.getField(2, rep);
        ret = (XPN)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    }
    return ret;
  }

  /**
   * Returns all repetitions of NK Name (NK1-2).
   */
  public XPN[] getNKName() {
     XPN[] ret = null;
    try {
        Type[] t = this.getField(2);  
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
   * Returns Relationship (NK1-3).
   */
  public CE getRelationship()  {
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
   * Returns a single repetition of Address (NK1-4).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public XAD getAddress(int rep) throws HL7Exception {
    XAD ret = null;
    try {
        Type t = this.getField(4, rep);
        ret = (XAD)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    }
    return ret;
  }

  /**
   * Returns all repetitions of Address (NK1-4).
   */
  public XAD[] getAddress() {
     XAD[] ret = null;
    try {
        Type[] t = this.getField(4);  
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
   * Returns a single repetition of Phone Number (NK1-5).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public XTN getPhoneNumber(int rep) throws HL7Exception {
    XTN ret = null;
    try {
        Type t = this.getField(5, rep);
        ret = (XTN)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    }
    return ret;
  }

  /**
   * Returns all repetitions of Phone Number (NK1-5).
   */
  public XTN[] getPhoneNumber() {
     XTN[] ret = null;
    try {
        Type[] t = this.getField(5);  
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
   * Returns a single repetition of Business Phone Number (NK1-6).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public XTN getBusinessPhoneNumber(int rep) throws HL7Exception {
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
   * Returns all repetitions of Business Phone Number (NK1-6).
   */
  public XTN[] getBusinessPhoneNumber() {
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
   * Returns Contact Role (NK1-7).
   */
  public CE getContactRole()  {
    CE ret = null;
    try {
        Type t = this.getField(7, 0);
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
   * Returns Start Date (NK1-8).
   */
  public DT getStartDate()  {
    DT ret = null;
    try {
        Type t = this.getField(8, 0);
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
   * Returns End Date (NK1-9).
   */
  public DT getEndDate()  {
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
   * Returns Next of Kin/Associated Parties Job Title (NK1-10).
   */
  public ST getNextOfKinAssociatedPartiesJobTitle()  {
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
   * Returns Next of Kin Job/Associated Parties Code/Class (NK1-11).
   */
  public JCC getNextOfKinJobAssociatedPartiesCodeClass()  {
    JCC ret = null;
    try {
        Type t = this.getField(11, 0);
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
   * Returns Next of Kin/Associated Parties Employee Number (NK1-12).
   */
  public CX getNextOfKinAssociatedPartiesEmployeeNumber()  {
    CX ret = null;
    try {
        Type t = this.getField(12, 0);
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
   * Returns a single repetition of Organization Name (NK1-13).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public XON getOrganizationName(int rep) throws HL7Exception {
    XON ret = null;
    try {
        Type t = this.getField(13, rep);
        ret = (XON)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    }
    return ret;
  }

  /**
   * Returns all repetitions of Organization Name (NK1-13).
   */
  public XON[] getOrganizationName() {
     XON[] ret = null;
    try {
        Type[] t = this.getField(13);  
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
   * Returns a single repetition of Marital Status (NK1-14).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public IS getMaritalStatus(int rep) throws HL7Exception {
    IS ret = null;
    try {
        Type t = this.getField(14, rep);
        ret = (IS)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    }
    return ret;
  }

  /**
   * Returns all repetitions of Marital Status (NK1-14).
   */
  public IS[] getMaritalStatus() {
     IS[] ret = null;
    try {
        Type[] t = this.getField(14);  
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
   * Returns Sex (NK1-15).
   */
  public IS getSex()  {
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
   * Returns Date of Birth (NK1-16).
   */
  public TS getDateOfBirth()  {
    TS ret = null;
    try {
        Type t = this.getField(16, 0);
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
   * Returns Living Dependency (NK1-17).
   */
  public IS getLivingDependency()  {
    IS ret = null;
    try {
        Type t = this.getField(17, 0);
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
   * Returns Ambulatory Status (NK1-18).
   */
  public IS getAmbulatoryStatus()  {
    IS ret = null;
    try {
        Type t = this.getField(18, 0);
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
   * Returns Citizenship (NK1-19).
   */
  public IS getCitizenship()  {
    IS ret = null;
    try {
        Type t = this.getField(19, 0);
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
   * Returns Primary Language (NK1-20).
   */
  public CE getPrimaryLanguage()  {
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
   * Returns Living Arrangement (NK1-21).
   */
  public IS getLivingArrangement()  {
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
   * Returns Publicity Indicator (NK1-22).
   */
  public CE getPublicityIndicator()  {
    CE ret = null;
    try {
        Type t = this.getField(22, 0);
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
   * Returns Protection Indicator (NK1-23).
   */
  public ID getProtectionIndicator()  {
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
   * Returns Student Indicator (NK1-24).
   */
  public IS getStudentIndicator()  {
    IS ret = null;
    try {
        Type t = this.getField(24, 0);
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
   * Returns Religion (NK1-25).
   */
  public IS getReligion()  {
    IS ret = null;
    try {
        Type t = this.getField(25, 0);
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
   * Returns Mother’s Maiden Name (NK1-26).
   */
  public XPN getMotherSMaidenName()  {
    XPN ret = null;
    try {
        Type t = this.getField(26, 0);
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
   * Returns Nationality Code (NK1-27).
   */
  public CE getNationalityCode()  {
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
   * Returns Ethnic Group (NK1-28).
   */
  public IS getEthnicGroup()  {
    IS ret = null;
    try {
        Type t = this.getField(28, 0);
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
   * Returns Contact Reason (NK1-29).
   */
  public CE getContactReason()  {
    CE ret = null;
    try {
        Type t = this.getField(29, 0);
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
   * Returns a single repetition of Contact Person's Name (NK1-30).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public XPN getContactPersonSName(int rep) throws HL7Exception {
    XPN ret = null;
    try {
        Type t = this.getField(30, rep);
        ret = (XPN)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    }
    return ret;
  }

  /**
   * Returns all repetitions of Contact Person's Name (NK1-30).
   */
  public XPN[] getContactPersonSName() {
     XPN[] ret = null;
    try {
        Type[] t = this.getField(30);  
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
   * Returns a single repetition of Contact Person’s Telephone Number (NK1-31).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public XTN getContactPersonSTelephoneNumber(int rep) throws HL7Exception {
    XTN ret = null;
    try {
        Type t = this.getField(31, rep);
        ret = (XTN)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    }
    return ret;
  }

  /**
   * Returns all repetitions of Contact Person’s Telephone Number (NK1-31).
   */
  public XTN[] getContactPersonSTelephoneNumber() {
     XTN[] ret = null;
    try {
        Type[] t = this.getField(31);  
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
   * Returns a single repetition of Contact Person’s Address (NK1-32).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public XAD getContactPersonSAddress(int rep) throws HL7Exception {
    XAD ret = null;
    try {
        Type t = this.getField(32, rep);
        ret = (XAD)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    }
    return ret;
  }

  /**
   * Returns all repetitions of Contact Person’s Address (NK1-32).
   */
  public XAD[] getContactPersonSAddress() {
     XAD[] ret = null;
    try {
        Type[] t = this.getField(32);  
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
   * Returns a single repetition of Associated Party’s Identifiers (NK1-33).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public CX getAssociatedPartySIdentifiers(int rep) throws HL7Exception {
    CX ret = null;
    try {
        Type t = this.getField(33, rep);
        ret = (CX)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    }
    return ret;
  }

  /**
   * Returns all repetitions of Associated Party’s Identifiers (NK1-33).
   */
  public CX[] getAssociatedPartySIdentifiers() {
     CX[] ret = null;
    try {
        Type[] t = this.getField(33);  
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
   * Returns Job Status (NK1-34).
   */
  public IS getJobStatus()  {
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
   * Returns Race (NK1-35).
   */
  public IS getRace()  {
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
   * Returns Handicap (NK1-36).
   */
  public IS getHandicap()  {
    IS ret = null;
    try {
        Type t = this.getField(36, 0);
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
   * Returns Contact Person Social Security Number (NK1-37).
   */
  public ST getContactPersonSocialSecurityNumber()  {
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

}