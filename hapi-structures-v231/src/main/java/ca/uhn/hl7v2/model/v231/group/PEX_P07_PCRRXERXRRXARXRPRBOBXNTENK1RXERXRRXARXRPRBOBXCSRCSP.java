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
 * <p>Represents a PEX_P07_PCRRXERXRRXARXRPRBOBXNTENK1RXERXRRXARXRPRBOBXCSRCSP group structure (a Group object).
 * A Group is an ordered collection of message segments that can repeat together or be optionally in/excluded together.
 * This Group contains the following elements:  
 * </p>
 * <ul>
                         * <li>1: PCR (PCR - possible causal relationship segment) <b>  </b></li>
                         * <li>2: PEX_P07_RXERXR (a Group object) <b>optional  </b></li>
                         * <li>3: PEX_P07_RXARXR (a Group object) <b>optional repeating </b></li>
                         * <li>4: PRB (Problem Detail) <b>optional repeating </b></li>
                         * <li>5: OBX (OBX - observation/result segment) <b>optional repeating </b></li>
                         * <li>6: NTE (NTE - notes and comments segment) <b>optional repeating </b></li>
                         * <li>7: PEX_P07_NK1RXERXRRXARXRPRBOBX (a Group object) <b>optional  </b></li>
                         * <li>8: PEX_P07_CSRCSP (a Group object) <b>optional repeating </b></li>
 * </ul>
 */
//@SuppressWarnings("unused")
public class PEX_P07_PCRRXERXRRXARXRPRBOBXNTENK1RXERXRRXARXRPRBOBXCSRCSP extends AbstractGroup {

    /** 
     * Creates a new PEX_P07_PCRRXERXRRXARXRPRBOBXNTENK1RXERXRRXARXRPRBOBXCSRCSP group
     */
    public PEX_P07_PCRRXERXRRXARXRPRBOBXNTENK1RXERXRRXARXRPRBOBXCSRCSP(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(PCR.class, true, false, false);
                                  this.add(PEX_P07_RXERXR.class, false, false, false);
                                  this.add(PEX_P07_RXARXR.class, false, true, false);
                                  this.add(PRB.class, false, true, false);
                                  this.add(OBX.class, false, true, false);
                                  this.add(NTE.class, false, true, false);
                                  this.add(PEX_P07_NK1RXERXRRXARXRPRBOBX.class, false, false, false);
                                  this.add(PEX_P07_CSRCSP.class, false, true, false);
       } catch(HL7Exception e) {
          log.error("Unexpected error creating PEX_P07_PCRRXERXRRXARXRPRBOBXNTENK1RXERXRRXARXRPRBOBXCSRCSP - this is probably a bug in the source code generator.", e);
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
     * PCR (PCR - possible causal relationship segment) - creates it if necessary
     */
    public PCR getPCR() { 
       PCR retVal = getTyped("PCR", PCR.class);
       return retVal;
    }




    /**
     * Returns
     * RXERXR (a Group object) - creates it if necessary
     */
    public PEX_P07_RXERXR getRXERXR() { 
       PEX_P07_RXERXR retVal = getTyped("RXERXR", PEX_P07_RXERXR.class);
       return retVal;
    }




    /**
     * Returns
     * the first repetition of 
     * RXARXR (a Group object) - creates it if necessary
     */
    public PEX_P07_RXARXR getRXARXR() { 
       PEX_P07_RXARXR retVal = getTyped("RXARXR", PEX_P07_RXARXR.class);
       return retVal;
    }


    /**
     * Returns a specific repetition of
     * RXARXR (a Group object) - creates it if necessary
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public PEX_P07_RXARXR getRXARXR(int rep) { 
       PEX_P07_RXARXR retVal = getTyped("RXARXR", rep, PEX_P07_RXARXR.class);
       return retVal;
    }

    /** 
     * Returns the number of existing repetitions of RXARXR 
     */ 
    public int getRXARXRReps() {  
        return getReps("RXARXR");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of RXARXR.
     * <p>
     * <p>
     * Note that unlike {@link #getRXARXR()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     */ 
    public java.util.List<PEX_P07_RXARXR> getRXARXRAll() throws HL7Exception {
    	return getAllAsList("RXARXR", PEX_P07_RXARXR.class);
    } 

    /**
     * Inserts a specific repetition of RXARXR (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertRXARXR(PEX_P07_RXARXR structure, int rep) throws HL7Exception { 
       super.insertRepetition("RXARXR", structure, rep);
    }


    /**
     * Inserts a specific repetition of RXARXR (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public PEX_P07_RXARXR insertRXARXR(int rep) throws HL7Exception { 
       return (PEX_P07_RXARXR)super.insertRepetition("RXARXR", rep);
    }


    /**
     * Removes a specific repetition of RXARXR (a Group object)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public PEX_P07_RXARXR removeRXARXR(int rep) throws HL7Exception { 
       return (PEX_P07_RXARXR)super.removeRepetition("RXARXR", rep);
    }



    /**
     * Returns
     * the first repetition of 
     * PRB (Problem Detail) - creates it if necessary
     */
    public PRB getPRB() { 
       PRB retVal = getTyped("PRB", PRB.class);
       return retVal;
    }


    /**
     * Returns a specific repetition of
     * PRB (Problem Detail) - creates it if necessary
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public PRB getPRB(int rep) { 
       PRB retVal = getTyped("PRB", rep, PRB.class);
       return retVal;
    }

    /** 
     * Returns the number of existing repetitions of PRB 
     */ 
    public int getPRBReps() {  
        return getReps("PRB");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of PRB.
     * <p>
     * <p>
     * Note that unlike {@link #getPRB()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     */ 
    public java.util.List<PRB> getPRBAll() throws HL7Exception {
    	return getAllAsList("PRB", PRB.class);
    } 

    /**
     * Inserts a specific repetition of PRB (Problem Detail)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertPRB(PRB structure, int rep) throws HL7Exception { 
       super.insertRepetition("PRB", structure, rep);
    }


    /**
     * Inserts a specific repetition of PRB (Problem Detail)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public PRB insertPRB(int rep) throws HL7Exception { 
       return (PRB)super.insertRepetition("PRB", rep);
    }


    /**
     * Removes a specific repetition of PRB (Problem Detail)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public PRB removePRB(int rep) throws HL7Exception { 
       return (PRB)super.removeRepetition("PRB", rep);
    }



    /**
     * Returns
     * the first repetition of 
     * OBX (OBX - observation/result segment) - creates it if necessary
     */
    public OBX getOBX() { 
       OBX retVal = getTyped("OBX", OBX.class);
       return retVal;
    }


    /**
     * Returns a specific repetition of
     * OBX (OBX - observation/result segment) - creates it if necessary
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public OBX getOBX(int rep) { 
       OBX retVal = getTyped("OBX", rep, OBX.class);
       return retVal;
    }

    /** 
     * Returns the number of existing repetitions of OBX 
     */ 
    public int getOBXReps() {  
        return getReps("OBX");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of OBX.
     * <p>
     * <p>
     * Note that unlike {@link #getOBX()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     */ 
    public java.util.List<OBX> getOBXAll() throws HL7Exception {
    	return getAllAsList("OBX", OBX.class);
    } 

    /**
     * Inserts a specific repetition of OBX (OBX - observation/result segment)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertOBX(OBX structure, int rep) throws HL7Exception { 
       super.insertRepetition("OBX", structure, rep);
    }


    /**
     * Inserts a specific repetition of OBX (OBX - observation/result segment)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public OBX insertOBX(int rep) throws HL7Exception { 
       return (OBX)super.insertRepetition("OBX", rep);
    }


    /**
     * Removes a specific repetition of OBX (OBX - observation/result segment)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public OBX removeOBX(int rep) throws HL7Exception { 
       return (OBX)super.removeRepetition("OBX", rep);
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
     * NK1RXERXRRXARXRPRBOBX (a Group object) - creates it if necessary
     */
    public PEX_P07_NK1RXERXRRXARXRPRBOBX getNK1RXERXRRXARXRPRBOBX() { 
       PEX_P07_NK1RXERXRRXARXRPRBOBX retVal = getTyped("NK1RXERXRRXARXRPRBOBX", PEX_P07_NK1RXERXRRXARXRPRBOBX.class);
       return retVal;
    }




    /**
     * Returns
     * the first repetition of 
     * CSRCSP (a Group object) - creates it if necessary
     */
    public PEX_P07_CSRCSP getCSRCSP() { 
       PEX_P07_CSRCSP retVal = getTyped("CSRCSP", PEX_P07_CSRCSP.class);
       return retVal;
    }


    /**
     * Returns a specific repetition of
     * CSRCSP (a Group object) - creates it if necessary
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public PEX_P07_CSRCSP getCSRCSP(int rep) { 
       PEX_P07_CSRCSP retVal = getTyped("CSRCSP", rep, PEX_P07_CSRCSP.class);
       return retVal;
    }

    /** 
     * Returns the number of existing repetitions of CSRCSP 
     */ 
    public int getCSRCSPReps() {  
        return getReps("CSRCSP");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of CSRCSP.
     * <p>
     * <p>
     * Note that unlike {@link #getCSRCSP()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     */ 
    public java.util.List<PEX_P07_CSRCSP> getCSRCSPAll() throws HL7Exception {
    	return getAllAsList("CSRCSP", PEX_P07_CSRCSP.class);
    } 

    /**
     * Inserts a specific repetition of CSRCSP (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertCSRCSP(PEX_P07_CSRCSP structure, int rep) throws HL7Exception { 
       super.insertRepetition("CSRCSP", structure, rep);
    }


    /**
     * Inserts a specific repetition of CSRCSP (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public PEX_P07_CSRCSP insertCSRCSP(int rep) throws HL7Exception { 
       return (PEX_P07_CSRCSP)super.insertRepetition("CSRCSP", rep);
    }


    /**
     * Removes a specific repetition of CSRCSP (a Group object)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public PEX_P07_CSRCSP removeCSRCSP(int rep) throws HL7Exception { 
       return (PEX_P07_CSRCSP)super.removeRepetition("CSRCSP", rep);
    }



}

