package ca.uhn.hl7v2.model.v231.segment;

import ca.uhn.hl7v2.model.*;
import ca.uhn.hl7v2.model.v231.datatype.*;

import ca.uhn.log.HapiLogFactory;
import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.HL7Exception;

/**
 * <p>Represents an HL7 ORC message segment. 
 * This segment has the following fields:</p><p>
 * ORC-1: Order Control (ID)<br> 
 * ORC-2: Placer Order Number (EI)<br> 
 * ORC-3: Filler Order Number (EI)<br> 
 * ORC-4: Placer Group Number (EI)<br> 
 * ORC-5: Order Status (ID)<br> 
 * ORC-6: Response Flag (ID)<br> 
 * ORC-7: Quantity/Timing (TQ)<br> 
 * ORC-8: Parent Order (EIP)<br> 
 * ORC-9: Date/Time of Transaction (TS)<br> 
 * ORC-10: Entered By (XCN)<br> 
 * ORC-11: Verified By (XCN)<br> 
 * ORC-12: Ordering Provider (XCN)<br> 
 * ORC-13: Enterer’s Location (PL)<br> 
 * ORC-14: Call Back Phone Number (XTN)<br> 
 * ORC-15: Order Effective Date/Time (TS)<br> 
 * ORC-16: Order Control Code Reason (CE)<br> 
 * ORC-17: Entering Organization (CE)<br> 
 * ORC-18: Entering Device (CE)<br> 
 * ORC-19: Action By (XCN)<br> 
 * ORC-20: Advanced Beneficiary Notice Code (CE)<br> 
 * ORC-21: Ordering Facility Name (XON)<br> 
 * ORC-22: Ordering Facility Address (XAD)<br> 
 * ORC-23: Ordering Facility Phone Number (XTN)<br> 
 * ORC-24: Ordering Provider Address (XAD)<br> 
 * </p><p>The get...() methods return data from individual fields.  These methods 
 * do not throw exceptions and may therefore have to handle exceptions internally.  
 * If an exception is handled internally, it is logged and null is returned.  
 * This is not expected to happen - if it does happen this indicates not so much 
 * an exceptional circumstance as a bug in the code for this class.</p>    
 */
public class ORC extends AbstractSegment  {

  /**
   * Creates a ORC (ORC - common order segment) segment object that belongs to the given 
   * message.  
   */
  public ORC(Group parent, ModelClassFactory factory) {
    super(parent, factory);
    Message message = getMessage();
    try {
       this.add(ID.class, false, 1, 2, new Object[]{message, new Integer(119)});
       this.add(EI.class, false, 1, 22, new Object[]{message});
       this.add(EI.class, false, 1, 22, new Object[]{message});
       this.add(EI.class, false, 1, 22, new Object[]{message});
       this.add(ID.class, false, 1, 2, new Object[]{message, new Integer(38)});
       this.add(ID.class, false, 1, 1, new Object[]{message, new Integer(121)});
       this.add(TQ.class, false, 1, 200, new Object[]{message});
       this.add(EIP.class, false, 1, 200, new Object[]{message});
       this.add(TS.class, false, 1, 26, new Object[]{message});
       this.add(XCN.class, false, 0, 120, new Object[]{message});
       this.add(XCN.class, false, 0, 120, new Object[]{message});
       this.add(XCN.class, false, 0, 120, new Object[]{message});
       this.add(PL.class, false, 1, 80, new Object[]{message});
       this.add(XTN.class, false, 2, 40, new Object[]{message});
       this.add(TS.class, false, 1, 26, new Object[]{message});
       this.add(CE.class, false, 1, 200, new Object[]{message});
       this.add(CE.class, false, 1, 60, new Object[]{message});
       this.add(CE.class, false, 1, 60, new Object[]{message});
       this.add(XCN.class, false, 0, 120, new Object[]{message});
       this.add(CE.class, false, 1, 40, new Object[]{message});
       this.add(XON.class, false, 0, 60, new Object[]{message});
       this.add(XAD.class, false, 0, 106, new Object[]{message});
       this.add(XTN.class, false, 0, 48, new Object[]{message});
       this.add(XAD.class, false, 0, 106, new Object[]{message});
    } catch (HL7Exception he) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Can't instantiate " + this.getClass().getName(), he);
    }
  }

  /**
   * Returns Order Control (ORC-1).
   */
  public ID getOrderControl()  {
    ID ret = null;
    try {
        Type t = this.getField(1, 0);
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
   * Returns Placer Order Number (ORC-2).
   */
  public EI getPlacerOrderNumber()  {
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
   * Returns Filler Order Number (ORC-3).
   */
  public EI getFillerOrderNumber()  {
    EI ret = null;
    try {
        Type t = this.getField(3, 0);
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
   * Returns Placer Group Number (ORC-4).
   */
  public EI getPlacerGroupNumber()  {
    EI ret = null;
    try {
        Type t = this.getField(4, 0);
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
   * Returns Order Status (ORC-5).
   */
  public ID getOrderStatus()  {
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
   * Returns Response Flag (ORC-6).
   */
  public ID getResponseFlag()  {
    ID ret = null;
    try {
        Type t = this.getField(6, 0);
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
   * Returns Quantity/Timing (ORC-7).
   */
  public TQ getQuantityTiming()  {
    TQ ret = null;
    try {
        Type t = this.getField(7, 0);
        ret = (TQ)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    } catch (HL7Exception he) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", he);
        throw new RuntimeException(he);
    }
    return ret;
  }

  /**
   * Returns Parent Order (ORC-8).
   */
  public EIP getParentOrder()  {
    EIP ret = null;
    try {
        Type t = this.getField(8, 0);
        ret = (EIP)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    } catch (HL7Exception he) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", he);
        throw new RuntimeException(he);
    }
    return ret;
  }

  /**
   * Returns Date/Time of Transaction (ORC-9).
   */
  public TS getDateTimeOfTransaction()  {
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
   * Returns a single repetition of Entered By (ORC-10).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public XCN getEnteredBy(int rep) throws HL7Exception {
    XCN ret = null;
    try {
        Type t = this.getField(10, rep);
        ret = (XCN)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    }
    return ret;
  }

  /**
   * Returns all repetitions of Entered By (ORC-10).
   */
  public XCN[] getEnteredBy() {
     XCN[] ret = null;
    try {
        Type[] t = this.getField(10);  
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
   * Returns a single repetition of Verified By (ORC-11).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public XCN getVerifiedBy(int rep) throws HL7Exception {
    XCN ret = null;
    try {
        Type t = this.getField(11, rep);
        ret = (XCN)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    }
    return ret;
  }

  /**
   * Returns all repetitions of Verified By (ORC-11).
   */
  public XCN[] getVerifiedBy() {
     XCN[] ret = null;
    try {
        Type[] t = this.getField(11);  
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
   * Returns a single repetition of Ordering Provider (ORC-12).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public XCN getOrderingProvider(int rep) throws HL7Exception {
    XCN ret = null;
    try {
        Type t = this.getField(12, rep);
        ret = (XCN)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    }
    return ret;
  }

  /**
   * Returns all repetitions of Ordering Provider (ORC-12).
   */
  public XCN[] getOrderingProvider() {
     XCN[] ret = null;
    try {
        Type[] t = this.getField(12);  
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
   * Returns Enterer’s Location (ORC-13).
   */
  public PL getEntererSLocation()  {
    PL ret = null;
    try {
        Type t = this.getField(13, 0);
        ret = (PL)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    } catch (HL7Exception he) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", he);
        throw new RuntimeException(he);
    }
    return ret;
  }

  /**
   * Returns a single repetition of Call Back Phone Number (ORC-14).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public XTN getCallBackPhoneNumber(int rep) throws HL7Exception {
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
   * Returns all repetitions of Call Back Phone Number (ORC-14).
   */
  public XTN[] getCallBackPhoneNumber() {
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
   * Returns Order Effective Date/Time (ORC-15).
   */
  public TS getOrderEffectiveDateTime()  {
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
   * Returns Order Control Code Reason (ORC-16).
   */
  public CE getOrderControlCodeReason()  {
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
   * Returns Entering Organization (ORC-17).
   */
  public CE getEnteringOrganization()  {
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
   * Returns Entering Device (ORC-18).
   */
  public CE getEnteringDevice()  {
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
   * Returns a single repetition of Action By (ORC-19).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public XCN getActionBy(int rep) throws HL7Exception {
    XCN ret = null;
    try {
        Type t = this.getField(19, rep);
        ret = (XCN)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    }
    return ret;
  }

  /**
   * Returns all repetitions of Action By (ORC-19).
   */
  public XCN[] getActionBy() {
     XCN[] ret = null;
    try {
        Type[] t = this.getField(19);  
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
   * Returns Advanced Beneficiary Notice Code (ORC-20).
   */
  public CE getAdvancedBeneficiaryNoticeCode()  {
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
   * Returns a single repetition of Ordering Facility Name (ORC-21).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public XON getOrderingFacilityName(int rep) throws HL7Exception {
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
   * Returns all repetitions of Ordering Facility Name (ORC-21).
   */
  public XON[] getOrderingFacilityName() {
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
   * Returns a single repetition of Ordering Facility Address (ORC-22).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public XAD getOrderingFacilityAddress(int rep) throws HL7Exception {
    XAD ret = null;
    try {
        Type t = this.getField(22, rep);
        ret = (XAD)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    }
    return ret;
  }

  /**
   * Returns all repetitions of Ordering Facility Address (ORC-22).
   */
  public XAD[] getOrderingFacilityAddress() {
     XAD[] ret = null;
    try {
        Type[] t = this.getField(22);  
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
   * Returns a single repetition of Ordering Facility Phone Number (ORC-23).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public XTN getOrderingFacilityPhoneNumber(int rep) throws HL7Exception {
    XTN ret = null;
    try {
        Type t = this.getField(23, rep);
        ret = (XTN)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    }
    return ret;
  }

  /**
   * Returns all repetitions of Ordering Facility Phone Number (ORC-23).
   */
  public XTN[] getOrderingFacilityPhoneNumber() {
     XTN[] ret = null;
    try {
        Type[] t = this.getField(23);  
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
   * Returns a single repetition of Ordering Provider Address (ORC-24).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public XAD getOrderingProviderAddress(int rep) throws HL7Exception {
    XAD ret = null;
    try {
        Type t = this.getField(24, rep);
        ret = (XAD)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    }
    return ret;
  }

  /**
   * Returns all repetitions of Ordering Provider Address (ORC-24).
   */
  public XAD[] getOrderingProviderAddress() {
     XAD[] ret = null;
    try {
        Type[] t = this.getField(24);  
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

}