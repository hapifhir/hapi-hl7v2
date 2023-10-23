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
 *<p>Represents an HL7 RQ1 message segment (RQ1 - requisition detail-1 segment). 
 * This segment has the following fields:</p>
 * <ul>
     * <li>RQ1-1: Anticipated Price (ST) <b>optional </b>
     * <li>RQ1-2: Manufacturer ID (CE) <b>optional </b>
     * <li>RQ1-3: Manufacturer’s Catalog (ST) <b>optional </b>
     * <li>RQ1-4: Vendor ID (CE) <b>optional </b>
     * <li>RQ1-5: Vendor Catalog (ST) <b>optional </b>
     * <li>RQ1-6: Taxable (ID) <b>optional </b>
     * <li>RQ1-7: Substitute Allowed (ID) <b>optional </b>
 * </ul>
 */
@SuppressWarnings("unused")
public class RQ1 extends AbstractSegment {

    /** 
     * Creates a new RQ1 segment
     */
    public RQ1(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(ST.class, false, 1, 10, new Object[]{ getMessage() }, "Anticipated Price");
                                  this.add(CE.class, false, 1, 60, new Object[]{ getMessage() }, "Manufacturer ID");
                                  this.add(ST.class, false, 1, 16, new Object[]{ getMessage() }, "Manufacturer’s Catalog");
                                  this.add(CE.class, false, 1, 60, new Object[]{ getMessage() }, "Vendor ID");
                                  this.add(ST.class, false, 1, 16, new Object[]{ getMessage() }, "Vendor Catalog");
                                              this.add(ID.class, false, 1, 1, new Object[]{ getMessage(), new Integer(136) }, "Taxable");
                                              this.add(ID.class, false, 1, 1, new Object[]{ getMessage(), new Integer(136) }, "Substitute Allowed");
       } catch(HL7Exception e) {
          log.error("Unexpected error creating RQ1 - this is probably a bug in the source code generator.", e);
       }
    }



    /**
     * Returns
     * RQ1-1: "Anticipated Price" - creates it if necessary
     */
    public ST getAnticipatedPrice() { 
		ST retVal = this.getTypedField(1, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RQ1-1: "Anticipated Price" - creates it if necessary
     */
    public ST getRq11_AnticipatedPrice() { 
		ST retVal = this.getTypedField(1, 0);
		return retVal;
    }



    /**
     * Returns
     * RQ1-2: "Manufacturer ID" - creates it if necessary
     */
    public CE getManufacturerID() { 
		CE retVal = this.getTypedField(2, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RQ1-2: "Manufacturer ID" - creates it if necessary
     */
    public CE getRq12_ManufacturerID() { 
		CE retVal = this.getTypedField(2, 0);
		return retVal;
    }



    /**
     * Returns
     * RQ1-3: "Manufacturer’s Catalog" - creates it if necessary
     */
    public ST getManufacturerSCatalog() { 
		ST retVal = this.getTypedField(3, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RQ1-3: "Manufacturer’s Catalog" - creates it if necessary
     */
    public ST getRq13_ManufacturerSCatalog() { 
		ST retVal = this.getTypedField(3, 0);
		return retVal;
    }



    /**
     * Returns
     * RQ1-4: "Vendor ID" - creates it if necessary
     */
    public CE getVendorID() { 
		CE retVal = this.getTypedField(4, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RQ1-4: "Vendor ID" - creates it if necessary
     */
    public CE getRq14_VendorID() { 
		CE retVal = this.getTypedField(4, 0);
		return retVal;
    }



    /**
     * Returns
     * RQ1-5: "Vendor Catalog" - creates it if necessary
     */
    public ST getVendorCatalog() { 
		ST retVal = this.getTypedField(5, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RQ1-5: "Vendor Catalog" - creates it if necessary
     */
    public ST getRq15_VendorCatalog() { 
		ST retVal = this.getTypedField(5, 0);
		return retVal;
    }



    /**
     * Returns
     * RQ1-6: "Taxable" - creates it if necessary
     */
    public ID getTaxable() { 
		ID retVal = this.getTypedField(6, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RQ1-6: "Taxable" - creates it if necessary
     */
    public ID getRq16_Taxable() { 
		ID retVal = this.getTypedField(6, 0);
		return retVal;
    }



    /**
     * Returns
     * RQ1-7: "Substitute Allowed" - creates it if necessary
     */
    public ID getSubstituteAllowed() { 
		ID retVal = this.getTypedField(7, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RQ1-7: "Substitute Allowed" - creates it if necessary
     */
    public ID getRq17_SubstituteAllowed() { 
		ID retVal = this.getTypedField(7, 0);
		return retVal;
    }





    /** {@inheritDoc} */   
    protected Type createNewTypeWithoutReflection(int field) {
       switch (field) {
          case 0: return new ST(getMessage());
          case 1: return new CE(getMessage());
          case 2: return new ST(getMessage());
          case 3: return new CE(getMessage());
          case 4: return new ST(getMessage());
          case 5: return new ID(getMessage(), new Integer( 136 ));
          case 6: return new ID(getMessage(), new Integer( 136 ));
          default: return null;
       }
   }


}

