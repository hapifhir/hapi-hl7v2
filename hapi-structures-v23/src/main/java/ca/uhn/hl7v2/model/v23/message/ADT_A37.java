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


package ca.uhn.hl7v2.model.v23.message;

import ca.uhn.hl7v2.model.v23.group.*;
import ca.uhn.hl7v2.model.v23.segment.*;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.parser.DefaultModelClassFactory;
import ca.uhn.hl7v2.model.*;


/**
 * <p>Represents a ADT_A37 message structure (see chapter ?). This structure contains the 
 * following elements: </p>
 * <ul>
		                 * <li>1: MSH (Message header segment) <b> </b> </li>
		                 * <li>2: EVN (Event type) <b> </b> </li>
		                 * <li>3: PID (Patient Identification) <b> </b> </li>
		                 * <li>4: PD1 (Patient Demographic) <b>optional </b> </li>
		                 * <li>5: PV1 (Patient visit) <b>optional </b> </li>
		                 * <li>6: DB1 (Disability Segment) <b>optional repeating</b> </li>
		                 * <li>7: PID (Patient Identification) <b> </b> </li>
		                 * <li>8: PV1 (Patient visit) <b>optional </b> </li>
		                 * <li>9: DB1 (Disability Segment) <b>optional repeating</b> </li>
 * </ul>
 */
//@SuppressWarnings("unused")
public class ADT_A37 extends AbstractMessage  {

    /**
     * Creates a new ADT_A37 message with DefaultModelClassFactory. 
     */ 
    public ADT_A37() { 
       this(new DefaultModelClassFactory());
    }

    /** 
     * Creates a new ADT_A37 message with custom ModelClassFactory.
     */
    public ADT_A37(ModelClassFactory factory) {
       super(factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                          this.add(MSH.class, true, false);
	                          this.add(EVN.class, true, false);
	                          this.add(PID.class, true, false);
	                          this.add(PD1.class, false, false);
	                          this.add(PV1.class, false, false);
	                          this.add(DB1.class, false, true);
	                          this.add(PID.class, true, false);
	                          this.add(PV1.class, false, false);
	                          this.add(DB1.class, false, true);
	       } catch(HL7Exception e) {
          log.error("Unexpected error creating ADT_A37 - this is probably a bug in the source code generator.", e);
       }
    }


    /** 
     * Returns "2.3"
     */
    public String getVersion() {
       return "2.3";
    }




    /**
     * <p>
     * Returns
     * MSH (Message header segment) - creates it if necessary
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
     * EVN (Event type) - creates it if necessary
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
     * PID (Patient Identification) - creates it if necessary
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
     * PD1 (Patient Demographic) - creates it if necessary
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
     * PV1 (Patient visit) - creates it if necessary
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
     * the first repetition of 
     * DB1 (Disability Segment) - creates it if necessary
     * </p>
     * 
     *
     */
    public DB1 getDB1() { 
       return getTyped("DB1", DB1.class);
    }


    /**
     * <p>
     * Returns a specific repetition of
     * DB1 (Disability Segment) - creates it if necessary
     * </p>
     * 
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public DB1 getDB1(int rep) { 
       return getTyped("DB1", rep, DB1.class);
    }

    /** 
     * <p>
     * Returns the number of existing repetitions of DB1 
     * </p>
     * 
     */ 
    public int getDB1Reps() { 
    	return getReps("DB1");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of DB1.
     * <p>
     * <p>
     * Note that unlike {@link #getDB1()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     * 
     */ 
    public java.util.List<DB1> getDB1All() throws HL7Exception {
    	return getAllAsList("DB1", DB1.class);
    } 

    /**
     * <p>
     * Inserts a specific repetition of DB1 (Disability Segment)
     * </p>
     * 
     *
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertDB1(DB1 structure, int rep) throws HL7Exception { 
       super.insertRepetition( "DB1", structure, rep);
    }


    /**
     * <p>
     * Inserts a specific repetition of DB1 (Disability Segment)
     * </p>
     * 
     *
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public DB1 insertDB1(int rep) throws HL7Exception { 
       return (DB1)super.insertRepetition("DB1", rep);
    }


    /**
     * <p>
     * Removes a specific repetition of DB1 (Disability Segment)
     * </p>
     * 
     *
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public DB1 removeDB1(int rep) throws HL7Exception { 
       return (DB1)super.removeRepetition("DB1", rep);
    }




    /**
     * <p>
     * Returns
     * PID2 (Patient Identification) - creates it if necessary
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
     * PV12 (Patient visit) - creates it if necessary
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
     * the first repetition of 
     * DB12 (Disability Segment) - creates it if necessary
     * </p>
     * 
     *
     */
    public DB1 getDB12() { 
       return getTyped("DB12", DB1.class);
    }


    /**
     * <p>
     * Returns a specific repetition of
     * DB12 (Disability Segment) - creates it if necessary
     * </p>
     * 
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public DB1 getDB12(int rep) { 
       return getTyped("DB12", rep, DB1.class);
    }

    /** 
     * <p>
     * Returns the number of existing repetitions of DB12 
     * </p>
     * 
     */ 
    public int getDB12Reps() { 
    	return getReps("DB12");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of DB12.
     * <p>
     * <p>
     * Note that unlike {@link #getDB12()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     * 
     */ 
    public java.util.List<DB1> getDB12All() throws HL7Exception {
    	return getAllAsList("DB12", DB1.class);
    } 

    /**
     * <p>
     * Inserts a specific repetition of DB12 (Disability Segment)
     * </p>
     * 
     *
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertDB12(DB1 structure, int rep) throws HL7Exception { 
       super.insertRepetition( "DB12", structure, rep);
    }


    /**
     * <p>
     * Inserts a specific repetition of DB12 (Disability Segment)
     * </p>
     * 
     *
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public DB1 insertDB12(int rep) throws HL7Exception { 
       return (DB1)super.insertRepetition("DB12", rep);
    }


    /**
     * <p>
     * Removes a specific repetition of DB12 (Disability Segment)
     * </p>
     * 
     *
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public DB1 removeDB12(int rep) throws HL7Exception { 
       return (DB1)super.removeRepetition("DB12", rep);
    }



}

