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


package ca.uhn.hl7v2.model.v28.group;

import ca.uhn.hl7v2.model.v28.segment.*;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.model.*;

/**
 * <p>Represents a EAC_U07_COMMAND group structure (a Group object).
 * A Group is an ordered collection of message segments that can repeat together or be optionally in/excluded together.
 * This Group contains the following elements:  
 * </p>
 * <ul>
                         * <li>1: ECD (Equipment Command) <b>  </b></li>
                         * <li>2: TQ1 (Timing/Quantity) <b>optional  </b></li>
                         * <li>3: EAC_U07_SPECIMEN_CONTAINER (a Group object) <b>optional  </b></li>
                         * <li>4: CNS (Clear Notification) <b>optional  </b></li>
 * </ul>
 */
//@SuppressWarnings("unused")
public class EAC_U07_COMMAND extends AbstractGroup {

    /** 
     * Creates a new EAC_U07_COMMAND group
     */
    public EAC_U07_COMMAND(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(ECD.class, true, false, false);
                                  this.add(TQ1.class, false, false, false);
                                  this.add(EAC_U07_SPECIMEN_CONTAINER.class, false, false, false);
                                  this.add(CNS.class, false, false, false);
       } catch(HL7Exception e) {
          log.error("Unexpected error creating EAC_U07_COMMAND - this is probably a bug in the source code generator.", e);
       }
    }

    /** 
     * Returns "2.8"
     */
    public String getVersion() {
       return "2.8";
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
     * TQ1 (Timing/Quantity) - creates it if necessary
     */
    public TQ1 getTQ1() { 
       TQ1 retVal = getTyped("TQ1", TQ1.class);
       return retVal;
    }




    /**
     * Returns
     * SPECIMEN_CONTAINER (a Group object) - creates it if necessary
     */
    public EAC_U07_SPECIMEN_CONTAINER getSPECIMEN_CONTAINER() { 
       EAC_U07_SPECIMEN_CONTAINER retVal = getTyped("SPECIMEN_CONTAINER", EAC_U07_SPECIMEN_CONTAINER.class);
       return retVal;
    }




    /**
     * Returns
     * CNS (Clear Notification) - creates it if necessary
     */
    public CNS getCNS() { 
       CNS retVal = getTyped("CNS", CNS.class);
       return retVal;
    }




}

