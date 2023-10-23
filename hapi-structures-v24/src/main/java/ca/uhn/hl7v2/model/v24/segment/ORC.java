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


package ca.uhn.hl7v2.model.v24.segment;

// import ca.uhn.hl7v2.model.v24.group.*;
import ca.uhn.hl7v2.model.v24.datatype.*;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.parser.DefaultModelClassFactory;
import ca.uhn.hl7v2.model.AbstractMessage;
import ca.uhn.hl7v2.model.Group;
import ca.uhn.hl7v2.model.Type;
import ca.uhn.hl7v2.model.AbstractSegment;
import ca.uhn.hl7v2.model.Varies;


/**
 *<p>Represents an HL7 ORC message segment (Common Order). 
 * This segment has the following fields:</p>
 * <ul>
     * <li>ORC-1: Order Control (ID) <b> </b>
     * <li>ORC-2: Placer Order Number (EI) <b>optional </b>
     * <li>ORC-3: Filler Order Number (EI) <b>optional </b>
     * <li>ORC-4: Placer Group Number (EI) <b>optional </b>
     * <li>ORC-5: Order Status (ID) <b>optional </b>
     * <li>ORC-6: Response Flag (ID) <b>optional </b>
     * <li>ORC-7: Quantity/Timing (TQ) <b>optional repeating</b>
     * <li>ORC-8: Parent Order (EIP) <b>optional </b>
     * <li>ORC-9: Date/Time of Transaction (TS) <b>optional </b>
     * <li>ORC-10: Entered By (XCN) <b>optional repeating</b>
     * <li>ORC-11: Verified By (XCN) <b>optional repeating</b>
     * <li>ORC-12: Ordering Provider (XCN) <b>optional repeating</b>
     * <li>ORC-13: Enterer's Location (PL) <b>optional </b>
     * <li>ORC-14: Call Back Phone Number (XTN) <b>optional repeating</b>
     * <li>ORC-15: Order Effective Date/Time (TS) <b>optional </b>
     * <li>ORC-16: Order Control Code Reason (CE) <b>optional </b>
     * <li>ORC-17: Entering Organization (CE) <b>optional </b>
     * <li>ORC-18: Entering Device (CE) <b>optional </b>
     * <li>ORC-19: Action By (XCN) <b>optional repeating</b>
     * <li>ORC-20: Advanced Beneficiary Notice Code (CE) <b>optional </b>
     * <li>ORC-21: Ordering Facility Name (XON) <b>optional repeating</b>
     * <li>ORC-22: Ordering Facility Address (XAD) <b>optional repeating</b>
     * <li>ORC-23: Ordering Facility Phone Number (XTN) <b>optional repeating</b>
     * <li>ORC-24: Ordering Provider Address (XAD) <b>optional repeating</b>
     * <li>ORC-25: Order Status Modifier (CWE) <b>optional </b>
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
                                  this.add(EI.class, false, 1, 22, new Object[]{ getMessage() }, "Placer Order Number");
                                  this.add(EI.class, false, 1, 22, new Object[]{ getMessage() }, "Filler Order Number");
                                  this.add(EI.class, false, 1, 22, new Object[]{ getMessage() }, "Placer Group Number");
                                              this.add(ID.class, false, 1, 2, new Object[]{ getMessage(), new Integer(38) }, "Order Status");
                                              this.add(ID.class, false, 1, 1, new Object[]{ getMessage(), new Integer(121) }, "Response Flag");
                                  this.add(TQ.class, false, 0, 200, new Object[]{ getMessage() }, "Quantity/Timing");
                                  this.add(EIP.class, false, 1, 200, new Object[]{ getMessage() }, "Parent Order");
                                  this.add(TS.class, false, 1, 26, new Object[]{ getMessage() }, "Date/Time of Transaction");
                                  this.add(XCN.class, false, 0, 250, new Object[]{ getMessage() }, "Entered By");
                                  this.add(XCN.class, false, 0, 250, new Object[]{ getMessage() }, "Verified By");
                                  this.add(XCN.class, false, 0, 250, new Object[]{ getMessage() }, "Ordering Provider");
                                  this.add(PL.class, false, 1, 80, new Object[]{ getMessage() }, "Enterer's Location");
                                  this.add(XTN.class, false, 2, 250, new Object[]{ getMessage() }, "Call Back Phone Number");
                                  this.add(TS.class, false, 1, 26, new Object[]{ getMessage() }, "Order Effective Date/Time");
                                  this.add(CE.class, false, 1, 250, new Object[]{ getMessage() }, "Order Control Code Reason");
                                  this.add(CE.class, false, 1, 250, new Object[]{ getMessage() }, "Entering Organization");
                                  this.add(CE.class, false, 1, 250, new Object[]{ getMessage() }, "Entering Device");
                                  this.add(XCN.class, false, 0, 250, new Object[]{ getMessage() }, "Action By");
                                  this.add(CE.class, false, 1, 250, new Object[]{ getMessage() }, "Advanced Beneficiary Notice Code");
                                  this.add(XON.class, false, 0, 250, new Object[]{ getMessage() }, "Ordering Facility Name");
                                  this.add(XAD.class, false, 0, 250, new Object[]{ getMessage() }, "Ordering Facility Address");
                                  this.add(XTN.class, false, 0, 250, new Object[]{ getMessage() }, "Ordering Facility Phone Number");
                                  this.add(XAD.class, false, 0, 250, new Object[]{ getMessage() }, "Ordering Provider Address");
                                  this.add(CWE.class, false, 1, 250, new Object[]{ getMessage() }, "Order Status Modifier");
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
    public EI getPlacerOrderNumber() { 
		EI retVal = this.getTypedField(2, 0);
		return retVal;
    }
    
    /**
     * Returns
     * ORC-2: "Placer Order Number" - creates it if necessary
     */
    public EI getOrc2_PlacerOrderNumber() { 
		EI retVal = this.getTypedField(2, 0);
		return retVal;
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
     * Returns all repetitions of Quantity/Timing (ORC-7).
     */
    public TQ[] getQuantityTiming() {
    	TQ[] retVal = this.getTypedField(7, new TQ[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Quantity/Timing (ORC-7).
     */
    public TQ[] getOrc7_QuantityTiming() {
    	TQ[] retVal = this.getTypedField(7, new TQ[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Quantity/Timing (ORC-7).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getQuantityTimingReps() {
    	return this.getReps(7);
    }


    /**
     * Returns a specific repetition of
     * ORC-7: "Quantity/Timing" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public TQ getQuantityTiming(int rep) { 
		TQ retVal = this.getTypedField(7, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * ORC-7: "Quantity/Timing" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public TQ getOrc7_QuantityTiming(int rep) { 
		TQ retVal = this.getTypedField(7, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Quantity/Timing (ORC-7).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getOrc7_QuantityTimingReps() {
    	return this.getReps(7);
    }


    /**
     * Inserts a repetition of
     * ORC-7: "Quantity/Timing" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public TQ insertQuantityTiming(int rep) throws HL7Exception { 
        return (TQ) super.insertRepetition(7, rep);
    }


    /**
     * Inserts a repetition of
     * ORC-7: "Quantity/Timing" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public TQ insertOrc7_QuantityTiming(int rep) throws HL7Exception { 
        return (TQ) super.insertRepetition(7, rep);
    }


    /**
     * Removes a repetition of
     * ORC-7: "Quantity/Timing" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public TQ removeQuantityTiming(int rep) throws HL7Exception { 
        return (TQ) super.removeRepetition(7, rep);
    }


    /**
     * Removes a repetition of
     * ORC-7: "Quantity/Timing" at a specific index
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
    public EIP getParentOrder() { 
		EIP retVal = this.getTypedField(8, 0);
		return retVal;
    }
    
    /**
     * Returns
     * ORC-8: "Parent Order" - creates it if necessary
     */
    public EIP getOrc8_ParentOrder() { 
		EIP retVal = this.getTypedField(8, 0);
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
     * Returns all repetitions of Entered By (ORC-10).
     */
    public XCN[] getEnteredBy() {
    	XCN[] retVal = this.getTypedField(10, new XCN[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Entered By (ORC-10).
     */
    public XCN[] getOrc10_EnteredBy() {
    	XCN[] retVal = this.getTypedField(10, new XCN[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Entered By (ORC-10).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getEnteredByReps() {
    	return this.getReps(10);
    }


    /**
     * Returns a specific repetition of
     * ORC-10: "Entered By" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XCN getEnteredBy(int rep) { 
		XCN retVal = this.getTypedField(10, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * ORC-10: "Entered By" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XCN getOrc10_EnteredBy(int rep) { 
		XCN retVal = this.getTypedField(10, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Entered By (ORC-10).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getOrc10_EnteredByReps() {
    	return this.getReps(10);
    }


    /**
     * Inserts a repetition of
     * ORC-10: "Entered By" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XCN insertEnteredBy(int rep) throws HL7Exception { 
        return (XCN) super.insertRepetition(10, rep);
    }


    /**
     * Inserts a repetition of
     * ORC-10: "Entered By" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XCN insertOrc10_EnteredBy(int rep) throws HL7Exception { 
        return (XCN) super.insertRepetition(10, rep);
    }


    /**
     * Removes a repetition of
     * ORC-10: "Entered By" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XCN removeEnteredBy(int rep) throws HL7Exception { 
        return (XCN) super.removeRepetition(10, rep);
    }


    /**
     * Removes a repetition of
     * ORC-10: "Entered By" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XCN removeOrc10_EnteredBy(int rep) throws HL7Exception { 
        return (XCN) super.removeRepetition(10, rep);
    }



    /**
     * Returns all repetitions of Verified By (ORC-11).
     */
    public XCN[] getVerifiedBy() {
    	XCN[] retVal = this.getTypedField(11, new XCN[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Verified By (ORC-11).
     */
    public XCN[] getOrc11_VerifiedBy() {
    	XCN[] retVal = this.getTypedField(11, new XCN[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Verified By (ORC-11).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getVerifiedByReps() {
    	return this.getReps(11);
    }


    /**
     * Returns a specific repetition of
     * ORC-11: "Verified By" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XCN getVerifiedBy(int rep) { 
		XCN retVal = this.getTypedField(11, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * ORC-11: "Verified By" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XCN getOrc11_VerifiedBy(int rep) { 
		XCN retVal = this.getTypedField(11, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Verified By (ORC-11).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getOrc11_VerifiedByReps() {
    	return this.getReps(11);
    }


    /**
     * Inserts a repetition of
     * ORC-11: "Verified By" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XCN insertVerifiedBy(int rep) throws HL7Exception { 
        return (XCN) super.insertRepetition(11, rep);
    }


    /**
     * Inserts a repetition of
     * ORC-11: "Verified By" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XCN insertOrc11_VerifiedBy(int rep) throws HL7Exception { 
        return (XCN) super.insertRepetition(11, rep);
    }


    /**
     * Removes a repetition of
     * ORC-11: "Verified By" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XCN removeVerifiedBy(int rep) throws HL7Exception { 
        return (XCN) super.removeRepetition(11, rep);
    }


    /**
     * Removes a repetition of
     * ORC-11: "Verified By" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XCN removeOrc11_VerifiedBy(int rep) throws HL7Exception { 
        return (XCN) super.removeRepetition(11, rep);
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
     * Returns all repetitions of Action By (ORC-19).
     */
    public XCN[] getActionBy() {
    	XCN[] retVal = this.getTypedField(19, new XCN[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Action By (ORC-19).
     */
    public XCN[] getOrc19_ActionBy() {
    	XCN[] retVal = this.getTypedField(19, new XCN[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Action By (ORC-19).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getActionByReps() {
    	return this.getReps(19);
    }


    /**
     * Returns a specific repetition of
     * ORC-19: "Action By" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XCN getActionBy(int rep) { 
		XCN retVal = this.getTypedField(19, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * ORC-19: "Action By" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XCN getOrc19_ActionBy(int rep) { 
		XCN retVal = this.getTypedField(19, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Action By (ORC-19).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getOrc19_ActionByReps() {
    	return this.getReps(19);
    }


    /**
     * Inserts a repetition of
     * ORC-19: "Action By" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XCN insertActionBy(int rep) throws HL7Exception { 
        return (XCN) super.insertRepetition(19, rep);
    }


    /**
     * Inserts a repetition of
     * ORC-19: "Action By" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XCN insertOrc19_ActionBy(int rep) throws HL7Exception { 
        return (XCN) super.insertRepetition(19, rep);
    }


    /**
     * Removes a repetition of
     * ORC-19: "Action By" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XCN removeActionBy(int rep) throws HL7Exception { 
        return (XCN) super.removeRepetition(19, rep);
    }


    /**
     * Removes a repetition of
     * ORC-19: "Action By" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XCN removeOrc19_ActionBy(int rep) throws HL7Exception { 
        return (XCN) super.removeRepetition(19, rep);
    }




    /**
     * Returns
     * ORC-20: "Advanced Beneficiary Notice Code" - creates it if necessary
     */
    public CE getAdvancedBeneficiaryNoticeCode() { 
		CE retVal = this.getTypedField(20, 0);
		return retVal;
    }
    
    /**
     * Returns
     * ORC-20: "Advanced Beneficiary Notice Code" - creates it if necessary
     */
    public CE getOrc20_AdvancedBeneficiaryNoticeCode() { 
		CE retVal = this.getTypedField(20, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Ordering Facility Name (ORC-21).
     */
    public XON[] getOrderingFacilityName() {
    	XON[] retVal = this.getTypedField(21, new XON[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Ordering Facility Name (ORC-21).
     */
    public XON[] getOrc21_OrderingFacilityName() {
    	XON[] retVal = this.getTypedField(21, new XON[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Ordering Facility Name (ORC-21).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getOrderingFacilityNameReps() {
    	return this.getReps(21);
    }


    /**
     * Returns a specific repetition of
     * ORC-21: "Ordering Facility Name" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XON getOrderingFacilityName(int rep) { 
		XON retVal = this.getTypedField(21, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * ORC-21: "Ordering Facility Name" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XON getOrc21_OrderingFacilityName(int rep) { 
		XON retVal = this.getTypedField(21, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Ordering Facility Name (ORC-21).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getOrc21_OrderingFacilityNameReps() {
    	return this.getReps(21);
    }


    /**
     * Inserts a repetition of
     * ORC-21: "Ordering Facility Name" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XON insertOrderingFacilityName(int rep) throws HL7Exception { 
        return (XON) super.insertRepetition(21, rep);
    }


    /**
     * Inserts a repetition of
     * ORC-21: "Ordering Facility Name" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XON insertOrc21_OrderingFacilityName(int rep) throws HL7Exception { 
        return (XON) super.insertRepetition(21, rep);
    }


    /**
     * Removes a repetition of
     * ORC-21: "Ordering Facility Name" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XON removeOrderingFacilityName(int rep) throws HL7Exception { 
        return (XON) super.removeRepetition(21, rep);
    }


    /**
     * Removes a repetition of
     * ORC-21: "Ordering Facility Name" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XON removeOrc21_OrderingFacilityName(int rep) throws HL7Exception { 
        return (XON) super.removeRepetition(21, rep);
    }



    /**
     * Returns all repetitions of Ordering Facility Address (ORC-22).
     */
    public XAD[] getOrderingFacilityAddress() {
    	XAD[] retVal = this.getTypedField(22, new XAD[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Ordering Facility Address (ORC-22).
     */
    public XAD[] getOrc22_OrderingFacilityAddress() {
    	XAD[] retVal = this.getTypedField(22, new XAD[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Ordering Facility Address (ORC-22).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getOrderingFacilityAddressReps() {
    	return this.getReps(22);
    }


    /**
     * Returns a specific repetition of
     * ORC-22: "Ordering Facility Address" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XAD getOrderingFacilityAddress(int rep) { 
		XAD retVal = this.getTypedField(22, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * ORC-22: "Ordering Facility Address" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XAD getOrc22_OrderingFacilityAddress(int rep) { 
		XAD retVal = this.getTypedField(22, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Ordering Facility Address (ORC-22).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getOrc22_OrderingFacilityAddressReps() {
    	return this.getReps(22);
    }


    /**
     * Inserts a repetition of
     * ORC-22: "Ordering Facility Address" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XAD insertOrderingFacilityAddress(int rep) throws HL7Exception { 
        return (XAD) super.insertRepetition(22, rep);
    }


    /**
     * Inserts a repetition of
     * ORC-22: "Ordering Facility Address" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XAD insertOrc22_OrderingFacilityAddress(int rep) throws HL7Exception { 
        return (XAD) super.insertRepetition(22, rep);
    }


    /**
     * Removes a repetition of
     * ORC-22: "Ordering Facility Address" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XAD removeOrderingFacilityAddress(int rep) throws HL7Exception { 
        return (XAD) super.removeRepetition(22, rep);
    }


    /**
     * Removes a repetition of
     * ORC-22: "Ordering Facility Address" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XAD removeOrc22_OrderingFacilityAddress(int rep) throws HL7Exception { 
        return (XAD) super.removeRepetition(22, rep);
    }



    /**
     * Returns all repetitions of Ordering Facility Phone Number (ORC-23).
     */
    public XTN[] getOrderingFacilityPhoneNumber() {
    	XTN[] retVal = this.getTypedField(23, new XTN[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Ordering Facility Phone Number (ORC-23).
     */
    public XTN[] getOrc23_OrderingFacilityPhoneNumber() {
    	XTN[] retVal = this.getTypedField(23, new XTN[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Ordering Facility Phone Number (ORC-23).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getOrderingFacilityPhoneNumberReps() {
    	return this.getReps(23);
    }


    /**
     * Returns a specific repetition of
     * ORC-23: "Ordering Facility Phone Number" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XTN getOrderingFacilityPhoneNumber(int rep) { 
		XTN retVal = this.getTypedField(23, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * ORC-23: "Ordering Facility Phone Number" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XTN getOrc23_OrderingFacilityPhoneNumber(int rep) { 
		XTN retVal = this.getTypedField(23, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Ordering Facility Phone Number (ORC-23).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getOrc23_OrderingFacilityPhoneNumberReps() {
    	return this.getReps(23);
    }


    /**
     * Inserts a repetition of
     * ORC-23: "Ordering Facility Phone Number" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XTN insertOrderingFacilityPhoneNumber(int rep) throws HL7Exception { 
        return (XTN) super.insertRepetition(23, rep);
    }


    /**
     * Inserts a repetition of
     * ORC-23: "Ordering Facility Phone Number" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XTN insertOrc23_OrderingFacilityPhoneNumber(int rep) throws HL7Exception { 
        return (XTN) super.insertRepetition(23, rep);
    }


    /**
     * Removes a repetition of
     * ORC-23: "Ordering Facility Phone Number" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XTN removeOrderingFacilityPhoneNumber(int rep) throws HL7Exception { 
        return (XTN) super.removeRepetition(23, rep);
    }


    /**
     * Removes a repetition of
     * ORC-23: "Ordering Facility Phone Number" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XTN removeOrc23_OrderingFacilityPhoneNumber(int rep) throws HL7Exception { 
        return (XTN) super.removeRepetition(23, rep);
    }



    /**
     * Returns all repetitions of Ordering Provider Address (ORC-24).
     */
    public XAD[] getOrderingProviderAddress() {
    	XAD[] retVal = this.getTypedField(24, new XAD[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Ordering Provider Address (ORC-24).
     */
    public XAD[] getOrc24_OrderingProviderAddress() {
    	XAD[] retVal = this.getTypedField(24, new XAD[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Ordering Provider Address (ORC-24).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getOrderingProviderAddressReps() {
    	return this.getReps(24);
    }


    /**
     * Returns a specific repetition of
     * ORC-24: "Ordering Provider Address" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XAD getOrderingProviderAddress(int rep) { 
		XAD retVal = this.getTypedField(24, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * ORC-24: "Ordering Provider Address" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XAD getOrc24_OrderingProviderAddress(int rep) { 
		XAD retVal = this.getTypedField(24, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Ordering Provider Address (ORC-24).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getOrc24_OrderingProviderAddressReps() {
    	return this.getReps(24);
    }


    /**
     * Inserts a repetition of
     * ORC-24: "Ordering Provider Address" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XAD insertOrderingProviderAddress(int rep) throws HL7Exception { 
        return (XAD) super.insertRepetition(24, rep);
    }


    /**
     * Inserts a repetition of
     * ORC-24: "Ordering Provider Address" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XAD insertOrc24_OrderingProviderAddress(int rep) throws HL7Exception { 
        return (XAD) super.insertRepetition(24, rep);
    }


    /**
     * Removes a repetition of
     * ORC-24: "Ordering Provider Address" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XAD removeOrderingProviderAddress(int rep) throws HL7Exception { 
        return (XAD) super.removeRepetition(24, rep);
    }


    /**
     * Removes a repetition of
     * ORC-24: "Ordering Provider Address" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XAD removeOrc24_OrderingProviderAddress(int rep) throws HL7Exception { 
        return (XAD) super.removeRepetition(24, rep);
    }




    /**
     * Returns
     * ORC-25: "Order Status Modifier" - creates it if necessary
     */
    public CWE getOrderStatusModifier() { 
		CWE retVal = this.getTypedField(25, 0);
		return retVal;
    }
    
    /**
     * Returns
     * ORC-25: "Order Status Modifier" - creates it if necessary
     */
    public CWE getOrc25_OrderStatusModifier() { 
		CWE retVal = this.getTypedField(25, 0);
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
          case 7: return new EIP(getMessage());
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
          case 19: return new CE(getMessage());
          case 20: return new XON(getMessage());
          case 21: return new XAD(getMessage());
          case 22: return new XTN(getMessage());
          case 23: return new XAD(getMessage());
          case 24: return new CWE(getMessage());
          default: return null;
       }
   }


}

