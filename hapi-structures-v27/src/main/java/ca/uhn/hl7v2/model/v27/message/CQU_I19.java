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


package ca.uhn.hl7v2.model.v27.message;

import ca.uhn.hl7v2.model.v27.group.*;
import ca.uhn.hl7v2.model.v27.segment.*;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.parser.DefaultModelClassFactory;
import ca.uhn.hl7v2.model.*;


/**
 * <p>Represents a CQU_I19 message structure (see chapter 11.7.1). This structure contains the 
 * following elements: </p>
 * <ul>
		                 * <li>1: MSH (Message Header) <b> </b> </li>
		                 * <li>2: SFT (Software Segment) <b>optional repeating</b> </li>
		                 * <li>3: UAC (User Authentication Credential Segment) <b>optional </b> </li>
		                 * <li>4: MSA (Message Acknowledgment) <b> </b> </li>
		                 * <li>5: ERR (Error) <b>optional repeating</b> </li>
		                 * <li>6: RF1 (Referral Information) <b> </b> </li>
		                 * <li>7: CQU_I19_PROVIDER_CONTACT (a Group object) <b>optional repeating</b> </li>
		                 * <li>8: CQU_I19_PATIENT (a Group object) <b>optional repeating</b> </li>
		                 * <li>9: NK1 (Next of Kin / Associated Parties) <b>optional repeating</b> </li>
		                 * <li>10: CQU_I19_INSURANCE (a Group object) <b>optional repeating</b> </li>
		                 * <li>11: CQU_I19_APPOINTMENT_HISTORY (a Group object) <b>optional repeating</b> </li>
		                 * <li>12: CQU_I19_CLINICAL_HISTORY (a Group object) <b>optional repeating</b> </li>
		                 * <li>13: CQU_I19_PATIENT_VISITS (a Group object) <b> repeating</b> </li>
		                 * <li>14: CQU_I19_MEDICATION_HISTORY (a Group object) <b>optional repeating</b> </li>
		                 * <li>15: CQU_I19_PROBLEM (a Group object) <b>optional repeating</b> </li>
		                 * <li>16: CQU_I19_GOAL (a Group object) <b>optional repeating</b> </li>
		                 * <li>17: CQU_I19_PATHWAY (a Group object) <b>optional repeating</b> </li>
		                 * <li>18: REL (Clinical Relationship Segment) <b>optional repeating</b> </li>
 * </ul>
 */
//@SuppressWarnings("unused")
public class CQU_I19 extends AbstractMessage  {

    /**
     * Creates a new CQU_I19 message with DefaultModelClassFactory. 
     */ 
    public CQU_I19() { 
       this(new DefaultModelClassFactory());
    }

    /** 
     * Creates a new CQU_I19 message with custom ModelClassFactory.
     */
    public CQU_I19(ModelClassFactory factory) {
       super(factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                          this.add(MSH.class, true, false);
	                          this.add(SFT.class, false, true);
	                          this.add(UAC.class, false, false);
	                          this.add(MSA.class, true, false);
	                          this.add(ERR.class, false, true);
	                          this.add(RF1.class, true, false);
	                          this.add(CQU_I19_PROVIDER_CONTACT.class, false, true);
	                          this.add(CQU_I19_PATIENT.class, false, true);
	                          this.add(NK1.class, false, true);
	                          this.add(CQU_I19_INSURANCE.class, false, true);
	                          this.add(CQU_I19_APPOINTMENT_HISTORY.class, false, true);
	                          this.add(CQU_I19_CLINICAL_HISTORY.class, false, true);
	                          this.add(CQU_I19_PATIENT_VISITS.class, true, true);
	                          this.add(CQU_I19_MEDICATION_HISTORY.class, false, true);
	                          this.add(CQU_I19_PROBLEM.class, false, true);
	                          this.add(CQU_I19_GOAL.class, false, true);
	                          this.add(CQU_I19_PATHWAY.class, false, true);
	                          this.add(REL.class, false, true);
	       } catch(HL7Exception e) {
          log.error("Unexpected error creating CQU_I19 - this is probably a bug in the source code generator.", e);
       }
    }


    /** 
     * Returns "2.7"
     */
    public String getVersion() {
       return "2.7";
    }




    /**
     * <p>
     * Returns
     * MSH (Message Header) - creates it if necessary
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
     * SFT (Software Segment) - creates it if necessary
     * </p>
     * 
     *
     */
    public SFT getSFT() { 
       return getTyped("SFT", SFT.class);
    }


    /**
     * <p>
     * Returns a specific repetition of
     * SFT (Software Segment) - creates it if necessary
     * </p>
     * 
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public SFT getSFT(int rep) { 
       return getTyped("SFT", rep, SFT.class);
    }

    /** 
     * <p>
     * Returns the number of existing repetitions of SFT 
     * </p>
     * 
     */ 
    public int getSFTReps() { 
    	return getReps("SFT");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of SFT.
     * <p>
     * <p>
     * Note that unlike {@link #getSFT()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     * 
     */ 
    public java.util.List<SFT> getSFTAll() throws HL7Exception {
    	return getAllAsList("SFT", SFT.class);
    } 

    /**
     * <p>
     * Inserts a specific repetition of SFT (Software Segment)
     * </p>
     * 
     *
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertSFT(SFT structure, int rep) throws HL7Exception { 
       super.insertRepetition( "SFT", structure, rep);
    }


    /**
     * <p>
     * Inserts a specific repetition of SFT (Software Segment)
     * </p>
     * 
     *
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public SFT insertSFT(int rep) throws HL7Exception { 
       return (SFT)super.insertRepetition("SFT", rep);
    }


    /**
     * <p>
     * Removes a specific repetition of SFT (Software Segment)
     * </p>
     * 
     *
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public SFT removeSFT(int rep) throws HL7Exception { 
       return (SFT)super.removeRepetition("SFT", rep);
    }




    /**
     * <p>
     * Returns
     * UAC (User Authentication Credential Segment) - creates it if necessary
     * </p>
     * 
     *
     */
    public UAC getUAC() { 
       return getTyped("UAC", UAC.class);
    }





    /**
     * <p>
     * Returns
     * MSA (Message Acknowledgment) - creates it if necessary
     * </p>
     * 
     *
     */
    public MSA getMSA() { 
       return getTyped("MSA", MSA.class);
    }





    /**
     * <p>
     * Returns
     * the first repetition of 
     * ERR (Error) - creates it if necessary
     * </p>
     * 
     *
     */
    public ERR getERR() { 
       return getTyped("ERR", ERR.class);
    }


    /**
     * <p>
     * Returns a specific repetition of
     * ERR (Error) - creates it if necessary
     * </p>
     * 
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public ERR getERR(int rep) { 
       return getTyped("ERR", rep, ERR.class);
    }

    /** 
     * <p>
     * Returns the number of existing repetitions of ERR 
     * </p>
     * 
     */ 
    public int getERRReps() { 
    	return getReps("ERR");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of ERR.
     * <p>
     * <p>
     * Note that unlike {@link #getERR()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     * 
     */ 
    public java.util.List<ERR> getERRAll() throws HL7Exception {
    	return getAllAsList("ERR", ERR.class);
    } 

    /**
     * <p>
     * Inserts a specific repetition of ERR (Error)
     * </p>
     * 
     *
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertERR(ERR structure, int rep) throws HL7Exception { 
       super.insertRepetition( "ERR", structure, rep);
    }


    /**
     * <p>
     * Inserts a specific repetition of ERR (Error)
     * </p>
     * 
     *
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public ERR insertERR(int rep) throws HL7Exception { 
       return (ERR)super.insertRepetition("ERR", rep);
    }


    /**
     * <p>
     * Removes a specific repetition of ERR (Error)
     * </p>
     * 
     *
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public ERR removeERR(int rep) throws HL7Exception { 
       return (ERR)super.removeRepetition("ERR", rep);
    }




    /**
     * <p>
     * Returns
     * RF1 (Referral Information) - creates it if necessary
     * </p>
     * 
     *
     */
    public RF1 getRF1() { 
       return getTyped("RF1", RF1.class);
    }





    /**
     * <p>
     * Returns
     * the first repetition of 
     * PROVIDER_CONTACT (a Group object) - creates it if necessary
     * </p>
     * 
     *
     */
    public CQU_I19_PROVIDER_CONTACT getPROVIDER_CONTACT() { 
       return getTyped("PROVIDER_CONTACT", CQU_I19_PROVIDER_CONTACT.class);
    }


    /**
     * <p>
     * Returns a specific repetition of
     * PROVIDER_CONTACT (a Group object) - creates it if necessary
     * </p>
     * 
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public CQU_I19_PROVIDER_CONTACT getPROVIDER_CONTACT(int rep) { 
       return getTyped("PROVIDER_CONTACT", rep, CQU_I19_PROVIDER_CONTACT.class);
    }

    /** 
     * <p>
     * Returns the number of existing repetitions of PROVIDER_CONTACT 
     * </p>
     * 
     */ 
    public int getPROVIDER_CONTACTReps() { 
    	return getReps("PROVIDER_CONTACT");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of PROVIDER_CONTACT.
     * <p>
     * <p>
     * Note that unlike {@link #getPROVIDER_CONTACT()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     * 
     */ 
    public java.util.List<CQU_I19_PROVIDER_CONTACT> getPROVIDER_CONTACTAll() throws HL7Exception {
    	return getAllAsList("PROVIDER_CONTACT", CQU_I19_PROVIDER_CONTACT.class);
    } 

    /**
     * <p>
     * Inserts a specific repetition of PROVIDER_CONTACT (a Group object)
     * </p>
     * 
     *
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertPROVIDER_CONTACT(CQU_I19_PROVIDER_CONTACT structure, int rep) throws HL7Exception { 
       super.insertRepetition( "PROVIDER_CONTACT", structure, rep);
    }


    /**
     * <p>
     * Inserts a specific repetition of PROVIDER_CONTACT (a Group object)
     * </p>
     * 
     *
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public CQU_I19_PROVIDER_CONTACT insertPROVIDER_CONTACT(int rep) throws HL7Exception { 
       return (CQU_I19_PROVIDER_CONTACT)super.insertRepetition("PROVIDER_CONTACT", rep);
    }


    /**
     * <p>
     * Removes a specific repetition of PROVIDER_CONTACT (a Group object)
     * </p>
     * 
     *
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public CQU_I19_PROVIDER_CONTACT removePROVIDER_CONTACT(int rep) throws HL7Exception { 
       return (CQU_I19_PROVIDER_CONTACT)super.removeRepetition("PROVIDER_CONTACT", rep);
    }




    /**
     * <p>
     * Returns
     * the first repetition of 
     * PATIENT (a Group object) - creates it if necessary
     * </p>
     * 
     *
     */
    public CQU_I19_PATIENT getPATIENT() { 
       return getTyped("PATIENT", CQU_I19_PATIENT.class);
    }


    /**
     * <p>
     * Returns a specific repetition of
     * PATIENT (a Group object) - creates it if necessary
     * </p>
     * 
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public CQU_I19_PATIENT getPATIENT(int rep) { 
       return getTyped("PATIENT", rep, CQU_I19_PATIENT.class);
    }

    /** 
     * <p>
     * Returns the number of existing repetitions of PATIENT 
     * </p>
     * 
     */ 
    public int getPATIENTReps() { 
    	return getReps("PATIENT");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of PATIENT.
     * <p>
     * <p>
     * Note that unlike {@link #getPATIENT()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     * 
     */ 
    public java.util.List<CQU_I19_PATIENT> getPATIENTAll() throws HL7Exception {
    	return getAllAsList("PATIENT", CQU_I19_PATIENT.class);
    } 

    /**
     * <p>
     * Inserts a specific repetition of PATIENT (a Group object)
     * </p>
     * 
     *
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertPATIENT(CQU_I19_PATIENT structure, int rep) throws HL7Exception { 
       super.insertRepetition( "PATIENT", structure, rep);
    }


    /**
     * <p>
     * Inserts a specific repetition of PATIENT (a Group object)
     * </p>
     * 
     *
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public CQU_I19_PATIENT insertPATIENT(int rep) throws HL7Exception { 
       return (CQU_I19_PATIENT)super.insertRepetition("PATIENT", rep);
    }


    /**
     * <p>
     * Removes a specific repetition of PATIENT (a Group object)
     * </p>
     * 
     *
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public CQU_I19_PATIENT removePATIENT(int rep) throws HL7Exception { 
       return (CQU_I19_PATIENT)super.removeRepetition("PATIENT", rep);
    }




    /**
     * <p>
     * Returns
     * the first repetition of 
     * NK1 (Next of Kin / Associated Parties) - creates it if necessary
     * </p>
     * 
     *
     */
    public NK1 getNK1() { 
       return getTyped("NK1", NK1.class);
    }


    /**
     * <p>
     * Returns a specific repetition of
     * NK1 (Next of Kin / Associated Parties) - creates it if necessary
     * </p>
     * 
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public NK1 getNK1(int rep) { 
       return getTyped("NK1", rep, NK1.class);
    }

    /** 
     * <p>
     * Returns the number of existing repetitions of NK1 
     * </p>
     * 
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
     * 
     */ 
    public java.util.List<NK1> getNK1All() throws HL7Exception {
    	return getAllAsList("NK1", NK1.class);
    } 

    /**
     * <p>
     * Inserts a specific repetition of NK1 (Next of Kin / Associated Parties)
     * </p>
     * 
     *
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertNK1(NK1 structure, int rep) throws HL7Exception { 
       super.insertRepetition( "NK1", structure, rep);
    }


    /**
     * <p>
     * Inserts a specific repetition of NK1 (Next of Kin / Associated Parties)
     * </p>
     * 
     *
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public NK1 insertNK1(int rep) throws HL7Exception { 
       return (NK1)super.insertRepetition("NK1", rep);
    }


    /**
     * <p>
     * Removes a specific repetition of NK1 (Next of Kin / Associated Parties)
     * </p>
     * 
     *
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public NK1 removeNK1(int rep) throws HL7Exception { 
       return (NK1)super.removeRepetition("NK1", rep);
    }




    /**
     * <p>
     * Returns
     * the first repetition of 
     * INSURANCE (a Group object) - creates it if necessary
     * </p>
     * 
     *
     */
    public CQU_I19_INSURANCE getINSURANCE() { 
       return getTyped("INSURANCE", CQU_I19_INSURANCE.class);
    }


    /**
     * <p>
     * Returns a specific repetition of
     * INSURANCE (a Group object) - creates it if necessary
     * </p>
     * 
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public CQU_I19_INSURANCE getINSURANCE(int rep) { 
       return getTyped("INSURANCE", rep, CQU_I19_INSURANCE.class);
    }

    /** 
     * <p>
     * Returns the number of existing repetitions of INSURANCE 
     * </p>
     * 
     */ 
    public int getINSURANCEReps() { 
    	return getReps("INSURANCE");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of INSURANCE.
     * <p>
     * <p>
     * Note that unlike {@link #getINSURANCE()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     * 
     */ 
    public java.util.List<CQU_I19_INSURANCE> getINSURANCEAll() throws HL7Exception {
    	return getAllAsList("INSURANCE", CQU_I19_INSURANCE.class);
    } 

    /**
     * <p>
     * Inserts a specific repetition of INSURANCE (a Group object)
     * </p>
     * 
     *
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertINSURANCE(CQU_I19_INSURANCE structure, int rep) throws HL7Exception { 
       super.insertRepetition( "INSURANCE", structure, rep);
    }


    /**
     * <p>
     * Inserts a specific repetition of INSURANCE (a Group object)
     * </p>
     * 
     *
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public CQU_I19_INSURANCE insertINSURANCE(int rep) throws HL7Exception { 
       return (CQU_I19_INSURANCE)super.insertRepetition("INSURANCE", rep);
    }


    /**
     * <p>
     * Removes a specific repetition of INSURANCE (a Group object)
     * </p>
     * 
     *
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public CQU_I19_INSURANCE removeINSURANCE(int rep) throws HL7Exception { 
       return (CQU_I19_INSURANCE)super.removeRepetition("INSURANCE", rep);
    }




    /**
     * <p>
     * Returns
     * the first repetition of 
     * APPOINTMENT_HISTORY (a Group object) - creates it if necessary
     * </p>
     * 
     *
     */
    public CQU_I19_APPOINTMENT_HISTORY getAPPOINTMENT_HISTORY() { 
       return getTyped("APPOINTMENT_HISTORY", CQU_I19_APPOINTMENT_HISTORY.class);
    }


    /**
     * <p>
     * Returns a specific repetition of
     * APPOINTMENT_HISTORY (a Group object) - creates it if necessary
     * </p>
     * 
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public CQU_I19_APPOINTMENT_HISTORY getAPPOINTMENT_HISTORY(int rep) { 
       return getTyped("APPOINTMENT_HISTORY", rep, CQU_I19_APPOINTMENT_HISTORY.class);
    }

    /** 
     * <p>
     * Returns the number of existing repetitions of APPOINTMENT_HISTORY 
     * </p>
     * 
     */ 
    public int getAPPOINTMENT_HISTORYReps() { 
    	return getReps("APPOINTMENT_HISTORY");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of APPOINTMENT_HISTORY.
     * <p>
     * <p>
     * Note that unlike {@link #getAPPOINTMENT_HISTORY()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     * 
     */ 
    public java.util.List<CQU_I19_APPOINTMENT_HISTORY> getAPPOINTMENT_HISTORYAll() throws HL7Exception {
    	return getAllAsList("APPOINTMENT_HISTORY", CQU_I19_APPOINTMENT_HISTORY.class);
    } 

    /**
     * <p>
     * Inserts a specific repetition of APPOINTMENT_HISTORY (a Group object)
     * </p>
     * 
     *
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertAPPOINTMENT_HISTORY(CQU_I19_APPOINTMENT_HISTORY structure, int rep) throws HL7Exception { 
       super.insertRepetition( "APPOINTMENT_HISTORY", structure, rep);
    }


    /**
     * <p>
     * Inserts a specific repetition of APPOINTMENT_HISTORY (a Group object)
     * </p>
     * 
     *
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public CQU_I19_APPOINTMENT_HISTORY insertAPPOINTMENT_HISTORY(int rep) throws HL7Exception { 
       return (CQU_I19_APPOINTMENT_HISTORY)super.insertRepetition("APPOINTMENT_HISTORY", rep);
    }


    /**
     * <p>
     * Removes a specific repetition of APPOINTMENT_HISTORY (a Group object)
     * </p>
     * 
     *
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public CQU_I19_APPOINTMENT_HISTORY removeAPPOINTMENT_HISTORY(int rep) throws HL7Exception { 
       return (CQU_I19_APPOINTMENT_HISTORY)super.removeRepetition("APPOINTMENT_HISTORY", rep);
    }




    /**
     * <p>
     * Returns
     * the first repetition of 
     * CLINICAL_HISTORY (a Group object) - creates it if necessary
     * </p>
     * 
     *
     */
    public CQU_I19_CLINICAL_HISTORY getCLINICAL_HISTORY() { 
       return getTyped("CLINICAL_HISTORY", CQU_I19_CLINICAL_HISTORY.class);
    }


    /**
     * <p>
     * Returns a specific repetition of
     * CLINICAL_HISTORY (a Group object) - creates it if necessary
     * </p>
     * 
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public CQU_I19_CLINICAL_HISTORY getCLINICAL_HISTORY(int rep) { 
       return getTyped("CLINICAL_HISTORY", rep, CQU_I19_CLINICAL_HISTORY.class);
    }

    /** 
     * <p>
     * Returns the number of existing repetitions of CLINICAL_HISTORY 
     * </p>
     * 
     */ 
    public int getCLINICAL_HISTORYReps() { 
    	return getReps("CLINICAL_HISTORY");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of CLINICAL_HISTORY.
     * <p>
     * <p>
     * Note that unlike {@link #getCLINICAL_HISTORY()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     * 
     */ 
    public java.util.List<CQU_I19_CLINICAL_HISTORY> getCLINICAL_HISTORYAll() throws HL7Exception {
    	return getAllAsList("CLINICAL_HISTORY", CQU_I19_CLINICAL_HISTORY.class);
    } 

    /**
     * <p>
     * Inserts a specific repetition of CLINICAL_HISTORY (a Group object)
     * </p>
     * 
     *
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertCLINICAL_HISTORY(CQU_I19_CLINICAL_HISTORY structure, int rep) throws HL7Exception { 
       super.insertRepetition( "CLINICAL_HISTORY", structure, rep);
    }


    /**
     * <p>
     * Inserts a specific repetition of CLINICAL_HISTORY (a Group object)
     * </p>
     * 
     *
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public CQU_I19_CLINICAL_HISTORY insertCLINICAL_HISTORY(int rep) throws HL7Exception { 
       return (CQU_I19_CLINICAL_HISTORY)super.insertRepetition("CLINICAL_HISTORY", rep);
    }


    /**
     * <p>
     * Removes a specific repetition of CLINICAL_HISTORY (a Group object)
     * </p>
     * 
     *
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public CQU_I19_CLINICAL_HISTORY removeCLINICAL_HISTORY(int rep) throws HL7Exception { 
       return (CQU_I19_CLINICAL_HISTORY)super.removeRepetition("CLINICAL_HISTORY", rep);
    }




    /**
     * <p>
     * Returns
     * the first repetition of 
     * PATIENT_VISITS (a Group object) - creates it if necessary
     * </p>
     * 
     *
     */
    public CQU_I19_PATIENT_VISITS getPATIENT_VISITS() { 
       return getTyped("PATIENT_VISITS", CQU_I19_PATIENT_VISITS.class);
    }


    /**
     * <p>
     * Returns a specific repetition of
     * PATIENT_VISITS (a Group object) - creates it if necessary
     * </p>
     * 
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public CQU_I19_PATIENT_VISITS getPATIENT_VISITS(int rep) { 
       return getTyped("PATIENT_VISITS", rep, CQU_I19_PATIENT_VISITS.class);
    }

    /** 
     * <p>
     * Returns the number of existing repetitions of PATIENT_VISITS 
     * </p>
     * 
     */ 
    public int getPATIENT_VISITSReps() { 
    	return getReps("PATIENT_VISITS");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of PATIENT_VISITS.
     * <p>
     * <p>
     * Note that unlike {@link #getPATIENT_VISITS()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     * 
     */ 
    public java.util.List<CQU_I19_PATIENT_VISITS> getPATIENT_VISITSAll() throws HL7Exception {
    	return getAllAsList("PATIENT_VISITS", CQU_I19_PATIENT_VISITS.class);
    } 

    /**
     * <p>
     * Inserts a specific repetition of PATIENT_VISITS (a Group object)
     * </p>
     * 
     *
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertPATIENT_VISITS(CQU_I19_PATIENT_VISITS structure, int rep) throws HL7Exception { 
       super.insertRepetition( "PATIENT_VISITS", structure, rep);
    }


    /**
     * <p>
     * Inserts a specific repetition of PATIENT_VISITS (a Group object)
     * </p>
     * 
     *
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public CQU_I19_PATIENT_VISITS insertPATIENT_VISITS(int rep) throws HL7Exception { 
       return (CQU_I19_PATIENT_VISITS)super.insertRepetition("PATIENT_VISITS", rep);
    }


    /**
     * <p>
     * Removes a specific repetition of PATIENT_VISITS (a Group object)
     * </p>
     * 
     *
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public CQU_I19_PATIENT_VISITS removePATIENT_VISITS(int rep) throws HL7Exception { 
       return (CQU_I19_PATIENT_VISITS)super.removeRepetition("PATIENT_VISITS", rep);
    }




    /**
     * <p>
     * Returns
     * the first repetition of 
     * MEDICATION_HISTORY (a Group object) - creates it if necessary
     * </p>
     * 
     *
     */
    public CQU_I19_MEDICATION_HISTORY getMEDICATION_HISTORY() { 
       return getTyped("MEDICATION_HISTORY", CQU_I19_MEDICATION_HISTORY.class);
    }


    /**
     * <p>
     * Returns a specific repetition of
     * MEDICATION_HISTORY (a Group object) - creates it if necessary
     * </p>
     * 
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public CQU_I19_MEDICATION_HISTORY getMEDICATION_HISTORY(int rep) { 
       return getTyped("MEDICATION_HISTORY", rep, CQU_I19_MEDICATION_HISTORY.class);
    }

    /** 
     * <p>
     * Returns the number of existing repetitions of MEDICATION_HISTORY 
     * </p>
     * 
     */ 
    public int getMEDICATION_HISTORYReps() { 
    	return getReps("MEDICATION_HISTORY");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of MEDICATION_HISTORY.
     * <p>
     * <p>
     * Note that unlike {@link #getMEDICATION_HISTORY()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     * 
     */ 
    public java.util.List<CQU_I19_MEDICATION_HISTORY> getMEDICATION_HISTORYAll() throws HL7Exception {
    	return getAllAsList("MEDICATION_HISTORY", CQU_I19_MEDICATION_HISTORY.class);
    } 

    /**
     * <p>
     * Inserts a specific repetition of MEDICATION_HISTORY (a Group object)
     * </p>
     * 
     *
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertMEDICATION_HISTORY(CQU_I19_MEDICATION_HISTORY structure, int rep) throws HL7Exception { 
       super.insertRepetition( "MEDICATION_HISTORY", structure, rep);
    }


    /**
     * <p>
     * Inserts a specific repetition of MEDICATION_HISTORY (a Group object)
     * </p>
     * 
     *
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public CQU_I19_MEDICATION_HISTORY insertMEDICATION_HISTORY(int rep) throws HL7Exception { 
       return (CQU_I19_MEDICATION_HISTORY)super.insertRepetition("MEDICATION_HISTORY", rep);
    }


    /**
     * <p>
     * Removes a specific repetition of MEDICATION_HISTORY (a Group object)
     * </p>
     * 
     *
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public CQU_I19_MEDICATION_HISTORY removeMEDICATION_HISTORY(int rep) throws HL7Exception { 
       return (CQU_I19_MEDICATION_HISTORY)super.removeRepetition("MEDICATION_HISTORY", rep);
    }




    /**
     * <p>
     * Returns
     * the first repetition of 
     * PROBLEM (a Group object) - creates it if necessary
     * </p>
     * 
     *
     */
    public CQU_I19_PROBLEM getPROBLEM() { 
       return getTyped("PROBLEM", CQU_I19_PROBLEM.class);
    }


    /**
     * <p>
     * Returns a specific repetition of
     * PROBLEM (a Group object) - creates it if necessary
     * </p>
     * 
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public CQU_I19_PROBLEM getPROBLEM(int rep) { 
       return getTyped("PROBLEM", rep, CQU_I19_PROBLEM.class);
    }

    /** 
     * <p>
     * Returns the number of existing repetitions of PROBLEM 
     * </p>
     * 
     */ 
    public int getPROBLEMReps() { 
    	return getReps("PROBLEM");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of PROBLEM.
     * <p>
     * <p>
     * Note that unlike {@link #getPROBLEM()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     * 
     */ 
    public java.util.List<CQU_I19_PROBLEM> getPROBLEMAll() throws HL7Exception {
    	return getAllAsList("PROBLEM", CQU_I19_PROBLEM.class);
    } 

    /**
     * <p>
     * Inserts a specific repetition of PROBLEM (a Group object)
     * </p>
     * 
     *
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertPROBLEM(CQU_I19_PROBLEM structure, int rep) throws HL7Exception { 
       super.insertRepetition( "PROBLEM", structure, rep);
    }


    /**
     * <p>
     * Inserts a specific repetition of PROBLEM (a Group object)
     * </p>
     * 
     *
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public CQU_I19_PROBLEM insertPROBLEM(int rep) throws HL7Exception { 
       return (CQU_I19_PROBLEM)super.insertRepetition("PROBLEM", rep);
    }


    /**
     * <p>
     * Removes a specific repetition of PROBLEM (a Group object)
     * </p>
     * 
     *
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public CQU_I19_PROBLEM removePROBLEM(int rep) throws HL7Exception { 
       return (CQU_I19_PROBLEM)super.removeRepetition("PROBLEM", rep);
    }




    /**
     * <p>
     * Returns
     * the first repetition of 
     * GOAL (a Group object) - creates it if necessary
     * </p>
     * 
     *
     */
    public CQU_I19_GOAL getGOAL() { 
       return getTyped("GOAL", CQU_I19_GOAL.class);
    }


    /**
     * <p>
     * Returns a specific repetition of
     * GOAL (a Group object) - creates it if necessary
     * </p>
     * 
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public CQU_I19_GOAL getGOAL(int rep) { 
       return getTyped("GOAL", rep, CQU_I19_GOAL.class);
    }

    /** 
     * <p>
     * Returns the number of existing repetitions of GOAL 
     * </p>
     * 
     */ 
    public int getGOALReps() { 
    	return getReps("GOAL");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of GOAL.
     * <p>
     * <p>
     * Note that unlike {@link #getGOAL()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     * 
     */ 
    public java.util.List<CQU_I19_GOAL> getGOALAll() throws HL7Exception {
    	return getAllAsList("GOAL", CQU_I19_GOAL.class);
    } 

    /**
     * <p>
     * Inserts a specific repetition of GOAL (a Group object)
     * </p>
     * 
     *
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertGOAL(CQU_I19_GOAL structure, int rep) throws HL7Exception { 
       super.insertRepetition( "GOAL", structure, rep);
    }


    /**
     * <p>
     * Inserts a specific repetition of GOAL (a Group object)
     * </p>
     * 
     *
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public CQU_I19_GOAL insertGOAL(int rep) throws HL7Exception { 
       return (CQU_I19_GOAL)super.insertRepetition("GOAL", rep);
    }


    /**
     * <p>
     * Removes a specific repetition of GOAL (a Group object)
     * </p>
     * 
     *
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public CQU_I19_GOAL removeGOAL(int rep) throws HL7Exception { 
       return (CQU_I19_GOAL)super.removeRepetition("GOAL", rep);
    }




    /**
     * <p>
     * Returns
     * the first repetition of 
     * PATHWAY (a Group object) - creates it if necessary
     * </p>
     * 
     *
     */
    public CQU_I19_PATHWAY getPATHWAY() { 
       return getTyped("PATHWAY", CQU_I19_PATHWAY.class);
    }


    /**
     * <p>
     * Returns a specific repetition of
     * PATHWAY (a Group object) - creates it if necessary
     * </p>
     * 
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public CQU_I19_PATHWAY getPATHWAY(int rep) { 
       return getTyped("PATHWAY", rep, CQU_I19_PATHWAY.class);
    }

    /** 
     * <p>
     * Returns the number of existing repetitions of PATHWAY 
     * </p>
     * 
     */ 
    public int getPATHWAYReps() { 
    	return getReps("PATHWAY");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of PATHWAY.
     * <p>
     * <p>
     * Note that unlike {@link #getPATHWAY()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     * 
     */ 
    public java.util.List<CQU_I19_PATHWAY> getPATHWAYAll() throws HL7Exception {
    	return getAllAsList("PATHWAY", CQU_I19_PATHWAY.class);
    } 

    /**
     * <p>
     * Inserts a specific repetition of PATHWAY (a Group object)
     * </p>
     * 
     *
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertPATHWAY(CQU_I19_PATHWAY structure, int rep) throws HL7Exception { 
       super.insertRepetition( "PATHWAY", structure, rep);
    }


    /**
     * <p>
     * Inserts a specific repetition of PATHWAY (a Group object)
     * </p>
     * 
     *
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public CQU_I19_PATHWAY insertPATHWAY(int rep) throws HL7Exception { 
       return (CQU_I19_PATHWAY)super.insertRepetition("PATHWAY", rep);
    }


    /**
     * <p>
     * Removes a specific repetition of PATHWAY (a Group object)
     * </p>
     * 
     *
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public CQU_I19_PATHWAY removePATHWAY(int rep) throws HL7Exception { 
       return (CQU_I19_PATHWAY)super.removeRepetition("PATHWAY", rep);
    }




    /**
     * <p>
     * Returns
     * the first repetition of 
     * REL (Clinical Relationship Segment) - creates it if necessary
     * </p>
     * 
     *
     */
    public REL getREL() { 
       return getTyped("REL", REL.class);
    }


    /**
     * <p>
     * Returns a specific repetition of
     * REL (Clinical Relationship Segment) - creates it if necessary
     * </p>
     * 
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public REL getREL(int rep) { 
       return getTyped("REL", rep, REL.class);
    }

    /** 
     * <p>
     * Returns the number of existing repetitions of REL 
     * </p>
     * 
     */ 
    public int getRELReps() { 
    	return getReps("REL");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of REL.
     * <p>
     * <p>
     * Note that unlike {@link #getREL()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     * 
     */ 
    public java.util.List<REL> getRELAll() throws HL7Exception {
    	return getAllAsList("REL", REL.class);
    } 

    /**
     * <p>
     * Inserts a specific repetition of REL (Clinical Relationship Segment)
     * </p>
     * 
     *
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertREL(REL structure, int rep) throws HL7Exception { 
       super.insertRepetition( "REL", structure, rep);
    }


    /**
     * <p>
     * Inserts a specific repetition of REL (Clinical Relationship Segment)
     * </p>
     * 
     *
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public REL insertREL(int rep) throws HL7Exception { 
       return (REL)super.insertRepetition("REL", rep);
    }


    /**
     * <p>
     * Removes a specific repetition of REL (Clinical Relationship Segment)
     * </p>
     * 
     *
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public REL removeREL(int rep) throws HL7Exception { 
       return (REL)super.removeRepetition("REL", rep);
    }



}

