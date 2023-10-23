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
 *<p>Represents an HL7 PSG message segment (Product/Service Group). 
 * This segment has the following fields:</p>
 * <ul>
     * <li>PSG-1: Provider Product/Service Group Number (EI) <b> </b>
     * <li>PSG-2: Payer Product/Service Group Number (EI) <b>optional </b>
     * <li>PSG-3: Product/Service Group Sequence Number (SI) <b> </b>
     * <li>PSG-4: Adjudicate as Group (ID) <b> </b>
     * <li>PSG-5: Product/Service Group Billed Amount (CP) <b> </b>
     * <li>PSG-6: Product/Service Group Description (ST) <b> </b>
 * </ul>
 */
@SuppressWarnings("unused")
public class PSG extends AbstractSegment {

    /** 
     * Creates a new PSG segment
     */
    public PSG(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(EI.class, true, 1, 0, new Object[]{ getMessage() }, "Provider Product/Service Group Number");
                                  this.add(EI.class, false, 1, 0, new Object[]{ getMessage() }, "Payer Product/Service Group Number");
                                  this.add(SI.class, true, 1, 4, new Object[]{ getMessage() }, "Product/Service Group Sequence Number");
                                              this.add(ID.class, true, 1, 1, new Object[]{ getMessage(), new Integer(136) }, "Adjudicate as Group");
                                  this.add(CP.class, true, 1, 0, new Object[]{ getMessage() }, "Product/Service Group Billed Amount");
                                  this.add(ST.class, true, 1, 0, new Object[]{ getMessage() }, "Product/Service Group Description");
       } catch(HL7Exception e) {
          log.error("Unexpected error creating PSG - this is probably a bug in the source code generator.", e);
       }
    }



    /**
     * Returns
     * PSG-1: "Provider Product/Service Group Number" - creates it if necessary
     */
    public EI getProviderProductServiceGroupNumber() { 
		EI retVal = this.getTypedField(1, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PSG-1: "Provider Product/Service Group Number" - creates it if necessary
     */
    public EI getPsg1_ProviderProductServiceGroupNumber() { 
		EI retVal = this.getTypedField(1, 0);
		return retVal;
    }



    /**
     * Returns
     * PSG-2: "Payer Product/Service Group Number" - creates it if necessary
     */
    public EI getPayerProductServiceGroupNumber() { 
		EI retVal = this.getTypedField(2, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PSG-2: "Payer Product/Service Group Number" - creates it if necessary
     */
    public EI getPsg2_PayerProductServiceGroupNumber() { 
		EI retVal = this.getTypedField(2, 0);
		return retVal;
    }



    /**
     * Returns
     * PSG-3: "Product/Service Group Sequence Number" - creates it if necessary
     */
    public SI getProductServiceGroupSequenceNumber() { 
		SI retVal = this.getTypedField(3, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PSG-3: "Product/Service Group Sequence Number" - creates it if necessary
     */
    public SI getPsg3_ProductServiceGroupSequenceNumber() { 
		SI retVal = this.getTypedField(3, 0);
		return retVal;
    }



    /**
     * Returns
     * PSG-4: "Adjudicate as Group" - creates it if necessary
     */
    public ID getAdjudicateAsGroup() { 
		ID retVal = this.getTypedField(4, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PSG-4: "Adjudicate as Group" - creates it if necessary
     */
    public ID getPsg4_AdjudicateAsGroup() { 
		ID retVal = this.getTypedField(4, 0);
		return retVal;
    }



    /**
     * Returns
     * PSG-5: "Product/Service Group Billed Amount" - creates it if necessary
     */
    public CP getProductServiceGroupBilledAmount() { 
		CP retVal = this.getTypedField(5, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PSG-5: "Product/Service Group Billed Amount" - creates it if necessary
     */
    public CP getPsg5_ProductServiceGroupBilledAmount() { 
		CP retVal = this.getTypedField(5, 0);
		return retVal;
    }



    /**
     * Returns
     * PSG-6: "Product/Service Group Description" - creates it if necessary
     */
    public ST getProductServiceGroupDescription() { 
		ST retVal = this.getTypedField(6, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PSG-6: "Product/Service Group Description" - creates it if necessary
     */
    public ST getPsg6_ProductServiceGroupDescription() { 
		ST retVal = this.getTypedField(6, 0);
		return retVal;
    }





    /** {@inheritDoc} */   
    protected Type createNewTypeWithoutReflection(int field) {
       switch (field) {
          case 0: return new EI(getMessage());
          case 1: return new EI(getMessage());
          case 2: return new SI(getMessage());
          case 3: return new ID(getMessage(), new Integer( 136 ));
          case 4: return new CP(getMessage());
          case 5: return new ST(getMessage());
          default: return null;
       }
   }


}

