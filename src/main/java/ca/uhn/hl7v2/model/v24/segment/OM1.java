package ca.uhn.hl7v2.model.v24.segment;

import ca.uhn.hl7v2.model.*;
import ca.uhn.hl7v2.model.v24.datatype.*;

import ca.uhn.log.HapiLogFactory;
import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.HL7Exception;

/**
 * <p>Represents an HL7 OM1 message segment. 
 * This segment has the following fields:</p><p>
 * OM1-1: Sequence Number - Test/ Observation Master File (NM)<br> 
 * OM1-2: Producer's Service/Test/Observation ID (CE)<br> 
 * OM1-3: Permitted Data Types (ID)<br> 
 * OM1-4: Specimen Required (ID)<br> 
 * OM1-5: Producer ID (CE)<br> 
 * OM1-6: Observation Description (TX)<br> 
 * OM1-7: Other Service/Test/Observation IDs for the Observation (CE)<br> 
 * OM1-8: Other Names (ST)<br> 
 * OM1-9: Preferred Report Name for the Observation (ST)<br> 
 * OM1-10: Preferred Short Name or Mnemonic for Observation (ST)<br> 
 * OM1-11: Preferred Long Name for the Observation (ST)<br> 
 * OM1-12: Orderability (ID)<br> 
 * OM1-13: Identity of Instrument Used to Perform this Study (CE)<br> 
 * OM1-14: Coded Representation of Method (CE)<br> 
 * OM1-15: Portable Device Indicator (ID)<br> 
 * OM1-16: Observation Producing Department/Section (CE)<br> 
 * OM1-17: Telephone Number of Section (XTN)<br> 
 * OM1-18: Nature of Service/Test/Observation (IS)<br> 
 * OM1-19: Report Subheader (CE)<br> 
 * OM1-20: Report Display Order (ST)<br> 
 * OM1-21: Date/Time Stamp for any change in Definition for the Observation (TS)<br> 
 * OM1-22: Effective Date/Time of Change (TS)<br> 
 * OM1-23: Typical Turn-Around Time (NM)<br> 
 * OM1-24: Processing Time (NM)<br> 
 * OM1-25: Processing Priority (ID)<br> 
 * OM1-26: Reporting Priority (ID)<br> 
 * OM1-27: Outside Site(s) Where Observation may be Performed (CE)<br> 
 * OM1-28: Address of Outside Site(s) (XAD)<br> 
 * OM1-29: Phone Number of Outside Site (XTN)<br> 
 * OM1-30: Confidentiality Code (IS)<br> 
 * OM1-31: Observations Required to Interpret the Observation (CE)<br> 
 * OM1-32: Interpretation of Observations (TX)<br> 
 * OM1-33: Contraindications to Observations (CE)<br> 
 * OM1-34: Reflex Tests/Observations (CE)<br> 
 * OM1-35: Rules that Trigger Reflex Testing (TX)<br> 
 * OM1-36: Fixed Canned Message (CE)<br> 
 * OM1-37: Patient Preparation (TX)<br> 
 * OM1-38: Procedure Medication (CE)<br> 
 * OM1-39: Factors that may Affect Affect the Observation (TX)<br> 
 * OM1-40: Service/Test/Observation Performance Schedule (ST)<br> 
 * OM1-41: Description of Test Methods (TX)<br> 
 * OM1-42: Kind of Quantity Observed (CE)<br> 
 * OM1-43: Point Versus Interval (CE)<br> 
 * OM1-44: Challenge Information (TX)<br> 
 * OM1-45: Relationship Modifier (CE)<br> 
 * OM1-46: Target Anatomic Site Of Test (CE)<br> 
 * OM1-47: Modality Of Imaging Measurement (CE)<br> 
 * </p><p>The get...() methods return data from individual fields.  These methods 
 * do not throw exceptions and may therefore have to handle exceptions internally.  
 * If an exception is handled internally, it is logged and null is returned.  
 * This is not expected to happen - if it does happen this indicates not so much 
 * an exceptional circumstance as a bug in the code for this class.</p>    
 */
public class OM1 extends AbstractSegment  {

  /**
   * Creates a OM1 (General Segment) segment object that belongs to the given 
   * message.  
   */
  public OM1(Group parent, ModelClassFactory factory) {
    super(parent, factory);
    Message message = getMessage();
    try {
       this.add(NM.class, true, 1, 4, new Object[]{message});
       this.add(CE.class, true, 1, 250, new Object[]{message});
       this.add(ID.class, false, 0, 12, new Object[]{message, new Integer(125)});
       this.add(ID.class, true, 1, 1, new Object[]{message, new Integer(136)});
       this.add(CE.class, true, 1, 250, new Object[]{message});
       this.add(TX.class, false, 1, 200, new Object[]{message});
       this.add(CE.class, false, 1, 250, new Object[]{message});
       this.add(ST.class, true, 0, 200, new Object[]{message});
       this.add(ST.class, false, 1, 30, new Object[]{message});
       this.add(ST.class, false, 1, 8, new Object[]{message});
       this.add(ST.class, false, 1, 200, new Object[]{message});
       this.add(ID.class, false, 1, 1, new Object[]{message, new Integer(136)});
       this.add(CE.class, false, 0, 250, new Object[]{message});
       this.add(CE.class, false, 0, 250, new Object[]{message});
       this.add(ID.class, false, 1, 1, new Object[]{message, new Integer(136)});
       this.add(CE.class, false, 0, 250, new Object[]{message});
       this.add(XTN.class, false, 1, 250, new Object[]{message});
       this.add(IS.class, true, 1, 1, new Object[]{message, new Integer(174)});
       this.add(CE.class, false, 1, 250, new Object[]{message});
       this.add(ST.class, false, 1, 20, new Object[]{message});
       this.add(TS.class, false, 1, 26, new Object[]{message});
       this.add(TS.class, false, 1, 26, new Object[]{message});
       this.add(NM.class, false, 1, 20, new Object[]{message});
       this.add(NM.class, false, 1, 20, new Object[]{message});
       this.add(ID.class, false, 0, 40, new Object[]{message, new Integer(168)});
       this.add(ID.class, false, 1, 5, new Object[]{message, new Integer(169)});
       this.add(CE.class, false, 0, 250, new Object[]{message});
       this.add(XAD.class, false, 0, 1000, new Object[]{message});
       this.add(XTN.class, false, 1, 400, new Object[]{message});
       this.add(IS.class, false, 1, 1, new Object[]{message, new Integer(177)});
       this.add(CE.class, false, 1, 250, new Object[]{message});
       this.add(TX.class, false, 1, 65536, new Object[]{message});
       this.add(CE.class, false, 1, 65536, new Object[]{message});
       this.add(CE.class, false, 0, 250, new Object[]{message});
       this.add(TX.class, false, 1, 80, new Object[]{message});
       this.add(CE.class, false, 1, 65536, new Object[]{message});
       this.add(TX.class, false, 1, 200, new Object[]{message});
       this.add(CE.class, false, 1, 250, new Object[]{message});
       this.add(TX.class, false, 1, 200, new Object[]{message});
       this.add(ST.class, false, 0, 60, new Object[]{message});
       this.add(TX.class, false, 1, 65536, new Object[]{message});
       this.add(CE.class, false, 1, 250, new Object[]{message});
       this.add(CE.class, false, 1, 250, new Object[]{message});
       this.add(TX.class, false, 1, 200, new Object[]{message});
       this.add(CE.class, false, 1, 250, new Object[]{message});
       this.add(CE.class, false, 1, 250, new Object[]{message});
       this.add(CE.class, false, 1, 250, new Object[]{message});
    } catch (HL7Exception he) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Can't instantiate " + this.getClass().getName(), he);
    }
  }

  /**
   * Returns Sequence Number - Test/ Observation Master File (OM1-1).
   */
  public NM getSequenceNumberTestObservationMasterFile()  {
    NM ret = null;
    try {
        Type t = this.getField(1, 0);
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
   * Returns Producer's Service/Test/Observation ID (OM1-2).
   */
  public CE getProducerSServiceTestObservationID()  {
    CE ret = null;
    try {
        Type t = this.getField(2, 0);
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
   * Returns a single repetition of Permitted Data Types (OM1-3).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public ID getPermittedDataTypes(int rep) throws HL7Exception {
    ID ret = null;
    try {
        Type t = this.getField(3, rep);
        ret = (ID)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    }
    return ret;
  }

  /**
   * Returns all repetitions of Permitted Data Types (OM1-3).
   */
  public ID[] getPermittedDataTypes() {
     ID[] ret = null;
    try {
        Type[] t = this.getField(3);  
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
   * Returns Specimen Required (OM1-4).
   */
  public ID getSpecimenRequired()  {
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
   * Returns Producer ID (OM1-5).
   */
  public CE getProducerID()  {
    CE ret = null;
    try {
        Type t = this.getField(5, 0);
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
   * Returns Observation Description (OM1-6).
   */
  public TX getObservationDescription()  {
    TX ret = null;
    try {
        Type t = this.getField(6, 0);
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
   * Returns Other Service/Test/Observation IDs for the Observation (OM1-7).
   */
  public CE getOtherServiceTestObservationIDsForTheObservation()  {
    CE ret = null;
    try {
        Type t = this.getField(7, 0);
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
   * Returns a single repetition of Other Names (OM1-8).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public ST getOtherNames(int rep) throws HL7Exception {
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
   * Returns all repetitions of Other Names (OM1-8).
   */
  public ST[] getOtherNames() {
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
   * Returns Preferred Report Name for the Observation (OM1-9).
   */
  public ST getPreferredReportNameForTheObservation()  {
    ST ret = null;
    try {
        Type t = this.getField(9, 0);
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
   * Returns Preferred Short Name or Mnemonic for Observation (OM1-10).
   */
  public ST getPreferredShortNameOrMnemonicForObservation()  {
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
   * Returns Preferred Long Name for the Observation (OM1-11).
   */
  public ST getPreferredLongNameForTheObservation()  {
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
   * Returns Orderability (OM1-12).
   */
  public ID getOrderability()  {
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
   * Returns a single repetition of Identity of Instrument Used to Perform this Study (OM1-13).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public CE getIdentityOfInstrumentUsedToPerformThisStudy(int rep) throws HL7Exception {
    CE ret = null;
    try {
        Type t = this.getField(13, rep);
        ret = (CE)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    }
    return ret;
  }

  /**
   * Returns all repetitions of Identity of Instrument Used to Perform this Study (OM1-13).
   */
  public CE[] getIdentityOfInstrumentUsedToPerformThisStudy() {
     CE[] ret = null;
    try {
        Type[] t = this.getField(13);  
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
   * Returns a single repetition of Coded Representation of Method (OM1-14).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public CE getCodedRepresentationOfMethod(int rep) throws HL7Exception {
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
   * Returns all repetitions of Coded Representation of Method (OM1-14).
   */
  public CE[] getCodedRepresentationOfMethod() {
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
   * Returns Portable Device Indicator (OM1-15).
   */
  public ID getPortableDeviceIndicator()  {
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
   * Returns a single repetition of Observation Producing Department/Section (OM1-16).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public CE getObservationProducingDepartmentSection(int rep) throws HL7Exception {
    CE ret = null;
    try {
        Type t = this.getField(16, rep);
        ret = (CE)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    }
    return ret;
  }

  /**
   * Returns all repetitions of Observation Producing Department/Section (OM1-16).
   */
  public CE[] getObservationProducingDepartmentSection() {
     CE[] ret = null;
    try {
        Type[] t = this.getField(16);  
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
   * Returns Telephone Number of Section (OM1-17).
   */
  public XTN getTelephoneNumberOfSection()  {
    XTN ret = null;
    try {
        Type t = this.getField(17, 0);
        ret = (XTN)t;
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
   * Returns Nature of Service/Test/Observation (OM1-18).
   */
  public IS getNatureOfServiceTestObservation()  {
    IS ret = null;
    try {
        Type t = this.getField(18, 0);
        ret = (IS)t;
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
   * Returns Report Subheader (OM1-19).
   */
  public CE getReportSubheader()  {
    CE ret = null;
    try {
        Type t = this.getField(19, 0);
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
   * Returns Report Display Order (OM1-20).
   */
  public ST getReportDisplayOrder()  {
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
   * Returns Date/Time Stamp for any change in Definition for the Observation (OM1-21).
   */
  public TS getDateTimeStampForAnyChangeInDefinitionForTheObservation()  {
    TS ret = null;
    try {
        Type t = this.getField(21, 0);
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
   * Returns Effective Date/Time of Change (OM1-22).
   */
  public TS getEffectiveDateTimeOfChange()  {
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
   * Returns Typical Turn-Around Time (OM1-23).
   */
  public NM getTypicalTurnAroundTime()  {
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
   * Returns Processing Time (OM1-24).
   */
  public NM getProcessingTime()  {
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
   * Returns a single repetition of Processing Priority (OM1-25).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public ID getProcessingPriority(int rep) throws HL7Exception {
    ID ret = null;
    try {
        Type t = this.getField(25, rep);
        ret = (ID)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    }
    return ret;
  }

  /**
   * Returns all repetitions of Processing Priority (OM1-25).
   */
  public ID[] getProcessingPriority() {
     ID[] ret = null;
    try {
        Type[] t = this.getField(25);  
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
   * Returns Reporting Priority (OM1-26).
   */
  public ID getReportingPriority()  {
    ID ret = null;
    try {
        Type t = this.getField(26, 0);
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
   * Returns a single repetition of Outside Site(s) Where Observation may be Performed (OM1-27).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public CE getOutsideSiteSWhereObservationMayBePerformed(int rep) throws HL7Exception {
    CE ret = null;
    try {
        Type t = this.getField(27, rep);
        ret = (CE)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    }
    return ret;
  }

  /**
   * Returns all repetitions of Outside Site(s) Where Observation may be Performed (OM1-27).
   */
  public CE[] getOutsideSiteSWhereObservationMayBePerformed() {
     CE[] ret = null;
    try {
        Type[] t = this.getField(27);  
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
   * Returns a single repetition of Address of Outside Site(s) (OM1-28).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public XAD getAddressOfOutsideSiteS(int rep) throws HL7Exception {
    XAD ret = null;
    try {
        Type t = this.getField(28, rep);
        ret = (XAD)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    }
    return ret;
  }

  /**
   * Returns all repetitions of Address of Outside Site(s) (OM1-28).
   */
  public XAD[] getAddressOfOutsideSiteS() {
     XAD[] ret = null;
    try {
        Type[] t = this.getField(28);  
        ret = new XAD[t.length];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = (XAD)t[i];
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
   * Returns Phone Number of Outside Site (OM1-29).
   */
  public XTN getPhoneNumberOfOutsideSite()  {
    XTN ret = null;
    try {
        Type t = this.getField(29, 0);
        ret = (XTN)t;
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
   * Returns Confidentiality Code (OM1-30).
   */
  public IS getConfidentialityCode()  {
    IS ret = null;
    try {
        Type t = this.getField(30, 0);
        ret = (IS)t;
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
   * Returns Observations Required to Interpret the Observation (OM1-31).
   */
  public CE getObservationsRequiredToInterpretTheObservation()  {
    CE ret = null;
    try {
        Type t = this.getField(31, 0);
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
   * Returns Interpretation of Observations (OM1-32).
   */
  public TX getInterpretationOfObservations()  {
    TX ret = null;
    try {
        Type t = this.getField(32, 0);
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
   * Returns Contraindications to Observations (OM1-33).
   */
  public CE getContraindicationsToObservations()  {
    CE ret = null;
    try {
        Type t = this.getField(33, 0);
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
   * Returns a single repetition of Reflex Tests/Observations (OM1-34).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public CE getReflexTestsObservations(int rep) throws HL7Exception {
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
   * Returns all repetitions of Reflex Tests/Observations (OM1-34).
   */
  public CE[] getReflexTestsObservations() {
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
   * Returns Rules that Trigger Reflex Testing (OM1-35).
   */
  public TX getRulesThatTriggerReflexTesting()  {
    TX ret = null;
    try {
        Type t = this.getField(35, 0);
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
   * Returns Fixed Canned Message (OM1-36).
   */
  public CE getFixedCannedMessage()  {
    CE ret = null;
    try {
        Type t = this.getField(36, 0);
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
   * Returns Patient Preparation (OM1-37).
   */
  public TX getPatientPreparation()  {
    TX ret = null;
    try {
        Type t = this.getField(37, 0);
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
   * Returns Procedure Medication (OM1-38).
   */
  public CE getProcedureMedication()  {
    CE ret = null;
    try {
        Type t = this.getField(38, 0);
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
   * Returns Factors that may Affect Affect the Observation (OM1-39).
   */
  public TX getFactorsThatMayAffectAffectTheObservation()  {
    TX ret = null;
    try {
        Type t = this.getField(39, 0);
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
   * Returns a single repetition of Service/Test/Observation Performance Schedule (OM1-40).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public ST getServiceTestObservationPerformanceSchedule(int rep) throws HL7Exception {
    ST ret = null;
    try {
        Type t = this.getField(40, rep);
        ret = (ST)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    }
    return ret;
  }

  /**
   * Returns all repetitions of Service/Test/Observation Performance Schedule (OM1-40).
   */
  public ST[] getServiceTestObservationPerformanceSchedule() {
     ST[] ret = null;
    try {
        Type[] t = this.getField(40);  
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
   * Returns Description of Test Methods (OM1-41).
   */
  public TX getDescriptionOfTestMethods()  {
    TX ret = null;
    try {
        Type t = this.getField(41, 0);
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
   * Returns Kind of Quantity Observed (OM1-42).
   */
  public CE getKindOfQuantityObserved()  {
    CE ret = null;
    try {
        Type t = this.getField(42, 0);
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
   * Returns Point Versus Interval (OM1-43).
   */
  public CE getPointVersusInterval()  {
    CE ret = null;
    try {
        Type t = this.getField(43, 0);
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
   * Returns Challenge Information (OM1-44).
   */
  public TX getChallengeInformation()  {
    TX ret = null;
    try {
        Type t = this.getField(44, 0);
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
   * Returns Relationship Modifier (OM1-45).
   */
  public CE getRelationshipModifier()  {
    CE ret = null;
    try {
        Type t = this.getField(45, 0);
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
   * Returns Target Anatomic Site Of Test (OM1-46).
   */
  public CE getTargetAnatomicSiteOfTest()  {
    CE ret = null;
    try {
        Type t = this.getField(46, 0);
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
   * Returns Modality Of Imaging Measurement (OM1-47).
   */
  public CE getModalityOfImagingMeasurement()  {
    CE ret = null;
    try {
        Type t = this.getField(47, 0);
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

}