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
 * <p>Represents a CSU_C09 message structure. This structure contains the 
 * following elements: </p>
 * <ul>
		                 * <li>1: MSH (MSH - message header segment) <b> </b> </li>
		                 * <li>2: CSU_C09_PIDPD1NTEPV1PV2CSRCSPCSSORCOBROBXORCRXARXR (a Group object) <b> repeating</b> </li>
 * </ul>
 */
//@SuppressWarnings("unused")
public class CSU_C09 extends AbstractMessage  {

    /**
     * Creates a new CSU_C09 message with DefaultModelClassFactory. 
     */ 
    public CSU_C09() { 
       this(new DefaultModelClassFactory());
    }

    /** 
     * Creates a new CSU_C09 message with custom ModelClassFactory.
     */
    public CSU_C09(ModelClassFactory factory) {
       super(factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                          this.add(MSH.class, true, false);
	                          this.add(CSU_C09_PIDPD1NTEPV1PV2CSRCSPCSSORCOBROBXORCRXARXR.class, true, true);
	       } catch(HL7Exception e) {
          log.error("Unexpected error creating CSU_C09 - this is probably a bug in the source code generator.", e);
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
     * the first repetition of 
     * PIDPD1NTEPV1PV2CSRCSPCSSORCOBROBXORCRXARXR (a Group object) - creates it if necessary
     * </p>
     * 
     *
     */
    public CSU_C09_PIDPD1NTEPV1PV2CSRCSPCSSORCOBROBXORCRXARXR getPIDPD1NTEPV1PV2CSRCSPCSSORCOBROBXORCRXARXR() { 
       return getTyped("PIDPD1NTEPV1PV2CSRCSPCSSORCOBROBXORCRXARXR", CSU_C09_PIDPD1NTEPV1PV2CSRCSPCSSORCOBROBXORCRXARXR.class);
    }


    /**
     * <p>
     * Returns a specific repetition of
     * PIDPD1NTEPV1PV2CSRCSPCSSORCOBROBXORCRXARXR (a Group object) - creates it if necessary
     * </p>
     * 
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public CSU_C09_PIDPD1NTEPV1PV2CSRCSPCSSORCOBROBXORCRXARXR getPIDPD1NTEPV1PV2CSRCSPCSSORCOBROBXORCRXARXR(int rep) { 
       return getTyped("PIDPD1NTEPV1PV2CSRCSPCSSORCOBROBXORCRXARXR", rep, CSU_C09_PIDPD1NTEPV1PV2CSRCSPCSSORCOBROBXORCRXARXR.class);
    }

    /** 
     * <p>
     * Returns the number of existing repetitions of PIDPD1NTEPV1PV2CSRCSPCSSORCOBROBXORCRXARXR 
     * </p>
     * 
     */ 
    public int getPIDPD1NTEPV1PV2CSRCSPCSSORCOBROBXORCRXARXRReps() { 
    	return getReps("PIDPD1NTEPV1PV2CSRCSPCSSORCOBROBXORCRXARXR");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of PIDPD1NTEPV1PV2CSRCSPCSSORCOBROBXORCRXARXR.
     * <p>
     * <p>
     * Note that unlike {@link #getPIDPD1NTEPV1PV2CSRCSPCSSORCOBROBXORCRXARXR()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     * 
     */ 
    public java.util.List<CSU_C09_PIDPD1NTEPV1PV2CSRCSPCSSORCOBROBXORCRXARXR> getPIDPD1NTEPV1PV2CSRCSPCSSORCOBROBXORCRXARXRAll() throws HL7Exception {
    	return getAllAsList("PIDPD1NTEPV1PV2CSRCSPCSSORCOBROBXORCRXARXR", CSU_C09_PIDPD1NTEPV1PV2CSRCSPCSSORCOBROBXORCRXARXR.class);
    } 

    /**
     * <p>
     * Inserts a specific repetition of PIDPD1NTEPV1PV2CSRCSPCSSORCOBROBXORCRXARXR (a Group object)
     * </p>
     * 
     *
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertPIDPD1NTEPV1PV2CSRCSPCSSORCOBROBXORCRXARXR(CSU_C09_PIDPD1NTEPV1PV2CSRCSPCSSORCOBROBXORCRXARXR structure, int rep) throws HL7Exception { 
       super.insertRepetition( "PIDPD1NTEPV1PV2CSRCSPCSSORCOBROBXORCRXARXR", structure, rep);
    }


    /**
     * <p>
     * Inserts a specific repetition of PIDPD1NTEPV1PV2CSRCSPCSSORCOBROBXORCRXARXR (a Group object)
     * </p>
     * 
     *
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public CSU_C09_PIDPD1NTEPV1PV2CSRCSPCSSORCOBROBXORCRXARXR insertPIDPD1NTEPV1PV2CSRCSPCSSORCOBROBXORCRXARXR(int rep) throws HL7Exception { 
       return (CSU_C09_PIDPD1NTEPV1PV2CSRCSPCSSORCOBROBXORCRXARXR)super.insertRepetition("PIDPD1NTEPV1PV2CSRCSPCSSORCOBROBXORCRXARXR", rep);
    }


    /**
     * <p>
     * Removes a specific repetition of PIDPD1NTEPV1PV2CSRCSPCSSORCOBROBXORCRXARXR (a Group object)
     * </p>
     * 
     *
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public CSU_C09_PIDPD1NTEPV1PV2CSRCSPCSSORCOBROBXORCRXARXR removePIDPD1NTEPV1PV2CSRCSPCSSORCOBROBXORCRXARXR(int rep) throws HL7Exception { 
       return (CSU_C09_PIDPD1NTEPV1PV2CSRCSPCSSORCOBROBXORCRXARXR)super.removeRepetition("PIDPD1NTEPV1PV2CSRCSPCSSORCOBROBXORCRXARXR", rep);
    }



}

