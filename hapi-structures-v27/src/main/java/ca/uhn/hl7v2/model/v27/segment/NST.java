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


package ca.uhn.hl7v2.model.v27.segment;

// import ca.uhn.hl7v2.model.v27.group.*;
import ca.uhn.hl7v2.model.v27.datatype.*;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.parser.DefaultModelClassFactory;
import ca.uhn.hl7v2.model.AbstractMessage;
import ca.uhn.hl7v2.model.Group;
import ca.uhn.hl7v2.model.Type;
import ca.uhn.hl7v2.model.AbstractSegment;
import ca.uhn.hl7v2.model.Varies;


/**
 *<p>Represents an HL7 NST message segment (Application control level statistics). 
 * This segment has the following fields:</p>
 * <ul>
     * <li>NST-1: Statistics Available (ID) <b> </b>
     * <li>NST-2: Source Identifier (ST) <b>optional </b>
     * <li>NST-3: Source Type (ID) <b>optional </b>
     * <li>NST-4: Statistics Start (DTM) <b>optional </b>
     * <li>NST-5: Statistics End (DTM) <b>optional </b>
     * <li>NST-6: Receive Character Count (NM) <b>optional </b>
     * <li>NST-7: Send Character Count (NM) <b>optional </b>
     * <li>NST-8: Messages Received (NM) <b>optional </b>
     * <li>NST-9: Messages Sent (NM) <b>optional </b>
     * <li>NST-10: Checksum Errors Received (NM) <b>optional </b>
     * <li>NST-11: Length Errors Received (NM) <b>optional </b>
     * <li>NST-12: Other Errors Received (NM) <b>optional </b>
     * <li>NST-13: Connect Timeouts (NM) <b>optional </b>
     * <li>NST-14: Receive Timeouts (NM) <b>optional </b>
     * <li>NST-15: Application control-level Errors (NM) <b>optional </b>
 * </ul>
 */
@SuppressWarnings("unused")
public class NST extends AbstractSegment {

    /** 
     * Creates a new NST segment
     */
    public NST(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                              this.add(ID.class, true, 1, 1, new Object[]{ getMessage(), new Integer(136) }, "Statistics Available");
                                  this.add(ST.class, false, 1, 0, new Object[]{ getMessage() }, "Source Identifier");
                                              this.add(ID.class, false, 1, 0, new Object[]{ getMessage(), new Integer(332) }, "Source Type");
                                  this.add(DTM.class, false, 1, 0, new Object[]{ getMessage() }, "Statistics Start");
                                  this.add(DTM.class, false, 1, 0, new Object[]{ getMessage() }, "Statistics End");
                                  this.add(NM.class, false, 1, 0, new Object[]{ getMessage() }, "Receive Character Count");
                                  this.add(NM.class, false, 1, 0, new Object[]{ getMessage() }, "Send Character Count");
                                  this.add(NM.class, false, 1, 0, new Object[]{ getMessage() }, "Messages Received");
                                  this.add(NM.class, false, 1, 0, new Object[]{ getMessage() }, "Messages Sent");
                                  this.add(NM.class, false, 1, 0, new Object[]{ getMessage() }, "Checksum Errors Received");
                                  this.add(NM.class, false, 1, 0, new Object[]{ getMessage() }, "Length Errors Received");
                                  this.add(NM.class, false, 1, 0, new Object[]{ getMessage() }, "Other Errors Received");
                                  this.add(NM.class, false, 1, 0, new Object[]{ getMessage() }, "Connect Timeouts");
                                  this.add(NM.class, false, 1, 0, new Object[]{ getMessage() }, "Receive Timeouts");
                                  this.add(NM.class, false, 1, 0, new Object[]{ getMessage() }, "Application control-level Errors");
       } catch(HL7Exception e) {
          log.error("Unexpected error creating NST - this is probably a bug in the source code generator.", e);
       }
    }



    /**
     * Returns
     * NST-1: "Statistics Available" - creates it if necessary
     */
    public ID getStatisticsAvailable() { 
		ID retVal = this.getTypedField(1, 0);
		return retVal;
    }
    
    /**
     * Returns
     * NST-1: "Statistics Available" - creates it if necessary
     */
    public ID getNst1_StatisticsAvailable() { 
		ID retVal = this.getTypedField(1, 0);
		return retVal;
    }



    /**
     * Returns
     * NST-2: "Source Identifier" - creates it if necessary
     */
    public ST getSourceIdentifier() { 
		ST retVal = this.getTypedField(2, 0);
		return retVal;
    }
    
    /**
     * Returns
     * NST-2: "Source Identifier" - creates it if necessary
     */
    public ST getNst2_SourceIdentifier() { 
		ST retVal = this.getTypedField(2, 0);
		return retVal;
    }



    /**
     * Returns
     * NST-3: "Source Type" - creates it if necessary
     */
    public ID getSourceType() { 
		ID retVal = this.getTypedField(3, 0);
		return retVal;
    }
    
    /**
     * Returns
     * NST-3: "Source Type" - creates it if necessary
     */
    public ID getNst3_SourceType() { 
		ID retVal = this.getTypedField(3, 0);
		return retVal;
    }



    /**
     * Returns
     * NST-4: "Statistics Start" - creates it if necessary
     */
    public DTM getStatisticsStart() { 
		DTM retVal = this.getTypedField(4, 0);
		return retVal;
    }
    
    /**
     * Returns
     * NST-4: "Statistics Start" - creates it if necessary
     */
    public DTM getNst4_StatisticsStart() { 
		DTM retVal = this.getTypedField(4, 0);
		return retVal;
    }



    /**
     * Returns
     * NST-5: "Statistics End" - creates it if necessary
     */
    public DTM getStatisticsEnd() { 
		DTM retVal = this.getTypedField(5, 0);
		return retVal;
    }
    
    /**
     * Returns
     * NST-5: "Statistics End" - creates it if necessary
     */
    public DTM getNst5_StatisticsEnd() { 
		DTM retVal = this.getTypedField(5, 0);
		return retVal;
    }



    /**
     * Returns
     * NST-6: "Receive Character Count" - creates it if necessary
     */
    public NM getReceiveCharacterCount() { 
		NM retVal = this.getTypedField(6, 0);
		return retVal;
    }
    
    /**
     * Returns
     * NST-6: "Receive Character Count" - creates it if necessary
     */
    public NM getNst6_ReceiveCharacterCount() { 
		NM retVal = this.getTypedField(6, 0);
		return retVal;
    }



    /**
     * Returns
     * NST-7: "Send Character Count" - creates it if necessary
     */
    public NM getSendCharacterCount() { 
		NM retVal = this.getTypedField(7, 0);
		return retVal;
    }
    
    /**
     * Returns
     * NST-7: "Send Character Count" - creates it if necessary
     */
    public NM getNst7_SendCharacterCount() { 
		NM retVal = this.getTypedField(7, 0);
		return retVal;
    }



    /**
     * Returns
     * NST-8: "Messages Received" - creates it if necessary
     */
    public NM getMessagesReceived() { 
		NM retVal = this.getTypedField(8, 0);
		return retVal;
    }
    
    /**
     * Returns
     * NST-8: "Messages Received" - creates it if necessary
     */
    public NM getNst8_MessagesReceived() { 
		NM retVal = this.getTypedField(8, 0);
		return retVal;
    }



    /**
     * Returns
     * NST-9: "Messages Sent" - creates it if necessary
     */
    public NM getMessagesSent() { 
		NM retVal = this.getTypedField(9, 0);
		return retVal;
    }
    
    /**
     * Returns
     * NST-9: "Messages Sent" - creates it if necessary
     */
    public NM getNst9_MessagesSent() { 
		NM retVal = this.getTypedField(9, 0);
		return retVal;
    }



    /**
     * Returns
     * NST-10: "Checksum Errors Received" - creates it if necessary
     */
    public NM getChecksumErrorsReceived() { 
		NM retVal = this.getTypedField(10, 0);
		return retVal;
    }
    
    /**
     * Returns
     * NST-10: "Checksum Errors Received" - creates it if necessary
     */
    public NM getNst10_ChecksumErrorsReceived() { 
		NM retVal = this.getTypedField(10, 0);
		return retVal;
    }



    /**
     * Returns
     * NST-11: "Length Errors Received" - creates it if necessary
     */
    public NM getLengthErrorsReceived() { 
		NM retVal = this.getTypedField(11, 0);
		return retVal;
    }
    
    /**
     * Returns
     * NST-11: "Length Errors Received" - creates it if necessary
     */
    public NM getNst11_LengthErrorsReceived() { 
		NM retVal = this.getTypedField(11, 0);
		return retVal;
    }



    /**
     * Returns
     * NST-12: "Other Errors Received" - creates it if necessary
     */
    public NM getOtherErrorsReceived() { 
		NM retVal = this.getTypedField(12, 0);
		return retVal;
    }
    
    /**
     * Returns
     * NST-12: "Other Errors Received" - creates it if necessary
     */
    public NM getNst12_OtherErrorsReceived() { 
		NM retVal = this.getTypedField(12, 0);
		return retVal;
    }



    /**
     * Returns
     * NST-13: "Connect Timeouts" - creates it if necessary
     */
    public NM getConnectTimeouts() { 
		NM retVal = this.getTypedField(13, 0);
		return retVal;
    }
    
    /**
     * Returns
     * NST-13: "Connect Timeouts" - creates it if necessary
     */
    public NM getNst13_ConnectTimeouts() { 
		NM retVal = this.getTypedField(13, 0);
		return retVal;
    }



    /**
     * Returns
     * NST-14: "Receive Timeouts" - creates it if necessary
     */
    public NM getReceiveTimeouts() { 
		NM retVal = this.getTypedField(14, 0);
		return retVal;
    }
    
    /**
     * Returns
     * NST-14: "Receive Timeouts" - creates it if necessary
     */
    public NM getNst14_ReceiveTimeouts() { 
		NM retVal = this.getTypedField(14, 0);
		return retVal;
    }



    /**
     * Returns
     * NST-15: "Application control-level Errors" - creates it if necessary
     */
    public NM getApplicationControlLevelErrors() { 
		NM retVal = this.getTypedField(15, 0);
		return retVal;
    }
    
    /**
     * Returns
     * NST-15: "Application control-level Errors" - creates it if necessary
     */
    public NM getNst15_ApplicationControlLevelErrors() { 
		NM retVal = this.getTypedField(15, 0);
		return retVal;
    }





    /** {@inheritDoc} */   
    protected Type createNewTypeWithoutReflection(int field) {
       switch (field) {
          case 0: return new ID(getMessage(), new Integer( 136 ));
          case 1: return new ST(getMessage());
          case 2: return new ID(getMessage(), new Integer( 332 ));
          case 3: return new DTM(getMessage());
          case 4: return new DTM(getMessage());
          case 5: return new NM(getMessage());
          case 6: return new NM(getMessage());
          case 7: return new NM(getMessage());
          case 8: return new NM(getMessage());
          case 9: return new NM(getMessage());
          case 10: return new NM(getMessage());
          case 11: return new NM(getMessage());
          case 12: return new NM(getMessage());
          case 13: return new NM(getMessage());
          case 14: return new NM(getMessage());
          default: return null;
       }
   }


}

