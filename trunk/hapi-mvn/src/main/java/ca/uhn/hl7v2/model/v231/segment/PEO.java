package ca.uhn.hl7v2.model.v231.segment;

import ca.uhn.hl7v2.model.*;
import ca.uhn.hl7v2.model.v231.datatype.*;

import ca.uhn.log.HapiLogFactory;
import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.HL7Exception;

/**
 * <p>Represents an HL7 PEO message segment. 
 * This segment has the following fields:</p><p>
 * PEO-1: Event Identifiers Used (CE)<br> 
 * PEO-2: Event Symptom/Diagnosis Code (CE)<br> 
 * PEO-3: Event Onset Date/Time (TS)<br> 
 * PEO-4: Event Exacerbation Date/Time (TS)<br> 
 * PEO-5: Event Improved Date/Time (TS)<br> 
 * PEO-6: Event Ended Data/Time (TS)<br> 
 * PEO-7: Event Location Occurred Address (XAD)<br> 
 * PEO-8: Event Qualification (ID)<br> 
 * PEO-9: Event Serious (ID)<br> 
 * PEO-10: Event Expected (ID)<br> 
 * PEO-11: Event Outcome (ID)<br> 
 * PEO-12: Patient Outcome (ID)<br> 
 * PEO-13: Event Description From Others (FT)<br> 
 * PEO-14: Event From Original Reporter (FT)<br> 
 * PEO-15: Event Description From Patient (FT)<br> 
 * PEO-16: Event Description From Practitioner (FT)<br> 
 * PEO-17: Event Description From Autopsy (FT)<br> 
 * PEO-18: Cause Of Death (CE)<br> 
 * PEO-19: Primary Observer Name (XPN)<br> 
 * PEO-20: Primary Observer Address (XAD)<br> 
 * PEO-21: Primary Observer Telephone (XTN)<br> 
 * PEO-22: Primary Observer’s Qualification (ID)<br> 
 * PEO-23: Confirmation Provided By (ID)<br> 
 * PEO-24: Primary Observer Aware Date/Time (TS)<br> 
 * PEO-25: Primary Observer’s identity May Be Divulged (ID)<br> 
 * </p><p>The get...() methods return data from individual fields.  These methods 
 * do not throw exceptions and may therefore have to handle exceptions internally.  
 * If an exception is handled internally, it is logged and null is returned.  
 * This is not expected to happen - if it does happen this indicates not so much 
 * an exceptional circumstance as a bug in the code for this class.</p>    
 */
public class PEO extends AbstractSegment  {

  /**
   * Creates a PEO (PEO - product experience observation segment) segment object that belongs to the given 
   * message.  
   */
  public PEO(Group parent, ModelClassFactory factory) {
    super(parent, factory);
    Message message = getMessage();
    try {
       this.add(CE.class, false, 0, 60, new Object[]{message});
       this.add(CE.class, false, 0, 60, new Object[]{message});
       this.add(TS.class, true, 1, 26, new Object[]{message});
       this.add(TS.class, false, 1, 26, new Object[]{message});
       this.add(TS.class, false, 1, 26, new Object[]{message});
       this.add(TS.class, false, 1, 26, new Object[]{message});
       this.add(XAD.class, false, 0, 106, new Object[]{message});
       this.add(ID.class, false, 0, 1, new Object[]{message, new Integer(237)});
       this.add(ID.class, false, 1, 1, new Object[]{message, new Integer(238)});
       this.add(ID.class, false, 1, 1, new Object[]{message, new Integer(239)});
       this.add(ID.class, false, 0, 1, new Object[]{message, new Integer(240)});
       this.add(ID.class, false, 1, 1, new Object[]{message, new Integer(241)});
       this.add(FT.class, false, 0, 600, new Object[]{message});
       this.add(FT.class, false, 0, 600, new Object[]{message});
       this.add(FT.class, false, 0, 600, new Object[]{message});
       this.add(FT.class, false, 0, 600, new Object[]{message});
       this.add(FT.class, false, 0, 600, new Object[]{message});
       this.add(CE.class, false, 0, 60, new Object[]{message});
       this.add(XPN.class, false, 0, 46, new Object[]{message});
       this.add(XAD.class, false, 0, 106, new Object[]{message});
       this.add(XTN.class, false, 0, 40, new Object[]{message});
       this.add(ID.class, false, 1, 1, new Object[]{message, new Integer(242)});
       this.add(ID.class, false, 1, 1, new Object[]{message, new Integer(242)});
       this.add(TS.class, false, 1, 26, new Object[]{message});
       this.add(ID.class, false, 1, 1, new Object[]{message, new Integer(243)});
    } catch (HL7Exception he) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Can't instantiate " + this.getClass().getName(), he);
    }
  }

  /**
   * Returns a single repetition of Event Identifiers Used (PEO-1).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public CE getEventIdentifiersUsed(int rep) throws HL7Exception {
    CE ret = null;
    try {
        Type t = this.getField(1, rep);
        ret = (CE)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    }
    return ret;
  }

  /**
   * Returns all repetitions of Event Identifiers Used (PEO-1).
   */
  public CE[] getEventIdentifiersUsed() {
     CE[] ret = null;
    try {
        Type[] t = this.getField(1);  
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
   * Returns a single repetition of Event Symptom/Diagnosis Code (PEO-2).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public CE getEventSymptomDiagnosisCode(int rep) throws HL7Exception {
    CE ret = null;
    try {
        Type t = this.getField(2, rep);
        ret = (CE)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    }
    return ret;
  }

  /**
   * Returns all repetitions of Event Symptom/Diagnosis Code (PEO-2).
   */
  public CE[] getEventSymptomDiagnosisCode() {
     CE[] ret = null;
    try {
        Type[] t = this.getField(2);  
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
   * Returns Event Onset Date/Time (PEO-3).
   */
  public TS getEventOnsetDateTime()  {
    TS ret = null;
    try {
        Type t = this.getField(3, 0);
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
   * Returns Event Exacerbation Date/Time (PEO-4).
   */
  public TS getEventExacerbationDateTime()  {
    TS ret = null;
    try {
        Type t = this.getField(4, 0);
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
   * Returns Event Improved Date/Time (PEO-5).
   */
  public TS getEventImprovedDateTime()  {
    TS ret = null;
    try {
        Type t = this.getField(5, 0);
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
   * Returns Event Ended Data/Time (PEO-6).
   */
  public TS getEventEndedDataTime()  {
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
   * Returns a single repetition of Event Location Occurred Address (PEO-7).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public XAD getEventLocationOccurredAddress(int rep) throws HL7Exception {
    XAD ret = null;
    try {
        Type t = this.getField(7, rep);
        ret = (XAD)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    }
    return ret;
  }

  /**
   * Returns all repetitions of Event Location Occurred Address (PEO-7).
   */
  public XAD[] getEventLocationOccurredAddress() {
     XAD[] ret = null;
    try {
        Type[] t = this.getField(7);  
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
   * Returns a single repetition of Event Qualification (PEO-8).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public ID getEventQualification(int rep) throws HL7Exception {
    ID ret = null;
    try {
        Type t = this.getField(8, rep);
        ret = (ID)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    }
    return ret;
  }

  /**
   * Returns all repetitions of Event Qualification (PEO-8).
   */
  public ID[] getEventQualification() {
     ID[] ret = null;
    try {
        Type[] t = this.getField(8);  
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
   * Returns Event Serious (PEO-9).
   */
  public ID getEventSerious()  {
    ID ret = null;
    try {
        Type t = this.getField(9, 0);
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
   * Returns Event Expected (PEO-10).
   */
  public ID getEventExpected()  {
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
   * Returns a single repetition of Event Outcome (PEO-11).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public ID getEventOutcome(int rep) throws HL7Exception {
    ID ret = null;
    try {
        Type t = this.getField(11, rep);
        ret = (ID)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    }
    return ret;
  }

  /**
   * Returns all repetitions of Event Outcome (PEO-11).
   */
  public ID[] getEventOutcome() {
     ID[] ret = null;
    try {
        Type[] t = this.getField(11);  
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
   * Returns Patient Outcome (PEO-12).
   */
  public ID getPatientOutcome()  {
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
   * Returns a single repetition of Event Description From Others (PEO-13).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public FT getEventDescriptionFromOthers(int rep) throws HL7Exception {
    FT ret = null;
    try {
        Type t = this.getField(13, rep);
        ret = (FT)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    }
    return ret;
  }

  /**
   * Returns all repetitions of Event Description From Others (PEO-13).
   */
  public FT[] getEventDescriptionFromOthers() {
     FT[] ret = null;
    try {
        Type[] t = this.getField(13);  
        ret = new FT[t.length];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = (FT)t[i];
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
   * Returns a single repetition of Event From Original Reporter (PEO-14).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public FT getEventFromOriginalReporter(int rep) throws HL7Exception {
    FT ret = null;
    try {
        Type t = this.getField(14, rep);
        ret = (FT)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    }
    return ret;
  }

  /**
   * Returns all repetitions of Event From Original Reporter (PEO-14).
   */
  public FT[] getEventFromOriginalReporter() {
     FT[] ret = null;
    try {
        Type[] t = this.getField(14);  
        ret = new FT[t.length];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = (FT)t[i];
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
   * Returns a single repetition of Event Description From Patient (PEO-15).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public FT getEventDescriptionFromPatient(int rep) throws HL7Exception {
    FT ret = null;
    try {
        Type t = this.getField(15, rep);
        ret = (FT)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    }
    return ret;
  }

  /**
   * Returns all repetitions of Event Description From Patient (PEO-15).
   */
  public FT[] getEventDescriptionFromPatient() {
     FT[] ret = null;
    try {
        Type[] t = this.getField(15);  
        ret = new FT[t.length];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = (FT)t[i];
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
   * Returns a single repetition of Event Description From Practitioner (PEO-16).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public FT getEventDescriptionFromPractitioner(int rep) throws HL7Exception {
    FT ret = null;
    try {
        Type t = this.getField(16, rep);
        ret = (FT)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    }
    return ret;
  }

  /**
   * Returns all repetitions of Event Description From Practitioner (PEO-16).
   */
  public FT[] getEventDescriptionFromPractitioner() {
     FT[] ret = null;
    try {
        Type[] t = this.getField(16);  
        ret = new FT[t.length];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = (FT)t[i];
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
   * Returns a single repetition of Event Description From Autopsy (PEO-17).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public FT getEventDescriptionFromAutopsy(int rep) throws HL7Exception {
    FT ret = null;
    try {
        Type t = this.getField(17, rep);
        ret = (FT)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    }
    return ret;
  }

  /**
   * Returns all repetitions of Event Description From Autopsy (PEO-17).
   */
  public FT[] getEventDescriptionFromAutopsy() {
     FT[] ret = null;
    try {
        Type[] t = this.getField(17);  
        ret = new FT[t.length];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = (FT)t[i];
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
   * Returns a single repetition of Cause Of Death (PEO-18).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public CE getCauseOfDeath(int rep) throws HL7Exception {
    CE ret = null;
    try {
        Type t = this.getField(18, rep);
        ret = (CE)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    }
    return ret;
  }

  /**
   * Returns all repetitions of Cause Of Death (PEO-18).
   */
  public CE[] getCauseOfDeath() {
     CE[] ret = null;
    try {
        Type[] t = this.getField(18);  
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
   * Returns a single repetition of Primary Observer Name (PEO-19).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public XPN getPrimaryObserverName(int rep) throws HL7Exception {
    XPN ret = null;
    try {
        Type t = this.getField(19, rep);
        ret = (XPN)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    }
    return ret;
  }

  /**
   * Returns all repetitions of Primary Observer Name (PEO-19).
   */
  public XPN[] getPrimaryObserverName() {
     XPN[] ret = null;
    try {
        Type[] t = this.getField(19);  
        ret = new XPN[t.length];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = (XPN)t[i];
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
   * Returns a single repetition of Primary Observer Address (PEO-20).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public XAD getPrimaryObserverAddress(int rep) throws HL7Exception {
    XAD ret = null;
    try {
        Type t = this.getField(20, rep);
        ret = (XAD)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    }
    return ret;
  }

  /**
   * Returns all repetitions of Primary Observer Address (PEO-20).
   */
  public XAD[] getPrimaryObserverAddress() {
     XAD[] ret = null;
    try {
        Type[] t = this.getField(20);  
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
   * Returns a single repetition of Primary Observer Telephone (PEO-21).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public XTN getPrimaryObserverTelephone(int rep) throws HL7Exception {
    XTN ret = null;
    try {
        Type t = this.getField(21, rep);
        ret = (XTN)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    }
    return ret;
  }

  /**
   * Returns all repetitions of Primary Observer Telephone (PEO-21).
   */
  public XTN[] getPrimaryObserverTelephone() {
     XTN[] ret = null;
    try {
        Type[] t = this.getField(21);  
        ret = new XTN[t.length];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = (XTN)t[i];
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
   * Returns Primary Observer’s Qualification (PEO-22).
   */
  public ID getPrimaryObserverSQualification()  {
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
   * Returns Confirmation Provided By (PEO-23).
   */
  public ID getConfirmationProvidedBy()  {
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
   * Returns Primary Observer Aware Date/Time (PEO-24).
   */
  public TS getPrimaryObserverAwareDateTime()  {
    TS ret = null;
    try {
        Type t = this.getField(24, 0);
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
   * Returns Primary Observer’s identity May Be Divulged (PEO-25).
   */
  public ID getPrimaryObserverSIdentityMayBeDivulged()  {
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

}