package ca.uhn.hl7v2.model.v21.segment;

import ca.uhn.hl7v2.model.*;
import ca.uhn.hl7v2.model.v21.datatype.*;

import ca.uhn.log.HapiLogFactory;
import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.HL7Exception;

/**
 * <p>Represents an HL7 OBX message segment. 
 * This segment has the following fields:</p><p>
 * OBX-1: SET ID - OBSERVATION SIMPLE (SI)<br> 
 * OBX-2: VALUE TYPE (ID)<br> 
 * OBX-3: OBSERVATION IDENTIFIER (CE)<br> 
 * OBX-4: OBSERVATION SUB-ID (NM)<br> 
 * OBX-5: OBSERVATION RESULTS (varies)<br> 
 * OBX-6: UNITS (ID)<br> 
 * OBX-7: REFERENCES RANGE (ST)<br> 
 * OBX-8: ABNORMAL FLAGS (ST)<br> 
 * OBX-9: PROBABILITY (NM)<br> 
 * OBX-10: NATURE OF ABNORMAL TEST (ID)<br> 
 * OBX-11: OBSERV RESULT STATUS (ID)<br> 
 * OBX-12: DATE LAST OBS NORMAL VALUES (TS)<br> 
 * </p><p>The get...() methods return data from individual fields.  These methods 
 * do not throw exceptions and may therefore have to handle exceptions internally.  
 * If an exception is handled internally, it is logged and null is returned.  
 * This is not expected to happen - if it does happen this indicates not so much 
 * an exceptional circumstance as a bug in the code for this class.</p>    
 */
public class OBX extends AbstractSegment  {

  /**
   * Creates a OBX (RESULT) segment object that belongs to the given 
   * message.  
   */
  public OBX(Group parent, ModelClassFactory factory) {
    super(parent, factory);
    Message message = getMessage();
    try {
       this.add(SI.class, false, 1, 4, new Object[]{message});
       this.add(ID.class, false, 1, 2, new Object[]{message, new Integer(125)});
       this.add(CE.class, true, 1, 80, new Object[]{message});
       this.add(NM.class, false, 1, 20, new Object[]{message});
       this.add(Varies.class, true, 1, 65, new Object[]{message});
       this.add(ID.class, false, 1, 20, new Object[]{message, new Integer(0)});
       this.add(ST.class, false, 1, 60, new Object[]{message});
       this.add(ST.class, false, 5, 10, new Object[]{message});
       this.add(NM.class, false, 1, 5, new Object[]{message});
       this.add(ID.class, false, 1, 5, new Object[]{message, new Integer(80)});
       this.add(ID.class, false, 1, 2, new Object[]{message, new Integer(85)});
       this.add(TS.class, false, 1, 19, new Object[]{message});
    } catch (HL7Exception he) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Can't instantiate " + this.getClass().getName(), he);
    }
  }

  /**
   * Returns SET ID - OBSERVATION SIMPLE (OBX-1).
   */
  public SI getSETIDOBSERVATIONSIMPLE()  {
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
   * Returns VALUE TYPE (OBX-2).
   */
  public ID getVALUETYPE()  {
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
   * Returns OBSERVATION IDENTIFIER (OBX-3).
   */
  public CE getOBSERVATIONIDENTIFIER()  {
    CE ret = null;
    try {
        Type t = this.getField(3, 0);
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
   * Returns OBSERVATION SUB-ID (OBX-4).
   */
  public NM getOBSERVATIONSUBID()  {
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
   * Returns OBSERVATION RESULTS (OBX-5).
   */
  public Varies getOBSERVATIONRESULTS()  {
    Varies ret = null;
    try {
        Type t = this.getField(5, 0);
        ret = (Varies)t;
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
   * Returns UNITS (OBX-6).
   */
  public ID getUNITS()  {
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
   * Returns REFERENCES RANGE (OBX-7).
   */
  public ST getREFERENCESRANGE()  {
    ST ret = null;
    try {
        Type t = this.getField(7, 0);
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
   * Returns a single repetition of ABNORMAL FLAGS (OBX-8).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public ST getABNORMALFLAGS(int rep) throws HL7Exception {
    ST ret = null;
    try {
        Type t = this.getField(8, rep);
        ret = (ST)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    }
    return ret;
  }

  /**
   * Returns all repetitions of ABNORMAL FLAGS (OBX-8).
   */
  public ST[] getABNORMALFLAGS() {
     ST[] ret = null;
    try {
        Type[] t = this.getField(8);  
        ret = new ST[t.length];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = (ST)t[i];
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
   * Returns PROBABILITY (OBX-9).
   */
  public NM getPROBABILITY()  {
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
   * Returns NATURE OF ABNORMAL TEST (OBX-10).
   */
  public ID getNATUREOFABNORMALTEST()  {
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
   * Returns OBSERV RESULT STATUS (OBX-11).
   */
  public ID getOBSERVRESULTSTATUS()  {
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
   * Returns DATE LAST OBS NORMAL VALUES (OBX-12).
   */
  public TS getDATELASTOBSNORMALVALUES()  {
    TS ret = null;
    try {
        Type t = this.getField(12, 0);
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

}