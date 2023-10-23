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
 * <p>Represents a NMR_N01 message structure (see chapter 14). This structure contains the 
 * following elements: </p>
 * <ul>
		                 * <li>1: MSH (Message Header) <b> </b> </li>
		                 * <li>2: MSA (Message Acknowledgment) <b> </b> </li>
		                 * <li>3: ERR (Error) <b>optional </b> </li>
		                 * <li>4: QRD (Original-Style Query Definition) <b>optional </b> </li>
		                 * <li>5: NMR_N01_CLOCK_AND_STATS_WITH_NOTES_ALT (a Group object) <b> repeating</b> </li>
 * </ul>
 */
//@SuppressWarnings("unused")
public class NMR_N01 extends AbstractMessage  {

    /**
     * Creates a new NMR_N01 message with DefaultModelClassFactory. 
     */ 
    public NMR_N01() { 
       this(new DefaultModelClassFactory());
    }

    /** 
     * Creates a new NMR_N01 message with custom ModelClassFactory.
     */
    public NMR_N01(ModelClassFactory factory) {
       super(factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                          this.add(MSH.class, true, false);
	                          this.add(MSA.class, true, false);
	                          this.add(ERR.class, false, false);
	                          this.add(QRD.class, false, false);
	                          this.add(NMR_N01_CLOCK_AND_STATS_WITH_NOTES_ALT.class, true, true);
	       } catch(HL7Exception e) {
          log.error("Unexpected error creating NMR_N01 - this is probably a bug in the source code generator.", e);
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
     * Returns
     * QRD (Original-Style Query Definition) - creates it if necessary
     * </p>
     * 
     *
     */
    public QRD getQRD() { 
       return getTyped("QRD", QRD.class);
    }





    /**
     * <p>
     * Returns
     * the first repetition of 
     * CLOCK_AND_STATS_WITH_NOTES_ALT (a Group object) - creates it if necessary
     * </p>
     * 
     *
     */
    public NMR_N01_CLOCK_AND_STATS_WITH_NOTES_ALT getCLOCK_AND_STATS_WITH_NOTES_ALT() { 
       return getTyped("CLOCK_AND_STATS_WITH_NOTES_ALT", NMR_N01_CLOCK_AND_STATS_WITH_NOTES_ALT.class);
    }


    /**
     * <p>
     * Returns a specific repetition of
     * CLOCK_AND_STATS_WITH_NOTES_ALT (a Group object) - creates it if necessary
     * </p>
     * 
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public NMR_N01_CLOCK_AND_STATS_WITH_NOTES_ALT getCLOCK_AND_STATS_WITH_NOTES_ALT(int rep) { 
       return getTyped("CLOCK_AND_STATS_WITH_NOTES_ALT", rep, NMR_N01_CLOCK_AND_STATS_WITH_NOTES_ALT.class);
    }

    /** 
     * <p>
     * Returns the number of existing repetitions of CLOCK_AND_STATS_WITH_NOTES_ALT 
     * </p>
     * 
     */ 
    public int getCLOCK_AND_STATS_WITH_NOTES_ALTReps() { 
    	return getReps("CLOCK_AND_STATS_WITH_NOTES_ALT");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of CLOCK_AND_STATS_WITH_NOTES_ALT.
     * <p>
     * <p>
     * Note that unlike {@link #getCLOCK_AND_STATS_WITH_NOTES_ALT()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     * 
     */ 
    public java.util.List<NMR_N01_CLOCK_AND_STATS_WITH_NOTES_ALT> getCLOCK_AND_STATS_WITH_NOTES_ALTAll() throws HL7Exception {
    	return getAllAsList("CLOCK_AND_STATS_WITH_NOTES_ALT", NMR_N01_CLOCK_AND_STATS_WITH_NOTES_ALT.class);
    } 

    /**
     * <p>
     * Inserts a specific repetition of CLOCK_AND_STATS_WITH_NOTES_ALT (a Group object)
     * </p>
     * 
     *
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertCLOCK_AND_STATS_WITH_NOTES_ALT(NMR_N01_CLOCK_AND_STATS_WITH_NOTES_ALT structure, int rep) throws HL7Exception { 
       super.insertRepetition( "CLOCK_AND_STATS_WITH_NOTES_ALT", structure, rep);
    }


    /**
     * <p>
     * Inserts a specific repetition of CLOCK_AND_STATS_WITH_NOTES_ALT (a Group object)
     * </p>
     * 
     *
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public NMR_N01_CLOCK_AND_STATS_WITH_NOTES_ALT insertCLOCK_AND_STATS_WITH_NOTES_ALT(int rep) throws HL7Exception { 
       return (NMR_N01_CLOCK_AND_STATS_WITH_NOTES_ALT)super.insertRepetition("CLOCK_AND_STATS_WITH_NOTES_ALT", rep);
    }


    /**
     * <p>
     * Removes a specific repetition of CLOCK_AND_STATS_WITH_NOTES_ALT (a Group object)
     * </p>
     * 
     *
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public NMR_N01_CLOCK_AND_STATS_WITH_NOTES_ALT removeCLOCK_AND_STATS_WITH_NOTES_ALT(int rep) throws HL7Exception { 
       return (NMR_N01_CLOCK_AND_STATS_WITH_NOTES_ALT)super.removeRepetition("CLOCK_AND_STATS_WITH_NOTES_ALT", rep);
    }



}

