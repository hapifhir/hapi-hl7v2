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
 * <p>Represents a INR_U06 message structure (see chapter 13). This structure contains the 
 * following elements: </p>
 * <ul>
		                 * <li>1: MSH (Message Header) <b> </b> </li>
		                 * <li>2: EQU (Equipment Detail) <b> </b> </li>
		                 * <li>3: INV (Inventory Detail) <b> repeating</b> </li>
		                 * <li>4: ROL (Role) <b>optional </b> </li>
 * </ul>
 */
//@SuppressWarnings("unused")
public class INR_U06 extends AbstractMessage  {

    /**
     * Creates a new INR_U06 message with DefaultModelClassFactory. 
     */ 
    public INR_U06() { 
       this(new DefaultModelClassFactory());
    }

    /** 
     * Creates a new INR_U06 message with custom ModelClassFactory.
     */
    public INR_U06(ModelClassFactory factory) {
       super(factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                          this.add(MSH.class, true, false);
	                          this.add(EQU.class, true, false);
	                          this.add(INV.class, true, true);
	                          this.add(ROL.class, false, false);
	       } catch(HL7Exception e) {
          log.error("Unexpected error creating INR_U06 - this is probably a bug in the source code generator.", e);
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
     * EQU (Equipment Detail) - creates it if necessary
     * </p>
     * 
     *
     */
    public EQU getEQU() { 
       return getTyped("EQU", EQU.class);
    }





    /**
     * <p>
     * Returns
     * the first repetition of 
     * INV (Inventory Detail) - creates it if necessary
     * </p>
     * 
     *
     */
    public INV getINV() { 
       return getTyped("INV", INV.class);
    }


    /**
     * <p>
     * Returns a specific repetition of
     * INV (Inventory Detail) - creates it if necessary
     * </p>
     * 
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public INV getINV(int rep) { 
       return getTyped("INV", rep, INV.class);
    }

    /** 
     * <p>
     * Returns the number of existing repetitions of INV 
     * </p>
     * 
     */ 
    public int getINVReps() { 
    	return getReps("INV");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of INV.
     * <p>
     * <p>
     * Note that unlike {@link #getINV()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     * 
     */ 
    public java.util.List<INV> getINVAll() throws HL7Exception {
    	return getAllAsList("INV", INV.class);
    } 

    /**
     * <p>
     * Inserts a specific repetition of INV (Inventory Detail)
     * </p>
     * 
     *
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertINV(INV structure, int rep) throws HL7Exception { 
       super.insertRepetition( "INV", structure, rep);
    }


    /**
     * <p>
     * Inserts a specific repetition of INV (Inventory Detail)
     * </p>
     * 
     *
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public INV insertINV(int rep) throws HL7Exception { 
       return (INV)super.insertRepetition("INV", rep);
    }


    /**
     * <p>
     * Removes a specific repetition of INV (Inventory Detail)
     * </p>
     * 
     *
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public INV removeINV(int rep) throws HL7Exception { 
       return (INV)super.removeRepetition("INV", rep);
    }




    /**
     * <p>
     * Returns
     * ROL (Role) - creates it if necessary
     * </p>
     * 
     *
     */
    public ROL getROL() { 
       return getTyped("ROL", ROL.class);
    }




}

