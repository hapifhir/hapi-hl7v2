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
 *<p>Represents an HL7 PSS message segment (Product/Service Section). 
 * This segment has the following fields:</p>
 * <ul>
     * <li>PSS-1: Provider Product/Service Section Number (EI) <b> </b>
     * <li>PSS-2: Payer Product/Service Section Number (EI) <b>optional </b>
     * <li>PSS-3: Product/Service Section Sequence Number (SI) <b> </b>
     * <li>PSS-4: Billed Amount (CP) <b> </b>
     * <li>PSS-5: Section Description or Heading (ST) <b> </b>
 * </ul>
 */
@SuppressWarnings("unused")
public class PSS extends AbstractSegment {

    /** 
     * Creates a new PSS segment
     */
    public PSS(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(EI.class, true, 1, 0, new Object[]{ getMessage() }, "Provider Product/Service Section Number");
                                  this.add(EI.class, false, 1, 0, new Object[]{ getMessage() }, "Payer Product/Service Section Number");
                                  this.add(SI.class, true, 1, 4, new Object[]{ getMessage() }, "Product/Service Section Sequence Number");
                                  this.add(CP.class, true, 1, 0, new Object[]{ getMessage() }, "Billed Amount");
                                  this.add(ST.class, true, 1, 0, new Object[]{ getMessage() }, "Section Description or Heading");
       } catch(HL7Exception e) {
          log.error("Unexpected error creating PSS - this is probably a bug in the source code generator.", e);
       }
    }



    /**
     * Returns
     * PSS-1: "Provider Product/Service Section Number" - creates it if necessary
     */
    public EI getProviderProductServiceSectionNumber() { 
		EI retVal = this.getTypedField(1, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PSS-1: "Provider Product/Service Section Number" - creates it if necessary
     */
    public EI getPss1_ProviderProductServiceSectionNumber() { 
		EI retVal = this.getTypedField(1, 0);
		return retVal;
    }



    /**
     * Returns
     * PSS-2: "Payer Product/Service Section Number" - creates it if necessary
     */
    public EI getPayerProductServiceSectionNumber() { 
		EI retVal = this.getTypedField(2, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PSS-2: "Payer Product/Service Section Number" - creates it if necessary
     */
    public EI getPss2_PayerProductServiceSectionNumber() { 
		EI retVal = this.getTypedField(2, 0);
		return retVal;
    }



    /**
     * Returns
     * PSS-3: "Product/Service Section Sequence Number" - creates it if necessary
     */
    public SI getProductServiceSectionSequenceNumber() { 
		SI retVal = this.getTypedField(3, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PSS-3: "Product/Service Section Sequence Number" - creates it if necessary
     */
    public SI getPss3_ProductServiceSectionSequenceNumber() { 
		SI retVal = this.getTypedField(3, 0);
		return retVal;
    }



    /**
     * Returns
     * PSS-4: "Billed Amount" - creates it if necessary
     */
    public CP getBilledAmount() { 
		CP retVal = this.getTypedField(4, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PSS-4: "Billed Amount" - creates it if necessary
     */
    public CP getPss4_BilledAmount() { 
		CP retVal = this.getTypedField(4, 0);
		return retVal;
    }



    /**
     * Returns
     * PSS-5: "Section Description or Heading" - creates it if necessary
     */
    public ST getSectionDescriptionOrHeading() { 
		ST retVal = this.getTypedField(5, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PSS-5: "Section Description or Heading" - creates it if necessary
     */
    public ST getPss5_SectionDescriptionOrHeading() { 
		ST retVal = this.getTypedField(5, 0);
		return retVal;
    }





    /** {@inheritDoc} */   
    protected Type createNewTypeWithoutReflection(int field) {
       switch (field) {
          case 0: return new EI(getMessage());
          case 1: return new EI(getMessage());
          case 2: return new SI(getMessage());
          case 3: return new CP(getMessage());
          case 4: return new ST(getMessage());
          default: return null;
       }
   }


}

