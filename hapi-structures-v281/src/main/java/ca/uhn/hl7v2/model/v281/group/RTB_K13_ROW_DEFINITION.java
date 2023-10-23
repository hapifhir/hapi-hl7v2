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


package ca.uhn.hl7v2.model.v281.group;

import ca.uhn.hl7v2.model.v281.segment.*;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.model.*;

/**
 * <p>Represents a RTB_K13_ROW_DEFINITION group structure (a Group object).
 * A Group is an ordered collection of message segments that can repeat together or be optionally in/excluded together.
 * This Group contains the following elements:  
 * </p>
 * <ul>
                         * <li>1: RDF (Table Row Definition) <b>  </b></li>
                         * <li>2: RDT (Table Row Data) <b>optional repeating </b></li>
 * </ul>
 */
//@SuppressWarnings("unused")
public class RTB_K13_ROW_DEFINITION extends AbstractGroup {

    /** 
     * Creates a new RTB_K13_ROW_DEFINITION group
     */
    public RTB_K13_ROW_DEFINITION(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(RDF.class, true, false, false);
                                  this.add(RDT.class, false, true, false);
       } catch(HL7Exception e) {
          log.error("Unexpected error creating RTB_K13_ROW_DEFINITION - this is probably a bug in the source code generator.", e);
       }
    }

    /** 
     * Returns "2.8.1"
     */
    public String getVersion() {
       return "2.8.1";
    }



    /**
     * Returns
     * RDF (Table Row Definition) - creates it if necessary
     */
    public RDF getRDF() { 
       RDF retVal = getTyped("RDF", RDF.class);
       return retVal;
    }




    /**
     * Returns
     * the first repetition of 
     * RDT (Table Row Data) - creates it if necessary
     */
    public RDT getRDT() { 
       RDT retVal = getTyped("RDT", RDT.class);
       return retVal;
    }


    /**
     * Returns a specific repetition of
     * RDT (Table Row Data) - creates it if necessary
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public RDT getRDT(int rep) { 
       RDT retVal = getTyped("RDT", rep, RDT.class);
       return retVal;
    }

    /** 
     * Returns the number of existing repetitions of RDT 
     */ 
    public int getRDTReps() {  
        return getReps("RDT");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of RDT.
     * <p>
     * <p>
     * Note that unlike {@link #getRDT()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     */ 
    public java.util.List<RDT> getRDTAll() throws HL7Exception {
    	return getAllAsList("RDT", RDT.class);
    } 

    /**
     * Inserts a specific repetition of RDT (Table Row Data)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertRDT(RDT structure, int rep) throws HL7Exception { 
       super.insertRepetition("RDT", structure, rep);
    }


    /**
     * Inserts a specific repetition of RDT (Table Row Data)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public RDT insertRDT(int rep) throws HL7Exception { 
       return (RDT)super.insertRepetition("RDT", rep);
    }


    /**
     * Removes a specific repetition of RDT (Table Row Data)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public RDT removeRDT(int rep) throws HL7Exception { 
       return (RDT)super.removeRepetition("RDT", rep);
    }



}

