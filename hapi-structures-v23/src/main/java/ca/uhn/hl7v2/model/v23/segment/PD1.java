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
 *<p>Represents an HL7 PD1 message segment (Patient Demographic). 
 * This segment has the following fields:</p>
 * <ul>
     * <li>PD1-1: Living Dependency (IS) <b>optional </b>
     * <li>PD1-2: Living Arrangement (IS) <b>optional </b>
     * <li>PD1-3: Patient Primary Facility (XON) <b>optional repeating</b>
     * <li>PD1-4: Patient Primary Care Provider Name & ID No. (XCN) <b>optional repeating</b>
     * <li>PD1-5: Student Indicator (IS) <b>optional </b>
     * <li>PD1-6: Handicap (IS) <b>optional </b>
     * <li>PD1-7: Living Will (IS) <b>optional </b>
     * <li>PD1-8: Organ Donor (IS) <b>optional </b>
     * <li>PD1-9: Separate Bill (ID) <b>optional </b>
     * <li>PD1-10: Duplicate Patient (CX) <b>optional repeating</b>
     * <li>PD1-11: Publicity Indicator (CE) <b>optional </b>
     * <li>PD1-12: Protection Indicator (ID) <b>optional </b>
 * </ul>
 */
@SuppressWarnings("unused")
public class PD1 extends AbstractSegment {

    /** 
     * Creates a new PD1 segment
     */
    public PD1(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                              this.add(IS.class, false, 1, 2, new Object[]{ getMessage(), new Integer(223) }, "Living Dependency");
                                              this.add(IS.class, false, 1, 2, new Object[]{ getMessage(), new Integer(220) }, "Living Arrangement");
                                  this.add(XON.class, false, 0, 90, new Object[]{ getMessage() }, "Patient Primary Facility");
                                  this.add(XCN.class, false, 0, 90, new Object[]{ getMessage() }, "Patient Primary Care Provider Name & ID No.");
                                              this.add(IS.class, false, 1, 2, new Object[]{ getMessage(), new Integer(231) }, "Student Indicator");
                                              this.add(IS.class, false, 1, 2, new Object[]{ getMessage(), new Integer(310) }, "Handicap");
                                              this.add(IS.class, false, 1, 2, new Object[]{ getMessage(), new Integer(315) }, "Living Will");
                                              this.add(IS.class, false, 1, 2, new Object[]{ getMessage(), new Integer(316) }, "Organ Donor");
                                              this.add(ID.class, false, 1, 2, new Object[]{ getMessage(), new Integer(136) }, "Separate Bill");
                                  this.add(CX.class, false, 0, 2, new Object[]{ getMessage() }, "Duplicate Patient");
                                  this.add(CE.class, false, 1, 1, new Object[]{ getMessage() }, "Publicity Indicator");
                                              this.add(ID.class, false, 1, 1, new Object[]{ getMessage(), new Integer(136) }, "Protection Indicator");
       } catch(HL7Exception e) {
          log.error("Unexpected error creating PD1 - this is probably a bug in the source code generator.", e);
       }
    }



    /**
     * Returns
     * PD1-1: "Living Dependency" - creates it if necessary
     */
    public IS getLivingDependency() { 
		IS retVal = this.getTypedField(1, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PD1-1: "Living Dependency" - creates it if necessary
     */
    public IS getPd11_LivingDependency() { 
		IS retVal = this.getTypedField(1, 0);
		return retVal;
    }



    /**
     * Returns
     * PD1-2: "Living Arrangement" - creates it if necessary
     */
    public IS getLivingArrangement() { 
		IS retVal = this.getTypedField(2, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PD1-2: "Living Arrangement" - creates it if necessary
     */
    public IS getPd12_LivingArrangement() { 
		IS retVal = this.getTypedField(2, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Patient Primary Facility (PD1-3).
     */
    public XON[] getPatientPrimaryFacility() {
    	XON[] retVal = this.getTypedField(3, new XON[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Patient Primary Facility (PD1-3).
     */
    public XON[] getPd13_PatientPrimaryFacility() {
    	XON[] retVal = this.getTypedField(3, new XON[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Patient Primary Facility (PD1-3).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getPatientPrimaryFacilityReps() {
    	return this.getReps(3);
    }


    /**
     * Returns a specific repetition of
     * PD1-3: "Patient Primary Facility" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XON getPatientPrimaryFacility(int rep) { 
		XON retVal = this.getTypedField(3, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * PD1-3: "Patient Primary Facility" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XON getPd13_PatientPrimaryFacility(int rep) { 
		XON retVal = this.getTypedField(3, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Patient Primary Facility (PD1-3).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getPd13_PatientPrimaryFacilityReps() {
    	return this.getReps(3);
    }


    /**
     * Inserts a repetition of
     * PD1-3: "Patient Primary Facility" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XON insertPatientPrimaryFacility(int rep) throws HL7Exception { 
        return (XON) super.insertRepetition(3, rep);
    }


    /**
     * Inserts a repetition of
     * PD1-3: "Patient Primary Facility" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XON insertPd13_PatientPrimaryFacility(int rep) throws HL7Exception { 
        return (XON) super.insertRepetition(3, rep);
    }


    /**
     * Removes a repetition of
     * PD1-3: "Patient Primary Facility" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XON removePatientPrimaryFacility(int rep) throws HL7Exception { 
        return (XON) super.removeRepetition(3, rep);
    }


    /**
     * Removes a repetition of
     * PD1-3: "Patient Primary Facility" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XON removePd13_PatientPrimaryFacility(int rep) throws HL7Exception { 
        return (XON) super.removeRepetition(3, rep);
    }



    /**
     * Returns all repetitions of Patient Primary Care Provider Name & ID No. (PD1-4).
     */
    public XCN[] getPatientPrimaryCareProviderNameIDNo() {
    	XCN[] retVal = this.getTypedField(4, new XCN[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Patient Primary Care Provider Name & ID No. (PD1-4).
     */
    public XCN[] getPd14_PatientPrimaryCareProviderNameIDNo() {
    	XCN[] retVal = this.getTypedField(4, new XCN[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Patient Primary Care Provider Name & ID No. (PD1-4).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getPatientPrimaryCareProviderNameIDNoReps() {
    	return this.getReps(4);
    }


    /**
     * Returns a specific repetition of
     * PD1-4: "Patient Primary Care Provider Name & ID No." - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XCN getPatientPrimaryCareProviderNameIDNo(int rep) { 
		XCN retVal = this.getTypedField(4, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * PD1-4: "Patient Primary Care Provider Name & ID No." - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public XCN getPd14_PatientPrimaryCareProviderNameIDNo(int rep) { 
		XCN retVal = this.getTypedField(4, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Patient Primary Care Provider Name & ID No. (PD1-4).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getPd14_PatientPrimaryCareProviderNameIDNoReps() {
    	return this.getReps(4);
    }


    /**
     * Inserts a repetition of
     * PD1-4: "Patient Primary Care Provider Name & ID No." at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XCN insertPatientPrimaryCareProviderNameIDNo(int rep) throws HL7Exception { 
        return (XCN) super.insertRepetition(4, rep);
    }


    /**
     * Inserts a repetition of
     * PD1-4: "Patient Primary Care Provider Name & ID No." at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XCN insertPd14_PatientPrimaryCareProviderNameIDNo(int rep) throws HL7Exception { 
        return (XCN) super.insertRepetition(4, rep);
    }


    /**
     * Removes a repetition of
     * PD1-4: "Patient Primary Care Provider Name & ID No." at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XCN removePatientPrimaryCareProviderNameIDNo(int rep) throws HL7Exception { 
        return (XCN) super.removeRepetition(4, rep);
    }


    /**
     * Removes a repetition of
     * PD1-4: "Patient Primary Care Provider Name & ID No." at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public XCN removePd14_PatientPrimaryCareProviderNameIDNo(int rep) throws HL7Exception { 
        return (XCN) super.removeRepetition(4, rep);
    }




    /**
     * Returns
     * PD1-5: "Student Indicator" - creates it if necessary
     */
    public IS getStudentIndicator() { 
		IS retVal = this.getTypedField(5, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PD1-5: "Student Indicator" - creates it if necessary
     */
    public IS getPd15_StudentIndicator() { 
		IS retVal = this.getTypedField(5, 0);
		return retVal;
    }



    /**
     * Returns
     * PD1-6: "Handicap" - creates it if necessary
     */
    public IS getHandicap() { 
		IS retVal = this.getTypedField(6, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PD1-6: "Handicap" - creates it if necessary
     */
    public IS getPd16_Handicap() { 
		IS retVal = this.getTypedField(6, 0);
		return retVal;
    }



    /**
     * Returns
     * PD1-7: "Living Will" - creates it if necessary
     */
    public IS getLivingWill() { 
		IS retVal = this.getTypedField(7, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PD1-7: "Living Will" - creates it if necessary
     */
    public IS getPd17_LivingWill() { 
		IS retVal = this.getTypedField(7, 0);
		return retVal;
    }



    /**
     * Returns
     * PD1-8: "Organ Donor" - creates it if necessary
     */
    public IS getOrganDonor() { 
		IS retVal = this.getTypedField(8, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PD1-8: "Organ Donor" - creates it if necessary
     */
    public IS getPd18_OrganDonor() { 
		IS retVal = this.getTypedField(8, 0);
		return retVal;
    }



    /**
     * Returns
     * PD1-9: "Separate Bill" - creates it if necessary
     */
    public ID getSeparateBill() { 
		ID retVal = this.getTypedField(9, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PD1-9: "Separate Bill" - creates it if necessary
     */
    public ID getPd19_SeparateBill() { 
		ID retVal = this.getTypedField(9, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Duplicate Patient (PD1-10).
     */
    public CX[] getDuplicatePatient() {
    	CX[] retVal = this.getTypedField(10, new CX[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Duplicate Patient (PD1-10).
     */
    public CX[] getPd110_DuplicatePatient() {
    	CX[] retVal = this.getTypedField(10, new CX[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Duplicate Patient (PD1-10).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getDuplicatePatientReps() {
    	return this.getReps(10);
    }


    /**
     * Returns a specific repetition of
     * PD1-10: "Duplicate Patient" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CX getDuplicatePatient(int rep) { 
		CX retVal = this.getTypedField(10, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * PD1-10: "Duplicate Patient" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CX getPd110_DuplicatePatient(int rep) { 
		CX retVal = this.getTypedField(10, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Duplicate Patient (PD1-10).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getPd110_DuplicatePatientReps() {
    	return this.getReps(10);
    }


    /**
     * Inserts a repetition of
     * PD1-10: "Duplicate Patient" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CX insertDuplicatePatient(int rep) throws HL7Exception { 
        return (CX) super.insertRepetition(10, rep);
    }


    /**
     * Inserts a repetition of
     * PD1-10: "Duplicate Patient" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CX insertPd110_DuplicatePatient(int rep) throws HL7Exception { 
        return (CX) super.insertRepetition(10, rep);
    }


    /**
     * Removes a repetition of
     * PD1-10: "Duplicate Patient" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CX removeDuplicatePatient(int rep) throws HL7Exception { 
        return (CX) super.removeRepetition(10, rep);
    }


    /**
     * Removes a repetition of
     * PD1-10: "Duplicate Patient" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CX removePd110_DuplicatePatient(int rep) throws HL7Exception { 
        return (CX) super.removeRepetition(10, rep);
    }




    /**
     * Returns
     * PD1-11: "Publicity Indicator" - creates it if necessary
     */
    public CE getPublicityIndicator() { 
		CE retVal = this.getTypedField(11, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PD1-11: "Publicity Indicator" - creates it if necessary
     */
    public CE getPd111_PublicityIndicator() { 
		CE retVal = this.getTypedField(11, 0);
		return retVal;
    }



    /**
     * Returns
     * PD1-12: "Protection Indicator" - creates it if necessary
     */
    public ID getProtectionIndicator() { 
		ID retVal = this.getTypedField(12, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PD1-12: "Protection Indicator" - creates it if necessary
     */
    public ID getPd112_ProtectionIndicator() { 
		ID retVal = this.getTypedField(12, 0);
		return retVal;
    }





    /** {@inheritDoc} */   
    protected Type createNewTypeWithoutReflection(int field) {
       switch (field) {
          case 0: return new IS(getMessage(), new Integer( 223 ));
          case 1: return new IS(getMessage(), new Integer( 220 ));
          case 2: return new XON(getMessage());
          case 3: return new XCN(getMessage());
          case 4: return new IS(getMessage(), new Integer( 231 ));
          case 5: return new IS(getMessage(), new Integer( 310 ));
          case 6: return new IS(getMessage(), new Integer( 315 ));
          case 7: return new IS(getMessage(), new Integer( 316 ));
          case 8: return new ID(getMessage(), new Integer( 136 ));
          case 9: return new CX(getMessage());
          case 10: return new CE(getMessage());
          case 11: return new ID(getMessage(), new Integer( 136 ));
          default: return null;
       }
   }


}

