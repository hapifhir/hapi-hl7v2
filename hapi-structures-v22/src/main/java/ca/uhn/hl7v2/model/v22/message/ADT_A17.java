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


package ca.uhn.hl7v2.model.v22.message;

import ca.uhn.hl7v2.model.v22.group.*;
import ca.uhn.hl7v2.model.v22.segment.*;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.parser.DefaultModelClassFactory;
import ca.uhn.hl7v2.model.*;


/**
 * <p>Represents a ADT_A17 message structure (see chapter ?). This structure contains the 
 * following elements: </p>
 * <ul>
		                 * <li>1: MSH (MESSAGE HEADER) <b> </b> </li>
		                 * <li>2: EVN (EVENT TYPE) <b> </b> </li>
		                 * <li>3: PID (PATIENT IDENTIFICATION) <b> </b> </li>
		                 * <li>4: PV1 (PATIENT VISIT) <b> </b> </li>
		                 * <li>5: PV2 (PATIENT VISIT - additional information) <b>optional </b> </li>
		                 * <li>6: OBX (OBSERVATION RESULT) <b>optional repeating</b> </li>
		                 * <li>7: PID (PATIENT IDENTIFICATION) <b> </b> </li>
		                 * <li>8: PV1 (PATIENT VISIT) <b> </b> </li>
		                 * <li>9: PV2 (PATIENT VISIT - additional information) <b>optional </b> </li>
		                 * <li>10: OBX (OBSERVATION RESULT) <b>optional repeating</b> </li>
 * </ul>
 */
//@SuppressWarnings("unused")
public class ADT_A17 extends AbstractMessage  {

    /**
     * Creates a new ADT_A17 message with DefaultModelClassFactory. 
     */ 
    public ADT_A17() { 
       this(new DefaultModelClassFactory());
    }

    /** 
     * Creates a new ADT_A17 message with custom ModelClassFactory.
     */
    public ADT_A17(ModelClassFactory factory) {
       super(factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                          this.add(MSH.class, true, false);
	                          this.add(EVN.class, true, false);
	                          this.add(PID.class, true, false);
	                          this.add(PV1.class, true, false);
	                          this.add(PV2.class, false, false);
	                          this.add(OBX.class, false, true);
	                          this.add(PID.class, true, false);
	                          this.add(PV1.class, true, false);
	                          this.add(PV2.class, false, false);
	                          this.add(OBX.class, false, true);
	       } catch(HL7Exception e) {
          log.error("Unexpected error creating ADT_A17 - this is probably a bug in the source code generator.", e);
       }
    }


    /** 
     * Returns "2.2"
     */
    public String getVersion() {
       return "2.2";
    }




    /**
     * <p>
     * Returns
     * MSH (MESSAGE HEADER) - creates it if necessary
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
     * EVN (EVENT TYPE) - creates it if necessary
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
     * PID (PATIENT IDENTIFICATION) - creates it if necessary
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
     * PV1 (PATIENT VISIT) - creates it if necessary
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
     * PV2 (PATIENT VISIT - additional information) - creates it if necessary
     * </p>
     * 
     *
     */
    public PV2 getPV2() { 
       return getTyped("PV2", PV2.class);
    }





    /**
     * <p>
     * Returns
     * the first repetition of 
     * OBX (OBSERVATION RESULT) - creates it if necessary
     * </p>
     * 
     *
     */
    public OBX getOBX() { 
       return getTyped("OBX", OBX.class);
    }


    /**
     * <p>
     * Returns a specific repetition of
     * OBX (OBSERVATION RESULT) - creates it if necessary
     * </p>
     * 
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public OBX getOBX(int rep) { 
       return getTyped("OBX", rep, OBX.class);
    }

    /** 
     * <p>
     * Returns the number of existing repetitions of OBX 
     * </p>
     * 
     */ 
    public int getOBXReps() { 
    	return getReps("OBX");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of OBX.
     * <p>
     * <p>
     * Note that unlike {@link #getOBX()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     * 
     */ 
    public java.util.List<OBX> getOBXAll() throws HL7Exception {
    	return getAllAsList("OBX", OBX.class);
    } 

    /**
     * <p>
     * Inserts a specific repetition of OBX (OBSERVATION RESULT)
     * </p>
     * 
     *
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertOBX(OBX structure, int rep) throws HL7Exception { 
       super.insertRepetition( "OBX", structure, rep);
    }


    /**
     * <p>
     * Inserts a specific repetition of OBX (OBSERVATION RESULT)
     * </p>
     * 
     *
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public OBX insertOBX(int rep) throws HL7Exception { 
       return (OBX)super.insertRepetition("OBX", rep);
    }


    /**
     * <p>
     * Removes a specific repetition of OBX (OBSERVATION RESULT)
     * </p>
     * 
     *
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public OBX removeOBX(int rep) throws HL7Exception { 
       return (OBX)super.removeRepetition("OBX", rep);
    }




    /**
     * <p>
     * Returns
     * PID2 (PATIENT IDENTIFICATION) - creates it if necessary
     * </p>
     * 
     *
     */
    public PID getPID2() { 
       return getTyped("PID2", PID.class);
    }





    /**
     * <p>
     * Returns
     * PV12 (PATIENT VISIT) - creates it if necessary
     * </p>
     * 
     *
     */
    public PV1 getPV12() { 
       return getTyped("PV12", PV1.class);
    }





    /**
     * <p>
     * Returns
     * PV22 (PATIENT VISIT - additional information) - creates it if necessary
     * </p>
     * 
     *
     */
    public PV2 getPV22() { 
       return getTyped("PV22", PV2.class);
    }





    /**
     * <p>
     * Returns
     * the first repetition of 
     * OBX2 (OBSERVATION RESULT) - creates it if necessary
     * </p>
     * 
     *
     */
    public OBX getOBX2() { 
       return getTyped("OBX2", OBX.class);
    }


    /**
     * <p>
     * Returns a specific repetition of
     * OBX2 (OBSERVATION RESULT) - creates it if necessary
     * </p>
     * 
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public OBX getOBX2(int rep) { 
       return getTyped("OBX2", rep, OBX.class);
    }

    /** 
     * <p>
     * Returns the number of existing repetitions of OBX2 
     * </p>
     * 
     */ 
    public int getOBX2Reps() { 
    	return getReps("OBX2");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of OBX2.
     * <p>
     * <p>
     * Note that unlike {@link #getOBX2()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     * 
     */ 
    public java.util.List<OBX> getOBX2All() throws HL7Exception {
    	return getAllAsList("OBX2", OBX.class);
    } 

    /**
     * <p>
     * Inserts a specific repetition of OBX2 (OBSERVATION RESULT)
     * </p>
     * 
     *
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertOBX2(OBX structure, int rep) throws HL7Exception { 
       super.insertRepetition( "OBX2", structure, rep);
    }


    /**
     * <p>
     * Inserts a specific repetition of OBX2 (OBSERVATION RESULT)
     * </p>
     * 
     *
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public OBX insertOBX2(int rep) throws HL7Exception { 
       return (OBX)super.insertRepetition("OBX2", rep);
    }


    /**
     * <p>
     * Removes a specific repetition of OBX2 (OBSERVATION RESULT)
     * </p>
     * 
     *
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public OBX removeOBX2(int rep) throws HL7Exception { 
       return (OBX)super.removeRepetition("OBX2", rep);
    }



}

