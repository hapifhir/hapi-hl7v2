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
 * <p>Represents a ORD_O02_PIDNTEORCODSNTEORCODTNTE group structure (a Group object).
 * A Group is an ordered collection of message segments that can repeat together or be optionally in/excluded together.
 * This Group contains the following elements:  
 * </p>
 * <ul>
                         * <li>1: ORD_O02_PIDNTE (a Group object) <b>optional  </b></li>
                         * <li>2: ORD_O02_ORCODSNTE (a Group object) <b> repeating </b></li>
                         * <li>3: ORD_O02_ORCODTNTE (a Group object) <b>optional repeating </b></li>
 * </ul>
 */
//@SuppressWarnings("unused")
public class ORD_O02_PIDNTEORCODSNTEORCODTNTE extends AbstractGroup {

    /** 
     * Creates a new ORD_O02_PIDNTEORCODSNTEORCODTNTE group
     */
    public ORD_O02_PIDNTEORCODSNTEORCODTNTE(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(ORD_O02_PIDNTE.class, false, false, false);
                                  this.add(ORD_O02_ORCODSNTE.class, true, true, false);
                                  this.add(ORD_O02_ORCODTNTE.class, false, true, false);
       } catch(HL7Exception e) {
          log.error("Unexpected error creating ORD_O02_PIDNTEORCODSNTEORCODTNTE - this is probably a bug in the source code generator.", e);
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
     * PIDNTE (a Group object) - creates it if necessary
     */
    public ORD_O02_PIDNTE getPIDNTE() { 
       ORD_O02_PIDNTE retVal = getTyped("PIDNTE", ORD_O02_PIDNTE.class);
       return retVal;
    }




    /**
     * Returns
     * the first repetition of 
     * ORCODSNTE (a Group object) - creates it if necessary
     */
    public ORD_O02_ORCODSNTE getORCODSNTE() { 
       ORD_O02_ORCODSNTE retVal = getTyped("ORCODSNTE", ORD_O02_ORCODSNTE.class);
       return retVal;
    }


    /**
     * Returns a specific repetition of
     * ORCODSNTE (a Group object) - creates it if necessary
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public ORD_O02_ORCODSNTE getORCODSNTE(int rep) { 
       ORD_O02_ORCODSNTE retVal = getTyped("ORCODSNTE", rep, ORD_O02_ORCODSNTE.class);
       return retVal;
    }

    /** 
     * Returns the number of existing repetitions of ORCODSNTE 
     */ 
    public int getORCODSNTEReps() {  
        return getReps("ORCODSNTE");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of ORCODSNTE.
     * <p>
     * <p>
     * Note that unlike {@link #getORCODSNTE()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     */ 
    public java.util.List<ORD_O02_ORCODSNTE> getORCODSNTEAll() throws HL7Exception {
    	return getAllAsList("ORCODSNTE", ORD_O02_ORCODSNTE.class);
    } 

    /**
     * Inserts a specific repetition of ORCODSNTE (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertORCODSNTE(ORD_O02_ORCODSNTE structure, int rep) throws HL7Exception { 
       super.insertRepetition("ORCODSNTE", structure, rep);
    }


    /**
     * Inserts a specific repetition of ORCODSNTE (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public ORD_O02_ORCODSNTE insertORCODSNTE(int rep) throws HL7Exception { 
       return (ORD_O02_ORCODSNTE)super.insertRepetition("ORCODSNTE", rep);
    }


    /**
     * Removes a specific repetition of ORCODSNTE (a Group object)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public ORD_O02_ORCODSNTE removeORCODSNTE(int rep) throws HL7Exception { 
       return (ORD_O02_ORCODSNTE)super.removeRepetition("ORCODSNTE", rep);
    }



    /**
     * Returns
     * the first repetition of 
     * ORCODTNTE (a Group object) - creates it if necessary
     */
    public ORD_O02_ORCODTNTE getORCODTNTE() { 
       ORD_O02_ORCODTNTE retVal = getTyped("ORCODTNTE", ORD_O02_ORCODTNTE.class);
       return retVal;
    }


    /**
     * Returns a specific repetition of
     * ORCODTNTE (a Group object) - creates it if necessary
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public ORD_O02_ORCODTNTE getORCODTNTE(int rep) { 
       ORD_O02_ORCODTNTE retVal = getTyped("ORCODTNTE", rep, ORD_O02_ORCODTNTE.class);
       return retVal;
    }

    /** 
     * Returns the number of existing repetitions of ORCODTNTE 
     */ 
    public int getORCODTNTEReps() {  
        return getReps("ORCODTNTE");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of ORCODTNTE.
     * <p>
     * <p>
     * Note that unlike {@link #getORCODTNTE()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     */ 
    public java.util.List<ORD_O02_ORCODTNTE> getORCODTNTEAll() throws HL7Exception {
    	return getAllAsList("ORCODTNTE", ORD_O02_ORCODTNTE.class);
    } 

    /**
     * Inserts a specific repetition of ORCODTNTE (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertORCODTNTE(ORD_O02_ORCODTNTE structure, int rep) throws HL7Exception { 
       super.insertRepetition("ORCODTNTE", structure, rep);
    }


    /**
     * Inserts a specific repetition of ORCODTNTE (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public ORD_O02_ORCODTNTE insertORCODTNTE(int rep) throws HL7Exception { 
       return (ORD_O02_ORCODTNTE)super.insertRepetition("ORCODTNTE", rep);
    }


    /**
     * Removes a specific repetition of ORCODTNTE (a Group object)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public ORD_O02_ORCODTNTE removeORCODTNTE(int rep) throws HL7Exception { 
       return (ORD_O02_ORCODTNTE)super.removeRepetition("ORCODTNTE", rep);
    }



}

