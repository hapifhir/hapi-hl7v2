package ca.uhn.hl7v2.model.v24.segment;

import ca.uhn.hl7v2.model.*;
import ca.uhn.hl7v2.model.v24.datatype.*;

import ca.uhn.log.HapiLogFactory;
import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.HL7Exception;

/**
 * <p>Represents an HL7 UB1 message segment. 
 * This segment has the following fields:</p><p>
 * UB1-1: Set ID - UB1 (SI)<br> 
 * UB1-2: Blood Deductible  (43) (NM)<br> 
 * UB1-3: Blood Furnished-Pints Of (40) (NM)<br> 
 * UB1-4: Blood Replaced-Pints (41) (NM)<br> 
 * UB1-5: Blood Not Replaced-Pints(42) (NM)<br> 
 * UB1-6: Co-Insurance Days (25) (NM)<br> 
 * UB1-7: Condition Code (35-39) (IS)<br> 
 * UB1-8: Covered Days - (23) (NM)<br> 
 * UB1-9: Non Covered Days - (24) (NM)<br> 
 * UB1-10: Value Amount & Code (46-49) (UVC)<br> 
 * UB1-11: Number Of Grace Days (90) (NM)<br> 
 * UB1-12: Special Program Indicator (44) (CE)<br> 
 * UB1-13: PSRO/UR Approval Indicator (87) (CE)<br> 
 * UB1-14: PSRO/UR Approved Stay-Fm (88) (DT)<br> 
 * UB1-15: PSRO/UR Approved Stay-To (89) (DT)<br> 
 * UB1-16: Occurrence (28-32) (OCD)<br> 
 * UB1-17: Occurrence Span (33) (CE)<br> 
 * UB1-18: Occur Span Start Date(33) (DT)<br> 
 * UB1-19: Occur Span End Date (33) (DT)<br> 
 * UB1-20: UB-82 Locator 2 (ST)<br> 
 * UB1-21: UB-82 Locator 9 (ST)<br> 
 * UB1-22: UB-82 Locator 27 (ST)<br> 
 * UB1-23: UB-82 Locator 45 (ST)<br> 
 * </p><p>The get...() methods return data from individual fields.  These methods 
 * do not throw exceptions and may therefore have to handle exceptions internally.  
 * If an exception is handled internally, it is logged and null is returned.  
 * This is not expected to happen - if it does happen this indicates not so much 
 * an exceptional circumstance as a bug in the code for this class.</p>    
 */
public class UB1 extends AbstractSegment  {

  /**
   * Creates a UB1 (UB82) segment object that belongs to the given 
   * message.  
   */
  public UB1(Group parent, ModelClassFactory factory) {
    super(parent, factory);
    Message message = getMessage();
    try {
       this.add(SI.class, false, 1, 4, new Object[]{message});
       this.add(NM.class, false, 1, 1, new Object[]{message});
       this.add(NM.class, false, 1, 2, new Object[]{message});
       this.add(NM.class, false, 1, 2, new Object[]{message});
       this.add(NM.class, false, 1, 2, new Object[]{message});
       this.add(NM.class, false, 1, 2, new Object[]{message});
       this.add(IS.class, false, 5, 14, new Object[]{message, new Integer(43)});
       this.add(NM.class, false, 1, 3, new Object[]{message});
       this.add(NM.class, false, 1, 3, new Object[]{message});
       this.add(UVC.class, false, 8, 12, new Object[]{message});
       this.add(NM.class, false, 1, 2, new Object[]{message});
       this.add(CE.class, false, 1, 250, new Object[]{message});
       this.add(CE.class, false, 1, 250, new Object[]{message});
       this.add(DT.class, false, 1, 8, new Object[]{message});
       this.add(DT.class, false, 1, 8, new Object[]{message});
       this.add(OCD.class, false, 5, 20, new Object[]{message});
       this.add(CE.class, false, 1, 250, new Object[]{message});
       this.add(DT.class, false, 1, 8, new Object[]{message});
       this.add(DT.class, false, 1, 8, new Object[]{message});
       this.add(ST.class, false, 1, 30, new Object[]{message});
       this.add(ST.class, false, 1, 7, new Object[]{message});
       this.add(ST.class, false, 1, 8, new Object[]{message});
       this.add(ST.class, false, 1, 17, new Object[]{message});
    } catch (HL7Exception he) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Can't instantiate " + this.getClass().getName(), he);
    }
  }

  /**
   * Returns Set ID - UB1 (UB1-1).
   */
  public SI getSetIDUB1()  {
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
   * Returns Blood Deductible  (43) (UB1-2).
   */
  public NM getBloodDeductible()  {
    NM ret = null;
    try {
        Type t = this.getField(2, 0);
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
   * Returns Blood Furnished-Pints Of (40) (UB1-3).
   */
  public NM getBloodFurnishedPintsOf()  {
    NM ret = null;
    try {
        Type t = this.getField(3, 0);
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
   * Returns Blood Replaced-Pints (41) (UB1-4).
   */
  public NM getBloodReplacedPints()  {
    NM ret = null;
    try {
        Type t = this.getField(4, 0);
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
   * Returns Blood Not Replaced-Pints(42) (UB1-5).
   */
  public NM getBloodNotReplacedPints()  {
    NM ret = null;
    try {
        Type t = this.getField(5, 0);
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
   * Returns Co-Insurance Days (25) (UB1-6).
   */
  public NM getCoInsuranceDays()  {
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
   * Returns a single repetition of Condition Code (35-39) (UB1-7).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public IS getConditionCode3539(int rep) throws HL7Exception {
    IS ret = null;
    try {
        Type t = this.getField(7, rep);
        ret = (IS)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    }
    return ret;
  }

  /**
   * Returns all repetitions of Condition Code (35-39) (UB1-7).
   */
  public IS[] getConditionCode3539() {
     IS[] ret = null;
    try {
        Type[] t = this.getField(7);  
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
   * Returns Covered Days - (23) (UB1-8).
   */
  public NM getCoveredDays()  {
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
   * Returns Non Covered Days - (24) (UB1-9).
   */
  public NM getNonCoveredDays()  {
    NM ret = null;
    try {
        Type t = this.getField(9, 0);
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
   * Returns a single repetition of Value Amount & Code (46-49) (UB1-10).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public UVC getValueAmountCode4649(int rep) throws HL7Exception {
    UVC ret = null;
    try {
        Type t = this.getField(10, rep);
        ret = (UVC)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    }
    return ret;
  }

  /**
   * Returns all repetitions of Value Amount & Code (46-49) (UB1-10).
   */
  public UVC[] getValueAmountCode4649() {
     UVC[] ret = null;
    try {
        Type[] t = this.getField(10);  
        ret = new UVC[t.length];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = (UVC)t[i];
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
   * Returns Number Of Grace Days (90) (UB1-11).
   */
  public NM getNumberOfGraceDays()  {
    NM ret = null;
    try {
        Type t = this.getField(11, 0);
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
   * Returns Special Program Indicator (44) (UB1-12).
   */
  public CE getSpecialProgramIndicator()  {
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
   * Returns PSRO/UR Approval Indicator (87) (UB1-13).
   */
  public CE getPSROURApprovalIndicator()  {
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
   * Returns PSRO/UR Approved Stay-Fm (88) (UB1-14).
   */
  public DT getPSROURApprovedStayFm()  {
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
   * Returns PSRO/UR Approved Stay-To (89) (UB1-15).
   */
  public DT getPSROURApprovedStayTo()  {
    DT ret = null;
    try {
        Type t = this.getField(15, 0);
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
   * Returns a single repetition of Occurrence (28-32) (UB1-16).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public OCD getOccurrence2832(int rep) throws HL7Exception {
    OCD ret = null;
    try {
        Type t = this.getField(16, rep);
        ret = (OCD)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    }
    return ret;
  }

  /**
   * Returns all repetitions of Occurrence (28-32) (UB1-16).
   */
  public OCD[] getOccurrence2832() {
     OCD[] ret = null;
    try {
        Type[] t = this.getField(16);  
        ret = new OCD[t.length];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = (OCD)t[i];
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
   * Returns Occurrence Span (33) (UB1-17).
   */
  public CE getOccurrenceSpan()  {
    CE ret = null;
    try {
        Type t = this.getField(17, 0);
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
   * Returns Occur Span Start Date(33) (UB1-18).
   */
  public DT getOccurSpanStartDate()  {
    DT ret = null;
    try {
        Type t = this.getField(18, 0);
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
   * Returns Occur Span End Date (33) (UB1-19).
   */
  public DT getOccurSpanEndDate()  {
    DT ret = null;
    try {
        Type t = this.getField(19, 0);
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
   * Returns UB-82 Locator 2 (UB1-20).
   */
  public ST getUB82Locator2()  {
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
   * Returns UB-82 Locator 9 (UB1-21).
   */
  public ST getUB82Locator9()  {
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
   * Returns UB-82 Locator 27 (UB1-22).
   */
  public ST getUB82Locator27()  {
    ST ret = null;
    try {
        Type t = this.getField(22, 0);
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
   * Returns UB-82 Locator 45 (UB1-23).
   */
  public ST getUB82Locator45()  {
    ST ret = null;
    try {
        Type t = this.getField(23, 0);
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