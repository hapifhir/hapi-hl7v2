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


package ca.uhn.hl7v2.model.v231.message;

import ca.uhn.hl7v2.model.v231.group.*;
import ca.uhn.hl7v2.model.v231.segment.*;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.parser.DefaultModelClassFactory;
import ca.uhn.hl7v2.model.*;


/**
 * <p>Represents a SRM_S01 message structure. This structure contains the 
 * following elements: </p>
 * <ul>
		                 * <li>1: MSH (MSH - message header segment) <b> </b> </li>
		                 * <li>2: ARQ (ARQ - appointment request segment) <b> </b> </li>
		                 * <li>3: APR (APR - appointment preferences segment) <b>optional </b> </li>
		                 * <li>4: NTE (NTE - notes and comments segment) <b>optional repeating</b> </li>
		                 * <li>5: SRM_S01_PIDPV1PV2OBXDG1 (a Group object) <b>optional repeating</b> </li>
		                 * <li>6: SRM_S01_RGSAISAPRNTEAIGAPRNTEAILAPRNTEAIPAPRNTE (a Group object) <b> repeating</b> </li>
 * </ul>
 */
//@SuppressWarnings("unused")
public class SRM_S01 extends AbstractMessage  {

    /**
     * Creates a new SRM_S01 message with DefaultModelClassFactory. 
     */ 
    public SRM_S01() { 
       this(new DefaultModelClassFactory());
    }

    /** 
     * Creates a new SRM_S01 message with custom ModelClassFactory.
     */
    public SRM_S01(ModelClassFactory factory) {
       super(factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                          this.add(MSH.class, true, false);
	                          this.add(ARQ.class, true, false);
	                          this.add(APR.class, false, false);
	                          this.add(NTE.class, false, true);
	                          this.add(SRM_S01_PIDPV1PV2OBXDG1.class, false, true);
	                          this.add(SRM_S01_RGSAISAPRNTEAIGAPRNTEAILAPRNTEAIPAPRNTE.class, true, true);
	       } catch(HL7Exception e) {
          log.error("Unexpected error creating SRM_S01 - this is probably a bug in the source code generator.", e);
       }
    }


    /** 
     * Returns "2.3.1"
     */
    public String getVersion() {
       return "2.3.1";
    }




    /**
     * <p>
     * Returns
     * MSH (MSH - message header segment) - creates it if necessary
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
     * ARQ (ARQ - appointment request segment) - creates it if necessary
     * </p>
     * 
     *
     */
    public ARQ getARQ() { 
       return getTyped("ARQ", ARQ.class);
    }





    /**
     * <p>
     * Returns
     * APR (APR - appointment preferences segment) - creates it if necessary
     * </p>
     * 
     *
     */
    public APR getAPR() { 
       return getTyped("APR", APR.class);
    }





    /**
     * <p>
     * Returns
     * the first repetition of 
     * NTE (NTE - notes and comments segment) - creates it if necessary
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
     * NTE (NTE - notes and comments segment) - creates it if necessary
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
     * Inserts a specific repetition of NTE (NTE - notes and comments segment)
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
     * Inserts a specific repetition of NTE (NTE - notes and comments segment)
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
     * Removes a specific repetition of NTE (NTE - notes and comments segment)
     * </p>
     * 
     *
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public NTE removeNTE(int rep) throws HL7Exception { 
       return (NTE)super.removeRepetition("NTE", rep);
    }




    /**
     * <p>
     * Returns
     * the first repetition of 
     * PIDPV1PV2OBXDG1 (a Group object) - creates it if necessary
     * </p>
     * 
     *
     */
    public SRM_S01_PIDPV1PV2OBXDG1 getPIDPV1PV2OBXDG1() { 
       return getTyped("PIDPV1PV2OBXDG1", SRM_S01_PIDPV1PV2OBXDG1.class);
    }


    /**
     * <p>
     * Returns a specific repetition of
     * PIDPV1PV2OBXDG1 (a Group object) - creates it if necessary
     * </p>
     * 
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public SRM_S01_PIDPV1PV2OBXDG1 getPIDPV1PV2OBXDG1(int rep) { 
       return getTyped("PIDPV1PV2OBXDG1", rep, SRM_S01_PIDPV1PV2OBXDG1.class);
    }

    /** 
     * <p>
     * Returns the number of existing repetitions of PIDPV1PV2OBXDG1 
     * </p>
     * 
     */ 
    public int getPIDPV1PV2OBXDG1Reps() { 
    	return getReps("PIDPV1PV2OBXDG1");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of PIDPV1PV2OBXDG1.
     * <p>
     * <p>
     * Note that unlike {@link #getPIDPV1PV2OBXDG1()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     * 
     */ 
    public java.util.List<SRM_S01_PIDPV1PV2OBXDG1> getPIDPV1PV2OBXDG1All() throws HL7Exception {
    	return getAllAsList("PIDPV1PV2OBXDG1", SRM_S01_PIDPV1PV2OBXDG1.class);
    } 

    /**
     * <p>
     * Inserts a specific repetition of PIDPV1PV2OBXDG1 (a Group object)
     * </p>
     * 
     *
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertPIDPV1PV2OBXDG1(SRM_S01_PIDPV1PV2OBXDG1 structure, int rep) throws HL7Exception { 
       super.insertRepetition( "PIDPV1PV2OBXDG1", structure, rep);
    }


    /**
     * <p>
     * Inserts a specific repetition of PIDPV1PV2OBXDG1 (a Group object)
     * </p>
     * 
     *
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public SRM_S01_PIDPV1PV2OBXDG1 insertPIDPV1PV2OBXDG1(int rep) throws HL7Exception { 
       return (SRM_S01_PIDPV1PV2OBXDG1)super.insertRepetition("PIDPV1PV2OBXDG1", rep);
    }


    /**
     * <p>
     * Removes a specific repetition of PIDPV1PV2OBXDG1 (a Group object)
     * </p>
     * 
     *
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public SRM_S01_PIDPV1PV2OBXDG1 removePIDPV1PV2OBXDG1(int rep) throws HL7Exception { 
       return (SRM_S01_PIDPV1PV2OBXDG1)super.removeRepetition("PIDPV1PV2OBXDG1", rep);
    }




    /**
     * <p>
     * Returns
     * the first repetition of 
     * RGSAISAPRNTEAIGAPRNTEAILAPRNTEAIPAPRNTE (a Group object) - creates it if necessary
     * </p>
     * 
     *
     */
    public SRM_S01_RGSAISAPRNTEAIGAPRNTEAILAPRNTEAIPAPRNTE getRGSAISAPRNTEAIGAPRNTEAILAPRNTEAIPAPRNTE() { 
       return getTyped("RGSAISAPRNTEAIGAPRNTEAILAPRNTEAIPAPRNTE", SRM_S01_RGSAISAPRNTEAIGAPRNTEAILAPRNTEAIPAPRNTE.class);
    }


    /**
     * <p>
     * Returns a specific repetition of
     * RGSAISAPRNTEAIGAPRNTEAILAPRNTEAIPAPRNTE (a Group object) - creates it if necessary
     * </p>
     * 
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public SRM_S01_RGSAISAPRNTEAIGAPRNTEAILAPRNTEAIPAPRNTE getRGSAISAPRNTEAIGAPRNTEAILAPRNTEAIPAPRNTE(int rep) { 
       return getTyped("RGSAISAPRNTEAIGAPRNTEAILAPRNTEAIPAPRNTE", rep, SRM_S01_RGSAISAPRNTEAIGAPRNTEAILAPRNTEAIPAPRNTE.class);
    }

    /** 
     * <p>
     * Returns the number of existing repetitions of RGSAISAPRNTEAIGAPRNTEAILAPRNTEAIPAPRNTE 
     * </p>
     * 
     */ 
    public int getRGSAISAPRNTEAIGAPRNTEAILAPRNTEAIPAPRNTEReps() { 
    	return getReps("RGSAISAPRNTEAIGAPRNTEAILAPRNTEAIPAPRNTE");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of RGSAISAPRNTEAIGAPRNTEAILAPRNTEAIPAPRNTE.
     * <p>
     * <p>
     * Note that unlike {@link #getRGSAISAPRNTEAIGAPRNTEAILAPRNTEAIPAPRNTE()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     * 
     */ 
    public java.util.List<SRM_S01_RGSAISAPRNTEAIGAPRNTEAILAPRNTEAIPAPRNTE> getRGSAISAPRNTEAIGAPRNTEAILAPRNTEAIPAPRNTEAll() throws HL7Exception {
    	return getAllAsList("RGSAISAPRNTEAIGAPRNTEAILAPRNTEAIPAPRNTE", SRM_S01_RGSAISAPRNTEAIGAPRNTEAILAPRNTEAIPAPRNTE.class);
    } 

    /**
     * <p>
     * Inserts a specific repetition of RGSAISAPRNTEAIGAPRNTEAILAPRNTEAIPAPRNTE (a Group object)
     * </p>
     * 
     *
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertRGSAISAPRNTEAIGAPRNTEAILAPRNTEAIPAPRNTE(SRM_S01_RGSAISAPRNTEAIGAPRNTEAILAPRNTEAIPAPRNTE structure, int rep) throws HL7Exception { 
       super.insertRepetition( "RGSAISAPRNTEAIGAPRNTEAILAPRNTEAIPAPRNTE", structure, rep);
    }


    /**
     * <p>
     * Inserts a specific repetition of RGSAISAPRNTEAIGAPRNTEAILAPRNTEAIPAPRNTE (a Group object)
     * </p>
     * 
     *
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public SRM_S01_RGSAISAPRNTEAIGAPRNTEAILAPRNTEAIPAPRNTE insertRGSAISAPRNTEAIGAPRNTEAILAPRNTEAIPAPRNTE(int rep) throws HL7Exception { 
       return (SRM_S01_RGSAISAPRNTEAIGAPRNTEAILAPRNTEAIPAPRNTE)super.insertRepetition("RGSAISAPRNTEAIGAPRNTEAILAPRNTEAIPAPRNTE", rep);
    }


    /**
     * <p>
     * Removes a specific repetition of RGSAISAPRNTEAIGAPRNTEAILAPRNTEAIPAPRNTE (a Group object)
     * </p>
     * 
     *
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public SRM_S01_RGSAISAPRNTEAIGAPRNTEAILAPRNTEAIPAPRNTE removeRGSAISAPRNTEAIGAPRNTEAILAPRNTEAIPAPRNTE(int rep) throws HL7Exception { 
       return (SRM_S01_RGSAISAPRNTEAIGAPRNTEAILAPRNTEAIPAPRNTE)super.removeRepetition("RGSAISAPRNTEAIGAPRNTEAILAPRNTEAIPAPRNTE", rep);
    }



}

