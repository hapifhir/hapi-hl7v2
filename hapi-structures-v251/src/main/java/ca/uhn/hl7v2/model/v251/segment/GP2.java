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


package ca.uhn.hl7v2.model.v251.segment;

// import ca.uhn.hl7v2.model.v251.group.*;
import ca.uhn.hl7v2.model.v251.datatype.*;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.parser.DefaultModelClassFactory;
import ca.uhn.hl7v2.model.AbstractMessage;
import ca.uhn.hl7v2.model.Group;
import ca.uhn.hl7v2.model.Type;
import ca.uhn.hl7v2.model.AbstractSegment;
import ca.uhn.hl7v2.model.Varies;


/**
 *<p>Represents an HL7 GP2 message segment (Grouping/Reimbursement - Procedure Line Item). 
 * This segment has the following fields:</p>
 * <ul>
     * <li>GP2-1: Revenue Code (IS) <b>optional </b>
     * <li>GP2-2: Number of Service Units (NM) <b>optional </b>
     * <li>GP2-3: Charge (CP) <b>optional </b>
     * <li>GP2-4: Reimbursement Action Code (IS) <b>optional </b>
     * <li>GP2-5: Denial or Rejection Code (IS) <b>optional </b>
     * <li>GP2-6: OCE Edit Code (IS) <b>optional repeating</b>
     * <li>GP2-7: Ambulatory Payment Classification Code (CE) <b>optional </b>
     * <li>GP2-8: Modifier Edit Code (IS) <b>optional repeating</b>
     * <li>GP2-9: Payment Adjustment Code (IS) <b>optional </b>
     * <li>GP2-10: Packaging Status Code (IS) <b>optional </b>
     * <li>GP2-11: Expected CMS Payment Amount (CP) <b>optional </b>
     * <li>GP2-12: Reimbursement Type Code (IS) <b>optional </b>
     * <li>GP2-13: Co-Pay Amount (CP) <b>optional </b>
     * <li>GP2-14: Pay Rate per Service Unit (NM) <b>optional </b>
 * </ul>
 */
@SuppressWarnings("unused")
public class GP2 extends AbstractSegment {

    /** 
     * Creates a new GP2 segment
     */
    public GP2(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                              this.add(IS.class, false, 1, 3, new Object[]{ getMessage(), new Integer(456) }, "Revenue Code");
                                  this.add(NM.class, false, 1, 7, new Object[]{ getMessage() }, "Number of Service Units");
                                  this.add(CP.class, false, 1, 12, new Object[]{ getMessage() }, "Charge");
                                              this.add(IS.class, false, 1, 1, new Object[]{ getMessage(), new Integer(459) }, "Reimbursement Action Code");
                                              this.add(IS.class, false, 1, 1, new Object[]{ getMessage(), new Integer(460) }, "Denial or Rejection Code");
                                              this.add(IS.class, false, 0, 3, new Object[]{ getMessage(), new Integer(458) }, "OCE Edit Code");
                                  this.add(CE.class, false, 1, 250, new Object[]{ getMessage() }, "Ambulatory Payment Classification Code");
                                              this.add(IS.class, false, 0, 1, new Object[]{ getMessage(), new Integer(467) }, "Modifier Edit Code");
                                              this.add(IS.class, false, 1, 1, new Object[]{ getMessage(), new Integer(468) }, "Payment Adjustment Code");
                                              this.add(IS.class, false, 1, 1, new Object[]{ getMessage(), new Integer(469) }, "Packaging Status Code");
                                  this.add(CP.class, false, 1, 12, new Object[]{ getMessage() }, "Expected CMS Payment Amount");
                                              this.add(IS.class, false, 1, 2, new Object[]{ getMessage(), new Integer(470) }, "Reimbursement Type Code");
                                  this.add(CP.class, false, 1, 12, new Object[]{ getMessage() }, "Co-Pay Amount");
                                  this.add(NM.class, false, 1, 4, new Object[]{ getMessage() }, "Pay Rate per Service Unit");
       } catch(HL7Exception e) {
          log.error("Unexpected error creating GP2 - this is probably a bug in the source code generator.", e);
       }
    }



    /**
     * Returns
     * GP2-1: "Revenue Code" - creates it if necessary
     */
    public IS getRevenueCode() { 
		IS retVal = this.getTypedField(1, 0);
		return retVal;
    }
    
    /**
     * Returns
     * GP2-1: "Revenue Code" - creates it if necessary
     */
    public IS getGp21_RevenueCode() { 
		IS retVal = this.getTypedField(1, 0);
		return retVal;
    }



    /**
     * Returns
     * GP2-2: "Number of Service Units" - creates it if necessary
     */
    public NM getNumberOfServiceUnits() { 
		NM retVal = this.getTypedField(2, 0);
		return retVal;
    }
    
    /**
     * Returns
     * GP2-2: "Number of Service Units" - creates it if necessary
     */
    public NM getGp22_NumberOfServiceUnits() { 
		NM retVal = this.getTypedField(2, 0);
		return retVal;
    }



    /**
     * Returns
     * GP2-3: "Charge" - creates it if necessary
     */
    public CP getCharge() { 
		CP retVal = this.getTypedField(3, 0);
		return retVal;
    }
    
    /**
     * Returns
     * GP2-3: "Charge" - creates it if necessary
     */
    public CP getGp23_Charge() { 
		CP retVal = this.getTypedField(3, 0);
		return retVal;
    }



    /**
     * Returns
     * GP2-4: "Reimbursement Action Code" - creates it if necessary
     */
    public IS getReimbursementActionCode() { 
		IS retVal = this.getTypedField(4, 0);
		return retVal;
    }
    
    /**
     * Returns
     * GP2-4: "Reimbursement Action Code" - creates it if necessary
     */
    public IS getGp24_ReimbursementActionCode() { 
		IS retVal = this.getTypedField(4, 0);
		return retVal;
    }



    /**
     * Returns
     * GP2-5: "Denial or Rejection Code" - creates it if necessary
     */
    public IS getDenialOrRejectionCode() { 
		IS retVal = this.getTypedField(5, 0);
		return retVal;
    }
    
    /**
     * Returns
     * GP2-5: "Denial or Rejection Code" - creates it if necessary
     */
    public IS getGp25_DenialOrRejectionCode() { 
		IS retVal = this.getTypedField(5, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of OCE Edit Code (GP2-6).
     */
    public IS[] getOCEEditCode() {
    	IS[] retVal = this.getTypedField(6, new IS[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of OCE Edit Code (GP2-6).
     */
    public IS[] getGp26_OCEEditCode() {
    	IS[] retVal = this.getTypedField(6, new IS[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of OCE Edit Code (GP2-6).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getOCEEditCodeReps() {
    	return this.getReps(6);
    }


    /**
     * Returns a specific repetition of
     * GP2-6: "OCE Edit Code" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public IS getOCEEditCode(int rep) { 
		IS retVal = this.getTypedField(6, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * GP2-6: "OCE Edit Code" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public IS getGp26_OCEEditCode(int rep) { 
		IS retVal = this.getTypedField(6, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of OCE Edit Code (GP2-6).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getGp26_OCEEditCodeReps() {
    	return this.getReps(6);
    }


    /**
     * Inserts a repetition of
     * GP2-6: "OCE Edit Code" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public IS insertOCEEditCode(int rep) throws HL7Exception { 
        return (IS) super.insertRepetition(6, rep);
    }


    /**
     * Inserts a repetition of
     * GP2-6: "OCE Edit Code" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public IS insertGp26_OCEEditCode(int rep) throws HL7Exception { 
        return (IS) super.insertRepetition(6, rep);
    }


    /**
     * Removes a repetition of
     * GP2-6: "OCE Edit Code" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public IS removeOCEEditCode(int rep) throws HL7Exception { 
        return (IS) super.removeRepetition(6, rep);
    }


    /**
     * Removes a repetition of
     * GP2-6: "OCE Edit Code" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public IS removeGp26_OCEEditCode(int rep) throws HL7Exception { 
        return (IS) super.removeRepetition(6, rep);
    }




    /**
     * Returns
     * GP2-7: "Ambulatory Payment Classification Code" - creates it if necessary
     */
    public CE getAmbulatoryPaymentClassificationCode() { 
		CE retVal = this.getTypedField(7, 0);
		return retVal;
    }
    
    /**
     * Returns
     * GP2-7: "Ambulatory Payment Classification Code" - creates it if necessary
     */
    public CE getGp27_AmbulatoryPaymentClassificationCode() { 
		CE retVal = this.getTypedField(7, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Modifier Edit Code (GP2-8).
     */
    public IS[] getModifierEditCode() {
    	IS[] retVal = this.getTypedField(8, new IS[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Modifier Edit Code (GP2-8).
     */
    public IS[] getGp28_ModifierEditCode() {
    	IS[] retVal = this.getTypedField(8, new IS[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Modifier Edit Code (GP2-8).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getModifierEditCodeReps() {
    	return this.getReps(8);
    }


    /**
     * Returns a specific repetition of
     * GP2-8: "Modifier Edit Code" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public IS getModifierEditCode(int rep) { 
		IS retVal = this.getTypedField(8, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * GP2-8: "Modifier Edit Code" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public IS getGp28_ModifierEditCode(int rep) { 
		IS retVal = this.getTypedField(8, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Modifier Edit Code (GP2-8).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getGp28_ModifierEditCodeReps() {
    	return this.getReps(8);
    }


    /**
     * Inserts a repetition of
     * GP2-8: "Modifier Edit Code" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public IS insertModifierEditCode(int rep) throws HL7Exception { 
        return (IS) super.insertRepetition(8, rep);
    }


    /**
     * Inserts a repetition of
     * GP2-8: "Modifier Edit Code" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public IS insertGp28_ModifierEditCode(int rep) throws HL7Exception { 
        return (IS) super.insertRepetition(8, rep);
    }


    /**
     * Removes a repetition of
     * GP2-8: "Modifier Edit Code" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public IS removeModifierEditCode(int rep) throws HL7Exception { 
        return (IS) super.removeRepetition(8, rep);
    }


    /**
     * Removes a repetition of
     * GP2-8: "Modifier Edit Code" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public IS removeGp28_ModifierEditCode(int rep) throws HL7Exception { 
        return (IS) super.removeRepetition(8, rep);
    }




    /**
     * Returns
     * GP2-9: "Payment Adjustment Code" - creates it if necessary
     */
    public IS getPaymentAdjustmentCode() { 
		IS retVal = this.getTypedField(9, 0);
		return retVal;
    }
    
    /**
     * Returns
     * GP2-9: "Payment Adjustment Code" - creates it if necessary
     */
    public IS getGp29_PaymentAdjustmentCode() { 
		IS retVal = this.getTypedField(9, 0);
		return retVal;
    }



    /**
     * Returns
     * GP2-10: "Packaging Status Code" - creates it if necessary
     */
    public IS getPackagingStatusCode() { 
		IS retVal = this.getTypedField(10, 0);
		return retVal;
    }
    
    /**
     * Returns
     * GP2-10: "Packaging Status Code" - creates it if necessary
     */
    public IS getGp210_PackagingStatusCode() { 
		IS retVal = this.getTypedField(10, 0);
		return retVal;
    }



    /**
     * Returns
     * GP2-11: "Expected CMS Payment Amount" - creates it if necessary
     */
    public CP getExpectedCMSPaymentAmount() { 
		CP retVal = this.getTypedField(11, 0);
		return retVal;
    }
    
    /**
     * Returns
     * GP2-11: "Expected CMS Payment Amount" - creates it if necessary
     */
    public CP getGp211_ExpectedCMSPaymentAmount() { 
		CP retVal = this.getTypedField(11, 0);
		return retVal;
    }



    /**
     * Returns
     * GP2-12: "Reimbursement Type Code" - creates it if necessary
     */
    public IS getReimbursementTypeCode() { 
		IS retVal = this.getTypedField(12, 0);
		return retVal;
    }
    
    /**
     * Returns
     * GP2-12: "Reimbursement Type Code" - creates it if necessary
     */
    public IS getGp212_ReimbursementTypeCode() { 
		IS retVal = this.getTypedField(12, 0);
		return retVal;
    }



    /**
     * Returns
     * GP2-13: "Co-Pay Amount" - creates it if necessary
     */
    public CP getCoPayAmount() { 
		CP retVal = this.getTypedField(13, 0);
		return retVal;
    }
    
    /**
     * Returns
     * GP2-13: "Co-Pay Amount" - creates it if necessary
     */
    public CP getGp213_CoPayAmount() { 
		CP retVal = this.getTypedField(13, 0);
		return retVal;
    }



    /**
     * Returns
     * GP2-14: "Pay Rate per Service Unit" - creates it if necessary
     */
    public NM getPayRatePerServiceUnit() { 
		NM retVal = this.getTypedField(14, 0);
		return retVal;
    }
    
    /**
     * Returns
     * GP2-14: "Pay Rate per Service Unit" - creates it if necessary
     */
    public NM getGp214_PayRatePerServiceUnit() { 
		NM retVal = this.getTypedField(14, 0);
		return retVal;
    }





    /** {@inheritDoc} */   
    protected Type createNewTypeWithoutReflection(int field) {
       switch (field) {
          case 0: return new IS(getMessage(), new Integer( 456 ));
          case 1: return new NM(getMessage());
          case 2: return new CP(getMessage());
          case 3: return new IS(getMessage(), new Integer( 459 ));
          case 4: return new IS(getMessage(), new Integer( 460 ));
          case 5: return new IS(getMessage(), new Integer( 458 ));
          case 6: return new CE(getMessage());
          case 7: return new IS(getMessage(), new Integer( 467 ));
          case 8: return new IS(getMessage(), new Integer( 468 ));
          case 9: return new IS(getMessage(), new Integer( 469 ));
          case 10: return new CP(getMessage());
          case 11: return new IS(getMessage(), new Integer( 470 ));
          case 12: return new CP(getMessage());
          case 13: return new NM(getMessage());
          default: return null;
       }
   }


}

