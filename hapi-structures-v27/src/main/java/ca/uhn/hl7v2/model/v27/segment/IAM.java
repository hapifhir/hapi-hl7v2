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
 *<p>Represents an HL7 IAM message segment (Patient Adverse Reaction Information). 
 * This segment has the following fields:</p>
 * <ul>
     * <li>IAM-1: Set ID - IAM (SI) <b> </b>
     * <li>IAM-2: Allergen Type Code (CWE) <b>optional </b>
     * <li>IAM-3: Allergen Code/Mnemonic/Description (CWE) <b> </b>
     * <li>IAM-4: Allergy Severity Code (CWE) <b>optional </b>
     * <li>IAM-5: Allergy Reaction Code (ST) <b>optional repeating</b>
     * <li>IAM-6: Allergy Action Code (CNE) <b> </b>
     * <li>IAM-7: Allergy Unique Identifier (EI) <b>optional </b>
     * <li>IAM-8: Action Reason (ST) <b>optional </b>
     * <li>IAM-9: Sensitivity to Causative Agent Code (CWE) <b>optional </b>
     * <li>IAM-10: Allergen Group Code/Mnemonic/Description (CWE) <b>optional </b>
     * <li>IAM-11: Onset Date (DT) <b>optional </b>
     * <li>IAM-12: Onset Date Text (ST) <b>optional </b>
     * <li>IAM-13: Reported Date/Time (DTM) <b>optional </b>
     * <li>IAM-14: Reported By (XPN) <b>optional </b>
     * <li>IAM-15: Relationship to Patient Code (CWE) <b>optional </b>
     * <li>IAM-16: Alert Device Code (CWE) <b>optional </b>
     * <li>IAM-17: Allergy Clinical Status Code (CWE) <b>optional </b>
     * <li>IAM-18: Statused by Person (XCN) <b>optional </b>
     * <li>IAM-19: Statused by Organization (XON) <b>optional </b>
     * <li>IAM-20: Statused at Date/Time (DTM) <b>optional </b>
     * <li>IAM-21: Inactivated by Person (XCN) <b>optional </b>
     * <li>IAM-22: Inactivated Date/Time (DTM) <b>optional </b>
     * <li>IAM-23: Initially Recorded by Person (XCN) <b>optional </b>
     * <li>IAM-24: Initially Recorded Date/Time (DTM) <b>optional </b>
     * <li>IAM-25: Modified by Person (XCN) <b>optional </b>
     * <li>IAM-26: Modified Date/Time (DTM) <b>optional </b>
     * <li>IAM-27: Clinician Identified Code (CWE) <b>optional </b>
     * <li>IAM-28: Initially Recorded by Organization (XON) <b>optional </b>
     * <li>IAM-29: Modified by Organization (XON) <b>optional </b>
     * <li>IAM-30: Inactivated by Organization (XON) <b>optional </b>
 * </ul>
 */
@SuppressWarnings("unused")
public class IAM extends AbstractSegment {

    /** 
     * Creates a new IAM segment
     */
    public IAM(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(SI.class, true, 1, 4, new Object[]{ getMessage() }, "Set ID - IAM");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "Allergen Type Code");
                                  this.add(CWE.class, true, 1, 0, new Object[]{ getMessage() }, "Allergen Code/Mnemonic/Description");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "Allergy Severity Code");
                                  this.add(ST.class, false, 0, 0, new Object[]{ getMessage() }, "Allergy Reaction Code");
                                  this.add(CNE.class, true, 1, 0, new Object[]{ getMessage() }, "Allergy Action Code");
                                  this.add(EI.class, false, 1, 0, new Object[]{ getMessage() }, "Allergy Unique Identifier");
                                  this.add(ST.class, false, 1, 0, new Object[]{ getMessage() }, "Action Reason");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "Sensitivity to Causative Agent Code");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "Allergen Group Code/Mnemonic/Description");
                                  this.add(DT.class, false, 1, 0, new Object[]{ getMessage() }, "Onset Date");
                                  this.add(ST.class, false, 1, 0, new Object[]{ getMessage() }, "Onset Date Text");
                                  this.add(DTM.class, false, 1, 0, new Object[]{ getMessage() }, "Reported Date/Time");
                                  this.add(XPN.class, false, 1, 0, new Object[]{ getMessage() }, "Reported By");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "Relationship to Patient Code");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "Alert Device Code");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "Allergy Clinical Status Code");
                                  this.add(XCN.class, false, 1, 0, new Object[]{ getMessage() }, "Statused by Person");
                                  this.add(XON.class, false, 1, 0, new Object[]{ getMessage() }, "Statused by Organization");
                                  this.add(DTM.class, false, 1, 0, new Object[]{ getMessage() }, "Statused at Date/Time");
                                  this.add(XCN.class, false, 1, 0, new Object[]{ getMessage() }, "Inactivated by Person");
                                  this.add(DTM.class, false, 1, 0, new Object[]{ getMessage() }, "Inactivated Date/Time");
                                  this.add(XCN.class, false, 1, 0, new Object[]{ getMessage() }, "Initially Recorded by Person");
                                  this.add(DTM.class, false, 1, 0, new Object[]{ getMessage() }, "Initially Recorded Date/Time");
                                  this.add(XCN.class, false, 1, 0, new Object[]{ getMessage() }, "Modified by Person");
                                  this.add(DTM.class, false, 1, 0, new Object[]{ getMessage() }, "Modified Date/Time");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "Clinician Identified Code");
                                  this.add(XON.class, false, 1, 0, new Object[]{ getMessage() }, "Initially Recorded by Organization");
                                  this.add(XON.class, false, 1, 0, new Object[]{ getMessage() }, "Modified by Organization");
                                  this.add(XON.class, false, 1, 0, new Object[]{ getMessage() }, "Inactivated by Organization");
       } catch(HL7Exception e) {
          log.error("Unexpected error creating IAM - this is probably a bug in the source code generator.", e);
       }
    }



    /**
     * Returns
     * IAM-1: "Set ID - IAM" - creates it if necessary
     */
    public SI getSetIDIAM() { 
		SI retVal = this.getTypedField(1, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IAM-1: "Set ID - IAM" - creates it if necessary
     */
    public SI getIam1_SetIDIAM() { 
		SI retVal = this.getTypedField(1, 0);
		return retVal;
    }



    /**
     * Returns
     * IAM-2: "Allergen Type Code" - creates it if necessary
     */
    public CWE getAllergenTypeCode() { 
		CWE retVal = this.getTypedField(2, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IAM-2: "Allergen Type Code" - creates it if necessary
     */
    public CWE getIam2_AllergenTypeCode() { 
		CWE retVal = this.getTypedField(2, 0);
		return retVal;
    }



    /**
     * Returns
     * IAM-3: "Allergen Code/Mnemonic/Description" - creates it if necessary
     */
    public CWE getAllergenCodeMnemonicDescription() { 
		CWE retVal = this.getTypedField(3, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IAM-3: "Allergen Code/Mnemonic/Description" - creates it if necessary
     */
    public CWE getIam3_AllergenCodeMnemonicDescription() { 
		CWE retVal = this.getTypedField(3, 0);
		return retVal;
    }



    /**
     * Returns
     * IAM-4: "Allergy Severity Code" - creates it if necessary
     */
    public CWE getAllergySeverityCode() { 
		CWE retVal = this.getTypedField(4, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IAM-4: "Allergy Severity Code" - creates it if necessary
     */
    public CWE getIam4_AllergySeverityCode() { 
		CWE retVal = this.getTypedField(4, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Allergy Reaction Code (IAM-5).
     */
    public ST[] getAllergyReactionCode() {
    	ST[] retVal = this.getTypedField(5, new ST[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Allergy Reaction Code (IAM-5).
     */
    public ST[] getIam5_AllergyReactionCode() {
    	ST[] retVal = this.getTypedField(5, new ST[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Allergy Reaction Code (IAM-5).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getAllergyReactionCodeReps() {
    	return this.getReps(5);
    }


    /**
     * Returns a specific repetition of
     * IAM-5: "Allergy Reaction Code" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public ST getAllergyReactionCode(int rep) { 
		ST retVal = this.getTypedField(5, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * IAM-5: "Allergy Reaction Code" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public ST getIam5_AllergyReactionCode(int rep) { 
		ST retVal = this.getTypedField(5, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Allergy Reaction Code (IAM-5).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getIam5_AllergyReactionCodeReps() {
    	return this.getReps(5);
    }


    /**
     * Inserts a repetition of
     * IAM-5: "Allergy Reaction Code" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ST insertAllergyReactionCode(int rep) throws HL7Exception { 
        return (ST) super.insertRepetition(5, rep);
    }


    /**
     * Inserts a repetition of
     * IAM-5: "Allergy Reaction Code" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ST insertIam5_AllergyReactionCode(int rep) throws HL7Exception { 
        return (ST) super.insertRepetition(5, rep);
    }


    /**
     * Removes a repetition of
     * IAM-5: "Allergy Reaction Code" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ST removeAllergyReactionCode(int rep) throws HL7Exception { 
        return (ST) super.removeRepetition(5, rep);
    }


    /**
     * Removes a repetition of
     * IAM-5: "Allergy Reaction Code" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ST removeIam5_AllergyReactionCode(int rep) throws HL7Exception { 
        return (ST) super.removeRepetition(5, rep);
    }




    /**
     * Returns
     * IAM-6: "Allergy Action Code" - creates it if necessary
     */
    public CNE getAllergyActionCode() { 
		CNE retVal = this.getTypedField(6, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IAM-6: "Allergy Action Code" - creates it if necessary
     */
    public CNE getIam6_AllergyActionCode() { 
		CNE retVal = this.getTypedField(6, 0);
		return retVal;
    }



    /**
     * Returns
     * IAM-7: "Allergy Unique Identifier" - creates it if necessary
     */
    public EI getAllergyUniqueIdentifier() { 
		EI retVal = this.getTypedField(7, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IAM-7: "Allergy Unique Identifier" - creates it if necessary
     */
    public EI getIam7_AllergyUniqueIdentifier() { 
		EI retVal = this.getTypedField(7, 0);
		return retVal;
    }



    /**
     * Returns
     * IAM-8: "Action Reason" - creates it if necessary
     */
    public ST getActionReason() { 
		ST retVal = this.getTypedField(8, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IAM-8: "Action Reason" - creates it if necessary
     */
    public ST getIam8_ActionReason() { 
		ST retVal = this.getTypedField(8, 0);
		return retVal;
    }



    /**
     * Returns
     * IAM-9: "Sensitivity to Causative Agent Code" - creates it if necessary
     */
    public CWE getSensitivityToCausativeAgentCode() { 
		CWE retVal = this.getTypedField(9, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IAM-9: "Sensitivity to Causative Agent Code" - creates it if necessary
     */
    public CWE getIam9_SensitivityToCausativeAgentCode() { 
		CWE retVal = this.getTypedField(9, 0);
		return retVal;
    }



    /**
     * Returns
     * IAM-10: "Allergen Group Code/Mnemonic/Description" - creates it if necessary
     */
    public CWE getAllergenGroupCodeMnemonicDescription() { 
		CWE retVal = this.getTypedField(10, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IAM-10: "Allergen Group Code/Mnemonic/Description" - creates it if necessary
     */
    public CWE getIam10_AllergenGroupCodeMnemonicDescription() { 
		CWE retVal = this.getTypedField(10, 0);
		return retVal;
    }



    /**
     * Returns
     * IAM-11: "Onset Date" - creates it if necessary
     */
    public DT getOnsetDate() { 
		DT retVal = this.getTypedField(11, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IAM-11: "Onset Date" - creates it if necessary
     */
    public DT getIam11_OnsetDate() { 
		DT retVal = this.getTypedField(11, 0);
		return retVal;
    }



    /**
     * Returns
     * IAM-12: "Onset Date Text" - creates it if necessary
     */
    public ST getOnsetDateText() { 
		ST retVal = this.getTypedField(12, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IAM-12: "Onset Date Text" - creates it if necessary
     */
    public ST getIam12_OnsetDateText() { 
		ST retVal = this.getTypedField(12, 0);
		return retVal;
    }



    /**
     * Returns
     * IAM-13: "Reported Date/Time" - creates it if necessary
     */
    public DTM getReportedDateTime() { 
		DTM retVal = this.getTypedField(13, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IAM-13: "Reported Date/Time" - creates it if necessary
     */
    public DTM getIam13_ReportedDateTime() { 
		DTM retVal = this.getTypedField(13, 0);
		return retVal;
    }



    /**
     * Returns
     * IAM-14: "Reported By" - creates it if necessary
     */
    public XPN getReportedBy() { 
		XPN retVal = this.getTypedField(14, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IAM-14: "Reported By" - creates it if necessary
     */
    public XPN getIam14_ReportedBy() { 
		XPN retVal = this.getTypedField(14, 0);
		return retVal;
    }



    /**
     * Returns
     * IAM-15: "Relationship to Patient Code" - creates it if necessary
     */
    public CWE getRelationshipToPatientCode() { 
		CWE retVal = this.getTypedField(15, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IAM-15: "Relationship to Patient Code" - creates it if necessary
     */
    public CWE getIam15_RelationshipToPatientCode() { 
		CWE retVal = this.getTypedField(15, 0);
		return retVal;
    }



    /**
     * Returns
     * IAM-16: "Alert Device Code" - creates it if necessary
     */
    public CWE getAlertDeviceCode() { 
		CWE retVal = this.getTypedField(16, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IAM-16: "Alert Device Code" - creates it if necessary
     */
    public CWE getIam16_AlertDeviceCode() { 
		CWE retVal = this.getTypedField(16, 0);
		return retVal;
    }



    /**
     * Returns
     * IAM-17: "Allergy Clinical Status Code" - creates it if necessary
     */
    public CWE getAllergyClinicalStatusCode() { 
		CWE retVal = this.getTypedField(17, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IAM-17: "Allergy Clinical Status Code" - creates it if necessary
     */
    public CWE getIam17_AllergyClinicalStatusCode() { 
		CWE retVal = this.getTypedField(17, 0);
		return retVal;
    }



    /**
     * Returns
     * IAM-18: "Statused by Person" - creates it if necessary
     */
    public XCN getStatusedByPerson() { 
		XCN retVal = this.getTypedField(18, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IAM-18: "Statused by Person" - creates it if necessary
     */
    public XCN getIam18_StatusedByPerson() { 
		XCN retVal = this.getTypedField(18, 0);
		return retVal;
    }



    /**
     * Returns
     * IAM-19: "Statused by Organization" - creates it if necessary
     */
    public XON getStatusedByOrganization() { 
		XON retVal = this.getTypedField(19, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IAM-19: "Statused by Organization" - creates it if necessary
     */
    public XON getIam19_StatusedByOrganization() { 
		XON retVal = this.getTypedField(19, 0);
		return retVal;
    }



    /**
     * Returns
     * IAM-20: "Statused at Date/Time" - creates it if necessary
     */
    public DTM getStatusedAtDateTime() { 
		DTM retVal = this.getTypedField(20, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IAM-20: "Statused at Date/Time" - creates it if necessary
     */
    public DTM getIam20_StatusedAtDateTime() { 
		DTM retVal = this.getTypedField(20, 0);
		return retVal;
    }



    /**
     * Returns
     * IAM-21: "Inactivated by Person" - creates it if necessary
     */
    public XCN getInactivatedByPerson() { 
		XCN retVal = this.getTypedField(21, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IAM-21: "Inactivated by Person" - creates it if necessary
     */
    public XCN getIam21_InactivatedByPerson() { 
		XCN retVal = this.getTypedField(21, 0);
		return retVal;
    }



    /**
     * Returns
     * IAM-22: "Inactivated Date/Time" - creates it if necessary
     */
    public DTM getInactivatedDateTime() { 
		DTM retVal = this.getTypedField(22, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IAM-22: "Inactivated Date/Time" - creates it if necessary
     */
    public DTM getIam22_InactivatedDateTime() { 
		DTM retVal = this.getTypedField(22, 0);
		return retVal;
    }



    /**
     * Returns
     * IAM-23: "Initially Recorded by Person" - creates it if necessary
     */
    public XCN getInitiallyRecordedByPerson() { 
		XCN retVal = this.getTypedField(23, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IAM-23: "Initially Recorded by Person" - creates it if necessary
     */
    public XCN getIam23_InitiallyRecordedByPerson() { 
		XCN retVal = this.getTypedField(23, 0);
		return retVal;
    }



    /**
     * Returns
     * IAM-24: "Initially Recorded Date/Time" - creates it if necessary
     */
    public DTM getInitiallyRecordedDateTime() { 
		DTM retVal = this.getTypedField(24, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IAM-24: "Initially Recorded Date/Time" - creates it if necessary
     */
    public DTM getIam24_InitiallyRecordedDateTime() { 
		DTM retVal = this.getTypedField(24, 0);
		return retVal;
    }



    /**
     * Returns
     * IAM-25: "Modified by Person" - creates it if necessary
     */
    public XCN getModifiedByPerson() { 
		XCN retVal = this.getTypedField(25, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IAM-25: "Modified by Person" - creates it if necessary
     */
    public XCN getIam25_ModifiedByPerson() { 
		XCN retVal = this.getTypedField(25, 0);
		return retVal;
    }



    /**
     * Returns
     * IAM-26: "Modified Date/Time" - creates it if necessary
     */
    public DTM getModifiedDateTime() { 
		DTM retVal = this.getTypedField(26, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IAM-26: "Modified Date/Time" - creates it if necessary
     */
    public DTM getIam26_ModifiedDateTime() { 
		DTM retVal = this.getTypedField(26, 0);
		return retVal;
    }



    /**
     * Returns
     * IAM-27: "Clinician Identified Code" - creates it if necessary
     */
    public CWE getClinicianIdentifiedCode() { 
		CWE retVal = this.getTypedField(27, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IAM-27: "Clinician Identified Code" - creates it if necessary
     */
    public CWE getIam27_ClinicianIdentifiedCode() { 
		CWE retVal = this.getTypedField(27, 0);
		return retVal;
    }



    /**
     * Returns
     * IAM-28: "Initially Recorded by Organization" - creates it if necessary
     */
    public XON getInitiallyRecordedByOrganization() { 
		XON retVal = this.getTypedField(28, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IAM-28: "Initially Recorded by Organization" - creates it if necessary
     */
    public XON getIam28_InitiallyRecordedByOrganization() { 
		XON retVal = this.getTypedField(28, 0);
		return retVal;
    }



    /**
     * Returns
     * IAM-29: "Modified by Organization" - creates it if necessary
     */
    public XON getModifiedByOrganization() { 
		XON retVal = this.getTypedField(29, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IAM-29: "Modified by Organization" - creates it if necessary
     */
    public XON getIam29_ModifiedByOrganization() { 
		XON retVal = this.getTypedField(29, 0);
		return retVal;
    }



    /**
     * Returns
     * IAM-30: "Inactivated by Organization" - creates it if necessary
     */
    public XON getInactivatedByOrganization() { 
		XON retVal = this.getTypedField(30, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IAM-30: "Inactivated by Organization" - creates it if necessary
     */
    public XON getIam30_InactivatedByOrganization() { 
		XON retVal = this.getTypedField(30, 0);
		return retVal;
    }





    /** {@inheritDoc} */   
    protected Type createNewTypeWithoutReflection(int field) {
       switch (field) {
          case 0: return new SI(getMessage());
          case 1: return new CWE(getMessage());
          case 2: return new CWE(getMessage());
          case 3: return new CWE(getMessage());
          case 4: return new ST(getMessage());
          case 5: return new CNE(getMessage());
          case 6: return new EI(getMessage());
          case 7: return new ST(getMessage());
          case 8: return new CWE(getMessage());
          case 9: return new CWE(getMessage());
          case 10: return new DT(getMessage());
          case 11: return new ST(getMessage());
          case 12: return new DTM(getMessage());
          case 13: return new XPN(getMessage());
          case 14: return new CWE(getMessage());
          case 15: return new CWE(getMessage());
          case 16: return new CWE(getMessage());
          case 17: return new XCN(getMessage());
          case 18: return new XON(getMessage());
          case 19: return new DTM(getMessage());
          case 20: return new XCN(getMessage());
          case 21: return new DTM(getMessage());
          case 22: return new XCN(getMessage());
          case 23: return new DTM(getMessage());
          case 24: return new XCN(getMessage());
          case 25: return new DTM(getMessage());
          case 26: return new CWE(getMessage());
          case 27: return new XON(getMessage());
          case 28: return new XON(getMessage());
          case 29: return new XON(getMessage());
          default: return null;
       }
   }


}

