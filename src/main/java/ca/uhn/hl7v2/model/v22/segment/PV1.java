package ca.uhn.hl7v2.model.v22.segment;

import ca.uhn.hl7v2.model.*;
import ca.uhn.hl7v2.model.v22.datatype.*;

import ca.uhn.log.HapiLogFactory;
import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.HL7Exception;

/**
 * <p>Represents an HL7 PV1 message segment. 
 * This segment has the following fields:</p><p>
 * PV1-1: Set ID - Patient Visit (SI)<br> 
 * PV1-2: Patient Class (ID)<br> 
 * PV1-3: Assigned Patient Location (CM_INTERNAL_LOCATION)<br> 
 * PV1-4: Admission Type (ID)<br> 
 * PV1-5: Preadmit Number (ST)<br> 
 * PV1-6: Prior Patient Location (CM_INTERNAL_LOCATION)<br> 
 * PV1-7: Attending Doctor (CN)<br> 
 * PV1-8: Referring Doctor (CN)<br> 
 * PV1-9: Consulting Doctor (CN)<br> 
 * PV1-10: Hospital Service (ID)<br> 
 * PV1-11: Temporary Location (CM_INTERNAL_LOCATION)<br> 
 * PV1-12: Preadmit Test Indicator (ID)<br> 
 * PV1-13: Readmission indicator (ID)<br> 
 * PV1-14: Admit Source (ID)<br> 
 * PV1-15: Ambulatory Status (ID)<br> 
 * PV1-16: VIP Indicator (ID)<br> 
 * PV1-17: Admitting Doctor (CN)<br> 
 * PV1-18: Patient type (ID)<br> 
 * PV1-19: Visit Number (CM_PAT_ID)<br> 
 * PV1-20: Financial Class (CM_FINANCE)<br> 
 * PV1-21: Charge Price Indicator (ID)<br> 
 * PV1-22: Courtesy Code (ID)<br> 
 * PV1-23: Credit Rating (ID)<br> 
 * PV1-24: Contract Code (ID)<br> 
 * PV1-25: Contract Effective Date (DT)<br> 
 * PV1-26: Contract Amount (NM)<br> 
 * PV1-27: Contract Period (NM)<br> 
 * PV1-28: Interest Code (ID)<br> 
 * PV1-29: Transfer to bad debt - code (ID)<br> 
 * PV1-30: Transfer to bad debt - date (DT)<br> 
 * PV1-31: Bad Debt Agency Code (ID)<br> 
 * PV1-32: Bad Debt Transfer Amount (NM)<br> 
 * PV1-33: Bad Debt Recovery Amount (NM)<br> 
 * PV1-34: Delete Account Indicator (ID)<br> 
 * PV1-35: Delete Account Date (DT)<br> 
 * PV1-36: Discharge Disposition (ID)<br> 
 * PV1-37: Discharged to Location (CM_DLD)<br> 
 * PV1-38: Diet Type (ID)<br> 
 * PV1-39: Servicing Facility (ID)<br> 
 * PV1-40: Bed Status (ID)<br> 
 * PV1-41: Account Status (ID)<br> 
 * PV1-42: Pending Location (CM_INTERNAL_LOCATION)<br> 
 * PV1-43: Prior Temporary Location (CM_INTERNAL_LOCATION)<br> 
 * PV1-44: Admit date / time (TS)<br> 
 * PV1-45: Discharge date / time (TS)<br> 
 * PV1-46: Current Patient Balance (NM)<br> 
 * PV1-47: Total Charges (NM)<br> 
 * PV1-48: Total Adjustments (NM)<br> 
 * PV1-49: Total Payments (NM)<br> 
 * PV1-50: Alternate Visit ID (CM_PAT_ID_0192)<br> 
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
       this.add(CM_INTERNAL_LOCATION.class, false, 1, 12, new Object[]{message});
       this.add(ID.class, false, 1, 2, new Object[]{message, new Integer(7)});
       this.add(ST.class, false, 1, 20, new Object[]{message});
       this.add(CM_INTERNAL_LOCATION.class, false, 1, 12, new Object[]{message});
       this.add(CN.class, false, 1, 60, new Object[]{message});
       this.add(CN.class, false, 1, 60, new Object[]{message});
       this.add(CN.class, false, 0, 60, new Object[]{message});
       this.add(ID.class, false, 1, 3, new Object[]{message, new Integer(69)});
       this.add(CM_INTERNAL_LOCATION.class, false, 1, 12, new Object[]{message});
       this.add(ID.class, false, 1, 2, new Object[]{message, new Integer(87)});
       this.add(ID.class, false, 1, 2, new Object[]{message, new Integer(92)});
       this.add(ID.class, false, 1, 3, new Object[]{message, new Integer(23)});
       this.add(ID.class, false, 0, 2, new Object[]{message, new Integer(9)});
       this.add(ID.class, false, 1, 2, new Object[]{message, new Integer(99)});
       this.add(CN.class, false, 1, 60, new Object[]{message});
       this.add(ID.class, false, 1, 2, new Object[]{message, new Integer(18)});
       this.add(CM_PAT_ID.class, false, 1, 15, new Object[]{message});
       this.add(CM_FINANCE.class, false, 4, 50, new Object[]{message});
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
       this.add(ID.class, false, 1, 10, new Object[]{message, new Integer(21)});
       this.add(NM.class, false, 1, 12, new Object[]{message});
       this.add(NM.class, false, 1, 12, new Object[]{message});
       this.add(ID.class, false, 1, 1, new Object[]{message, new Integer(111)});
       this.add(DT.class, false, 1, 8, new Object[]{message});
       this.add(ID.class, false, 1, 3, new Object[]{message, new Integer(112)});
       this.add(CM_DLD.class, false, 1, 25, new Object[]{message});
       this.add(ID.class, false, 1, 2, new Object[]{message, new Integer(114)});
       this.add(ID.class, false, 1, 4, new Object[]{message, new Integer(115)});
       this.add(ID.class, false, 1, 1, new Object[]{message, new Integer(116)});
       this.add(ID.class, false, 1, 2, new Object[]{message, new Integer(117)});
       this.add(CM_INTERNAL_LOCATION.class, false, 1, 12, new Object[]{message});
       this.add(CM_INTERNAL_LOCATION.class, false, 1, 12, new Object[]{message});
       this.add(TS.class, false, 1, 26, new Object[]{message});
       this.add(TS.class, false, 1, 26, new Object[]{message});
       this.add(NM.class, false, 1, 12, new Object[]{message});
       this.add(NM.class, false, 1, 12, new Object[]{message});
       this.add(NM.class, false, 1, 12, new Object[]{message});
       this.add(NM.class, false, 1, 12, new Object[]{message});
       this.add(CM_PAT_ID_0192.class, false, 1, 20, new Object[]{message});
    } catch (HL7Exception he) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Can't instantiate " + this.getClass().getName(), he);
    }
  }

  /**
   * Returns Set ID - Patient Visit (PV1-1).
   */
  public SI getSetIDPatientVisit()  {
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
   * Returns Patient Class (PV1-2).
   */
  public ID getPatientClass()  {
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
   * Returns Assigned Patient Location (PV1-3).
   */
  public CM_INTERNAL_LOCATION getAssignedPatientLocation()  {
    CM_INTERNAL_LOCATION ret = null;
    try {
        Type t = this.getField(3, 0);
        ret = (CM_INTERNAL_LOCATION)t;
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
   * Returns Admission Type (PV1-4).
   */
  public ID getAdmissionType()  {
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
   * Returns Preadmit Number (PV1-5).
   */
  public ST getPreadmitNumber()  {
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
   * Returns Prior Patient Location (PV1-6).
   */
  public CM_INTERNAL_LOCATION getPriorPatientLocation()  {
    CM_INTERNAL_LOCATION ret = null;
    try {
        Type t = this.getField(6, 0);
        ret = (CM_INTERNAL_LOCATION)t;
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
   * Returns Attending Doctor (PV1-7).
   */
  public CN getAttendingDoctor()  {
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
   * Returns Referring Doctor (PV1-8).
   */
  public CN getReferringDoctor()  {
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
   * Returns a single repetition of Consulting Doctor (PV1-9).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public CN getConsultingDoctor(int rep) throws HL7Exception {
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
   * Returns all repetitions of Consulting Doctor (PV1-9).
   */
  public CN[] getConsultingDoctor() {
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
   * Returns Hospital Service (PV1-10).
   */
  public ID getHospitalService()  {
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
   * Returns Temporary Location (PV1-11).
   */
  public CM_INTERNAL_LOCATION getTemporaryLocation()  {
    CM_INTERNAL_LOCATION ret = null;
    try {
        Type t = this.getField(11, 0);
        ret = (CM_INTERNAL_LOCATION)t;
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
   * Returns Preadmit Test Indicator (PV1-12).
   */
  public ID getPreadmitTestIndicator()  {
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
   * Returns Readmission indicator (PV1-13).
   */
  public ID getReadmissionIndicator()  {
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
   * Returns Admit Source (PV1-14).
   */
  public ID getAdmitSource()  {
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
   * Returns a single repetition of Ambulatory Status (PV1-15).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public ID getAmbulatoryStatus(int rep) throws HL7Exception {
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
   * Returns all repetitions of Ambulatory Status (PV1-15).
   */
  public ID[] getAmbulatoryStatus() {
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
   * Returns VIP Indicator (PV1-16).
   */
  public ID getVIPIndicator()  {
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
   * Returns Admitting Doctor (PV1-17).
   */
  public CN getAdmittingDoctor()  {
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
   * Returns Patient type (PV1-18).
   */
  public ID getPatientType()  {
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
   * Returns Visit Number (PV1-19).
   */
  public CM_PAT_ID getVisitNumber()  {
    CM_PAT_ID ret = null;
    try {
        Type t = this.getField(19, 0);
        ret = (CM_PAT_ID)t;
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
   * Returns a single repetition of Financial Class (PV1-20).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public CM_FINANCE getFinancialClass(int rep) throws HL7Exception {
    CM_FINANCE ret = null;
    try {
        Type t = this.getField(20, rep);
        ret = (CM_FINANCE)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    }
    return ret;
  }

  /**
   * Returns all repetitions of Financial Class (PV1-20).
   */
  public CM_FINANCE[] getFinancialClass() {
     CM_FINANCE[] ret = null;
    try {
        Type[] t = this.getField(20);  
        ret = new CM_FINANCE[t.length];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = (CM_FINANCE)t[i];
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
   * Returns Charge Price Indicator (PV1-21).
   */
  public ID getChargePriceIndicator()  {
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
   * Returns Courtesy Code (PV1-22).
   */
  public ID getCourtesyCode()  {
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
   * Returns Credit Rating (PV1-23).
   */
  public ID getCreditRating()  {
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
   * Returns a single repetition of Contract Code (PV1-24).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public ID getContractCode(int rep) throws HL7Exception {
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
   * Returns all repetitions of Contract Code (PV1-24).
   */
  public ID[] getContractCode() {
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
   * Returns a single repetition of Contract Effective Date (PV1-25).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public DT getContractEffectiveDate(int rep) throws HL7Exception {
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
   * Returns all repetitions of Contract Effective Date (PV1-25).
   */
  public DT[] getContractEffectiveDate() {
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
   * Returns a single repetition of Contract Amount (PV1-26).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public NM getContractAmount(int rep) throws HL7Exception {
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
   * Returns all repetitions of Contract Amount (PV1-26).
   */
  public NM[] getContractAmount() {
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
   * Returns a single repetition of Contract Period (PV1-27).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public NM getContractPeriod(int rep) throws HL7Exception {
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
   * Returns all repetitions of Contract Period (PV1-27).
   */
  public NM[] getContractPeriod() {
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
   * Returns Interest Code (PV1-28).
   */
  public ID getInterestCode()  {
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
   * Returns Transfer to bad debt - code (PV1-29).
   */
  public ID getTransferToBadDebtCode()  {
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
   * Returns Transfer to bad debt - date (PV1-30).
   */
  public DT getTransferToBadDebtDate()  {
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
   * Returns Bad Debt Agency Code (PV1-31).
   */
  public ID getBadDebtAgencyCode()  {
    ID ret = null;
    try {
        Type t = this.getField(31, 0);
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
   * Returns Bad Debt Transfer Amount (PV1-32).
   */
  public NM getBadDebtTransferAmount()  {
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
   * Returns Bad Debt Recovery Amount (PV1-33).
   */
  public NM getBadDebtRecoveryAmount()  {
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
   * Returns Delete Account Indicator (PV1-34).
   */
  public ID getDeleteAccountIndicator()  {
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
   * Returns Delete Account Date (PV1-35).
   */
  public DT getDeleteAccountDate()  {
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
   * Returns Discharge Disposition (PV1-36).
   */
  public ID getDischargeDisposition()  {
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
   * Returns Discharged to Location (PV1-37).
   */
  public CM_DLD getDischargedToLocation()  {
    CM_DLD ret = null;
    try {
        Type t = this.getField(37, 0);
        ret = (CM_DLD)t;
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
   * Returns Diet Type (PV1-38).
   */
  public ID getDietType()  {
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
   * Returns Servicing Facility (PV1-39).
   */
  public ID getServicingFacility()  {
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
   * Returns Bed Status (PV1-40).
   */
  public ID getBedStatus()  {
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
   * Returns Account Status (PV1-41).
   */
  public ID getAccountStatus()  {
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
   * Returns Pending Location (PV1-42).
   */
  public CM_INTERNAL_LOCATION getPendingLocation()  {
    CM_INTERNAL_LOCATION ret = null;
    try {
        Type t = this.getField(42, 0);
        ret = (CM_INTERNAL_LOCATION)t;
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
   * Returns Prior Temporary Location (PV1-43).
   */
  public CM_INTERNAL_LOCATION getPriorTemporaryLocation()  {
    CM_INTERNAL_LOCATION ret = null;
    try {
        Type t = this.getField(43, 0);
        ret = (CM_INTERNAL_LOCATION)t;
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
   * Returns Admit date / time (PV1-44).
   */
  public TS getAdmitDateTime()  {
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
   * Returns Discharge date / time (PV1-45).
   */
  public TS getDischargeDateTime()  {
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
   * Returns Current Patient Balance (PV1-46).
   */
  public NM getCurrentPatientBalance()  {
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
   * Returns Total Charges (PV1-47).
   */
  public NM getTotalCharges()  {
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
   * Returns Total Adjustments (PV1-48).
   */
  public NM getTotalAdjustments()  {
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
   * Returns Total Payments (PV1-49).
   */
  public NM getTotalPayments()  {
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

  /**
   * Returns Alternate Visit ID (PV1-50).
   */
  public CM_PAT_ID_0192 getAlternateVisitID()  {
    CM_PAT_ID_0192 ret = null;
    try {
        Type t = this.getField(50, 0);
        ret = (CM_PAT_ID_0192)t;
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