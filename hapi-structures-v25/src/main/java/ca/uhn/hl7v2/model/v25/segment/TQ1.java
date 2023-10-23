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


package ca.uhn.hl7v2.model.v25.segment;

// import ca.uhn.hl7v2.model.v25.group.*;
import ca.uhn.hl7v2.model.v25.datatype.*;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.parser.DefaultModelClassFactory;
import ca.uhn.hl7v2.model.AbstractMessage;
import ca.uhn.hl7v2.model.Group;
import ca.uhn.hl7v2.model.Type;
import ca.uhn.hl7v2.model.AbstractSegment;
import ca.uhn.hl7v2.model.Varies;


/**
 *<p>Represents an HL7 TQ1 message segment (Timing/Quantity). 
 * This segment has the following fields:</p>
 * <ul>
     * <li>TQ1-1: Set ID - TQ1 (SI) <b>optional </b>
     * <li>TQ1-2: Quantity (CQ) <b>optional </b>
     * <li>TQ1-3: Repeat Pattern (RPT) <b>optional repeating</b>
     * <li>TQ1-4: Explicit Time (TM) <b>optional repeating</b>
     * <li>TQ1-5: Relative Time and Units (CQ) <b>optional repeating</b>
     * <li>TQ1-6: Service Duration (CQ) <b>optional </b>
     * <li>TQ1-7: Start date/time (TS) <b>optional </b>
     * <li>TQ1-8: End date/time (TS) <b>optional </b>
     * <li>TQ1-9: Priority (CWE) <b>optional repeating</b>
     * <li>TQ1-10: Condition text (TX) <b>optional </b>
     * <li>TQ1-11: Text instruction (TX) <b>optional </b>
     * <li>TQ1-12: Conjunction (ID) <b>optional </b>
     * <li>TQ1-13: Occurrence duration (CQ) <b>optional </b>
     * <li>TQ1-14: Total occurrence's (NM) <b>optional </b>
 * </ul>
 */
@SuppressWarnings("unused")
public class TQ1 extends AbstractSegment {

    /** 
     * Creates a new TQ1 segment
     */
    public TQ1(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(SI.class, false, 1, 4, new Object[]{ getMessage() }, "Set ID - TQ1");
                                  this.add(CQ.class, false, 1, 20, new Object[]{ getMessage() }, "Quantity");
                                  this.add(RPT.class, false, 0, 540, new Object[]{ getMessage() }, "Repeat Pattern");
                                  this.add(TM.class, false, 0, 20, new Object[]{ getMessage() }, "Explicit Time");
                                  this.add(CQ.class, false, 0, 20, new Object[]{ getMessage() }, "Relative Time and Units");
                                  this.add(CQ.class, false, 1, 20, new Object[]{ getMessage() }, "Service Duration");
                                  this.add(TS.class, false, 1, 26, new Object[]{ getMessage() }, "Start date/time");
                                  this.add(TS.class, false, 1, 26, new Object[]{ getMessage() }, "End date/time");
                                  this.add(CWE.class, false, 0, 250, new Object[]{ getMessage() }, "Priority");
                                  this.add(TX.class, false, 1, 250, new Object[]{ getMessage() }, "Condition text");
                                  this.add(TX.class, false, 1, 250, new Object[]{ getMessage() }, "Text instruction");
                                              this.add(ID.class, false, 1, 10, new Object[]{ getMessage(), new Integer(427) }, "Conjunction");
                                  this.add(CQ.class, false, 1, 20, new Object[]{ getMessage() }, "Occurrence duration");
                                  this.add(NM.class, false, 1, 10, new Object[]{ getMessage() }, "Total occurrence's");
       } catch(HL7Exception e) {
          log.error("Unexpected error creating TQ1 - this is probably a bug in the source code generator.", e);
       }
    }



    /**
     * Returns
     * TQ1-1: "Set ID - TQ1" - creates it if necessary
     */
    public SI getSetIDTQ1() { 
		SI retVal = this.getTypedField(1, 0);
		return retVal;
    }
    
    /**
     * Returns
     * TQ1-1: "Set ID - TQ1" - creates it if necessary
     */
    public SI getTq11_SetIDTQ1() { 
		SI retVal = this.getTypedField(1, 0);
		return retVal;
    }



    /**
     * Returns
     * TQ1-2: "Quantity" - creates it if necessary
     */
    public CQ getQuantity() { 
		CQ retVal = this.getTypedField(2, 0);
		return retVal;
    }
    
    /**
     * Returns
     * TQ1-2: "Quantity" - creates it if necessary
     */
    public CQ getTq12_Quantity() { 
		CQ retVal = this.getTypedField(2, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Repeat Pattern (TQ1-3).
     */
    public RPT[] getRepeatPattern() {
    	RPT[] retVal = this.getTypedField(3, new RPT[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Repeat Pattern (TQ1-3).
     */
    public RPT[] getTq13_RepeatPattern() {
    	RPT[] retVal = this.getTypedField(3, new RPT[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Repeat Pattern (TQ1-3).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getRepeatPatternReps() {
    	return this.getReps(3);
    }


    /**
     * Returns a specific repetition of
     * TQ1-3: "Repeat Pattern" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public RPT getRepeatPattern(int rep) { 
		RPT retVal = this.getTypedField(3, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * TQ1-3: "Repeat Pattern" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public RPT getTq13_RepeatPattern(int rep) { 
		RPT retVal = this.getTypedField(3, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Repeat Pattern (TQ1-3).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getTq13_RepeatPatternReps() {
    	return this.getReps(3);
    }


    /**
     * Inserts a repetition of
     * TQ1-3: "Repeat Pattern" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public RPT insertRepeatPattern(int rep) throws HL7Exception { 
        return (RPT) super.insertRepetition(3, rep);
    }


    /**
     * Inserts a repetition of
     * TQ1-3: "Repeat Pattern" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public RPT insertTq13_RepeatPattern(int rep) throws HL7Exception { 
        return (RPT) super.insertRepetition(3, rep);
    }


    /**
     * Removes a repetition of
     * TQ1-3: "Repeat Pattern" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public RPT removeRepeatPattern(int rep) throws HL7Exception { 
        return (RPT) super.removeRepetition(3, rep);
    }


    /**
     * Removes a repetition of
     * TQ1-3: "Repeat Pattern" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public RPT removeTq13_RepeatPattern(int rep) throws HL7Exception { 
        return (RPT) super.removeRepetition(3, rep);
    }



    /**
     * Returns all repetitions of Explicit Time (TQ1-4).
     */
    public TM[] getExplicitTime() {
    	TM[] retVal = this.getTypedField(4, new TM[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Explicit Time (TQ1-4).
     */
    public TM[] getTq14_ExplicitTime() {
    	TM[] retVal = this.getTypedField(4, new TM[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Explicit Time (TQ1-4).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getExplicitTimeReps() {
    	return this.getReps(4);
    }


    /**
     * Returns a specific repetition of
     * TQ1-4: "Explicit Time" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public TM getExplicitTime(int rep) { 
		TM retVal = this.getTypedField(4, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * TQ1-4: "Explicit Time" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public TM getTq14_ExplicitTime(int rep) { 
		TM retVal = this.getTypedField(4, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Explicit Time (TQ1-4).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getTq14_ExplicitTimeReps() {
    	return this.getReps(4);
    }


    /**
     * Inserts a repetition of
     * TQ1-4: "Explicit Time" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public TM insertExplicitTime(int rep) throws HL7Exception { 
        return (TM) super.insertRepetition(4, rep);
    }


    /**
     * Inserts a repetition of
     * TQ1-4: "Explicit Time" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public TM insertTq14_ExplicitTime(int rep) throws HL7Exception { 
        return (TM) super.insertRepetition(4, rep);
    }


    /**
     * Removes a repetition of
     * TQ1-4: "Explicit Time" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public TM removeExplicitTime(int rep) throws HL7Exception { 
        return (TM) super.removeRepetition(4, rep);
    }


    /**
     * Removes a repetition of
     * TQ1-4: "Explicit Time" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public TM removeTq14_ExplicitTime(int rep) throws HL7Exception { 
        return (TM) super.removeRepetition(4, rep);
    }



    /**
     * Returns all repetitions of Relative Time and Units (TQ1-5).
     */
    public CQ[] getRelativeTimeAndUnits() {
    	CQ[] retVal = this.getTypedField(5, new CQ[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Relative Time and Units (TQ1-5).
     */
    public CQ[] getTq15_RelativeTimeAndUnits() {
    	CQ[] retVal = this.getTypedField(5, new CQ[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Relative Time and Units (TQ1-5).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getRelativeTimeAndUnitsReps() {
    	return this.getReps(5);
    }


    /**
     * Returns a specific repetition of
     * TQ1-5: "Relative Time and Units" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CQ getRelativeTimeAndUnits(int rep) { 
		CQ retVal = this.getTypedField(5, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * TQ1-5: "Relative Time and Units" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CQ getTq15_RelativeTimeAndUnits(int rep) { 
		CQ retVal = this.getTypedField(5, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Relative Time and Units (TQ1-5).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getTq15_RelativeTimeAndUnitsReps() {
    	return this.getReps(5);
    }


    /**
     * Inserts a repetition of
     * TQ1-5: "Relative Time and Units" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CQ insertRelativeTimeAndUnits(int rep) throws HL7Exception { 
        return (CQ) super.insertRepetition(5, rep);
    }


    /**
     * Inserts a repetition of
     * TQ1-5: "Relative Time and Units" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CQ insertTq15_RelativeTimeAndUnits(int rep) throws HL7Exception { 
        return (CQ) super.insertRepetition(5, rep);
    }


    /**
     * Removes a repetition of
     * TQ1-5: "Relative Time and Units" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CQ removeRelativeTimeAndUnits(int rep) throws HL7Exception { 
        return (CQ) super.removeRepetition(5, rep);
    }


    /**
     * Removes a repetition of
     * TQ1-5: "Relative Time and Units" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CQ removeTq15_RelativeTimeAndUnits(int rep) throws HL7Exception { 
        return (CQ) super.removeRepetition(5, rep);
    }




    /**
     * Returns
     * TQ1-6: "Service Duration" - creates it if necessary
     */
    public CQ getServiceDuration() { 
		CQ retVal = this.getTypedField(6, 0);
		return retVal;
    }
    
    /**
     * Returns
     * TQ1-6: "Service Duration" - creates it if necessary
     */
    public CQ getTq16_ServiceDuration() { 
		CQ retVal = this.getTypedField(6, 0);
		return retVal;
    }



    /**
     * Returns
     * TQ1-7: "Start date/time" - creates it if necessary
     */
    public TS getStartDateTime() { 
		TS retVal = this.getTypedField(7, 0);
		return retVal;
    }
    
    /**
     * Returns
     * TQ1-7: "Start date/time" - creates it if necessary
     */
    public TS getTq17_StartDateTime() { 
		TS retVal = this.getTypedField(7, 0);
		return retVal;
    }



    /**
     * Returns
     * TQ1-8: "End date/time" - creates it if necessary
     */
    public TS getEndDateTime() { 
		TS retVal = this.getTypedField(8, 0);
		return retVal;
    }
    
    /**
     * Returns
     * TQ1-8: "End date/time" - creates it if necessary
     */
    public TS getTq18_EndDateTime() { 
		TS retVal = this.getTypedField(8, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Priority (TQ1-9).
     */
    public CWE[] getPriority() {
    	CWE[] retVal = this.getTypedField(9, new CWE[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Priority (TQ1-9).
     */
    public CWE[] getTq19_Priority() {
    	CWE[] retVal = this.getTypedField(9, new CWE[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Priority (TQ1-9).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getPriorityReps() {
    	return this.getReps(9);
    }


    /**
     * Returns a specific repetition of
     * TQ1-9: "Priority" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CWE getPriority(int rep) { 
		CWE retVal = this.getTypedField(9, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * TQ1-9: "Priority" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CWE getTq19_Priority(int rep) { 
		CWE retVal = this.getTypedField(9, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Priority (TQ1-9).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getTq19_PriorityReps() {
    	return this.getReps(9);
    }


    /**
     * Inserts a repetition of
     * TQ1-9: "Priority" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE insertPriority(int rep) throws HL7Exception { 
        return (CWE) super.insertRepetition(9, rep);
    }


    /**
     * Inserts a repetition of
     * TQ1-9: "Priority" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE insertTq19_Priority(int rep) throws HL7Exception { 
        return (CWE) super.insertRepetition(9, rep);
    }


    /**
     * Removes a repetition of
     * TQ1-9: "Priority" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE removePriority(int rep) throws HL7Exception { 
        return (CWE) super.removeRepetition(9, rep);
    }


    /**
     * Removes a repetition of
     * TQ1-9: "Priority" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE removeTq19_Priority(int rep) throws HL7Exception { 
        return (CWE) super.removeRepetition(9, rep);
    }




    /**
     * Returns
     * TQ1-10: "Condition text" - creates it if necessary
     */
    public TX getConditionText() { 
		TX retVal = this.getTypedField(10, 0);
		return retVal;
    }
    
    /**
     * Returns
     * TQ1-10: "Condition text" - creates it if necessary
     */
    public TX getTq110_ConditionText() { 
		TX retVal = this.getTypedField(10, 0);
		return retVal;
    }



    /**
     * Returns
     * TQ1-11: "Text instruction" - creates it if necessary
     */
    public TX getTextInstruction() { 
		TX retVal = this.getTypedField(11, 0);
		return retVal;
    }
    
    /**
     * Returns
     * TQ1-11: "Text instruction" - creates it if necessary
     */
    public TX getTq111_TextInstruction() { 
		TX retVal = this.getTypedField(11, 0);
		return retVal;
    }



    /**
     * Returns
     * TQ1-12: "Conjunction" - creates it if necessary
     */
    public ID getConjunction() { 
		ID retVal = this.getTypedField(12, 0);
		return retVal;
    }
    
    /**
     * Returns
     * TQ1-12: "Conjunction" - creates it if necessary
     */
    public ID getTq112_Conjunction() { 
		ID retVal = this.getTypedField(12, 0);
		return retVal;
    }



    /**
     * Returns
     * TQ1-13: "Occurrence duration" - creates it if necessary
     */
    public CQ getOccurrenceDuration() { 
		CQ retVal = this.getTypedField(13, 0);
		return retVal;
    }
    
    /**
     * Returns
     * TQ1-13: "Occurrence duration" - creates it if necessary
     */
    public CQ getTq113_OccurrenceDuration() { 
		CQ retVal = this.getTypedField(13, 0);
		return retVal;
    }



    /**
     * Returns
     * TQ1-14: "Total occurrence's" - creates it if necessary
     */
    public NM getTotalOccurrenceS() { 
		NM retVal = this.getTypedField(14, 0);
		return retVal;
    }
    
    /**
     * Returns
     * TQ1-14: "Total occurrence's" - creates it if necessary
     */
    public NM getTq114_TotalOccurrenceS() { 
		NM retVal = this.getTypedField(14, 0);
		return retVal;
    }





    /** {@inheritDoc} */   
    protected Type createNewTypeWithoutReflection(int field) {
       switch (field) {
          case 0: return new SI(getMessage());
          case 1: return new CQ(getMessage());
          case 2: return new RPT(getMessage());
          case 3: return new TM(getMessage());
          case 4: return new CQ(getMessage());
          case 5: return new CQ(getMessage());
          case 6: return new TS(getMessage());
          case 7: return new TS(getMessage());
          case 8: return new CWE(getMessage());
          case 9: return new TX(getMessage());
          case 10: return new TX(getMessage());
          case 11: return new ID(getMessage(), new Integer( 427 ));
          case 12: return new CQ(getMessage());
          case 13: return new NM(getMessage());
          default: return null;
       }
   }


}

