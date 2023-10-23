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
 * <p>Represents a EHC_E02_PRODUCT_SERVICE_SECTION group structure (a Group object).
 * A Group is an ordered collection of message segments that can repeat together or be optionally in/excluded together.
 * This Group contains the following elements:  
 * </p>
 * <ul>
                         * <li>1: PSS (Product/Service Section) <b>  choice</b></li>
                         * <li>2: EHC_E02_PSG (a Group object) <b>optional repeating </b></li>
 * </ul>
 * <p>
 * Note that this structure has "choice" elements. This means that one of the 
 * structures above marked as "choice" must be present, but no more than one.
 * </p> 
 */
//@SuppressWarnings("unused")
public class EHC_E02_PRODUCT_SERVICE_SECTION extends AbstractGroup {

    /** 
     * Creates a new EHC_E02_PRODUCT_SERVICE_SECTION group
     */
    public EHC_E02_PRODUCT_SERVICE_SECTION(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(PSS.class, true, false, true);
                                  this.add(EHC_E02_PSG.class, false, true, false);
       } catch(HL7Exception e) {
          log.error("Unexpected error creating EHC_E02_PRODUCT_SERVICE_SECTION - this is probably a bug in the source code generator.", e);
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
     * PSS (Product/Service Section) - creates it if necessary
     */
    public PSS getPSS() { 
       PSS retVal = getTyped("PSS", PSS.class);
       return retVal;
    }




    /**
     * Returns
     * the first repetition of 
     * PSG (a Group object) - creates it if necessary
     */
    public EHC_E02_PSG getPSG() { 
       EHC_E02_PSG retVal = getTyped("PSG", EHC_E02_PSG.class);
       return retVal;
    }


    /**
     * Returns a specific repetition of
     * PSG (a Group object) - creates it if necessary
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public EHC_E02_PSG getPSG(int rep) { 
       EHC_E02_PSG retVal = getTyped("PSG", rep, EHC_E02_PSG.class);
       return retVal;
    }

    /** 
     * Returns the number of existing repetitions of PSG 
     */ 
    public int getPSGReps() {  
        return getReps("PSG");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of PSG.
     * <p>
     * <p>
     * Note that unlike {@link #getPSG()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     */ 
    public java.util.List<EHC_E02_PSG> getPSGAll() throws HL7Exception {
    	return getAllAsList("PSG", EHC_E02_PSG.class);
    } 

    /**
     * Inserts a specific repetition of PSG (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertPSG(EHC_E02_PSG structure, int rep) throws HL7Exception { 
       super.insertRepetition("PSG", structure, rep);
    }


    /**
     * Inserts a specific repetition of PSG (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public EHC_E02_PSG insertPSG(int rep) throws HL7Exception { 
       return (EHC_E02_PSG)super.insertRepetition("PSG", rep);
    }


    /**
     * Removes a specific repetition of PSG (a Group object)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public EHC_E02_PSG removePSG(int rep) throws HL7Exception { 
       return (EHC_E02_PSG)super.removeRepetition("PSG", rep);
    }



}

