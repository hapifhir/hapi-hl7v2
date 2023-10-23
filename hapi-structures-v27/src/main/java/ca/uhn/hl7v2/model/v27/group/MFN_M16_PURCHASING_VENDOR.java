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


package ca.uhn.hl7v2.model.v27.group;

import ca.uhn.hl7v2.model.v27.segment.*;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.model.*;

/**
 * <p>Represents a MFN_M16_PURCHASING_VENDOR group structure (a Group object).
 * A Group is an ordered collection of message segments that can repeat together or be optionally in/excluded together.
 * This Group contains the following elements:  
 * </p>
 * <ul>
                         * <li>1: VND (Purchasing Vendor) <b>  </b></li>
                         * <li>2: MFN_M16_PACKAGING (a Group object) <b>optional repeating </b></li>
 * </ul>
 */
//@SuppressWarnings("unused")
public class MFN_M16_PURCHASING_VENDOR extends AbstractGroup {

    /** 
     * Creates a new MFN_M16_PURCHASING_VENDOR group
     */
    public MFN_M16_PURCHASING_VENDOR(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(VND.class, true, false, false);
                                  this.add(MFN_M16_PACKAGING.class, false, true, false);
       } catch(HL7Exception e) {
          log.error("Unexpected error creating MFN_M16_PURCHASING_VENDOR - this is probably a bug in the source code generator.", e);
       }
    }

    /** 
     * Returns "2.7"
     */
    public String getVersion() {
       return "2.7";
    }



    /**
     * Returns
     * VND (Purchasing Vendor) - creates it if necessary
     */
    public VND getVND() { 
       VND retVal = getTyped("VND", VND.class);
       return retVal;
    }




    /**
     * Returns
     * the first repetition of 
     * PACKAGING (a Group object) - creates it if necessary
     */
    public MFN_M16_PACKAGING getPACKAGING() { 
       MFN_M16_PACKAGING retVal = getTyped("PACKAGING", MFN_M16_PACKAGING.class);
       return retVal;
    }


    /**
     * Returns a specific repetition of
     * PACKAGING (a Group object) - creates it if necessary
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public MFN_M16_PACKAGING getPACKAGING(int rep) { 
       MFN_M16_PACKAGING retVal = getTyped("PACKAGING", rep, MFN_M16_PACKAGING.class);
       return retVal;
    }

    /** 
     * Returns the number of existing repetitions of PACKAGING 
     */ 
    public int getPACKAGINGReps() {  
        return getReps("PACKAGING");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of PACKAGING.
     * <p>
     * <p>
     * Note that unlike {@link #getPACKAGING()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     */ 
    public java.util.List<MFN_M16_PACKAGING> getPACKAGINGAll() throws HL7Exception {
    	return getAllAsList("PACKAGING", MFN_M16_PACKAGING.class);
    } 

    /**
     * Inserts a specific repetition of PACKAGING (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertPACKAGING(MFN_M16_PACKAGING structure, int rep) throws HL7Exception { 
       super.insertRepetition("PACKAGING", structure, rep);
    }


    /**
     * Inserts a specific repetition of PACKAGING (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public MFN_M16_PACKAGING insertPACKAGING(int rep) throws HL7Exception { 
       return (MFN_M16_PACKAGING)super.insertRepetition("PACKAGING", rep);
    }


    /**
     * Removes a specific repetition of PACKAGING (a Group object)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public MFN_M16_PACKAGING removePACKAGING(int rep) throws HL7Exception { 
       return (MFN_M16_PACKAGING)super.removeRepetition("PACKAGING", rep);
    }



}

