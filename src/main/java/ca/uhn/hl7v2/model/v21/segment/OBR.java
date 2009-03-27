package ca.uhn.hl7v2.model.v21.segment;

import ca.uhn.hl7v2.model.*;
import ca.uhn.hl7v2.model.v21.datatype.*;

import ca.uhn.log.HapiLogFactory;
import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.HL7Exception;

/**
 * <p>Represents an HL7 OBR message segment. 
 * This segment has the following fields:</p><p>
 * OBR-1: SET ID - OBSERVATION REQUEST (SI)<br> 
 * OBR-2: PLACER ORDER # (CM)<br> 
 * OBR-3: FILLER ORDER # (CM)<br> 
 * OBR-4: UNIVERSAL SERVICE IDENT. (CE)<br> 
 * OBR-5: PRIORITY (ST)<br> 
 * OBR-6: REQUESTED DATE-TIME (TS)<br> 
 * OBR-7: OBSERVATION DATE/TIME (TS)<br> 
 * OBR-8: OBSERVATION END DATE/TIME (TS)<br> 
 * OBR-9: COLLECTION VOLUME (CQ)<br> 
 * OBR-10: COLLECTOR IDENTIFIER (CN)<br> 
 * OBR-11: SPECIMEN ACTION CODE (ST)<br> 
 * OBR-12: DANGER CODE (CM)<br> 
 * OBR-13: RELEVANT CLINICAL INFO. (ST)<br> 
 * OBR-14: SPECIMEN RECEIVED DATE/TIME (TS)<br> 
 * OBR-15: SPECIMEN SOURCE (CM)<br> 
 * OBR-16: ORDERING PROVIDER (CN)<br> 
 * OBR-17: ORDER CALL-BACK PHONE NUM (TN)<br> 
 * OBR-18: PLACERS FIELD #1 (ST)<br> 
 * OBR-19: PLACERS FIELD #2 (ST)<br> 
 * OBR-20: FILLERS FIELD #1 (ST)<br> 
 * OBR-21: FILLERS FIELD #2 (ST)<br> 
 * OBR-22: RESULTS RPT/STATUS CHNG - DATE/T (TS)<br> 
 * OBR-23: CHARGE TO PRACTICE (CM)<br> 
 * OBR-24: DIAGNOSTIC SERV SECT ID (ID)<br> 
 * OBR-25: RESULT STATUS (ID)<br> 
 * OBR-26: LINKED RESULTS (CE)<br> 
 * OBR-27: QUANTITY/TIMING (CM)<br> 
 * OBR-28: RESULT COPIES TO (CN)<br> 
 * OBR-29: PARENT ACCESSION # (CM)<br> 
 * OBR-30: TRANSPORTATION MODE (ID)<br> 
 * OBR-31: REASON FOR STUDY (CE)<br> 
 * OBR-32: PRINCIPAL RESULT INTERPRETER (CN)<br> 
 * OBR-33: ASSISTANT RESULT INTERPRETER (CN)<br> 
 * OBR-34: TECHNICIAN (CN)<br> 
 * OBR-35: TRANSCRIPTIONIST (CN)<br> 
 * OBR-36: SCHEDULED - DATE/TIME (TS)<br> 
 * </p><p>The get...() methods return data from individual fields.  These methods 
 * do not throw exceptions and may therefore have to handle exceptions internally.  
 * If an exception is handled internally, it is logged and null is returned.  
 * This is not expected to happen - if it does happen this indicates not so much 
 * an exceptional circumstance as a bug in the code for this class.</p>    
 */
public class OBR extends AbstractSegment  {

  /**
   * Creates a OBR (OBSERVATION REQUEST) segment object that belongs to the given 
   * message.  
   */
  public OBR(Group parent, ModelClassFactory factory) {
    super(parent, factory);
    Message message = getMessage();
    try {
       this.add(SI.class, false, 1, 4, new Object[]{message});
       this.add(CM.class, false, 1, 75, new Object[]{message});
       this.add(CM.class, false, 1, 75, new Object[]{message});
       this.add(CE.class, true, 1, 200, new Object[]{message});
       this.add(ST.class, false, 1, 2, new Object[]{message});
       this.add(TS.class, false, 1, 19, new Object[]{message});
       this.add(TS.class, true, 1, 19, new Object[]{message});
       this.add(TS.class, true, 1, 19, new Object[]{message});
       this.add(CQ.class, true, 1, 20, new Object[]{message});
       this.add(CN.class, false, 0, 60, new Object[]{message});
       this.add(ST.class, false, 1, 1, new Object[]{message});
       this.add(CM.class, false, 1, 60, new Object[]{message});
       this.add(ST.class, false, 1, 300, new Object[]{message});
       this.add(TS.class, true, 1, 19, new Object[]{message});
       this.add(CM.class, false, 1, 300, new Object[]{message});
       this.add(CN.class, false, 0, 60, new Object[]{message});
       this.add(TN.class, false, 2, 40, new Object[]{message});
       this.add(ST.class, false, 1, 60, new Object[]{message});
       this.add(ST.class, false, 1, 60, new Object[]{message});
       this.add(ST.class, false, 1, 60, new Object[]{message});
       this.add(ST.class, false, 1, 60, new Object[]{message});
       this.add(TS.class, true, 1, 19, new Object[]{message});
       this.add(CM.class, false, 1, 40, new Object[]{message});
       this.add(ID.class, false, 1, 10, new Object[]{message, new Integer(74)});
       this.add(ID.class, false, 1, 1, new Object[]{message, new Integer(123)});
       this.add(CE.class, false, 1, 200, new Object[]{message});
       this.add(CM.class, false, 0, 200, new Object[]{message});
       this.add(CN.class, false, 5, 80, new Object[]{message});
       this.add(CM.class, false, 1, 150, new Object[]{message});
       this.add(ID.class, false, 1, 20, new Object[]{message, new Integer(124)});
       this.add(CE.class, false, 0, 300, new Object[]{message});
       this.add(CN.class, false, 1, 60, new Object[]{message});
       this.add(CN.class, false, 1, 60, new Object[]{message});
       this.add(CN.class, false, 1, 60, new Object[]{message});
       this.add(CN.class, false, 1, 60, new Object[]{message});
       this.add(TS.class, false, 1, 19, new Object[]{message});
    } catch (HL7Exception he) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Can't instantiate " + this.getClass().getName(), he);
    }
  }

  /**
   * Returns SET ID - OBSERVATION REQUEST (OBR-1).
   */
  public SI getSETIDOBSERVATIONREQUEST()  {
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
   * Returns PLACER ORDER # (OBR-2).
   */
  public CM getPLACERORDER()  {
    CM ret = null;
    try {
        Type t = this.getField(2, 0);
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
   * Returns FILLER ORDER # (OBR-3).
   */
  public CM getFILLERORDER()  {
    CM ret = null;
    try {
        Type t = this.getField(3, 0);
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
   * Returns UNIVERSAL SERVICE IDENT. (OBR-4).
   */
  public CE getUNIVERSALSERVICEIDENT()  {
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
   * Returns PRIORITY (OBR-5).
   */
  public ST getPRIORITY()  {
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
   * Returns REQUESTED DATE-TIME (OBR-6).
   */
  public TS getREQUESTEDDATETIME()  {
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
   * Returns OBSERVATION DATE/TIME (OBR-7).
   */
  public TS getOBSERVATIONDATETIME()  {
    TS ret = null;
    try {
        Type t = this.getField(7, 0);
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
   * Returns OBSERVATION END DATE/TIME (OBR-8).
   */
  public TS getOBSERVATIONENDDATETIME()  {
    TS ret = null;
    try {
        Type t = this.getField(8, 0);
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
   * Returns COLLECTION VOLUME (OBR-9).
   */
  public CQ getCOLLECTIONVOLUME()  {
    CQ ret = null;
    try {
        Type t = this.getField(9, 0);
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
   * Returns a single repetition of COLLECTOR IDENTIFIER (OBR-10).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public CN getCOLLECTORIDENTIFIER(int rep) throws HL7Exception {
    CN ret = null;
    try {
        Type t = this.getField(10, rep);
        ret = (CN)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    }
    return ret;
  }

  /**
   * Returns all repetitions of COLLECTOR IDENTIFIER (OBR-10).
   */
  public CN[] getCOLLECTORIDENTIFIER() {
     CN[] ret = null;
    try {
        Type[] t = this.getField(10);  
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
   * Returns SPECIMEN ACTION CODE (OBR-11).
   */
  public ST getSPECIMENACTIONCODE()  {
    ST ret = null;
    try {
        Type t = this.getField(11, 0);
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
   * Returns DANGER CODE (OBR-12).
   */
  public CM getDANGERCODE()  {
    CM ret = null;
    try {
        Type t = this.getField(12, 0);
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
   * Returns RELEVANT CLINICAL INFO. (OBR-13).
   */
  public ST getRELEVANTCLINICALINFO()  {
    ST ret = null;
    try {
        Type t = this.getField(13, 0);
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
   * Returns SPECIMEN RECEIVED DATE/TIME (OBR-14).
   */
  public TS getSPECIMENRECEIVEDDATETIME()  {
    TS ret = null;
    try {
        Type t = this.getField(14, 0);
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
   * Returns SPECIMEN SOURCE (OBR-15).
   */
  public CM getSPECIMENSOURCE()  {
    CM ret = null;
    try {
        Type t = this.getField(15, 0);
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
   * Returns a single repetition of ORDERING PROVIDER (OBR-16).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public CN getORDERINGPROVIDER(int rep) throws HL7Exception {
    CN ret = null;
    try {
        Type t = this.getField(16, rep);
        ret = (CN)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    }
    return ret;
  }

  /**
   * Returns all repetitions of ORDERING PROVIDER (OBR-16).
   */
  public CN[] getORDERINGPROVIDER() {
     CN[] ret = null;
    try {
        Type[] t = this.getField(16);  
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
   * Returns a single repetition of ORDER CALL-BACK PHONE NUM (OBR-17).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public TN getORDERCALLBACKPHONENUM(int rep) throws HL7Exception {
    TN ret = null;
    try {
        Type t = this.getField(17, rep);
        ret = (TN)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    }
    return ret;
  }

  /**
   * Returns all repetitions of ORDER CALL-BACK PHONE NUM (OBR-17).
   */
  public TN[] getORDERCALLBACKPHONENUM() {
     TN[] ret = null;
    try {
        Type[] t = this.getField(17);  
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
   * Returns PLACERS FIELD #1 (OBR-18).
   */
  public ST getPLACERSFIELD1()  {
    ST ret = null;
    try {
        Type t = this.getField(18, 0);
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
   * Returns PLACERS FIELD #2 (OBR-19).
   */
  public ST getPLACERSFIELD2()  {
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
   * Returns FILLERS FIELD #1 (OBR-20).
   */
  public ST getFILLERSFIELD1()  {
    ST ret = null;
    try {
        Type t = this.getField(20, 0);
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
   * Returns FILLERS FIELD #2 (OBR-21).
   */
  public ST getFILLERSFIELD2()  {
    ST ret = null;
    try {
        Type t = this.getField(21, 0);
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
   * Returns RESULTS RPT/STATUS CHNG - DATE/T (OBR-22).
   */
  public TS getRESULTSRPTSTATUSCHNGDATET()  {
    TS ret = null;
    try {
        Type t = this.getField(22, 0);
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
   * Returns CHARGE TO PRACTICE (OBR-23).
   */
  public CM getCHARGETOPRACTICE()  {
    CM ret = null;
    try {
        Type t = this.getField(23, 0);
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
   * Returns DIAGNOSTIC SERV SECT ID (OBR-24).
   */
  public ID getDIAGNOSTICSERVSECTID()  {
    ID ret = null;
    try {
        Type t = this.getField(24, 0);
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
   * Returns RESULT STATUS (OBR-25).
   */
  public ID getRESULTSTATUS()  {
    ID ret = null;
    try {
        Type t = this.getField(25, 0);
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
   * Returns LINKED RESULTS (OBR-26).
   */
  public CE getLINKEDRESULTS()  {
    CE ret = null;
    try {
        Type t = this.getField(26, 0);
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
   * Returns a single repetition of QUANTITY/TIMING (OBR-27).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public CM getQUANTITYTIMING(int rep) throws HL7Exception {
    CM ret = null;
    try {
        Type t = this.getField(27, rep);
        ret = (CM)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    }
    return ret;
  }

  /**
   * Returns all repetitions of QUANTITY/TIMING (OBR-27).
   */
  public CM[] getQUANTITYTIMING() {
     CM[] ret = null;
    try {
        Type[] t = this.getField(27);  
        ret = new CM[t.length];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = (CM)t[i];
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
   * Returns a single repetition of RESULT COPIES TO (OBR-28).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public CN getRESULTCOPIESTO(int rep) throws HL7Exception {
    CN ret = null;
    try {
        Type t = this.getField(28, rep);
        ret = (CN)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    }
    return ret;
  }

  /**
   * Returns all repetitions of RESULT COPIES TO (OBR-28).
   */
  public CN[] getRESULTCOPIESTO() {
     CN[] ret = null;
    try {
        Type[] t = this.getField(28);  
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
   * Returns PARENT ACCESSION # (OBR-29).
   */
  public CM getPARENTACCESSION()  {
    CM ret = null;
    try {
        Type t = this.getField(29, 0);
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
   * Returns TRANSPORTATION MODE (OBR-30).
   */
  public ID getTRANSPORTATIONMODE()  {
    ID ret = null;
    try {
        Type t = this.getField(30, 0);
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
   * Returns a single repetition of REASON FOR STUDY (OBR-31).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public CE getREASONFORSTUDY(int rep) throws HL7Exception {
    CE ret = null;
    try {
        Type t = this.getField(31, rep);
        ret = (CE)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    }
    return ret;
  }

  /**
   * Returns all repetitions of REASON FOR STUDY (OBR-31).
   */
  public CE[] getREASONFORSTUDY() {
     CE[] ret = null;
    try {
        Type[] t = this.getField(31);  
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
   * Returns PRINCIPAL RESULT INTERPRETER (OBR-32).
   */
  public CN getPRINCIPALRESULTINTERPRETER()  {
    CN ret = null;
    try {
        Type t = this.getField(32, 0);
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
   * Returns ASSISTANT RESULT INTERPRETER (OBR-33).
   */
  public CN getASSISTANTRESULTINTERPRETER()  {
    CN ret = null;
    try {
        Type t = this.getField(33, 0);
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
   * Returns TECHNICIAN (OBR-34).
   */
  public CN getTECHNICIAN()  {
    CN ret = null;
    try {
        Type t = this.getField(34, 0);
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
   * Returns TRANSCRIPTIONIST (OBR-35).
   */
  public CN getTRANSCRIPTIONIST()  {
    CN ret = null;
    try {
        Type t = this.getField(35, 0);
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
   * Returns SCHEDULED - DATE/TIME (OBR-36).
   */
  public TS getSCHEDULEDDATETIME()  {
    TS ret = null;
    try {
        Type t = this.getField(36, 0);
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

}