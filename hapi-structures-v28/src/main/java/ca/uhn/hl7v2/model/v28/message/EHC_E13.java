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


package ca.uhn.hl7v2.model.v28.message;

import ca.uhn.hl7v2.model.v28.group.*;
import ca.uhn.hl7v2.model.v28.segment.*;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.parser.DefaultModelClassFactory;
import ca.uhn.hl7v2.model.*;


/**
 * <p>Represents a EHC_E13 message structure (see chapter 16.3.8). This structure contains the 
 * following elements: </p>
 * <ul>
		                 * <li>1: MSH (Message Header) <b> </b> </li>
		                 * <li>2: SFT (Software Segment) <b>optional repeating</b> </li>
		                 * <li>3: UAC (User Authentication Credential Segment) <b>optional repeating</b> </li>
		                 * <li>4: MSA (Message Acknowledgment) <b> </b> </li>
		                 * <li>5: ERR (Error) <b>optional repeating</b> </li>
		                 * <li>6: RFI (Request for Information) <b> </b> </li>
		                 * <li>7: CTD (Contact Data) <b>optional repeating</b> </li>
		                 * <li>8: IVC (Invoice Segment) <b> </b> </li>
		                 * <li>9: PSS (Product/Service Section) <b> </b> </li>
		                 * <li>10: PSG (Product/Service Group) <b> </b> </li>
		                 * <li>11: PID (Patient Identification) <b>optional </b> </li>
		                 * <li>12: PSL (Product/Service Line Item) <b>optional </b> </li>
		                 * <li>13: EHC_E13_REQUEST (a Group object) <b> repeating</b> </li>
 * </ul>
 */
//@SuppressWarnings("unused")
public class EHC_E13 extends AbstractMessage  {

    /**
     * Creates a new EHC_E13 message with DefaultModelClassFactory. 
     */ 
    public EHC_E13() { 
       this(new DefaultModelClassFactory());
    }

    /** 
     * Creates a new EHC_E13 message with custom ModelClassFactory.
     */
    public EHC_E13(ModelClassFactory factory) {
       super(factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                          this.add(MSH.class, true, false);
	                          this.add(SFT.class, false, true);
	                          this.add(UAC.class, false, true);
	                          this.add(MSA.class, true, false);
	                          this.add(ERR.class, false, true);
	                          this.add(RFI.class, true, false);
	                          this.add(CTD.class, false, true);
	                          this.add(IVC.class, true, false);
	                          this.add(PSS.class, true, false);
	                          this.add(PSG.class, true, false);
	                          this.add(PID.class, false, false);
	                          this.add(PSL.class, false, false);
	                          this.add(EHC_E13_REQUEST.class, true, true);
	       } catch(HL7Exception e) {
          log.error("Unexpected error creating EHC_E13 - this is probably a bug in the source code generator.", e);
       }
    }


    /** 
     * Returns "2.8"
     */
    public String getVersion() {
       return "2.8";
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
     * the first repetition of 
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
     * Returns a specific repetition of
     * UAC (User Authentication Credential Segment) - creates it if necessary
     * </p>
     * 
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public UAC getUAC(int rep) { 
       return getTyped("UAC", rep, UAC.class);
    }

    /** 
     * <p>
     * Returns the number of existing repetitions of UAC 
     * </p>
     * 
     */ 
    public int getUACReps() { 
    	return getReps("UAC");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of UAC.
     * <p>
     * <p>
     * Note that unlike {@link #getUAC()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     * 
     */ 
    public java.util.List<UAC> getUACAll() throws HL7Exception {
    	return getAllAsList("UAC", UAC.class);
    } 

    /**
     * <p>
     * Inserts a specific repetition of UAC (User Authentication Credential Segment)
     * </p>
     * 
     *
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertUAC(UAC structure, int rep) throws HL7Exception { 
       super.insertRepetition( "UAC", structure, rep);
    }


    /**
     * <p>
     * Inserts a specific repetition of UAC (User Authentication Credential Segment)
     * </p>
     * 
     *
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public UAC insertUAC(int rep) throws HL7Exception { 
       return (UAC)super.insertRepetition("UAC", rep);
    }


    /**
     * <p>
     * Removes a specific repetition of UAC (User Authentication Credential Segment)
     * </p>
     * 
     *
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public UAC removeUAC(int rep) throws HL7Exception { 
       return (UAC)super.removeRepetition("UAC", rep);
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
     * RFI (Request for Information) - creates it if necessary
     * </p>
     * 
     *
     */
    public RFI getRFI() { 
       return getTyped("RFI", RFI.class);
    }





    /**
     * <p>
     * Returns
     * the first repetition of 
     * CTD (Contact Data) - creates it if necessary
     * </p>
     * 
     *
     */
    public CTD getCTD() { 
       return getTyped("CTD", CTD.class);
    }


    /**
     * <p>
     * Returns a specific repetition of
     * CTD (Contact Data) - creates it if necessary
     * </p>
     * 
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public CTD getCTD(int rep) { 
       return getTyped("CTD", rep, CTD.class);
    }

    /** 
     * <p>
     * Returns the number of existing repetitions of CTD 
     * </p>
     * 
     */ 
    public int getCTDReps() { 
    	return getReps("CTD");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of CTD.
     * <p>
     * <p>
     * Note that unlike {@link #getCTD()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     * 
     */ 
    public java.util.List<CTD> getCTDAll() throws HL7Exception {
    	return getAllAsList("CTD", CTD.class);
    } 

    /**
     * <p>
     * Inserts a specific repetition of CTD (Contact Data)
     * </p>
     * 
     *
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertCTD(CTD structure, int rep) throws HL7Exception { 
       super.insertRepetition( "CTD", structure, rep);
    }


    /**
     * <p>
     * Inserts a specific repetition of CTD (Contact Data)
     * </p>
     * 
     *
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public CTD insertCTD(int rep) throws HL7Exception { 
       return (CTD)super.insertRepetition("CTD", rep);
    }


    /**
     * <p>
     * Removes a specific repetition of CTD (Contact Data)
     * </p>
     * 
     *
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public CTD removeCTD(int rep) throws HL7Exception { 
       return (CTD)super.removeRepetition("CTD", rep);
    }




    /**
     * <p>
     * Returns
     * IVC (Invoice Segment) - creates it if necessary
     * </p>
     * 
     *
     */
    public IVC getIVC() { 
       return getTyped("IVC", IVC.class);
    }





    /**
     * <p>
     * Returns
     * PSS (Product/Service Section) - creates it if necessary
     * </p>
     * 
     *
     */
    public PSS getPSS() { 
       return getTyped("PSS", PSS.class);
    }





    /**
     * <p>
     * Returns
     * PSG (Product/Service Group) - creates it if necessary
     * </p>
     * 
     *
     */
    public PSG getPSG() { 
       return getTyped("PSG", PSG.class);
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
     * PSL (Product/Service Line Item) - creates it if necessary
     * </p>
     * 
     *
     */
    public PSL getPSL() { 
       return getTyped("PSL", PSL.class);
    }





    /**
     * <p>
     * Returns
     * the first repetition of 
     * REQUEST (a Group object) - creates it if necessary
     * </p>
     * 
     *
     */
    public EHC_E13_REQUEST getREQUEST() { 
       return getTyped("REQUEST", EHC_E13_REQUEST.class);
    }


    /**
     * <p>
     * Returns a specific repetition of
     * REQUEST (a Group object) - creates it if necessary
     * </p>
     * 
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public EHC_E13_REQUEST getREQUEST(int rep) { 
       return getTyped("REQUEST", rep, EHC_E13_REQUEST.class);
    }

    /** 
     * <p>
     * Returns the number of existing repetitions of REQUEST 
     * </p>
     * 
     */ 
    public int getREQUESTReps() { 
    	return getReps("REQUEST");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of REQUEST.
     * <p>
     * <p>
     * Note that unlike {@link #getREQUEST()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     * 
     */ 
    public java.util.List<EHC_E13_REQUEST> getREQUESTAll() throws HL7Exception {
    	return getAllAsList("REQUEST", EHC_E13_REQUEST.class);
    } 

    /**
     * <p>
     * Inserts a specific repetition of REQUEST (a Group object)
     * </p>
     * 
     *
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertREQUEST(EHC_E13_REQUEST structure, int rep) throws HL7Exception { 
       super.insertRepetition( "REQUEST", structure, rep);
    }


    /**
     * <p>
     * Inserts a specific repetition of REQUEST (a Group object)
     * </p>
     * 
     *
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public EHC_E13_REQUEST insertREQUEST(int rep) throws HL7Exception { 
       return (EHC_E13_REQUEST)super.insertRepetition("REQUEST", rep);
    }


    /**
     * <p>
     * Removes a specific repetition of REQUEST (a Group object)
     * </p>
     * 
     *
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public EHC_E13_REQUEST removeREQUEST(int rep) throws HL7Exception { 
       return (EHC_E13_REQUEST)super.removeRepetition("REQUEST", rep);
    }



}

