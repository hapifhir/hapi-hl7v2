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


package ca.uhn.hl7v2.model.v251.group;

import ca.uhn.hl7v2.model.v251.segment.*;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.model.*;

/**
 * <p>Represents a SRR_S01_SCHEDULE group structure (a Group object).
 * A Group is an ordered collection of message segments that can repeat together or be optionally in/excluded together.
 * This Group contains the following elements:  
 * </p>
 * <ul>
                         * <li>1: SCH (Scheduling Activity Information) <b>  </b></li>
                         * <li>2: TQ1 (Timing/Quantity) <b>optional repeating </b></li>
                         * <li>3: NTE (Notes and Comments) <b>optional repeating </b></li>
                         * <li>4: SRR_S01_PATIENT (a Group object) <b>optional repeating </b></li>
                         * <li>5: SRR_S01_RESOURCES (a Group object) <b> repeating </b></li>
 * </ul>
 */
//@SuppressWarnings("unused")
public class SRR_S01_SCHEDULE extends AbstractGroup {

    /** 
     * Creates a new SRR_S01_SCHEDULE group
     */
    public SRR_S01_SCHEDULE(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(SCH.class, true, false, false);
                                  this.add(TQ1.class, false, true, false);
                                  this.add(NTE.class, false, true, false);
                                  this.add(SRR_S01_PATIENT.class, false, true, false);
                                  this.add(SRR_S01_RESOURCES.class, true, true, false);
       } catch(HL7Exception e) {
          log.error("Unexpected error creating SRR_S01_SCHEDULE - this is probably a bug in the source code generator.", e);
       }
    }

    /** 
     * Returns "2.5.1"
     */
    public String getVersion() {
       return "2.5.1";
    }



    /**
     * Returns
     * SCH (Scheduling Activity Information) - creates it if necessary
     */
    public SCH getSCH() { 
       SCH retVal = getTyped("SCH", SCH.class);
       return retVal;
    }




    /**
     * Returns
     * the first repetition of 
     * TQ1 (Timing/Quantity) - creates it if necessary
     */
    public TQ1 getTQ1() { 
       TQ1 retVal = getTyped("TQ1", TQ1.class);
       return retVal;
    }


    /**
     * Returns a specific repetition of
     * TQ1 (Timing/Quantity) - creates it if necessary
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public TQ1 getTQ1(int rep) { 
       TQ1 retVal = getTyped("TQ1", rep, TQ1.class);
       return retVal;
    }

    /** 
     * Returns the number of existing repetitions of TQ1 
     */ 
    public int getTQ1Reps() {  
        return getReps("TQ1");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of TQ1.
     * <p>
     * <p>
     * Note that unlike {@link #getTQ1()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     */ 
    public java.util.List<TQ1> getTQ1All() throws HL7Exception {
    	return getAllAsList("TQ1", TQ1.class);
    } 

    /**
     * Inserts a specific repetition of TQ1 (Timing/Quantity)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertTQ1(TQ1 structure, int rep) throws HL7Exception { 
       super.insertRepetition("TQ1", structure, rep);
    }


    /**
     * Inserts a specific repetition of TQ1 (Timing/Quantity)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public TQ1 insertTQ1(int rep) throws HL7Exception { 
       return (TQ1)super.insertRepetition("TQ1", rep);
    }


    /**
     * Removes a specific repetition of TQ1 (Timing/Quantity)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public TQ1 removeTQ1(int rep) throws HL7Exception { 
       return (TQ1)super.removeRepetition("TQ1", rep);
    }



    /**
     * Returns
     * the first repetition of 
     * NTE (Notes and Comments) - creates it if necessary
     */
    public NTE getNTE() { 
       NTE retVal = getTyped("NTE", NTE.class);
       return retVal;
    }


    /**
     * Returns a specific repetition of
     * NTE (Notes and Comments) - creates it if necessary
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
     * Inserts a specific repetition of NTE (Notes and Comments)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertNTE(NTE structure, int rep) throws HL7Exception { 
       super.insertRepetition("NTE", structure, rep);
    }


    /**
     * Inserts a specific repetition of NTE (Notes and Comments)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public NTE insertNTE(int rep) throws HL7Exception { 
       return (NTE)super.insertRepetition("NTE", rep);
    }


    /**
     * Removes a specific repetition of NTE (Notes and Comments)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public NTE removeNTE(int rep) throws HL7Exception { 
       return (NTE)super.removeRepetition("NTE", rep);
    }



    /**
     * Returns
     * the first repetition of 
     * PATIENT (a Group object) - creates it if necessary
     */
    public SRR_S01_PATIENT getPATIENT() { 
       SRR_S01_PATIENT retVal = getTyped("PATIENT", SRR_S01_PATIENT.class);
       return retVal;
    }


    /**
     * Returns a specific repetition of
     * PATIENT (a Group object) - creates it if necessary
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public SRR_S01_PATIENT getPATIENT(int rep) { 
       SRR_S01_PATIENT retVal = getTyped("PATIENT", rep, SRR_S01_PATIENT.class);
       return retVal;
    }

    /** 
     * Returns the number of existing repetitions of PATIENT 
     */ 
    public int getPATIENTReps() {  
        return getReps("PATIENT");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of PATIENT.
     * <p>
     * <p>
     * Note that unlike {@link #getPATIENT()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     */ 
    public java.util.List<SRR_S01_PATIENT> getPATIENTAll() throws HL7Exception {
    	return getAllAsList("PATIENT", SRR_S01_PATIENT.class);
    } 

    /**
     * Inserts a specific repetition of PATIENT (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertPATIENT(SRR_S01_PATIENT structure, int rep) throws HL7Exception { 
       super.insertRepetition("PATIENT", structure, rep);
    }


    /**
     * Inserts a specific repetition of PATIENT (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public SRR_S01_PATIENT insertPATIENT(int rep) throws HL7Exception { 
       return (SRR_S01_PATIENT)super.insertRepetition("PATIENT", rep);
    }


    /**
     * Removes a specific repetition of PATIENT (a Group object)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public SRR_S01_PATIENT removePATIENT(int rep) throws HL7Exception { 
       return (SRR_S01_PATIENT)super.removeRepetition("PATIENT", rep);
    }



    /**
     * Returns
     * the first repetition of 
     * RESOURCES (a Group object) - creates it if necessary
     */
    public SRR_S01_RESOURCES getRESOURCES() { 
       SRR_S01_RESOURCES retVal = getTyped("RESOURCES", SRR_S01_RESOURCES.class);
       return retVal;
    }


    /**
     * Returns a specific repetition of
     * RESOURCES (a Group object) - creates it if necessary
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public SRR_S01_RESOURCES getRESOURCES(int rep) { 
       SRR_S01_RESOURCES retVal = getTyped("RESOURCES", rep, SRR_S01_RESOURCES.class);
       return retVal;
    }

    /** 
     * Returns the number of existing repetitions of RESOURCES 
     */ 
    public int getRESOURCESReps() {  
        return getReps("RESOURCES");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of RESOURCES.
     * <p>
     * <p>
     * Note that unlike {@link #getRESOURCES()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     */ 
    public java.util.List<SRR_S01_RESOURCES> getRESOURCESAll() throws HL7Exception {
    	return getAllAsList("RESOURCES", SRR_S01_RESOURCES.class);
    } 

    /**
     * Inserts a specific repetition of RESOURCES (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertRESOURCES(SRR_S01_RESOURCES structure, int rep) throws HL7Exception { 
       super.insertRepetition("RESOURCES", structure, rep);
    }


    /**
     * Inserts a specific repetition of RESOURCES (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public SRR_S01_RESOURCES insertRESOURCES(int rep) throws HL7Exception { 
       return (SRR_S01_RESOURCES)super.insertRepetition("RESOURCES", rep);
    }


    /**
     * Removes a specific repetition of RESOURCES (a Group object)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public SRR_S01_RESOURCES removeRESOURCES(int rep) throws HL7Exception { 
       return (SRR_S01_RESOURCES)super.removeRepetition("RESOURCES", rep);
    }



}

