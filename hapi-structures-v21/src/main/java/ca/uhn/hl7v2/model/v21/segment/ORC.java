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
 *<p>Represents an HL7 ORC message segment (COMMON ORDER). 
 * This segment has the following fields:</p>
 * <ul>
     * <li>ORC-1: ORDER CONTROL (ST) <b> </b>
     * <li>ORC-2: PLACER ORDER # (CM) <b>optional </b>
     * <li>ORC-3: FILLER ORDER # (CM) <b>optional </b>
     * <li>ORC-4: PLACER GROUP # (CM) <b>optional </b>
     * <li>ORC-5: ORDER STATUS (ST) <b>optional </b>
     * <li>ORC-6: RESPONSE FLAG (ST) <b>optional </b>
     * <li>ORC-7: TIMING/QUANTITY (CM) <b>optional </b>
     * <li>ORC-8: PARENT (CM) <b>optional </b>
     * <li>ORC-9: DATE/TIME OF TRANSACTION (TS) <b>optional </b>
     * <li>ORC-10: ENTERED BY (CN) <b>optional </b>
     * <li>ORC-11: VERIFIED BY (CN) <b>optional </b>
     * <li>ORC-12: ORDERING PROVIDER (CN) <b>optional </b>
     * <li>ORC-13: ENTERER'S LOCATION (CM) <b>optional </b>
     * <li>ORC-14: CALL BACK PHONE NUMBER (TN) <b>optional repeating</b>
 * </ul>
 */
@SuppressWarnings("unused")
public class ORC extends AbstractSegment {

    /** 
     * Creates a new ORC segment
     */
    public ORC(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(ST.class, true, 1, 2, new Object[]{ getMessage() }, "ORDER CONTROL");
                                  this.add(CM.class, false, 1, 75, new Object[]{ getMessage() }, "PLACER ORDER #");
                                  this.add(CM.class, false, 1, 75, new Object[]{ getMessage() }, "FILLER ORDER #");
                                  this.add(CM.class, false, 1, 75, new Object[]{ getMessage() }, "PLACER GROUP #");
                                  this.add(ST.class, false, 1, 2, new Object[]{ getMessage() }, "ORDER STATUS");
                                  this.add(ST.class, false, 1, 1, new Object[]{ getMessage() }, "RESPONSE FLAG");
                                  this.add(CM.class, false, 1, 200, new Object[]{ getMessage() }, "TIMING/QUANTITY");
                                  this.add(CM.class, false, 1, 200, new Object[]{ getMessage() }, "PARENT");
                                  this.add(TS.class, false, 1, 19, new Object[]{ getMessage() }, "DATE/TIME OF TRANSACTION");
                                  this.add(CN.class, false, 1, 80, new Object[]{ getMessage() }, "ENTERED BY");
                                  this.add(CN.class, false, 1, 80, new Object[]{ getMessage() }, "VERIFIED BY");
                                  this.add(CN.class, false, 1, 80, new Object[]{ getMessage() }, "ORDERING PROVIDER");
                                  this.add(CM.class, false, 1, 80, new Object[]{ getMessage() }, "ENTERER'S LOCATION");
                                  this.add(TN.class, false, 2, 40, new Object[]{ getMessage() }, "CALL BACK PHONE NUMBER");
       } catch(HL7Exception e) {
          log.error("Unexpected error creating ORC - this is probably a bug in the source code generator.", e);
       }
    }



    /**
     * Returns
     * ORC-1: "ORDER CONTROL" - creates it if necessary
     */
    public ST getORDERCONTROL() { 
		ST retVal = this.getTypedField(1, 0);
		return retVal;
    }
    
    /**
     * Returns
     * ORC-1: "ORDER CONTROL" - creates it if necessary
     */
    public ST getOrc1_ORDERCONTROL() { 
		ST retVal = this.getTypedField(1, 0);
		return retVal;
    }



    /**
     * Returns
     * ORC-2: "PLACER ORDER #" - creates it if necessary
     */
    public CM getPLACERORDER() { 
		CM retVal = this.getTypedField(2, 0);
		return retVal;
    }
    
    /**
     * Returns
     * ORC-2: "PLACER ORDER #" - creates it if necessary
     */
    public CM getOrc2_PLACERORDER() { 
		CM retVal = this.getTypedField(2, 0);
		return retVal;
    }



    /**
     * Returns
     * ORC-3: "FILLER ORDER #" - creates it if necessary
     */
    public CM getFILLERORDER() { 
		CM retVal = this.getTypedField(3, 0);
		return retVal;
    }
    
    /**
     * Returns
     * ORC-3: "FILLER ORDER #" - creates it if necessary
     */
    public CM getOrc3_FILLERORDER() { 
		CM retVal = this.getTypedField(3, 0);
		return retVal;
    }



    /**
     * Returns
     * ORC-4: "PLACER GROUP #" - creates it if necessary
     */
    public CM getPLACERGROUP() { 
		CM retVal = this.getTypedField(4, 0);
		return retVal;
    }
    
    /**
     * Returns
     * ORC-4: "PLACER GROUP #" - creates it if necessary
     */
    public CM getOrc4_PLACERGROUP() { 
		CM retVal = this.getTypedField(4, 0);
		return retVal;
    }



    /**
     * Returns
     * ORC-5: "ORDER STATUS" - creates it if necessary
     */
    public ST getORDERSTATUS() { 
		ST retVal = this.getTypedField(5, 0);
		return retVal;
    }
    
    /**
     * Returns
     * ORC-5: "ORDER STATUS" - creates it if necessary
     */
    public ST getOrc5_ORDERSTATUS() { 
		ST retVal = this.getTypedField(5, 0);
		return retVal;
    }



    /**
     * Returns
     * ORC-6: "RESPONSE FLAG" - creates it if necessary
     */
    public ST getRESPONSEFLAG() { 
		ST retVal = this.getTypedField(6, 0);
		return retVal;
    }
    
    /**
     * Returns
     * ORC-6: "RESPONSE FLAG" - creates it if necessary
     */
    public ST getOrc6_RESPONSEFLAG() { 
		ST retVal = this.getTypedField(6, 0);
		return retVal;
    }



    /**
     * Returns
     * ORC-7: "TIMING/QUANTITY" - creates it if necessary
     */
    public CM getTIMINGQUANTITY() { 
		CM retVal = this.getTypedField(7, 0);
		return retVal;
    }
    
    /**
     * Returns
     * ORC-7: "TIMING/QUANTITY" - creates it if necessary
     */
    public CM getOrc7_TIMINGQUANTITY() { 
		CM retVal = this.getTypedField(7, 0);
		return retVal;
    }



    /**
     * Returns
     * ORC-8: "PARENT" - creates it if necessary
     */
    public CM getPARENT() { 
		CM retVal = this.getTypedField(8, 0);
		return retVal;
    }
    
    /**
     * Returns
     * ORC-8: "PARENT" - creates it if necessary
     */
    public CM getOrc8_PARENT() { 
		CM retVal = this.getTypedField(8, 0);
		return retVal;
    }



    /**
     * Returns
     * ORC-9: "DATE/TIME OF TRANSACTION" - creates it if necessary
     */
    public TS getDATETIMEOFTRANSACTION() { 
		TS retVal = this.getTypedField(9, 0);
		return retVal;
    }
    
    /**
     * Returns
     * ORC-9: "DATE/TIME OF TRANSACTION" - creates it if necessary
     */
    public TS getOrc9_DATETIMEOFTRANSACTION() { 
		TS retVal = this.getTypedField(9, 0);
		return retVal;
    }



    /**
     * Returns
     * ORC-10: "ENTERED BY" - creates it if necessary
     */
    public CN getENTEREDBY() { 
		CN retVal = this.getTypedField(10, 0);
		return retVal;
    }
    
    /**
     * Returns
     * ORC-10: "ENTERED BY" - creates it if necessary
     */
    public CN getOrc10_ENTEREDBY() { 
		CN retVal = this.getTypedField(10, 0);
		return retVal;
    }



    /**
     * Returns
     * ORC-11: "VERIFIED BY" - creates it if necessary
     */
    public CN getVERIFIEDBY() { 
		CN retVal = this.getTypedField(11, 0);
		return retVal;
    }
    
    /**
     * Returns
     * ORC-11: "VERIFIED BY" - creates it if necessary
     */
    public CN getOrc11_VERIFIEDBY() { 
		CN retVal = this.getTypedField(11, 0);
		return retVal;
    }



    /**
     * Returns
     * ORC-12: "ORDERING PROVIDER" - creates it if necessary
     */
    public CN getORDERINGPROVIDER() { 
		CN retVal = this.getTypedField(12, 0);
		return retVal;
    }
    
    /**
     * Returns
     * ORC-12: "ORDERING PROVIDER" - creates it if necessary
     */
    public CN getOrc12_ORDERINGPROVIDER() { 
		CN retVal = this.getTypedField(12, 0);
		return retVal;
    }



    /**
     * Returns
     * ORC-13: "ENTERER'S LOCATION" - creates it if necessary
     */
    public CM getENTERERSLOCATION() { 
		CM retVal = this.getTypedField(13, 0);
		return retVal;
    }
    
    /**
     * Returns
     * ORC-13: "ENTERER'S LOCATION" - creates it if necessary
     */
    public CM getOrc13_ENTERERSLOCATION() { 
		CM retVal = this.getTypedField(13, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of CALL BACK PHONE NUMBER (ORC-14).
     */
    public TN[] getCALLBACKPHONENUMBER() {
    	TN[] retVal = this.getTypedField(14, new TN[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of CALL BACK PHONE NUMBER (ORC-14).
     */
    public TN[] getOrc14_CALLBACKPHONENUMBER() {
    	TN[] retVal = this.getTypedField(14, new TN[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of CALL BACK PHONE NUMBER (ORC-14).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getCALLBACKPHONENUMBERReps() {
    	return this.getReps(14);
    }


    /**
     * Returns a specific repetition of
     * ORC-14: "CALL BACK PHONE NUMBER" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public TN getCALLBACKPHONENUMBER(int rep) { 
		TN retVal = this.getTypedField(14, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * ORC-14: "CALL BACK PHONE NUMBER" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public TN getOrc14_CALLBACKPHONENUMBER(int rep) { 
		TN retVal = this.getTypedField(14, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of CALL BACK PHONE NUMBER (ORC-14).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getOrc14_CALLBACKPHONENUMBERReps() {
    	return this.getReps(14);
    }


    /**
     * Inserts a repetition of
     * ORC-14: "CALL BACK PHONE NUMBER" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public TN insertCALLBACKPHONENUMBER(int rep) throws HL7Exception { 
        return (TN) super.insertRepetition(14, rep);
    }


    /**
     * Inserts a repetition of
     * ORC-14: "CALL BACK PHONE NUMBER" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public TN insertOrc14_CALLBACKPHONENUMBER(int rep) throws HL7Exception { 
        return (TN) super.insertRepetition(14, rep);
    }


    /**
     * Removes a repetition of
     * ORC-14: "CALL BACK PHONE NUMBER" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public TN removeCALLBACKPHONENUMBER(int rep) throws HL7Exception { 
        return (TN) super.removeRepetition(14, rep);
    }


    /**
     * Removes a repetition of
     * ORC-14: "CALL BACK PHONE NUMBER" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public TN removeOrc14_CALLBACKPHONENUMBER(int rep) throws HL7Exception { 
        return (TN) super.removeRepetition(14, rep);
    }






    /** {@inheritDoc} */   
    protected Type createNewTypeWithoutReflection(int field) {
       switch (field) {
          case 0: return new ST(getMessage());
          case 1: return new CM(getMessage());
          case 2: return new CM(getMessage());
          case 3: return new CM(getMessage());
          case 4: return new ST(getMessage());
          case 5: return new ST(getMessage());
          case 6: return new CM(getMessage());
          case 7: return new CM(getMessage());
          case 8: return new TS(getMessage());
          case 9: return new CN(getMessage());
          case 10: return new CN(getMessage());
          case 11: return new CN(getMessage());
          case 12: return new CM(getMessage());
          case 13: return new TN(getMessage());
          default: return null;
       }
   }


}

