package ca.uhn.hl7v2.model.v23.segment;

import ca.uhn.hl7v2.model.*;
import ca.uhn.hl7v2.model.v23.datatype.*;

import ca.uhn.log.HapiLogFactory;
import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.HL7Exception;

/**
 * <p>Represents an HL7 PES message segment. 
 * This segment has the following fields:</p><p>
 * PES-1: Sender Organization Name (XON)<br> 
 * PES-2: Sender Individual Name (XCN)<br> 
 * PES-3: Sender Address (XAD)<br> 
 * PES-4: Sender Telephone (XTN)<br> 
 * PES-5: Sender Event Identifier (EI)<br> 
 * PES-6: Sender Sequence Number (NM)<br> 
 * PES-7: Sender Event Description (FT)<br> 
 * PES-8: Sender Comment (FT)<br> 
 * PES-9: Sender Aware Date/Time (TS)<br> 
 * PES-10: Event Report Date (TS)<br> 
 * PES-11: Event Report Timing/Type (ID)<br> 
 * PES-12: Event Report Source (ID)<br> 
 * PES-13: Event Reported To (ID)<br> 
 * </p><p>The get...() methods return data from individual fields.  These methods 
 * do not throw exceptions and may therefore have to handle exceptions internally.  
 * If an exception is handled internally, it is logged and null is returned.  
 * This is not expected to happen - if it does happen this indicates not so much 
 * an exceptional circumstance as a bug in the code for this class.</p>    
 */
public class PES extends AbstractSegment  {

  /**
   * Creates a PES (Product Experience Sender) segment object that belongs to the given 
   * message.  
   */
  public PES(Group parent, ModelClassFactory factory) {
    super(parent, factory);
    Message message = getMessage();
    try {
       this.add(XON.class, false, 1, 80, new Object[]{message});
       this.add(XCN.class, false, 0, 60, new Object[]{message});
       this.add(XAD.class, false, 0, 200, new Object[]{message});
       this.add(XTN.class, false, 0, 44, new Object[]{message});
       this.add(EI.class, false, 1, 30, new Object[]{message});
       this.add(NM.class, false, 1, 2, new Object[]{message});
       this.add(FT.class, false, 0, 600, new Object[]{message});
       this.add(FT.class, false, 1, 600, new Object[]{message});
       this.add(TS.class, false, 1, 26, new Object[]{message});
       this.add(TS.class, true, 1, 26, new Object[]{message});
       this.add(ID.class, false, 2, 3, new Object[]{message, new Integer(234)});
       this.add(ID.class, false, 1, 1, new Object[]{message, new Integer(235)});
       this.add(ID.class, false, 0, 1, new Object[]{message, new Integer(236)});
    } catch (HL7Exception he) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Can't instantiate " + this.getClass().getName(), he);
    }
  }

  /**
   * Returns Sender Organization Name (PES-1).
   */
  public XON getSenderOrganizationName()  {
    XON ret = null;
    try {
        Type t = this.getField(1, 0);
        ret = (XON)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    } catch (HL7Exception he) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", he);
        throw new RuntimeException(he);
    }
    return ret;
  }

  /**
   * Returns a single repetition of Sender Individual Name (PES-2).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public XCN getSenderIndividualName(int rep) throws HL7Exception {
    XCN ret = null;
    try {
        Type t = this.getField(2, rep);
        ret = (XCN)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    }
    return ret;
  }

  /**
   * Returns all repetitions of Sender Individual Name (PES-2).
   */
  public XCN[] getSenderIndividualName() {
     XCN[] ret = null;
    try {
        Type[] t = this.getField(2);  
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
   * Returns a single repetition of Sender Address (PES-3).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public XAD getSenderAddress(int rep) throws HL7Exception {
    XAD ret = null;
    try {
        Type t = this.getField(3, rep);
        ret = (XAD)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    }
    return ret;
  }

  /**
   * Returns all repetitions of Sender Address (PES-3).
   */
  public XAD[] getSenderAddress() {
     XAD[] ret = null;
    try {
        Type[] t = this.getField(3);  
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
   * Returns a single repetition of Sender Telephone (PES-4).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public XTN getSenderTelephone(int rep) throws HL7Exception {
    XTN ret = null;
    try {
        Type t = this.getField(4, rep);
        ret = (XTN)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    }
    return ret;
  }

  /**
   * Returns all repetitions of Sender Telephone (PES-4).
   */
  public XTN[] getSenderTelephone() {
     XTN[] ret = null;
    try {
        Type[] t = this.getField(4);  
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
   * Returns Sender Event Identifier (PES-5).
   */
  public EI getSenderEventIdentifier()  {
    EI ret = null;
    try {
        Type t = this.getField(5, 0);
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
   * Returns Sender Sequence Number (PES-6).
   */
  public NM getSenderSequenceNumber()  {
    NM ret = null;
    try {
        Type t = this.getField(6, 0);
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
   * Returns a single repetition of Sender Event Description (PES-7).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public FT getSenderEventDescription(int rep) throws HL7Exception {
    FT ret = null;
    try {
        Type t = this.getField(7, rep);
        ret = (FT)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    }
    return ret;
  }

  /**
   * Returns all repetitions of Sender Event Description (PES-7).
   */
  public FT[] getSenderEventDescription() {
     FT[] ret = null;
    try {
        Type[] t = this.getField(7);  
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
   * Returns Sender Comment (PES-8).
   */
  public FT getSenderComment()  {
    FT ret = null;
    try {
        Type t = this.getField(8, 0);
        ret = (FT)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    } catch (HL7Exception he) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", he);
        throw new RuntimeException(he);
    }
    return ret;
  }

  /**
   * Returns Sender Aware Date/Time (PES-9).
   */
  public TS getSenderAwareDateTime()  {
    TS ret = null;
    try {
        Type t = this.getField(9, 0);
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
   * Returns Event Report Date (PES-10).
   */
  public TS getEventReportDate()  {
    TS ret = null;
    try {
        Type t = this.getField(10, 0);
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
   * Returns a single repetition of Event Report Timing/Type (PES-11).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public ID getEventReportTimingType(int rep) throws HL7Exception {
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
   * Returns all repetitions of Event Report Timing/Type (PES-11).
   */
  public ID[] getEventReportTimingType() {
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
   * Returns Event Report Source (PES-12).
   */
  public ID getEventReportSource()  {
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
   * Returns a single repetition of Event Reported To (PES-13).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public ID getEventReportedTo(int rep) throws HL7Exception {
    ID ret = null;
    try {
        Type t = this.getField(13, rep);
        ret = (ID)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    }
    return ret;
  }

  /**
   * Returns all repetitions of Event Reported To (PES-13).
   */
  public ID[] getEventReportedTo() {
     ID[] ret = null;
    try {
        Type[] t = this.getField(13);  
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

}