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


package ca.uhn.hl7v2.model.v26.segment;

// import ca.uhn.hl7v2.model.v26.group.*;
import ca.uhn.hl7v2.model.v26.datatype.*;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.parser.DefaultModelClassFactory;
import ca.uhn.hl7v2.model.AbstractMessage;
import ca.uhn.hl7v2.model.Group;
import ca.uhn.hl7v2.model.Type;
import ca.uhn.hl7v2.model.AbstractSegment;
import ca.uhn.hl7v2.model.Varies;


/**
 *<p>Represents an HL7 PYE message segment (Payee Information). 
 * This segment has the following fields:</p>
 * <ul>
     * <li>PYE-1: Set ID - PYE (SI) <b> </b>
     * <li>PYE-2: Payee Type (IS) <b> </b>
     * <li>PYE-3: Payee Relationship to Invoice (Patient) (IS) <b>optional </b>
     * <li>PYE-4: Payee Identification List (XON) <b>optional </b>
     * <li>PYE-5: Payee Person Name (XPN) <b>optional </b>
     * <li>PYE-6: Payee Address (XAD) <b>optional </b>
     * <li>PYE-7: Payment Method (IS) <b>optional </b>
 * </ul>
 */
@SuppressWarnings("unused")
public class PYE extends AbstractSegment {

    /** 
     * Creates a new PYE segment
     */
    public PYE(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(SI.class, true, 1, 4, new Object[]{ getMessage() }, "Set ID - PYE");
                                              this.add(IS.class, true, 1, 6, new Object[]{ getMessage(), new Integer(557) }, "Payee Type");
                                              this.add(IS.class, false, 1, 2, new Object[]{ getMessage(), new Integer(558) }, "Payee Relationship to Invoice (Patient)");
                                  this.add(XON.class, false, 1, 183, new Object[]{ getMessage() }, "Payee Identification List");
                                  this.add(XPN.class, false, 1, 466, new Object[]{ getMessage() }, "Payee Person Name");
                                  this.add(XAD.class, false, 1, 235, new Object[]{ getMessage() }, "Payee Address");
                                              this.add(IS.class, false, 1, 80, new Object[]{ getMessage(), new Integer(570) }, "Payment Method");
       } catch(HL7Exception e) {
          log.error("Unexpected error creating PYE - this is probably a bug in the source code generator.", e);
       }
    }



    /**
     * Returns
     * PYE-1: "Set ID - PYE" - creates it if necessary
     */
    public SI getSetIDPYE() { 
		SI retVal = this.getTypedField(1, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PYE-1: "Set ID - PYE" - creates it if necessary
     */
    public SI getPye1_SetIDPYE() { 
		SI retVal = this.getTypedField(1, 0);
		return retVal;
    }



    /**
     * Returns
     * PYE-2: "Payee Type" - creates it if necessary
     */
    public IS getPayeeType() { 
		IS retVal = this.getTypedField(2, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PYE-2: "Payee Type" - creates it if necessary
     */
    public IS getPye2_PayeeType() { 
		IS retVal = this.getTypedField(2, 0);
		return retVal;
    }



    /**
     * Returns
     * PYE-3: "Payee Relationship to Invoice (Patient)" - creates it if necessary
     */
    public IS getPayeeRelationshipToInvoicePatient() { 
		IS retVal = this.getTypedField(3, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PYE-3: "Payee Relationship to Invoice (Patient)" - creates it if necessary
     */
    public IS getPye3_PayeeRelationshipToInvoicePatient() { 
		IS retVal = this.getTypedField(3, 0);
		return retVal;
    }



    /**
     * Returns
     * PYE-4: "Payee Identification List" - creates it if necessary
     */
    public XON getPayeeIdentificationList() { 
		XON retVal = this.getTypedField(4, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PYE-4: "Payee Identification List" - creates it if necessary
     */
    public XON getPye4_PayeeIdentificationList() { 
		XON retVal = this.getTypedField(4, 0);
		return retVal;
    }



    /**
     * Returns
     * PYE-5: "Payee Person Name" - creates it if necessary
     */
    public XPN getPayeePersonName() { 
		XPN retVal = this.getTypedField(5, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PYE-5: "Payee Person Name" - creates it if necessary
     */
    public XPN getPye5_PayeePersonName() { 
		XPN retVal = this.getTypedField(5, 0);
		return retVal;
    }



    /**
     * Returns
     * PYE-6: "Payee Address" - creates it if necessary
     */
    public XAD getPayeeAddress() { 
		XAD retVal = this.getTypedField(6, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PYE-6: "Payee Address" - creates it if necessary
     */
    public XAD getPye6_PayeeAddress() { 
		XAD retVal = this.getTypedField(6, 0);
		return retVal;
    }



    /**
     * Returns
     * PYE-7: "Payment Method" - creates it if necessary
     */
    public IS getPaymentMethod() { 
		IS retVal = this.getTypedField(7, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PYE-7: "Payment Method" - creates it if necessary
     */
    public IS getPye7_PaymentMethod() { 
		IS retVal = this.getTypedField(7, 0);
		return retVal;
    }





    /** {@inheritDoc} */   
    protected Type createNewTypeWithoutReflection(int field) {
       switch (field) {
          case 0: return new SI(getMessage());
          case 1: return new IS(getMessage(), new Integer( 557 ));
          case 2: return new IS(getMessage(), new Integer( 558 ));
          case 3: return new XON(getMessage());
          case 4: return new XPN(getMessage());
          case 5: return new XAD(getMessage());
          case 6: return new IS(getMessage(), new Integer( 570 ));
          default: return null;
       }
   }


}

