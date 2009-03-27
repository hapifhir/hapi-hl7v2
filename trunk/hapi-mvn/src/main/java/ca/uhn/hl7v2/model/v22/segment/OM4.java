package ca.uhn.hl7v2.model.v22.segment;

import ca.uhn.hl7v2.model.*;
import ca.uhn.hl7v2.model.v22.datatype.*;

import ca.uhn.log.HapiLogFactory;
import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.HL7Exception;

/**
 * <p>Represents an HL7 OM4 message segment. 
 * This segment has the following fields:</p><p>
 * OM4-1: Segment Type ID (ST)<br> 
 * OM4-2: Sequence Number - Test/ Observation Master File (NM)<br> 
 * OM4-3: Derived Specimen (ID)<br> 
 * OM4-4: Container Description (TX)<br> 
 * OM4-5: Container Volume (NM)<br> 
 * OM4-6: Container Units (CE)<br> 
 * OM4-7: Specimen (CE)<br> 
 * OM4-8: Additive (CE)<br> 
 * OM4-9: Preparation (TX)<br> 
 * OM4-10: Special Handling Requirements (TX)<br> 
 * OM4-11: Normal Collection Volume (CQ_QUANTITY)<br> 
 * OM4-12: Minimum Collection Volume (CQ_QUANTITY)<br> 
 * OM4-13: Specimen Requirements (TX)<br> 
 * OM4-14: Specimen Priorities (ID)<br> 
 * OM4-15: Specimen Retention Time (CQ_QUANTITY)<br> 
 * </p><p>The get...() methods return data from individual fields.  These methods 
 * do not throw exceptions and may therefore have to handle exceptions internally.  
 * If an exception is handled internally, it is logged and null is returned.  
 * This is not expected to happen - if it does happen this indicates not so much 
 * an exceptional circumstance as a bug in the code for this class.</p>    
 */
public class OM4 extends AbstractSegment  {

  /**
   * Creates a OM4 (OBSERVATION that require specimens) segment object that belongs to the given 
   * message.  
   */
  public OM4(Group parent, ModelClassFactory factory) {
    super(parent, factory);
    Message message = getMessage();
    try {
       this.add(ST.class, false, 1, 3, new Object[]{message});
       this.add(NM.class, false, 1, 4, new Object[]{message});
       this.add(ID.class, false, 1, 1, new Object[]{message, new Integer(170)});
       this.add(TX.class, false, 1, 60, new Object[]{message});
       this.add(NM.class, false, 1, 20, new Object[]{message});
       this.add(CE.class, false, 1, 60, new Object[]{message});
       this.add(CE.class, false, 1, 60, new Object[]{message});
       this.add(CE.class, false, 1, 60, new Object[]{message});
       this.add(TX.class, false, 1, 10240, new Object[]{message});
       this.add(TX.class, false, 1, 10240, new Object[]{message});
       this.add(CQ_QUANTITY.class, false, 1, 20, new Object[]{message});
       this.add(CQ_QUANTITY.class, false, 1, 20, new Object[]{message});
       this.add(TX.class, false, 1, 10240, new Object[]{message});
       this.add(ID.class, false, 0, 60, new Object[]{message, new Integer(27)});
       this.add(CQ_QUANTITY.class, false, 1, 20, new Object[]{message});
    } catch (HL7Exception he) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Can't instantiate " + this.getClass().getName(), he);
    }
  }

  /**
   * Returns Segment Type ID (OM4-1).
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
   * Returns Sequence Number - Test/ Observation Master File (OM4-2).
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
   * Returns Derived Specimen (OM4-3).
   */
  public ID getDerivedSpecimen()  {
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
   * Returns Container Description (OM4-4).
   */
  public TX getContainerDescription()  {
    TX ret = null;
    try {
        Type t = this.getField(4, 0);
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
   * Returns Container Volume (OM4-5).
   */
  public NM getContainerVolume()  {
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
   * Returns Container Units (OM4-6).
   */
  public CE getContainerUnits()  {
    CE ret = null;
    try {
        Type t = this.getField(6, 0);
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
   * Returns Specimen (OM4-7).
   */
  public CE getSpecimen()  {
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
   * Returns Additive (OM4-8).
   */
  public CE getAdditive()  {
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
   * Returns Preparation (OM4-9).
   */
  public TX getPreparation()  {
    TX ret = null;
    try {
        Type t = this.getField(9, 0);
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
   * Returns Special Handling Requirements (OM4-10).
   */
  public TX getSpecialHandlingRequirements()  {
    TX ret = null;
    try {
        Type t = this.getField(10, 0);
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
   * Returns Normal Collection Volume (OM4-11).
   */
  public CQ_QUANTITY getNormalCollectionVolume()  {
    CQ_QUANTITY ret = null;
    try {
        Type t = this.getField(11, 0);
        ret = (CQ_QUANTITY)t;
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
   * Returns Minimum Collection Volume (OM4-12).
   */
  public CQ_QUANTITY getMinimumCollectionVolume()  {
    CQ_QUANTITY ret = null;
    try {
        Type t = this.getField(12, 0);
        ret = (CQ_QUANTITY)t;
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
   * Returns Specimen Requirements (OM4-13).
   */
  public TX getSpecimenRequirements()  {
    TX ret = null;
    try {
        Type t = this.getField(13, 0);
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
   * Returns a single repetition of Specimen Priorities (OM4-14).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public ID getSpecimenPriorities(int rep) throws HL7Exception {
    ID ret = null;
    try {
        Type t = this.getField(14, rep);
        ret = (ID)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    }
    return ret;
  }

  /**
   * Returns all repetitions of Specimen Priorities (OM4-14).
   */
  public ID[] getSpecimenPriorities() {
     ID[] ret = null;
    try {
        Type[] t = this.getField(14);  
        ret = new ID[t.length];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = (ID)t[i];
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
   * Returns Specimen Retention Time (OM4-15).
   */
  public CQ_QUANTITY getSpecimenRetentionTime()  {
    CQ_QUANTITY ret = null;
    try {
        Type t = this.getField(15, 0);
        ret = (CQ_QUANTITY)t;
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