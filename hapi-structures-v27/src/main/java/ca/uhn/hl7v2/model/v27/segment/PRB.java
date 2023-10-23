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
 *<p>Represents an HL7 PRB message segment (Problem Details). 
 * This segment has the following fields:</p>
 * <ul>
     * <li>PRB-1: Action Code (ID) <b> </b>
     * <li>PRB-2: Action Date/Time (DTM) <b> </b>
     * <li>PRB-3: Problem ID (CWE) <b> </b>
     * <li>PRB-4: Problem Instance ID (EI) <b> </b>
     * <li>PRB-5: Episode of Care ID (EI) <b>optional </b>
     * <li>PRB-6: Problem List Priority (NM) <b>optional </b>
     * <li>PRB-7: Problem Established Date/Time (DTM) <b>optional </b>
     * <li>PRB-8: Anticipated Problem Resolution Date/Time (DTM) <b>optional </b>
     * <li>PRB-9: Actual Problem Resolution Date/Time (DTM) <b>optional </b>
     * <li>PRB-10: Problem Classification (CWE) <b>optional </b>
     * <li>PRB-11: Problem Management Discipline (CWE) <b>optional repeating</b>
     * <li>PRB-12: Problem Persistence (CWE) <b>optional </b>
     * <li>PRB-13: Problem Confirmation Status (CWE) <b>optional </b>
     * <li>PRB-14: Problem Life Cycle Status (CWE) <b>optional </b>
     * <li>PRB-15: Problem Life Cycle Status Date/Time (DTM) <b>optional </b>
     * <li>PRB-16: Problem Date of Onset (DTM) <b>optional </b>
     * <li>PRB-17: Problem Onset Text (ST) <b>optional </b>
     * <li>PRB-18: Problem Ranking (CWE) <b>optional </b>
     * <li>PRB-19: Certainty of Problem (CWE) <b>optional </b>
     * <li>PRB-20: Probability of Problem (0-1) (NM) <b>optional </b>
     * <li>PRB-21: Individual Awareness of Problem (CWE) <b>optional </b>
     * <li>PRB-22: Problem Prognosis (CWE) <b>optional </b>
     * <li>PRB-23: Individual Awareness of Prognosis (CWE) <b>optional </b>
     * <li>PRB-24: Family/Significant Other Awareness of Problem/Prognosis (ST) <b>optional </b>
     * <li>PRB-25: Security/Sensitivity (CWE) <b>optional </b>
     * <li>PRB-26: Problem Severity (CWE) <b>optional </b>
     * <li>PRB-27: Problem Perspective (CWE) <b>optional </b>
     * <li>PRB-28: Mood Code (CNE) <b>optional </b>
 * </ul>
 */
@SuppressWarnings("unused")
public class PRB extends AbstractSegment {

    /** 
     * Creates a new PRB segment
     */
    public PRB(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                              this.add(ID.class, true, 1, 2, new Object[]{ getMessage(), new Integer(287) }, "Action Code");
                                  this.add(DTM.class, true, 1, 0, new Object[]{ getMessage() }, "Action Date/Time");
                                  this.add(CWE.class, true, 1, 0, new Object[]{ getMessage() }, "Problem ID");
                                  this.add(EI.class, true, 1, 0, new Object[]{ getMessage() }, "Problem Instance ID");
                                  this.add(EI.class, false, 1, 0, new Object[]{ getMessage() }, "Episode of Care ID");
                                  this.add(NM.class, false, 1, 0, new Object[]{ getMessage() }, "Problem List Priority");
                                  this.add(DTM.class, false, 1, 0, new Object[]{ getMessage() }, "Problem Established Date/Time");
                                  this.add(DTM.class, false, 1, 0, new Object[]{ getMessage() }, "Anticipated Problem Resolution Date/Time");
                                  this.add(DTM.class, false, 1, 0, new Object[]{ getMessage() }, "Actual Problem Resolution Date/Time");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "Problem Classification");
                                  this.add(CWE.class, false, 0, 0, new Object[]{ getMessage() }, "Problem Management Discipline");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "Problem Persistence");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "Problem Confirmation Status");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "Problem Life Cycle Status");
                                  this.add(DTM.class, false, 1, 0, new Object[]{ getMessage() }, "Problem Life Cycle Status Date/Time");
                                  this.add(DTM.class, false, 1, 0, new Object[]{ getMessage() }, "Problem Date of Onset");
                                  this.add(ST.class, false, 1, 0, new Object[]{ getMessage() }, "Problem Onset Text");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "Problem Ranking");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "Certainty of Problem");
                                  this.add(NM.class, false, 1, 0, new Object[]{ getMessage() }, "Probability of Problem (0-1)");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "Individual Awareness of Problem");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "Problem Prognosis");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "Individual Awareness of Prognosis");
                                  this.add(ST.class, false, 1, 0, new Object[]{ getMessage() }, "Family/Significant Other Awareness of Problem/Prognosis");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "Security/Sensitivity");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "Problem Severity");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "Problem Perspective");
                                  this.add(CNE.class, false, 1, 0, new Object[]{ getMessage() }, "Mood Code");
       } catch(HL7Exception e) {
          log.error("Unexpected error creating PRB - this is probably a bug in the source code generator.", e);
       }
    }



    /**
     * Returns
     * PRB-1: "Action Code" - creates it if necessary
     */
    public ID getActionCode() { 
		ID retVal = this.getTypedField(1, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PRB-1: "Action Code" - creates it if necessary
     */
    public ID getPrb1_ActionCode() { 
		ID retVal = this.getTypedField(1, 0);
		return retVal;
    }



    /**
     * Returns
     * PRB-2: "Action Date/Time" - creates it if necessary
     */
    public DTM getActionDateTime() { 
		DTM retVal = this.getTypedField(2, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PRB-2: "Action Date/Time" - creates it if necessary
     */
    public DTM getPrb2_ActionDateTime() { 
		DTM retVal = this.getTypedField(2, 0);
		return retVal;
    }



    /**
     * Returns
     * PRB-3: "Problem ID" - creates it if necessary
     */
    public CWE getProblemID() { 
		CWE retVal = this.getTypedField(3, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PRB-3: "Problem ID" - creates it if necessary
     */
    public CWE getPrb3_ProblemID() { 
		CWE retVal = this.getTypedField(3, 0);
		return retVal;
    }



    /**
     * Returns
     * PRB-4: "Problem Instance ID" - creates it if necessary
     */
    public EI getProblemInstanceID() { 
		EI retVal = this.getTypedField(4, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PRB-4: "Problem Instance ID" - creates it if necessary
     */
    public EI getPrb4_ProblemInstanceID() { 
		EI retVal = this.getTypedField(4, 0);
		return retVal;
    }



    /**
     * Returns
     * PRB-5: "Episode of Care ID" - creates it if necessary
     */
    public EI getEpisodeOfCareID() { 
		EI retVal = this.getTypedField(5, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PRB-5: "Episode of Care ID" - creates it if necessary
     */
    public EI getPrb5_EpisodeOfCareID() { 
		EI retVal = this.getTypedField(5, 0);
		return retVal;
    }



    /**
     * Returns
     * PRB-6: "Problem List Priority" - creates it if necessary
     */
    public NM getProblemListPriority() { 
		NM retVal = this.getTypedField(6, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PRB-6: "Problem List Priority" - creates it if necessary
     */
    public NM getPrb6_ProblemListPriority() { 
		NM retVal = this.getTypedField(6, 0);
		return retVal;
    }



    /**
     * Returns
     * PRB-7: "Problem Established Date/Time" - creates it if necessary
     */
    public DTM getProblemEstablishedDateTime() { 
		DTM retVal = this.getTypedField(7, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PRB-7: "Problem Established Date/Time" - creates it if necessary
     */
    public DTM getPrb7_ProblemEstablishedDateTime() { 
		DTM retVal = this.getTypedField(7, 0);
		return retVal;
    }



    /**
     * Returns
     * PRB-8: "Anticipated Problem Resolution Date/Time" - creates it if necessary
     */
    public DTM getAnticipatedProblemResolutionDateTime() { 
		DTM retVal = this.getTypedField(8, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PRB-8: "Anticipated Problem Resolution Date/Time" - creates it if necessary
     */
    public DTM getPrb8_AnticipatedProblemResolutionDateTime() { 
		DTM retVal = this.getTypedField(8, 0);
		return retVal;
    }



    /**
     * Returns
     * PRB-9: "Actual Problem Resolution Date/Time" - creates it if necessary
     */
    public DTM getActualProblemResolutionDateTime() { 
		DTM retVal = this.getTypedField(9, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PRB-9: "Actual Problem Resolution Date/Time" - creates it if necessary
     */
    public DTM getPrb9_ActualProblemResolutionDateTime() { 
		DTM retVal = this.getTypedField(9, 0);
		return retVal;
    }



    /**
     * Returns
     * PRB-10: "Problem Classification" - creates it if necessary
     */
    public CWE getProblemClassification() { 
		CWE retVal = this.getTypedField(10, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PRB-10: "Problem Classification" - creates it if necessary
     */
    public CWE getPrb10_ProblemClassification() { 
		CWE retVal = this.getTypedField(10, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Problem Management Discipline (PRB-11).
     */
    public CWE[] getProblemManagementDiscipline() {
    	CWE[] retVal = this.getTypedField(11, new CWE[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Problem Management Discipline (PRB-11).
     */
    public CWE[] getPrb11_ProblemManagementDiscipline() {
    	CWE[] retVal = this.getTypedField(11, new CWE[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Problem Management Discipline (PRB-11).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getProblemManagementDisciplineReps() {
    	return this.getReps(11);
    }


    /**
     * Returns a specific repetition of
     * PRB-11: "Problem Management Discipline" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CWE getProblemManagementDiscipline(int rep) { 
		CWE retVal = this.getTypedField(11, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * PRB-11: "Problem Management Discipline" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CWE getPrb11_ProblemManagementDiscipline(int rep) { 
		CWE retVal = this.getTypedField(11, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Problem Management Discipline (PRB-11).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getPrb11_ProblemManagementDisciplineReps() {
    	return this.getReps(11);
    }


    /**
     * Inserts a repetition of
     * PRB-11: "Problem Management Discipline" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE insertProblemManagementDiscipline(int rep) throws HL7Exception { 
        return (CWE) super.insertRepetition(11, rep);
    }


    /**
     * Inserts a repetition of
     * PRB-11: "Problem Management Discipline" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE insertPrb11_ProblemManagementDiscipline(int rep) throws HL7Exception { 
        return (CWE) super.insertRepetition(11, rep);
    }


    /**
     * Removes a repetition of
     * PRB-11: "Problem Management Discipline" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE removeProblemManagementDiscipline(int rep) throws HL7Exception { 
        return (CWE) super.removeRepetition(11, rep);
    }


    /**
     * Removes a repetition of
     * PRB-11: "Problem Management Discipline" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE removePrb11_ProblemManagementDiscipline(int rep) throws HL7Exception { 
        return (CWE) super.removeRepetition(11, rep);
    }




    /**
     * Returns
     * PRB-12: "Problem Persistence" - creates it if necessary
     */
    public CWE getProblemPersistence() { 
		CWE retVal = this.getTypedField(12, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PRB-12: "Problem Persistence" - creates it if necessary
     */
    public CWE getPrb12_ProblemPersistence() { 
		CWE retVal = this.getTypedField(12, 0);
		return retVal;
    }



    /**
     * Returns
     * PRB-13: "Problem Confirmation Status" - creates it if necessary
     */
    public CWE getProblemConfirmationStatus() { 
		CWE retVal = this.getTypedField(13, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PRB-13: "Problem Confirmation Status" - creates it if necessary
     */
    public CWE getPrb13_ProblemConfirmationStatus() { 
		CWE retVal = this.getTypedField(13, 0);
		return retVal;
    }



    /**
     * Returns
     * PRB-14: "Problem Life Cycle Status" - creates it if necessary
     */
    public CWE getProblemLifeCycleStatus() { 
		CWE retVal = this.getTypedField(14, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PRB-14: "Problem Life Cycle Status" - creates it if necessary
     */
    public CWE getPrb14_ProblemLifeCycleStatus() { 
		CWE retVal = this.getTypedField(14, 0);
		return retVal;
    }



    /**
     * Returns
     * PRB-15: "Problem Life Cycle Status Date/Time" - creates it if necessary
     */
    public DTM getProblemLifeCycleStatusDateTime() { 
		DTM retVal = this.getTypedField(15, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PRB-15: "Problem Life Cycle Status Date/Time" - creates it if necessary
     */
    public DTM getPrb15_ProblemLifeCycleStatusDateTime() { 
		DTM retVal = this.getTypedField(15, 0);
		return retVal;
    }



    /**
     * Returns
     * PRB-16: "Problem Date of Onset" - creates it if necessary
     */
    public DTM getProblemDateOfOnset() { 
		DTM retVal = this.getTypedField(16, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PRB-16: "Problem Date of Onset" - creates it if necessary
     */
    public DTM getPrb16_ProblemDateOfOnset() { 
		DTM retVal = this.getTypedField(16, 0);
		return retVal;
    }



    /**
     * Returns
     * PRB-17: "Problem Onset Text" - creates it if necessary
     */
    public ST getProblemOnsetText() { 
		ST retVal = this.getTypedField(17, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PRB-17: "Problem Onset Text" - creates it if necessary
     */
    public ST getPrb17_ProblemOnsetText() { 
		ST retVal = this.getTypedField(17, 0);
		return retVal;
    }



    /**
     * Returns
     * PRB-18: "Problem Ranking" - creates it if necessary
     */
    public CWE getProblemRanking() { 
		CWE retVal = this.getTypedField(18, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PRB-18: "Problem Ranking" - creates it if necessary
     */
    public CWE getPrb18_ProblemRanking() { 
		CWE retVal = this.getTypedField(18, 0);
		return retVal;
    }



    /**
     * Returns
     * PRB-19: "Certainty of Problem" - creates it if necessary
     */
    public CWE getCertaintyOfProblem() { 
		CWE retVal = this.getTypedField(19, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PRB-19: "Certainty of Problem" - creates it if necessary
     */
    public CWE getPrb19_CertaintyOfProblem() { 
		CWE retVal = this.getTypedField(19, 0);
		return retVal;
    }



    /**
     * Returns
     * PRB-20: "Probability of Problem (0-1)" - creates it if necessary
     */
    public NM getProbabilityOfProblem() { 
		NM retVal = this.getTypedField(20, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PRB-20: "Probability of Problem (0-1)" - creates it if necessary
     */
    public NM getPrb20_ProbabilityOfProblem() { 
		NM retVal = this.getTypedField(20, 0);
		return retVal;
    }



    /**
     * Returns
     * PRB-21: "Individual Awareness of Problem" - creates it if necessary
     */
    public CWE getIndividualAwarenessOfProblem() { 
		CWE retVal = this.getTypedField(21, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PRB-21: "Individual Awareness of Problem" - creates it if necessary
     */
    public CWE getPrb21_IndividualAwarenessOfProblem() { 
		CWE retVal = this.getTypedField(21, 0);
		return retVal;
    }



    /**
     * Returns
     * PRB-22: "Problem Prognosis" - creates it if necessary
     */
    public CWE getProblemPrognosis() { 
		CWE retVal = this.getTypedField(22, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PRB-22: "Problem Prognosis" - creates it if necessary
     */
    public CWE getPrb22_ProblemPrognosis() { 
		CWE retVal = this.getTypedField(22, 0);
		return retVal;
    }



    /**
     * Returns
     * PRB-23: "Individual Awareness of Prognosis" - creates it if necessary
     */
    public CWE getIndividualAwarenessOfPrognosis() { 
		CWE retVal = this.getTypedField(23, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PRB-23: "Individual Awareness of Prognosis" - creates it if necessary
     */
    public CWE getPrb23_IndividualAwarenessOfPrognosis() { 
		CWE retVal = this.getTypedField(23, 0);
		return retVal;
    }



    /**
     * Returns
     * PRB-24: "Family/Significant Other Awareness of Problem/Prognosis" - creates it if necessary
     */
    public ST getFamilySignificantOtherAwarenessOfProblemPrognosis() { 
		ST retVal = this.getTypedField(24, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PRB-24: "Family/Significant Other Awareness of Problem/Prognosis" - creates it if necessary
     */
    public ST getPrb24_FamilySignificantOtherAwarenessOfProblemPrognosis() { 
		ST retVal = this.getTypedField(24, 0);
		return retVal;
    }



    /**
     * Returns
     * PRB-25: "Security/Sensitivity" - creates it if necessary
     */
    public CWE getSecuritySensitivity() { 
		CWE retVal = this.getTypedField(25, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PRB-25: "Security/Sensitivity" - creates it if necessary
     */
    public CWE getPrb25_SecuritySensitivity() { 
		CWE retVal = this.getTypedField(25, 0);
		return retVal;
    }



    /**
     * Returns
     * PRB-26: "Problem Severity" - creates it if necessary
     */
    public CWE getProblemSeverity() { 
		CWE retVal = this.getTypedField(26, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PRB-26: "Problem Severity" - creates it if necessary
     */
    public CWE getPrb26_ProblemSeverity() { 
		CWE retVal = this.getTypedField(26, 0);
		return retVal;
    }



    /**
     * Returns
     * PRB-27: "Problem Perspective" - creates it if necessary
     */
    public CWE getProblemPerspective() { 
		CWE retVal = this.getTypedField(27, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PRB-27: "Problem Perspective" - creates it if necessary
     */
    public CWE getPrb27_ProblemPerspective() { 
		CWE retVal = this.getTypedField(27, 0);
		return retVal;
    }



    /**
     * Returns
     * PRB-28: "Mood Code" - creates it if necessary
     */
    public CNE getMoodCode() { 
		CNE retVal = this.getTypedField(28, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PRB-28: "Mood Code" - creates it if necessary
     */
    public CNE getPrb28_MoodCode() { 
		CNE retVal = this.getTypedField(28, 0);
		return retVal;
    }





    /** {@inheritDoc} */   
    protected Type createNewTypeWithoutReflection(int field) {
       switch (field) {
          case 0: return new ID(getMessage(), new Integer( 287 ));
          case 1: return new DTM(getMessage());
          case 2: return new CWE(getMessage());
          case 3: return new EI(getMessage());
          case 4: return new EI(getMessage());
          case 5: return new NM(getMessage());
          case 6: return new DTM(getMessage());
          case 7: return new DTM(getMessage());
          case 8: return new DTM(getMessage());
          case 9: return new CWE(getMessage());
          case 10: return new CWE(getMessage());
          case 11: return new CWE(getMessage());
          case 12: return new CWE(getMessage());
          case 13: return new CWE(getMessage());
          case 14: return new DTM(getMessage());
          case 15: return new DTM(getMessage());
          case 16: return new ST(getMessage());
          case 17: return new CWE(getMessage());
          case 18: return new CWE(getMessage());
          case 19: return new NM(getMessage());
          case 20: return new CWE(getMessage());
          case 21: return new CWE(getMessage());
          case 22: return new CWE(getMessage());
          case 23: return new ST(getMessage());
          case 24: return new CWE(getMessage());
          case 25: return new CWE(getMessage());
          case 26: return new CWE(getMessage());
          case 27: return new CNE(getMessage());
          default: return null;
       }
   }


}

