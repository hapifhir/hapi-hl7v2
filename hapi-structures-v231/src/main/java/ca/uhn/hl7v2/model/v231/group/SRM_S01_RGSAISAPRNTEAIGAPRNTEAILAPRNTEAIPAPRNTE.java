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
 * <p>Represents a SRM_S01_RGSAISAPRNTEAIGAPRNTEAILAPRNTEAIPAPRNTE group structure (a Group object).
 * A Group is an ordered collection of message segments that can repeat together or be optionally in/excluded together.
 * This Group contains the following elements:  
 * </p>
 * <ul>
                         * <li>1: RGS (RGS - resource group segment) <b>  </b></li>
                         * <li>2: SRM_S01_AISAPRNTE (a Group object) <b>optional repeating </b></li>
                         * <li>3: SRM_S01_AIGAPRNTE (a Group object) <b>optional repeating </b></li>
                         * <li>4: SRM_S01_AILAPRNTE (a Group object) <b>optional repeating </b></li>
                         * <li>5: SRM_S01_AIPAPRNTE (a Group object) <b>optional repeating </b></li>
 * </ul>
 */
//@SuppressWarnings("unused")
public class SRM_S01_RGSAISAPRNTEAIGAPRNTEAILAPRNTEAIPAPRNTE extends AbstractGroup {

    /** 
     * Creates a new SRM_S01_RGSAISAPRNTEAIGAPRNTEAILAPRNTEAIPAPRNTE group
     */
    public SRM_S01_RGSAISAPRNTEAIGAPRNTEAILAPRNTEAIPAPRNTE(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(RGS.class, true, false, false);
                                  this.add(SRM_S01_AISAPRNTE.class, false, true, false);
                                  this.add(SRM_S01_AIGAPRNTE.class, false, true, false);
                                  this.add(SRM_S01_AILAPRNTE.class, false, true, false);
                                  this.add(SRM_S01_AIPAPRNTE.class, false, true, false);
       } catch(HL7Exception e) {
          log.error("Unexpected error creating SRM_S01_RGSAISAPRNTEAIGAPRNTEAILAPRNTEAIPAPRNTE - this is probably a bug in the source code generator.", e);
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
     * AISAPRNTE (a Group object) - creates it if necessary
     */
    public SRM_S01_AISAPRNTE getAISAPRNTE() { 
       SRM_S01_AISAPRNTE retVal = getTyped("AISAPRNTE", SRM_S01_AISAPRNTE.class);
       return retVal;
    }


    /**
     * Returns a specific repetition of
     * AISAPRNTE (a Group object) - creates it if necessary
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public SRM_S01_AISAPRNTE getAISAPRNTE(int rep) { 
       SRM_S01_AISAPRNTE retVal = getTyped("AISAPRNTE", rep, SRM_S01_AISAPRNTE.class);
       return retVal;
    }

    /** 
     * Returns the number of existing repetitions of AISAPRNTE 
     */ 
    public int getAISAPRNTEReps() {  
        return getReps("AISAPRNTE");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of AISAPRNTE.
     * <p>
     * <p>
     * Note that unlike {@link #getAISAPRNTE()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     */ 
    public java.util.List<SRM_S01_AISAPRNTE> getAISAPRNTEAll() throws HL7Exception {
    	return getAllAsList("AISAPRNTE", SRM_S01_AISAPRNTE.class);
    } 

    /**
     * Inserts a specific repetition of AISAPRNTE (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertAISAPRNTE(SRM_S01_AISAPRNTE structure, int rep) throws HL7Exception { 
       super.insertRepetition("AISAPRNTE", structure, rep);
    }


    /**
     * Inserts a specific repetition of AISAPRNTE (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public SRM_S01_AISAPRNTE insertAISAPRNTE(int rep) throws HL7Exception { 
       return (SRM_S01_AISAPRNTE)super.insertRepetition("AISAPRNTE", rep);
    }


    /**
     * Removes a specific repetition of AISAPRNTE (a Group object)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public SRM_S01_AISAPRNTE removeAISAPRNTE(int rep) throws HL7Exception { 
       return (SRM_S01_AISAPRNTE)super.removeRepetition("AISAPRNTE", rep);
    }



    /**
     * Returns
     * the first repetition of 
     * AIGAPRNTE (a Group object) - creates it if necessary
     */
    public SRM_S01_AIGAPRNTE getAIGAPRNTE() { 
       SRM_S01_AIGAPRNTE retVal = getTyped("AIGAPRNTE", SRM_S01_AIGAPRNTE.class);
       return retVal;
    }


    /**
     * Returns a specific repetition of
     * AIGAPRNTE (a Group object) - creates it if necessary
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public SRM_S01_AIGAPRNTE getAIGAPRNTE(int rep) { 
       SRM_S01_AIGAPRNTE retVal = getTyped("AIGAPRNTE", rep, SRM_S01_AIGAPRNTE.class);
       return retVal;
    }

    /** 
     * Returns the number of existing repetitions of AIGAPRNTE 
     */ 
    public int getAIGAPRNTEReps() {  
        return getReps("AIGAPRNTE");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of AIGAPRNTE.
     * <p>
     * <p>
     * Note that unlike {@link #getAIGAPRNTE()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     */ 
    public java.util.List<SRM_S01_AIGAPRNTE> getAIGAPRNTEAll() throws HL7Exception {
    	return getAllAsList("AIGAPRNTE", SRM_S01_AIGAPRNTE.class);
    } 

    /**
     * Inserts a specific repetition of AIGAPRNTE (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertAIGAPRNTE(SRM_S01_AIGAPRNTE structure, int rep) throws HL7Exception { 
       super.insertRepetition("AIGAPRNTE", structure, rep);
    }


    /**
     * Inserts a specific repetition of AIGAPRNTE (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public SRM_S01_AIGAPRNTE insertAIGAPRNTE(int rep) throws HL7Exception { 
       return (SRM_S01_AIGAPRNTE)super.insertRepetition("AIGAPRNTE", rep);
    }


    /**
     * Removes a specific repetition of AIGAPRNTE (a Group object)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public SRM_S01_AIGAPRNTE removeAIGAPRNTE(int rep) throws HL7Exception { 
       return (SRM_S01_AIGAPRNTE)super.removeRepetition("AIGAPRNTE", rep);
    }



    /**
     * Returns
     * the first repetition of 
     * AILAPRNTE (a Group object) - creates it if necessary
     */
    public SRM_S01_AILAPRNTE getAILAPRNTE() { 
       SRM_S01_AILAPRNTE retVal = getTyped("AILAPRNTE", SRM_S01_AILAPRNTE.class);
       return retVal;
    }


    /**
     * Returns a specific repetition of
     * AILAPRNTE (a Group object) - creates it if necessary
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public SRM_S01_AILAPRNTE getAILAPRNTE(int rep) { 
       SRM_S01_AILAPRNTE retVal = getTyped("AILAPRNTE", rep, SRM_S01_AILAPRNTE.class);
       return retVal;
    }

    /** 
     * Returns the number of existing repetitions of AILAPRNTE 
     */ 
    public int getAILAPRNTEReps() {  
        return getReps("AILAPRNTE");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of AILAPRNTE.
     * <p>
     * <p>
     * Note that unlike {@link #getAILAPRNTE()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     */ 
    public java.util.List<SRM_S01_AILAPRNTE> getAILAPRNTEAll() throws HL7Exception {
    	return getAllAsList("AILAPRNTE", SRM_S01_AILAPRNTE.class);
    } 

    /**
     * Inserts a specific repetition of AILAPRNTE (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertAILAPRNTE(SRM_S01_AILAPRNTE structure, int rep) throws HL7Exception { 
       super.insertRepetition("AILAPRNTE", structure, rep);
    }


    /**
     * Inserts a specific repetition of AILAPRNTE (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public SRM_S01_AILAPRNTE insertAILAPRNTE(int rep) throws HL7Exception { 
       return (SRM_S01_AILAPRNTE)super.insertRepetition("AILAPRNTE", rep);
    }


    /**
     * Removes a specific repetition of AILAPRNTE (a Group object)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public SRM_S01_AILAPRNTE removeAILAPRNTE(int rep) throws HL7Exception { 
       return (SRM_S01_AILAPRNTE)super.removeRepetition("AILAPRNTE", rep);
    }



    /**
     * Returns
     * the first repetition of 
     * AIPAPRNTE (a Group object) - creates it if necessary
     */
    public SRM_S01_AIPAPRNTE getAIPAPRNTE() { 
       SRM_S01_AIPAPRNTE retVal = getTyped("AIPAPRNTE", SRM_S01_AIPAPRNTE.class);
       return retVal;
    }


    /**
     * Returns a specific repetition of
     * AIPAPRNTE (a Group object) - creates it if necessary
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public SRM_S01_AIPAPRNTE getAIPAPRNTE(int rep) { 
       SRM_S01_AIPAPRNTE retVal = getTyped("AIPAPRNTE", rep, SRM_S01_AIPAPRNTE.class);
       return retVal;
    }

    /** 
     * Returns the number of existing repetitions of AIPAPRNTE 
     */ 
    public int getAIPAPRNTEReps() {  
        return getReps("AIPAPRNTE");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of AIPAPRNTE.
     * <p>
     * <p>
     * Note that unlike {@link #getAIPAPRNTE()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     */ 
    public java.util.List<SRM_S01_AIPAPRNTE> getAIPAPRNTEAll() throws HL7Exception {
    	return getAllAsList("AIPAPRNTE", SRM_S01_AIPAPRNTE.class);
    } 

    /**
     * Inserts a specific repetition of AIPAPRNTE (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertAIPAPRNTE(SRM_S01_AIPAPRNTE structure, int rep) throws HL7Exception { 
       super.insertRepetition("AIPAPRNTE", structure, rep);
    }


    /**
     * Inserts a specific repetition of AIPAPRNTE (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public SRM_S01_AIPAPRNTE insertAIPAPRNTE(int rep) throws HL7Exception { 
       return (SRM_S01_AIPAPRNTE)super.insertRepetition("AIPAPRNTE", rep);
    }


    /**
     * Removes a specific repetition of AIPAPRNTE (a Group object)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public SRM_S01_AIPAPRNTE removeAIPAPRNTE(int rep) throws HL7Exception { 
       return (SRM_S01_AIPAPRNTE)super.removeRepetition("AIPAPRNTE", rep);
    }



}

