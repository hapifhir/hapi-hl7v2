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
 *<p>Represents an HL7 DRG message segment (Diagnosis Related Group). 
 * This segment has the following fields:</p>
 * <ul>
     * <li>DRG-1: Diagnostic Related Group (CE) <b>optional </b>
     * <li>DRG-2: DRG Assigned Date/Time (TS) <b>optional </b>
     * <li>DRG-3: DRG Approval Indicator (ID) <b>optional </b>
     * <li>DRG-4: DRG Grouper Review Code (IS) <b>optional </b>
     * <li>DRG-5: Outlier Type (CE) <b>optional </b>
     * <li>DRG-6: Outlier Days (NM) <b>optional </b>
     * <li>DRG-7: Outlier Cost (CP) <b>optional </b>
     * <li>DRG-8: DRG Payor (IS) <b>optional </b>
     * <li>DRG-9: Outlier Reimbursement (CP) <b>optional </b>
     * <li>DRG-10: Confidential Indicator (ID) <b>optional </b>
     * <li>DRG-11: DRG Transfer Type (IS) <b>optional </b>
 * </ul>
 */
@SuppressWarnings("unused")
public class DRG extends AbstractSegment {

    /** 
     * Creates a new DRG segment
     */
    public DRG(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(CE.class, false, 1, 250, new Object[]{ getMessage() }, "Diagnostic Related Group");
                                  this.add(TS.class, false, 1, 26, new Object[]{ getMessage() }, "DRG Assigned Date/Time");
                                              this.add(ID.class, false, 1, 1, new Object[]{ getMessage(), new Integer(136) }, "DRG Approval Indicator");
                                              this.add(IS.class, false, 1, 2, new Object[]{ getMessage(), new Integer(56) }, "DRG Grouper Review Code");
                                  this.add(CE.class, false, 1, 250, new Object[]{ getMessage() }, "Outlier Type");
                                  this.add(NM.class, false, 1, 3, new Object[]{ getMessage() }, "Outlier Days");
                                  this.add(CP.class, false, 1, 12, new Object[]{ getMessage() }, "Outlier Cost");
                                              this.add(IS.class, false, 1, 1, new Object[]{ getMessage(), new Integer(229) }, "DRG Payor");
                                  this.add(CP.class, false, 1, 9, new Object[]{ getMessage() }, "Outlier Reimbursement");
                                              this.add(ID.class, false, 1, 1, new Object[]{ getMessage(), new Integer(136) }, "Confidential Indicator");
                                              this.add(IS.class, false, 1, 21, new Object[]{ getMessage(), new Integer(415) }, "DRG Transfer Type");
       } catch(HL7Exception e) {
          log.error("Unexpected error creating DRG - this is probably a bug in the source code generator.", e);
       }
    }



    /**
     * Returns
     * DRG-1: "Diagnostic Related Group" - creates it if necessary
     */
    public CE getDiagnosticRelatedGroup() { 
		CE retVal = this.getTypedField(1, 0);
		return retVal;
    }
    
    /**
     * Returns
     * DRG-1: "Diagnostic Related Group" - creates it if necessary
     */
    public CE getDrg1_DiagnosticRelatedGroup() { 
		CE retVal = this.getTypedField(1, 0);
		return retVal;
    }



    /**
     * Returns
     * DRG-2: "DRG Assigned Date/Time" - creates it if necessary
     */
    public TS getDRGAssignedDateTime() { 
		TS retVal = this.getTypedField(2, 0);
		return retVal;
    }
    
    /**
     * Returns
     * DRG-2: "DRG Assigned Date/Time" - creates it if necessary
     */
    public TS getDrg2_DRGAssignedDateTime() { 
		TS retVal = this.getTypedField(2, 0);
		return retVal;
    }



    /**
     * Returns
     * DRG-3: "DRG Approval Indicator" - creates it if necessary
     */
    public ID getDRGApprovalIndicator() { 
		ID retVal = this.getTypedField(3, 0);
		return retVal;
    }
    
    /**
     * Returns
     * DRG-3: "DRG Approval Indicator" - creates it if necessary
     */
    public ID getDrg3_DRGApprovalIndicator() { 
		ID retVal = this.getTypedField(3, 0);
		return retVal;
    }



    /**
     * Returns
     * DRG-4: "DRG Grouper Review Code" - creates it if necessary
     */
    public IS getDRGGrouperReviewCode() { 
		IS retVal = this.getTypedField(4, 0);
		return retVal;
    }
    
    /**
     * Returns
     * DRG-4: "DRG Grouper Review Code" - creates it if necessary
     */
    public IS getDrg4_DRGGrouperReviewCode() { 
		IS retVal = this.getTypedField(4, 0);
		return retVal;
    }



    /**
     * Returns
     * DRG-5: "Outlier Type" - creates it if necessary
     */
    public CE getOutlierType() { 
		CE retVal = this.getTypedField(5, 0);
		return retVal;
    }
    
    /**
     * Returns
     * DRG-5: "Outlier Type" - creates it if necessary
     */
    public CE getDrg5_OutlierType() { 
		CE retVal = this.getTypedField(5, 0);
		return retVal;
    }



    /**
     * Returns
     * DRG-6: "Outlier Days" - creates it if necessary
     */
    public NM getOutlierDays() { 
		NM retVal = this.getTypedField(6, 0);
		return retVal;
    }
    
    /**
     * Returns
     * DRG-6: "Outlier Days" - creates it if necessary
     */
    public NM getDrg6_OutlierDays() { 
		NM retVal = this.getTypedField(6, 0);
		return retVal;
    }



    /**
     * Returns
     * DRG-7: "Outlier Cost" - creates it if necessary
     */
    public CP getOutlierCost() { 
		CP retVal = this.getTypedField(7, 0);
		return retVal;
    }
    
    /**
     * Returns
     * DRG-7: "Outlier Cost" - creates it if necessary
     */
    public CP getDrg7_OutlierCost() { 
		CP retVal = this.getTypedField(7, 0);
		return retVal;
    }



    /**
     * Returns
     * DRG-8: "DRG Payor" - creates it if necessary
     */
    public IS getDRGPayor() { 
		IS retVal = this.getTypedField(8, 0);
		return retVal;
    }
    
    /**
     * Returns
     * DRG-8: "DRG Payor" - creates it if necessary
     */
    public IS getDrg8_DRGPayor() { 
		IS retVal = this.getTypedField(8, 0);
		return retVal;
    }



    /**
     * Returns
     * DRG-9: "Outlier Reimbursement" - creates it if necessary
     */
    public CP getOutlierReimbursement() { 
		CP retVal = this.getTypedField(9, 0);
		return retVal;
    }
    
    /**
     * Returns
     * DRG-9: "Outlier Reimbursement" - creates it if necessary
     */
    public CP getDrg9_OutlierReimbursement() { 
		CP retVal = this.getTypedField(9, 0);
		return retVal;
    }



    /**
     * Returns
     * DRG-10: "Confidential Indicator" - creates it if necessary
     */
    public ID getConfidentialIndicator() { 
		ID retVal = this.getTypedField(10, 0);
		return retVal;
    }
    
    /**
     * Returns
     * DRG-10: "Confidential Indicator" - creates it if necessary
     */
    public ID getDrg10_ConfidentialIndicator() { 
		ID retVal = this.getTypedField(10, 0);
		return retVal;
    }



    /**
     * Returns
     * DRG-11: "DRG Transfer Type" - creates it if necessary
     */
    public IS getDRGTransferType() { 
		IS retVal = this.getTypedField(11, 0);
		return retVal;
    }
    
    /**
     * Returns
     * DRG-11: "DRG Transfer Type" - creates it if necessary
     */
    public IS getDrg11_DRGTransferType() { 
		IS retVal = this.getTypedField(11, 0);
		return retVal;
    }





    /** {@inheritDoc} */   
    protected Type createNewTypeWithoutReflection(int field) {
       switch (field) {
          case 0: return new CE(getMessage());
          case 1: return new TS(getMessage());
          case 2: return new ID(getMessage(), new Integer( 136 ));
          case 3: return new IS(getMessage(), new Integer( 56 ));
          case 4: return new CE(getMessage());
          case 5: return new NM(getMessage());
          case 6: return new CP(getMessage());
          case 7: return new IS(getMessage(), new Integer( 229 ));
          case 8: return new CP(getMessage());
          case 9: return new ID(getMessage(), new Integer( 136 ));
          case 10: return new IS(getMessage(), new Integer( 415 ));
          default: return null;
       }
   }


}

