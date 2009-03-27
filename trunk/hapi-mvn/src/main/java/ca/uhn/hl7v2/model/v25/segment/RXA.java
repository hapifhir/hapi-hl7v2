package ca.uhn.hl7v2.model.v25.segment;

import ca.uhn.hl7v2.model.*;
import ca.uhn.hl7v2.model.v25.datatype.*;

import ca.uhn.log.HapiLogFactory;
import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.HL7Exception;

/**
 * <p>Represents an HL7 RXA message segment. 
 * This segment has the following fields:</p><p>
 * RXA-1: Give Sub-ID Counter (NM)<br> 
 * RXA-2: Administration Sub-ID Counter (NM)<br> 
 * RXA-3: Date/Time Start of Administration (TS)<br> 
 * RXA-4: Date/Time End of Administration (TS)<br> 
 * RXA-5: Administered Code (CE)<br> 
 * RXA-6: Administered Amount (NM)<br> 
 * RXA-7: Administered Units (CE)<br> 
 * RXA-8: Administered Dosage Form (CE)<br> 
 * RXA-9: Administration Notes (CE)<br> 
 * RXA-10: Administering Provider (XCN)<br> 
 * RXA-11: Administered-at Location (LA2)<br> 
 * RXA-12: Administered Per (Time Unit) (ST)<br> 
 * RXA-13: Administered Strength (NM)<br> 
 * RXA-14: Administered Strength Units (CE)<br> 
 * RXA-15: Substance Lot Number (ST)<br> 
 * RXA-16: Substance Expiration Date (TS)<br> 
 * RXA-17: Substance Manufacturer Name (CE)<br> 
 * RXA-18: Substance/Treatment Refusal Reason (CE)<br> 
 * RXA-19: Indication (CE)<br> 
 * RXA-20: Completion Status (ID)<br> 
 * RXA-21: Action Code - RXA (ID)<br> 
 * RXA-22: System Entry Date/Time (TS)<br> 
 * RXA-23: Administered Drug Strength Volume (NM)<br> 
 * RXA-24: Administered Drug Strength Volume Units (CWE)<br> 
 * RXA-25: Administered Barcode Identifier (CWE)<br> 
 * RXA-26: Pharmacy Order Type (ID)<br> 
 * </p><p>The get...() methods return data from individual fields.  These methods 
 * do not throw exceptions and may therefore have to handle exceptions internally.  
 * If an exception is handled internally, it is logged and null is returned.  
 * This is not expected to happen - if it does happen this indicates not so much 
 * an exceptional circumstance as a bug in the code for this class.</p>    
 */
public class RXA extends AbstractSegment  {

  /**
   * Creates a RXA (Pharmacy/Treatment Administration) segment object that belongs to the given 
   * message.  
   */
  public RXA(Group parent, ModelClassFactory factory) {
    super(parent, factory);
    Message message = getMessage();
    try {
       this.add(NM.class, true, 1, 4, new Object[]{message});
       this.add(NM.class, true, 1, 4, new Object[]{message});
       this.add(TS.class, true, 1, 26, new Object[]{message});
       this.add(TS.class, true, 1, 26, new Object[]{message});
       this.add(CE.class, true, 1, 250, new Object[]{message});
       this.add(NM.class, true, 1, 20, new Object[]{message});
       this.add(CE.class, false, 1, 250, new Object[]{message});
       this.add(CE.class, false, 1, 250, new Object[]{message});
       this.add(CE.class, false, 0, 250, new Object[]{message});
       this.add(XCN.class, false, 0, 250, new Object[]{message});
       this.add(LA2.class, false, 1, 200, new Object[]{message});
       this.add(ST.class, false, 1, 20, new Object[]{message});
       this.add(NM.class, false, 1, 20, new Object[]{message});
       this.add(CE.class, false, 1, 250, new Object[]{message});
       this.add(ST.class, false, 0, 20, new Object[]{message});
       this.add(TS.class, false, 0, 26, new Object[]{message});
       this.add(CE.class, false, 0, 250, new Object[]{message});
       this.add(CE.class, false, 0, 250, new Object[]{message});
       this.add(CE.class, false, 0, 250, new Object[]{message});
       this.add(ID.class, false, 1, 2, new Object[]{message, new Integer(322)});
       this.add(ID.class, false, 1, 2, new Object[]{message, new Integer(323)});
       this.add(TS.class, false, 1, 26, new Object[]{message});
       this.add(NM.class, false, 1, 5, new Object[]{message});
       this.add(CWE.class, false, 1, 250, new Object[]{message});
       this.add(CWE.class, false, 1, 60, new Object[]{message});
       this.add(ID.class, false, 1, 1, new Object[]{message, new Integer(480)});
    } catch (HL7Exception he) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Can't instantiate " + this.getClass().getName(), he);
    }
  }

  /**
   * Returns Give Sub-ID Counter (RXA-1).
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
   * Returns Administration Sub-ID Counter (RXA-2).
   */
  public NM getAdministrationSubIDCounter()  {
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
   * Returns Date/Time Start of Administration (RXA-3).
   */
  public TS getDateTimeStartOfAdministration()  {
    TS ret = null;
    try {
        Type t = this.getField(3, 0);
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
   * Returns Date/Time End of Administration (RXA-4).
   */
  public TS getDateTimeEndOfAdministration()  {
    TS ret = null;
    try {
        Type t = this.getField(4, 0);
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
   * Returns Administered Code (RXA-5).
   */
  public CE getAdministeredCode()  {
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
   * Returns Administered Amount (RXA-6).
   */
  public NM getAdministeredAmount()  {
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
   * Returns Administered Units (RXA-7).
   */
  public CE getAdministeredUnits()  {
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
   * Returns Administered Dosage Form (RXA-8).
   */
  public CE getAdministeredDosageForm()  {
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
   * Returns a single repetition of Administration Notes (RXA-9).
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
   * Returns all repetitions of Administration Notes (RXA-9).
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
   * Returns a single repetition of Administering Provider (RXA-10).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public XCN getAdministeringProvider(int rep) throws HL7Exception {
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
   * Returns all repetitions of Administering Provider (RXA-10).
   */
  public XCN[] getAdministeringProvider() {
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
   * Returns Administered-at Location (RXA-11).
   */
  public LA2 getAdministeredAtLocation()  {
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
   * Returns Administered Per (Time Unit) (RXA-12).
   */
  public ST getAdministeredPerTimeUnit()  {
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
   * Returns Administered Strength (RXA-13).
   */
  public NM getAdministeredStrength()  {
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
   * Returns Administered Strength Units (RXA-14).
   */
  public CE getAdministeredStrengthUnits()  {
    CE ret = null;
    try {
        Type t = this.getField(14, 0);
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
   * Returns a single repetition of Substance Lot Number (RXA-15).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public ST getSubstanceLotNumber(int rep) throws HL7Exception {
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
   * Returns all repetitions of Substance Lot Number (RXA-15).
   */
  public ST[] getSubstanceLotNumber() {
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
   * Returns a single repetition of Substance Expiration Date (RXA-16).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public TS getSubstanceExpirationDate(int rep) throws HL7Exception {
    TS ret = null;
    try {
        Type t = this.getField(16, rep);
        ret = (TS)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    }
    return ret;
  }

  /**
   * Returns all repetitions of Substance Expiration Date (RXA-16).
   */
  public TS[] getSubstanceExpirationDate() {
     TS[] ret = null;
    try {
        Type[] t = this.getField(16);  
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
   * Returns a single repetition of Substance Manufacturer Name (RXA-17).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public CE getSubstanceManufacturerName(int rep) throws HL7Exception {
    CE ret = null;
    try {
        Type t = this.getField(17, rep);
        ret = (CE)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    }
    return ret;
  }

  /**
   * Returns all repetitions of Substance Manufacturer Name (RXA-17).
   */
  public CE[] getSubstanceManufacturerName() {
     CE[] ret = null;
    try {
        Type[] t = this.getField(17);  
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
   * Returns a single repetition of Substance/Treatment Refusal Reason (RXA-18).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public CE getSubstanceTreatmentRefusalReason(int rep) throws HL7Exception {
    CE ret = null;
    try {
        Type t = this.getField(18, rep);
        ret = (CE)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    }
    return ret;
  }

  /**
   * Returns all repetitions of Substance/Treatment Refusal Reason (RXA-18).
   */
  public CE[] getSubstanceTreatmentRefusalReason() {
     CE[] ret = null;
    try {
        Type[] t = this.getField(18);  
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
   * Returns a single repetition of Indication (RXA-19).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public CE getIndication(int rep) throws HL7Exception {
    CE ret = null;
    try {
        Type t = this.getField(19, rep);
        ret = (CE)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    }
    return ret;
  }

  /**
   * Returns all repetitions of Indication (RXA-19).
   */
  public CE[] getIndication() {
     CE[] ret = null;
    try {
        Type[] t = this.getField(19);  
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
   * Returns Completion Status (RXA-20).
   */
  public ID getCompletionStatus()  {
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
   * Returns Action Code - RXA (RXA-21).
   */
  public ID getActionCodeRXA()  {
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
   * Returns System Entry Date/Time (RXA-22).
   */
  public TS getSystemEntryDateTime()  {
    TS ret = null;
    try {
        Type t = this.getField(22, 0);
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
   * Returns Administered Drug Strength Volume (RXA-23).
   */
  public NM getAdministeredDrugStrengthVolume()  {
    NM ret = null;
    try {
        Type t = this.getField(23, 0);
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
   * Returns Administered Drug Strength Volume Units (RXA-24).
   */
  public CWE getAdministeredDrugStrengthVolumeUnits()  {
    CWE ret = null;
    try {
        Type t = this.getField(24, 0);
        ret = (CWE)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    } catch (HL7Exception he) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", he);
        throw new RuntimeException(he);
    }
    return ret;
  }

  /**
   * Returns Administered Barcode Identifier (RXA-25).
   */
  public CWE getAdministeredBarcodeIdentifier()  {
    CWE ret = null;
    try {
        Type t = this.getField(25, 0);
        ret = (CWE)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    } catch (HL7Exception he) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", he);
        throw new RuntimeException(he);
    }
    return ret;
  }

  /**
   * Returns Pharmacy Order Type (RXA-26).
   */
  public ID getPharmacyOrderType()  {
    ID ret = null;
    try {
        Type t = this.getField(26, 0);
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