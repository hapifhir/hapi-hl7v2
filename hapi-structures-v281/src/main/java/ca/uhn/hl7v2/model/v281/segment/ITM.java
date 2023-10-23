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


package ca.uhn.hl7v2.model.v281.segment;

// import ca.uhn.hl7v2.model.v281.group.*;
import ca.uhn.hl7v2.model.v281.datatype.*;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.parser.DefaultModelClassFactory;
import ca.uhn.hl7v2.model.AbstractMessage;
import ca.uhn.hl7v2.model.Group;
import ca.uhn.hl7v2.model.Type;
import ca.uhn.hl7v2.model.AbstractSegment;
import ca.uhn.hl7v2.model.Varies;


/**
 *<p>Represents an HL7 ITM message segment (Material Item). 
 * This segment has the following fields:</p>
 * <ul>
     * <li>ITM-1: Item Identifier (EI) <b> </b>
     * <li>ITM-2: Item Description (ST) <b>optional </b>
     * <li>ITM-3: Item Status (CWE) <b>optional </b>
     * <li>ITM-4: Item Type (CWE) <b>optional </b>
     * <li>ITM-5: Item Category (CWE) <b>optional </b>
     * <li>ITM-6: Subject to Expiration Indicator (CNE) <b>optional </b>
     * <li>ITM-7: Manufacturer Identifier (EI) <b>optional </b>
     * <li>ITM-8: Manufacturer Name (ST) <b>optional </b>
     * <li>ITM-9: Manufacturer Catalog Number (ST) <b>optional </b>
     * <li>ITM-10: Manufacturer Labeler Identification Code (CWE) <b>optional </b>
     * <li>ITM-11: Patient Chargeable Indicator (CNE) <b>optional </b>
     * <li>ITM-12: Transaction Code (CWE) <b>optional </b>
     * <li>ITM-13: Transaction amount - unit (CP) <b>optional </b>
     * <li>ITM-14: Stocked Item Indicator (CNE) <b>optional </b>
     * <li>ITM-15: Supply Risk Codes (CWE) <b>optional </b>
     * <li>ITM-16: Approving Regulatory Agency (XON) <b>optional repeating</b>
     * <li>ITM-17: Latex Indicator (CNE) <b>optional </b>
     * <li>ITM-18: Ruling Act (CWE) <b>optional repeating</b>
     * <li>ITM-19: Item Natural Account Code (CWE) <b>optional </b>
     * <li>ITM-20: Approved To Buy Quantity (NM) <b>optional </b>
     * <li>ITM-21: Approved To Buy Price (MO) <b>optional </b>
     * <li>ITM-22: Taxable Item Indicator (CNE) <b>optional </b>
     * <li>ITM-23: Freight Charge Indicator (CNE) <b>optional </b>
     * <li>ITM-24: Item Set Indicator (CNE) <b>optional </b>
     * <li>ITM-25: Item Set Identifier (EI) <b>optional </b>
     * <li>ITM-26: Track Department Usage Indicator (CNE) <b>optional </b>
     * <li>ITM-27: Procedure Code (CNE) <b>optional </b>
     * <li>ITM-28: Procedure Code Modifier (CNE) <b>optional repeating</b>
     * <li>ITM-29: Special Handling Code (CWE) <b>optional </b>
     * <li>ITM-30: Hazardous Indicator (CNE) <b>optional </b>
     * <li>ITM-31: Sterile Indicator (CNE) <b>optional </b>
     * <li>ITM-32: Material Data Safety Sheet Number (EI) <b>optional </b>
     * <li>ITM-33: United Nations Standard Products and Services Code (UNSPSC) (CWE) <b>optional </b>
 * </ul>
 */
@SuppressWarnings("unused")
public class ITM extends AbstractSegment {

    /** 
     * Creates a new ITM segment
     */
    public ITM(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(EI.class, true, 1, 0, new Object[]{ getMessage() }, "Item Identifier");
                                  this.add(ST.class, false, 1, 0, new Object[]{ getMessage() }, "Item Description");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "Item Status");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "Item Type");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "Item Category");
                                  this.add(CNE.class, false, 1, 0, new Object[]{ getMessage() }, "Subject to Expiration Indicator");
                                  this.add(EI.class, false, 1, 0, new Object[]{ getMessage() }, "Manufacturer Identifier");
                                  this.add(ST.class, false, 1, 0, new Object[]{ getMessage() }, "Manufacturer Name");
                                  this.add(ST.class, false, 1, 0, new Object[]{ getMessage() }, "Manufacturer Catalog Number");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "Manufacturer Labeler Identification Code");
                                  this.add(CNE.class, false, 1, 0, new Object[]{ getMessage() }, "Patient Chargeable Indicator");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "Transaction Code");
                                  this.add(CP.class, false, 1, 0, new Object[]{ getMessage() }, "Transaction amount - unit");
                                  this.add(CNE.class, false, 1, 0, new Object[]{ getMessage() }, "Stocked Item Indicator");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "Supply Risk Codes");
                                  this.add(XON.class, false, 0, 0, new Object[]{ getMessage() }, "Approving Regulatory Agency");
                                  this.add(CNE.class, false, 1, 0, new Object[]{ getMessage() }, "Latex Indicator");
                                  this.add(CWE.class, false, 0, 0, new Object[]{ getMessage() }, "Ruling Act");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "Item Natural Account Code");
                                  this.add(NM.class, false, 1, 0, new Object[]{ getMessage() }, "Approved To Buy Quantity");
                                  this.add(MO.class, false, 1, 0, new Object[]{ getMessage() }, "Approved To Buy Price");
                                  this.add(CNE.class, false, 1, 0, new Object[]{ getMessage() }, "Taxable Item Indicator");
                                  this.add(CNE.class, false, 1, 0, new Object[]{ getMessage() }, "Freight Charge Indicator");
                                  this.add(CNE.class, false, 1, 0, new Object[]{ getMessage() }, "Item Set Indicator");
                                  this.add(EI.class, false, 1, 0, new Object[]{ getMessage() }, "Item Set Identifier");
                                  this.add(CNE.class, false, 1, 0, new Object[]{ getMessage() }, "Track Department Usage Indicator");
                                  this.add(CNE.class, false, 1, 0, new Object[]{ getMessage() }, "Procedure Code");
                                  this.add(CNE.class, false, 0, 0, new Object[]{ getMessage() }, "Procedure Code Modifier");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "Special Handling Code");
                                  this.add(CNE.class, false, 1, 0, new Object[]{ getMessage() }, "Hazardous Indicator");
                                  this.add(CNE.class, false, 1, 0, new Object[]{ getMessage() }, "Sterile Indicator");
                                  this.add(EI.class, false, 1, 0, new Object[]{ getMessage() }, "Material Data Safety Sheet Number");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "United Nations Standard Products and Services Code (UNSPSC)");
       } catch(HL7Exception e) {
          log.error("Unexpected error creating ITM - this is probably a bug in the source code generator.", e);
       }
    }



    /**
     * Returns
     * ITM-1: "Item Identifier" - creates it if necessary
     */
    public EI getItemIdentifier() { 
		EI retVal = this.getTypedField(1, 0);
		return retVal;
    }
    
    /**
     * Returns
     * ITM-1: "Item Identifier" - creates it if necessary
     */
    public EI getItm1_ItemIdentifier() { 
		EI retVal = this.getTypedField(1, 0);
		return retVal;
    }



    /**
     * Returns
     * ITM-2: "Item Description" - creates it if necessary
     */
    public ST getItemDescription() { 
		ST retVal = this.getTypedField(2, 0);
		return retVal;
    }
    
    /**
     * Returns
     * ITM-2: "Item Description" - creates it if necessary
     */
    public ST getItm2_ItemDescription() { 
		ST retVal = this.getTypedField(2, 0);
		return retVal;
    }



    /**
     * Returns
     * ITM-3: "Item Status" - creates it if necessary
     */
    public CWE getItemStatus() { 
		CWE retVal = this.getTypedField(3, 0);
		return retVal;
    }
    
    /**
     * Returns
     * ITM-3: "Item Status" - creates it if necessary
     */
    public CWE getItm3_ItemStatus() { 
		CWE retVal = this.getTypedField(3, 0);
		return retVal;
    }



    /**
     * Returns
     * ITM-4: "Item Type" - creates it if necessary
     */
    public CWE getItemType() { 
		CWE retVal = this.getTypedField(4, 0);
		return retVal;
    }
    
    /**
     * Returns
     * ITM-4: "Item Type" - creates it if necessary
     */
    public CWE getItm4_ItemType() { 
		CWE retVal = this.getTypedField(4, 0);
		return retVal;
    }



    /**
     * Returns
     * ITM-5: "Item Category" - creates it if necessary
     */
    public CWE getItemCategory() { 
		CWE retVal = this.getTypedField(5, 0);
		return retVal;
    }
    
    /**
     * Returns
     * ITM-5: "Item Category" - creates it if necessary
     */
    public CWE getItm5_ItemCategory() { 
		CWE retVal = this.getTypedField(5, 0);
		return retVal;
    }



    /**
     * Returns
     * ITM-6: "Subject to Expiration Indicator" - creates it if necessary
     */
    public CNE getSubjectToExpirationIndicator() { 
		CNE retVal = this.getTypedField(6, 0);
		return retVal;
    }
    
    /**
     * Returns
     * ITM-6: "Subject to Expiration Indicator" - creates it if necessary
     */
    public CNE getItm6_SubjectToExpirationIndicator() { 
		CNE retVal = this.getTypedField(6, 0);
		return retVal;
    }



    /**
     * Returns
     * ITM-7: "Manufacturer Identifier" - creates it if necessary
     */
    public EI getManufacturerIdentifier() { 
		EI retVal = this.getTypedField(7, 0);
		return retVal;
    }
    
    /**
     * Returns
     * ITM-7: "Manufacturer Identifier" - creates it if necessary
     */
    public EI getItm7_ManufacturerIdentifier() { 
		EI retVal = this.getTypedField(7, 0);
		return retVal;
    }



    /**
     * Returns
     * ITM-8: "Manufacturer Name" - creates it if necessary
     */
    public ST getManufacturerName() { 
		ST retVal = this.getTypedField(8, 0);
		return retVal;
    }
    
    /**
     * Returns
     * ITM-8: "Manufacturer Name" - creates it if necessary
     */
    public ST getItm8_ManufacturerName() { 
		ST retVal = this.getTypedField(8, 0);
		return retVal;
    }



    /**
     * Returns
     * ITM-9: "Manufacturer Catalog Number" - creates it if necessary
     */
    public ST getManufacturerCatalogNumber() { 
		ST retVal = this.getTypedField(9, 0);
		return retVal;
    }
    
    /**
     * Returns
     * ITM-9: "Manufacturer Catalog Number" - creates it if necessary
     */
    public ST getItm9_ManufacturerCatalogNumber() { 
		ST retVal = this.getTypedField(9, 0);
		return retVal;
    }



    /**
     * Returns
     * ITM-10: "Manufacturer Labeler Identification Code" - creates it if necessary
     */
    public CWE getManufacturerLabelerIdentificationCode() { 
		CWE retVal = this.getTypedField(10, 0);
		return retVal;
    }
    
    /**
     * Returns
     * ITM-10: "Manufacturer Labeler Identification Code" - creates it if necessary
     */
    public CWE getItm10_ManufacturerLabelerIdentificationCode() { 
		CWE retVal = this.getTypedField(10, 0);
		return retVal;
    }



    /**
     * Returns
     * ITM-11: "Patient Chargeable Indicator" - creates it if necessary
     */
    public CNE getPatientChargeableIndicator() { 
		CNE retVal = this.getTypedField(11, 0);
		return retVal;
    }
    
    /**
     * Returns
     * ITM-11: "Patient Chargeable Indicator" - creates it if necessary
     */
    public CNE getItm11_PatientChargeableIndicator() { 
		CNE retVal = this.getTypedField(11, 0);
		return retVal;
    }



    /**
     * Returns
     * ITM-12: "Transaction Code" - creates it if necessary
     */
    public CWE getTransactionCode() { 
		CWE retVal = this.getTypedField(12, 0);
		return retVal;
    }
    
    /**
     * Returns
     * ITM-12: "Transaction Code" - creates it if necessary
     */
    public CWE getItm12_TransactionCode() { 
		CWE retVal = this.getTypedField(12, 0);
		return retVal;
    }



    /**
     * Returns
     * ITM-13: "Transaction amount - unit" - creates it if necessary
     */
    public CP getTransactionAmountUnit() { 
		CP retVal = this.getTypedField(13, 0);
		return retVal;
    }
    
    /**
     * Returns
     * ITM-13: "Transaction amount - unit" - creates it if necessary
     */
    public CP getItm13_TransactionAmountUnit() { 
		CP retVal = this.getTypedField(13, 0);
		return retVal;
    }



    /**
     * Returns
     * ITM-14: "Stocked Item Indicator" - creates it if necessary
     */
    public CNE getStockedItemIndicator() { 
		CNE retVal = this.getTypedField(14, 0);
		return retVal;
    }
    
    /**
     * Returns
     * ITM-14: "Stocked Item Indicator" - creates it if necessary
     */
    public CNE getItm14_StockedItemIndicator() { 
		CNE retVal = this.getTypedField(14, 0);
		return retVal;
    }



    /**
     * Returns
     * ITM-15: "Supply Risk Codes" - creates it if necessary
     */
    public CWE getSupplyRiskCodes() { 
		CWE retVal = this.getTypedField(15, 0);
		return retVal;
    }
    
    /**
     * Returns
     * ITM-15: "Supply Risk Codes" - creates it if necessary
     */
    public CWE getItm15_SupplyRiskCodes() { 
		CWE retVal = this.getTypedField(15, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Approving Regulatory Agency (ITM-16).
     */
    public XON[] getApprovingRegulatoryAgency() {
    	XON[] retVal = this.getTypedField(16, new XON[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Approving Regulatory Agency (ITM-16).
     */
    public XON[] getItm16_ApprovingRegulatoryAgency() {
    	XON[] retVal = this.getTypedField(16, new XON[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Approving Regulatory Agency (ITM-16).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getApprovingRegulatoryAgencyReps() {
    	return this.getReps(16);
    }


    /**
     * Returns a specific repetition of
     * ITM-16: "Approving Regulatory Agency" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XON getApprovingRegulatoryAgency(int rep) { 
		XON retVal = this.getTypedField(16, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * ITM-16: "Approving Regulatory Agency" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XON getItm16_ApprovingRegulatoryAgency(int rep) { 
		XON retVal = this.getTypedField(16, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Approving Regulatory Agency (ITM-16).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getItm16_ApprovingRegulatoryAgencyReps() {
    	return this.getReps(16);
    }


    /**
     * Inserts a repetition of
     * ITM-16: "Approving Regulatory Agency" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XON insertApprovingRegulatoryAgency(int rep) throws HL7Exception { 
        return (XON) super.insertRepetition(16, rep);
    }


    /**
     * Inserts a repetition of
     * ITM-16: "Approving Regulatory Agency" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XON insertItm16_ApprovingRegulatoryAgency(int rep) throws HL7Exception { 
        return (XON) super.insertRepetition(16, rep);
    }


    /**
     * Removes a repetition of
     * ITM-16: "Approving Regulatory Agency" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XON removeApprovingRegulatoryAgency(int rep) throws HL7Exception { 
        return (XON) super.removeRepetition(16, rep);
    }


    /**
     * Removes a repetition of
     * ITM-16: "Approving Regulatory Agency" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XON removeItm16_ApprovingRegulatoryAgency(int rep) throws HL7Exception { 
        return (XON) super.removeRepetition(16, rep);
    }




    /**
     * Returns
     * ITM-17: "Latex Indicator" - creates it if necessary
     */
    public CNE getLatexIndicator() { 
		CNE retVal = this.getTypedField(17, 0);
		return retVal;
    }
    
    /**
     * Returns
     * ITM-17: "Latex Indicator" - creates it if necessary
     */
    public CNE getItm17_LatexIndicator() { 
		CNE retVal = this.getTypedField(17, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Ruling Act (ITM-18).
     */
    public CWE[] getRulingAct() {
    	CWE[] retVal = this.getTypedField(18, new CWE[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Ruling Act (ITM-18).
     */
    public CWE[] getItm18_RulingAct() {
    	CWE[] retVal = this.getTypedField(18, new CWE[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Ruling Act (ITM-18).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getRulingActReps() {
    	return this.getReps(18);
    }


    /**
     * Returns a specific repetition of
     * ITM-18: "Ruling Act" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CWE getRulingAct(int rep) { 
		CWE retVal = this.getTypedField(18, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * ITM-18: "Ruling Act" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CWE getItm18_RulingAct(int rep) { 
		CWE retVal = this.getTypedField(18, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Ruling Act (ITM-18).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getItm18_RulingActReps() {
    	return this.getReps(18);
    }


    /**
     * Inserts a repetition of
     * ITM-18: "Ruling Act" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE insertRulingAct(int rep) throws HL7Exception { 
        return (CWE) super.insertRepetition(18, rep);
    }


    /**
     * Inserts a repetition of
     * ITM-18: "Ruling Act" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE insertItm18_RulingAct(int rep) throws HL7Exception { 
        return (CWE) super.insertRepetition(18, rep);
    }


    /**
     * Removes a repetition of
     * ITM-18: "Ruling Act" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE removeRulingAct(int rep) throws HL7Exception { 
        return (CWE) super.removeRepetition(18, rep);
    }


    /**
     * Removes a repetition of
     * ITM-18: "Ruling Act" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE removeItm18_RulingAct(int rep) throws HL7Exception { 
        return (CWE) super.removeRepetition(18, rep);
    }




    /**
     * Returns
     * ITM-19: "Item Natural Account Code" - creates it if necessary
     */
    public CWE getItemNaturalAccountCode() { 
		CWE retVal = this.getTypedField(19, 0);
		return retVal;
    }
    
    /**
     * Returns
     * ITM-19: "Item Natural Account Code" - creates it if necessary
     */
    public CWE getItm19_ItemNaturalAccountCode() { 
		CWE retVal = this.getTypedField(19, 0);
		return retVal;
    }



    /**
     * Returns
     * ITM-20: "Approved To Buy Quantity" - creates it if necessary
     */
    public NM getApprovedToBuyQuantity() { 
		NM retVal = this.getTypedField(20, 0);
		return retVal;
    }
    
    /**
     * Returns
     * ITM-20: "Approved To Buy Quantity" - creates it if necessary
     */
    public NM getItm20_ApprovedToBuyQuantity() { 
		NM retVal = this.getTypedField(20, 0);
		return retVal;
    }



    /**
     * Returns
     * ITM-21: "Approved To Buy Price" - creates it if necessary
     */
    public MO getApprovedToBuyPrice() { 
		MO retVal = this.getTypedField(21, 0);
		return retVal;
    }
    
    /**
     * Returns
     * ITM-21: "Approved To Buy Price" - creates it if necessary
     */
    public MO getItm21_ApprovedToBuyPrice() { 
		MO retVal = this.getTypedField(21, 0);
		return retVal;
    }



    /**
     * Returns
     * ITM-22: "Taxable Item Indicator" - creates it if necessary
     */
    public CNE getTaxableItemIndicator() { 
		CNE retVal = this.getTypedField(22, 0);
		return retVal;
    }
    
    /**
     * Returns
     * ITM-22: "Taxable Item Indicator" - creates it if necessary
     */
    public CNE getItm22_TaxableItemIndicator() { 
		CNE retVal = this.getTypedField(22, 0);
		return retVal;
    }



    /**
     * Returns
     * ITM-23: "Freight Charge Indicator" - creates it if necessary
     */
    public CNE getFreightChargeIndicator() { 
		CNE retVal = this.getTypedField(23, 0);
		return retVal;
    }
    
    /**
     * Returns
     * ITM-23: "Freight Charge Indicator" - creates it if necessary
     */
    public CNE getItm23_FreightChargeIndicator() { 
		CNE retVal = this.getTypedField(23, 0);
		return retVal;
    }



    /**
     * Returns
     * ITM-24: "Item Set Indicator" - creates it if necessary
     */
    public CNE getItemSetIndicator() { 
		CNE retVal = this.getTypedField(24, 0);
		return retVal;
    }
    
    /**
     * Returns
     * ITM-24: "Item Set Indicator" - creates it if necessary
     */
    public CNE getItm24_ItemSetIndicator() { 
		CNE retVal = this.getTypedField(24, 0);
		return retVal;
    }



    /**
     * Returns
     * ITM-25: "Item Set Identifier" - creates it if necessary
     */
    public EI getItemSetIdentifier() { 
		EI retVal = this.getTypedField(25, 0);
		return retVal;
    }
    
    /**
     * Returns
     * ITM-25: "Item Set Identifier" - creates it if necessary
     */
    public EI getItm25_ItemSetIdentifier() { 
		EI retVal = this.getTypedField(25, 0);
		return retVal;
    }



    /**
     * Returns
     * ITM-26: "Track Department Usage Indicator" - creates it if necessary
     */
    public CNE getTrackDepartmentUsageIndicator() { 
		CNE retVal = this.getTypedField(26, 0);
		return retVal;
    }
    
    /**
     * Returns
     * ITM-26: "Track Department Usage Indicator" - creates it if necessary
     */
    public CNE getItm26_TrackDepartmentUsageIndicator() { 
		CNE retVal = this.getTypedField(26, 0);
		return retVal;
    }



    /**
     * Returns
     * ITM-27: "Procedure Code" - creates it if necessary
     */
    public CNE getProcedureCode() { 
		CNE retVal = this.getTypedField(27, 0);
		return retVal;
    }
    
    /**
     * Returns
     * ITM-27: "Procedure Code" - creates it if necessary
     */
    public CNE getItm27_ProcedureCode() { 
		CNE retVal = this.getTypedField(27, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Procedure Code Modifier (ITM-28).
     */
    public CNE[] getProcedureCodeModifier() {
    	CNE[] retVal = this.getTypedField(28, new CNE[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Procedure Code Modifier (ITM-28).
     */
    public CNE[] getItm28_ProcedureCodeModifier() {
    	CNE[] retVal = this.getTypedField(28, new CNE[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Procedure Code Modifier (ITM-28).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getProcedureCodeModifierReps() {
    	return this.getReps(28);
    }


    /**
     * Returns a specific repetition of
     * ITM-28: "Procedure Code Modifier" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CNE getProcedureCodeModifier(int rep) { 
		CNE retVal = this.getTypedField(28, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * ITM-28: "Procedure Code Modifier" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CNE getItm28_ProcedureCodeModifier(int rep) { 
		CNE retVal = this.getTypedField(28, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Procedure Code Modifier (ITM-28).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getItm28_ProcedureCodeModifierReps() {
    	return this.getReps(28);
    }


    /**
     * Inserts a repetition of
     * ITM-28: "Procedure Code Modifier" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CNE insertProcedureCodeModifier(int rep) throws HL7Exception { 
        return (CNE) super.insertRepetition(28, rep);
    }


    /**
     * Inserts a repetition of
     * ITM-28: "Procedure Code Modifier" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CNE insertItm28_ProcedureCodeModifier(int rep) throws HL7Exception { 
        return (CNE) super.insertRepetition(28, rep);
    }


    /**
     * Removes a repetition of
     * ITM-28: "Procedure Code Modifier" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CNE removeProcedureCodeModifier(int rep) throws HL7Exception { 
        return (CNE) super.removeRepetition(28, rep);
    }


    /**
     * Removes a repetition of
     * ITM-28: "Procedure Code Modifier" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CNE removeItm28_ProcedureCodeModifier(int rep) throws HL7Exception { 
        return (CNE) super.removeRepetition(28, rep);
    }




    /**
     * Returns
     * ITM-29: "Special Handling Code" - creates it if necessary
     */
    public CWE getSpecialHandlingCode() { 
		CWE retVal = this.getTypedField(29, 0);
		return retVal;
    }
    
    /**
     * Returns
     * ITM-29: "Special Handling Code" - creates it if necessary
     */
    public CWE getItm29_SpecialHandlingCode() { 
		CWE retVal = this.getTypedField(29, 0);
		return retVal;
    }



    /**
     * Returns
     * ITM-30: "Hazardous Indicator" - creates it if necessary
     */
    public CNE getHazardousIndicator() { 
		CNE retVal = this.getTypedField(30, 0);
		return retVal;
    }
    
    /**
     * Returns
     * ITM-30: "Hazardous Indicator" - creates it if necessary
     */
    public CNE getItm30_HazardousIndicator() { 
		CNE retVal = this.getTypedField(30, 0);
		return retVal;
    }



    /**
     * Returns
     * ITM-31: "Sterile Indicator" - creates it if necessary
     */
    public CNE getSterileIndicator() { 
		CNE retVal = this.getTypedField(31, 0);
		return retVal;
    }
    
    /**
     * Returns
     * ITM-31: "Sterile Indicator" - creates it if necessary
     */
    public CNE getItm31_SterileIndicator() { 
		CNE retVal = this.getTypedField(31, 0);
		return retVal;
    }



    /**
     * Returns
     * ITM-32: "Material Data Safety Sheet Number" - creates it if necessary
     */
    public EI getMaterialDataSafetySheetNumber() { 
		EI retVal = this.getTypedField(32, 0);
		return retVal;
    }
    
    /**
     * Returns
     * ITM-32: "Material Data Safety Sheet Number" - creates it if necessary
     */
    public EI getItm32_MaterialDataSafetySheetNumber() { 
		EI retVal = this.getTypedField(32, 0);
		return retVal;
    }



    /**
     * Returns
     * ITM-33: "United Nations Standard Products and Services Code (UNSPSC)" - creates it if necessary
     */
    public CWE getUnitedNationsStandardProductsAndServicesCodeUNSPSC() { 
		CWE retVal = this.getTypedField(33, 0);
		return retVal;
    }
    
    /**
     * Returns
     * ITM-33: "United Nations Standard Products and Services Code (UNSPSC)" - creates it if necessary
     */
    public CWE getItm33_UnitedNationsStandardProductsAndServicesCodeUNSPSC() { 
		CWE retVal = this.getTypedField(33, 0);
		return retVal;
    }





    /** {@inheritDoc} */   
    protected Type createNewTypeWithoutReflection(int field) {
       switch (field) {
          case 0: return new EI(getMessage());
          case 1: return new ST(getMessage());
          case 2: return new CWE(getMessage());
          case 3: return new CWE(getMessage());
          case 4: return new CWE(getMessage());
          case 5: return new CNE(getMessage());
          case 6: return new EI(getMessage());
          case 7: return new ST(getMessage());
          case 8: return new ST(getMessage());
          case 9: return new CWE(getMessage());
          case 10: return new CNE(getMessage());
          case 11: return new CWE(getMessage());
          case 12: return new CP(getMessage());
          case 13: return new CNE(getMessage());
          case 14: return new CWE(getMessage());
          case 15: return new XON(getMessage());
          case 16: return new CNE(getMessage());
          case 17: return new CWE(getMessage());
          case 18: return new CWE(getMessage());
          case 19: return new NM(getMessage());
          case 20: return new MO(getMessage());
          case 21: return new CNE(getMessage());
          case 22: return new CNE(getMessage());
          case 23: return new CNE(getMessage());
          case 24: return new EI(getMessage());
          case 25: return new CNE(getMessage());
          case 26: return new CNE(getMessage());
          case 27: return new CNE(getMessage());
          case 28: return new CWE(getMessage());
          case 29: return new CNE(getMessage());
          case 30: return new CNE(getMessage());
          case 31: return new EI(getMessage());
          case 32: return new CWE(getMessage());
          default: return null;
       }
   }


}

