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
 *<p>Represents an HL7 MSA message segment (Message Acknowledgment). 
 * This segment has the following fields:</p>
 * <ul>
     * <li>MSA-1: Acknowledgment Code (ID) <b> </b>
     * <li>MSA-2: Message Control ID (ST) <b> </b>
     * <li>MSA-3: Text Message (NULLDT) <b>optional </b>
     * <li>MSA-4: Expected Sequence Number (NM) <b>optional </b>
     * <li>MSA-5: Delayed Acknowledgment Type (NULLDT) <b>optional </b>
     * <li>MSA-6: Error Condition (NULLDT) <b>optional </b>
     * <li>MSA-7: Message Waiting Number (NM) <b>optional </b>
     * <li>MSA-8: Message Waiting Priority (ID) <b>optional </b>
 * </ul>
 */
@SuppressWarnings("unused")
public class MSA extends AbstractSegment {

    /** 
     * Creates a new MSA segment
     */
    public MSA(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                              this.add(ID.class, true, 1, 2, new Object[]{ getMessage(), new Integer(8) }, "Acknowledgment Code");
                                  this.add(ST.class, true, 1, 199, new Object[]{ getMessage() }, "Message Control ID");
                                  this.add(NULLDT.class, false, 1, 0, new Object[]{ getMessage() }, "Text Message");
                                  this.add(NM.class, false, 1, 0, new Object[]{ getMessage() }, "Expected Sequence Number");
                                  this.add(NULLDT.class, false, 1, 0, new Object[]{ getMessage() }, "Delayed Acknowledgment Type");
                                  this.add(NULLDT.class, false, 1, 0, new Object[]{ getMessage() }, "Error Condition");
                                  this.add(NM.class, false, 1, 0, new Object[]{ getMessage() }, "Message Waiting Number");
                                              this.add(ID.class, false, 1, 1, new Object[]{ getMessage(), new Integer(520) }, "Message Waiting Priority");
       } catch(HL7Exception e) {
          log.error("Unexpected error creating MSA - this is probably a bug in the source code generator.", e);
       }
    }



    /**
     * Returns
     * MSA-1: "Acknowledgment Code" - creates it if necessary
     */
    public ID getAcknowledgmentCode() { 
		ID retVal = this.getTypedField(1, 0);
		return retVal;
    }
    
    /**
     * Returns
     * MSA-1: "Acknowledgment Code" - creates it if necessary
     */
    public ID getMsa1_AcknowledgmentCode() { 
		ID retVal = this.getTypedField(1, 0);
		return retVal;
    }



    /**
     * Returns
     * MSA-2: "Message Control ID" - creates it if necessary
     */
    public ST getMessageControlID() { 
		ST retVal = this.getTypedField(2, 0);
		return retVal;
    }
    
    /**
     * Returns
     * MSA-2: "Message Control ID" - creates it if necessary
     */
    public ST getMsa2_MessageControlID() { 
		ST retVal = this.getTypedField(2, 0);
		return retVal;
    }



    /**
     * Returns
     * MSA-3: "Text Message" - creates it if necessary
     */
    public NULLDT getTextMessage() { 
		NULLDT retVal = this.getTypedField(3, 0);
		return retVal;
    }
    
    /**
     * Returns
     * MSA-3: "Text Message" - creates it if necessary
     */
    public NULLDT getMsa3_TextMessage() { 
		NULLDT retVal = this.getTypedField(3, 0);
		return retVal;
    }



    /**
     * Returns
     * MSA-4: "Expected Sequence Number" - creates it if necessary
     */
    public NM getExpectedSequenceNumber() { 
		NM retVal = this.getTypedField(4, 0);
		return retVal;
    }
    
    /**
     * Returns
     * MSA-4: "Expected Sequence Number" - creates it if necessary
     */
    public NM getMsa4_ExpectedSequenceNumber() { 
		NM retVal = this.getTypedField(4, 0);
		return retVal;
    }



    /**
     * Returns
     * MSA-5: "Delayed Acknowledgment Type" - creates it if necessary
     */
    public NULLDT getDelayedAcknowledgmentType() { 
		NULLDT retVal = this.getTypedField(5, 0);
		return retVal;
    }
    
    /**
     * Returns
     * MSA-5: "Delayed Acknowledgment Type" - creates it if necessary
     */
    public NULLDT getMsa5_DelayedAcknowledgmentType() { 
		NULLDT retVal = this.getTypedField(5, 0);
		return retVal;
    }



    /**
     * Returns
     * MSA-6: "Error Condition" - creates it if necessary
     */
    public NULLDT getErrorCondition() { 
		NULLDT retVal = this.getTypedField(6, 0);
		return retVal;
    }
    
    /**
     * Returns
     * MSA-6: "Error Condition" - creates it if necessary
     */
    public NULLDT getMsa6_ErrorCondition() { 
		NULLDT retVal = this.getTypedField(6, 0);
		return retVal;
    }



    /**
     * Returns
     * MSA-7: "Message Waiting Number" - creates it if necessary
     */
    public NM getMessageWaitingNumber() { 
		NM retVal = this.getTypedField(7, 0);
		return retVal;
    }
    
    /**
     * Returns
     * MSA-7: "Message Waiting Number" - creates it if necessary
     */
    public NM getMsa7_MessageWaitingNumber() { 
		NM retVal = this.getTypedField(7, 0);
		return retVal;
    }



    /**
     * Returns
     * MSA-8: "Message Waiting Priority" - creates it if necessary
     */
    public ID getMessageWaitingPriority() { 
		ID retVal = this.getTypedField(8, 0);
		return retVal;
    }
    
    /**
     * Returns
     * MSA-8: "Message Waiting Priority" - creates it if necessary
     */
    public ID getMsa8_MessageWaitingPriority() { 
		ID retVal = this.getTypedField(8, 0);
		return retVal;
    }





    /** {@inheritDoc} */   
    protected Type createNewTypeWithoutReflection(int field) {
       switch (field) {
          case 0: return new ID(getMessage(), new Integer( 8 ));
          case 1: return new ST(getMessage());
          case 2: return new NULLDT(getMessage());
          case 3: return new NM(getMessage());
          case 4: return new NULLDT(getMessage());
          case 5: return new NULLDT(getMessage());
          case 6: return new NM(getMessage());
          case 7: return new ID(getMessage(), new Integer( 520 ));
          default: return null;
       }
   }


}

