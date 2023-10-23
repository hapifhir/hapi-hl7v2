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
 * <p>Represents a PPT_PCL_PATHWAY group structure (a Group object).
 * A Group is an ordered collection of message segments that can repeat together or be optionally in/excluded together.
 * This Group contains the following elements:  
 * </p>
 * <ul>
                         * <li>1: PTH (Pathway) <b>  </b></li>
                         * <li>2: NTE (Notes and comments segment) <b>optional repeating </b></li>
                         * <li>3: VAR (Variance) <b>optional repeating </b></li>
                         * <li>4: PPT_PCL_PATHWAY_ROLE (a Group object) <b>optional repeating </b></li>
                         * <li>5: PPT_PCL_GOAL (a Group object) <b>optional repeating </b></li>
 * </ul>
 */
//@SuppressWarnings("unused")
public class PPT_PCL_PATHWAY extends AbstractGroup {

    /** 
     * Creates a new PPT_PCL_PATHWAY group
     */
    public PPT_PCL_PATHWAY(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(PTH.class, true, false, false);
                                  this.add(NTE.class, false, true, false);
                                  this.add(VAR.class, false, true, false);
                                  this.add(PPT_PCL_PATHWAY_ROLE.class, false, true, false);
                                  this.add(PPT_PCL_GOAL.class, false, true, false);
       } catch(HL7Exception e) {
          log.error("Unexpected error creating PPT_PCL_PATHWAY - this is probably a bug in the source code generator.", e);
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
     * PTH (Pathway) - creates it if necessary
     */
    public PTH getPTH() { 
       PTH retVal = getTyped("PTH", PTH.class);
       return retVal;
    }




    /**
     * Returns
     * the first repetition of 
     * NTE (Notes and comments segment) - creates it if necessary
     */
    public NTE getNTE() { 
       NTE retVal = getTyped("NTE", NTE.class);
       return retVal;
    }


    /**
     * Returns a specific repetition of
     * NTE (Notes and comments segment) - creates it if necessary
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
     * Inserts a specific repetition of NTE (Notes and comments segment)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertNTE(NTE structure, int rep) throws HL7Exception { 
       super.insertRepetition("NTE", structure, rep);
    }


    /**
     * Inserts a specific repetition of NTE (Notes and comments segment)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public NTE insertNTE(int rep) throws HL7Exception { 
       return (NTE)super.insertRepetition("NTE", rep);
    }


    /**
     * Removes a specific repetition of NTE (Notes and comments segment)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public NTE removeNTE(int rep) throws HL7Exception { 
       return (NTE)super.removeRepetition("NTE", rep);
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
     * PATHWAY_ROLE (a Group object) - creates it if necessary
     */
    public PPT_PCL_PATHWAY_ROLE getPATHWAY_ROLE() { 
       PPT_PCL_PATHWAY_ROLE retVal = getTyped("PATHWAY_ROLE", PPT_PCL_PATHWAY_ROLE.class);
       return retVal;
    }


    /**
     * Returns a specific repetition of
     * PATHWAY_ROLE (a Group object) - creates it if necessary
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public PPT_PCL_PATHWAY_ROLE getPATHWAY_ROLE(int rep) { 
       PPT_PCL_PATHWAY_ROLE retVal = getTyped("PATHWAY_ROLE", rep, PPT_PCL_PATHWAY_ROLE.class);
       return retVal;
    }

    /** 
     * Returns the number of existing repetitions of PATHWAY_ROLE 
     */ 
    public int getPATHWAY_ROLEReps() {  
        return getReps("PATHWAY_ROLE");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of PATHWAY_ROLE.
     * <p>
     * <p>
     * Note that unlike {@link #getPATHWAY_ROLE()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     */ 
    public java.util.List<PPT_PCL_PATHWAY_ROLE> getPATHWAY_ROLEAll() throws HL7Exception {
    	return getAllAsList("PATHWAY_ROLE", PPT_PCL_PATHWAY_ROLE.class);
    } 

    /**
     * Inserts a specific repetition of PATHWAY_ROLE (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertPATHWAY_ROLE(PPT_PCL_PATHWAY_ROLE structure, int rep) throws HL7Exception { 
       super.insertRepetition("PATHWAY_ROLE", structure, rep);
    }


    /**
     * Inserts a specific repetition of PATHWAY_ROLE (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public PPT_PCL_PATHWAY_ROLE insertPATHWAY_ROLE(int rep) throws HL7Exception { 
       return (PPT_PCL_PATHWAY_ROLE)super.insertRepetition("PATHWAY_ROLE", rep);
    }


    /**
     * Removes a specific repetition of PATHWAY_ROLE (a Group object)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public PPT_PCL_PATHWAY_ROLE removePATHWAY_ROLE(int rep) throws HL7Exception { 
       return (PPT_PCL_PATHWAY_ROLE)super.removeRepetition("PATHWAY_ROLE", rep);
    }



    /**
     * Returns
     * the first repetition of 
     * GOAL (a Group object) - creates it if necessary
     */
    public PPT_PCL_GOAL getGOAL() { 
       PPT_PCL_GOAL retVal = getTyped("GOAL", PPT_PCL_GOAL.class);
       return retVal;
    }


    /**
     * Returns a specific repetition of
     * GOAL (a Group object) - creates it if necessary
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public PPT_PCL_GOAL getGOAL(int rep) { 
       PPT_PCL_GOAL retVal = getTyped("GOAL", rep, PPT_PCL_GOAL.class);
       return retVal;
    }

    /** 
     * Returns the number of existing repetitions of GOAL 
     */ 
    public int getGOALReps() {  
        return getReps("GOAL");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of GOAL.
     * <p>
     * <p>
     * Note that unlike {@link #getGOAL()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     */ 
    public java.util.List<PPT_PCL_GOAL> getGOALAll() throws HL7Exception {
    	return getAllAsList("GOAL", PPT_PCL_GOAL.class);
    } 

    /**
     * Inserts a specific repetition of GOAL (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertGOAL(PPT_PCL_GOAL structure, int rep) throws HL7Exception { 
       super.insertRepetition("GOAL", structure, rep);
    }


    /**
     * Inserts a specific repetition of GOAL (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public PPT_PCL_GOAL insertGOAL(int rep) throws HL7Exception { 
       return (PPT_PCL_GOAL)super.insertRepetition("GOAL", rep);
    }


    /**
     * Removes a specific repetition of GOAL (a Group object)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public PPT_PCL_GOAL removeGOAL(int rep) throws HL7Exception { 
       return (PPT_PCL_GOAL)super.removeRepetition("GOAL", rep);
    }



}

