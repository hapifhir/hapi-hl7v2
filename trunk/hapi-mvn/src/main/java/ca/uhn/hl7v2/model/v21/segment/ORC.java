package ca.uhn.hl7v2.model.v21.segment;

import ca.uhn.hl7v2.model.*;
import ca.uhn.hl7v2.model.v21.datatype.*;

import ca.uhn.log.HapiLogFactory;
import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.HL7Exception;

/**
 * <p>Represents an HL7 ORC message segment. 
 * This segment has the following fields:</p><p>
 * ORC-1: ORDER CONTROL (ST)<br> 
 * ORC-2: PLACER ORDER # (CM)<br> 
 * ORC-3: FILLER ORDER # (CM)<br> 
 * ORC-4: PLACER GROUP # (CM)<br> 
 * ORC-5: ORDER STATUS (ST)<br> 
 * ORC-6: RESPONSE FLAG (ST)<br> 
 * ORC-7: TIMING/QUANTITY (CM)<br> 
 * ORC-8: PARENT (CM)<br> 
 * ORC-9: DATE/TIME OF TRANSACTION (TS)<br> 
 * ORC-10: ENTERED BY (CN)<br> 
 * ORC-11: VERIFIED BY (CN)<br> 
 * ORC-12: ORDERING PROVIDER (CN)<br> 
 * ORC-13: ENTERER'S LOCATION (CM)<br> 
 * ORC-14: CALL BACK PHONE NUMBER (TN)<br> 
 * </p><p>The get...() methods return data from individual fields.  These methods 
 * do not throw exceptions and may therefore have to handle exceptions internally.  
 * If an exception is handled internally, it is logged and null is returned.  
 * This is not expected to happen - if it does happen this indicates not so much 
 * an exceptional circumstance as a bug in the code for this class.</p>    
 */
public class ORC extends AbstractSegment  {

  /**
   * Creates a ORC (COMMON ORDER) segment object that belongs to the given 
   * message.  
   */
  public ORC(Group parent, ModelClassFactory factory) {
    super(parent, factory);
    Message message = getMessage();
    try {
       this.add(ST.class, true, 1, 2, new Object[]{message});
       this.add(CM.class, false, 1, 75, new Object[]{message});
       this.add(CM.class, false, 1, 75, new Object[]{message});
       this.add(CM.class, false, 1, 75, new Object[]{message});
       this.add(ST.class, false, 1, 2, new Object[]{message});
       this.add(ST.class, false, 1, 1, new Object[]{message});
       this.add(CM.class, false, 1, 200, new Object[]{message});
       this.add(CM.class, false, 1, 200, new Object[]{message});
       this.add(TS.class, false, 1, 19, new Object[]{message});
       this.add(CN.class, false, 1, 80, new Object[]{message});
       this.add(CN.class, false, 1, 80, new Object[]{message});
       this.add(CN.class, false, 1, 80, new Object[]{message});
       this.add(CM.class, false, 1, 80, new Object[]{message});
       this.add(TN.class, false, 2, 40, new Object[]{message});
    } catch (HL7Exception he) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Can't instantiate " + this.getClass().getName(), he);
    }
  }

  /**
   * Returns ORDER CONTROL (ORC-1).
   */
  public ST getORDERCONTROL()  {
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
   * Returns PLACER ORDER # (ORC-2).
   */
  public CM getPLACERORDER()  {
    CM ret = null;
    try {
        Type t = this.getField(2, 0);
        ret = (CM)t;
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
   * Returns FILLER ORDER # (ORC-3).
   */
  public CM getFILLERORDER()  {
    CM ret = null;
    try {
        Type t = this.getField(3, 0);
        ret = (CM)t;
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
   * Returns PLACER GROUP # (ORC-4).
   */
  public CM getPLACERGROUP()  {
    CM ret = null;
    try {
        Type t = this.getField(4, 0);
        ret = (CM)t;
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
   * Returns ORDER STATUS (ORC-5).
   */
  public ST getORDERSTATUS()  {
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

  /**
   * Returns RESPONSE FLAG (ORC-6).
   */
  public ST getRESPONSEFLAG()  {
    ST ret = null;
    try {
        Type t = this.getField(6, 0);
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
   * Returns TIMING/QUANTITY (ORC-7).
   */
  public CM getTIMINGQUANTITY()  {
    CM ret = null;
    try {
        Type t = this.getField(7, 0);
        ret = (CM)t;
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
   * Returns PARENT (ORC-8).
   */
  public CM getPARENT()  {
    CM ret = null;
    try {
        Type t = this.getField(8, 0);
        ret = (CM)t;
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
   * Returns DATE/TIME OF TRANSACTION (ORC-9).
   */
  public TS getDATETIMEOFTRANSACTION()  {
    TS ret = null;
    try {
        Type t = this.getField(9, 0);
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
   * Returns ENTERED BY (ORC-10).
   */
  public CN getENTEREDBY()  {
    CN ret = null;
    try {
        Type t = this.getField(10, 0);
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
   * Returns VERIFIED BY (ORC-11).
   */
  public CN getVERIFIEDBY()  {
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
   * Returns ORDERING PROVIDER (ORC-12).
   */
  public CN getORDERINGPROVIDER()  {
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
   * Returns ENTERER'S LOCATION (ORC-13).
   */
  public CM getENTERERSLOCATION()  {
    CM ret = null;
    try {
        Type t = this.getField(13, 0);
        ret = (CM)t;
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
   * Returns a single repetition of CALL BACK PHONE NUMBER (ORC-14).
   * @param rep the repetition number (this is a repeating field)
   * @throws HL7Exception if the repetition number is invalid.
   */
  public TN getCALLBACKPHONENUMBER(int rep) throws HL7Exception {
    TN ret = null;
    try {
        Type t = this.getField(14, rep);
        ret = (TN)t;
    } catch (ClassCastException cce) {
        HapiLogFactory.getHapiLog(this.getClass()).error("Unexpected problem obtaining field value.  This is a bug.", cce);
        throw new RuntimeException(cce);
    }
    return ret;
  }

  /**
   * Returns all repetitions of CALL BACK PHONE NUMBER (ORC-14).
   */
  public TN[] getCALLBACKPHONENUMBER() {
     TN[] ret = null;
    try {
        Type[] t = this.getField(14);  
        ret = new TN[t.length];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = (TN)t[i];
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