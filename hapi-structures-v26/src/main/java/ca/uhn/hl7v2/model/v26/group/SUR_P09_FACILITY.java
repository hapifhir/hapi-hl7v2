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


package ca.uhn.hl7v2.model.v26.group;

import ca.uhn.hl7v2.model.v26.segment.*;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.model.*;

/**
 * <p>Represents a SUR_P09_FACILITY group structure (a Group object).
 * A Group is an ordered collection of message segments that can repeat together or be optionally in/excluded together.
 * This Group contains the following elements:  
 * </p>
 * <ul>
                         * <li>1: FAC (Facility) <b>  </b></li>
                         * <li>2: SUR_P09_PRODUCT (a Group object) <b> repeating </b></li>
                         * <li>3: PSH (Product Summary Header) <b>  </b></li>
                         * <li>4: SUR_P09_FACILITY_DETAIL (a Group object) <b> repeating </b></li>
 * </ul>
 */
//@SuppressWarnings("unused")
public class SUR_P09_FACILITY extends AbstractGroup {

    /** 
     * Creates a new SUR_P09_FACILITY group
     */
    public SUR_P09_FACILITY(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(FAC.class, true, false, false);
                                  this.add(SUR_P09_PRODUCT.class, true, true, false);
                                  this.add(PSH.class, true, false, false);
                                  this.add(SUR_P09_FACILITY_DETAIL.class, true, true, false);
       } catch(HL7Exception e) {
          log.error("Unexpected error creating SUR_P09_FACILITY - this is probably a bug in the source code generator.", e);
       }
    }

    /** 
     * Returns "2.6"
     */
    public String getVersion() {
       return "2.6";
    }



    /**
     * Returns
     * FAC (Facility) - creates it if necessary
     */
    public FAC getFAC() { 
       FAC retVal = getTyped("FAC", FAC.class);
       return retVal;
    }




    /**
     * Returns
     * the first repetition of 
     * PRODUCT (a Group object) - creates it if necessary
     */
    public SUR_P09_PRODUCT getPRODUCT() { 
       SUR_P09_PRODUCT retVal = getTyped("PRODUCT", SUR_P09_PRODUCT.class);
       return retVal;
    }


    /**
     * Returns a specific repetition of
     * PRODUCT (a Group object) - creates it if necessary
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public SUR_P09_PRODUCT getPRODUCT(int rep) { 
       SUR_P09_PRODUCT retVal = getTyped("PRODUCT", rep, SUR_P09_PRODUCT.class);
       return retVal;
    }

    /** 
     * Returns the number of existing repetitions of PRODUCT 
     */ 
    public int getPRODUCTReps() {  
        return getReps("PRODUCT");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of PRODUCT.
     * <p>
     * <p>
     * Note that unlike {@link #getPRODUCT()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     */ 
    public java.util.List<SUR_P09_PRODUCT> getPRODUCTAll() throws HL7Exception {
    	return getAllAsList("PRODUCT", SUR_P09_PRODUCT.class);
    } 

    /**
     * Inserts a specific repetition of PRODUCT (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertPRODUCT(SUR_P09_PRODUCT structure, int rep) throws HL7Exception { 
       super.insertRepetition("PRODUCT", structure, rep);
    }


    /**
     * Inserts a specific repetition of PRODUCT (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public SUR_P09_PRODUCT insertPRODUCT(int rep) throws HL7Exception { 
       return (SUR_P09_PRODUCT)super.insertRepetition("PRODUCT", rep);
    }


    /**
     * Removes a specific repetition of PRODUCT (a Group object)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public SUR_P09_PRODUCT removePRODUCT(int rep) throws HL7Exception { 
       return (SUR_P09_PRODUCT)super.removeRepetition("PRODUCT", rep);
    }



    /**
     * Returns
     * PSH (Product Summary Header) - creates it if necessary
     */
    public PSH getPSH() { 
       PSH retVal = getTyped("PSH", PSH.class);
       return retVal;
    }




    /**
     * Returns
     * the first repetition of 
     * FACILITY_DETAIL (a Group object) - creates it if necessary
     */
    public SUR_P09_FACILITY_DETAIL getFACILITY_DETAIL() { 
       SUR_P09_FACILITY_DETAIL retVal = getTyped("FACILITY_DETAIL", SUR_P09_FACILITY_DETAIL.class);
       return retVal;
    }


    /**
     * Returns a specific repetition of
     * FACILITY_DETAIL (a Group object) - creates it if necessary
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public SUR_P09_FACILITY_DETAIL getFACILITY_DETAIL(int rep) { 
       SUR_P09_FACILITY_DETAIL retVal = getTyped("FACILITY_DETAIL", rep, SUR_P09_FACILITY_DETAIL.class);
       return retVal;
    }

    /** 
     * Returns the number of existing repetitions of FACILITY_DETAIL 
     */ 
    public int getFACILITY_DETAILReps() {  
        return getReps("FACILITY_DETAIL");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of FACILITY_DETAIL.
     * <p>
     * <p>
     * Note that unlike {@link #getFACILITY_DETAIL()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     */ 
    public java.util.List<SUR_P09_FACILITY_DETAIL> getFACILITY_DETAILAll() throws HL7Exception {
    	return getAllAsList("FACILITY_DETAIL", SUR_P09_FACILITY_DETAIL.class);
    } 

    /**
     * Inserts a specific repetition of FACILITY_DETAIL (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertFACILITY_DETAIL(SUR_P09_FACILITY_DETAIL structure, int rep) throws HL7Exception { 
       super.insertRepetition("FACILITY_DETAIL", structure, rep);
    }


    /**
     * Inserts a specific repetition of FACILITY_DETAIL (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public SUR_P09_FACILITY_DETAIL insertFACILITY_DETAIL(int rep) throws HL7Exception { 
       return (SUR_P09_FACILITY_DETAIL)super.insertRepetition("FACILITY_DETAIL", rep);
    }


    /**
     * Removes a specific repetition of FACILITY_DETAIL (a Group object)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public SUR_P09_FACILITY_DETAIL removeFACILITY_DETAIL(int rep) throws HL7Exception { 
       return (SUR_P09_FACILITY_DETAIL)super.removeRepetition("FACILITY_DETAIL", rep);
    }



}

