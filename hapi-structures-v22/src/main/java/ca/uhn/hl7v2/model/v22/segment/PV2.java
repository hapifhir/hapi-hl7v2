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


package ca.uhn.hl7v2.model.v22.segment;

// import ca.uhn.hl7v2.model.v22.group.*;
import ca.uhn.hl7v2.model.v22.datatype.*;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.parser.DefaultModelClassFactory;
import ca.uhn.hl7v2.model.AbstractMessage;
import ca.uhn.hl7v2.model.Group;
import ca.uhn.hl7v2.model.Type;
import ca.uhn.hl7v2.model.AbstractSegment;
import ca.uhn.hl7v2.model.Varies;


/**
 *<p>Represents an HL7 PV2 message segment (PATIENT VISIT - additional information). 
 * This segment has the following fields:</p>
 * <ul>
     * <li>PV2-1: Prior Pending Location (CM_INTERNAL_LOCATION) <b>optional </b>
     * <li>PV2-2: Accommodation Code (CE) <b>optional </b>
     * <li>PV2-3: Admit Reason (CE) <b>optional </b>
     * <li>PV2-4: Transfer Reason (CE) <b>optional </b>
     * <li>PV2-5: Patient Valuables (ST) <b>optional repeating</b>
     * <li>PV2-6: Patient Valuables Location (ST) <b>optional </b>
     * <li>PV2-7: Visit User Code (ID) <b>optional </b>
     * <li>PV2-8: Expected Admit Date (DT) <b>optional </b>
     * <li>PV2-9: Expected Discharge Date (DT) <b>optional </b>
 * </ul>
 */
@SuppressWarnings("unused")
public class PV2 extends AbstractSegment {

    /** 
     * Creates a new PV2 segment
     */
    public PV2(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(CM_INTERNAL_LOCATION.class, false, 1, 12, new Object[]{ getMessage() }, "Prior Pending Location");
                                  this.add(CE.class, false, 1, 60, new Object[]{ getMessage() }, "Accommodation Code");
                                  this.add(CE.class, false, 1, 60, new Object[]{ getMessage() }, "Admit Reason");
                                  this.add(CE.class, false, 1, 60, new Object[]{ getMessage() }, "Transfer Reason");
                                  this.add(ST.class, false, 0, 25, new Object[]{ getMessage() }, "Patient Valuables");
                                  this.add(ST.class, false, 1, 25, new Object[]{ getMessage() }, "Patient Valuables Location");
                                              this.add(ID.class, false, 1, 2, new Object[]{ getMessage(), new Integer(130) }, "Visit User Code");
                                  this.add(DT.class, false, 1, 8, new Object[]{ getMessage() }, "Expected Admit Date");
                                  this.add(DT.class, false, 1, 8, new Object[]{ getMessage() }, "Expected Discharge Date");
       } catch(HL7Exception e) {
          log.error("Unexpected error creating PV2 - this is probably a bug in the source code generator.", e);
       }
    }



    /**
     * Returns
     * PV2-1: "Prior Pending Location" - creates it if necessary
     */
    public CM_INTERNAL_LOCATION getPriorPendingLocation() { 
		CM_INTERNAL_LOCATION retVal = this.getTypedField(1, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PV2-1: "Prior Pending Location" - creates it if necessary
     */
    public CM_INTERNAL_LOCATION getPv21_PriorPendingLocation() { 
		CM_INTERNAL_LOCATION retVal = this.getTypedField(1, 0);
		return retVal;
    }



    /**
     * Returns
     * PV2-2: "Accommodation Code" - creates it if necessary
     */
    public CE getAccommodationCode() { 
		CE retVal = this.getTypedField(2, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PV2-2: "Accommodation Code" - creates it if necessary
     */
    public CE getPv22_AccommodationCode() { 
		CE retVal = this.getTypedField(2, 0);
		return retVal;
    }



    /**
     * Returns
     * PV2-3: "Admit Reason" - creates it if necessary
     */
    public CE getAdmitReason() { 
		CE retVal = this.getTypedField(3, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PV2-3: "Admit Reason" - creates it if necessary
     */
    public CE getPv23_AdmitReason() { 
		CE retVal = this.getTypedField(3, 0);
		return retVal;
    }



    /**
     * Returns
     * PV2-4: "Transfer Reason" - creates it if necessary
     */
    public CE getTransferReason() { 
		CE retVal = this.getTypedField(4, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PV2-4: "Transfer Reason" - creates it if necessary
     */
    public CE getPv24_TransferReason() { 
		CE retVal = this.getTypedField(4, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Patient Valuables (PV2-5).
     */
    public ST[] getPatientValuables() {
    	ST[] retVal = this.getTypedField(5, new ST[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Patient Valuables (PV2-5).
     */
    public ST[] getPv25_PatientValuables() {
    	ST[] retVal = this.getTypedField(5, new ST[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Patient Valuables (PV2-5).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getPatientValuablesReps() {
    	return this.getReps(5);
    }


    /**
     * Returns a specific repetition of
     * PV2-5: "Patient Valuables" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public ST getPatientValuables(int rep) { 
		ST retVal = this.getTypedField(5, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * PV2-5: "Patient Valuables" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public ST getPv25_PatientValuables(int rep) { 
		ST retVal = this.getTypedField(5, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Patient Valuables (PV2-5).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getPv25_PatientValuablesReps() {
    	return this.getReps(5);
    }


    /**
     * Inserts a repetition of
     * PV2-5: "Patient Valuables" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ST insertPatientValuables(int rep) throws HL7Exception { 
        return (ST) super.insertRepetition(5, rep);
    }


    /**
     * Inserts a repetition of
     * PV2-5: "Patient Valuables" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ST insertPv25_PatientValuables(int rep) throws HL7Exception { 
        return (ST) super.insertRepetition(5, rep);
    }


    /**
     * Removes a repetition of
     * PV2-5: "Patient Valuables" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ST removePatientValuables(int rep) throws HL7Exception { 
        return (ST) super.removeRepetition(5, rep);
    }


    /**
     * Removes a repetition of
     * PV2-5: "Patient Valuables" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ST removePv25_PatientValuables(int rep) throws HL7Exception { 
        return (ST) super.removeRepetition(5, rep);
    }




    /**
     * Returns
     * PV2-6: "Patient Valuables Location" - creates it if necessary
     */
    public ST getPatientValuablesLocation() { 
		ST retVal = this.getTypedField(6, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PV2-6: "Patient Valuables Location" - creates it if necessary
     */
    public ST getPv26_PatientValuablesLocation() { 
		ST retVal = this.getTypedField(6, 0);
		return retVal;
    }



    /**
     * Returns
     * PV2-7: "Visit User Code" - creates it if necessary
     */
    public ID getVisitUserCode() { 
		ID retVal = this.getTypedField(7, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PV2-7: "Visit User Code" - creates it if necessary
     */
    public ID getPv27_VisitUserCode() { 
		ID retVal = this.getTypedField(7, 0);
		return retVal;
    }



    /**
     * Returns
     * PV2-8: "Expected Admit Date" - creates it if necessary
     */
    public DT getExpectedAdmitDate() { 
		DT retVal = this.getTypedField(8, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PV2-8: "Expected Admit Date" - creates it if necessary
     */
    public DT getPv28_ExpectedAdmitDate() { 
		DT retVal = this.getTypedField(8, 0);
		return retVal;
    }



    /**
     * Returns
     * PV2-9: "Expected Discharge Date" - creates it if necessary
     */
    public DT getExpectedDischargeDate() { 
		DT retVal = this.getTypedField(9, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PV2-9: "Expected Discharge Date" - creates it if necessary
     */
    public DT getPv29_ExpectedDischargeDate() { 
		DT retVal = this.getTypedField(9, 0);
		return retVal;
    }





    /** {@inheritDoc} */   
    protected Type createNewTypeWithoutReflection(int field) {
       switch (field) {
          case 0: return new CM_INTERNAL_LOCATION(getMessage());
          case 1: return new CE(getMessage());
          case 2: return new CE(getMessage());
          case 3: return new CE(getMessage());
          case 4: return new ST(getMessage());
          case 5: return new ST(getMessage());
          case 6: return new ID(getMessage(), new Integer( 130 ));
          case 7: return new DT(getMessage());
          case 8: return new DT(getMessage());
          default: return null;
       }
   }


}

