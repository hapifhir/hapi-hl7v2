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
 *<p>Represents an HL7 MSH message segment (Message header segment). 
 * This segment has the following fields:</p>
 * <ul>
     * <li>MSH-1: Field Separator (ST) <b> </b>
     * <li>MSH-2: Encoding Characters (ST) <b> </b>
     * <li>MSH-3: Sending Application (HD) <b>optional </b>
     * <li>MSH-4: Sending Facility (HD) <b>optional </b>
     * <li>MSH-5: Receiving Application (HD) <b>optional </b>
     * <li>MSH-6: Receiving Facility (HD) <b>optional </b>
     * <li>MSH-7: Date / Time of Message (TS) <b>optional </b>
     * <li>MSH-8: Security (ST) <b>optional </b>
     * <li>MSH-9: Message Type (CM_MSG) <b> </b>
     * <li>MSH-10: Message Control ID (ST) <b> </b>
     * <li>MSH-11: Processing ID (PT) <b> </b>
     * <li>MSH-12: Version ID (ID) <b> </b>
     * <li>MSH-13: Sequence Number (NM) <b>optional </b>
     * <li>MSH-14: Continuation Pointer (ST) <b>optional </b>
     * <li>MSH-15: Accept Acknowledgement Type (ID) <b>optional </b>
     * <li>MSH-16: Application Acknowledgement Type (ID) <b>optional </b>
     * <li>MSH-17: Country Code (ID) <b>optional </b>
     * <li>MSH-18: Character Set (ID) <b>optional </b>
     * <li>MSH-19: Principal Language of Message (CE) <b>optional </b>
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
                                  this.add(HD.class, false, 1, 180, new Object[]{ getMessage() }, "Sending Application");
                                  this.add(HD.class, false, 1, 180, new Object[]{ getMessage() }, "Sending Facility");
                                  this.add(HD.class, false, 1, 180, new Object[]{ getMessage() }, "Receiving Application");
                                  this.add(HD.class, false, 1, 180, new Object[]{ getMessage() }, "Receiving Facility");
                                  this.add(TS.class, false, 1, 26, new Object[]{ getMessage() }, "Date / Time of Message");
                                  this.add(ST.class, false, 1, 40, new Object[]{ getMessage() }, "Security");
                                  this.add(CM_MSG.class, true, 1, 7, new Object[]{ getMessage() }, "Message Type");
                                  this.add(ST.class, true, 1, 20, new Object[]{ getMessage() }, "Message Control ID");
                                  this.add(PT.class, true, 1, 3, new Object[]{ getMessage() }, "Processing ID");
                                              this.add(ID.class, true, 1, 8, new Object[]{ getMessage(), new Integer(104) }, "Version ID");
                                  this.add(NM.class, false, 1, 15, new Object[]{ getMessage() }, "Sequence Number");
                                  this.add(ST.class, false, 1, 180, new Object[]{ getMessage() }, "Continuation Pointer");
                                              this.add(ID.class, false, 1, 2, new Object[]{ getMessage(), new Integer(155) }, "Accept Acknowledgement Type");
                                              this.add(ID.class, false, 1, 2, new Object[]{ getMessage(), new Integer(155) }, "Application Acknowledgement Type");
                                              this.add(ID.class, false, 1, 2, new Object[]{ getMessage(), new Integer(0) }, "Country Code");
                                              this.add(ID.class, false, 1, 6, new Object[]{ getMessage(), new Integer(211) }, "Character Set");
                                  this.add(CE.class, false, 1, 3, new Object[]{ getMessage() }, "Principal Language of Message");
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
     * MSH-7: "Date / Time of Message" - creates it if necessary
     */
    public TS getDateTimeOfMessage() { 
		TS retVal = this.getTypedField(7, 0);
		return retVal;
    }
    
    /**
     * Returns
     * MSH-7: "Date / Time of Message" - creates it if necessary
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
    public CM_MSG getMessageType() { 
		CM_MSG retVal = this.getTypedField(9, 0);
		return retVal;
    }
    
    /**
     * Returns
     * MSH-9: "Message Type" - creates it if necessary
     */
    public CM_MSG getMsh9_MessageType() { 
		CM_MSG retVal = this.getTypedField(9, 0);
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
    public ID getVersionID() { 
		ID retVal = this.getTypedField(12, 0);
		return retVal;
    }
    
    /**
     * Returns
     * MSH-12: "Version ID" - creates it if necessary
     */
    public ID getMsh12_VersionID() { 
		ID retVal = this.getTypedField(12, 0);
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
     * MSH-15: "Accept Acknowledgement Type" - creates it if necessary
     */
    public ID getAcceptAcknowledgementType() { 
		ID retVal = this.getTypedField(15, 0);
		return retVal;
    }
    
    /**
     * Returns
     * MSH-15: "Accept Acknowledgement Type" - creates it if necessary
     */
    public ID getMsh15_AcceptAcknowledgementType() { 
		ID retVal = this.getTypedField(15, 0);
		return retVal;
    }



    /**
     * Returns
     * MSH-16: "Application Acknowledgement Type" - creates it if necessary
     */
    public ID getApplicationAcknowledgementType() { 
		ID retVal = this.getTypedField(16, 0);
		return retVal;
    }
    
    /**
     * Returns
     * MSH-16: "Application Acknowledgement Type" - creates it if necessary
     */
    public ID getMsh16_ApplicationAcknowledgementType() { 
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
     * Returns
     * MSH-18: "Character Set" - creates it if necessary
     */
    public ID getCharacterSet() { 
		ID retVal = this.getTypedField(18, 0);
		return retVal;
    }
    
    /**
     * Returns
     * MSH-18: "Character Set" - creates it if necessary
     */
    public ID getMsh18_CharacterSet() { 
		ID retVal = this.getTypedField(18, 0);
		return retVal;
    }



    /**
     * Returns
     * MSH-19: "Principal Language of Message" - creates it if necessary
     */
    public CE getPrincipalLanguageOfMessage() { 
		CE retVal = this.getTypedField(19, 0);
		return retVal;
    }
    
    /**
     * Returns
     * MSH-19: "Principal Language of Message" - creates it if necessary
     */
    public CE getMsh19_PrincipalLanguageOfMessage() { 
		CE retVal = this.getTypedField(19, 0);
		return retVal;
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
          case 8: return new CM_MSG(getMessage());
          case 9: return new ST(getMessage());
          case 10: return new PT(getMessage());
          case 11: return new ID(getMessage(), new Integer( 104 ));
          case 12: return new NM(getMessage());
          case 13: return new ST(getMessage());
          case 14: return new ID(getMessage(), new Integer( 155 ));
          case 15: return new ID(getMessage(), new Integer( 155 ));
          case 16: return new ID(getMessage(), new Integer( 0 ));
          case 17: return new ID(getMessage(), new Integer( 211 ));
          case 18: return new CE(getMessage());
          default: return null;
       }
   }


}

