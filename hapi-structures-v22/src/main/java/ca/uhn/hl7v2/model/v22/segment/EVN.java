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


package ca.uhn.hl7v2.model.v22.segment;

// import ca.uhn.hl7v2.model.v22.group.*;
import ca.uhn.hl7v2.model.v22.datatype.*;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.parser.DefaultModelClassFactory;
import ca.uhn.hl7v2.model.AbstractMessage;
import ca.uhn.hl7v2.model.Group;
import ca.uhn.hl7v2.model.Type;
import ca.uhn.hl7v2.model.AbstractSegment;
import ca.uhn.hl7v2.model.Varies;


/**
 *<p>Represents an HL7 EVN message segment (EVENT TYPE). 
 * This segment has the following fields:</p>
 * <ul>
     * <li>EVN-1: Event Type Code (ID) <b> </b>
     * <li>EVN-2: Date / time of event (TS) <b> </b>
     * <li>EVN-3: Date / time planned event (TS) <b>optional </b>
     * <li>EVN-4: Event Reason Code (ID) <b>optional </b>
     * <li>EVN-5: Operator ID (ID) <b>optional </b>
 * </ul>
 */
@SuppressWarnings("unused")
public class EVN extends AbstractSegment {

    /** 
     * Creates a new EVN segment
     */
    public EVN(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                              this.add(ID.class, true, 1, 3, new Object[]{ getMessage(), new Integer(3) }, "Event Type Code");
                                  this.add(TS.class, true, 1, 26, new Object[]{ getMessage() }, "Date / time of event");
                                  this.add(TS.class, false, 1, 26, new Object[]{ getMessage() }, "Date / time planned event");
                                              this.add(ID.class, false, 1, 3, new Object[]{ getMessage(), new Integer(62) }, "Event Reason Code");
                                              this.add(ID.class, false, 1, 5, new Object[]{ getMessage(), new Integer(188) }, "Operator ID");
       } catch(HL7Exception e) {
          log.error("Unexpected error creating EVN - this is probably a bug in the source code generator.", e);
       }
    }



    /**
     * Returns
     * EVN-1: "Event Type Code" - creates it if necessary
     */
    public ID getEventTypeCode() { 
		ID retVal = this.getTypedField(1, 0);
		return retVal;
    }
    
    /**
     * Returns
     * EVN-1: "Event Type Code" - creates it if necessary
     */
    public ID getEvn1_EventTypeCode() { 
		ID retVal = this.getTypedField(1, 0);
		return retVal;
    }



    /**
     * Returns
     * EVN-2: "Date / time of event" - creates it if necessary
     */
    public TS getDateTimeOfEvent() { 
		TS retVal = this.getTypedField(2, 0);
		return retVal;
    }
    
    /**
     * Returns
     * EVN-2: "Date / time of event" - creates it if necessary
     */
    public TS getEvn2_DateTimeOfEvent() { 
		TS retVal = this.getTypedField(2, 0);
		return retVal;
    }



    /**
     * Returns
     * EVN-3: "Date / time planned event" - creates it if necessary
     */
    public TS getDateTimePlannedEvent() { 
		TS retVal = this.getTypedField(3, 0);
		return retVal;
    }
    
    /**
     * Returns
     * EVN-3: "Date / time planned event" - creates it if necessary
     */
    public TS getEvn3_DateTimePlannedEvent() { 
		TS retVal = this.getTypedField(3, 0);
		return retVal;
    }



    /**
     * Returns
     * EVN-4: "Event Reason Code" - creates it if necessary
     */
    public ID getEventReasonCode() { 
		ID retVal = this.getTypedField(4, 0);
		return retVal;
    }
    
    /**
     * Returns
     * EVN-4: "Event Reason Code" - creates it if necessary
     */
    public ID getEvn4_EventReasonCode() { 
		ID retVal = this.getTypedField(4, 0);
		return retVal;
    }



    /**
     * Returns
     * EVN-5: "Operator ID" - creates it if necessary
     */
    public ID getOperatorID() { 
		ID retVal = this.getTypedField(5, 0);
		return retVal;
    }
    
    /**
     * Returns
     * EVN-5: "Operator ID" - creates it if necessary
     */
    public ID getEvn5_OperatorID() { 
		ID retVal = this.getTypedField(5, 0);
		return retVal;
    }





    /** {@inheritDoc} */   
    protected Type createNewTypeWithoutReflection(int field) {
       switch (field) {
          case 0: return new ID(getMessage(), new Integer( 3 ));
          case 1: return new TS(getMessage());
          case 2: return new TS(getMessage());
          case 3: return new ID(getMessage(), new Integer( 62 ));
          case 4: return new ID(getMessage(), new Integer( 188 ));
          default: return null;
       }
   }


}

