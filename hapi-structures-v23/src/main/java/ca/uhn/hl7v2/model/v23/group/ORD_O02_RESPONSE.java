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


package ca.uhn.hl7v2.model.v23.group;

import ca.uhn.hl7v2.model.v23.segment.*;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.model.*;

/**
 * <p>Represents a ORD_O02_RESPONSE group structure (a Group object).
 * A Group is an ordered collection of message segments that can repeat together or be optionally in/excluded together.
 * This Group contains the following elements:  
 * </p>
 * <ul>
                         * <li>1: ORD_O02_PATIENT (a Group object) <b>optional  </b></li>
                         * <li>2: ORD_O02_ORDER_DIET (a Group object) <b> repeating </b></li>
                         * <li>3: ORD_O02_ORDER_TRAY (a Group object) <b>optional repeating </b></li>
 * </ul>
 */
//@SuppressWarnings("unused")
public class ORD_O02_RESPONSE extends AbstractGroup {

    /** 
     * Creates a new ORD_O02_RESPONSE group
     */
    public ORD_O02_RESPONSE(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(ORD_O02_PATIENT.class, false, false, false);
                                  this.add(ORD_O02_ORDER_DIET.class, true, true, false);
                                  this.add(ORD_O02_ORDER_TRAY.class, false, true, false);
       } catch(HL7Exception e) {
          log.error("Unexpected error creating ORD_O02_RESPONSE - this is probably a bug in the source code generator.", e);
       }
    }

    /** 
     * Returns "2.3"
     */
    public String getVersion() {
       return "2.3";
    }



    /**
     * Returns
     * PATIENT (a Group object) - creates it if necessary
     */
    public ORD_O02_PATIENT getPATIENT() { 
       ORD_O02_PATIENT retVal = getTyped("PATIENT", ORD_O02_PATIENT.class);
       return retVal;
    }




    /**
     * Returns
     * the first repetition of 
     * ORDER_DIET (a Group object) - creates it if necessary
     */
    public ORD_O02_ORDER_DIET getORDER_DIET() { 
       ORD_O02_ORDER_DIET retVal = getTyped("ORDER_DIET", ORD_O02_ORDER_DIET.class);
       return retVal;
    }


    /**
     * Returns a specific repetition of
     * ORDER_DIET (a Group object) - creates it if necessary
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public ORD_O02_ORDER_DIET getORDER_DIET(int rep) { 
       ORD_O02_ORDER_DIET retVal = getTyped("ORDER_DIET", rep, ORD_O02_ORDER_DIET.class);
       return retVal;
    }

    /** 
     * Returns the number of existing repetitions of ORDER_DIET 
     */ 
    public int getORDER_DIETReps() {  
        return getReps("ORDER_DIET");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of ORDER_DIET.
     * <p>
     * <p>
     * Note that unlike {@link #getORDER_DIET()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     */ 
    public java.util.List<ORD_O02_ORDER_DIET> getORDER_DIETAll() throws HL7Exception {
    	return getAllAsList("ORDER_DIET", ORD_O02_ORDER_DIET.class);
    } 

    /**
     * Inserts a specific repetition of ORDER_DIET (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertORDER_DIET(ORD_O02_ORDER_DIET structure, int rep) throws HL7Exception { 
       super.insertRepetition("ORDER_DIET", structure, rep);
    }


    /**
     * Inserts a specific repetition of ORDER_DIET (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public ORD_O02_ORDER_DIET insertORDER_DIET(int rep) throws HL7Exception { 
       return (ORD_O02_ORDER_DIET)super.insertRepetition("ORDER_DIET", rep);
    }


    /**
     * Removes a specific repetition of ORDER_DIET (a Group object)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public ORD_O02_ORDER_DIET removeORDER_DIET(int rep) throws HL7Exception { 
       return (ORD_O02_ORDER_DIET)super.removeRepetition("ORDER_DIET", rep);
    }



    /**
     * Returns
     * the first repetition of 
     * ORDER_TRAY (a Group object) - creates it if necessary
     */
    public ORD_O02_ORDER_TRAY getORDER_TRAY() { 
       ORD_O02_ORDER_TRAY retVal = getTyped("ORDER_TRAY", ORD_O02_ORDER_TRAY.class);
       return retVal;
    }


    /**
     * Returns a specific repetition of
     * ORDER_TRAY (a Group object) - creates it if necessary
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public ORD_O02_ORDER_TRAY getORDER_TRAY(int rep) { 
       ORD_O02_ORDER_TRAY retVal = getTyped("ORDER_TRAY", rep, ORD_O02_ORDER_TRAY.class);
       return retVal;
    }

    /** 
     * Returns the number of existing repetitions of ORDER_TRAY 
     */ 
    public int getORDER_TRAYReps() {  
        return getReps("ORDER_TRAY");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of ORDER_TRAY.
     * <p>
     * <p>
     * Note that unlike {@link #getORDER_TRAY()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     */ 
    public java.util.List<ORD_O02_ORDER_TRAY> getORDER_TRAYAll() throws HL7Exception {
    	return getAllAsList("ORDER_TRAY", ORD_O02_ORDER_TRAY.class);
    } 

    /**
     * Inserts a specific repetition of ORDER_TRAY (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertORDER_TRAY(ORD_O02_ORDER_TRAY structure, int rep) throws HL7Exception { 
       super.insertRepetition("ORDER_TRAY", structure, rep);
    }


    /**
     * Inserts a specific repetition of ORDER_TRAY (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public ORD_O02_ORDER_TRAY insertORDER_TRAY(int rep) throws HL7Exception { 
       return (ORD_O02_ORDER_TRAY)super.insertRepetition("ORDER_TRAY", rep);
    }


    /**
     * Removes a specific repetition of ORDER_TRAY (a Group object)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public ORD_O02_ORDER_TRAY removeORDER_TRAY(int rep) throws HL7Exception { 
       return (ORD_O02_ORDER_TRAY)super.removeRepetition("ORDER_TRAY", rep);
    }



}

