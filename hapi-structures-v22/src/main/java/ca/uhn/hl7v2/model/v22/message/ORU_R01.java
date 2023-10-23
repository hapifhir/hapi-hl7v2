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


package ca.uhn.hl7v2.model.v22.message;

import ca.uhn.hl7v2.model.v22.group.*;
import ca.uhn.hl7v2.model.v22.segment.*;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.parser.DefaultModelClassFactory;
import ca.uhn.hl7v2.model.*;


/**
 * <p>Represents a ORU_R01 message structure (see chapter ?). This structure contains the 
 * following elements: </p>
 * <ul>
		                 * <li>1: MSH (MESSAGE HEADER) <b> </b> </li>
		                 * <li>2: ORU_R01_PATIENT_RESULT (a Group object) <b> repeating</b> </li>
		                 * <li>3: DSC (CONTINUATION POINTER) <b>optional </b> </li>
 * </ul>
 */
//@SuppressWarnings("unused")
public class ORU_R01 extends AbstractMessage  {

    /**
     * Creates a new ORU_R01 message with DefaultModelClassFactory. 
     */ 
    public ORU_R01() { 
       this(new DefaultModelClassFactory());
    }

    /** 
     * Creates a new ORU_R01 message with custom ModelClassFactory.
     */
    public ORU_R01(ModelClassFactory factory) {
       super(factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                          this.add(MSH.class, true, false);
	                          this.add(ORU_R01_PATIENT_RESULT.class, true, true);
	                          this.add(DSC.class, false, false);
	       } catch(HL7Exception e) {
          log.error("Unexpected error creating ORU_R01 - this is probably a bug in the source code generator.", e);
       }
    }


    /** 
     * Returns "2.2"
     */
    public String getVersion() {
       return "2.2";
    }




    /**
     * <p>
     * Returns
     * MSH (MESSAGE HEADER) - creates it if necessary
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
     * the first repetition of 
     * PATIENT_RESULT (a Group object) - creates it if necessary
     * </p>
     * 
     *
     */
    public ORU_R01_PATIENT_RESULT getPATIENT_RESULT() { 
       return getTyped("PATIENT_RESULT", ORU_R01_PATIENT_RESULT.class);
    }


    /**
     * <p>
     * Returns a specific repetition of
     * PATIENT_RESULT (a Group object) - creates it if necessary
     * </p>
     * 
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public ORU_R01_PATIENT_RESULT getPATIENT_RESULT(int rep) { 
       return getTyped("PATIENT_RESULT", rep, ORU_R01_PATIENT_RESULT.class);
    }

    /** 
     * <p>
     * Returns the number of existing repetitions of PATIENT_RESULT 
     * </p>
     * 
     */ 
    public int getPATIENT_RESULTReps() { 
    	return getReps("PATIENT_RESULT");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of PATIENT_RESULT.
     * <p>
     * <p>
     * Note that unlike {@link #getPATIENT_RESULT()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     * 
     */ 
    public java.util.List<ORU_R01_PATIENT_RESULT> getPATIENT_RESULTAll() throws HL7Exception {
    	return getAllAsList("PATIENT_RESULT", ORU_R01_PATIENT_RESULT.class);
    } 

    /**
     * <p>
     * Inserts a specific repetition of PATIENT_RESULT (a Group object)
     * </p>
     * 
     *
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertPATIENT_RESULT(ORU_R01_PATIENT_RESULT structure, int rep) throws HL7Exception { 
       super.insertRepetition( "PATIENT_RESULT", structure, rep);
    }


    /**
     * <p>
     * Inserts a specific repetition of PATIENT_RESULT (a Group object)
     * </p>
     * 
     *
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public ORU_R01_PATIENT_RESULT insertPATIENT_RESULT(int rep) throws HL7Exception { 
       return (ORU_R01_PATIENT_RESULT)super.insertRepetition("PATIENT_RESULT", rep);
    }


    /**
     * <p>
     * Removes a specific repetition of PATIENT_RESULT (a Group object)
     * </p>
     * 
     *
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public ORU_R01_PATIENT_RESULT removePATIENT_RESULT(int rep) throws HL7Exception { 
       return (ORU_R01_PATIENT_RESULT)super.removeRepetition("PATIENT_RESULT", rep);
    }




    /**
     * <p>
     * Returns
     * DSC (CONTINUATION POINTER) - creates it if necessary
     * </p>
     * 
     *
     */
    public DSC getDSC() { 
       return getTyped("DSC", DSC.class);
    }




}

