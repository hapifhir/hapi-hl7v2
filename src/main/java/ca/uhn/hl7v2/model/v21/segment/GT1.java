package ca.uhn.hl7v2.model.v21.segment;

import ca.uhn.hl7v2.model.*;
import ca.uhn.hl7v2.model.v21.datatype.*;

import ca.uhn.log.HapiLogFactory;
import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.HL7Exception;

/**
 * <p>Represents an HL7 GT1 message segment. 
 * This segment has the following fields:</p><p>
 * GT1-1: SET ID - GUARANTOR (SI)<br> 
 * GT1-2: GUARANTOR NUMBER (ID)<br> 
 * GT1-3: GUARANTOR NAME (PN)<br> 
 * GT1-4: GUARANTOR SPOUSE NAME (PN)<br> 
 * GT1-5: GUARANTOR ADDRESS (AD)<br> 
 * GT1-6: GUARANTOR PH. NUM.- HOME (TN)<br> 
 * GT1-7: GUARANTOR PH. NUM-BUSINESS (TN)<br> 
 * GT1-8: GUARANTOR DATE OF BIRTH (DT)<br> 
 * GT1-9: GUARANTOR SEX (ID)<br> 
 * GT1-10: GUARANTOR TYPE (ID)<br> 
 * GT1-11: GUARANTOR RELATIONSHIP (ID)<br> 
 * GT1-12: GUARANTOR SSN (ST)<br> 
 * GT1-13: GUARANTOR DATE - BEGIN (DT)<br> 
 * GT1-14: GUARANTOR DATE - END (DT)<br> 
 * GT1-15: GUARANTOR PRIORITY (NM)<br> 
 * GT1-16: GUARANTOR EMPLOYER NAME (ST)<br> 
 * GT1-17: GUARANTOR EMPLOYER ADDRESS (AD)<br> 
 * GT1-18: GUARANTOR EMPLOY PHONE # (TN)<br> 
 * GT1-19: GUARANTOR EMPLOYEE ID NUM (ST)<br> 
 * GT1-20: GUARANTOR EMPLOYMENT STATUS (ID)<br> 
 * </p><p>The get...() methods return data from individual fields.  These methods 
 * do not throw exceptions and may therefore have to handle exceptions internally.  
 * If an exception is handled internally, it is logged and null is returned.  
 * This is not expected to happen - if it does happen this indicates not so much 
 * an exceptional circumstance as a bug in the code for this class.</p>    
 */
public class GT1 extends AbstractSegment  {

  /**
   * Creates a GT1 (GUARANTOR) segment object that belongs to the given 
   * message.  
   */
  public GT1(Group parent, ModelClassFactory factory) {
    super(parent, factory);
    Message message = getMessage();
    try {
       this.add(SI.class, true, 1, 4, new Object[]{message});
       this.add(ID.class, false, 1, 20, new Object[]{message, new Integer(0)});
       this.add(PN.class, true, 1, 48, new Object[]{message});
       this.add(PN.class, false, 1, 48, new Object[]{message});
       this.add(AD.class, false, 1, 106, new Object[]{message});
       this.add(TN.class, false, 1, 40, new Object[]{message});
       this.add(TN.class, false, 1, 40, new Object[]{message});
       this.add(DT.class, false, 1, 8, new Object[]{message});
       this.add(ID.class, false, 1, 1, new Object[]{message, new Integer(1)});
       this.add(ID.class, false, 1, 2, new Object[]{message, new Integer(68)});
       this.add(ID.class, false, 1, 2, new Object[]{message, new Integer(63)});
       this.add(ST.class, false, 1, 11, new Object[]{message});
       this.add(DT.class, false, 1, 8, new Object[]{message});
       this.add(DT.class, false, 1, 8, new Object[]{message});
       this.add(NM.class, false, 1, 2, new Object[]{message});
       this.add(ST.class, false, 1, 45, new Object[]{message});
       this.add(AD.class, false, 1, 106, new Object[]{message});
       this.add(TN.class, false, 1, 40, new Object[]{message});
       this.add(ST.class, false, 1, 20, new Object[]{message});
       this.add(ID.class, false, 1, 2, new Object[]{message, new Integer(66)});
    } catch (HL7Exception he) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Can't instantiate " + this.getClass().getName(), he);
    }
  }

  /**
   * Returns SET ID - GUARANTOR (GT1-1).
   */
  public SI getSETIDGUARANTOR()  {
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
   * Returns GUARANTOR NUMBER (GT1-2).
   */
  public ID getGUARANTORNUMBER()  {
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
   * Returns GUARANTOR NAME (GT1-3).
   */
  public PN getGUARANTORNAME()  {
    PN ret = null;
    try {
        Type t = this.getField(3, 0);
        ret = (PN)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    } catch (HL7Exception he) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", he);
        throw new RuntimeException(he);
    }
    return ret;
  }

  /**
   * Returns GUARANTOR SPOUSE NAME (GT1-4).
   */
  public PN getGUARANTORSPOUSENAME()  {
    PN ret = null;
    try {
        Type t = this.getField(4, 0);
        ret = (PN)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    } catch (HL7Exception he) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", he);
        throw new RuntimeException(he);
    }
    return ret;
  }

  /**
   * Returns GUARANTOR ADDRESS (GT1-5).
   */
  public AD getGUARANTORADDRESS()  {
    AD ret = null;
    try {
        Type t = this.getField(5, 0);
        ret = (AD)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    } catch (HL7Exception he) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", he);
        throw new RuntimeException(he);
    }
    return ret;
  }

  /**
   * Returns GUARANTOR PH. NUM.- HOME (GT1-6).
   */
  public TN getGUARANTORPHNUMHOME()  {
    TN ret = null;
    try {
        Type t = this.getField(6, 0);
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
   * Returns GUARANTOR PH. NUM-BUSINESS (GT1-7).
   */
  public TN getGUARANTORPHNUMBUSINESS()  {
    TN ret = null;
    try {
        Type t = this.getField(7, 0);
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
   * Returns GUARANTOR DATE OF BIRTH (GT1-8).
   */
  public DT getGUARANTORDATEOFBIRTH()  {
    DT ret = null;
    try {
        Type t = this.getField(8, 0);
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
   * Returns GUARANTOR SEX (GT1-9).
   */
  public ID getGUARANTORSEX()  {
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
   * Returns GUARANTOR TYPE (GT1-10).
   */
  public ID getGUARANTORTYPE()  {
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
   * Returns GUARANTOR RELATIONSHIP (GT1-11).
   */
  public ID getGUARANTORRELATIONSHIP()  {
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
   * Returns GUARANTOR SSN (GT1-12).
   */
  public ST getGUARANTORSSN()  {
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
   * Returns GUARANTOR DATE - BEGIN (GT1-13).
   */
  public DT getGUARANTORDATEBEGIN()  {
    DT ret = null;
    try {
        Type t = this.getField(13, 0);
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
   * Returns GUARANTOR DATE - END (GT1-14).
   */
  public DT getGUARANTORDATEEND()  {
    DT ret = null;
    try {
        Type t = this.getField(14, 0);
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
   * Returns GUARANTOR PRIORITY (GT1-15).
   */
  public NM getGUARANTORPRIORITY()  {
    NM ret = null;
    try {
        Type t = this.getField(15, 0);
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
   * Returns GUARANTOR EMPLOYER NAME (GT1-16).
   */
  public ST getGUARANTOREMPLOYERNAME()  {
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
   * Returns GUARANTOR EMPLOYER ADDRESS (GT1-17).
   */
  public AD getGUARANTOREMPLOYERADDRESS()  {
    AD ret = null;
    try {
        Type t = this.getField(17, 0);
        ret = (AD)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    } catch (HL7Exception he) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", he);
        throw new RuntimeException(he);
    }
    return ret;
  }

  /**
   * Returns GUARANTOR EMPLOY PHONE # (GT1-18).
   */
  public TN getGUARANTOREMPLOYPHONE()  {
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
   * Returns GUARANTOR EMPLOYEE ID NUM (GT1-19).
   */
  public ST getGUARANTOREMPLOYEEIDNUM()  {
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
   * Returns GUARANTOR EMPLOYMENT STATUS (GT1-20).
   */
  public ID getGUARANTOREMPLOYMENTSTATUS()  {
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

}