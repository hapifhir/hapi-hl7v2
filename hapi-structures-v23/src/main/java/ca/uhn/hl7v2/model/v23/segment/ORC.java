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


package ca.uhn.hl7v2.model.v23.segment;

// import ca.uhn.hl7v2.model.v23.group.*;
import ca.uhn.hl7v2.model.v23.datatype.*;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.parser.DefaultModelClassFactory;
import ca.uhn.hl7v2.model.AbstractMessage;
import ca.uhn.hl7v2.model.Group;
import ca.uhn.hl7v2.model.Type;
import ca.uhn.hl7v2.model.AbstractSegment;
import ca.uhn.hl7v2.model.Varies;


/**
 *<p>Represents an HL7 ORC message segment (Common order segment). 
 * This segment has the following fields:</p>
 * <ul>
     * <li>ORC-1: Order Control (ID) <b> </b>
     * <li>ORC-2: Placer Order Number (EI) <b>optional repeating</b>
     * <li>ORC-3: Filler Order Number (EI) <b>optional </b>
     * <li>ORC-4: Placer Group Number (EI) <b>optional </b>
     * <li>ORC-5: Order Status (ID) <b>optional </b>
     * <li>ORC-6: Response Flag (ID) <b>optional </b>
     * <li>ORC-7: Quantity/Timing (TQ) <b> </b>
     * <li>ORC-8: Parent Order (CM_EIP) <b>optional </b>
     * <li>ORC-9: Date/Time of Transaction (TS) <b>optional </b>
     * <li>ORC-10: Entered By (XCN) <b>optional </b>
     * <li>ORC-11: Verified By (XCN) <b>optional </b>
     * <li>ORC-12: Ordering Provider (XCN) <b>optional repeating</b>
     * <li>ORC-13: Enterer's Location (PL) <b>optional </b>
     * <li>ORC-14: Call Back Phone Number (XTN) <b>optional repeating</b>
     * <li>ORC-15: Order Effective Date/Time (TS) <b>optional </b>
     * <li>ORC-16: Order Control Code Reason (CE) <b>optional </b>
     * <li>ORC-17: Entering Organization (CE) <b>optional </b>
     * <li>ORC-18: Entering Device (CE) <b>optional </b>
     * <li>ORC-19: Action By (XCN) <b>optional </b>
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
                                  this.add(EI.class, false, 0, 22, new Object[]{ getMessage() }, "Placer Order Number");
                                  this.add(EI.class, false, 1, 22, new Object[]{ getMessage() }, "Filler Order Number");
                                  this.add(EI.class, false, 1, 22, new Object[]{ getMessage() }, "Placer Group Number");
                                              this.add(ID.class, false, 1, 2, new Object[]{ getMessage(), new Integer(38) }, "Order Status");
                                              this.add(ID.class, false, 1, 1, new Object[]{ getMessage(), new Integer(121) }, "Response Flag");
                                  this.add(TQ.class, true, 1, 200, new Object[]{ getMessage() }, "Quantity/Timing");
                                  this.add(CM_EIP.class, false, 1, 200, new Object[]{ getMessage() }, "Parent Order");
                                  this.add(TS.class, false, 1, 26, new Object[]{ getMessage() }, "Date/Time of Transaction");
                                  this.add(XCN.class, false, 1, 120, new Object[]{ getMessage() }, "Entered By");
                                  this.add(XCN.class, false, 1, 120, new Object[]{ getMessage() }, "Verified By");
                                  this.add(XCN.class, false, 0, 120, new Object[]{ getMessage() }, "Ordering Provider");
                                  this.add(PL.class, false, 1, 80, new Object[]{ getMessage() }, "Enterer's Location");
                                  this.add(XTN.class, false, 2, 40, new Object[]{ getMessage() }, "Call Back Phone Number");
                                  this.add(TS.class, false, 1, 26, new Object[]{ getMessage() }, "Order Effective Date/Time");
                                  this.add(CE.class, false, 1, 200, new Object[]{ getMessage() }, "Order Control Code Reason");
                                  this.add(CE.class, false, 1, 60, new Object[]{ getMessage() }, "Entering Organization");
                                  this.add(CE.class, false, 1, 60, new Object[]{ getMessage() }, "Entering Device");
                                  this.add(XCN.class, false, 1, 120, new Object[]{ getMessage() }, "Action By");
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
     * Returns all repetitions of Placer Order Number (ORC-2).
     */
    public EI[] getPlacerOrderNumber() {
    	EI[] retVal = this.getTypedField(2, new EI[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Placer Order Number (ORC-2).
     */
    public EI[] getOrc2_PlacerOrderNumber() {
    	EI[] retVal = this.getTypedField(2, new EI[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Placer Order Number (ORC-2).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getPlacerOrderNumberReps() {
    	return this.getReps(2);
    }


    /**
     * Returns a specific repetition of
     * ORC-2: "Placer Order Number" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public EI getPlacerOrderNumber(int rep) { 
		EI retVal = this.getTypedField(2, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * ORC-2: "Placer Order Number" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public EI getOrc2_PlacerOrderNumber(int rep) { 
		EI retVal = this.getTypedField(2, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Placer Order Number (ORC-2).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getOrc2_PlacerOrderNumberReps() {
    	return this.getReps(2);
    }


    /**
     * Inserts a repetition of
     * ORC-2: "Placer Order Number" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public EI insertPlacerOrderNumber(int rep) throws HL7Exception { 
        return (EI) super.insertRepetition(2, rep);
    }


    /**
     * Inserts a repetition of
     * ORC-2: "Placer Order Number" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public EI insertOrc2_PlacerOrderNumber(int rep) throws HL7Exception { 
        return (EI) super.insertRepetition(2, rep);
    }


    /**
     * Removes a repetition of
     * ORC-2: "Placer Order Number" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public EI removePlacerOrderNumber(int rep) throws HL7Exception { 
        return (EI) super.removeRepetition(2, rep);
    }


    /**
     * Removes a repetition of
     * ORC-2: "Placer Order Number" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public EI removeOrc2_PlacerOrderNumber(int rep) throws HL7Exception { 
        return (EI) super.removeRepetition(2, rep);
    }




    /**
     * Returns
     * ORC-3: "Filler Order Number" - creates it if necessary
     */
    public EI getFillerOrderNumber() { 
		EI retVal = this.getTypedField(3, 0);
		return retVal;
    }
    
    /**
     * Returns
     * ORC-3: "Filler Order Number" - creates it if necessary
     */
    public EI getOrc3_FillerOrderNumber() { 
		EI retVal = this.getTypedField(3, 0);
		return retVal;
    }



    /**
     * Returns
     * ORC-4: "Placer Group Number" - creates it if necessary
     */
    public EI getPlacerGroupNumber() { 
		EI retVal = this.getTypedField(4, 0);
		return retVal;
    }
    
    /**
     * Returns
     * ORC-4: "Placer Group Number" - creates it if necessary
     */
    public EI getOrc4_PlacerGroupNumber() { 
		EI retVal = this.getTypedField(4, 0);
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
     * Returns
     * ORC-7: "Quantity/Timing" - creates it if necessary
     */
    public TQ getQuantityTiming() { 
		TQ retVal = this.getTypedField(7, 0);
		return retVal;
    }
    
    /**
     * Returns
     * ORC-7: "Quantity/Timing" - creates it if necessary
     */
    public TQ getOrc7_QuantityTiming() { 
		TQ retVal = this.getTypedField(7, 0);
		return retVal;
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
     * ORC-9: "Date/Time of Transaction" - creates it if necessary
     */
    public TS getDateTimeOfTransaction() { 
		TS retVal = this.getTypedField(9, 0);
		return retVal;
    }
    
    /**
     * Returns
     * ORC-9: "Date/Time of Transaction" - creates it if necessary
     */
    public TS getOrc9_DateTimeOfTransaction() { 
		TS retVal = this.getTypedField(9, 0);
		return retVal;
    }



    /**
     * Returns
     * ORC-10: "Entered By" - creates it if necessary
     */
    public XCN getEnteredBy() { 
		XCN retVal = this.getTypedField(10, 0);
		return retVal;
    }
    
    /**
     * Returns
     * ORC-10: "Entered By" - creates it if necessary
     */
    public XCN getOrc10_EnteredBy() { 
		XCN retVal = this.getTypedField(10, 0);
		return retVal;
    }



    /**
     * Returns
     * ORC-11: "Verified By" - creates it if necessary
     */
    public XCN getVerifiedBy() { 
		XCN retVal = this.getTypedField(11, 0);
		return retVal;
    }
    
    /**
     * Returns
     * ORC-11: "Verified By" - creates it if necessary
     */
    public XCN getOrc11_VerifiedBy() { 
		XCN retVal = this.getTypedField(11, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Ordering Provider (ORC-12).
     */
    public XCN[] getOrderingProvider() {
    	XCN[] retVal = this.getTypedField(12, new XCN[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Ordering Provider (ORC-12).
     */
    public XCN[] getOrc12_OrderingProvider() {
    	XCN[] retVal = this.getTypedField(12, new XCN[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Ordering Provider (ORC-12).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getOrderingProviderReps() {
    	return this.getReps(12);
    }


    /**
     * Returns a specific repetition of
     * ORC-12: "Ordering Provider" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XCN getOrderingProvider(int rep) { 
		XCN retVal = this.getTypedField(12, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * ORC-12: "Ordering Provider" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XCN getOrc12_OrderingProvider(int rep) { 
		XCN retVal = this.getTypedField(12, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Ordering Provider (ORC-12).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getOrc12_OrderingProviderReps() {
    	return this.getReps(12);
    }


    /**
     * Inserts a repetition of
     * ORC-12: "Ordering Provider" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XCN insertOrderingProvider(int rep) throws HL7Exception { 
        return (XCN) super.insertRepetition(12, rep);
    }


    /**
     * Inserts a repetition of
     * ORC-12: "Ordering Provider" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XCN insertOrc12_OrderingProvider(int rep) throws HL7Exception { 
        return (XCN) super.insertRepetition(12, rep);
    }


    /**
     * Removes a repetition of
     * ORC-12: "Ordering Provider" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XCN removeOrderingProvider(int rep) throws HL7Exception { 
        return (XCN) super.removeRepetition(12, rep);
    }


    /**
     * Removes a repetition of
     * ORC-12: "Ordering Provider" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XCN removeOrc12_OrderingProvider(int rep) throws HL7Exception { 
        return (XCN) super.removeRepetition(12, rep);
    }




    /**
     * Returns
     * ORC-13: "Enterer's Location" - creates it if necessary
     */
    public PL getEntererSLocation() { 
		PL retVal = this.getTypedField(13, 0);
		return retVal;
    }
    
    /**
     * Returns
     * ORC-13: "Enterer's Location" - creates it if necessary
     */
    public PL getOrc13_EntererSLocation() { 
		PL retVal = this.getTypedField(13, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Call Back Phone Number (ORC-14).
     */
    public XTN[] getCallBackPhoneNumber() {
    	XTN[] retVal = this.getTypedField(14, new XTN[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Call Back Phone Number (ORC-14).
     */
    public XTN[] getOrc14_CallBackPhoneNumber() {
    	XTN[] retVal = this.getTypedField(14, new XTN[0]);
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
    public XTN getCallBackPhoneNumber(int rep) { 
		XTN retVal = this.getTypedField(14, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * ORC-14: "Call Back Phone Number" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XTN getOrc14_CallBackPhoneNumber(int rep) { 
		XTN retVal = this.getTypedField(14, rep);
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
    public XTN insertCallBackPhoneNumber(int rep) throws HL7Exception { 
        return (XTN) super.insertRepetition(14, rep);
    }


    /**
     * Inserts a repetition of
     * ORC-14: "Call Back Phone Number" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XTN insertOrc14_CallBackPhoneNumber(int rep) throws HL7Exception { 
        return (XTN) super.insertRepetition(14, rep);
    }


    /**
     * Removes a repetition of
     * ORC-14: "Call Back Phone Number" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XTN removeCallBackPhoneNumber(int rep) throws HL7Exception { 
        return (XTN) super.removeRepetition(14, rep);
    }


    /**
     * Removes a repetition of
     * ORC-14: "Call Back Phone Number" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XTN removeOrc14_CallBackPhoneNumber(int rep) throws HL7Exception { 
        return (XTN) super.removeRepetition(14, rep);
    }




    /**
     * Returns
     * ORC-15: "Order Effective Date/Time" - creates it if necessary
     */
    public TS getOrderEffectiveDateTime() { 
		TS retVal = this.getTypedField(15, 0);
		return retVal;
    }
    
    /**
     * Returns
     * ORC-15: "Order Effective Date/Time" - creates it if necessary
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
     * ORC-19: "Action By" - creates it if necessary
     */
    public XCN getActionBy() { 
		XCN retVal = this.getTypedField(19, 0);
		return retVal;
    }
    
    /**
     * Returns
     * ORC-19: "Action By" - creates it if necessary
     */
    public XCN getOrc19_ActionBy() { 
		XCN retVal = this.getTypedField(19, 0);
		return retVal;
    }





    /** {@inheritDoc} */   
    protected Type createNewTypeWithoutReflection(int field) {
       switch (field) {
          case 0: return new ID(getMessage(), new Integer( 119 ));
          case 1: return new EI(getMessage());
          case 2: return new EI(getMessage());
          case 3: return new EI(getMessage());
          case 4: return new ID(getMessage(), new Integer( 38 ));
          case 5: return new ID(getMessage(), new Integer( 121 ));
          case 6: return new TQ(getMessage());
          case 7: return new CM_EIP(getMessage());
          case 8: return new TS(getMessage());
          case 9: return new XCN(getMessage());
          case 10: return new XCN(getMessage());
          case 11: return new XCN(getMessage());
          case 12: return new PL(getMessage());
          case 13: return new XTN(getMessage());
          case 14: return new TS(getMessage());
          case 15: return new CE(getMessage());
          case 16: return new CE(getMessage());
          case 17: return new CE(getMessage());
          case 18: return new XCN(getMessage());
          default: return null;
       }
   }


}

