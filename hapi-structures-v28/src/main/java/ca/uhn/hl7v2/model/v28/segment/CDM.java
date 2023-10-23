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
 *<p>Represents an HL7 CDM message segment (Charge Description Master). 
 * This segment has the following fields:</p>
 * <ul>
     * <li>CDM-1: Primary Key Value - CDM (CWE) <b> </b>
     * <li>CDM-2: Charge Code Alias (CWE) <b>optional repeating</b>
     * <li>CDM-3: Charge Description Short (ST) <b> </b>
     * <li>CDM-4: Charge Description Long (ST) <b>optional </b>
     * <li>CDM-5: Description Override Indicator (CWE) <b>optional </b>
     * <li>CDM-6: Exploding Charges (CWE) <b>optional repeating</b>
     * <li>CDM-7: Procedure Code (CNE) <b>optional repeating</b>
     * <li>CDM-8: Active/Inactive Flag (ID) <b>optional </b>
     * <li>CDM-9: Inventory Number (CWE) <b>optional repeating</b>
     * <li>CDM-10: Resource Load (NM) <b>optional </b>
     * <li>CDM-11: Contract Number (CX) <b>optional repeating</b>
     * <li>CDM-12: Contract Organization (XON) <b>optional repeating</b>
     * <li>CDM-13: Room Fee Indicator (ID) <b>optional </b>
 * </ul>
 */
@SuppressWarnings("unused")
public class CDM extends AbstractSegment {

    /** 
     * Creates a new CDM segment
     */
    public CDM(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(CWE.class, true, 1, 0, new Object[]{ getMessage() }, "Primary Key Value - CDM");
                                  this.add(CWE.class, false, 0, 0, new Object[]{ getMessage() }, "Charge Code Alias");
                                  this.add(ST.class, true, 1, 0, new Object[]{ getMessage() }, "Charge Description Short");
                                  this.add(ST.class, false, 1, 0, new Object[]{ getMessage() }, "Charge Description Long");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "Description Override Indicator");
                                  this.add(CWE.class, false, 0, 0, new Object[]{ getMessage() }, "Exploding Charges");
                                  this.add(CNE.class, false, 0, 0, new Object[]{ getMessage() }, "Procedure Code");
                                              this.add(ID.class, false, 1, 1, new Object[]{ getMessage(), new Integer(183) }, "Active/Inactive Flag");
                                  this.add(CWE.class, false, 0, 0, new Object[]{ getMessage() }, "Inventory Number");
                                  this.add(NM.class, false, 1, 0, new Object[]{ getMessage() }, "Resource Load");
                                  this.add(CX.class, false, 0, 0, new Object[]{ getMessage() }, "Contract Number");
                                  this.add(XON.class, false, 0, 0, new Object[]{ getMessage() }, "Contract Organization");
                                              this.add(ID.class, false, 1, 1, new Object[]{ getMessage(), new Integer(136) }, "Room Fee Indicator");
       } catch(HL7Exception e) {
          log.error("Unexpected error creating CDM - this is probably a bug in the source code generator.", e);
       }
    }



    /**
     * Returns
     * CDM-1: "Primary Key Value - CDM" - creates it if necessary
     */
    public CWE getPrimaryKeyValueCDM() { 
		CWE retVal = this.getTypedField(1, 0);
		return retVal;
    }
    
    /**
     * Returns
     * CDM-1: "Primary Key Value - CDM" - creates it if necessary
     */
    public CWE getCdm1_PrimaryKeyValueCDM() { 
		CWE retVal = this.getTypedField(1, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Charge Code Alias (CDM-2).
     */
    public CWE[] getChargeCodeAlias() {
    	CWE[] retVal = this.getTypedField(2, new CWE[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Charge Code Alias (CDM-2).
     */
    public CWE[] getCdm2_ChargeCodeAlias() {
    	CWE[] retVal = this.getTypedField(2, new CWE[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Charge Code Alias (CDM-2).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getChargeCodeAliasReps() {
    	return this.getReps(2);
    }


    /**
     * Returns a specific repetition of
     * CDM-2: "Charge Code Alias" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CWE getChargeCodeAlias(int rep) { 
		CWE retVal = this.getTypedField(2, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * CDM-2: "Charge Code Alias" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CWE getCdm2_ChargeCodeAlias(int rep) { 
		CWE retVal = this.getTypedField(2, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Charge Code Alias (CDM-2).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getCdm2_ChargeCodeAliasReps() {
    	return this.getReps(2);
    }


    /**
     * Inserts a repetition of
     * CDM-2: "Charge Code Alias" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE insertChargeCodeAlias(int rep) throws HL7Exception { 
        return (CWE) super.insertRepetition(2, rep);
    }


    /**
     * Inserts a repetition of
     * CDM-2: "Charge Code Alias" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE insertCdm2_ChargeCodeAlias(int rep) throws HL7Exception { 
        return (CWE) super.insertRepetition(2, rep);
    }


    /**
     * Removes a repetition of
     * CDM-2: "Charge Code Alias" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE removeChargeCodeAlias(int rep) throws HL7Exception { 
        return (CWE) super.removeRepetition(2, rep);
    }


    /**
     * Removes a repetition of
     * CDM-2: "Charge Code Alias" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE removeCdm2_ChargeCodeAlias(int rep) throws HL7Exception { 
        return (CWE) super.removeRepetition(2, rep);
    }




    /**
     * Returns
     * CDM-3: "Charge Description Short" - creates it if necessary
     */
    public ST getChargeDescriptionShort() { 
		ST retVal = this.getTypedField(3, 0);
		return retVal;
    }
    
    /**
     * Returns
     * CDM-3: "Charge Description Short" - creates it if necessary
     */
    public ST getCdm3_ChargeDescriptionShort() { 
		ST retVal = this.getTypedField(3, 0);
		return retVal;
    }



    /**
     * Returns
     * CDM-4: "Charge Description Long" - creates it if necessary
     */
    public ST getChargeDescriptionLong() { 
		ST retVal = this.getTypedField(4, 0);
		return retVal;
    }
    
    /**
     * Returns
     * CDM-4: "Charge Description Long" - creates it if necessary
     */
    public ST getCdm4_ChargeDescriptionLong() { 
		ST retVal = this.getTypedField(4, 0);
		return retVal;
    }



    /**
     * Returns
     * CDM-5: "Description Override Indicator" - creates it if necessary
     */
    public CWE getDescriptionOverrideIndicator() { 
		CWE retVal = this.getTypedField(5, 0);
		return retVal;
    }
    
    /**
     * Returns
     * CDM-5: "Description Override Indicator" - creates it if necessary
     */
    public CWE getCdm5_DescriptionOverrideIndicator() { 
		CWE retVal = this.getTypedField(5, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Exploding Charges (CDM-6).
     */
    public CWE[] getExplodingCharges() {
    	CWE[] retVal = this.getTypedField(6, new CWE[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Exploding Charges (CDM-6).
     */
    public CWE[] getCdm6_ExplodingCharges() {
    	CWE[] retVal = this.getTypedField(6, new CWE[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Exploding Charges (CDM-6).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getExplodingChargesReps() {
    	return this.getReps(6);
    }


    /**
     * Returns a specific repetition of
     * CDM-6: "Exploding Charges" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CWE getExplodingCharges(int rep) { 
		CWE retVal = this.getTypedField(6, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * CDM-6: "Exploding Charges" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CWE getCdm6_ExplodingCharges(int rep) { 
		CWE retVal = this.getTypedField(6, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Exploding Charges (CDM-6).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getCdm6_ExplodingChargesReps() {
    	return this.getReps(6);
    }


    /**
     * Inserts a repetition of
     * CDM-6: "Exploding Charges" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE insertExplodingCharges(int rep) throws HL7Exception { 
        return (CWE) super.insertRepetition(6, rep);
    }


    /**
     * Inserts a repetition of
     * CDM-6: "Exploding Charges" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE insertCdm6_ExplodingCharges(int rep) throws HL7Exception { 
        return (CWE) super.insertRepetition(6, rep);
    }


    /**
     * Removes a repetition of
     * CDM-6: "Exploding Charges" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE removeExplodingCharges(int rep) throws HL7Exception { 
        return (CWE) super.removeRepetition(6, rep);
    }


    /**
     * Removes a repetition of
     * CDM-6: "Exploding Charges" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE removeCdm6_ExplodingCharges(int rep) throws HL7Exception { 
        return (CWE) super.removeRepetition(6, rep);
    }



    /**
     * Returns all repetitions of Procedure Code (CDM-7).
     */
    public CNE[] getProcedureCode() {
    	CNE[] retVal = this.getTypedField(7, new CNE[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Procedure Code (CDM-7).
     */
    public CNE[] getCdm7_ProcedureCode() {
    	CNE[] retVal = this.getTypedField(7, new CNE[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Procedure Code (CDM-7).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getProcedureCodeReps() {
    	return this.getReps(7);
    }


    /**
     * Returns a specific repetition of
     * CDM-7: "Procedure Code" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CNE getProcedureCode(int rep) { 
		CNE retVal = this.getTypedField(7, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * CDM-7: "Procedure Code" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CNE getCdm7_ProcedureCode(int rep) { 
		CNE retVal = this.getTypedField(7, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Procedure Code (CDM-7).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getCdm7_ProcedureCodeReps() {
    	return this.getReps(7);
    }


    /**
     * Inserts a repetition of
     * CDM-7: "Procedure Code" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CNE insertProcedureCode(int rep) throws HL7Exception { 
        return (CNE) super.insertRepetition(7, rep);
    }


    /**
     * Inserts a repetition of
     * CDM-7: "Procedure Code" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CNE insertCdm7_ProcedureCode(int rep) throws HL7Exception { 
        return (CNE) super.insertRepetition(7, rep);
    }


    /**
     * Removes a repetition of
     * CDM-7: "Procedure Code" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CNE removeProcedureCode(int rep) throws HL7Exception { 
        return (CNE) super.removeRepetition(7, rep);
    }


    /**
     * Removes a repetition of
     * CDM-7: "Procedure Code" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CNE removeCdm7_ProcedureCode(int rep) throws HL7Exception { 
        return (CNE) super.removeRepetition(7, rep);
    }




    /**
     * Returns
     * CDM-8: "Active/Inactive Flag" - creates it if necessary
     */
    public ID getActiveInactiveFlag() { 
		ID retVal = this.getTypedField(8, 0);
		return retVal;
    }
    
    /**
     * Returns
     * CDM-8: "Active/Inactive Flag" - creates it if necessary
     */
    public ID getCdm8_ActiveInactiveFlag() { 
		ID retVal = this.getTypedField(8, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Inventory Number (CDM-9).
     */
    public CWE[] getInventoryNumber() {
    	CWE[] retVal = this.getTypedField(9, new CWE[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Inventory Number (CDM-9).
     */
    public CWE[] getCdm9_InventoryNumber() {
    	CWE[] retVal = this.getTypedField(9, new CWE[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Inventory Number (CDM-9).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getInventoryNumberReps() {
    	return this.getReps(9);
    }


    /**
     * Returns a specific repetition of
     * CDM-9: "Inventory Number" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CWE getInventoryNumber(int rep) { 
		CWE retVal = this.getTypedField(9, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * CDM-9: "Inventory Number" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CWE getCdm9_InventoryNumber(int rep) { 
		CWE retVal = this.getTypedField(9, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Inventory Number (CDM-9).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getCdm9_InventoryNumberReps() {
    	return this.getReps(9);
    }


    /**
     * Inserts a repetition of
     * CDM-9: "Inventory Number" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE insertInventoryNumber(int rep) throws HL7Exception { 
        return (CWE) super.insertRepetition(9, rep);
    }


    /**
     * Inserts a repetition of
     * CDM-9: "Inventory Number" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE insertCdm9_InventoryNumber(int rep) throws HL7Exception { 
        return (CWE) super.insertRepetition(9, rep);
    }


    /**
     * Removes a repetition of
     * CDM-9: "Inventory Number" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE removeInventoryNumber(int rep) throws HL7Exception { 
        return (CWE) super.removeRepetition(9, rep);
    }


    /**
     * Removes a repetition of
     * CDM-9: "Inventory Number" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE removeCdm9_InventoryNumber(int rep) throws HL7Exception { 
        return (CWE) super.removeRepetition(9, rep);
    }




    /**
     * Returns
     * CDM-10: "Resource Load" - creates it if necessary
     */
    public NM getResourceLoad() { 
		NM retVal = this.getTypedField(10, 0);
		return retVal;
    }
    
    /**
     * Returns
     * CDM-10: "Resource Load" - creates it if necessary
     */
    public NM getCdm10_ResourceLoad() { 
		NM retVal = this.getTypedField(10, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Contract Number (CDM-11).
     */
    public CX[] getContractNumber() {
    	CX[] retVal = this.getTypedField(11, new CX[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Contract Number (CDM-11).
     */
    public CX[] getCdm11_ContractNumber() {
    	CX[] retVal = this.getTypedField(11, new CX[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Contract Number (CDM-11).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getContractNumberReps() {
    	return this.getReps(11);
    }


    /**
     * Returns a specific repetition of
     * CDM-11: "Contract Number" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CX getContractNumber(int rep) { 
		CX retVal = this.getTypedField(11, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * CDM-11: "Contract Number" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CX getCdm11_ContractNumber(int rep) { 
		CX retVal = this.getTypedField(11, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Contract Number (CDM-11).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getCdm11_ContractNumberReps() {
    	return this.getReps(11);
    }


    /**
     * Inserts a repetition of
     * CDM-11: "Contract Number" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CX insertContractNumber(int rep) throws HL7Exception { 
        return (CX) super.insertRepetition(11, rep);
    }


    /**
     * Inserts a repetition of
     * CDM-11: "Contract Number" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CX insertCdm11_ContractNumber(int rep) throws HL7Exception { 
        return (CX) super.insertRepetition(11, rep);
    }


    /**
     * Removes a repetition of
     * CDM-11: "Contract Number" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CX removeContractNumber(int rep) throws HL7Exception { 
        return (CX) super.removeRepetition(11, rep);
    }


    /**
     * Removes a repetition of
     * CDM-11: "Contract Number" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CX removeCdm11_ContractNumber(int rep) throws HL7Exception { 
        return (CX) super.removeRepetition(11, rep);
    }



    /**
     * Returns all repetitions of Contract Organization (CDM-12).
     */
    public XON[] getContractOrganization() {
    	XON[] retVal = this.getTypedField(12, new XON[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Contract Organization (CDM-12).
     */
    public XON[] getCdm12_ContractOrganization() {
    	XON[] retVal = this.getTypedField(12, new XON[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Contract Organization (CDM-12).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getContractOrganizationReps() {
    	return this.getReps(12);
    }


    /**
     * Returns a specific repetition of
     * CDM-12: "Contract Organization" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XON getContractOrganization(int rep) { 
		XON retVal = this.getTypedField(12, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * CDM-12: "Contract Organization" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XON getCdm12_ContractOrganization(int rep) { 
		XON retVal = this.getTypedField(12, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Contract Organization (CDM-12).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getCdm12_ContractOrganizationReps() {
    	return this.getReps(12);
    }


    /**
     * Inserts a repetition of
     * CDM-12: "Contract Organization" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XON insertContractOrganization(int rep) throws HL7Exception { 
        return (XON) super.insertRepetition(12, rep);
    }


    /**
     * Inserts a repetition of
     * CDM-12: "Contract Organization" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XON insertCdm12_ContractOrganization(int rep) throws HL7Exception { 
        return (XON) super.insertRepetition(12, rep);
    }


    /**
     * Removes a repetition of
     * CDM-12: "Contract Organization" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XON removeContractOrganization(int rep) throws HL7Exception { 
        return (XON) super.removeRepetition(12, rep);
    }


    /**
     * Removes a repetition of
     * CDM-12: "Contract Organization" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XON removeCdm12_ContractOrganization(int rep) throws HL7Exception { 
        return (XON) super.removeRepetition(12, rep);
    }




    /**
     * Returns
     * CDM-13: "Room Fee Indicator" - creates it if necessary
     */
    public ID getRoomFeeIndicator() { 
		ID retVal = this.getTypedField(13, 0);
		return retVal;
    }
    
    /**
     * Returns
     * CDM-13: "Room Fee Indicator" - creates it if necessary
     */
    public ID getCdm13_RoomFeeIndicator() { 
		ID retVal = this.getTypedField(13, 0);
		return retVal;
    }





    /** {@inheritDoc} */   
    protected Type createNewTypeWithoutReflection(int field) {
       switch (field) {
          case 0: return new CWE(getMessage());
          case 1: return new CWE(getMessage());
          case 2: return new ST(getMessage());
          case 3: return new ST(getMessage());
          case 4: return new CWE(getMessage());
          case 5: return new CWE(getMessage());
          case 6: return new CNE(getMessage());
          case 7: return new ID(getMessage(), new Integer( 183 ));
          case 8: return new CWE(getMessage());
          case 9: return new NM(getMessage());
          case 10: return new CX(getMessage());
          case 11: return new XON(getMessage());
          case 12: return new ID(getMessage(), new Integer( 136 ));
          default: return null;
       }
   }


}

