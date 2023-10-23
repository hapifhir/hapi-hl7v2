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


package ca.uhn.hl7v2.model.v231.segment;

// import ca.uhn.hl7v2.model.v231.group.*;
import ca.uhn.hl7v2.model.v231.datatype.*;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.parser.DefaultModelClassFactory;
import ca.uhn.hl7v2.model.AbstractMessage;
import ca.uhn.hl7v2.model.Group;
import ca.uhn.hl7v2.model.Type;
import ca.uhn.hl7v2.model.AbstractSegment;
import ca.uhn.hl7v2.model.Varies;


/**
 *<p>Represents an HL7 GOL message segment (Goal Detail). 
 * This segment has the following fields:</p>
 * <ul>
     * <li>GOL-1: Action Code (ID) <b> </b>
     * <li>GOL-2: Action Date/Time (TS) <b> </b>
     * <li>GOL-3: Goal ID (CE) <b> </b>
     * <li>GOL-4: Goal Instance ID (EI) <b> </b>
     * <li>GOL-5: Episode of Care ID (EI) <b>optional </b>
     * <li>GOL-6: Goal List Priority (NM) <b>optional </b>
     * <li>GOL-7: Goal Established Date/Time (TS) <b>optional </b>
     * <li>GOL-8: Expected Goal Achieve Date/Time (TS) <b>optional </b>
     * <li>GOL-9: Goal Classification (CE) <b>optional </b>
     * <li>GOL-10: Goal Management Discipline (CE) <b>optional </b>
     * <li>GOL-11: Current Goal Review Status (CE) <b>optional </b>
     * <li>GOL-12: Current Goal Review Date/Time (TS) <b>optional </b>
     * <li>GOL-13: Next Goal Review Date/Time (TS) <b>optional </b>
     * <li>GOL-14: Previous Goal Review Date/Time (TS) <b>optional </b>
     * <li>GOL-15: Goal Review Interval (TQ) <b>optional </b>
     * <li>GOL-16: Goal Evaluation (CE) <b>optional </b>
     * <li>GOL-17: Goal Evaluation Comment (ST) <b>optional repeating</b>
     * <li>GOL-18: Goal Life Cycle Status (CE) <b>optional </b>
     * <li>GOL-19: Goal Life Cycle Status Date/Time (TS) <b>optional </b>
     * <li>GOL-20: Goal Target Type (CE) <b>optional repeating</b>
     * <li>GOL-21: Goal Target Name (XPN) <b>optional repeating</b>
 * </ul>
 */
@SuppressWarnings("unused")
public class GOL extends AbstractSegment {

    /** 
     * Creates a new GOL segment
     */
    public GOL(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                              this.add(ID.class, true, 1, 2, new Object[]{ getMessage(), new Integer(287) }, "Action Code");
                                  this.add(TS.class, true, 1, 26, new Object[]{ getMessage() }, "Action Date/Time");
                                  this.add(CE.class, true, 1, 80, new Object[]{ getMessage() }, "Goal ID");
                                  this.add(EI.class, true, 1, 60, new Object[]{ getMessage() }, "Goal Instance ID");
                                  this.add(EI.class, false, 1, 60, new Object[]{ getMessage() }, "Episode of Care ID");
                                  this.add(NM.class, false, 1, 60, new Object[]{ getMessage() }, "Goal List Priority");
                                  this.add(TS.class, false, 1, 26, new Object[]{ getMessage() }, "Goal Established Date/Time");
                                  this.add(TS.class, false, 1, 26, new Object[]{ getMessage() }, "Expected Goal Achieve Date/Time");
                                  this.add(CE.class, false, 1, 80, new Object[]{ getMessage() }, "Goal Classification");
                                  this.add(CE.class, false, 1, 80, new Object[]{ getMessage() }, "Goal Management Discipline");
                                  this.add(CE.class, false, 1, 80, new Object[]{ getMessage() }, "Current Goal Review Status");
                                  this.add(TS.class, false, 1, 26, new Object[]{ getMessage() }, "Current Goal Review Date/Time");
                                  this.add(TS.class, false, 1, 26, new Object[]{ getMessage() }, "Next Goal Review Date/Time");
                                  this.add(TS.class, false, 1, 26, new Object[]{ getMessage() }, "Previous Goal Review Date/Time");
                                  this.add(TQ.class, false, 1, 200, new Object[]{ getMessage() }, "Goal Review Interval");
                                  this.add(CE.class, false, 1, 80, new Object[]{ getMessage() }, "Goal Evaluation");
                                  this.add(ST.class, false, 0, 300, new Object[]{ getMessage() }, "Goal Evaluation Comment");
                                  this.add(CE.class, false, 1, 80, new Object[]{ getMessage() }, "Goal Life Cycle Status");
                                  this.add(TS.class, false, 1, 26, new Object[]{ getMessage() }, "Goal Life Cycle Status Date/Time");
                                  this.add(CE.class, false, 0, 80, new Object[]{ getMessage() }, "Goal Target Type");
                                  this.add(XPN.class, false, 0, 80, new Object[]{ getMessage() }, "Goal Target Name");
       } catch(HL7Exception e) {
          log.error("Unexpected error creating GOL - this is probably a bug in the source code generator.", e);
       }
    }



    /**
     * Returns
     * GOL-1: "Action Code" - creates it if necessary
     */
    public ID getActionCode() { 
		ID retVal = this.getTypedField(1, 0);
		return retVal;
    }
    
    /**
     * Returns
     * GOL-1: "Action Code" - creates it if necessary
     */
    public ID getGol1_ActionCode() { 
		ID retVal = this.getTypedField(1, 0);
		return retVal;
    }



    /**
     * Returns
     * GOL-2: "Action Date/Time" - creates it if necessary
     */
    public TS getActionDateTime() { 
		TS retVal = this.getTypedField(2, 0);
		return retVal;
    }
    
    /**
     * Returns
     * GOL-2: "Action Date/Time" - creates it if necessary
     */
    public TS getGol2_ActionDateTime() { 
		TS retVal = this.getTypedField(2, 0);
		return retVal;
    }



    /**
     * Returns
     * GOL-3: "Goal ID" - creates it if necessary
     */
    public CE getGoalID() { 
		CE retVal = this.getTypedField(3, 0);
		return retVal;
    }
    
    /**
     * Returns
     * GOL-3: "Goal ID" - creates it if necessary
     */
    public CE getGol3_GoalID() { 
		CE retVal = this.getTypedField(3, 0);
		return retVal;
    }



    /**
     * Returns
     * GOL-4: "Goal Instance ID" - creates it if necessary
     */
    public EI getGoalInstanceID() { 
		EI retVal = this.getTypedField(4, 0);
		return retVal;
    }
    
    /**
     * Returns
     * GOL-4: "Goal Instance ID" - creates it if necessary
     */
    public EI getGol4_GoalInstanceID() { 
		EI retVal = this.getTypedField(4, 0);
		return retVal;
    }



    /**
     * Returns
     * GOL-5: "Episode of Care ID" - creates it if necessary
     */
    public EI getEpisodeOfCareID() { 
		EI retVal = this.getTypedField(5, 0);
		return retVal;
    }
    
    /**
     * Returns
     * GOL-5: "Episode of Care ID" - creates it if necessary
     */
    public EI getGol5_EpisodeOfCareID() { 
		EI retVal = this.getTypedField(5, 0);
		return retVal;
    }



    /**
     * Returns
     * GOL-6: "Goal List Priority" - creates it if necessary
     */
    public NM getGoalListPriority() { 
		NM retVal = this.getTypedField(6, 0);
		return retVal;
    }
    
    /**
     * Returns
     * GOL-6: "Goal List Priority" - creates it if necessary
     */
    public NM getGol6_GoalListPriority() { 
		NM retVal = this.getTypedField(6, 0);
		return retVal;
    }



    /**
     * Returns
     * GOL-7: "Goal Established Date/Time" - creates it if necessary
     */
    public TS getGoalEstablishedDateTime() { 
		TS retVal = this.getTypedField(7, 0);
		return retVal;
    }
    
    /**
     * Returns
     * GOL-7: "Goal Established Date/Time" - creates it if necessary
     */
    public TS getGol7_GoalEstablishedDateTime() { 
		TS retVal = this.getTypedField(7, 0);
		return retVal;
    }



    /**
     * Returns
     * GOL-8: "Expected Goal Achieve Date/Time" - creates it if necessary
     */
    public TS getExpectedGoalAchieveDateTime() { 
		TS retVal = this.getTypedField(8, 0);
		return retVal;
    }
    
    /**
     * Returns
     * GOL-8: "Expected Goal Achieve Date/Time" - creates it if necessary
     */
    public TS getGol8_ExpectedGoalAchieveDateTime() { 
		TS retVal = this.getTypedField(8, 0);
		return retVal;
    }



    /**
     * Returns
     * GOL-9: "Goal Classification" - creates it if necessary
     */
    public CE getGoalClassification() { 
		CE retVal = this.getTypedField(9, 0);
		return retVal;
    }
    
    /**
     * Returns
     * GOL-9: "Goal Classification" - creates it if necessary
     */
    public CE getGol9_GoalClassification() { 
		CE retVal = this.getTypedField(9, 0);
		return retVal;
    }



    /**
     * Returns
     * GOL-10: "Goal Management Discipline" - creates it if necessary
     */
    public CE getGoalManagementDiscipline() { 
		CE retVal = this.getTypedField(10, 0);
		return retVal;
    }
    
    /**
     * Returns
     * GOL-10: "Goal Management Discipline" - creates it if necessary
     */
    public CE getGol10_GoalManagementDiscipline() { 
		CE retVal = this.getTypedField(10, 0);
		return retVal;
    }



    /**
     * Returns
     * GOL-11: "Current Goal Review Status" - creates it if necessary
     */
    public CE getCurrentGoalReviewStatus() { 
		CE retVal = this.getTypedField(11, 0);
		return retVal;
    }
    
    /**
     * Returns
     * GOL-11: "Current Goal Review Status" - creates it if necessary
     */
    public CE getGol11_CurrentGoalReviewStatus() { 
		CE retVal = this.getTypedField(11, 0);
		return retVal;
    }



    /**
     * Returns
     * GOL-12: "Current Goal Review Date/Time" - creates it if necessary
     */
    public TS getCurrentGoalReviewDateTime() { 
		TS retVal = this.getTypedField(12, 0);
		return retVal;
    }
    
    /**
     * Returns
     * GOL-12: "Current Goal Review Date/Time" - creates it if necessary
     */
    public TS getGol12_CurrentGoalReviewDateTime() { 
		TS retVal = this.getTypedField(12, 0);
		return retVal;
    }



    /**
     * Returns
     * GOL-13: "Next Goal Review Date/Time" - creates it if necessary
     */
    public TS getNextGoalReviewDateTime() { 
		TS retVal = this.getTypedField(13, 0);
		return retVal;
    }
    
    /**
     * Returns
     * GOL-13: "Next Goal Review Date/Time" - creates it if necessary
     */
    public TS getGol13_NextGoalReviewDateTime() { 
		TS retVal = this.getTypedField(13, 0);
		return retVal;
    }



    /**
     * Returns
     * GOL-14: "Previous Goal Review Date/Time" - creates it if necessary
     */
    public TS getPreviousGoalReviewDateTime() { 
		TS retVal = this.getTypedField(14, 0);
		return retVal;
    }
    
    /**
     * Returns
     * GOL-14: "Previous Goal Review Date/Time" - creates it if necessary
     */
    public TS getGol14_PreviousGoalReviewDateTime() { 
		TS retVal = this.getTypedField(14, 0);
		return retVal;
    }



    /**
     * Returns
     * GOL-15: "Goal Review Interval" - creates it if necessary
     */
    public TQ getGoalReviewInterval() { 
		TQ retVal = this.getTypedField(15, 0);
		return retVal;
    }
    
    /**
     * Returns
     * GOL-15: "Goal Review Interval" - creates it if necessary
     */
    public TQ getGol15_GoalReviewInterval() { 
		TQ retVal = this.getTypedField(15, 0);
		return retVal;
    }



    /**
     * Returns
     * GOL-16: "Goal Evaluation" - creates it if necessary
     */
    public CE getGoalEvaluation() { 
		CE retVal = this.getTypedField(16, 0);
		return retVal;
    }
    
    /**
     * Returns
     * GOL-16: "Goal Evaluation" - creates it if necessary
     */
    public CE getGol16_GoalEvaluation() { 
		CE retVal = this.getTypedField(16, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Goal Evaluation Comment (GOL-17).
     */
    public ST[] getGoalEvaluationComment() {
    	ST[] retVal = this.getTypedField(17, new ST[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Goal Evaluation Comment (GOL-17).
     */
    public ST[] getGol17_GoalEvaluationComment() {
    	ST[] retVal = this.getTypedField(17, new ST[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Goal Evaluation Comment (GOL-17).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getGoalEvaluationCommentReps() {
    	return this.getReps(17);
    }


    /**
     * Returns a specific repetition of
     * GOL-17: "Goal Evaluation Comment" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public ST getGoalEvaluationComment(int rep) { 
		ST retVal = this.getTypedField(17, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * GOL-17: "Goal Evaluation Comment" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public ST getGol17_GoalEvaluationComment(int rep) { 
		ST retVal = this.getTypedField(17, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Goal Evaluation Comment (GOL-17).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getGol17_GoalEvaluationCommentReps() {
    	return this.getReps(17);
    }


    /**
     * Inserts a repetition of
     * GOL-17: "Goal Evaluation Comment" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ST insertGoalEvaluationComment(int rep) throws HL7Exception { 
        return (ST) super.insertRepetition(17, rep);
    }


    /**
     * Inserts a repetition of
     * GOL-17: "Goal Evaluation Comment" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ST insertGol17_GoalEvaluationComment(int rep) throws HL7Exception { 
        return (ST) super.insertRepetition(17, rep);
    }


    /**
     * Removes a repetition of
     * GOL-17: "Goal Evaluation Comment" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ST removeGoalEvaluationComment(int rep) throws HL7Exception { 
        return (ST) super.removeRepetition(17, rep);
    }


    /**
     * Removes a repetition of
     * GOL-17: "Goal Evaluation Comment" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ST removeGol17_GoalEvaluationComment(int rep) throws HL7Exception { 
        return (ST) super.removeRepetition(17, rep);
    }




    /**
     * Returns
     * GOL-18: "Goal Life Cycle Status" - creates it if necessary
     */
    public CE getGoalLifeCycleStatus() { 
		CE retVal = this.getTypedField(18, 0);
		return retVal;
    }
    
    /**
     * Returns
     * GOL-18: "Goal Life Cycle Status" - creates it if necessary
     */
    public CE getGol18_GoalLifeCycleStatus() { 
		CE retVal = this.getTypedField(18, 0);
		return retVal;
    }



    /**
     * Returns
     * GOL-19: "Goal Life Cycle Status Date/Time" - creates it if necessary
     */
    public TS getGoalLifeCycleStatusDateTime() { 
		TS retVal = this.getTypedField(19, 0);
		return retVal;
    }
    
    /**
     * Returns
     * GOL-19: "Goal Life Cycle Status Date/Time" - creates it if necessary
     */
    public TS getGol19_GoalLifeCycleStatusDateTime() { 
		TS retVal = this.getTypedField(19, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Goal Target Type (GOL-20).
     */
    public CE[] getGoalTargetType() {
    	CE[] retVal = this.getTypedField(20, new CE[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Goal Target Type (GOL-20).
     */
    public CE[] getGol20_GoalTargetType() {
    	CE[] retVal = this.getTypedField(20, new CE[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Goal Target Type (GOL-20).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getGoalTargetTypeReps() {
    	return this.getReps(20);
    }


    /**
     * Returns a specific repetition of
     * GOL-20: "Goal Target Type" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CE getGoalTargetType(int rep) { 
		CE retVal = this.getTypedField(20, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * GOL-20: "Goal Target Type" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CE getGol20_GoalTargetType(int rep) { 
		CE retVal = this.getTypedField(20, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Goal Target Type (GOL-20).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getGol20_GoalTargetTypeReps() {
    	return this.getReps(20);
    }


    /**
     * Inserts a repetition of
     * GOL-20: "Goal Target Type" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE insertGoalTargetType(int rep) throws HL7Exception { 
        return (CE) super.insertRepetition(20, rep);
    }


    /**
     * Inserts a repetition of
     * GOL-20: "Goal Target Type" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE insertGol20_GoalTargetType(int rep) throws HL7Exception { 
        return (CE) super.insertRepetition(20, rep);
    }


    /**
     * Removes a repetition of
     * GOL-20: "Goal Target Type" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE removeGoalTargetType(int rep) throws HL7Exception { 
        return (CE) super.removeRepetition(20, rep);
    }


    /**
     * Removes a repetition of
     * GOL-20: "Goal Target Type" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE removeGol20_GoalTargetType(int rep) throws HL7Exception { 
        return (CE) super.removeRepetition(20, rep);
    }



    /**
     * Returns all repetitions of Goal Target Name (GOL-21).
     */
    public XPN[] getGoalTargetName() {
    	XPN[] retVal = this.getTypedField(21, new XPN[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Goal Target Name (GOL-21).
     */
    public XPN[] getGol21_GoalTargetName() {
    	XPN[] retVal = this.getTypedField(21, new XPN[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Goal Target Name (GOL-21).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getGoalTargetNameReps() {
    	return this.getReps(21);
    }


    /**
     * Returns a specific repetition of
     * GOL-21: "Goal Target Name" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XPN getGoalTargetName(int rep) { 
		XPN retVal = this.getTypedField(21, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * GOL-21: "Goal Target Name" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XPN getGol21_GoalTargetName(int rep) { 
		XPN retVal = this.getTypedField(21, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Goal Target Name (GOL-21).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getGol21_GoalTargetNameReps() {
    	return this.getReps(21);
    }


    /**
     * Inserts a repetition of
     * GOL-21: "Goal Target Name" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XPN insertGoalTargetName(int rep) throws HL7Exception { 
        return (XPN) super.insertRepetition(21, rep);
    }


    /**
     * Inserts a repetition of
     * GOL-21: "Goal Target Name" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XPN insertGol21_GoalTargetName(int rep) throws HL7Exception { 
        return (XPN) super.insertRepetition(21, rep);
    }


    /**
     * Removes a repetition of
     * GOL-21: "Goal Target Name" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XPN removeGoalTargetName(int rep) throws HL7Exception { 
        return (XPN) super.removeRepetition(21, rep);
    }


    /**
     * Removes a repetition of
     * GOL-21: "Goal Target Name" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XPN removeGol21_GoalTargetName(int rep) throws HL7Exception { 
        return (XPN) super.removeRepetition(21, rep);
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
          case 8: return new CE(getMessage());
          case 9: return new CE(getMessage());
          case 10: return new CE(getMessage());
          case 11: return new TS(getMessage());
          case 12: return new TS(getMessage());
          case 13: return new TS(getMessage());
          case 14: return new TQ(getMessage());
          case 15: return new CE(getMessage());
          case 16: return new ST(getMessage());
          case 17: return new CE(getMessage());
          case 18: return new TS(getMessage());
          case 19: return new CE(getMessage());
          case 20: return new XPN(getMessage());
          default: return null;
       }
   }


}

