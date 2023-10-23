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
 * <p>Represents a OMD_O03_ORDER_DIET group structure (a Group object).
 * A Group is an ordered collection of message segments that can repeat together or be optionally in/excluded together.
 * This Group contains the following elements:  
 * </p>
 * <ul>
                         * <li>1: ORC (Common Order) <b>  </b></li>
                         * <li>2: OMD_O03_TIMING_DIET (a Group object) <b>optional repeating </b></li>
                         * <li>3: OMD_O03_DIET (a Group object) <b>optional  </b></li>
 * </ul>
 */
//@SuppressWarnings("unused")
public class OMD_O03_ORDER_DIET extends AbstractGroup {

    /** 
     * Creates a new OMD_O03_ORDER_DIET group
     */
    public OMD_O03_ORDER_DIET(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(ORC.class, true, false, false);
                                  this.add(OMD_O03_TIMING_DIET.class, false, true, false);
                                  this.add(OMD_O03_DIET.class, false, false, false);
       } catch(HL7Exception e) {
          log.error("Unexpected error creating OMD_O03_ORDER_DIET - this is probably a bug in the source code generator.", e);
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
     * ORC (Common Order) - creates it if necessary
     */
    public ORC getORC() { 
       ORC retVal = getTyped("ORC", ORC.class);
       return retVal;
    }




    /**
     * Returns
     * the first repetition of 
     * TIMING_DIET (a Group object) - creates it if necessary
     */
    public OMD_O03_TIMING_DIET getTIMING_DIET() { 
       OMD_O03_TIMING_DIET retVal = getTyped("TIMING_DIET", OMD_O03_TIMING_DIET.class);
       return retVal;
    }


    /**
     * Returns a specific repetition of
     * TIMING_DIET (a Group object) - creates it if necessary
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public OMD_O03_TIMING_DIET getTIMING_DIET(int rep) { 
       OMD_O03_TIMING_DIET retVal = getTyped("TIMING_DIET", rep, OMD_O03_TIMING_DIET.class);
       return retVal;
    }

    /** 
     * Returns the number of existing repetitions of TIMING_DIET 
     */ 
    public int getTIMING_DIETReps() {  
        return getReps("TIMING_DIET");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of TIMING_DIET.
     * <p>
     * <p>
     * Note that unlike {@link #getTIMING_DIET()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     */ 
    public java.util.List<OMD_O03_TIMING_DIET> getTIMING_DIETAll() throws HL7Exception {
    	return getAllAsList("TIMING_DIET", OMD_O03_TIMING_DIET.class);
    } 

    /**
     * Inserts a specific repetition of TIMING_DIET (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertTIMING_DIET(OMD_O03_TIMING_DIET structure, int rep) throws HL7Exception { 
       super.insertRepetition("TIMING_DIET", structure, rep);
    }


    /**
     * Inserts a specific repetition of TIMING_DIET (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public OMD_O03_TIMING_DIET insertTIMING_DIET(int rep) throws HL7Exception { 
       return (OMD_O03_TIMING_DIET)super.insertRepetition("TIMING_DIET", rep);
    }


    /**
     * Removes a specific repetition of TIMING_DIET (a Group object)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public OMD_O03_TIMING_DIET removeTIMING_DIET(int rep) throws HL7Exception { 
       return (OMD_O03_TIMING_DIET)super.removeRepetition("TIMING_DIET", rep);
    }



    /**
     * Returns
     * DIET (a Group object) - creates it if necessary
     */
    public OMD_O03_DIET getDIET() { 
       OMD_O03_DIET retVal = getTyped("DIET", OMD_O03_DIET.class);
       return retVal;
    }




}

