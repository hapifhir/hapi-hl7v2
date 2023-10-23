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
 * <p>Represents a SIU_S12 message structure. This structure contains the 
 * following elements: </p>
 * <ul>
		                 * <li>1: MSH (MSH - message header segment) <b> </b> </li>
		                 * <li>2: SCH (SCH - schedule activity information segment) <b> </b> </li>
		                 * <li>3: NTE (NTE - notes and comments segment) <b>optional repeating</b> </li>
		                 * <li>4: SIU_S12_PIDPD1PV1PV2OBXDG1 (a Group object) <b>optional repeating</b> </li>
		                 * <li>5: SIU_S12_RGSAISNTEAIGNTEAILNTEAIPNTE (a Group object) <b> repeating</b> </li>
 * </ul>
 */
//@SuppressWarnings("unused")
public class SIU_S12 extends AbstractMessage  {

    /**
     * Creates a new SIU_S12 message with DefaultModelClassFactory. 
     */ 
    public SIU_S12() { 
       this(new DefaultModelClassFactory());
    }

    /** 
     * Creates a new SIU_S12 message with custom ModelClassFactory.
     */
    public SIU_S12(ModelClassFactory factory) {
       super(factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                          this.add(MSH.class, true, false);
	                          this.add(SCH.class, true, false);
	                          this.add(NTE.class, false, true);
	                          this.add(SIU_S12_PIDPD1PV1PV2OBXDG1.class, false, true);
	                          this.add(SIU_S12_RGSAISNTEAIGNTEAILNTEAIPNTE.class, true, true);
	       } catch(HL7Exception e) {
          log.error("Unexpected error creating SIU_S12 - this is probably a bug in the source code generator.", e);
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
     * SCH (SCH - schedule activity information segment) - creates it if necessary
     * </p>
     * 
     *
     */
    public SCH getSCH() { 
       return getTyped("SCH", SCH.class);
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
     * PIDPD1PV1PV2OBXDG1 (a Group object) - creates it if necessary
     * </p>
     * 
     *
     */
    public SIU_S12_PIDPD1PV1PV2OBXDG1 getPIDPD1PV1PV2OBXDG1() { 
       return getTyped("PIDPD1PV1PV2OBXDG1", SIU_S12_PIDPD1PV1PV2OBXDG1.class);
    }


    /**
     * <p>
     * Returns a specific repetition of
     * PIDPD1PV1PV2OBXDG1 (a Group object) - creates it if necessary
     * </p>
     * 
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public SIU_S12_PIDPD1PV1PV2OBXDG1 getPIDPD1PV1PV2OBXDG1(int rep) { 
       return getTyped("PIDPD1PV1PV2OBXDG1", rep, SIU_S12_PIDPD1PV1PV2OBXDG1.class);
    }

    /** 
     * <p>
     * Returns the number of existing repetitions of PIDPD1PV1PV2OBXDG1 
     * </p>
     * 
     */ 
    public int getPIDPD1PV1PV2OBXDG1Reps() { 
    	return getReps("PIDPD1PV1PV2OBXDG1");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of PIDPD1PV1PV2OBXDG1.
     * <p>
     * <p>
     * Note that unlike {@link #getPIDPD1PV1PV2OBXDG1()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     * 
     */ 
    public java.util.List<SIU_S12_PIDPD1PV1PV2OBXDG1> getPIDPD1PV1PV2OBXDG1All() throws HL7Exception {
    	return getAllAsList("PIDPD1PV1PV2OBXDG1", SIU_S12_PIDPD1PV1PV2OBXDG1.class);
    } 

    /**
     * <p>
     * Inserts a specific repetition of PIDPD1PV1PV2OBXDG1 (a Group object)
     * </p>
     * 
     *
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertPIDPD1PV1PV2OBXDG1(SIU_S12_PIDPD1PV1PV2OBXDG1 structure, int rep) throws HL7Exception { 
       super.insertRepetition( "PIDPD1PV1PV2OBXDG1", structure, rep);
    }


    /**
     * <p>
     * Inserts a specific repetition of PIDPD1PV1PV2OBXDG1 (a Group object)
     * </p>
     * 
     *
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public SIU_S12_PIDPD1PV1PV2OBXDG1 insertPIDPD1PV1PV2OBXDG1(int rep) throws HL7Exception { 
       return (SIU_S12_PIDPD1PV1PV2OBXDG1)super.insertRepetition("PIDPD1PV1PV2OBXDG1", rep);
    }


    /**
     * <p>
     * Removes a specific repetition of PIDPD1PV1PV2OBXDG1 (a Group object)
     * </p>
     * 
     *
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public SIU_S12_PIDPD1PV1PV2OBXDG1 removePIDPD1PV1PV2OBXDG1(int rep) throws HL7Exception { 
       return (SIU_S12_PIDPD1PV1PV2OBXDG1)super.removeRepetition("PIDPD1PV1PV2OBXDG1", rep);
    }




    /**
     * <p>
     * Returns
     * the first repetition of 
     * RGSAISNTEAIGNTEAILNTEAIPNTE (a Group object) - creates it if necessary
     * </p>
     * 
     *
     */
    public SIU_S12_RGSAISNTEAIGNTEAILNTEAIPNTE getRGSAISNTEAIGNTEAILNTEAIPNTE() { 
       return getTyped("RGSAISNTEAIGNTEAILNTEAIPNTE", SIU_S12_RGSAISNTEAIGNTEAILNTEAIPNTE.class);
    }


    /**
     * <p>
     * Returns a specific repetition of
     * RGSAISNTEAIGNTEAILNTEAIPNTE (a Group object) - creates it if necessary
     * </p>
     * 
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public SIU_S12_RGSAISNTEAIGNTEAILNTEAIPNTE getRGSAISNTEAIGNTEAILNTEAIPNTE(int rep) { 
       return getTyped("RGSAISNTEAIGNTEAILNTEAIPNTE", rep, SIU_S12_RGSAISNTEAIGNTEAILNTEAIPNTE.class);
    }

    /** 
     * <p>
     * Returns the number of existing repetitions of RGSAISNTEAIGNTEAILNTEAIPNTE 
     * </p>
     * 
     */ 
    public int getRGSAISNTEAIGNTEAILNTEAIPNTEReps() { 
    	return getReps("RGSAISNTEAIGNTEAILNTEAIPNTE");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of RGSAISNTEAIGNTEAILNTEAIPNTE.
     * <p>
     * <p>
     * Note that unlike {@link #getRGSAISNTEAIGNTEAILNTEAIPNTE()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     * 
     */ 
    public java.util.List<SIU_S12_RGSAISNTEAIGNTEAILNTEAIPNTE> getRGSAISNTEAIGNTEAILNTEAIPNTEAll() throws HL7Exception {
    	return getAllAsList("RGSAISNTEAIGNTEAILNTEAIPNTE", SIU_S12_RGSAISNTEAIGNTEAILNTEAIPNTE.class);
    } 

    /**
     * <p>
     * Inserts a specific repetition of RGSAISNTEAIGNTEAILNTEAIPNTE (a Group object)
     * </p>
     * 
     *
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertRGSAISNTEAIGNTEAILNTEAIPNTE(SIU_S12_RGSAISNTEAIGNTEAILNTEAIPNTE structure, int rep) throws HL7Exception { 
       super.insertRepetition( "RGSAISNTEAIGNTEAILNTEAIPNTE", structure, rep);
    }


    /**
     * <p>
     * Inserts a specific repetition of RGSAISNTEAIGNTEAILNTEAIPNTE (a Group object)
     * </p>
     * 
     *
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public SIU_S12_RGSAISNTEAIGNTEAILNTEAIPNTE insertRGSAISNTEAIGNTEAILNTEAIPNTE(int rep) throws HL7Exception { 
       return (SIU_S12_RGSAISNTEAIGNTEAILNTEAIPNTE)super.insertRepetition("RGSAISNTEAIGNTEAILNTEAIPNTE", rep);
    }


    /**
     * <p>
     * Removes a specific repetition of RGSAISNTEAIGNTEAILNTEAIPNTE (a Group object)
     * </p>
     * 
     *
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public SIU_S12_RGSAISNTEAIGNTEAILNTEAIPNTE removeRGSAISNTEAIGNTEAILNTEAIPNTE(int rep) throws HL7Exception { 
       return (SIU_S12_RGSAISNTEAIGNTEAILNTEAIPNTE)super.removeRepetition("RGSAISNTEAIGNTEAILNTEAIPNTE", rep);
    }



}

