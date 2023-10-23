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


package ca.uhn.hl7v2.model.v231.group;

import ca.uhn.hl7v2.model.v231.segment.*;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.model.*;

/**
 * <p>Represents a CSU_C09_CSPCSSORCOBROBXORCRXARXR group structure (a Group object).
 * A Group is an ordered collection of message segments that can repeat together or be optionally in/excluded together.
 * This Group contains the following elements:  
 * </p>
 * <ul>
                         * <li>1: CSP (CSP - clinical study phase segment) <b>optional  </b></li>
                         * <li>2: CSU_C09_CSSORCOBROBXORCRXARXR (a Group object) <b> repeating </b></li>
 * </ul>
 */
//@SuppressWarnings("unused")
public class CSU_C09_CSPCSSORCOBROBXORCRXARXR extends AbstractGroup {

    /** 
     * Creates a new CSU_C09_CSPCSSORCOBROBXORCRXARXR group
     */
    public CSU_C09_CSPCSSORCOBROBXORCRXARXR(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(CSP.class, false, false, false);
                                  this.add(CSU_C09_CSSORCOBROBXORCRXARXR.class, true, true, false);
       } catch(HL7Exception e) {
          log.error("Unexpected error creating CSU_C09_CSPCSSORCOBROBXORCRXARXR - this is probably a bug in the source code generator.", e);
       }
    }

    /** 
     * Returns "2.3.1"
     */
    public String getVersion() {
       return "2.3.1";
    }



    /**
     * Returns
     * CSP (CSP - clinical study phase segment) - creates it if necessary
     */
    public CSP getCSP() { 
       CSP retVal = getTyped("CSP", CSP.class);
       return retVal;
    }




    /**
     * Returns
     * the first repetition of 
     * CSSORCOBROBXORCRXARXR (a Group object) - creates it if necessary
     */
    public CSU_C09_CSSORCOBROBXORCRXARXR getCSSORCOBROBXORCRXARXR() { 
       CSU_C09_CSSORCOBROBXORCRXARXR retVal = getTyped("CSSORCOBROBXORCRXARXR", CSU_C09_CSSORCOBROBXORCRXARXR.class);
       return retVal;
    }


    /**
     * Returns a specific repetition of
     * CSSORCOBROBXORCRXARXR (a Group object) - creates it if necessary
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public CSU_C09_CSSORCOBROBXORCRXARXR getCSSORCOBROBXORCRXARXR(int rep) { 
       CSU_C09_CSSORCOBROBXORCRXARXR retVal = getTyped("CSSORCOBROBXORCRXARXR", rep, CSU_C09_CSSORCOBROBXORCRXARXR.class);
       return retVal;
    }

    /** 
     * Returns the number of existing repetitions of CSSORCOBROBXORCRXARXR 
     */ 
    public int getCSSORCOBROBXORCRXARXRReps() {  
        return getReps("CSSORCOBROBXORCRXARXR");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of CSSORCOBROBXORCRXARXR.
     * <p>
     * <p>
     * Note that unlike {@link #getCSSORCOBROBXORCRXARXR()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     */ 
    public java.util.List<CSU_C09_CSSORCOBROBXORCRXARXR> getCSSORCOBROBXORCRXARXRAll() throws HL7Exception {
    	return getAllAsList("CSSORCOBROBXORCRXARXR", CSU_C09_CSSORCOBROBXORCRXARXR.class);
    } 

    /**
     * Inserts a specific repetition of CSSORCOBROBXORCRXARXR (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertCSSORCOBROBXORCRXARXR(CSU_C09_CSSORCOBROBXORCRXARXR structure, int rep) throws HL7Exception { 
       super.insertRepetition("CSSORCOBROBXORCRXARXR", structure, rep);
    }


    /**
     * Inserts a specific repetition of CSSORCOBROBXORCRXARXR (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public CSU_C09_CSSORCOBROBXORCRXARXR insertCSSORCOBROBXORCRXARXR(int rep) throws HL7Exception { 
       return (CSU_C09_CSSORCOBROBXORCRXARXR)super.insertRepetition("CSSORCOBROBXORCRXARXR", rep);
    }


    /**
     * Removes a specific repetition of CSSORCOBROBXORCRXARXR (a Group object)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public CSU_C09_CSSORCOBROBXORCRXARXR removeCSSORCOBROBXORCRXARXR(int rep) throws HL7Exception { 
       return (CSU_C09_CSSORCOBROBXORCRXARXR)super.removeRepetition("CSSORCOBROBXORCRXARXR", rep);
    }



}

