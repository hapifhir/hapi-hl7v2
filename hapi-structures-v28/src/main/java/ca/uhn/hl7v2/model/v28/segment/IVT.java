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


package ca.uhn.hl7v2.model.v28.segment;

// import ca.uhn.hl7v2.model.v28.group.*;
import ca.uhn.hl7v2.model.v28.datatype.*;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.parser.DefaultModelClassFactory;
import ca.uhn.hl7v2.model.AbstractMessage;
import ca.uhn.hl7v2.model.Group;
import ca.uhn.hl7v2.model.Type;
import ca.uhn.hl7v2.model.AbstractSegment;
import ca.uhn.hl7v2.model.Varies;


/**
 *<p>Represents an HL7 IVT message segment (Material Location). 
 * This segment has the following fields:</p>
 * <ul>
     * <li>IVT-1: Set Id - IVT (SI) <b> </b>
     * <li>IVT-2: Inventory Location Identifier (EI) <b> </b>
     * <li>IVT-3: Inventory Location Name (ST) <b>optional </b>
     * <li>IVT-4: Source Location Identifier (EI) <b>optional </b>
     * <li>IVT-5: Source Location Name (ST) <b>optional </b>
     * <li>IVT-6: Item Status (CWE) <b>optional </b>
     * <li>IVT-7: Bin Location Identifier (EI) <b>optional repeating</b>
     * <li>IVT-8: Order Packaging (CWE) <b>optional </b>
     * <li>IVT-9: Issue Packaging (CWE) <b>optional </b>
     * <li>IVT-10: Default Inventory Asset Account (EI) <b>optional </b>
     * <li>IVT-11: Patient Chargeable Indicator (CNE) <b>optional </b>
     * <li>IVT-12: Transaction Code (CWE) <b>optional </b>
     * <li>IVT-13: Transaction amount - unit (CP) <b>optional </b>
     * <li>IVT-14: Item Importance Code (CWE) <b>optional </b>
     * <li>IVT-15: Stocked Item Indicator (CNE) <b>optional </b>
     * <li>IVT-16: Consignment Item Indicator (CNE) <b>optional </b>
     * <li>IVT-17: Reusable Item Indicator (CNE) <b>optional </b>
     * <li>IVT-18: Reusable Cost (CP) <b>optional </b>
     * <li>IVT-19: Substitute Item Identifier (EI) <b>optional repeating</b>
     * <li>IVT-20: Latex-Free Substitute Item Identifier (EI) <b>optional </b>
     * <li>IVT-21: Recommended Reorder Theory (CWE) <b>optional </b>
     * <li>IVT-22: Recommended Safety Stock Days (NM) <b>optional </b>
     * <li>IVT-23: Recommended Maximum Days Inventory (NM) <b>optional </b>
     * <li>IVT-24: Recommended Order Point (NM) <b>optional </b>
     * <li>IVT-25: Recommended Order Amount (NM) <b>optional </b>
     * <li>IVT-26: Operating Room Par Level Indicator (CNE) <b>optional </b>
 * </ul>
 */
@SuppressWarnings("unused")
public class IVT extends AbstractSegment {

    /** 
     * Creates a new IVT segment
     */
    public IVT(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(SI.class, true, 1, 4, new Object[]{ getMessage() }, "Set Id - IVT");
                                  this.add(EI.class, true, 1, 0, new Object[]{ getMessage() }, "Inventory Location Identifier");
                                  this.add(ST.class, false, 1, 0, new Object[]{ getMessage() }, "Inventory Location Name");
                                  this.add(EI.class, false, 1, 0, new Object[]{ getMessage() }, "Source Location Identifier");
                                  this.add(ST.class, false, 1, 0, new Object[]{ getMessage() }, "Source Location Name");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "Item Status");
                                  this.add(EI.class, false, 0, 0, new Object[]{ getMessage() }, "Bin Location Identifier");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "Order Packaging");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "Issue Packaging");
                                  this.add(EI.class, false, 1, 0, new Object[]{ getMessage() }, "Default Inventory Asset Account");
                                  this.add(CNE.class, false, 1, 0, new Object[]{ getMessage() }, "Patient Chargeable Indicator");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "Transaction Code");
                                  this.add(CP.class, false, 1, 0, new Object[]{ getMessage() }, "Transaction amount - unit");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "Item Importance Code");
                                  this.add(CNE.class, false, 1, 0, new Object[]{ getMessage() }, "Stocked Item Indicator");
                                  this.add(CNE.class, false, 1, 0, new Object[]{ getMessage() }, "Consignment Item Indicator");
                                  this.add(CNE.class, false, 1, 0, new Object[]{ getMessage() }, "Reusable Item Indicator");
                                  this.add(CP.class, false, 1, 0, new Object[]{ getMessage() }, "Reusable Cost");
                                  this.add(EI.class, false, 0, 0, new Object[]{ getMessage() }, "Substitute Item Identifier");
                                  this.add(EI.class, false, 1, 0, new Object[]{ getMessage() }, "Latex-Free Substitute Item Identifier");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "Recommended Reorder Theory");
                                  this.add(NM.class, false, 1, 0, new Object[]{ getMessage() }, "Recommended Safety Stock Days");
                                  this.add(NM.class, false, 1, 0, new Object[]{ getMessage() }, "Recommended Maximum Days Inventory");
                                  this.add(NM.class, false, 1, 0, new Object[]{ getMessage() }, "Recommended Order Point");
                                  this.add(NM.class, false, 1, 0, new Object[]{ getMessage() }, "Recommended Order Amount");
                                  this.add(CNE.class, false, 1, 0, new Object[]{ getMessage() }, "Operating Room Par Level Indicator");
       } catch(HL7Exception e) {
          log.error("Unexpected error creating IVT - this is probably a bug in the source code generator.", e);
       }
    }



    /**
     * Returns
     * IVT-1: "Set Id - IVT" - creates it if necessary
     */
    public SI getSetIdIVT() { 
		SI retVal = this.getTypedField(1, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IVT-1: "Set Id - IVT" - creates it if necessary
     */
    public SI getIvt1_SetIdIVT() { 
		SI retVal = this.getTypedField(1, 0);
		return retVal;
    }



    /**
     * Returns
     * IVT-2: "Inventory Location Identifier" - creates it if necessary
     */
    public EI getInventoryLocationIdentifier() { 
		EI retVal = this.getTypedField(2, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IVT-2: "Inventory Location Identifier" - creates it if necessary
     */
    public EI getIvt2_InventoryLocationIdentifier() { 
		EI retVal = this.getTypedField(2, 0);
		return retVal;
    }



    /**
     * Returns
     * IVT-3: "Inventory Location Name" - creates it if necessary
     */
    public ST getInventoryLocationName() { 
		ST retVal = this.getTypedField(3, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IVT-3: "Inventory Location Name" - creates it if necessary
     */
    public ST getIvt3_InventoryLocationName() { 
		ST retVal = this.getTypedField(3, 0);
		return retVal;
    }



    /**
     * Returns
     * IVT-4: "Source Location Identifier" - creates it if necessary
     */
    public EI getSourceLocationIdentifier() { 
		EI retVal = this.getTypedField(4, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IVT-4: "Source Location Identifier" - creates it if necessary
     */
    public EI getIvt4_SourceLocationIdentifier() { 
		EI retVal = this.getTypedField(4, 0);
		return retVal;
    }



    /**
     * Returns
     * IVT-5: "Source Location Name" - creates it if necessary
     */
    public ST getSourceLocationName() { 
		ST retVal = this.getTypedField(5, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IVT-5: "Source Location Name" - creates it if necessary
     */
    public ST getIvt5_SourceLocationName() { 
		ST retVal = this.getTypedField(5, 0);
		return retVal;
    }



    /**
     * Returns
     * IVT-6: "Item Status" - creates it if necessary
     */
    public CWE getItemStatus() { 
		CWE retVal = this.getTypedField(6, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IVT-6: "Item Status" - creates it if necessary
     */
    public CWE getIvt6_ItemStatus() { 
		CWE retVal = this.getTypedField(6, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Bin Location Identifier (IVT-7).
     */
    public EI[] getBinLocationIdentifier() {
    	EI[] retVal = this.getTypedField(7, new EI[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Bin Location Identifier (IVT-7).
     */
    public EI[] getIvt7_BinLocationIdentifier() {
    	EI[] retVal = this.getTypedField(7, new EI[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Bin Location Identifier (IVT-7).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getBinLocationIdentifierReps() {
    	return this.getReps(7);
    }


    /**
     * Returns a specific repetition of
     * IVT-7: "Bin Location Identifier" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public EI getBinLocationIdentifier(int rep) { 
		EI retVal = this.getTypedField(7, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * IVT-7: "Bin Location Identifier" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public EI getIvt7_BinLocationIdentifier(int rep) { 
		EI retVal = this.getTypedField(7, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Bin Location Identifier (IVT-7).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getIvt7_BinLocationIdentifierReps() {
    	return this.getReps(7);
    }


    /**
     * Inserts a repetition of
     * IVT-7: "Bin Location Identifier" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public EI insertBinLocationIdentifier(int rep) throws HL7Exception { 
        return (EI) super.insertRepetition(7, rep);
    }


    /**
     * Inserts a repetition of
     * IVT-7: "Bin Location Identifier" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public EI insertIvt7_BinLocationIdentifier(int rep) throws HL7Exception { 
        return (EI) super.insertRepetition(7, rep);
    }


    /**
     * Removes a repetition of
     * IVT-7: "Bin Location Identifier" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public EI removeBinLocationIdentifier(int rep) throws HL7Exception { 
        return (EI) super.removeRepetition(7, rep);
    }


    /**
     * Removes a repetition of
     * IVT-7: "Bin Location Identifier" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public EI removeIvt7_BinLocationIdentifier(int rep) throws HL7Exception { 
        return (EI) super.removeRepetition(7, rep);
    }




    /**
     * Returns
     * IVT-8: "Order Packaging" - creates it if necessary
     */
    public CWE getOrderPackaging() { 
		CWE retVal = this.getTypedField(8, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IVT-8: "Order Packaging" - creates it if necessary
     */
    public CWE getIvt8_OrderPackaging() { 
		CWE retVal = this.getTypedField(8, 0);
		return retVal;
    }



    /**
     * Returns
     * IVT-9: "Issue Packaging" - creates it if necessary
     */
    public CWE getIssuePackaging() { 
		CWE retVal = this.getTypedField(9, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IVT-9: "Issue Packaging" - creates it if necessary
     */
    public CWE getIvt9_IssuePackaging() { 
		CWE retVal = this.getTypedField(9, 0);
		return retVal;
    }



    /**
     * Returns
     * IVT-10: "Default Inventory Asset Account" - creates it if necessary
     */
    public EI getDefaultInventoryAssetAccount() { 
		EI retVal = this.getTypedField(10, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IVT-10: "Default Inventory Asset Account" - creates it if necessary
     */
    public EI getIvt10_DefaultInventoryAssetAccount() { 
		EI retVal = this.getTypedField(10, 0);
		return retVal;
    }



    /**
     * Returns
     * IVT-11: "Patient Chargeable Indicator" - creates it if necessary
     */
    public CNE getPatientChargeableIndicator() { 
		CNE retVal = this.getTypedField(11, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IVT-11: "Patient Chargeable Indicator" - creates it if necessary
     */
    public CNE getIvt11_PatientChargeableIndicator() { 
		CNE retVal = this.getTypedField(11, 0);
		return retVal;
    }



    /**
     * Returns
     * IVT-12: "Transaction Code" - creates it if necessary
     */
    public CWE getTransactionCode() { 
		CWE retVal = this.getTypedField(12, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IVT-12: "Transaction Code" - creates it if necessary
     */
    public CWE getIvt12_TransactionCode() { 
		CWE retVal = this.getTypedField(12, 0);
		return retVal;
    }



    /**
     * Returns
     * IVT-13: "Transaction amount - unit" - creates it if necessary
     */
    public CP getTransactionAmountUnit() { 
		CP retVal = this.getTypedField(13, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IVT-13: "Transaction amount - unit" - creates it if necessary
     */
    public CP getIvt13_TransactionAmountUnit() { 
		CP retVal = this.getTypedField(13, 0);
		return retVal;
    }



    /**
     * Returns
     * IVT-14: "Item Importance Code" - creates it if necessary
     */
    public CWE getItemImportanceCode() { 
		CWE retVal = this.getTypedField(14, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IVT-14: "Item Importance Code" - creates it if necessary
     */
    public CWE getIvt14_ItemImportanceCode() { 
		CWE retVal = this.getTypedField(14, 0);
		return retVal;
    }



    /**
     * Returns
     * IVT-15: "Stocked Item Indicator" - creates it if necessary
     */
    public CNE getStockedItemIndicator() { 
		CNE retVal = this.getTypedField(15, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IVT-15: "Stocked Item Indicator" - creates it if necessary
     */
    public CNE getIvt15_StockedItemIndicator() { 
		CNE retVal = this.getTypedField(15, 0);
		return retVal;
    }



    /**
     * Returns
     * IVT-16: "Consignment Item Indicator" - creates it if necessary
     */
    public CNE getConsignmentItemIndicator() { 
		CNE retVal = this.getTypedField(16, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IVT-16: "Consignment Item Indicator" - creates it if necessary
     */
    public CNE getIvt16_ConsignmentItemIndicator() { 
		CNE retVal = this.getTypedField(16, 0);
		return retVal;
    }



    /**
     * Returns
     * IVT-17: "Reusable Item Indicator" - creates it if necessary
     */
    public CNE getReusableItemIndicator() { 
		CNE retVal = this.getTypedField(17, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IVT-17: "Reusable Item Indicator" - creates it if necessary
     */
    public CNE getIvt17_ReusableItemIndicator() { 
		CNE retVal = this.getTypedField(17, 0);
		return retVal;
    }



    /**
     * Returns
     * IVT-18: "Reusable Cost" - creates it if necessary
     */
    public CP getReusableCost() { 
		CP retVal = this.getTypedField(18, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IVT-18: "Reusable Cost" - creates it if necessary
     */
    public CP getIvt18_ReusableCost() { 
		CP retVal = this.getTypedField(18, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Substitute Item Identifier (IVT-19).
     */
    public EI[] getSubstituteItemIdentifier() {
    	EI[] retVal = this.getTypedField(19, new EI[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Substitute Item Identifier (IVT-19).
     */
    public EI[] getIvt19_SubstituteItemIdentifier() {
    	EI[] retVal = this.getTypedField(19, new EI[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Substitute Item Identifier (IVT-19).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getSubstituteItemIdentifierReps() {
    	return this.getReps(19);
    }


    /**
     * Returns a specific repetition of
     * IVT-19: "Substitute Item Identifier" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public EI getSubstituteItemIdentifier(int rep) { 
		EI retVal = this.getTypedField(19, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * IVT-19: "Substitute Item Identifier" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public EI getIvt19_SubstituteItemIdentifier(int rep) { 
		EI retVal = this.getTypedField(19, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Substitute Item Identifier (IVT-19).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getIvt19_SubstituteItemIdentifierReps() {
    	return this.getReps(19);
    }


    /**
     * Inserts a repetition of
     * IVT-19: "Substitute Item Identifier" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public EI insertSubstituteItemIdentifier(int rep) throws HL7Exception { 
        return (EI) super.insertRepetition(19, rep);
    }


    /**
     * Inserts a repetition of
     * IVT-19: "Substitute Item Identifier" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public EI insertIvt19_SubstituteItemIdentifier(int rep) throws HL7Exception { 
        return (EI) super.insertRepetition(19, rep);
    }


    /**
     * Removes a repetition of
     * IVT-19: "Substitute Item Identifier" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public EI removeSubstituteItemIdentifier(int rep) throws HL7Exception { 
        return (EI) super.removeRepetition(19, rep);
    }


    /**
     * Removes a repetition of
     * IVT-19: "Substitute Item Identifier" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public EI removeIvt19_SubstituteItemIdentifier(int rep) throws HL7Exception { 
        return (EI) super.removeRepetition(19, rep);
    }




    /**
     * Returns
     * IVT-20: "Latex-Free Substitute Item Identifier" - creates it if necessary
     */
    public EI getLatexFreeSubstituteItemIdentifier() { 
		EI retVal = this.getTypedField(20, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IVT-20: "Latex-Free Substitute Item Identifier" - creates it if necessary
     */
    public EI getIvt20_LatexFreeSubstituteItemIdentifier() { 
		EI retVal = this.getTypedField(20, 0);
		return retVal;
    }



    /**
     * Returns
     * IVT-21: "Recommended Reorder Theory" - creates it if necessary
     */
    public CWE getRecommendedReorderTheory() { 
		CWE retVal = this.getTypedField(21, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IVT-21: "Recommended Reorder Theory" - creates it if necessary
     */
    public CWE getIvt21_RecommendedReorderTheory() { 
		CWE retVal = this.getTypedField(21, 0);
		return retVal;
    }



    /**
     * Returns
     * IVT-22: "Recommended Safety Stock Days" - creates it if necessary
     */
    public NM getRecommendedSafetyStockDays() { 
		NM retVal = this.getTypedField(22, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IVT-22: "Recommended Safety Stock Days" - creates it if necessary
     */
    public NM getIvt22_RecommendedSafetyStockDays() { 
		NM retVal = this.getTypedField(22, 0);
		return retVal;
    }



    /**
     * Returns
     * IVT-23: "Recommended Maximum Days Inventory" - creates it if necessary
     */
    public NM getRecommendedMaximumDaysInventory() { 
		NM retVal = this.getTypedField(23, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IVT-23: "Recommended Maximum Days Inventory" - creates it if necessary
     */
    public NM getIvt23_RecommendedMaximumDaysInventory() { 
		NM retVal = this.getTypedField(23, 0);
		return retVal;
    }



    /**
     * Returns
     * IVT-24: "Recommended Order Point" - creates it if necessary
     */
    public NM getRecommendedOrderPoint() { 
		NM retVal = this.getTypedField(24, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IVT-24: "Recommended Order Point" - creates it if necessary
     */
    public NM getIvt24_RecommendedOrderPoint() { 
		NM retVal = this.getTypedField(24, 0);
		return retVal;
    }



    /**
     * Returns
     * IVT-25: "Recommended Order Amount" - creates it if necessary
     */
    public NM getRecommendedOrderAmount() { 
		NM retVal = this.getTypedField(25, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IVT-25: "Recommended Order Amount" - creates it if necessary
     */
    public NM getIvt25_RecommendedOrderAmount() { 
		NM retVal = this.getTypedField(25, 0);
		return retVal;
    }



    /**
     * Returns
     * IVT-26: "Operating Room Par Level Indicator" - creates it if necessary
     */
    public CNE getOperatingRoomParLevelIndicator() { 
		CNE retVal = this.getTypedField(26, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IVT-26: "Operating Room Par Level Indicator" - creates it if necessary
     */
    public CNE getIvt26_OperatingRoomParLevelIndicator() { 
		CNE retVal = this.getTypedField(26, 0);
		return retVal;
    }





    /** {@inheritDoc} */   
    protected Type createNewTypeWithoutReflection(int field) {
       switch (field) {
          case 0: return new SI(getMessage());
          case 1: return new EI(getMessage());
          case 2: return new ST(getMessage());
          case 3: return new EI(getMessage());
          case 4: return new ST(getMessage());
          case 5: return new CWE(getMessage());
          case 6: return new EI(getMessage());
          case 7: return new CWE(getMessage());
          case 8: return new CWE(getMessage());
          case 9: return new EI(getMessage());
          case 10: return new CNE(getMessage());
          case 11: return new CWE(getMessage());
          case 12: return new CP(getMessage());
          case 13: return new CWE(getMessage());
          case 14: return new CNE(getMessage());
          case 15: return new CNE(getMessage());
          case 16: return new CNE(getMessage());
          case 17: return new CP(getMessage());
          case 18: return new EI(getMessage());
          case 19: return new EI(getMessage());
          case 20: return new CWE(getMessage());
          case 21: return new NM(getMessage());
          case 22: return new NM(getMessage());
          case 23: return new NM(getMessage());
          case 24: return new NM(getMessage());
          case 25: return new CNE(getMessage());
          default: return null;
       }
   }


}

