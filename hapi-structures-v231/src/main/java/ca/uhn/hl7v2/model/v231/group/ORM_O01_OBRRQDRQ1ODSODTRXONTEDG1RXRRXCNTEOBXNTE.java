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
 * <p>Represents a ORM_O01_OBRRQDRQ1ODSODTRXONTEDG1RXRRXCNTEOBXNTE group structure (a Group object).
 * A Group is an ordered collection of message segments that can repeat together or be optionally in/excluded together.
 * This Group contains the following elements:  
 * </p>
 * <ul>
                         * <li>1: OBR (OBR - observation request segment) <b>  choice</b></li>
                         * <li>2: RQD (RQD - requisition detail segment) <b>  choice</b></li>
                         * <li>3: RQ1 (RQ1 - requisition detail-1 segment) <b>  choice</b></li>
                         * <li>4: ODS (ODS - dietary orders, supplements, and preferences segment) <b>  choice</b></li>
                         * <li>5: ODT (ODT - diet tray instructions segment) <b>  choice</b></li>
                         * <li>6: RXO (RXO - pharmacy/treatment order segment) <b>  choice</b></li>
                         * <li>7: NTE (NTE - notes and comments segment) <b>optional repeating </b></li>
                         * <li>8: DG1 (DG1 - diagnosis segment) <b>optional repeating </b></li>
                         * <li>9: RXR (RXR - pharmacy/treatment route segment) <b> repeating </b></li>
                         * <li>10: ORM_O01_RXCNTE (a Group object) <b>optional  </b></li>
                         * <li>11: ORM_O01_OBXNTE (a Group object) <b>optional repeating </b></li>
 * </ul>
 * <p>
 * Note that this structure has "choice" elements. This means that one of the 
 * structures above marked as "choice" must be present, but no more than one.
 * </p> 
 */
//@SuppressWarnings("unused")
public class ORM_O01_OBRRQDRQ1ODSODTRXONTEDG1RXRRXCNTEOBXNTE extends AbstractGroup {

    /** 
     * Creates a new ORM_O01_OBRRQDRQ1ODSODTRXONTEDG1RXRRXCNTEOBXNTE group
     */
    public ORM_O01_OBRRQDRQ1ODSODTRXONTEDG1RXRRXCNTEOBXNTE(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(OBR.class, true, false, true);
                                  this.add(RQD.class, true, false, true);
                                  this.add(RQ1.class, true, false, true);
                                  this.add(ODS.class, true, false, true);
                                  this.add(ODT.class, true, false, true);
                                  this.add(RXO.class, true, false, true);
                                  this.add(NTE.class, false, true, false);
                                  this.add(DG1.class, false, true, false);
                                  this.add(RXR.class, true, true, false);
                                  this.add(ORM_O01_RXCNTE.class, false, false, false);
                                  this.add(ORM_O01_OBXNTE.class, false, true, false);
       } catch(HL7Exception e) {
          log.error("Unexpected error creating ORM_O01_OBRRQDRQ1ODSODTRXONTEDG1RXRRXCNTEOBXNTE - this is probably a bug in the source code generator.", e);
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
     * OBR (OBR - observation request segment) - creates it if necessary
     */
    public OBR getOBR() { 
       OBR retVal = getTyped("OBR", OBR.class);
       return retVal;
    }




    /**
     * Returns
     * RQD (RQD - requisition detail segment) - creates it if necessary
     */
    public RQD getRQD() { 
       RQD retVal = getTyped("RQD", RQD.class);
       return retVal;
    }




    /**
     * Returns
     * RQ1 (RQ1 - requisition detail-1 segment) - creates it if necessary
     */
    public RQ1 getRQ1() { 
       RQ1 retVal = getTyped("RQ1", RQ1.class);
       return retVal;
    }




    /**
     * Returns
     * ODS (ODS - dietary orders, supplements, and preferences segment) - creates it if necessary
     */
    public ODS getODS() { 
       ODS retVal = getTyped("ODS", ODS.class);
       return retVal;
    }




    /**
     * Returns
     * ODT (ODT - diet tray instructions segment) - creates it if necessary
     */
    public ODT getODT() { 
       ODT retVal = getTyped("ODT", ODT.class);
       return retVal;
    }




    /**
     * Returns
     * RXO (RXO - pharmacy/treatment order segment) - creates it if necessary
     */
    public RXO getRXO() { 
       RXO retVal = getTyped("RXO", RXO.class);
       return retVal;
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
     * DG1 (DG1 - diagnosis segment) - creates it if necessary
     */
    public DG1 getDG1() { 
       DG1 retVal = getTyped("DG1", DG1.class);
       return retVal;
    }


    /**
     * Returns a specific repetition of
     * DG1 (DG1 - diagnosis segment) - creates it if necessary
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public DG1 getDG1(int rep) { 
       DG1 retVal = getTyped("DG1", rep, DG1.class);
       return retVal;
    }

    /** 
     * Returns the number of existing repetitions of DG1 
     */ 
    public int getDG1Reps() {  
        return getReps("DG1");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of DG1.
     * <p>
     * <p>
     * Note that unlike {@link #getDG1()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     */ 
    public java.util.List<DG1> getDG1All() throws HL7Exception {
    	return getAllAsList("DG1", DG1.class);
    } 

    /**
     * Inserts a specific repetition of DG1 (DG1 - diagnosis segment)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertDG1(DG1 structure, int rep) throws HL7Exception { 
       super.insertRepetition("DG1", structure, rep);
    }


    /**
     * Inserts a specific repetition of DG1 (DG1 - diagnosis segment)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public DG1 insertDG1(int rep) throws HL7Exception { 
       return (DG1)super.insertRepetition("DG1", rep);
    }


    /**
     * Removes a specific repetition of DG1 (DG1 - diagnosis segment)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public DG1 removeDG1(int rep) throws HL7Exception { 
       return (DG1)super.removeRepetition("DG1", rep);
    }



    /**
     * Returns
     * the first repetition of 
     * RXR (RXR - pharmacy/treatment route segment) - creates it if necessary
     */
    public RXR getRXR() { 
       RXR retVal = getTyped("RXR", RXR.class);
       return retVal;
    }


    /**
     * Returns a specific repetition of
     * RXR (RXR - pharmacy/treatment route segment) - creates it if necessary
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public RXR getRXR(int rep) { 
       RXR retVal = getTyped("RXR", rep, RXR.class);
       return retVal;
    }

    /** 
     * Returns the number of existing repetitions of RXR 
     */ 
    public int getRXRReps() {  
        return getReps("RXR");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of RXR.
     * <p>
     * <p>
     * Note that unlike {@link #getRXR()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     */ 
    public java.util.List<RXR> getRXRAll() throws HL7Exception {
    	return getAllAsList("RXR", RXR.class);
    } 

    /**
     * Inserts a specific repetition of RXR (RXR - pharmacy/treatment route segment)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertRXR(RXR structure, int rep) throws HL7Exception { 
       super.insertRepetition("RXR", structure, rep);
    }


    /**
     * Inserts a specific repetition of RXR (RXR - pharmacy/treatment route segment)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public RXR insertRXR(int rep) throws HL7Exception { 
       return (RXR)super.insertRepetition("RXR", rep);
    }


    /**
     * Removes a specific repetition of RXR (RXR - pharmacy/treatment route segment)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public RXR removeRXR(int rep) throws HL7Exception { 
       return (RXR)super.removeRepetition("RXR", rep);
    }



    /**
     * Returns
     * RXCNTE (a Group object) - creates it if necessary
     */
    public ORM_O01_RXCNTE getRXCNTE() { 
       ORM_O01_RXCNTE retVal = getTyped("RXCNTE", ORM_O01_RXCNTE.class);
       return retVal;
    }




    /**
     * Returns
     * the first repetition of 
     * OBXNTE (a Group object) - creates it if necessary
     */
    public ORM_O01_OBXNTE getOBXNTE() { 
       ORM_O01_OBXNTE retVal = getTyped("OBXNTE", ORM_O01_OBXNTE.class);
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
    public ORM_O01_OBXNTE getOBXNTE(int rep) { 
       ORM_O01_OBXNTE retVal = getTyped("OBXNTE", rep, ORM_O01_OBXNTE.class);
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
    public java.util.List<ORM_O01_OBXNTE> getOBXNTEAll() throws HL7Exception {
    	return getAllAsList("OBXNTE", ORM_O01_OBXNTE.class);
    } 

    /**
     * Inserts a specific repetition of OBXNTE (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertOBXNTE(ORM_O01_OBXNTE structure, int rep) throws HL7Exception { 
       super.insertRepetition("OBXNTE", structure, rep);
    }


    /**
     * Inserts a specific repetition of OBXNTE (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public ORM_O01_OBXNTE insertOBXNTE(int rep) throws HL7Exception { 
       return (ORM_O01_OBXNTE)super.insertRepetition("OBXNTE", rep);
    }


    /**
     * Removes a specific repetition of OBXNTE (a Group object)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public ORM_O01_OBXNTE removeOBXNTE(int rep) throws HL7Exception { 
       return (ORM_O01_OBXNTE)super.removeRepetition("OBXNTE", rep);
    }



}

