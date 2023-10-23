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
 *<p>Represents an HL7 PKG message segment (Item Packaging). 
 * This segment has the following fields:</p>
 * <ul>
     * <li>PKG-1: Set Id - PKG (SI) <b> </b>
     * <li>PKG-2: Packaging Units (CWE) <b>optional </b>
     * <li>PKG-3: Default Order Unit Of Measure Indicator (CNE) <b>optional </b>
     * <li>PKG-4: Package Quantity (NM) <b>optional </b>
     * <li>PKG-5: Price (CP) <b>optional </b>
     * <li>PKG-6: Future Item Price (CP) <b>optional </b>
     * <li>PKG-7: Future Item Price Effective Date (DTM) <b>optional </b>
     * <li>PKG-8: Global Trade Item Number (CWE) <b>optional </b>
 * </ul>
 */
@SuppressWarnings("unused")
public class PKG extends AbstractSegment {

    /** 
     * Creates a new PKG segment
     */
    public PKG(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(SI.class, true, 1, 4, new Object[]{ getMessage() }, "Set Id - PKG");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "Packaging Units");
                                  this.add(CNE.class, false, 1, 0, new Object[]{ getMessage() }, "Default Order Unit Of Measure Indicator");
                                  this.add(NM.class, false, 1, 0, new Object[]{ getMessage() }, "Package Quantity");
                                  this.add(CP.class, false, 1, 0, new Object[]{ getMessage() }, "Price");
                                  this.add(CP.class, false, 1, 0, new Object[]{ getMessage() }, "Future Item Price");
                                  this.add(DTM.class, false, 1, 0, new Object[]{ getMessage() }, "Future Item Price Effective Date");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "Global Trade Item Number");
       } catch(HL7Exception e) {
          log.error("Unexpected error creating PKG - this is probably a bug in the source code generator.", e);
       }
    }



    /**
     * Returns
     * PKG-1: "Set Id - PKG" - creates it if necessary
     */
    public SI getSetIdPKG() { 
		SI retVal = this.getTypedField(1, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PKG-1: "Set Id - PKG" - creates it if necessary
     */
    public SI getPkg1_SetIdPKG() { 
		SI retVal = this.getTypedField(1, 0);
		return retVal;
    }



    /**
     * Returns
     * PKG-2: "Packaging Units" - creates it if necessary
     */
    public CWE getPackagingUnits() { 
		CWE retVal = this.getTypedField(2, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PKG-2: "Packaging Units" - creates it if necessary
     */
    public CWE getPkg2_PackagingUnits() { 
		CWE retVal = this.getTypedField(2, 0);
		return retVal;
    }



    /**
     * Returns
     * PKG-3: "Default Order Unit Of Measure Indicator" - creates it if necessary
     */
    public CNE getDefaultOrderUnitOfMeasureIndicator() { 
		CNE retVal = this.getTypedField(3, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PKG-3: "Default Order Unit Of Measure Indicator" - creates it if necessary
     */
    public CNE getPkg3_DefaultOrderUnitOfMeasureIndicator() { 
		CNE retVal = this.getTypedField(3, 0);
		return retVal;
    }



    /**
     * Returns
     * PKG-4: "Package Quantity" - creates it if necessary
     */
    public NM getPackageQuantity() { 
		NM retVal = this.getTypedField(4, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PKG-4: "Package Quantity" - creates it if necessary
     */
    public NM getPkg4_PackageQuantity() { 
		NM retVal = this.getTypedField(4, 0);
		return retVal;
    }



    /**
     * Returns
     * PKG-5: "Price" - creates it if necessary
     */
    public CP getPrice() { 
		CP retVal = this.getTypedField(5, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PKG-5: "Price" - creates it if necessary
     */
    public CP getPkg5_Price() { 
		CP retVal = this.getTypedField(5, 0);
		return retVal;
    }



    /**
     * Returns
     * PKG-6: "Future Item Price" - creates it if necessary
     */
    public CP getFutureItemPrice() { 
		CP retVal = this.getTypedField(6, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PKG-6: "Future Item Price" - creates it if necessary
     */
    public CP getPkg6_FutureItemPrice() { 
		CP retVal = this.getTypedField(6, 0);
		return retVal;
    }



    /**
     * Returns
     * PKG-7: "Future Item Price Effective Date" - creates it if necessary
     */
    public DTM getFutureItemPriceEffectiveDate() { 
		DTM retVal = this.getTypedField(7, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PKG-7: "Future Item Price Effective Date" - creates it if necessary
     */
    public DTM getPkg7_FutureItemPriceEffectiveDate() { 
		DTM retVal = this.getTypedField(7, 0);
		return retVal;
    }



    /**
     * Returns
     * PKG-8: "Global Trade Item Number" - creates it if necessary
     */
    public CWE getGlobalTradeItemNumber() { 
		CWE retVal = this.getTypedField(8, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PKG-8: "Global Trade Item Number" - creates it if necessary
     */
    public CWE getPkg8_GlobalTradeItemNumber() { 
		CWE retVal = this.getTypedField(8, 0);
		return retVal;
    }





    /** {@inheritDoc} */   
    protected Type createNewTypeWithoutReflection(int field) {
       switch (field) {
          case 0: return new SI(getMessage());
          case 1: return new CWE(getMessage());
          case 2: return new CNE(getMessage());
          case 3: return new NM(getMessage());
          case 4: return new CP(getMessage());
          case 5: return new CP(getMessage());
          case 6: return new DTM(getMessage());
          case 7: return new CWE(getMessage());
          default: return null;
       }
   }


}

