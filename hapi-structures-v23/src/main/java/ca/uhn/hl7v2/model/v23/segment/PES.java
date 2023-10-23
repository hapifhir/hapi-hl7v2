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
 *<p>Represents an HL7 PES message segment (Product Experience Sender). 
 * This segment has the following fields:</p>
 * <ul>
     * <li>PES-1: Sender Organization Name (XON) <b>optional </b>
     * <li>PES-2: Sender Individual Name (XCN) <b>optional repeating</b>
     * <li>PES-3: Sender Address (XAD) <b>optional repeating</b>
     * <li>PES-4: Sender Telephone (XTN) <b>optional repeating</b>
     * <li>PES-5: Sender Event Identifier (EI) <b>optional </b>
     * <li>PES-6: Sender Sequence Number (NM) <b>optional </b>
     * <li>PES-7: Sender Event Description (FT) <b>optional repeating</b>
     * <li>PES-8: Sender Comment (FT) <b>optional </b>
     * <li>PES-9: Sender Aware Date/Time (TS) <b>optional </b>
     * <li>PES-10: Event Report Date (TS) <b> </b>
     * <li>PES-11: Event Report Timing/Type (ID) <b>optional repeating</b>
     * <li>PES-12: Event Report Source (ID) <b>optional </b>
     * <li>PES-13: Event Reported To (ID) <b>optional repeating</b>
 * </ul>
 */
@SuppressWarnings("unused")
public class PES extends AbstractSegment {

    /** 
     * Creates a new PES segment
     */
    public PES(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(XON.class, false, 1, 80, new Object[]{ getMessage() }, "Sender Organization Name");
                                  this.add(XCN.class, false, 0, 60, new Object[]{ getMessage() }, "Sender Individual Name");
                                  this.add(XAD.class, false, 0, 200, new Object[]{ getMessage() }, "Sender Address");
                                  this.add(XTN.class, false, 0, 44, new Object[]{ getMessage() }, "Sender Telephone");
                                  this.add(EI.class, false, 1, 30, new Object[]{ getMessage() }, "Sender Event Identifier");
                                  this.add(NM.class, false, 1, 2, new Object[]{ getMessage() }, "Sender Sequence Number");
                                  this.add(FT.class, false, 0, 600, new Object[]{ getMessage() }, "Sender Event Description");
                                  this.add(FT.class, false, 1, 600, new Object[]{ getMessage() }, "Sender Comment");
                                  this.add(TS.class, false, 1, 26, new Object[]{ getMessage() }, "Sender Aware Date/Time");
                                  this.add(TS.class, true, 1, 26, new Object[]{ getMessage() }, "Event Report Date");
                                              this.add(ID.class, false, 2, 3, new Object[]{ getMessage(), new Integer(234) }, "Event Report Timing/Type");
                                              this.add(ID.class, false, 1, 1, new Object[]{ getMessage(), new Integer(235) }, "Event Report Source");
                                              this.add(ID.class, false, 0, 1, new Object[]{ getMessage(), new Integer(236) }, "Event Reported To");
       } catch(HL7Exception e) {
          log.error("Unexpected error creating PES - this is probably a bug in the source code generator.", e);
       }
    }



    /**
     * Returns
     * PES-1: "Sender Organization Name" - creates it if necessary
     */
    public XON getSenderOrganizationName() { 
		XON retVal = this.getTypedField(1, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PES-1: "Sender Organization Name" - creates it if necessary
     */
    public XON getPes1_SenderOrganizationName() { 
		XON retVal = this.getTypedField(1, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Sender Individual Name (PES-2).
     */
    public XCN[] getSenderIndividualName() {
    	XCN[] retVal = this.getTypedField(2, new XCN[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Sender Individual Name (PES-2).
     */
    public XCN[] getPes2_SenderIndividualName() {
    	XCN[] retVal = this.getTypedField(2, new XCN[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Sender Individual Name (PES-2).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getSenderIndividualNameReps() {
    	return this.getReps(2);
    }


    /**
     * Returns a specific repetition of
     * PES-2: "Sender Individual Name" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XCN getSenderIndividualName(int rep) { 
		XCN retVal = this.getTypedField(2, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * PES-2: "Sender Individual Name" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XCN getPes2_SenderIndividualName(int rep) { 
		XCN retVal = this.getTypedField(2, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Sender Individual Name (PES-2).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getPes2_SenderIndividualNameReps() {
    	return this.getReps(2);
    }


    /**
     * Inserts a repetition of
     * PES-2: "Sender Individual Name" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XCN insertSenderIndividualName(int rep) throws HL7Exception { 
        return (XCN) super.insertRepetition(2, rep);
    }


    /**
     * Inserts a repetition of
     * PES-2: "Sender Individual Name" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XCN insertPes2_SenderIndividualName(int rep) throws HL7Exception { 
        return (XCN) super.insertRepetition(2, rep);
    }


    /**
     * Removes a repetition of
     * PES-2: "Sender Individual Name" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XCN removeSenderIndividualName(int rep) throws HL7Exception { 
        return (XCN) super.removeRepetition(2, rep);
    }


    /**
     * Removes a repetition of
     * PES-2: "Sender Individual Name" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XCN removePes2_SenderIndividualName(int rep) throws HL7Exception { 
        return (XCN) super.removeRepetition(2, rep);
    }



    /**
     * Returns all repetitions of Sender Address (PES-3).
     */
    public XAD[] getSenderAddress() {
    	XAD[] retVal = this.getTypedField(3, new XAD[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Sender Address (PES-3).
     */
    public XAD[] getPes3_SenderAddress() {
    	XAD[] retVal = this.getTypedField(3, new XAD[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Sender Address (PES-3).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getSenderAddressReps() {
    	return this.getReps(3);
    }


    /**
     * Returns a specific repetition of
     * PES-3: "Sender Address" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XAD getSenderAddress(int rep) { 
		XAD retVal = this.getTypedField(3, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * PES-3: "Sender Address" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XAD getPes3_SenderAddress(int rep) { 
		XAD retVal = this.getTypedField(3, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Sender Address (PES-3).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getPes3_SenderAddressReps() {
    	return this.getReps(3);
    }


    /**
     * Inserts a repetition of
     * PES-3: "Sender Address" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XAD insertSenderAddress(int rep) throws HL7Exception { 
        return (XAD) super.insertRepetition(3, rep);
    }


    /**
     * Inserts a repetition of
     * PES-3: "Sender Address" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XAD insertPes3_SenderAddress(int rep) throws HL7Exception { 
        return (XAD) super.insertRepetition(3, rep);
    }


    /**
     * Removes a repetition of
     * PES-3: "Sender Address" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XAD removeSenderAddress(int rep) throws HL7Exception { 
        return (XAD) super.removeRepetition(3, rep);
    }


    /**
     * Removes a repetition of
     * PES-3: "Sender Address" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XAD removePes3_SenderAddress(int rep) throws HL7Exception { 
        return (XAD) super.removeRepetition(3, rep);
    }



    /**
     * Returns all repetitions of Sender Telephone (PES-4).
     */
    public XTN[] getSenderTelephone() {
    	XTN[] retVal = this.getTypedField(4, new XTN[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Sender Telephone (PES-4).
     */
    public XTN[] getPes4_SenderTelephone() {
    	XTN[] retVal = this.getTypedField(4, new XTN[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Sender Telephone (PES-4).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getSenderTelephoneReps() {
    	return this.getReps(4);
    }


    /**
     * Returns a specific repetition of
     * PES-4: "Sender Telephone" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XTN getSenderTelephone(int rep) { 
		XTN retVal = this.getTypedField(4, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * PES-4: "Sender Telephone" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XTN getPes4_SenderTelephone(int rep) { 
		XTN retVal = this.getTypedField(4, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Sender Telephone (PES-4).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getPes4_SenderTelephoneReps() {
    	return this.getReps(4);
    }


    /**
     * Inserts a repetition of
     * PES-4: "Sender Telephone" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XTN insertSenderTelephone(int rep) throws HL7Exception { 
        return (XTN) super.insertRepetition(4, rep);
    }


    /**
     * Inserts a repetition of
     * PES-4: "Sender Telephone" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XTN insertPes4_SenderTelephone(int rep) throws HL7Exception { 
        return (XTN) super.insertRepetition(4, rep);
    }


    /**
     * Removes a repetition of
     * PES-4: "Sender Telephone" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XTN removeSenderTelephone(int rep) throws HL7Exception { 
        return (XTN) super.removeRepetition(4, rep);
    }


    /**
     * Removes a repetition of
     * PES-4: "Sender Telephone" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XTN removePes4_SenderTelephone(int rep) throws HL7Exception { 
        return (XTN) super.removeRepetition(4, rep);
    }




    /**
     * Returns
     * PES-5: "Sender Event Identifier" - creates it if necessary
     */
    public EI getSenderEventIdentifier() { 
		EI retVal = this.getTypedField(5, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PES-5: "Sender Event Identifier" - creates it if necessary
     */
    public EI getPes5_SenderEventIdentifier() { 
		EI retVal = this.getTypedField(5, 0);
		return retVal;
    }



    /**
     * Returns
     * PES-6: "Sender Sequence Number" - creates it if necessary
     */
    public NM getSenderSequenceNumber() { 
		NM retVal = this.getTypedField(6, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PES-6: "Sender Sequence Number" - creates it if necessary
     */
    public NM getPes6_SenderSequenceNumber() { 
		NM retVal = this.getTypedField(6, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Sender Event Description (PES-7).
     */
    public FT[] getSenderEventDescription() {
    	FT[] retVal = this.getTypedField(7, new FT[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Sender Event Description (PES-7).
     */
    public FT[] getPes7_SenderEventDescription() {
    	FT[] retVal = this.getTypedField(7, new FT[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Sender Event Description (PES-7).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getSenderEventDescriptionReps() {
    	return this.getReps(7);
    }


    /**
     * Returns a specific repetition of
     * PES-7: "Sender Event Description" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public FT getSenderEventDescription(int rep) { 
		FT retVal = this.getTypedField(7, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * PES-7: "Sender Event Description" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public FT getPes7_SenderEventDescription(int rep) { 
		FT retVal = this.getTypedField(7, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Sender Event Description (PES-7).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getPes7_SenderEventDescriptionReps() {
    	return this.getReps(7);
    }


    /**
     * Inserts a repetition of
     * PES-7: "Sender Event Description" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public FT insertSenderEventDescription(int rep) throws HL7Exception { 
        return (FT) super.insertRepetition(7, rep);
    }


    /**
     * Inserts a repetition of
     * PES-7: "Sender Event Description" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public FT insertPes7_SenderEventDescription(int rep) throws HL7Exception { 
        return (FT) super.insertRepetition(7, rep);
    }


    /**
     * Removes a repetition of
     * PES-7: "Sender Event Description" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public FT removeSenderEventDescription(int rep) throws HL7Exception { 
        return (FT) super.removeRepetition(7, rep);
    }


    /**
     * Removes a repetition of
     * PES-7: "Sender Event Description" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public FT removePes7_SenderEventDescription(int rep) throws HL7Exception { 
        return (FT) super.removeRepetition(7, rep);
    }




    /**
     * Returns
     * PES-8: "Sender Comment" - creates it if necessary
     */
    public FT getSenderComment() { 
		FT retVal = this.getTypedField(8, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PES-8: "Sender Comment" - creates it if necessary
     */
    public FT getPes8_SenderComment() { 
		FT retVal = this.getTypedField(8, 0);
		return retVal;
    }



    /**
     * Returns
     * PES-9: "Sender Aware Date/Time" - creates it if necessary
     */
    public TS getSenderAwareDateTime() { 
		TS retVal = this.getTypedField(9, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PES-9: "Sender Aware Date/Time" - creates it if necessary
     */
    public TS getPes9_SenderAwareDateTime() { 
		TS retVal = this.getTypedField(9, 0);
		return retVal;
    }



    /**
     * Returns
     * PES-10: "Event Report Date" - creates it if necessary
     */
    public TS getEventReportDate() { 
		TS retVal = this.getTypedField(10, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PES-10: "Event Report Date" - creates it if necessary
     */
    public TS getPes10_EventReportDate() { 
		TS retVal = this.getTypedField(10, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Event Report Timing/Type (PES-11).
     */
    public ID[] getEventReportTimingType() {
    	ID[] retVal = this.getTypedField(11, new ID[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Event Report Timing/Type (PES-11).
     */
    public ID[] getPes11_EventReportTimingType() {
    	ID[] retVal = this.getTypedField(11, new ID[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Event Report Timing/Type (PES-11).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getEventReportTimingTypeReps() {
    	return this.getReps(11);
    }


    /**
     * Returns a specific repetition of
     * PES-11: "Event Report Timing/Type" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public ID getEventReportTimingType(int rep) { 
		ID retVal = this.getTypedField(11, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * PES-11: "Event Report Timing/Type" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public ID getPes11_EventReportTimingType(int rep) { 
		ID retVal = this.getTypedField(11, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Event Report Timing/Type (PES-11).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getPes11_EventReportTimingTypeReps() {
    	return this.getReps(11);
    }


    /**
     * Inserts a repetition of
     * PES-11: "Event Report Timing/Type" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ID insertEventReportTimingType(int rep) throws HL7Exception { 
        return (ID) super.insertRepetition(11, rep);
    }


    /**
     * Inserts a repetition of
     * PES-11: "Event Report Timing/Type" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ID insertPes11_EventReportTimingType(int rep) throws HL7Exception { 
        return (ID) super.insertRepetition(11, rep);
    }


    /**
     * Removes a repetition of
     * PES-11: "Event Report Timing/Type" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ID removeEventReportTimingType(int rep) throws HL7Exception { 
        return (ID) super.removeRepetition(11, rep);
    }


    /**
     * Removes a repetition of
     * PES-11: "Event Report Timing/Type" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ID removePes11_EventReportTimingType(int rep) throws HL7Exception { 
        return (ID) super.removeRepetition(11, rep);
    }




    /**
     * Returns
     * PES-12: "Event Report Source" - creates it if necessary
     */
    public ID getEventReportSource() { 
		ID retVal = this.getTypedField(12, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PES-12: "Event Report Source" - creates it if necessary
     */
    public ID getPes12_EventReportSource() { 
		ID retVal = this.getTypedField(12, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Event Reported To (PES-13).
     */
    public ID[] getEventReportedTo() {
    	ID[] retVal = this.getTypedField(13, new ID[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Event Reported To (PES-13).
     */
    public ID[] getPes13_EventReportedTo() {
    	ID[] retVal = this.getTypedField(13, new ID[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Event Reported To (PES-13).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getEventReportedToReps() {
    	return this.getReps(13);
    }


    /**
     * Returns a specific repetition of
     * PES-13: "Event Reported To" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public ID getEventReportedTo(int rep) { 
		ID retVal = this.getTypedField(13, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * PES-13: "Event Reported To" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public ID getPes13_EventReportedTo(int rep) { 
		ID retVal = this.getTypedField(13, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Event Reported To (PES-13).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getPes13_EventReportedToReps() {
    	return this.getReps(13);
    }


    /**
     * Inserts a repetition of
     * PES-13: "Event Reported To" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ID insertEventReportedTo(int rep) throws HL7Exception { 
        return (ID) super.insertRepetition(13, rep);
    }


    /**
     * Inserts a repetition of
     * PES-13: "Event Reported To" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ID insertPes13_EventReportedTo(int rep) throws HL7Exception { 
        return (ID) super.insertRepetition(13, rep);
    }


    /**
     * Removes a repetition of
     * PES-13: "Event Reported To" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ID removeEventReportedTo(int rep) throws HL7Exception { 
        return (ID) super.removeRepetition(13, rep);
    }


    /**
     * Removes a repetition of
     * PES-13: "Event Reported To" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ID removePes13_EventReportedTo(int rep) throws HL7Exception { 
        return (ID) super.removeRepetition(13, rep);
    }






    /** {@inheritDoc} */   
    protected Type createNewTypeWithoutReflection(int field) {
       switch (field) {
          case 0: return new XON(getMessage());
          case 1: return new XCN(getMessage());
          case 2: return new XAD(getMessage());
          case 3: return new XTN(getMessage());
          case 4: return new EI(getMessage());
          case 5: return new NM(getMessage());
          case 6: return new FT(getMessage());
          case 7: return new FT(getMessage());
          case 8: return new TS(getMessage());
          case 9: return new TS(getMessage());
          case 10: return new ID(getMessage(), new Integer( 234 ));
          case 11: return new ID(getMessage(), new Integer( 235 ));
          case 12: return new ID(getMessage(), new Integer( 236 ));
          default: return null;
       }
   }


}

