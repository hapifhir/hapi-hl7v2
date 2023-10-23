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


package ca.uhn.hl7v2.model.v27.group;

import ca.uhn.hl7v2.model.v27.segment.*;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.model.*;

/**
 * <p>Represents a CCI_I22_PATHWAY group structure (a Group object).
 * A Group is an ordered collection of message segments that can repeat together or be optionally in/excluded together.
 * This Group contains the following elements:  
 * </p>
 * <ul>
                         * <li>1: PTH (Pathway) <b>  </b></li>
                         * <li>2: VAR (Variance) <b>optional repeating </b></li>
                         * <li>3: CCI_I22_ROLE_PATHWAY (a Group object) <b>optional repeating </b></li>
                         * <li>4: OBX (Observation/Result) <b>optional repeating </b></li>
 * </ul>
 */
//@SuppressWarnings("unused")
public class CCI_I22_PATHWAY extends AbstractGroup {

    /** 
     * Creates a new CCI_I22_PATHWAY group
     */
    public CCI_I22_PATHWAY(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(PTH.class, true, false, false);
                                  this.add(VAR.class, false, true, false);
                                  this.add(CCI_I22_ROLE_PATHWAY.class, false, true, false);
                                  this.add(OBX.class, false, true, false);
       } catch(HL7Exception e) {
          log.error("Unexpected error creating CCI_I22_PATHWAY - this is probably a bug in the source code generator.", e);
       }
    }

    /** 
     * Returns "2.7"
     */
    public String getVersion() {
       return "2.7";
    }



    /**
     * Returns
     * PTH (Pathway) - creates it if necessary
     */
    public PTH getPTH() { 
       PTH retVal = getTyped("PTH", PTH.class);
       return retVal;
    }




    /**
     * Returns
     * the first repetition of 
     * VAR (Variance) - creates it if necessary
     */
    public VAR getVAR() { 
       VAR retVal = getTyped("VAR", VAR.class);
       return retVal;
    }


    /**
     * Returns a specific repetition of
     * VAR (Variance) - creates it if necessary
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public VAR getVAR(int rep) { 
       VAR retVal = getTyped("VAR", rep, VAR.class);
       return retVal;
    }

    /** 
     * Returns the number of existing repetitions of VAR 
     */ 
    public int getVARReps() {  
        return getReps("VAR");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of VAR.
     * <p>
     * <p>
     * Note that unlike {@link #getVAR()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     */ 
    public java.util.List<VAR> getVARAll() throws HL7Exception {
    	return getAllAsList("VAR", VAR.class);
    } 

    /**
     * Inserts a specific repetition of VAR (Variance)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertVAR(VAR structure, int rep) throws HL7Exception { 
       super.insertRepetition("VAR", structure, rep);
    }


    /**
     * Inserts a specific repetition of VAR (Variance)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public VAR insertVAR(int rep) throws HL7Exception { 
       return (VAR)super.insertRepetition("VAR", rep);
    }


    /**
     * Removes a specific repetition of VAR (Variance)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public VAR removeVAR(int rep) throws HL7Exception { 
       return (VAR)super.removeRepetition("VAR", rep);
    }



    /**
     * Returns
     * the first repetition of 
     * ROLE_PATHWAY (a Group object) - creates it if necessary
     */
    public CCI_I22_ROLE_PATHWAY getROLE_PATHWAY() { 
       CCI_I22_ROLE_PATHWAY retVal = getTyped("ROLE_PATHWAY", CCI_I22_ROLE_PATHWAY.class);
       return retVal;
    }


    /**
     * Returns a specific repetition of
     * ROLE_PATHWAY (a Group object) - creates it if necessary
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public CCI_I22_ROLE_PATHWAY getROLE_PATHWAY(int rep) { 
       CCI_I22_ROLE_PATHWAY retVal = getTyped("ROLE_PATHWAY", rep, CCI_I22_ROLE_PATHWAY.class);
       return retVal;
    }

    /** 
     * Returns the number of existing repetitions of ROLE_PATHWAY 
     */ 
    public int getROLE_PATHWAYReps() {  
        return getReps("ROLE_PATHWAY");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of ROLE_PATHWAY.
     * <p>
     * <p>
     * Note that unlike {@link #getROLE_PATHWAY()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     */ 
    public java.util.List<CCI_I22_ROLE_PATHWAY> getROLE_PATHWAYAll() throws HL7Exception {
    	return getAllAsList("ROLE_PATHWAY", CCI_I22_ROLE_PATHWAY.class);
    } 

    /**
     * Inserts a specific repetition of ROLE_PATHWAY (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertROLE_PATHWAY(CCI_I22_ROLE_PATHWAY structure, int rep) throws HL7Exception { 
       super.insertRepetition("ROLE_PATHWAY", structure, rep);
    }


    /**
     * Inserts a specific repetition of ROLE_PATHWAY (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public CCI_I22_ROLE_PATHWAY insertROLE_PATHWAY(int rep) throws HL7Exception { 
       return (CCI_I22_ROLE_PATHWAY)super.insertRepetition("ROLE_PATHWAY", rep);
    }


    /**
     * Removes a specific repetition of ROLE_PATHWAY (a Group object)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public CCI_I22_ROLE_PATHWAY removeROLE_PATHWAY(int rep) throws HL7Exception { 
       return (CCI_I22_ROLE_PATHWAY)super.removeRepetition("ROLE_PATHWAY", rep);
    }



    /**
     * Returns
     * the first repetition of 
     * OBX (Observation/Result) - creates it if necessary
     */
    public OBX getOBX() { 
       OBX retVal = getTyped("OBX", OBX.class);
       return retVal;
    }


    /**
     * Returns a specific repetition of
     * OBX (Observation/Result) - creates it if necessary
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public OBX getOBX(int rep) { 
       OBX retVal = getTyped("OBX", rep, OBX.class);
       return retVal;
    }

    /** 
     * Returns the number of existing repetitions of OBX 
     */ 
    public int getOBXReps() {  
        return getReps("OBX");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of OBX.
     * <p>
     * <p>
     * Note that unlike {@link #getOBX()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     */ 
    public java.util.List<OBX> getOBXAll() throws HL7Exception {
    	return getAllAsList("OBX", OBX.class);
    } 

    /**
     * Inserts a specific repetition of OBX (Observation/Result)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertOBX(OBX structure, int rep) throws HL7Exception { 
       super.insertRepetition("OBX", structure, rep);
    }


    /**
     * Inserts a specific repetition of OBX (Observation/Result)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public OBX insertOBX(int rep) throws HL7Exception { 
       return (OBX)super.insertRepetition("OBX", rep);
    }


    /**
     * Removes a specific repetition of OBX (Observation/Result)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public OBX removeOBX(int rep) throws HL7Exception { 
       return (OBX)super.removeRepetition("OBX", rep);
    }



}

