package ca.uhn.hl7v2.model.v25.segment;

import ca.uhn.hl7v2.model.*;
import ca.uhn.hl7v2.model.v25.datatype.*;

import ca.uhn.log.HapiLogFactory;
import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.HL7Exception;

/**
 * <p>Represents an HL7 MSH message segment. 
 * This segment has the following fields:</p><p>
 * MSH-1: Field Separator (ST)<br> 
 * MSH-2: Encoding Characters (ST)<br> 
 * MSH-3: Sending Application (HD)<br> 
 * MSH-4: Sending Facility (HD)<br> 
 * MSH-5: Receiving Application (HD)<br> 
 * MSH-6: Receiving Facility (HD)<br> 
 * MSH-7: Date/Time Of Message (TS)<br> 
 * MSH-8: Security (ST)<br> 
 * MSH-9: Message Type (MSG)<br> 
 * MSH-10: Message Control ID (ST)<br> 
 * MSH-11: Processing ID (PT)<br> 
 * MSH-12: Version ID (VID)<br> 
 * MSH-13: Sequence Number (NM)<br> 
 * MSH-14: Continuation Pointer (ST)<br> 
 * MSH-15: Accept Acknowledgment Type (ID)<br> 
 * MSH-16: Application Acknowledgment Type (ID)<br> 
 * MSH-17: Country Code (ID)<br> 
 * MSH-18: Character Set (ID)<br> 
 * MSH-19: Principal Language Of Message (CE)<br> 
 * MSH-20: Alternate Character Set Handling Scheme (ID)<br> 
 * MSH-21: Message Profile Identifier (EI)<br> 
 * </p><p>The get...() methods return data from individual fields.  These methods 
 * do not throw exceptions and may therefore have to handle exceptions internally.  
 * If an exception is handled internally, it is logged and null is returned.  
 * This is not expected to happen - if it does happen this indicates not so much 
 * an exceptional circumstance as a bug in the code for this class.</p>    
 */
public class MSH extends AbstractSegment  {

  /**
   * Creates a MSH (Message Header) segment object that belongs to the given 
   * message.  
   */
  public MSH(Group parent, ModelClassFactory factory) {
    super(parent, factory);
    Message message = getMessage();
    try {
       this.add(ST.class, true, 1, 1, new Object[]{message});
       this.add(ST.class, true, 1, 4, new Object[]{message});
       this.add(HD.class, false, 1, 227, new Object[]{message});
       this.add(HD.class, false, 1, 227, new Object[]{message});
       this.add(HD.class, false, 1, 227, new Object[]{message});
       this.add(HD.class, false, 1, 227, new Object[]{message});
       this.add(TS.class, true, 1, 26, new Object[]{message});
       this.add(ST.class, false, 1, 40, new Object[]{message});
       this.add(MSG.class, true, 1, 15, new Object[]{message});
       this.add(ST.class, true, 1, 20, new Object[]{message});
       this.add(PT.class, true, 1, 3, new Object[]{message});
       this.add(VID.class, true, 1, 60, new Object[]{message});
       this.add(NM.class, false, 1, 15, new Object[]{message});
       this.add(ST.class, false, 1, 180, new Object[]{message});
       this.add(ID.class, false, 1, 2, new Object[]{message, new Integer(155)});
       this.add(ID.class, false, 1, 2, new Object[]{message, new Integer(155)});
       this.add(ID.class, false, 1, 3, new Object[]{message, new Integer(399)});
       this.add(ID.class, false, 0, 16, new Object[]{message, new Integer(211)});
       this.add(CE.class, false, 1, 250, new Object[]{message});
       this.add(ID.class, false, 1, 20, new Object[]{message, new Integer(356)});
       this.add(EI.class, false, 0, 427, new Object[]{message});
    } catch (HL7Exception he) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Can't instantiate " + this.getClass().getName(), he);
    }
  }

  /**
   * Returns Field Separator (MSH-1).
   */
  public ST getFieldSeparator()  {
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
   * Returns Encoding Characters (MSH-2).
   */
  public ST getEncodingCharacters()  {
    ST ret = null;
    try {
        Type t = this.getField(2, 0);
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
   * Returns Sending Application (MSH-3).
   */
  public HD getSendingApplication()  {
    HD ret = null;
    try {
        Type t = this.getField(3, 0);
        ret = (HD)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    } catch (HL7Exception he) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", he);
        throw new RuntimeException(he);
    }
    return ret;
  }

  /**
   * Returns Sending Facility (MSH-4).
   */
  public HD getSendingFacility()  {
    HD ret = null;
    try {
        Type t = this.getField(4, 0);
        ret = (HD)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    } catch (HL7Exception he) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", he);
        throw new RuntimeException(he);
    }
    return ret;
  }

  /**
   * Returns Receiving Application (MSH-5).
   */
  public HD getReceivingApplication()  {
    HD ret = null;
    try {
        Type t = this.getField(5, 0);
        ret = (HD)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    } catch (HL7Exception he) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", he);
        throw new RuntimeException(he);
    }
    return ret;
  }

  /**
   * Returns Receiving Facility (MSH-6).
   */
  public HD getReceivingFacility()  {
    HD ret = null;
    try {
        Type t = this.getField(6, 0);
        ret = (HD)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    } catch (HL7Exception he) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", he);
        throw new RuntimeException(he);
    }
    return ret;
  }

  /**
   * Returns Date/Time Of Message (MSH-7).
   */
  public TS getDateTimeOfMessage()  {
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
   * Returns Security (MSH-8).
   */
  public ST getSecurity()  {
    ST ret = null;
    try {
        Type t = this.getField(8, 0);
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
   * Returns Message Type (MSH-9).
   */
  public MSG getMessageType()  {
    MSG ret = null;
    try {
        Type t = this.getField(9, 0);
        ret = (MSG)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    } catch (HL7Exception he) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", he);
        throw new RuntimeException(he);
    }
    return ret;
  }

  /**
   * Returns Message Control ID (MSH-10).
   */
  public ST getMessageControlID()  {
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
   * Returns Processing ID (MSH-11).
   */
  public PT getProcessingID()  {
    PT ret = null;
    try {
        Type t = this.getField(11, 0);
        ret = (PT)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    } catch (HL7Exception he) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", he);
        throw new RuntimeException(he);
    }
    return ret;
  }

  /**
   * Returns Version ID (MSH-12).
   */
  public VID getVersionID()  {
    VID ret = null;
    try {
        Type t = this.getField(12, 0);
        ret = (VID)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    } catch (HL7Exception he) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", he);
        throw new RuntimeException(he);
    }
    return ret;
  }

  /**
   * Returns Sequence Number (MSH-13).
   */
  public NM getSequenceNumber()  {
    NM ret = null;
    try {
        Type t = this.getField(13, 0);
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
   * Returns Continuation Pointer (MSH-14).
   */
  public ST getContinuationPointer()  {
    ST ret = null;
    try {
        Type t = this.getField(14, 0);
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
   * Returns Accept Acknowledgment Type (MSH-15).
   */
  public ID getAcceptAcknowledgmentType()  {
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
   * Returns Application Acknowledgment Type (MSH-16).
   */
  public ID getApplicationAcknowledgmentType()  {
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
   * Returns Country Code (MSH-17).
   */
  public ID getCountryCode()  {
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
   * Returns a single repetition of Character Set (MSH-18).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public ID getCharacterSet(int rep) throws HL7Exception {
    ID ret = null;
    try {
        Type t = this.getField(18, rep);
        ret = (ID)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    }
    return ret;
  }

  /**
   * Returns all repetitions of Character Set (MSH-18).
   */
  public ID[] getCharacterSet() {
     ID[] ret = null;
    try {
        Type[] t = this.getField(18);  
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
   * Returns Principal Language Of Message (MSH-19).
   */
  public CE getPrincipalLanguageOfMessage()  {
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
   * Returns Alternate Character Set Handling Scheme (MSH-20).
   */
  public ID getAlternateCharacterSetHandlingScheme()  {
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
   * Returns a single repetition of Message Profile Identifier (MSH-21).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public EI getMessageProfileIdentifier(int rep) throws HL7Exception {
    EI ret = null;
    try {
        Type t = this.getField(21, rep);
        ret = (EI)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    }
    return ret;
  }

  /**
   * Returns all repetitions of Message Profile Identifier (MSH-21).
   */
  public EI[] getMessageProfileIdentifier() {
     EI[] ret = null;
    try {
        Type[] t = this.getField(21);  
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

}