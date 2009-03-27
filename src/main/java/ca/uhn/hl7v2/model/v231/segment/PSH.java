package ca.uhn.hl7v2.model.v231.segment;

import ca.uhn.hl7v2.model.*;
import ca.uhn.hl7v2.model.v231.datatype.*;

import ca.uhn.log.HapiLogFactory;
import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.HL7Exception;

/**
 * <p>Represents an HL7 PSH message segment. 
 * This segment has the following fields:</p><p>
 * PSH-1: Report Type (ST)<br> 
 * PSH-2: Report Form Identifier (ST)<br> 
 * PSH-3: Report Date (TS)<br> 
 * PSH-4: Report Interval Start Date (TS)<br> 
 * PSH-5: Report Interval End Date (TS)<br> 
 * PSH-6: Quantity Manufactured (CQ)<br> 
 * PSH-7: Quantity Distributed (CQ)<br> 
 * PSH-8: Quantity Distributed Method (ID)<br> 
 * PSH-9: Quantity Distributed Comment (FT)<br> 
 * PSH-10: Quantity in Use (CQ)<br> 
 * PSH-11: Quantity in Use Method (ID)<br> 
 * PSH-12: Quantity in Use Comment (FT)<br> 
 * PSH-13: Number of Product Experience Reports Filed by Facility (NM)<br> 
 * PSH-14: Number of Product Experience Reports Filed by Distributor (NM)<br> 
 * </p><p>The get...() methods return data from individual fields.  These methods 
 * do not throw exceptions and may therefore have to handle exceptions internally.  
 * If an exception is handled internally, it is logged and null is returned.  
 * This is not expected to happen - if it does happen this indicates not so much 
 * an exceptional circumstance as a bug in the code for this class.</p>    
 */
public class PSH extends AbstractSegment  {

  /**
   * Creates a PSH (PSH - product summary header segment) segment object that belongs to the given 
   * message.  
   */
  public PSH(Group parent, ModelClassFactory factory) {
    super(parent, factory);
    Message message = getMessage();
    try {
       this.add(ST.class, true, 1, 60, new Object[]{message});
       this.add(ST.class, false, 1, 60, new Object[]{message});
       this.add(TS.class, true, 1, 26, new Object[]{message});
       this.add(TS.class, false, 1, 26, new Object[]{message});
       this.add(TS.class, false, 1, 26, new Object[]{message});
       this.add(CQ.class, false, 1, 12, new Object[]{message});
       this.add(CQ.class, false, 1, 12, new Object[]{message});
       this.add(ID.class, false, 1, 1, new Object[]{message, new Integer(329)});
       this.add(FT.class, false, 1, 600, new Object[]{message});
       this.add(CQ.class, false, 1, 12, new Object[]{message});
       this.add(ID.class, false, 1, 1, new Object[]{message, new Integer(329)});
       this.add(FT.class, false, 1, 600, new Object[]{message});
       this.add(NM.class, false, 8, 2, new Object[]{message});
       this.add(NM.class, false, 8, 2, new Object[]{message});
    } catch (HL7Exception he) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Can't instantiate " + this.getClass().getName(), he);
    }
  }

  /**
   * Returns Report Type (PSH-1).
   */
  public ST getReportType()  {
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
   * Returns Report Form Identifier (PSH-2).
   */
  public ST getReportFormIdentifier()  {
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
   * Returns Report Date (PSH-3).
   */
  public TS getReportDate()  {
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
   * Returns Report Interval Start Date (PSH-4).
   */
  public TS getReportIntervalStartDate()  {
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
   * Returns Report Interval End Date (PSH-5).
   */
  public TS getReportIntervalEndDate()  {
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
   * Returns Quantity Manufactured (PSH-6).
   */
  public CQ getQuantityManufactured()  {
    CQ ret = null;
    try {
        Type t = this.getField(6, 0);
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
   * Returns Quantity Distributed (PSH-7).
   */
  public CQ getQuantityDistributed()  {
    CQ ret = null;
    try {
        Type t = this.getField(7, 0);
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
   * Returns Quantity Distributed Method (PSH-8).
   */
  public ID getQuantityDistributedMethod()  {
    ID ret = null;
    try {
        Type t = this.getField(8, 0);
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
   * Returns Quantity Distributed Comment (PSH-9).
   */
  public FT getQuantityDistributedComment()  {
    FT ret = null;
    try {
        Type t = this.getField(9, 0);
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
   * Returns Quantity in Use (PSH-10).
   */
  public CQ getQuantityInUse()  {
    CQ ret = null;
    try {
        Type t = this.getField(10, 0);
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
   * Returns Quantity in Use Method (PSH-11).
   */
  public ID getQuantityInUseMethod()  {
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
   * Returns Quantity in Use Comment (PSH-12).
   */
  public FT getQuantityInUseComment()  {
    FT ret = null;
    try {
        Type t = this.getField(12, 0);
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
   * Returns a single repetition of Number of Product Experience Reports Filed by Facility (PSH-13).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public NM getNumberOfProductExperienceReportsFiledByFacility(int rep) throws HL7Exception {
    NM ret = null;
    try {
        Type t = this.getField(13, rep);
        ret = (NM)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    }
    return ret;
  }

  /**
   * Returns all repetitions of Number of Product Experience Reports Filed by Facility (PSH-13).
   */
  public NM[] getNumberOfProductExperienceReportsFiledByFacility() {
     NM[] ret = null;
    try {
        Type[] t = this.getField(13);  
        ret = new NM[t.length];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = (NM)t[i];
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
   * Returns a single repetition of Number of Product Experience Reports Filed by Distributor (PSH-14).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public NM getNumberOfProductExperienceReportsFiledByDistributor(int rep) throws HL7Exception {
    NM ret = null;
    try {
        Type t = this.getField(14, rep);
        ret = (NM)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    }
    return ret;
  }

  /**
   * Returns all repetitions of Number of Product Experience Reports Filed by Distributor (PSH-14).
   */
  public NM[] getNumberOfProductExperienceReportsFiledByDistributor() {
     NM[] ret = null;
    try {
        Type[] t = this.getField(14);  
        ret = new NM[t.length];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = (NM)t[i];
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