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


package ca.uhn.hl7v2.model.v23.message;

import ca.uhn.hl7v2.model.v23.group.*;
import ca.uhn.hl7v2.model.v23.segment.*;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.parser.DefaultModelClassFactory;
import ca.uhn.hl7v2.model.*;


/**
 * <p>Represents a REF_I15 message structure (see chapter ?). This structure contains the 
 * following elements: </p>
 * <ul>
		                 * <li>1: MSH (Message header segment) <b> </b> </li>
		                 * <li>2: RF1 (Referral Information Segment) <b>optional </b> </li>
		                 * <li>3: REF_I15_AUTHORIZATION (a Group object) <b>optional </b> </li>
		                 * <li>4: REF_I15_PROVIDER (a Group object) <b> repeating</b> </li>
		                 * <li>5: PID (Patient Identification) <b> </b> </li>
		                 * <li>6: NK1 (Next of kin) <b>optional repeating</b> </li>
		                 * <li>7: GT1 (Guarantor) <b>optional repeating</b> </li>
		                 * <li>8: REF_I15_INSURANCE (a Group object) <b>optional repeating</b> </li>
		                 * <li>9: ACC (Accident) <b>optional </b> </li>
		                 * <li>10: DG1 (Diagnosis) <b>optional repeating</b> </li>
		                 * <li>11: DRG (Diagnosis Related Group) <b>optional repeating</b> </li>
		                 * <li>12: AL1 (Patient allergy information) <b>optional repeating</b> </li>
		                 * <li>13: REF_I15_PROCEDURE (a Group object) <b>optional repeating</b> </li>
		                 * <li>14: REF_I15_RESULTS (a Group object) <b>optional repeating</b> </li>
		                 * <li>15: REF_I15_VISIT (a Group object) <b>optional </b> </li>
		                 * <li>16: NTE (Notes and comments segment) <b>optional repeating</b> </li>
 * </ul>
 */
//@SuppressWarnings("unused")
public class REF_I15 extends AbstractMessage  {

    /**
     * Creates a new REF_I15 message with DefaultModelClassFactory. 
     */ 
    public REF_I15() { 
       this(new DefaultModelClassFactory());
    }

    /** 
     * Creates a new REF_I15 message with custom ModelClassFactory.
     */
    public REF_I15(ModelClassFactory factory) {
       super(factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                          this.add(MSH.class, true, false);
	                          this.add(RF1.class, false, false);
	                          this.add(REF_I15_AUTHORIZATION.class, false, false);
	                          this.add(REF_I15_PROVIDER.class, true, true);
	                          this.add(PID.class, true, false);
	                          this.add(NK1.class, false, true);
	                          this.add(GT1.class, false, true);
	                          this.add(REF_I15_INSURANCE.class, false, true);
	                          this.add(ACC.class, false, false);
	                          this.add(DG1.class, false, true);
	                          this.add(DRG.class, false, true);
	                          this.add(AL1.class, false, true);
	                          this.add(REF_I15_PROCEDURE.class, false, true);
	                          this.add(REF_I15_RESULTS.class, false, true);
	                          this.add(REF_I15_VISIT.class, false, false);
	                          this.add(NTE.class, false, true);
	       } catch(HL7Exception e) {
          log.error("Unexpected error creating REF_I15 - this is probably a bug in the source code generator.", e);
       }
    }


    /** 
     * Returns "2.3"
     */
    public String getVersion() {
       return "2.3";
    }




    /**
     * <p>
     * Returns
     * MSH (Message header segment) - creates it if necessary
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
     * RF1 (Referral Information Segment) - creates it if necessary
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
     * AUTHORIZATION (a Group object) - creates it if necessary
     * </p>
     * 
     *
     */
    public REF_I15_AUTHORIZATION getAUTHORIZATION() { 
       return getTyped("AUTHORIZATION", REF_I15_AUTHORIZATION.class);
    }





    /**
     * <p>
     * Returns
     * the first repetition of 
     * PROVIDER (a Group object) - creates it if necessary
     * </p>
     * 
     *
     */
    public REF_I15_PROVIDER getPROVIDER() { 
       return getTyped("PROVIDER", REF_I15_PROVIDER.class);
    }


    /**
     * <p>
     * Returns a specific repetition of
     * PROVIDER (a Group object) - creates it if necessary
     * </p>
     * 
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public REF_I15_PROVIDER getPROVIDER(int rep) { 
       return getTyped("PROVIDER", rep, REF_I15_PROVIDER.class);
    }

    /** 
     * <p>
     * Returns the number of existing repetitions of PROVIDER 
     * </p>
     * 
     */ 
    public int getPROVIDERReps() { 
    	return getReps("PROVIDER");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of PROVIDER.
     * <p>
     * <p>
     * Note that unlike {@link #getPROVIDER()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     * 
     */ 
    public java.util.List<REF_I15_PROVIDER> getPROVIDERAll() throws HL7Exception {
    	return getAllAsList("PROVIDER", REF_I15_PROVIDER.class);
    } 

    /**
     * <p>
     * Inserts a specific repetition of PROVIDER (a Group object)
     * </p>
     * 
     *
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertPROVIDER(REF_I15_PROVIDER structure, int rep) throws HL7Exception { 
       super.insertRepetition( "PROVIDER", structure, rep);
    }


    /**
     * <p>
     * Inserts a specific repetition of PROVIDER (a Group object)
     * </p>
     * 
     *
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public REF_I15_PROVIDER insertPROVIDER(int rep) throws HL7Exception { 
       return (REF_I15_PROVIDER)super.insertRepetition("PROVIDER", rep);
    }


    /**
     * <p>
     * Removes a specific repetition of PROVIDER (a Group object)
     * </p>
     * 
     *
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public REF_I15_PROVIDER removePROVIDER(int rep) throws HL7Exception { 
       return (REF_I15_PROVIDER)super.removeRepetition("PROVIDER", rep);
    }




    /**
     * <p>
     * Returns
     * PID (Patient Identification) - creates it if necessary
     * </p>
     * 
     *
     */
    public PID getPID() { 
       return getTyped("PID", PID.class);
    }





    /**
     * <p>
     * Returns
     * the first repetition of 
     * NK1 (Next of kin) - creates it if necessary
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
     * NK1 (Next of kin) - creates it if necessary
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
     * Inserts a specific repetition of NK1 (Next of kin)
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
     * Inserts a specific repetition of NK1 (Next of kin)
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
     * Removes a specific repetition of NK1 (Next of kin)
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
     * GT1 (Guarantor) - creates it if necessary
     * </p>
     * 
     *
     */
    public GT1 getGT1() { 
       return getTyped("GT1", GT1.class);
    }


    /**
     * <p>
     * Returns a specific repetition of
     * GT1 (Guarantor) - creates it if necessary
     * </p>
     * 
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public GT1 getGT1(int rep) { 
       return getTyped("GT1", rep, GT1.class);
    }

    /** 
     * <p>
     * Returns the number of existing repetitions of GT1 
     * </p>
     * 
     */ 
    public int getGT1Reps() { 
    	return getReps("GT1");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of GT1.
     * <p>
     * <p>
     * Note that unlike {@link #getGT1()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     * 
     */ 
    public java.util.List<GT1> getGT1All() throws HL7Exception {
    	return getAllAsList("GT1", GT1.class);
    } 

    /**
     * <p>
     * Inserts a specific repetition of GT1 (Guarantor)
     * </p>
     * 
     *
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertGT1(GT1 structure, int rep) throws HL7Exception { 
       super.insertRepetition( "GT1", structure, rep);
    }


    /**
     * <p>
     * Inserts a specific repetition of GT1 (Guarantor)
     * </p>
     * 
     *
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public GT1 insertGT1(int rep) throws HL7Exception { 
       return (GT1)super.insertRepetition("GT1", rep);
    }


    /**
     * <p>
     * Removes a specific repetition of GT1 (Guarantor)
     * </p>
     * 
     *
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public GT1 removeGT1(int rep) throws HL7Exception { 
       return (GT1)super.removeRepetition("GT1", rep);
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
    public REF_I15_INSURANCE getINSURANCE() { 
       return getTyped("INSURANCE", REF_I15_INSURANCE.class);
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
    public REF_I15_INSURANCE getINSURANCE(int rep) { 
       return getTyped("INSURANCE", rep, REF_I15_INSURANCE.class);
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
    public java.util.List<REF_I15_INSURANCE> getINSURANCEAll() throws HL7Exception {
    	return getAllAsList("INSURANCE", REF_I15_INSURANCE.class);
    } 

    /**
     * <p>
     * Inserts a specific repetition of INSURANCE (a Group object)
     * </p>
     * 
     *
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertINSURANCE(REF_I15_INSURANCE structure, int rep) throws HL7Exception { 
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
    public REF_I15_INSURANCE insertINSURANCE(int rep) throws HL7Exception { 
       return (REF_I15_INSURANCE)super.insertRepetition("INSURANCE", rep);
    }


    /**
     * <p>
     * Removes a specific repetition of INSURANCE (a Group object)
     * </p>
     * 
     *
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public REF_I15_INSURANCE removeINSURANCE(int rep) throws HL7Exception { 
       return (REF_I15_INSURANCE)super.removeRepetition("INSURANCE", rep);
    }




    /**
     * <p>
     * Returns
     * ACC (Accident) - creates it if necessary
     * </p>
     * 
     *
     */
    public ACC getACC() { 
       return getTyped("ACC", ACC.class);
    }





    /**
     * <p>
     * Returns
     * the first repetition of 
     * DG1 (Diagnosis) - creates it if necessary
     * </p>
     * 
     *
     */
    public DG1 getDG1() { 
       return getTyped("DG1", DG1.class);
    }


    /**
     * <p>
     * Returns a specific repetition of
     * DG1 (Diagnosis) - creates it if necessary
     * </p>
     * 
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public DG1 getDG1(int rep) { 
       return getTyped("DG1", rep, DG1.class);
    }

    /** 
     * <p>
     * Returns the number of existing repetitions of DG1 
     * </p>
     * 
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
     * 
     */ 
    public java.util.List<DG1> getDG1All() throws HL7Exception {
    	return getAllAsList("DG1", DG1.class);
    } 

    /**
     * <p>
     * Inserts a specific repetition of DG1 (Diagnosis)
     * </p>
     * 
     *
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertDG1(DG1 structure, int rep) throws HL7Exception { 
       super.insertRepetition( "DG1", structure, rep);
    }


    /**
     * <p>
     * Inserts a specific repetition of DG1 (Diagnosis)
     * </p>
     * 
     *
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public DG1 insertDG1(int rep) throws HL7Exception { 
       return (DG1)super.insertRepetition("DG1", rep);
    }


    /**
     * <p>
     * Removes a specific repetition of DG1 (Diagnosis)
     * </p>
     * 
     *
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public DG1 removeDG1(int rep) throws HL7Exception { 
       return (DG1)super.removeRepetition("DG1", rep);
    }




    /**
     * <p>
     * Returns
     * the first repetition of 
     * DRG (Diagnosis Related Group) - creates it if necessary
     * </p>
     * 
     *
     */
    public DRG getDRG() { 
       return getTyped("DRG", DRG.class);
    }


    /**
     * <p>
     * Returns a specific repetition of
     * DRG (Diagnosis Related Group) - creates it if necessary
     * </p>
     * 
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public DRG getDRG(int rep) { 
       return getTyped("DRG", rep, DRG.class);
    }

    /** 
     * <p>
     * Returns the number of existing repetitions of DRG 
     * </p>
     * 
     */ 
    public int getDRGReps() { 
    	return getReps("DRG");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of DRG.
     * <p>
     * <p>
     * Note that unlike {@link #getDRG()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     * 
     */ 
    public java.util.List<DRG> getDRGAll() throws HL7Exception {
    	return getAllAsList("DRG", DRG.class);
    } 

    /**
     * <p>
     * Inserts a specific repetition of DRG (Diagnosis Related Group)
     * </p>
     * 
     *
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertDRG(DRG structure, int rep) throws HL7Exception { 
       super.insertRepetition( "DRG", structure, rep);
    }


    /**
     * <p>
     * Inserts a specific repetition of DRG (Diagnosis Related Group)
     * </p>
     * 
     *
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public DRG insertDRG(int rep) throws HL7Exception { 
       return (DRG)super.insertRepetition("DRG", rep);
    }


    /**
     * <p>
     * Removes a specific repetition of DRG (Diagnosis Related Group)
     * </p>
     * 
     *
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public DRG removeDRG(int rep) throws HL7Exception { 
       return (DRG)super.removeRepetition("DRG", rep);
    }




    /**
     * <p>
     * Returns
     * the first repetition of 
     * AL1 (Patient allergy information) - creates it if necessary
     * </p>
     * 
     *
     */
    public AL1 getAL1() { 
       return getTyped("AL1", AL1.class);
    }


    /**
     * <p>
     * Returns a specific repetition of
     * AL1 (Patient allergy information) - creates it if necessary
     * </p>
     * 
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public AL1 getAL1(int rep) { 
       return getTyped("AL1", rep, AL1.class);
    }

    /** 
     * <p>
     * Returns the number of existing repetitions of AL1 
     * </p>
     * 
     */ 
    public int getAL1Reps() { 
    	return getReps("AL1");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of AL1.
     * <p>
     * <p>
     * Note that unlike {@link #getAL1()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     * 
     */ 
    public java.util.List<AL1> getAL1All() throws HL7Exception {
    	return getAllAsList("AL1", AL1.class);
    } 

    /**
     * <p>
     * Inserts a specific repetition of AL1 (Patient allergy information)
     * </p>
     * 
     *
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertAL1(AL1 structure, int rep) throws HL7Exception { 
       super.insertRepetition( "AL1", structure, rep);
    }


    /**
     * <p>
     * Inserts a specific repetition of AL1 (Patient allergy information)
     * </p>
     * 
     *
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public AL1 insertAL1(int rep) throws HL7Exception { 
       return (AL1)super.insertRepetition("AL1", rep);
    }


    /**
     * <p>
     * Removes a specific repetition of AL1 (Patient allergy information)
     * </p>
     * 
     *
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public AL1 removeAL1(int rep) throws HL7Exception { 
       return (AL1)super.removeRepetition("AL1", rep);
    }




    /**
     * <p>
     * Returns
     * the first repetition of 
     * PROCEDURE (a Group object) - creates it if necessary
     * </p>
     * 
     *
     */
    public REF_I15_PROCEDURE getPROCEDURE() { 
       return getTyped("PROCEDURE", REF_I15_PROCEDURE.class);
    }


    /**
     * <p>
     * Returns a specific repetition of
     * PROCEDURE (a Group object) - creates it if necessary
     * </p>
     * 
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public REF_I15_PROCEDURE getPROCEDURE(int rep) { 
       return getTyped("PROCEDURE", rep, REF_I15_PROCEDURE.class);
    }

    /** 
     * <p>
     * Returns the number of existing repetitions of PROCEDURE 
     * </p>
     * 
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
     * 
     */ 
    public java.util.List<REF_I15_PROCEDURE> getPROCEDUREAll() throws HL7Exception {
    	return getAllAsList("PROCEDURE", REF_I15_PROCEDURE.class);
    } 

    /**
     * <p>
     * Inserts a specific repetition of PROCEDURE (a Group object)
     * </p>
     * 
     *
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertPROCEDURE(REF_I15_PROCEDURE structure, int rep) throws HL7Exception { 
       super.insertRepetition( "PROCEDURE", structure, rep);
    }


    /**
     * <p>
     * Inserts a specific repetition of PROCEDURE (a Group object)
     * </p>
     * 
     *
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public REF_I15_PROCEDURE insertPROCEDURE(int rep) throws HL7Exception { 
       return (REF_I15_PROCEDURE)super.insertRepetition("PROCEDURE", rep);
    }


    /**
     * <p>
     * Removes a specific repetition of PROCEDURE (a Group object)
     * </p>
     * 
     *
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public REF_I15_PROCEDURE removePROCEDURE(int rep) throws HL7Exception { 
       return (REF_I15_PROCEDURE)super.removeRepetition("PROCEDURE", rep);
    }




    /**
     * <p>
     * Returns
     * the first repetition of 
     * RESULTS (a Group object) - creates it if necessary
     * </p>
     * 
     *
     */
    public REF_I15_RESULTS getRESULTS() { 
       return getTyped("RESULTS", REF_I15_RESULTS.class);
    }


    /**
     * <p>
     * Returns a specific repetition of
     * RESULTS (a Group object) - creates it if necessary
     * </p>
     * 
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public REF_I15_RESULTS getRESULTS(int rep) { 
       return getTyped("RESULTS", rep, REF_I15_RESULTS.class);
    }

    /** 
     * <p>
     * Returns the number of existing repetitions of RESULTS 
     * </p>
     * 
     */ 
    public int getRESULTSReps() { 
    	return getReps("RESULTS");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of RESULTS.
     * <p>
     * <p>
     * Note that unlike {@link #getRESULTS()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     * 
     */ 
    public java.util.List<REF_I15_RESULTS> getRESULTSAll() throws HL7Exception {
    	return getAllAsList("RESULTS", REF_I15_RESULTS.class);
    } 

    /**
     * <p>
     * Inserts a specific repetition of RESULTS (a Group object)
     * </p>
     * 
     *
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertRESULTS(REF_I15_RESULTS structure, int rep) throws HL7Exception { 
       super.insertRepetition( "RESULTS", structure, rep);
    }


    /**
     * <p>
     * Inserts a specific repetition of RESULTS (a Group object)
     * </p>
     * 
     *
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public REF_I15_RESULTS insertRESULTS(int rep) throws HL7Exception { 
       return (REF_I15_RESULTS)super.insertRepetition("RESULTS", rep);
    }


    /**
     * <p>
     * Removes a specific repetition of RESULTS (a Group object)
     * </p>
     * 
     *
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public REF_I15_RESULTS removeRESULTS(int rep) throws HL7Exception { 
       return (REF_I15_RESULTS)super.removeRepetition("RESULTS", rep);
    }




    /**
     * <p>
     * Returns
     * VISIT (a Group object) - creates it if necessary
     * </p>
     * 
     *
     */
    public REF_I15_VISIT getVISIT() { 
       return getTyped("VISIT", REF_I15_VISIT.class);
    }





    /**
     * <p>
     * Returns
     * the first repetition of 
     * NTE (Notes and comments segment) - creates it if necessary
     * </p>
     * 
     *
     */
    public NTE getNTE() { 
       return getTyped("NTE", NTE.class);
    }


    /**
     * <p>
     * Returns a specific repetition of
     * NTE (Notes and comments segment) - creates it if necessary
     * </p>
     * 
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public NTE getNTE(int rep) { 
       return getTyped("NTE", rep, NTE.class);
    }

    /** 
     * <p>
     * Returns the number of existing repetitions of NTE 
     * </p>
     * 
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
     * 
     */ 
    public java.util.List<NTE> getNTEAll() throws HL7Exception {
    	return getAllAsList("NTE", NTE.class);
    } 

    /**
     * <p>
     * Inserts a specific repetition of NTE (Notes and comments segment)
     * </p>
     * 
     *
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertNTE(NTE structure, int rep) throws HL7Exception { 
       super.insertRepetition( "NTE", structure, rep);
    }


    /**
     * <p>
     * Inserts a specific repetition of NTE (Notes and comments segment)
     * </p>
     * 
     *
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public NTE insertNTE(int rep) throws HL7Exception { 
       return (NTE)super.insertRepetition("NTE", rep);
    }


    /**
     * <p>
     * Removes a specific repetition of NTE (Notes and comments segment)
     * </p>
     * 
     *
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public NTE removeNTE(int rep) throws HL7Exception { 
       return (NTE)super.removeRepetition("NTE", rep);
    }



}

