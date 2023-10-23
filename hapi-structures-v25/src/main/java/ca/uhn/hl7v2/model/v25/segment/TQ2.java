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
 *<p>Represents an HL7 TQ2 message segment (Timing/Quantity Relationship). 
 * This segment has the following fields:</p>
 * <ul>
     * <li>TQ2-1: Set ID - TQ2 (SI) <b>optional </b>
     * <li>TQ2-2: Sequence/Results Flag (ID) <b>optional </b>
     * <li>TQ2-3: Related Placer Number (EI) <b>optional repeating</b>
     * <li>TQ2-4: Related Filler Number (EI) <b>optional repeating</b>
     * <li>TQ2-5: Related Placer Group Number (EI) <b>optional repeating</b>
     * <li>TQ2-6: Sequence Condition Code (ID) <b>optional </b>
     * <li>TQ2-7: Cyclic Entry/Exit Indicator (ID) <b>optional </b>
     * <li>TQ2-8: Sequence Condition Time Interval (CQ) <b>optional </b>
     * <li>TQ2-9: Cyclic Group Maximum Number of Repeats (NM) <b>optional </b>
     * <li>TQ2-10: Special Service Request Relationship (ID) <b>optional </b>
 * </ul>
 */
@SuppressWarnings("unused")
public class TQ2 extends AbstractSegment {

    /** 
     * Creates a new TQ2 segment
     */
    public TQ2(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(SI.class, false, 1, 4, new Object[]{ getMessage() }, "Set ID - TQ2");
                                              this.add(ID.class, false, 1, 1, new Object[]{ getMessage(), new Integer(503) }, "Sequence/Results Flag");
                                  this.add(EI.class, false, 0, 22, new Object[]{ getMessage() }, "Related Placer Number");
                                  this.add(EI.class, false, 0, 22, new Object[]{ getMessage() }, "Related Filler Number");
                                  this.add(EI.class, false, 0, 22, new Object[]{ getMessage() }, "Related Placer Group Number");
                                              this.add(ID.class, false, 1, 2, new Object[]{ getMessage(), new Integer(504) }, "Sequence Condition Code");
                                              this.add(ID.class, false, 1, 1, new Object[]{ getMessage(), new Integer(505) }, "Cyclic Entry/Exit Indicator");
                                  this.add(CQ.class, false, 1, 20, new Object[]{ getMessage() }, "Sequence Condition Time Interval");
                                  this.add(NM.class, false, 1, 10, new Object[]{ getMessage() }, "Cyclic Group Maximum Number of Repeats");
                                              this.add(ID.class, false, 1, 1, new Object[]{ getMessage(), new Integer(506) }, "Special Service Request Relationship");
       } catch(HL7Exception e) {
          log.error("Unexpected error creating TQ2 - this is probably a bug in the source code generator.", e);
       }
    }



    /**
     * Returns
     * TQ2-1: "Set ID - TQ2" - creates it if necessary
     */
    public SI getSetIDTQ2() { 
		SI retVal = this.getTypedField(1, 0);
		return retVal;
    }
    
    /**
     * Returns
     * TQ2-1: "Set ID - TQ2" - creates it if necessary
     */
    public SI getTq21_SetIDTQ2() { 
		SI retVal = this.getTypedField(1, 0);
		return retVal;
    }



    /**
     * Returns
     * TQ2-2: "Sequence/Results Flag" - creates it if necessary
     */
    public ID getSequenceResultsFlag() { 
		ID retVal = this.getTypedField(2, 0);
		return retVal;
    }
    
    /**
     * Returns
     * TQ2-2: "Sequence/Results Flag" - creates it if necessary
     */
    public ID getTq22_SequenceResultsFlag() { 
		ID retVal = this.getTypedField(2, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Related Placer Number (TQ2-3).
     */
    public EI[] getRelatedPlacerNumber() {
    	EI[] retVal = this.getTypedField(3, new EI[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Related Placer Number (TQ2-3).
     */
    public EI[] getTq23_RelatedPlacerNumber() {
    	EI[] retVal = this.getTypedField(3, new EI[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Related Placer Number (TQ2-3).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getRelatedPlacerNumberReps() {
    	return this.getReps(3);
    }


    /**
     * Returns a specific repetition of
     * TQ2-3: "Related Placer Number" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public EI getRelatedPlacerNumber(int rep) { 
		EI retVal = this.getTypedField(3, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * TQ2-3: "Related Placer Number" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public EI getTq23_RelatedPlacerNumber(int rep) { 
		EI retVal = this.getTypedField(3, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Related Placer Number (TQ2-3).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getTq23_RelatedPlacerNumberReps() {
    	return this.getReps(3);
    }


    /**
     * Inserts a repetition of
     * TQ2-3: "Related Placer Number" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public EI insertRelatedPlacerNumber(int rep) throws HL7Exception { 
        return (EI) super.insertRepetition(3, rep);
    }


    /**
     * Inserts a repetition of
     * TQ2-3: "Related Placer Number" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public EI insertTq23_RelatedPlacerNumber(int rep) throws HL7Exception { 
        return (EI) super.insertRepetition(3, rep);
    }


    /**
     * Removes a repetition of
     * TQ2-3: "Related Placer Number" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public EI removeRelatedPlacerNumber(int rep) throws HL7Exception { 
        return (EI) super.removeRepetition(3, rep);
    }


    /**
     * Removes a repetition of
     * TQ2-3: "Related Placer Number" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public EI removeTq23_RelatedPlacerNumber(int rep) throws HL7Exception { 
        return (EI) super.removeRepetition(3, rep);
    }



    /**
     * Returns all repetitions of Related Filler Number (TQ2-4).
     */
    public EI[] getRelatedFillerNumber() {
    	EI[] retVal = this.getTypedField(4, new EI[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Related Filler Number (TQ2-4).
     */
    public EI[] getTq24_RelatedFillerNumber() {
    	EI[] retVal = this.getTypedField(4, new EI[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Related Filler Number (TQ2-4).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getRelatedFillerNumberReps() {
    	return this.getReps(4);
    }


    /**
     * Returns a specific repetition of
     * TQ2-4: "Related Filler Number" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public EI getRelatedFillerNumber(int rep) { 
		EI retVal = this.getTypedField(4, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * TQ2-4: "Related Filler Number" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public EI getTq24_RelatedFillerNumber(int rep) { 
		EI retVal = this.getTypedField(4, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Related Filler Number (TQ2-4).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getTq24_RelatedFillerNumberReps() {
    	return this.getReps(4);
    }


    /**
     * Inserts a repetition of
     * TQ2-4: "Related Filler Number" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public EI insertRelatedFillerNumber(int rep) throws HL7Exception { 
        return (EI) super.insertRepetition(4, rep);
    }


    /**
     * Inserts a repetition of
     * TQ2-4: "Related Filler Number" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public EI insertTq24_RelatedFillerNumber(int rep) throws HL7Exception { 
        return (EI) super.insertRepetition(4, rep);
    }


    /**
     * Removes a repetition of
     * TQ2-4: "Related Filler Number" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public EI removeRelatedFillerNumber(int rep) throws HL7Exception { 
        return (EI) super.removeRepetition(4, rep);
    }


    /**
     * Removes a repetition of
     * TQ2-4: "Related Filler Number" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public EI removeTq24_RelatedFillerNumber(int rep) throws HL7Exception { 
        return (EI) super.removeRepetition(4, rep);
    }



    /**
     * Returns all repetitions of Related Placer Group Number (TQ2-5).
     */
    public EI[] getRelatedPlacerGroupNumber() {
    	EI[] retVal = this.getTypedField(5, new EI[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Related Placer Group Number (TQ2-5).
     */
    public EI[] getTq25_RelatedPlacerGroupNumber() {
    	EI[] retVal = this.getTypedField(5, new EI[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Related Placer Group Number (TQ2-5).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getRelatedPlacerGroupNumberReps() {
    	return this.getReps(5);
    }


    /**
     * Returns a specific repetition of
     * TQ2-5: "Related Placer Group Number" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public EI getRelatedPlacerGroupNumber(int rep) { 
		EI retVal = this.getTypedField(5, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * TQ2-5: "Related Placer Group Number" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public EI getTq25_RelatedPlacerGroupNumber(int rep) { 
		EI retVal = this.getTypedField(5, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Related Placer Group Number (TQ2-5).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getTq25_RelatedPlacerGroupNumberReps() {
    	return this.getReps(5);
    }


    /**
     * Inserts a repetition of
     * TQ2-5: "Related Placer Group Number" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public EI insertRelatedPlacerGroupNumber(int rep) throws HL7Exception { 
        return (EI) super.insertRepetition(5, rep);
    }


    /**
     * Inserts a repetition of
     * TQ2-5: "Related Placer Group Number" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public EI insertTq25_RelatedPlacerGroupNumber(int rep) throws HL7Exception { 
        return (EI) super.insertRepetition(5, rep);
    }


    /**
     * Removes a repetition of
     * TQ2-5: "Related Placer Group Number" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public EI removeRelatedPlacerGroupNumber(int rep) throws HL7Exception { 
        return (EI) super.removeRepetition(5, rep);
    }


    /**
     * Removes a repetition of
     * TQ2-5: "Related Placer Group Number" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public EI removeTq25_RelatedPlacerGroupNumber(int rep) throws HL7Exception { 
        return (EI) super.removeRepetition(5, rep);
    }




    /**
     * Returns
     * TQ2-6: "Sequence Condition Code" - creates it if necessary
     */
    public ID getSequenceConditionCode() { 
		ID retVal = this.getTypedField(6, 0);
		return retVal;
    }
    
    /**
     * Returns
     * TQ2-6: "Sequence Condition Code" - creates it if necessary
     */
    public ID getTq26_SequenceConditionCode() { 
		ID retVal = this.getTypedField(6, 0);
		return retVal;
    }



    /**
     * Returns
     * TQ2-7: "Cyclic Entry/Exit Indicator" - creates it if necessary
     */
    public ID getCyclicEntryExitIndicator() { 
		ID retVal = this.getTypedField(7, 0);
		return retVal;
    }
    
    /**
     * Returns
     * TQ2-7: "Cyclic Entry/Exit Indicator" - creates it if necessary
     */
    public ID getTq27_CyclicEntryExitIndicator() { 
		ID retVal = this.getTypedField(7, 0);
		return retVal;
    }



    /**
     * Returns
     * TQ2-8: "Sequence Condition Time Interval" - creates it if necessary
     */
    public CQ getSequenceConditionTimeInterval() { 
		CQ retVal = this.getTypedField(8, 0);
		return retVal;
    }
    
    /**
     * Returns
     * TQ2-8: "Sequence Condition Time Interval" - creates it if necessary
     */
    public CQ getTq28_SequenceConditionTimeInterval() { 
		CQ retVal = this.getTypedField(8, 0);
		return retVal;
    }



    /**
     * Returns
     * TQ2-9: "Cyclic Group Maximum Number of Repeats" - creates it if necessary
     */
    public NM getCyclicGroupMaximumNumberOfRepeats() { 
		NM retVal = this.getTypedField(9, 0);
		return retVal;
    }
    
    /**
     * Returns
     * TQ2-9: "Cyclic Group Maximum Number of Repeats" - creates it if necessary
     */
    public NM getTq29_CyclicGroupMaximumNumberOfRepeats() { 
		NM retVal = this.getTypedField(9, 0);
		return retVal;
    }



    /**
     * Returns
     * TQ2-10: "Special Service Request Relationship" - creates it if necessary
     */
    public ID getSpecialServiceRequestRelationship() { 
		ID retVal = this.getTypedField(10, 0);
		return retVal;
    }
    
    /**
     * Returns
     * TQ2-10: "Special Service Request Relationship" - creates it if necessary
     */
    public ID getTq210_SpecialServiceRequestRelationship() { 
		ID retVal = this.getTypedField(10, 0);
		return retVal;
    }





    /** {@inheritDoc} */   
    protected Type createNewTypeWithoutReflection(int field) {
       switch (field) {
          case 0: return new SI(getMessage());
          case 1: return new ID(getMessage(), new Integer( 503 ));
          case 2: return new EI(getMessage());
          case 3: return new EI(getMessage());
          case 4: return new EI(getMessage());
          case 5: return new ID(getMessage(), new Integer( 504 ));
          case 6: return new ID(getMessage(), new Integer( 505 ));
          case 7: return new CQ(getMessage());
          case 8: return new NM(getMessage());
          case 9: return new ID(getMessage(), new Integer( 506 ));
          default: return null;
       }
   }


}

