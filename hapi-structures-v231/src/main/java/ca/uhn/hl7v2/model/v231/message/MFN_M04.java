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


package ca.uhn.hl7v2.model.v231.message;

import ca.uhn.hl7v2.model.v231.group.*;
import ca.uhn.hl7v2.model.v231.segment.*;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.parser.DefaultModelClassFactory;
import ca.uhn.hl7v2.model.*;


/**
 * <p>Represents a MFN_M04 message structure (see chapter ?). This structure contains the 
 * following elements: </p>
 * <ul>
		                 * <li>1: MSH (MSH - message header segment) <b> </b> </li>
		                 * <li>2: MFI (MFI - master file identification segment) <b> </b> </li>
		                 * <li>3: MFN_M04_MFECDMPRC (a Group object) <b> repeating</b> </li>
 * </ul>
 */
//@SuppressWarnings("unused")
public class MFN_M04 extends AbstractMessage  {

    /**
     * Creates a new MFN_M04 message with DefaultModelClassFactory. 
     */ 
    public MFN_M04() { 
       this(new DefaultModelClassFactory());
    }

    /** 
     * Creates a new MFN_M04 message with custom ModelClassFactory.
     */
    public MFN_M04(ModelClassFactory factory) {
       super(factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                          this.add(MSH.class, true, false);
	                          this.add(MFI.class, true, false);
	                          this.add(MFN_M04_MFECDMPRC.class, true, true);
	       } catch(HL7Exception e) {
          log.error("Unexpected error creating MFN_M04 - this is probably a bug in the source code generator.", e);
       }
    }


    /** 
     * Returns "2.3.1"
     */
    public String getVersion() {
       return "2.3.1";
    }




    /**
     * <p>
     * Returns
     * MSH (MSH - message header segment) - creates it if necessary
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
     * MFI (MFI - master file identification segment) - creates it if necessary
     * </p>
     * 
     *
     */
    public MFI getMFI() { 
       return getTyped("MFI", MFI.class);
    }





    /**
     * <p>
     * Returns
     * the first repetition of 
     * MFECDMPRC (a Group object) - creates it if necessary
     * </p>
     * 
     *
     */
    public MFN_M04_MFECDMPRC getMFECDMPRC() { 
       return getTyped("MFECDMPRC", MFN_M04_MFECDMPRC.class);
    }


    /**
     * <p>
     * Returns a specific repetition of
     * MFECDMPRC (a Group object) - creates it if necessary
     * </p>
     * 
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public MFN_M04_MFECDMPRC getMFECDMPRC(int rep) { 
       return getTyped("MFECDMPRC", rep, MFN_M04_MFECDMPRC.class);
    }

    /** 
     * <p>
     * Returns the number of existing repetitions of MFECDMPRC 
     * </p>
     * 
     */ 
    public int getMFECDMPRCReps() { 
    	return getReps("MFECDMPRC");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of MFECDMPRC.
     * <p>
     * <p>
     * Note that unlike {@link #getMFECDMPRC()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     * 
     */ 
    public java.util.List<MFN_M04_MFECDMPRC> getMFECDMPRCAll() throws HL7Exception {
    	return getAllAsList("MFECDMPRC", MFN_M04_MFECDMPRC.class);
    } 

    /**
     * <p>
     * Inserts a specific repetition of MFECDMPRC (a Group object)
     * </p>
     * 
     *
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertMFECDMPRC(MFN_M04_MFECDMPRC structure, int rep) throws HL7Exception { 
       super.insertRepetition( "MFECDMPRC", structure, rep);
    }


    /**
     * <p>
     * Inserts a specific repetition of MFECDMPRC (a Group object)
     * </p>
     * 
     *
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public MFN_M04_MFECDMPRC insertMFECDMPRC(int rep) throws HL7Exception { 
       return (MFN_M04_MFECDMPRC)super.insertRepetition("MFECDMPRC", rep);
    }


    /**
     * <p>
     * Removes a specific repetition of MFECDMPRC (a Group object)
     * </p>
     * 
     *
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public MFN_M04_MFECDMPRC removeMFECDMPRC(int rep) throws HL7Exception { 
       return (MFN_M04_MFECDMPRC)super.removeRepetition("MFECDMPRC", rep);
    }



}

