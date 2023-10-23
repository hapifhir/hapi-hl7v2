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
 * <p>Represents a RSP_Z82_TIMING_ENCODED group structure (a Group object).
 * A Group is an ordered collection of message segments that can repeat together or be optionally in/excluded together.
 * This Group contains the following elements:  
 * </p>
 * <ul>
                         * <li>1: TQ1 (Timing/Quantity) <b>  </b></li>
                         * <li>2: TQ2 (Timing/Quantity Relationship) <b>optional repeating </b></li>
 * </ul>
 */
//@SuppressWarnings("unused")
public class RSP_Z82_TIMING_ENCODED extends AbstractGroup {

    /** 
     * Creates a new RSP_Z82_TIMING_ENCODED group
     */
    public RSP_Z82_TIMING_ENCODED(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(TQ1.class, true, false, false);
                                  this.add(TQ2.class, false, true, false);
       } catch(HL7Exception e) {
          log.error("Unexpected error creating RSP_Z82_TIMING_ENCODED - this is probably a bug in the source code generator.", e);
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
     * TQ1 (Timing/Quantity) - creates it if necessary
     */
    public TQ1 getTQ1() { 
       TQ1 retVal = getTyped("TQ1", TQ1.class);
       return retVal;
    }




    /**
     * Returns
     * the first repetition of 
     * TQ2 (Timing/Quantity Relationship) - creates it if necessary
     */
    public TQ2 getTQ2() { 
       TQ2 retVal = getTyped("TQ2", TQ2.class);
       return retVal;
    }


    /**
     * Returns a specific repetition of
     * TQ2 (Timing/Quantity Relationship) - creates it if necessary
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public TQ2 getTQ2(int rep) { 
       TQ2 retVal = getTyped("TQ2", rep, TQ2.class);
       return retVal;
    }

    /** 
     * Returns the number of existing repetitions of TQ2 
     */ 
    public int getTQ2Reps() {  
        return getReps("TQ2");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of TQ2.
     * <p>
     * <p>
     * Note that unlike {@link #getTQ2()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     */ 
    public java.util.List<TQ2> getTQ2All() throws HL7Exception {
    	return getAllAsList("TQ2", TQ2.class);
    } 

    /**
     * Inserts a specific repetition of TQ2 (Timing/Quantity Relationship)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertTQ2(TQ2 structure, int rep) throws HL7Exception { 
       super.insertRepetition("TQ2", structure, rep);
    }


    /**
     * Inserts a specific repetition of TQ2 (Timing/Quantity Relationship)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public TQ2 insertTQ2(int rep) throws HL7Exception { 
       return (TQ2)super.insertRepetition("TQ2", rep);
    }


    /**
     * Removes a specific repetition of TQ2 (Timing/Quantity Relationship)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public TQ2 removeTQ2(int rep) throws HL7Exception { 
       return (TQ2)super.removeRepetition("TQ2", rep);
    }



}

