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


package ca.uhn.hl7v2.model.v281.group;

import ca.uhn.hl7v2.model.v281.segment.*;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.model.*;

/**
 * <p>Represents a EHC_E13_REQUEST group structure (a Group object).
 * A Group is an ordered collection of message segments that can repeat together or be optionally in/excluded together.
 * This Group contains the following elements:  
 * </p>
 * <ul>
                         * <li>1: CTD (Contact Data) <b>optional  </b></li>
                         * <li>2: OBR (Observation Request) <b>  </b></li>
                         * <li>3: NTE (Notes and Comments) <b>optional  </b></li>
                         * <li>4: EHC_E13_RESPONSE (a Group object) <b> repeating </b></li>
 * </ul>
 */
//@SuppressWarnings("unused")
public class EHC_E13_REQUEST extends AbstractGroup {

    /** 
     * Creates a new EHC_E13_REQUEST group
     */
    public EHC_E13_REQUEST(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(CTD.class, false, false, false);
                                  this.add(OBR.class, true, false, false);
                                  this.add(NTE.class, false, false, false);
                                  this.add(EHC_E13_RESPONSE.class, true, true, false);
       } catch(HL7Exception e) {
          log.error("Unexpected error creating EHC_E13_REQUEST - this is probably a bug in the source code generator.", e);
       }
    }

    /** 
     * Returns "2.8.1"
     */
    public String getVersion() {
       return "2.8.1";
    }



    /**
     * Returns
     * CTD (Contact Data) - creates it if necessary
     */
    public CTD getCTD() { 
       CTD retVal = getTyped("CTD", CTD.class);
       return retVal;
    }




    /**
     * Returns
     * OBR (Observation Request) - creates it if necessary
     */
    public OBR getOBR() { 
       OBR retVal = getTyped("OBR", OBR.class);
       return retVal;
    }




    /**
     * Returns
     * NTE (Notes and Comments) - creates it if necessary
     */
    public NTE getNTE() { 
       NTE retVal = getTyped("NTE", NTE.class);
       return retVal;
    }




    /**
     * Returns
     * the first repetition of 
     * RESPONSE (a Group object) - creates it if necessary
     */
    public EHC_E13_RESPONSE getRESPONSE() { 
       EHC_E13_RESPONSE retVal = getTyped("RESPONSE", EHC_E13_RESPONSE.class);
       return retVal;
    }


    /**
     * Returns a specific repetition of
     * RESPONSE (a Group object) - creates it if necessary
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public EHC_E13_RESPONSE getRESPONSE(int rep) { 
       EHC_E13_RESPONSE retVal = getTyped("RESPONSE", rep, EHC_E13_RESPONSE.class);
       return retVal;
    }

    /** 
     * Returns the number of existing repetitions of RESPONSE 
     */ 
    public int getRESPONSEReps() {  
        return getReps("RESPONSE");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of RESPONSE.
     * <p>
     * <p>
     * Note that unlike {@link #getRESPONSE()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     */ 
    public java.util.List<EHC_E13_RESPONSE> getRESPONSEAll() throws HL7Exception {
    	return getAllAsList("RESPONSE", EHC_E13_RESPONSE.class);
    } 

    /**
     * Inserts a specific repetition of RESPONSE (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertRESPONSE(EHC_E13_RESPONSE structure, int rep) throws HL7Exception { 
       super.insertRepetition("RESPONSE", structure, rep);
    }


    /**
     * Inserts a specific repetition of RESPONSE (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public EHC_E13_RESPONSE insertRESPONSE(int rep) throws HL7Exception { 
       return (EHC_E13_RESPONSE)super.insertRepetition("RESPONSE", rep);
    }


    /**
     * Removes a specific repetition of RESPONSE (a Group object)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public EHC_E13_RESPONSE removeRESPONSE(int rep) throws HL7Exception { 
       return (EHC_E13_RESPONSE)super.removeRepetition("RESPONSE", rep);
    }



}

