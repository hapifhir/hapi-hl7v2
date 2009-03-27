package ca.uhn.hl7v2.model.v22.segment;

import ca.uhn.hl7v2.model.*;
import ca.uhn.hl7v2.model.v22.datatype.*;

import ca.uhn.log.HapiLogFactory;
import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.HL7Exception;

/**
 * <p>Represents an HL7 OM1 message segment. 
 * This segment has the following fields:</p><p>
 * OM1-1: Segment Type ID (ST)<br> 
 * OM1-2: Sequence Number - Test/ Observation Master File (NM)<br> 
 * OM1-3: Producer's test / observation ID (CE)<br> 
 * OM1-4: Permitted Data Types (ID)<br> 
 * OM1-5: Specimen Required (ID)<br> 
 * OM1-6: Producer ID (CE)<br> 
 * OM1-7: Observation Description (TX)<br> 
 * OM1-8: Other test / observation IDs for the observation (CE)<br> 
 * OM1-9: Other Names (ST)<br> 
 * OM1-10: Preferred Report Name for the Observation (ST)<br> 
 * OM1-11: Preferred Short Name or Mnemonic for Observation (ST)<br> 
 * OM1-12: Preferred Long Name for the Observation (ST)<br> 
 * OM1-13: Orderability (ID)<br> 
 * OM1-14: Identity of instrument used to perform this study (CE)<br> 
 * OM1-15: Coded Representation of Method (CE)<br> 
 * OM1-16: Portable (ID)<br> 
 * OM1-17: Observation producing department / section (ID)<br> 
 * OM1-18: Telephone Number of Section (TN)<br> 
 * OM1-19: Nature of test / observation (ID)<br> 
 * OM1-20: Report Subheader (CE)<br> 
 * OM1-21: Report Display Order (ST)<br> 
 * OM1-22: Date / time stamp for any change in definition for obs (TS)<br> 
 * OM1-23: Effective date / time of change (TS)<br> 
 * OM1-24: Typical Turn-around Time (NM)<br> 
 * OM1-25: Processing Time (NM)<br> 
 * OM1-26: Processing Priority (ID)<br> 
 * OM1-27: Reporting Priority (ID)<br> 
 * OM1-28: Outside Site(s) Where Observation may be Performed (CE)<br> 
 * OM1-29: Address of Outside Site(s) (AD)<br> 
 * OM1-30: Phone Number of Outside Site (TN)<br> 
 * OM1-31: Confidentiality Code (ID)<br> 
 * OM1-32: Observations required to interpret the observation (CE)<br> 
 * OM1-33: Interpretation of Observations (TX)<br> 
 * OM1-34: Contraindications to Observations (CE)<br> 
 * OM1-35: Reflex tests / observations (CE)<br> 
 * OM1-36: Rules that Trigger Reflex Testing (ST)<br> 
 * OM1-37: Fixed Canned Message (CE)<br> 
 * OM1-38: Patient Preparation (TX)<br> 
 * OM1-39: Procedure Medication (CE)<br> 
 * OM1-40: Factors that may affect the observation (TX)<br> 
 * OM1-41: Test / observation performance schedule (ST)<br> 
 * OM1-42: Description of Test Methods (TX)<br> 
 * </p><p>The get...() methods return data from individual fields.  These methods 
 * do not throw exceptions and may therefore have to handle exceptions internally.  
 * If an exception is handled internally, it is logged and null is returned.  
 * This is not expected to happen - if it does happen this indicates not so much 
 * an exceptional circumstance as a bug in the code for this class.</p>    
 */
public class OM1 extends AbstractSegment  {

  /**
   * Creates a OM1 (GENERAL - fields that apply to most observations) segment object that belongs to the given 
   * message.  
   */
  public OM1(Group parent, ModelClassFactory factory) {
    super(parent, factory);
    Message message = getMessage();
    try {
       this.add(ST.class, false, 1, 3, new Object[]{message});
       this.add(NM.class, false, 1, 4, new Object[]{message});
       this.add(CE.class, true, 1, 200, new Object[]{message});
       this.add(ID.class, false, 0, 12, new Object[]{message, new Integer(125)});
       this.add(ID.class, true, 1, 1, new Object[]{message, new Integer(136)});
       this.add(CE.class, true, 1, 200, new Object[]{message});
       this.add(TX.class, false, 1, 200, new Object[]{message});
       this.add(CE.class, false, 1, 200, new Object[]{message});
       this.add(ST.class, true, 0, 200, new Object[]{message});
       this.add(ST.class, false, 1, 30, new Object[]{message});
       this.add(ST.class, false, 1, 8, new Object[]{message});
       this.add(ST.class, false, 1, 200, new Object[]{message});
       this.add(ID.class, false, 1, 1, new Object[]{message, new Integer(136)});
       this.add(CE.class, false, 0, 60, new Object[]{message});
       this.add(CE.class, false, 0, 200, new Object[]{message});
       this.add(ID.class, false, 1, 1, new Object[]{message, new Integer(136)});
       this.add(ID.class, false, 0, 1, new Object[]{message, new Integer(0)});
       this.add(TN.class, false, 1, 40, new Object[]{message});
       this.add(ID.class, true, 1, 1, new Object[]{message, new Integer(174)});
       this.add(CE.class, false, 1, 200, new Object[]{message});
       this.add(ST.class, false, 1, 20, new Object[]{message});
       this.add(TS.class, true, 1, 26, new Object[]{message});
       this.add(TS.class, false, 1, 26, new Object[]{message});
       this.add(NM.class, false, 1, 20, new Object[]{message});
       this.add(NM.class, false, 1, 20, new Object[]{message});
       this.add(ID.class, false, 0, 40, new Object[]{message, new Integer(168)});
       this.add(ID.class, false, 1, 5, new Object[]{message, new Integer(169)});
       this.add(CE.class, false, 0, 200, new Object[]{message});
       this.add(AD.class, false, 0, 1000, new Object[]{message});
       this.add(TN.class, false, 0, 400, new Object[]{message});
       this.add(ID.class, false, 1, 1, new Object[]{message, new Integer(177)});
       this.add(CE.class, false, 0, 200, new Object[]{message});
       this.add(TX.class, false, 1, 65536, new Object[]{message});
       this.add(CE.class, false, 0, 65536, new Object[]{message});
       this.add(CE.class, false, 0, 200, new Object[]{message});
       this.add(ST.class, false, 1, 80, new Object[]{message});
       this.add(CE.class, false, 0, 65536, new Object[]{message});
       this.add(TX.class, false, 1, 200, new Object[]{message});
       this.add(CE.class, false, 1, 200, new Object[]{message});
       this.add(TX.class, false, 1, 200, new Object[]{message});
       this.add(ST.class, false, 0, 60, new Object[]{message});
       this.add(TX.class, false, 1, 65536, new Object[]{message});
    } catch (HL7Exception he) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Can't instantiate " + this.getClass().getName(), he);
    }
  }

  /**
   * Returns Segment Type ID (OM1-1).
   */
  public ST getSegmentTypeID()  {
    ST ret = null;
    try {
        Type t = this.getField(1, 0);
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
   * Returns Sequence Number - Test/ Observation Master File (OM1-2).
   */
  public NM getSequenceNumberTestObservationMasterFile()  {
    NM ret = null;
    try {
        Type t = this.getField(2, 0);
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
   * Returns Producer's test / observation ID (OM1-3).
   */
  public CE getProducerSTestObservationID()  {
    CE ret = null;
    try {
        Type t = this.getField(3, 0);
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
   * Returns a single repetition of Permitted Data Types (OM1-4).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public ID getPermittedDataTypes(int rep) throws HL7Exception {
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
   * Returns all repetitions of Permitted Data Types (OM1-4).
   */
  public ID[] getPermittedDataTypes() {
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
   * Returns Specimen Required (OM1-5).
   */
  public ID getSpecimenRequired()  {
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
   * Returns Producer ID (OM1-6).
   */
  public CE getProducerID()  {
    CE ret = null;
    try {
        Type t = this.getField(6, 0);
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
   * Returns Observation Description (OM1-7).
   */
  public TX getObservationDescription()  {
    TX ret = null;
    try {
        Type t = this.getField(7, 0);
        ret = (TX)t;
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
   * Returns Other test / observation IDs for the observation (OM1-8).
   */
  public CE getOtherTestObservationIDsForTheObservation()  {
    CE ret = null;
    try {
        Type t = this.getField(8, 0);
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
   * Returns a single repetition of Other Names (OM1-9).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public ST getOtherNames(int rep) throws HL7Exception {
    ST ret = null;
    try {
        Type t = this.getField(9, rep);
        ret = (ST)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    }
    return ret;
  }

  /**
   * Returns all repetitions of Other Names (OM1-9).
   */
  public ST[] getOtherNames() {
     ST[] ret = null;
    try {
        Type[] t = this.getField(9);  
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
   * Returns Preferred Report Name for the Observation (OM1-10).
   */
  public ST getPreferredReportNameForTheObservation()  {
    ST ret = null;
    try {
        Type t = this.getField(10, 0);
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
   * Returns Preferred Short Name or Mnemonic for Observation (OM1-11).
   */
  public ST getPreferredShortNameOrMnemonicForObservation()  {
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
   * Returns Preferred Long Name for the Observation (OM1-12).
   */
  public ST getPreferredLongNameForTheObservation()  {
    ST ret = null;
    try {
        Type t = this.getField(12, 0);
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
   * Returns Orderability (OM1-13).
   */
  public ID getOrderability()  {
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
   * Returns a single repetition of Identity of instrument used to perform this study (OM1-14).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public CE getIdentityOfInstrumentUsedToPerformThisStudy(int rep) throws HL7Exception {
    CE ret = null;
    try {
        Type t = this.getField(14, rep);
        ret = (CE)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    }
    return ret;
  }

  /**
   * Returns all repetitions of Identity of instrument used to perform this study (OM1-14).
   */
  public CE[] getIdentityOfInstrumentUsedToPerformThisStudy() {
     CE[] ret = null;
    try {
        Type[] t = this.getField(14);  
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
   * Returns a single repetition of Coded Representation of Method (OM1-15).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public CE getCodedRepresentationOfMethod(int rep) throws HL7Exception {
    CE ret = null;
    try {
        Type t = this.getField(15, rep);
        ret = (CE)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    }
    return ret;
  }

  /**
   * Returns all repetitions of Coded Representation of Method (OM1-15).
   */
  public CE[] getCodedRepresentationOfMethod() {
     CE[] ret = null;
    try {
        Type[] t = this.getField(15);  
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
   * Returns Portable (OM1-16).
   */
  public ID getPortable()  {
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
   * Returns a single repetition of Observation producing department / section (OM1-17).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public ID getObservationProducingDepartmentSection(int rep) throws HL7Exception {
    ID ret = null;
    try {
        Type t = this.getField(17, rep);
        ret = (ID)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    }
    return ret;
  }

  /**
   * Returns all repetitions of Observation producing department / section (OM1-17).
   */
  public ID[] getObservationProducingDepartmentSection() {
     ID[] ret = null;
    try {
        Type[] t = this.getField(17);  
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
   * Returns Telephone Number of Section (OM1-18).
   */
  public TN getTelephoneNumberOfSection()  {
    TN ret = null;
    try {
        Type t = this.getField(18, 0);
        ret = (TN)t;
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
   * Returns Nature of test / observation (OM1-19).
   */
  public ID getNatureOfTestObservation()  {
    ID ret = null;
    try {
        Type t = this.getField(19, 0);
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
   * Returns Report Subheader (OM1-20).
   */
  public CE getReportSubheader()  {
    CE ret = null;
    try {
        Type t = this.getField(20, 0);
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
   * Returns Report Display Order (OM1-21).
   */
  public ST getReportDisplayOrder()  {
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
   * Returns Date / time stamp for any change in definition for obs (OM1-22).
   */
  public TS getDateTimeStampForAnyChangeInDefinitionForObs()  {
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
   * Returns Effective date / time of change (OM1-23).
   */
  public TS getEffectiveDateTimeOfChange()  {
    TS ret = null;
    try {
        Type t = this.getField(23, 0);
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
   * Returns Typical Turn-around Time (OM1-24).
   */
  public NM getTypicalTurnAroundTime()  {
    NM ret = null;
    try {
        Type t = this.getField(24, 0);
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
   * Returns Processing Time (OM1-25).
   */
  public NM getProcessingTime()  {
    NM ret = null;
    try {
        Type t = this.getField(25, 0);
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
   * Returns a single repetition of Processing Priority (OM1-26).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public ID getProcessingPriority(int rep) throws HL7Exception {
    ID ret = null;
    try {
        Type t = this.getField(26, rep);
        ret = (ID)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    }
    return ret;
  }

  /**
   * Returns all repetitions of Processing Priority (OM1-26).
   */
  public ID[] getProcessingPriority() {
     ID[] ret = null;
    try {
        Type[] t = this.getField(26);  
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
   * Returns Reporting Priority (OM1-27).
   */
  public ID getReportingPriority()  {
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
   * Returns a single repetition of Outside Site(s) Where Observation may be Performed (OM1-28).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public CE getOutsideSiteSWhereObservationMayBePerformed(int rep) throws HL7Exception {
    CE ret = null;
    try {
        Type t = this.getField(28, rep);
        ret = (CE)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    }
    return ret;
  }

  /**
   * Returns all repetitions of Outside Site(s) Where Observation may be Performed (OM1-28).
   */
  public CE[] getOutsideSiteSWhereObservationMayBePerformed() {
     CE[] ret = null;
    try {
        Type[] t = this.getField(28);  
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
   * Returns a single repetition of Address of Outside Site(s) (OM1-29).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public AD getAddressOfOutsideSiteS(int rep) throws HL7Exception {
    AD ret = null;
    try {
        Type t = this.getField(29, rep);
        ret = (AD)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    }
    return ret;
  }

  /**
   * Returns all repetitions of Address of Outside Site(s) (OM1-29).
   */
  public AD[] getAddressOfOutsideSiteS() {
     AD[] ret = null;
    try {
        Type[] t = this.getField(29);  
        ret = new AD[t.length];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = (AD)t[i];
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
   * Returns a single repetition of Phone Number of Outside Site (OM1-30).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public TN getPhoneNumberOfOutsideSite(int rep) throws HL7Exception {
    TN ret = null;
    try {
        Type t = this.getField(30, rep);
        ret = (TN)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    }
    return ret;
  }

  /**
   * Returns all repetitions of Phone Number of Outside Site (OM1-30).
   */
  public TN[] getPhoneNumberOfOutsideSite() {
     TN[] ret = null;
    try {
        Type[] t = this.getField(30);  
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
   * Returns Confidentiality Code (OM1-31).
   */
  public ID getConfidentialityCode()  {
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
   * Returns a single repetition of Observations required to interpret the observation (OM1-32).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public CE getObservationsRequiredToInterpretTheObservation(int rep) throws HL7Exception {
    CE ret = null;
    try {
        Type t = this.getField(32, rep);
        ret = (CE)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    }
    return ret;
  }

  /**
   * Returns all repetitions of Observations required to interpret the observation (OM1-32).
   */
  public CE[] getObservationsRequiredToInterpretTheObservation() {
     CE[] ret = null;
    try {
        Type[] t = this.getField(32);  
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
   * Returns Interpretation of Observations (OM1-33).
   */
  public TX getInterpretationOfObservations()  {
    TX ret = null;
    try {
        Type t = this.getField(33, 0);
        ret = (TX)t;
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
   * Returns a single repetition of Contraindications to Observations (OM1-34).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public CE getContraindicationsToObservations(int rep) throws HL7Exception {
    CE ret = null;
    try {
        Type t = this.getField(34, rep);
        ret = (CE)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    }
    return ret;
  }

  /**
   * Returns all repetitions of Contraindications to Observations (OM1-34).
   */
  public CE[] getContraindicationsToObservations() {
     CE[] ret = null;
    try {
        Type[] t = this.getField(34);  
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
   * Returns a single repetition of Reflex tests / observations (OM1-35).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public CE getReflexTestsObservations(int rep) throws HL7Exception {
    CE ret = null;
    try {
        Type t = this.getField(35, rep);
        ret = (CE)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    }
    return ret;
  }

  /**
   * Returns all repetitions of Reflex tests / observations (OM1-35).
   */
  public CE[] getReflexTestsObservations() {
     CE[] ret = null;
    try {
        Type[] t = this.getField(35);  
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
   * Returns Rules that Trigger Reflex Testing (OM1-36).
   */
  public ST getRulesThatTriggerReflexTesting()  {
    ST ret = null;
    try {
        Type t = this.getField(36, 0);
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
   * Returns a single repetition of Fixed Canned Message (OM1-37).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public CE getFixedCannedMessage(int rep) throws HL7Exception {
    CE ret = null;
    try {
        Type t = this.getField(37, rep);
        ret = (CE)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    }
    return ret;
  }

  /**
   * Returns all repetitions of Fixed Canned Message (OM1-37).
   */
  public CE[] getFixedCannedMessage() {
     CE[] ret = null;
    try {
        Type[] t = this.getField(37);  
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
   * Returns Patient Preparation (OM1-38).
   */
  public TX getPatientPreparation()  {
    TX ret = null;
    try {
        Type t = this.getField(38, 0);
        ret = (TX)t;
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
   * Returns Procedure Medication (OM1-39).
   */
  public CE getProcedureMedication()  {
    CE ret = null;
    try {
        Type t = this.getField(39, 0);
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
   * Returns Factors that may affect the observation (OM1-40).
   */
  public TX getFactorsThatMayAffectTheObservation()  {
    TX ret = null;
    try {
        Type t = this.getField(40, 0);
        ret = (TX)t;
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
   * Returns a single repetition of Test / observation performance schedule (OM1-41).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public ST getTestObservationPerformanceSchedule(int rep) throws HL7Exception {
    ST ret = null;
    try {
        Type t = this.getField(41, rep);
        ret = (ST)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    }
    return ret;
  }

  /**
   * Returns all repetitions of Test / observation performance schedule (OM1-41).
   */
  public ST[] getTestObservationPerformanceSchedule() {
     ST[] ret = null;
    try {
        Type[] t = this.getField(41);  
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
   * Returns Description of Test Methods (OM1-42).
   */
  public TX getDescriptionOfTestMethods()  {
    TX ret = null;
    try {
        Type t = this.getField(42, 0);
        ret = (TX)t;
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