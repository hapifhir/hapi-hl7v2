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
 * <p>Represents a SQM_S25_RGSAISAPRAIGAPRAIPAPRAILAPR group structure (a Group object).
 * A Group is an ordered collection of message segments that can repeat together or be optionally in/excluded together.
 * This Group contains the following elements:  
 * </p>
 * <ul>
                         * <li>1: RGS (RGS - resource group segment) <b>  </b></li>
                         * <li>2: SQM_S25_AISAPR (a Group object) <b>optional repeating </b></li>
                         * <li>3: SQM_S25_AIGAPR (a Group object) <b>optional repeating </b></li>
                         * <li>4: SQM_S25_AIPAPR (a Group object) <b>optional repeating </b></li>
                         * <li>5: SQM_S25_AILAPR (a Group object) <b>optional repeating </b></li>
 * </ul>
 */
//@SuppressWarnings("unused")
public class SQM_S25_RGSAISAPRAIGAPRAIPAPRAILAPR extends AbstractGroup {

    /** 
     * Creates a new SQM_S25_RGSAISAPRAIGAPRAIPAPRAILAPR group
     */
    public SQM_S25_RGSAISAPRAIGAPRAIPAPRAILAPR(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(RGS.class, true, false, false);
                                  this.add(SQM_S25_AISAPR.class, false, true, false);
                                  this.add(SQM_S25_AIGAPR.class, false, true, false);
                                  this.add(SQM_S25_AIPAPR.class, false, true, false);
                                  this.add(SQM_S25_AILAPR.class, false, true, false);
       } catch(HL7Exception e) {
          log.error("Unexpected error creating SQM_S25_RGSAISAPRAIGAPRAIPAPRAILAPR - this is probably a bug in the source code generator.", e);
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
     * RGS (RGS - resource group segment) - creates it if necessary
     */
    public RGS getRGS() { 
       RGS retVal = getTyped("RGS", RGS.class);
       return retVal;
    }




    /**
     * Returns
     * the first repetition of 
     * AISAPR (a Group object) - creates it if necessary
     */
    public SQM_S25_AISAPR getAISAPR() { 
       SQM_S25_AISAPR retVal = getTyped("AISAPR", SQM_S25_AISAPR.class);
       return retVal;
    }


    /**
     * Returns a specific repetition of
     * AISAPR (a Group object) - creates it if necessary
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public SQM_S25_AISAPR getAISAPR(int rep) { 
       SQM_S25_AISAPR retVal = getTyped("AISAPR", rep, SQM_S25_AISAPR.class);
       return retVal;
    }

    /** 
     * Returns the number of existing repetitions of AISAPR 
     */ 
    public int getAISAPRReps() {  
        return getReps("AISAPR");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of AISAPR.
     * <p>
     * <p>
     * Note that unlike {@link #getAISAPR()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     */ 
    public java.util.List<SQM_S25_AISAPR> getAISAPRAll() throws HL7Exception {
    	return getAllAsList("AISAPR", SQM_S25_AISAPR.class);
    } 

    /**
     * Inserts a specific repetition of AISAPR (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertAISAPR(SQM_S25_AISAPR structure, int rep) throws HL7Exception { 
       super.insertRepetition("AISAPR", structure, rep);
    }


    /**
     * Inserts a specific repetition of AISAPR (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public SQM_S25_AISAPR insertAISAPR(int rep) throws HL7Exception { 
       return (SQM_S25_AISAPR)super.insertRepetition("AISAPR", rep);
    }


    /**
     * Removes a specific repetition of AISAPR (a Group object)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public SQM_S25_AISAPR removeAISAPR(int rep) throws HL7Exception { 
       return (SQM_S25_AISAPR)super.removeRepetition("AISAPR", rep);
    }



    /**
     * Returns
     * the first repetition of 
     * AIGAPR (a Group object) - creates it if necessary
     */
    public SQM_S25_AIGAPR getAIGAPR() { 
       SQM_S25_AIGAPR retVal = getTyped("AIGAPR", SQM_S25_AIGAPR.class);
       return retVal;
    }


    /**
     * Returns a specific repetition of
     * AIGAPR (a Group object) - creates it if necessary
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public SQM_S25_AIGAPR getAIGAPR(int rep) { 
       SQM_S25_AIGAPR retVal = getTyped("AIGAPR", rep, SQM_S25_AIGAPR.class);
       return retVal;
    }

    /** 
     * Returns the number of existing repetitions of AIGAPR 
     */ 
    public int getAIGAPRReps() {  
        return getReps("AIGAPR");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of AIGAPR.
     * <p>
     * <p>
     * Note that unlike {@link #getAIGAPR()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     */ 
    public java.util.List<SQM_S25_AIGAPR> getAIGAPRAll() throws HL7Exception {
    	return getAllAsList("AIGAPR", SQM_S25_AIGAPR.class);
    } 

    /**
     * Inserts a specific repetition of AIGAPR (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertAIGAPR(SQM_S25_AIGAPR structure, int rep) throws HL7Exception { 
       super.insertRepetition("AIGAPR", structure, rep);
    }


    /**
     * Inserts a specific repetition of AIGAPR (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public SQM_S25_AIGAPR insertAIGAPR(int rep) throws HL7Exception { 
       return (SQM_S25_AIGAPR)super.insertRepetition("AIGAPR", rep);
    }


    /**
     * Removes a specific repetition of AIGAPR (a Group object)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public SQM_S25_AIGAPR removeAIGAPR(int rep) throws HL7Exception { 
       return (SQM_S25_AIGAPR)super.removeRepetition("AIGAPR", rep);
    }



    /**
     * Returns
     * the first repetition of 
     * AIPAPR (a Group object) - creates it if necessary
     */
    public SQM_S25_AIPAPR getAIPAPR() { 
       SQM_S25_AIPAPR retVal = getTyped("AIPAPR", SQM_S25_AIPAPR.class);
       return retVal;
    }


    /**
     * Returns a specific repetition of
     * AIPAPR (a Group object) - creates it if necessary
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public SQM_S25_AIPAPR getAIPAPR(int rep) { 
       SQM_S25_AIPAPR retVal = getTyped("AIPAPR", rep, SQM_S25_AIPAPR.class);
       return retVal;
    }

    /** 
     * Returns the number of existing repetitions of AIPAPR 
     */ 
    public int getAIPAPRReps() {  
        return getReps("AIPAPR");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of AIPAPR.
     * <p>
     * <p>
     * Note that unlike {@link #getAIPAPR()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     */ 
    public java.util.List<SQM_S25_AIPAPR> getAIPAPRAll() throws HL7Exception {
    	return getAllAsList("AIPAPR", SQM_S25_AIPAPR.class);
    } 

    /**
     * Inserts a specific repetition of AIPAPR (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertAIPAPR(SQM_S25_AIPAPR structure, int rep) throws HL7Exception { 
       super.insertRepetition("AIPAPR", structure, rep);
    }


    /**
     * Inserts a specific repetition of AIPAPR (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public SQM_S25_AIPAPR insertAIPAPR(int rep) throws HL7Exception { 
       return (SQM_S25_AIPAPR)super.insertRepetition("AIPAPR", rep);
    }


    /**
     * Removes a specific repetition of AIPAPR (a Group object)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public SQM_S25_AIPAPR removeAIPAPR(int rep) throws HL7Exception { 
       return (SQM_S25_AIPAPR)super.removeRepetition("AIPAPR", rep);
    }



    /**
     * Returns
     * the first repetition of 
     * AILAPR (a Group object) - creates it if necessary
     */
    public SQM_S25_AILAPR getAILAPR() { 
       SQM_S25_AILAPR retVal = getTyped("AILAPR", SQM_S25_AILAPR.class);
       return retVal;
    }


    /**
     * Returns a specific repetition of
     * AILAPR (a Group object) - creates it if necessary
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public SQM_S25_AILAPR getAILAPR(int rep) { 
       SQM_S25_AILAPR retVal = getTyped("AILAPR", rep, SQM_S25_AILAPR.class);
       return retVal;
    }

    /** 
     * Returns the number of existing repetitions of AILAPR 
     */ 
    public int getAILAPRReps() {  
        return getReps("AILAPR");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of AILAPR.
     * <p>
     * <p>
     * Note that unlike {@link #getAILAPR()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     */ 
    public java.util.List<SQM_S25_AILAPR> getAILAPRAll() throws HL7Exception {
    	return getAllAsList("AILAPR", SQM_S25_AILAPR.class);
    } 

    /**
     * Inserts a specific repetition of AILAPR (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertAILAPR(SQM_S25_AILAPR structure, int rep) throws HL7Exception { 
       super.insertRepetition("AILAPR", structure, rep);
    }


    /**
     * Inserts a specific repetition of AILAPR (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public SQM_S25_AILAPR insertAILAPR(int rep) throws HL7Exception { 
       return (SQM_S25_AILAPR)super.insertRepetition("AILAPR", rep);
    }


    /**
     * Removes a specific repetition of AILAPR (a Group object)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public SQM_S25_AILAPR removeAILAPR(int rep) throws HL7Exception { 
       return (SQM_S25_AILAPR)super.removeRepetition("AILAPR", rep);
    }



}

