package ca.uhn.hl7v2.model.v25.segment;

import ca.uhn.hl7v2.model.*;
import ca.uhn.hl7v2.model.v25.datatype.*;

import ca.uhn.log.HapiLogFactory;
import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.HL7Exception;

/**
 * <p>Represents an HL7 BPX message segment. 
 * This segment has the following fields:</p><p>
 * BPX-1: Set ID _ BPX (SI)<br> 
 * BPX-2: BP Dispense Status (CWE)<br> 
 * BPX-3: BP Status (ID)<br> 
 * BPX-4: BP Date/Time of Status (TS)<br> 
 * BPX-5: BC Donation ID (EI)<br> 
 * BPX-6: BC Component (CNE)<br> 
 * BPX-7: BC Donation Type / Intended Use (CNE)<br> 
 * BPX-8: CP Commercial Product (CWE)<br> 
 * BPX-9: CP Manufacturer (XON)<br> 
 * BPX-10: CP Lot Number (EI)<br> 
 * BPX-11: BP Blood Group (CNE)<br> 
 * BPX-12: BC Special Testing (CNE)<br> 
 * BPX-13: BP Expiration Date/Time (TS)<br> 
 * BPX-14: BP Quantity (NM)<br> 
 * BPX-15: BP Amount (NM)<br> 
 * BPX-16: BP Units (CE)<br> 
 * BPX-17: BP Unique ID (EI)<br> 
 * BPX-18: BP Actual Dispensed To Location (PL)<br> 
 * BPX-19: BP Actual Dispensed To Address (XAD)<br> 
 * BPX-20: BP Dispensed to Receiver (XCN)<br> 
 * BPX-21: BP Dispensing Individual (XCN)<br> 
 * </p><p>The get...() methods return data from individual fields.  These methods 
 * do not throw exceptions and may therefore have to handle exceptions internally.  
 * If an exception is handled internally, it is logged and null is returned.  
 * This is not expected to happen - if it does happen this indicates not so much 
 * an exceptional circumstance as a bug in the code for this class.</p>    
 */
public class BPX extends AbstractSegment  {

  /**
   * Creates a BPX (Blood product dispense status) segment object that belongs to the given 
   * message.  
   */
  public BPX(Group parent, ModelClassFactory factory) {
    super(parent, factory);
    Message message = getMessage();
    try {
       this.add(SI.class, true, 1, 4, new Object[]{message});
       this.add(CWE.class, true, 1, 250, new Object[]{message});
       this.add(ID.class, true, 1, 1, new Object[]{message, new Integer(511)});
       this.add(TS.class, true, 1, 26, new Object[]{message});
       this.add(EI.class, false, 1, 22, new Object[]{message});
       this.add(CNE.class, false, 1, 250, new Object[]{message});
       this.add(CNE.class, false, 1, 250, new Object[]{message});
       this.add(CWE.class, false, 1, 250, new Object[]{message});
       this.add(XON.class, false, 1, 250, new Object[]{message});
       this.add(EI.class, false, 1, 22, new Object[]{message});
       this.add(CNE.class, false, 1, 250, new Object[]{message});
       this.add(CNE.class, false, 0, 250, new Object[]{message});
       this.add(TS.class, false, 1, 26, new Object[]{message});
       this.add(NM.class, true, 1, 5, new Object[]{message});
       this.add(NM.class, false, 1, 5, new Object[]{message});
       this.add(CE.class, false, 1, 250, new Object[]{message});
       this.add(EI.class, false, 1, 22, new Object[]{message});
       this.add(PL.class, false, 1, 80, new Object[]{message});
       this.add(XAD.class, false, 1, 250, new Object[]{message});
       this.add(XCN.class, false, 1, 250, new Object[]{message});
       this.add(XCN.class, false, 1, 250, new Object[]{message});
    } catch (HL7Exception he) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Can't instantiate " + this.getClass().getName(), he);
    }
  }

  /**
   * Returns Set ID _ BPX (BPX-1).
   */
  public SI getSetIDBPX()  {
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
   * Returns BP Dispense Status (BPX-2).
   */
  public CWE getBPDispenseStatus()  {
    CWE ret = null;
    try {
        Type t = this.getField(2, 0);
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
   * Returns BP Status (BPX-3).
   */
  public ID getBPStatus()  {
    ID ret = null;
    try {
        Type t = this.getField(3, 0);
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
   * Returns BP Date/Time of Status (BPX-4).
   */
  public TS getBPDateTimeOfStatus()  {
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
   * Returns BC Donation ID (BPX-5).
   */
  public EI getBCDonationID()  {
    EI ret = null;
    try {
        Type t = this.getField(5, 0);
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
   * Returns BC Component (BPX-6).
   */
  public CNE getBCComponent()  {
    CNE ret = null;
    try {
        Type t = this.getField(6, 0);
        ret = (CNE)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    } catch (HL7Exception he) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", he);
        throw new RuntimeException(he);
    }
    return ret;
  }

  /**
   * Returns BC Donation Type / Intended Use (BPX-7).
   */
  public CNE getBCDonationTypeIntendedUse()  {
    CNE ret = null;
    try {
        Type t = this.getField(7, 0);
        ret = (CNE)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    } catch (HL7Exception he) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", he);
        throw new RuntimeException(he);
    }
    return ret;
  }

  /**
   * Returns CP Commercial Product (BPX-8).
   */
  public CWE getCPCommercialProduct()  {
    CWE ret = null;
    try {
        Type t = this.getField(8, 0);
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
   * Returns CP Manufacturer (BPX-9).
   */
  public XON getCPManufacturer()  {
    XON ret = null;
    try {
        Type t = this.getField(9, 0);
        ret = (XON)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    } catch (HL7Exception he) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", he);
        throw new RuntimeException(he);
    }
    return ret;
  }

  /**
   * Returns CP Lot Number (BPX-10).
   */
  public EI getCPLotNumber()  {
    EI ret = null;
    try {
        Type t = this.getField(10, 0);
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
   * Returns BP Blood Group (BPX-11).
   */
  public CNE getBPBloodGroup()  {
    CNE ret = null;
    try {
        Type t = this.getField(11, 0);
        ret = (CNE)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    } catch (HL7Exception he) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", he);
        throw new RuntimeException(he);
    }
    return ret;
  }

  /**
   * Returns a single repetition of BC Special Testing (BPX-12).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public CNE getBCSpecialTesting(int rep) throws HL7Exception {
    CNE ret = null;
    try {
        Type t = this.getField(12, rep);
        ret = (CNE)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    }
    return ret;
  }

  /**
   * Returns all repetitions of BC Special Testing (BPX-12).
   */
  public CNE[] getBCSpecialTesting() {
     CNE[] ret = null;
    try {
        Type[] t = this.getField(12);  
        ret = new CNE[t.length];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = (CNE)t[i];
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
   * Returns BP Expiration Date/Time (BPX-13).
   */
  public TS getBPExpirationDateTime()  {
    TS ret = null;
    try {
        Type t = this.getField(13, 0);
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
   * Returns BP Quantity (BPX-14).
   */
  public NM getBPQuantity()  {
    NM ret = null;
    try {
        Type t = this.getField(14, 0);
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
   * Returns BP Amount (BPX-15).
   */
  public NM getBPAmount()  {
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
   * Returns BP Units (BPX-16).
   */
  public CE getBPUnits()  {
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
   * Returns BP Unique ID (BPX-17).
   */
  public EI getBPUniqueID()  {
    EI ret = null;
    try {
        Type t = this.getField(17, 0);
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
   * Returns BP Actual Dispensed To Location (BPX-18).
   */
  public PL getBPActualDispensedToLocation()  {
    PL ret = null;
    try {
        Type t = this.getField(18, 0);
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
   * Returns BP Actual Dispensed To Address (BPX-19).
   */
  public XAD getBPActualDispensedToAddress()  {
    XAD ret = null;
    try {
        Type t = this.getField(19, 0);
        ret = (XAD)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    } catch (HL7Exception he) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", he);
        throw new RuntimeException(he);
    }
    return ret;
  }

  /**
   * Returns BP Dispensed to Receiver (BPX-20).
   */
  public XCN getBPDispensedToReceiver()  {
    XCN ret = null;
    try {
        Type t = this.getField(20, 0);
        ret = (XCN)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    } catch (HL7Exception he) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", he);
        throw new RuntimeException(he);
    }
    return ret;
  }

  /**
   * Returns BP Dispensing Individual (BPX-21).
   */
  public XCN getBPDispensingIndividual()  {
    XCN ret = null;
    try {
        Type t = this.getField(21, 0);
        ret = (XCN)t;
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