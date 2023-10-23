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
 * <p>Represents a PMU_B04 message structure (see chapter 15). This structure contains the 
 * following elements: </p>
 * <ul>
		                 * <li>1: MSH (Message Header) <b> </b> </li>
		                 * <li>2: EVN (Event Type) <b> </b> </li>
		                 * <li>3: STF (Staff Identification) <b> </b> </li>
		                 * <li>4: PRA (Practitioner Detail) <b>optional repeating</b> </li>
		                 * <li>5: ORG (Practitioner Organization Unit) <b>optional </b> </li>
 * </ul>
 */
//@SuppressWarnings("unused")
public class PMU_B04 extends AbstractMessage  {

    /**
     * Creates a new PMU_B04 message with DefaultModelClassFactory. 
     */ 
    public PMU_B04() { 
       this(new DefaultModelClassFactory());
    }

    /** 
     * Creates a new PMU_B04 message with custom ModelClassFactory.
     */
    public PMU_B04(ModelClassFactory factory) {
       super(factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                          this.add(MSH.class, true, false);
	                          this.add(EVN.class, true, false);
	                          this.add(STF.class, true, false);
	                          this.add(PRA.class, false, true);
	                          this.add(ORG.class, false, false);
	       } catch(HL7Exception e) {
          log.error("Unexpected error creating PMU_B04 - this is probably a bug in the source code generator.", e);
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
     * STF (Staff Identification) - creates it if necessary
     * </p>
     * 
     *
     */
    public STF getSTF() { 
       return getTyped("STF", STF.class);
    }





    /**
     * <p>
     * Returns
     * the first repetition of 
     * PRA (Practitioner Detail) - creates it if necessary
     * </p>
     * 
     *
     */
    public PRA getPRA() { 
       return getTyped("PRA", PRA.class);
    }


    /**
     * <p>
     * Returns a specific repetition of
     * PRA (Practitioner Detail) - creates it if necessary
     * </p>
     * 
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public PRA getPRA(int rep) { 
       return getTyped("PRA", rep, PRA.class);
    }

    /** 
     * <p>
     * Returns the number of existing repetitions of PRA 
     * </p>
     * 
     */ 
    public int getPRAReps() { 
    	return getReps("PRA");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of PRA.
     * <p>
     * <p>
     * Note that unlike {@link #getPRA()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     * 
     */ 
    public java.util.List<PRA> getPRAAll() throws HL7Exception {
    	return getAllAsList("PRA", PRA.class);
    } 

    /**
     * <p>
     * Inserts a specific repetition of PRA (Practitioner Detail)
     * </p>
     * 
     *
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertPRA(PRA structure, int rep) throws HL7Exception { 
       super.insertRepetition( "PRA", structure, rep);
    }


    /**
     * <p>
     * Inserts a specific repetition of PRA (Practitioner Detail)
     * </p>
     * 
     *
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public PRA insertPRA(int rep) throws HL7Exception { 
       return (PRA)super.insertRepetition("PRA", rep);
    }


    /**
     * <p>
     * Removes a specific repetition of PRA (Practitioner Detail)
     * </p>
     * 
     *
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public PRA removePRA(int rep) throws HL7Exception { 
       return (PRA)super.removeRepetition("PRA", rep);
    }




    /**
     * <p>
     * Returns
     * ORG (Practitioner Organization Unit) - creates it if necessary
     * </p>
     * 
     *
     */
    public ORG getORG() { 
       return getTyped("ORG", ORG.class);
    }




}

