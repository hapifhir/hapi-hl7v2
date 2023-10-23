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
 *<p>Represents an HL7 IIM message segment (Inventory Item Master). 
 * This segment has the following fields:</p>
 * <ul>
     * <li>IIM-1: Primary Key Value - IIM (CWE) <b> </b>
     * <li>IIM-2: Service Item Code (CWE) <b> </b>
     * <li>IIM-3: Inventory Lot Number (ST) <b>optional </b>
     * <li>IIM-4: Inventory Expiration Date (DTM) <b>optional </b>
     * <li>IIM-5: Inventory Manufacturer Name (CWE) <b>optional </b>
     * <li>IIM-6: Inventory Location (CWE) <b>optional </b>
     * <li>IIM-7: Inventory Received Date (DTM) <b>optional </b>
     * <li>IIM-8: Inventory Received Quantity (NM) <b>optional </b>
     * <li>IIM-9: Inventory Received Quantity Unit (CWE) <b>optional </b>
     * <li>IIM-10: Inventory Received Item Cost (MO) <b>optional </b>
     * <li>IIM-11: Inventory On Hand Date (DTM) <b>optional </b>
     * <li>IIM-12: Inventory On Hand Quantity (NM) <b>optional </b>
     * <li>IIM-13: Inventory On Hand Quantity Unit (CWE) <b>optional </b>
     * <li>IIM-14: Procedure Code (CNE) <b>optional </b>
     * <li>IIM-15: Procedure Code Modifier (CNE) <b>optional repeating</b>
 * </ul>
 */
@SuppressWarnings("unused")
public class IIM extends AbstractSegment {

    /** 
     * Creates a new IIM segment
     */
    public IIM(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(CWE.class, true, 1, 0, new Object[]{ getMessage() }, "Primary Key Value - IIM");
                                  this.add(CWE.class, true, 1, 0, new Object[]{ getMessage() }, "Service Item Code");
                                  this.add(ST.class, false, 1, 0, new Object[]{ getMessage() }, "Inventory Lot Number");
                                  this.add(DTM.class, false, 1, 0, new Object[]{ getMessage() }, "Inventory Expiration Date");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "Inventory Manufacturer Name");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "Inventory Location");
                                  this.add(DTM.class, false, 1, 0, new Object[]{ getMessage() }, "Inventory Received Date");
                                  this.add(NM.class, false, 1, 0, new Object[]{ getMessage() }, "Inventory Received Quantity");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "Inventory Received Quantity Unit");
                                  this.add(MO.class, false, 1, 0, new Object[]{ getMessage() }, "Inventory Received Item Cost");
                                  this.add(DTM.class, false, 1, 0, new Object[]{ getMessage() }, "Inventory On Hand Date");
                                  this.add(NM.class, false, 1, 0, new Object[]{ getMessage() }, "Inventory On Hand Quantity");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "Inventory On Hand Quantity Unit");
                                  this.add(CNE.class, false, 1, 0, new Object[]{ getMessage() }, "Procedure Code");
                                  this.add(CNE.class, false, 0, 0, new Object[]{ getMessage() }, "Procedure Code Modifier");
       } catch(HL7Exception e) {
          log.error("Unexpected error creating IIM - this is probably a bug in the source code generator.", e);
       }
    }



    /**
     * Returns
     * IIM-1: "Primary Key Value - IIM" - creates it if necessary
     */
    public CWE getPrimaryKeyValueIIM() { 
		CWE retVal = this.getTypedField(1, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IIM-1: "Primary Key Value - IIM" - creates it if necessary
     */
    public CWE getIim1_PrimaryKeyValueIIM() { 
		CWE retVal = this.getTypedField(1, 0);
		return retVal;
    }



    /**
     * Returns
     * IIM-2: "Service Item Code" - creates it if necessary
     */
    public CWE getServiceItemCode() { 
		CWE retVal = this.getTypedField(2, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IIM-2: "Service Item Code" - creates it if necessary
     */
    public CWE getIim2_ServiceItemCode() { 
		CWE retVal = this.getTypedField(2, 0);
		return retVal;
    }



    /**
     * Returns
     * IIM-3: "Inventory Lot Number" - creates it if necessary
     */
    public ST getInventoryLotNumber() { 
		ST retVal = this.getTypedField(3, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IIM-3: "Inventory Lot Number" - creates it if necessary
     */
    public ST getIim3_InventoryLotNumber() { 
		ST retVal = this.getTypedField(3, 0);
		return retVal;
    }



    /**
     * Returns
     * IIM-4: "Inventory Expiration Date" - creates it if necessary
     */
    public DTM getInventoryExpirationDate() { 
		DTM retVal = this.getTypedField(4, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IIM-4: "Inventory Expiration Date" - creates it if necessary
     */
    public DTM getIim4_InventoryExpirationDate() { 
		DTM retVal = this.getTypedField(4, 0);
		return retVal;
    }



    /**
     * Returns
     * IIM-5: "Inventory Manufacturer Name" - creates it if necessary
     */
    public CWE getInventoryManufacturerName() { 
		CWE retVal = this.getTypedField(5, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IIM-5: "Inventory Manufacturer Name" - creates it if necessary
     */
    public CWE getIim5_InventoryManufacturerName() { 
		CWE retVal = this.getTypedField(5, 0);
		return retVal;
    }



    /**
     * Returns
     * IIM-6: "Inventory Location" - creates it if necessary
     */
    public CWE getInventoryLocation() { 
		CWE retVal = this.getTypedField(6, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IIM-6: "Inventory Location" - creates it if necessary
     */
    public CWE getIim6_InventoryLocation() { 
		CWE retVal = this.getTypedField(6, 0);
		return retVal;
    }



    /**
     * Returns
     * IIM-7: "Inventory Received Date" - creates it if necessary
     */
    public DTM getInventoryReceivedDate() { 
		DTM retVal = this.getTypedField(7, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IIM-7: "Inventory Received Date" - creates it if necessary
     */
    public DTM getIim7_InventoryReceivedDate() { 
		DTM retVal = this.getTypedField(7, 0);
		return retVal;
    }



    /**
     * Returns
     * IIM-8: "Inventory Received Quantity" - creates it if necessary
     */
    public NM getInventoryReceivedQuantity() { 
		NM retVal = this.getTypedField(8, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IIM-8: "Inventory Received Quantity" - creates it if necessary
     */
    public NM getIim8_InventoryReceivedQuantity() { 
		NM retVal = this.getTypedField(8, 0);
		return retVal;
    }



    /**
     * Returns
     * IIM-9: "Inventory Received Quantity Unit" - creates it if necessary
     */
    public CWE getInventoryReceivedQuantityUnit() { 
		CWE retVal = this.getTypedField(9, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IIM-9: "Inventory Received Quantity Unit" - creates it if necessary
     */
    public CWE getIim9_InventoryReceivedQuantityUnit() { 
		CWE retVal = this.getTypedField(9, 0);
		return retVal;
    }



    /**
     * Returns
     * IIM-10: "Inventory Received Item Cost" - creates it if necessary
     */
    public MO getInventoryReceivedItemCost() { 
		MO retVal = this.getTypedField(10, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IIM-10: "Inventory Received Item Cost" - creates it if necessary
     */
    public MO getIim10_InventoryReceivedItemCost() { 
		MO retVal = this.getTypedField(10, 0);
		return retVal;
    }



    /**
     * Returns
     * IIM-11: "Inventory On Hand Date" - creates it if necessary
     */
    public DTM getInventoryOnHandDate() { 
		DTM retVal = this.getTypedField(11, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IIM-11: "Inventory On Hand Date" - creates it if necessary
     */
    public DTM getIim11_InventoryOnHandDate() { 
		DTM retVal = this.getTypedField(11, 0);
		return retVal;
    }



    /**
     * Returns
     * IIM-12: "Inventory On Hand Quantity" - creates it if necessary
     */
    public NM getInventoryOnHandQuantity() { 
		NM retVal = this.getTypedField(12, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IIM-12: "Inventory On Hand Quantity" - creates it if necessary
     */
    public NM getIim12_InventoryOnHandQuantity() { 
		NM retVal = this.getTypedField(12, 0);
		return retVal;
    }



    /**
     * Returns
     * IIM-13: "Inventory On Hand Quantity Unit" - creates it if necessary
     */
    public CWE getInventoryOnHandQuantityUnit() { 
		CWE retVal = this.getTypedField(13, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IIM-13: "Inventory On Hand Quantity Unit" - creates it if necessary
     */
    public CWE getIim13_InventoryOnHandQuantityUnit() { 
		CWE retVal = this.getTypedField(13, 0);
		return retVal;
    }



    /**
     * Returns
     * IIM-14: "Procedure Code" - creates it if necessary
     */
    public CNE getProcedureCode() { 
		CNE retVal = this.getTypedField(14, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IIM-14: "Procedure Code" - creates it if necessary
     */
    public CNE getIim14_ProcedureCode() { 
		CNE retVal = this.getTypedField(14, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Procedure Code Modifier (IIM-15).
     */
    public CNE[] getProcedureCodeModifier() {
    	CNE[] retVal = this.getTypedField(15, new CNE[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Procedure Code Modifier (IIM-15).
     */
    public CNE[] getIim15_ProcedureCodeModifier() {
    	CNE[] retVal = this.getTypedField(15, new CNE[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Procedure Code Modifier (IIM-15).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getProcedureCodeModifierReps() {
    	return this.getReps(15);
    }


    /**
     * Returns a specific repetition of
     * IIM-15: "Procedure Code Modifier" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CNE getProcedureCodeModifier(int rep) { 
		CNE retVal = this.getTypedField(15, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * IIM-15: "Procedure Code Modifier" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CNE getIim15_ProcedureCodeModifier(int rep) { 
		CNE retVal = this.getTypedField(15, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Procedure Code Modifier (IIM-15).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getIim15_ProcedureCodeModifierReps() {
    	return this.getReps(15);
    }


    /**
     * Inserts a repetition of
     * IIM-15: "Procedure Code Modifier" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CNE insertProcedureCodeModifier(int rep) throws HL7Exception { 
        return (CNE) super.insertRepetition(15, rep);
    }


    /**
     * Inserts a repetition of
     * IIM-15: "Procedure Code Modifier" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CNE insertIim15_ProcedureCodeModifier(int rep) throws HL7Exception { 
        return (CNE) super.insertRepetition(15, rep);
    }


    /**
     * Removes a repetition of
     * IIM-15: "Procedure Code Modifier" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CNE removeProcedureCodeModifier(int rep) throws HL7Exception { 
        return (CNE) super.removeRepetition(15, rep);
    }


    /**
     * Removes a repetition of
     * IIM-15: "Procedure Code Modifier" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CNE removeIim15_ProcedureCodeModifier(int rep) throws HL7Exception { 
        return (CNE) super.removeRepetition(15, rep);
    }






    /** {@inheritDoc} */   
    protected Type createNewTypeWithoutReflection(int field) {
       switch (field) {
          case 0: return new CWE(getMessage());
          case 1: return new CWE(getMessage());
          case 2: return new ST(getMessage());
          case 3: return new DTM(getMessage());
          case 4: return new CWE(getMessage());
          case 5: return new CWE(getMessage());
          case 6: return new DTM(getMessage());
          case 7: return new NM(getMessage());
          case 8: return new CWE(getMessage());
          case 9: return new MO(getMessage());
          case 10: return new DTM(getMessage());
          case 11: return new NM(getMessage());
          case 12: return new CWE(getMessage());
          case 13: return new CNE(getMessage());
          case 14: return new CNE(getMessage());
          default: return null;
       }
   }


}

