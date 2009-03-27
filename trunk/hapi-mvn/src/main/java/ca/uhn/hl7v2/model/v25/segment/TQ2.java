package ca.uhn.hl7v2.model.v25.segment;

import ca.uhn.hl7v2.model.*;
import ca.uhn.hl7v2.model.v25.datatype.*;

import ca.uhn.log.HapiLogFactory;
import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.HL7Exception;

/**
 * <p>Represents an HL7 TQ2 message segment. 
 * This segment has the following fields:</p><p>
 * TQ2-1: Set ID - TQ2 (SI)<br> 
 * TQ2-2: Sequence/Results Flag (ID)<br> 
 * TQ2-3: Related Placer Number (EI)<br> 
 * TQ2-4: Related Filler Number (EI)<br> 
 * TQ2-5: Related Placer Group Number (EI)<br> 
 * TQ2-6: Sequence Condition Code (ID)<br> 
 * TQ2-7: Cyclic Entry/Exit Indicator (ID)<br> 
 * TQ2-8: Sequence Condition Time Interval (CQ)<br> 
 * TQ2-9: Cyclic Group Maximum Number of Repeats (NM)<br> 
 * TQ2-10: Special Service Request Relationship (ID)<br> 
 * </p><p>The get...() methods return data from individual fields.  These methods 
 * do not throw exceptions and may therefore have to handle exceptions internally.  
 * If an exception is handled internally, it is logged and null is returned.  
 * This is not expected to happen - if it does happen this indicates not so much 
 * an exceptional circumstance as a bug in the code for this class.</p>    
 */
public class TQ2 extends AbstractSegment  {

  /**
   * Creates a TQ2 (Timing/Quantity Relationship) segment object that belongs to the given 
   * message.  
   */
  public TQ2(Group parent, ModelClassFactory factory) {
    super(parent, factory);
    Message message = getMessage();
    try {
       this.add(SI.class, false, 1, 4, new Object[]{message});
       this.add(ID.class, false, 1, 1, new Object[]{message, new Integer(503)});
       this.add(EI.class, false, 0, 22, new Object[]{message});
       this.add(EI.class, false, 0, 22, new Object[]{message});
       this.add(EI.class, false, 0, 22, new Object[]{message});
       this.add(ID.class, false, 1, 2, new Object[]{message, new Integer(504)});
       this.add(ID.class, false, 1, 1, new Object[]{message, new Integer(505)});
       this.add(CQ.class, false, 1, 20, new Object[]{message});
       this.add(NM.class, false, 1, 10, new Object[]{message});
       this.add(ID.class, false, 1, 1, new Object[]{message, new Integer(506)});
    } catch (HL7Exception he) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Can't instantiate " + this.getClass().getName(), he);
    }
  }

  /**
   * Returns Set ID - TQ2 (TQ2-1).
   */
  public SI getSetIDTQ2()  {
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
   * Returns Sequence/Results Flag (TQ2-2).
   */
  public ID getSequenceResultsFlag()  {
    ID ret = null;
    try {
        Type t = this.getField(2, 0);
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
   * Returns a single repetition of Related Placer Number (TQ2-3).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public EI getRelatedPlacerNumber(int rep) throws HL7Exception {
    EI ret = null;
    try {
        Type t = this.getField(3, rep);
        ret = (EI)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    }
    return ret;
  }

  /**
   * Returns all repetitions of Related Placer Number (TQ2-3).
   */
  public EI[] getRelatedPlacerNumber() {
     EI[] ret = null;
    try {
        Type[] t = this.getField(3);  
        ret = new EI[t.length];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = (EI)t[i];
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
   * Returns a single repetition of Related Filler Number (TQ2-4).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public EI getRelatedFillerNumber(int rep) throws HL7Exception {
    EI ret = null;
    try {
        Type t = this.getField(4, rep);
        ret = (EI)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    }
    return ret;
  }

  /**
   * Returns all repetitions of Related Filler Number (TQ2-4).
   */
  public EI[] getRelatedFillerNumber() {
     EI[] ret = null;
    try {
        Type[] t = this.getField(4);  
        ret = new EI[t.length];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = (EI)t[i];
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
   * Returns a single repetition of Related Placer Group Number (TQ2-5).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public EI getRelatedPlacerGroupNumber(int rep) throws HL7Exception {
    EI ret = null;
    try {
        Type t = this.getField(5, rep);
        ret = (EI)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    }
    return ret;
  }

  /**
   * Returns all repetitions of Related Placer Group Number (TQ2-5).
   */
  public EI[] getRelatedPlacerGroupNumber() {
     EI[] ret = null;
    try {
        Type[] t = this.getField(5);  
        ret = new EI[t.length];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = (EI)t[i];
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
   * Returns Sequence Condition Code (TQ2-6).
   */
  public ID getSequenceConditionCode()  {
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
   * Returns Cyclic Entry/Exit Indicator (TQ2-7).
   */
  public ID getCyclicEntryExitIndicator()  {
    ID ret = null;
    try {
        Type t = this.getField(7, 0);
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
   * Returns Sequence Condition Time Interval (TQ2-8).
   */
  public CQ getSequenceConditionTimeInterval()  {
    CQ ret = null;
    try {
        Type t = this.getField(8, 0);
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

  /**
   * Returns Cyclic Group Maximum Number of Repeats (TQ2-9).
   */
  public NM getCyclicGroupMaximumNumberOfRepeats()  {
    NM ret = null;
    try {
        Type t = this.getField(9, 0);
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
   * Returns Special Service Request Relationship (TQ2-10).
   */
  public ID getSpecialServiceRequestRelationship()  {
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

}