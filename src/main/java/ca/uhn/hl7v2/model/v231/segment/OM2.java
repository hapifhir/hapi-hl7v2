package ca.uhn.hl7v2.model.v231.segment;

import ca.uhn.hl7v2.model.*;
import ca.uhn.hl7v2.model.v231.datatype.*;

import ca.uhn.log.HapiLogFactory;
import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.HL7Exception;

/**
 * <p>Represents an HL7 OM2 message segment. 
 * This segment has the following fields:</p><p>
 * OM2-1: Sequence Number - Test/Observation Master File (NM)<br> 
 * OM2-2: Units of Measure (CE)<br> 
 * OM2-3: Range of Decimal Precision (NM)<br> 
 * OM2-4: Corresponding SI Units of Measure (CE)<br> 
 * OM2-5: SI Conversion Factor (TX)<br> 
 * OM2-6: Reference (Normal) Range - Ordinal & Continuous Obs (RFR)<br> 
 * OM2-7: Critical Range for Ordinal & Continuous Obs (NR)<br> 
 * OM2-8: Absolute Range for Ordinal & Continuous Obs (RFR)<br> 
 * OM2-9: Delta Check Criteria (DLT)<br> 
 * OM2-10: Minimum Meaningful Increments (NM)<br> 
 * </p><p>The get...() methods return data from individual fields.  These methods 
 * do not throw exceptions and may therefore have to handle exceptions internally.  
 * If an exception is handled internally, it is logged and null is returned.  
 * This is not expected to happen - if it does happen this indicates not so much 
 * an exceptional circumstance as a bug in the code for this class.</p>    
 */
public class OM2 extends AbstractSegment  {

  /**
   * Creates a OM2 (OM2 - numeric observation segment) segment object that belongs to the given 
   * message.  
   */
  public OM2(Group parent, ModelClassFactory factory) {
    super(parent, factory);
    Message message = getMessage();
    try {
       this.add(NM.class, false, 1, 4, new Object[]{message});
       this.add(CE.class, false, 1, 60, new Object[]{message});
       this.add(NM.class, false, 0, 10, new Object[]{message});
       this.add(CE.class, false, 1, 60, new Object[]{message});
       this.add(TX.class, false, 1, 60, new Object[]{message});
       this.add(RFR.class, false, 1, 200, new Object[]{message});
       this.add(NR.class, false, 1, 200, new Object[]{message});
       this.add(RFR.class, false, 1, 200, new Object[]{message});
       this.add(DLT.class, false, 0, 200, new Object[]{message});
       this.add(NM.class, false, 1, 20, new Object[]{message});
    } catch (HL7Exception he) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Can't instantiate " + this.getClass().getName(), he);
    }
  }

  /**
   * Returns Sequence Number - Test/Observation Master File (OM2-1).
   */
  public NM getSequenceNumberTestObservationMasterFile()  {
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
   * Returns Units of Measure (OM2-2).
   */
  public CE getUnitsOfMeasure()  {
    CE ret = null;
    try {
        Type t = this.getField(2, 0);
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
   * Returns a single repetition of Range of Decimal Precision (OM2-3).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public NM getRangeOfDecimalPrecision(int rep) throws HL7Exception {
    NM ret = null;
    try {
        Type t = this.getField(3, rep);
        ret = (NM)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    }
    return ret;
  }

  /**
   * Returns all repetitions of Range of Decimal Precision (OM2-3).
   */
  public NM[] getRangeOfDecimalPrecision() {
     NM[] ret = null;
    try {
        Type[] t = this.getField(3);  
        ret = new NM[t.length];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = (NM)t[i];
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
   * Returns Corresponding SI Units of Measure (OM2-4).
   */
  public CE getCorrespondingSIUnitsOfMeasure()  {
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
   * Returns SI Conversion Factor (OM2-5).
   */
  public TX getSIConversionFactor()  {
    TX ret = null;
    try {
        Type t = this.getField(5, 0);
        ret = (TX)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    } catch (HL7Exception he) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", he);
        throw new RuntimeException(he);
    }
    return ret;
  }

  /**
   * Returns Reference (Normal) Range - Ordinal & Continuous Obs (OM2-6).
   */
  public RFR getReferenceNormalRangeOrdinalContinuousObs()  {
    RFR ret = null;
    try {
        Type t = this.getField(6, 0);
        ret = (RFR)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    } catch (HL7Exception he) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", he);
        throw new RuntimeException(he);
    }
    return ret;
  }

  /**
   * Returns Critical Range for Ordinal & Continuous Obs (OM2-7).
   */
  public NR getCriticalRangeForOrdinalContinuousObs()  {
    NR ret = null;
    try {
        Type t = this.getField(7, 0);
        ret = (NR)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    } catch (HL7Exception he) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", he);
        throw new RuntimeException(he);
    }
    return ret;
  }

  /**
   * Returns Absolute Range for Ordinal & Continuous Obs (OM2-8).
   */
  public RFR getAbsoluteRangeForOrdinalContinuousObs()  {
    RFR ret = null;
    try {
        Type t = this.getField(8, 0);
        ret = (RFR)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    } catch (HL7Exception he) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", he);
        throw new RuntimeException(he);
    }
    return ret;
  }

  /**
   * Returns a single repetition of Delta Check Criteria (OM2-9).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public DLT getDeltaCheckCriteria(int rep) throws HL7Exception {
    DLT ret = null;
    try {
        Type t = this.getField(9, rep);
        ret = (DLT)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    }
    return ret;
  }

  /**
   * Returns all repetitions of Delta Check Criteria (OM2-9).
   */
  public DLT[] getDeltaCheckCriteria() {
     DLT[] ret = null;
    try {
        Type[] t = this.getField(9);  
        ret = new DLT[t.length];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = (DLT)t[i];
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
   * Returns Minimum Meaningful Increments (OM2-10).
   */
  public NM getMinimumMeaningfulIncrements()  {
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

}