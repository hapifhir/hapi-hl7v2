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


package ca.uhn.hl7v2.model.v23.message;

import ca.uhn.hl7v2.model.v23.group.*;
import ca.uhn.hl7v2.model.v23.segment.*;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.parser.DefaultModelClassFactory;
import ca.uhn.hl7v2.model.*;


/**
 * <p>Represents a SIU_S18 message structure (see chapter ?). This structure contains the 
 * following elements: </p>
 * <ul>
		                 * <li>1: MSH (Message header segment) <b> </b> </li>
		                 * <li>2: SCH (Schedule Activity Information) <b> </b> </li>
		                 * <li>3: NTE (Notes and comments segment) <b>optional repeating</b> </li>
		                 * <li>4: SIU_S18_PATIENT (a Group object) <b>optional repeating</b> </li>
		                 * <li>5: SIU_S18_RESOURCES (a Group object) <b> repeating</b> </li>
 * </ul>
 */
//@SuppressWarnings("unused")
public class SIU_S18 extends AbstractMessage  {

    /**
     * Creates a new SIU_S18 message with DefaultModelClassFactory. 
     */ 
    public SIU_S18() { 
       this(new DefaultModelClassFactory());
    }

    /** 
     * Creates a new SIU_S18 message with custom ModelClassFactory.
     */
    public SIU_S18(ModelClassFactory factory) {
       super(factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                          this.add(MSH.class, true, false);
	                          this.add(SCH.class, true, false);
	                          this.add(NTE.class, false, true);
	                          this.add(SIU_S18_PATIENT.class, false, true);
	                          this.add(SIU_S18_RESOURCES.class, true, true);
	       } catch(HL7Exception e) {
          log.error("Unexpected error creating SIU_S18 - this is probably a bug in the source code generator.", e);
       }
    }


    /** 
     * Returns "2.3"
     */
    public String getVersion() {
       return "2.3";
    }




    /**
     * <p>
     * Returns
     * MSH (Message header segment) - creates it if necessary
     * </p>
     * 
     *
     */
    public MSH getMSH() { 
       return getTyped("MSH", MSH.class);
    }





    /**
     * <p>
     * Returns
     * SCH (Schedule Activity Information) - creates it if necessary
     * </p>
     * 
     *
     */
    public SCH getSCH() { 
       return getTyped("SCH", SCH.class);
    }





    /**
     * <p>
     * Returns
     * the first repetition of 
     * NTE (Notes and comments segment) - creates it if necessary
     * </p>
     * 
     *
     */
    public NTE getNTE() { 
       return getTyped("NTE", NTE.class);
    }


    /**
     * <p>
     * Returns a specific repetition of
     * NTE (Notes and comments segment) - creates it if necessary
     * </p>
     * 
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public NTE getNTE(int rep) { 
       return getTyped("NTE", rep, NTE.class);
    }

    /** 
     * <p>
     * Returns the number of existing repetitions of NTE 
     * </p>
     * 
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
     * 
     */ 
    public java.util.List<NTE> getNTEAll() throws HL7Exception {
    	return getAllAsList("NTE", NTE.class);
    } 

    /**
     * <p>
     * Inserts a specific repetition of NTE (Notes and comments segment)
     * </p>
     * 
     *
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertNTE(NTE structure, int rep) throws HL7Exception { 
       super.insertRepetition( "NTE", structure, rep);
    }


    /**
     * <p>
     * Inserts a specific repetition of NTE (Notes and comments segment)
     * </p>
     * 
     *
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public NTE insertNTE(int rep) throws HL7Exception { 
       return (NTE)super.insertRepetition("NTE", rep);
    }


    /**
     * <p>
     * Removes a specific repetition of NTE (Notes and comments segment)
     * </p>
     * 
     *
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public NTE removeNTE(int rep) throws HL7Exception { 
       return (NTE)super.removeRepetition("NTE", rep);
    }




    /**
     * <p>
     * Returns
     * the first repetition of 
     * PATIENT (a Group object) - creates it if necessary
     * </p>
     * 
     *
     */
    public SIU_S18_PATIENT getPATIENT() { 
       return getTyped("PATIENT", SIU_S18_PATIENT.class);
    }


    /**
     * <p>
     * Returns a specific repetition of
     * PATIENT (a Group object) - creates it if necessary
     * </p>
     * 
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public SIU_S18_PATIENT getPATIENT(int rep) { 
       return getTyped("PATIENT", rep, SIU_S18_PATIENT.class);
    }

    /** 
     * <p>
     * Returns the number of existing repetitions of PATIENT 
     * </p>
     * 
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
     * 
     */ 
    public java.util.List<SIU_S18_PATIENT> getPATIENTAll() throws HL7Exception {
    	return getAllAsList("PATIENT", SIU_S18_PATIENT.class);
    } 

    /**
     * <p>
     * Inserts a specific repetition of PATIENT (a Group object)
     * </p>
     * 
     *
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertPATIENT(SIU_S18_PATIENT structure, int rep) throws HL7Exception { 
       super.insertRepetition( "PATIENT", structure, rep);
    }


    /**
     * <p>
     * Inserts a specific repetition of PATIENT (a Group object)
     * </p>
     * 
     *
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public SIU_S18_PATIENT insertPATIENT(int rep) throws HL7Exception { 
       return (SIU_S18_PATIENT)super.insertRepetition("PATIENT", rep);
    }


    /**
     * <p>
     * Removes a specific repetition of PATIENT (a Group object)
     * </p>
     * 
     *
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public SIU_S18_PATIENT removePATIENT(int rep) throws HL7Exception { 
       return (SIU_S18_PATIENT)super.removeRepetition("PATIENT", rep);
    }




    /**
     * <p>
     * Returns
     * the first repetition of 
     * RESOURCES (a Group object) - creates it if necessary
     * </p>
     * 
     *
     */
    public SIU_S18_RESOURCES getRESOURCES() { 
       return getTyped("RESOURCES", SIU_S18_RESOURCES.class);
    }


    /**
     * <p>
     * Returns a specific repetition of
     * RESOURCES (a Group object) - creates it if necessary
     * </p>
     * 
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public SIU_S18_RESOURCES getRESOURCES(int rep) { 
       return getTyped("RESOURCES", rep, SIU_S18_RESOURCES.class);
    }

    /** 
     * <p>
     * Returns the number of existing repetitions of RESOURCES 
     * </p>
     * 
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
     * 
     */ 
    public java.util.List<SIU_S18_RESOURCES> getRESOURCESAll() throws HL7Exception {
    	return getAllAsList("RESOURCES", SIU_S18_RESOURCES.class);
    } 

    /**
     * <p>
     * Inserts a specific repetition of RESOURCES (a Group object)
     * </p>
     * 
     *
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertRESOURCES(SIU_S18_RESOURCES structure, int rep) throws HL7Exception { 
       super.insertRepetition( "RESOURCES", structure, rep);
    }


    /**
     * <p>
     * Inserts a specific repetition of RESOURCES (a Group object)
     * </p>
     * 
     *
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public SIU_S18_RESOURCES insertRESOURCES(int rep) throws HL7Exception { 
       return (SIU_S18_RESOURCES)super.insertRepetition("RESOURCES", rep);
    }


    /**
     * <p>
     * Removes a specific repetition of RESOURCES (a Group object)
     * </p>
     * 
     *
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public SIU_S18_RESOURCES removeRESOURCES(int rep) throws HL7Exception { 
       return (SIU_S18_RESOURCES)super.removeRepetition("RESOURCES", rep);
    }



}

