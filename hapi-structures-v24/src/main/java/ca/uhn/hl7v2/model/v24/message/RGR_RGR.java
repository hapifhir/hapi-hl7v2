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
 * <p>Represents a RGR_RGR message structure (see chapter 4). This structure contains the 
 * following elements: </p>
 * <ul>
		                 * <li>1: MSH (Message Header) <b> </b> </li>
		                 * <li>2: MSA (Message Acknowledgment) <b> </b> </li>
		                 * <li>3: ERR (Error) <b>optional </b> </li>
		                 * <li>4: RGR_RGR_DEFINTION (a Group object) <b> repeating</b> </li>
		                 * <li>5: DSC (Continuation Pointer) <b>optional </b> </li>
 * </ul>
 */
//@SuppressWarnings("unused")
public class RGR_RGR extends AbstractMessage  {

    /**
     * Creates a new RGR_RGR message with DefaultModelClassFactory. 
     */ 
    public RGR_RGR() { 
       this(new DefaultModelClassFactory());
    }

    /** 
     * Creates a new RGR_RGR message with custom ModelClassFactory.
     */
    public RGR_RGR(ModelClassFactory factory) {
       super(factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                          this.add(MSH.class, true, false);
	                          this.add(MSA.class, true, false);
	                          this.add(ERR.class, false, false);
	                          this.add(RGR_RGR_DEFINTION.class, true, true);
	                          this.add(DSC.class, false, false);
	       } catch(HL7Exception e) {
          log.error("Unexpected error creating RGR_RGR - this is probably a bug in the source code generator.", e);
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
     * the first repetition of 
     * DEFINTION (a Group object) - creates it if necessary
     * </p>
     * 
     *
     */
    public RGR_RGR_DEFINTION getDEFINTION() { 
       return getTyped("DEFINTION", RGR_RGR_DEFINTION.class);
    }


    /**
     * <p>
     * Returns a specific repetition of
     * DEFINTION (a Group object) - creates it if necessary
     * </p>
     * 
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public RGR_RGR_DEFINTION getDEFINTION(int rep) { 
       return getTyped("DEFINTION", rep, RGR_RGR_DEFINTION.class);
    }

    /** 
     * <p>
     * Returns the number of existing repetitions of DEFINTION 
     * </p>
     * 
     */ 
    public int getDEFINTIONReps() { 
    	return getReps("DEFINTION");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of DEFINTION.
     * <p>
     * <p>
     * Note that unlike {@link #getDEFINTION()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     * 
     */ 
    public java.util.List<RGR_RGR_DEFINTION> getDEFINTIONAll() throws HL7Exception {
    	return getAllAsList("DEFINTION", RGR_RGR_DEFINTION.class);
    } 

    /**
     * <p>
     * Inserts a specific repetition of DEFINTION (a Group object)
     * </p>
     * 
     *
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertDEFINTION(RGR_RGR_DEFINTION structure, int rep) throws HL7Exception { 
       super.insertRepetition( "DEFINTION", structure, rep);
    }


    /**
     * <p>
     * Inserts a specific repetition of DEFINTION (a Group object)
     * </p>
     * 
     *
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public RGR_RGR_DEFINTION insertDEFINTION(int rep) throws HL7Exception { 
       return (RGR_RGR_DEFINTION)super.insertRepetition("DEFINTION", rep);
    }


    /**
     * <p>
     * Removes a specific repetition of DEFINTION (a Group object)
     * </p>
     * 
     *
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public RGR_RGR_DEFINTION removeDEFINTION(int rep) throws HL7Exception { 
       return (RGR_RGR_DEFINTION)super.removeRepetition("DEFINTION", rep);
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

