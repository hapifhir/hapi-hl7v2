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


package ca.uhn.hl7v2.model.v22.segment;

// import ca.uhn.hl7v2.model.v22.group.*;
import ca.uhn.hl7v2.model.v22.datatype.*;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.parser.DefaultModelClassFactory;
import ca.uhn.hl7v2.model.AbstractMessage;
import ca.uhn.hl7v2.model.Group;
import ca.uhn.hl7v2.model.Type;
import ca.uhn.hl7v2.model.AbstractSegment;
import ca.uhn.hl7v2.model.Varies;


/**
 *<p>Represents an HL7 ORC message segment (COMMOM ORDER). 
 * This segment has the following fields:</p>
 * <ul>
     * <li>ORC-1: Order Control (ID) <b> </b>
     * <li>ORC-2: Placer Order Number (CM_PLACER) <b>optional </b>
     * <li>ORC-3: Filler Order Number (CM_FILLER) <b>optional </b>
     * <li>ORC-4: Placer Group Number (CM_GROUP_ID) <b>optional </b>
     * <li>ORC-5: Order Status (ID) <b>optional </b>
     * <li>ORC-6: Response Flag (ID) <b>optional </b>
     * <li>ORC-7: Quantity / timing (TQ) <b>optional repeating</b>
     * <li>ORC-8: Parent Order (CM_EIP) <b>optional </b>
     * <li>ORC-9: Date / time of transaction (TS) <b>optional </b>
     * <li>ORC-10: Entered By (CN) <b>optional </b>
     * <li>ORC-11: Verified By (CN) <b>optional </b>
     * <li>ORC-12: Ordering Provider (CN) <b>optional </b>
     * <li>ORC-13: Enterer's Location (CM_PARENT_RESULT) <b>optional </b>
     * <li>ORC-14: Call Back Phone Number (TN) <b>optional repeating</b>
     * <li>ORC-15: Order effective date / time (TS) <b>optional </b>
     * <li>ORC-16: Order Control Code Reason (CE) <b>optional </b>
     * <li>ORC-17: Entering Organization (CE) <b>optional </b>
     * <li>ORC-18: Entering Device (CE) <b>optional </b>
     * <li>ORC-19: Action by (CN) <b>optional </b>
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
                                              this.add(ID.class, true, 1, 2, new Object[]{ getMessage(), new Integer(119) }, "Order Control");
                                  this.add(CM_PLACER.class, false, 1, 75, new Object[]{ getMessage() }, "Placer Order Number");
                                  this.add(CM_FILLER.class, false, 1, 75, new Object[]{ getMessage() }, "Filler Order Number");
                                  this.add(CM_GROUP_ID.class, false, 1, 75, new Object[]{ getMessage() }, "Placer Group Number");
                                              this.add(ID.class, false, 1, 2, new Object[]{ getMessage(), new Integer(38) }, "Order Status");
                                              this.add(ID.class, false, 1, 1, new Object[]{ getMessage(), new Integer(121) }, "Response Flag");
                                  this.add(TQ.class, false, 0, 200, new Object[]{ getMessage() }, "Quantity / timing");
                                  this.add(CM_EIP.class, false, 1, 200, new Object[]{ getMessage() }, "Parent Order");
                                  this.add(TS.class, false, 1, 26, new Object[]{ getMessage() }, "Date / time of transaction");
                                  this.add(CN.class, false, 1, 80, new Object[]{ getMessage() }, "Entered By");
                                  this.add(CN.class, false, 1, 80, new Object[]{ getMessage() }, "Verified By");
                                  this.add(CN.class, false, 1, 80, new Object[]{ getMessage() }, "Ordering Provider");
                                  this.add(CM_PARENT_RESULT.class, false, 1, 80, new Object[]{ getMessage() }, "Enterer's Location");
                                  this.add(TN.class, false, 2, 40, new Object[]{ getMessage() }, "Call Back Phone Number");
                                  this.add(TS.class, false, 1, 26, new Object[]{ getMessage() }, "Order effective date / time");
                                  this.add(CE.class, false, 1, 200, new Object[]{ getMessage() }, "Order Control Code Reason");
                                  this.add(CE.class, false, 1, 60, new Object[]{ getMessage() }, "Entering Organization");
                                  this.add(CE.class, false, 1, 60, new Object[]{ getMessage() }, "Entering Device");
                                  this.add(CN.class, false, 1, 80, new Object[]{ getMessage() }, "Action by");
       } catch(HL7Exception e) {
          log.error("Unexpected error creating ORC - this is probably a bug in the source code generator.", e);
       }
    }



    /**
     * Returns
     * ORC-1: "Order Control" - creates it if necessary
     */
    public ID getOrderControl() { 
		ID retVal = this.getTypedField(1, 0);
		return retVal;
    }
    
    /**
     * Returns
     * ORC-1: "Order Control" - creates it if necessary
     */
    public ID getOrc1_OrderControl() { 
		ID retVal = this.getTypedField(1, 0);
		return retVal;
    }



    /**
     * Returns
     * ORC-2: "Placer Order Number" - creates it if necessary
     */
    public CM_PLACER getPlacerOrderNumber() { 
		CM_PLACER retVal = this.getTypedField(2, 0);
		return retVal;
    }
    
    /**
     * Returns
     * ORC-2: "Placer Order Number" - creates it if necessary
     */
    public CM_PLACER getOrc2_PlacerOrderNumber() { 
		CM_PLACER retVal = this.getTypedField(2, 0);
		return retVal;
    }



    /**
     * Returns
     * ORC-3: "Filler Order Number" - creates it if necessary
     */
    public CM_FILLER getFillerOrderNumber() { 
		CM_FILLER retVal = this.getTypedField(3, 0);
		return retVal;
    }
    
    /**
     * Returns
     * ORC-3: "Filler Order Number" - creates it if necessary
     */
    public CM_FILLER getOrc3_FillerOrderNumber() { 
		CM_FILLER retVal = this.getTypedField(3, 0);
		return retVal;
    }



    /**
     * Returns
     * ORC-4: "Placer Group Number" - creates it if necessary
     */
    public CM_GROUP_ID getPlacerGroupNumber() { 
		CM_GROUP_ID retVal = this.getTypedField(4, 0);
		return retVal;
    }
    
    /**
     * Returns
     * ORC-4: "Placer Group Number" - creates it if necessary
     */
    public CM_GROUP_ID getOrc4_PlacerGroupNumber() { 
		CM_GROUP_ID retVal = this.getTypedField(4, 0);
		return retVal;
    }



    /**
     * Returns
     * ORC-5: "Order Status" - creates it if necessary
     */
    public ID getOrderStatus() { 
		ID retVal = this.getTypedField(5, 0);
		return retVal;
    }
    
    /**
     * Returns
     * ORC-5: "Order Status" - creates it if necessary
     */
    public ID getOrc5_OrderStatus() { 
		ID retVal = this.getTypedField(5, 0);
		return retVal;
    }



    /**
     * Returns
     * ORC-6: "Response Flag" - creates it if necessary
     */
    public ID getResponseFlag() { 
		ID retVal = this.getTypedField(6, 0);
		return retVal;
    }
    
    /**
     * Returns
     * ORC-6: "Response Flag" - creates it if necessary
     */
    public ID getOrc6_ResponseFlag() { 
		ID retVal = this.getTypedField(6, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Quantity / timing (ORC-7).
     */
    public TQ[] getQuantityTiming() {
    	TQ[] retVal = this.getTypedField(7, new TQ[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Quantity / timing (ORC-7).
     */
    public TQ[] getOrc7_QuantityTiming() {
    	TQ[] retVal = this.getTypedField(7, new TQ[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Quantity / timing (ORC-7).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getQuantityTimingReps() {
    	return this.getReps(7);
    }


    /**
     * Returns a specific repetition of
     * ORC-7: "Quantity / timing" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public TQ getQuantityTiming(int rep) { 
		TQ retVal = this.getTypedField(7, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * ORC-7: "Quantity / timing" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public TQ getOrc7_QuantityTiming(int rep) { 
		TQ retVal = this.getTypedField(7, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Quantity / timing (ORC-7).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getOrc7_QuantityTimingReps() {
    	return this.getReps(7);
    }


    /**
     * Inserts a repetition of
     * ORC-7: "Quantity / timing" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public TQ insertQuantityTiming(int rep) throws HL7Exception { 
        return (TQ) super.insertRepetition(7, rep);
    }


    /**
     * Inserts a repetition of
     * ORC-7: "Quantity / timing" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public TQ insertOrc7_QuantityTiming(int rep) throws HL7Exception { 
        return (TQ) super.insertRepetition(7, rep);
    }


    /**
     * Removes a repetition of
     * ORC-7: "Quantity / timing" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public TQ removeQuantityTiming(int rep) throws HL7Exception { 
        return (TQ) super.removeRepetition(7, rep);
    }


    /**
     * Removes a repetition of
     * ORC-7: "Quantity / timing" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public TQ removeOrc7_QuantityTiming(int rep) throws HL7Exception { 
        return (TQ) super.removeRepetition(7, rep);
    }




    /**
     * Returns
     * ORC-8: "Parent Order" - creates it if necessary
     */
    public CM_EIP getParentOrder() { 
		CM_EIP retVal = this.getTypedField(8, 0);
		return retVal;
    }
    
    /**
     * Returns
     * ORC-8: "Parent Order" - creates it if necessary
     */
    public CM_EIP getOrc8_ParentOrder() { 
		CM_EIP retVal = this.getTypedField(8, 0);
		return retVal;
    }



    /**
     * Returns
     * ORC-9: "Date / time of transaction" - creates it if necessary
     */
    public TS getDateTimeOfTransaction() { 
		TS retVal = this.getTypedField(9, 0);
		return retVal;
    }
    
    /**
     * Returns
     * ORC-9: "Date / time of transaction" - creates it if necessary
     */
    public TS getOrc9_DateTimeOfTransaction() { 
		TS retVal = this.getTypedField(9, 0);
		return retVal;
    }



    /**
     * Returns
     * ORC-10: "Entered By" - creates it if necessary
     */
    public CN getEnteredBy() { 
		CN retVal = this.getTypedField(10, 0);
		return retVal;
    }
    
    /**
     * Returns
     * ORC-10: "Entered By" - creates it if necessary
     */
    public CN getOrc10_EnteredBy() { 
		CN retVal = this.getTypedField(10, 0);
		return retVal;
    }



    /**
     * Returns
     * ORC-11: "Verified By" - creates it if necessary
     */
    public CN getVerifiedBy() { 
		CN retVal = this.getTypedField(11, 0);
		return retVal;
    }
    
    /**
     * Returns
     * ORC-11: "Verified By" - creates it if necessary
     */
    public CN getOrc11_VerifiedBy() { 
		CN retVal = this.getTypedField(11, 0);
		return retVal;
    }



    /**
     * Returns
     * ORC-12: "Ordering Provider" - creates it if necessary
     */
    public CN getOrderingProvider() { 
		CN retVal = this.getTypedField(12, 0);
		return retVal;
    }
    
    /**
     * Returns
     * ORC-12: "Ordering Provider" - creates it if necessary
     */
    public CN getOrc12_OrderingProvider() { 
		CN retVal = this.getTypedField(12, 0);
		return retVal;
    }



    /**
     * Returns
     * ORC-13: "Enterer's Location" - creates it if necessary
     */
    public CM_PARENT_RESULT getEntererSLocation() { 
		CM_PARENT_RESULT retVal = this.getTypedField(13, 0);
		return retVal;
    }
    
    /**
     * Returns
     * ORC-13: "Enterer's Location" - creates it if necessary
     */
    public CM_PARENT_RESULT getOrc13_EntererSLocation() { 
		CM_PARENT_RESULT retVal = this.getTypedField(13, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Call Back Phone Number (ORC-14).
     */
    public TN[] getCallBackPhoneNumber() {
    	TN[] retVal = this.getTypedField(14, new TN[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Call Back Phone Number (ORC-14).
     */
    public TN[] getOrc14_CallBackPhoneNumber() {
    	TN[] retVal = this.getTypedField(14, new TN[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Call Back Phone Number (ORC-14).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getCallBackPhoneNumberReps() {
    	return this.getReps(14);
    }


    /**
     * Returns a specific repetition of
     * ORC-14: "Call Back Phone Number" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public TN getCallBackPhoneNumber(int rep) { 
		TN retVal = this.getTypedField(14, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * ORC-14: "Call Back Phone Number" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public TN getOrc14_CallBackPhoneNumber(int rep) { 
		TN retVal = this.getTypedField(14, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Call Back Phone Number (ORC-14).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getOrc14_CallBackPhoneNumberReps() {
    	return this.getReps(14);
    }


    /**
     * Inserts a repetition of
     * ORC-14: "Call Back Phone Number" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public TN insertCallBackPhoneNumber(int rep) throws HL7Exception { 
        return (TN) super.insertRepetition(14, rep);
    }


    /**
     * Inserts a repetition of
     * ORC-14: "Call Back Phone Number" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public TN insertOrc14_CallBackPhoneNumber(int rep) throws HL7Exception { 
        return (TN) super.insertRepetition(14, rep);
    }


    /**
     * Removes a repetition of
     * ORC-14: "Call Back Phone Number" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public TN removeCallBackPhoneNumber(int rep) throws HL7Exception { 
        return (TN) super.removeRepetition(14, rep);
    }


    /**
     * Removes a repetition of
     * ORC-14: "Call Back Phone Number" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public TN removeOrc14_CallBackPhoneNumber(int rep) throws HL7Exception { 
        return (TN) super.removeRepetition(14, rep);
    }




    /**
     * Returns
     * ORC-15: "Order effective date / time" - creates it if necessary
     */
    public TS getOrderEffectiveDateTime() { 
		TS retVal = this.getTypedField(15, 0);
		return retVal;
    }
    
    /**
     * Returns
     * ORC-15: "Order effective date / time" - creates it if necessary
     */
    public TS getOrc15_OrderEffectiveDateTime() { 
		TS retVal = this.getTypedField(15, 0);
		return retVal;
    }



    /**
     * Returns
     * ORC-16: "Order Control Code Reason" - creates it if necessary
     */
    public CE getOrderControlCodeReason() { 
		CE retVal = this.getTypedField(16, 0);
		return retVal;
    }
    
    /**
     * Returns
     * ORC-16: "Order Control Code Reason" - creates it if necessary
     */
    public CE getOrc16_OrderControlCodeReason() { 
		CE retVal = this.getTypedField(16, 0);
		return retVal;
    }



    /**
     * Returns
     * ORC-17: "Entering Organization" - creates it if necessary
     */
    public CE getEnteringOrganization() { 
		CE retVal = this.getTypedField(17, 0);
		return retVal;
    }
    
    /**
     * Returns
     * ORC-17: "Entering Organization" - creates it if necessary
     */
    public CE getOrc17_EnteringOrganization() { 
		CE retVal = this.getTypedField(17, 0);
		return retVal;
    }



    /**
     * Returns
     * ORC-18: "Entering Device" - creates it if necessary
     */
    public CE getEnteringDevice() { 
		CE retVal = this.getTypedField(18, 0);
		return retVal;
    }
    
    /**
     * Returns
     * ORC-18: "Entering Device" - creates it if necessary
     */
    public CE getOrc18_EnteringDevice() { 
		CE retVal = this.getTypedField(18, 0);
		return retVal;
    }



    /**
     * Returns
     * ORC-19: "Action by" - creates it if necessary
     */
    public CN getActionBy() { 
		CN retVal = this.getTypedField(19, 0);
		return retVal;
    }
    
    /**
     * Returns
     * ORC-19: "Action by" - creates it if necessary
     */
    public CN getOrc19_ActionBy() { 
		CN retVal = this.getTypedField(19, 0);
		return retVal;
    }





    /** {@inheritDoc} */   
    protected Type createNewTypeWithoutReflection(int field) {
       switch (field) {
          case 0: return new ID(getMessage(), new Integer( 119 ));
          case 1: return new CM_PLACER(getMessage());
          case 2: return new CM_FILLER(getMessage());
          case 3: return new CM_GROUP_ID(getMessage());
          case 4: return new ID(getMessage(), new Integer( 38 ));
          case 5: return new ID(getMessage(), new Integer( 121 ));
          case 6: return new TQ(getMessage());
          case 7: return new CM_EIP(getMessage());
          case 8: return new TS(getMessage());
          case 9: return new CN(getMessage());
          case 10: return new CN(getMessage());
          case 11: return new CN(getMessage());
          case 12: return new CM_PARENT_RESULT(getMessage());
          case 13: return new TN(getMessage());
          case 14: return new TS(getMessage());
          case 15: return new CE(getMessage());
          case 16: return new CE(getMessage());
          case 17: return new CE(getMessage());
          case 18: return new CN(getMessage());
          default: return null;
       }
   }


}

