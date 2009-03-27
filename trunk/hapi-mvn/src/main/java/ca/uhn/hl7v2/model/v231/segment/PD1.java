package ca.uhn.hl7v2.model.v231.segment;

import ca.uhn.hl7v2.model.*;
import ca.uhn.hl7v2.model.v231.datatype.*;

import ca.uhn.log.HapiLogFactory;
import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.HL7Exception;

/**
 * <p>Represents an HL7 PD1 message segment. 
 * This segment has the following fields:</p><p>
 * PD1-1: Living Dependency (IS)<br> 
 * PD1-2: Living Arrangement (IS)<br> 
 * PD1-3: Patient Primary Facility (XON)<br> 
 * PD1-4: Patient Primary Care Provider Name & ID No. (XCN)<br> 
 * PD1-5: Student Indicator (IS)<br> 
 * PD1-6: Handicap (IS)<br> 
 * PD1-7: Living Will (IS)<br> 
 * PD1-8: Organ Donor (IS)<br> 
 * PD1-9: Separate Bill (ID)<br> 
 * PD1-10: Duplicate Patient (CX)<br> 
 * PD1-11: Publicity Code (CE)<br> 
 * PD1-12: Protection Indicator (ID)<br> 
 * </p><p>The get...() methods return data from individual fields.  These methods 
 * do not throw exceptions and may therefore have to handle exceptions internally.  
 * If an exception is handled internally, it is logged and null is returned.  
 * This is not expected to happen - if it does happen this indicates not so much 
 * an exceptional circumstance as a bug in the code for this class.</p>    
 */
public class PD1 extends AbstractSegment  {

  /**
   * Creates a PD1 (PD1 - patient additional demographic segment) segment object that belongs to the given 
   * message.  
   */
  public PD1(Group parent, ModelClassFactory factory) {
    super(parent, factory);
    Message message = getMessage();
    try {
       this.add(IS.class, false, 0, 2, new Object[]{message, new Integer(223)});
       this.add(IS.class, false, 1, 2, new Object[]{message, new Integer(220)});
       this.add(XON.class, false, 0, 90, new Object[]{message});
       this.add(XCN.class, false, 0, 90, new Object[]{message});
       this.add(IS.class, false, 1, 2, new Object[]{message, new Integer(231)});
       this.add(IS.class, false, 1, 2, new Object[]{message, new Integer(295)});
       this.add(IS.class, false, 1, 2, new Object[]{message, new Integer(315)});
       this.add(IS.class, false, 1, 2, new Object[]{message, new Integer(316)});
       this.add(ID.class, false, 1, 1, new Object[]{message, new Integer(136)});
       this.add(CX.class, false, 0, 20, new Object[]{message});
       this.add(CE.class, false, 1, 80, new Object[]{message});
       this.add(ID.class, false, 1, 1, new Object[]{message, new Integer(136)});
    } catch (HL7Exception he) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Can't instantiate " + this.getClass().getName(), he);
    }
  }

  /**
   * Returns a single repetition of Living Dependency (PD1-1).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public IS getLivingDependency(int rep) throws HL7Exception {
    IS ret = null;
    try {
        Type t = this.getField(1, rep);
        ret = (IS)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    }
    return ret;
  }

  /**
   * Returns all repetitions of Living Dependency (PD1-1).
   */
  public IS[] getLivingDependency() {
     IS[] ret = null;
    try {
        Type[] t = this.getField(1);  
        ret = new IS[t.length];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = (IS)t[i];
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
   * Returns Living Arrangement (PD1-2).
   */
  public IS getLivingArrangement()  {
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
   * Returns a single repetition of Patient Primary Facility (PD1-3).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public XON getPatientPrimaryFacility(int rep) throws HL7Exception {
    XON ret = null;
    try {
        Type t = this.getField(3, rep);
        ret = (XON)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    }
    return ret;
  }

  /**
   * Returns all repetitions of Patient Primary Facility (PD1-3).
   */
  public XON[] getPatientPrimaryFacility() {
     XON[] ret = null;
    try {
        Type[] t = this.getField(3);  
        ret = new XON[t.length];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = (XON)t[i];
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
   * Returns a single repetition of Patient Primary Care Provider Name & ID No. (PD1-4).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public XCN getPatientPrimaryCareProviderNameIDNo(int rep) throws HL7Exception {
    XCN ret = null;
    try {
        Type t = this.getField(4, rep);
        ret = (XCN)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    }
    return ret;
  }

  /**
   * Returns all repetitions of Patient Primary Care Provider Name & ID No. (PD1-4).
   */
  public XCN[] getPatientPrimaryCareProviderNameIDNo() {
     XCN[] ret = null;
    try {
        Type[] t = this.getField(4);  
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
   * Returns Student Indicator (PD1-5).
   */
  public IS getStudentIndicator()  {
    IS ret = null;
    try {
        Type t = this.getField(5, 0);
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
   * Returns Handicap (PD1-6).
   */
  public IS getHandicap()  {
    IS ret = null;
    try {
        Type t = this.getField(6, 0);
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
   * Returns Living Will (PD1-7).
   */
  public IS getLivingWill()  {
    IS ret = null;
    try {
        Type t = this.getField(7, 0);
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
   * Returns Organ Donor (PD1-8).
   */
  public IS getOrganDonor()  {
    IS ret = null;
    try {
        Type t = this.getField(8, 0);
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
   * Returns Separate Bill (PD1-9).
   */
  public ID getSeparateBill()  {
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
   * Returns a single repetition of Duplicate Patient (PD1-10).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public CX getDuplicatePatient(int rep) throws HL7Exception {
    CX ret = null;
    try {
        Type t = this.getField(10, rep);
        ret = (CX)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    }
    return ret;
  }

  /**
   * Returns all repetitions of Duplicate Patient (PD1-10).
   */
  public CX[] getDuplicatePatient() {
     CX[] ret = null;
    try {
        Type[] t = this.getField(10);  
        ret = new CX[t.length];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = (CX)t[i];
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
   * Returns Publicity Code (PD1-11).
   */
  public CE getPublicityCode()  {
    CE ret = null;
    try {
        Type t = this.getField(11, 0);
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
   * Returns Protection Indicator (PD1-12).
   */
  public ID getProtectionIndicator()  {
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

}