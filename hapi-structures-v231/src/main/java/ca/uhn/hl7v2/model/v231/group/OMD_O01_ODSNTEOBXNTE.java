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
 * <p>Represents a OMD_O01_ODSNTEOBXNTE group structure (a Group object).
 * A Group is an ordered collection of message segments that can repeat together or be optionally in/excluded together.
 * This Group contains the following elements:  
 * </p>
 * <ul>
                         * <li>1: ODS (ODS - dietary orders, supplements, and preferences segment) <b> repeating </b></li>
                         * <li>2: NTE (NTE - notes and comments segment) <b>optional repeating </b></li>
                         * <li>3: OMD_O01_OBXNTE (a Group object) <b> repeating </b></li>
 * </ul>
 */
//@SuppressWarnings("unused")
public class OMD_O01_ODSNTEOBXNTE extends AbstractGroup {

    /** 
     * Creates a new OMD_O01_ODSNTEOBXNTE group
     */
    public OMD_O01_ODSNTEOBXNTE(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(ODS.class, true, true, false);
                                  this.add(NTE.class, false, true, false);
                                  this.add(OMD_O01_OBXNTE.class, true, true, false);
       } catch(HL7Exception e) {
          log.error("Unexpected error creating OMD_O01_ODSNTEOBXNTE - this is probably a bug in the source code generator.", e);
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
     * the first repetition of 
     * ODS (ODS - dietary orders, supplements, and preferences segment) - creates it if necessary
     */
    public ODS getODS() { 
       ODS retVal = getTyped("ODS", ODS.class);
       return retVal;
    }


    /**
     * Returns a specific repetition of
     * ODS (ODS - dietary orders, supplements, and preferences segment) - creates it if necessary
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public ODS getODS(int rep) { 
       ODS retVal = getTyped("ODS", rep, ODS.class);
       return retVal;
    }

    /** 
     * Returns the number of existing repetitions of ODS 
     */ 
    public int getODSReps() {  
        return getReps("ODS");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of ODS.
     * <p>
     * <p>
     * Note that unlike {@link #getODS()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     */ 
    public java.util.List<ODS> getODSAll() throws HL7Exception {
    	return getAllAsList("ODS", ODS.class);
    } 

    /**
     * Inserts a specific repetition of ODS (ODS - dietary orders, supplements, and preferences segment)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertODS(ODS structure, int rep) throws HL7Exception { 
       super.insertRepetition("ODS", structure, rep);
    }


    /**
     * Inserts a specific repetition of ODS (ODS - dietary orders, supplements, and preferences segment)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public ODS insertODS(int rep) throws HL7Exception { 
       return (ODS)super.insertRepetition("ODS", rep);
    }


    /**
     * Removes a specific repetition of ODS (ODS - dietary orders, supplements, and preferences segment)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public ODS removeODS(int rep) throws HL7Exception { 
       return (ODS)super.removeRepetition("ODS", rep);
    }



    /**
     * Returns
     * the first repetition of 
     * NTE (NTE - notes and comments segment) - creates it if necessary
     */
    public NTE getNTE() { 
       NTE retVal = getTyped("NTE", NTE.class);
       return retVal;
    }


    /**
     * Returns a specific repetition of
     * NTE (NTE - notes and comments segment) - creates it if necessary
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
     * Inserts a specific repetition of NTE (NTE - notes and comments segment)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertNTE(NTE structure, int rep) throws HL7Exception { 
       super.insertRepetition("NTE", structure, rep);
    }


    /**
     * Inserts a specific repetition of NTE (NTE - notes and comments segment)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public NTE insertNTE(int rep) throws HL7Exception { 
       return (NTE)super.insertRepetition("NTE", rep);
    }


    /**
     * Removes a specific repetition of NTE (NTE - notes and comments segment)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public NTE removeNTE(int rep) throws HL7Exception { 
       return (NTE)super.removeRepetition("NTE", rep);
    }



    /**
     * Returns
     * the first repetition of 
     * OBXNTE (a Group object) - creates it if necessary
     */
    public OMD_O01_OBXNTE getOBXNTE() { 
       OMD_O01_OBXNTE retVal = getTyped("OBXNTE", OMD_O01_OBXNTE.class);
       return retVal;
    }


    /**
     * Returns a specific repetition of
     * OBXNTE (a Group object) - creates it if necessary
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public OMD_O01_OBXNTE getOBXNTE(int rep) { 
       OMD_O01_OBXNTE retVal = getTyped("OBXNTE", rep, OMD_O01_OBXNTE.class);
       return retVal;
    }

    /** 
     * Returns the number of existing repetitions of OBXNTE 
     */ 
    public int getOBXNTEReps() {  
        return getReps("OBXNTE");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of OBXNTE.
     * <p>
     * <p>
     * Note that unlike {@link #getOBXNTE()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     */ 
    public java.util.List<OMD_O01_OBXNTE> getOBXNTEAll() throws HL7Exception {
    	return getAllAsList("OBXNTE", OMD_O01_OBXNTE.class);
    } 

    /**
     * Inserts a specific repetition of OBXNTE (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertOBXNTE(OMD_O01_OBXNTE structure, int rep) throws HL7Exception { 
       super.insertRepetition("OBXNTE", structure, rep);
    }


    /**
     * Inserts a specific repetition of OBXNTE (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public OMD_O01_OBXNTE insertOBXNTE(int rep) throws HL7Exception { 
       return (OMD_O01_OBXNTE)super.insertRepetition("OBXNTE", rep);
    }


    /**
     * Removes a specific repetition of OBXNTE (a Group object)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public OMD_O01_OBXNTE removeOBXNTE(int rep) throws HL7Exception { 
       return (OMD_O01_OBXNTE)super.removeRepetition("OBXNTE", rep);
    }



}

