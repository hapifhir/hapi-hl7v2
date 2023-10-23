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


package ca.uhn.hl7v2.model.v28.group;

import ca.uhn.hl7v2.model.v28.segment.*;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.model.*;

/**
 * <p>Represents a RDE_O11_ORDER group structure (a Group object).
 * A Group is an ordered collection of message segments that can repeat together or be optionally in/excluded together.
 * This Group contains the following elements:  
 * </p>
 * <ul>
                         * <li>1: ORC (Common Order) <b>  </b></li>
                         * <li>2: PRT (Participation Information) <b>optional repeating </b></li>
                         * <li>3: RDE_O11_TIMING (a Group object) <b>optional repeating </b></li>
                         * <li>4: RDE_O11_ORDER_DETAIL (a Group object) <b>optional  </b></li>
                         * <li>5: RXE (Pharmacy/Treatment Encoded Order) <b>  </b></li>
                         * <li>6: PRT (Participation Information) <b>optional repeating </b></li>
                         * <li>7: NTE (Notes and Comments) <b>optional repeating </b></li>
                         * <li>8: RDE_O11_TIMING_ENCODED (a Group object) <b> repeating </b></li>
                         * <li>9: RDE_O11_PHARMACY_TREATMENT_INFUSION_ORDER (a Group object) <b>optional repeating </b></li>
                         * <li>10: RXR (Pharmacy/Treatment Route) <b> repeating </b></li>
                         * <li>11: RXC (Pharmacy/Treatment Component Order) <b>optional repeating </b></li>
                         * <li>12: CDO (Cumulative Dosage) <b>optional repeating </b></li>
                         * <li>13: RDE_O11_OBSERVATION (a Group object) <b>optional repeating </b></li>
                         * <li>14: FT1 (Financial Transaction) <b>optional repeating </b></li>
                         * <li>15: BLG (Billing) <b>optional  </b></li>
                         * <li>16: CTI (Clinical Trial Identification) <b>optional repeating </b></li>
 * </ul>
 */
//@SuppressWarnings("unused")
public class RDE_O11_ORDER extends AbstractGroup {

    /** 
     * Creates a new RDE_O11_ORDER group
     */
    public RDE_O11_ORDER(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(ORC.class, true, false, false);
                                  this.add(PRT.class, false, true, false);
                                  this.add(RDE_O11_TIMING.class, false, true, false);
                                  this.add(RDE_O11_ORDER_DETAIL.class, false, false, false);
                                  this.add(RXE.class, true, false, false);
                                  this.add(PRT.class, false, true, false);
                                  this.add(NTE.class, false, true, false);
                                  this.add(RDE_O11_TIMING_ENCODED.class, true, true, false);
                                  this.add(RDE_O11_PHARMACY_TREATMENT_INFUSION_ORDER.class, false, true, false);
                                  this.add(RXR.class, true, true, false);
                                  this.add(RXC.class, false, true, false);
                                  this.add(CDO.class, false, true, false);
                                  this.add(RDE_O11_OBSERVATION.class, false, true, false);
                                  this.add(FT1.class, false, true, false);
                                  this.add(BLG.class, false, false, false);
                                  this.add(CTI.class, false, true, false);
       } catch(HL7Exception e) {
          log.error("Unexpected error creating RDE_O11_ORDER - this is probably a bug in the source code generator.", e);
       }
    }

    /** 
     * Returns "2.8"
     */
    public String getVersion() {
       return "2.8";
    }



    /**
     * Returns
     * ORC (Common Order) - creates it if necessary
     */
    public ORC getORC() { 
       ORC retVal = getTyped("ORC", ORC.class);
       return retVal;
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
     * TIMING (a Group object) - creates it if necessary
     */
    public RDE_O11_TIMING getTIMING() { 
       RDE_O11_TIMING retVal = getTyped("TIMING", RDE_O11_TIMING.class);
       return retVal;
    }


    /**
     * Returns a specific repetition of
     * TIMING (a Group object) - creates it if necessary
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public RDE_O11_TIMING getTIMING(int rep) { 
       RDE_O11_TIMING retVal = getTyped("TIMING", rep, RDE_O11_TIMING.class);
       return retVal;
    }

    /** 
     * Returns the number of existing repetitions of TIMING 
     */ 
    public int getTIMINGReps() {  
        return getReps("TIMING");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of TIMING.
     * <p>
     * <p>
     * Note that unlike {@link #getTIMING()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     */ 
    public java.util.List<RDE_O11_TIMING> getTIMINGAll() throws HL7Exception {
    	return getAllAsList("TIMING", RDE_O11_TIMING.class);
    } 

    /**
     * Inserts a specific repetition of TIMING (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertTIMING(RDE_O11_TIMING structure, int rep) throws HL7Exception { 
       super.insertRepetition("TIMING", structure, rep);
    }


    /**
     * Inserts a specific repetition of TIMING (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public RDE_O11_TIMING insertTIMING(int rep) throws HL7Exception { 
       return (RDE_O11_TIMING)super.insertRepetition("TIMING", rep);
    }


    /**
     * Removes a specific repetition of TIMING (a Group object)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public RDE_O11_TIMING removeTIMING(int rep) throws HL7Exception { 
       return (RDE_O11_TIMING)super.removeRepetition("TIMING", rep);
    }



    /**
     * Returns
     * ORDER_DETAIL (a Group object) - creates it if necessary
     */
    public RDE_O11_ORDER_DETAIL getORDER_DETAIL() { 
       RDE_O11_ORDER_DETAIL retVal = getTyped("ORDER_DETAIL", RDE_O11_ORDER_DETAIL.class);
       return retVal;
    }




    /**
     * Returns
     * RXE (Pharmacy/Treatment Encoded Order) - creates it if necessary
     */
    public RXE getRXE() { 
       RXE retVal = getTyped("RXE", RXE.class);
       return retVal;
    }




    /**
     * Returns
     * the first repetition of 
     * PRT2 (Participation Information) - creates it if necessary
     */
    public PRT getPRT2() { 
       PRT retVal = getTyped("PRT2", PRT.class);
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
    public PRT getPRT2(int rep) { 
       PRT retVal = getTyped("PRT2", rep, PRT.class);
       return retVal;
    }

    /** 
     * Returns the number of existing repetitions of PRT2 
     */ 
    public int getPRT2Reps() {  
        return getReps("PRT2");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of PRT2.
     * <p>
     * <p>
     * Note that unlike {@link #getPRT2()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     */ 
    public java.util.List<PRT> getPRT2All() throws HL7Exception {
    	return getAllAsList("PRT2", PRT.class);
    } 

    /**
     * Inserts a specific repetition of PRT2 (Participation Information)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertPRT2(PRT structure, int rep) throws HL7Exception { 
       super.insertRepetition("PRT2", structure, rep);
    }


    /**
     * Inserts a specific repetition of PRT2 (Participation Information)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public PRT insertPRT2(int rep) throws HL7Exception { 
       return (PRT)super.insertRepetition("PRT2", rep);
    }


    /**
     * Removes a specific repetition of PRT2 (Participation Information)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public PRT removePRT2(int rep) throws HL7Exception { 
       return (PRT)super.removeRepetition("PRT2", rep);
    }



    /**
     * Returns
     * the first repetition of 
     * NTE (Notes and Comments) - creates it if necessary
     */
    public NTE getNTE() { 
       NTE retVal = getTyped("NTE", NTE.class);
       return retVal;
    }


    /**
     * Returns a specific repetition of
     * NTE (Notes and Comments) - creates it if necessary
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
     * Inserts a specific repetition of NTE (Notes and Comments)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertNTE(NTE structure, int rep) throws HL7Exception { 
       super.insertRepetition("NTE", structure, rep);
    }


    /**
     * Inserts a specific repetition of NTE (Notes and Comments)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public NTE insertNTE(int rep) throws HL7Exception { 
       return (NTE)super.insertRepetition("NTE", rep);
    }


    /**
     * Removes a specific repetition of NTE (Notes and Comments)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public NTE removeNTE(int rep) throws HL7Exception { 
       return (NTE)super.removeRepetition("NTE", rep);
    }



    /**
     * Returns
     * the first repetition of 
     * TIMING_ENCODED (a Group object) - creates it if necessary
     */
    public RDE_O11_TIMING_ENCODED getTIMING_ENCODED() { 
       RDE_O11_TIMING_ENCODED retVal = getTyped("TIMING_ENCODED", RDE_O11_TIMING_ENCODED.class);
       return retVal;
    }


    /**
     * Returns a specific repetition of
     * TIMING_ENCODED (a Group object) - creates it if necessary
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public RDE_O11_TIMING_ENCODED getTIMING_ENCODED(int rep) { 
       RDE_O11_TIMING_ENCODED retVal = getTyped("TIMING_ENCODED", rep, RDE_O11_TIMING_ENCODED.class);
       return retVal;
    }

    /** 
     * Returns the number of existing repetitions of TIMING_ENCODED 
     */ 
    public int getTIMING_ENCODEDReps() {  
        return getReps("TIMING_ENCODED");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of TIMING_ENCODED.
     * <p>
     * <p>
     * Note that unlike {@link #getTIMING_ENCODED()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     */ 
    public java.util.List<RDE_O11_TIMING_ENCODED> getTIMING_ENCODEDAll() throws HL7Exception {
    	return getAllAsList("TIMING_ENCODED", RDE_O11_TIMING_ENCODED.class);
    } 

    /**
     * Inserts a specific repetition of TIMING_ENCODED (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertTIMING_ENCODED(RDE_O11_TIMING_ENCODED structure, int rep) throws HL7Exception { 
       super.insertRepetition("TIMING_ENCODED", structure, rep);
    }


    /**
     * Inserts a specific repetition of TIMING_ENCODED (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public RDE_O11_TIMING_ENCODED insertTIMING_ENCODED(int rep) throws HL7Exception { 
       return (RDE_O11_TIMING_ENCODED)super.insertRepetition("TIMING_ENCODED", rep);
    }


    /**
     * Removes a specific repetition of TIMING_ENCODED (a Group object)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public RDE_O11_TIMING_ENCODED removeTIMING_ENCODED(int rep) throws HL7Exception { 
       return (RDE_O11_TIMING_ENCODED)super.removeRepetition("TIMING_ENCODED", rep);
    }



    /**
     * Returns
     * the first repetition of 
     * PHARMACY_TREATMENT_INFUSION_ORDER (a Group object) - creates it if necessary
     */
    public RDE_O11_PHARMACY_TREATMENT_INFUSION_ORDER getPHARMACY_TREATMENT_INFUSION_ORDER() { 
       RDE_O11_PHARMACY_TREATMENT_INFUSION_ORDER retVal = getTyped("PHARMACY_TREATMENT_INFUSION_ORDER", RDE_O11_PHARMACY_TREATMENT_INFUSION_ORDER.class);
       return retVal;
    }


    /**
     * Returns a specific repetition of
     * PHARMACY_TREATMENT_INFUSION_ORDER (a Group object) - creates it if necessary
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public RDE_O11_PHARMACY_TREATMENT_INFUSION_ORDER getPHARMACY_TREATMENT_INFUSION_ORDER(int rep) { 
       RDE_O11_PHARMACY_TREATMENT_INFUSION_ORDER retVal = getTyped("PHARMACY_TREATMENT_INFUSION_ORDER", rep, RDE_O11_PHARMACY_TREATMENT_INFUSION_ORDER.class);
       return retVal;
    }

    /** 
     * Returns the number of existing repetitions of PHARMACY_TREATMENT_INFUSION_ORDER 
     */ 
    public int getPHARMACY_TREATMENT_INFUSION_ORDERReps() {  
        return getReps("PHARMACY_TREATMENT_INFUSION_ORDER");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of PHARMACY_TREATMENT_INFUSION_ORDER.
     * <p>
     * <p>
     * Note that unlike {@link #getPHARMACY_TREATMENT_INFUSION_ORDER()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     */ 
    public java.util.List<RDE_O11_PHARMACY_TREATMENT_INFUSION_ORDER> getPHARMACY_TREATMENT_INFUSION_ORDERAll() throws HL7Exception {
    	return getAllAsList("PHARMACY_TREATMENT_INFUSION_ORDER", RDE_O11_PHARMACY_TREATMENT_INFUSION_ORDER.class);
    } 

    /**
     * Inserts a specific repetition of PHARMACY_TREATMENT_INFUSION_ORDER (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertPHARMACY_TREATMENT_INFUSION_ORDER(RDE_O11_PHARMACY_TREATMENT_INFUSION_ORDER structure, int rep) throws HL7Exception { 
       super.insertRepetition("PHARMACY_TREATMENT_INFUSION_ORDER", structure, rep);
    }


    /**
     * Inserts a specific repetition of PHARMACY_TREATMENT_INFUSION_ORDER (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public RDE_O11_PHARMACY_TREATMENT_INFUSION_ORDER insertPHARMACY_TREATMENT_INFUSION_ORDER(int rep) throws HL7Exception { 
       return (RDE_O11_PHARMACY_TREATMENT_INFUSION_ORDER)super.insertRepetition("PHARMACY_TREATMENT_INFUSION_ORDER", rep);
    }


    /**
     * Removes a specific repetition of PHARMACY_TREATMENT_INFUSION_ORDER (a Group object)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public RDE_O11_PHARMACY_TREATMENT_INFUSION_ORDER removePHARMACY_TREATMENT_INFUSION_ORDER(int rep) throws HL7Exception { 
       return (RDE_O11_PHARMACY_TREATMENT_INFUSION_ORDER)super.removeRepetition("PHARMACY_TREATMENT_INFUSION_ORDER", rep);
    }



    /**
     * Returns
     * the first repetition of 
     * RXR (Pharmacy/Treatment Route) - creates it if necessary
     */
    public RXR getRXR() { 
       RXR retVal = getTyped("RXR", RXR.class);
       return retVal;
    }


    /**
     * Returns a specific repetition of
     * RXR (Pharmacy/Treatment Route) - creates it if necessary
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
     * Inserts a specific repetition of RXR (Pharmacy/Treatment Route)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertRXR(RXR structure, int rep) throws HL7Exception { 
       super.insertRepetition("RXR", structure, rep);
    }


    /**
     * Inserts a specific repetition of RXR (Pharmacy/Treatment Route)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public RXR insertRXR(int rep) throws HL7Exception { 
       return (RXR)super.insertRepetition("RXR", rep);
    }


    /**
     * Removes a specific repetition of RXR (Pharmacy/Treatment Route)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public RXR removeRXR(int rep) throws HL7Exception { 
       return (RXR)super.removeRepetition("RXR", rep);
    }



    /**
     * Returns
     * the first repetition of 
     * RXC (Pharmacy/Treatment Component Order) - creates it if necessary
     */
    public RXC getRXC() { 
       RXC retVal = getTyped("RXC", RXC.class);
       return retVal;
    }


    /**
     * Returns a specific repetition of
     * RXC (Pharmacy/Treatment Component Order) - creates it if necessary
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public RXC getRXC(int rep) { 
       RXC retVal = getTyped("RXC", rep, RXC.class);
       return retVal;
    }

    /** 
     * Returns the number of existing repetitions of RXC 
     */ 
    public int getRXCReps() {  
        return getReps("RXC");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of RXC.
     * <p>
     * <p>
     * Note that unlike {@link #getRXC()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     */ 
    public java.util.List<RXC> getRXCAll() throws HL7Exception {
    	return getAllAsList("RXC", RXC.class);
    } 

    /**
     * Inserts a specific repetition of RXC (Pharmacy/Treatment Component Order)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertRXC(RXC structure, int rep) throws HL7Exception { 
       super.insertRepetition("RXC", structure, rep);
    }


    /**
     * Inserts a specific repetition of RXC (Pharmacy/Treatment Component Order)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public RXC insertRXC(int rep) throws HL7Exception { 
       return (RXC)super.insertRepetition("RXC", rep);
    }


    /**
     * Removes a specific repetition of RXC (Pharmacy/Treatment Component Order)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public RXC removeRXC(int rep) throws HL7Exception { 
       return (RXC)super.removeRepetition("RXC", rep);
    }



    /**
     * Returns
     * the first repetition of 
     * CDO (Cumulative Dosage) - creates it if necessary
     */
    public CDO getCDO() { 
       CDO retVal = getTyped("CDO", CDO.class);
       return retVal;
    }


    /**
     * Returns a specific repetition of
     * CDO (Cumulative Dosage) - creates it if necessary
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public CDO getCDO(int rep) { 
       CDO retVal = getTyped("CDO", rep, CDO.class);
       return retVal;
    }

    /** 
     * Returns the number of existing repetitions of CDO 
     */ 
    public int getCDOReps() {  
        return getReps("CDO");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of CDO.
     * <p>
     * <p>
     * Note that unlike {@link #getCDO()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     */ 
    public java.util.List<CDO> getCDOAll() throws HL7Exception {
    	return getAllAsList("CDO", CDO.class);
    } 

    /**
     * Inserts a specific repetition of CDO (Cumulative Dosage)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertCDO(CDO structure, int rep) throws HL7Exception { 
       super.insertRepetition("CDO", structure, rep);
    }


    /**
     * Inserts a specific repetition of CDO (Cumulative Dosage)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public CDO insertCDO(int rep) throws HL7Exception { 
       return (CDO)super.insertRepetition("CDO", rep);
    }


    /**
     * Removes a specific repetition of CDO (Cumulative Dosage)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public CDO removeCDO(int rep) throws HL7Exception { 
       return (CDO)super.removeRepetition("CDO", rep);
    }



    /**
     * Returns
     * the first repetition of 
     * OBSERVATION (a Group object) - creates it if necessary
     */
    public RDE_O11_OBSERVATION getOBSERVATION() { 
       RDE_O11_OBSERVATION retVal = getTyped("OBSERVATION", RDE_O11_OBSERVATION.class);
       return retVal;
    }


    /**
     * Returns a specific repetition of
     * OBSERVATION (a Group object) - creates it if necessary
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public RDE_O11_OBSERVATION getOBSERVATION(int rep) { 
       RDE_O11_OBSERVATION retVal = getTyped("OBSERVATION", rep, RDE_O11_OBSERVATION.class);
       return retVal;
    }

    /** 
     * Returns the number of existing repetitions of OBSERVATION 
     */ 
    public int getOBSERVATIONReps() {  
        return getReps("OBSERVATION");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of OBSERVATION.
     * <p>
     * <p>
     * Note that unlike {@link #getOBSERVATION()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     */ 
    public java.util.List<RDE_O11_OBSERVATION> getOBSERVATIONAll() throws HL7Exception {
    	return getAllAsList("OBSERVATION", RDE_O11_OBSERVATION.class);
    } 

    /**
     * Inserts a specific repetition of OBSERVATION (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertOBSERVATION(RDE_O11_OBSERVATION structure, int rep) throws HL7Exception { 
       super.insertRepetition("OBSERVATION", structure, rep);
    }


    /**
     * Inserts a specific repetition of OBSERVATION (a Group object)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public RDE_O11_OBSERVATION insertOBSERVATION(int rep) throws HL7Exception { 
       return (RDE_O11_OBSERVATION)super.insertRepetition("OBSERVATION", rep);
    }


    /**
     * Removes a specific repetition of OBSERVATION (a Group object)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public RDE_O11_OBSERVATION removeOBSERVATION(int rep) throws HL7Exception { 
       return (RDE_O11_OBSERVATION)super.removeRepetition("OBSERVATION", rep);
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
     * BLG (Billing) - creates it if necessary
     */
    public BLG getBLG() { 
       BLG retVal = getTyped("BLG", BLG.class);
       return retVal;
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



}

