package ca.uhn.hl7v2.model.v21.segment;

import ca.uhn.hl7v2.model.*;
import ca.uhn.hl7v2.model.v21.datatype.*;

import ca.uhn.log.HapiLogFactory;
import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.HL7Exception;

/**
 * <p>Represents an HL7 QRD message segment. 
 * This segment has the following fields:</p><p>
 * QRD-1: QUERY DATE/TIME (TS)<br> 
 * QRD-2: QUERY FORMAT CODE (ID)<br> 
 * QRD-3: QUERY PRIORITY (ID)<br> 
 * QRD-4: QUERY ID (ST)<br> 
 * QRD-5: DEFERRED RESPONSE TYPE (ID)<br> 
 * QRD-6: DEFERRED RESPONSE DATE/TIME (TS)<br> 
 * QRD-7: QUANTITY LIMITED REQUEST (CQ)<br> 
 * QRD-8: WHO SUBJECT FILTER (ST)<br> 
 * QRD-9: WHAT SUBJECT FILTER (ID)<br> 
 * QRD-10: WHAT DEPARTMENT DATA CODE (ST)<br> 
 * QRD-11: WHAT DATA CODE VALUE QUAL. (ST)<br> 
 * QRD-12: QUERY RESULTS LEVEL (ID)<br> 
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
       this.add(TS.class, true, 1, 19, new Object[]{message});
       this.add(ID.class, true, 1, 1, new Object[]{message, new Integer(106)});
       this.add(ID.class, true, 1, 1, new Object[]{message, new Integer(91)});
       this.add(ST.class, true, 1, 10, new Object[]{message});
       this.add(ID.class, false, 1, 1, new Object[]{message, new Integer(107)});
       this.add(TS.class, false, 1, 19, new Object[]{message});
       this.add(CQ.class, true, 1, 5, new Object[]{message});
       this.add(ST.class, true, 0, 20, new Object[]{message});
       this.add(ID.class, true, 0, 3, new Object[]{message, new Integer(48)});
       this.add(ST.class, true, 0, 20, new Object[]{message});
       this.add(ST.class, false, 0, 20, new Object[]{message});
       this.add(ID.class, false, 1, 1, new Object[]{message, new Integer(108)});
    } catch (HL7Exception he) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Can't instantiate " + this.getClass().getName(), he);
    }
  }

  /**
   * Returns QUERY DATE/TIME (QRD-1).
   */
  public TS getQUERYDATETIME()  {
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
   * Returns QUERY FORMAT CODE (QRD-2).
   */
  public ID getQUERYFORMATCODE()  {
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
   * Returns QUERY PRIORITY (QRD-3).
   */
  public ID getQUERYPRIORITY()  {
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
   * Returns QUERY ID (QRD-4).
   */
  public ST getQUERYID()  {
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
   * Returns DEFERRED RESPONSE TYPE (QRD-5).
   */
  public ID getDEFERREDRESPONSETYPE()  {
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
   * Returns DEFERRED RESPONSE DATE/TIME (QRD-6).
   */
  public TS getDEFERREDRESPONSEDATETIME()  {
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
   * Returns QUANTITY LIMITED REQUEST (QRD-7).
   */
  public CQ getQUANTITYLIMITEDREQUEST()  {
    CQ ret = null;
    try {
        Type t = this.getField(7, 0);
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
   * Returns a single repetition of WHO SUBJECT FILTER (QRD-8).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public ST getWHOSUBJECTFILTER(int rep) throws HL7Exception {
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
   * Returns all repetitions of WHO SUBJECT FILTER (QRD-8).
   */
  public ST[] getWHOSUBJECTFILTER() {
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
   * Returns a single repetition of WHAT SUBJECT FILTER (QRD-9).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public ID getWHATSUBJECTFILTER(int rep) throws HL7Exception {
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
   * Returns all repetitions of WHAT SUBJECT FILTER (QRD-9).
   */
  public ID[] getWHATSUBJECTFILTER() {
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
   * Returns a single repetition of WHAT DEPARTMENT DATA CODE (QRD-10).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public ST getWHATDEPARTMENTDATACODE(int rep) throws HL7Exception {
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
   * Returns all repetitions of WHAT DEPARTMENT DATA CODE (QRD-10).
   */
  public ST[] getWHATDEPARTMENTDATACODE() {
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
   * Returns a single repetition of WHAT DATA CODE VALUE QUAL. (QRD-11).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public ST getWHATDATACODEVALUEQUAL(int rep) throws HL7Exception {
    ST ret = null;
    try {
        Type t = this.getField(11, rep);
        ret = (ST)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    }
    return ret;
  }

  /**
   * Returns all repetitions of WHAT DATA CODE VALUE QUAL. (QRD-11).
   */
  public ST[] getWHATDATACODEVALUEQUAL() {
     ST[] ret = null;
    try {
        Type[] t = this.getField(11);  
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
   * Returns QUERY RESULTS LEVEL (QRD-12).
   */
  public ID getQUERYRESULTSLEVEL()  {
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