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


package ca.uhn.hl7v2.model.v251.segment;

// import ca.uhn.hl7v2.model.v251.group.*;
import ca.uhn.hl7v2.model.v251.datatype.*;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.parser.DefaultModelClassFactory;
import ca.uhn.hl7v2.model.AbstractMessage;
import ca.uhn.hl7v2.model.Group;
import ca.uhn.hl7v2.model.Type;
import ca.uhn.hl7v2.model.AbstractSegment;
import ca.uhn.hl7v2.model.Varies;


/**
 *<p>Represents an HL7 PR1 message segment (Procedures). 
 * This segment has the following fields:</p>
 * <ul>
     * <li>PR1-1: Set ID - PR1 (SI) <b> </b>
     * <li>PR1-2: Procedure Coding Method (IS) <b>optional </b>
     * <li>PR1-3: Procedure Code (CE) <b> </b>
     * <li>PR1-4: Procedure Description (ST) <b>optional </b>
     * <li>PR1-5: Procedure Date/Time (TS) <b> </b>
     * <li>PR1-6: Procedure Functional Type (IS) <b>optional </b>
     * <li>PR1-7: Procedure Minutes (NM) <b>optional </b>
     * <li>PR1-8: Anesthesiologist (XCN) <b>optional repeating</b>
     * <li>PR1-9: Anesthesia Code (IS) <b>optional </b>
     * <li>PR1-10: Anesthesia Minutes (NM) <b>optional </b>
     * <li>PR1-11: Surgeon (XCN) <b>optional repeating</b>
     * <li>PR1-12: Procedure Practitioner (XCN) <b>optional repeating</b>
     * <li>PR1-13: Consent Code (CE) <b>optional </b>
     * <li>PR1-14: Procedure Priority (ID) <b>optional </b>
     * <li>PR1-15: Associated Diagnosis Code (CE) <b>optional </b>
     * <li>PR1-16: Procedure Code Modifier (CE) <b>optional repeating</b>
     * <li>PR1-17: Procedure DRG Type (IS) <b>optional </b>
     * <li>PR1-18: Tissue Type Code (CE) <b>optional repeating</b>
     * <li>PR1-19: Procedure Identifier (EI) <b>optional </b>
     * <li>PR1-20: Procedure Action Code (ID) <b>optional </b>
 * </ul>
 */
@SuppressWarnings("unused")
public class PR1 extends AbstractSegment {

    /** 
     * Creates a new PR1 segment
     */
    public PR1(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(SI.class, true, 1, 4, new Object[]{ getMessage() }, "Set ID - PR1");
                                              this.add(IS.class, false, 1, 3, new Object[]{ getMessage(), new Integer(89) }, "Procedure Coding Method");
                                  this.add(CE.class, true, 1, 250, new Object[]{ getMessage() }, "Procedure Code");
                                  this.add(ST.class, false, 1, 40, new Object[]{ getMessage() }, "Procedure Description");
                                  this.add(TS.class, true, 1, 26, new Object[]{ getMessage() }, "Procedure Date/Time");
                                              this.add(IS.class, false, 1, 2, new Object[]{ getMessage(), new Integer(230) }, "Procedure Functional Type");
                                  this.add(NM.class, false, 1, 4, new Object[]{ getMessage() }, "Procedure Minutes");
                                  this.add(XCN.class, false, 0, 250, new Object[]{ getMessage() }, "Anesthesiologist");
                                              this.add(IS.class, false, 1, 2, new Object[]{ getMessage(), new Integer(19) }, "Anesthesia Code");
                                  this.add(NM.class, false, 1, 4, new Object[]{ getMessage() }, "Anesthesia Minutes");
                                  this.add(XCN.class, false, 0, 250, new Object[]{ getMessage() }, "Surgeon");
                                  this.add(XCN.class, false, 0, 250, new Object[]{ getMessage() }, "Procedure Practitioner");
                                  this.add(CE.class, false, 1, 250, new Object[]{ getMessage() }, "Consent Code");
                                              this.add(ID.class, false, 1, 2, new Object[]{ getMessage(), new Integer(418) }, "Procedure Priority");
                                  this.add(CE.class, false, 1, 250, new Object[]{ getMessage() }, "Associated Diagnosis Code");
                                  this.add(CE.class, false, 0, 250, new Object[]{ getMessage() }, "Procedure Code Modifier");
                                              this.add(IS.class, false, 1, 20, new Object[]{ getMessage(), new Integer(416) }, "Procedure DRG Type");
                                  this.add(CE.class, false, 0, 250, new Object[]{ getMessage() }, "Tissue Type Code");
                                  this.add(EI.class, false, 1, 427, new Object[]{ getMessage() }, "Procedure Identifier");
                                              this.add(ID.class, false, 1, 1, new Object[]{ getMessage(), new Integer(206) }, "Procedure Action Code");
       } catch(HL7Exception e) {
          log.error("Unexpected error creating PR1 - this is probably a bug in the source code generator.", e);
       }
    }



    /**
     * Returns
     * PR1-1: "Set ID - PR1" - creates it if necessary
     */
    public SI getSetIDPR1() { 
		SI retVal = this.getTypedField(1, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PR1-1: "Set ID - PR1" - creates it if necessary
     */
    public SI getPr11_SetIDPR1() { 
		SI retVal = this.getTypedField(1, 0);
		return retVal;
    }



    /**
     * Returns
     * PR1-2: "Procedure Coding Method" - creates it if necessary
     */
    public IS getProcedureCodingMethod() { 
		IS retVal = this.getTypedField(2, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PR1-2: "Procedure Coding Method" - creates it if necessary
     */
    public IS getPr12_ProcedureCodingMethod() { 
		IS retVal = this.getTypedField(2, 0);
		return retVal;
    }



    /**
     * Returns
     * PR1-3: "Procedure Code" - creates it if necessary
     */
    public CE getProcedureCode() { 
		CE retVal = this.getTypedField(3, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PR1-3: "Procedure Code" - creates it if necessary
     */
    public CE getPr13_ProcedureCode() { 
		CE retVal = this.getTypedField(3, 0);
		return retVal;
    }



    /**
     * Returns
     * PR1-4: "Procedure Description" - creates it if necessary
     */
    public ST getProcedureDescription() { 
		ST retVal = this.getTypedField(4, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PR1-4: "Procedure Description" - creates it if necessary
     */
    public ST getPr14_ProcedureDescription() { 
		ST retVal = this.getTypedField(4, 0);
		return retVal;
    }



    /**
     * Returns
     * PR1-5: "Procedure Date/Time" - creates it if necessary
     */
    public TS getProcedureDateTime() { 
		TS retVal = this.getTypedField(5, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PR1-5: "Procedure Date/Time" - creates it if necessary
     */
    public TS getPr15_ProcedureDateTime() { 
		TS retVal = this.getTypedField(5, 0);
		return retVal;
    }



    /**
     * Returns
     * PR1-6: "Procedure Functional Type" - creates it if necessary
     */
    public IS getProcedureFunctionalType() { 
		IS retVal = this.getTypedField(6, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PR1-6: "Procedure Functional Type" - creates it if necessary
     */
    public IS getPr16_ProcedureFunctionalType() { 
		IS retVal = this.getTypedField(6, 0);
		return retVal;
    }



    /**
     * Returns
     * PR1-7: "Procedure Minutes" - creates it if necessary
     */
    public NM getProcedureMinutes() { 
		NM retVal = this.getTypedField(7, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PR1-7: "Procedure Minutes" - creates it if necessary
     */
    public NM getPr17_ProcedureMinutes() { 
		NM retVal = this.getTypedField(7, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Anesthesiologist (PR1-8).
     */
    public XCN[] getAnesthesiologist() {
    	XCN[] retVal = this.getTypedField(8, new XCN[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Anesthesiologist (PR1-8).
     */
    public XCN[] getPr18_Anesthesiologist() {
    	XCN[] retVal = this.getTypedField(8, new XCN[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Anesthesiologist (PR1-8).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getAnesthesiologistReps() {
    	return this.getReps(8);
    }


    /**
     * Returns a specific repetition of
     * PR1-8: "Anesthesiologist" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XCN getAnesthesiologist(int rep) { 
		XCN retVal = this.getTypedField(8, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * PR1-8: "Anesthesiologist" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XCN getPr18_Anesthesiologist(int rep) { 
		XCN retVal = this.getTypedField(8, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Anesthesiologist (PR1-8).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getPr18_AnesthesiologistReps() {
    	return this.getReps(8);
    }


    /**
     * Inserts a repetition of
     * PR1-8: "Anesthesiologist" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XCN insertAnesthesiologist(int rep) throws HL7Exception { 
        return (XCN) super.insertRepetition(8, rep);
    }


    /**
     * Inserts a repetition of
     * PR1-8: "Anesthesiologist" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XCN insertPr18_Anesthesiologist(int rep) throws HL7Exception { 
        return (XCN) super.insertRepetition(8, rep);
    }


    /**
     * Removes a repetition of
     * PR1-8: "Anesthesiologist" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XCN removeAnesthesiologist(int rep) throws HL7Exception { 
        return (XCN) super.removeRepetition(8, rep);
    }


    /**
     * Removes a repetition of
     * PR1-8: "Anesthesiologist" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XCN removePr18_Anesthesiologist(int rep) throws HL7Exception { 
        return (XCN) super.removeRepetition(8, rep);
    }




    /**
     * Returns
     * PR1-9: "Anesthesia Code" - creates it if necessary
     */
    public IS getAnesthesiaCode() { 
		IS retVal = this.getTypedField(9, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PR1-9: "Anesthesia Code" - creates it if necessary
     */
    public IS getPr19_AnesthesiaCode() { 
		IS retVal = this.getTypedField(9, 0);
		return retVal;
    }



    /**
     * Returns
     * PR1-10: "Anesthesia Minutes" - creates it if necessary
     */
    public NM getAnesthesiaMinutes() { 
		NM retVal = this.getTypedField(10, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PR1-10: "Anesthesia Minutes" - creates it if necessary
     */
    public NM getPr110_AnesthesiaMinutes() { 
		NM retVal = this.getTypedField(10, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Surgeon (PR1-11).
     */
    public XCN[] getSurgeon() {
    	XCN[] retVal = this.getTypedField(11, new XCN[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Surgeon (PR1-11).
     */
    public XCN[] getPr111_Surgeon() {
    	XCN[] retVal = this.getTypedField(11, new XCN[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Surgeon (PR1-11).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getSurgeonReps() {
    	return this.getReps(11);
    }


    /**
     * Returns a specific repetition of
     * PR1-11: "Surgeon" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XCN getSurgeon(int rep) { 
		XCN retVal = this.getTypedField(11, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * PR1-11: "Surgeon" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XCN getPr111_Surgeon(int rep) { 
		XCN retVal = this.getTypedField(11, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Surgeon (PR1-11).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getPr111_SurgeonReps() {
    	return this.getReps(11);
    }


    /**
     * Inserts a repetition of
     * PR1-11: "Surgeon" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XCN insertSurgeon(int rep) throws HL7Exception { 
        return (XCN) super.insertRepetition(11, rep);
    }


    /**
     * Inserts a repetition of
     * PR1-11: "Surgeon" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XCN insertPr111_Surgeon(int rep) throws HL7Exception { 
        return (XCN) super.insertRepetition(11, rep);
    }


    /**
     * Removes a repetition of
     * PR1-11: "Surgeon" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XCN removeSurgeon(int rep) throws HL7Exception { 
        return (XCN) super.removeRepetition(11, rep);
    }


    /**
     * Removes a repetition of
     * PR1-11: "Surgeon" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XCN removePr111_Surgeon(int rep) throws HL7Exception { 
        return (XCN) super.removeRepetition(11, rep);
    }



    /**
     * Returns all repetitions of Procedure Practitioner (PR1-12).
     */
    public XCN[] getProcedurePractitioner() {
    	XCN[] retVal = this.getTypedField(12, new XCN[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Procedure Practitioner (PR1-12).
     */
    public XCN[] getPr112_ProcedurePractitioner() {
    	XCN[] retVal = this.getTypedField(12, new XCN[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Procedure Practitioner (PR1-12).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getProcedurePractitionerReps() {
    	return this.getReps(12);
    }


    /**
     * Returns a specific repetition of
     * PR1-12: "Procedure Practitioner" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XCN getProcedurePractitioner(int rep) { 
		XCN retVal = this.getTypedField(12, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * PR1-12: "Procedure Practitioner" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XCN getPr112_ProcedurePractitioner(int rep) { 
		XCN retVal = this.getTypedField(12, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Procedure Practitioner (PR1-12).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getPr112_ProcedurePractitionerReps() {
    	return this.getReps(12);
    }


    /**
     * Inserts a repetition of
     * PR1-12: "Procedure Practitioner" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XCN insertProcedurePractitioner(int rep) throws HL7Exception { 
        return (XCN) super.insertRepetition(12, rep);
    }


    /**
     * Inserts a repetition of
     * PR1-12: "Procedure Practitioner" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XCN insertPr112_ProcedurePractitioner(int rep) throws HL7Exception { 
        return (XCN) super.insertRepetition(12, rep);
    }


    /**
     * Removes a repetition of
     * PR1-12: "Procedure Practitioner" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XCN removeProcedurePractitioner(int rep) throws HL7Exception { 
        return (XCN) super.removeRepetition(12, rep);
    }


    /**
     * Removes a repetition of
     * PR1-12: "Procedure Practitioner" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XCN removePr112_ProcedurePractitioner(int rep) throws HL7Exception { 
        return (XCN) super.removeRepetition(12, rep);
    }




    /**
     * Returns
     * PR1-13: "Consent Code" - creates it if necessary
     */
    public CE getConsentCode() { 
		CE retVal = this.getTypedField(13, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PR1-13: "Consent Code" - creates it if necessary
     */
    public CE getPr113_ConsentCode() { 
		CE retVal = this.getTypedField(13, 0);
		return retVal;
    }



    /**
     * Returns
     * PR1-14: "Procedure Priority" - creates it if necessary
     */
    public ID getProcedurePriority() { 
		ID retVal = this.getTypedField(14, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PR1-14: "Procedure Priority" - creates it if necessary
     */
    public ID getPr114_ProcedurePriority() { 
		ID retVal = this.getTypedField(14, 0);
		return retVal;
    }



    /**
     * Returns
     * PR1-15: "Associated Diagnosis Code" - creates it if necessary
     */
    public CE getAssociatedDiagnosisCode() { 
		CE retVal = this.getTypedField(15, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PR1-15: "Associated Diagnosis Code" - creates it if necessary
     */
    public CE getPr115_AssociatedDiagnosisCode() { 
		CE retVal = this.getTypedField(15, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Procedure Code Modifier (PR1-16).
     */
    public CE[] getProcedureCodeModifier() {
    	CE[] retVal = this.getTypedField(16, new CE[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Procedure Code Modifier (PR1-16).
     */
    public CE[] getPr116_ProcedureCodeModifier() {
    	CE[] retVal = this.getTypedField(16, new CE[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Procedure Code Modifier (PR1-16).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getProcedureCodeModifierReps() {
    	return this.getReps(16);
    }


    /**
     * Returns a specific repetition of
     * PR1-16: "Procedure Code Modifier" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CE getProcedureCodeModifier(int rep) { 
		CE retVal = this.getTypedField(16, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * PR1-16: "Procedure Code Modifier" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CE getPr116_ProcedureCodeModifier(int rep) { 
		CE retVal = this.getTypedField(16, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Procedure Code Modifier (PR1-16).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getPr116_ProcedureCodeModifierReps() {
    	return this.getReps(16);
    }


    /**
     * Inserts a repetition of
     * PR1-16: "Procedure Code Modifier" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE insertProcedureCodeModifier(int rep) throws HL7Exception { 
        return (CE) super.insertRepetition(16, rep);
    }


    /**
     * Inserts a repetition of
     * PR1-16: "Procedure Code Modifier" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE insertPr116_ProcedureCodeModifier(int rep) throws HL7Exception { 
        return (CE) super.insertRepetition(16, rep);
    }


    /**
     * Removes a repetition of
     * PR1-16: "Procedure Code Modifier" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE removeProcedureCodeModifier(int rep) throws HL7Exception { 
        return (CE) super.removeRepetition(16, rep);
    }


    /**
     * Removes a repetition of
     * PR1-16: "Procedure Code Modifier" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE removePr116_ProcedureCodeModifier(int rep) throws HL7Exception { 
        return (CE) super.removeRepetition(16, rep);
    }




    /**
     * Returns
     * PR1-17: "Procedure DRG Type" - creates it if necessary
     */
    public IS getProcedureDRGType() { 
		IS retVal = this.getTypedField(17, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PR1-17: "Procedure DRG Type" - creates it if necessary
     */
    public IS getPr117_ProcedureDRGType() { 
		IS retVal = this.getTypedField(17, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Tissue Type Code (PR1-18).
     */
    public CE[] getTissueTypeCode() {
    	CE[] retVal = this.getTypedField(18, new CE[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Tissue Type Code (PR1-18).
     */
    public CE[] getPr118_TissueTypeCode() {
    	CE[] retVal = this.getTypedField(18, new CE[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Tissue Type Code (PR1-18).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getTissueTypeCodeReps() {
    	return this.getReps(18);
    }


    /**
     * Returns a specific repetition of
     * PR1-18: "Tissue Type Code" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CE getTissueTypeCode(int rep) { 
		CE retVal = this.getTypedField(18, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * PR1-18: "Tissue Type Code" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CE getPr118_TissueTypeCode(int rep) { 
		CE retVal = this.getTypedField(18, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Tissue Type Code (PR1-18).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getPr118_TissueTypeCodeReps() {
    	return this.getReps(18);
    }


    /**
     * Inserts a repetition of
     * PR1-18: "Tissue Type Code" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE insertTissueTypeCode(int rep) throws HL7Exception { 
        return (CE) super.insertRepetition(18, rep);
    }


    /**
     * Inserts a repetition of
     * PR1-18: "Tissue Type Code" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE insertPr118_TissueTypeCode(int rep) throws HL7Exception { 
        return (CE) super.insertRepetition(18, rep);
    }


    /**
     * Removes a repetition of
     * PR1-18: "Tissue Type Code" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE removeTissueTypeCode(int rep) throws HL7Exception { 
        return (CE) super.removeRepetition(18, rep);
    }


    /**
     * Removes a repetition of
     * PR1-18: "Tissue Type Code" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE removePr118_TissueTypeCode(int rep) throws HL7Exception { 
        return (CE) super.removeRepetition(18, rep);
    }




    /**
     * Returns
     * PR1-19: "Procedure Identifier" - creates it if necessary
     */
    public EI getProcedureIdentifier() { 
		EI retVal = this.getTypedField(19, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PR1-19: "Procedure Identifier" - creates it if necessary
     */
    public EI getPr119_ProcedureIdentifier() { 
		EI retVal = this.getTypedField(19, 0);
		return retVal;
    }



    /**
     * Returns
     * PR1-20: "Procedure Action Code" - creates it if necessary
     */
    public ID getProcedureActionCode() { 
		ID retVal = this.getTypedField(20, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PR1-20: "Procedure Action Code" - creates it if necessary
     */
    public ID getPr120_ProcedureActionCode() { 
		ID retVal = this.getTypedField(20, 0);
		return retVal;
    }





    /** {@inheritDoc} */   
    protected Type createNewTypeWithoutReflection(int field) {
       switch (field) {
          case 0: return new SI(getMessage());
          case 1: return new IS(getMessage(), new Integer( 89 ));
          case 2: return new CE(getMessage());
          case 3: return new ST(getMessage());
          case 4: return new TS(getMessage());
          case 5: return new IS(getMessage(), new Integer( 230 ));
          case 6: return new NM(getMessage());
          case 7: return new XCN(getMessage());
          case 8: return new IS(getMessage(), new Integer( 19 ));
          case 9: return new NM(getMessage());
          case 10: return new XCN(getMessage());
          case 11: return new XCN(getMessage());
          case 12: return new CE(getMessage());
          case 13: return new ID(getMessage(), new Integer( 418 ));
          case 14: return new CE(getMessage());
          case 15: return new CE(getMessage());
          case 16: return new IS(getMessage(), new Integer( 416 ));
          case 17: return new CE(getMessage());
          case 18: return new EI(getMessage());
          case 19: return new ID(getMessage(), new Integer( 206 ));
          default: return null;
       }
   }


}

