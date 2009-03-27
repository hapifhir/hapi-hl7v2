package ca.uhn.hl7v2.model.v21.segment;

import ca.uhn.hl7v2.model.*;
import ca.uhn.hl7v2.model.v21.datatype.*;

import ca.uhn.log.HapiLogFactory;
import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.HL7Exception;

/**
 * <p>Represents an HL7 RX1 message segment. 
 * This segment has the following fields:</p><p>
 * RX1-1: UNUSED (ST)<br> 
 * RX1-2: UNUSED (ST)<br> 
 * RX1-3: ROUTE (ST)<br> 
 * RX1-4: SITE ADMINISTERED (ST)<br> 
 * RX1-5: IV SOLUTION RATE (CQ)<br> 
 * RX1-6: DRUG STRENGTH (CQ)<br> 
 * RX1-7: FINAL CONCENTRATION (NM)<br> 
 * RX1-8: FINAL VOLUME IN ML. (NM)<br> 
 * RX1-9: DRUG DOSE (CM)<br> 
 * RX1-10: DRUG ROLE (ID)<br> 
 * RX1-11: PRESCRIPTION SEQUENCE # (NM)<br> 
 * RX1-12: QUANTITY DISPENSED (CQ)<br> 
 * RX1-13: UNUSED (ST)<br> 
 * RX1-14: DRUG ID (CE)<br> 
 * RX1-15: COMPONENT DRUG IDS (ID)<br> 
 * RX1-16: PRESCRIPTION TYPE (ID)<br> 
 * RX1-17: SUBSTITUTION STATUS (ID)<br> 
 * RX1-18: RX ORDER STATUS (ID)<br> 
 * RX1-19: NUMBER OF REFILLS (NM)<br> 
 * RX1-20: UNUSED (ST)<br> 
 * RX1-21: REFILLS REMAINING (NM)<br> 
 * RX1-22: DEA CLASS (ID)<br> 
 * RX1-23: ORDERING MD'S DEA NUMBER (NM)<br> 
 * RX1-24: UNUSED (ST)<br> 
 * RX1-25: LAST REFILL DATE/TIME (TS)<br> 
 * RX1-26: RX NUMBER (ST)<br> 
 * RX1-27: PRN STATUS (ID)<br> 
 * RX1-28: PHARMACY INSTRUCTIONS (TX)<br> 
 * RX1-29: PATIENT INSTRUCTIONS (TX)<br> 
 * RX1-30: INSTRUCTIONS (SIG) (TX)<br> 
 * </p><p>The get...() methods return data from individual fields.  These methods 
 * do not throw exceptions and may therefore have to handle exceptions internally.  
 * If an exception is handled internally, it is logged and null is returned.  
 * This is not expected to happen - if it does happen this indicates not so much 
 * an exceptional circumstance as a bug in the code for this class.</p>    
 */
public class RX1 extends AbstractSegment  {

  /**
   * Creates a RX1 (PHARMACY ORDER) segment object that belongs to the given 
   * message.  
   */
  public RX1(Group parent, ModelClassFactory factory) {
    super(parent, factory);
    Message message = getMessage();
    try {
       this.add(ST.class, false, 1, 0, new Object[]{message});
       this.add(ST.class, false, 1, 0, new Object[]{message});
       this.add(ST.class, false, 1, 8, new Object[]{message});
       this.add(ST.class, false, 1, 20, new Object[]{message});
       this.add(CQ.class, false, 1, 10, new Object[]{message});
       this.add(CQ.class, false, 1, 14, new Object[]{message});
       this.add(NM.class, false, 1, 10, new Object[]{message});
       this.add(NM.class, false, 1, 10, new Object[]{message});
       this.add(CM.class, false, 1, 10, new Object[]{message});
       this.add(ID.class, false, 1, 1, new Object[]{message, new Integer(0)});
       this.add(NM.class, false, 1, 3, new Object[]{message});
       this.add(CQ.class, false, 1, 4, new Object[]{message});
       this.add(ST.class, false, 1, 0, new Object[]{message});
       this.add(CE.class, false, 1, 5, new Object[]{message});
       this.add(ID.class, false, 5, 5, new Object[]{message, new Integer(0)});
       this.add(ID.class, false, 1, 2, new Object[]{message, new Integer(0)});
       this.add(ID.class, false, 1, 1, new Object[]{message, new Integer(0)});
       this.add(ID.class, false, 1, 2, new Object[]{message, new Integer(38)});
       this.add(NM.class, false, 1, 3, new Object[]{message});
       this.add(ST.class, false, 1, 0, new Object[]{message});
       this.add(NM.class, false, 1, 3, new Object[]{message});
       this.add(ID.class, false, 1, 5, new Object[]{message, new Integer(0)});
       this.add(NM.class, false, 1, 10, new Object[]{message});
       this.add(ST.class, false, 1, 0, new Object[]{message});
       this.add(TS.class, false, 1, 19, new Object[]{message});
       this.add(ST.class, false, 1, 20, new Object[]{message});
       this.add(ID.class, false, 1, 5, new Object[]{message, new Integer(0)});
       this.add(TX.class, false, 5, 80, new Object[]{message});
       this.add(TX.class, false, 5, 80, new Object[]{message});
       this.add(TX.class, false, 0, 500, new Object[]{message});
    } catch (HL7Exception he) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Can't instantiate " + this.getClass().getName(), he);
    }
  }

  /**
   * Returns ROUTE (RX1-3).
   */
  public ST getROUTE()  {
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
   * Returns SITE ADMINISTERED (RX1-4).
   */
  public ST getSITEADMINISTERED()  {
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
   * Returns IV SOLUTION RATE (RX1-5).
   */
  public CQ getIVSOLUTIONRATE()  {
    CQ ret = null;
    try {
        Type t = this.getField(5, 0);
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
   * Returns DRUG STRENGTH (RX1-6).
   */
  public CQ getDRUGSTRENGTH()  {
    CQ ret = null;
    try {
        Type t = this.getField(6, 0);
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
   * Returns FINAL CONCENTRATION (RX1-7).
   */
  public NM getFINALCONCENTRATION()  {
    NM ret = null;
    try {
        Type t = this.getField(7, 0);
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
   * Returns FINAL VOLUME IN ML. (RX1-8).
   */
  public NM getFINALVOLUMEINML()  {
    NM ret = null;
    try {
        Type t = this.getField(8, 0);
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
   * Returns DRUG DOSE (RX1-9).
   */
  public CM getDRUGDOSE()  {
    CM ret = null;
    try {
        Type t = this.getField(9, 0);
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

  /**
   * Returns DRUG ROLE (RX1-10).
   */
  public ID getDRUGROLE()  {
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
   * Returns PRESCRIPTION SEQUENCE # (RX1-11).
   */
  public NM getPRESCRIPTIONSEQUENCE()  {
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
   * Returns QUANTITY DISPENSED (RX1-12).
   */
  public CQ getQUANTITYDISPENSED()  {
    CQ ret = null;
    try {
        Type t = this.getField(12, 0);
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
   * Returns DRUG ID (RX1-14).
   */
  public CE getDRUGID()  {
    CE ret = null;
    try {
        Type t = this.getField(14, 0);
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
   * Returns a single repetition of COMPONENT DRUG IDS (RX1-15).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public ID getCOMPONENTDRUGIDS(int rep) throws HL7Exception {
    ID ret = null;
    try {
        Type t = this.getField(15, rep);
        ret = (ID)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    }
    return ret;
  }

  /**
   * Returns all repetitions of COMPONENT DRUG IDS (RX1-15).
   */
  public ID[] getCOMPONENTDRUGIDS() {
     ID[] ret = null;
    try {
        Type[] t = this.getField(15);  
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
   * Returns PRESCRIPTION TYPE (RX1-16).
   */
  public ID getPRESCRIPTIONTYPE()  {
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
   * Returns SUBSTITUTION STATUS (RX1-17).
   */
  public ID getSUBSTITUTIONSTATUS()  {
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
   * Returns RX ORDER STATUS (RX1-18).
   */
  public ID getRXORDERSTATUS()  {
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
   * Returns NUMBER OF REFILLS (RX1-19).
   */
  public NM getNUMBEROFREFILLS()  {
    NM ret = null;
    try {
        Type t = this.getField(19, 0);
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
   * Returns REFILLS REMAINING (RX1-21).
   */
  public NM getREFILLSREMAINING()  {
    NM ret = null;
    try {
        Type t = this.getField(21, 0);
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
   * Returns DEA CLASS (RX1-22).
   */
  public ID getDEACLASS()  {
    ID ret = null;
    try {
        Type t = this.getField(22, 0);
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
   * Returns ORDERING MD'S DEA NUMBER (RX1-23).
   */
  public NM getORDERINGMDSDEANUMBER()  {
    NM ret = null;
    try {
        Type t = this.getField(23, 0);
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
   * Returns LAST REFILL DATE/TIME (RX1-25).
   */
  public TS getLASTREFILLDATETIME()  {
    TS ret = null;
    try {
        Type t = this.getField(25, 0);
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
   * Returns RX NUMBER (RX1-26).
   */
  public ST getRXNUMBER()  {
    ST ret = null;
    try {
        Type t = this.getField(26, 0);
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
   * Returns PRN STATUS (RX1-27).
   */
  public ID getPRNSTATUS()  {
    ID ret = null;
    try {
        Type t = this.getField(27, 0);
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
   * Returns a single repetition of PHARMACY INSTRUCTIONS (RX1-28).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public TX getPHARMACYINSTRUCTIONS(int rep) throws HL7Exception {
    TX ret = null;
    try {
        Type t = this.getField(28, rep);
        ret = (TX)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    }
    return ret;
  }

  /**
   * Returns all repetitions of PHARMACY INSTRUCTIONS (RX1-28).
   */
  public TX[] getPHARMACYINSTRUCTIONS() {
     TX[] ret = null;
    try {
        Type[] t = this.getField(28);  
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
   * Returns a single repetition of PATIENT INSTRUCTIONS (RX1-29).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public TX getPATIENTINSTRUCTIONS(int rep) throws HL7Exception {
    TX ret = null;
    try {
        Type t = this.getField(29, rep);
        ret = (TX)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    }
    return ret;
  }

  /**
   * Returns all repetitions of PATIENT INSTRUCTIONS (RX1-29).
   */
  public TX[] getPATIENTINSTRUCTIONS() {
     TX[] ret = null;
    try {
        Type[] t = this.getField(29);  
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
   * Returns a single repetition of INSTRUCTIONS (SIG) (RX1-30).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public TX getINSTRUCTIONS(int rep) throws HL7Exception {
    TX ret = null;
    try {
        Type t = this.getField(30, rep);
        ret = (TX)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    }
    return ret;
  }

  /**
   * Returns all repetitions of INSTRUCTIONS (SIG) (RX1-30).
   */
  public TX[] getINSTRUCTIONS() {
     TX[] ret = null;
    try {
        Type[] t = this.getField(30);  
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

}