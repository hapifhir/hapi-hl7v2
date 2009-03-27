package ca.uhn.hl7v2.model.v21.segment;

import ca.uhn.hl7v2.model.*;
import ca.uhn.hl7v2.model.v21.datatype.*;

import ca.uhn.log.HapiLogFactory;
import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.HL7Exception;

/**
 * <p>Represents an HL7 URD message segment. 
 * This segment has the following fields:</p><p>
 * URD-1: R/U DATE/TIME (TS)<br> 
 * URD-2: REPORT PRIORITY (ID)<br> 
 * URD-3: R/U WHO SUBJECT DEFINITION (ST)<br> 
 * URD-4: R/U WHAT SUBJECT DEFINITION (ID)<br> 
 * URD-5: R/U WHAT DEPARTMENT CODE (ST)<br> 
 * URD-6: R/U DISPLAY/PRINT LOCATIONS (ST)<br> 
 * URD-7: R/U RESULTS LEVEL (ID)<br> 
 * </p><p>The get...() methods return data from individual fields.  These methods 
 * do not throw exceptions and may therefore have to handle exceptions internally.  
 * If an exception is handled internally, it is logged and null is returned.  
 * This is not expected to happen - if it does happen this indicates not so much 
 * an exceptional circumstance as a bug in the code for this class.</p>    
 */
public class URD extends AbstractSegment  {

  /**
   * Creates a URD (RESULTS/UPDATE DEFINITION) segment object that belongs to the given 
   * message.  
   */
  public URD(Group parent, ModelClassFactory factory) {
    super(parent, factory);
    Message message = getMessage();
    try {
       this.add(TS.class, false, 1, 19, new Object[]{message});
       this.add(ID.class, false, 1, 1, new Object[]{message, new Integer(109)});
       this.add(ST.class, true, 0, 20, new Object[]{message});
       this.add(ID.class, false, 0, 3, new Object[]{message, new Integer(48)});
       this.add(ST.class, false, 0, 20, new Object[]{message});
       this.add(ST.class, false, 0, 20, new Object[]{message});
       this.add(ID.class, false, 1, 1, new Object[]{message, new Integer(108)});
    } catch (HL7Exception he) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Can't instantiate " + this.getClass().getName(), he);
    }
  }

  /**
   * Returns R/U DATE/TIME (URD-1).
   */
  public TS getRUDATETIME()  {
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
   * Returns REPORT PRIORITY (URD-2).
   */
  public ID getREPORTPRIORITY()  {
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
   * Returns a single repetition of R/U WHO SUBJECT DEFINITION (URD-3).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public ST getRUWHOSUBJECTDEFINITION(int rep) throws HL7Exception {
    ST ret = null;
    try {
        Type t = this.getField(3, rep);
        ret = (ST)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    }
    return ret;
  }

  /**
   * Returns all repetitions of R/U WHO SUBJECT DEFINITION (URD-3).
   */
  public ST[] getRUWHOSUBJECTDEFINITION() {
     ST[] ret = null;
    try {
        Type[] t = this.getField(3);  
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
   * Returns a single repetition of R/U WHAT SUBJECT DEFINITION (URD-4).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public ID getRUWHATSUBJECTDEFINITION(int rep) throws HL7Exception {
    ID ret = null;
    try {
        Type t = this.getField(4, rep);
        ret = (ID)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    }
    return ret;
  }

  /**
   * Returns all repetitions of R/U WHAT SUBJECT DEFINITION (URD-4).
   */
  public ID[] getRUWHATSUBJECTDEFINITION() {
     ID[] ret = null;
    try {
        Type[] t = this.getField(4);  
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
   * Returns a single repetition of R/U WHAT DEPARTMENT CODE (URD-5).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public ST getRUWHATDEPARTMENTCODE(int rep) throws HL7Exception {
    ST ret = null;
    try {
        Type t = this.getField(5, rep);
        ret = (ST)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    }
    return ret;
  }

  /**
   * Returns all repetitions of R/U WHAT DEPARTMENT CODE (URD-5).
   */
  public ST[] getRUWHATDEPARTMENTCODE() {
     ST[] ret = null;
    try {
        Type[] t = this.getField(5);  
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
   * Returns a single repetition of R/U DISPLAY/PRINT LOCATIONS (URD-6).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public ST getRUDISPLAYPRINTLOCATIONS(int rep) throws HL7Exception {
    ST ret = null;
    try {
        Type t = this.getField(6, rep);
        ret = (ST)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    }
    return ret;
  }

  /**
   * Returns all repetitions of R/U DISPLAY/PRINT LOCATIONS (URD-6).
   */
  public ST[] getRUDISPLAYPRINTLOCATIONS() {
     ST[] ret = null;
    try {
        Type[] t = this.getField(6);  
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
   * Returns R/U RESULTS LEVEL (URD-7).
   */
  public ID getRURESULTSLEVEL()  {
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

}