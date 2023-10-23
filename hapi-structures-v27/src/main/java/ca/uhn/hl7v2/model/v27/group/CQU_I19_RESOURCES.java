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
 * <p>Represents a CQU_I19_RESOURCES group structure (a Group object).
 * A Group is an ordered collection of message segments that can repeat together or be optionally in/excluded together.
 * This Group contains the following elements:  
 * </p>
 * <ul>
                         * <li>1: RGS (Resource Group) <b>  </b></li>
                         * <li>2: CQU_I19_RESOURCE_DETAIL (a Group object) <b>optional repeating </b></li>
 * </ul>
 */
//@SuppressWarnings("unused")
public class CQU_I19_RESOURCES extends AbstractGroup {

    /** 
     * Creates a new CQU_I19_RESOURCES group
     */
    public CQU_I19_RESOURCES(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(RGS.class, true, false, false);
                                  this.add(CQU_I19_RESOURCE_DETAIL.class, false, true, false);
       } catch(HL7Exception e) {
          log.error("Unexpected error creating CQU_I19_RESOURCES - this is probably a bug in the source code generator.", e);
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
     * RGS (Resource Group) - creates it if necessary
     */
    public RGS getRGS() { 
       RGS retVal = getTyped("RGS", RGS.class);
       return retVal;
    }




    /**
     * Returns
     * the first repetition of 
     * RESOURCE_DETAIL (a Group object) - creates it if necessary
     */
    public CQU_I19_RESOURCE_DETAIL getRESOURCE_DETAIL() { 
       CQU_I19_RESOURCE_DETAIL retVal = getTyped("RESOURCE_DETAIL", CQU_I19_RESOURCE_DETAIL.class);
       return retVal;
    }


    /**
     * Returns a specific repetition of
     * RESOURCE_DETAIL (a Group object) - creates it if necessary
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public CQU_I19_RESOURCE_DETAIL getRESOURCE_DETAIL(int rep) { 
       CQU_I19_RESOURCE_DETAIL retVal = getTyped("RESOURCE_DETAIL", rep, CQU_I19_RESOURCE_DETAIL.class);
       return retVal;
    }

    /** 
     * Returns the number of existing repetitions of RESOURCE_DETAIL 
     */ 
    public int getRESOURCE_DETAILReps() {  
        return getReps("RESOURCE_DETAIL");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of RESOURCE_DETAIL.
     * <p>
     * <p>
     * Note that unlike {@link #getRESOURCE_DETAIL()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     */ 
    public java.util.List<CQU_I19_RESOURCE_DETAIL> getRESOURCE_DETAILAll() throws HL7Exception {
    	return getAllAsList("RESOURCE_DETAIL", CQU_I19_RESOURCE_DETAIL.class);
    } 

    /**
     * Inserts a specific repetition of RESOURCE_DETAIL (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertRESOURCE_DETAIL(CQU_I19_RESOURCE_DETAIL structure, int rep) throws HL7Exception { 
       super.insertRepetition("RESOURCE_DETAIL", structure, rep);
    }


    /**
     * Inserts a specific repetition of RESOURCE_DETAIL (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public CQU_I19_RESOURCE_DETAIL insertRESOURCE_DETAIL(int rep) throws HL7Exception { 
       return (CQU_I19_RESOURCE_DETAIL)super.insertRepetition("RESOURCE_DETAIL", rep);
    }


    /**
     * Removes a specific repetition of RESOURCE_DETAIL (a Group object)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public CQU_I19_RESOURCE_DETAIL removeRESOURCE_DETAIL(int rep) throws HL7Exception { 
       return (CQU_I19_RESOURCE_DETAIL)super.removeRepetition("RESOURCE_DETAIL", rep);
    }



}

