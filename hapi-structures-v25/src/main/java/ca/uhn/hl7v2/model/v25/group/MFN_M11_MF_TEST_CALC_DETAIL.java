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
 * <p>Represents a MFN_M11_MF_TEST_CALC_DETAIL group structure (a Group object).
 * A Group is an ordered collection of message segments that can repeat together or be optionally in/excluded together.
 * This Group contains the following elements:  
 * </p>
 * <ul>
                         * <li>1: OM6 (Observations that are Calculated from Other Observations) <b>  </b></li>
                         * <li>2: OM2 (Numeric Observation) <b>  </b></li>
 * </ul>
 */
//@SuppressWarnings("unused")
public class MFN_M11_MF_TEST_CALC_DETAIL extends AbstractGroup {

    /** 
     * Creates a new MFN_M11_MF_TEST_CALC_DETAIL group
     */
    public MFN_M11_MF_TEST_CALC_DETAIL(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(OM6.class, true, false, false);
                                  this.add(OM2.class, true, false, false);
       } catch(HL7Exception e) {
          log.error("Unexpected error creating MFN_M11_MF_TEST_CALC_DETAIL - this is probably a bug in the source code generator.", e);
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
     * OM6 (Observations that are Calculated from Other Observations) - creates it if necessary
     */
    public OM6 getOM6() { 
       OM6 retVal = getTyped("OM6", OM6.class);
       return retVal;
    }




    /**
     * Returns
     * OM2 (Numeric Observation) - creates it if necessary
     */
    public OM2 getOM2() { 
       OM2 retVal = getTyped("OM2", OM2.class);
       return retVal;
    }




}

