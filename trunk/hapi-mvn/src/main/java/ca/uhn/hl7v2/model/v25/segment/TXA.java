package ca.uhn.hl7v2.model.v25.segment;

import ca.uhn.hl7v2.model.*;
import ca.uhn.hl7v2.model.v25.datatype.*;

import ca.uhn.log.HapiLogFactory;
import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.HL7Exception;

/**
 * <p>Represents an HL7 TXA message segment. 
 * This segment has the following fields:</p><p>
 * TXA-1: Set ID- TXA (SI)<br> 
 * TXA-2: Document Type (IS)<br> 
 * TXA-3: Document Content Presentation (ID)<br> 
 * TXA-4: Activity Date/Time (TS)<br> 
 * TXA-5: Primary Activity Provider Code/Name (XCN)<br> 
 * TXA-6: Origination Date/Time (TS)<br> 
 * TXA-7: Transcription Date/Time (TS)<br> 
 * TXA-8: Edit Date/Time (TS)<br> 
 * TXA-9: Originator Code/Name (XCN)<br> 
 * TXA-10: Assigned Document Authenticator (XCN)<br> 
 * TXA-11: Transcriptionist Code/Name (XCN)<br> 
 * TXA-12: Unique Document Number (EI)<br> 
 * TXA-13: Parent Document Number (EI)<br> 
 * TXA-14: Placer Order Number (EI)<br> 
 * TXA-15: Filler Order Number (EI)<br> 
 * TXA-16: Unique Document File Name (ST)<br> 
 * TXA-17: Document Completion Status (ID)<br> 
 * TXA-18: Document Confidentiality Status (ID)<br> 
 * TXA-19: Document Availability Status (ID)<br> 
 * TXA-20: Document Storage Status (ID)<br> 
 * TXA-21: Document Change Reason (ST)<br> 
 * TXA-22: Authentication Person, Time Stamp (PPN)<br> 
 * TXA-23: Distributed Copies (Code and Name of Recipients) (XCN)<br> 
 * </p><p>The get...() methods return data from individual fields.  These methods 
 * do not throw exceptions and may therefore have to handle exceptions internally.  
 * If an exception is handled internally, it is logged and null is returned.  
 * This is not expected to happen - if it does happen this indicates not so much 
 * an exceptional circumstance as a bug in the code for this class.</p>    
 */
public class TXA extends AbstractSegment  {

  /**
   * Creates a TXA (Transcription Document Header) segment object that belongs to the given 
   * message.  
   */
  public TXA(Group parent, ModelClassFactory factory) {
    super(parent, factory);
    Message message = getMessage();
    try {
       this.add(SI.class, true, 1, 4, new Object[]{message});
       this.add(IS.class, true, 1, 30, new Object[]{message, new Integer(270)});
       this.add(ID.class, false, 1, 2, new Object[]{message, new Integer(191)});
       this.add(TS.class, false, 1, 26, new Object[]{message});
       this.add(XCN.class, false, 0, 250, new Object[]{message});
       this.add(TS.class, false, 1, 26, new Object[]{message});
       this.add(TS.class, false, 1, 26, new Object[]{message});
       this.add(TS.class, false, 0, 26, new Object[]{message});
       this.add(XCN.class, false, 0, 250, new Object[]{message});
       this.add(XCN.class, false, 0, 250, new Object[]{message});
       this.add(XCN.class, false, 0, 250, new Object[]{message});
       this.add(EI.class, true, 1, 30, new Object[]{message});
       this.add(EI.class, false, 1, 30, new Object[]{message});
       this.add(EI.class, false, 0, 22, new Object[]{message});
       this.add(EI.class, false, 1, 22, new Object[]{message});
       this.add(ST.class, false, 1, 30, new Object[]{message});
       this.add(ID.class, true, 1, 2, new Object[]{message, new Integer(271)});
       this.add(ID.class, false, 1, 2, new Object[]{message, new Integer(272)});
       this.add(ID.class, false, 1, 2, new Object[]{message, new Integer(273)});
       this.add(ID.class, false, 1, 2, new Object[]{message, new Integer(275)});
       this.add(ST.class, false, 1, 30, new Object[]{message});
       this.add(PPN.class, false, 0, 250, new Object[]{message});
       this.add(XCN.class, false, 0, 250, new Object[]{message});
    } catch (HL7Exception he) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Can't instantiate " + this.getClass().getName(), he);
    }
  }

  /**
   * Returns Set ID- TXA (TXA-1).
   */
  public SI getSetIDTXA()  {
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
   * Returns Document Type (TXA-2).
   */
  public IS getDocumentType()  {
    IS ret = null;
    try {
        Type t = this.getField(2, 0);
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
   * Returns Document Content Presentation (TXA-3).
   */
  public ID getDocumentContentPresentation()  {
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
   * Returns Activity Date/Time (TXA-4).
   */
  public TS getActivityDateTime()  {
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
   * Returns a single repetition of Primary Activity Provider Code/Name (TXA-5).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public XCN getPrimaryActivityProviderCodeName(int rep) throws HL7Exception {
    XCN ret = null;
    try {
        Type t = this.getField(5, rep);
        ret = (XCN)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    }
    return ret;
  }

  /**
   * Returns all repetitions of Primary Activity Provider Code/Name (TXA-5).
   */
  public XCN[] getPrimaryActivityProviderCodeName() {
     XCN[] ret = null;
    try {
        Type[] t = this.getField(5);  
        ret = new XCN[t.length];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = (XCN)t[i];
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
   * Returns Origination Date/Time (TXA-6).
   */
  public TS getOriginationDateTime()  {
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
   * Returns Transcription Date/Time (TXA-7).
   */
  public TS getTranscriptionDateTime()  {
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
   * Returns a single repetition of Edit Date/Time (TXA-8).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public TS getEditDateTime(int rep) throws HL7Exception {
    TS ret = null;
    try {
        Type t = this.getField(8, rep);
        ret = (TS)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    }
    return ret;
  }

  /**
   * Returns all repetitions of Edit Date/Time (TXA-8).
   */
  public TS[] getEditDateTime() {
     TS[] ret = null;
    try {
        Type[] t = this.getField(8);  
        ret = new TS[t.length];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = (TS)t[i];
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
   * Returns a single repetition of Originator Code/Name (TXA-9).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public XCN getOriginatorCodeName(int rep) throws HL7Exception {
    XCN ret = null;
    try {
        Type t = this.getField(9, rep);
        ret = (XCN)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    }
    return ret;
  }

  /**
   * Returns all repetitions of Originator Code/Name (TXA-9).
   */
  public XCN[] getOriginatorCodeName() {
     XCN[] ret = null;
    try {
        Type[] t = this.getField(9);  
        ret = new XCN[t.length];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = (XCN)t[i];
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
   * Returns a single repetition of Assigned Document Authenticator (TXA-10).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public XCN getAssignedDocumentAuthenticator(int rep) throws HL7Exception {
    XCN ret = null;
    try {
        Type t = this.getField(10, rep);
        ret = (XCN)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    }
    return ret;
  }

  /**
   * Returns all repetitions of Assigned Document Authenticator (TXA-10).
   */
  public XCN[] getAssignedDocumentAuthenticator() {
     XCN[] ret = null;
    try {
        Type[] t = this.getField(10);  
        ret = new XCN[t.length];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = (XCN)t[i];
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
   * Returns a single repetition of Transcriptionist Code/Name (TXA-11).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public XCN getTranscriptionistCodeName(int rep) throws HL7Exception {
    XCN ret = null;
    try {
        Type t = this.getField(11, rep);
        ret = (XCN)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    }
    return ret;
  }

  /**
   * Returns all repetitions of Transcriptionist Code/Name (TXA-11).
   */
  public XCN[] getTranscriptionistCodeName() {
     XCN[] ret = null;
    try {
        Type[] t = this.getField(11);  
        ret = new XCN[t.length];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = (XCN)t[i];
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
   * Returns Unique Document Number (TXA-12).
   */
  public EI getUniqueDocumentNumber()  {
    EI ret = null;
    try {
        Type t = this.getField(12, 0);
        ret = (EI)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    } catch (HL7Exception he) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", he);
        throw new RuntimeException(he);
    }
    return ret;
  }

  /**
   * Returns Parent Document Number (TXA-13).
   */
  public EI getParentDocumentNumber()  {
    EI ret = null;
    try {
        Type t = this.getField(13, 0);
        ret = (EI)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    } catch (HL7Exception he) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", he);
        throw new RuntimeException(he);
    }
    return ret;
  }

  /**
   * Returns a single repetition of Placer Order Number (TXA-14).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public EI getPlacerOrderNumber(int rep) throws HL7Exception {
    EI ret = null;
    try {
        Type t = this.getField(14, rep);
        ret = (EI)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    }
    return ret;
  }

  /**
   * Returns all repetitions of Placer Order Number (TXA-14).
   */
  public EI[] getPlacerOrderNumber() {
     EI[] ret = null;
    try {
        Type[] t = this.getField(14);  
        ret = new EI[t.length];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = (EI)t[i];
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
   * Returns Filler Order Number (TXA-15).
   */
  public EI getFillerOrderNumber()  {
    EI ret = null;
    try {
        Type t = this.getField(15, 0);
        ret = (EI)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    } catch (HL7Exception he) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", he);
        throw new RuntimeException(he);
    }
    return ret;
  }

  /**
   * Returns Unique Document File Name (TXA-16).
   */
  public ST getUniqueDocumentFileName()  {
    ST ret = null;
    try {
        Type t = this.getField(16, 0);
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
   * Returns Document Completion Status (TXA-17).
   */
  public ID getDocumentCompletionStatus()  {
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
   * Returns Document Confidentiality Status (TXA-18).
   */
  public ID getDocumentConfidentialityStatus()  {
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
   * Returns Document Availability Status (TXA-19).
   */
  public ID getDocumentAvailabilityStatus()  {
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
   * Returns Document Storage Status (TXA-20).
   */
  public ID getDocumentStorageStatus()  {
    ID ret = null;
    try {
        Type t = this.getField(20, 0);
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
   * Returns Document Change Reason (TXA-21).
   */
  public ST getDocumentChangeReason()  {
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
   * Returns a single repetition of Authentication Person, Time Stamp (TXA-22).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public PPN getAuthenticationPersonTimeStamp(int rep) throws HL7Exception {
    PPN ret = null;
    try {
        Type t = this.getField(22, rep);
        ret = (PPN)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    }
    return ret;
  }

  /**
   * Returns all repetitions of Authentication Person, Time Stamp (TXA-22).
   */
  public PPN[] getAuthenticationPersonTimeStamp() {
     PPN[] ret = null;
    try {
        Type[] t = this.getField(22);  
        ret = new PPN[t.length];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = (PPN)t[i];
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
   * Returns a single repetition of Distributed Copies (Code and Name of Recipients) (TXA-23).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public XCN getDistributedCopiesCodeandNameofRecipients(int rep) throws HL7Exception {
    XCN ret = null;
    try {
        Type t = this.getField(23, rep);
        ret = (XCN)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    }
    return ret;
  }

  /**
   * Returns all repetitions of Distributed Copies (Code and Name of Recipients) (TXA-23).
   */
  public XCN[] getDistributedCopiesCodeandNameofRecipients() {
     XCN[] ret = null;
    try {
        Type[] t = this.getField(23);  
        ret = new XCN[t.length];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = (XCN)t[i];
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