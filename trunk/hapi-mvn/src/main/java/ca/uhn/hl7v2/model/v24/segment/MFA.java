package ca.uhn.hl7v2.model.v24.segment;

import ca.uhn.hl7v2.model.*;
import ca.uhn.hl7v2.model.v24.datatype.*;

import ca.uhn.log.HapiLogFactory;
import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.HL7Exception;

/**
 * <p>Represents an HL7 MFA message segment. 
 * This segment has the following fields:</p><p>
 * MFA-1: Record-Level Event Code (ID)<br> 
 * MFA-2: MFN Control ID (ST)<br> 
 * MFA-3: Event Completion Date/Time (TS)<br> 
 * MFA-4: MFN Record Level Error Return (CE)<br> 
 * MFA-5: Primary Key Value - MFA (CE)<br> 
 * MFA-6: Primary Key Value Type - MFA (ID)<br> 
 * </p><p>The get...() methods return data from individual fields.  These methods 
 * do not throw exceptions and may therefore have to handle exceptions internally.  
 * If an exception is handled internally, it is logged and null is returned.  
 * This is not expected to happen - if it does happen this indicates not so much 
 * an exceptional circumstance as a bug in the code for this class.</p>    
 */
public class MFA extends AbstractSegment  {

  /**
   * Creates a MFA (Master File Acknowledgment) segment object that belongs to the given 
   * message.  
   */
  public MFA(Group parent, ModelClassFactory factory) {
    super(parent, factory);
    Message message = getMessage();
    try {
       this.add(ID.class, true, 1, 3, new Object[]{message, new Integer(180)});
       this.add(ST.class, false, 1, 20, new Object[]{message});
       this.add(TS.class, false, 1, 26, new Object[]{message});
       this.add(CE.class, true, 1, 250, new Object[]{message});
       this.add(CE.class, true, 0, 250, new Object[]{message});
       this.add(ID.class, true, 0, 3, new Object[]{message, new Integer(355)});
    } catch (HL7Exception he) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Can't instantiate " + this.getClass().getName(), he);
    }
  }

  /**
   * Returns Record-Level Event Code (MFA-1).
   */
  public ID getRecordLevelEventCode()  {
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
   * Returns MFN Control ID (MFA-2).
   */
  public ST getMFNControlID()  {
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
   * Returns Event Completion Date/Time (MFA-3).
   */
  public TS getEventCompletionDateTime()  {
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
   * Returns MFN Record Level Error Return (MFA-4).
   */
  public CE getMFNRecordLevelErrorReturn()  {
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
   * Returns a single repetition of Primary Key Value - MFA (MFA-5).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public CE getPrimaryKeyValueMFA(int rep) throws HL7Exception {
    CE ret = null;
    try {
        Type t = this.getField(5, rep);
        ret = (CE)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    }
    return ret;
  }

  /**
   * Returns all repetitions of Primary Key Value - MFA (MFA-5).
   */
  public CE[] getPrimaryKeyValueMFA() {
     CE[] ret = null;
    try {
        Type[] t = this.getField(5);  
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
   * Returns a single repetition of Primary Key Value Type - MFA (MFA-6).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public ID getPrimaryKeyValueTypeMFA(int rep) throws HL7Exception {
    ID ret = null;
    try {
        Type t = this.getField(6, rep);
        ret = (ID)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    }
    return ret;
  }

  /**
   * Returns all repetitions of Primary Key Value Type - MFA (MFA-6).
   */
  public ID[] getPrimaryKeyValueTypeMFA() {
     ID[] ret = null;
    try {
        Type[] t = this.getField(6);  
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

}