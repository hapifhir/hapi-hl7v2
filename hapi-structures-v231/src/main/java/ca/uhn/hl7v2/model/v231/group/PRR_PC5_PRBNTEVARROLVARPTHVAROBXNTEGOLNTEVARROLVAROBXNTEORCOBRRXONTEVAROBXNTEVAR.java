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
 * <p>Represents a PRR_PC5_PRBNTEVARROLVARPTHVAROBXNTEGOLNTEVARROLVAROBXNTEORCOBRRXONTEVAROBXNTEVAR group structure (a Group object).
 * A Group is an ordered collection of message segments that can repeat together or be optionally in/excluded together.
 * This Group contains the following elements:  
 * </p>
 * <ul>
                         * <li>1: PRB (Problem Detail) <b>  </b></li>
                         * <li>2: NTE (NTE - notes and comments segment) <b>optional repeating </b></li>
                         * <li>3: VAR (Variance) <b>optional repeating </b></li>
                         * <li>4: PRR_PC5_ROLVAR (a Group object) <b>optional repeating </b></li>
                         * <li>5: PRR_PC5_PTHVAR (a Group object) <b>optional repeating </b></li>
                         * <li>6: PRR_PC5_OBXNTE (a Group object) <b>optional repeating </b></li>
                         * <li>7: PRR_PC5_GOLNTEVARROLVAROBXNTE (a Group object) <b>optional repeating </b></li>
                         * <li>8: PRR_PC5_ORCOBRRXONTEVAROBXNTEVAR (a Group object) <b>optional repeating </b></li>
 * </ul>
 */
//@SuppressWarnings("unused")
public class PRR_PC5_PRBNTEVARROLVARPTHVAROBXNTEGOLNTEVARROLVAROBXNTEORCOBRRXONTEVAROBXNTEVAR extends AbstractGroup {

    /** 
     * Creates a new PRR_PC5_PRBNTEVARROLVARPTHVAROBXNTEGOLNTEVARROLVAROBXNTEORCOBRRXONTEVAROBXNTEVAR group
     */
    public PRR_PC5_PRBNTEVARROLVARPTHVAROBXNTEGOLNTEVARROLVAROBXNTEORCOBRRXONTEVAROBXNTEVAR(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(PRB.class, true, false, false);
                                  this.add(NTE.class, false, true, false);
                                  this.add(VAR.class, false, true, false);
                                  this.add(PRR_PC5_ROLVAR.class, false, true, false);
                                  this.add(PRR_PC5_PTHVAR.class, false, true, false);
                                  this.add(PRR_PC5_OBXNTE.class, false, true, false);
                                  this.add(PRR_PC5_GOLNTEVARROLVAROBXNTE.class, false, true, false);
                                  this.add(PRR_PC5_ORCOBRRXONTEVAROBXNTEVAR.class, false, true, false);
       } catch(HL7Exception e) {
          log.error("Unexpected error creating PRR_PC5_PRBNTEVARROLVARPTHVAROBXNTEGOLNTEVARROLVAROBXNTEORCOBRRXONTEVAROBXNTEVAR - this is probably a bug in the source code generator.", e);
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
     * PRB (Problem Detail) - creates it if necessary
     */
    public PRB getPRB() { 
       PRB retVal = getTyped("PRB", PRB.class);
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
     * VAR (Variance) - creates it if necessary
     */
    public VAR getVAR() { 
       VAR retVal = getTyped("VAR", VAR.class);
       return retVal;
    }


    /**
     * Returns a specific repetition of
     * VAR (Variance) - creates it if necessary
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public VAR getVAR(int rep) { 
       VAR retVal = getTyped("VAR", rep, VAR.class);
       return retVal;
    }

    /** 
     * Returns the number of existing repetitions of VAR 
     */ 
    public int getVARReps() {  
        return getReps("VAR");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of VAR.
     * <p>
     * <p>
     * Note that unlike {@link #getVAR()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     */ 
    public java.util.List<VAR> getVARAll() throws HL7Exception {
    	return getAllAsList("VAR", VAR.class);
    } 

    /**
     * Inserts a specific repetition of VAR (Variance)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertVAR(VAR structure, int rep) throws HL7Exception { 
       super.insertRepetition("VAR", structure, rep);
    }


    /**
     * Inserts a specific repetition of VAR (Variance)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public VAR insertVAR(int rep) throws HL7Exception { 
       return (VAR)super.insertRepetition("VAR", rep);
    }


    /**
     * Removes a specific repetition of VAR (Variance)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public VAR removeVAR(int rep) throws HL7Exception { 
       return (VAR)super.removeRepetition("VAR", rep);
    }



    /**
     * Returns
     * the first repetition of 
     * ROLVAR (a Group object) - creates it if necessary
     */
    public PRR_PC5_ROLVAR getROLVAR() { 
       PRR_PC5_ROLVAR retVal = getTyped("ROLVAR", PRR_PC5_ROLVAR.class);
       return retVal;
    }


    /**
     * Returns a specific repetition of
     * ROLVAR (a Group object) - creates it if necessary
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public PRR_PC5_ROLVAR getROLVAR(int rep) { 
       PRR_PC5_ROLVAR retVal = getTyped("ROLVAR", rep, PRR_PC5_ROLVAR.class);
       return retVal;
    }

    /** 
     * Returns the number of existing repetitions of ROLVAR 
     */ 
    public int getROLVARReps() {  
        return getReps("ROLVAR");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of ROLVAR.
     * <p>
     * <p>
     * Note that unlike {@link #getROLVAR()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     */ 
    public java.util.List<PRR_PC5_ROLVAR> getROLVARAll() throws HL7Exception {
    	return getAllAsList("ROLVAR", PRR_PC5_ROLVAR.class);
    } 

    /**
     * Inserts a specific repetition of ROLVAR (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertROLVAR(PRR_PC5_ROLVAR structure, int rep) throws HL7Exception { 
       super.insertRepetition("ROLVAR", structure, rep);
    }


    /**
     * Inserts a specific repetition of ROLVAR (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public PRR_PC5_ROLVAR insertROLVAR(int rep) throws HL7Exception { 
       return (PRR_PC5_ROLVAR)super.insertRepetition("ROLVAR", rep);
    }


    /**
     * Removes a specific repetition of ROLVAR (a Group object)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public PRR_PC5_ROLVAR removeROLVAR(int rep) throws HL7Exception { 
       return (PRR_PC5_ROLVAR)super.removeRepetition("ROLVAR", rep);
    }



    /**
     * Returns
     * the first repetition of 
     * PTHVAR (a Group object) - creates it if necessary
     */
    public PRR_PC5_PTHVAR getPTHVAR() { 
       PRR_PC5_PTHVAR retVal = getTyped("PTHVAR", PRR_PC5_PTHVAR.class);
       return retVal;
    }


    /**
     * Returns a specific repetition of
     * PTHVAR (a Group object) - creates it if necessary
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public PRR_PC5_PTHVAR getPTHVAR(int rep) { 
       PRR_PC5_PTHVAR retVal = getTyped("PTHVAR", rep, PRR_PC5_PTHVAR.class);
       return retVal;
    }

    /** 
     * Returns the number of existing repetitions of PTHVAR 
     */ 
    public int getPTHVARReps() {  
        return getReps("PTHVAR");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of PTHVAR.
     * <p>
     * <p>
     * Note that unlike {@link #getPTHVAR()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     */ 
    public java.util.List<PRR_PC5_PTHVAR> getPTHVARAll() throws HL7Exception {
    	return getAllAsList("PTHVAR", PRR_PC5_PTHVAR.class);
    } 

    /**
     * Inserts a specific repetition of PTHVAR (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertPTHVAR(PRR_PC5_PTHVAR structure, int rep) throws HL7Exception { 
       super.insertRepetition("PTHVAR", structure, rep);
    }


    /**
     * Inserts a specific repetition of PTHVAR (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public PRR_PC5_PTHVAR insertPTHVAR(int rep) throws HL7Exception { 
       return (PRR_PC5_PTHVAR)super.insertRepetition("PTHVAR", rep);
    }


    /**
     * Removes a specific repetition of PTHVAR (a Group object)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public PRR_PC5_PTHVAR removePTHVAR(int rep) throws HL7Exception { 
       return (PRR_PC5_PTHVAR)super.removeRepetition("PTHVAR", rep);
    }



    /**
     * Returns
     * the first repetition of 
     * OBXNTE (a Group object) - creates it if necessary
     */
    public PRR_PC5_OBXNTE getOBXNTE() { 
       PRR_PC5_OBXNTE retVal = getTyped("OBXNTE", PRR_PC5_OBXNTE.class);
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
    public PRR_PC5_OBXNTE getOBXNTE(int rep) { 
       PRR_PC5_OBXNTE retVal = getTyped("OBXNTE", rep, PRR_PC5_OBXNTE.class);
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
    public java.util.List<PRR_PC5_OBXNTE> getOBXNTEAll() throws HL7Exception {
    	return getAllAsList("OBXNTE", PRR_PC5_OBXNTE.class);
    } 

    /**
     * Inserts a specific repetition of OBXNTE (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertOBXNTE(PRR_PC5_OBXNTE structure, int rep) throws HL7Exception { 
       super.insertRepetition("OBXNTE", structure, rep);
    }


    /**
     * Inserts a specific repetition of OBXNTE (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public PRR_PC5_OBXNTE insertOBXNTE(int rep) throws HL7Exception { 
       return (PRR_PC5_OBXNTE)super.insertRepetition("OBXNTE", rep);
    }


    /**
     * Removes a specific repetition of OBXNTE (a Group object)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public PRR_PC5_OBXNTE removeOBXNTE(int rep) throws HL7Exception { 
       return (PRR_PC5_OBXNTE)super.removeRepetition("OBXNTE", rep);
    }



    /**
     * Returns
     * the first repetition of 
     * GOLNTEVARROLVAROBXNTE (a Group object) - creates it if necessary
     */
    public PRR_PC5_GOLNTEVARROLVAROBXNTE getGOLNTEVARROLVAROBXNTE() { 
       PRR_PC5_GOLNTEVARROLVAROBXNTE retVal = getTyped("GOLNTEVARROLVAROBXNTE", PRR_PC5_GOLNTEVARROLVAROBXNTE.class);
       return retVal;
    }


    /**
     * Returns a specific repetition of
     * GOLNTEVARROLVAROBXNTE (a Group object) - creates it if necessary
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public PRR_PC5_GOLNTEVARROLVAROBXNTE getGOLNTEVARROLVAROBXNTE(int rep) { 
       PRR_PC5_GOLNTEVARROLVAROBXNTE retVal = getTyped("GOLNTEVARROLVAROBXNTE", rep, PRR_PC5_GOLNTEVARROLVAROBXNTE.class);
       return retVal;
    }

    /** 
     * Returns the number of existing repetitions of GOLNTEVARROLVAROBXNTE 
     */ 
    public int getGOLNTEVARROLVAROBXNTEReps() {  
        return getReps("GOLNTEVARROLVAROBXNTE");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of GOLNTEVARROLVAROBXNTE.
     * <p>
     * <p>
     * Note that unlike {@link #getGOLNTEVARROLVAROBXNTE()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     */ 
    public java.util.List<PRR_PC5_GOLNTEVARROLVAROBXNTE> getGOLNTEVARROLVAROBXNTEAll() throws HL7Exception {
    	return getAllAsList("GOLNTEVARROLVAROBXNTE", PRR_PC5_GOLNTEVARROLVAROBXNTE.class);
    } 

    /**
     * Inserts a specific repetition of GOLNTEVARROLVAROBXNTE (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertGOLNTEVARROLVAROBXNTE(PRR_PC5_GOLNTEVARROLVAROBXNTE structure, int rep) throws HL7Exception { 
       super.insertRepetition("GOLNTEVARROLVAROBXNTE", structure, rep);
    }


    /**
     * Inserts a specific repetition of GOLNTEVARROLVAROBXNTE (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public PRR_PC5_GOLNTEVARROLVAROBXNTE insertGOLNTEVARROLVAROBXNTE(int rep) throws HL7Exception { 
       return (PRR_PC5_GOLNTEVARROLVAROBXNTE)super.insertRepetition("GOLNTEVARROLVAROBXNTE", rep);
    }


    /**
     * Removes a specific repetition of GOLNTEVARROLVAROBXNTE (a Group object)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public PRR_PC5_GOLNTEVARROLVAROBXNTE removeGOLNTEVARROLVAROBXNTE(int rep) throws HL7Exception { 
       return (PRR_PC5_GOLNTEVARROLVAROBXNTE)super.removeRepetition("GOLNTEVARROLVAROBXNTE", rep);
    }



    /**
     * Returns
     * the first repetition of 
     * ORCOBRRXONTEVAROBXNTEVAR (a Group object) - creates it if necessary
     */
    public PRR_PC5_ORCOBRRXONTEVAROBXNTEVAR getORCOBRRXONTEVAROBXNTEVAR() { 
       PRR_PC5_ORCOBRRXONTEVAROBXNTEVAR retVal = getTyped("ORCOBRRXONTEVAROBXNTEVAR", PRR_PC5_ORCOBRRXONTEVAROBXNTEVAR.class);
       return retVal;
    }


    /**
     * Returns a specific repetition of
     * ORCOBRRXONTEVAROBXNTEVAR (a Group object) - creates it if necessary
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public PRR_PC5_ORCOBRRXONTEVAROBXNTEVAR getORCOBRRXONTEVAROBXNTEVAR(int rep) { 
       PRR_PC5_ORCOBRRXONTEVAROBXNTEVAR retVal = getTyped("ORCOBRRXONTEVAROBXNTEVAR", rep, PRR_PC5_ORCOBRRXONTEVAROBXNTEVAR.class);
       return retVal;
    }

    /** 
     * Returns the number of existing repetitions of ORCOBRRXONTEVAROBXNTEVAR 
     */ 
    public int getORCOBRRXONTEVAROBXNTEVARReps() {  
        return getReps("ORCOBRRXONTEVAROBXNTEVAR");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of ORCOBRRXONTEVAROBXNTEVAR.
     * <p>
     * <p>
     * Note that unlike {@link #getORCOBRRXONTEVAROBXNTEVAR()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     */ 
    public java.util.List<PRR_PC5_ORCOBRRXONTEVAROBXNTEVAR> getORCOBRRXONTEVAROBXNTEVARAll() throws HL7Exception {
    	return getAllAsList("ORCOBRRXONTEVAROBXNTEVAR", PRR_PC5_ORCOBRRXONTEVAROBXNTEVAR.class);
    } 

    /**
     * Inserts a specific repetition of ORCOBRRXONTEVAROBXNTEVAR (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertORCOBRRXONTEVAROBXNTEVAR(PRR_PC5_ORCOBRRXONTEVAROBXNTEVAR structure, int rep) throws HL7Exception { 
       super.insertRepetition("ORCOBRRXONTEVAROBXNTEVAR", structure, rep);
    }


    /**
     * Inserts a specific repetition of ORCOBRRXONTEVAROBXNTEVAR (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public PRR_PC5_ORCOBRRXONTEVAROBXNTEVAR insertORCOBRRXONTEVAROBXNTEVAR(int rep) throws HL7Exception { 
       return (PRR_PC5_ORCOBRRXONTEVAROBXNTEVAR)super.insertRepetition("ORCOBRRXONTEVAROBXNTEVAR", rep);
    }


    /**
     * Removes a specific repetition of ORCOBRRXONTEVAROBXNTEVAR (a Group object)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public PRR_PC5_ORCOBRRXONTEVAROBXNTEVAR removeORCOBRRXONTEVAROBXNTEVAR(int rep) throws HL7Exception { 
       return (PRR_PC5_ORCOBRRXONTEVAROBXNTEVAR)super.removeRepetition("ORCOBRRXONTEVAROBXNTEVAR", rep);
    }



}

