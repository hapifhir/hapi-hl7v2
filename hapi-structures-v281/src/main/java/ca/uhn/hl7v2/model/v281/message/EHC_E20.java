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


package ca.uhn.hl7v2.model.v281.message;

import ca.uhn.hl7v2.model.v281.group.*;
import ca.uhn.hl7v2.model.v281.segment.*;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.parser.DefaultModelClassFactory;
import ca.uhn.hl7v2.model.*;


/**
 * <p>Represents a EHC_E20 message structure (see chapter 16.3.10). This structure contains the 
 * following elements: </p>
 * <ul>
		                 * <li>1: MSH (Message Header) <b> </b> </li>
		                 * <li>2: SFT (Software Segment) <b>optional repeating</b> </li>
		                 * <li>3: UAC (User Authentication Credential Segment) <b>optional repeating</b> </li>
		                 * <li>4: IVC (Invoice Segment) <b> </b> </li>
		                 * <li>5: CTD (Contact Data) <b> repeating</b> </li>
		                 * <li>6: LOC (Location Identification) <b>optional repeating</b> </li>
		                 * <li>7: ROL (Role) <b>optional repeating</b> </li>
		                 * <li>8: EHC_E20_PAT_INFO (a Group object) <b> repeating</b> </li>
		                 * <li>9: EHC_E20_PSL_ITEM_INFO (a Group object) <b> repeating</b> </li>
 * </ul>
 */
//@SuppressWarnings("unused")
public class EHC_E20 extends AbstractMessage  {

    /**
     * Creates a new EHC_E20 message with DefaultModelClassFactory. 
     */ 
    public EHC_E20() { 
       this(new DefaultModelClassFactory());
    }

    /** 
     * Creates a new EHC_E20 message with custom ModelClassFactory.
     */
    public EHC_E20(ModelClassFactory factory) {
       super(factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                          this.add(MSH.class, true, false);
	                          this.add(SFT.class, false, true);
	                          this.add(UAC.class, false, true);
	                          this.add(IVC.class, true, false);
	                          this.add(CTD.class, true, true);
	                          this.add(LOC.class, false, true);
	                          this.add(ROL.class, false, true);
	                          this.add(EHC_E20_PAT_INFO.class, true, true);
	                          this.add(EHC_E20_PSL_ITEM_INFO.class, true, true);
	       } catch(HL7Exception e) {
          log.error("Unexpected error creating EHC_E20 - this is probably a bug in the source code generator.", e);
       }
    }


    /** 
     * Returns "2.8.1"
     */
    public String getVersion() {
       return "2.8.1";
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
     * the first repetition of 
     * LOC (Location Identification) - creates it if necessary
     * </p>
     * 
     *
     */
    public LOC getLOC() { 
       return getTyped("LOC", LOC.class);
    }


    /**
     * <p>
     * Returns a specific repetition of
     * LOC (Location Identification) - creates it if necessary
     * </p>
     * 
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public LOC getLOC(int rep) { 
       return getTyped("LOC", rep, LOC.class);
    }

    /** 
     * <p>
     * Returns the number of existing repetitions of LOC 
     * </p>
     * 
     */ 
    public int getLOCReps() { 
    	return getReps("LOC");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of LOC.
     * <p>
     * <p>
     * Note that unlike {@link #getLOC()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     * 
     */ 
    public java.util.List<LOC> getLOCAll() throws HL7Exception {
    	return getAllAsList("LOC", LOC.class);
    } 

    /**
     * <p>
     * Inserts a specific repetition of LOC (Location Identification)
     * </p>
     * 
     *
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertLOC(LOC structure, int rep) throws HL7Exception { 
       super.insertRepetition( "LOC", structure, rep);
    }


    /**
     * <p>
     * Inserts a specific repetition of LOC (Location Identification)
     * </p>
     * 
     *
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public LOC insertLOC(int rep) throws HL7Exception { 
       return (LOC)super.insertRepetition("LOC", rep);
    }


    /**
     * <p>
     * Removes a specific repetition of LOC (Location Identification)
     * </p>
     * 
     *
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public LOC removeLOC(int rep) throws HL7Exception { 
       return (LOC)super.removeRepetition("LOC", rep);
    }




    /**
     * <p>
     * Returns
     * the first repetition of 
     * ROL (Role) - creates it if necessary
     * </p>
     * 
     *
     */
    public ROL getROL() { 
       return getTyped("ROL", ROL.class);
    }


    /**
     * <p>
     * Returns a specific repetition of
     * ROL (Role) - creates it if necessary
     * </p>
     * 
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public ROL getROL(int rep) { 
       return getTyped("ROL", rep, ROL.class);
    }

    /** 
     * <p>
     * Returns the number of existing repetitions of ROL 
     * </p>
     * 
     */ 
    public int getROLReps() { 
    	return getReps("ROL");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of ROL.
     * <p>
     * <p>
     * Note that unlike {@link #getROL()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     * 
     */ 
    public java.util.List<ROL> getROLAll() throws HL7Exception {
    	return getAllAsList("ROL", ROL.class);
    } 

    /**
     * <p>
     * Inserts a specific repetition of ROL (Role)
     * </p>
     * 
     *
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertROL(ROL structure, int rep) throws HL7Exception { 
       super.insertRepetition( "ROL", structure, rep);
    }


    /**
     * <p>
     * Inserts a specific repetition of ROL (Role)
     * </p>
     * 
     *
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public ROL insertROL(int rep) throws HL7Exception { 
       return (ROL)super.insertRepetition("ROL", rep);
    }


    /**
     * <p>
     * Removes a specific repetition of ROL (Role)
     * </p>
     * 
     *
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public ROL removeROL(int rep) throws HL7Exception { 
       return (ROL)super.removeRepetition("ROL", rep);
    }




    /**
     * <p>
     * Returns
     * the first repetition of 
     * PAT_INFO (a Group object) - creates it if necessary
     * </p>
     * 
     *
     */
    public EHC_E20_PAT_INFO getPAT_INFO() { 
       return getTyped("PAT_INFO", EHC_E20_PAT_INFO.class);
    }


    /**
     * <p>
     * Returns a specific repetition of
     * PAT_INFO (a Group object) - creates it if necessary
     * </p>
     * 
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public EHC_E20_PAT_INFO getPAT_INFO(int rep) { 
       return getTyped("PAT_INFO", rep, EHC_E20_PAT_INFO.class);
    }

    /** 
     * <p>
     * Returns the number of existing repetitions of PAT_INFO 
     * </p>
     * 
     */ 
    public int getPAT_INFOReps() { 
    	return getReps("PAT_INFO");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of PAT_INFO.
     * <p>
     * <p>
     * Note that unlike {@link #getPAT_INFO()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     * 
     */ 
    public java.util.List<EHC_E20_PAT_INFO> getPAT_INFOAll() throws HL7Exception {
    	return getAllAsList("PAT_INFO", EHC_E20_PAT_INFO.class);
    } 

    /**
     * <p>
     * Inserts a specific repetition of PAT_INFO (a Group object)
     * </p>
     * 
     *
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertPAT_INFO(EHC_E20_PAT_INFO structure, int rep) throws HL7Exception { 
       super.insertRepetition( "PAT_INFO", structure, rep);
    }


    /**
     * <p>
     * Inserts a specific repetition of PAT_INFO (a Group object)
     * </p>
     * 
     *
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public EHC_E20_PAT_INFO insertPAT_INFO(int rep) throws HL7Exception { 
       return (EHC_E20_PAT_INFO)super.insertRepetition("PAT_INFO", rep);
    }


    /**
     * <p>
     * Removes a specific repetition of PAT_INFO (a Group object)
     * </p>
     * 
     *
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public EHC_E20_PAT_INFO removePAT_INFO(int rep) throws HL7Exception { 
       return (EHC_E20_PAT_INFO)super.removeRepetition("PAT_INFO", rep);
    }




    /**
     * <p>
     * Returns
     * the first repetition of 
     * PSL_ITEM_INFO (a Group object) - creates it if necessary
     * </p>
     * 
     *
     */
    public EHC_E20_PSL_ITEM_INFO getPSL_ITEM_INFO() { 
       return getTyped("PSL_ITEM_INFO", EHC_E20_PSL_ITEM_INFO.class);
    }


    /**
     * <p>
     * Returns a specific repetition of
     * PSL_ITEM_INFO (a Group object) - creates it if necessary
     * </p>
     * 
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public EHC_E20_PSL_ITEM_INFO getPSL_ITEM_INFO(int rep) { 
       return getTyped("PSL_ITEM_INFO", rep, EHC_E20_PSL_ITEM_INFO.class);
    }

    /** 
     * <p>
     * Returns the number of existing repetitions of PSL_ITEM_INFO 
     * </p>
     * 
     */ 
    public int getPSL_ITEM_INFOReps() { 
    	return getReps("PSL_ITEM_INFO");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of PSL_ITEM_INFO.
     * <p>
     * <p>
     * Note that unlike {@link #getPSL_ITEM_INFO()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     * 
     */ 
    public java.util.List<EHC_E20_PSL_ITEM_INFO> getPSL_ITEM_INFOAll() throws HL7Exception {
    	return getAllAsList("PSL_ITEM_INFO", EHC_E20_PSL_ITEM_INFO.class);
    } 

    /**
     * <p>
     * Inserts a specific repetition of PSL_ITEM_INFO (a Group object)
     * </p>
     * 
     *
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertPSL_ITEM_INFO(EHC_E20_PSL_ITEM_INFO structure, int rep) throws HL7Exception { 
       super.insertRepetition( "PSL_ITEM_INFO", structure, rep);
    }


    /**
     * <p>
     * Inserts a specific repetition of PSL_ITEM_INFO (a Group object)
     * </p>
     * 
     *
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public EHC_E20_PSL_ITEM_INFO insertPSL_ITEM_INFO(int rep) throws HL7Exception { 
       return (EHC_E20_PSL_ITEM_INFO)super.insertRepetition("PSL_ITEM_INFO", rep);
    }


    /**
     * <p>
     * Removes a specific repetition of PSL_ITEM_INFO (a Group object)
     * </p>
     * 
     *
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public EHC_E20_PSL_ITEM_INFO removePSL_ITEM_INFO(int rep) throws HL7Exception { 
       return (EHC_E20_PSL_ITEM_INFO)super.removeRepetition("PSL_ITEM_INFO", rep);
    }



}

