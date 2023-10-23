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
 * <p>Represents a OMD_O01 message structure (see chapter 4.6). This structure contains the 
 * following elements: </p>
 * <ul>
		                 * <li>1: MSH (MSH - message header segment) <b> </b> </li>
		                 * <li>2: NTE (NTE - notes and comments segment) <b>optional repeating</b> </li>
		                 * <li>3: OMD_O01_PIDPD1NTEPV1PV2IN1IN2IN3GT1AL1 (a Group object) <b>optional </b> </li>
		                 * <li>4: OMD_O01_ORCODSNTEOBXNTE (a Group object) <b> repeating</b> </li>
		                 * <li>5: OMD_O01_ORCODTNTE (a Group object) <b>optional repeating</b> </li>
 * </ul>
 */
//@SuppressWarnings("unused")
public class OMD_O01 extends AbstractMessage  {

    /**
     * Creates a new OMD_O01 message with DefaultModelClassFactory. 
     */ 
    public OMD_O01() { 
       this(new DefaultModelClassFactory());
    }

    /** 
     * Creates a new OMD_O01 message with custom ModelClassFactory.
     */
    public OMD_O01(ModelClassFactory factory) {
       super(factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                          this.add(MSH.class, true, false);
	                          this.add(NTE.class, false, true);
	                          this.add(OMD_O01_PIDPD1NTEPV1PV2IN1IN2IN3GT1AL1.class, false, false);
	                          this.add(OMD_O01_ORCODSNTEOBXNTE.class, true, true);
	                          this.add(OMD_O01_ORCODTNTE.class, false, true);
	       } catch(HL7Exception e) {
          log.error("Unexpected error creating OMD_O01 - this is probably a bug in the source code generator.", e);
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
     * PIDPD1NTEPV1PV2IN1IN2IN3GT1AL1 (a Group object) - creates it if necessary
     * </p>
     * 
     *
     */
    public OMD_O01_PIDPD1NTEPV1PV2IN1IN2IN3GT1AL1 getPIDPD1NTEPV1PV2IN1IN2IN3GT1AL1() { 
       return getTyped("PIDPD1NTEPV1PV2IN1IN2IN3GT1AL1", OMD_O01_PIDPD1NTEPV1PV2IN1IN2IN3GT1AL1.class);
    }





    /**
     * <p>
     * Returns
     * the first repetition of 
     * ORCODSNTEOBXNTE (a Group object) - creates it if necessary
     * </p>
     * 
     *
     */
    public OMD_O01_ORCODSNTEOBXNTE getORCODSNTEOBXNTE() { 
       return getTyped("ORCODSNTEOBXNTE", OMD_O01_ORCODSNTEOBXNTE.class);
    }


    /**
     * <p>
     * Returns a specific repetition of
     * ORCODSNTEOBXNTE (a Group object) - creates it if necessary
     * </p>
     * 
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public OMD_O01_ORCODSNTEOBXNTE getORCODSNTEOBXNTE(int rep) { 
       return getTyped("ORCODSNTEOBXNTE", rep, OMD_O01_ORCODSNTEOBXNTE.class);
    }

    /** 
     * <p>
     * Returns the number of existing repetitions of ORCODSNTEOBXNTE 
     * </p>
     * 
     */ 
    public int getORCODSNTEOBXNTEReps() { 
    	return getReps("ORCODSNTEOBXNTE");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of ORCODSNTEOBXNTE.
     * <p>
     * <p>
     * Note that unlike {@link #getORCODSNTEOBXNTE()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     * 
     */ 
    public java.util.List<OMD_O01_ORCODSNTEOBXNTE> getORCODSNTEOBXNTEAll() throws HL7Exception {
    	return getAllAsList("ORCODSNTEOBXNTE", OMD_O01_ORCODSNTEOBXNTE.class);
    } 

    /**
     * <p>
     * Inserts a specific repetition of ORCODSNTEOBXNTE (a Group object)
     * </p>
     * 
     *
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertORCODSNTEOBXNTE(OMD_O01_ORCODSNTEOBXNTE structure, int rep) throws HL7Exception { 
       super.insertRepetition( "ORCODSNTEOBXNTE", structure, rep);
    }


    /**
     * <p>
     * Inserts a specific repetition of ORCODSNTEOBXNTE (a Group object)
     * </p>
     * 
     *
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public OMD_O01_ORCODSNTEOBXNTE insertORCODSNTEOBXNTE(int rep) throws HL7Exception { 
       return (OMD_O01_ORCODSNTEOBXNTE)super.insertRepetition("ORCODSNTEOBXNTE", rep);
    }


    /**
     * <p>
     * Removes a specific repetition of ORCODSNTEOBXNTE (a Group object)
     * </p>
     * 
     *
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public OMD_O01_ORCODSNTEOBXNTE removeORCODSNTEOBXNTE(int rep) throws HL7Exception { 
       return (OMD_O01_ORCODSNTEOBXNTE)super.removeRepetition("ORCODSNTEOBXNTE", rep);
    }




    /**
     * <p>
     * Returns
     * the first repetition of 
     * ORCODTNTE (a Group object) - creates it if necessary
     * </p>
     * 
     *
     */
    public OMD_O01_ORCODTNTE getORCODTNTE() { 
       return getTyped("ORCODTNTE", OMD_O01_ORCODTNTE.class);
    }


    /**
     * <p>
     * Returns a specific repetition of
     * ORCODTNTE (a Group object) - creates it if necessary
     * </p>
     * 
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public OMD_O01_ORCODTNTE getORCODTNTE(int rep) { 
       return getTyped("ORCODTNTE", rep, OMD_O01_ORCODTNTE.class);
    }

    /** 
     * <p>
     * Returns the number of existing repetitions of ORCODTNTE 
     * </p>
     * 
     */ 
    public int getORCODTNTEReps() { 
    	return getReps("ORCODTNTE");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of ORCODTNTE.
     * <p>
     * <p>
     * Note that unlike {@link #getORCODTNTE()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     * 
     */ 
    public java.util.List<OMD_O01_ORCODTNTE> getORCODTNTEAll() throws HL7Exception {
    	return getAllAsList("ORCODTNTE", OMD_O01_ORCODTNTE.class);
    } 

    /**
     * <p>
     * Inserts a specific repetition of ORCODTNTE (a Group object)
     * </p>
     * 
     *
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertORCODTNTE(OMD_O01_ORCODTNTE structure, int rep) throws HL7Exception { 
       super.insertRepetition( "ORCODTNTE", structure, rep);
    }


    /**
     * <p>
     * Inserts a specific repetition of ORCODTNTE (a Group object)
     * </p>
     * 
     *
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public OMD_O01_ORCODTNTE insertORCODTNTE(int rep) throws HL7Exception { 
       return (OMD_O01_ORCODTNTE)super.insertRepetition("ORCODTNTE", rep);
    }


    /**
     * <p>
     * Removes a specific repetition of ORCODTNTE (a Group object)
     * </p>
     * 
     *
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public OMD_O01_ORCODTNTE removeORCODTNTE(int rep) throws HL7Exception { 
       return (OMD_O01_ORCODTNTE)super.removeRepetition("ORCODTNTE", rep);
    }



}

