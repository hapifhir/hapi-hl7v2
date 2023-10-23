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
 *<p>Represents an HL7 OM7 message segment (Additional Basic Attributes). 
 * This segment has the following fields:</p>
 * <ul>
     * <li>OM7-1: Sequence Number - Test/Observation Master File (NM) <b> </b>
     * <li>OM7-2: Universal Service Identifier (CE) <b> </b>
     * <li>OM7-3: Category Identifier (CE) <b>optional repeating</b>
     * <li>OM7-4: Category Description (TX) <b>optional </b>
     * <li>OM7-5: Category Synonym (ST) <b>optional repeating</b>
     * <li>OM7-6: Effective Test/Service Start Date/Time (TS) <b>optional </b>
     * <li>OM7-7: Effective Test/Service End Date/Time (TS) <b>optional </b>
     * <li>OM7-8: Test/Service Default Duration Quantity (NM) <b>optional </b>
     * <li>OM7-9: Test/Service Default Duration Units (CE) <b>optional </b>
     * <li>OM7-10: Test/Service Default Frequency (IS) <b>optional </b>
     * <li>OM7-11: Consent Indicator (ID) <b>optional </b>
     * <li>OM7-12: Consent Identifier (CE) <b>optional </b>
     * <li>OM7-13: Consent Effective Start Date/Time (TS) <b>optional </b>
     * <li>OM7-14: Consent Effective End Date/Time (TS) <b>optional </b>
     * <li>OM7-15: Consent Interval Quantity (NM) <b>optional </b>
     * <li>OM7-16: Consent Interval Units (CE) <b>optional </b>
     * <li>OM7-17: Consent Waiting Period Quantity (NM) <b>optional </b>
     * <li>OM7-18: Consent Waiting Period Units (CE) <b>optional </b>
     * <li>OM7-19: Effective Date/Time of Change (TS) <b>optional </b>
     * <li>OM7-20: Entered By (XCN) <b>optional </b>
     * <li>OM7-21: Orderable-at Location (PL) <b>optional repeating</b>
     * <li>OM7-22: Formulary Status (IS) <b>optional </b>
     * <li>OM7-23: Special Order Indicator (ID) <b>optional </b>
     * <li>OM7-24: Primary Key Value - CDM (CE) <b>optional repeating</b>
 * </ul>
 */
@SuppressWarnings("unused")
public class OM7 extends AbstractSegment {

    /** 
     * Creates a new OM7 segment
     */
    public OM7(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(NM.class, true, 1, 4, new Object[]{ getMessage() }, "Sequence Number - Test/Observation Master File");
                                  this.add(CE.class, true, 1, 250, new Object[]{ getMessage() }, "Universal Service Identifier");
                                  this.add(CE.class, false, 0, 250, new Object[]{ getMessage() }, "Category Identifier");
                                  this.add(TX.class, false, 1, 200, new Object[]{ getMessage() }, "Category Description");
                                  this.add(ST.class, false, 0, 200, new Object[]{ getMessage() }, "Category Synonym");
                                  this.add(TS.class, false, 1, 26, new Object[]{ getMessage() }, "Effective Test/Service Start Date/Time");
                                  this.add(TS.class, false, 1, 26, new Object[]{ getMessage() }, "Effective Test/Service End Date/Time");
                                  this.add(NM.class, false, 1, 5, new Object[]{ getMessage() }, "Test/Service Default Duration Quantity");
                                  this.add(CE.class, false, 1, 250, new Object[]{ getMessage() }, "Test/Service Default Duration Units");
                                              this.add(IS.class, false, 1, 60, new Object[]{ getMessage(), new Integer(335) }, "Test/Service Default Frequency");
                                              this.add(ID.class, false, 1, 1, new Object[]{ getMessage(), new Integer(136) }, "Consent Indicator");
                                  this.add(CE.class, false, 1, 250, new Object[]{ getMessage() }, "Consent Identifier");
                                  this.add(TS.class, false, 1, 26, new Object[]{ getMessage() }, "Consent Effective Start Date/Time");
                                  this.add(TS.class, false, 1, 26, new Object[]{ getMessage() }, "Consent Effective End Date/Time");
                                  this.add(NM.class, false, 1, 5, new Object[]{ getMessage() }, "Consent Interval Quantity");
                                  this.add(CE.class, false, 1, 250, new Object[]{ getMessage() }, "Consent Interval Units");
                                  this.add(NM.class, false, 1, 5, new Object[]{ getMessage() }, "Consent Waiting Period Quantity");
                                  this.add(CE.class, false, 1, 250, new Object[]{ getMessage() }, "Consent Waiting Period Units");
                                  this.add(TS.class, false, 1, 26, new Object[]{ getMessage() }, "Effective Date/Time of Change");
                                  this.add(XCN.class, false, 1, 250, new Object[]{ getMessage() }, "Entered By");
                                  this.add(PL.class, false, 0, 200, new Object[]{ getMessage() }, "Orderable-at Location");
                                              this.add(IS.class, false, 1, 1, new Object[]{ getMessage(), new Integer(473) }, "Formulary Status");
                                              this.add(ID.class, false, 1, 1, new Object[]{ getMessage(), new Integer(136) }, "Special Order Indicator");
                                  this.add(CE.class, false, 0, 250, new Object[]{ getMessage() }, "Primary Key Value - CDM");
       } catch(HL7Exception e) {
          log.error("Unexpected error creating OM7 - this is probably a bug in the source code generator.", e);
       }
    }



    /**
     * Returns
     * OM7-1: "Sequence Number - Test/Observation Master File" - creates it if necessary
     */
    public NM getSequenceNumberTestObservationMasterFile() { 
		NM retVal = this.getTypedField(1, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OM7-1: "Sequence Number - Test/Observation Master File" - creates it if necessary
     */
    public NM getOm71_SequenceNumberTestObservationMasterFile() { 
		NM retVal = this.getTypedField(1, 0);
		return retVal;
    }



    /**
     * Returns
     * OM7-2: "Universal Service Identifier" - creates it if necessary
     */
    public CE getUniversalServiceIdentifier() { 
		CE retVal = this.getTypedField(2, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OM7-2: "Universal Service Identifier" - creates it if necessary
     */
    public CE getOm72_UniversalServiceIdentifier() { 
		CE retVal = this.getTypedField(2, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Category Identifier (OM7-3).
     */
    public CE[] getCategoryIdentifier() {
    	CE[] retVal = this.getTypedField(3, new CE[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Category Identifier (OM7-3).
     */
    public CE[] getOm73_CategoryIdentifier() {
    	CE[] retVal = this.getTypedField(3, new CE[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Category Identifier (OM7-3).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getCategoryIdentifierReps() {
    	return this.getReps(3);
    }


    /**
     * Returns a specific repetition of
     * OM7-3: "Category Identifier" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CE getCategoryIdentifier(int rep) { 
		CE retVal = this.getTypedField(3, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * OM7-3: "Category Identifier" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CE getOm73_CategoryIdentifier(int rep) { 
		CE retVal = this.getTypedField(3, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Category Identifier (OM7-3).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getOm73_CategoryIdentifierReps() {
    	return this.getReps(3);
    }


    /**
     * Inserts a repetition of
     * OM7-3: "Category Identifier" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE insertCategoryIdentifier(int rep) throws HL7Exception { 
        return (CE) super.insertRepetition(3, rep);
    }


    /**
     * Inserts a repetition of
     * OM7-3: "Category Identifier" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE insertOm73_CategoryIdentifier(int rep) throws HL7Exception { 
        return (CE) super.insertRepetition(3, rep);
    }


    /**
     * Removes a repetition of
     * OM7-3: "Category Identifier" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE removeCategoryIdentifier(int rep) throws HL7Exception { 
        return (CE) super.removeRepetition(3, rep);
    }


    /**
     * Removes a repetition of
     * OM7-3: "Category Identifier" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE removeOm73_CategoryIdentifier(int rep) throws HL7Exception { 
        return (CE) super.removeRepetition(3, rep);
    }




    /**
     * Returns
     * OM7-4: "Category Description" - creates it if necessary
     */
    public TX getCategoryDescription() { 
		TX retVal = this.getTypedField(4, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OM7-4: "Category Description" - creates it if necessary
     */
    public TX getOm74_CategoryDescription() { 
		TX retVal = this.getTypedField(4, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Category Synonym (OM7-5).
     */
    public ST[] getCategorySynonym() {
    	ST[] retVal = this.getTypedField(5, new ST[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Category Synonym (OM7-5).
     */
    public ST[] getOm75_CategorySynonym() {
    	ST[] retVal = this.getTypedField(5, new ST[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Category Synonym (OM7-5).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getCategorySynonymReps() {
    	return this.getReps(5);
    }


    /**
     * Returns a specific repetition of
     * OM7-5: "Category Synonym" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public ST getCategorySynonym(int rep) { 
		ST retVal = this.getTypedField(5, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * OM7-5: "Category Synonym" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public ST getOm75_CategorySynonym(int rep) { 
		ST retVal = this.getTypedField(5, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Category Synonym (OM7-5).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getOm75_CategorySynonymReps() {
    	return this.getReps(5);
    }


    /**
     * Inserts a repetition of
     * OM7-5: "Category Synonym" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ST insertCategorySynonym(int rep) throws HL7Exception { 
        return (ST) super.insertRepetition(5, rep);
    }


    /**
     * Inserts a repetition of
     * OM7-5: "Category Synonym" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ST insertOm75_CategorySynonym(int rep) throws HL7Exception { 
        return (ST) super.insertRepetition(5, rep);
    }


    /**
     * Removes a repetition of
     * OM7-5: "Category Synonym" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ST removeCategorySynonym(int rep) throws HL7Exception { 
        return (ST) super.removeRepetition(5, rep);
    }


    /**
     * Removes a repetition of
     * OM7-5: "Category Synonym" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ST removeOm75_CategorySynonym(int rep) throws HL7Exception { 
        return (ST) super.removeRepetition(5, rep);
    }




    /**
     * Returns
     * OM7-6: "Effective Test/Service Start Date/Time" - creates it if necessary
     */
    public TS getEffectiveTestServiceStartDateTime() { 
		TS retVal = this.getTypedField(6, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OM7-6: "Effective Test/Service Start Date/Time" - creates it if necessary
     */
    public TS getOm76_EffectiveTestServiceStartDateTime() { 
		TS retVal = this.getTypedField(6, 0);
		return retVal;
    }



    /**
     * Returns
     * OM7-7: "Effective Test/Service End Date/Time" - creates it if necessary
     */
    public TS getEffectiveTestServiceEndDateTime() { 
		TS retVal = this.getTypedField(7, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OM7-7: "Effective Test/Service End Date/Time" - creates it if necessary
     */
    public TS getOm77_EffectiveTestServiceEndDateTime() { 
		TS retVal = this.getTypedField(7, 0);
		return retVal;
    }



    /**
     * Returns
     * OM7-8: "Test/Service Default Duration Quantity" - creates it if necessary
     */
    public NM getTestServiceDefaultDurationQuantity() { 
		NM retVal = this.getTypedField(8, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OM7-8: "Test/Service Default Duration Quantity" - creates it if necessary
     */
    public NM getOm78_TestServiceDefaultDurationQuantity() { 
		NM retVal = this.getTypedField(8, 0);
		return retVal;
    }



    /**
     * Returns
     * OM7-9: "Test/Service Default Duration Units" - creates it if necessary
     */
    public CE getTestServiceDefaultDurationUnits() { 
		CE retVal = this.getTypedField(9, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OM7-9: "Test/Service Default Duration Units" - creates it if necessary
     */
    public CE getOm79_TestServiceDefaultDurationUnits() { 
		CE retVal = this.getTypedField(9, 0);
		return retVal;
    }



    /**
     * Returns
     * OM7-10: "Test/Service Default Frequency" - creates it if necessary
     */
    public IS getTestServiceDefaultFrequency() { 
		IS retVal = this.getTypedField(10, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OM7-10: "Test/Service Default Frequency" - creates it if necessary
     */
    public IS getOm710_TestServiceDefaultFrequency() { 
		IS retVal = this.getTypedField(10, 0);
		return retVal;
    }



    /**
     * Returns
     * OM7-11: "Consent Indicator" - creates it if necessary
     */
    public ID getConsentIndicator() { 
		ID retVal = this.getTypedField(11, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OM7-11: "Consent Indicator" - creates it if necessary
     */
    public ID getOm711_ConsentIndicator() { 
		ID retVal = this.getTypedField(11, 0);
		return retVal;
    }



    /**
     * Returns
     * OM7-12: "Consent Identifier" - creates it if necessary
     */
    public CE getConsentIdentifier() { 
		CE retVal = this.getTypedField(12, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OM7-12: "Consent Identifier" - creates it if necessary
     */
    public CE getOm712_ConsentIdentifier() { 
		CE retVal = this.getTypedField(12, 0);
		return retVal;
    }



    /**
     * Returns
     * OM7-13: "Consent Effective Start Date/Time" - creates it if necessary
     */
    public TS getConsentEffectiveStartDateTime() { 
		TS retVal = this.getTypedField(13, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OM7-13: "Consent Effective Start Date/Time" - creates it if necessary
     */
    public TS getOm713_ConsentEffectiveStartDateTime() { 
		TS retVal = this.getTypedField(13, 0);
		return retVal;
    }



    /**
     * Returns
     * OM7-14: "Consent Effective End Date/Time" - creates it if necessary
     */
    public TS getConsentEffectiveEndDateTime() { 
		TS retVal = this.getTypedField(14, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OM7-14: "Consent Effective End Date/Time" - creates it if necessary
     */
    public TS getOm714_ConsentEffectiveEndDateTime() { 
		TS retVal = this.getTypedField(14, 0);
		return retVal;
    }



    /**
     * Returns
     * OM7-15: "Consent Interval Quantity" - creates it if necessary
     */
    public NM getConsentIntervalQuantity() { 
		NM retVal = this.getTypedField(15, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OM7-15: "Consent Interval Quantity" - creates it if necessary
     */
    public NM getOm715_ConsentIntervalQuantity() { 
		NM retVal = this.getTypedField(15, 0);
		return retVal;
    }



    /**
     * Returns
     * OM7-16: "Consent Interval Units" - creates it if necessary
     */
    public CE getConsentIntervalUnits() { 
		CE retVal = this.getTypedField(16, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OM7-16: "Consent Interval Units" - creates it if necessary
     */
    public CE getOm716_ConsentIntervalUnits() { 
		CE retVal = this.getTypedField(16, 0);
		return retVal;
    }



    /**
     * Returns
     * OM7-17: "Consent Waiting Period Quantity" - creates it if necessary
     */
    public NM getConsentWaitingPeriodQuantity() { 
		NM retVal = this.getTypedField(17, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OM7-17: "Consent Waiting Period Quantity" - creates it if necessary
     */
    public NM getOm717_ConsentWaitingPeriodQuantity() { 
		NM retVal = this.getTypedField(17, 0);
		return retVal;
    }



    /**
     * Returns
     * OM7-18: "Consent Waiting Period Units" - creates it if necessary
     */
    public CE getConsentWaitingPeriodUnits() { 
		CE retVal = this.getTypedField(18, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OM7-18: "Consent Waiting Period Units" - creates it if necessary
     */
    public CE getOm718_ConsentWaitingPeriodUnits() { 
		CE retVal = this.getTypedField(18, 0);
		return retVal;
    }



    /**
     * Returns
     * OM7-19: "Effective Date/Time of Change" - creates it if necessary
     */
    public TS getEffectiveDateTimeOfChange() { 
		TS retVal = this.getTypedField(19, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OM7-19: "Effective Date/Time of Change" - creates it if necessary
     */
    public TS getOm719_EffectiveDateTimeOfChange() { 
		TS retVal = this.getTypedField(19, 0);
		return retVal;
    }



    /**
     * Returns
     * OM7-20: "Entered By" - creates it if necessary
     */
    public XCN getEnteredBy() { 
		XCN retVal = this.getTypedField(20, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OM7-20: "Entered By" - creates it if necessary
     */
    public XCN getOm720_EnteredBy() { 
		XCN retVal = this.getTypedField(20, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Orderable-at Location (OM7-21).
     */
    public PL[] getOrderableAtLocation() {
    	PL[] retVal = this.getTypedField(21, new PL[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Orderable-at Location (OM7-21).
     */
    public PL[] getOm721_OrderableAtLocation() {
    	PL[] retVal = this.getTypedField(21, new PL[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Orderable-at Location (OM7-21).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getOrderableAtLocationReps() {
    	return this.getReps(21);
    }


    /**
     * Returns a specific repetition of
     * OM7-21: "Orderable-at Location" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public PL getOrderableAtLocation(int rep) { 
		PL retVal = this.getTypedField(21, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * OM7-21: "Orderable-at Location" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public PL getOm721_OrderableAtLocation(int rep) { 
		PL retVal = this.getTypedField(21, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Orderable-at Location (OM7-21).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getOm721_OrderableAtLocationReps() {
    	return this.getReps(21);
    }


    /**
     * Inserts a repetition of
     * OM7-21: "Orderable-at Location" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public PL insertOrderableAtLocation(int rep) throws HL7Exception { 
        return (PL) super.insertRepetition(21, rep);
    }


    /**
     * Inserts a repetition of
     * OM7-21: "Orderable-at Location" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public PL insertOm721_OrderableAtLocation(int rep) throws HL7Exception { 
        return (PL) super.insertRepetition(21, rep);
    }


    /**
     * Removes a repetition of
     * OM7-21: "Orderable-at Location" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public PL removeOrderableAtLocation(int rep) throws HL7Exception { 
        return (PL) super.removeRepetition(21, rep);
    }


    /**
     * Removes a repetition of
     * OM7-21: "Orderable-at Location" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public PL removeOm721_OrderableAtLocation(int rep) throws HL7Exception { 
        return (PL) super.removeRepetition(21, rep);
    }




    /**
     * Returns
     * OM7-22: "Formulary Status" - creates it if necessary
     */
    public IS getFormularyStatus() { 
		IS retVal = this.getTypedField(22, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OM7-22: "Formulary Status" - creates it if necessary
     */
    public IS getOm722_FormularyStatus() { 
		IS retVal = this.getTypedField(22, 0);
		return retVal;
    }



    /**
     * Returns
     * OM7-23: "Special Order Indicator" - creates it if necessary
     */
    public ID getSpecialOrderIndicator() { 
		ID retVal = this.getTypedField(23, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OM7-23: "Special Order Indicator" - creates it if necessary
     */
    public ID getOm723_SpecialOrderIndicator() { 
		ID retVal = this.getTypedField(23, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Primary Key Value - CDM (OM7-24).
     */
    public CE[] getPrimaryKeyValueCDM() {
    	CE[] retVal = this.getTypedField(24, new CE[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Primary Key Value - CDM (OM7-24).
     */
    public CE[] getOm724_PrimaryKeyValueCDM() {
    	CE[] retVal = this.getTypedField(24, new CE[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Primary Key Value - CDM (OM7-24).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getPrimaryKeyValueCDMReps() {
    	return this.getReps(24);
    }


    /**
     * Returns a specific repetition of
     * OM7-24: "Primary Key Value - CDM" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CE getPrimaryKeyValueCDM(int rep) { 
		CE retVal = this.getTypedField(24, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * OM7-24: "Primary Key Value - CDM" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CE getOm724_PrimaryKeyValueCDM(int rep) { 
		CE retVal = this.getTypedField(24, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Primary Key Value - CDM (OM7-24).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getOm724_PrimaryKeyValueCDMReps() {
    	return this.getReps(24);
    }


    /**
     * Inserts a repetition of
     * OM7-24: "Primary Key Value - CDM" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE insertPrimaryKeyValueCDM(int rep) throws HL7Exception { 
        return (CE) super.insertRepetition(24, rep);
    }


    /**
     * Inserts a repetition of
     * OM7-24: "Primary Key Value - CDM" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE insertOm724_PrimaryKeyValueCDM(int rep) throws HL7Exception { 
        return (CE) super.insertRepetition(24, rep);
    }


    /**
     * Removes a repetition of
     * OM7-24: "Primary Key Value - CDM" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE removePrimaryKeyValueCDM(int rep) throws HL7Exception { 
        return (CE) super.removeRepetition(24, rep);
    }


    /**
     * Removes a repetition of
     * OM7-24: "Primary Key Value - CDM" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE removeOm724_PrimaryKeyValueCDM(int rep) throws HL7Exception { 
        return (CE) super.removeRepetition(24, rep);
    }






    /** {@inheritDoc} */   
    protected Type createNewTypeWithoutReflection(int field) {
       switch (field) {
          case 0: return new NM(getMessage());
          case 1: return new CE(getMessage());
          case 2: return new CE(getMessage());
          case 3: return new TX(getMessage());
          case 4: return new ST(getMessage());
          case 5: return new TS(getMessage());
          case 6: return new TS(getMessage());
          case 7: return new NM(getMessage());
          case 8: return new CE(getMessage());
          case 9: return new IS(getMessage(), new Integer( 335 ));
          case 10: return new ID(getMessage(), new Integer( 136 ));
          case 11: return new CE(getMessage());
          case 12: return new TS(getMessage());
          case 13: return new TS(getMessage());
          case 14: return new NM(getMessage());
          case 15: return new CE(getMessage());
          case 16: return new NM(getMessage());
          case 17: return new CE(getMessage());
          case 18: return new TS(getMessage());
          case 19: return new XCN(getMessage());
          case 20: return new PL(getMessage());
          case 21: return new IS(getMessage(), new Integer( 473 ));
          case 22: return new ID(getMessage(), new Integer( 136 ));
          case 23: return new CE(getMessage());
          default: return null;
       }
   }


}

