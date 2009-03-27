package ca.uhn.hl7v2.model.v231.segment;

import ca.uhn.hl7v2.model.*;
import ca.uhn.hl7v2.model.v231.datatype.*;

import ca.uhn.log.HapiLogFactory;
import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.HL7Exception;

/**
 * <p>Represents an HL7 RXO message segment. 
 * This segment has the following fields:</p><p>
 * RXO-1: Requested Give Code (CE)<br> 
 * RXO-2: Requested Give Amount - Minimum (NM)<br> 
 * RXO-3: Requested Give Amount - Maximum (NM)<br> 
 * RXO-4: Requested Give Units (CE)<br> 
 * RXO-5: Requested Dosage Form (CE)<br> 
 * RXO-6: Provider’s Pharmacy/Treatment Instructions (CE)<br> 
 * RXO-7: Provider’s Administration Instructions (CE)<br> 
 * RXO-8: Deliver-to Location (LA1)<br> 
 * RXO-9: Allow Substitutions (ID)<br> 
 * RXO-10: Requested Dispense Code (CE)<br> 
 * RXO-11: Requested Dispense Amount (NM)<br> 
 * RXO-12: Requested Dispense Units (CE)<br> 
 * RXO-13: Number Of Refills (NM)<br> 
 * RXO-14: Ordering Provider’s DEA Number (XCN)<br> 
 * RXO-15: Pharmacist/Treatment Supplier’s Verifier ID (XCN)<br> 
 * RXO-16: Needs Human Review (ID)<br> 
 * RXO-17: Requested Give Per (Time Unit) (ST)<br> 
 * RXO-18: Requested Give Strength (NM)<br> 
 * RXO-19: Requested Give Strength Units (CE)<br> 
 * RXO-20: Indication (CE)<br> 
 * RXO-21: Requested Give Rate Amount (ST)<br> 
 * RXO-22: Requested Give Rate Units (CE)<br> 
 * RXO-23: Total Daily Dose (CQ)<br> 
 * </p><p>The get...() methods return data from individual fields.  These methods 
 * do not throw exceptions and may therefore have to handle exceptions internally.  
 * If an exception is handled internally, it is logged and null is returned.  
 * This is not expected to happen - if it does happen this indicates not so much 
 * an exceptional circumstance as a bug in the code for this class.</p>    
 */
public class RXO extends AbstractSegment  {

  /**
   * Creates a RXO (RXO - pharmacy/treatment order segment) segment object that belongs to the given 
   * message.  
   */
  public RXO(Group parent, ModelClassFactory factory) {
    super(parent, factory);
    Message message = getMessage();
    try {
       this.add(CE.class, false, 1, 100, new Object[]{message});
       this.add(NM.class, false, 1, 20, new Object[]{message});
       this.add(NM.class, false, 1, 20, new Object[]{message});
       this.add(CE.class, false, 1, 60, new Object[]{message});
       this.add(CE.class, false, 1, 60, new Object[]{message});
       this.add(CE.class, false, 0, 200, new Object[]{message});
       this.add(CE.class, false, 0, 200, new Object[]{message});
       this.add(LA1.class, false, 1, 200, new Object[]{message});
       this.add(ID.class, false, 1, 1, new Object[]{message, new Integer(161)});
       this.add(CE.class, false, 1, 100, new Object[]{message});
       this.add(NM.class, false, 1, 20, new Object[]{message});
       this.add(CE.class, false, 1, 60, new Object[]{message});
       this.add(NM.class, false, 1, 3, new Object[]{message});
       this.add(XCN.class, false, 0, 60, new Object[]{message});
       this.add(XCN.class, false, 0, 60, new Object[]{message});
       this.add(ID.class, false, 1, 1, new Object[]{message, new Integer(136)});
       this.add(ST.class, false, 1, 20, new Object[]{message});
       this.add(NM.class, false, 1, 20, new Object[]{message});
       this.add(CE.class, false, 1, 60, new Object[]{message});
       this.add(CE.class, false, 0, 200, new Object[]{message});
       this.add(ST.class, false, 1, 6, new Object[]{message});
       this.add(CE.class, false, 1, 60, new Object[]{message});
       this.add(CQ.class, false, 1, 10, new Object[]{message});
    } catch (HL7Exception he) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Can't instantiate " + this.getClass().getName(), he);
    }
  }

  /**
   * Returns Requested Give Code (RXO-1).
   */
  public CE getRequestedGiveCode()  {
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
   * Returns Requested Give Amount - Minimum (RXO-2).
   */
  public NM getRequestedGiveAmountMinimum()  {
    NM ret = null;
    try {
        Type t = this.getField(2, 0);
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
   * Returns Requested Give Amount - Maximum (RXO-3).
   */
  public NM getRequestedGiveAmountMaximum()  {
    NM ret = null;
    try {
        Type t = this.getField(3, 0);
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
   * Returns Requested Give Units (RXO-4).
   */
  public CE getRequestedGiveUnits()  {
    CE ret = null;
    try {
        Type t = this.getField(4, 0);
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
   * Returns Requested Dosage Form (RXO-5).
   */
  public CE getRequestedDosageForm()  {
    CE ret = null;
    try {
        Type t = this.getField(5, 0);
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
   * Returns a single repetition of Provider’s Pharmacy/Treatment Instructions (RXO-6).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public CE getProviderSPharmacyTreatmentInstructions(int rep) throws HL7Exception {
    CE ret = null;
    try {
        Type t = this.getField(6, rep);
        ret = (CE)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    }
    return ret;
  }

  /**
   * Returns all repetitions of Provider’s Pharmacy/Treatment Instructions (RXO-6).
   */
  public CE[] getProviderSPharmacyTreatmentInstructions() {
     CE[] ret = null;
    try {
        Type[] t = this.getField(6);  
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
   * Returns a single repetition of Provider’s Administration Instructions (RXO-7).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public CE getProviderSAdministrationInstructions(int rep) throws HL7Exception {
    CE ret = null;
    try {
        Type t = this.getField(7, rep);
        ret = (CE)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    }
    return ret;
  }

  /**
   * Returns all repetitions of Provider’s Administration Instructions (RXO-7).
   */
  public CE[] getProviderSAdministrationInstructions() {
     CE[] ret = null;
    try {
        Type[] t = this.getField(7);  
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
   * Returns Deliver-to Location (RXO-8).
   */
  public LA1 getDeliverToLocation()  {
    LA1 ret = null;
    try {
        Type t = this.getField(8, 0);
        ret = (LA1)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    } catch (HL7Exception he) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", he);
        throw new RuntimeException(he);
    }
    return ret;
  }

  /**
   * Returns Allow Substitutions (RXO-9).
   */
  public ID getAllowSubstitutions()  {
    ID ret = null;
    try {
        Type t = this.getField(9, 0);
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
   * Returns Requested Dispense Code (RXO-10).
   */
  public CE getRequestedDispenseCode()  {
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
   * Returns Requested Dispense Amount (RXO-11).
   */
  public NM getRequestedDispenseAmount()  {
    NM ret = null;
    try {
        Type t = this.getField(11, 0);
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
   * Returns Requested Dispense Units (RXO-12).
   */
  public CE getRequestedDispenseUnits()  {
    CE ret = null;
    try {
        Type t = this.getField(12, 0);
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
   * Returns Number Of Refills (RXO-13).
   */
  public NM getNumberOfRefills()  {
    NM ret = null;
    try {
        Type t = this.getField(13, 0);
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
   * Returns a single repetition of Ordering Provider’s DEA Number (RXO-14).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public XCN getOrderingProviderSDEANumber(int rep) throws HL7Exception {
    XCN ret = null;
    try {
        Type t = this.getField(14, rep);
        ret = (XCN)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    }
    return ret;
  }

  /**
   * Returns all repetitions of Ordering Provider’s DEA Number (RXO-14).
   */
  public XCN[] getOrderingProviderSDEANumber() {
     XCN[] ret = null;
    try {
        Type[] t = this.getField(14);  
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
   * Returns a single repetition of Pharmacist/Treatment Supplier’s Verifier ID (RXO-15).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public XCN getPharmacistTreatmentSupplierSVerifierID(int rep) throws HL7Exception {
    XCN ret = null;
    try {
        Type t = this.getField(15, rep);
        ret = (XCN)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    }
    return ret;
  }

  /**
   * Returns all repetitions of Pharmacist/Treatment Supplier’s Verifier ID (RXO-15).
   */
  public XCN[] getPharmacistTreatmentSupplierSVerifierID() {
     XCN[] ret = null;
    try {
        Type[] t = this.getField(15);  
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
   * Returns Needs Human Review (RXO-16).
   */
  public ID getNeedsHumanReview()  {
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
   * Returns Requested Give Per (Time Unit) (RXO-17).
   */
  public ST getRequestedGivePerTimeUnit()  {
    ST ret = null;
    try {
        Type t = this.getField(17, 0);
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
   * Returns Requested Give Strength (RXO-18).
   */
  public NM getRequestedGiveStrength()  {
    NM ret = null;
    try {
        Type t = this.getField(18, 0);
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
   * Returns Requested Give Strength Units (RXO-19).
   */
  public CE getRequestedGiveStrengthUnits()  {
    CE ret = null;
    try {
        Type t = this.getField(19, 0);
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
   * Returns a single repetition of Indication (RXO-20).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public CE getIndication(int rep) throws HL7Exception {
    CE ret = null;
    try {
        Type t = this.getField(20, rep);
        ret = (CE)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    }
    return ret;
  }

  /**
   * Returns all repetitions of Indication (RXO-20).
   */
  public CE[] getIndication() {
     CE[] ret = null;
    try {
        Type[] t = this.getField(20);  
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
   * Returns Requested Give Rate Amount (RXO-21).
   */
  public ST getRequestedGiveRateAmount()  {
    ST ret = null;
    try {
        Type t = this.getField(21, 0);
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
   * Returns Requested Give Rate Units (RXO-22).
   */
  public CE getRequestedGiveRateUnits()  {
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
   * Returns Total Daily Dose (RXO-23).
   */
  public CQ getTotalDailyDose()  {
    CQ ret = null;
    try {
        Type t = this.getField(23, 0);
        ret = (CQ)t;
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