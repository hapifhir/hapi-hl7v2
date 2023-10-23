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


package ca.uhn.hl7v2.model.v22.segment;

// import ca.uhn.hl7v2.model.v22.group.*;
import ca.uhn.hl7v2.model.v22.datatype.*;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.parser.DefaultModelClassFactory;
import ca.uhn.hl7v2.model.AbstractMessage;
import ca.uhn.hl7v2.model.Group;
import ca.uhn.hl7v2.model.Type;
import ca.uhn.hl7v2.model.AbstractSegment;
import ca.uhn.hl7v2.model.Varies;


/**
 *<p>Represents an HL7 GT1 message segment (GUARANTOR). 
 * This segment has the following fields:</p>
 * <ul>
     * <li>GT1-1: Set ID - guarantor (SI) <b> </b>
     * <li>GT1-2: Guarantor number (CK) <b>optional </b>
     * <li>GT1-3: Guarantor name (PN) <b> </b>
     * <li>GT1-4: Guarantor spouse name (PN) <b>optional </b>
     * <li>GT1-5: Guarantor address (AD) <b>optional </b>
     * <li>GT1-6: Guarantor phone number - home (TN) <b>optional repeating</b>
     * <li>GT1-7: Guarantor phone number - business (TN) <b>optional repeating</b>
     * <li>GT1-8: Guarantor date of birth (DT) <b>optional </b>
     * <li>GT1-9: Guarantor sex (ID) <b>optional </b>
     * <li>GT1-10: Guarantor type (ID) <b>optional </b>
     * <li>GT1-11: Guarantor relationship (ID) <b>optional </b>
     * <li>GT1-12: Guarantor social security number (ST) <b>optional </b>
     * <li>GT1-13: Guarantor date - begin (DT) <b>optional </b>
     * <li>GT1-14: Guarantor date - end (DT) <b>optional </b>
     * <li>GT1-15: Guarantor priority (NM) <b>optional </b>
     * <li>GT1-16: Guarantor employer name (ST) <b>optional </b>
     * <li>GT1-17: Guarantor employer address (AD) <b>optional </b>
     * <li>GT1-18: Guarantor employ phone number (TN) <b>optional repeating</b>
     * <li>GT1-19: Guarantor employee ID number (ST) <b>optional </b>
     * <li>GT1-20: Guarantor employment status (ID) <b>optional </b>
     * <li>GT1-21: Guarantor organization (ST) <b>optional </b>
 * </ul>
 */
@SuppressWarnings("unused")
public class GT1 extends AbstractSegment {

    /** 
     * Creates a new GT1 segment
     */
    public GT1(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(SI.class, true, 1, 4, new Object[]{ getMessage() }, "Set ID - guarantor");
                                  this.add(CK.class, false, 1, 20, new Object[]{ getMessage() }, "Guarantor number");
                                  this.add(PN.class, true, 1, 48, new Object[]{ getMessage() }, "Guarantor name");
                                  this.add(PN.class, false, 1, 48, new Object[]{ getMessage() }, "Guarantor spouse name");
                                  this.add(AD.class, false, 1, 106, new Object[]{ getMessage() }, "Guarantor address");
                                  this.add(TN.class, false, 3, 40, new Object[]{ getMessage() }, "Guarantor phone number - home");
                                  this.add(TN.class, false, 3, 40, new Object[]{ getMessage() }, "Guarantor phone number - business");
                                  this.add(DT.class, false, 1, 8, new Object[]{ getMessage() }, "Guarantor date of birth");
                                              this.add(ID.class, false, 1, 1, new Object[]{ getMessage(), new Integer(1) }, "Guarantor sex");
                                              this.add(ID.class, false, 1, 2, new Object[]{ getMessage(), new Integer(68) }, "Guarantor type");
                                              this.add(ID.class, false, 1, 2, new Object[]{ getMessage(), new Integer(63) }, "Guarantor relationship");
                                  this.add(ST.class, false, 1, 11, new Object[]{ getMessage() }, "Guarantor social security number");
                                  this.add(DT.class, false, 1, 8, new Object[]{ getMessage() }, "Guarantor date - begin");
                                  this.add(DT.class, false, 1, 8, new Object[]{ getMessage() }, "Guarantor date - end");
                                  this.add(NM.class, false, 1, 2, new Object[]{ getMessage() }, "Guarantor priority");
                                  this.add(ST.class, false, 1, 45, new Object[]{ getMessage() }, "Guarantor employer name");
                                  this.add(AD.class, false, 1, 106, new Object[]{ getMessage() }, "Guarantor employer address");
                                  this.add(TN.class, false, 3, 40, new Object[]{ getMessage() }, "Guarantor employ phone number");
                                  this.add(ST.class, false, 1, 20, new Object[]{ getMessage() }, "Guarantor employee ID number");
                                              this.add(ID.class, false, 1, 2, new Object[]{ getMessage(), new Integer(66) }, "Guarantor employment status");
                                  this.add(ST.class, false, 1, 60, new Object[]{ getMessage() }, "Guarantor organization");
       } catch(HL7Exception e) {
          log.error("Unexpected error creating GT1 - this is probably a bug in the source code generator.", e);
       }
    }



    /**
     * Returns
     * GT1-1: "Set ID - guarantor" - creates it if necessary
     */
    public SI getSetIDGuarantor() { 
		SI retVal = this.getTypedField(1, 0);
		return retVal;
    }
    
    /**
     * Returns
     * GT1-1: "Set ID - guarantor" - creates it if necessary
     */
    public SI getGt11_SetIDGuarantor() { 
		SI retVal = this.getTypedField(1, 0);
		return retVal;
    }



    /**
     * Returns
     * GT1-2: "Guarantor number" - creates it if necessary
     */
    public CK getGuarantorNumber() { 
		CK retVal = this.getTypedField(2, 0);
		return retVal;
    }
    
    /**
     * Returns
     * GT1-2: "Guarantor number" - creates it if necessary
     */
    public CK getGt12_GuarantorNumber() { 
		CK retVal = this.getTypedField(2, 0);
		return retVal;
    }



    /**
     * Returns
     * GT1-3: "Guarantor name" - creates it if necessary
     */
    public PN getGuarantorName() { 
		PN retVal = this.getTypedField(3, 0);
		return retVal;
    }
    
    /**
     * Returns
     * GT1-3: "Guarantor name" - creates it if necessary
     */
    public PN getGt13_GuarantorName() { 
		PN retVal = this.getTypedField(3, 0);
		return retVal;
    }



    /**
     * Returns
     * GT1-4: "Guarantor spouse name" - creates it if necessary
     */
    public PN getGuarantorSpouseName() { 
		PN retVal = this.getTypedField(4, 0);
		return retVal;
    }
    
    /**
     * Returns
     * GT1-4: "Guarantor spouse name" - creates it if necessary
     */
    public PN getGt14_GuarantorSpouseName() { 
		PN retVal = this.getTypedField(4, 0);
		return retVal;
    }



    /**
     * Returns
     * GT1-5: "Guarantor address" - creates it if necessary
     */
    public AD getGuarantorAddress() { 
		AD retVal = this.getTypedField(5, 0);
		return retVal;
    }
    
    /**
     * Returns
     * GT1-5: "Guarantor address" - creates it if necessary
     */
    public AD getGt15_GuarantorAddress() { 
		AD retVal = this.getTypedField(5, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Guarantor phone number - home (GT1-6).
     */
    public TN[] getGuarantorPhoneNumberHome() {
    	TN[] retVal = this.getTypedField(6, new TN[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Guarantor phone number - home (GT1-6).
     */
    public TN[] getGt16_GuarantorPhoneNumberHome() {
    	TN[] retVal = this.getTypedField(6, new TN[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Guarantor phone number - home (GT1-6).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getGuarantorPhoneNumberHomeReps() {
    	return this.getReps(6);
    }


    /**
     * Returns a specific repetition of
     * GT1-6: "Guarantor phone number - home" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public TN getGuarantorPhoneNumberHome(int rep) { 
		TN retVal = this.getTypedField(6, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * GT1-6: "Guarantor phone number - home" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public TN getGt16_GuarantorPhoneNumberHome(int rep) { 
		TN retVal = this.getTypedField(6, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Guarantor phone number - home (GT1-6).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getGt16_GuarantorPhoneNumberHomeReps() {
    	return this.getReps(6);
    }


    /**
     * Inserts a repetition of
     * GT1-6: "Guarantor phone number - home" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public TN insertGuarantorPhoneNumberHome(int rep) throws HL7Exception { 
        return (TN) super.insertRepetition(6, rep);
    }


    /**
     * Inserts a repetition of
     * GT1-6: "Guarantor phone number - home" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public TN insertGt16_GuarantorPhoneNumberHome(int rep) throws HL7Exception { 
        return (TN) super.insertRepetition(6, rep);
    }


    /**
     * Removes a repetition of
     * GT1-6: "Guarantor phone number - home" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public TN removeGuarantorPhoneNumberHome(int rep) throws HL7Exception { 
        return (TN) super.removeRepetition(6, rep);
    }


    /**
     * Removes a repetition of
     * GT1-6: "Guarantor phone number - home" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public TN removeGt16_GuarantorPhoneNumberHome(int rep) throws HL7Exception { 
        return (TN) super.removeRepetition(6, rep);
    }



    /**
     * Returns all repetitions of Guarantor phone number - business (GT1-7).
     */
    public TN[] getGuarantorPhoneNumberBusiness() {
    	TN[] retVal = this.getTypedField(7, new TN[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Guarantor phone number - business (GT1-7).
     */
    public TN[] getGt17_GuarantorPhoneNumberBusiness() {
    	TN[] retVal = this.getTypedField(7, new TN[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Guarantor phone number - business (GT1-7).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getGuarantorPhoneNumberBusinessReps() {
    	return this.getReps(7);
    }


    /**
     * Returns a specific repetition of
     * GT1-7: "Guarantor phone number - business" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public TN getGuarantorPhoneNumberBusiness(int rep) { 
		TN retVal = this.getTypedField(7, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * GT1-7: "Guarantor phone number - business" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public TN getGt17_GuarantorPhoneNumberBusiness(int rep) { 
		TN retVal = this.getTypedField(7, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Guarantor phone number - business (GT1-7).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getGt17_GuarantorPhoneNumberBusinessReps() {
    	return this.getReps(7);
    }


    /**
     * Inserts a repetition of
     * GT1-7: "Guarantor phone number - business" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public TN insertGuarantorPhoneNumberBusiness(int rep) throws HL7Exception { 
        return (TN) super.insertRepetition(7, rep);
    }


    /**
     * Inserts a repetition of
     * GT1-7: "Guarantor phone number - business" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public TN insertGt17_GuarantorPhoneNumberBusiness(int rep) throws HL7Exception { 
        return (TN) super.insertRepetition(7, rep);
    }


    /**
     * Removes a repetition of
     * GT1-7: "Guarantor phone number - business" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public TN removeGuarantorPhoneNumberBusiness(int rep) throws HL7Exception { 
        return (TN) super.removeRepetition(7, rep);
    }


    /**
     * Removes a repetition of
     * GT1-7: "Guarantor phone number - business" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public TN removeGt17_GuarantorPhoneNumberBusiness(int rep) throws HL7Exception { 
        return (TN) super.removeRepetition(7, rep);
    }




    /**
     * Returns
     * GT1-8: "Guarantor date of birth" - creates it if necessary
     */
    public DT getGuarantorDateOfBirth() { 
		DT retVal = this.getTypedField(8, 0);
		return retVal;
    }
    
    /**
     * Returns
     * GT1-8: "Guarantor date of birth" - creates it if necessary
     */
    public DT getGt18_GuarantorDateOfBirth() { 
		DT retVal = this.getTypedField(8, 0);
		return retVal;
    }



    /**
     * Returns
     * GT1-9: "Guarantor sex" - creates it if necessary
     */
    public ID getGuarantorSex() { 
		ID retVal = this.getTypedField(9, 0);
		return retVal;
    }
    
    /**
     * Returns
     * GT1-9: "Guarantor sex" - creates it if necessary
     */
    public ID getGt19_GuarantorSex() { 
		ID retVal = this.getTypedField(9, 0);
		return retVal;
    }



    /**
     * Returns
     * GT1-10: "Guarantor type" - creates it if necessary
     */
    public ID getGuarantorType() { 
		ID retVal = this.getTypedField(10, 0);
		return retVal;
    }
    
    /**
     * Returns
     * GT1-10: "Guarantor type" - creates it if necessary
     */
    public ID getGt110_GuarantorType() { 
		ID retVal = this.getTypedField(10, 0);
		return retVal;
    }



    /**
     * Returns
     * GT1-11: "Guarantor relationship" - creates it if necessary
     */
    public ID getGuarantorRelationship() { 
		ID retVal = this.getTypedField(11, 0);
		return retVal;
    }
    
    /**
     * Returns
     * GT1-11: "Guarantor relationship" - creates it if necessary
     */
    public ID getGt111_GuarantorRelationship() { 
		ID retVal = this.getTypedField(11, 0);
		return retVal;
    }



    /**
     * Returns
     * GT1-12: "Guarantor social security number" - creates it if necessary
     */
    public ST getGuarantorSocialSecurityNumber() { 
		ST retVal = this.getTypedField(12, 0);
		return retVal;
    }
    
    /**
     * Returns
     * GT1-12: "Guarantor social security number" - creates it if necessary
     */
    public ST getGt112_GuarantorSocialSecurityNumber() { 
		ST retVal = this.getTypedField(12, 0);
		return retVal;
    }



    /**
     * Returns
     * GT1-13: "Guarantor date - begin" - creates it if necessary
     */
    public DT getGuarantorDateBegin() { 
		DT retVal = this.getTypedField(13, 0);
		return retVal;
    }
    
    /**
     * Returns
     * GT1-13: "Guarantor date - begin" - creates it if necessary
     */
    public DT getGt113_GuarantorDateBegin() { 
		DT retVal = this.getTypedField(13, 0);
		return retVal;
    }



    /**
     * Returns
     * GT1-14: "Guarantor date - end" - creates it if necessary
     */
    public DT getGuarantorDateEnd() { 
		DT retVal = this.getTypedField(14, 0);
		return retVal;
    }
    
    /**
     * Returns
     * GT1-14: "Guarantor date - end" - creates it if necessary
     */
    public DT getGt114_GuarantorDateEnd() { 
		DT retVal = this.getTypedField(14, 0);
		return retVal;
    }



    /**
     * Returns
     * GT1-15: "Guarantor priority" - creates it if necessary
     */
    public NM getGuarantorPriority() { 
		NM retVal = this.getTypedField(15, 0);
		return retVal;
    }
    
    /**
     * Returns
     * GT1-15: "Guarantor priority" - creates it if necessary
     */
    public NM getGt115_GuarantorPriority() { 
		NM retVal = this.getTypedField(15, 0);
		return retVal;
    }



    /**
     * Returns
     * GT1-16: "Guarantor employer name" - creates it if necessary
     */
    public ST getGuarantorEmployerName() { 
		ST retVal = this.getTypedField(16, 0);
		return retVal;
    }
    
    /**
     * Returns
     * GT1-16: "Guarantor employer name" - creates it if necessary
     */
    public ST getGt116_GuarantorEmployerName() { 
		ST retVal = this.getTypedField(16, 0);
		return retVal;
    }



    /**
     * Returns
     * GT1-17: "Guarantor employer address" - creates it if necessary
     */
    public AD getGuarantorEmployerAddress() { 
		AD retVal = this.getTypedField(17, 0);
		return retVal;
    }
    
    /**
     * Returns
     * GT1-17: "Guarantor employer address" - creates it if necessary
     */
    public AD getGt117_GuarantorEmployerAddress() { 
		AD retVal = this.getTypedField(17, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Guarantor employ phone number (GT1-18).
     */
    public TN[] getGuarantorEmployPhoneNumber() {
    	TN[] retVal = this.getTypedField(18, new TN[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Guarantor employ phone number (GT1-18).
     */
    public TN[] getGt118_GuarantorEmployPhoneNumber() {
    	TN[] retVal = this.getTypedField(18, new TN[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Guarantor employ phone number (GT1-18).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getGuarantorEmployPhoneNumberReps() {
    	return this.getReps(18);
    }


    /**
     * Returns a specific repetition of
     * GT1-18: "Guarantor employ phone number" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public TN getGuarantorEmployPhoneNumber(int rep) { 
		TN retVal = this.getTypedField(18, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * GT1-18: "Guarantor employ phone number" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public TN getGt118_GuarantorEmployPhoneNumber(int rep) { 
		TN retVal = this.getTypedField(18, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Guarantor employ phone number (GT1-18).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getGt118_GuarantorEmployPhoneNumberReps() {
    	return this.getReps(18);
    }


    /**
     * Inserts a repetition of
     * GT1-18: "Guarantor employ phone number" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public TN insertGuarantorEmployPhoneNumber(int rep) throws HL7Exception { 
        return (TN) super.insertRepetition(18, rep);
    }


    /**
     * Inserts a repetition of
     * GT1-18: "Guarantor employ phone number" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public TN insertGt118_GuarantorEmployPhoneNumber(int rep) throws HL7Exception { 
        return (TN) super.insertRepetition(18, rep);
    }


    /**
     * Removes a repetition of
     * GT1-18: "Guarantor employ phone number" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public TN removeGuarantorEmployPhoneNumber(int rep) throws HL7Exception { 
        return (TN) super.removeRepetition(18, rep);
    }


    /**
     * Removes a repetition of
     * GT1-18: "Guarantor employ phone number" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public TN removeGt118_GuarantorEmployPhoneNumber(int rep) throws HL7Exception { 
        return (TN) super.removeRepetition(18, rep);
    }




    /**
     * Returns
     * GT1-19: "Guarantor employee ID number" - creates it if necessary
     */
    public ST getGuarantorEmployeeIDNumber() { 
		ST retVal = this.getTypedField(19, 0);
		return retVal;
    }
    
    /**
     * Returns
     * GT1-19: "Guarantor employee ID number" - creates it if necessary
     */
    public ST getGt119_GuarantorEmployeeIDNumber() { 
		ST retVal = this.getTypedField(19, 0);
		return retVal;
    }



    /**
     * Returns
     * GT1-20: "Guarantor employment status" - creates it if necessary
     */
    public ID getGuarantorEmploymentStatus() { 
		ID retVal = this.getTypedField(20, 0);
		return retVal;
    }
    
    /**
     * Returns
     * GT1-20: "Guarantor employment status" - creates it if necessary
     */
    public ID getGt120_GuarantorEmploymentStatus() { 
		ID retVal = this.getTypedField(20, 0);
		return retVal;
    }



    /**
     * Returns
     * GT1-21: "Guarantor organization" - creates it if necessary
     */
    public ST getGuarantorOrganization() { 
		ST retVal = this.getTypedField(21, 0);
		return retVal;
    }
    
    /**
     * Returns
     * GT1-21: "Guarantor organization" - creates it if necessary
     */
    public ST getGt121_GuarantorOrganization() { 
		ST retVal = this.getTypedField(21, 0);
		return retVal;
    }





    /** {@inheritDoc} */   
    protected Type createNewTypeWithoutReflection(int field) {
       switch (field) {
          case 0: return new SI(getMessage());
          case 1: return new CK(getMessage());
          case 2: return new PN(getMessage());
          case 3: return new PN(getMessage());
          case 4: return new AD(getMessage());
          case 5: return new TN(getMessage());
          case 6: return new TN(getMessage());
          case 7: return new DT(getMessage());
          case 8: return new ID(getMessage(), new Integer( 1 ));
          case 9: return new ID(getMessage(), new Integer( 68 ));
          case 10: return new ID(getMessage(), new Integer( 63 ));
          case 11: return new ST(getMessage());
          case 12: return new DT(getMessage());
          case 13: return new DT(getMessage());
          case 14: return new NM(getMessage());
          case 15: return new ST(getMessage());
          case 16: return new AD(getMessage());
          case 17: return new TN(getMessage());
          case 18: return new ST(getMessage());
          case 19: return new ID(getMessage(), new Integer( 66 ));
          case 20: return new ST(getMessage());
          default: return null;
       }
   }


}

