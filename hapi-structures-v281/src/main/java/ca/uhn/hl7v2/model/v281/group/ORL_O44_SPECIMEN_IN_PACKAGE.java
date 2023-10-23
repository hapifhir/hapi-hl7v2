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
 * <p>Represents a ORL_O44_SPECIMEN_IN_PACKAGE group structure (a Group object).
 * A Group is an ordered collection of message segments that can repeat together or be optionally in/excluded together.
 * This Group contains the following elements:  
 * </p>
 * <ul>
                         * <li>1: SPM (Specimen) <b>  </b></li>
                         * <li>2: ORL_O44_SPECIMEN_CONTAINER_IN_PACKAGE (a Group object) <b>optional repeating </b></li>
 * </ul>
 */
//@SuppressWarnings("unused")
public class ORL_O44_SPECIMEN_IN_PACKAGE extends AbstractGroup {

    /** 
     * Creates a new ORL_O44_SPECIMEN_IN_PACKAGE group
     */
    public ORL_O44_SPECIMEN_IN_PACKAGE(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(SPM.class, true, false, false);
                                  this.add(ORL_O44_SPECIMEN_CONTAINER_IN_PACKAGE.class, false, true, false);
       } catch(HL7Exception e) {
          log.error("Unexpected error creating ORL_O44_SPECIMEN_IN_PACKAGE - this is probably a bug in the source code generator.", e);
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
     * SPM (Specimen) - creates it if necessary
     */
    public SPM getSPM() { 
       SPM retVal = getTyped("SPM", SPM.class);
       return retVal;
    }




    /**
     * Returns
     * the first repetition of 
     * SPECIMEN_CONTAINER_IN_PACKAGE (a Group object) - creates it if necessary
     */
    public ORL_O44_SPECIMEN_CONTAINER_IN_PACKAGE getSPECIMEN_CONTAINER_IN_PACKAGE() { 
       ORL_O44_SPECIMEN_CONTAINER_IN_PACKAGE retVal = getTyped("SPECIMEN_CONTAINER_IN_PACKAGE", ORL_O44_SPECIMEN_CONTAINER_IN_PACKAGE.class);
       return retVal;
    }


    /**
     * Returns a specific repetition of
     * SPECIMEN_CONTAINER_IN_PACKAGE (a Group object) - creates it if necessary
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public ORL_O44_SPECIMEN_CONTAINER_IN_PACKAGE getSPECIMEN_CONTAINER_IN_PACKAGE(int rep) { 
       ORL_O44_SPECIMEN_CONTAINER_IN_PACKAGE retVal = getTyped("SPECIMEN_CONTAINER_IN_PACKAGE", rep, ORL_O44_SPECIMEN_CONTAINER_IN_PACKAGE.class);
       return retVal;
    }

    /** 
     * Returns the number of existing repetitions of SPECIMEN_CONTAINER_IN_PACKAGE 
     */ 
    public int getSPECIMEN_CONTAINER_IN_PACKAGEReps() {  
        return getReps("SPECIMEN_CONTAINER_IN_PACKAGE");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of SPECIMEN_CONTAINER_IN_PACKAGE.
     * <p>
     * <p>
     * Note that unlike {@link #getSPECIMEN_CONTAINER_IN_PACKAGE()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     */ 
    public java.util.List<ORL_O44_SPECIMEN_CONTAINER_IN_PACKAGE> getSPECIMEN_CONTAINER_IN_PACKAGEAll() throws HL7Exception {
    	return getAllAsList("SPECIMEN_CONTAINER_IN_PACKAGE", ORL_O44_SPECIMEN_CONTAINER_IN_PACKAGE.class);
    } 

    /**
     * Inserts a specific repetition of SPECIMEN_CONTAINER_IN_PACKAGE (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertSPECIMEN_CONTAINER_IN_PACKAGE(ORL_O44_SPECIMEN_CONTAINER_IN_PACKAGE structure, int rep) throws HL7Exception { 
       super.insertRepetition("SPECIMEN_CONTAINER_IN_PACKAGE", structure, rep);
    }


    /**
     * Inserts a specific repetition of SPECIMEN_CONTAINER_IN_PACKAGE (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public ORL_O44_SPECIMEN_CONTAINER_IN_PACKAGE insertSPECIMEN_CONTAINER_IN_PACKAGE(int rep) throws HL7Exception { 
       return (ORL_O44_SPECIMEN_CONTAINER_IN_PACKAGE)super.insertRepetition("SPECIMEN_CONTAINER_IN_PACKAGE", rep);
    }


    /**
     * Removes a specific repetition of SPECIMEN_CONTAINER_IN_PACKAGE (a Group object)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public ORL_O44_SPECIMEN_CONTAINER_IN_PACKAGE removeSPECIMEN_CONTAINER_IN_PACKAGE(int rep) throws HL7Exception { 
       return (ORL_O44_SPECIMEN_CONTAINER_IN_PACKAGE)super.removeRepetition("SPECIMEN_CONTAINER_IN_PACKAGE", rep);
    }



}

