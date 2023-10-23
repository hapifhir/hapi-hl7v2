/*
 * This class is an auto-generated source file for a HAPI
 * HL7 v2.x standard structure class.
 *
 * For more information, visit: http://hl7api.sourceforge.net/
 * 
 * The contents of this file are subject to the Mozilla Public License Version 1.1 
 * (the "License"); you may not use this file except in compliance with the License. 
 * You may obtain a copy of the License at http://www.mozilla.org/MPL/ 
 * Software distributed under the License is distributed on an "AS IS" basis, 
 * WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the 
 * specific language governing rights and limitations under the License. 
 * 
 * The Original Code is "[file_name]".  Description: 
 * "[one_line_description]" 
 * 
 * The Initial Developer of the Original Code is University Health Network. Copyright (C) 
 * 2012.  All Rights Reserved. 
 * 
 * Contributor(s): ______________________________________. 
 * 
 * Alternatively, the contents of this file may be used under the terms of the 
 * GNU General Public License (the  "GPL"), in which case the provisions of the GPL are 
 * applicable instead of those above.  If you wish to allow use of your version of this 
 * file only under the terms of the GPL and not to allow others to use your version 
 * of this file under the MPL, indicate your decision by deleting  the provisions above 
 * and replace  them with the notice and other provisions required by the GPL License.  
 * If you do not delete the provisions above, a recipient may use your version of 
 * this file under either the MPL or the GPL. 
 * 
 */


package ca.uhn.hl7v2.model.v21.segment;

// import ca.uhn.hl7v2.model.v21.group.*;
import ca.uhn.hl7v2.model.v21.datatype.*;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.parser.DefaultModelClassFactory;
import ca.uhn.hl7v2.model.AbstractMessage;
import ca.uhn.hl7v2.model.Group;
import ca.uhn.hl7v2.model.Type;
import ca.uhn.hl7v2.model.AbstractSegment;
import ca.uhn.hl7v2.model.Varies;


/**
 *<p>Represents an HL7 FT1 message segment (FINANCIAL TRANSACTION). 
 * This segment has the following fields:</p>
 * <ul>
     * <li>FT1-1: SET ID - FINANCIAL TRANSACTION (SI) <b>optional </b>
     * <li>FT1-2: TRANSACTION ID (ST) <b>optional </b>
     * <li>FT1-3: TRANSACTION BATCH ID (ST) <b>optional </b>
     * <li>FT1-4: TRANSACTION DATE (DT) <b> </b>
     * <li>FT1-5: TRANSACTION POSTING DATE (DT) <b>optional </b>
     * <li>FT1-6: TRANSACTION TYPE (ID) <b> </b>
     * <li>FT1-7: TRANSACTION CODE (ID) <b> </b>
     * <li>FT1-8: TRANSACTION DESCRIPTION (ST) <b>optional </b>
     * <li>FT1-9: TRANSACTION DESCRIPTION - ALT (ST) <b>optional </b>
     * <li>FT1-10: TRANSACTION AMOUNT - EXTENDED (NM) <b>optional </b>
     * <li>FT1-11: TRANSACTION QUANTITY (NM) <b>optional </b>
     * <li>FT1-12: TRANSACTION AMOUNT - UNIT (NM) <b>optional </b>
     * <li>FT1-13: DEPARTMENT CODE (ST) <b>optional </b>
     * <li>FT1-14: INSURANCE PLAN ID (ID) <b>optional </b>
     * <li>FT1-15: INSURANCE AMOUNT (NM) <b>optional </b>
     * <li>FT1-16: PATIENT LOCATION (ST) <b>optional </b>
     * <li>FT1-17: FEE SCHEDULE (ID) <b>optional </b>
     * <li>FT1-18: PATIENT TYPE (ID) <b>optional </b>
     * <li>FT1-19: DIAGNOSIS CODE (ID) <b>optional </b>
     * <li>FT1-20: PERFORMED BY CODE (CN) <b>optional </b>
     * <li>FT1-21: ORDERED BY CODE (CN) <b>optional </b>
     * <li>FT1-22: UNIT COST (NM) <b>optional </b>
 * </ul>
 */
@SuppressWarnings("unused")
public class FT1 extends AbstractSegment {

    /** 
     * Creates a new FT1 segment
     */
    public FT1(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(SI.class, false, 1, 4, new Object[]{ getMessage() }, "SET ID - FINANCIAL TRANSACTION");
                                  this.add(ST.class, false, 1, 12, new Object[]{ getMessage() }, "TRANSACTION ID");
                                  this.add(ST.class, false, 1, 5, new Object[]{ getMessage() }, "TRANSACTION BATCH ID");
                                  this.add(DT.class, true, 1, 8, new Object[]{ getMessage() }, "TRANSACTION DATE");
                                  this.add(DT.class, false, 1, 8, new Object[]{ getMessage() }, "TRANSACTION POSTING DATE");
                                              this.add(ID.class, true, 1, 8, new Object[]{ getMessage(), new Integer(17) }, "TRANSACTION TYPE");
                                              this.add(ID.class, true, 1, 20, new Object[]{ getMessage(), new Integer(96) }, "TRANSACTION CODE");
                                  this.add(ST.class, false, 1, 40, new Object[]{ getMessage() }, "TRANSACTION DESCRIPTION");
                                  this.add(ST.class, false, 1, 40, new Object[]{ getMessage() }, "TRANSACTION DESCRIPTION - ALT");
                                  this.add(NM.class, false, 1, 12, new Object[]{ getMessage() }, "TRANSACTION AMOUNT - EXTENDED");
                                  this.add(NM.class, false, 1, 4, new Object[]{ getMessage() }, "TRANSACTION QUANTITY");
                                  this.add(NM.class, false, 1, 12, new Object[]{ getMessage() }, "TRANSACTION AMOUNT - UNIT");
                                  this.add(ST.class, false, 1, 16, new Object[]{ getMessage() }, "DEPARTMENT CODE");
                                              this.add(ID.class, false, 1, 8, new Object[]{ getMessage(), new Integer(72) }, "INSURANCE PLAN ID");
                                  this.add(NM.class, false, 1, 12, new Object[]{ getMessage() }, "INSURANCE AMOUNT");
                                  this.add(ST.class, false, 1, 12, new Object[]{ getMessage() }, "PATIENT LOCATION");
                                              this.add(ID.class, false, 1, 1, new Object[]{ getMessage(), new Integer(24) }, "FEE SCHEDULE");
                                              this.add(ID.class, false, 1, 2, new Object[]{ getMessage(), new Integer(18) }, "PATIENT TYPE");
                                              this.add(ID.class, false, 1, 8, new Object[]{ getMessage(), new Integer(51) }, "DIAGNOSIS CODE");
                                  this.add(CN.class, false, 1, 60, new Object[]{ getMessage() }, "PERFORMED BY CODE");
                                  this.add(CN.class, false, 1, 60, new Object[]{ getMessage() }, "ORDERED BY CODE");
                                  this.add(NM.class, false, 1, 12, new Object[]{ getMessage() }, "UNIT COST");
       } catch(HL7Exception e) {
          log.error("Unexpected error creating FT1 - this is probably a bug in the source code generator.", e);
       }
    }



    /**
     * Returns
     * FT1-1: "SET ID - FINANCIAL TRANSACTION" - creates it if necessary
     */
    public SI getSETIDFINANCIALTRANSACTION() { 
		SI retVal = this.getTypedField(1, 0);
		return retVal;
    }
    
    /**
     * Returns
     * FT1-1: "SET ID - FINANCIAL TRANSACTION" - creates it if necessary
     */
    public SI getFt11_SETIDFINANCIALTRANSACTION() { 
		SI retVal = this.getTypedField(1, 0);
		return retVal;
    }



    /**
     * Returns
     * FT1-2: "TRANSACTION ID" - creates it if necessary
     */
    public ST getTRANSACTIONID() { 
		ST retVal = this.getTypedField(2, 0);
		return retVal;
    }
    
    /**
     * Returns
     * FT1-2: "TRANSACTION ID" - creates it if necessary
     */
    public ST getFt12_TRANSACTIONID() { 
		ST retVal = this.getTypedField(2, 0);
		return retVal;
    }



    /**
     * Returns
     * FT1-3: "TRANSACTION BATCH ID" - creates it if necessary
     */
    public ST getTRANSACTIONBATCHID() { 
		ST retVal = this.getTypedField(3, 0);
		return retVal;
    }
    
    /**
     * Returns
     * FT1-3: "TRANSACTION BATCH ID" - creates it if necessary
     */
    public ST getFt13_TRANSACTIONBATCHID() { 
		ST retVal = this.getTypedField(3, 0);
		return retVal;
    }



    /**
     * Returns
     * FT1-4: "TRANSACTION DATE" - creates it if necessary
     */
    public DT getTRANSACTIONDATE() { 
		DT retVal = this.getTypedField(4, 0);
		return retVal;
    }
    
    /**
     * Returns
     * FT1-4: "TRANSACTION DATE" - creates it if necessary
     */
    public DT getFt14_TRANSACTIONDATE() { 
		DT retVal = this.getTypedField(4, 0);
		return retVal;
    }



    /**
     * Returns
     * FT1-5: "TRANSACTION POSTING DATE" - creates it if necessary
     */
    public DT getTRANSACTIONPOSTINGDATE() { 
		DT retVal = this.getTypedField(5, 0);
		return retVal;
    }
    
    /**
     * Returns
     * FT1-5: "TRANSACTION POSTING DATE" - creates it if necessary
     */
    public DT getFt15_TRANSACTIONPOSTINGDATE() { 
		DT retVal = this.getTypedField(5, 0);
		return retVal;
    }



    /**
     * Returns
     * FT1-6: "TRANSACTION TYPE" - creates it if necessary
     */
    public ID getTRANSACTIONTYPE() { 
		ID retVal = this.getTypedField(6, 0);
		return retVal;
    }
    
    /**
     * Returns
     * FT1-6: "TRANSACTION TYPE" - creates it if necessary
     */
    public ID getFt16_TRANSACTIONTYPE() { 
		ID retVal = this.getTypedField(6, 0);
		return retVal;
    }



    /**
     * Returns
     * FT1-7: "TRANSACTION CODE" - creates it if necessary
     */
    public ID getTRANSACTIONCODE() { 
		ID retVal = this.getTypedField(7, 0);
		return retVal;
    }
    
    /**
     * Returns
     * FT1-7: "TRANSACTION CODE" - creates it if necessary
     */
    public ID getFt17_TRANSACTIONCODE() { 
		ID retVal = this.getTypedField(7, 0);
		return retVal;
    }



    /**
     * Returns
     * FT1-8: "TRANSACTION DESCRIPTION" - creates it if necessary
     */
    public ST getTRANSACTIONDESCRIPTION() { 
		ST retVal = this.getTypedField(8, 0);
		return retVal;
    }
    
    /**
     * Returns
     * FT1-8: "TRANSACTION DESCRIPTION" - creates it if necessary
     */
    public ST getFt18_TRANSACTIONDESCRIPTION() { 
		ST retVal = this.getTypedField(8, 0);
		return retVal;
    }



    /**
     * Returns
     * FT1-9: "TRANSACTION DESCRIPTION - ALT" - creates it if necessary
     */
    public ST getTRANSACTIONDESCRIPTIONALT() { 
		ST retVal = this.getTypedField(9, 0);
		return retVal;
    }
    
    /**
     * Returns
     * FT1-9: "TRANSACTION DESCRIPTION - ALT" - creates it if necessary
     */
    public ST getFt19_TRANSACTIONDESCRIPTIONALT() { 
		ST retVal = this.getTypedField(9, 0);
		return retVal;
    }



    /**
     * Returns
     * FT1-10: "TRANSACTION AMOUNT - EXTENDED" - creates it if necessary
     */
    public NM getTRANSACTIONAMOUNTEXTENDED() { 
		NM retVal = this.getTypedField(10, 0);
		return retVal;
    }
    
    /**
     * Returns
     * FT1-10: "TRANSACTION AMOUNT - EXTENDED" - creates it if necessary
     */
    public NM getFt110_TRANSACTIONAMOUNTEXTENDED() { 
		NM retVal = this.getTypedField(10, 0);
		return retVal;
    }



    /**
     * Returns
     * FT1-11: "TRANSACTION QUANTITY" - creates it if necessary
     */
    public NM getTRANSACTIONQUANTITY() { 
		NM retVal = this.getTypedField(11, 0);
		return retVal;
    }
    
    /**
     * Returns
     * FT1-11: "TRANSACTION QUANTITY" - creates it if necessary
     */
    public NM getFt111_TRANSACTIONQUANTITY() { 
		NM retVal = this.getTypedField(11, 0);
		return retVal;
    }



    /**
     * Returns
     * FT1-12: "TRANSACTION AMOUNT - UNIT" - creates it if necessary
     */
    public NM getTRANSACTIONAMOUNTUNIT() { 
		NM retVal = this.getTypedField(12, 0);
		return retVal;
    }
    
    /**
     * Returns
     * FT1-12: "TRANSACTION AMOUNT - UNIT" - creates it if necessary
     */
    public NM getFt112_TRANSACTIONAMOUNTUNIT() { 
		NM retVal = this.getTypedField(12, 0);
		return retVal;
    }



    /**
     * Returns
     * FT1-13: "DEPARTMENT CODE" - creates it if necessary
     */
    public ST getDEPARTMENTCODE() { 
		ST retVal = this.getTypedField(13, 0);
		return retVal;
    }
    
    /**
     * Returns
     * FT1-13: "DEPARTMENT CODE" - creates it if necessary
     */
    public ST getFt113_DEPARTMENTCODE() { 
		ST retVal = this.getTypedField(13, 0);
		return retVal;
    }



    /**
     * Returns
     * FT1-14: "INSURANCE PLAN ID" - creates it if necessary
     */
    public ID getINSURANCEPLANID() { 
		ID retVal = this.getTypedField(14, 0);
		return retVal;
    }
    
    /**
     * Returns
     * FT1-14: "INSURANCE PLAN ID" - creates it if necessary
     */
    public ID getFt114_INSURANCEPLANID() { 
		ID retVal = this.getTypedField(14, 0);
		return retVal;
    }



    /**
     * Returns
     * FT1-15: "INSURANCE AMOUNT" - creates it if necessary
     */
    public NM getINSURANCEAMOUNT() { 
		NM retVal = this.getTypedField(15, 0);
		return retVal;
    }
    
    /**
     * Returns
     * FT1-15: "INSURANCE AMOUNT" - creates it if necessary
     */
    public NM getFt115_INSURANCEAMOUNT() { 
		NM retVal = this.getTypedField(15, 0);
		return retVal;
    }



    /**
     * Returns
     * FT1-16: "PATIENT LOCATION" - creates it if necessary
     */
    public ST getPATIENTLOCATION() { 
		ST retVal = this.getTypedField(16, 0);
		return retVal;
    }
    
    /**
     * Returns
     * FT1-16: "PATIENT LOCATION" - creates it if necessary
     */
    public ST getFt116_PATIENTLOCATION() { 
		ST retVal = this.getTypedField(16, 0);
		return retVal;
    }



    /**
     * Returns
     * FT1-17: "FEE SCHEDULE" - creates it if necessary
     */
    public ID getFEESCHEDULE() { 
		ID retVal = this.getTypedField(17, 0);
		return retVal;
    }
    
    /**
     * Returns
     * FT1-17: "FEE SCHEDULE" - creates it if necessary
     */
    public ID getFt117_FEESCHEDULE() { 
		ID retVal = this.getTypedField(17, 0);
		return retVal;
    }



    /**
     * Returns
     * FT1-18: "PATIENT TYPE" - creates it if necessary
     */
    public ID getPATIENTTYPE() { 
		ID retVal = this.getTypedField(18, 0);
		return retVal;
    }
    
    /**
     * Returns
     * FT1-18: "PATIENT TYPE" - creates it if necessary
     */
    public ID getFt118_PATIENTTYPE() { 
		ID retVal = this.getTypedField(18, 0);
		return retVal;
    }



    /**
     * Returns
     * FT1-19: "DIAGNOSIS CODE" - creates it if necessary
     */
    public ID getDIAGNOSISCODE() { 
		ID retVal = this.getTypedField(19, 0);
		return retVal;
    }
    
    /**
     * Returns
     * FT1-19: "DIAGNOSIS CODE" - creates it if necessary
     */
    public ID getFt119_DIAGNOSISCODE() { 
		ID retVal = this.getTypedField(19, 0);
		return retVal;
    }



    /**
     * Returns
     * FT1-20: "PERFORMED BY CODE" - creates it if necessary
     */
    public CN getPERFORMEDBYCODE() { 
		CN retVal = this.getTypedField(20, 0);
		return retVal;
    }
    
    /**
     * Returns
     * FT1-20: "PERFORMED BY CODE" - creates it if necessary
     */
    public CN getFt120_PERFORMEDBYCODE() { 
		CN retVal = this.getTypedField(20, 0);
		return retVal;
    }



    /**
     * Returns
     * FT1-21: "ORDERED BY CODE" - creates it if necessary
     */
    public CN getORDEREDBYCODE() { 
		CN retVal = this.getTypedField(21, 0);
		return retVal;
    }
    
    /**
     * Returns
     * FT1-21: "ORDERED BY CODE" - creates it if necessary
     */
    public CN getFt121_ORDEREDBYCODE() { 
		CN retVal = this.getTypedField(21, 0);
		return retVal;
    }



    /**
     * Returns
     * FT1-22: "UNIT COST" - creates it if necessary
     */
    public NM getUNITCOST() { 
		NM retVal = this.getTypedField(22, 0);
		return retVal;
    }
    
    /**
     * Returns
     * FT1-22: "UNIT COST" - creates it if necessary
     */
    public NM getFt122_UNITCOST() { 
		NM retVal = this.getTypedField(22, 0);
		return retVal;
    }





    /** {@inheritDoc} */   
    protected Type createNewTypeWithoutReflection(int field) {
       switch (field) {
          case 0: return new SI(getMessage());
          case 1: return new ST(getMessage());
          case 2: return new ST(getMessage());
          case 3: return new DT(getMessage());
          case 4: return new DT(getMessage());
          case 5: return new ID(getMessage(), new Integer( 17 ));
          case 6: return new ID(getMessage(), new Integer( 96 ));
          case 7: return new ST(getMessage());
          case 8: return new ST(getMessage());
          case 9: return new NM(getMessage());
          case 10: return new NM(getMessage());
          case 11: return new NM(getMessage());
          case 12: return new ST(getMessage());
          case 13: return new ID(getMessage(), new Integer( 72 ));
          case 14: return new NM(getMessage());
          case 15: return new ST(getMessage());
          case 16: return new ID(getMessage(), new Integer( 24 ));
          case 17: return new ID(getMessage(), new Integer( 18 ));
          case 18: return new ID(getMessage(), new Integer( 51 ));
          case 19: return new CN(getMessage());
          case 20: return new CN(getMessage());
          case 21: return new NM(getMessage());
          default: return null;
       }
   }


}

