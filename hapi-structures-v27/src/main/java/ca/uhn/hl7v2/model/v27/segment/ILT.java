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
 *<p>Represents an HL7 ILT message segment (Material Lot). 
 * This segment has the following fields:</p>
 * <ul>
     * <li>ILT-1: Set Id - ILT (SI) <b> </b>
     * <li>ILT-2: Inventory Lot Number (ST) <b> </b>
     * <li>ILT-3: Inventory Expiration Date (DTM) <b>optional </b>
     * <li>ILT-4: Inventory Received Date (DTM) <b>optional </b>
     * <li>ILT-5: Inventory Received Quantity (NM) <b>optional </b>
     * <li>ILT-6: Inventory Received Quantity Unit (CWE) <b>optional </b>
     * <li>ILT-7: Inventory Received Item Cost (MO) <b>optional </b>
     * <li>ILT-8: Inventory On Hand Date (DTM) <b>optional </b>
     * <li>ILT-9: Inventory On Hand Quantity (NM) <b>optional </b>
     * <li>ILT-10: Inventory On Hand Quantity Unit (CWE) <b>optional </b>
 * </ul>
 */
@SuppressWarnings("unused")
public class ILT extends AbstractSegment {

    /** 
     * Creates a new ILT segment
     */
    public ILT(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(SI.class, true, 1, 4, new Object[]{ getMessage() }, "Set Id - ILT");
                                  this.add(ST.class, true, 1, 0, new Object[]{ getMessage() }, "Inventory Lot Number");
                                  this.add(DTM.class, false, 1, 0, new Object[]{ getMessage() }, "Inventory Expiration Date");
                                  this.add(DTM.class, false, 1, 0, new Object[]{ getMessage() }, "Inventory Received Date");
                                  this.add(NM.class, false, 1, 0, new Object[]{ getMessage() }, "Inventory Received Quantity");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "Inventory Received Quantity Unit");
                                  this.add(MO.class, false, 1, 0, new Object[]{ getMessage() }, "Inventory Received Item Cost");
                                  this.add(DTM.class, false, 1, 0, new Object[]{ getMessage() }, "Inventory On Hand Date");
                                  this.add(NM.class, false, 1, 0, new Object[]{ getMessage() }, "Inventory On Hand Quantity");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "Inventory On Hand Quantity Unit");
       } catch(HL7Exception e) {
          log.error("Unexpected error creating ILT - this is probably a bug in the source code generator.", e);
       }
    }



    /**
     * Returns
     * ILT-1: "Set Id - ILT" - creates it if necessary
     */
    public SI getSetIdILT() { 
		SI retVal = this.getTypedField(1, 0);
		return retVal;
    }
    
    /**
     * Returns
     * ILT-1: "Set Id - ILT" - creates it if necessary
     */
    public SI getIlt1_SetIdILT() { 
		SI retVal = this.getTypedField(1, 0);
		return retVal;
    }



    /**
     * Returns
     * ILT-2: "Inventory Lot Number" - creates it if necessary
     */
    public ST getInventoryLotNumber() { 
		ST retVal = this.getTypedField(2, 0);
		return retVal;
    }
    
    /**
     * Returns
     * ILT-2: "Inventory Lot Number" - creates it if necessary
     */
    public ST getIlt2_InventoryLotNumber() { 
		ST retVal = this.getTypedField(2, 0);
		return retVal;
    }



    /**
     * Returns
     * ILT-3: "Inventory Expiration Date" - creates it if necessary
     */
    public DTM getInventoryExpirationDate() { 
		DTM retVal = this.getTypedField(3, 0);
		return retVal;
    }
    
    /**
     * Returns
     * ILT-3: "Inventory Expiration Date" - creates it if necessary
     */
    public DTM getIlt3_InventoryExpirationDate() { 
		DTM retVal = this.getTypedField(3, 0);
		return retVal;
    }



    /**
     * Returns
     * ILT-4: "Inventory Received Date" - creates it if necessary
     */
    public DTM getInventoryReceivedDate() { 
		DTM retVal = this.getTypedField(4, 0);
		return retVal;
    }
    
    /**
     * Returns
     * ILT-4: "Inventory Received Date" - creates it if necessary
     */
    public DTM getIlt4_InventoryReceivedDate() { 
		DTM retVal = this.getTypedField(4, 0);
		return retVal;
    }



    /**
     * Returns
     * ILT-5: "Inventory Received Quantity" - creates it if necessary
     */
    public NM getInventoryReceivedQuantity() { 
		NM retVal = this.getTypedField(5, 0);
		return retVal;
    }
    
    /**
     * Returns
     * ILT-5: "Inventory Received Quantity" - creates it if necessary
     */
    public NM getIlt5_InventoryReceivedQuantity() { 
		NM retVal = this.getTypedField(5, 0);
		return retVal;
    }



    /**
     * Returns
     * ILT-6: "Inventory Received Quantity Unit" - creates it if necessary
     */
    public CWE getInventoryReceivedQuantityUnit() { 
		CWE retVal = this.getTypedField(6, 0);
		return retVal;
    }
    
    /**
     * Returns
     * ILT-6: "Inventory Received Quantity Unit" - creates it if necessary
     */
    public CWE getIlt6_InventoryReceivedQuantityUnit() { 
		CWE retVal = this.getTypedField(6, 0);
		return retVal;
    }



    /**
     * Returns
     * ILT-7: "Inventory Received Item Cost" - creates it if necessary
     */
    public MO getInventoryReceivedItemCost() { 
		MO retVal = this.getTypedField(7, 0);
		return retVal;
    }
    
    /**
     * Returns
     * ILT-7: "Inventory Received Item Cost" - creates it if necessary
     */
    public MO getIlt7_InventoryReceivedItemCost() { 
		MO retVal = this.getTypedField(7, 0);
		return retVal;
    }



    /**
     * Returns
     * ILT-8: "Inventory On Hand Date" - creates it if necessary
     */
    public DTM getInventoryOnHandDate() { 
		DTM retVal = this.getTypedField(8, 0);
		return retVal;
    }
    
    /**
     * Returns
     * ILT-8: "Inventory On Hand Date" - creates it if necessary
     */
    public DTM getIlt8_InventoryOnHandDate() { 
		DTM retVal = this.getTypedField(8, 0);
		return retVal;
    }



    /**
     * Returns
     * ILT-9: "Inventory On Hand Quantity" - creates it if necessary
     */
    public NM getInventoryOnHandQuantity() { 
		NM retVal = this.getTypedField(9, 0);
		return retVal;
    }
    
    /**
     * Returns
     * ILT-9: "Inventory On Hand Quantity" - creates it if necessary
     */
    public NM getIlt9_InventoryOnHandQuantity() { 
		NM retVal = this.getTypedField(9, 0);
		return retVal;
    }



    /**
     * Returns
     * ILT-10: "Inventory On Hand Quantity Unit" - creates it if necessary
     */
    public CWE getInventoryOnHandQuantityUnit() { 
		CWE retVal = this.getTypedField(10, 0);
		return retVal;
    }
    
    /**
     * Returns
     * ILT-10: "Inventory On Hand Quantity Unit" - creates it if necessary
     */
    public CWE getIlt10_InventoryOnHandQuantityUnit() { 
		CWE retVal = this.getTypedField(10, 0);
		return retVal;
    }





    /** {@inheritDoc} */   
    protected Type createNewTypeWithoutReflection(int field) {
       switch (field) {
          case 0: return new SI(getMessage());
          case 1: return new ST(getMessage());
          case 2: return new DTM(getMessage());
          case 3: return new DTM(getMessage());
          case 4: return new NM(getMessage());
          case 5: return new CWE(getMessage());
          case 6: return new MO(getMessage());
          case 7: return new DTM(getMessage());
          case 8: return new NM(getMessage());
          case 9: return new CWE(getMessage());
          default: return null;
       }
   }


}

