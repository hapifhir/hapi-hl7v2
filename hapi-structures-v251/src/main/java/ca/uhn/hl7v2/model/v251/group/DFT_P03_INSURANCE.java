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


package ca.uhn.hl7v2.model.v251.group;

import ca.uhn.hl7v2.model.v251.segment.*;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.model.*;

/**
 * <p>Represents a DFT_P03_INSURANCE group structure (a Group object).
 * A Group is an ordered collection of message segments that can repeat together or be optionally in/excluded together.
 * This Group contains the following elements:  
 * </p>
 * <ul>
                         * <li>1: IN1 (Insurance) <b>  </b></li>
                         * <li>2: IN2 (Insurance Additional Information) <b>optional  </b></li>
                         * <li>3: IN3 (Insurance Additional Information, Certification) <b>optional repeating </b></li>
                         * <li>4: ROL (Role) <b>optional repeating </b></li>
 * </ul>
 */
//@SuppressWarnings("unused")
public class DFT_P03_INSURANCE extends AbstractGroup {

    /** 
     * Creates a new DFT_P03_INSURANCE group
     */
    public DFT_P03_INSURANCE(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(IN1.class, true, false, false);
                                  this.add(IN2.class, false, false, false);
                                  this.add(IN3.class, false, true, false);
                                  this.add(ROL.class, false, true, false);
       } catch(HL7Exception e) {
          log.error("Unexpected error creating DFT_P03_INSURANCE - this is probably a bug in the source code generator.", e);
       }
    }

    /** 
     * Returns "2.5.1"
     */
    public String getVersion() {
       return "2.5.1";
    }



    /**
     * Returns
     * IN1 (Insurance) - creates it if necessary
     */
    public IN1 getIN1() { 
       IN1 retVal = getTyped("IN1", IN1.class);
       return retVal;
    }




    /**
     * Returns
     * IN2 (Insurance Additional Information) - creates it if necessary
     */
    public IN2 getIN2() { 
       IN2 retVal = getTyped("IN2", IN2.class);
       return retVal;
    }




    /**
     * Returns
     * the first repetition of 
     * IN3 (Insurance Additional Information, Certification) - creates it if necessary
     */
    public IN3 getIN3() { 
       IN3 retVal = getTyped("IN3", IN3.class);
       return retVal;
    }


    /**
     * Returns a specific repetition of
     * IN3 (Insurance Additional Information, Certification) - creates it if necessary
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public IN3 getIN3(int rep) { 
       IN3 retVal = getTyped("IN3", rep, IN3.class);
       return retVal;
    }

    /** 
     * Returns the number of existing repetitions of IN3 
     */ 
    public int getIN3Reps() {  
        return getReps("IN3");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of IN3.
     * <p>
     * <p>
     * Note that unlike {@link #getIN3()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     */ 
    public java.util.List<IN3> getIN3All() throws HL7Exception {
    	return getAllAsList("IN3", IN3.class);
    } 

    /**
     * Inserts a specific repetition of IN3 (Insurance Additional Information, Certification)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertIN3(IN3 structure, int rep) throws HL7Exception { 
       super.insertRepetition("IN3", structure, rep);
    }


    /**
     * Inserts a specific repetition of IN3 (Insurance Additional Information, Certification)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public IN3 insertIN3(int rep) throws HL7Exception { 
       return (IN3)super.insertRepetition("IN3", rep);
    }


    /**
     * Removes a specific repetition of IN3 (Insurance Additional Information, Certification)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public IN3 removeIN3(int rep) throws HL7Exception { 
       return (IN3)super.removeRepetition("IN3", rep);
    }



    /**
     * Returns
     * the first repetition of 
     * ROL (Role) - creates it if necessary
     */
    public ROL getROL() { 
       ROL retVal = getTyped("ROL", ROL.class);
       return retVal;
    }


    /**
     * Returns a specific repetition of
     * ROL (Role) - creates it if necessary
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public ROL getROL(int rep) { 
       ROL retVal = getTyped("ROL", rep, ROL.class);
       return retVal;
    }

    /** 
     * Returns the number of existing repetitions of ROL 
     */ 
    public int getROLReps() {  
        return getReps("ROL");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of ROL.
     * <p>
     * <p>
     * Note that unlike {@link #getROL()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     */ 
    public java.util.List<ROL> getROLAll() throws HL7Exception {
    	return getAllAsList("ROL", ROL.class);
    } 

    /**
     * Inserts a specific repetition of ROL (Role)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertROL(ROL structure, int rep) throws HL7Exception { 
       super.insertRepetition("ROL", structure, rep);
    }


    /**
     * Inserts a specific repetition of ROL (Role)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public ROL insertROL(int rep) throws HL7Exception { 
       return (ROL)super.insertRepetition("ROL", rep);
    }


    /**
     * Removes a specific repetition of ROL (Role)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public ROL removeROL(int rep) throws HL7Exception { 
       return (ROL)super.removeRepetition("ROL", rep);
    }



}

