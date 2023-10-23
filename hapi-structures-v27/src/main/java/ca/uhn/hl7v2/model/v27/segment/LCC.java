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


package ca.uhn.hl7v2.model.v27.segment;

// import ca.uhn.hl7v2.model.v27.group.*;
import ca.uhn.hl7v2.model.v27.datatype.*;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.parser.DefaultModelClassFactory;
import ca.uhn.hl7v2.model.AbstractMessage;
import ca.uhn.hl7v2.model.Group;
import ca.uhn.hl7v2.model.Type;
import ca.uhn.hl7v2.model.AbstractSegment;
import ca.uhn.hl7v2.model.Varies;


/**
 *<p>Represents an HL7 LCC message segment (Location Charge Code). 
 * This segment has the following fields:</p>
 * <ul>
     * <li>LCC-1: Primary Key Value - LCC (PL) <b> </b>
     * <li>LCC-2: Location Department (CWE) <b> </b>
     * <li>LCC-3: Accommodation Type (CWE) <b>optional repeating</b>
     * <li>LCC-4: Charge Code (CWE) <b> repeating</b>
 * </ul>
 */
@SuppressWarnings("unused")
public class LCC extends AbstractSegment {

    /** 
     * Creates a new LCC segment
     */
    public LCC(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(PL.class, true, 1, 0, new Object[]{ getMessage() }, "Primary Key Value - LCC");
                                  this.add(CWE.class, true, 1, 0, new Object[]{ getMessage() }, "Location Department");
                                  this.add(CWE.class, false, 0, 0, new Object[]{ getMessage() }, "Accommodation Type");
                                  this.add(CWE.class, true, 0, 0, new Object[]{ getMessage() }, "Charge Code");
       } catch(HL7Exception e) {
          log.error("Unexpected error creating LCC - this is probably a bug in the source code generator.", e);
       }
    }



    /**
     * Returns
     * LCC-1: "Primary Key Value - LCC" - creates it if necessary
     */
    public PL getPrimaryKeyValueLCC() { 
		PL retVal = this.getTypedField(1, 0);
		return retVal;
    }
    
    /**
     * Returns
     * LCC-1: "Primary Key Value - LCC" - creates it if necessary
     */
    public PL getLcc1_PrimaryKeyValueLCC() { 
		PL retVal = this.getTypedField(1, 0);
		return retVal;
    }



    /**
     * Returns
     * LCC-2: "Location Department" - creates it if necessary
     */
    public CWE getLocationDepartment() { 
		CWE retVal = this.getTypedField(2, 0);
		return retVal;
    }
    
    /**
     * Returns
     * LCC-2: "Location Department" - creates it if necessary
     */
    public CWE getLcc2_LocationDepartment() { 
		CWE retVal = this.getTypedField(2, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Accommodation Type (LCC-3).
     */
    public CWE[] getAccommodationType() {
    	CWE[] retVal = this.getTypedField(3, new CWE[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Accommodation Type (LCC-3).
     */
    public CWE[] getLcc3_AccommodationType() {
    	CWE[] retVal = this.getTypedField(3, new CWE[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Accommodation Type (LCC-3).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getAccommodationTypeReps() {
    	return this.getReps(3);
    }


    /**
     * Returns a specific repetition of
     * LCC-3: "Accommodation Type" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CWE getAccommodationType(int rep) { 
		CWE retVal = this.getTypedField(3, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * LCC-3: "Accommodation Type" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CWE getLcc3_AccommodationType(int rep) { 
		CWE retVal = this.getTypedField(3, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Accommodation Type (LCC-3).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getLcc3_AccommodationTypeReps() {
    	return this.getReps(3);
    }


    /**
     * Inserts a repetition of
     * LCC-3: "Accommodation Type" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE insertAccommodationType(int rep) throws HL7Exception { 
        return (CWE) super.insertRepetition(3, rep);
    }


    /**
     * Inserts a repetition of
     * LCC-3: "Accommodation Type" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE insertLcc3_AccommodationType(int rep) throws HL7Exception { 
        return (CWE) super.insertRepetition(3, rep);
    }


    /**
     * Removes a repetition of
     * LCC-3: "Accommodation Type" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE removeAccommodationType(int rep) throws HL7Exception { 
        return (CWE) super.removeRepetition(3, rep);
    }


    /**
     * Removes a repetition of
     * LCC-3: "Accommodation Type" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE removeLcc3_AccommodationType(int rep) throws HL7Exception { 
        return (CWE) super.removeRepetition(3, rep);
    }



    /**
     * Returns all repetitions of Charge Code (LCC-4).
     */
    public CWE[] getChargeCode() {
    	CWE[] retVal = this.getTypedField(4, new CWE[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Charge Code (LCC-4).
     */
    public CWE[] getLcc4_ChargeCode() {
    	CWE[] retVal = this.getTypedField(4, new CWE[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Charge Code (LCC-4).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getChargeCodeReps() {
    	return this.getReps(4);
    }


    /**
     * Returns a specific repetition of
     * LCC-4: "Charge Code" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CWE getChargeCode(int rep) { 
		CWE retVal = this.getTypedField(4, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * LCC-4: "Charge Code" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CWE getLcc4_ChargeCode(int rep) { 
		CWE retVal = this.getTypedField(4, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Charge Code (LCC-4).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getLcc4_ChargeCodeReps() {
    	return this.getReps(4);
    }


    /**
     * Inserts a repetition of
     * LCC-4: "Charge Code" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE insertChargeCode(int rep) throws HL7Exception { 
        return (CWE) super.insertRepetition(4, rep);
    }


    /**
     * Inserts a repetition of
     * LCC-4: "Charge Code" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE insertLcc4_ChargeCode(int rep) throws HL7Exception { 
        return (CWE) super.insertRepetition(4, rep);
    }


    /**
     * Removes a repetition of
     * LCC-4: "Charge Code" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE removeChargeCode(int rep) throws HL7Exception { 
        return (CWE) super.removeRepetition(4, rep);
    }


    /**
     * Removes a repetition of
     * LCC-4: "Charge Code" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE removeLcc4_ChargeCode(int rep) throws HL7Exception { 
        return (CWE) super.removeRepetition(4, rep);
    }






    /** {@inheritDoc} */   
    protected Type createNewTypeWithoutReflection(int field) {
       switch (field) {
          case 0: return new PL(getMessage());
          case 1: return new CWE(getMessage());
          case 2: return new CWE(getMessage());
          case 3: return new CWE(getMessage());
          default: return null;
       }
   }


}

