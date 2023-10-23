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
 * <p>Represents a ORU_R01_PIDPD1NK1NTEPV1PV2ORCOBRNTEOBXNTECTI group structure (a Group object).
 * A Group is an ordered collection of message segments that can repeat together or be optionally in/excluded together.
 * This Group contains the following elements:  
 * </p>
 * <ul>
                         * <li>1: ORU_R01_PIDPD1NK1NTEPV1PV2 (a Group object) <b>optional  </b></li>
                         * <li>2: ORU_R01_ORCOBRNTEOBXNTECTI (a Group object) <b> repeating </b></li>
 * </ul>
 */
//@SuppressWarnings("unused")
public class ORU_R01_PIDPD1NK1NTEPV1PV2ORCOBRNTEOBXNTECTI extends AbstractGroup {

    /** 
     * Creates a new ORU_R01_PIDPD1NK1NTEPV1PV2ORCOBRNTEOBXNTECTI group
     */
    public ORU_R01_PIDPD1NK1NTEPV1PV2ORCOBRNTEOBXNTECTI(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(ORU_R01_PIDPD1NK1NTEPV1PV2.class, false, false, false);
                                  this.add(ORU_R01_ORCOBRNTEOBXNTECTI.class, true, true, false);
       } catch(HL7Exception e) {
          log.error("Unexpected error creating ORU_R01_PIDPD1NK1NTEPV1PV2ORCOBRNTEOBXNTECTI - this is probably a bug in the source code generator.", e);
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
     * PIDPD1NK1NTEPV1PV2 (a Group object) - creates it if necessary
     */
    public ORU_R01_PIDPD1NK1NTEPV1PV2 getPIDPD1NK1NTEPV1PV2() { 
       ORU_R01_PIDPD1NK1NTEPV1PV2 retVal = getTyped("PIDPD1NK1NTEPV1PV2", ORU_R01_PIDPD1NK1NTEPV1PV2.class);
       return retVal;
    }




    /**
     * Returns
     * the first repetition of 
     * ORCOBRNTEOBXNTECTI (a Group object) - creates it if necessary
     */
    public ORU_R01_ORCOBRNTEOBXNTECTI getORCOBRNTEOBXNTECTI() { 
       ORU_R01_ORCOBRNTEOBXNTECTI retVal = getTyped("ORCOBRNTEOBXNTECTI", ORU_R01_ORCOBRNTEOBXNTECTI.class);
       return retVal;
    }


    /**
     * Returns a specific repetition of
     * ORCOBRNTEOBXNTECTI (a Group object) - creates it if necessary
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public ORU_R01_ORCOBRNTEOBXNTECTI getORCOBRNTEOBXNTECTI(int rep) { 
       ORU_R01_ORCOBRNTEOBXNTECTI retVal = getTyped("ORCOBRNTEOBXNTECTI", rep, ORU_R01_ORCOBRNTEOBXNTECTI.class);
       return retVal;
    }

    /** 
     * Returns the number of existing repetitions of ORCOBRNTEOBXNTECTI 
     */ 
    public int getORCOBRNTEOBXNTECTIReps() {  
        return getReps("ORCOBRNTEOBXNTECTI");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of ORCOBRNTEOBXNTECTI.
     * <p>
     * <p>
     * Note that unlike {@link #getORCOBRNTEOBXNTECTI()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     */ 
    public java.util.List<ORU_R01_ORCOBRNTEOBXNTECTI> getORCOBRNTEOBXNTECTIAll() throws HL7Exception {
    	return getAllAsList("ORCOBRNTEOBXNTECTI", ORU_R01_ORCOBRNTEOBXNTECTI.class);
    } 

    /**
     * Inserts a specific repetition of ORCOBRNTEOBXNTECTI (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertORCOBRNTEOBXNTECTI(ORU_R01_ORCOBRNTEOBXNTECTI structure, int rep) throws HL7Exception { 
       super.insertRepetition("ORCOBRNTEOBXNTECTI", structure, rep);
    }


    /**
     * Inserts a specific repetition of ORCOBRNTEOBXNTECTI (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public ORU_R01_ORCOBRNTEOBXNTECTI insertORCOBRNTEOBXNTECTI(int rep) throws HL7Exception { 
       return (ORU_R01_ORCOBRNTEOBXNTECTI)super.insertRepetition("ORCOBRNTEOBXNTECTI", rep);
    }


    /**
     * Removes a specific repetition of ORCOBRNTEOBXNTECTI (a Group object)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public ORU_R01_ORCOBRNTEOBXNTECTI removeORCOBRNTEOBXNTECTI(int rep) throws HL7Exception { 
       return (ORU_R01_ORCOBRNTEOBXNTECTI)super.removeRepetition("ORCOBRNTEOBXNTECTI", rep);
    }



}

