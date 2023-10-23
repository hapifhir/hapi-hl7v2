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


package ca.uhn.hl7v2.model.v26.message;

import ca.uhn.hl7v2.model.v26.group.*;
import ca.uhn.hl7v2.model.v26.segment.*;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.parser.DefaultModelClassFactory;
import ca.uhn.hl7v2.model.*;


/**
 * <p>Represents a RDR_RDR message structure (see chapter 4.13.17). This structure contains the 
 * following elements: </p>
 * <ul>
		                 * <li>1: MSH (Message Header) <b> </b> </li>
		                 * <li>2: MSA (Message Acknowledgment) <b> </b> </li>
		                 * <li>3: ERR (Error) <b>optional repeating</b> </li>
		                 * <li>4: SFT (Software Segment) <b>optional repeating</b> </li>
		                 * <li>5: SFT (Software Segment) <b>optional </b> </li>
		                 * <li>6: UAC (User Authentication Credential Segment) <b>optional </b> </li>
		                 * <li>7: RDR_RDR_DEFINITION (a Group object) <b> repeating</b> </li>
		                 * <li>8: RXC (Pharmacy/Treatment Component Order) <b>optional repeating</b> </li>
		                 * <li>9: DSC (Continuation Pointer) <b>optional </b> </li>
		                 * <li>10: RXD (Pharmacy/Treatment Dispense) <b> </b> </li>
		                 * <li>11: RXR (Pharmacy/Treatment Route) <b> repeating</b> </li>
		                 * <li>12: RXC (Pharmacy/Treatment Component Order) <b>optional repeating</b> </li>
		                 * <li>13: DSC (Continuation Pointer) <b>optional </b> </li>
 * </ul>
 */
//@SuppressWarnings("unused")
public class RDR_RDR extends AbstractMessage  {

    /**
     * Creates a new RDR_RDR message with DefaultModelClassFactory. 
     */ 
    public RDR_RDR() { 
       this(new DefaultModelClassFactory());
    }

    /** 
     * Creates a new RDR_RDR message with custom ModelClassFactory.
     */
    public RDR_RDR(ModelClassFactory factory) {
       super(factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                          this.add(MSH.class, true, false);
	                          this.add(MSA.class, true, false);
	                          this.add(ERR.class, false, true);
	                          this.add(SFT.class, false, true);
	                          this.add(SFT.class, false, false);
	                          this.add(UAC.class, false, false);
	                          this.add(RDR_RDR_DEFINITION.class, true, true);
	                          this.add(RXC.class, false, true);
	                          this.add(DSC.class, false, false);
	                          this.add(RXD.class, true, false);
	                          this.add(RXR.class, true, true);
	                          this.add(RXC.class, false, true);
	                          this.add(DSC.class, false, false);
	       } catch(HL7Exception e) {
          log.error("Unexpected error creating RDR_RDR - this is probably a bug in the source code generator.", e);
       }
    }


    /** 
     * Returns "2.6"
     */
    public String getVersion() {
       return "2.6";
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
     * the first repetition of 
     * SFT (Software Segment) - creates it if necessary
     * </p>
     * 
     *
     */
    public SFT getSFT() { 
       return getTyped("SFT", SFT.class);
    }


    /**
     * <p>
     * Returns a specific repetition of
     * SFT (Software Segment) - creates it if necessary
     * </p>
     * 
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public SFT getSFT(int rep) { 
       return getTyped("SFT", rep, SFT.class);
    }

    /** 
     * <p>
     * Returns the number of existing repetitions of SFT 
     * </p>
     * 
     */ 
    public int getSFTReps() { 
    	return getReps("SFT");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of SFT.
     * <p>
     * <p>
     * Note that unlike {@link #getSFT()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     * 
     */ 
    public java.util.List<SFT> getSFTAll() throws HL7Exception {
    	return getAllAsList("SFT", SFT.class);
    } 

    /**
     * <p>
     * Inserts a specific repetition of SFT (Software Segment)
     * </p>
     * 
     *
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertSFT(SFT structure, int rep) throws HL7Exception { 
       super.insertRepetition( "SFT", structure, rep);
    }


    /**
     * <p>
     * Inserts a specific repetition of SFT (Software Segment)
     * </p>
     * 
     *
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public SFT insertSFT(int rep) throws HL7Exception { 
       return (SFT)super.insertRepetition("SFT", rep);
    }


    /**
     * <p>
     * Removes a specific repetition of SFT (Software Segment)
     * </p>
     * 
     *
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public SFT removeSFT(int rep) throws HL7Exception { 
       return (SFT)super.removeRepetition("SFT", rep);
    }




    /**
     * <p>
     * Returns
     * SFT2 (Software Segment) - creates it if necessary
     * </p>
     * 
     *
     */
    public SFT getSFT2() { 
       return getTyped("SFT2", SFT.class);
    }





    /**
     * <p>
     * Returns
     * UAC (User Authentication Credential Segment) - creates it if necessary
     * </p>
     * 
     *
     */
    public UAC getUAC() { 
       return getTyped("UAC", UAC.class);
    }





    /**
     * <p>
     * Returns
     * the first repetition of 
     * DEFINITION (a Group object) - creates it if necessary
     * </p>
     * 
     *
     */
    public RDR_RDR_DEFINITION getDEFINITION() { 
       return getTyped("DEFINITION", RDR_RDR_DEFINITION.class);
    }


    /**
     * <p>
     * Returns a specific repetition of
     * DEFINITION (a Group object) - creates it if necessary
     * </p>
     * 
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public RDR_RDR_DEFINITION getDEFINITION(int rep) { 
       return getTyped("DEFINITION", rep, RDR_RDR_DEFINITION.class);
    }

    /** 
     * <p>
     * Returns the number of existing repetitions of DEFINITION 
     * </p>
     * 
     */ 
    public int getDEFINITIONReps() { 
    	return getReps("DEFINITION");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of DEFINITION.
     * <p>
     * <p>
     * Note that unlike {@link #getDEFINITION()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     * 
     */ 
    public java.util.List<RDR_RDR_DEFINITION> getDEFINITIONAll() throws HL7Exception {
    	return getAllAsList("DEFINITION", RDR_RDR_DEFINITION.class);
    } 

    /**
     * <p>
     * Inserts a specific repetition of DEFINITION (a Group object)
     * </p>
     * 
     *
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertDEFINITION(RDR_RDR_DEFINITION structure, int rep) throws HL7Exception { 
       super.insertRepetition( "DEFINITION", structure, rep);
    }


    /**
     * <p>
     * Inserts a specific repetition of DEFINITION (a Group object)
     * </p>
     * 
     *
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public RDR_RDR_DEFINITION insertDEFINITION(int rep) throws HL7Exception { 
       return (RDR_RDR_DEFINITION)super.insertRepetition("DEFINITION", rep);
    }


    /**
     * <p>
     * Removes a specific repetition of DEFINITION (a Group object)
     * </p>
     * 
     *
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public RDR_RDR_DEFINITION removeDEFINITION(int rep) throws HL7Exception { 
       return (RDR_RDR_DEFINITION)super.removeRepetition("DEFINITION", rep);
    }




    /**
     * <p>
     * Returns
     * the first repetition of 
     * RXC (Pharmacy/Treatment Component Order) - creates it if necessary
     * </p>
     * 
     *
     */
    public RXC getRXC() { 
       return getTyped("RXC", RXC.class);
    }


    /**
     * <p>
     * Returns a specific repetition of
     * RXC (Pharmacy/Treatment Component Order) - creates it if necessary
     * </p>
     * 
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public RXC getRXC(int rep) { 
       return getTyped("RXC", rep, RXC.class);
    }

    /** 
     * <p>
     * Returns the number of existing repetitions of RXC 
     * </p>
     * 
     */ 
    public int getRXCReps() { 
    	return getReps("RXC");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of RXC.
     * <p>
     * <p>
     * Note that unlike {@link #getRXC()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     * 
     */ 
    public java.util.List<RXC> getRXCAll() throws HL7Exception {
    	return getAllAsList("RXC", RXC.class);
    } 

    /**
     * <p>
     * Inserts a specific repetition of RXC (Pharmacy/Treatment Component Order)
     * </p>
     * 
     *
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertRXC(RXC structure, int rep) throws HL7Exception { 
       super.insertRepetition( "RXC", structure, rep);
    }


    /**
     * <p>
     * Inserts a specific repetition of RXC (Pharmacy/Treatment Component Order)
     * </p>
     * 
     *
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public RXC insertRXC(int rep) throws HL7Exception { 
       return (RXC)super.insertRepetition("RXC", rep);
    }


    /**
     * <p>
     * Removes a specific repetition of RXC (Pharmacy/Treatment Component Order)
     * </p>
     * 
     *
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public RXC removeRXC(int rep) throws HL7Exception { 
       return (RXC)super.removeRepetition("RXC", rep);
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





    /**
     * <p>
     * Returns
     * RXD (Pharmacy/Treatment Dispense) - creates it if necessary
     * </p>
     * 
     *
     */
    public RXD getRXD() { 
       return getTyped("RXD", RXD.class);
    }





    /**
     * <p>
     * Returns
     * the first repetition of 
     * RXR (Pharmacy/Treatment Route) - creates it if necessary
     * </p>
     * 
     *
     */
    public RXR getRXR() { 
       return getTyped("RXR", RXR.class);
    }


    /**
     * <p>
     * Returns a specific repetition of
     * RXR (Pharmacy/Treatment Route) - creates it if necessary
     * </p>
     * 
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public RXR getRXR(int rep) { 
       return getTyped("RXR", rep, RXR.class);
    }

    /** 
     * <p>
     * Returns the number of existing repetitions of RXR 
     * </p>
     * 
     */ 
    public int getRXRReps() { 
    	return getReps("RXR");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of RXR.
     * <p>
     * <p>
     * Note that unlike {@link #getRXR()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     * 
     */ 
    public java.util.List<RXR> getRXRAll() throws HL7Exception {
    	return getAllAsList("RXR", RXR.class);
    } 

    /**
     * <p>
     * Inserts a specific repetition of RXR (Pharmacy/Treatment Route)
     * </p>
     * 
     *
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertRXR(RXR structure, int rep) throws HL7Exception { 
       super.insertRepetition( "RXR", structure, rep);
    }


    /**
     * <p>
     * Inserts a specific repetition of RXR (Pharmacy/Treatment Route)
     * </p>
     * 
     *
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public RXR insertRXR(int rep) throws HL7Exception { 
       return (RXR)super.insertRepetition("RXR", rep);
    }


    /**
     * <p>
     * Removes a specific repetition of RXR (Pharmacy/Treatment Route)
     * </p>
     * 
     *
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public RXR removeRXR(int rep) throws HL7Exception { 
       return (RXR)super.removeRepetition("RXR", rep);
    }




    /**
     * <p>
     * Returns
     * the first repetition of 
     * RXC2 (Pharmacy/Treatment Component Order) - creates it if necessary
     * </p>
     * 
     *
     */
    public RXC getRXC2() { 
       return getTyped("RXC2", RXC.class);
    }


    /**
     * <p>
     * Returns a specific repetition of
     * RXC2 (Pharmacy/Treatment Component Order) - creates it if necessary
     * </p>
     * 
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public RXC getRXC2(int rep) { 
       return getTyped("RXC2", rep, RXC.class);
    }

    /** 
     * <p>
     * Returns the number of existing repetitions of RXC2 
     * </p>
     * 
     */ 
    public int getRXC2Reps() { 
    	return getReps("RXC2");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of RXC2.
     * <p>
     * <p>
     * Note that unlike {@link #getRXC2()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     * 
     */ 
    public java.util.List<RXC> getRXC2All() throws HL7Exception {
    	return getAllAsList("RXC2", RXC.class);
    } 

    /**
     * <p>
     * Inserts a specific repetition of RXC2 (Pharmacy/Treatment Component Order)
     * </p>
     * 
     *
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertRXC2(RXC structure, int rep) throws HL7Exception { 
       super.insertRepetition( "RXC2", structure, rep);
    }


    /**
     * <p>
     * Inserts a specific repetition of RXC2 (Pharmacy/Treatment Component Order)
     * </p>
     * 
     *
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public RXC insertRXC2(int rep) throws HL7Exception { 
       return (RXC)super.insertRepetition("RXC2", rep);
    }


    /**
     * <p>
     * Removes a specific repetition of RXC2 (Pharmacy/Treatment Component Order)
     * </p>
     * 
     *
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public RXC removeRXC2(int rep) throws HL7Exception { 
       return (RXC)super.removeRepetition("RXC2", rep);
    }




    /**
     * <p>
     * Returns
     * DSC2 (Continuation Pointer) - creates it if necessary
     * </p>
     * 
     *
     */
    public DSC getDSC2() { 
       return getTyped("DSC2", DSC.class);
    }




}

