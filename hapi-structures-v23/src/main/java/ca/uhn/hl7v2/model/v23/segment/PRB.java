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


package ca.uhn.hl7v2.model.v23.segment;

// import ca.uhn.hl7v2.model.v23.group.*;
import ca.uhn.hl7v2.model.v23.datatype.*;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.parser.DefaultModelClassFactory;
import ca.uhn.hl7v2.model.AbstractMessage;
import ca.uhn.hl7v2.model.Group;
import ca.uhn.hl7v2.model.Type;
import ca.uhn.hl7v2.model.AbstractSegment;
import ca.uhn.hl7v2.model.Varies;


/**
 *<p>Represents an HL7 PRB message segment (Problem Detail). 
 * This segment has the following fields:</p>
 * <ul>
     * <li>PRB-1: Action Code (ID) <b> </b>
     * <li>PRB-2: Action Date/Time (TS) <b> </b>
     * <li>PRB-3: Problem ID (CE) <b> </b>
     * <li>PRB-4: Problem Instance ID (EI) <b> </b>
     * <li>PRB-5: Episode of Care ID (EI) <b>optional </b>
     * <li>PRB-6: Problem List Priority (NM) <b>optional </b>
     * <li>PRB-7: Problem Established Date/Time (TS) <b>optional </b>
     * <li>PRB-8: Anticipated Problem Resolution Date/Time (TS) <b>optional </b>
     * <li>PRB-9: Actual Problem Resolution Date/Time (TS) <b>optional </b>
     * <li>PRB-10: Problem Classification (CE) <b>optional </b>
     * <li>PRB-11: Problem Management Discipline (CE) <b>optional repeating</b>
     * <li>PRB-12: Problem Persistence (CE) <b>optional </b>
     * <li>PRB-13: Problem Confirmation Status (CE) <b>optional </b>
     * <li>PRB-14: Problem Life Cycle Status (CE) <b>optional </b>
     * <li>PRB-15: Problem Life Cycle Status Date/Time (TS) <b>optional </b>
     * <li>PRB-16: Problem Date of Onset (TS) <b>optional </b>
     * <li>PRB-17: Problem Onset Text (ST) <b>optional </b>
     * <li>PRB-18: Problem Ranking (CE) <b>optional </b>
     * <li>PRB-19: Certainty of Problem (CE) <b>optional </b>
     * <li>PRB-20: Probability of Problem (0-1) (NM) <b>optional </b>
     * <li>PRB-21: Individual Awareness of Problem (CE) <b>optional </b>
     * <li>PRB-22: Problem Prognosis (CE) <b>optional </b>
     * <li>PRB-23: Individual Awareness of Prognosis (CE) <b>optional </b>
     * <li>PRB-24: Family/Significant Other Awareness of Problem/Prognosis (ST) <b>optional </b>
     * <li>PRB-25: Security/Sensitivity (CE) <b>optional </b>
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
                                  this.add(TS.class, true, 1, 26, new Object[]{ getMessage() }, "Action Date/Time");
                                  this.add(CE.class, true, 1, 80, new Object[]{ getMessage() }, "Problem ID");
                                  this.add(EI.class, true, 1, 60, new Object[]{ getMessage() }, "Problem Instance ID");
                                  this.add(EI.class, false, 1, 60, new Object[]{ getMessage() }, "Episode of Care ID");
                                  this.add(NM.class, false, 1, 60, new Object[]{ getMessage() }, "Problem List Priority");
                                  this.add(TS.class, false, 1, 26, new Object[]{ getMessage() }, "Problem Established Date/Time");
                                  this.add(TS.class, false, 1, 26, new Object[]{ getMessage() }, "Anticipated Problem Resolution Date/Time");
                                  this.add(TS.class, false, 1, 26, new Object[]{ getMessage() }, "Actual Problem Resolution Date/Time");
                                  this.add(CE.class, false, 1, 80, new Object[]{ getMessage() }, "Problem Classification");
                                  this.add(CE.class, false, 0, 80, new Object[]{ getMessage() }, "Problem Management Discipline");
                                  this.add(CE.class, false, 1, 80, new Object[]{ getMessage() }, "Problem Persistence");
                                  this.add(CE.class, false, 1, 80, new Object[]{ getMessage() }, "Problem Confirmation Status");
                                  this.add(CE.class, false, 1, 80, new Object[]{ getMessage() }, "Problem Life Cycle Status");
                                  this.add(TS.class, false, 1, 26, new Object[]{ getMessage() }, "Problem Life Cycle Status Date/Time");
                                  this.add(TS.class, false, 1, 26, new Object[]{ getMessage() }, "Problem Date of Onset");
                                  this.add(ST.class, false, 1, 80, new Object[]{ getMessage() }, "Problem Onset Text");
                                  this.add(CE.class, false, 1, 80, new Object[]{ getMessage() }, "Problem Ranking");
                                  this.add(CE.class, false, 1, 60, new Object[]{ getMessage() }, "Certainty of Problem");
                                  this.add(NM.class, false, 1, 5, new Object[]{ getMessage() }, "Probability of Problem (0-1)");
                                  this.add(CE.class, false, 1, 80, new Object[]{ getMessage() }, "Individual Awareness of Problem");
                                  this.add(CE.class, false, 1, 80, new Object[]{ getMessage() }, "Problem Prognosis");
                                  this.add(CE.class, false, 1, 80, new Object[]{ getMessage() }, "Individual Awareness of Prognosis");
                                  this.add(ST.class, false, 1, 200, new Object[]{ getMessage() }, "Family/Significant Other Awareness of Problem/Prognosis");
                                  this.add(CE.class, false, 1, 80, new Object[]{ getMessage() }, "Security/Sensitivity");
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
    public TS getActionDateTime() { 
		TS retVal = this.getTypedField(2, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PRB-2: "Action Date/Time" - creates it if necessary
     */
    public TS getPrb2_ActionDateTime() { 
		TS retVal = this.getTypedField(2, 0);
		return retVal;
    }



    /**
     * Returns
     * PRB-3: "Problem ID" - creates it if necessary
     */
    public CE getProblemID() { 
		CE retVal = this.getTypedField(3, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PRB-3: "Problem ID" - creates it if necessary
     */
    public CE getPrb3_ProblemID() { 
		CE retVal = this.getTypedField(3, 0);
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
    public TS getProblemEstablishedDateTime() { 
		TS retVal = this.getTypedField(7, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PRB-7: "Problem Established Date/Time" - creates it if necessary
     */
    public TS getPrb7_ProblemEstablishedDateTime() { 
		TS retVal = this.getTypedField(7, 0);
		return retVal;
    }



    /**
     * Returns
     * PRB-8: "Anticipated Problem Resolution Date/Time" - creates it if necessary
     */
    public TS getAnticipatedProblemResolutionDateTime() { 
		TS retVal = this.getTypedField(8, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PRB-8: "Anticipated Problem Resolution Date/Time" - creates it if necessary
     */
    public TS getPrb8_AnticipatedProblemResolutionDateTime() { 
		TS retVal = this.getTypedField(8, 0);
		return retVal;
    }



    /**
     * Returns
     * PRB-9: "Actual Problem Resolution Date/Time" - creates it if necessary
     */
    public TS getActualProblemResolutionDateTime() { 
		TS retVal = this.getTypedField(9, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PRB-9: "Actual Problem Resolution Date/Time" - creates it if necessary
     */
    public TS getPrb9_ActualProblemResolutionDateTime() { 
		TS retVal = this.getTypedField(9, 0);
		return retVal;
    }



    /**
     * Returns
     * PRB-10: "Problem Classification" - creates it if necessary
     */
    public CE getProblemClassification() { 
		CE retVal = this.getTypedField(10, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PRB-10: "Problem Classification" - creates it if necessary
     */
    public CE getPrb10_ProblemClassification() { 
		CE retVal = this.getTypedField(10, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Problem Management Discipline (PRB-11).
     */
    public CE[] getProblemManagementDiscipline() {
    	CE[] retVal = this.getTypedField(11, new CE[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Problem Management Discipline (PRB-11).
     */
    public CE[] getPrb11_ProblemManagementDiscipline() {
    	CE[] retVal = this.getTypedField(11, new CE[0]);
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
    public CE getProblemManagementDiscipline(int rep) { 
		CE retVal = this.getTypedField(11, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * PRB-11: "Problem Management Discipline" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CE getPrb11_ProblemManagementDiscipline(int rep) { 
		CE retVal = this.getTypedField(11, rep);
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
    public CE insertProblemManagementDiscipline(int rep) throws HL7Exception { 
        return (CE) super.insertRepetition(11, rep);
    }


    /**
     * Inserts a repetition of
     * PRB-11: "Problem Management Discipline" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE insertPrb11_ProblemManagementDiscipline(int rep) throws HL7Exception { 
        return (CE) super.insertRepetition(11, rep);
    }


    /**
     * Removes a repetition of
     * PRB-11: "Problem Management Discipline" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE removeProblemManagementDiscipline(int rep) throws HL7Exception { 
        return (CE) super.removeRepetition(11, rep);
    }


    /**
     * Removes a repetition of
     * PRB-11: "Problem Management Discipline" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE removePrb11_ProblemManagementDiscipline(int rep) throws HL7Exception { 
        return (CE) super.removeRepetition(11, rep);
    }




    /**
     * Returns
     * PRB-12: "Problem Persistence" - creates it if necessary
     */
    public CE getProblemPersistence() { 
		CE retVal = this.getTypedField(12, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PRB-12: "Problem Persistence" - creates it if necessary
     */
    public CE getPrb12_ProblemPersistence() { 
		CE retVal = this.getTypedField(12, 0);
		return retVal;
    }



    /**
     * Returns
     * PRB-13: "Problem Confirmation Status" - creates it if necessary
     */
    public CE getProblemConfirmationStatus() { 
		CE retVal = this.getTypedField(13, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PRB-13: "Problem Confirmation Status" - creates it if necessary
     */
    public CE getPrb13_ProblemConfirmationStatus() { 
		CE retVal = this.getTypedField(13, 0);
		return retVal;
    }



    /**
     * Returns
     * PRB-14: "Problem Life Cycle Status" - creates it if necessary
     */
    public CE getProblemLifeCycleStatus() { 
		CE retVal = this.getTypedField(14, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PRB-14: "Problem Life Cycle Status" - creates it if necessary
     */
    public CE getPrb14_ProblemLifeCycleStatus() { 
		CE retVal = this.getTypedField(14, 0);
		return retVal;
    }



    /**
     * Returns
     * PRB-15: "Problem Life Cycle Status Date/Time" - creates it if necessary
     */
    public TS getProblemLifeCycleStatusDateTime() { 
		TS retVal = this.getTypedField(15, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PRB-15: "Problem Life Cycle Status Date/Time" - creates it if necessary
     */
    public TS getPrb15_ProblemLifeCycleStatusDateTime() { 
		TS retVal = this.getTypedField(15, 0);
		return retVal;
    }



    /**
     * Returns
     * PRB-16: "Problem Date of Onset" - creates it if necessary
     */
    public TS getProblemDateOfOnset() { 
		TS retVal = this.getTypedField(16, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PRB-16: "Problem Date of Onset" - creates it if necessary
     */
    public TS getPrb16_ProblemDateOfOnset() { 
		TS retVal = this.getTypedField(16, 0);
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
    public CE getProblemRanking() { 
		CE retVal = this.getTypedField(18, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PRB-18: "Problem Ranking" - creates it if necessary
     */
    public CE getPrb18_ProblemRanking() { 
		CE retVal = this.getTypedField(18, 0);
		return retVal;
    }



    /**
     * Returns
     * PRB-19: "Certainty of Problem" - creates it if necessary
     */
    public CE getCertaintyOfProblem() { 
		CE retVal = this.getTypedField(19, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PRB-19: "Certainty of Problem" - creates it if necessary
     */
    public CE getPrb19_CertaintyOfProblem() { 
		CE retVal = this.getTypedField(19, 0);
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
    public CE getIndividualAwarenessOfProblem() { 
		CE retVal = this.getTypedField(21, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PRB-21: "Individual Awareness of Problem" - creates it if necessary
     */
    public CE getPrb21_IndividualAwarenessOfProblem() { 
		CE retVal = this.getTypedField(21, 0);
		return retVal;
    }



    /**
     * Returns
     * PRB-22: "Problem Prognosis" - creates it if necessary
     */
    public CE getProblemPrognosis() { 
		CE retVal = this.getTypedField(22, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PRB-22: "Problem Prognosis" - creates it if necessary
     */
    public CE getPrb22_ProblemPrognosis() { 
		CE retVal = this.getTypedField(22, 0);
		return retVal;
    }



    /**
     * Returns
     * PRB-23: "Individual Awareness of Prognosis" - creates it if necessary
     */
    public CE getIndividualAwarenessOfPrognosis() { 
		CE retVal = this.getTypedField(23, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PRB-23: "Individual Awareness of Prognosis" - creates it if necessary
     */
    public CE getPrb23_IndividualAwarenessOfPrognosis() { 
		CE retVal = this.getTypedField(23, 0);
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
    public CE getSecuritySensitivity() { 
		CE retVal = this.getTypedField(25, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PRB-25: "Security/Sensitivity" - creates it if necessary
     */
    public CE getPrb25_SecuritySensitivity() { 
		CE retVal = this.getTypedField(25, 0);
		return retVal;
    }





    /** {@inheritDoc} */   
    protected Type createNewTypeWithoutReflection(int field) {
       switch (field) {
          case 0: return new ID(getMessage(), new Integer( 287 ));
          case 1: return new TS(getMessage());
          case 2: return new CE(getMessage());
          case 3: return new EI(getMessage());
          case 4: return new EI(getMessage());
          case 5: return new NM(getMessage());
          case 6: return new TS(getMessage());
          case 7: return new TS(getMessage());
          case 8: return new TS(getMessage());
          case 9: return new CE(getMessage());
          case 10: return new CE(getMessage());
          case 11: return new CE(getMessage());
          case 12: return new CE(getMessage());
          case 13: return new CE(getMessage());
          case 14: return new TS(getMessage());
          case 15: return new TS(getMessage());
          case 16: return new ST(getMessage());
          case 17: return new CE(getMessage());
          case 18: return new CE(getMessage());
          case 19: return new NM(getMessage());
          case 20: return new CE(getMessage());
          case 21: return new CE(getMessage());
          case 22: return new CE(getMessage());
          case 23: return new ST(getMessage());
          case 24: return new CE(getMessage());
          default: return null;
       }
   }


}

