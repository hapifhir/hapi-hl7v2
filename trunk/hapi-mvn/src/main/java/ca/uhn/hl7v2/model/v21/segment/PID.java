package ca.uhn.hl7v2.model.v21.segment;

import ca.uhn.hl7v2.model.*;
import ca.uhn.hl7v2.model.v21.datatype.*;

import ca.uhn.log.HapiLogFactory;
import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.HL7Exception;

/**
 * <p>Represents an HL7 PID message segment. 
 * This segment has the following fields:</p><p>
 * PID-1: SET ID - PATIENT ID (SI)<br> 
 * PID-2: PATIENT ID EXTERNAL (EXTERNAL ID) (CK)<br> 
 * PID-3: PATIENT ID INTERNAL (INTERNAL ID) (CK)<br> 
 * PID-4: ALTERNATE PATIENT ID (ST)<br> 
 * PID-5: PATIENT NAME (PN)<br> 
 * PID-6: MOTHER'S MAIDEN NAME (ST)<br> 
 * PID-7: DATE OF BIRTH (DT)<br> 
 * PID-8: SEX (ID)<br> 
 * PID-9: PATIENT ALIAS (PN)<br> 
 * PID-10: ETHNIC GROUP (ID)<br> 
 * PID-11: PATIENT ADDRESS (AD)<br> 
 * PID-12: COUNTY CODE (ID)<br> 
 * PID-13: PHONE NUMBER - HOME (TN)<br> 
 * PID-14: PHONE NUMBER - BUSINESS (TN)<br> 
 * PID-15: LANGUAGE - PATIENT (ST)<br> 
 * PID-16: MARITAL STATUS (ID)<br> 
 * PID-17: RELIGION (ID)<br> 
 * PID-18: PATIENT ACCOUNT NUMBER (CK)<br> 
 * PID-19: SSN NUMBER - PATIENT (ST)<br> 
 * PID-20: DRIVER'S LIC NUM - PATIENT (CM)<br> 
 * </p><p>The get...() methods return data from individual fields.  These methods 
 * do not throw exceptions and may therefore have to handle exceptions internally.  
 * If an exception is handled internally, it is logged and null is returned.  
 * This is not expected to happen - if it does happen this indicates not so much 
 * an exceptional circumstance as a bug in the code for this class.</p>    
 */
public class PID extends AbstractSegment  {

  /**
   * Creates a PID (PATIENT IDENTIFICATION) segment object that belongs to the given 
   * message.  
   */
  public PID(Group parent, ModelClassFactory factory) {
    super(parent, factory);
    Message message = getMessage();
    try {
       this.add(SI.class, false, 1, 4, new Object[]{message});
       this.add(CK.class, false, 1, 16, new Object[]{message});
       this.add(CK.class, true, 1, 16, new Object[]{message});
       this.add(ST.class, false, 1, 12, new Object[]{message});
       this.add(PN.class, true, 1, 48, new Object[]{message});
       this.add(ST.class, false, 1, 30, new Object[]{message});
       this.add(DT.class, false, 1, 8, new Object[]{message});
       this.add(ID.class, false, 1, 1, new Object[]{message, new Integer(1)});
       this.add(PN.class, false, 0, 48, new Object[]{message});
       this.add(ID.class, false, 1, 1, new Object[]{message, new Integer(5)});
       this.add(AD.class, false, 1, 106, new Object[]{message});
       this.add(ID.class, false, 1, 4, new Object[]{message, new Integer(0)});
       this.add(TN.class, false, 3, 40, new Object[]{message});
       this.add(TN.class, false, 3, 40, new Object[]{message});
       this.add(ST.class, false, 1, 25, new Object[]{message});
       this.add(ID.class, false, 1, 1, new Object[]{message, new Integer(2)});
       this.add(ID.class, false, 1, 3, new Object[]{message, new Integer(6)});
       this.add(CK.class, false, 1, 20, new Object[]{message});
       this.add(ST.class, false, 1, 16, new Object[]{message});
       this.add(CM.class, false, 1, 25, new Object[]{message});
    } catch (HL7Exception he) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Can't instantiate " + this.getClass().getName(), he);
    }
  }

  /**
   * Returns SET ID - PATIENT ID (PID-1).
   */
  public SI getSETIDPATIENTID()  {
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
   * Returns PATIENT ID EXTERNAL (EXTERNAL ID) (PID-2).
   */
  public CK getPATIENTIDEXTERNALEXTERNALID()  {
    CK ret = null;
    try {
        Type t = this.getField(2, 0);
        ret = (CK)t;
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
   * Returns PATIENT ID INTERNAL (INTERNAL ID) (PID-3).
   */
  public CK getPATIENTIDINTERNALINTERNALID()  {
    CK ret = null;
    try {
        Type t = this.getField(3, 0);
        ret = (CK)t;
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
   * Returns ALTERNATE PATIENT ID (PID-4).
   */
  public ST getALTERNATEPATIENTID()  {
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
   * Returns PATIENT NAME (PID-5).
   */
  public PN getPATIENTNAME()  {
    PN ret = null;
    try {
        Type t = this.getField(5, 0);
        ret = (PN)t;
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
   * Returns MOTHER'S MAIDEN NAME (PID-6).
   */
  public ST getMOTHERSMAIDENNAME()  {
    ST ret = null;
    try {
        Type t = this.getField(6, 0);
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
   * Returns DATE OF BIRTH (PID-7).
   */
  public DT getDATEOFBIRTH()  {
    DT ret = null;
    try {
        Type t = this.getField(7, 0);
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
   * Returns SEX (PID-8).
   */
  public ID getSEX()  {
    ID ret = null;
    try {
        Type t = this.getField(8, 0);
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
   * Returns a single repetition of PATIENT ALIAS (PID-9).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public PN getPATIENTALIAS(int rep) throws HL7Exception {
    PN ret = null;
    try {
        Type t = this.getField(9, rep);
        ret = (PN)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    }
    return ret;
  }

  /**
   * Returns all repetitions of PATIENT ALIAS (PID-9).
   */
  public PN[] getPATIENTALIAS() {
     PN[] ret = null;
    try {
        Type[] t = this.getField(9);  
        ret = new PN[t.length];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = (PN)t[i];
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
   * Returns ETHNIC GROUP (PID-10).
   */
  public ID getETHNICGROUP()  {
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

  /**
   * Returns PATIENT ADDRESS (PID-11).
   */
  public AD getPATIENTADDRESS()  {
    AD ret = null;
    try {
        Type t = this.getField(11, 0);
        ret = (AD)t;
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
   * Returns COUNTY CODE (PID-12).
   */
  public ID getCOUNTYCODE()  {
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

  /**
   * Returns a single repetition of PHONE NUMBER - HOME (PID-13).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public TN getPHONENUMBERHOME(int rep) throws HL7Exception {
    TN ret = null;
    try {
        Type t = this.getField(13, rep);
        ret = (TN)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    }
    return ret;
  }

  /**
   * Returns all repetitions of PHONE NUMBER - HOME (PID-13).
   */
  public TN[] getPHONENUMBERHOME() {
     TN[] ret = null;
    try {
        Type[] t = this.getField(13);  
        ret = new TN[t.length];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = (TN)t[i];
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
   * Returns a single repetition of PHONE NUMBER - BUSINESS (PID-14).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public TN getPHONENUMBERBUSINESS(int rep) throws HL7Exception {
    TN ret = null;
    try {
        Type t = this.getField(14, rep);
        ret = (TN)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    }
    return ret;
  }

  /**
   * Returns all repetitions of PHONE NUMBER - BUSINESS (PID-14).
   */
  public TN[] getPHONENUMBERBUSINESS() {
     TN[] ret = null;
    try {
        Type[] t = this.getField(14);  
        ret = new TN[t.length];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = (TN)t[i];
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
   * Returns LANGUAGE - PATIENT (PID-15).
   */
  public ST getLANGUAGEPATIENT()  {
    ST ret = null;
    try {
        Type t = this.getField(15, 0);
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
   * Returns MARITAL STATUS (PID-16).
   */
  public ID getMARITALSTATUS()  {
    ID ret = null;
    try {
        Type t = this.getField(16, 0);
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
   * Returns RELIGION (PID-17).
   */
  public ID getRELIGION()  {
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
   * Returns PATIENT ACCOUNT NUMBER (PID-18).
   */
  public CK getPATIENTACCOUNTNUMBER()  {
    CK ret = null;
    try {
        Type t = this.getField(18, 0);
        ret = (CK)t;
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
   * Returns SSN NUMBER - PATIENT (PID-19).
   */
  public ST getSSNNUMBERPATIENT()  {
    ST ret = null;
    try {
        Type t = this.getField(19, 0);
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
   * Returns DRIVER'S LIC NUM - PATIENT (PID-20).
   */
  public CM getDRIVERSLICNUMPATIENT()  {
    CM ret = null;
    try {
        Type t = this.getField(20, 0);
        ret = (CM)t;
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