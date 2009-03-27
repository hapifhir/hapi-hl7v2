package ca.uhn.hl7v2.model.v25.segment;

import ca.uhn.hl7v2.model.*;
import ca.uhn.hl7v2.model.v25.datatype.*;

import ca.uhn.log.HapiLogFactory;
import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.HL7Exception;

/**
 * <p>Represents an HL7 PRA message segment. 
 * This segment has the following fields:</p><p>
 * PRA-1: Primary Key Value - PRA (CE)<br> 
 * PRA-2: Practitioner Group (CE)<br> 
 * PRA-3: Practitioner Category (IS)<br> 
 * PRA-4: Provider Billing (ID)<br> 
 * PRA-5: Specialty (SPD)<br> 
 * PRA-6: Practitioner ID Numbers (PLN)<br> 
 * PRA-7: Privileges (PIP)<br> 
 * PRA-8: Date Entered Practice (DT)<br> 
 * PRA-9: Institution (CE)<br> 
 * PRA-10: Date Left Practice (DT)<br> 
 * PRA-11: Government Reimbursement Billing Eligibility (CE)<br> 
 * PRA-12: Set ID - PRA (SI)<br> 
 * </p><p>The get...() methods return data from individual fields.  These methods 
 * do not throw exceptions and may therefore have to handle exceptions internally.  
 * If an exception is handled internally, it is logged and null is returned.  
 * This is not expected to happen - if it does happen this indicates not so much 
 * an exceptional circumstance as a bug in the code for this class.</p>    
 */
public class PRA extends AbstractSegment  {

  /**
   * Creates a PRA (Practitioner Detail) segment object that belongs to the given 
   * message.  
   */
  public PRA(Group parent, ModelClassFactory factory) {
    super(parent, factory);
    Message message = getMessage();
    try {
       this.add(CE.class, false, 1, 250, new Object[]{message});
       this.add(CE.class, false, 0, 250, new Object[]{message});
       this.add(IS.class, false, 0, 3, new Object[]{message, new Integer(186)});
       this.add(ID.class, false, 1, 1, new Object[]{message, new Integer(187)});
       this.add(SPD.class, false, 0, 112, new Object[]{message});
       this.add(PLN.class, false, 0, 99, new Object[]{message});
       this.add(PIP.class, false, 0, 770, new Object[]{message});
       this.add(DT.class, false, 1, 8, new Object[]{message});
       this.add(CE.class, false, 1, 250, new Object[]{message});
       this.add(DT.class, false, 1, 8, new Object[]{message});
       this.add(CE.class, false, 0, 250, new Object[]{message});
       this.add(SI.class, false, 1, 60, new Object[]{message});
    } catch (HL7Exception he) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Can't instantiate " + this.getClass().getName(), he);
    }
  }

  /**
   * Returns Primary Key Value - PRA (PRA-1).
   */
  public CE getPrimaryKeyValuePRA()  {
    CE ret = null;
    try {
        Type t = this.getField(1, 0);
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
   * Returns a single repetition of Practitioner Group (PRA-2).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public CE getPractitionerGroup(int rep) throws HL7Exception {
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
   * Returns all repetitions of Practitioner Group (PRA-2).
   */
  public CE[] getPractitionerGroup() {
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
   * Returns a single repetition of Practitioner Category (PRA-3).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public IS getPractitionerCategory(int rep) throws HL7Exception {
    IS ret = null;
    try {
        Type t = this.getField(3, rep);
        ret = (IS)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    }
    return ret;
  }

  /**
   * Returns all repetitions of Practitioner Category (PRA-3).
   */
  public IS[] getPractitionerCategory() {
     IS[] ret = null;
    try {
        Type[] t = this.getField(3);  
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
   * Returns Provider Billing (PRA-4).
   */
  public ID getProviderBilling()  {
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
   * Returns a single repetition of Specialty (PRA-5).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public SPD getSpecialty(int rep) throws HL7Exception {
    SPD ret = null;
    try {
        Type t = this.getField(5, rep);
        ret = (SPD)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    }
    return ret;
  }

  /**
   * Returns all repetitions of Specialty (PRA-5).
   */
  public SPD[] getSpecialty() {
     SPD[] ret = null;
    try {
        Type[] t = this.getField(5);  
        ret = new SPD[t.length];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = (SPD)t[i];
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
   * Returns a single repetition of Practitioner ID Numbers (PRA-6).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public PLN getPractitionerIDNumbers(int rep) throws HL7Exception {
    PLN ret = null;
    try {
        Type t = this.getField(6, rep);
        ret = (PLN)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    }
    return ret;
  }

  /**
   * Returns all repetitions of Practitioner ID Numbers (PRA-6).
   */
  public PLN[] getPractitionerIDNumbers() {
     PLN[] ret = null;
    try {
        Type[] t = this.getField(6);  
        ret = new PLN[t.length];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = (PLN)t[i];
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
   * Returns a single repetition of Privileges (PRA-7).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public PIP getPrivileges(int rep) throws HL7Exception {
    PIP ret = null;
    try {
        Type t = this.getField(7, rep);
        ret = (PIP)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    }
    return ret;
  }

  /**
   * Returns all repetitions of Privileges (PRA-7).
   */
  public PIP[] getPrivileges() {
     PIP[] ret = null;
    try {
        Type[] t = this.getField(7);  
        ret = new PIP[t.length];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = (PIP)t[i];
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
   * Returns Date Entered Practice (PRA-8).
   */
  public DT getDateEnteredPractice()  {
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
   * Returns Institution (PRA-9).
   */
  public CE getInstitution()  {
    CE ret = null;
    try {
        Type t = this.getField(9, 0);
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
   * Returns Date Left Practice (PRA-10).
   */
  public DT getDateLeftPractice()  {
    DT ret = null;
    try {
        Type t = this.getField(10, 0);
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
   * Returns a single repetition of Government Reimbursement Billing Eligibility (PRA-11).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public CE getGovernmentReimbursementBillingEligibility(int rep) throws HL7Exception {
    CE ret = null;
    try {
        Type t = this.getField(11, rep);
        ret = (CE)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    }
    return ret;
  }

  /**
   * Returns all repetitions of Government Reimbursement Billing Eligibility (PRA-11).
   */
  public CE[] getGovernmentReimbursementBillingEligibility() {
     CE[] ret = null;
    try {
        Type[] t = this.getField(11);  
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
   * Returns Set ID - PRA (PRA-12).
   */
  public SI getSetIDPRA()  {
    SI ret = null;
    try {
        Type t = this.getField(12, 0);
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

}