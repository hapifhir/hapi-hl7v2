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
 *<p>Represents an HL7 VND message segment (Purchasing Vendor). 
 * This segment has the following fields:</p>
 * <ul>
     * <li>VND-1: Set Id - VND (SI) <b> </b>
     * <li>VND-2: Vendor Identifier (EI) <b> </b>
     * <li>VND-3: Vendor Name (ST) <b>optional </b>
     * <li>VND-4: Vendor Catalog Number (EI) <b>optional </b>
     * <li>VND-5: Primary Vendor Indicator (CNE) <b>optional </b>
 * </ul>
 */
@SuppressWarnings("unused")
public class VND extends AbstractSegment {

    /** 
     * Creates a new VND segment
     */
    public VND(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(SI.class, true, 1, 0, new Object[]{ getMessage() }, "Set Id - VND");
                                  this.add(EI.class, true, 1, 0, new Object[]{ getMessage() }, "Vendor Identifier");
                                  this.add(ST.class, false, 1, 0, new Object[]{ getMessage() }, "Vendor Name");
                                  this.add(EI.class, false, 1, 0, new Object[]{ getMessage() }, "Vendor Catalog Number");
                                  this.add(CNE.class, false, 1, 0, new Object[]{ getMessage() }, "Primary Vendor Indicator");
       } catch(HL7Exception e) {
          log.error("Unexpected error creating VND - this is probably a bug in the source code generator.", e);
       }
    }



    /**
     * Returns
     * VND-1: "Set Id - VND" - creates it if necessary
     */
    public SI getSetIdVND() { 
		SI retVal = this.getTypedField(1, 0);
		return retVal;
    }
    
    /**
     * Returns
     * VND-1: "Set Id - VND" - creates it if necessary
     */
    public SI getVnd1_SetIdVND() { 
		SI retVal = this.getTypedField(1, 0);
		return retVal;
    }



    /**
     * Returns
     * VND-2: "Vendor Identifier" - creates it if necessary
     */
    public EI getVendorIdentifier() { 
		EI retVal = this.getTypedField(2, 0);
		return retVal;
    }
    
    /**
     * Returns
     * VND-2: "Vendor Identifier" - creates it if necessary
     */
    public EI getVnd2_VendorIdentifier() { 
		EI retVal = this.getTypedField(2, 0);
		return retVal;
    }



    /**
     * Returns
     * VND-3: "Vendor Name" - creates it if necessary
     */
    public ST getVendorName() { 
		ST retVal = this.getTypedField(3, 0);
		return retVal;
    }
    
    /**
     * Returns
     * VND-3: "Vendor Name" - creates it if necessary
     */
    public ST getVnd3_VendorName() { 
		ST retVal = this.getTypedField(3, 0);
		return retVal;
    }



    /**
     * Returns
     * VND-4: "Vendor Catalog Number" - creates it if necessary
     */
    public EI getVendorCatalogNumber() { 
		EI retVal = this.getTypedField(4, 0);
		return retVal;
    }
    
    /**
     * Returns
     * VND-4: "Vendor Catalog Number" - creates it if necessary
     */
    public EI getVnd4_VendorCatalogNumber() { 
		EI retVal = this.getTypedField(4, 0);
		return retVal;
    }



    /**
     * Returns
     * VND-5: "Primary Vendor Indicator" - creates it if necessary
     */
    public CNE getPrimaryVendorIndicator() { 
		CNE retVal = this.getTypedField(5, 0);
		return retVal;
    }
    
    /**
     * Returns
     * VND-5: "Primary Vendor Indicator" - creates it if necessary
     */
    public CNE getVnd5_PrimaryVendorIndicator() { 
		CNE retVal = this.getTypedField(5, 0);
		return retVal;
    }





    /** {@inheritDoc} */   
    protected Type createNewTypeWithoutReflection(int field) {
       switch (field) {
          case 0: return new SI(getMessage());
          case 1: return new EI(getMessage());
          case 2: return new ST(getMessage());
          case 3: return new EI(getMessage());
          case 4: return new CNE(getMessage());
          default: return null;
       }
   }


}

