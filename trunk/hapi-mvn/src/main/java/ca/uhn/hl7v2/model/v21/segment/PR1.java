package ca.uhn.hl7v2.model.v21.segment;

import ca.uhn.hl7v2.model.*;
import ca.uhn.hl7v2.model.v21.datatype.*;

import ca.uhn.log.HapiLogFactory;
import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.HL7Exception;

/**
 * <p>Represents an HL7 PR1 message segment. 
 * This segment has the following fields:</p><p>
 * PR1-1: SET ID - PROCEDURE (SI)<br> 
 * PR1-2: PROCEDURE CODING METHOD. (ID)<br> 
 * PR1-3: PROCEDURE CODE (ID)<br> 
 * PR1-4: PROCEDURE DESCRIPTION (ST)<br> 
 * PR1-5: PROCEDURE DATE/TIME (TS)<br> 
 * PR1-6: PROCEDURE TYPE (ID)<br> 
 * PR1-7: PROCEDURE MINUTES (NM)<br> 
 * PR1-8: ANESTHESIOLOGIST (CN)<br> 
 * PR1-9: ANESTHESIA CODE (ID)<br> 
 * PR1-10: ANESTHESIA MINUTES (NM)<br> 
 * PR1-11: SURGEON (CN)<br> 
 * PR1-12: RESIDENT CODE (CN)<br> 
 * PR1-13: CONSENT CODE (ID)<br> 
 * </p><p>The get...() methods return data from individual fields.  These methods 
 * do not throw exceptions and may therefore have to handle exceptions internally.  
 * If an exception is handled internally, it is logged and null is returned.  
 * This is not expected to happen - if it does happen this indicates not so much 
 * an exceptional circumstance as a bug in the code for this class.</p>    
 */
public class PR1 extends AbstractSegment  {

  /**
   * Creates a PR1 (PROCEDURES) segment object that belongs to the given 
   * message.  
   */
  public PR1(Group parent, ModelClassFactory factory) {
    super(parent, factory);
    Message message = getMessage();
    try {
       this.add(SI.class, true, 0, 4, new Object[]{message});
       this.add(ID.class, true, 1, 2, new Object[]{message, new Integer(89)});
       this.add(ID.class, true, 1, 10, new Object[]{message, new Integer(88)});
       this.add(ST.class, false, 1, 40, new Object[]{message});
       this.add(TS.class, true, 1, 19, new Object[]{message});
       this.add(ID.class, true, 1, 2, new Object[]{message, new Integer(90)});
       this.add(NM.class, false, 1, 4, new Object[]{message});
       this.add(CN.class, false, 1, 60, new Object[]{message});
       this.add(ID.class, false, 1, 2, new Object[]{message, new Integer(19)});
       this.add(NM.class, false, 1, 4, new Object[]{message});
       this.add(CN.class, false, 1, 60, new Object[]{message});
       this.add(CN.class, false, 1, 60, new Object[]{message});
       this.add(ID.class, false, 1, 2, new Object[]{message, new Integer(59)});
    } catch (HL7Exception he) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Can't instantiate " + this.getClass().getName(), he);
    }
  }

  /**
   * Returns a single repetition of SET ID - PROCEDURE (PR1-1).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public SI getSETIDPROCEDURE(int rep) throws HL7Exception {
    SI ret = null;
    try {
        Type t = this.getField(1, rep);
        ret = (SI)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    }
    return ret;
  }

  /**
   * Returns all repetitions of SET ID - PROCEDURE (PR1-1).
   */
  public SI[] getSETIDPROCEDURE() {
     SI[] ret = null;
    try {
        Type[] t = this.getField(1);  
        ret = new SI[t.length];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = (SI)t[i];
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
   * Returns PROCEDURE CODING METHOD. (PR1-2).
   */
  public ID getPROCEDURECODINGMETHOD()  {
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
   * Returns PROCEDURE CODE (PR1-3).
   */
  public ID getPROCEDURECODE()  {
    ID ret = null;
    try {
        Type t = this.getField(3, 0);
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
   * Returns PROCEDURE DESCRIPTION (PR1-4).
   */
  public ST getPROCEDUREDESCRIPTION()  {
    ST ret = null;
    try {
        Type t = this.getField(4, 0);
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
   * Returns PROCEDURE DATE/TIME (PR1-5).
   */
  public TS getPROCEDUREDATETIME()  {
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
   * Returns PROCEDURE TYPE (PR1-6).
   */
  public ID getPROCEDURETYPE()  {
    ID ret = null;
    try {
        Type t = this.getField(6, 0);
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
   * Returns PROCEDURE MINUTES (PR1-7).
   */
  public NM getPROCEDUREMINUTES()  {
    NM ret = null;
    try {
        Type t = this.getField(7, 0);
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
   * Returns ANESTHESIOLOGIST (PR1-8).
   */
  public CN getANESTHESIOLOGIST()  {
    CN ret = null;
    try {
        Type t = this.getField(8, 0);
        ret = (CN)t;
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
   * Returns ANESTHESIA CODE (PR1-9).
   */
  public ID getANESTHESIACODE()  {
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
   * Returns ANESTHESIA MINUTES (PR1-10).
   */
  public NM getANESTHESIAMINUTES()  {
    NM ret = null;
    try {
        Type t = this.getField(10, 0);
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
   * Returns SURGEON (PR1-11).
   */
  public CN getSURGEON()  {
    CN ret = null;
    try {
        Type t = this.getField(11, 0);
        ret = (CN)t;
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
   * Returns RESIDENT CODE (PR1-12).
   */
  public CN getRESIDENTCODE()  {
    CN ret = null;
    try {
        Type t = this.getField(12, 0);
        ret = (CN)t;
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
   * Returns CONSENT CODE (PR1-13).
   */
  public ID getCONSENTCODE()  {
    ID ret = null;
    try {
        Type t = this.getField(13, 0);
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