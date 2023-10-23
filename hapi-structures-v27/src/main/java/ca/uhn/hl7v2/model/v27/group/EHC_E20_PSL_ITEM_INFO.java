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


package ca.uhn.hl7v2.model.v27.group;

import ca.uhn.hl7v2.model.v27.segment.*;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.model.*;

/**
 * <p>Represents a EHC_E20_PSL_ITEM_INFO group structure (a Group object).
 * A Group is an ordered collection of message segments that can repeat together or be optionally in/excluded together.
 * This Group contains the following elements:  
 * </p>
 * <ul>
                         * <li>1: PSL (Product/Service Line Item) <b>  choice</b></li>
                         * <li>2: NTE (Notes and Comments) <b>optional repeating choice</b></li>
                         * <li>3: ADJ (Adjustment) <b>optional repeating choice</b></li>
                         * <li>4: LOC (Location Identification) <b>optional repeating choice</b></li>
                         * <li>5: ROL (Role) <b>optional repeating choice</b></li>
 * </ul>
 * <p>
 * Note that this structure has "choice" elements. This means that one of the 
 * structures above marked as "choice" must be present, but no more than one.
 * </p> 
 */
//@SuppressWarnings("unused")
public class EHC_E20_PSL_ITEM_INFO extends AbstractGroup {

    /** 
     * Creates a new EHC_E20_PSL_ITEM_INFO group
     */
    public EHC_E20_PSL_ITEM_INFO(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(PSL.class, true, false, true);
                                  this.add(NTE.class, false, true, true);
                                  this.add(ADJ.class, false, true, true);
                                  this.add(LOC.class, false, true, true);
                                  this.add(ROL.class, false, true, true);
       } catch(HL7Exception e) {
          log.error("Unexpected error creating EHC_E20_PSL_ITEM_INFO - this is probably a bug in the source code generator.", e);
       }
    }

    /** 
     * Returns "2.7"
     */
    public String getVersion() {
       return "2.7";
    }



    /**
     * Returns
     * PSL (Product/Service Line Item) - creates it if necessary
     */
    public PSL getPSL() { 
       PSL retVal = getTyped("PSL", PSL.class);
       return retVal;
    }




    /**
     * Returns
     * the first repetition of 
     * NTE (Notes and Comments) - creates it if necessary
     */
    public NTE getNTE() { 
       NTE retVal = getTyped("NTE", NTE.class);
       return retVal;
    }


    /**
     * Returns a specific repetition of
     * NTE (Notes and Comments) - creates it if necessary
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public NTE getNTE(int rep) { 
       NTE retVal = getTyped("NTE", rep, NTE.class);
       return retVal;
    }

    /** 
     * Returns the number of existing repetitions of NTE 
     */ 
    public int getNTEReps() {  
        return getReps("NTE");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of NTE.
     * <p>
     * <p>
     * Note that unlike {@link #getNTE()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     */ 
    public java.util.List<NTE> getNTEAll() throws HL7Exception {
    	return getAllAsList("NTE", NTE.class);
    } 

    /**
     * Inserts a specific repetition of NTE (Notes and Comments)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertNTE(NTE structure, int rep) throws HL7Exception { 
       super.insertRepetition("NTE", structure, rep);
    }


    /**
     * Inserts a specific repetition of NTE (Notes and Comments)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public NTE insertNTE(int rep) throws HL7Exception { 
       return (NTE)super.insertRepetition("NTE", rep);
    }


    /**
     * Removes a specific repetition of NTE (Notes and Comments)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public NTE removeNTE(int rep) throws HL7Exception { 
       return (NTE)super.removeRepetition("NTE", rep);
    }



    /**
     * Returns
     * the first repetition of 
     * ADJ (Adjustment) - creates it if necessary
     */
    public ADJ getADJ() { 
       ADJ retVal = getTyped("ADJ", ADJ.class);
       return retVal;
    }


    /**
     * Returns a specific repetition of
     * ADJ (Adjustment) - creates it if necessary
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public ADJ getADJ(int rep) { 
       ADJ retVal = getTyped("ADJ", rep, ADJ.class);
       return retVal;
    }

    /** 
     * Returns the number of existing repetitions of ADJ 
     */ 
    public int getADJReps() {  
        return getReps("ADJ");
    } 

    /** 
     * <p>
     * Returns a non-modifiable List containing all current existing repetitions of ADJ.
     * <p>
     * <p>
     * Note that unlike {@link #getADJ()}, this method will not create any reps
     * if none are already present, so an empty list may be returned.
     * </p>
     */ 
    public java.util.List<ADJ> getADJAll() throws HL7Exception {
    	return getAllAsList("ADJ", ADJ.class);
    } 

    /**
     * Inserts a specific repetition of ADJ (Adjustment)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertADJ(ADJ structure, int rep) throws HL7Exception { 
       super.insertRepetition("ADJ", structure, rep);
    }


    /**
     * Inserts a specific repetition of ADJ (Adjustment)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public ADJ insertADJ(int rep) throws HL7Exception { 
       return (ADJ)super.insertRepetition("ADJ", rep);
    }


    /**
     * Removes a specific repetition of ADJ (Adjustment)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public ADJ removeADJ(int rep) throws HL7Exception { 
       return (ADJ)super.removeRepetition("ADJ", rep);
    }



    /**
     * Returns
     * the first repetition of 
     * LOC (Location Identification) - creates it if necessary
     */
    public LOC getLOC() { 
       LOC retVal = getTyped("LOC", LOC.class);
       return retVal;
    }


    /**
     * Returns a specific repetition of
     * LOC (Location Identification) - creates it if necessary
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public LOC getLOC(int rep) { 
       LOC retVal = getTyped("LOC", rep, LOC.class);
       return retVal;
    }

    /** 
     * Returns the number of existing repetitions of LOC 
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
     */ 
    public java.util.List<LOC> getLOCAll() throws HL7Exception {
    	return getAllAsList("LOC", LOC.class);
    } 

    /**
     * Inserts a specific repetition of LOC (Location Identification)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertLOC(LOC structure, int rep) throws HL7Exception { 
       super.insertRepetition("LOC", structure, rep);
    }


    /**
     * Inserts a specific repetition of LOC (Location Identification)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public LOC insertLOC(int rep) throws HL7Exception { 
       return (LOC)super.insertRepetition("LOC", rep);
    }


    /**
     * Removes a specific repetition of LOC (Location Identification)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public LOC removeLOC(int rep) throws HL7Exception { 
       return (LOC)super.removeRepetition("LOC", rep);
    }



    /**
     * Returns
     * the first repetition of 
     * ROL (Role) - creates it if necessary
     */
    public ROL getROL() { 
       ROL retVal = getTyped("ROL", ROL.class);
       return retVal;
    }


    /**
     * Returns a specific repetition of
     * ROL (Role) - creates it if necessary
     *
     * @param rep The repetition index (0-indexed, i.e. the first repetition is at index 0)
     * @throws HL7Exception if the repetition requested is more than one 
     *     greater than the number of existing repetitions.
     */
    public ROL getROL(int rep) { 
       ROL retVal = getTyped("ROL", rep, ROL.class);
       return retVal;
    }

    /** 
     * Returns the number of existing repetitions of ROL 
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
     */ 
    public java.util.List<ROL> getROLAll() throws HL7Exception {
    	return getAllAsList("ROL", ROL.class);
    } 

    /**
     * Inserts a specific repetition of ROL (Role)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public void insertROL(ROL structure, int rep) throws HL7Exception { 
       super.insertRepetition("ROL", structure, rep);
    }


    /**
     * Inserts a specific repetition of ROL (Role)
     * @see AbstractGroup#insertRepetition(Structure, int) 
     */
    public ROL insertROL(int rep) throws HL7Exception { 
       return (ROL)super.insertRepetition("ROL", rep);
    }


    /**
     * Removes a specific repetition of ROL (Role)
     * @see AbstractGroup#removeRepetition(String, int) 
     */
    public ROL removeROL(int rep) throws HL7Exception { 
       return (ROL)super.removeRepetition("ROL", rep);
    }



}

