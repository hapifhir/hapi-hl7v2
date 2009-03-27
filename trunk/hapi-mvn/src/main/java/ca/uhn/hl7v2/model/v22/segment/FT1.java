package ca.uhn.hl7v2.model.v22.segment;

import ca.uhn.hl7v2.model.*;
import ca.uhn.hl7v2.model.v22.datatype.*;

import ca.uhn.log.HapiLogFactory;
import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.HL7Exception;

/**
 * <p>Represents an HL7 FT1 message segment. 
 * This segment has the following fields:</p><p>
 * FT1-1: Set ID - financial transaction (SI)<br> 
 * FT1-2: Transaction ID (ST)<br> 
 * FT1-3: Transaction batch ID (ST)<br> 
 * FT1-4: Transaction date (DT)<br> 
 * FT1-5: Transaction posting date (DT)<br> 
 * FT1-6: Transaction type (ID)<br> 
 * FT1-7: Transaction code (CE)<br> 
 * FT1-8: Transaction description (ST)<br> 
 * FT1-9: Transaction description - alternate (ST)<br> 
 * FT1-10: Transaction quantity (NM)<br> 
 * FT1-11: Transaction amount - extended (NM)<br> 
 * FT1-12: Transaction amount - unit (NM)<br> 
 * FT1-13: Department code (CE)<br> 
 * FT1-14: Insurance plan ID (ID)<br> 
 * FT1-15: Insurance amount (NM)<br> 
 * FT1-16: Assigned Patient Location (CM_INTERNAL_LOCATION)<br> 
 * FT1-17: Fee schedule (ID)<br> 
 * FT1-18: Patient type (ID)<br> 
 * FT1-19: Diagnosis code (CE)<br> 
 * FT1-20: Performed by code (CN)<br> 
 * FT1-21: Ordered by code (CN)<br> 
 * FT1-22: Unit cost (NM)<br> 
 * FT1-23: Filler Order Number (CM_FILLER)<br> 
 * </p><p>The get...() methods return data from individual fields.  These methods 
 * do not throw exceptions and may therefore have to handle exceptions internally.  
 * If an exception is handled internally, it is logged and null is returned.  
 * This is not expected to happen - if it does happen this indicates not so much 
 * an exceptional circumstance as a bug in the code for this class.</p>    
 */
public class FT1 extends AbstractSegment  {

  /**
   * Creates a FT1 (FINANCIAL TRANSACTION) segment object that belongs to the given 
   * message.  
   */
  public FT1(Group parent, ModelClassFactory factory) {
    super(parent, factory);
    Message message = getMessage();
    try {
       this.add(SI.class, false, 1, 4, new Object[]{message});
       this.add(ST.class, false, 1, 12, new Object[]{message});
       this.add(ST.class, false, 1, 10, new Object[]{message});
       this.add(DT.class, true, 1, 8, new Object[]{message});
       this.add(DT.class, false, 1, 8, new Object[]{message});
       this.add(ID.class, true, 1, 8, new Object[]{message, new Integer(17)});
       this.add(CE.class, true, 1, 20, new Object[]{message});
       this.add(ST.class, false, 1, 40, new Object[]{message});
       this.add(ST.class, false, 1, 40, new Object[]{message});
       this.add(NM.class, false, 1, 4, new Object[]{message});
       this.add(NM.class, false, 1, 12, new Object[]{message});
       this.add(NM.class, false, 1, 12, new Object[]{message});
       this.add(CE.class, false, 1, 60, new Object[]{message});
       this.add(ID.class, true, 1, 8, new Object[]{message, new Integer(72)});
       this.add(NM.class, false, 1, 12, new Object[]{message});
       this.add(CM_INTERNAL_LOCATION.class, false, 1, 12, new Object[]{message});
       this.add(ID.class, false, 1, 1, new Object[]{message, new Integer(24)});
       this.add(ID.class, false, 1, 2, new Object[]{message, new Integer(18)});
       this.add(CE.class, false, 0, 8, new Object[]{message});
       this.add(CN.class, false, 1, 60, new Object[]{message});
       this.add(CN.class, false, 1, 60, new Object[]{message});
       this.add(NM.class, false, 1, 12, new Object[]{message});
       this.add(CM_FILLER.class, false, 1, 75, new Object[]{message});
    } catch (HL7Exception he) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Can't instantiate " + this.getClass().getName(), he);
    }
  }

  /**
   * Returns Set ID - financial transaction (FT1-1).
   */
  public SI getSetIDFinancialTransaction()  {
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
   * Returns Transaction ID (FT1-2).
   */
  public ST getTransactionID()  {
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
   * Returns Transaction batch ID (FT1-3).
   */
  public ST getTransactionBatchID()  {
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
   * Returns Transaction date (FT1-4).
   */
  public DT getTransactionDate()  {
    DT ret = null;
    try {
        Type t = this.getField(4, 0);
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
   * Returns Transaction posting date (FT1-5).
   */
  public DT getTransactionPostingDate()  {
    DT ret = null;
    try {
        Type t = this.getField(5, 0);
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
   * Returns Transaction type (FT1-6).
   */
  public ID getTransactionType()  {
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
   * Returns Transaction code (FT1-7).
   */
  public CE getTransactionCode()  {
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
   * Returns Transaction description (FT1-8).
   */
  public ST getTransactionDescription()  {
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
   * Returns Transaction description - alternate (FT1-9).
   */
  public ST getTransactionDescriptionAlternate()  {
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
   * Returns Transaction quantity (FT1-10).
   */
  public NM getTransactionQuantity()  {
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
   * Returns Transaction amount - extended (FT1-11).
   */
  public NM getTransactionAmountExtended()  {
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
   * Returns Transaction amount - unit (FT1-12).
   */
  public NM getTransactionAmountUnit()  {
    NM ret = null;
    try {
        Type t = this.getField(12, 0);
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
   * Returns Department code (FT1-13).
   */
  public CE getDepartmentCode()  {
    CE ret = null;
    try {
        Type t = this.getField(13, 0);
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
   * Returns Insurance plan ID (FT1-14).
   */
  public ID getInsurancePlanID()  {
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
   * Returns Insurance amount (FT1-15).
   */
  public NM getInsuranceAmount()  {
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
   * Returns Assigned Patient Location (FT1-16).
   */
  public CM_INTERNAL_LOCATION getAssignedPatientLocation()  {
    CM_INTERNAL_LOCATION ret = null;
    try {
        Type t = this.getField(16, 0);
        ret = (CM_INTERNAL_LOCATION)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    } catch (HL7Exception he) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", he);
        throw new RuntimeException(he);
    }
    return ret;
  }

  /**
   * Returns Fee schedule (FT1-17).
   */
  public ID getFeeSchedule()  {
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
   * Returns Patient type (FT1-18).
   */
  public ID getPatientType()  {
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
   * Returns a single repetition of Diagnosis code (FT1-19).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public CE getDiagnosisCode(int rep) throws HL7Exception {
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
   * Returns all repetitions of Diagnosis code (FT1-19).
   */
  public CE[] getDiagnosisCode() {
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
   * Returns Performed by code (FT1-20).
   */
  public CN getPerformedByCode()  {
    CN ret = null;
    try {
        Type t = this.getField(20, 0);
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
   * Returns Ordered by code (FT1-21).
   */
  public CN getOrderedByCode()  {
    CN ret = null;
    try {
        Type t = this.getField(21, 0);
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
   * Returns Unit cost (FT1-22).
   */
  public NM getUnitCost()  {
    NM ret = null;
    try {
        Type t = this.getField(22, 0);
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
   * Returns Filler Order Number (FT1-23).
   */
  public CM_FILLER getFillerOrderNumber()  {
    CM_FILLER ret = null;
    try {
        Type t = this.getField(23, 0);
        ret = (CM_FILLER)t;
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