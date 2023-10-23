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
 * <p>Represents a SRR_S02_RESOURCES group structure (a Group object).
 * A Group is an ordered collection of message segments that can repeat together or be optionally in/excluded together.
 * This Group contains the following elements:  
 * </p>
 * <ul>
                         * <li>1: RGS (Resource Group) <b>  </b></li>
                         * <li>2: SRR_S02_SERVICE (a Group object) <b>optional repeating </b></li>
                         * <li>3: SRR_S02_GENERAL_RESOURCE (a Group object) <b>optional repeating </b></li>
                         * <li>4: SRR_S02_LOCATION_RESOURCE (a Group object) <b>optional repeating </b></li>
                         * <li>5: SRR_S02_PERSONNEL_RESOURCE (a Group object) <b>optional repeating </b></li>
 * </ul>
 */
//@SuppressWarnings("unused")
public class SRR_S02_RESOURCES extends AbstractGroup {

    /** 
     * Creates a new SRR_S02_RESOURCES group
     */
    public SRR_S02_RESOURCES(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(RGS.class, true, false, false);
                                  this.add(SRR_S02_SERVICE.class, false, true, false);
                                  this.add(SRR_S02_GENERAL_RESOURCE.class, false, true, false);
                                  this.add(SRR_S02_LOCATION_RESOURCE.class, false, true, false);
                                  this.add(SRR_S02_PERSONNEL_RESOURCE.class, false, true, false);
       } catch(HL7Exception e) {
          log.error("Unexpected error creating SRR_S02_RESOURCES - this is probably a bug in the source code generator.", e);
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
     * RGS (Resource Group) - creates it if necessary
     */
    public RGS getRGS() { 
       RGS retVal = getTyped("RGS", RGS.class);
       return retVal;
    }




    /**
     * Returns
     * the first repetition of 
     * SERVICE (a Group object) - creates it if necessary
     */
    public SRR_S02_SERVICE getSERVICE() { 
       SRR_S02_SERVICE retVal = getTyped("SERVICE", SRR_S02_SERVICE.class);
       return retVal;
    }


    /**
     * Returns a specific repetition of
     * SERVICE (a Group object) - creates it if necessary
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public SRR_S02_SERVICE getSERVICE(int rep) { 
       SRR_S02_SERVICE retVal = getTyped("SERVICE", rep, SRR_S02_SERVICE.class);
       return retVal;
    }

    /** 
     * Returns the number of existing repetitions of SERVICE 
     */ 
    public int getSERVICEReps() {  
        return getReps("SERVICE");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of SERVICE.
     * <p>
     * <p>
     * Note that unlike {@link #getSERVICE()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     */ 
    public java.util.List<SRR_S02_SERVICE> getSERVICEAll() throws HL7Exception {
    	return getAllAsList("SERVICE", SRR_S02_SERVICE.class);
    } 

    /**
     * Inserts a specific repetition of SERVICE (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertSERVICE(SRR_S02_SERVICE structure, int rep) throws HL7Exception { 
       super.insertRepetition("SERVICE", structure, rep);
    }


    /**
     * Inserts a specific repetition of SERVICE (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public SRR_S02_SERVICE insertSERVICE(int rep) throws HL7Exception { 
       return (SRR_S02_SERVICE)super.insertRepetition("SERVICE", rep);
    }


    /**
     * Removes a specific repetition of SERVICE (a Group object)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public SRR_S02_SERVICE removeSERVICE(int rep) throws HL7Exception { 
       return (SRR_S02_SERVICE)super.removeRepetition("SERVICE", rep);
    }



    /**
     * Returns
     * the first repetition of 
     * GENERAL_RESOURCE (a Group object) - creates it if necessary
     */
    public SRR_S02_GENERAL_RESOURCE getGENERAL_RESOURCE() { 
       SRR_S02_GENERAL_RESOURCE retVal = getTyped("GENERAL_RESOURCE", SRR_S02_GENERAL_RESOURCE.class);
       return retVal;
    }


    /**
     * Returns a specific repetition of
     * GENERAL_RESOURCE (a Group object) - creates it if necessary
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public SRR_S02_GENERAL_RESOURCE getGENERAL_RESOURCE(int rep) { 
       SRR_S02_GENERAL_RESOURCE retVal = getTyped("GENERAL_RESOURCE", rep, SRR_S02_GENERAL_RESOURCE.class);
       return retVal;
    }

    /** 
     * Returns the number of existing repetitions of GENERAL_RESOURCE 
     */ 
    public int getGENERAL_RESOURCEReps() {  
        return getReps("GENERAL_RESOURCE");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of GENERAL_RESOURCE.
     * <p>
     * <p>
     * Note that unlike {@link #getGENERAL_RESOURCE()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     */ 
    public java.util.List<SRR_S02_GENERAL_RESOURCE> getGENERAL_RESOURCEAll() throws HL7Exception {
    	return getAllAsList("GENERAL_RESOURCE", SRR_S02_GENERAL_RESOURCE.class);
    } 

    /**
     * Inserts a specific repetition of GENERAL_RESOURCE (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertGENERAL_RESOURCE(SRR_S02_GENERAL_RESOURCE structure, int rep) throws HL7Exception { 
       super.insertRepetition("GENERAL_RESOURCE", structure, rep);
    }


    /**
     * Inserts a specific repetition of GENERAL_RESOURCE (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public SRR_S02_GENERAL_RESOURCE insertGENERAL_RESOURCE(int rep) throws HL7Exception { 
       return (SRR_S02_GENERAL_RESOURCE)super.insertRepetition("GENERAL_RESOURCE", rep);
    }


    /**
     * Removes a specific repetition of GENERAL_RESOURCE (a Group object)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public SRR_S02_GENERAL_RESOURCE removeGENERAL_RESOURCE(int rep) throws HL7Exception { 
       return (SRR_S02_GENERAL_RESOURCE)super.removeRepetition("GENERAL_RESOURCE", rep);
    }



    /**
     * Returns
     * the first repetition of 
     * LOCATION_RESOURCE (a Group object) - creates it if necessary
     */
    public SRR_S02_LOCATION_RESOURCE getLOCATION_RESOURCE() { 
       SRR_S02_LOCATION_RESOURCE retVal = getTyped("LOCATION_RESOURCE", SRR_S02_LOCATION_RESOURCE.class);
       return retVal;
    }


    /**
     * Returns a specific repetition of
     * LOCATION_RESOURCE (a Group object) - creates it if necessary
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public SRR_S02_LOCATION_RESOURCE getLOCATION_RESOURCE(int rep) { 
       SRR_S02_LOCATION_RESOURCE retVal = getTyped("LOCATION_RESOURCE", rep, SRR_S02_LOCATION_RESOURCE.class);
       return retVal;
    }

    /** 
     * Returns the number of existing repetitions of LOCATION_RESOURCE 
     */ 
    public int getLOCATION_RESOURCEReps() {  
        return getReps("LOCATION_RESOURCE");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of LOCATION_RESOURCE.
     * <p>
     * <p>
     * Note that unlike {@link #getLOCATION_RESOURCE()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     */ 
    public java.util.List<SRR_S02_LOCATION_RESOURCE> getLOCATION_RESOURCEAll() throws HL7Exception {
    	return getAllAsList("LOCATION_RESOURCE", SRR_S02_LOCATION_RESOURCE.class);
    } 

    /**
     * Inserts a specific repetition of LOCATION_RESOURCE (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertLOCATION_RESOURCE(SRR_S02_LOCATION_RESOURCE structure, int rep) throws HL7Exception { 
       super.insertRepetition("LOCATION_RESOURCE", structure, rep);
    }


    /**
     * Inserts a specific repetition of LOCATION_RESOURCE (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public SRR_S02_LOCATION_RESOURCE insertLOCATION_RESOURCE(int rep) throws HL7Exception { 
       return (SRR_S02_LOCATION_RESOURCE)super.insertRepetition("LOCATION_RESOURCE", rep);
    }


    /**
     * Removes a specific repetition of LOCATION_RESOURCE (a Group object)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public SRR_S02_LOCATION_RESOURCE removeLOCATION_RESOURCE(int rep) throws HL7Exception { 
       return (SRR_S02_LOCATION_RESOURCE)super.removeRepetition("LOCATION_RESOURCE", rep);
    }



    /**
     * Returns
     * the first repetition of 
     * PERSONNEL_RESOURCE (a Group object) - creates it if necessary
     */
    public SRR_S02_PERSONNEL_RESOURCE getPERSONNEL_RESOURCE() { 
       SRR_S02_PERSONNEL_RESOURCE retVal = getTyped("PERSONNEL_RESOURCE", SRR_S02_PERSONNEL_RESOURCE.class);
       return retVal;
    }


    /**
     * Returns a specific repetition of
     * PERSONNEL_RESOURCE (a Group object) - creates it if necessary
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public SRR_S02_PERSONNEL_RESOURCE getPERSONNEL_RESOURCE(int rep) { 
       SRR_S02_PERSONNEL_RESOURCE retVal = getTyped("PERSONNEL_RESOURCE", rep, SRR_S02_PERSONNEL_RESOURCE.class);
       return retVal;
    }

    /** 
     * Returns the number of existing repetitions of PERSONNEL_RESOURCE 
     */ 
    public int getPERSONNEL_RESOURCEReps() {  
        return getReps("PERSONNEL_RESOURCE");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of PERSONNEL_RESOURCE.
     * <p>
     * <p>
     * Note that unlike {@link #getPERSONNEL_RESOURCE()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     */ 
    public java.util.List<SRR_S02_PERSONNEL_RESOURCE> getPERSONNEL_RESOURCEAll() throws HL7Exception {
    	return getAllAsList("PERSONNEL_RESOURCE", SRR_S02_PERSONNEL_RESOURCE.class);
    } 

    /**
     * Inserts a specific repetition of PERSONNEL_RESOURCE (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertPERSONNEL_RESOURCE(SRR_S02_PERSONNEL_RESOURCE structure, int rep) throws HL7Exception { 
       super.insertRepetition("PERSONNEL_RESOURCE", structure, rep);
    }


    /**
     * Inserts a specific repetition of PERSONNEL_RESOURCE (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public SRR_S02_PERSONNEL_RESOURCE insertPERSONNEL_RESOURCE(int rep) throws HL7Exception { 
       return (SRR_S02_PERSONNEL_RESOURCE)super.insertRepetition("PERSONNEL_RESOURCE", rep);
    }


    /**
     * Removes a specific repetition of PERSONNEL_RESOURCE (a Group object)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public SRR_S02_PERSONNEL_RESOURCE removePERSONNEL_RESOURCE(int rep) throws HL7Exception { 
       return (SRR_S02_PERSONNEL_RESOURCE)super.removeRepetition("PERSONNEL_RESOURCE", rep);
    }



}

