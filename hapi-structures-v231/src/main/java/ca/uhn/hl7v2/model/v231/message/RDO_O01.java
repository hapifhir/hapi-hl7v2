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
 * <p>Represents a RDO_O01 message structure (see chapter 4.8.1). This structure contains the 
 * following elements: </p>
 * <ul>
		                 * <li>1: MSH (MSH - message header segment) <b> </b> </li>
		                 * <li>2: NTE (NTE - notes and comments segment) <b>optional repeating</b> </li>
		                 * <li>3: RDO_O01_PIDPD1NTEPV1PV2IN1IN2IN3GT1AL1 (a Group object) <b>optional </b> </li>
		                 * <li>4: RDO_O01_ORCRXONTERXRRXCNTEOBXNTEBLG (a Group object) <b> repeating</b> </li>
 * </ul>
 */
//@SuppressWarnings("unused")
public class RDO_O01 extends AbstractMessage  {

    /**
     * Creates a new RDO_O01 message with DefaultModelClassFactory. 
     */ 
    public RDO_O01() { 
       this(new DefaultModelClassFactory());
    }

    /** 
     * Creates a new RDO_O01 message with custom ModelClassFactory.
     */
    public RDO_O01(ModelClassFactory factory) {
       super(factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                          this.add(MSH.class, true, false);
	                          this.add(NTE.class, false, true);
	                          this.add(RDO_O01_PIDPD1NTEPV1PV2IN1IN2IN3GT1AL1.class, false, false);
	                          this.add(RDO_O01_ORCRXONTERXRRXCNTEOBXNTEBLG.class, true, true);
	       } catch(HL7Exception e) {
          log.error("Unexpected error creating RDO_O01 - this is probably a bug in the source code generator.", e);
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
    public RDO_O01_PIDPD1NTEPV1PV2IN1IN2IN3GT1AL1 getPIDPD1NTEPV1PV2IN1IN2IN3GT1AL1() { 
       return getTyped("PIDPD1NTEPV1PV2IN1IN2IN3GT1AL1", RDO_O01_PIDPD1NTEPV1PV2IN1IN2IN3GT1AL1.class);
    }





    /**
     * <p>
     * Returns
     * the first repetition of 
     * ORCRXONTERXRRXCNTEOBXNTEBLG (a Group object) - creates it if necessary
     * </p>
     * 
     *
     */
    public RDO_O01_ORCRXONTERXRRXCNTEOBXNTEBLG getORCRXONTERXRRXCNTEOBXNTEBLG() { 
       return getTyped("ORCRXONTERXRRXCNTEOBXNTEBLG", RDO_O01_ORCRXONTERXRRXCNTEOBXNTEBLG.class);
    }


    /**
     * <p>
     * Returns a specific repetition of
     * ORCRXONTERXRRXCNTEOBXNTEBLG (a Group object) - creates it if necessary
     * </p>
     * 
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public RDO_O01_ORCRXONTERXRRXCNTEOBXNTEBLG getORCRXONTERXRRXCNTEOBXNTEBLG(int rep) { 
       return getTyped("ORCRXONTERXRRXCNTEOBXNTEBLG", rep, RDO_O01_ORCRXONTERXRRXCNTEOBXNTEBLG.class);
    }

    /** 
     * <p>
     * Returns the number of existing repetitions of ORCRXONTERXRRXCNTEOBXNTEBLG 
     * </p>
     * 
     */ 
    public int getORCRXONTERXRRXCNTEOBXNTEBLGReps() { 
    	return getReps("ORCRXONTERXRRXCNTEOBXNTEBLG");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of ORCRXONTERXRRXCNTEOBXNTEBLG.
     * <p>
     * <p>
     * Note that unlike {@link #getORCRXONTERXRRXCNTEOBXNTEBLG()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     * 
     */ 
    public java.util.List<RDO_O01_ORCRXONTERXRRXCNTEOBXNTEBLG> getORCRXONTERXRRXCNTEOBXNTEBLGAll() throws HL7Exception {
    	return getAllAsList("ORCRXONTERXRRXCNTEOBXNTEBLG", RDO_O01_ORCRXONTERXRRXCNTEOBXNTEBLG.class);
    } 

    /**
     * <p>
     * Inserts a specific repetition of ORCRXONTERXRRXCNTEOBXNTEBLG (a Group object)
     * </p>
     * 
     *
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertORCRXONTERXRRXCNTEOBXNTEBLG(RDO_O01_ORCRXONTERXRRXCNTEOBXNTEBLG structure, int rep) throws HL7Exception { 
       super.insertRepetition( "ORCRXONTERXRRXCNTEOBXNTEBLG", structure, rep);
    }


    /**
     * <p>
     * Inserts a specific repetition of ORCRXONTERXRRXCNTEOBXNTEBLG (a Group object)
     * </p>
     * 
     *
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public RDO_O01_ORCRXONTERXRRXCNTEOBXNTEBLG insertORCRXONTERXRRXCNTEOBXNTEBLG(int rep) throws HL7Exception { 
       return (RDO_O01_ORCRXONTERXRRXCNTEOBXNTEBLG)super.insertRepetition("ORCRXONTERXRRXCNTEOBXNTEBLG", rep);
    }


    /**
     * <p>
     * Removes a specific repetition of ORCRXONTERXRRXCNTEOBXNTEBLG (a Group object)
     * </p>
     * 
     *
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public RDO_O01_ORCRXONTERXRRXCNTEOBXNTEBLG removeORCRXONTERXRRXCNTEOBXNTEBLG(int rep) throws HL7Exception { 
       return (RDO_O01_ORCRXONTERXRRXCNTEOBXNTEBLG)super.removeRepetition("ORCRXONTERXRRXCNTEOBXNTEBLG", rep);
    }



}

