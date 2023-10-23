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


package ca.uhn.hl7v2.model.v24.message;

import ca.uhn.hl7v2.model.v24.group.*;
import ca.uhn.hl7v2.model.v24.segment.*;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.parser.DefaultModelClassFactory;
import ca.uhn.hl7v2.model.*;


/**
 * <p>Represents a PEX_P07 message structure (see chapter 7). This structure contains the 
 * following elements: </p>
 * <ul>
		                 * <li>1: MSH (Message Header) <b> </b> </li>
		                 * <li>2: EVN (Event Type) <b> </b> </li>
		                 * <li>3: PID (Patient identification) <b> </b> </li>
		                 * <li>4: PD1 (patient additional demographic) <b>optional </b> </li>
		                 * <li>5: NTE (Notes and Comments) <b>optional repeating</b> </li>
		                 * <li>6: PEX_P07_VISIT (a Group object) <b>optional </b> </li>
		                 * <li>7: PEX_P07_EXPERIENCE (a Group object) <b> repeating</b> </li>
 * </ul>
 */
//@SuppressWarnings("unused")
public class PEX_P07 extends AbstractMessage  {

    /**
     * Creates a new PEX_P07 message with DefaultModelClassFactory. 
     */ 
    public PEX_P07() { 
       this(new DefaultModelClassFactory());
    }

    /** 
     * Creates a new PEX_P07 message with custom ModelClassFactory.
     */
    public PEX_P07(ModelClassFactory factory) {
       super(factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                          this.add(MSH.class, true, false);
	                          this.add(EVN.class, true, false);
	                          this.add(PID.class, true, false);
	                          this.add(PD1.class, false, false);
	                          this.add(NTE.class, false, true);
	                          this.add(PEX_P07_VISIT.class, false, false);
	                          this.add(PEX_P07_EXPERIENCE.class, true, true);
	       } catch(HL7Exception e) {
          log.error("Unexpected error creating PEX_P07 - this is probably a bug in the source code generator.", e);
       }
    }


    /** 
     * Returns "2.4"
     */
    public String getVersion() {
       return "2.4";
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
     * PID (Patient identification) - creates it if necessary
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
     * PD1 (patient additional demographic) - creates it if necessary
     * </p>
     * 
     *
     */
    public PD1 getPD1() { 
       return getTyped("PD1", PD1.class);
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




    /**
     * <p>
     * Returns
     * VISIT (a Group object) - creates it if necessary
     * </p>
     * 
     *
     */
    public PEX_P07_VISIT getVISIT() { 
       return getTyped("VISIT", PEX_P07_VISIT.class);
    }





    /**
     * <p>
     * Returns
     * the first repetition of 
     * EXPERIENCE (a Group object) - creates it if necessary
     * </p>
     * 
     *
     */
    public PEX_P07_EXPERIENCE getEXPERIENCE() { 
       return getTyped("EXPERIENCE", PEX_P07_EXPERIENCE.class);
    }


    /**
     * <p>
     * Returns a specific repetition of
     * EXPERIENCE (a Group object) - creates it if necessary
     * </p>
     * 
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public PEX_P07_EXPERIENCE getEXPERIENCE(int rep) { 
       return getTyped("EXPERIENCE", rep, PEX_P07_EXPERIENCE.class);
    }

    /** 
     * <p>
     * Returns the number of existing repetitions of EXPERIENCE 
     * </p>
     * 
     */ 
    public int getEXPERIENCEReps() { 
    	return getReps("EXPERIENCE");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of EXPERIENCE.
     * <p>
     * <p>
     * Note that unlike {@link #getEXPERIENCE()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     * 
     */ 
    public java.util.List<PEX_P07_EXPERIENCE> getEXPERIENCEAll() throws HL7Exception {
    	return getAllAsList("EXPERIENCE", PEX_P07_EXPERIENCE.class);
    } 

    /**
     * <p>
     * Inserts a specific repetition of EXPERIENCE (a Group object)
     * </p>
     * 
     *
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertEXPERIENCE(PEX_P07_EXPERIENCE structure, int rep) throws HL7Exception { 
       super.insertRepetition( "EXPERIENCE", structure, rep);
    }


    /**
     * <p>
     * Inserts a specific repetition of EXPERIENCE (a Group object)
     * </p>
     * 
     *
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public PEX_P07_EXPERIENCE insertEXPERIENCE(int rep) throws HL7Exception { 
       return (PEX_P07_EXPERIENCE)super.insertRepetition("EXPERIENCE", rep);
    }


    /**
     * <p>
     * Removes a specific repetition of EXPERIENCE (a Group object)
     * </p>
     * 
     *
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public PEX_P07_EXPERIENCE removeEXPERIENCE(int rep) throws HL7Exception { 
       return (PEX_P07_EXPERIENCE)super.removeRepetition("EXPERIENCE", rep);
    }



}

