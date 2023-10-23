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
 * <p>Represents a EHC_E02_PSG group structure (a Group object).
 * A Group is an ordered collection of message segments that can repeat together or be optionally in/excluded together.
 * This Group contains the following elements:  
 * </p>
 * <ul>
                         * <li>1: PSG (Product/Service Group) <b>  choice</b></li>
                         * <li>2: PSL (Product/Service Line Item) <b>optional repeating choice</b></li>
 * </ul>
 * <p>
 * Note that this structure has "choice" elements. This means that one of the 
 * structures above marked as "choice" must be present, but no more than one.
 * </p> 
 */
//@SuppressWarnings("unused")
public class EHC_E02_PSG extends AbstractGroup {

    /** 
     * Creates a new EHC_E02_PSG group
     */
    public EHC_E02_PSG(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(PSG.class, true, false, true);
                                  this.add(PSL.class, false, true, true);
       } catch(HL7Exception e) {
          log.error("Unexpected error creating EHC_E02_PSG - this is probably a bug in the source code generator.", e);
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
     * PSG (Product/Service Group) - creates it if necessary
     */
    public PSG getPSG() { 
       PSG retVal = getTyped("PSG", PSG.class);
       return retVal;
    }




    /**
     * Returns
     * the first repetition of 
     * PSL (Product/Service Line Item) - creates it if necessary
     */
    public PSL getPSL() { 
       PSL retVal = getTyped("PSL", PSL.class);
       return retVal;
    }


    /**
     * Returns a specific repetition of
     * PSL (Product/Service Line Item) - creates it if necessary
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public PSL getPSL(int rep) { 
       PSL retVal = getTyped("PSL", rep, PSL.class);
       return retVal;
    }

    /** 
     * Returns the number of existing repetitions of PSL 
     */ 
    public int getPSLReps() {  
        return getReps("PSL");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of PSL.
     * <p>
     * <p>
     * Note that unlike {@link #getPSL()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     */ 
    public java.util.List<PSL> getPSLAll() throws HL7Exception {
    	return getAllAsList("PSL", PSL.class);
    } 

    /**
     * Inserts a specific repetition of PSL (Product/Service Line Item)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertPSL(PSL structure, int rep) throws HL7Exception { 
       super.insertRepetition("PSL", structure, rep);
    }


    /**
     * Inserts a specific repetition of PSL (Product/Service Line Item)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public PSL insertPSL(int rep) throws HL7Exception { 
       return (PSL)super.insertRepetition("PSL", rep);
    }


    /**
     * Removes a specific repetition of PSL (Product/Service Line Item)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public PSL removePSL(int rep) throws HL7Exception { 
       return (PSL)super.removeRepetition("PSL", rep);
    }



}

