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
 * <p>Represents a EHC_E01_PRODUCT_SERVICE_GROUP group structure (a Group object).
 * A Group is an ordered collection of message segments that can repeat together or be optionally in/excluded together.
 * This Group contains the following elements:  
 * </p>
 * <ul>
                         * <li>1: PSG (Product/Service Group) <b>  choice</b></li>
                         * <li>2: LOC (Location Identification) <b>optional repeating choice</b></li>
                         * <li>3: PRT (Participation Information) <b>optional repeating choice</b></li>
                         * <li>4: ROL (Role) <b>optional repeating choice</b></li>
                         * <li>5: EHC_E01_PATIENT_INFO (a Group object) <b>optional repeating </b></li>
                         * <li>6: EHC_E01_PRODUCT_SERVICE_LINE_ITEM (a Group object) <b> repeating </b></li>
                         * <li>7: EHC_E01_PROCEDURE (a Group object) <b>optional repeating </b></li>
                         * <li>8: IPR (Invoice Processing Results) <b>optional repeating choice</b></li>
 * </ul>
 * <p>
 * Note that this structure has "choice" elements. This means that one of the 
 * structures above marked as "choice" must be present, but no more than one.
 * </p> 
 */
//@SuppressWarnings("unused")
public class EHC_E01_PRODUCT_SERVICE_GROUP extends AbstractGroup {

    /** 
     * Creates a new EHC_E01_PRODUCT_SERVICE_GROUP group
     */
    public EHC_E01_PRODUCT_SERVICE_GROUP(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(PSG.class, true, false, true);
                                  this.add(LOC.class, false, true, true);
                                  this.add(PRT.class, false, true, true);
                                  this.add(ROL.class, false, true, true);
                                  this.add(EHC_E01_PATIENT_INFO.class, false, true, false);
                                  this.add(EHC_E01_PRODUCT_SERVICE_LINE_ITEM.class, true, true, false);
                                  this.add(EHC_E01_PROCEDURE.class, false, true, false);
                                  this.add(IPR.class, false, true, true);
       } catch(HL7Exception e) {
          log.error("Unexpected error creating EHC_E01_PRODUCT_SERVICE_GROUP - this is probably a bug in the source code generator.", e);
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
     * PSG (Product/Service Group) - creates it if necessary
     */
    public PSG getPSG() { 
       PSG retVal = getTyped("PSG", PSG.class);
       return retVal;
    }




    /**
     * Returns
     * the first repetition of 
     * LOC (Location Identification) - creates it if necessary
     */
    public LOC getLOC() { 
       LOC retVal = getTyped("LOC", LOC.class);
       return retVal;
    }


    /**
     * Returns a specific repetition of
     * LOC (Location Identification) - creates it if necessary
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public LOC getLOC(int rep) { 
       LOC retVal = getTyped("LOC", rep, LOC.class);
       return retVal;
    }

    /** 
     * Returns the number of existing repetitions of LOC 
     */ 
    public int getLOCReps() {  
        return getReps("LOC");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of LOC.
     * <p>
     * <p>
     * Note that unlike {@link #getLOC()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     */ 
    public java.util.List<LOC> getLOCAll() throws HL7Exception {
    	return getAllAsList("LOC", LOC.class);
    } 

    /**
     * Inserts a specific repetition of LOC (Location Identification)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertLOC(LOC structure, int rep) throws HL7Exception { 
       super.insertRepetition("LOC", structure, rep);
    }


    /**
     * Inserts a specific repetition of LOC (Location Identification)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public LOC insertLOC(int rep) throws HL7Exception { 
       return (LOC)super.insertRepetition("LOC", rep);
    }


    /**
     * Removes a specific repetition of LOC (Location Identification)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public LOC removeLOC(int rep) throws HL7Exception { 
       return (LOC)super.removeRepetition("LOC", rep);
    }



    /**
     * Returns
     * the first repetition of 
     * PRT (Participation Information) - creates it if necessary
     */
    public PRT getPRT() { 
       PRT retVal = getTyped("PRT", PRT.class);
       return retVal;
    }


    /**
     * Returns a specific repetition of
     * PRT (Participation Information) - creates it if necessary
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public PRT getPRT(int rep) { 
       PRT retVal = getTyped("PRT", rep, PRT.class);
       return retVal;
    }

    /** 
     * Returns the number of existing repetitions of PRT 
     */ 
    public int getPRTReps() {  
        return getReps("PRT");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of PRT.
     * <p>
     * <p>
     * Note that unlike {@link #getPRT()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     */ 
    public java.util.List<PRT> getPRTAll() throws HL7Exception {
    	return getAllAsList("PRT", PRT.class);
    } 

    /**
     * Inserts a specific repetition of PRT (Participation Information)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertPRT(PRT structure, int rep) throws HL7Exception { 
       super.insertRepetition("PRT", structure, rep);
    }


    /**
     * Inserts a specific repetition of PRT (Participation Information)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public PRT insertPRT(int rep) throws HL7Exception { 
       return (PRT)super.insertRepetition("PRT", rep);
    }


    /**
     * Removes a specific repetition of PRT (Participation Information)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public PRT removePRT(int rep) throws HL7Exception { 
       return (PRT)super.removeRepetition("PRT", rep);
    }



    /**
     * Returns
     * the first repetition of 
     * ROL (Role) - creates it if necessary
     */
    public ROL getROL() { 
       ROL retVal = getTyped("ROL", ROL.class);
       return retVal;
    }


    /**
     * Returns a specific repetition of
     * ROL (Role) - creates it if necessary
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public ROL getROL(int rep) { 
       ROL retVal = getTyped("ROL", rep, ROL.class);
       return retVal;
    }

    /** 
     * Returns the number of existing repetitions of ROL 
     */ 
    public int getROLReps() {  
        return getReps("ROL");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of ROL.
     * <p>
     * <p>
     * Note that unlike {@link #getROL()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     */ 
    public java.util.List<ROL> getROLAll() throws HL7Exception {
    	return getAllAsList("ROL", ROL.class);
    } 

    /**
     * Inserts a specific repetition of ROL (Role)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertROL(ROL structure, int rep) throws HL7Exception { 
       super.insertRepetition("ROL", structure, rep);
    }


    /**
     * Inserts a specific repetition of ROL (Role)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public ROL insertROL(int rep) throws HL7Exception { 
       return (ROL)super.insertRepetition("ROL", rep);
    }


    /**
     * Removes a specific repetition of ROL (Role)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public ROL removeROL(int rep) throws HL7Exception { 
       return (ROL)super.removeRepetition("ROL", rep);
    }



    /**
     * Returns
     * the first repetition of 
     * PATIENT_INFO (a Group object) - creates it if necessary
     */
    public EHC_E01_PATIENT_INFO getPATIENT_INFO() { 
       EHC_E01_PATIENT_INFO retVal = getTyped("PATIENT_INFO", EHC_E01_PATIENT_INFO.class);
       return retVal;
    }


    /**
     * Returns a specific repetition of
     * PATIENT_INFO (a Group object) - creates it if necessary
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public EHC_E01_PATIENT_INFO getPATIENT_INFO(int rep) { 
       EHC_E01_PATIENT_INFO retVal = getTyped("PATIENT_INFO", rep, EHC_E01_PATIENT_INFO.class);
       return retVal;
    }

    /** 
     * Returns the number of existing repetitions of PATIENT_INFO 
     */ 
    public int getPATIENT_INFOReps() {  
        return getReps("PATIENT_INFO");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of PATIENT_INFO.
     * <p>
     * <p>
     * Note that unlike {@link #getPATIENT_INFO()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     */ 
    public java.util.List<EHC_E01_PATIENT_INFO> getPATIENT_INFOAll() throws HL7Exception {
    	return getAllAsList("PATIENT_INFO", EHC_E01_PATIENT_INFO.class);
    } 

    /**
     * Inserts a specific repetition of PATIENT_INFO (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertPATIENT_INFO(EHC_E01_PATIENT_INFO structure, int rep) throws HL7Exception { 
       super.insertRepetition("PATIENT_INFO", structure, rep);
    }


    /**
     * Inserts a specific repetition of PATIENT_INFO (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public EHC_E01_PATIENT_INFO insertPATIENT_INFO(int rep) throws HL7Exception { 
       return (EHC_E01_PATIENT_INFO)super.insertRepetition("PATIENT_INFO", rep);
    }


    /**
     * Removes a specific repetition of PATIENT_INFO (a Group object)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public EHC_E01_PATIENT_INFO removePATIENT_INFO(int rep) throws HL7Exception { 
       return (EHC_E01_PATIENT_INFO)super.removeRepetition("PATIENT_INFO", rep);
    }



    /**
     * Returns
     * the first repetition of 
     * PRODUCT_SERVICE_LINE_ITEM (a Group object) - creates it if necessary
     */
    public EHC_E01_PRODUCT_SERVICE_LINE_ITEM getPRODUCT_SERVICE_LINE_ITEM() { 
       EHC_E01_PRODUCT_SERVICE_LINE_ITEM retVal = getTyped("PRODUCT_SERVICE_LINE_ITEM", EHC_E01_PRODUCT_SERVICE_LINE_ITEM.class);
       return retVal;
    }


    /**
     * Returns a specific repetition of
     * PRODUCT_SERVICE_LINE_ITEM (a Group object) - creates it if necessary
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public EHC_E01_PRODUCT_SERVICE_LINE_ITEM getPRODUCT_SERVICE_LINE_ITEM(int rep) { 
       EHC_E01_PRODUCT_SERVICE_LINE_ITEM retVal = getTyped("PRODUCT_SERVICE_LINE_ITEM", rep, EHC_E01_PRODUCT_SERVICE_LINE_ITEM.class);
       return retVal;
    }

    /** 
     * Returns the number of existing repetitions of PRODUCT_SERVICE_LINE_ITEM 
     */ 
    public int getPRODUCT_SERVICE_LINE_ITEMReps() {  
        return getReps("PRODUCT_SERVICE_LINE_ITEM");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of PRODUCT_SERVICE_LINE_ITEM.
     * <p>
     * <p>
     * Note that unlike {@link #getPRODUCT_SERVICE_LINE_ITEM()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     */ 
    public java.util.List<EHC_E01_PRODUCT_SERVICE_LINE_ITEM> getPRODUCT_SERVICE_LINE_ITEMAll() throws HL7Exception {
    	return getAllAsList("PRODUCT_SERVICE_LINE_ITEM", EHC_E01_PRODUCT_SERVICE_LINE_ITEM.class);
    } 

    /**
     * Inserts a specific repetition of PRODUCT_SERVICE_LINE_ITEM (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertPRODUCT_SERVICE_LINE_ITEM(EHC_E01_PRODUCT_SERVICE_LINE_ITEM structure, int rep) throws HL7Exception { 
       super.insertRepetition("PRODUCT_SERVICE_LINE_ITEM", structure, rep);
    }


    /**
     * Inserts a specific repetition of PRODUCT_SERVICE_LINE_ITEM (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public EHC_E01_PRODUCT_SERVICE_LINE_ITEM insertPRODUCT_SERVICE_LINE_ITEM(int rep) throws HL7Exception { 
       return (EHC_E01_PRODUCT_SERVICE_LINE_ITEM)super.insertRepetition("PRODUCT_SERVICE_LINE_ITEM", rep);
    }


    /**
     * Removes a specific repetition of PRODUCT_SERVICE_LINE_ITEM (a Group object)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public EHC_E01_PRODUCT_SERVICE_LINE_ITEM removePRODUCT_SERVICE_LINE_ITEM(int rep) throws HL7Exception { 
       return (EHC_E01_PRODUCT_SERVICE_LINE_ITEM)super.removeRepetition("PRODUCT_SERVICE_LINE_ITEM", rep);
    }



    /**
     * Returns
     * the first repetition of 
     * PROCEDURE (a Group object) - creates it if necessary
     */
    public EHC_E01_PROCEDURE getPROCEDURE() { 
       EHC_E01_PROCEDURE retVal = getTyped("PROCEDURE", EHC_E01_PROCEDURE.class);
       return retVal;
    }


    /**
     * Returns a specific repetition of
     * PROCEDURE (a Group object) - creates it if necessary
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public EHC_E01_PROCEDURE getPROCEDURE(int rep) { 
       EHC_E01_PROCEDURE retVal = getTyped("PROCEDURE", rep, EHC_E01_PROCEDURE.class);
       return retVal;
    }

    /** 
     * Returns the number of existing repetitions of PROCEDURE 
     */ 
    public int getPROCEDUREReps() {  
        return getReps("PROCEDURE");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of PROCEDURE.
     * <p>
     * <p>
     * Note that unlike {@link #getPROCEDURE()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     */ 
    public java.util.List<EHC_E01_PROCEDURE> getPROCEDUREAll() throws HL7Exception {
    	return getAllAsList("PROCEDURE", EHC_E01_PROCEDURE.class);
    } 

    /**
     * Inserts a specific repetition of PROCEDURE (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertPROCEDURE(EHC_E01_PROCEDURE structure, int rep) throws HL7Exception { 
       super.insertRepetition("PROCEDURE", structure, rep);
    }


    /**
     * Inserts a specific repetition of PROCEDURE (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public EHC_E01_PROCEDURE insertPROCEDURE(int rep) throws HL7Exception { 
       return (EHC_E01_PROCEDURE)super.insertRepetition("PROCEDURE", rep);
    }


    /**
     * Removes a specific repetition of PROCEDURE (a Group object)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public EHC_E01_PROCEDURE removePROCEDURE(int rep) throws HL7Exception { 
       return (EHC_E01_PROCEDURE)super.removeRepetition("PROCEDURE", rep);
    }



    /**
     * Returns
     * the first repetition of 
     * IPR (Invoice Processing Results) - creates it if necessary
     */
    public IPR getIPR() { 
       IPR retVal = getTyped("IPR", IPR.class);
       return retVal;
    }


    /**
     * Returns a specific repetition of
     * IPR (Invoice Processing Results) - creates it if necessary
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public IPR getIPR(int rep) { 
       IPR retVal = getTyped("IPR", rep, IPR.class);
       return retVal;
    }

    /** 
     * Returns the number of existing repetitions of IPR 
     */ 
    public int getIPRReps() {  
        return getReps("IPR");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of IPR.
     * <p>
     * <p>
     * Note that unlike {@link #getIPR()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     */ 
    public java.util.List<IPR> getIPRAll() throws HL7Exception {
    	return getAllAsList("IPR", IPR.class);
    } 

    /**
     * Inserts a specific repetition of IPR (Invoice Processing Results)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertIPR(IPR structure, int rep) throws HL7Exception { 
       super.insertRepetition("IPR", structure, rep);
    }


    /**
     * Inserts a specific repetition of IPR (Invoice Processing Results)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public IPR insertIPR(int rep) throws HL7Exception { 
       return (IPR)super.insertRepetition("IPR", rep);
    }


    /**
     * Removes a specific repetition of IPR (Invoice Processing Results)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public IPR removeIPR(int rep) throws HL7Exception { 
       return (IPR)super.removeRepetition("IPR", rep);
    }



}

