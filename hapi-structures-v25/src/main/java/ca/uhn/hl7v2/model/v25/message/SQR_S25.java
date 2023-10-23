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
 * <p>Represents a SQR_S25 message structure (see chapter 10.5.3). This structure contains the 
 * following elements: </p>
 * <ul>
		                 * <li>1: MSH (Message Header) <b> </b> </li>
		                 * <li>2: MSA (Message Acknowledgment) <b> </b> </li>
		                 * <li>3: ERR (Error) <b>optional repeating</b> </li>
		                 * <li>4: QAK (Query Acknowledgment) <b> </b> </li>
		                 * <li>5: SQR_S25_SCHEDULE (a Group object) <b>optional repeating</b> </li>
		                 * <li>6: DSC (Continuation Pointer) <b>optional </b> </li>
 * </ul>
 */
//@SuppressWarnings("unused")
public class SQR_S25 extends AbstractMessage  {

    /**
     * Creates a new SQR_S25 message with DefaultModelClassFactory. 
     */ 
    public SQR_S25() { 
       this(new DefaultModelClassFactory());
    }

    /** 
     * Creates a new SQR_S25 message with custom ModelClassFactory.
     */
    public SQR_S25(ModelClassFactory factory) {
       super(factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                          this.add(MSH.class, true, false);
	                          this.add(MSA.class, true, false);
	                          this.add(ERR.class, false, true);
	                          this.add(QAK.class, true, false);
	                          this.add(SQR_S25_SCHEDULE.class, false, true);
	                          this.add(DSC.class, false, false);
	       } catch(HL7Exception e) {
          log.error("Unexpected error creating SQR_S25 - this is probably a bug in the source code generator.", e);
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
     * QAK (Query Acknowledgment) - creates it if necessary
     * </p>
     * 
     *
     */
    public QAK getQAK() { 
       return getTyped("QAK", QAK.class);
    }





    /**
     * <p>
     * Returns
     * the first repetition of 
     * SCHEDULE (a Group object) - creates it if necessary
     * </p>
     * 
     *
     */
    public SQR_S25_SCHEDULE getSCHEDULE() { 
       return getTyped("SCHEDULE", SQR_S25_SCHEDULE.class);
    }


    /**
     * <p>
     * Returns a specific repetition of
     * SCHEDULE (a Group object) - creates it if necessary
     * </p>
     * 
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public SQR_S25_SCHEDULE getSCHEDULE(int rep) { 
       return getTyped("SCHEDULE", rep, SQR_S25_SCHEDULE.class);
    }

    /** 
     * <p>
     * Returns the number of existing repetitions of SCHEDULE 
     * </p>
     * 
     */ 
    public int getSCHEDULEReps() { 
    	return getReps("SCHEDULE");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of SCHEDULE.
     * <p>
     * <p>
     * Note that unlike {@link #getSCHEDULE()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     * 
     */ 
    public java.util.List<SQR_S25_SCHEDULE> getSCHEDULEAll() throws HL7Exception {
    	return getAllAsList("SCHEDULE", SQR_S25_SCHEDULE.class);
    } 

    /**
     * <p>
     * Inserts a specific repetition of SCHEDULE (a Group object)
     * </p>
     * 
     *
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertSCHEDULE(SQR_S25_SCHEDULE structure, int rep) throws HL7Exception { 
       super.insertRepetition( "SCHEDULE", structure, rep);
    }


    /**
     * <p>
     * Inserts a specific repetition of SCHEDULE (a Group object)
     * </p>
     * 
     *
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public SQR_S25_SCHEDULE insertSCHEDULE(int rep) throws HL7Exception { 
       return (SQR_S25_SCHEDULE)super.insertRepetition("SCHEDULE", rep);
    }


    /**
     * <p>
     * Removes a specific repetition of SCHEDULE (a Group object)
     * </p>
     * 
     *
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public SQR_S25_SCHEDULE removeSCHEDULE(int rep) throws HL7Exception { 
       return (SQR_S25_SCHEDULE)super.removeRepetition("SCHEDULE", rep);
    }




    /**
     * <p>
     * Returns
     * DSC (Continuation Pointer) - creates it if necessary
     * </p>
     * 
     *
     */
    public DSC getDSC() { 
       return getTyped("DSC", DSC.class);
    }




}

