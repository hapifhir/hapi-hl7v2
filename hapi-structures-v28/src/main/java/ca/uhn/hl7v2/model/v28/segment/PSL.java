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
 *<p>Represents an HL7 PSL message segment (Product/Service Line Item). 
 * This segment has the following fields:</p>
 * <ul>
     * <li>PSL-1: Provider Product/Service Line Item Number (EI) <b> </b>
     * <li>PSL-2: Payer Product/Service Line Item Number (EI) <b>optional </b>
     * <li>PSL-3: Product/Service Line Item Sequence Number (SI) <b> </b>
     * <li>PSL-4: Provider Tracking ID (EI) <b>optional </b>
     * <li>PSL-5: Payer Tracking ID (EI) <b>optional </b>
     * <li>PSL-6: Product/Service Line Item Status (CWE) <b> </b>
     * <li>PSL-7: Product/Service Code (CWE) <b> </b>
     * <li>PSL-8: Product/Service Code Modifier (CWE) <b>optional </b>
     * <li>PSL-9: Product/Service Code Description (ST) <b>optional </b>
     * <li>PSL-10: Product/Service Effective Date (DTM) <b>optional </b>
     * <li>PSL-11: Product/Service Expiration Date (DTM) <b>optional </b>
     * <li>PSL-12: Product/Service Quantity (CQ) <b>optional </b>
     * <li>PSL-13: Product/Service Unit Cost (CP) <b>optional </b>
     * <li>PSL-14: Number of Items per Unit (NM) <b>optional </b>
     * <li>PSL-15: Product/Service Gross Amount (CP) <b>optional </b>
     * <li>PSL-16: Product/Service Billed Amount (CP) <b>optional </b>
     * <li>PSL-17: Product/Service Clarification Code Type (CWE) <b>optional </b>
     * <li>PSL-18: Product/Service Clarification Code Value (ST) <b>optional </b>
     * <li>PSL-19: Health Document Reference Identifier (EI) <b>optional </b>
     * <li>PSL-20: Processing Consideration Code (CWE) <b>optional </b>
     * <li>PSL-21: Restricted Disclosure Indicator (ID) <b> </b>
     * <li>PSL-22: Related Product/Service Code Indicator (CWE) <b>optional </b>
     * <li>PSL-23: Product/Service Amount for Physician (CP) <b>optional </b>
     * <li>PSL-24: Product/Service Cost Factor (NM) <b>optional </b>
     * <li>PSL-25: Cost Center (CX) <b>optional </b>
     * <li>PSL-26: Billing Period (DR) <b>optional </b>
     * <li>PSL-27: Days without Billing (NM) <b>optional </b>
     * <li>PSL-28: Session-No (NM) <b>optional </b>
     * <li>PSL-29: Executing Physician ID (XCN) <b>optional </b>
     * <li>PSL-30: Responsible Physician ID (XCN) <b>optional </b>
     * <li>PSL-31: Role Executing Physician (CWE) <b>optional </b>
     * <li>PSL-32: Medical Role Executing Physician (CWE) <b>optional </b>
     * <li>PSL-33: Side of body (CWE) <b>optional </b>
     * <li>PSL-34: Number of TP's PP (NM) <b>optional </b>
     * <li>PSL-35: TP-Value PP (CP) <b>optional </b>
     * <li>PSL-36: Internal Scaling Factor PP (NM) <b>optional </b>
     * <li>PSL-37: External Scaling Factor PP (NM) <b>optional </b>
     * <li>PSL-38: Amount PP (CP) <b>optional </b>
     * <li>PSL-39: Number of TP's Technical Part (NM) <b>optional </b>
     * <li>PSL-40: TP-Value Technical Part (CP) <b>optional </b>
     * <li>PSL-41: Internal Scaling Factor Technical Part (NM) <b>optional </b>
     * <li>PSL-42: External Scaling Factor Technical Part (NM) <b>optional </b>
     * <li>PSL-43: Amount Technical Part (CP) <b>optional </b>
     * <li>PSL-44: Total Amount Professional Part + Technical Part (CP) <b>optional </b>
     * <li>PSL-45: VAT-Rate (NM) <b>optional </b>
     * <li>PSL-46: Main-Service (ID) <b>optional </b>
     * <li>PSL-47: Validation (ID) <b>optional </b>
     * <li>PSL-48: Comment (ST) <b>optional </b>
 * </ul>
 */
@SuppressWarnings("unused")
public class PSL extends AbstractSegment {

    /** 
     * Creates a new PSL segment
     */
    public PSL(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(EI.class, true, 1, 0, new Object[]{ getMessage() }, "Provider Product/Service Line Item Number");
                                  this.add(EI.class, false, 1, 0, new Object[]{ getMessage() }, "Payer Product/Service Line Item Number");
                                  this.add(SI.class, true, 1, 4, new Object[]{ getMessage() }, "Product/Service Line Item Sequence Number");
                                  this.add(EI.class, false, 1, 0, new Object[]{ getMessage() }, "Provider Tracking ID");
                                  this.add(EI.class, false, 1, 0, new Object[]{ getMessage() }, "Payer Tracking ID");
                                  this.add(CWE.class, true, 1, 0, new Object[]{ getMessage() }, "Product/Service Line Item Status");
                                  this.add(CWE.class, true, 1, 0, new Object[]{ getMessage() }, "Product/Service Code");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "Product/Service Code Modifier");
                                  this.add(ST.class, false, 1, 0, new Object[]{ getMessage() }, "Product/Service Code Description");
                                  this.add(DTM.class, false, 1, 0, new Object[]{ getMessage() }, "Product/Service Effective Date");
                                  this.add(DTM.class, false, 1, 0, new Object[]{ getMessage() }, "Product/Service Expiration Date");
                                  this.add(CQ.class, false, 1, 0, new Object[]{ getMessage() }, "Product/Service Quantity");
                                  this.add(CP.class, false, 1, 0, new Object[]{ getMessage() }, "Product/Service Unit Cost");
                                  this.add(NM.class, false, 1, 0, new Object[]{ getMessage() }, "Number of Items per Unit");
                                  this.add(CP.class, false, 1, 0, new Object[]{ getMessage() }, "Product/Service Gross Amount");
                                  this.add(CP.class, false, 1, 0, new Object[]{ getMessage() }, "Product/Service Billed Amount");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "Product/Service Clarification Code Type");
                                  this.add(ST.class, false, 1, 0, new Object[]{ getMessage() }, "Product/Service Clarification Code Value");
                                  this.add(EI.class, false, 1, 0, new Object[]{ getMessage() }, "Health Document Reference Identifier");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "Processing Consideration Code");
                                              this.add(ID.class, true, 1, 4, new Object[]{ getMessage(), new Integer(532) }, "Restricted Disclosure Indicator");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "Related Product/Service Code Indicator");
                                  this.add(CP.class, false, 1, 0, new Object[]{ getMessage() }, "Product/Service Amount for Physician");
                                  this.add(NM.class, false, 1, 0, new Object[]{ getMessage() }, "Product/Service Cost Factor");
                                  this.add(CX.class, false, 1, 0, new Object[]{ getMessage() }, "Cost Center");
                                  this.add(DR.class, false, 1, 0, new Object[]{ getMessage() }, "Billing Period");
                                  this.add(NM.class, false, 1, 0, new Object[]{ getMessage() }, "Days without Billing");
                                  this.add(NM.class, false, 1, 4, new Object[]{ getMessage() }, "Session-No");
                                  this.add(XCN.class, false, 1, 0, new Object[]{ getMessage() }, "Executing Physician ID");
                                  this.add(XCN.class, false, 1, 0, new Object[]{ getMessage() }, "Responsible Physician ID");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "Role Executing Physician");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "Medical Role Executing Physician");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "Side of body");
                                  this.add(NM.class, false, 1, 0, new Object[]{ getMessage() }, "Number of TP's PP");
                                  this.add(CP.class, false, 1, 0, new Object[]{ getMessage() }, "TP-Value PP");
                                  this.add(NM.class, false, 1, 0, new Object[]{ getMessage() }, "Internal Scaling Factor PP");
                                  this.add(NM.class, false, 1, 0, new Object[]{ getMessage() }, "External Scaling Factor PP");
                                  this.add(CP.class, false, 1, 0, new Object[]{ getMessage() }, "Amount PP");
                                  this.add(NM.class, false, 1, 0, new Object[]{ getMessage() }, "Number of TP's Technical Part");
                                  this.add(CP.class, false, 1, 0, new Object[]{ getMessage() }, "TP-Value Technical Part");
                                  this.add(NM.class, false, 1, 0, new Object[]{ getMessage() }, "Internal Scaling Factor Technical Part");
                                  this.add(NM.class, false, 1, 0, new Object[]{ getMessage() }, "External Scaling Factor Technical Part");
                                  this.add(CP.class, false, 1, 0, new Object[]{ getMessage() }, "Amount Technical Part");
                                  this.add(CP.class, false, 1, 0, new Object[]{ getMessage() }, "Total Amount Professional Part + Technical Part");
                                  this.add(NM.class, false, 1, 0, new Object[]{ getMessage() }, "VAT-Rate");
                                              this.add(ID.class, false, 1, 20, new Object[]{ getMessage(), new Integer(0) }, "Main-Service");
                                              this.add(ID.class, false, 1, 1, new Object[]{ getMessage(), new Integer(136) }, "Validation");
                                  this.add(ST.class, false, 1, 0, new Object[]{ getMessage() }, "Comment");
       } catch(HL7Exception e) {
          log.error("Unexpected error creating PSL - this is probably a bug in the source code generator.", e);
       }
    }



    /**
     * Returns
     * PSL-1: "Provider Product/Service Line Item Number" - creates it if necessary
     */
    public EI getProviderProductServiceLineItemNumber() { 
		EI retVal = this.getTypedField(1, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PSL-1: "Provider Product/Service Line Item Number" - creates it if necessary
     */
    public EI getPsl1_ProviderProductServiceLineItemNumber() { 
		EI retVal = this.getTypedField(1, 0);
		return retVal;
    }



    /**
     * Returns
     * PSL-2: "Payer Product/Service Line Item Number" - creates it if necessary
     */
    public EI getPayerProductServiceLineItemNumber() { 
		EI retVal = this.getTypedField(2, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PSL-2: "Payer Product/Service Line Item Number" - creates it if necessary
     */
    public EI getPsl2_PayerProductServiceLineItemNumber() { 
		EI retVal = this.getTypedField(2, 0);
		return retVal;
    }



    /**
     * Returns
     * PSL-3: "Product/Service Line Item Sequence Number" - creates it if necessary
     */
    public SI getProductServiceLineItemSequenceNumber() { 
		SI retVal = this.getTypedField(3, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PSL-3: "Product/Service Line Item Sequence Number" - creates it if necessary
     */
    public SI getPsl3_ProductServiceLineItemSequenceNumber() { 
		SI retVal = this.getTypedField(3, 0);
		return retVal;
    }



    /**
     * Returns
     * PSL-4: "Provider Tracking ID" - creates it if necessary
     */
    public EI getProviderTrackingID() { 
		EI retVal = this.getTypedField(4, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PSL-4: "Provider Tracking ID" - creates it if necessary
     */
    public EI getPsl4_ProviderTrackingID() { 
		EI retVal = this.getTypedField(4, 0);
		return retVal;
    }



    /**
     * Returns
     * PSL-5: "Payer Tracking ID" - creates it if necessary
     */
    public EI getPayerTrackingID() { 
		EI retVal = this.getTypedField(5, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PSL-5: "Payer Tracking ID" - creates it if necessary
     */
    public EI getPsl5_PayerTrackingID() { 
		EI retVal = this.getTypedField(5, 0);
		return retVal;
    }



    /**
     * Returns
     * PSL-6: "Product/Service Line Item Status" - creates it if necessary
     */
    public CWE getProductServiceLineItemStatus() { 
		CWE retVal = this.getTypedField(6, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PSL-6: "Product/Service Line Item Status" - creates it if necessary
     */
    public CWE getPsl6_ProductServiceLineItemStatus() { 
		CWE retVal = this.getTypedField(6, 0);
		return retVal;
    }



    /**
     * Returns
     * PSL-7: "Product/Service Code" - creates it if necessary
     */
    public CWE getProductServiceCode() { 
		CWE retVal = this.getTypedField(7, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PSL-7: "Product/Service Code" - creates it if necessary
     */
    public CWE getPsl7_ProductServiceCode() { 
		CWE retVal = this.getTypedField(7, 0);
		return retVal;
    }



    /**
     * Returns
     * PSL-8: "Product/Service Code Modifier" - creates it if necessary
     */
    public CWE getProductServiceCodeModifier() { 
		CWE retVal = this.getTypedField(8, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PSL-8: "Product/Service Code Modifier" - creates it if necessary
     */
    public CWE getPsl8_ProductServiceCodeModifier() { 
		CWE retVal = this.getTypedField(8, 0);
		return retVal;
    }



    /**
     * Returns
     * PSL-9: "Product/Service Code Description" - creates it if necessary
     */
    public ST getProductServiceCodeDescription() { 
		ST retVal = this.getTypedField(9, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PSL-9: "Product/Service Code Description" - creates it if necessary
     */
    public ST getPsl9_ProductServiceCodeDescription() { 
		ST retVal = this.getTypedField(9, 0);
		return retVal;
    }



    /**
     * Returns
     * PSL-10: "Product/Service Effective Date" - creates it if necessary
     */
    public DTM getProductServiceEffectiveDate() { 
		DTM retVal = this.getTypedField(10, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PSL-10: "Product/Service Effective Date" - creates it if necessary
     */
    public DTM getPsl10_ProductServiceEffectiveDate() { 
		DTM retVal = this.getTypedField(10, 0);
		return retVal;
    }



    /**
     * Returns
     * PSL-11: "Product/Service Expiration Date" - creates it if necessary
     */
    public DTM getProductServiceExpirationDate() { 
		DTM retVal = this.getTypedField(11, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PSL-11: "Product/Service Expiration Date" - creates it if necessary
     */
    public DTM getPsl11_ProductServiceExpirationDate() { 
		DTM retVal = this.getTypedField(11, 0);
		return retVal;
    }



    /**
     * Returns
     * PSL-12: "Product/Service Quantity" - creates it if necessary
     */
    public CQ getProductServiceQuantity() { 
		CQ retVal = this.getTypedField(12, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PSL-12: "Product/Service Quantity" - creates it if necessary
     */
    public CQ getPsl12_ProductServiceQuantity() { 
		CQ retVal = this.getTypedField(12, 0);
		return retVal;
    }



    /**
     * Returns
     * PSL-13: "Product/Service Unit Cost" - creates it if necessary
     */
    public CP getProductServiceUnitCost() { 
		CP retVal = this.getTypedField(13, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PSL-13: "Product/Service Unit Cost" - creates it if necessary
     */
    public CP getPsl13_ProductServiceUnitCost() { 
		CP retVal = this.getTypedField(13, 0);
		return retVal;
    }



    /**
     * Returns
     * PSL-14: "Number of Items per Unit" - creates it if necessary
     */
    public NM getNumberOfItemsPerUnit() { 
		NM retVal = this.getTypedField(14, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PSL-14: "Number of Items per Unit" - creates it if necessary
     */
    public NM getPsl14_NumberOfItemsPerUnit() { 
		NM retVal = this.getTypedField(14, 0);
		return retVal;
    }



    /**
     * Returns
     * PSL-15: "Product/Service Gross Amount" - creates it if necessary
     */
    public CP getProductServiceGrossAmount() { 
		CP retVal = this.getTypedField(15, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PSL-15: "Product/Service Gross Amount" - creates it if necessary
     */
    public CP getPsl15_ProductServiceGrossAmount() { 
		CP retVal = this.getTypedField(15, 0);
		return retVal;
    }



    /**
     * Returns
     * PSL-16: "Product/Service Billed Amount" - creates it if necessary
     */
    public CP getProductServiceBilledAmount() { 
		CP retVal = this.getTypedField(16, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PSL-16: "Product/Service Billed Amount" - creates it if necessary
     */
    public CP getPsl16_ProductServiceBilledAmount() { 
		CP retVal = this.getTypedField(16, 0);
		return retVal;
    }



    /**
     * Returns
     * PSL-17: "Product/Service Clarification Code Type" - creates it if necessary
     */
    public CWE getProductServiceClarificationCodeType() { 
		CWE retVal = this.getTypedField(17, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PSL-17: "Product/Service Clarification Code Type" - creates it if necessary
     */
    public CWE getPsl17_ProductServiceClarificationCodeType() { 
		CWE retVal = this.getTypedField(17, 0);
		return retVal;
    }



    /**
     * Returns
     * PSL-18: "Product/Service Clarification Code Value" - creates it if necessary
     */
    public ST getProductServiceClarificationCodeValue() { 
		ST retVal = this.getTypedField(18, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PSL-18: "Product/Service Clarification Code Value" - creates it if necessary
     */
    public ST getPsl18_ProductServiceClarificationCodeValue() { 
		ST retVal = this.getTypedField(18, 0);
		return retVal;
    }



    /**
     * Returns
     * PSL-19: "Health Document Reference Identifier" - creates it if necessary
     */
    public EI getHealthDocumentReferenceIdentifier() { 
		EI retVal = this.getTypedField(19, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PSL-19: "Health Document Reference Identifier" - creates it if necessary
     */
    public EI getPsl19_HealthDocumentReferenceIdentifier() { 
		EI retVal = this.getTypedField(19, 0);
		return retVal;
    }



    /**
     * Returns
     * PSL-20: "Processing Consideration Code" - creates it if necessary
     */
    public CWE getProcessingConsiderationCode() { 
		CWE retVal = this.getTypedField(20, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PSL-20: "Processing Consideration Code" - creates it if necessary
     */
    public CWE getPsl20_ProcessingConsiderationCode() { 
		CWE retVal = this.getTypedField(20, 0);
		return retVal;
    }



    /**
     * Returns
     * PSL-21: "Restricted Disclosure Indicator" - creates it if necessary
     */
    public ID getRestrictedDisclosureIndicator() { 
		ID retVal = this.getTypedField(21, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PSL-21: "Restricted Disclosure Indicator" - creates it if necessary
     */
    public ID getPsl21_RestrictedDisclosureIndicator() { 
		ID retVal = this.getTypedField(21, 0);
		return retVal;
    }



    /**
     * Returns
     * PSL-22: "Related Product/Service Code Indicator" - creates it if necessary
     */
    public CWE getRelatedProductServiceCodeIndicator() { 
		CWE retVal = this.getTypedField(22, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PSL-22: "Related Product/Service Code Indicator" - creates it if necessary
     */
    public CWE getPsl22_RelatedProductServiceCodeIndicator() { 
		CWE retVal = this.getTypedField(22, 0);
		return retVal;
    }



    /**
     * Returns
     * PSL-23: "Product/Service Amount for Physician" - creates it if necessary
     */
    public CP getProductServiceAmountForPhysician() { 
		CP retVal = this.getTypedField(23, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PSL-23: "Product/Service Amount for Physician" - creates it if necessary
     */
    public CP getPsl23_ProductServiceAmountForPhysician() { 
		CP retVal = this.getTypedField(23, 0);
		return retVal;
    }



    /**
     * Returns
     * PSL-24: "Product/Service Cost Factor" - creates it if necessary
     */
    public NM getProductServiceCostFactor() { 
		NM retVal = this.getTypedField(24, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PSL-24: "Product/Service Cost Factor" - creates it if necessary
     */
    public NM getPsl24_ProductServiceCostFactor() { 
		NM retVal = this.getTypedField(24, 0);
		return retVal;
    }



    /**
     * Returns
     * PSL-25: "Cost Center" - creates it if necessary
     */
    public CX getCostCenter() { 
		CX retVal = this.getTypedField(25, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PSL-25: "Cost Center" - creates it if necessary
     */
    public CX getPsl25_CostCenter() { 
		CX retVal = this.getTypedField(25, 0);
		return retVal;
    }



    /**
     * Returns
     * PSL-26: "Billing Period" - creates it if necessary
     */
    public DR getBillingPeriod() { 
		DR retVal = this.getTypedField(26, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PSL-26: "Billing Period" - creates it if necessary
     */
    public DR getPsl26_BillingPeriod() { 
		DR retVal = this.getTypedField(26, 0);
		return retVal;
    }



    /**
     * Returns
     * PSL-27: "Days without Billing" - creates it if necessary
     */
    public NM getDaysWithoutBilling() { 
		NM retVal = this.getTypedField(27, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PSL-27: "Days without Billing" - creates it if necessary
     */
    public NM getPsl27_DaysWithoutBilling() { 
		NM retVal = this.getTypedField(27, 0);
		return retVal;
    }



    /**
     * Returns
     * PSL-28: "Session-No" - creates it if necessary
     */
    public NM getSessionNo() { 
		NM retVal = this.getTypedField(28, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PSL-28: "Session-No" - creates it if necessary
     */
    public NM getPsl28_SessionNo() { 
		NM retVal = this.getTypedField(28, 0);
		return retVal;
    }



    /**
     * Returns
     * PSL-29: "Executing Physician ID" - creates it if necessary
     */
    public XCN getExecutingPhysicianID() { 
		XCN retVal = this.getTypedField(29, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PSL-29: "Executing Physician ID" - creates it if necessary
     */
    public XCN getPsl29_ExecutingPhysicianID() { 
		XCN retVal = this.getTypedField(29, 0);
		return retVal;
    }



    /**
     * Returns
     * PSL-30: "Responsible Physician ID" - creates it if necessary
     */
    public XCN getResponsiblePhysicianID() { 
		XCN retVal = this.getTypedField(30, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PSL-30: "Responsible Physician ID" - creates it if necessary
     */
    public XCN getPsl30_ResponsiblePhysicianID() { 
		XCN retVal = this.getTypedField(30, 0);
		return retVal;
    }



    /**
     * Returns
     * PSL-31: "Role Executing Physician" - creates it if necessary
     */
    public CWE getRoleExecutingPhysician() { 
		CWE retVal = this.getTypedField(31, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PSL-31: "Role Executing Physician" - creates it if necessary
     */
    public CWE getPsl31_RoleExecutingPhysician() { 
		CWE retVal = this.getTypedField(31, 0);
		return retVal;
    }



    /**
     * Returns
     * PSL-32: "Medical Role Executing Physician" - creates it if necessary
     */
    public CWE getMedicalRoleExecutingPhysician() { 
		CWE retVal = this.getTypedField(32, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PSL-32: "Medical Role Executing Physician" - creates it if necessary
     */
    public CWE getPsl32_MedicalRoleExecutingPhysician() { 
		CWE retVal = this.getTypedField(32, 0);
		return retVal;
    }



    /**
     * Returns
     * PSL-33: "Side of body" - creates it if necessary
     */
    public CWE getSideOfBody() { 
		CWE retVal = this.getTypedField(33, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PSL-33: "Side of body" - creates it if necessary
     */
    public CWE getPsl33_SideOfBody() { 
		CWE retVal = this.getTypedField(33, 0);
		return retVal;
    }



    /**
     * Returns
     * PSL-34: "Number of TP's PP" - creates it if necessary
     */
    public NM getNumberOfTPSPP() { 
		NM retVal = this.getTypedField(34, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PSL-34: "Number of TP's PP" - creates it if necessary
     */
    public NM getPsl34_NumberOfTPSPP() { 
		NM retVal = this.getTypedField(34, 0);
		return retVal;
    }



    /**
     * Returns
     * PSL-35: "TP-Value PP" - creates it if necessary
     */
    public CP getTPValuePP() { 
		CP retVal = this.getTypedField(35, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PSL-35: "TP-Value PP" - creates it if necessary
     */
    public CP getPsl35_TPValuePP() { 
		CP retVal = this.getTypedField(35, 0);
		return retVal;
    }



    /**
     * Returns
     * PSL-36: "Internal Scaling Factor PP" - creates it if necessary
     */
    public NM getInternalScalingFactorPP() { 
		NM retVal = this.getTypedField(36, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PSL-36: "Internal Scaling Factor PP" - creates it if necessary
     */
    public NM getPsl36_InternalScalingFactorPP() { 
		NM retVal = this.getTypedField(36, 0);
		return retVal;
    }



    /**
     * Returns
     * PSL-37: "External Scaling Factor PP" - creates it if necessary
     */
    public NM getExternalScalingFactorPP() { 
		NM retVal = this.getTypedField(37, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PSL-37: "External Scaling Factor PP" - creates it if necessary
     */
    public NM getPsl37_ExternalScalingFactorPP() { 
		NM retVal = this.getTypedField(37, 0);
		return retVal;
    }



    /**
     * Returns
     * PSL-38: "Amount PP" - creates it if necessary
     */
    public CP getAmountPP() { 
		CP retVal = this.getTypedField(38, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PSL-38: "Amount PP" - creates it if necessary
     */
    public CP getPsl38_AmountPP() { 
		CP retVal = this.getTypedField(38, 0);
		return retVal;
    }



    /**
     * Returns
     * PSL-39: "Number of TP's Technical Part" - creates it if necessary
     */
    public NM getNumberOfTPSTechnicalPart() { 
		NM retVal = this.getTypedField(39, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PSL-39: "Number of TP's Technical Part" - creates it if necessary
     */
    public NM getPsl39_NumberOfTPSTechnicalPart() { 
		NM retVal = this.getTypedField(39, 0);
		return retVal;
    }



    /**
     * Returns
     * PSL-40: "TP-Value Technical Part" - creates it if necessary
     */
    public CP getTPValueTechnicalPart() { 
		CP retVal = this.getTypedField(40, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PSL-40: "TP-Value Technical Part" - creates it if necessary
     */
    public CP getPsl40_TPValueTechnicalPart() { 
		CP retVal = this.getTypedField(40, 0);
		return retVal;
    }



    /**
     * Returns
     * PSL-41: "Internal Scaling Factor Technical Part" - creates it if necessary
     */
    public NM getInternalScalingFactorTechnicalPart() { 
		NM retVal = this.getTypedField(41, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PSL-41: "Internal Scaling Factor Technical Part" - creates it if necessary
     */
    public NM getPsl41_InternalScalingFactorTechnicalPart() { 
		NM retVal = this.getTypedField(41, 0);
		return retVal;
    }



    /**
     * Returns
     * PSL-42: "External Scaling Factor Technical Part" - creates it if necessary
     */
    public NM getExternalScalingFactorTechnicalPart() { 
		NM retVal = this.getTypedField(42, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PSL-42: "External Scaling Factor Technical Part" - creates it if necessary
     */
    public NM getPsl42_ExternalScalingFactorTechnicalPart() { 
		NM retVal = this.getTypedField(42, 0);
		return retVal;
    }



    /**
     * Returns
     * PSL-43: "Amount Technical Part" - creates it if necessary
     */
    public CP getAmountTechnicalPart() { 
		CP retVal = this.getTypedField(43, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PSL-43: "Amount Technical Part" - creates it if necessary
     */
    public CP getPsl43_AmountTechnicalPart() { 
		CP retVal = this.getTypedField(43, 0);
		return retVal;
    }



    /**
     * Returns
     * PSL-44: "Total Amount Professional Part + Technical Part" - creates it if necessary
     */
    public CP getTotalAmountProfessionalPartTechnicalPart() { 
		CP retVal = this.getTypedField(44, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PSL-44: "Total Amount Professional Part + Technical Part" - creates it if necessary
     */
    public CP getPsl44_TotalAmountProfessionalPartTechnicalPart() { 
		CP retVal = this.getTypedField(44, 0);
		return retVal;
    }



    /**
     * Returns
     * PSL-45: "VAT-Rate" - creates it if necessary
     */
    public NM getVATRate() { 
		NM retVal = this.getTypedField(45, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PSL-45: "VAT-Rate" - creates it if necessary
     */
    public NM getPsl45_VATRate() { 
		NM retVal = this.getTypedField(45, 0);
		return retVal;
    }



    /**
     * Returns
     * PSL-46: "Main-Service" - creates it if necessary
     */
    public ID getMainService() { 
		ID retVal = this.getTypedField(46, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PSL-46: "Main-Service" - creates it if necessary
     */
    public ID getPsl46_MainService() { 
		ID retVal = this.getTypedField(46, 0);
		return retVal;
    }



    /**
     * Returns
     * PSL-47: "Validation" - creates it if necessary
     */
    public ID getValidation() { 
		ID retVal = this.getTypedField(47, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PSL-47: "Validation" - creates it if necessary
     */
    public ID getPsl47_Validation() { 
		ID retVal = this.getTypedField(47, 0);
		return retVal;
    }



    /**
     * Returns
     * PSL-48: "Comment" - creates it if necessary
     */
    public ST getComment() { 
		ST retVal = this.getTypedField(48, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PSL-48: "Comment" - creates it if necessary
     */
    public ST getPsl48_Comment() { 
		ST retVal = this.getTypedField(48, 0);
		return retVal;
    }





    /** {@inheritDoc} */   
    protected Type createNewTypeWithoutReflection(int field) {
       switch (field) {
          case 0: return new EI(getMessage());
          case 1: return new EI(getMessage());
          case 2: return new SI(getMessage());
          case 3: return new EI(getMessage());
          case 4: return new EI(getMessage());
          case 5: return new CWE(getMessage());
          case 6: return new CWE(getMessage());
          case 7: return new CWE(getMessage());
          case 8: return new ST(getMessage());
          case 9: return new DTM(getMessage());
          case 10: return new DTM(getMessage());
          case 11: return new CQ(getMessage());
          case 12: return new CP(getMessage());
          case 13: return new NM(getMessage());
          case 14: return new CP(getMessage());
          case 15: return new CP(getMessage());
          case 16: return new CWE(getMessage());
          case 17: return new ST(getMessage());
          case 18: return new EI(getMessage());
          case 19: return new CWE(getMessage());
          case 20: return new ID(getMessage(), new Integer( 532 ));
          case 21: return new CWE(getMessage());
          case 22: return new CP(getMessage());
          case 23: return new NM(getMessage());
          case 24: return new CX(getMessage());
          case 25: return new DR(getMessage());
          case 26: return new NM(getMessage());
          case 27: return new NM(getMessage());
          case 28: return new XCN(getMessage());
          case 29: return new XCN(getMessage());
          case 30: return new CWE(getMessage());
          case 31: return new CWE(getMessage());
          case 32: return new CWE(getMessage());
          case 33: return new NM(getMessage());
          case 34: return new CP(getMessage());
          case 35: return new NM(getMessage());
          case 36: return new NM(getMessage());
          case 37: return new CP(getMessage());
          case 38: return new NM(getMessage());
          case 39: return new CP(getMessage());
          case 40: return new NM(getMessage());
          case 41: return new NM(getMessage());
          case 42: return new CP(getMessage());
          case 43: return new CP(getMessage());
          case 44: return new NM(getMessage());
          case 45: return new ID(getMessage(), new Integer( 0 ));
          case 46: return new ID(getMessage(), new Integer( 136 ));
          case 47: return new ST(getMessage());
          default: return null;
       }
   }


}

