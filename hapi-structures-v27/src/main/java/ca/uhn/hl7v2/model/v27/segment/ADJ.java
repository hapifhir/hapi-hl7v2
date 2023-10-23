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


package ca.uhn.hl7v2.model.v27.segment;

// import ca.uhn.hl7v2.model.v27.group.*;
import ca.uhn.hl7v2.model.v27.datatype.*;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.parser.DefaultModelClassFactory;
import ca.uhn.hl7v2.model.AbstractMessage;
import ca.uhn.hl7v2.model.Group;
import ca.uhn.hl7v2.model.Type;
import ca.uhn.hl7v2.model.AbstractSegment;
import ca.uhn.hl7v2.model.Varies;


/**
 *<p>Represents an HL7 ADJ message segment (Adjustment). 
 * This segment has the following fields:</p>
 * <ul>
     * <li>ADJ-1: Provider Adjustment Number (EI) <b> </b>
     * <li>ADJ-2: Payer Adjustment Number (EI) <b> </b>
     * <li>ADJ-3: Adjustment Sequence Number (SI) <b> </b>
     * <li>ADJ-4: Adjustment Category (CWE) <b> </b>
     * <li>ADJ-5: Adjustment Amount (CP) <b>optional </b>
     * <li>ADJ-6: Adjustment Quantity (CQ) <b>optional </b>
     * <li>ADJ-7: Adjustment Reason PA (CWE) <b>optional </b>
     * <li>ADJ-8: Adjustment Description (ST) <b>optional </b>
     * <li>ADJ-9: Original Value (NM) <b>optional </b>
     * <li>ADJ-10: Substitute Value (NM) <b>optional </b>
     * <li>ADJ-11: Adjustment Action (CWE) <b>optional </b>
     * <li>ADJ-12: Provider Adjustment Number Cross Reference (EI) <b>optional </b>
     * <li>ADJ-13: Provider Product/Service Line Item Number Cross Reference (EI) <b>optional </b>
     * <li>ADJ-14: Adjustment Date (DTM) <b> </b>
     * <li>ADJ-15: Responsible Organization (XON) <b>optional </b>
 * </ul>
 */
@SuppressWarnings("unused")
public class ADJ extends AbstractSegment {

    /** 
     * Creates a new ADJ segment
     */
    public ADJ(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(EI.class, true, 1, 0, new Object[]{ getMessage() }, "Provider Adjustment Number");
                                  this.add(EI.class, true, 1, 0, new Object[]{ getMessage() }, "Payer Adjustment Number");
                                  this.add(SI.class, true, 1, 4, new Object[]{ getMessage() }, "Adjustment Sequence Number");
                                  this.add(CWE.class, true, 1, 0, new Object[]{ getMessage() }, "Adjustment Category");
                                  this.add(CP.class, false, 1, 0, new Object[]{ getMessage() }, "Adjustment Amount");
                                  this.add(CQ.class, false, 1, 0, new Object[]{ getMessage() }, "Adjustment Quantity");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "Adjustment Reason PA");
                                  this.add(ST.class, false, 1, 0, new Object[]{ getMessage() }, "Adjustment Description");
                                  this.add(NM.class, false, 1, 0, new Object[]{ getMessage() }, "Original Value");
                                  this.add(NM.class, false, 1, 0, new Object[]{ getMessage() }, "Substitute Value");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "Adjustment Action");
                                  this.add(EI.class, false, 1, 0, new Object[]{ getMessage() }, "Provider Adjustment Number Cross Reference");
                                  this.add(EI.class, false, 1, 0, new Object[]{ getMessage() }, "Provider Product/Service Line Item Number Cross Reference");
                                  this.add(DTM.class, true, 1, 0, new Object[]{ getMessage() }, "Adjustment Date");
                                  this.add(XON.class, false, 1, 0, new Object[]{ getMessage() }, "Responsible Organization");
       } catch(HL7Exception e) {
          log.error("Unexpected error creating ADJ - this is probably a bug in the source code generator.", e);
       }
    }



    /**
     * Returns
     * ADJ-1: "Provider Adjustment Number" - creates it if necessary
     */
    public EI getProviderAdjustmentNumber() { 
		EI retVal = this.getTypedField(1, 0);
		return retVal;
    }
    
    /**
     * Returns
     * ADJ-1: "Provider Adjustment Number" - creates it if necessary
     */
    public EI getAdj1_ProviderAdjustmentNumber() { 
		EI retVal = this.getTypedField(1, 0);
		return retVal;
    }



    /**
     * Returns
     * ADJ-2: "Payer Adjustment Number" - creates it if necessary
     */
    public EI getPayerAdjustmentNumber() { 
		EI retVal = this.getTypedField(2, 0);
		return retVal;
    }
    
    /**
     * Returns
     * ADJ-2: "Payer Adjustment Number" - creates it if necessary
     */
    public EI getAdj2_PayerAdjustmentNumber() { 
		EI retVal = this.getTypedField(2, 0);
		return retVal;
    }



    /**
     * Returns
     * ADJ-3: "Adjustment Sequence Number" - creates it if necessary
     */
    public SI getAdjustmentSequenceNumber() { 
		SI retVal = this.getTypedField(3, 0);
		return retVal;
    }
    
    /**
     * Returns
     * ADJ-3: "Adjustment Sequence Number" - creates it if necessary
     */
    public SI getAdj3_AdjustmentSequenceNumber() { 
		SI retVal = this.getTypedField(3, 0);
		return retVal;
    }



    /**
     * Returns
     * ADJ-4: "Adjustment Category" - creates it if necessary
     */
    public CWE getAdjustmentCategory() { 
		CWE retVal = this.getTypedField(4, 0);
		return retVal;
    }
    
    /**
     * Returns
     * ADJ-4: "Adjustment Category" - creates it if necessary
     */
    public CWE getAdj4_AdjustmentCategory() { 
		CWE retVal = this.getTypedField(4, 0);
		return retVal;
    }



    /**
     * Returns
     * ADJ-5: "Adjustment Amount" - creates it if necessary
     */
    public CP getAdjustmentAmount() { 
		CP retVal = this.getTypedField(5, 0);
		return retVal;
    }
    
    /**
     * Returns
     * ADJ-5: "Adjustment Amount" - creates it if necessary
     */
    public CP getAdj5_AdjustmentAmount() { 
		CP retVal = this.getTypedField(5, 0);
		return retVal;
    }



    /**
     * Returns
     * ADJ-6: "Adjustment Quantity" - creates it if necessary
     */
    public CQ getAdjustmentQuantity() { 
		CQ retVal = this.getTypedField(6, 0);
		return retVal;
    }
    
    /**
     * Returns
     * ADJ-6: "Adjustment Quantity" - creates it if necessary
     */
    public CQ getAdj6_AdjustmentQuantity() { 
		CQ retVal = this.getTypedField(6, 0);
		return retVal;
    }



    /**
     * Returns
     * ADJ-7: "Adjustment Reason PA" - creates it if necessary
     */
    public CWE getAdjustmentReasonPA() { 
		CWE retVal = this.getTypedField(7, 0);
		return retVal;
    }
    
    /**
     * Returns
     * ADJ-7: "Adjustment Reason PA" - creates it if necessary
     */
    public CWE getAdj7_AdjustmentReasonPA() { 
		CWE retVal = this.getTypedField(7, 0);
		return retVal;
    }



    /**
     * Returns
     * ADJ-8: "Adjustment Description" - creates it if necessary
     */
    public ST getAdjustmentDescription() { 
		ST retVal = this.getTypedField(8, 0);
		return retVal;
    }
    
    /**
     * Returns
     * ADJ-8: "Adjustment Description" - creates it if necessary
     */
    public ST getAdj8_AdjustmentDescription() { 
		ST retVal = this.getTypedField(8, 0);
		return retVal;
    }



    /**
     * Returns
     * ADJ-9: "Original Value" - creates it if necessary
     */
    public NM getOriginalValue() { 
		NM retVal = this.getTypedField(9, 0);
		return retVal;
    }
    
    /**
     * Returns
     * ADJ-9: "Original Value" - creates it if necessary
     */
    public NM getAdj9_OriginalValue() { 
		NM retVal = this.getTypedField(9, 0);
		return retVal;
    }



    /**
     * Returns
     * ADJ-10: "Substitute Value" - creates it if necessary
     */
    public NM getSubstituteValue() { 
		NM retVal = this.getTypedField(10, 0);
		return retVal;
    }
    
    /**
     * Returns
     * ADJ-10: "Substitute Value" - creates it if necessary
     */
    public NM getAdj10_SubstituteValue() { 
		NM retVal = this.getTypedField(10, 0);
		return retVal;
    }



    /**
     * Returns
     * ADJ-11: "Adjustment Action" - creates it if necessary
     */
    public CWE getAdjustmentAction() { 
		CWE retVal = this.getTypedField(11, 0);
		return retVal;
    }
    
    /**
     * Returns
     * ADJ-11: "Adjustment Action" - creates it if necessary
     */
    public CWE getAdj11_AdjustmentAction() { 
		CWE retVal = this.getTypedField(11, 0);
		return retVal;
    }



    /**
     * Returns
     * ADJ-12: "Provider Adjustment Number Cross Reference" - creates it if necessary
     */
    public EI getProviderAdjustmentNumberCrossReference() { 
		EI retVal = this.getTypedField(12, 0);
		return retVal;
    }
    
    /**
     * Returns
     * ADJ-12: "Provider Adjustment Number Cross Reference" - creates it if necessary
     */
    public EI getAdj12_ProviderAdjustmentNumberCrossReference() { 
		EI retVal = this.getTypedField(12, 0);
		return retVal;
    }



    /**
     * Returns
     * ADJ-13: "Provider Product/Service Line Item Number Cross Reference" - creates it if necessary
     */
    public EI getProviderProductServiceLineItemNumberCrossReference() { 
		EI retVal = this.getTypedField(13, 0);
		return retVal;
    }
    
    /**
     * Returns
     * ADJ-13: "Provider Product/Service Line Item Number Cross Reference" - creates it if necessary
     */
    public EI getAdj13_ProviderProductServiceLineItemNumberCrossReference() { 
		EI retVal = this.getTypedField(13, 0);
		return retVal;
    }



    /**
     * Returns
     * ADJ-14: "Adjustment Date" - creates it if necessary
     */
    public DTM getAdjustmentDate() { 
		DTM retVal = this.getTypedField(14, 0);
		return retVal;
    }
    
    /**
     * Returns
     * ADJ-14: "Adjustment Date" - creates it if necessary
     */
    public DTM getAdj14_AdjustmentDate() { 
		DTM retVal = this.getTypedField(14, 0);
		return retVal;
    }



    /**
     * Returns
     * ADJ-15: "Responsible Organization" - creates it if necessary
     */
    public XON getResponsibleOrganization() { 
		XON retVal = this.getTypedField(15, 0);
		return retVal;
    }
    
    /**
     * Returns
     * ADJ-15: "Responsible Organization" - creates it if necessary
     */
    public XON getAdj15_ResponsibleOrganization() { 
		XON retVal = this.getTypedField(15, 0);
		return retVal;
    }





    /** {@inheritDoc} */   
    protected Type createNewTypeWithoutReflection(int field) {
       switch (field) {
          case 0: return new EI(getMessage());
          case 1: return new EI(getMessage());
          case 2: return new SI(getMessage());
          case 3: return new CWE(getMessage());
          case 4: return new CP(getMessage());
          case 5: return new CQ(getMessage());
          case 6: return new CWE(getMessage());
          case 7: return new ST(getMessage());
          case 8: return new NM(getMessage());
          case 9: return new NM(getMessage());
          case 10: return new CWE(getMessage());
          case 11: return new EI(getMessage());
          case 12: return new EI(getMessage());
          case 13: return new DTM(getMessage());
          case 14: return new XON(getMessage());
          default: return null;
       }
   }


}

