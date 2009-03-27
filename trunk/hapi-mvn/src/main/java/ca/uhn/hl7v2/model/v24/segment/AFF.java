package ca.uhn.hl7v2.model.v24.segment;

import ca.uhn.hl7v2.model.*;
import ca.uhn.hl7v2.model.v24.datatype.*;

import ca.uhn.log.HapiLogFactory;
import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.HL7Exception;

/**
 * <p>Represents an HL7 AFF message segment. 
 * This segment has the following fields:</p><p>
 * AFF-1: Set ID - AFF (SI)<br> 
 * AFF-2: Professional Organization (XON)<br> 
 * AFF-3: Professional Organization Address (XAD)<br> 
 * AFF-4: Professional Organization Affiliation Date Range (DR)<br> 
 * AFF-5: Professional Affiliation Additional Information (ST)<br> 
 * </p><p>The get...() methods return data from individual fields.  These methods 
 * do not throw exceptions and may therefore have to handle exceptions internally.  
 * If an exception is handled internally, it is logged and null is returned.  
 * This is not expected to happen - if it does happen this indicates not so much 
 * an exceptional circumstance as a bug in the code for this class.</p>    
 */
public class AFF extends AbstractSegment  {

  /**
   * Creates a AFF (Professional Affiliation) segment object that belongs to the given 
   * message.  
   */
  public AFF(Group parent, ModelClassFactory factory) {
    super(parent, factory);
    Message message = getMessage();
    try {
       this.add(SI.class, true, 1, 60, new Object[]{message});
       this.add(XON.class, true, 1, 250, new Object[]{message});
       this.add(XAD.class, false, 1, 250, new Object[]{message});
       this.add(DR.class, false, 0, 52, new Object[]{message});
       this.add(ST.class, false, 1, 60, new Object[]{message});
    } catch (HL7Exception he) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Can't instantiate " + this.getClass().getName(), he);
    }
  }

  /**
   * Returns Set ID - AFF (AFF-1).
   */
  public SI getSetIDAFF()  {
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
   * Returns Professional Organization (AFF-2).
   */
  public XON getProfessionalOrganization()  {
    XON ret = null;
    try {
        Type t = this.getField(2, 0);
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
   * Returns Professional Organization Address (AFF-3).
   */
  public XAD getProfessionalOrganizationAddress()  {
    XAD ret = null;
    try {
        Type t = this.getField(3, 0);
        ret = (XAD)t;
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
   * Returns a single repetition of Professional Organization Affiliation Date Range (AFF-4).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public DR getProfessionalOrganizationAffiliationDateRange(int rep) throws HL7Exception {
    DR ret = null;
    try {
        Type t = this.getField(4, rep);
        ret = (DR)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    }
    return ret;
  }

  /**
   * Returns all repetitions of Professional Organization Affiliation Date Range (AFF-4).
   */
  public DR[] getProfessionalOrganizationAffiliationDateRange() {
     DR[] ret = null;
    try {
        Type[] t = this.getField(4);  
        ret = new DR[t.length];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = (DR)t[i];
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
   * Returns Professional Affiliation Additional Information (AFF-5).
   */
  public ST getProfessionalAffiliationAdditionalInformation()  {
    ST ret = null;
    try {
        Type t = this.getField(5, 0);
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

}