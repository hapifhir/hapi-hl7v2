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
 * <p>Represents a OPL_O37_ORDER group structure (a Group object).
 * A Group is an ordered collection of message segments that can repeat together or be optionally in/excluded together.
 * This Group contains the following elements:  
 * </p>
 * <ul>
                         * <li>1: NK1 (Next of Kin / Associated Parties) <b> repeating </b></li>
                         * <li>2: OPL_O37_PATIENT (a Group object) <b>optional  </b></li>
                         * <li>3: OPL_O37_SPECIMEN (a Group object) <b> repeating </b></li>
                         * <li>4: OPL_O37_PRIOR_RESULT (a Group object) <b>optional  </b></li>
                         * <li>5: FT1 (Financial Transaction) <b>optional repeating </b></li>
                         * <li>6: CTI (Clinical Trial Identification) <b>optional repeating </b></li>
                         * <li>7: BLG (Billing) <b>optional  </b></li>
 * </ul>
 */
//@SuppressWarnings("unused")
public class OPL_O37_ORDER extends AbstractGroup {

    /** 
     * Creates a new OPL_O37_ORDER group
     */
    public OPL_O37_ORDER(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(NK1.class, true, true, false);
                                  this.add(OPL_O37_PATIENT.class, false, false, false);
                                  this.add(OPL_O37_SPECIMEN.class, true, true, false);
                                  this.add(OPL_O37_PRIOR_RESULT.class, false, false, false);
                                  this.add(FT1.class, false, true, false);
                                  this.add(CTI.class, false, true, false);
                                  this.add(BLG.class, false, false, false);
       } catch(HL7Exception e) {
          log.error("Unexpected error creating OPL_O37_ORDER - this is probably a bug in the source code generator.", e);
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
     * the first repetition of 
     * NK1 (Next of Kin / Associated Parties) - creates it if necessary
     */
    public NK1 getNK1() { 
       NK1 retVal = getTyped("NK1", NK1.class);
       return retVal;
    }


    /**
     * Returns a specific repetition of
     * NK1 (Next of Kin / Associated Parties) - creates it if necessary
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public NK1 getNK1(int rep) { 
       NK1 retVal = getTyped("NK1", rep, NK1.class);
       return retVal;
    }

    /** 
     * Returns the number of existing repetitions of NK1 
     */ 
    public int getNK1Reps() {  
        return getReps("NK1");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of NK1.
     * <p>
     * <p>
     * Note that unlike {@link #getNK1()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     */ 
    public java.util.List<NK1> getNK1All() throws HL7Exception {
    	return getAllAsList("NK1", NK1.class);
    } 

    /**
     * Inserts a specific repetition of NK1 (Next of Kin / Associated Parties)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertNK1(NK1 structure, int rep) throws HL7Exception { 
       super.insertRepetition("NK1", structure, rep);
    }


    /**
     * Inserts a specific repetition of NK1 (Next of Kin / Associated Parties)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public NK1 insertNK1(int rep) throws HL7Exception { 
       return (NK1)super.insertRepetition("NK1", rep);
    }


    /**
     * Removes a specific repetition of NK1 (Next of Kin / Associated Parties)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public NK1 removeNK1(int rep) throws HL7Exception { 
       return (NK1)super.removeRepetition("NK1", rep);
    }



    /**
     * Returns
     * PATIENT (a Group object) - creates it if necessary
     */
    public OPL_O37_PATIENT getPATIENT() { 
       OPL_O37_PATIENT retVal = getTyped("PATIENT", OPL_O37_PATIENT.class);
       return retVal;
    }




    /**
     * Returns
     * the first repetition of 
     * SPECIMEN (a Group object) - creates it if necessary
     */
    public OPL_O37_SPECIMEN getSPECIMEN() { 
       OPL_O37_SPECIMEN retVal = getTyped("SPECIMEN", OPL_O37_SPECIMEN.class);
       return retVal;
    }


    /**
     * Returns a specific repetition of
     * SPECIMEN (a Group object) - creates it if necessary
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public OPL_O37_SPECIMEN getSPECIMEN(int rep) { 
       OPL_O37_SPECIMEN retVal = getTyped("SPECIMEN", rep, OPL_O37_SPECIMEN.class);
       return retVal;
    }

    /** 
     * Returns the number of existing repetitions of SPECIMEN 
     */ 
    public int getSPECIMENReps() {  
        return getReps("SPECIMEN");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of SPECIMEN.
     * <p>
     * <p>
     * Note that unlike {@link #getSPECIMEN()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     */ 
    public java.util.List<OPL_O37_SPECIMEN> getSPECIMENAll() throws HL7Exception {
    	return getAllAsList("SPECIMEN", OPL_O37_SPECIMEN.class);
    } 

    /**
     * Inserts a specific repetition of SPECIMEN (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertSPECIMEN(OPL_O37_SPECIMEN structure, int rep) throws HL7Exception { 
       super.insertRepetition("SPECIMEN", structure, rep);
    }


    /**
     * Inserts a specific repetition of SPECIMEN (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public OPL_O37_SPECIMEN insertSPECIMEN(int rep) throws HL7Exception { 
       return (OPL_O37_SPECIMEN)super.insertRepetition("SPECIMEN", rep);
    }


    /**
     * Removes a specific repetition of SPECIMEN (a Group object)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public OPL_O37_SPECIMEN removeSPECIMEN(int rep) throws HL7Exception { 
       return (OPL_O37_SPECIMEN)super.removeRepetition("SPECIMEN", rep);
    }



    /**
     * Returns
     * PRIOR_RESULT (a Group object) - creates it if necessary
     */
    public OPL_O37_PRIOR_RESULT getPRIOR_RESULT() { 
       OPL_O37_PRIOR_RESULT retVal = getTyped("PRIOR_RESULT", OPL_O37_PRIOR_RESULT.class);
       return retVal;
    }




    /**
     * Returns
     * the first repetition of 
     * FT1 (Financial Transaction) - creates it if necessary
     */
    public FT1 getFT1() { 
       FT1 retVal = getTyped("FT1", FT1.class);
       return retVal;
    }


    /**
     * Returns a specific repetition of
     * FT1 (Financial Transaction) - creates it if necessary
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public FT1 getFT1(int rep) { 
       FT1 retVal = getTyped("FT1", rep, FT1.class);
       return retVal;
    }

    /** 
     * Returns the number of existing repetitions of FT1 
     */ 
    public int getFT1Reps() {  
        return getReps("FT1");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of FT1.
     * <p>
     * <p>
     * Note that unlike {@link #getFT1()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     */ 
    public java.util.List<FT1> getFT1All() throws HL7Exception {
    	return getAllAsList("FT1", FT1.class);
    } 

    /**
     * Inserts a specific repetition of FT1 (Financial Transaction)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertFT1(FT1 structure, int rep) throws HL7Exception { 
       super.insertRepetition("FT1", structure, rep);
    }


    /**
     * Inserts a specific repetition of FT1 (Financial Transaction)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public FT1 insertFT1(int rep) throws HL7Exception { 
       return (FT1)super.insertRepetition("FT1", rep);
    }


    /**
     * Removes a specific repetition of FT1 (Financial Transaction)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public FT1 removeFT1(int rep) throws HL7Exception { 
       return (FT1)super.removeRepetition("FT1", rep);
    }



    /**
     * Returns
     * the first repetition of 
     * CTI (Clinical Trial Identification) - creates it if necessary
     */
    public CTI getCTI() { 
       CTI retVal = getTyped("CTI", CTI.class);
       return retVal;
    }


    /**
     * Returns a specific repetition of
     * CTI (Clinical Trial Identification) - creates it if necessary
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public CTI getCTI(int rep) { 
       CTI retVal = getTyped("CTI", rep, CTI.class);
       return retVal;
    }

    /** 
     * Returns the number of existing repetitions of CTI 
     */ 
    public int getCTIReps() {  
        return getReps("CTI");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of CTI.
     * <p>
     * <p>
     * Note that unlike {@link #getCTI()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     */ 
    public java.util.List<CTI> getCTIAll() throws HL7Exception {
    	return getAllAsList("CTI", CTI.class);
    } 

    /**
     * Inserts a specific repetition of CTI (Clinical Trial Identification)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertCTI(CTI structure, int rep) throws HL7Exception { 
       super.insertRepetition("CTI", structure, rep);
    }


    /**
     * Inserts a specific repetition of CTI (Clinical Trial Identification)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public CTI insertCTI(int rep) throws HL7Exception { 
       return (CTI)super.insertRepetition("CTI", rep);
    }


    /**
     * Removes a specific repetition of CTI (Clinical Trial Identification)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public CTI removeCTI(int rep) throws HL7Exception { 
       return (CTI)super.removeRepetition("CTI", rep);
    }



    /**
     * Returns
     * BLG (Billing) - creates it if necessary
     */
    public BLG getBLG() { 
       BLG retVal = getTyped("BLG", BLG.class);
       return retVal;
    }




}

