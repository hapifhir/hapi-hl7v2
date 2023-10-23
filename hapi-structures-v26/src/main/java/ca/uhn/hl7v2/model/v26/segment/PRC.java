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
 *<p>Represents an HL7 PRC message segment (Pricing). 
 * This segment has the following fields:</p>
 * <ul>
     * <li>PRC-1: Primary Key Value-PRC (CWE) <b> </b>
     * <li>PRC-2: Facility ID-PRC (CWE) <b>optional repeating</b>
     * <li>PRC-3: Department (CWE) <b>optional repeating</b>
     * <li>PRC-4: Valid Patient Classes (IS) <b>optional repeating</b>
     * <li>PRC-5: Price (CP) <b>optional repeating</b>
     * <li>PRC-6: Formula (ST) <b>optional repeating</b>
     * <li>PRC-7: Minimum Quantity (NM) <b>optional </b>
     * <li>PRC-8: Maximum Quantity (NM) <b>optional </b>
     * <li>PRC-9: Minimum Price (MO) <b>optional </b>
     * <li>PRC-10: Maximum Price (MO) <b>optional </b>
     * <li>PRC-11: Effective Start Date (DTM) <b>optional </b>
     * <li>PRC-12: Effective End Date (DTM) <b>optional </b>
     * <li>PRC-13: Price Override Flag (IS) <b>optional </b>
     * <li>PRC-14: Billing Category (CWE) <b>optional repeating</b>
     * <li>PRC-15: Chargeable Flag (ID) <b>optional </b>
     * <li>PRC-16: Active/Inactive Flag (ID) <b>optional </b>
     * <li>PRC-17: Cost (MO) <b>optional </b>
     * <li>PRC-18: Charge on Indicator (IS) <b>optional </b>
 * </ul>
 */
@SuppressWarnings("unused")
public class PRC extends AbstractSegment {

    /** 
     * Creates a new PRC segment
     */
    public PRC(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(CWE.class, true, 1, 250, new Object[]{ getMessage() }, "Primary Key Value-PRC");
                                  this.add(CWE.class, false, 0, 250, new Object[]{ getMessage() }, "Facility ID-PRC");
                                  this.add(CWE.class, false, 0, 250, new Object[]{ getMessage() }, "Department");
                                              this.add(IS.class, false, 0, 1, new Object[]{ getMessage(), new Integer(4) }, "Valid Patient Classes");
                                  this.add(CP.class, false, 0, 12, new Object[]{ getMessage() }, "Price");
                                  this.add(ST.class, false, 0, 200, new Object[]{ getMessage() }, "Formula");
                                  this.add(NM.class, false, 1, 4, new Object[]{ getMessage() }, "Minimum Quantity");
                                  this.add(NM.class, false, 1, 4, new Object[]{ getMessage() }, "Maximum Quantity");
                                  this.add(MO.class, false, 1, 12, new Object[]{ getMessage() }, "Minimum Price");
                                  this.add(MO.class, false, 1, 12, new Object[]{ getMessage() }, "Maximum Price");
                                  this.add(DTM.class, false, 1, 24, new Object[]{ getMessage() }, "Effective Start Date");
                                  this.add(DTM.class, false, 1, 24, new Object[]{ getMessage() }, "Effective End Date");
                                              this.add(IS.class, false, 1, 1, new Object[]{ getMessage(), new Integer(268) }, "Price Override Flag");
                                  this.add(CWE.class, false, 0, 250, new Object[]{ getMessage() }, "Billing Category");
                                              this.add(ID.class, false, 1, 1, new Object[]{ getMessage(), new Integer(136) }, "Chargeable Flag");
                                              this.add(ID.class, false, 1, 1, new Object[]{ getMessage(), new Integer(183) }, "Active/Inactive Flag");
                                  this.add(MO.class, false, 1, 12, new Object[]{ getMessage() }, "Cost");
                                              this.add(IS.class, false, 1, 1, new Object[]{ getMessage(), new Integer(269) }, "Charge on Indicator");
       } catch(HL7Exception e) {
          log.error("Unexpected error creating PRC - this is probably a bug in the source code generator.", e);
       }
    }



    /**
     * Returns
     * PRC-1: "Primary Key Value-PRC" - creates it if necessary
     */
    public CWE getPrimaryKeyValuePRC() { 
		CWE retVal = this.getTypedField(1, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PRC-1: "Primary Key Value-PRC" - creates it if necessary
     */
    public CWE getPrc1_PrimaryKeyValuePRC() { 
		CWE retVal = this.getTypedField(1, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Facility ID-PRC (PRC-2).
     */
    public CWE[] getFacilityIDPRC() {
    	CWE[] retVal = this.getTypedField(2, new CWE[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Facility ID-PRC (PRC-2).
     */
    public CWE[] getPrc2_FacilityIDPRC() {
    	CWE[] retVal = this.getTypedField(2, new CWE[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Facility ID-PRC (PRC-2).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getFacilityIDPRCReps() {
    	return this.getReps(2);
    }


    /**
     * Returns a specific repetition of
     * PRC-2: "Facility ID-PRC" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CWE getFacilityIDPRC(int rep) { 
		CWE retVal = this.getTypedField(2, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * PRC-2: "Facility ID-PRC" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CWE getPrc2_FacilityIDPRC(int rep) { 
		CWE retVal = this.getTypedField(2, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Facility ID-PRC (PRC-2).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getPrc2_FacilityIDPRCReps() {
    	return this.getReps(2);
    }


    /**
     * Inserts a repetition of
     * PRC-2: "Facility ID-PRC" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE insertFacilityIDPRC(int rep) throws HL7Exception { 
        return (CWE) super.insertRepetition(2, rep);
    }


    /**
     * Inserts a repetition of
     * PRC-2: "Facility ID-PRC" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE insertPrc2_FacilityIDPRC(int rep) throws HL7Exception { 
        return (CWE) super.insertRepetition(2, rep);
    }


    /**
     * Removes a repetition of
     * PRC-2: "Facility ID-PRC" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE removeFacilityIDPRC(int rep) throws HL7Exception { 
        return (CWE) super.removeRepetition(2, rep);
    }


    /**
     * Removes a repetition of
     * PRC-2: "Facility ID-PRC" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE removePrc2_FacilityIDPRC(int rep) throws HL7Exception { 
        return (CWE) super.removeRepetition(2, rep);
    }



    /**
     * Returns all repetitions of Department (PRC-3).
     */
    public CWE[] getDepartment() {
    	CWE[] retVal = this.getTypedField(3, new CWE[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Department (PRC-3).
     */
    public CWE[] getPrc3_Department() {
    	CWE[] retVal = this.getTypedField(3, new CWE[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Department (PRC-3).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getDepartmentReps() {
    	return this.getReps(3);
    }


    /**
     * Returns a specific repetition of
     * PRC-3: "Department" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CWE getDepartment(int rep) { 
		CWE retVal = this.getTypedField(3, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * PRC-3: "Department" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CWE getPrc3_Department(int rep) { 
		CWE retVal = this.getTypedField(3, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Department (PRC-3).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getPrc3_DepartmentReps() {
    	return this.getReps(3);
    }


    /**
     * Inserts a repetition of
     * PRC-3: "Department" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE insertDepartment(int rep) throws HL7Exception { 
        return (CWE) super.insertRepetition(3, rep);
    }


    /**
     * Inserts a repetition of
     * PRC-3: "Department" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE insertPrc3_Department(int rep) throws HL7Exception { 
        return (CWE) super.insertRepetition(3, rep);
    }


    /**
     * Removes a repetition of
     * PRC-3: "Department" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE removeDepartment(int rep) throws HL7Exception { 
        return (CWE) super.removeRepetition(3, rep);
    }


    /**
     * Removes a repetition of
     * PRC-3: "Department" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE removePrc3_Department(int rep) throws HL7Exception { 
        return (CWE) super.removeRepetition(3, rep);
    }



    /**
     * Returns all repetitions of Valid Patient Classes (PRC-4).
     */
    public IS[] getValidPatientClasses() {
    	IS[] retVal = this.getTypedField(4, new IS[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Valid Patient Classes (PRC-4).
     */
    public IS[] getPrc4_ValidPatientClasses() {
    	IS[] retVal = this.getTypedField(4, new IS[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Valid Patient Classes (PRC-4).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getValidPatientClassesReps() {
    	return this.getReps(4);
    }


    /**
     * Returns a specific repetition of
     * PRC-4: "Valid Patient Classes" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public IS getValidPatientClasses(int rep) { 
		IS retVal = this.getTypedField(4, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * PRC-4: "Valid Patient Classes" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public IS getPrc4_ValidPatientClasses(int rep) { 
		IS retVal = this.getTypedField(4, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Valid Patient Classes (PRC-4).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getPrc4_ValidPatientClassesReps() {
    	return this.getReps(4);
    }


    /**
     * Inserts a repetition of
     * PRC-4: "Valid Patient Classes" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public IS insertValidPatientClasses(int rep) throws HL7Exception { 
        return (IS) super.insertRepetition(4, rep);
    }


    /**
     * Inserts a repetition of
     * PRC-4: "Valid Patient Classes" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public IS insertPrc4_ValidPatientClasses(int rep) throws HL7Exception { 
        return (IS) super.insertRepetition(4, rep);
    }


    /**
     * Removes a repetition of
     * PRC-4: "Valid Patient Classes" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public IS removeValidPatientClasses(int rep) throws HL7Exception { 
        return (IS) super.removeRepetition(4, rep);
    }


    /**
     * Removes a repetition of
     * PRC-4: "Valid Patient Classes" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public IS removePrc4_ValidPatientClasses(int rep) throws HL7Exception { 
        return (IS) super.removeRepetition(4, rep);
    }



    /**
     * Returns all repetitions of Price (PRC-5).
     */
    public CP[] getPrice() {
    	CP[] retVal = this.getTypedField(5, new CP[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Price (PRC-5).
     */
    public CP[] getPrc5_Price() {
    	CP[] retVal = this.getTypedField(5, new CP[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Price (PRC-5).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getPriceReps() {
    	return this.getReps(5);
    }


    /**
     * Returns a specific repetition of
     * PRC-5: "Price" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CP getPrice(int rep) { 
		CP retVal = this.getTypedField(5, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * PRC-5: "Price" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CP getPrc5_Price(int rep) { 
		CP retVal = this.getTypedField(5, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Price (PRC-5).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getPrc5_PriceReps() {
    	return this.getReps(5);
    }


    /**
     * Inserts a repetition of
     * PRC-5: "Price" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CP insertPrice(int rep) throws HL7Exception { 
        return (CP) super.insertRepetition(5, rep);
    }


    /**
     * Inserts a repetition of
     * PRC-5: "Price" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CP insertPrc5_Price(int rep) throws HL7Exception { 
        return (CP) super.insertRepetition(5, rep);
    }


    /**
     * Removes a repetition of
     * PRC-5: "Price" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CP removePrice(int rep) throws HL7Exception { 
        return (CP) super.removeRepetition(5, rep);
    }


    /**
     * Removes a repetition of
     * PRC-5: "Price" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CP removePrc5_Price(int rep) throws HL7Exception { 
        return (CP) super.removeRepetition(5, rep);
    }



    /**
     * Returns all repetitions of Formula (PRC-6).
     */
    public ST[] getFormula() {
    	ST[] retVal = this.getTypedField(6, new ST[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Formula (PRC-6).
     */
    public ST[] getPrc6_Formula() {
    	ST[] retVal = this.getTypedField(6, new ST[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Formula (PRC-6).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getFormulaReps() {
    	return this.getReps(6);
    }


    /**
     * Returns a specific repetition of
     * PRC-6: "Formula" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public ST getFormula(int rep) { 
		ST retVal = this.getTypedField(6, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * PRC-6: "Formula" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public ST getPrc6_Formula(int rep) { 
		ST retVal = this.getTypedField(6, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Formula (PRC-6).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getPrc6_FormulaReps() {
    	return this.getReps(6);
    }


    /**
     * Inserts a repetition of
     * PRC-6: "Formula" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ST insertFormula(int rep) throws HL7Exception { 
        return (ST) super.insertRepetition(6, rep);
    }


    /**
     * Inserts a repetition of
     * PRC-6: "Formula" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ST insertPrc6_Formula(int rep) throws HL7Exception { 
        return (ST) super.insertRepetition(6, rep);
    }


    /**
     * Removes a repetition of
     * PRC-6: "Formula" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ST removeFormula(int rep) throws HL7Exception { 
        return (ST) super.removeRepetition(6, rep);
    }


    /**
     * Removes a repetition of
     * PRC-6: "Formula" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ST removePrc6_Formula(int rep) throws HL7Exception { 
        return (ST) super.removeRepetition(6, rep);
    }




    /**
     * Returns
     * PRC-7: "Minimum Quantity" - creates it if necessary
     */
    public NM getMinimumQuantity() { 
		NM retVal = this.getTypedField(7, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PRC-7: "Minimum Quantity" - creates it if necessary
     */
    public NM getPrc7_MinimumQuantity() { 
		NM retVal = this.getTypedField(7, 0);
		return retVal;
    }



    /**
     * Returns
     * PRC-8: "Maximum Quantity" - creates it if necessary
     */
    public NM getMaximumQuantity() { 
		NM retVal = this.getTypedField(8, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PRC-8: "Maximum Quantity" - creates it if necessary
     */
    public NM getPrc8_MaximumQuantity() { 
		NM retVal = this.getTypedField(8, 0);
		return retVal;
    }



    /**
     * Returns
     * PRC-9: "Minimum Price" - creates it if necessary
     */
    public MO getMinimumPrice() { 
		MO retVal = this.getTypedField(9, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PRC-9: "Minimum Price" - creates it if necessary
     */
    public MO getPrc9_MinimumPrice() { 
		MO retVal = this.getTypedField(9, 0);
		return retVal;
    }



    /**
     * Returns
     * PRC-10: "Maximum Price" - creates it if necessary
     */
    public MO getMaximumPrice() { 
		MO retVal = this.getTypedField(10, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PRC-10: "Maximum Price" - creates it if necessary
     */
    public MO getPrc10_MaximumPrice() { 
		MO retVal = this.getTypedField(10, 0);
		return retVal;
    }



    /**
     * Returns
     * PRC-11: "Effective Start Date" - creates it if necessary
     */
    public DTM getEffectiveStartDate() { 
		DTM retVal = this.getTypedField(11, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PRC-11: "Effective Start Date" - creates it if necessary
     */
    public DTM getPrc11_EffectiveStartDate() { 
		DTM retVal = this.getTypedField(11, 0);
		return retVal;
    }



    /**
     * Returns
     * PRC-12: "Effective End Date" - creates it if necessary
     */
    public DTM getEffectiveEndDate() { 
		DTM retVal = this.getTypedField(12, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PRC-12: "Effective End Date" - creates it if necessary
     */
    public DTM getPrc12_EffectiveEndDate() { 
		DTM retVal = this.getTypedField(12, 0);
		return retVal;
    }



    /**
     * Returns
     * PRC-13: "Price Override Flag" - creates it if necessary
     */
    public IS getPriceOverrideFlag() { 
		IS retVal = this.getTypedField(13, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PRC-13: "Price Override Flag" - creates it if necessary
     */
    public IS getPrc13_PriceOverrideFlag() { 
		IS retVal = this.getTypedField(13, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Billing Category (PRC-14).
     */
    public CWE[] getBillingCategory() {
    	CWE[] retVal = this.getTypedField(14, new CWE[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Billing Category (PRC-14).
     */
    public CWE[] getPrc14_BillingCategory() {
    	CWE[] retVal = this.getTypedField(14, new CWE[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Billing Category (PRC-14).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getBillingCategoryReps() {
    	return this.getReps(14);
    }


    /**
     * Returns a specific repetition of
     * PRC-14: "Billing Category" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CWE getBillingCategory(int rep) { 
		CWE retVal = this.getTypedField(14, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * PRC-14: "Billing Category" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CWE getPrc14_BillingCategory(int rep) { 
		CWE retVal = this.getTypedField(14, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Billing Category (PRC-14).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getPrc14_BillingCategoryReps() {
    	return this.getReps(14);
    }


    /**
     * Inserts a repetition of
     * PRC-14: "Billing Category" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE insertBillingCategory(int rep) throws HL7Exception { 
        return (CWE) super.insertRepetition(14, rep);
    }


    /**
     * Inserts a repetition of
     * PRC-14: "Billing Category" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE insertPrc14_BillingCategory(int rep) throws HL7Exception { 
        return (CWE) super.insertRepetition(14, rep);
    }


    /**
     * Removes a repetition of
     * PRC-14: "Billing Category" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE removeBillingCategory(int rep) throws HL7Exception { 
        return (CWE) super.removeRepetition(14, rep);
    }


    /**
     * Removes a repetition of
     * PRC-14: "Billing Category" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE removePrc14_BillingCategory(int rep) throws HL7Exception { 
        return (CWE) super.removeRepetition(14, rep);
    }




    /**
     * Returns
     * PRC-15: "Chargeable Flag" - creates it if necessary
     */
    public ID getChargeableFlag() { 
		ID retVal = this.getTypedField(15, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PRC-15: "Chargeable Flag" - creates it if necessary
     */
    public ID getPrc15_ChargeableFlag() { 
		ID retVal = this.getTypedField(15, 0);
		return retVal;
    }



    /**
     * Returns
     * PRC-16: "Active/Inactive Flag" - creates it if necessary
     */
    public ID getActiveInactiveFlag() { 
		ID retVal = this.getTypedField(16, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PRC-16: "Active/Inactive Flag" - creates it if necessary
     */
    public ID getPrc16_ActiveInactiveFlag() { 
		ID retVal = this.getTypedField(16, 0);
		return retVal;
    }



    /**
     * Returns
     * PRC-17: "Cost" - creates it if necessary
     */
    public MO getCost() { 
		MO retVal = this.getTypedField(17, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PRC-17: "Cost" - creates it if necessary
     */
    public MO getPrc17_Cost() { 
		MO retVal = this.getTypedField(17, 0);
		return retVal;
    }



    /**
     * Returns
     * PRC-18: "Charge on Indicator" - creates it if necessary
     */
    public IS getChargeOnIndicator() { 
		IS retVal = this.getTypedField(18, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PRC-18: "Charge on Indicator" - creates it if necessary
     */
    public IS getPrc18_ChargeOnIndicator() { 
		IS retVal = this.getTypedField(18, 0);
		return retVal;
    }





    /** {@inheritDoc} */   
    protected Type createNewTypeWithoutReflection(int field) {
       switch (field) {
          case 0: return new CWE(getMessage());
          case 1: return new CWE(getMessage());
          case 2: return new CWE(getMessage());
          case 3: return new IS(getMessage(), new Integer( 4 ));
          case 4: return new CP(getMessage());
          case 5: return new ST(getMessage());
          case 6: return new NM(getMessage());
          case 7: return new NM(getMessage());
          case 8: return new MO(getMessage());
          case 9: return new MO(getMessage());
          case 10: return new DTM(getMessage());
          case 11: return new DTM(getMessage());
          case 12: return new IS(getMessage(), new Integer( 268 ));
          case 13: return new CWE(getMessage());
          case 14: return new ID(getMessage(), new Integer( 136 ));
          case 15: return new ID(getMessage(), new Integer( 183 ));
          case 16: return new MO(getMessage());
          case 17: return new IS(getMessage(), new Integer( 269 ));
          default: return null;
       }
   }


}

