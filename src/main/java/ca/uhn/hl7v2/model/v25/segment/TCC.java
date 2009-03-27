package ca.uhn.hl7v2.model.v25.segment;

import ca.uhn.hl7v2.model.*;
import ca.uhn.hl7v2.model.v25.datatype.*;

import ca.uhn.log.HapiLogFactory;
import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.HL7Exception;

/**
 * <p>Represents an HL7 TCC message segment. 
 * This segment has the following fields:</p><p>
 * TCC-1: Universal Service Identifier (CE)<br> 
 * TCC-2: Test Application Identifier (EI)<br> 
 * TCC-3: Specimen Source (SPS)<br> 
 * TCC-4: Auto-Dilution Factor Default (SN)<br> 
 * TCC-5: Rerun Dilution Factor Default (SN)<br> 
 * TCC-6: Pre-Dilution Factor Default (SN)<br> 
 * TCC-7: Endogenous Content of Pre-Dilution Diluent (SN)<br> 
 * TCC-8: Inventory Limits Warning Level (NM)<br> 
 * TCC-9: Automatic Rerun Allowed (ID)<br> 
 * TCC-10: Automatic Repeat Allowed (ID)<br> 
 * TCC-11: Automatic Reflex Allowed (ID)<br> 
 * TCC-12: Equipment Dynamic Range (SN)<br> 
 * TCC-13: Units (CE)<br> 
 * TCC-14: Processing Type (CE)<br> 
 * </p><p>The get...() methods return data from individual fields.  These methods 
 * do not throw exceptions and may therefore have to handle exceptions internally.  
 * If an exception is handled internally, it is logged and null is returned.  
 * This is not expected to happen - if it does happen this indicates not so much 
 * an exceptional circumstance as a bug in the code for this class.</p>    
 */
public class TCC extends AbstractSegment  {

  /**
   * Creates a TCC (Test Code Configuration) segment object that belongs to the given 
   * message.  
   */
  public TCC(Group parent, ModelClassFactory factory) {
    super(parent, factory);
    Message message = getMessage();
    try {
       this.add(CE.class, true, 1, 250, new Object[]{message});
       this.add(EI.class, true, 1, 80, new Object[]{message});
       this.add(SPS.class, false, 1, 300, new Object[]{message});
       this.add(SN.class, false, 1, 20, new Object[]{message});
       this.add(SN.class, false, 1, 20, new Object[]{message});
       this.add(SN.class, false, 1, 20, new Object[]{message});
       this.add(SN.class, false, 1, 20, new Object[]{message});
       this.add(NM.class, false, 1, 10, new Object[]{message});
       this.add(ID.class, false, 1, 1, new Object[]{message, new Integer(136)});
       this.add(ID.class, false, 1, 1, new Object[]{message, new Integer(136)});
       this.add(ID.class, false, 1, 1, new Object[]{message, new Integer(136)});
       this.add(SN.class, false, 1, 20, new Object[]{message});
       this.add(CE.class, false, 1, 250, new Object[]{message});
       this.add(CE.class, false, 1, 250, new Object[]{message});
    } catch (HL7Exception he) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Can't instantiate " + this.getClass().getName(), he);
    }
  }

  /**
   * Returns Universal Service Identifier (TCC-1).
   */
  public CE getUniversalServiceIdentifier()  {
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
   * Returns Test Application Identifier (TCC-2).
   */
  public EI getTestApplicationIdentifier()  {
    EI ret = null;
    try {
        Type t = this.getField(2, 0);
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
   * Returns Specimen Source (TCC-3).
   */
  public SPS getSpecimenSource()  {
    SPS ret = null;
    try {
        Type t = this.getField(3, 0);
        ret = (SPS)t;
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
   * Returns Auto-Dilution Factor Default (TCC-4).
   */
  public SN getAutoDilutionFactorDefault()  {
    SN ret = null;
    try {
        Type t = this.getField(4, 0);
        ret = (SN)t;
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
   * Returns Rerun Dilution Factor Default (TCC-5).
   */
  public SN getRerunDilutionFactorDefault()  {
    SN ret = null;
    try {
        Type t = this.getField(5, 0);
        ret = (SN)t;
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
   * Returns Pre-Dilution Factor Default (TCC-6).
   */
  public SN getPreDilutionFactorDefault()  {
    SN ret = null;
    try {
        Type t = this.getField(6, 0);
        ret = (SN)t;
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
   * Returns Endogenous Content of Pre-Dilution Diluent (TCC-7).
   */
  public SN getEndogenousContentOfPreDilutionDiluent()  {
    SN ret = null;
    try {
        Type t = this.getField(7, 0);
        ret = (SN)t;
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
   * Returns Inventory Limits Warning Level (TCC-8).
   */
  public NM getInventoryLimitsWarningLevel()  {
    NM ret = null;
    try {
        Type t = this.getField(8, 0);
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
   * Returns Automatic Rerun Allowed (TCC-9).
   */
  public ID getAutomaticRerunAllowed()  {
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
   * Returns Automatic Repeat Allowed (TCC-10).
   */
  public ID getAutomaticRepeatAllowed()  {
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
   * Returns Automatic Reflex Allowed (TCC-11).
   */
  public ID getAutomaticReflexAllowed()  {
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
   * Returns Equipment Dynamic Range (TCC-12).
   */
  public SN getEquipmentDynamicRange()  {
    SN ret = null;
    try {
        Type t = this.getField(12, 0);
        ret = (SN)t;
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
   * Returns Units (TCC-13).
   */
  public CE getUnits()  {
    CE ret = null;
    try {
        Type t = this.getField(13, 0);
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
   * Returns Processing Type (TCC-14).
   */
  public CE getProcessingType()  {
    CE ret = null;
    try {
        Type t = this.getField(14, 0);
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

}