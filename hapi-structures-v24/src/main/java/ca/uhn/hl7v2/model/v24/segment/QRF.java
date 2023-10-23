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


package ca.uhn.hl7v2.model.v24.segment;

// import ca.uhn.hl7v2.model.v24.group.*;
import ca.uhn.hl7v2.model.v24.datatype.*;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.parser.DefaultModelClassFactory;
import ca.uhn.hl7v2.model.AbstractMessage;
import ca.uhn.hl7v2.model.Group;
import ca.uhn.hl7v2.model.Type;
import ca.uhn.hl7v2.model.AbstractSegment;
import ca.uhn.hl7v2.model.Varies;


/**
 *<p>Represents an HL7 QRF message segment (Original Style Query Filter). 
 * This segment has the following fields:</p>
 * <ul>
     * <li>QRF-1: Where Subject Filter (ST) <b> repeating</b>
     * <li>QRF-2: When Data Start Date/Time (TS) <b>optional </b>
     * <li>QRF-3: When Data End Date/Time (TS) <b>optional </b>
     * <li>QRF-4: What User Qualifier (ST) <b>optional repeating</b>
     * <li>QRF-5: Other QRY Subject Filter (ST) <b>optional repeating</b>
     * <li>QRF-6: Which Date/Time Qualifier (ID) <b>optional repeating</b>
     * <li>QRF-7: Which Date/Time Status Qualifier (ID) <b>optional repeating</b>
     * <li>QRF-8: Date/Time Selection Qualifier (ID) <b>optional repeating</b>
     * <li>QRF-9: When Quantity/Timing Qualifier (TQ) <b>optional </b>
     * <li>QRF-10: Search Confidence Threshold (NM) <b>optional </b>
 * </ul>
 */
@SuppressWarnings("unused")
public class QRF extends AbstractSegment {

    /** 
     * Creates a new QRF segment
     */
    public QRF(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(ST.class, true, 0, 20, new Object[]{ getMessage() }, "Where Subject Filter");
                                  this.add(TS.class, false, 1, 26, new Object[]{ getMessage() }, "When Data Start Date/Time");
                                  this.add(TS.class, false, 1, 26, new Object[]{ getMessage() }, "When Data End Date/Time");
                                  this.add(ST.class, false, 0, 60, new Object[]{ getMessage() }, "What User Qualifier");
                                  this.add(ST.class, false, 0, 60, new Object[]{ getMessage() }, "Other QRY Subject Filter");
                                              this.add(ID.class, false, 0, 12, new Object[]{ getMessage(), new Integer(156) }, "Which Date/Time Qualifier");
                                              this.add(ID.class, false, 0, 12, new Object[]{ getMessage(), new Integer(157) }, "Which Date/Time Status Qualifier");
                                              this.add(ID.class, false, 0, 12, new Object[]{ getMessage(), new Integer(158) }, "Date/Time Selection Qualifier");
                                  this.add(TQ.class, false, 1, 60, new Object[]{ getMessage() }, "When Quantity/Timing Qualifier");
                                  this.add(NM.class, false, 1, 10, new Object[]{ getMessage() }, "Search Confidence Threshold");
       } catch(HL7Exception e) {
          log.error("Unexpected error creating QRF - this is probably a bug in the source code generator.", e);
       }
    }


    /**
     * Returns all repetitions of Where Subject Filter (QRF-1).
     */
    public ST[] getWhereSubjectFilter() {
    	ST[] retVal = this.getTypedField(1, new ST[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Where Subject Filter (QRF-1).
     */
    public ST[] getQrf1_WhereSubjectFilter() {
    	ST[] retVal = this.getTypedField(1, new ST[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Where Subject Filter (QRF-1).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getWhereSubjectFilterReps() {
    	return this.getReps(1);
    }


    /**
     * Returns a specific repetition of
     * QRF-1: "Where Subject Filter" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public ST getWhereSubjectFilter(int rep) { 
		ST retVal = this.getTypedField(1, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * QRF-1: "Where Subject Filter" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public ST getQrf1_WhereSubjectFilter(int rep) { 
		ST retVal = this.getTypedField(1, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Where Subject Filter (QRF-1).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getQrf1_WhereSubjectFilterReps() {
    	return this.getReps(1);
    }


    /**
     * Inserts a repetition of
     * QRF-1: "Where Subject Filter" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ST insertWhereSubjectFilter(int rep) throws HL7Exception { 
        return (ST) super.insertRepetition(1, rep);
    }


    /**
     * Inserts a repetition of
     * QRF-1: "Where Subject Filter" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ST insertQrf1_WhereSubjectFilter(int rep) throws HL7Exception { 
        return (ST) super.insertRepetition(1, rep);
    }


    /**
     * Removes a repetition of
     * QRF-1: "Where Subject Filter" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ST removeWhereSubjectFilter(int rep) throws HL7Exception { 
        return (ST) super.removeRepetition(1, rep);
    }


    /**
     * Removes a repetition of
     * QRF-1: "Where Subject Filter" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ST removeQrf1_WhereSubjectFilter(int rep) throws HL7Exception { 
        return (ST) super.removeRepetition(1, rep);
    }




    /**
     * Returns
     * QRF-2: "When Data Start Date/Time" - creates it if necessary
     */
    public TS getWhenDataStartDateTime() { 
		TS retVal = this.getTypedField(2, 0);
		return retVal;
    }
    
    /**
     * Returns
     * QRF-2: "When Data Start Date/Time" - creates it if necessary
     */
    public TS getQrf2_WhenDataStartDateTime() { 
		TS retVal = this.getTypedField(2, 0);
		return retVal;
    }



    /**
     * Returns
     * QRF-3: "When Data End Date/Time" - creates it if necessary
     */
    public TS getWhenDataEndDateTime() { 
		TS retVal = this.getTypedField(3, 0);
		return retVal;
    }
    
    /**
     * Returns
     * QRF-3: "When Data End Date/Time" - creates it if necessary
     */
    public TS getQrf3_WhenDataEndDateTime() { 
		TS retVal = this.getTypedField(3, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of What User Qualifier (QRF-4).
     */
    public ST[] getWhatUserQualifier() {
    	ST[] retVal = this.getTypedField(4, new ST[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of What User Qualifier (QRF-4).
     */
    public ST[] getQrf4_WhatUserQualifier() {
    	ST[] retVal = this.getTypedField(4, new ST[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of What User Qualifier (QRF-4).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getWhatUserQualifierReps() {
    	return this.getReps(4);
    }


    /**
     * Returns a specific repetition of
     * QRF-4: "What User Qualifier" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public ST getWhatUserQualifier(int rep) { 
		ST retVal = this.getTypedField(4, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * QRF-4: "What User Qualifier" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public ST getQrf4_WhatUserQualifier(int rep) { 
		ST retVal = this.getTypedField(4, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of What User Qualifier (QRF-4).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getQrf4_WhatUserQualifierReps() {
    	return this.getReps(4);
    }


    /**
     * Inserts a repetition of
     * QRF-4: "What User Qualifier" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ST insertWhatUserQualifier(int rep) throws HL7Exception { 
        return (ST) super.insertRepetition(4, rep);
    }


    /**
     * Inserts a repetition of
     * QRF-4: "What User Qualifier" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ST insertQrf4_WhatUserQualifier(int rep) throws HL7Exception { 
        return (ST) super.insertRepetition(4, rep);
    }


    /**
     * Removes a repetition of
     * QRF-4: "What User Qualifier" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ST removeWhatUserQualifier(int rep) throws HL7Exception { 
        return (ST) super.removeRepetition(4, rep);
    }


    /**
     * Removes a repetition of
     * QRF-4: "What User Qualifier" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ST removeQrf4_WhatUserQualifier(int rep) throws HL7Exception { 
        return (ST) super.removeRepetition(4, rep);
    }



    /**
     * Returns all repetitions of Other QRY Subject Filter (QRF-5).
     */
    public ST[] getOtherQRYSubjectFilter() {
    	ST[] retVal = this.getTypedField(5, new ST[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Other QRY Subject Filter (QRF-5).
     */
    public ST[] getQrf5_OtherQRYSubjectFilter() {
    	ST[] retVal = this.getTypedField(5, new ST[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Other QRY Subject Filter (QRF-5).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getOtherQRYSubjectFilterReps() {
    	return this.getReps(5);
    }


    /**
     * Returns a specific repetition of
     * QRF-5: "Other QRY Subject Filter" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public ST getOtherQRYSubjectFilter(int rep) { 
		ST retVal = this.getTypedField(5, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * QRF-5: "Other QRY Subject Filter" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public ST getQrf5_OtherQRYSubjectFilter(int rep) { 
		ST retVal = this.getTypedField(5, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Other QRY Subject Filter (QRF-5).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getQrf5_OtherQRYSubjectFilterReps() {
    	return this.getReps(5);
    }


    /**
     * Inserts a repetition of
     * QRF-5: "Other QRY Subject Filter" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ST insertOtherQRYSubjectFilter(int rep) throws HL7Exception { 
        return (ST) super.insertRepetition(5, rep);
    }


    /**
     * Inserts a repetition of
     * QRF-5: "Other QRY Subject Filter" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ST insertQrf5_OtherQRYSubjectFilter(int rep) throws HL7Exception { 
        return (ST) super.insertRepetition(5, rep);
    }


    /**
     * Removes a repetition of
     * QRF-5: "Other QRY Subject Filter" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ST removeOtherQRYSubjectFilter(int rep) throws HL7Exception { 
        return (ST) super.removeRepetition(5, rep);
    }


    /**
     * Removes a repetition of
     * QRF-5: "Other QRY Subject Filter" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ST removeQrf5_OtherQRYSubjectFilter(int rep) throws HL7Exception { 
        return (ST) super.removeRepetition(5, rep);
    }



    /**
     * Returns all repetitions of Which Date/Time Qualifier (QRF-6).
     */
    public ID[] getWhichDateTimeQualifier() {
    	ID[] retVal = this.getTypedField(6, new ID[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Which Date/Time Qualifier (QRF-6).
     */
    public ID[] getQrf6_WhichDateTimeQualifier() {
    	ID[] retVal = this.getTypedField(6, new ID[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Which Date/Time Qualifier (QRF-6).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getWhichDateTimeQualifierReps() {
    	return this.getReps(6);
    }


    /**
     * Returns a specific repetition of
     * QRF-6: "Which Date/Time Qualifier" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public ID getWhichDateTimeQualifier(int rep) { 
		ID retVal = this.getTypedField(6, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * QRF-6: "Which Date/Time Qualifier" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public ID getQrf6_WhichDateTimeQualifier(int rep) { 
		ID retVal = this.getTypedField(6, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Which Date/Time Qualifier (QRF-6).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getQrf6_WhichDateTimeQualifierReps() {
    	return this.getReps(6);
    }


    /**
     * Inserts a repetition of
     * QRF-6: "Which Date/Time Qualifier" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ID insertWhichDateTimeQualifier(int rep) throws HL7Exception { 
        return (ID) super.insertRepetition(6, rep);
    }


    /**
     * Inserts a repetition of
     * QRF-6: "Which Date/Time Qualifier" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ID insertQrf6_WhichDateTimeQualifier(int rep) throws HL7Exception { 
        return (ID) super.insertRepetition(6, rep);
    }


    /**
     * Removes a repetition of
     * QRF-6: "Which Date/Time Qualifier" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ID removeWhichDateTimeQualifier(int rep) throws HL7Exception { 
        return (ID) super.removeRepetition(6, rep);
    }


    /**
     * Removes a repetition of
     * QRF-6: "Which Date/Time Qualifier" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ID removeQrf6_WhichDateTimeQualifier(int rep) throws HL7Exception { 
        return (ID) super.removeRepetition(6, rep);
    }



    /**
     * Returns all repetitions of Which Date/Time Status Qualifier (QRF-7).
     */
    public ID[] getWhichDateTimeStatusQualifier() {
    	ID[] retVal = this.getTypedField(7, new ID[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Which Date/Time Status Qualifier (QRF-7).
     */
    public ID[] getQrf7_WhichDateTimeStatusQualifier() {
    	ID[] retVal = this.getTypedField(7, new ID[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Which Date/Time Status Qualifier (QRF-7).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getWhichDateTimeStatusQualifierReps() {
    	return this.getReps(7);
    }


    /**
     * Returns a specific repetition of
     * QRF-7: "Which Date/Time Status Qualifier" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public ID getWhichDateTimeStatusQualifier(int rep) { 
		ID retVal = this.getTypedField(7, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * QRF-7: "Which Date/Time Status Qualifier" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public ID getQrf7_WhichDateTimeStatusQualifier(int rep) { 
		ID retVal = this.getTypedField(7, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Which Date/Time Status Qualifier (QRF-7).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getQrf7_WhichDateTimeStatusQualifierReps() {
    	return this.getReps(7);
    }


    /**
     * Inserts a repetition of
     * QRF-7: "Which Date/Time Status Qualifier" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ID insertWhichDateTimeStatusQualifier(int rep) throws HL7Exception { 
        return (ID) super.insertRepetition(7, rep);
    }


    /**
     * Inserts a repetition of
     * QRF-7: "Which Date/Time Status Qualifier" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ID insertQrf7_WhichDateTimeStatusQualifier(int rep) throws HL7Exception { 
        return (ID) super.insertRepetition(7, rep);
    }


    /**
     * Removes a repetition of
     * QRF-7: "Which Date/Time Status Qualifier" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ID removeWhichDateTimeStatusQualifier(int rep) throws HL7Exception { 
        return (ID) super.removeRepetition(7, rep);
    }


    /**
     * Removes a repetition of
     * QRF-7: "Which Date/Time Status Qualifier" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ID removeQrf7_WhichDateTimeStatusQualifier(int rep) throws HL7Exception { 
        return (ID) super.removeRepetition(7, rep);
    }



    /**
     * Returns all repetitions of Date/Time Selection Qualifier (QRF-8).
     */
    public ID[] getDateTimeSelectionQualifier() {
    	ID[] retVal = this.getTypedField(8, new ID[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Date/Time Selection Qualifier (QRF-8).
     */
    public ID[] getQrf8_DateTimeSelectionQualifier() {
    	ID[] retVal = this.getTypedField(8, new ID[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Date/Time Selection Qualifier (QRF-8).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getDateTimeSelectionQualifierReps() {
    	return this.getReps(8);
    }


    /**
     * Returns a specific repetition of
     * QRF-8: "Date/Time Selection Qualifier" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public ID getDateTimeSelectionQualifier(int rep) { 
		ID retVal = this.getTypedField(8, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * QRF-8: "Date/Time Selection Qualifier" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public ID getQrf8_DateTimeSelectionQualifier(int rep) { 
		ID retVal = this.getTypedField(8, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Date/Time Selection Qualifier (QRF-8).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getQrf8_DateTimeSelectionQualifierReps() {
    	return this.getReps(8);
    }


    /**
     * Inserts a repetition of
     * QRF-8: "Date/Time Selection Qualifier" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ID insertDateTimeSelectionQualifier(int rep) throws HL7Exception { 
        return (ID) super.insertRepetition(8, rep);
    }


    /**
     * Inserts a repetition of
     * QRF-8: "Date/Time Selection Qualifier" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ID insertQrf8_DateTimeSelectionQualifier(int rep) throws HL7Exception { 
        return (ID) super.insertRepetition(8, rep);
    }


    /**
     * Removes a repetition of
     * QRF-8: "Date/Time Selection Qualifier" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ID removeDateTimeSelectionQualifier(int rep) throws HL7Exception { 
        return (ID) super.removeRepetition(8, rep);
    }


    /**
     * Removes a repetition of
     * QRF-8: "Date/Time Selection Qualifier" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ID removeQrf8_DateTimeSelectionQualifier(int rep) throws HL7Exception { 
        return (ID) super.removeRepetition(8, rep);
    }




    /**
     * Returns
     * QRF-9: "When Quantity/Timing Qualifier" - creates it if necessary
     */
    public TQ getWhenQuantityTimingQualifier() { 
		TQ retVal = this.getTypedField(9, 0);
		return retVal;
    }
    
    /**
     * Returns
     * QRF-9: "When Quantity/Timing Qualifier" - creates it if necessary
     */
    public TQ getQrf9_WhenQuantityTimingQualifier() { 
		TQ retVal = this.getTypedField(9, 0);
		return retVal;
    }



    /**
     * Returns
     * QRF-10: "Search Confidence Threshold" - creates it if necessary
     */
    public NM getSearchConfidenceThreshold() { 
		NM retVal = this.getTypedField(10, 0);
		return retVal;
    }
    
    /**
     * Returns
     * QRF-10: "Search Confidence Threshold" - creates it if necessary
     */
    public NM getQrf10_SearchConfidenceThreshold() { 
		NM retVal = this.getTypedField(10, 0);
		return retVal;
    }





    /** {@inheritDoc} */   
    protected Type createNewTypeWithoutReflection(int field) {
       switch (field) {
          case 0: return new ST(getMessage());
          case 1: return new TS(getMessage());
          case 2: return new TS(getMessage());
          case 3: return new ST(getMessage());
          case 4: return new ST(getMessage());
          case 5: return new ID(getMessage(), new Integer( 156 ));
          case 6: return new ID(getMessage(), new Integer( 157 ));
          case 7: return new ID(getMessage(), new Integer( 158 ));
          case 8: return new TQ(getMessage());
          case 9: return new NM(getMessage());
          default: return null;
       }
   }


}

