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
 * <p>Represents a RAR_RAR_QRDQRFPIDNTEORCRXERXRRXCRXARXR group structure (a Group object).
 * A Group is an ordered collection of message segments that can repeat together or be optionally in/excluded together.
 * This Group contains the following elements:  
 * </p>
 * <ul>
                         * <li>1: QRD (QRD - original-style query definition segment) <b>  </b></li>
                         * <li>2: QRF (QRF - original style query filter segment) <b>optional  </b></li>
                         * <li>3: RAR_RAR_PIDNTE (a Group object) <b>optional  </b></li>
                         * <li>4: RAR_RAR_ORCRXERXRRXCRXARXR (a Group object) <b> repeating </b></li>
 * </ul>
 */
//@SuppressWarnings("unused")
public class RAR_RAR_QRDQRFPIDNTEORCRXERXRRXCRXARXR extends AbstractGroup {

    /** 
     * Creates a new RAR_RAR_QRDQRFPIDNTEORCRXERXRRXCRXARXR group
     */
    public RAR_RAR_QRDQRFPIDNTEORCRXERXRRXCRXARXR(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(QRD.class, true, false, false);
                                  this.add(QRF.class, false, false, false);
                                  this.add(RAR_RAR_PIDNTE.class, false, false, false);
                                  this.add(RAR_RAR_ORCRXERXRRXCRXARXR.class, true, true, false);
       } catch(HL7Exception e) {
          log.error("Unexpected error creating RAR_RAR_QRDQRFPIDNTEORCRXERXRRXCRXARXR - this is probably a bug in the source code generator.", e);
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
     * QRD (QRD - original-style query definition segment) - creates it if necessary
     */
    public QRD getQRD() { 
       QRD retVal = getTyped("QRD", QRD.class);
       return retVal;
    }




    /**
     * Returns
     * QRF (QRF - original style query filter segment) - creates it if necessary
     */
    public QRF getQRF() { 
       QRF retVal = getTyped("QRF", QRF.class);
       return retVal;
    }




    /**
     * Returns
     * PIDNTE (a Group object) - creates it if necessary
     */
    public RAR_RAR_PIDNTE getPIDNTE() { 
       RAR_RAR_PIDNTE retVal = getTyped("PIDNTE", RAR_RAR_PIDNTE.class);
       return retVal;
    }




    /**
     * Returns
     * the first repetition of 
     * ORCRXERXRRXCRXARXR (a Group object) - creates it if necessary
     */
    public RAR_RAR_ORCRXERXRRXCRXARXR getORCRXERXRRXCRXARXR() { 
       RAR_RAR_ORCRXERXRRXCRXARXR retVal = getTyped("ORCRXERXRRXCRXARXR", RAR_RAR_ORCRXERXRRXCRXARXR.class);
       return retVal;
    }


    /**
     * Returns a specific repetition of
     * ORCRXERXRRXCRXARXR (a Group object) - creates it if necessary
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public RAR_RAR_ORCRXERXRRXCRXARXR getORCRXERXRRXCRXARXR(int rep) { 
       RAR_RAR_ORCRXERXRRXCRXARXR retVal = getTyped("ORCRXERXRRXCRXARXR", rep, RAR_RAR_ORCRXERXRRXCRXARXR.class);
       return retVal;
    }

    /** 
     * Returns the number of existing repetitions of ORCRXERXRRXCRXARXR 
     */ 
    public int getORCRXERXRRXCRXARXRReps() {  
        return getReps("ORCRXERXRRXCRXARXR");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of ORCRXERXRRXCRXARXR.
     * <p>
     * <p>
     * Note that unlike {@link #getORCRXERXRRXCRXARXR()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     */ 
    public java.util.List<RAR_RAR_ORCRXERXRRXCRXARXR> getORCRXERXRRXCRXARXRAll() throws HL7Exception {
    	return getAllAsList("ORCRXERXRRXCRXARXR", RAR_RAR_ORCRXERXRRXCRXARXR.class);
    } 

    /**
     * Inserts a specific repetition of ORCRXERXRRXCRXARXR (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertORCRXERXRRXCRXARXR(RAR_RAR_ORCRXERXRRXCRXARXR structure, int rep) throws HL7Exception { 
       super.insertRepetition("ORCRXERXRRXCRXARXR", structure, rep);
    }


    /**
     * Inserts a specific repetition of ORCRXERXRRXCRXARXR (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public RAR_RAR_ORCRXERXRRXCRXARXR insertORCRXERXRRXCRXARXR(int rep) throws HL7Exception { 
       return (RAR_RAR_ORCRXERXRRXCRXARXR)super.insertRepetition("ORCRXERXRRXCRXARXR", rep);
    }


    /**
     * Removes a specific repetition of ORCRXERXRRXCRXARXR (a Group object)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public RAR_RAR_ORCRXERXRRXCRXARXR removeORCRXERXRRXCRXARXR(int rep) throws HL7Exception { 
       return (RAR_RAR_ORCRXERXRRXCRXARXR)super.removeRepetition("ORCRXERXRRXCRXARXR", rep);
    }



}

