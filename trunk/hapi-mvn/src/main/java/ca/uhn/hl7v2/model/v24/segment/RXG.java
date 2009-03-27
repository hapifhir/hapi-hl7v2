package ca.uhn.hl7v2.model.v24.segment;

import ca.uhn.hl7v2.model.*;
import ca.uhn.hl7v2.model.v24.datatype.*;

import ca.uhn.log.HapiLogFactory;
import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.HL7Exception;

/**
 * <p>Represents an HL7 RXG message segment. 
 * This segment has the following fields:</p><p>
 * RXG-1: Give Sub-ID Counter (NM)<br> 
 * RXG-2: Dispense Sub-ID Counter (NM)<br> 
 * RXG-3: Quantity/Timing (TQ)<br> 
 * RXG-4: Give Code (CE)<br> 
 * RXG-5: Give Amount - Minimum (NM)<br> 
 * RXG-6: Give Amount - Maximum (NM)<br> 
 * RXG-7: Give Units (CE)<br> 
 * RXG-8: Give Dosage Form (CE)<br> 
 * RXG-9: Administration Notes (CE)<br> 
 * RXG-10: Substitution Status (ID)<br> 
 * RXG-11: Dispense-To Location (LA2)<br> 
 * RXG-12: Needs Human Review (ID)<br> 
 * RXG-13: Pharmacy/Treatment Supplier's Special Administration Instructions (CE)<br> 
 * RXG-14: Give Per (Time Unit) (ST)<br> 
 * RXG-15: Give Rate Amount (ST)<br> 
 * RXG-16: Give Rate Units (CE)<br> 
 * RXG-17: Give Strength (NM)<br> 
 * RXG-18: Give Strength Units (CE)<br> 
 * RXG-19: Substance Lot Number (ST)<br> 
 * RXG-20: Substance Expiration Date (TS)<br> 
 * RXG-21: Substance Manufacturer Name (CE)<br> 
 * RXG-22: Indication (CE)<br> 
 * </p><p>The get...() methods return data from individual fields.  These methods 
 * do not throw exceptions and may therefore have to handle exceptions internally.  
 * If an exception is handled internally, it is logged and null is returned.  
 * This is not expected to happen - if it does happen this indicates not so much 
 * an exceptional circumstance as a bug in the code for this class.</p>    
 */
public class RXG extends AbstractSegment  {

  /**
   * Creates a RXG (Pharmacy/Treatment Give) segment object that belongs to the given 
   * message.  
   */
  public RXG(Group parent, ModelClassFactory factory) {
    super(parent, factory);
    Message message = getMessage();
    try {
       this.add(NM.class, true, 1, 4, new Object[]{message});
       this.add(NM.class, false, 1, 4, new Object[]{message});
       this.add(TQ.class, true, 1, 200, new Object[]{message});
       this.add(CE.class, true, 1, 250, new Object[]{message});
       this.add(NM.class, true, 1, 20, new Object[]{message});
       this.add(NM.class, false, 1, 20, new Object[]{message});
       this.add(CE.class, true, 1, 250, new Object[]{message});
       this.add(CE.class, false, 1, 250, new Object[]{message});
       this.add(CE.class, false, 0, 250, new Object[]{message});
       this.add(ID.class, false, 1, 1, new Object[]{message, new Integer(167)});
       this.add(LA2.class, false, 1, 200, new Object[]{message});
       this.add(ID.class, false, 1, 1, new Object[]{message, new Integer(136)});
       this.add(CE.class, false, 0, 250, new Object[]{message});
       this.add(ST.class, false, 1, 20, new Object[]{message});
       this.add(ST.class, false, 1, 6, new Object[]{message});
       this.add(CE.class, false, 1, 250, new Object[]{message});
       this.add(NM.class, false, 1, 20, new Object[]{message});
       this.add(CE.class, false, 1, 250, new Object[]{message});
       this.add(ST.class, false, 0, 20, new Object[]{message});
       this.add(TS.class, false, 0, 26, new Object[]{message});
       this.add(CE.class, false, 0, 250, new Object[]{message});
       this.add(CE.class, false, 0, 250, new Object[]{message});
    } catch (HL7Exception he) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Can't instantiate " + this.getClass().getName(), he);
    }
  }

  /**
   * Returns Give Sub-ID Counter (RXG-1).
   */
  public NM getGiveSubIDCounter()  {
    NM ret = null;
    try {
        Type t = this.getField(1, 0);
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
   * Returns Dispense Sub-ID Counter (RXG-2).
   */
  public NM getDispenseSubIDCounter()  {
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
   * Returns Quantity/Timing (RXG-3).
   */
  public TQ getQuantityTiming()  {
    TQ ret = null;
    try {
        Type t = this.getField(3, 0);
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
   * Returns Give Code (RXG-4).
   */
  public CE getGiveCode()  {
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
   * Returns Give Amount - Minimum (RXG-5).
   */
  public NM getGiveAmountMinimum()  {
    NM ret = null;
    try {
        Type t = this.getField(5, 0);
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
   * Returns Give Amount - Maximum (RXG-6).
   */
  public NM getGiveAmountMaximum()  {
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
   * Returns Give Units (RXG-7).
   */
  public CE getGiveUnits()  {
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
   * Returns Give Dosage Form (RXG-8).
   */
  public CE getGiveDosageForm()  {
    CE ret = null;
    try {
        Type t = this.getField(8, 0);
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
   * Returns a single repetition of Administration Notes (RXG-9).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public CE getAdministrationNotes(int rep) throws HL7Exception {
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
   * Returns all repetitions of Administration Notes (RXG-9).
   */
  public CE[] getAdministrationNotes() {
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
   * Returns Substitution Status (RXG-10).
   */
  public ID getSubstitutionStatus()  {
    ID ret = null;
    try {
        Type t = this.getField(10, 0);
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
   * Returns Dispense-To Location (RXG-11).
   */
  public LA2 getDispenseToLocation()  {
    LA2 ret = null;
    try {
        Type t = this.getField(11, 0);
        ret = (LA2)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    } catch (HL7Exception he) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", he);
        throw new RuntimeException(he);
    }
    return ret;
  }

  /**
   * Returns Needs Human Review (RXG-12).
   */
  public ID getNeedsHumanReview()  {
    ID ret = null;
    try {
        Type t = this.getField(12, 0);
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
   * Returns a single repetition of Pharmacy/Treatment Supplier's Special Administration Instructions (RXG-13).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public CE getPharmacyTreatmentSupplierSSpecialAdministrationInstructions(int rep) throws HL7Exception {
    CE ret = null;
    try {
        Type t = this.getField(13, rep);
        ret = (CE)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    }
    return ret;
  }

  /**
   * Returns all repetitions of Pharmacy/Treatment Supplier's Special Administration Instructions (RXG-13).
   */
  public CE[] getPharmacyTreatmentSupplierSSpecialAdministrationInstructions() {
     CE[] ret = null;
    try {
        Type[] t = this.getField(13);  
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
   * Returns Give Per (Time Unit) (RXG-14).
   */
  public ST getGivePerTimeUnit()  {
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
   * Returns Give Rate Amount (RXG-15).
   */
  public ST getGiveRateAmount()  {
    ST ret = null;
    try {
        Type t = this.getField(15, 0);
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
   * Returns Give Rate Units (RXG-16).
   */
  public CE getGiveRateUnits()  {
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
   * Returns Give Strength (RXG-17).
   */
  public NM getGiveStrength()  {
    NM ret = null;
    try {
        Type t = this.getField(17, 0);
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
   * Returns Give Strength Units (RXG-18).
   */
  public CE getGiveStrengthUnits()  {
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
   * Returns a single repetition of Substance Lot Number (RXG-19).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public ST getSubstanceLotNumber(int rep) throws HL7Exception {
    ST ret = null;
    try {
        Type t = this.getField(19, rep);
        ret = (ST)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    }
    return ret;
  }

  /**
   * Returns all repetitions of Substance Lot Number (RXG-19).
   */
  public ST[] getSubstanceLotNumber() {
     ST[] ret = null;
    try {
        Type[] t = this.getField(19);  
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
   * Returns a single repetition of Substance Expiration Date (RXG-20).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public TS getSubstanceExpirationDate(int rep) throws HL7Exception {
    TS ret = null;
    try {
        Type t = this.getField(20, rep);
        ret = (TS)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    }
    return ret;
  }

  /**
   * Returns all repetitions of Substance Expiration Date (RXG-20).
   */
  public TS[] getSubstanceExpirationDate() {
     TS[] ret = null;
    try {
        Type[] t = this.getField(20);  
        ret = new TS[t.length];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = (TS)t[i];
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
   * Returns a single repetition of Substance Manufacturer Name (RXG-21).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public CE getSubstanceManufacturerName(int rep) throws HL7Exception {
    CE ret = null;
    try {
        Type t = this.getField(21, rep);
        ret = (CE)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    }
    return ret;
  }

  /**
   * Returns all repetitions of Substance Manufacturer Name (RXG-21).
   */
  public CE[] getSubstanceManufacturerName() {
     CE[] ret = null;
    try {
        Type[] t = this.getField(21);  
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
   * Returns a single repetition of Indication (RXG-22).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public CE getIndication(int rep) throws HL7Exception {
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
   * Returns all repetitions of Indication (RXG-22).
   */
  public CE[] getIndication() {
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

}