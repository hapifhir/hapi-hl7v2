package ca.uhn.hl7v2.model.v22.segment;

import ca.uhn.hl7v2.model.*;
import ca.uhn.hl7v2.model.v22.datatype.*;

import ca.uhn.log.HapiLogFactory;
import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.HL7Exception;

/**
 * <p>Represents an HL7 OM2 message segment. 
 * This segment has the following fields:</p><p>
 * OM2-1: Segment Type ID (ST)<br> 
 * OM2-2: Sequence Number - Test/ Observation Master File (NM)<br> 
 * OM2-3: Units of Measure (CE)<br> 
 * OM2-4: Range of Decimal Precision (NM)<br> 
 * OM2-5: Corresponding SI Units of Measure (CE)<br> 
 * OM2-6: SI Conversion Factor (TX)<br> 
 * OM2-7: Reference (normal) range - ordinal & continuous observations (CM_RFR)<br> 
 * OM2-8: Critical range for ordinal and continuous observations (CM_RANGE)<br> 
 * OM2-9: Absolute range for ordinal and continuous observations (CM_ABS_RANGE)<br> 
 * OM2-10: Delta Check Criteria (CM_DLT)<br> 
 * OM2-11: Minimum Meaningful Increments (NM)<br> 
 * </p><p>The get...() methods return data from individual fields.  These methods 
 * do not throw exceptions and may therefore have to handle exceptions internally.  
 * If an exception is handled internally, it is logged and null is returned.  
 * This is not expected to happen - if it does happen this indicates not so much 
 * an exceptional circumstance as a bug in the code for this class.</p>    
 */
public class OM2 extends AbstractSegment  {

  /**
   * Creates a OM2 (NUMERIC OBSERVATION) segment object that belongs to the given 
   * message.  
   */
  public OM2(Group parent, ModelClassFactory factory) {
    super(parent, factory);
    Message message = getMessage();
    try {
       this.add(ST.class, false, 1, 3, new Object[]{message});
       this.add(NM.class, false, 1, 4, new Object[]{message});
       this.add(CE.class, false, 1, 60, new Object[]{message});
       this.add(NM.class, false, 1, 10, new Object[]{message});
       this.add(CE.class, false, 1, 60, new Object[]{message});
       this.add(TX.class, true, 0, 20, new Object[]{message});
       this.add(CM_RFR.class, false, 0, 200, new Object[]{message});
       this.add(CM_RANGE.class, false, 1, 200, new Object[]{message});
       this.add(CM_ABS_RANGE.class, false, 1, 200, new Object[]{message});
       this.add(CM_DLT.class, false, 0, 200, new Object[]{message});
       this.add(NM.class, false, 1, 20, new Object[]{message});
    } catch (HL7Exception he) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Can't instantiate " + this.getClass().getName(), he);
    }
  }

  /**
   * Returns Segment Type ID (OM2-1).
   */
  public ST getSegmentTypeID()  {
    ST ret = null;
    try {
        Type t = this.getField(1, 0);
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
   * Returns Sequence Number - Test/ Observation Master File (OM2-2).
   */
  public NM getSequenceNumberTestObservationMasterFile()  {
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
   * Returns Units of Measure (OM2-3).
   */
  public CE getUnitsOfMeasure()  {
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
   * Returns Range of Decimal Precision (OM2-4).
   */
  public NM getRangeOfDecimalPrecision()  {
    NM ret = null;
    try {
        Type t = this.getField(4, 0);
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
   * Returns Corresponding SI Units of Measure (OM2-5).
   */
  public CE getCorrespondingSIUnitsOfMeasure()  {
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
   * Returns a single repetition of SI Conversion Factor (OM2-6).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public TX getSIConversionFactor(int rep) throws HL7Exception {
    TX ret = null;
    try {
        Type t = this.getField(6, rep);
        ret = (TX)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    }
    return ret;
  }

  /**
   * Returns all repetitions of SI Conversion Factor (OM2-6).
   */
  public TX[] getSIConversionFactor() {
     TX[] ret = null;
    try {
        Type[] t = this.getField(6);  
        ret = new TX[t.length];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = (TX)t[i];
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
   * Returns a single repetition of Reference (normal) range - ordinal & continuous observations (OM2-7).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public CM_RFR getReferenceNormalRangeOrdinalContinuousObservations(int rep) throws HL7Exception {
    CM_RFR ret = null;
    try {
        Type t = this.getField(7, rep);
        ret = (CM_RFR)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    }
    return ret;
  }

  /**
   * Returns all repetitions of Reference (normal) range - ordinal & continuous observations (OM2-7).
   */
  public CM_RFR[] getReferenceNormalRangeOrdinalContinuousObservations() {
     CM_RFR[] ret = null;
    try {
        Type[] t = this.getField(7);  
        ret = new CM_RFR[t.length];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = (CM_RFR)t[i];
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
   * Returns Critical range for ordinal and continuous observations (OM2-8).
   */
  public CM_RANGE getCriticalRangeForOrdinalAndContinuousObservations()  {
    CM_RANGE ret = null;
    try {
        Type t = this.getField(8, 0);
        ret = (CM_RANGE)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    } catch (HL7Exception he) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", he);
        throw new RuntimeException(he);
    }
    return ret;
  }

  /**
   * Returns Absolute range for ordinal and continuous observations (OM2-9).
   */
  public CM_ABS_RANGE getAbsoluteRangeForOrdinalAndContinuousObservations()  {
    CM_ABS_RANGE ret = null;
    try {
        Type t = this.getField(9, 0);
        ret = (CM_ABS_RANGE)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    } catch (HL7Exception he) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", he);
        throw new RuntimeException(he);
    }
    return ret;
  }

  /**
   * Returns a single repetition of Delta Check Criteria (OM2-10).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public CM_DLT getDeltaCheckCriteria(int rep) throws HL7Exception {
    CM_DLT ret = null;
    try {
        Type t = this.getField(10, rep);
        ret = (CM_DLT)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    }
    return ret;
  }

  /**
   * Returns all repetitions of Delta Check Criteria (OM2-10).
   */
  public CM_DLT[] getDeltaCheckCriteria() {
     CM_DLT[] ret = null;
    try {
        Type[] t = this.getField(10);  
        ret = new CM_DLT[t.length];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = (CM_DLT)t[i];
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
   * Returns Minimum Meaningful Increments (OM2-11).
   */
  public NM getMinimumMeaningfulIncrements()  {
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

}