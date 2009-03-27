package ca.uhn.hl7v2.model.v21.segment;

import ca.uhn.hl7v2.model.*;
import ca.uhn.hl7v2.model.v21.datatype.*;

import ca.uhn.log.HapiLogFactory;
import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.HL7Exception;

/**
 * <p>Represents an HL7 PV1 message segment. 
 * This segment has the following fields:</p><p>
 * PV1-1: SET ID - PATIENT VISIT (SI)<br> 
 * PV1-2: PATIENT CLASS (ID)<br> 
 * PV1-3: ASSIGNED PATIENT LOCATION (ID)<br> 
 * PV1-4: ADMISSION TYPE (ID)<br> 
 * PV1-5: PRE-ADMIT NUMBER (ST)<br> 
 * PV1-6: PRIOR PATIENT LOCATION (ID)<br> 
 * PV1-7: ATTENDING DOCTOR (CN)<br> 
 * PV1-8: REFERRING DOCTOR (CN)<br> 
 * PV1-9: CONSULTING DOCTOR (CN)<br> 
 * PV1-10: HOSPITAL SERVICE (ID)<br> 
 * PV1-11: TEMPORARY LOCATION (ID)<br> 
 * PV1-12: PRE-ADMIT TEST INDICATOR (ID)<br> 
 * PV1-13: RE-ADMISSION INDICATOR (ID)<br> 
 * PV1-14: ADMIT SOURCE (ID)<br> 
 * PV1-15: AMBULATORY STATUS (ID)<br> 
 * PV1-16: VIP INDICATOR (ID)<br> 
 * PV1-17: ADMITTING DOCTOR (CN)<br> 
 * PV1-18: PATIENT TYPE (ID)<br> 
 * PV1-19: VISIT NUMBER (NM)<br> 
 * PV1-20: FINANCIAL CLASS (ID)<br> 
 * PV1-21: CHARGE PRICE INDICATOR (ID)<br> 
 * PV1-22: COURTESY CODE (ID)<br> 
 * PV1-23: CREDIT RATING (ID)<br> 
 * PV1-24: CONTRACT CODE (ID)<br> 
 * PV1-25: CONTRACT EFFECTIVE DATE (DT)<br> 
 * PV1-26: CONTRACT AMOUNT (NM)<br> 
 * PV1-27: CONTRACT PERIOD (NM)<br> 
 * PV1-28: INTEREST CODE (ID)<br> 
 * PV1-29: TRANSFER TO BAD DEBT CODE (ID)<br> 
 * PV1-30: TRANSFER TO BAD DEBT DATE (DT)<br> 
 * PV1-31: BAD DEBT AGENCY CODE (ST)<br> 
 * PV1-32: BAD DEBT TRANSFER AMOUNT (NM)<br> 
 * PV1-33: BAD DEBT RECOVERY AMOUNT (NM)<br> 
 * PV1-34: DELETE ACCOUNT INDICATOR (ID)<br> 
 * PV1-35: DELETE ACCOUNT DATE (DT)<br> 
 * PV1-36: DISCHARGE DISPOSITION (ID)<br> 
 * PV1-37: DISCHARGED TO LOCATION (ID)<br> 
 * PV1-38: DIET TYPE (ID)<br> 
 * PV1-39: SERVICING FACILITY (ID)<br> 
 * PV1-40: BED STATUS (ID)<br> 
 * PV1-41: ACCOUNT STATUS (ID)<br> 
 * PV1-42: PENDING LOCATION (ID)<br> 
 * PV1-43: PRIOR TEMPORARY LOCATION (ID)<br> 
 * PV1-44: ADMIT DATE/TIME (TS)<br> 
 * PV1-45: DISCHARGE DATE/TIME (TS)<br> 
 * PV1-46: CURRENT PATIENT BALANCE (NM)<br> 
 * PV1-47: TOTAL CHARGES (NM)<br> 
 * PV1-48: TOTAL ADJUSTMENTS (NM)<br> 
 * PV1-49: TOTAL PAYMENTS (NM)<br> 
 * </p><p>The get...() methods return data from individual fields.  These methods 
 * do not throw exceptions and may therefore have to handle exceptions internally.  
 * If an exception is handled internally, it is logged and null is returned.  
 * This is not expected to happen - if it does happen this indicates not so much 
 * an exceptional circumstance as a bug in the code for this class.</p>    
 */
public class PV1 extends AbstractSegment  {

  /**
   * Creates a PV1 (PATIENT VISIT) segment object that belongs to the given 
   * message.  
   */
  public PV1(Group parent, ModelClassFactory factory) {
    super(parent, factory);
    Message message = getMessage();
    try {
       this.add(SI.class, false, 1, 4, new Object[]{message});
       this.add(ID.class, true, 1, 1, new Object[]{message, new Integer(4)});
       this.add(ID.class, true, 1, 12, new Object[]{message, new Integer(79)});
       this.add(ID.class, false, 1, 2, new Object[]{message, new Integer(7)});
       this.add(ST.class, false, 1, 20, new Object[]{message});
       this.add(ID.class, false, 1, 12, new Object[]{message, new Integer(79)});
       this.add(CN.class, false, 1, 60, new Object[]{message});
       this.add(CN.class, false, 1, 60, new Object[]{message});
       this.add(CN.class, false, 0, 60, new Object[]{message});
       this.add(ID.class, false, 1, 3, new Object[]{message, new Integer(69)});
       this.add(ID.class, false, 1, 12, new Object[]{message, new Integer(79)});
       this.add(ID.class, false, 1, 2, new Object[]{message, new Integer(87)});
       this.add(ID.class, false, 1, 2, new Object[]{message, new Integer(92)});
       this.add(ID.class, false, 1, 3, new Object[]{message, new Integer(23)});
       this.add(ID.class, false, 1, 2, new Object[]{message, new Integer(9)});
       this.add(ID.class, false, 1, 2, new Object[]{message, new Integer(99)});
       this.add(CN.class, false, 1, 60, new Object[]{message});
       this.add(ID.class, false, 1, 2, new Object[]{message, new Integer(18)});
       this.add(NM.class, false, 1, 4, new Object[]{message});
       this.add(ID.class, false, 4, 11, new Object[]{message, new Integer(64)});
       this.add(ID.class, false, 1, 2, new Object[]{message, new Integer(32)});
       this.add(ID.class, false, 1, 2, new Object[]{message, new Integer(45)});
       this.add(ID.class, false, 1, 2, new Object[]{message, new Integer(46)});
       this.add(ID.class, false, 0, 2, new Object[]{message, new Integer(44)});
       this.add(DT.class, false, 0, 8, new Object[]{message});
       this.add(NM.class, false, 0, 12, new Object[]{message});
       this.add(NM.class, false, 0, 3, new Object[]{message});
       this.add(ID.class, false, 1, 2, new Object[]{message, new Integer(73)});
       this.add(ID.class, false, 1, 1, new Object[]{message, new Integer(110)});
       this.add(DT.class, false, 1, 8, new Object[]{message});
       this.add(ST.class, false, 1, 10, new Object[]{message});
       this.add(NM.class, false, 1, 12, new Object[]{message});
       this.add(NM.class, false, 1, 12, new Object[]{message});
       this.add(ID.class, false, 1, 1, new Object[]{message, new Integer(111)});
       this.add(DT.class, false, 1, 8, new Object[]{message});
       this.add(ID.class, false, 1, 2, new Object[]{message, new Integer(112)});
       this.add(ID.class, false, 1, 2, new Object[]{message, new Integer(113)});
       this.add(ID.class, false, 1, 2, new Object[]{message, new Integer(114)});
       this.add(ID.class, false, 1, 2, new Object[]{message, new Integer(115)});
       this.add(ID.class, false, 1, 1, new Object[]{message, new Integer(116)});
       this.add(ID.class, false, 1, 2, new Object[]{message, new Integer(117)});
       this.add(ID.class, false, 1, 12, new Object[]{message, new Integer(79)});
       this.add(ID.class, false, 1, 12, new Object[]{message, new Integer(79)});
       this.add(TS.class, false, 1, 19, new Object[]{message});
       this.add(TS.class, false, 1, 19, new Object[]{message});
       this.add(NM.class, false, 1, 12, new Object[]{message});
       this.add(NM.class, false, 1, 12, new Object[]{message});
       this.add(NM.class, false, 1, 12, new Object[]{message});
       this.add(NM.class, false, 1, 12, new Object[]{message});
    } catch (HL7Exception he) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Can't instantiate " + this.getClass().getName(), he);
    }
  }

  /**
   * Returns SET ID - PATIENT VISIT (PV1-1).
   */
  public SI getSETIDPATIENTVISIT()  {
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
   * Returns PATIENT CLASS (PV1-2).
   */
  public ID getPATIENTCLASS()  {
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
   * Returns ASSIGNED PATIENT LOCATION (PV1-3).
   */
  public ID getASSIGNEDPATIENTLOCATION()  {
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
   * Returns ADMISSION TYPE (PV1-4).
   */
  public ID getADMISSIONTYPE()  {
    ID ret = null;
    try {
        Type t = this.getField(4, 0);
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
   * Returns PRE-ADMIT NUMBER (PV1-5).
   */
  public ST getPREADMITNUMBER()  {
    ST ret = null;
    try {
        Type t = this.getField(5, 0);
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
   * Returns PRIOR PATIENT LOCATION (PV1-6).
   */
  public ID getPRIORPATIENTLOCATION()  {
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
   * Returns ATTENDING DOCTOR (PV1-7).
   */
  public CN getATTENDINGDOCTOR()  {
    CN ret = null;
    try {
        Type t = this.getField(7, 0);
        ret = (CN)t;
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
   * Returns REFERRING DOCTOR (PV1-8).
   */
  public CN getREFERRINGDOCTOR()  {
    CN ret = null;
    try {
        Type t = this.getField(8, 0);
        ret = (CN)t;
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
   * Returns a single repetition of CONSULTING DOCTOR (PV1-9).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public CN getCONSULTINGDOCTOR(int rep) throws HL7Exception {
    CN ret = null;
    try {
        Type t = this.getField(9, rep);
        ret = (CN)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    }
    return ret;
  }

  /**
   * Returns all repetitions of CONSULTING DOCTOR (PV1-9).
   */
  public CN[] getCONSULTINGDOCTOR() {
     CN[] ret = null;
    try {
        Type[] t = this.getField(9);  
        ret = new CN[t.length];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = (CN)t[i];
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
   * Returns HOSPITAL SERVICE (PV1-10).
   */
  public ID getHOSPITALSERVICE()  {
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
   * Returns TEMPORARY LOCATION (PV1-11).
   */
  public ID getTEMPORARYLOCATION()  {
    ID ret = null;
    try {
        Type t = this.getField(11, 0);
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
   * Returns PRE-ADMIT TEST INDICATOR (PV1-12).
   */
  public ID getPREADMITTESTINDICATOR()  {
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
   * Returns RE-ADMISSION INDICATOR (PV1-13).
   */
  public ID getREADMISSIONINDICATOR()  {
    ID ret = null;
    try {
        Type t = this.getField(13, 0);
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
   * Returns ADMIT SOURCE (PV1-14).
   */
  public ID getADMITSOURCE()  {
    ID ret = null;
    try {
        Type t = this.getField(14, 0);
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
   * Returns AMBULATORY STATUS (PV1-15).
   */
  public ID getAMBULATORYSTATUS()  {
    ID ret = null;
    try {
        Type t = this.getField(15, 0);
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
   * Returns VIP INDICATOR (PV1-16).
   */
  public ID getVIPINDICATOR()  {
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
   * Returns ADMITTING DOCTOR (PV1-17).
   */
  public CN getADMITTINGDOCTOR()  {
    CN ret = null;
    try {
        Type t = this.getField(17, 0);
        ret = (CN)t;
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
   * Returns PATIENT TYPE (PV1-18).
   */
  public ID getPATIENTTYPE()  {
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
   * Returns VISIT NUMBER (PV1-19).
   */
  public NM getVISITNUMBER()  {
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
   * Returns a single repetition of FINANCIAL CLASS (PV1-20).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public ID getFINANCIALCLASS(int rep) throws HL7Exception {
    ID ret = null;
    try {
        Type t = this.getField(20, rep);
        ret = (ID)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    }
    return ret;
  }

  /**
   * Returns all repetitions of FINANCIAL CLASS (PV1-20).
   */
  public ID[] getFINANCIALCLASS() {
     ID[] ret = null;
    try {
        Type[] t = this.getField(20);  
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
   * Returns CHARGE PRICE INDICATOR (PV1-21).
   */
  public ID getCHARGEPRICEINDICATOR()  {
    ID ret = null;
    try {
        Type t = this.getField(21, 0);
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
   * Returns COURTESY CODE (PV1-22).
   */
  public ID getCOURTESYCODE()  {
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
   * Returns CREDIT RATING (PV1-23).
   */
  public ID getCREDITRATING()  {
    ID ret = null;
    try {
        Type t = this.getField(23, 0);
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
   * Returns a single repetition of CONTRACT CODE (PV1-24).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public ID getCONTRACTCODE(int rep) throws HL7Exception {
    ID ret = null;
    try {
        Type t = this.getField(24, rep);
        ret = (ID)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    }
    return ret;
  }

  /**
   * Returns all repetitions of CONTRACT CODE (PV1-24).
   */
  public ID[] getCONTRACTCODE() {
     ID[] ret = null;
    try {
        Type[] t = this.getField(24);  
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
   * Returns a single repetition of CONTRACT EFFECTIVE DATE (PV1-25).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public DT getCONTRACTEFFECTIVEDATE(int rep) throws HL7Exception {
    DT ret = null;
    try {
        Type t = this.getField(25, rep);
        ret = (DT)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    }
    return ret;
  }

  /**
   * Returns all repetitions of CONTRACT EFFECTIVE DATE (PV1-25).
   */
  public DT[] getCONTRACTEFFECTIVEDATE() {
     DT[] ret = null;
    try {
        Type[] t = this.getField(25);  
        ret = new DT[t.length];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = (DT)t[i];
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
   * Returns a single repetition of CONTRACT AMOUNT (PV1-26).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public NM getCONTRACTAMOUNT(int rep) throws HL7Exception {
    NM ret = null;
    try {
        Type t = this.getField(26, rep);
        ret = (NM)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    }
    return ret;
  }

  /**
   * Returns all repetitions of CONTRACT AMOUNT (PV1-26).
   */
  public NM[] getCONTRACTAMOUNT() {
     NM[] ret = null;
    try {
        Type[] t = this.getField(26);  
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
   * Returns a single repetition of CONTRACT PERIOD (PV1-27).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public NM getCONTRACTPERIOD(int rep) throws HL7Exception {
    NM ret = null;
    try {
        Type t = this.getField(27, rep);
        ret = (NM)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    }
    return ret;
  }

  /**
   * Returns all repetitions of CONTRACT PERIOD (PV1-27).
   */
  public NM[] getCONTRACTPERIOD() {
     NM[] ret = null;
    try {
        Type[] t = this.getField(27);  
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
   * Returns INTEREST CODE (PV1-28).
   */
  public ID getINTERESTCODE()  {
    ID ret = null;
    try {
        Type t = this.getField(28, 0);
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
   * Returns TRANSFER TO BAD DEBT CODE (PV1-29).
   */
  public ID getTRANSFERTOBADDEBTCODE()  {
    ID ret = null;
    try {
        Type t = this.getField(29, 0);
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
   * Returns TRANSFER TO BAD DEBT DATE (PV1-30).
   */
  public DT getTRANSFERTOBADDEBTDATE()  {
    DT ret = null;
    try {
        Type t = this.getField(30, 0);
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
   * Returns BAD DEBT AGENCY CODE (PV1-31).
   */
  public ST getBADDEBTAGENCYCODE()  {
    ST ret = null;
    try {
        Type t = this.getField(31, 0);
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
   * Returns BAD DEBT TRANSFER AMOUNT (PV1-32).
   */
  public NM getBADDEBTTRANSFERAMOUNT()  {
    NM ret = null;
    try {
        Type t = this.getField(32, 0);
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
   * Returns BAD DEBT RECOVERY AMOUNT (PV1-33).
   */
  public NM getBADDEBTRECOVERYAMOUNT()  {
    NM ret = null;
    try {
        Type t = this.getField(33, 0);
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
   * Returns DELETE ACCOUNT INDICATOR (PV1-34).
   */
  public ID getDELETEACCOUNTINDICATOR()  {
    ID ret = null;
    try {
        Type t = this.getField(34, 0);
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
   * Returns DELETE ACCOUNT DATE (PV1-35).
   */
  public DT getDELETEACCOUNTDATE()  {
    DT ret = null;
    try {
        Type t = this.getField(35, 0);
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
   * Returns DISCHARGE DISPOSITION (PV1-36).
   */
  public ID getDISCHARGEDISPOSITION()  {
    ID ret = null;
    try {
        Type t = this.getField(36, 0);
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
   * Returns DISCHARGED TO LOCATION (PV1-37).
   */
  public ID getDISCHARGEDTOLOCATION()  {
    ID ret = null;
    try {
        Type t = this.getField(37, 0);
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
   * Returns DIET TYPE (PV1-38).
   */
  public ID getDIETTYPE()  {
    ID ret = null;
    try {
        Type t = this.getField(38, 0);
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
   * Returns SERVICING FACILITY (PV1-39).
   */
  public ID getSERVICINGFACILITY()  {
    ID ret = null;
    try {
        Type t = this.getField(39, 0);
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
   * Returns BED STATUS (PV1-40).
   */
  public ID getBEDSTATUS()  {
    ID ret = null;
    try {
        Type t = this.getField(40, 0);
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
   * Returns ACCOUNT STATUS (PV1-41).
   */
  public ID getACCOUNTSTATUS()  {
    ID ret = null;
    try {
        Type t = this.getField(41, 0);
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
   * Returns PENDING LOCATION (PV1-42).
   */
  public ID getPENDINGLOCATION()  {
    ID ret = null;
    try {
        Type t = this.getField(42, 0);
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
   * Returns PRIOR TEMPORARY LOCATION (PV1-43).
   */
  public ID getPRIORTEMPORARYLOCATION()  {
    ID ret = null;
    try {
        Type t = this.getField(43, 0);
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
   * Returns ADMIT DATE/TIME (PV1-44).
   */
  public TS getADMITDATETIME()  {
    TS ret = null;
    try {
        Type t = this.getField(44, 0);
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
   * Returns DISCHARGE DATE/TIME (PV1-45).
   */
  public TS getDISCHARGEDATETIME()  {
    TS ret = null;
    try {
        Type t = this.getField(45, 0);
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
   * Returns CURRENT PATIENT BALANCE (PV1-46).
   */
  public NM getCURRENTPATIENTBALANCE()  {
    NM ret = null;
    try {
        Type t = this.getField(46, 0);
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
   * Returns TOTAL CHARGES (PV1-47).
   */
  public NM getTOTALCHARGES()  {
    NM ret = null;
    try {
        Type t = this.getField(47, 0);
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
   * Returns TOTAL ADJUSTMENTS (PV1-48).
   */
  public NM getTOTALADJUSTMENTS()  {
    NM ret = null;
    try {
        Type t = this.getField(48, 0);
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
   * Returns TOTAL PAYMENTS (PV1-49).
   */
  public NM getTOTALPAYMENTS()  {
    NM ret = null;
    try {
        Type t = this.getField(49, 0);
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