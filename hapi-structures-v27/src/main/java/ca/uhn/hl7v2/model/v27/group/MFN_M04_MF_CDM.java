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
 * <p>Represents a MFN_M04_MF_CDM group structure (a Group object).
 * A Group is an ordered collection of message segments that can repeat together or be optionally in/excluded together.
 * This Group contains the following elements:  
 * </p>
 * <ul>
                         * <li>1: MFE (Master File Entry) <b>  </b></li>
                         * <li>2: CDM (Charge Description Master) <b>  </b></li>
                         * <li>3: PRC (Pricing) <b>optional repeating </b></li>
 * </ul>
 */
//@SuppressWarnings("unused")
public class MFN_M04_MF_CDM extends AbstractGroup {

    /** 
     * Creates a new MFN_M04_MF_CDM group
     */
    public MFN_M04_MF_CDM(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(MFE.class, true, false, false);
                                  this.add(CDM.class, true, false, false);
                                  this.add(PRC.class, false, true, false);
       } catch(HL7Exception e) {
          log.error("Unexpected error creating MFN_M04_MF_CDM - this is probably a bug in the source code generator.", e);
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
     * MFE (Master File Entry) - creates it if necessary
     */
    public MFE getMFE() { 
       MFE retVal = getTyped("MFE", MFE.class);
       return retVal;
    }




    /**
     * Returns
     * CDM (Charge Description Master) - creates it if necessary
     */
    public CDM getCDM() { 
       CDM retVal = getTyped("CDM", CDM.class);
       return retVal;
    }




    /**
     * Returns
     * the first repetition of 
     * PRC (Pricing) - creates it if necessary
     */
    public PRC getPRC() { 
       PRC retVal = getTyped("PRC", PRC.class);
       return retVal;
    }


    /**
     * Returns a specific repetition of
     * PRC (Pricing) - creates it if necessary
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public PRC getPRC(int rep) { 
       PRC retVal = getTyped("PRC", rep, PRC.class);
       return retVal;
    }

    /** 
     * Returns the number of existing repetitions of PRC 
     */ 
    public int getPRCReps() {  
        return getReps("PRC");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of PRC.
     * <p>
     * <p>
     * Note that unlike {@link #getPRC()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     */ 
    public java.util.List<PRC> getPRCAll() throws HL7Exception {
    	return getAllAsList("PRC", PRC.class);
    } 

    /**
     * Inserts a specific repetition of PRC (Pricing)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertPRC(PRC structure, int rep) throws HL7Exception { 
       super.insertRepetition("PRC", structure, rep);
    }


    /**
     * Inserts a specific repetition of PRC (Pricing)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public PRC insertPRC(int rep) throws HL7Exception { 
       return (PRC)super.insertRepetition("PRC", rep);
    }


    /**
     * Removes a specific repetition of PRC (Pricing)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public PRC removePRC(int rep) throws HL7Exception { 
       return (PRC)super.removeRepetition("PRC", rep);
    }



}

