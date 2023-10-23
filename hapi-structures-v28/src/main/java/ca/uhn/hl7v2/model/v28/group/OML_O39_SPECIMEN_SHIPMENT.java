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
 * <p>Represents a OML_O39_SPECIMEN_SHIPMENT group structure (a Group object).
 * A Group is an ordered collection of message segments that can repeat together or be optionally in/excluded together.
 * This Group contains the following elements:  
 * </p>
 * <ul>
                         * <li>1: SHP (Shipment) <b>  </b></li>
                         * <li>2: OML_O39_SHIPMENT_OBSERVATION (a Group object) <b>optional repeating </b></li>
                         * <li>3: OML_O39_PACKAGE (a Group object) <b> repeating </b></li>
 * </ul>
 */
//@SuppressWarnings("unused")
public class OML_O39_SPECIMEN_SHIPMENT extends AbstractGroup {

    /** 
     * Creates a new OML_O39_SPECIMEN_SHIPMENT group
     */
    public OML_O39_SPECIMEN_SHIPMENT(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(SHP.class, true, false, false);
                                  this.add(OML_O39_SHIPMENT_OBSERVATION.class, false, true, false);
                                  this.add(OML_O39_PACKAGE.class, true, true, false);
       } catch(HL7Exception e) {
          log.error("Unexpected error creating OML_O39_SPECIMEN_SHIPMENT - this is probably a bug in the source code generator.", e);
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
     * SHP (Shipment) - creates it if necessary
     */
    public SHP getSHP() { 
       SHP retVal = getTyped("SHP", SHP.class);
       return retVal;
    }




    /**
     * Returns
     * the first repetition of 
     * SHIPMENT_OBSERVATION (a Group object) - creates it if necessary
     */
    public OML_O39_SHIPMENT_OBSERVATION getSHIPMENT_OBSERVATION() { 
       OML_O39_SHIPMENT_OBSERVATION retVal = getTyped("SHIPMENT_OBSERVATION", OML_O39_SHIPMENT_OBSERVATION.class);
       return retVal;
    }


    /**
     * Returns a specific repetition of
     * SHIPMENT_OBSERVATION (a Group object) - creates it if necessary
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public OML_O39_SHIPMENT_OBSERVATION getSHIPMENT_OBSERVATION(int rep) { 
       OML_O39_SHIPMENT_OBSERVATION retVal = getTyped("SHIPMENT_OBSERVATION", rep, OML_O39_SHIPMENT_OBSERVATION.class);
       return retVal;
    }

    /** 
     * Returns the number of existing repetitions of SHIPMENT_OBSERVATION 
     */ 
    public int getSHIPMENT_OBSERVATIONReps() {  
        return getReps("SHIPMENT_OBSERVATION");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of SHIPMENT_OBSERVATION.
     * <p>
     * <p>
     * Note that unlike {@link #getSHIPMENT_OBSERVATION()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     */ 
    public java.util.List<OML_O39_SHIPMENT_OBSERVATION> getSHIPMENT_OBSERVATIONAll() throws HL7Exception {
    	return getAllAsList("SHIPMENT_OBSERVATION", OML_O39_SHIPMENT_OBSERVATION.class);
    } 

    /**
     * Inserts a specific repetition of SHIPMENT_OBSERVATION (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertSHIPMENT_OBSERVATION(OML_O39_SHIPMENT_OBSERVATION structure, int rep) throws HL7Exception { 
       super.insertRepetition("SHIPMENT_OBSERVATION", structure, rep);
    }


    /**
     * Inserts a specific repetition of SHIPMENT_OBSERVATION (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public OML_O39_SHIPMENT_OBSERVATION insertSHIPMENT_OBSERVATION(int rep) throws HL7Exception { 
       return (OML_O39_SHIPMENT_OBSERVATION)super.insertRepetition("SHIPMENT_OBSERVATION", rep);
    }


    /**
     * Removes a specific repetition of SHIPMENT_OBSERVATION (a Group object)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public OML_O39_SHIPMENT_OBSERVATION removeSHIPMENT_OBSERVATION(int rep) throws HL7Exception { 
       return (OML_O39_SHIPMENT_OBSERVATION)super.removeRepetition("SHIPMENT_OBSERVATION", rep);
    }



    /**
     * Returns
     * the first repetition of 
     * PACKAGE (a Group object) - creates it if necessary
     */
    public OML_O39_PACKAGE getPACKAGE() { 
       OML_O39_PACKAGE retVal = getTyped("PACKAGE", OML_O39_PACKAGE.class);
       return retVal;
    }


    /**
     * Returns a specific repetition of
     * PACKAGE (a Group object) - creates it if necessary
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public OML_O39_PACKAGE getPACKAGE(int rep) { 
       OML_O39_PACKAGE retVal = getTyped("PACKAGE", rep, OML_O39_PACKAGE.class);
       return retVal;
    }

    /** 
     * Returns the number of existing repetitions of PACKAGE 
     */ 
    public int getPACKAGEReps() {  
        return getReps("PACKAGE");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of PACKAGE.
     * <p>
     * <p>
     * Note that unlike {@link #getPACKAGE()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     */ 
    public java.util.List<OML_O39_PACKAGE> getPACKAGEAll() throws HL7Exception {
    	return getAllAsList("PACKAGE", OML_O39_PACKAGE.class);
    } 

    /**
     * Inserts a specific repetition of PACKAGE (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertPACKAGE(OML_O39_PACKAGE structure, int rep) throws HL7Exception { 
       super.insertRepetition("PACKAGE", structure, rep);
    }


    /**
     * Inserts a specific repetition of PACKAGE (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public OML_O39_PACKAGE insertPACKAGE(int rep) throws HL7Exception { 
       return (OML_O39_PACKAGE)super.insertRepetition("PACKAGE", rep);
    }


    /**
     * Removes a specific repetition of PACKAGE (a Group object)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public OML_O39_PACKAGE removePACKAGE(int rep) throws HL7Exception { 
       return (OML_O39_PACKAGE)super.removeRepetition("PACKAGE", rep);
    }



}

