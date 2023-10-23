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


package ca.uhn.hl7v2.model.v23.segment;

// import ca.uhn.hl7v2.model.v23.group.*;
import ca.uhn.hl7v2.model.v23.datatype.*;
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
     * <li>LCC-1: Primary Key Value (PL) <b> </b>
     * <li>LCC-2: Location Department (IS) <b> </b>
     * <li>LCC-3: Accommodation Type (CE) <b>optional repeating</b>
     * <li>LCC-4: Charge Code (CE) <b> repeating</b>
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
                                  this.add(PL.class, true, 1, 200, new Object[]{ getMessage() }, "Primary Key Value");
                                              this.add(IS.class, true, 1, 10, new Object[]{ getMessage(), new Integer(264) }, "Location Department");
                                  this.add(CE.class, false, 0, 60, new Object[]{ getMessage() }, "Accommodation Type");
                                  this.add(CE.class, true, 0, 60, new Object[]{ getMessage() }, "Charge Code");
       } catch(HL7Exception e) {
          log.error("Unexpected error creating LCC - this is probably a bug in the source code generator.", e);
       }
    }



    /**
     * Returns
     * LCC-1: "Primary Key Value" - creates it if necessary
     */
    public PL getPrimaryKeyValue() { 
		PL retVal = this.getTypedField(1, 0);
		return retVal;
    }
    
    /**
     * Returns
     * LCC-1: "Primary Key Value" - creates it if necessary
     */
    public PL getLcc1_PrimaryKeyValue() { 
		PL retVal = this.getTypedField(1, 0);
		return retVal;
    }



    /**
     * Returns
     * LCC-2: "Location Department" - creates it if necessary
     */
    public IS getLocationDepartment() { 
		IS retVal = this.getTypedField(2, 0);
		return retVal;
    }
    
    /**
     * Returns
     * LCC-2: "Location Department" - creates it if necessary
     */
    public IS getLcc2_LocationDepartment() { 
		IS retVal = this.getTypedField(2, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Accommodation Type (LCC-3).
     */
    public CE[] getAccommodationType() {
    	CE[] retVal = this.getTypedField(3, new CE[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Accommodation Type (LCC-3).
     */
    public CE[] getLcc3_AccommodationType() {
    	CE[] retVal = this.getTypedField(3, new CE[0]);
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
    public CE getAccommodationType(int rep) { 
		CE retVal = this.getTypedField(3, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * LCC-3: "Accommodation Type" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CE getLcc3_AccommodationType(int rep) { 
		CE retVal = this.getTypedField(3, rep);
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
    public CE insertAccommodationType(int rep) throws HL7Exception { 
        return (CE) super.insertRepetition(3, rep);
    }


    /**
     * Inserts a repetition of
     * LCC-3: "Accommodation Type" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE insertLcc3_AccommodationType(int rep) throws HL7Exception { 
        return (CE) super.insertRepetition(3, rep);
    }


    /**
     * Removes a repetition of
     * LCC-3: "Accommodation Type" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE removeAccommodationType(int rep) throws HL7Exception { 
        return (CE) super.removeRepetition(3, rep);
    }


    /**
     * Removes a repetition of
     * LCC-3: "Accommodation Type" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE removeLcc3_AccommodationType(int rep) throws HL7Exception { 
        return (CE) super.removeRepetition(3, rep);
    }



    /**
     * Returns all repetitions of Charge Code (LCC-4).
     */
    public CE[] getChargeCode() {
    	CE[] retVal = this.getTypedField(4, new CE[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Charge Code (LCC-4).
     */
    public CE[] getLcc4_ChargeCode() {
    	CE[] retVal = this.getTypedField(4, new CE[0]);
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
    public CE getChargeCode(int rep) { 
		CE retVal = this.getTypedField(4, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * LCC-4: "Charge Code" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CE getLcc4_ChargeCode(int rep) { 
		CE retVal = this.getTypedField(4, rep);
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
    public CE insertChargeCode(int rep) throws HL7Exception { 
        return (CE) super.insertRepetition(4, rep);
    }


    /**
     * Inserts a repetition of
     * LCC-4: "Charge Code" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE insertLcc4_ChargeCode(int rep) throws HL7Exception { 
        return (CE) super.insertRepetition(4, rep);
    }


    /**
     * Removes a repetition of
     * LCC-4: "Charge Code" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE removeChargeCode(int rep) throws HL7Exception { 
        return (CE) super.removeRepetition(4, rep);
    }


    /**
     * Removes a repetition of
     * LCC-4: "Charge Code" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE removeLcc4_ChargeCode(int rep) throws HL7Exception { 
        return (CE) super.removeRepetition(4, rep);
    }






    /** {@inheritDoc} */   
    protected Type createNewTypeWithoutReflection(int field) {
       switch (field) {
          case 0: return new PL(getMessage());
          case 1: return new IS(getMessage(), new Integer( 264 ));
          case 2: return new CE(getMessage());
          case 3: return new CE(getMessage());
          default: return null;
       }
   }


}

