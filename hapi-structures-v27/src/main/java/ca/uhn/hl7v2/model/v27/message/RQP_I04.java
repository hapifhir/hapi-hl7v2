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
 * <p>Represents a RQP_I04 message structure (see chapter 11.3.4). This structure contains the 
 * following elements: </p>
 * <ul>
		                 * <li>1: MSH (Message Header) <b> </b> </li>
		                 * <li>2: SFT (Software Segment) <b>optional repeating</b> </li>
		                 * <li>3: UAC (User Authentication Credential Segment) <b>optional </b> </li>
		                 * <li>4: RQP_I04_PROVIDER (a Group object) <b> repeating</b> </li>
		                 * <li>5: PID (Patient Identification) <b> </b> </li>
		                 * <li>6: NK1 (Next of Kin / Associated Parties) <b>optional repeating</b> </li>
		                 * <li>7: GT1 (Guarantor) <b>optional repeating</b> </li>
		                 * <li>8: NTE (Notes and Comments) <b>optional repeating</b> </li>
 * </ul>
 */
//@SuppressWarnings("unused")
public class RQP_I04 extends AbstractMessage  {

    /**
     * Creates a new RQP_I04 message with DefaultModelClassFactory. 
     */ 
    public RQP_I04() { 
       this(new DefaultModelClassFactory());
    }

    /** 
     * Creates a new RQP_I04 message with custom ModelClassFactory.
     */
    public RQP_I04(ModelClassFactory factory) {
       super(factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                          this.add(MSH.class, true, false);
	                          this.add(SFT.class, false, true);
	                          this.add(UAC.class, false, false);
	                          this.add(RQP_I04_PROVIDER.class, true, true);
	                          this.add(PID.class, true, false);
	                          this.add(NK1.class, false, true);
	                          this.add(GT1.class, false, true);
	                          this.add(NTE.class, false, true);
	       } catch(HL7Exception e) {
          log.error("Unexpected error creating RQP_I04 - this is probably a bug in the source code generator.", e);
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
     * the first repetition of 
     * PROVIDER (a Group object) - creates it if necessary
     * </p>
     * 
     *
     */
    public RQP_I04_PROVIDER getPROVIDER() { 
       return getTyped("PROVIDER", RQP_I04_PROVIDER.class);
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
    public RQP_I04_PROVIDER getPROVIDER(int rep) { 
       return getTyped("PROVIDER", rep, RQP_I04_PROVIDER.class);
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
    public java.util.List<RQP_I04_PROVIDER> getPROVIDERAll() throws HL7Exception {
    	return getAllAsList("PROVIDER", RQP_I04_PROVIDER.class);
    } 

    /**
     * <p>
     * Inserts a specific repetition of PROVIDER (a Group object)
     * </p>
     * 
     *
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertPROVIDER(RQP_I04_PROVIDER structure, int rep) throws HL7Exception { 
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
    public RQP_I04_PROVIDER insertPROVIDER(int rep) throws HL7Exception { 
       return (RQP_I04_PROVIDER)super.insertRepetition("PROVIDER", rep);
    }


    /**
     * <p>
     * Removes a specific repetition of PROVIDER (a Group object)
     * </p>
     * 
     *
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public RQP_I04_PROVIDER removePROVIDER(int rep) throws HL7Exception { 
       return (RQP_I04_PROVIDER)super.removeRepetition("PROVIDER", rep);
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
     * NTE (Notes and Comments) - creates it if necessary
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
     * NTE (Notes and Comments) - creates it if necessary
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
     * Inserts a specific repetition of NTE (Notes and Comments)
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
     * Inserts a specific repetition of NTE (Notes and Comments)
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
     * Removes a specific repetition of NTE (Notes and Comments)
     * </p>
     * 
     *
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public NTE removeNTE(int rep) throws HL7Exception { 
       return (NTE)super.removeRepetition("NTE", rep);
    }



}

