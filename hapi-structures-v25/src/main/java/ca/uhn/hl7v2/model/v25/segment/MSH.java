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
 *<p>Represents an HL7 MSH message segment (Message Header). 
 * This segment has the following fields:</p>
 * <ul>
     * <li>MSH-1: Field Separator (ST) <b> </b>
     * <li>MSH-2: Encoding Characters (ST) <b> </b>
     * <li>MSH-3: Sending Application (HD) <b>optional </b>
     * <li>MSH-4: Sending Facility (HD) <b>optional </b>
     * <li>MSH-5: Receiving Application (HD) <b>optional </b>
     * <li>MSH-6: Receiving Facility (HD) <b>optional </b>
     * <li>MSH-7: Date/Time Of Message (TS) <b> </b>
     * <li>MSH-8: Security (ST) <b>optional </b>
     * <li>MSH-9: Message Type (MSG) <b> </b>
     * <li>MSH-10: Message Control ID (ST) <b> </b>
     * <li>MSH-11: Processing ID (PT) <b> </b>
     * <li>MSH-12: Version ID (VID) <b> </b>
     * <li>MSH-13: Sequence Number (NM) <b>optional </b>
     * <li>MSH-14: Continuation Pointer (ST) <b>optional </b>
     * <li>MSH-15: Accept Acknowledgment Type (ID) <b>optional </b>
     * <li>MSH-16: Application Acknowledgment Type (ID) <b>optional </b>
     * <li>MSH-17: Country Code (ID) <b>optional </b>
     * <li>MSH-18: Character Set (ID) <b>optional repeating</b>
     * <li>MSH-19: Principal Language Of Message (CE) <b>optional </b>
     * <li>MSH-20: Alternate Character Set Handling Scheme (ID) <b>optional </b>
     * <li>MSH-21: Message Profile Identifier (EI) <b>optional repeating</b>
 * </ul>
 */
@SuppressWarnings("unused")
public class MSH extends AbstractSegment {

    /** 
     * Creates a new MSH segment
     */
    public MSH(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(ST.class, true, 1, 1, new Object[]{ getMessage() }, "Field Separator");
                                  this.add(ST.class, true, 1, 4, new Object[]{ getMessage() }, "Encoding Characters");
                                  this.add(HD.class, false, 1, 227, new Object[]{ getMessage() }, "Sending Application");
                                  this.add(HD.class, false, 1, 227, new Object[]{ getMessage() }, "Sending Facility");
                                  this.add(HD.class, false, 1, 227, new Object[]{ getMessage() }, "Receiving Application");
                                  this.add(HD.class, false, 1, 227, new Object[]{ getMessage() }, "Receiving Facility");
                                  this.add(TS.class, true, 1, 26, new Object[]{ getMessage() }, "Date/Time Of Message");
                                  this.add(ST.class, false, 1, 40, new Object[]{ getMessage() }, "Security");
                                  this.add(MSG.class, true, 1, 15, new Object[]{ getMessage() }, "Message Type");
                                  this.add(ST.class, true, 1, 20, new Object[]{ getMessage() }, "Message Control ID");
                                  this.add(PT.class, true, 1, 3, new Object[]{ getMessage() }, "Processing ID");
                                  this.add(VID.class, true, 1, 60, new Object[]{ getMessage() }, "Version ID");
                                  this.add(NM.class, false, 1, 15, new Object[]{ getMessage() }, "Sequence Number");
                                  this.add(ST.class, false, 1, 180, new Object[]{ getMessage() }, "Continuation Pointer");
                                              this.add(ID.class, false, 1, 2, new Object[]{ getMessage(), new Integer(155) }, "Accept Acknowledgment Type");
                                              this.add(ID.class, false, 1, 2, new Object[]{ getMessage(), new Integer(155) }, "Application Acknowledgment Type");
                                              this.add(ID.class, false, 1, 3, new Object[]{ getMessage(), new Integer(399) }, "Country Code");
                                              this.add(ID.class, false, 0, 16, new Object[]{ getMessage(), new Integer(211) }, "Character Set");
                                  this.add(CE.class, false, 1, 250, new Object[]{ getMessage() }, "Principal Language Of Message");
                                              this.add(ID.class, false, 1, 20, new Object[]{ getMessage(), new Integer(356) }, "Alternate Character Set Handling Scheme");
                                  this.add(EI.class, false, 0, 427, new Object[]{ getMessage() }, "Message Profile Identifier");
       } catch(HL7Exception e) {
          log.error("Unexpected error creating MSH - this is probably a bug in the source code generator.", e);
       }
    }



    /**
     * Returns
     * MSH-1: "Field Separator" - creates it if necessary
     */
    public ST getFieldSeparator() { 
		ST retVal = this.getTypedField(1, 0);
		return retVal;
    }
    
    /**
     * Returns
     * MSH-1: "Field Separator" - creates it if necessary
     */
    public ST getMsh1_FieldSeparator() { 
		ST retVal = this.getTypedField(1, 0);
		return retVal;
    }



    /**
     * Returns
     * MSH-2: "Encoding Characters" - creates it if necessary
     */
    public ST getEncodingCharacters() { 
		ST retVal = this.getTypedField(2, 0);
		return retVal;
    }
    
    /**
     * Returns
     * MSH-2: "Encoding Characters" - creates it if necessary
     */
    public ST getMsh2_EncodingCharacters() { 
		ST retVal = this.getTypedField(2, 0);
		return retVal;
    }



    /**
     * Returns
     * MSH-3: "Sending Application" - creates it if necessary
     */
    public HD getSendingApplication() { 
		HD retVal = this.getTypedField(3, 0);
		return retVal;
    }
    
    /**
     * Returns
     * MSH-3: "Sending Application" - creates it if necessary
     */
    public HD getMsh3_SendingApplication() { 
		HD retVal = this.getTypedField(3, 0);
		return retVal;
    }



    /**
     * Returns
     * MSH-4: "Sending Facility" - creates it if necessary
     */
    public HD getSendingFacility() { 
		HD retVal = this.getTypedField(4, 0);
		return retVal;
    }
    
    /**
     * Returns
     * MSH-4: "Sending Facility" - creates it if necessary
     */
    public HD getMsh4_SendingFacility() { 
		HD retVal = this.getTypedField(4, 0);
		return retVal;
    }



    /**
     * Returns
     * MSH-5: "Receiving Application" - creates it if necessary
     */
    public HD getReceivingApplication() { 
		HD retVal = this.getTypedField(5, 0);
		return retVal;
    }
    
    /**
     * Returns
     * MSH-5: "Receiving Application" - creates it if necessary
     */
    public HD getMsh5_ReceivingApplication() { 
		HD retVal = this.getTypedField(5, 0);
		return retVal;
    }



    /**
     * Returns
     * MSH-6: "Receiving Facility" - creates it if necessary
     */
    public HD getReceivingFacility() { 
		HD retVal = this.getTypedField(6, 0);
		return retVal;
    }
    
    /**
     * Returns
     * MSH-6: "Receiving Facility" - creates it if necessary
     */
    public HD getMsh6_ReceivingFacility() { 
		HD retVal = this.getTypedField(6, 0);
		return retVal;
    }



    /**
     * Returns
     * MSH-7: "Date/Time Of Message" - creates it if necessary
     */
    public TS getDateTimeOfMessage() { 
		TS retVal = this.getTypedField(7, 0);
		return retVal;
    }
    
    /**
     * Returns
     * MSH-7: "Date/Time Of Message" - creates it if necessary
     */
    public TS getMsh7_DateTimeOfMessage() { 
		TS retVal = this.getTypedField(7, 0);
		return retVal;
    }



    /**
     * Returns
     * MSH-8: "Security" - creates it if necessary
     */
    public ST getSecurity() { 
		ST retVal = this.getTypedField(8, 0);
		return retVal;
    }
    
    /**
     * Returns
     * MSH-8: "Security" - creates it if necessary
     */
    public ST getMsh8_Security() { 
		ST retVal = this.getTypedField(8, 0);
		return retVal;
    }



    /**
     * Returns
     * MSH-9: "Message Type" - creates it if necessary
     */
    public MSG getMessageType() { 
		MSG retVal = this.getTypedField(9, 0);
		return retVal;
    }
    
    /**
     * Returns
     * MSH-9: "Message Type" - creates it if necessary
     */
    public MSG getMsh9_MessageType() { 
		MSG retVal = this.getTypedField(9, 0);
		return retVal;
    }



    /**
     * Returns
     * MSH-10: "Message Control ID" - creates it if necessary
     */
    public ST getMessageControlID() { 
		ST retVal = this.getTypedField(10, 0);
		return retVal;
    }
    
    /**
     * Returns
     * MSH-10: "Message Control ID" - creates it if necessary
     */
    public ST getMsh10_MessageControlID() { 
		ST retVal = this.getTypedField(10, 0);
		return retVal;
    }



    /**
     * Returns
     * MSH-11: "Processing ID" - creates it if necessary
     */
    public PT getProcessingID() { 
		PT retVal = this.getTypedField(11, 0);
		return retVal;
    }
    
    /**
     * Returns
     * MSH-11: "Processing ID" - creates it if necessary
     */
    public PT getMsh11_ProcessingID() { 
		PT retVal = this.getTypedField(11, 0);
		return retVal;
    }



    /**
     * Returns
     * MSH-12: "Version ID" - creates it if necessary
     */
    public VID getVersionID() { 
		VID retVal = this.getTypedField(12, 0);
		return retVal;
    }
    
    /**
     * Returns
     * MSH-12: "Version ID" - creates it if necessary
     */
    public VID getMsh12_VersionID() { 
		VID retVal = this.getTypedField(12, 0);
		return retVal;
    }



    /**
     * Returns
     * MSH-13: "Sequence Number" - creates it if necessary
     */
    public NM getSequenceNumber() { 
		NM retVal = this.getTypedField(13, 0);
		return retVal;
    }
    
    /**
     * Returns
     * MSH-13: "Sequence Number" - creates it if necessary
     */
    public NM getMsh13_SequenceNumber() { 
		NM retVal = this.getTypedField(13, 0);
		return retVal;
    }



    /**
     * Returns
     * MSH-14: "Continuation Pointer" - creates it if necessary
     */
    public ST getContinuationPointer() { 
		ST retVal = this.getTypedField(14, 0);
		return retVal;
    }
    
    /**
     * Returns
     * MSH-14: "Continuation Pointer" - creates it if necessary
     */
    public ST getMsh14_ContinuationPointer() { 
		ST retVal = this.getTypedField(14, 0);
		return retVal;
    }



    /**
     * Returns
     * MSH-15: "Accept Acknowledgment Type" - creates it if necessary
     */
    public ID getAcceptAcknowledgmentType() { 
		ID retVal = this.getTypedField(15, 0);
		return retVal;
    }
    
    /**
     * Returns
     * MSH-15: "Accept Acknowledgment Type" - creates it if necessary
     */
    public ID getMsh15_AcceptAcknowledgmentType() { 
		ID retVal = this.getTypedField(15, 0);
		return retVal;
    }



    /**
     * Returns
     * MSH-16: "Application Acknowledgment Type" - creates it if necessary
     */
    public ID getApplicationAcknowledgmentType() { 
		ID retVal = this.getTypedField(16, 0);
		return retVal;
    }
    
    /**
     * Returns
     * MSH-16: "Application Acknowledgment Type" - creates it if necessary
     */
    public ID getMsh16_ApplicationAcknowledgmentType() { 
		ID retVal = this.getTypedField(16, 0);
		return retVal;
    }



    /**
     * Returns
     * MSH-17: "Country Code" - creates it if necessary
     */
    public ID getCountryCode() { 
		ID retVal = this.getTypedField(17, 0);
		return retVal;
    }
    
    /**
     * Returns
     * MSH-17: "Country Code" - creates it if necessary
     */
    public ID getMsh17_CountryCode() { 
		ID retVal = this.getTypedField(17, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Character Set (MSH-18).
     */
    public ID[] getCharacterSet() {
    	ID[] retVal = this.getTypedField(18, new ID[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Character Set (MSH-18).
     */
    public ID[] getMsh18_CharacterSet() {
    	ID[] retVal = this.getTypedField(18, new ID[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Character Set (MSH-18).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getCharacterSetReps() {
    	return this.getReps(18);
    }


    /**
     * Returns a specific repetition of
     * MSH-18: "Character Set" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public ID getCharacterSet(int rep) { 
		ID retVal = this.getTypedField(18, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * MSH-18: "Character Set" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public ID getMsh18_CharacterSet(int rep) { 
		ID retVal = this.getTypedField(18, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Character Set (MSH-18).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getMsh18_CharacterSetReps() {
    	return this.getReps(18);
    }


    /**
     * Inserts a repetition of
     * MSH-18: "Character Set" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ID insertCharacterSet(int rep) throws HL7Exception { 
        return (ID) super.insertRepetition(18, rep);
    }


    /**
     * Inserts a repetition of
     * MSH-18: "Character Set" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ID insertMsh18_CharacterSet(int rep) throws HL7Exception { 
        return (ID) super.insertRepetition(18, rep);
    }


    /**
     * Removes a repetition of
     * MSH-18: "Character Set" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ID removeCharacterSet(int rep) throws HL7Exception { 
        return (ID) super.removeRepetition(18, rep);
    }


    /**
     * Removes a repetition of
     * MSH-18: "Character Set" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ID removeMsh18_CharacterSet(int rep) throws HL7Exception { 
        return (ID) super.removeRepetition(18, rep);
    }




    /**
     * Returns
     * MSH-19: "Principal Language Of Message" - creates it if necessary
     */
    public CE getPrincipalLanguageOfMessage() { 
		CE retVal = this.getTypedField(19, 0);
		return retVal;
    }
    
    /**
     * Returns
     * MSH-19: "Principal Language Of Message" - creates it if necessary
     */
    public CE getMsh19_PrincipalLanguageOfMessage() { 
		CE retVal = this.getTypedField(19, 0);
		return retVal;
    }



    /**
     * Returns
     * MSH-20: "Alternate Character Set Handling Scheme" - creates it if necessary
     */
    public ID getAlternateCharacterSetHandlingScheme() { 
		ID retVal = this.getTypedField(20, 0);
		return retVal;
    }
    
    /**
     * Returns
     * MSH-20: "Alternate Character Set Handling Scheme" - creates it if necessary
     */
    public ID getMsh20_AlternateCharacterSetHandlingScheme() { 
		ID retVal = this.getTypedField(20, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Message Profile Identifier (MSH-21).
     */
    public EI[] getMessageProfileIdentifier() {
    	EI[] retVal = this.getTypedField(21, new EI[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Message Profile Identifier (MSH-21).
     */
    public EI[] getMsh21_MessageProfileIdentifier() {
    	EI[] retVal = this.getTypedField(21, new EI[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Message Profile Identifier (MSH-21).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getMessageProfileIdentifierReps() {
    	return this.getReps(21);
    }


    /**
     * Returns a specific repetition of
     * MSH-21: "Message Profile Identifier" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public EI getMessageProfileIdentifier(int rep) { 
		EI retVal = this.getTypedField(21, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * MSH-21: "Message Profile Identifier" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public EI getMsh21_MessageProfileIdentifier(int rep) { 
		EI retVal = this.getTypedField(21, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Message Profile Identifier (MSH-21).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getMsh21_MessageProfileIdentifierReps() {
    	return this.getReps(21);
    }


    /**
     * Inserts a repetition of
     * MSH-21: "Message Profile Identifier" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public EI insertMessageProfileIdentifier(int rep) throws HL7Exception { 
        return (EI) super.insertRepetition(21, rep);
    }


    /**
     * Inserts a repetition of
     * MSH-21: "Message Profile Identifier" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public EI insertMsh21_MessageProfileIdentifier(int rep) throws HL7Exception { 
        return (EI) super.insertRepetition(21, rep);
    }


    /**
     * Removes a repetition of
     * MSH-21: "Message Profile Identifier" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public EI removeMessageProfileIdentifier(int rep) throws HL7Exception { 
        return (EI) super.removeRepetition(21, rep);
    }


    /**
     * Removes a repetition of
     * MSH-21: "Message Profile Identifier" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public EI removeMsh21_MessageProfileIdentifier(int rep) throws HL7Exception { 
        return (EI) super.removeRepetition(21, rep);
    }






    /** {@inheritDoc} */   
    protected Type createNewTypeWithoutReflection(int field) {
       switch (field) {
          case 0: return new ST(getMessage());
          case 1: return new ST(getMessage());
          case 2: return new HD(getMessage());
          case 3: return new HD(getMessage());
          case 4: return new HD(getMessage());
          case 5: return new HD(getMessage());
          case 6: return new TS(getMessage());
          case 7: return new ST(getMessage());
          case 8: return new MSG(getMessage());
          case 9: return new ST(getMessage());
          case 10: return new PT(getMessage());
          case 11: return new VID(getMessage());
          case 12: return new NM(getMessage());
          case 13: return new ST(getMessage());
          case 14: return new ID(getMessage(), new Integer( 155 ));
          case 15: return new ID(getMessage(), new Integer( 155 ));
          case 16: return new ID(getMessage(), new Integer( 399 ));
          case 17: return new ID(getMessage(), new Integer( 211 ));
          case 18: return new CE(getMessage());
          case 19: return new ID(getMessage(), new Integer( 356 ));
          case 20: return new EI(getMessage());
          default: return null;
       }
   }


}

