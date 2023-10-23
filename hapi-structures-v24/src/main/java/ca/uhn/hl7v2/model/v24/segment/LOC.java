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


package ca.uhn.hl7v2.model.v24.segment;

// import ca.uhn.hl7v2.model.v24.group.*;
import ca.uhn.hl7v2.model.v24.datatype.*;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.parser.DefaultModelClassFactory;
import ca.uhn.hl7v2.model.AbstractMessage;
import ca.uhn.hl7v2.model.Group;
import ca.uhn.hl7v2.model.Type;
import ca.uhn.hl7v2.model.AbstractSegment;
import ca.uhn.hl7v2.model.Varies;


/**
 *<p>Represents an HL7 LOC message segment (Location Identification). 
 * This segment has the following fields:</p>
 * <ul>
     * <li>LOC-1: Primary Key Value - LOC (PL) <b> </b>
     * <li>LOC-2: Location Description (ST) <b>optional </b>
     * <li>LOC-3: Location Type - LOC (IS) <b> repeating</b>
     * <li>LOC-4: Organization Name - LOC (XON) <b>optional repeating</b>
     * <li>LOC-5: Location Address (XAD) <b>optional repeating</b>
     * <li>LOC-6: Location Phone (XTN) <b>optional repeating</b>
     * <li>LOC-7: License Number (CE) <b>optional repeating</b>
     * <li>LOC-8: Location Equipment (IS) <b>optional repeating</b>
     * <li>LOC-9: Location Service Code (IS) <b>optional </b>
 * </ul>
 */
@SuppressWarnings("unused")
public class LOC extends AbstractSegment {

    /** 
     * Creates a new LOC segment
     */
    public LOC(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(PL.class, true, 1, 200, new Object[]{ getMessage() }, "Primary Key Value - LOC");
                                  this.add(ST.class, false, 1, 48, new Object[]{ getMessage() }, "Location Description");
                                              this.add(IS.class, true, 0, 2, new Object[]{ getMessage(), new Integer(260) }, "Location Type - LOC");
                                  this.add(XON.class, false, 0, 250, new Object[]{ getMessage() }, "Organization Name - LOC");
                                  this.add(XAD.class, false, 0, 250, new Object[]{ getMessage() }, "Location Address");
                                  this.add(XTN.class, false, 0, 250, new Object[]{ getMessage() }, "Location Phone");
                                  this.add(CE.class, false, 0, 250, new Object[]{ getMessage() }, "License Number");
                                              this.add(IS.class, false, 0, 3, new Object[]{ getMessage(), new Integer(261) }, "Location Equipment");
                                              this.add(IS.class, false, 1, 1, new Object[]{ getMessage(), new Integer(442) }, "Location Service Code");
       } catch(HL7Exception e) {
          log.error("Unexpected error creating LOC - this is probably a bug in the source code generator.", e);
       }
    }



    /**
     * Returns
     * LOC-1: "Primary Key Value - LOC" - creates it if necessary
     */
    public PL getPrimaryKeyValueLOC() { 
		PL retVal = this.getTypedField(1, 0);
		return retVal;
    }
    
    /**
     * Returns
     * LOC-1: "Primary Key Value - LOC" - creates it if necessary
     */
    public PL getLoc1_PrimaryKeyValueLOC() { 
		PL retVal = this.getTypedField(1, 0);
		return retVal;
    }



    /**
     * Returns
     * LOC-2: "Location Description" - creates it if necessary
     */
    public ST getLocationDescription() { 
		ST retVal = this.getTypedField(2, 0);
		return retVal;
    }
    
    /**
     * Returns
     * LOC-2: "Location Description" - creates it if necessary
     */
    public ST getLoc2_LocationDescription() { 
		ST retVal = this.getTypedField(2, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Location Type - LOC (LOC-3).
     */
    public IS[] getLocationTypeLOC() {
    	IS[] retVal = this.getTypedField(3, new IS[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Location Type - LOC (LOC-3).
     */
    public IS[] getLoc3_LocationTypeLOC() {
    	IS[] retVal = this.getTypedField(3, new IS[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Location Type - LOC (LOC-3).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getLocationTypeLOCReps() {
    	return this.getReps(3);
    }


    /**
     * Returns a specific repetition of
     * LOC-3: "Location Type - LOC" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public IS getLocationTypeLOC(int rep) { 
		IS retVal = this.getTypedField(3, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * LOC-3: "Location Type - LOC" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public IS getLoc3_LocationTypeLOC(int rep) { 
		IS retVal = this.getTypedField(3, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Location Type - LOC (LOC-3).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getLoc3_LocationTypeLOCReps() {
    	return this.getReps(3);
    }


    /**
     * Inserts a repetition of
     * LOC-3: "Location Type - LOC" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public IS insertLocationTypeLOC(int rep) throws HL7Exception { 
        return (IS) super.insertRepetition(3, rep);
    }


    /**
     * Inserts a repetition of
     * LOC-3: "Location Type - LOC" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public IS insertLoc3_LocationTypeLOC(int rep) throws HL7Exception { 
        return (IS) super.insertRepetition(3, rep);
    }


    /**
     * Removes a repetition of
     * LOC-3: "Location Type - LOC" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public IS removeLocationTypeLOC(int rep) throws HL7Exception { 
        return (IS) super.removeRepetition(3, rep);
    }


    /**
     * Removes a repetition of
     * LOC-3: "Location Type - LOC" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public IS removeLoc3_LocationTypeLOC(int rep) throws HL7Exception { 
        return (IS) super.removeRepetition(3, rep);
    }



    /**
     * Returns all repetitions of Organization Name - LOC (LOC-4).
     */
    public XON[] getOrganizationNameLOC() {
    	XON[] retVal = this.getTypedField(4, new XON[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Organization Name - LOC (LOC-4).
     */
    public XON[] getLoc4_OrganizationNameLOC() {
    	XON[] retVal = this.getTypedField(4, new XON[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Organization Name - LOC (LOC-4).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getOrganizationNameLOCReps() {
    	return this.getReps(4);
    }


    /**
     * Returns a specific repetition of
     * LOC-4: "Organization Name - LOC" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XON getOrganizationNameLOC(int rep) { 
		XON retVal = this.getTypedField(4, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * LOC-4: "Organization Name - LOC" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XON getLoc4_OrganizationNameLOC(int rep) { 
		XON retVal = this.getTypedField(4, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Organization Name - LOC (LOC-4).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getLoc4_OrganizationNameLOCReps() {
    	return this.getReps(4);
    }


    /**
     * Inserts a repetition of
     * LOC-4: "Organization Name - LOC" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XON insertOrganizationNameLOC(int rep) throws HL7Exception { 
        return (XON) super.insertRepetition(4, rep);
    }


    /**
     * Inserts a repetition of
     * LOC-4: "Organization Name - LOC" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XON insertLoc4_OrganizationNameLOC(int rep) throws HL7Exception { 
        return (XON) super.insertRepetition(4, rep);
    }


    /**
     * Removes a repetition of
     * LOC-4: "Organization Name - LOC" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XON removeOrganizationNameLOC(int rep) throws HL7Exception { 
        return (XON) super.removeRepetition(4, rep);
    }


    /**
     * Removes a repetition of
     * LOC-4: "Organization Name - LOC" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XON removeLoc4_OrganizationNameLOC(int rep) throws HL7Exception { 
        return (XON) super.removeRepetition(4, rep);
    }



    /**
     * Returns all repetitions of Location Address (LOC-5).
     */
    public XAD[] getLocationAddress() {
    	XAD[] retVal = this.getTypedField(5, new XAD[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Location Address (LOC-5).
     */
    public XAD[] getLoc5_LocationAddress() {
    	XAD[] retVal = this.getTypedField(5, new XAD[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Location Address (LOC-5).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getLocationAddressReps() {
    	return this.getReps(5);
    }


    /**
     * Returns a specific repetition of
     * LOC-5: "Location Address" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XAD getLocationAddress(int rep) { 
		XAD retVal = this.getTypedField(5, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * LOC-5: "Location Address" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XAD getLoc5_LocationAddress(int rep) { 
		XAD retVal = this.getTypedField(5, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Location Address (LOC-5).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getLoc5_LocationAddressReps() {
    	return this.getReps(5);
    }


    /**
     * Inserts a repetition of
     * LOC-5: "Location Address" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XAD insertLocationAddress(int rep) throws HL7Exception { 
        return (XAD) super.insertRepetition(5, rep);
    }


    /**
     * Inserts a repetition of
     * LOC-5: "Location Address" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XAD insertLoc5_LocationAddress(int rep) throws HL7Exception { 
        return (XAD) super.insertRepetition(5, rep);
    }


    /**
     * Removes a repetition of
     * LOC-5: "Location Address" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XAD removeLocationAddress(int rep) throws HL7Exception { 
        return (XAD) super.removeRepetition(5, rep);
    }


    /**
     * Removes a repetition of
     * LOC-5: "Location Address" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XAD removeLoc5_LocationAddress(int rep) throws HL7Exception { 
        return (XAD) super.removeRepetition(5, rep);
    }



    /**
     * Returns all repetitions of Location Phone (LOC-6).
     */
    public XTN[] getLocationPhone() {
    	XTN[] retVal = this.getTypedField(6, new XTN[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Location Phone (LOC-6).
     */
    public XTN[] getLoc6_LocationPhone() {
    	XTN[] retVal = this.getTypedField(6, new XTN[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Location Phone (LOC-6).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getLocationPhoneReps() {
    	return this.getReps(6);
    }


    /**
     * Returns a specific repetition of
     * LOC-6: "Location Phone" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XTN getLocationPhone(int rep) { 
		XTN retVal = this.getTypedField(6, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * LOC-6: "Location Phone" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XTN getLoc6_LocationPhone(int rep) { 
		XTN retVal = this.getTypedField(6, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Location Phone (LOC-6).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getLoc6_LocationPhoneReps() {
    	return this.getReps(6);
    }


    /**
     * Inserts a repetition of
     * LOC-6: "Location Phone" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XTN insertLocationPhone(int rep) throws HL7Exception { 
        return (XTN) super.insertRepetition(6, rep);
    }


    /**
     * Inserts a repetition of
     * LOC-6: "Location Phone" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XTN insertLoc6_LocationPhone(int rep) throws HL7Exception { 
        return (XTN) super.insertRepetition(6, rep);
    }


    /**
     * Removes a repetition of
     * LOC-6: "Location Phone" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XTN removeLocationPhone(int rep) throws HL7Exception { 
        return (XTN) super.removeRepetition(6, rep);
    }


    /**
     * Removes a repetition of
     * LOC-6: "Location Phone" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XTN removeLoc6_LocationPhone(int rep) throws HL7Exception { 
        return (XTN) super.removeRepetition(6, rep);
    }



    /**
     * Returns all repetitions of License Number (LOC-7).
     */
    public CE[] getLicenseNumber() {
    	CE[] retVal = this.getTypedField(7, new CE[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of License Number (LOC-7).
     */
    public CE[] getLoc7_LicenseNumber() {
    	CE[] retVal = this.getTypedField(7, new CE[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of License Number (LOC-7).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getLicenseNumberReps() {
    	return this.getReps(7);
    }


    /**
     * Returns a specific repetition of
     * LOC-7: "License Number" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CE getLicenseNumber(int rep) { 
		CE retVal = this.getTypedField(7, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * LOC-7: "License Number" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CE getLoc7_LicenseNumber(int rep) { 
		CE retVal = this.getTypedField(7, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of License Number (LOC-7).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getLoc7_LicenseNumberReps() {
    	return this.getReps(7);
    }


    /**
     * Inserts a repetition of
     * LOC-7: "License Number" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE insertLicenseNumber(int rep) throws HL7Exception { 
        return (CE) super.insertRepetition(7, rep);
    }


    /**
     * Inserts a repetition of
     * LOC-7: "License Number" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE insertLoc7_LicenseNumber(int rep) throws HL7Exception { 
        return (CE) super.insertRepetition(7, rep);
    }


    /**
     * Removes a repetition of
     * LOC-7: "License Number" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE removeLicenseNumber(int rep) throws HL7Exception { 
        return (CE) super.removeRepetition(7, rep);
    }


    /**
     * Removes a repetition of
     * LOC-7: "License Number" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CE removeLoc7_LicenseNumber(int rep) throws HL7Exception { 
        return (CE) super.removeRepetition(7, rep);
    }



    /**
     * Returns all repetitions of Location Equipment (LOC-8).
     */
    public IS[] getLocationEquipment() {
    	IS[] retVal = this.getTypedField(8, new IS[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Location Equipment (LOC-8).
     */
    public IS[] getLoc8_LocationEquipment() {
    	IS[] retVal = this.getTypedField(8, new IS[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Location Equipment (LOC-8).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getLocationEquipmentReps() {
    	return this.getReps(8);
    }


    /**
     * Returns a specific repetition of
     * LOC-8: "Location Equipment" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public IS getLocationEquipment(int rep) { 
		IS retVal = this.getTypedField(8, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * LOC-8: "Location Equipment" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public IS getLoc8_LocationEquipment(int rep) { 
		IS retVal = this.getTypedField(8, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Location Equipment (LOC-8).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getLoc8_LocationEquipmentReps() {
    	return this.getReps(8);
    }


    /**
     * Inserts a repetition of
     * LOC-8: "Location Equipment" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public IS insertLocationEquipment(int rep) throws HL7Exception { 
        return (IS) super.insertRepetition(8, rep);
    }


    /**
     * Inserts a repetition of
     * LOC-8: "Location Equipment" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public IS insertLoc8_LocationEquipment(int rep) throws HL7Exception { 
        return (IS) super.insertRepetition(8, rep);
    }


    /**
     * Removes a repetition of
     * LOC-8: "Location Equipment" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public IS removeLocationEquipment(int rep) throws HL7Exception { 
        return (IS) super.removeRepetition(8, rep);
    }


    /**
     * Removes a repetition of
     * LOC-8: "Location Equipment" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public IS removeLoc8_LocationEquipment(int rep) throws HL7Exception { 
        return (IS) super.removeRepetition(8, rep);
    }




    /**
     * Returns
     * LOC-9: "Location Service Code" - creates it if necessary
     */
    public IS getLocationServiceCode() { 
		IS retVal = this.getTypedField(9, 0);
		return retVal;
    }
    
    /**
     * Returns
     * LOC-9: "Location Service Code" - creates it if necessary
     */
    public IS getLoc9_LocationServiceCode() { 
		IS retVal = this.getTypedField(9, 0);
		return retVal;
    }





    /** {@inheritDoc} */   
    protected Type createNewTypeWithoutReflection(int field) {
       switch (field) {
          case 0: return new PL(getMessage());
          case 1: return new ST(getMessage());
          case 2: return new IS(getMessage(), new Integer( 260 ));
          case 3: return new XON(getMessage());
          case 4: return new XAD(getMessage());
          case 5: return new XTN(getMessage());
          case 6: return new CE(getMessage());
          case 7: return new IS(getMessage(), new Integer( 261 ));
          case 8: return new IS(getMessage(), new Integer( 442 ));
          default: return null;
       }
   }


}

