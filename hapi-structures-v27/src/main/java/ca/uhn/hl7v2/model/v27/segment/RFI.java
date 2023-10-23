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
 *<p>Represents an HL7 RFI message segment (Request for Information). 
 * This segment has the following fields:</p>
 * <ul>
     * <li>RFI-1: Request Date (DTM) <b> </b>
     * <li>RFI-2: Response Due Date (DTM) <b> </b>
     * <li>RFI-3: Patient Consent (ID) <b>optional </b>
     * <li>RFI-4: Date Additional Information Was Submitted (DTM) <b>optional </b>
 * </ul>
 */
@SuppressWarnings("unused")
public class RFI extends AbstractSegment {

    /** 
     * Creates a new RFI segment
     */
    public RFI(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(DTM.class, true, 1, 0, new Object[]{ getMessage() }, "Request Date");
                                  this.add(DTM.class, true, 1, 0, new Object[]{ getMessage() }, "Response Due Date");
                                              this.add(ID.class, false, 1, 1, new Object[]{ getMessage(), new Integer(136) }, "Patient Consent");
                                  this.add(DTM.class, false, 1, 0, new Object[]{ getMessage() }, "Date Additional Information Was Submitted");
       } catch(HL7Exception e) {
          log.error("Unexpected error creating RFI - this is probably a bug in the source code generator.", e);
       }
    }



    /**
     * Returns
     * RFI-1: "Request Date" - creates it if necessary
     */
    public DTM getRequestDate() { 
		DTM retVal = this.getTypedField(1, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RFI-1: "Request Date" - creates it if necessary
     */
    public DTM getRfi1_RequestDate() { 
		DTM retVal = this.getTypedField(1, 0);
		return retVal;
    }



    /**
     * Returns
     * RFI-2: "Response Due Date" - creates it if necessary
     */
    public DTM getResponseDueDate() { 
		DTM retVal = this.getTypedField(2, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RFI-2: "Response Due Date" - creates it if necessary
     */
    public DTM getRfi2_ResponseDueDate() { 
		DTM retVal = this.getTypedField(2, 0);
		return retVal;
    }



    /**
     * Returns
     * RFI-3: "Patient Consent" - creates it if necessary
     */
    public ID getPatientConsent() { 
		ID retVal = this.getTypedField(3, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RFI-3: "Patient Consent" - creates it if necessary
     */
    public ID getRfi3_PatientConsent() { 
		ID retVal = this.getTypedField(3, 0);
		return retVal;
    }



    /**
     * Returns
     * RFI-4: "Date Additional Information Was Submitted" - creates it if necessary
     */
    public DTM getDateAdditionalInformationWasSubmitted() { 
		DTM retVal = this.getTypedField(4, 0);
		return retVal;
    }
    
    /**
     * Returns
     * RFI-4: "Date Additional Information Was Submitted" - creates it if necessary
     */
    public DTM getRfi4_DateAdditionalInformationWasSubmitted() { 
		DTM retVal = this.getTypedField(4, 0);
		return retVal;
    }





    /** {@inheritDoc} */   
    protected Type createNewTypeWithoutReflection(int field) {
       switch (field) {
          case 0: return new DTM(getMessage());
          case 1: return new DTM(getMessage());
          case 2: return new ID(getMessage(), new Integer( 136 ));
          case 3: return new DTM(getMessage());
          default: return null;
       }
   }


}

