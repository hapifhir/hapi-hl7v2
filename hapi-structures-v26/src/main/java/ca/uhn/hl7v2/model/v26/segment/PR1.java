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
 *<p>Represents an HL7 PR1 message segment (Procedures). 
 * This segment has the following fields:</p>
 * <ul>
     * <li>PR1-1: Set ID - PR1 (SI) <b> </b>
     * <li>PR1-2: Procedure Coding Method (NULLDT) <b>optional </b>
     * <li>PR1-3: Procedure Code (CNE) <b> </b>
     * <li>PR1-4: Procedure Description (NULLDT) <b>optional </b>
     * <li>PR1-5: Procedure Date/Time (DTM) <b> </b>
     * <li>PR1-6: Procedure Functional Type (IS) <b>optional </b>
     * <li>PR1-7: Procedure Minutes (NM) <b>optional </b>
     * <li>PR1-8: Anesthesiologist (NULLDT) <b>optional </b>
     * <li>PR1-9: Anesthesia Code (IS) <b>optional </b>
     * <li>PR1-10: Anesthesia Minutes (NM) <b>optional </b>
     * <li>PR1-11: Surgeon (NULLDT) <b>optional </b>
     * <li>PR1-12: Procedure Practitioner (NULLDT) <b>optional </b>
     * <li>PR1-13: Consent Code (CWE) <b>optional </b>
     * <li>PR1-14: Procedure Priority (ID) <b>optional </b>
     * <li>PR1-15: Associated Diagnosis Code (CWE) <b>optional </b>
     * <li>PR1-16: Procedure Code Modifier (CNE) <b>optional repeating</b>
     * <li>PR1-17: Procedure DRG Type (IS) <b>optional </b>
     * <li>PR1-18: Tissue Type Code (CWE) <b>optional repeating</b>
     * <li>PR1-19: Procedure Identifier (EI) <b>optional </b>
     * <li>PR1-20: Procedure Action Code (ID) <b>optional </b>
     * <li>PR1-21: DRG Procedure Determination Status (IS) <b>optional </b>
     * <li>PR1-22: DRG Procedure Relevance (IS) <b>optional </b>
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
                                  this.add(NULLDT.class, false, 1, 0, new Object[]{ getMessage() }, "Procedure Coding Method");
                                  this.add(CNE.class, true, 1, 705, new Object[]{ getMessage() }, "Procedure Code");
                                  this.add(NULLDT.class, false, 1, 0, new Object[]{ getMessage() }, "Procedure Description");
                                  this.add(DTM.class, true, 1, 24, new Object[]{ getMessage() }, "Procedure Date/Time");
                                              this.add(IS.class, false, 1, 2, new Object[]{ getMessage(), new Integer(230) }, "Procedure Functional Type");
                                  this.add(NM.class, false, 1, 4, new Object[]{ getMessage() }, "Procedure Minutes");
                                  this.add(NULLDT.class, false, 1, 0, new Object[]{ getMessage() }, "Anesthesiologist");
                                              this.add(IS.class, false, 1, 2, new Object[]{ getMessage(), new Integer(19) }, "Anesthesia Code");
                                  this.add(NM.class, false, 1, 4, new Object[]{ getMessage() }, "Anesthesia Minutes");
                                  this.add(NULLDT.class, false, 1, 0, new Object[]{ getMessage() }, "Surgeon");
                                  this.add(NULLDT.class, false, 1, 0, new Object[]{ getMessage() }, "Procedure Practitioner");
                                  this.add(CWE.class, false, 1, 250, new Object[]{ getMessage() }, "Consent Code");
                                              this.add(ID.class, false, 1, 2, new Object[]{ getMessage(), new Integer(418) }, "Procedure Priority");
                                  this.add(CWE.class, false, 1, 250, new Object[]{ getMessage() }, "Associated Diagnosis Code");
                                  this.add(CNE.class, false, 0, 705, new Object[]{ getMessage() }, "Procedure Code Modifier");
                                              this.add(IS.class, false, 1, 20, new Object[]{ getMessage(), new Integer(416) }, "Procedure DRG Type");
                                  this.add(CWE.class, false, 0, 250, new Object[]{ getMessage() }, "Tissue Type Code");
                                  this.add(EI.class, false, 1, 427, new Object[]{ getMessage() }, "Procedure Identifier");
                                              this.add(ID.class, false, 1, 1, new Object[]{ getMessage(), new Integer(206) }, "Procedure Action Code");
                                              this.add(IS.class, false, 1, 20, new Object[]{ getMessage(), new Integer(761) }, "DRG Procedure Determination Status");
                                              this.add(IS.class, false, 1, 20, new Object[]{ getMessage(), new Integer(763) }, "DRG Procedure Relevance");
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
    public NULLDT getProcedureCodingMethod() { 
		NULLDT retVal = this.getTypedField(2, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PR1-2: "Procedure Coding Method" - creates it if necessary
     */
    public NULLDT getPr12_ProcedureCodingMethod() { 
		NULLDT retVal = this.getTypedField(2, 0);
		return retVal;
    }



    /**
     * Returns
     * PR1-3: "Procedure Code" - creates it if necessary
     */
    public CNE getProcedureCode() { 
		CNE retVal = this.getTypedField(3, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PR1-3: "Procedure Code" - creates it if necessary
     */
    public CNE getPr13_ProcedureCode() { 
		CNE retVal = this.getTypedField(3, 0);
		return retVal;
    }



    /**
     * Returns
     * PR1-4: "Procedure Description" - creates it if necessary
     */
    public NULLDT getProcedureDescription() { 
		NULLDT retVal = this.getTypedField(4, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PR1-4: "Procedure Description" - creates it if necessary
     */
    public NULLDT getPr14_ProcedureDescription() { 
		NULLDT retVal = this.getTypedField(4, 0);
		return retVal;
    }



    /**
     * Returns
     * PR1-5: "Procedure Date/Time" - creates it if necessary
     */
    public DTM getProcedureDateTime() { 
		DTM retVal = this.getTypedField(5, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PR1-5: "Procedure Date/Time" - creates it if necessary
     */
    public DTM getPr15_ProcedureDateTime() { 
		DTM retVal = this.getTypedField(5, 0);
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
     * Returns
     * PR1-8: "Anesthesiologist" - creates it if necessary
     */
    public NULLDT getAnesthesiologist() { 
		NULLDT retVal = this.getTypedField(8, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PR1-8: "Anesthesiologist" - creates it if necessary
     */
    public NULLDT getPr18_Anesthesiologist() { 
		NULLDT retVal = this.getTypedField(8, 0);
		return retVal;
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
     * Returns
     * PR1-11: "Surgeon" - creates it if necessary
     */
    public NULLDT getSurgeon() { 
		NULLDT retVal = this.getTypedField(11, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PR1-11: "Surgeon" - creates it if necessary
     */
    public NULLDT getPr111_Surgeon() { 
		NULLDT retVal = this.getTypedField(11, 0);
		return retVal;
    }



    /**
     * Returns
     * PR1-12: "Procedure Practitioner" - creates it if necessary
     */
    public NULLDT getProcedurePractitioner() { 
		NULLDT retVal = this.getTypedField(12, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PR1-12: "Procedure Practitioner" - creates it if necessary
     */
    public NULLDT getPr112_ProcedurePractitioner() { 
		NULLDT retVal = this.getTypedField(12, 0);
		return retVal;
    }



    /**
     * Returns
     * PR1-13: "Consent Code" - creates it if necessary
     */
    public CWE getConsentCode() { 
		CWE retVal = this.getTypedField(13, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PR1-13: "Consent Code" - creates it if necessary
     */
    public CWE getPr113_ConsentCode() { 
		CWE retVal = this.getTypedField(13, 0);
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
    public CWE getAssociatedDiagnosisCode() { 
		CWE retVal = this.getTypedField(15, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PR1-15: "Associated Diagnosis Code" - creates it if necessary
     */
    public CWE getPr115_AssociatedDiagnosisCode() { 
		CWE retVal = this.getTypedField(15, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Procedure Code Modifier (PR1-16).
     */
    public CNE[] getProcedureCodeModifier() {
    	CNE[] retVal = this.getTypedField(16, new CNE[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Procedure Code Modifier (PR1-16).
     */
    public CNE[] getPr116_ProcedureCodeModifier() {
    	CNE[] retVal = this.getTypedField(16, new CNE[0]);
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
    public CNE getProcedureCodeModifier(int rep) { 
		CNE retVal = this.getTypedField(16, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * PR1-16: "Procedure Code Modifier" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CNE getPr116_ProcedureCodeModifier(int rep) { 
		CNE retVal = this.getTypedField(16, rep);
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
    public CNE insertProcedureCodeModifier(int rep) throws HL7Exception { 
        return (CNE) super.insertRepetition(16, rep);
    }


    /**
     * Inserts a repetition of
     * PR1-16: "Procedure Code Modifier" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CNE insertPr116_ProcedureCodeModifier(int rep) throws HL7Exception { 
        return (CNE) super.insertRepetition(16, rep);
    }


    /**
     * Removes a repetition of
     * PR1-16: "Procedure Code Modifier" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CNE removeProcedureCodeModifier(int rep) throws HL7Exception { 
        return (CNE) super.removeRepetition(16, rep);
    }


    /**
     * Removes a repetition of
     * PR1-16: "Procedure Code Modifier" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CNE removePr116_ProcedureCodeModifier(int rep) throws HL7Exception { 
        return (CNE) super.removeRepetition(16, rep);
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
    public CWE[] getTissueTypeCode() {
    	CWE[] retVal = this.getTypedField(18, new CWE[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Tissue Type Code (PR1-18).
     */
    public CWE[] getPr118_TissueTypeCode() {
    	CWE[] retVal = this.getTypedField(18, new CWE[0]);
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
    public CWE getTissueTypeCode(int rep) { 
		CWE retVal = this.getTypedField(18, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * PR1-18: "Tissue Type Code" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CWE getPr118_TissueTypeCode(int rep) { 
		CWE retVal = this.getTypedField(18, rep);
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
    public CWE insertTissueTypeCode(int rep) throws HL7Exception { 
        return (CWE) super.insertRepetition(18, rep);
    }


    /**
     * Inserts a repetition of
     * PR1-18: "Tissue Type Code" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE insertPr118_TissueTypeCode(int rep) throws HL7Exception { 
        return (CWE) super.insertRepetition(18, rep);
    }


    /**
     * Removes a repetition of
     * PR1-18: "Tissue Type Code" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE removeTissueTypeCode(int rep) throws HL7Exception { 
        return (CWE) super.removeRepetition(18, rep);
    }


    /**
     * Removes a repetition of
     * PR1-18: "Tissue Type Code" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE removePr118_TissueTypeCode(int rep) throws HL7Exception { 
        return (CWE) super.removeRepetition(18, rep);
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



    /**
     * Returns
     * PR1-21: "DRG Procedure Determination Status" - creates it if necessary
     */
    public IS getDRGProcedureDeterminationStatus() { 
		IS retVal = this.getTypedField(21, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PR1-21: "DRG Procedure Determination Status" - creates it if necessary
     */
    public IS getPr121_DRGProcedureDeterminationStatus() { 
		IS retVal = this.getTypedField(21, 0);
		return retVal;
    }



    /**
     * Returns
     * PR1-22: "DRG Procedure Relevance" - creates it if necessary
     */
    public IS getDRGProcedureRelevance() { 
		IS retVal = this.getTypedField(22, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PR1-22: "DRG Procedure Relevance" - creates it if necessary
     */
    public IS getPr122_DRGProcedureRelevance() { 
		IS retVal = this.getTypedField(22, 0);
		return retVal;
    }





    /** {@inheritDoc} */   
    protected Type createNewTypeWithoutReflection(int field) {
       switch (field) {
          case 0: return new SI(getMessage());
          case 1: return new NULLDT(getMessage());
          case 2: return new CNE(getMessage());
          case 3: return new NULLDT(getMessage());
          case 4: return new DTM(getMessage());
          case 5: return new IS(getMessage(), new Integer( 230 ));
          case 6: return new NM(getMessage());
          case 7: return new NULLDT(getMessage());
          case 8: return new IS(getMessage(), new Integer( 19 ));
          case 9: return new NM(getMessage());
          case 10: return new NULLDT(getMessage());
          case 11: return new NULLDT(getMessage());
          case 12: return new CWE(getMessage());
          case 13: return new ID(getMessage(), new Integer( 418 ));
          case 14: return new CWE(getMessage());
          case 15: return new CNE(getMessage());
          case 16: return new IS(getMessage(), new Integer( 416 ));
          case 17: return new CWE(getMessage());
          case 18: return new EI(getMessage());
          case 19: return new ID(getMessage(), new Integer( 206 ));
          case 20: return new IS(getMessage(), new Integer( 761 ));
          case 21: return new IS(getMessage(), new Integer( 763 ));
          default: return null;
       }
   }


}

