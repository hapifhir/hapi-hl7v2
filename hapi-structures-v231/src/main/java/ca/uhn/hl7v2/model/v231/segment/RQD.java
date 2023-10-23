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


package ca.uhn.hl7v2.model.v231.segment;

// import ca.uhn.hl7v2.model.v231.group.*;
import ca.uhn.hl7v2.model.v231.datatype.*;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.parser.DefaultModelClassFactory;
import ca.uhn.hl7v2.model.AbstractMessage;
import ca.uhn.hl7v2.model.Group;
import ca.uhn.hl7v2.model.Type;
import ca.uhn.hl7v2.model.AbstractSegment;
import ca.uhn.hl7v2.model.Varies;


/**
 *<p>Represents an HL7 RQD message segment (RQD - requisition detail segment). 
 * This segment has the following fields:</p>
 * <ul>
     * <li>RQD-1: Requisition Line Number (SI) <b>optional </b>
     * <li>RQD-2: Item Code - Internal (CE) <b>optional </b>
     * <li>RQD-3: Item Code - External (CE) <b>optional </b>
     * <li>RQD-4: Hospital Item Code (CE) <b>optional </b>
     * <li>RQD-5: Requisition Quantity (NM) <b>optional </b>
     * <li>RQD-6: Requisition Unit of Measure (CE) <b>optional </b>
     * <li>RQD-7: Dept. Cost Center (IS) <b>optional </b>
     * <li>RQD-8: Item Natural Account Code (IS) <b>optional </b>
     * <li>RQD-9: Deliver To ID (CE) <b>optional </b>
     * <li>RQD-10: Date Needed (DT) <b>optional </b>
 * </ul>
 */
@SuppressWarnings("unused")
public class RQD extends AbstractSegment {

    /** 
     * Creates a new RQD segment
     */
    public RQD(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(SI.class, false, 1, 4, new Object[]{ getMessage() }, "Requisition Line Number");
                                  this.add(CE.class, false, 1, 60, new Object[]{ getMessage() }, "Item Code - Internal");
                                  this.add(CE.class, false, 1, 60, new Object[]{ getMessage() }, "Item Code - External");
                                  this.add(CE.class, false, 1, 60, new Object[]{ getMessage() }, "Hospital Item Code");
                                  this.add(NM.class, false, 1, 6, new Object[]{ getMessage() }, "Requisition Quantity");
                                  this.add(CE.class, false, 1, 60, new Object[]{ getMessage() }, "Requisition Unit of Measure");
                                              this.add(IS.class, false, 1, 30, new Object[]{ getMessage(), new Integer(319) }, "Dept. Cost Center");
                                              this.add(IS.class, false, 1, 30, new Object[]{ getMessage(), new Integer(320) }, "Item Natural Account Code");
                                  this.add(CE.class, false, 1, 60, new Object[]{ getMessage() }, "Deliver To ID");
                                  this.add(DT.class, false, 1, 8, new Object[]{ getMessage() }, "Date Needed");
       } catch(HL7Exception e) {
          log.error("Unexpected error creating RQD - this is probably a bug in the source code generator.", e);
       }
    }



    /**
     * Returns
     * RQD-1: "Requisition Line Number" - creates it if necessary
     */
    public SI getRequisitionLineNumber() { 
		SI retVal = this.getTypedField(1, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RQD-1: "Requisition Line Number" - creates it if necessary
     */
    public SI getRqd1_RequisitionLineNumber() { 
		SI retVal = this.getTypedField(1, 0);
		return retVal;
    }



    /**
     * Returns
     * RQD-2: "Item Code - Internal" - creates it if necessary
     */
    public CE getItemCodeInternal() { 
		CE retVal = this.getTypedField(2, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RQD-2: "Item Code - Internal" - creates it if necessary
     */
    public CE getRqd2_ItemCodeInternal() { 
		CE retVal = this.getTypedField(2, 0);
		return retVal;
    }



    /**
     * Returns
     * RQD-3: "Item Code - External" - creates it if necessary
     */
    public CE getItemCodeExternal() { 
		CE retVal = this.getTypedField(3, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RQD-3: "Item Code - External" - creates it if necessary
     */
    public CE getRqd3_ItemCodeExternal() { 
		CE retVal = this.getTypedField(3, 0);
		return retVal;
    }



    /**
     * Returns
     * RQD-4: "Hospital Item Code" - creates it if necessary
     */
    public CE getHospitalItemCode() { 
		CE retVal = this.getTypedField(4, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RQD-4: "Hospital Item Code" - creates it if necessary
     */
    public CE getRqd4_HospitalItemCode() { 
		CE retVal = this.getTypedField(4, 0);
		return retVal;
    }



    /**
     * Returns
     * RQD-5: "Requisition Quantity" - creates it if necessary
     */
    public NM getRequisitionQuantity() { 
		NM retVal = this.getTypedField(5, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RQD-5: "Requisition Quantity" - creates it if necessary
     */
    public NM getRqd5_RequisitionQuantity() { 
		NM retVal = this.getTypedField(5, 0);
		return retVal;
    }



    /**
     * Returns
     * RQD-6: "Requisition Unit of Measure" - creates it if necessary
     */
    public CE getRequisitionUnitOfMeasure() { 
		CE retVal = this.getTypedField(6, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RQD-6: "Requisition Unit of Measure" - creates it if necessary
     */
    public CE getRqd6_RequisitionUnitOfMeasure() { 
		CE retVal = this.getTypedField(6, 0);
		return retVal;
    }



    /**
     * Returns
     * RQD-7: "Dept. Cost Center" - creates it if necessary
     */
    public IS getDeptCostCenter() { 
		IS retVal = this.getTypedField(7, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RQD-7: "Dept. Cost Center" - creates it if necessary
     */
    public IS getRqd7_DeptCostCenter() { 
		IS retVal = this.getTypedField(7, 0);
		return retVal;
    }



    /**
     * Returns
     * RQD-8: "Item Natural Account Code" - creates it if necessary
     */
    public IS getItemNaturalAccountCode() { 
		IS retVal = this.getTypedField(8, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RQD-8: "Item Natural Account Code" - creates it if necessary
     */
    public IS getRqd8_ItemNaturalAccountCode() { 
		IS retVal = this.getTypedField(8, 0);
		return retVal;
    }



    /**
     * Returns
     * RQD-9: "Deliver To ID" - creates it if necessary
     */
    public CE getDeliverToID() { 
		CE retVal = this.getTypedField(9, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RQD-9: "Deliver To ID" - creates it if necessary
     */
    public CE getRqd9_DeliverToID() { 
		CE retVal = this.getTypedField(9, 0);
		return retVal;
    }



    /**
     * Returns
     * RQD-10: "Date Needed" - creates it if necessary
     */
    public DT getDateNeeded() { 
		DT retVal = this.getTypedField(10, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RQD-10: "Date Needed" - creates it if necessary
     */
    public DT getRqd10_DateNeeded() { 
		DT retVal = this.getTypedField(10, 0);
		return retVal;
    }





    /** {@inheritDoc} */   
    protected Type createNewTypeWithoutReflection(int field) {
       switch (field) {
          case 0: return new SI(getMessage());
          case 1: return new CE(getMessage());
          case 2: return new CE(getMessage());
          case 3: return new CE(getMessage());
          case 4: return new NM(getMessage());
          case 5: return new CE(getMessage());
          case 6: return new IS(getMessage(), new Integer( 319 ));
          case 7: return new IS(getMessage(), new Integer( 320 ));
          case 8: return new CE(getMessage());
          case 9: return new DT(getMessage());
          default: return null;
       }
   }


}

