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


package ca.uhn.hl7v2.model.v25.message;

import ca.uhn.hl7v2.model.v25.group.*;
import ca.uhn.hl7v2.model.v25.segment.*;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.parser.DefaultModelClassFactory;
import ca.uhn.hl7v2.model.*;


/**
 * <p>Represents a MDM_T02 message structure (see chapter 9.5.2). This structure contains the 
 * following elements: </p>
 * <ul>
		                 * <li>1: MSH (Message Header) <b> </b> </li>
		                 * <li>2: SFT (Software Segment) <b>optional repeating</b> </li>
		                 * <li>3: EVN (Event Type) <b> </b> </li>
		                 * <li>4: PID (Patient Identification) <b> </b> </li>
		                 * <li>5: PV1 (Patient Visit) <b> </b> </li>
		                 * <li>6: MDM_T02_COMMON_ORDER (a Group object) <b>optional repeating</b> </li>
		                 * <li>7: TXA (Transcription Document Header) <b> </b> </li>
		                 * <li>8: MDM_T02_OBXNTE (a Group object) <b> repeating</b> </li>
 * </ul>
 */
//@SuppressWarnings("unused")
public class MDM_T02 extends AbstractMessage  {

    /**
     * Creates a new MDM_T02 message with DefaultModelClassFactory. 
     */ 
    public MDM_T02() { 
       this(new DefaultModelClassFactory());
    }

    /** 
     * Creates a new MDM_T02 message with custom ModelClassFactory.
     */
    public MDM_T02(ModelClassFactory factory) {
       super(factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                          this.add(MSH.class, true, false);
	                          this.add(SFT.class, false, true);
	                          this.add(EVN.class, true, false);
	                          this.add(PID.class, true, false);
	                          this.add(PV1.class, true, false);
	                          this.add(MDM_T02_COMMON_ORDER.class, false, true);
	                          this.add(TXA.class, true, false);
	                          this.add(MDM_T02_OBXNTE.class, true, true);
	       } catch(HL7Exception e) {
          log.error("Unexpected error creating MDM_T02 - this is probably a bug in the source code generator.", e);
       }
    }


    /** 
     * Returns "2.5"
     */
    public String getVersion() {
       return "2.5";
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
     * EVN (Event Type) - creates it if necessary
     * </p>
     * 
     *
     */
    public EVN getEVN() { 
       return getTyped("EVN", EVN.class);
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
     * PV1 (Patient Visit) - creates it if necessary
     * </p>
     * 
     *
     */
    public PV1 getPV1() { 
       return getTyped("PV1", PV1.class);
    }





    /**
     * <p>
     * Returns
     * the first repetition of 
     * COMMON_ORDER (a Group object) - creates it if necessary
     * </p>
     * 
     *
     */
    public MDM_T02_COMMON_ORDER getCOMMON_ORDER() { 
       return getTyped("COMMON_ORDER", MDM_T02_COMMON_ORDER.class);
    }


    /**
     * <p>
     * Returns a specific repetition of
     * COMMON_ORDER (a Group object) - creates it if necessary
     * </p>
     * 
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public MDM_T02_COMMON_ORDER getCOMMON_ORDER(int rep) { 
       return getTyped("COMMON_ORDER", rep, MDM_T02_COMMON_ORDER.class);
    }

    /** 
     * <p>
     * Returns the number of existing repetitions of COMMON_ORDER 
     * </p>
     * 
     */ 
    public int getCOMMON_ORDERReps() { 
    	return getReps("COMMON_ORDER");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of COMMON_ORDER.
     * <p>
     * <p>
     * Note that unlike {@link #getCOMMON_ORDER()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     * 
     */ 
    public java.util.List<MDM_T02_COMMON_ORDER> getCOMMON_ORDERAll() throws HL7Exception {
    	return getAllAsList("COMMON_ORDER", MDM_T02_COMMON_ORDER.class);
    } 

    /**
     * <p>
     * Inserts a specific repetition of COMMON_ORDER (a Group object)
     * </p>
     * 
     *
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertCOMMON_ORDER(MDM_T02_COMMON_ORDER structure, int rep) throws HL7Exception { 
       super.insertRepetition( "COMMON_ORDER", structure, rep);
    }


    /**
     * <p>
     * Inserts a specific repetition of COMMON_ORDER (a Group object)
     * </p>
     * 
     *
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public MDM_T02_COMMON_ORDER insertCOMMON_ORDER(int rep) throws HL7Exception { 
       return (MDM_T02_COMMON_ORDER)super.insertRepetition("COMMON_ORDER", rep);
    }


    /**
     * <p>
     * Removes a specific repetition of COMMON_ORDER (a Group object)
     * </p>
     * 
     *
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public MDM_T02_COMMON_ORDER removeCOMMON_ORDER(int rep) throws HL7Exception { 
       return (MDM_T02_COMMON_ORDER)super.removeRepetition("COMMON_ORDER", rep);
    }




    /**
     * <p>
     * Returns
     * TXA (Transcription Document Header) - creates it if necessary
     * </p>
     * 
     *
     */
    public TXA getTXA() { 
       return getTyped("TXA", TXA.class);
    }





    /**
     * <p>
     * Returns
     * the first repetition of 
     * OBXNTE (a Group object) - creates it if necessary
     * </p>
     * 
     *
     */
    public MDM_T02_OBXNTE getOBXNTE() { 
       return getTyped("OBXNTE", MDM_T02_OBXNTE.class);
    }


    /**
     * <p>
     * Returns a specific repetition of
     * OBXNTE (a Group object) - creates it if necessary
     * </p>
     * 
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public MDM_T02_OBXNTE getOBXNTE(int rep) { 
       return getTyped("OBXNTE", rep, MDM_T02_OBXNTE.class);
    }

    /** 
     * <p>
     * Returns the number of existing repetitions of OBXNTE 
     * </p>
     * 
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
     * 
     */ 
    public java.util.List<MDM_T02_OBXNTE> getOBXNTEAll() throws HL7Exception {
    	return getAllAsList("OBXNTE", MDM_T02_OBXNTE.class);
    } 

    /**
     * <p>
     * Inserts a specific repetition of OBXNTE (a Group object)
     * </p>
     * 
     *
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertOBXNTE(MDM_T02_OBXNTE structure, int rep) throws HL7Exception { 
       super.insertRepetition( "OBXNTE", structure, rep);
    }


    /**
     * <p>
     * Inserts a specific repetition of OBXNTE (a Group object)
     * </p>
     * 
     *
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public MDM_T02_OBXNTE insertOBXNTE(int rep) throws HL7Exception { 
       return (MDM_T02_OBXNTE)super.insertRepetition("OBXNTE", rep);
    }


    /**
     * <p>
     * Removes a specific repetition of OBXNTE (a Group object)
     * </p>
     * 
     *
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public MDM_T02_OBXNTE removeOBXNTE(int rep) throws HL7Exception { 
       return (MDM_T02_OBXNTE)super.removeRepetition("OBXNTE", rep);
    }



}

