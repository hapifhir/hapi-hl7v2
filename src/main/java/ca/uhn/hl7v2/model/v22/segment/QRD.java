package ca.uhn.hl7v2.model.v22.segment;

import ca.uhn.hl7v2.model.*;
import ca.uhn.hl7v2.model.v22.datatype.*;

import ca.uhn.log.HapiLogFactory;
import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.HL7Exception;

/**
 * <p>Represents an HL7 QRD message segment. 
 * This segment has the following fields:</p><p>
 * QRD-1: Query date / time (TS)<br> 
 * QRD-2: Query Format Code (ID)<br> 
 * QRD-3: Query Priority (ID)<br> 
 * QRD-4: Query ID (ST)<br> 
 * QRD-5: Deferred Response Type (ID)<br> 
 * QRD-6: Deferred response date / time (TS)<br> 
 * QRD-7: Quantity Limited Request (CQ_QUANTITY)<br> 
 * QRD-8: Who Subject Filter (ST)<br> 
 * QRD-9: What Subject Filter (ID)<br> 
 * QRD-10: What Department Data Code (ST)<br> 
 * QRD-11: What data code value qualifier (CM_VR)<br> 
 * QRD-12: Query Results Level (ID)<br> 
 * </p><p>The get...() methods return data from individual fields.  These methods 
 * do not throw exceptions and may therefore have to handle exceptions internally.  
 * If an exception is handled internally, it is logged and null is returned.  
 * This is not expected to happen - if it does happen this indicates not so much 
 * an exceptional circumstance as a bug in the code for this class.</p>    
 */
public class QRD extends AbstractSegment  {

  /**
   * Creates a QRD (QUERY DEFINITION) segment object that belongs to the given 
   * message.  
   */
  public QRD(Group parent, ModelClassFactory factory) {
    super(parent, factory);
    Message message = getMessage();
    try {
       this.add(TS.class, true, 1, 26, new Object[]{message});
       this.add(ID.class, true, 1, 1, new Object[]{message, new Integer(106)});
       this.add(ID.class, true, 1, 1, new Object[]{message, new Integer(91)});
       this.add(ST.class, true, 1, 10, new Object[]{message});
       this.add(ID.class, false, 1, 1, new Object[]{message, new Integer(107)});
       this.add(TS.class, false, 1, 26, new Object[]{message});
       this.add(CQ_QUANTITY.class, true, 1, 10, new Object[]{message});
       this.add(ST.class, true, 0, 20, new Object[]{message});
       this.add(ID.class, true, 0, 3, new Object[]{message, new Integer(48)});
       this.add(ST.class, true, 0, 20, new Object[]{message});
       this.add(CM_VR.class, false, 0, 20, new Object[]{message});
       this.add(ID.class, false, 1, 1, new Object[]{message, new Integer(108)});
    } catch (HL7Exception he) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Can't instantiate " + this.getClass().getName(), he);
    }
  }

  /**
   * Returns Query date / time (QRD-1).
   */
  public TS getQueryDateTime()  {
    TS ret = null;
    try {
        Type t = this.getField(1, 0);
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
   * Returns Query Format Code (QRD-2).
   */
  public ID getQueryFormatCode()  {
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
   * Returns Query Priority (QRD-3).
   */
  public ID getQueryPriority()  {
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
   * Returns Query ID (QRD-4).
   */
  public ST getQueryID()  {
    ST ret = null;
    try {
        Type t = this.getField(4, 0);
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
   * Returns Deferred Response Type (QRD-5).
   */
  public ID getDeferredResponseType()  {
    ID ret = null;
    try {
        Type t = this.getField(5, 0);
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
   * Returns Deferred response date / time (QRD-6).
   */
  public TS getDeferredResponseDateTime()  {
    TS ret = null;
    try {
        Type t = this.getField(6, 0);
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
   * Returns Quantity Limited Request (QRD-7).
   */
  public CQ_QUANTITY getQuantityLimitedRequest()  {
    CQ_QUANTITY ret = null;
    try {
        Type t = this.getField(7, 0);
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
   * Returns a single repetition of Who Subject Filter (QRD-8).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public ST getWhoSubjectFilter(int rep) throws HL7Exception {
    ST ret = null;
    try {
        Type t = this.getField(8, rep);
        ret = (ST)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    }
    return ret;
  }

  /**
   * Returns all repetitions of Who Subject Filter (QRD-8).
   */
  public ST[] getWhoSubjectFilter() {
     ST[] ret = null;
    try {
        Type[] t = this.getField(8);  
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
   * Returns a single repetition of What Subject Filter (QRD-9).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public ID getWhatSubjectFilter(int rep) throws HL7Exception {
    ID ret = null;
    try {
        Type t = this.getField(9, rep);
        ret = (ID)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    }
    return ret;
  }

  /**
   * Returns all repetitions of What Subject Filter (QRD-9).
   */
  public ID[] getWhatSubjectFilter() {
     ID[] ret = null;
    try {
        Type[] t = this.getField(9);  
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
   * Returns a single repetition of What Department Data Code (QRD-10).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public ST getWhatDepartmentDataCode(int rep) throws HL7Exception {
    ST ret = null;
    try {
        Type t = this.getField(10, rep);
        ret = (ST)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    }
    return ret;
  }

  /**
   * Returns all repetitions of What Department Data Code (QRD-10).
   */
  public ST[] getWhatDepartmentDataCode() {
     ST[] ret = null;
    try {
        Type[] t = this.getField(10);  
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
   * Returns a single repetition of What data code value qualifier (QRD-11).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public CM_VR getWhatDataCodeValueQualifier(int rep) throws HL7Exception {
    CM_VR ret = null;
    try {
        Type t = this.getField(11, rep);
        ret = (CM_VR)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    }
    return ret;
  }

  /**
   * Returns all repetitions of What data code value qualifier (QRD-11).
   */
  public CM_VR[] getWhatDataCodeValueQualifier() {
     CM_VR[] ret = null;
    try {
        Type[] t = this.getField(11);  
        ret = new CM_VR[t.length];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = (CM_VR)t[i];
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
   * Returns Query Results Level (QRD-12).
   */
  public ID getQueryResultsLevel()  {
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

}