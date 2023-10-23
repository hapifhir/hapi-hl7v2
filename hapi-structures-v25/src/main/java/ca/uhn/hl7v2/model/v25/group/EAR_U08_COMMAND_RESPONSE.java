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


package ca.uhn.hl7v2.model.v25.group;

import ca.uhn.hl7v2.model.v25.segment.*;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.model.*;

/**
 * <p>Represents a EAR_U08_COMMAND_RESPONSE group structure (a Group object).
 * A Group is an ordered collection of message segments that can repeat together or be optionally in/excluded together.
 * This Group contains the following elements:  
 * </p>
 * <ul>
                         * <li>1: ECD (Equipment Command) <b>  </b></li>
                         * <li>2: EAR_U08_SPECIMEN_CONTAINER (a Group object) <b>optional  </b></li>
                         * <li>3: ECR (Equipment Command Response) <b>  </b></li>
 * </ul>
 */
//@SuppressWarnings("unused")
public class EAR_U08_COMMAND_RESPONSE extends AbstractGroup {

    /** 
     * Creates a new EAR_U08_COMMAND_RESPONSE group
     */
    public EAR_U08_COMMAND_RESPONSE(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(ECD.class, true, false, false);
                                  this.add(EAR_U08_SPECIMEN_CONTAINER.class, false, false, false);
                                  this.add(ECR.class, true, false, false);
       } catch(HL7Exception e) {
          log.error("Unexpected error creating EAR_U08_COMMAND_RESPONSE - this is probably a bug in the source code generator.", e);
       }
    }

    /** 
     * Returns "2.5"
     */
    public String getVersion() {
       return "2.5";
    }



    /**
     * Returns
     * ECD (Equipment Command) - creates it if necessary
     */
    public ECD getECD() { 
       ECD retVal = getTyped("ECD", ECD.class);
       return retVal;
    }




    /**
     * Returns
     * SPECIMEN_CONTAINER (a Group object) - creates it if necessary
     */
    public EAR_U08_SPECIMEN_CONTAINER getSPECIMEN_CONTAINER() { 
       EAR_U08_SPECIMEN_CONTAINER retVal = getTyped("SPECIMEN_CONTAINER", EAR_U08_SPECIMEN_CONTAINER.class);
       return retVal;
    }




    /**
     * Returns
     * ECR (Equipment Command Response) - creates it if necessary
     */
    public ECR getECR() { 
       ECR retVal = getTyped("ECR", ECR.class);
       return retVal;
    }




}

