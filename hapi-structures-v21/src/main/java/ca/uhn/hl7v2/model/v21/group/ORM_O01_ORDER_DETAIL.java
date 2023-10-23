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


package ca.uhn.hl7v2.model.v21.group;

import ca.uhn.hl7v2.model.v21.segment.*;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.model.*;

/**
 * <p>Represents a ORM_O01_ORDER_DETAIL group structure (a Group object).
 * A Group is an ordered collection of message segments that can repeat together or be optionally in/excluded together.
 * This Group contains the following elements:  
 * </p>
 * <ul>
                         * <li>1: OBR (OBSERVATION REQUEST) <b>  choice</b></li>
                         * <li>2: ORO (ORDER OTHER) <b>  choice</b></li>
                         * <li>3: RX1 (PHARMACY ORDER) <b>  choice</b></li>
                         * <li>4: NTE (NOTES AND COMMENTS) <b>optional repeating </b></li>
                         * <li>5: OBX (RESULT) <b>optional repeating </b></li>
                         * <li>6: NTE (NOTES AND COMMENTS) <b>optional repeating </b></li>
 * </ul>
 * <p>
 * Note that this structure has "choice" elements. This means that one of the 
 * structures above marked as "choice" must be present, but no more than one.
 * </p> 
 */
//@SuppressWarnings("unused")
public class ORM_O01_ORDER_DETAIL extends AbstractGroup {

    /** 
     * Creates a new ORM_O01_ORDER_DETAIL group
     */
    public ORM_O01_ORDER_DETAIL(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(OBR.class, true, false, true);
                                  this.add(ORO.class, true, false, true);
                                  this.add(RX1.class, true, false, true);
                                  this.add(NTE.class, false, true, false);
                                  this.add(OBX.class, false, true, false);
                                  this.add(NTE.class, false, true, false);
       } catch(HL7Exception e) {
          log.error("Unexpected error creating ORM_O01_ORDER_DETAIL - this is probably a bug in the source code generator.", e);
       }
    }

    /** 
     * Returns "2.1"
     */
    public String getVersion() {
       return "2.1";
    }



    /**
     * Returns
     * OBR (OBSERVATION REQUEST) - creates it if necessary
     */
    public OBR getOBR() { 
       OBR retVal = getTyped("OBR", OBR.class);
       return retVal;
    }




    /**
     * Returns
     * ORO (ORDER OTHER) - creates it if necessary
     */
    public ORO getORO() { 
       ORO retVal = getTyped("ORO", ORO.class);
       return retVal;
    }




    /**
     * Returns
     * RX1 (PHARMACY ORDER) - creates it if necessary
     */
    public RX1 getRX1() { 
       RX1 retVal = getTyped("RX1", RX1.class);
       return retVal;
    }




    /**
     * Returns
     * the first repetition of 
     * NTE (NOTES AND COMMENTS) - creates it if necessary
     */
    public NTE getNTE() { 
       NTE retVal = getTyped("NTE", NTE.class);
       return retVal;
    }


    /**
     * Returns a specific repetition of
     * NTE (NOTES AND COMMENTS) - creates it if necessary
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public NTE getNTE(int rep) { 
       NTE retVal = getTyped("NTE", rep, NTE.class);
       return retVal;
    }

    /** 
     * Returns the number of existing repetitions of NTE 
     */ 
    public int getNTEReps() {  
        return getReps("NTE");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of NTE.
     * <p>
     * <p>
     * Note that unlike {@link #getNTE()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     */ 
    public java.util.List<NTE> getNTEAll() throws HL7Exception {
    	return getAllAsList("NTE", NTE.class);
    } 

    /**
     * Inserts a specific repetition of NTE (NOTES AND COMMENTS)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertNTE(NTE structure, int rep) throws HL7Exception { 
       super.insertRepetition("NTE", structure, rep);
    }


    /**
     * Inserts a specific repetition of NTE (NOTES AND COMMENTS)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public NTE insertNTE(int rep) throws HL7Exception { 
       return (NTE)super.insertRepetition("NTE", rep);
    }


    /**
     * Removes a specific repetition of NTE (NOTES AND COMMENTS)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public NTE removeNTE(int rep) throws HL7Exception { 
       return (NTE)super.removeRepetition("NTE", rep);
    }



    /**
     * Returns
     * the first repetition of 
     * OBX (RESULT) - creates it if necessary
     */
    public OBX getOBX() { 
       OBX retVal = getTyped("OBX", OBX.class);
       return retVal;
    }


    /**
     * Returns a specific repetition of
     * OBX (RESULT) - creates it if necessary
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
     * Inserts a specific repetition of OBX (RESULT)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertOBX(OBX structure, int rep) throws HL7Exception { 
       super.insertRepetition("OBX", structure, rep);
    }


    /**
     * Inserts a specific repetition of OBX (RESULT)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public OBX insertOBX(int rep) throws HL7Exception { 
       return (OBX)super.insertRepetition("OBX", rep);
    }


    /**
     * Removes a specific repetition of OBX (RESULT)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public OBX removeOBX(int rep) throws HL7Exception { 
       return (OBX)super.removeRepetition("OBX", rep);
    }



    /**
     * Returns
     * the first repetition of 
     * NTE2 (NOTES AND COMMENTS) - creates it if necessary
     */
    public NTE getNTE2() { 
       NTE retVal = getTyped("NTE2", NTE.class);
       return retVal;
    }


    /**
     * Returns a specific repetition of
     * NTE (NOTES AND COMMENTS) - creates it if necessary
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public NTE getNTE2(int rep) { 
       NTE retVal = getTyped("NTE2", rep, NTE.class);
       return retVal;
    }

    /** 
     * Returns the number of existing repetitions of NTE2 
     */ 
    public int getNTE2Reps() {  
        return getReps("NTE2");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of NTE2.
     * <p>
     * <p>
     * Note that unlike {@link #getNTE2()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     */ 
    public java.util.List<NTE> getNTE2All() throws HL7Exception {
    	return getAllAsList("NTE2", NTE.class);
    } 

    /**
     * Inserts a specific repetition of NTE2 (NOTES AND COMMENTS)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertNTE2(NTE structure, int rep) throws HL7Exception { 
       super.insertRepetition("NTE2", structure, rep);
    }


    /**
     * Inserts a specific repetition of NTE2 (NOTES AND COMMENTS)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public NTE insertNTE2(int rep) throws HL7Exception { 
       return (NTE)super.insertRepetition("NTE2", rep);
    }


    /**
     * Removes a specific repetition of NTE2 (NOTES AND COMMENTS)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public NTE removeNTE2(int rep) throws HL7Exception { 
       return (NTE)super.removeRepetition("NTE2", rep);
    }



}

