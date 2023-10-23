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
 *<p>Represents an HL7 PR1 message segment (PROCEDURES). 
 * This segment has the following fields:</p>
 * <ul>
     * <li>PR1-1: Set ID - procedure (SI) <b> </b>
     * <li>PR1-2: Procedure coding method (ID) <b> repeating</b>
     * <li>PR1-3: Procedure code (ID) <b> repeating</b>
     * <li>PR1-4: Procedure description (ST) <b>optional repeating</b>
     * <li>PR1-5: Procedure date / time (TS) <b> </b>
     * <li>PR1-6: Procedure type (ID) <b> </b>
     * <li>PR1-7: Procedure minutes (NM) <b>optional </b>
     * <li>PR1-8: Anesthesiologist (CN) <b>optional </b>
     * <li>PR1-9: Anesthesia code (ID) <b>optional </b>
     * <li>PR1-10: Anesthesia minutes (NM) <b>optional </b>
     * <li>PR1-11: Surgeon (CN) <b>optional </b>
     * <li>PR1-12: Procedure Practitioner (CM_PRACTITIONER) <b>optional repeating</b>
     * <li>PR1-13: Consent code (ID) <b>optional </b>
     * <li>PR1-14: Procedure priority (NM) <b>optional </b>
 * </ul>
 */
@SuppressWarnings("unused")
public class PR1 extends AbstractSegment {

    /** 
     * Creates a new PR1 segment
     */
    public PR1(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(SI.class, true, 1, 4, new Object[]{ getMessage() }, "Set ID - procedure");
                                              this.add(ID.class, true, 0, 2, new Object[]{ getMessage(), new Integer(89) }, "Procedure coding method");
                                              this.add(ID.class, true, 0, 10, new Object[]{ getMessage(), new Integer(88) }, "Procedure code");
                                  this.add(ST.class, false, 0, 40, new Object[]{ getMessage() }, "Procedure description");
                                  this.add(TS.class, true, 1, 26, new Object[]{ getMessage() }, "Procedure date / time");
                                              this.add(ID.class, true, 1, 2, new Object[]{ getMessage(), new Integer(90) }, "Procedure type");
                                  this.add(NM.class, false, 1, 4, new Object[]{ getMessage() }, "Procedure minutes");
                                  this.add(CN.class, false, 1, 60, new Object[]{ getMessage() }, "Anesthesiologist");
                                              this.add(ID.class, false, 1, 2, new Object[]{ getMessage(), new Integer(19) }, "Anesthesia code");
                                  this.add(NM.class, false, 1, 4, new Object[]{ getMessage() }, "Anesthesia minutes");
                                  this.add(CN.class, false, 1, 60, new Object[]{ getMessage() }, "Surgeon");
                                  this.add(CM_PRACTITIONER.class, false, 0, 60, new Object[]{ getMessage() }, "Procedure Practitioner");
                                              this.add(ID.class, false, 1, 2, new Object[]{ getMessage(), new Integer(59) }, "Consent code");
                                  this.add(NM.class, false, 1, 2, new Object[]{ getMessage() }, "Procedure priority");
       } catch(HL7Exception e) {
          log.error("Unexpected error creating PR1 - this is probably a bug in the source code generator.", e);
       }
    }



    /**
     * Returns
     * PR1-1: "Set ID - procedure" - creates it if necessary
     */
    public SI getSetIDProcedure() { 
		SI retVal = this.getTypedField(1, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PR1-1: "Set ID - procedure" - creates it if necessary
     */
    public SI getPr11_SetIDProcedure() { 
		SI retVal = this.getTypedField(1, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Procedure coding method (PR1-2).
     */
    public ID[] getProcedureCodingMethod() {
    	ID[] retVal = this.getTypedField(2, new ID[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Procedure coding method (PR1-2).
     */
    public ID[] getPr12_ProcedureCodingMethod() {
    	ID[] retVal = this.getTypedField(2, new ID[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Procedure coding method (PR1-2).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getProcedureCodingMethodReps() {
    	return this.getReps(2);
    }


    /**
     * Returns a specific repetition of
     * PR1-2: "Procedure coding method" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public ID getProcedureCodingMethod(int rep) { 
		ID retVal = this.getTypedField(2, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * PR1-2: "Procedure coding method" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public ID getPr12_ProcedureCodingMethod(int rep) { 
		ID retVal = this.getTypedField(2, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Procedure coding method (PR1-2).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getPr12_ProcedureCodingMethodReps() {
    	return this.getReps(2);
    }


    /**
     * Inserts a repetition of
     * PR1-2: "Procedure coding method" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ID insertProcedureCodingMethod(int rep) throws HL7Exception { 
        return (ID) super.insertRepetition(2, rep);
    }


    /**
     * Inserts a repetition of
     * PR1-2: "Procedure coding method" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ID insertPr12_ProcedureCodingMethod(int rep) throws HL7Exception { 
        return (ID) super.insertRepetition(2, rep);
    }


    /**
     * Removes a repetition of
     * PR1-2: "Procedure coding method" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ID removeProcedureCodingMethod(int rep) throws HL7Exception { 
        return (ID) super.removeRepetition(2, rep);
    }


    /**
     * Removes a repetition of
     * PR1-2: "Procedure coding method" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ID removePr12_ProcedureCodingMethod(int rep) throws HL7Exception { 
        return (ID) super.removeRepetition(2, rep);
    }



    /**
     * Returns all repetitions of Procedure code (PR1-3).
     */
    public ID[] getProcedureCode() {
    	ID[] retVal = this.getTypedField(3, new ID[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Procedure code (PR1-3).
     */
    public ID[] getPr13_ProcedureCode() {
    	ID[] retVal = this.getTypedField(3, new ID[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Procedure code (PR1-3).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getProcedureCodeReps() {
    	return this.getReps(3);
    }


    /**
     * Returns a specific repetition of
     * PR1-3: "Procedure code" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public ID getProcedureCode(int rep) { 
		ID retVal = this.getTypedField(3, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * PR1-3: "Procedure code" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public ID getPr13_ProcedureCode(int rep) { 
		ID retVal = this.getTypedField(3, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Procedure code (PR1-3).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getPr13_ProcedureCodeReps() {
    	return this.getReps(3);
    }


    /**
     * Inserts a repetition of
     * PR1-3: "Procedure code" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ID insertProcedureCode(int rep) throws HL7Exception { 
        return (ID) super.insertRepetition(3, rep);
    }


    /**
     * Inserts a repetition of
     * PR1-3: "Procedure code" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ID insertPr13_ProcedureCode(int rep) throws HL7Exception { 
        return (ID) super.insertRepetition(3, rep);
    }


    /**
     * Removes a repetition of
     * PR1-3: "Procedure code" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ID removeProcedureCode(int rep) throws HL7Exception { 
        return (ID) super.removeRepetition(3, rep);
    }


    /**
     * Removes a repetition of
     * PR1-3: "Procedure code" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ID removePr13_ProcedureCode(int rep) throws HL7Exception { 
        return (ID) super.removeRepetition(3, rep);
    }



    /**
     * Returns all repetitions of Procedure description (PR1-4).
     */
    public ST[] getProcedureDescription() {
    	ST[] retVal = this.getTypedField(4, new ST[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Procedure description (PR1-4).
     */
    public ST[] getPr14_ProcedureDescription() {
    	ST[] retVal = this.getTypedField(4, new ST[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Procedure description (PR1-4).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getProcedureDescriptionReps() {
    	return this.getReps(4);
    }


    /**
     * Returns a specific repetition of
     * PR1-4: "Procedure description" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public ST getProcedureDescription(int rep) { 
		ST retVal = this.getTypedField(4, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * PR1-4: "Procedure description" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public ST getPr14_ProcedureDescription(int rep) { 
		ST retVal = this.getTypedField(4, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Procedure description (PR1-4).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getPr14_ProcedureDescriptionReps() {
    	return this.getReps(4);
    }


    /**
     * Inserts a repetition of
     * PR1-4: "Procedure description" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ST insertProcedureDescription(int rep) throws HL7Exception { 
        return (ST) super.insertRepetition(4, rep);
    }


    /**
     * Inserts a repetition of
     * PR1-4: "Procedure description" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ST insertPr14_ProcedureDescription(int rep) throws HL7Exception { 
        return (ST) super.insertRepetition(4, rep);
    }


    /**
     * Removes a repetition of
     * PR1-4: "Procedure description" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ST removeProcedureDescription(int rep) throws HL7Exception { 
        return (ST) super.removeRepetition(4, rep);
    }


    /**
     * Removes a repetition of
     * PR1-4: "Procedure description" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ST removePr14_ProcedureDescription(int rep) throws HL7Exception { 
        return (ST) super.removeRepetition(4, rep);
    }




    /**
     * Returns
     * PR1-5: "Procedure date / time" - creates it if necessary
     */
    public TS getProcedureDateTime() { 
		TS retVal = this.getTypedField(5, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PR1-5: "Procedure date / time" - creates it if necessary
     */
    public TS getPr15_ProcedureDateTime() { 
		TS retVal = this.getTypedField(5, 0);
		return retVal;
    }



    /**
     * Returns
     * PR1-6: "Procedure type" - creates it if necessary
     */
    public ID getProcedureType() { 
		ID retVal = this.getTypedField(6, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PR1-6: "Procedure type" - creates it if necessary
     */
    public ID getPr16_ProcedureType() { 
		ID retVal = this.getTypedField(6, 0);
		return retVal;
    }



    /**
     * Returns
     * PR1-7: "Procedure minutes" - creates it if necessary
     */
    public NM getProcedureMinutes() { 
		NM retVal = this.getTypedField(7, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PR1-7: "Procedure minutes" - creates it if necessary
     */
    public NM getPr17_ProcedureMinutes() { 
		NM retVal = this.getTypedField(7, 0);
		return retVal;
    }



    /**
     * Returns
     * PR1-8: "Anesthesiologist" - creates it if necessary
     */
    public CN getAnesthesiologist() { 
		CN retVal = this.getTypedField(8, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PR1-8: "Anesthesiologist" - creates it if necessary
     */
    public CN getPr18_Anesthesiologist() { 
		CN retVal = this.getTypedField(8, 0);
		return retVal;
    }



    /**
     * Returns
     * PR1-9: "Anesthesia code" - creates it if necessary
     */
    public ID getAnesthesiaCode() { 
		ID retVal = this.getTypedField(9, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PR1-9: "Anesthesia code" - creates it if necessary
     */
    public ID getPr19_AnesthesiaCode() { 
		ID retVal = this.getTypedField(9, 0);
		return retVal;
    }



    /**
     * Returns
     * PR1-10: "Anesthesia minutes" - creates it if necessary
     */
    public NM getAnesthesiaMinutes() { 
		NM retVal = this.getTypedField(10, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PR1-10: "Anesthesia minutes" - creates it if necessary
     */
    public NM getPr110_AnesthesiaMinutes() { 
		NM retVal = this.getTypedField(10, 0);
		return retVal;
    }



    /**
     * Returns
     * PR1-11: "Surgeon" - creates it if necessary
     */
    public CN getSurgeon() { 
		CN retVal = this.getTypedField(11, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PR1-11: "Surgeon" - creates it if necessary
     */
    public CN getPr111_Surgeon() { 
		CN retVal = this.getTypedField(11, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Procedure Practitioner (PR1-12).
     */
    public CM_PRACTITIONER[] getProcedurePractitioner() {
    	CM_PRACTITIONER[] retVal = this.getTypedField(12, new CM_PRACTITIONER[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Procedure Practitioner (PR1-12).
     */
    public CM_PRACTITIONER[] getPr112_ProcedurePractitioner() {
    	CM_PRACTITIONER[] retVal = this.getTypedField(12, new CM_PRACTITIONER[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Procedure Practitioner (PR1-12).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getProcedurePractitionerReps() {
    	return this.getReps(12);
    }


    /**
     * Returns a specific repetition of
     * PR1-12: "Procedure Practitioner" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CM_PRACTITIONER getProcedurePractitioner(int rep) { 
		CM_PRACTITIONER retVal = this.getTypedField(12, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * PR1-12: "Procedure Practitioner" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CM_PRACTITIONER getPr112_ProcedurePractitioner(int rep) { 
		CM_PRACTITIONER retVal = this.getTypedField(12, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Procedure Practitioner (PR1-12).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getPr112_ProcedurePractitionerReps() {
    	return this.getReps(12);
    }


    /**
     * Inserts a repetition of
     * PR1-12: "Procedure Practitioner" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CM_PRACTITIONER insertProcedurePractitioner(int rep) throws HL7Exception { 
        return (CM_PRACTITIONER) super.insertRepetition(12, rep);
    }


    /**
     * Inserts a repetition of
     * PR1-12: "Procedure Practitioner" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CM_PRACTITIONER insertPr112_ProcedurePractitioner(int rep) throws HL7Exception { 
        return (CM_PRACTITIONER) super.insertRepetition(12, rep);
    }


    /**
     * Removes a repetition of
     * PR1-12: "Procedure Practitioner" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CM_PRACTITIONER removeProcedurePractitioner(int rep) throws HL7Exception { 
        return (CM_PRACTITIONER) super.removeRepetition(12, rep);
    }


    /**
     * Removes a repetition of
     * PR1-12: "Procedure Practitioner" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CM_PRACTITIONER removePr112_ProcedurePractitioner(int rep) throws HL7Exception { 
        return (CM_PRACTITIONER) super.removeRepetition(12, rep);
    }




    /**
     * Returns
     * PR1-13: "Consent code" - creates it if necessary
     */
    public ID getConsentCode() { 
		ID retVal = this.getTypedField(13, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PR1-13: "Consent code" - creates it if necessary
     */
    public ID getPr113_ConsentCode() { 
		ID retVal = this.getTypedField(13, 0);
		return retVal;
    }



    /**
     * Returns
     * PR1-14: "Procedure priority" - creates it if necessary
     */
    public NM getProcedurePriority() { 
		NM retVal = this.getTypedField(14, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PR1-14: "Procedure priority" - creates it if necessary
     */
    public NM getPr114_ProcedurePriority() { 
		NM retVal = this.getTypedField(14, 0);
		return retVal;
    }





    /** {@inheritDoc} */   
    protected Type createNewTypeWithoutReflection(int field) {
       switch (field) {
          case 0: return new SI(getMessage());
          case 1: return new ID(getMessage(), new Integer( 89 ));
          case 2: return new ID(getMessage(), new Integer( 88 ));
          case 3: return new ST(getMessage());
          case 4: return new TS(getMessage());
          case 5: return new ID(getMessage(), new Integer( 90 ));
          case 6: return new NM(getMessage());
          case 7: return new CN(getMessage());
          case 8: return new ID(getMessage(), new Integer( 19 ));
          case 9: return new NM(getMessage());
          case 10: return new CN(getMessage());
          case 11: return new CM_PRACTITIONER(getMessage());
          case 12: return new ID(getMessage(), new Integer( 59 ));
          case 13: return new NM(getMessage());
          default: return null;
       }
   }


}

