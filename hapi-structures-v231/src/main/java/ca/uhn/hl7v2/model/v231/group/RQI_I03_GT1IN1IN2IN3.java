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
 * <p>Represents a RQI_I03_GT1IN1IN2IN3 group structure (a Group object).
 * A Group is an ordered collection of message segments that can repeat together or be optionally in/excluded together.
 * This Group contains the following elements:  
 * </p>
 * <ul>
                         * <li>1: GT1 (GT1 - guarantor segment) <b>optional repeating </b></li>
                         * <li>2: RQI_I03_IN1IN2IN3 (a Group object) <b> repeating </b></li>
 * </ul>
 */
//@SuppressWarnings("unused")
public class RQI_I03_GT1IN1IN2IN3 extends AbstractGroup {

    /** 
     * Creates a new RQI_I03_GT1IN1IN2IN3 group
     */
    public RQI_I03_GT1IN1IN2IN3(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(GT1.class, false, true, false);
                                  this.add(RQI_I03_IN1IN2IN3.class, true, true, false);
       } catch(HL7Exception e) {
          log.error("Unexpected error creating RQI_I03_GT1IN1IN2IN3 - this is probably a bug in the source code generator.", e);
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
     * the first repetition of 
     * GT1 (GT1 - guarantor segment) - creates it if necessary
     */
    public GT1 getGT1() { 
       GT1 retVal = getTyped("GT1", GT1.class);
       return retVal;
    }


    /**
     * Returns a specific repetition of
     * GT1 (GT1 - guarantor segment) - creates it if necessary
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public GT1 getGT1(int rep) { 
       GT1 retVal = getTyped("GT1", rep, GT1.class);
       return retVal;
    }

    /** 
     * Returns the number of existing repetitions of GT1 
     */ 
    public int getGT1Reps() {  
        return getReps("GT1");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of GT1.
     * <p>
     * <p>
     * Note that unlike {@link #getGT1()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     */ 
    public java.util.List<GT1> getGT1All() throws HL7Exception {
    	return getAllAsList("GT1", GT1.class);
    } 

    /**
     * Inserts a specific repetition of GT1 (GT1 - guarantor segment)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertGT1(GT1 structure, int rep) throws HL7Exception { 
       super.insertRepetition("GT1", structure, rep);
    }


    /**
     * Inserts a specific repetition of GT1 (GT1 - guarantor segment)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public GT1 insertGT1(int rep) throws HL7Exception { 
       return (GT1)super.insertRepetition("GT1", rep);
    }


    /**
     * Removes a specific repetition of GT1 (GT1 - guarantor segment)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public GT1 removeGT1(int rep) throws HL7Exception { 
       return (GT1)super.removeRepetition("GT1", rep);
    }



    /**
     * Returns
     * the first repetition of 
     * IN1IN2IN3 (a Group object) - creates it if necessary
     */
    public RQI_I03_IN1IN2IN3 getIN1IN2IN3() { 
       RQI_I03_IN1IN2IN3 retVal = getTyped("IN1IN2IN3", RQI_I03_IN1IN2IN3.class);
       return retVal;
    }


    /**
     * Returns a specific repetition of
     * IN1IN2IN3 (a Group object) - creates it if necessary
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public RQI_I03_IN1IN2IN3 getIN1IN2IN3(int rep) { 
       RQI_I03_IN1IN2IN3 retVal = getTyped("IN1IN2IN3", rep, RQI_I03_IN1IN2IN3.class);
       return retVal;
    }

    /** 
     * Returns the number of existing repetitions of IN1IN2IN3 
     */ 
    public int getIN1IN2IN3Reps() {  
        return getReps("IN1IN2IN3");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of IN1IN2IN3.
     * <p>
     * <p>
     * Note that unlike {@link #getIN1IN2IN3()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     */ 
    public java.util.List<RQI_I03_IN1IN2IN3> getIN1IN2IN3All() throws HL7Exception {
    	return getAllAsList("IN1IN2IN3", RQI_I03_IN1IN2IN3.class);
    } 

    /**
     * Inserts a specific repetition of IN1IN2IN3 (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertIN1IN2IN3(RQI_I03_IN1IN2IN3 structure, int rep) throws HL7Exception { 
       super.insertRepetition("IN1IN2IN3", structure, rep);
    }


    /**
     * Inserts a specific repetition of IN1IN2IN3 (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public RQI_I03_IN1IN2IN3 insertIN1IN2IN3(int rep) throws HL7Exception { 
       return (RQI_I03_IN1IN2IN3)super.insertRepetition("IN1IN2IN3", rep);
    }


    /**
     * Removes a specific repetition of IN1IN2IN3 (a Group object)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public RQI_I03_IN1IN2IN3 removeIN1IN2IN3(int rep) throws HL7Exception { 
       return (RQI_I03_IN1IN2IN3)super.removeRepetition("IN1IN2IN3", rep);
    }



}

