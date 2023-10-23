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
 * <p>Represents a SUR_P09_FACPSHPDCPSHFACPDCNTE group structure (a Group object).
 * A Group is an ordered collection of message segments that can repeat together or be optionally in/excluded together.
 * This Group contains the following elements:  
 * </p>
 * <ul>
                         * <li>1: FAC (FAC - facility segment) <b>  </b></li>
                         * <li>2: SUR_P09_PSHPDC (a Group object) <b> repeating </b></li>
                         * <li>3: PSH (PSH - product summary header segment) <b>  </b></li>
                         * <li>4: SUR_P09_FACPDCNTE (a Group object) <b> repeating </b></li>
 * </ul>
 */
//@SuppressWarnings("unused")
public class SUR_P09_FACPSHPDCPSHFACPDCNTE extends AbstractGroup {

    /** 
     * Creates a new SUR_P09_FACPSHPDCPSHFACPDCNTE group
     */
    public SUR_P09_FACPSHPDCPSHFACPDCNTE(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(FAC.class, true, false, false);
                                  this.add(SUR_P09_PSHPDC.class, true, true, false);
                                  this.add(PSH.class, true, false, false);
                                  this.add(SUR_P09_FACPDCNTE.class, true, true, false);
       } catch(HL7Exception e) {
          log.error("Unexpected error creating SUR_P09_FACPSHPDCPSHFACPDCNTE - this is probably a bug in the source code generator.", e);
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
     * FAC (FAC - facility segment) - creates it if necessary
     */
    public FAC getFAC() { 
       FAC retVal = getTyped("FAC", FAC.class);
       return retVal;
    }




    /**
     * Returns
     * the first repetition of 
     * PSHPDC (a Group object) - creates it if necessary
     */
    public SUR_P09_PSHPDC getPSHPDC() { 
       SUR_P09_PSHPDC retVal = getTyped("PSHPDC", SUR_P09_PSHPDC.class);
       return retVal;
    }


    /**
     * Returns a specific repetition of
     * PSHPDC (a Group object) - creates it if necessary
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public SUR_P09_PSHPDC getPSHPDC(int rep) { 
       SUR_P09_PSHPDC retVal = getTyped("PSHPDC", rep, SUR_P09_PSHPDC.class);
       return retVal;
    }

    /** 
     * Returns the number of existing repetitions of PSHPDC 
     */ 
    public int getPSHPDCReps() {  
        return getReps("PSHPDC");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of PSHPDC.
     * <p>
     * <p>
     * Note that unlike {@link #getPSHPDC()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     */ 
    public java.util.List<SUR_P09_PSHPDC> getPSHPDCAll() throws HL7Exception {
    	return getAllAsList("PSHPDC", SUR_P09_PSHPDC.class);
    } 

    /**
     * Inserts a specific repetition of PSHPDC (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertPSHPDC(SUR_P09_PSHPDC structure, int rep) throws HL7Exception { 
       super.insertRepetition("PSHPDC", structure, rep);
    }


    /**
     * Inserts a specific repetition of PSHPDC (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public SUR_P09_PSHPDC insertPSHPDC(int rep) throws HL7Exception { 
       return (SUR_P09_PSHPDC)super.insertRepetition("PSHPDC", rep);
    }


    /**
     * Removes a specific repetition of PSHPDC (a Group object)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public SUR_P09_PSHPDC removePSHPDC(int rep) throws HL7Exception { 
       return (SUR_P09_PSHPDC)super.removeRepetition("PSHPDC", rep);
    }



    /**
     * Returns
     * PSH (PSH - product summary header segment) - creates it if necessary
     */
    public PSH getPSH() { 
       PSH retVal = getTyped("PSH", PSH.class);
       return retVal;
    }




    /**
     * Returns
     * the first repetition of 
     * FACPDCNTE (a Group object) - creates it if necessary
     */
    public SUR_P09_FACPDCNTE getFACPDCNTE() { 
       SUR_P09_FACPDCNTE retVal = getTyped("FACPDCNTE", SUR_P09_FACPDCNTE.class);
       return retVal;
    }


    /**
     * Returns a specific repetition of
     * FACPDCNTE (a Group object) - creates it if necessary
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public SUR_P09_FACPDCNTE getFACPDCNTE(int rep) { 
       SUR_P09_FACPDCNTE retVal = getTyped("FACPDCNTE", rep, SUR_P09_FACPDCNTE.class);
       return retVal;
    }

    /** 
     * Returns the number of existing repetitions of FACPDCNTE 
     */ 
    public int getFACPDCNTEReps() {  
        return getReps("FACPDCNTE");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of FACPDCNTE.
     * <p>
     * <p>
     * Note that unlike {@link #getFACPDCNTE()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     */ 
    public java.util.List<SUR_P09_FACPDCNTE> getFACPDCNTEAll() throws HL7Exception {
    	return getAllAsList("FACPDCNTE", SUR_P09_FACPDCNTE.class);
    } 

    /**
     * Inserts a specific repetition of FACPDCNTE (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertFACPDCNTE(SUR_P09_FACPDCNTE structure, int rep) throws HL7Exception { 
       super.insertRepetition("FACPDCNTE", structure, rep);
    }


    /**
     * Inserts a specific repetition of FACPDCNTE (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public SUR_P09_FACPDCNTE insertFACPDCNTE(int rep) throws HL7Exception { 
       return (SUR_P09_FACPDCNTE)super.insertRepetition("FACPDCNTE", rep);
    }


    /**
     * Removes a specific repetition of FACPDCNTE (a Group object)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public SUR_P09_FACPDCNTE removeFACPDCNTE(int rep) throws HL7Exception { 
       return (SUR_P09_FACPDCNTE)super.removeRepetition("FACPDCNTE", rep);
    }



}

