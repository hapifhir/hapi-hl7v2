package ca.uhn.hl7v2.model.v23.segment;

import ca.uhn.hl7v2.model.*;
import ca.uhn.hl7v2.model.v23.datatype.*;

import ca.uhn.log.HapiLogFactory;
import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.HL7Exception;

/**
 * <p>Represents an HL7 OBR message segment. 
 * This segment has the following fields:</p><p>
 * OBR-1: Set ID - Observation Request (SI)<br> 
 * OBR-2: Placer Order Number (EI)<br> 
 * OBR-3: Filler Order Number (EI)<br> 
 * OBR-4: Universal Service Identifier (CE)<br> 
 * OBR-5: Priority (ID)<br> 
 * OBR-6: Requested Date/Time (TS)<br> 
 * OBR-7: Observation Date/Time (TS)<br> 
 * OBR-8: Observation End Date/Time (TS)<br> 
 * OBR-9: Collection Volume (CQ)<br> 
 * OBR-10: Collector Identifier (XCN)<br> 
 * OBR-11: Specimen Action Code (ID)<br> 
 * OBR-12: Danger Code (CE)<br> 
 * OBR-13: Relevant Clinical Information (ST)<br> 
 * OBR-14: Specimen Received Date/Time (TS)<br> 
 * OBR-15: Specimen Source (CM_SPS)<br> 
 * OBR-16: Ordering Provider (XCN)<br> 
 * OBR-17: Order Callback Phone Number (XTN)<br> 
 * OBR-18: Placer Field 1 (ST)<br> 
 * OBR-19: Placer Field 2 (ST)<br> 
 * OBR-20: Filler Field 1 (ST)<br> 
 * OBR-21: Filler Field 2 (ST)<br> 
 * OBR-22: Results Rpt/Status Chng - Date/Time (TS)<br> 
 * OBR-23: Charge To Practice (CM_MOC)<br> 
 * OBR-24: Diagnostic Service Section ID (ID)<br> 
 * OBR-25: Result Status (ID)<br> 
 * OBR-26: Parent Result (CM_PRL)<br> 
 * OBR-27: Quantity/Timing (TQ)<br> 
 * OBR-28: Result Copies To (XCN)<br> 
 * OBR-29: Parent Number (CM_EIP)<br> 
 * OBR-30: Transportation Mode (ID)<br> 
 * OBR-31: Reason For Study (CE)<br> 
 * OBR-32: Principal Result Interpreter (CM_NDL)<br> 
 * OBR-33: Assistant Result Interpreter (CM_NDL)<br> 
 * OBR-34: Technician (CM_NDL)<br> 
 * OBR-35: Transcriptionist (CM_NDL)<br> 
 * OBR-36: Scheduled Date/Time (TS)<br> 
 * OBR-37: Number Of Sample Containers (NM)<br> 
 * OBR-38: Transport Logistics Of Collected Sample (CE)<br> 
 * OBR-39: Collector’s Comment (CE)<br> 
 * OBR-40: Transport Arrangement Responsibility (CE)<br> 
 * OBR-41: Transport Arranged (ID)<br> 
 * OBR-42: Escort Required (ID)<br> 
 * OBR-43: Planned Patient Transport Comment (CE)<br> 
 * </p><p>The get...() methods return data from individual fields.  These methods 
 * do not throw exceptions and may therefore have to handle exceptions internally.  
 * If an exception is handled internally, it is logged and null is returned.  
 * This is not expected to happen - if it does happen this indicates not so much 
 * an exceptional circumstance as a bug in the code for this class.</p>    
 */
public class OBR extends AbstractSegment  {

  /**
   * Creates a OBR (Observation request segment) segment object that belongs to the given 
   * message.  
   */
  public OBR(Group parent, ModelClassFactory factory) {
    super(parent, factory);
    Message message = getMessage();
    try {
       this.add(SI.class, false, 1, 4, new Object[]{message});
       this.add(EI.class, false, 0, 22, new Object[]{message});
       this.add(EI.class, false, 1, 22, new Object[]{message});
       this.add(CE.class, true, 1, 200, new Object[]{message});
       this.add(ID.class, false, 1, 2, new Object[]{message, new Integer(0)});
       this.add(TS.class, false, 1, 26, new Object[]{message});
       this.add(TS.class, false, 1, 26, new Object[]{message});
       this.add(TS.class, false, 1, 26, new Object[]{message});
       this.add(CQ.class, false, 1, 20, new Object[]{message});
       this.add(XCN.class, false, 0, 60, new Object[]{message});
       this.add(ID.class, false, 1, 1, new Object[]{message, new Integer(65)});
       this.add(CE.class, false, 1, 60, new Object[]{message});
       this.add(ST.class, false, 1, 300, new Object[]{message});
       this.add(TS.class, false, 1, 26, new Object[]{message});
       this.add(CM_SPS.class, false, 1, 300, new Object[]{message});
       this.add(XCN.class, false, 0, 120, new Object[]{message});
       this.add(XTN.class, false, 2, 40, new Object[]{message});
       this.add(ST.class, false, 1, 60, new Object[]{message});
       this.add(ST.class, false, 1, 60, new Object[]{message});
       this.add(ST.class, false, 1, 60, new Object[]{message});
       this.add(ST.class, false, 1, 60, new Object[]{message});
       this.add(TS.class, false, 1, 26, new Object[]{message});
       this.add(CM_MOC.class, false, 1, 40, new Object[]{message});
       this.add(ID.class, false, 1, 10, new Object[]{message, new Integer(74)});
       this.add(ID.class, false, 1, 1, new Object[]{message, new Integer(123)});
       this.add(CM_PRL.class, false, 1, 200, new Object[]{message});
       this.add(TQ.class, true, 1, 200, new Object[]{message});
       this.add(XCN.class, false, 5, 150, new Object[]{message});
       this.add(CM_EIP.class, false, 1, 150, new Object[]{message});
       this.add(ID.class, false, 1, 20, new Object[]{message, new Integer(124)});
       this.add(CE.class, false, 0, 300, new Object[]{message});
       this.add(CM_NDL.class, false, 1, 200, new Object[]{message});
       this.add(CM_NDL.class, false, 0, 200, new Object[]{message});
       this.add(CM_NDL.class, false, 0, 200, new Object[]{message});
       this.add(CM_NDL.class, false, 0, 200, new Object[]{message});
       this.add(TS.class, false, 1, 26, new Object[]{message});
       this.add(NM.class, false, 1, 4, new Object[]{message});
       this.add(CE.class, false, 0, 60, new Object[]{message});
       this.add(CE.class, false, 0, 200, new Object[]{message});
       this.add(CE.class, false, 1, 60, new Object[]{message});
       this.add(ID.class, false, 1, 30, new Object[]{message, new Integer(224)});
       this.add(ID.class, false, 1, 1, new Object[]{message, new Integer(225)});
       this.add(CE.class, false, 0, 200, new Object[]{message});
    } catch (HL7Exception he) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Can't instantiate " + this.getClass().getName(), he);
    }
  }

  /**
   * Returns Set ID - Observation Request (OBR-1).
   */
  public SI getSetIDObservationRequest()  {
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
   * Returns a single repetition of Placer Order Number (OBR-2).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public EI getPlacerOrderNumber(int rep) throws HL7Exception {
    EI ret = null;
    try {
        Type t = this.getField(2, rep);
        ret = (EI)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    }
    return ret;
  }

  /**
   * Returns all repetitions of Placer Order Number (OBR-2).
   */
  public EI[] getPlacerOrderNumber() {
     EI[] ret = null;
    try {
        Type[] t = this.getField(2);  
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
   * Returns Filler Order Number (OBR-3).
   */
  public EI getFillerOrderNumber()  {
    EI ret = null;
    try {
        Type t = this.getField(3, 0);
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
   * Returns Universal Service Identifier (OBR-4).
   */
  public CE getUniversalServiceIdentifier()  {
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
   * Returns Priority (OBR-5).
   */
  public ID getPriority()  {
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
   * Returns Requested Date/Time (OBR-6).
   */
  public TS getRequestedDateTime()  {
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
   * Returns Observation Date/Time (OBR-7).
   */
  public TS getObservationDateTime()  {
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
   * Returns Observation End Date/Time (OBR-8).
   */
  public TS getObservationEndDateTime()  {
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
   * Returns Collection Volume (OBR-9).
   */
  public CQ getCollectionVolume()  {
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
   * Returns a single repetition of Collector Identifier (OBR-10).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public XCN getCollectorIdentifier(int rep) throws HL7Exception {
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
   * Returns all repetitions of Collector Identifier (OBR-10).
   */
  public XCN[] getCollectorIdentifier() {
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
   * Returns Specimen Action Code (OBR-11).
   */
  public ID getSpecimenActionCode()  {
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
   * Returns Danger Code (OBR-12).
   */
  public CE getDangerCode()  {
    CE ret = null;
    try {
        Type t = this.getField(12, 0);
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
   * Returns Relevant Clinical Information (OBR-13).
   */
  public ST getRelevantClinicalInformation()  {
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
   * Returns Specimen Received Date/Time (OBR-14).
   */
  public TS getSpecimenReceivedDateTime()  {
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
   * Returns Specimen Source (OBR-15).
   */
  public CM_SPS getSpecimenSource()  {
    CM_SPS ret = null;
    try {
        Type t = this.getField(15, 0);
        ret = (CM_SPS)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    } catch (HL7Exception he) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", he);
        throw new RuntimeException(he);
    }
    return ret;
  }

  /**
   * Returns a single repetition of Ordering Provider (OBR-16).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public XCN getOrderingProvider(int rep) throws HL7Exception {
    XCN ret = null;
    try {
        Type t = this.getField(16, rep);
        ret = (XCN)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    }
    return ret;
  }

  /**
   * Returns all repetitions of Ordering Provider (OBR-16).
   */
  public XCN[] getOrderingProvider() {
     XCN[] ret = null;
    try {
        Type[] t = this.getField(16);  
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
   * Returns a single repetition of Order Callback Phone Number (OBR-17).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public XTN getOrderCallbackPhoneNumber(int rep) throws HL7Exception {
    XTN ret = null;
    try {
        Type t = this.getField(17, rep);
        ret = (XTN)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    }
    return ret;
  }

  /**
   * Returns all repetitions of Order Callback Phone Number (OBR-17).
   */
  public XTN[] getOrderCallbackPhoneNumber() {
     XTN[] ret = null;
    try {
        Type[] t = this.getField(17);  
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
   * Returns Placer Field 1 (OBR-18).
   */
  public ST getPlacerField1()  {
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
   * Returns Placer Field 2 (OBR-19).
   */
  public ST getPlacerField2()  {
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
   * Returns Filler Field 1 (OBR-20).
   */
  public ST getFillerField1()  {
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
   * Returns Filler Field 2 (OBR-21).
   */
  public ST getFillerField2()  {
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
   * Returns Results Rpt/Status Chng - Date/Time (OBR-22).
   */
  public TS getResultsRptStatusChngDateTime()  {
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
   * Returns Charge To Practice (OBR-23).
   */
  public CM_MOC getChargeToPractice()  {
    CM_MOC ret = null;
    try {
        Type t = this.getField(23, 0);
        ret = (CM_MOC)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    } catch (HL7Exception he) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", he);
        throw new RuntimeException(he);
    }
    return ret;
  }

  /**
   * Returns Diagnostic Service Section ID (OBR-24).
   */
  public ID getDiagnosticServiceSectionID()  {
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
   * Returns Result Status (OBR-25).
   */
  public ID getResultStatus()  {
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
   * Returns Parent Result (OBR-26).
   */
  public CM_PRL getParentResult()  {
    CM_PRL ret = null;
    try {
        Type t = this.getField(26, 0);
        ret = (CM_PRL)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    } catch (HL7Exception he) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", he);
        throw new RuntimeException(he);
    }
    return ret;
  }

  /**
   * Returns Quantity/Timing (OBR-27).
   */
  public TQ getQuantityTiming()  {
    TQ ret = null;
    try {
        Type t = this.getField(27, 0);
        ret = (TQ)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    } catch (HL7Exception he) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", he);
        throw new RuntimeException(he);
    }
    return ret;
  }

  /**
   * Returns a single repetition of Result Copies To (OBR-28).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public XCN getResultCopiesTo(int rep) throws HL7Exception {
    XCN ret = null;
    try {
        Type t = this.getField(28, rep);
        ret = (XCN)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    }
    return ret;
  }

  /**
   * Returns all repetitions of Result Copies To (OBR-28).
   */
  public XCN[] getResultCopiesTo() {
     XCN[] ret = null;
    try {
        Type[] t = this.getField(28);  
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
   * Returns Parent Number (OBR-29).
   */
  public CM_EIP getParentNumber()  {
    CM_EIP ret = null;
    try {
        Type t = this.getField(29, 0);
        ret = (CM_EIP)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    } catch (HL7Exception he) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", he);
        throw new RuntimeException(he);
    }
    return ret;
  }

  /**
   * Returns Transportation Mode (OBR-30).
   */
  public ID getTransportationMode()  {
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
   * Returns a single repetition of Reason For Study (OBR-31).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public CE getReasonForStudy(int rep) throws HL7Exception {
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
   * Returns all repetitions of Reason For Study (OBR-31).
   */
  public CE[] getReasonForStudy() {
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
   * Returns Principal Result Interpreter (OBR-32).
   */
  public CM_NDL getPrincipalResultInterpreter()  {
    CM_NDL ret = null;
    try {
        Type t = this.getField(32, 0);
        ret = (CM_NDL)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    } catch (HL7Exception he) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", he);
        throw new RuntimeException(he);
    }
    return ret;
  }

  /**
   * Returns a single repetition of Assistant Result Interpreter (OBR-33).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public CM_NDL getAssistantResultInterpreter(int rep) throws HL7Exception {
    CM_NDL ret = null;
    try {
        Type t = this.getField(33, rep);
        ret = (CM_NDL)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    }
    return ret;
  }

  /**
   * Returns all repetitions of Assistant Result Interpreter (OBR-33).
   */
  public CM_NDL[] getAssistantResultInterpreter() {
     CM_NDL[] ret = null;
    try {
        Type[] t = this.getField(33);  
        ret = new CM_NDL[t.length];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = (CM_NDL)t[i];
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
   * Returns a single repetition of Technician (OBR-34).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public CM_NDL getTechnician(int rep) throws HL7Exception {
    CM_NDL ret = null;
    try {
        Type t = this.getField(34, rep);
        ret = (CM_NDL)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    }
    return ret;
  }

  /**
   * Returns all repetitions of Technician (OBR-34).
   */
  public CM_NDL[] getTechnician() {
     CM_NDL[] ret = null;
    try {
        Type[] t = this.getField(34);  
        ret = new CM_NDL[t.length];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = (CM_NDL)t[i];
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
   * Returns a single repetition of Transcriptionist (OBR-35).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public CM_NDL getTranscriptionist(int rep) throws HL7Exception {
    CM_NDL ret = null;
    try {
        Type t = this.getField(35, rep);
        ret = (CM_NDL)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    }
    return ret;
  }

  /**
   * Returns all repetitions of Transcriptionist (OBR-35).
   */
  public CM_NDL[] getTranscriptionist() {
     CM_NDL[] ret = null;
    try {
        Type[] t = this.getField(35);  
        ret = new CM_NDL[t.length];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = (CM_NDL)t[i];
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
   * Returns Scheduled Date/Time (OBR-36).
   */
  public TS getScheduledDateTime()  {
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

  /**
   * Returns Number Of Sample Containers (OBR-37).
   */
  public NM getNumberOfSampleContainers()  {
    NM ret = null;
    try {
        Type t = this.getField(37, 0);
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
   * Returns a single repetition of Transport Logistics Of Collected Sample (OBR-38).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public CE getTransportLogisticsOfCollectedSample(int rep) throws HL7Exception {
    CE ret = null;
    try {
        Type t = this.getField(38, rep);
        ret = (CE)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    }
    return ret;
  }

  /**
   * Returns all repetitions of Transport Logistics Of Collected Sample (OBR-38).
   */
  public CE[] getTransportLogisticsOfCollectedSample() {
     CE[] ret = null;
    try {
        Type[] t = this.getField(38);  
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
   * Returns a single repetition of Collector’s Comment (OBR-39).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public CE getCollectorSComment(int rep) throws HL7Exception {
    CE ret = null;
    try {
        Type t = this.getField(39, rep);
        ret = (CE)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    }
    return ret;
  }

  /**
   * Returns all repetitions of Collector’s Comment (OBR-39).
   */
  public CE[] getCollectorSComment() {
     CE[] ret = null;
    try {
        Type[] t = this.getField(39);  
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
   * Returns Transport Arrangement Responsibility (OBR-40).
   */
  public CE getTransportArrangementResponsibility()  {
    CE ret = null;
    try {
        Type t = this.getField(40, 0);
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
   * Returns Transport Arranged (OBR-41).
   */
  public ID getTransportArranged()  {
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
   * Returns Escort Required (OBR-42).
   */
  public ID getEscortRequired()  {
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
   * Returns a single repetition of Planned Patient Transport Comment (OBR-43).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public CE getPlannedPatientTransportComment(int rep) throws HL7Exception {
    CE ret = null;
    try {
        Type t = this.getField(43, rep);
        ret = (CE)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    }
    return ret;
  }

  /**
   * Returns all repetitions of Planned Patient Transport Comment (OBR-43).
   */
  public CE[] getPlannedPatientTransportComment() {
     CE[] ret = null;
    try {
        Type[] t = this.getField(43);  
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

}