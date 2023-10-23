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


package ca.uhn.hl7v2.model.v231.group;

import ca.uhn.hl7v2.model.v231.segment.*;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.model.*;

/**
 * <p>Represents a ORM_O01_ORCOBRRQDRQ1ODSODTRXONTEDG1RXRRXCNTEOBXNTECTIBLG group structure (a Group object).
 * A Group is an ordered collection of message segments that can repeat together or be optionally in/excluded together.
 * This Group contains the following elements:  
 * </p>
 * <ul>
                         * <li>1: ORC (ORC - common order segment) <b>  </b></li>
                         * <li>2: ORM_O01_OBRRQDRQ1ODSODTRXONTEDG1RXRRXCNTEOBXNTE (a Group object) <b>optional  </b></li>
                         * <li>3: CTI (CTI - clinical trial identification segment) <b>optional repeating </b></li>
                         * <li>4: BLG (BLG - billing segment) <b>optional  </b></li>
 * </ul>
 */
//@SuppressWarnings("unused")
public class ORM_O01_ORCOBRRQDRQ1ODSODTRXONTEDG1RXRRXCNTEOBXNTECTIBLG extends AbstractGroup {

    /** 
     * Creates a new ORM_O01_ORCOBRRQDRQ1ODSODTRXONTEDG1RXRRXCNTEOBXNTECTIBLG group
     */
    public ORM_O01_ORCOBRRQDRQ1ODSODTRXONTEDG1RXRRXCNTEOBXNTECTIBLG(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(ORC.class, true, false, false);
                                  this.add(ORM_O01_OBRRQDRQ1ODSODTRXONTEDG1RXRRXCNTEOBXNTE.class, false, false, false);
                                  this.add(CTI.class, false, true, false);
                                  this.add(BLG.class, false, false, false);
       } catch(HL7Exception e) {
          log.error("Unexpected error creating ORM_O01_ORCOBRRQDRQ1ODSODTRXONTEDG1RXRRXCNTEOBXNTECTIBLG - this is probably a bug in the source code generator.", e);
       }
    }

    /** 
     * Returns "2.3.1"
     */
    public String getVersion() {
       return "2.3.1";
    }



    /**
     * Returns
     * ORC (ORC - common order segment) - creates it if necessary
     */
    public ORC getORC() { 
       ORC retVal = getTyped("ORC", ORC.class);
       return retVal;
    }




    /**
     * Returns
     * OBRRQDRQ1ODSODTRXONTEDG1RXRRXCNTEOBXNTE (a Group object) - creates it if necessary
     */
    public ORM_O01_OBRRQDRQ1ODSODTRXONTEDG1RXRRXCNTEOBXNTE getOBRRQDRQ1ODSODTRXONTEDG1RXRRXCNTEOBXNTE() { 
       ORM_O01_OBRRQDRQ1ODSODTRXONTEDG1RXRRXCNTEOBXNTE retVal = getTyped("OBRRQDRQ1ODSODTRXONTEDG1RXRRXCNTEOBXNTE", ORM_O01_OBRRQDRQ1ODSODTRXONTEDG1RXRRXCNTEOBXNTE.class);
       return retVal;
    }




    /**
     * Returns
     * the first repetition of 
     * CTI (CTI - clinical trial identification segment) - creates it if necessary
     */
    public CTI getCTI() { 
       CTI retVal = getTyped("CTI", CTI.class);
       return retVal;
    }


    /**
     * Returns a specific repetition of
     * CTI (CTI - clinical trial identification segment) - creates it if necessary
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public CTI getCTI(int rep) { 
       CTI retVal = getTyped("CTI", rep, CTI.class);
       return retVal;
    }

    /** 
     * Returns the number of existing repetitions of CTI 
     */ 
    public int getCTIReps() {  
        return getReps("CTI");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of CTI.
     * <p>
     * <p>
     * Note that unlike {@link #getCTI()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     */ 
    public java.util.List<CTI> getCTIAll() throws HL7Exception {
    	return getAllAsList("CTI", CTI.class);
    } 

    /**
     * Inserts a specific repetition of CTI (CTI - clinical trial identification segment)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertCTI(CTI structure, int rep) throws HL7Exception { 
       super.insertRepetition("CTI", structure, rep);
    }


    /**
     * Inserts a specific repetition of CTI (CTI - clinical trial identification segment)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public CTI insertCTI(int rep) throws HL7Exception { 
       return (CTI)super.insertRepetition("CTI", rep);
    }


    /**
     * Removes a specific repetition of CTI (CTI - clinical trial identification segment)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public CTI removeCTI(int rep) throws HL7Exception { 
       return (CTI)super.removeRepetition("CTI", rep);
    }



    /**
     * Returns
     * BLG (BLG - billing segment) - creates it if necessary
     */
    public BLG getBLG() { 
       BLG retVal = getTyped("BLG", BLG.class);
       return retVal;
    }




}

