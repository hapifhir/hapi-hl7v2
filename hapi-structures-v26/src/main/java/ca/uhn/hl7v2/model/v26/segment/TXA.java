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
 *<p>Represents an HL7 TXA message segment (Transcription Document Header). 
 * This segment has the following fields:</p>
 * <ul>
     * <li>TXA-1: Set ID- TXA (SI) <b> </b>
     * <li>TXA-2: Document Type (IS) <b> </b>
     * <li>TXA-3: Document Content Presentation (ID) <b>optional </b>
     * <li>TXA-4: Activity Date/Time (DTM) <b>optional </b>
     * <li>TXA-5: Primary Activity Provider Code/Name (XCN) <b>optional repeating</b>
     * <li>TXA-6: Origination Date/Time (DTM) <b>optional </b>
     * <li>TXA-7: Transcription Date/Time (DTM) <b>optional </b>
     * <li>TXA-8: Edit Date/Time (DTM) <b>optional repeating</b>
     * <li>TXA-9: Originator Code/Name (XCN) <b>optional repeating</b>
     * <li>TXA-10: Assigned Document Authenticator (XCN) <b>optional repeating</b>
     * <li>TXA-11: Transcriptionist Code/Name (XCN) <b>optional repeating</b>
     * <li>TXA-12: Unique Document Number (EI) <b> </b>
     * <li>TXA-13: Parent Document Number (EI) <b>optional </b>
     * <li>TXA-14: Placer Order Number (EI) <b>optional repeating</b>
     * <li>TXA-15: Filler Order Number (EI) <b>optional </b>
     * <li>TXA-16: Unique Document File Name (ST) <b>optional </b>
     * <li>TXA-17: Document Completion Status (ID) <b> </b>
     * <li>TXA-18: Document Confidentiality Status (ID) <b>optional </b>
     * <li>TXA-19: Document Availability Status (ID) <b>optional </b>
     * <li>TXA-20: Document Storage Status (ID) <b>optional </b>
     * <li>TXA-21: Document Change Reason (ST) <b>optional </b>
     * <li>TXA-22: Authentication Person, Time Stamp (set) (PPN) <b>optional repeating</b>
     * <li>TXA-23: Distributed Copies (Code and Name of Recipient(s) ) (XCN) <b>optional repeating</b>
 * </ul>
 */
@SuppressWarnings("unused")
public class TXA extends AbstractSegment {

    /** 
     * Creates a new TXA segment
     */
    public TXA(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(SI.class, true, 1, 4, new Object[]{ getMessage() }, "Set ID- TXA");
                                              this.add(IS.class, true, 1, 30, new Object[]{ getMessage(), new Integer(270) }, "Document Type");
                                              this.add(ID.class, false, 1, 2, new Object[]{ getMessage(), new Integer(191) }, "Document Content Presentation");
                                  this.add(DTM.class, false, 1, 24, new Object[]{ getMessage() }, "Activity Date/Time");
                                  this.add(XCN.class, false, 0, 250, new Object[]{ getMessage() }, "Primary Activity Provider Code/Name");
                                  this.add(DTM.class, false, 1, 24, new Object[]{ getMessage() }, "Origination Date/Time");
                                  this.add(DTM.class, false, 1, 24, new Object[]{ getMessage() }, "Transcription Date/Time");
                                  this.add(DTM.class, false, 0, 24, new Object[]{ getMessage() }, "Edit Date/Time");
                                  this.add(XCN.class, false, 0, 250, new Object[]{ getMessage() }, "Originator Code/Name");
                                  this.add(XCN.class, false, 0, 250, new Object[]{ getMessage() }, "Assigned Document Authenticator");
                                  this.add(XCN.class, false, 0, 250, new Object[]{ getMessage() }, "Transcriptionist Code/Name");
                                  this.add(EI.class, true, 1, 427, new Object[]{ getMessage() }, "Unique Document Number");
                                  this.add(EI.class, false, 1, 427, new Object[]{ getMessage() }, "Parent Document Number");
                                  this.add(EI.class, false, 0, 427, new Object[]{ getMessage() }, "Placer Order Number");
                                  this.add(EI.class, false, 1, 427, new Object[]{ getMessage() }, "Filler Order Number");
                                  this.add(ST.class, false, 1, 30, new Object[]{ getMessage() }, "Unique Document File Name");
                                              this.add(ID.class, true, 1, 2, new Object[]{ getMessage(), new Integer(271) }, "Document Completion Status");
                                              this.add(ID.class, false, 1, 2, new Object[]{ getMessage(), new Integer(272) }, "Document Confidentiality Status");
                                              this.add(ID.class, false, 1, 2, new Object[]{ getMessage(), new Integer(273) }, "Document Availability Status");
                                              this.add(ID.class, false, 1, 2, new Object[]{ getMessage(), new Integer(275) }, "Document Storage Status");
                                  this.add(ST.class, false, 1, 30, new Object[]{ getMessage() }, "Document Change Reason");
                                  this.add(PPN.class, false, 0, 250, new Object[]{ getMessage() }, "Authentication Person, Time Stamp (set)");
                                  this.add(XCN.class, false, 0, 250, new Object[]{ getMessage() }, "Distributed Copies (Code and Name of Recipient(s) )");
       } catch(HL7Exception e) {
          log.error("Unexpected error creating TXA - this is probably a bug in the source code generator.", e);
       }
    }



    /**
     * Returns
     * TXA-1: "Set ID- TXA" - creates it if necessary
     */
    public SI getSetIDTXA() { 
		SI retVal = this.getTypedField(1, 0);
		return retVal;
    }
    
    /**
     * Returns
     * TXA-1: "Set ID- TXA" - creates it if necessary
     */
    public SI getTxa1_SetIDTXA() { 
		SI retVal = this.getTypedField(1, 0);
		return retVal;
    }



    /**
     * Returns
     * TXA-2: "Document Type" - creates it if necessary
     */
    public IS getDocumentType() { 
		IS retVal = this.getTypedField(2, 0);
		return retVal;
    }
    
    /**
     * Returns
     * TXA-2: "Document Type" - creates it if necessary
     */
    public IS getTxa2_DocumentType() { 
		IS retVal = this.getTypedField(2, 0);
		return retVal;
    }



    /**
     * Returns
     * TXA-3: "Document Content Presentation" - creates it if necessary
     */
    public ID getDocumentContentPresentation() { 
		ID retVal = this.getTypedField(3, 0);
		return retVal;
    }
    
    /**
     * Returns
     * TXA-3: "Document Content Presentation" - creates it if necessary
     */
    public ID getTxa3_DocumentContentPresentation() { 
		ID retVal = this.getTypedField(3, 0);
		return retVal;
    }



    /**
     * Returns
     * TXA-4: "Activity Date/Time" - creates it if necessary
     */
    public DTM getActivityDateTime() { 
		DTM retVal = this.getTypedField(4, 0);
		return retVal;
    }
    
    /**
     * Returns
     * TXA-4: "Activity Date/Time" - creates it if necessary
     */
    public DTM getTxa4_ActivityDateTime() { 
		DTM retVal = this.getTypedField(4, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Primary Activity Provider Code/Name (TXA-5).
     */
    public XCN[] getPrimaryActivityProviderCodeName() {
    	XCN[] retVal = this.getTypedField(5, new XCN[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Primary Activity Provider Code/Name (TXA-5).
     */
    public XCN[] getTxa5_PrimaryActivityProviderCodeName() {
    	XCN[] retVal = this.getTypedField(5, new XCN[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Primary Activity Provider Code/Name (TXA-5).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getPrimaryActivityProviderCodeNameReps() {
    	return this.getReps(5);
    }


    /**
     * Returns a specific repetition of
     * TXA-5: "Primary Activity Provider Code/Name" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XCN getPrimaryActivityProviderCodeName(int rep) { 
		XCN retVal = this.getTypedField(5, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * TXA-5: "Primary Activity Provider Code/Name" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XCN getTxa5_PrimaryActivityProviderCodeName(int rep) { 
		XCN retVal = this.getTypedField(5, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Primary Activity Provider Code/Name (TXA-5).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getTxa5_PrimaryActivityProviderCodeNameReps() {
    	return this.getReps(5);
    }


    /**
     * Inserts a repetition of
     * TXA-5: "Primary Activity Provider Code/Name" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XCN insertPrimaryActivityProviderCodeName(int rep) throws HL7Exception { 
        return (XCN) super.insertRepetition(5, rep);
    }


    /**
     * Inserts a repetition of
     * TXA-5: "Primary Activity Provider Code/Name" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XCN insertTxa5_PrimaryActivityProviderCodeName(int rep) throws HL7Exception { 
        return (XCN) super.insertRepetition(5, rep);
    }


    /**
     * Removes a repetition of
     * TXA-5: "Primary Activity Provider Code/Name" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XCN removePrimaryActivityProviderCodeName(int rep) throws HL7Exception { 
        return (XCN) super.removeRepetition(5, rep);
    }


    /**
     * Removes a repetition of
     * TXA-5: "Primary Activity Provider Code/Name" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XCN removeTxa5_PrimaryActivityProviderCodeName(int rep) throws HL7Exception { 
        return (XCN) super.removeRepetition(5, rep);
    }




    /**
     * Returns
     * TXA-6: "Origination Date/Time" - creates it if necessary
     */
    public DTM getOriginationDateTime() { 
		DTM retVal = this.getTypedField(6, 0);
		return retVal;
    }
    
    /**
     * Returns
     * TXA-6: "Origination Date/Time" - creates it if necessary
     */
    public DTM getTxa6_OriginationDateTime() { 
		DTM retVal = this.getTypedField(6, 0);
		return retVal;
    }



    /**
     * Returns
     * TXA-7: "Transcription Date/Time" - creates it if necessary
     */
    public DTM getTranscriptionDateTime() { 
		DTM retVal = this.getTypedField(7, 0);
		return retVal;
    }
    
    /**
     * Returns
     * TXA-7: "Transcription Date/Time" - creates it if necessary
     */
    public DTM getTxa7_TranscriptionDateTime() { 
		DTM retVal = this.getTypedField(7, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Edit Date/Time (TXA-8).
     */
    public DTM[] getEditDateTime() {
    	DTM[] retVal = this.getTypedField(8, new DTM[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Edit Date/Time (TXA-8).
     */
    public DTM[] getTxa8_EditDateTime() {
    	DTM[] retVal = this.getTypedField(8, new DTM[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Edit Date/Time (TXA-8).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getEditDateTimeReps() {
    	return this.getReps(8);
    }


    /**
     * Returns a specific repetition of
     * TXA-8: "Edit Date/Time" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public DTM getEditDateTime(int rep) { 
		DTM retVal = this.getTypedField(8, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * TXA-8: "Edit Date/Time" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public DTM getTxa8_EditDateTime(int rep) { 
		DTM retVal = this.getTypedField(8, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Edit Date/Time (TXA-8).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getTxa8_EditDateTimeReps() {
    	return this.getReps(8);
    }


    /**
     * Inserts a repetition of
     * TXA-8: "Edit Date/Time" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public DTM insertEditDateTime(int rep) throws HL7Exception { 
        return (DTM) super.insertRepetition(8, rep);
    }


    /**
     * Inserts a repetition of
     * TXA-8: "Edit Date/Time" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public DTM insertTxa8_EditDateTime(int rep) throws HL7Exception { 
        return (DTM) super.insertRepetition(8, rep);
    }


    /**
     * Removes a repetition of
     * TXA-8: "Edit Date/Time" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public DTM removeEditDateTime(int rep) throws HL7Exception { 
        return (DTM) super.removeRepetition(8, rep);
    }


    /**
     * Removes a repetition of
     * TXA-8: "Edit Date/Time" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public DTM removeTxa8_EditDateTime(int rep) throws HL7Exception { 
        return (DTM) super.removeRepetition(8, rep);
    }



    /**
     * Returns all repetitions of Originator Code/Name (TXA-9).
     */
    public XCN[] getOriginatorCodeName() {
    	XCN[] retVal = this.getTypedField(9, new XCN[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Originator Code/Name (TXA-9).
     */
    public XCN[] getTxa9_OriginatorCodeName() {
    	XCN[] retVal = this.getTypedField(9, new XCN[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Originator Code/Name (TXA-9).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getOriginatorCodeNameReps() {
    	return this.getReps(9);
    }


    /**
     * Returns a specific repetition of
     * TXA-9: "Originator Code/Name" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XCN getOriginatorCodeName(int rep) { 
		XCN retVal = this.getTypedField(9, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * TXA-9: "Originator Code/Name" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XCN getTxa9_OriginatorCodeName(int rep) { 
		XCN retVal = this.getTypedField(9, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Originator Code/Name (TXA-9).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getTxa9_OriginatorCodeNameReps() {
    	return this.getReps(9);
    }


    /**
     * Inserts a repetition of
     * TXA-9: "Originator Code/Name" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XCN insertOriginatorCodeName(int rep) throws HL7Exception { 
        return (XCN) super.insertRepetition(9, rep);
    }


    /**
     * Inserts a repetition of
     * TXA-9: "Originator Code/Name" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XCN insertTxa9_OriginatorCodeName(int rep) throws HL7Exception { 
        return (XCN) super.insertRepetition(9, rep);
    }


    /**
     * Removes a repetition of
     * TXA-9: "Originator Code/Name" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XCN removeOriginatorCodeName(int rep) throws HL7Exception { 
        return (XCN) super.removeRepetition(9, rep);
    }


    /**
     * Removes a repetition of
     * TXA-9: "Originator Code/Name" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XCN removeTxa9_OriginatorCodeName(int rep) throws HL7Exception { 
        return (XCN) super.removeRepetition(9, rep);
    }



    /**
     * Returns all repetitions of Assigned Document Authenticator (TXA-10).
     */
    public XCN[] getAssignedDocumentAuthenticator() {
    	XCN[] retVal = this.getTypedField(10, new XCN[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Assigned Document Authenticator (TXA-10).
     */
    public XCN[] getTxa10_AssignedDocumentAuthenticator() {
    	XCN[] retVal = this.getTypedField(10, new XCN[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Assigned Document Authenticator (TXA-10).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getAssignedDocumentAuthenticatorReps() {
    	return this.getReps(10);
    }


    /**
     * Returns a specific repetition of
     * TXA-10: "Assigned Document Authenticator" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XCN getAssignedDocumentAuthenticator(int rep) { 
		XCN retVal = this.getTypedField(10, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * TXA-10: "Assigned Document Authenticator" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XCN getTxa10_AssignedDocumentAuthenticator(int rep) { 
		XCN retVal = this.getTypedField(10, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Assigned Document Authenticator (TXA-10).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getTxa10_AssignedDocumentAuthenticatorReps() {
    	return this.getReps(10);
    }


    /**
     * Inserts a repetition of
     * TXA-10: "Assigned Document Authenticator" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XCN insertAssignedDocumentAuthenticator(int rep) throws HL7Exception { 
        return (XCN) super.insertRepetition(10, rep);
    }


    /**
     * Inserts a repetition of
     * TXA-10: "Assigned Document Authenticator" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XCN insertTxa10_AssignedDocumentAuthenticator(int rep) throws HL7Exception { 
        return (XCN) super.insertRepetition(10, rep);
    }


    /**
     * Removes a repetition of
     * TXA-10: "Assigned Document Authenticator" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XCN removeAssignedDocumentAuthenticator(int rep) throws HL7Exception { 
        return (XCN) super.removeRepetition(10, rep);
    }


    /**
     * Removes a repetition of
     * TXA-10: "Assigned Document Authenticator" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XCN removeTxa10_AssignedDocumentAuthenticator(int rep) throws HL7Exception { 
        return (XCN) super.removeRepetition(10, rep);
    }



    /**
     * Returns all repetitions of Transcriptionist Code/Name (TXA-11).
     */
    public XCN[] getTranscriptionistCodeName() {
    	XCN[] retVal = this.getTypedField(11, new XCN[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Transcriptionist Code/Name (TXA-11).
     */
    public XCN[] getTxa11_TranscriptionistCodeName() {
    	XCN[] retVal = this.getTypedField(11, new XCN[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Transcriptionist Code/Name (TXA-11).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getTranscriptionistCodeNameReps() {
    	return this.getReps(11);
    }


    /**
     * Returns a specific repetition of
     * TXA-11: "Transcriptionist Code/Name" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XCN getTranscriptionistCodeName(int rep) { 
		XCN retVal = this.getTypedField(11, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * TXA-11: "Transcriptionist Code/Name" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XCN getTxa11_TranscriptionistCodeName(int rep) { 
		XCN retVal = this.getTypedField(11, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Transcriptionist Code/Name (TXA-11).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getTxa11_TranscriptionistCodeNameReps() {
    	return this.getReps(11);
    }


    /**
     * Inserts a repetition of
     * TXA-11: "Transcriptionist Code/Name" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XCN insertTranscriptionistCodeName(int rep) throws HL7Exception { 
        return (XCN) super.insertRepetition(11, rep);
    }


    /**
     * Inserts a repetition of
     * TXA-11: "Transcriptionist Code/Name" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XCN insertTxa11_TranscriptionistCodeName(int rep) throws HL7Exception { 
        return (XCN) super.insertRepetition(11, rep);
    }


    /**
     * Removes a repetition of
     * TXA-11: "Transcriptionist Code/Name" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XCN removeTranscriptionistCodeName(int rep) throws HL7Exception { 
        return (XCN) super.removeRepetition(11, rep);
    }


    /**
     * Removes a repetition of
     * TXA-11: "Transcriptionist Code/Name" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XCN removeTxa11_TranscriptionistCodeName(int rep) throws HL7Exception { 
        return (XCN) super.removeRepetition(11, rep);
    }




    /**
     * Returns
     * TXA-12: "Unique Document Number" - creates it if necessary
     */
    public EI getUniqueDocumentNumber() { 
		EI retVal = this.getTypedField(12, 0);
		return retVal;
    }
    
    /**
     * Returns
     * TXA-12: "Unique Document Number" - creates it if necessary
     */
    public EI getTxa12_UniqueDocumentNumber() { 
		EI retVal = this.getTypedField(12, 0);
		return retVal;
    }



    /**
     * Returns
     * TXA-13: "Parent Document Number" - creates it if necessary
     */
    public EI getParentDocumentNumber() { 
		EI retVal = this.getTypedField(13, 0);
		return retVal;
    }
    
    /**
     * Returns
     * TXA-13: "Parent Document Number" - creates it if necessary
     */
    public EI getTxa13_ParentDocumentNumber() { 
		EI retVal = this.getTypedField(13, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Placer Order Number (TXA-14).
     */
    public EI[] getPlacerOrderNumber() {
    	EI[] retVal = this.getTypedField(14, new EI[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Placer Order Number (TXA-14).
     */
    public EI[] getTxa14_PlacerOrderNumber() {
    	EI[] retVal = this.getTypedField(14, new EI[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Placer Order Number (TXA-14).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getPlacerOrderNumberReps() {
    	return this.getReps(14);
    }


    /**
     * Returns a specific repetition of
     * TXA-14: "Placer Order Number" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public EI getPlacerOrderNumber(int rep) { 
		EI retVal = this.getTypedField(14, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * TXA-14: "Placer Order Number" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public EI getTxa14_PlacerOrderNumber(int rep) { 
		EI retVal = this.getTypedField(14, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Placer Order Number (TXA-14).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getTxa14_PlacerOrderNumberReps() {
    	return this.getReps(14);
    }


    /**
     * Inserts a repetition of
     * TXA-14: "Placer Order Number" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public EI insertPlacerOrderNumber(int rep) throws HL7Exception { 
        return (EI) super.insertRepetition(14, rep);
    }


    /**
     * Inserts a repetition of
     * TXA-14: "Placer Order Number" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public EI insertTxa14_PlacerOrderNumber(int rep) throws HL7Exception { 
        return (EI) super.insertRepetition(14, rep);
    }


    /**
     * Removes a repetition of
     * TXA-14: "Placer Order Number" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public EI removePlacerOrderNumber(int rep) throws HL7Exception { 
        return (EI) super.removeRepetition(14, rep);
    }


    /**
     * Removes a repetition of
     * TXA-14: "Placer Order Number" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public EI removeTxa14_PlacerOrderNumber(int rep) throws HL7Exception { 
        return (EI) super.removeRepetition(14, rep);
    }




    /**
     * Returns
     * TXA-15: "Filler Order Number" - creates it if necessary
     */
    public EI getFillerOrderNumber() { 
		EI retVal = this.getTypedField(15, 0);
		return retVal;
    }
    
    /**
     * Returns
     * TXA-15: "Filler Order Number" - creates it if necessary
     */
    public EI getTxa15_FillerOrderNumber() { 
		EI retVal = this.getTypedField(15, 0);
		return retVal;
    }



    /**
     * Returns
     * TXA-16: "Unique Document File Name" - creates it if necessary
     */
    public ST getUniqueDocumentFileName() { 
		ST retVal = this.getTypedField(16, 0);
		return retVal;
    }
    
    /**
     * Returns
     * TXA-16: "Unique Document File Name" - creates it if necessary
     */
    public ST getTxa16_UniqueDocumentFileName() { 
		ST retVal = this.getTypedField(16, 0);
		return retVal;
    }



    /**
     * Returns
     * TXA-17: "Document Completion Status" - creates it if necessary
     */
    public ID getDocumentCompletionStatus() { 
		ID retVal = this.getTypedField(17, 0);
		return retVal;
    }
    
    /**
     * Returns
     * TXA-17: "Document Completion Status" - creates it if necessary
     */
    public ID getTxa17_DocumentCompletionStatus() { 
		ID retVal = this.getTypedField(17, 0);
		return retVal;
    }



    /**
     * Returns
     * TXA-18: "Document Confidentiality Status" - creates it if necessary
     */
    public ID getDocumentConfidentialityStatus() { 
		ID retVal = this.getTypedField(18, 0);
		return retVal;
    }
    
    /**
     * Returns
     * TXA-18: "Document Confidentiality Status" - creates it if necessary
     */
    public ID getTxa18_DocumentConfidentialityStatus() { 
		ID retVal = this.getTypedField(18, 0);
		return retVal;
    }



    /**
     * Returns
     * TXA-19: "Document Availability Status" - creates it if necessary
     */
    public ID getDocumentAvailabilityStatus() { 
		ID retVal = this.getTypedField(19, 0);
		return retVal;
    }
    
    /**
     * Returns
     * TXA-19: "Document Availability Status" - creates it if necessary
     */
    public ID getTxa19_DocumentAvailabilityStatus() { 
		ID retVal = this.getTypedField(19, 0);
		return retVal;
    }



    /**
     * Returns
     * TXA-20: "Document Storage Status" - creates it if necessary
     */
    public ID getDocumentStorageStatus() { 
		ID retVal = this.getTypedField(20, 0);
		return retVal;
    }
    
    /**
     * Returns
     * TXA-20: "Document Storage Status" - creates it if necessary
     */
    public ID getTxa20_DocumentStorageStatus() { 
		ID retVal = this.getTypedField(20, 0);
		return retVal;
    }



    /**
     * Returns
     * TXA-21: "Document Change Reason" - creates it if necessary
     */
    public ST getDocumentChangeReason() { 
		ST retVal = this.getTypedField(21, 0);
		return retVal;
    }
    
    /**
     * Returns
     * TXA-21: "Document Change Reason" - creates it if necessary
     */
    public ST getTxa21_DocumentChangeReason() { 
		ST retVal = this.getTypedField(21, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Authentication Person, Time Stamp (set) (TXA-22).
     */
    public PPN[] getAuthenticationPersonTimeStampSet() {
    	PPN[] retVal = this.getTypedField(22, new PPN[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Authentication Person, Time Stamp (set) (TXA-22).
     */
    public PPN[] getTxa22_AuthenticationPersonTimeStampSet() {
    	PPN[] retVal = this.getTypedField(22, new PPN[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Authentication Person, Time Stamp (set) (TXA-22).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getAuthenticationPersonTimeStampSetReps() {
    	return this.getReps(22);
    }


    /**
     * Returns a specific repetition of
     * TXA-22: "Authentication Person, Time Stamp (set)" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public PPN getAuthenticationPersonTimeStampSet(int rep) { 
		PPN retVal = this.getTypedField(22, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * TXA-22: "Authentication Person, Time Stamp (set)" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public PPN getTxa22_AuthenticationPersonTimeStampSet(int rep) { 
		PPN retVal = this.getTypedField(22, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Authentication Person, Time Stamp (set) (TXA-22).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getTxa22_AuthenticationPersonTimeStampSetReps() {
    	return this.getReps(22);
    }


    /**
     * Inserts a repetition of
     * TXA-22: "Authentication Person, Time Stamp (set)" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public PPN insertAuthenticationPersonTimeStampSet(int rep) throws HL7Exception { 
        return (PPN) super.insertRepetition(22, rep);
    }


    /**
     * Inserts a repetition of
     * TXA-22: "Authentication Person, Time Stamp (set)" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public PPN insertTxa22_AuthenticationPersonTimeStampSet(int rep) throws HL7Exception { 
        return (PPN) super.insertRepetition(22, rep);
    }


    /**
     * Removes a repetition of
     * TXA-22: "Authentication Person, Time Stamp (set)" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public PPN removeAuthenticationPersonTimeStampSet(int rep) throws HL7Exception { 
        return (PPN) super.removeRepetition(22, rep);
    }


    /**
     * Removes a repetition of
     * TXA-22: "Authentication Person, Time Stamp (set)" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public PPN removeTxa22_AuthenticationPersonTimeStampSet(int rep) throws HL7Exception { 
        return (PPN) super.removeRepetition(22, rep);
    }



    /**
     * Returns all repetitions of Distributed Copies (Code and Name of Recipient(s) ) (TXA-23).
     */
    public XCN[] getDistributedCopiesCodeandNameofRecipients() {
    	XCN[] retVal = this.getTypedField(23, new XCN[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Distributed Copies (Code and Name of Recipient(s) ) (TXA-23).
     */
    public XCN[] getTxa23_DistributedCopiesCodeandNameofRecipients() {
    	XCN[] retVal = this.getTypedField(23, new XCN[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Distributed Copies (Code and Name of Recipient(s) ) (TXA-23).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getDistributedCopiesCodeandNameofRecipientsReps() {
    	return this.getReps(23);
    }


    /**
     * Returns a specific repetition of
     * TXA-23: "Distributed Copies (Code and Name of Recipient(s) )" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XCN getDistributedCopiesCodeandNameofRecipients(int rep) { 
		XCN retVal = this.getTypedField(23, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * TXA-23: "Distributed Copies (Code and Name of Recipient(s) )" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XCN getTxa23_DistributedCopiesCodeandNameofRecipients(int rep) { 
		XCN retVal = this.getTypedField(23, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Distributed Copies (Code and Name of Recipient(s) ) (TXA-23).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getTxa23_DistributedCopiesCodeandNameofRecipientsReps() {
    	return this.getReps(23);
    }


    /**
     * Inserts a repetition of
     * TXA-23: "Distributed Copies (Code and Name of Recipient(s) )" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XCN insertDistributedCopiesCodeandNameofRecipients(int rep) throws HL7Exception { 
        return (XCN) super.insertRepetition(23, rep);
    }


    /**
     * Inserts a repetition of
     * TXA-23: "Distributed Copies (Code and Name of Recipient(s) )" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XCN insertTxa23_DistributedCopiesCodeandNameofRecipients(int rep) throws HL7Exception { 
        return (XCN) super.insertRepetition(23, rep);
    }


    /**
     * Removes a repetition of
     * TXA-23: "Distributed Copies (Code and Name of Recipient(s) )" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XCN removeDistributedCopiesCodeandNameofRecipients(int rep) throws HL7Exception { 
        return (XCN) super.removeRepetition(23, rep);
    }


    /**
     * Removes a repetition of
     * TXA-23: "Distributed Copies (Code and Name of Recipient(s) )" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XCN removeTxa23_DistributedCopiesCodeandNameofRecipients(int rep) throws HL7Exception { 
        return (XCN) super.removeRepetition(23, rep);
    }






    /** {@inheritDoc} */   
    protected Type createNewTypeWithoutReflection(int field) {
       switch (field) {
          case 0: return new SI(getMessage());
          case 1: return new IS(getMessage(), new Integer( 270 ));
          case 2: return new ID(getMessage(), new Integer( 191 ));
          case 3: return new DTM(getMessage());
          case 4: return new XCN(getMessage());
          case 5: return new DTM(getMessage());
          case 6: return new DTM(getMessage());
          case 7: return new DTM(getMessage());
          case 8: return new XCN(getMessage());
          case 9: return new XCN(getMessage());
          case 10: return new XCN(getMessage());
          case 11: return new EI(getMessage());
          case 12: return new EI(getMessage());
          case 13: return new EI(getMessage());
          case 14: return new EI(getMessage());
          case 15: return new ST(getMessage());
          case 16: return new ID(getMessage(), new Integer( 271 ));
          case 17: return new ID(getMessage(), new Integer( 272 ));
          case 18: return new ID(getMessage(), new Integer( 273 ));
          case 19: return new ID(getMessage(), new Integer( 275 ));
          case 20: return new ST(getMessage());
          case 21: return new PPN(getMessage());
          case 22: return new XCN(getMessage());
          default: return null;
       }
   }


}

