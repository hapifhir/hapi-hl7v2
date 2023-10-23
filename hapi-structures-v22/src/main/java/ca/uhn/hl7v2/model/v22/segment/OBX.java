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
 *<p>Represents an HL7 OBX message segment (OBSERVATION RESULT). 
 * This segment has the following fields:</p>
 * <ul>
     * <li>OBX-1: Set ID - Observational Simple (SI) <b>optional </b>
     * <li>OBX-2: Value Type (ID) <b> </b>
     * <li>OBX-3: Observation Identifier (CE) <b> </b>
     * <li>OBX-4: Observation Sub-ID (ST) <b>optional </b>
     * <li>OBX-5: Observation Value (Varies) <b>optional </b>
     * <li>OBX-6: Units (CE) <b>optional </b>
     * <li>OBX-7: References Range (ST) <b>optional </b>
     * <li>OBX-8: Abnormal Flags (ID) <b>optional repeating</b>
     * <li>OBX-9: Probability (NM) <b>optional </b>
     * <li>OBX-10: Nature of Abnormal Test (ID) <b>optional </b>
     * <li>OBX-11: Observation result status (ID) <b> </b>
     * <li>OBX-12: Effective date last observation normal values (TS) <b>optional </b>
     * <li>OBX-13: User Defined Access Checks (ST) <b>optional </b>
     * <li>OBX-14: Date / time of the observation (TS) <b>optional </b>
     * <li>OBX-15: Producer's ID (CE) <b>optional </b>
     * <li>OBX-16: Responsible Observer (CN) <b>optional </b>
 * </ul>
 */
@SuppressWarnings("unused")
public class OBX extends AbstractSegment {

    /** 
     * Creates a new OBX segment
     */
    public OBX(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(SI.class, false, 1, 4, new Object[]{ getMessage() }, "Set ID - Observational Simple");
                                              this.add(ID.class, true, 1, 2, new Object[]{ getMessage(), new Integer(125) }, "Value Type");
                                  this.add(CE.class, true, 1, 80, new Object[]{ getMessage() }, "Observation Identifier");
                                  this.add(ST.class, false, 1, 20, new Object[]{ getMessage() }, "Observation Sub-ID");
                                  this.add(Varies.class, false, 1, 65536, new Object[]{ getMessage() }, "Observation Value");
                                  this.add(CE.class, false, 1, 60, new Object[]{ getMessage() }, "Units");
                                  this.add(ST.class, false, 1, 60, new Object[]{ getMessage() }, "References Range");
                                              this.add(ID.class, false, 5, 10, new Object[]{ getMessage(), new Integer(78) }, "Abnormal Flags");
                                  this.add(NM.class, false, 1, 5, new Object[]{ getMessage() }, "Probability");
                                              this.add(ID.class, false, 1, 5, new Object[]{ getMessage(), new Integer(80) }, "Nature of Abnormal Test");
                                              this.add(ID.class, true, 1, 2, new Object[]{ getMessage(), new Integer(85) }, "Observation result status");
                                  this.add(TS.class, false, 1, 26, new Object[]{ getMessage() }, "Effective date last observation normal values");
                                  this.add(ST.class, false, 1, 20, new Object[]{ getMessage() }, "User Defined Access Checks");
                                  this.add(TS.class, false, 1, 26, new Object[]{ getMessage() }, "Date / time of the observation");
                                  this.add(CE.class, false, 1, 60, new Object[]{ getMessage() }, "Producer's ID");
                                  this.add(CN.class, false, 1, 60, new Object[]{ getMessage() }, "Responsible Observer");
       } catch(HL7Exception e) {
          log.error("Unexpected error creating OBX - this is probably a bug in the source code generator.", e);
       }
    }



    /**
     * Returns
     * OBX-1: "Set ID - Observational Simple" - creates it if necessary
     */
    public SI getSetIDObservationalSimple() { 
		SI retVal = this.getTypedField(1, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OBX-1: "Set ID - Observational Simple" - creates it if necessary
     */
    public SI getObx1_SetIDObservationalSimple() { 
		SI retVal = this.getTypedField(1, 0);
		return retVal;
    }



    /**
     * Returns
     * OBX-2: "Value Type" - creates it if necessary
     */
    public ID getValueType() { 
		ID retVal = this.getTypedField(2, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OBX-2: "Value Type" - creates it if necessary
     */
    public ID getObx2_ValueType() { 
		ID retVal = this.getTypedField(2, 0);
		return retVal;
    }



    /**
     * Returns
     * OBX-3: "Observation Identifier" - creates it if necessary
     */
    public CE getObservationIdentifier() { 
		CE retVal = this.getTypedField(3, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OBX-3: "Observation Identifier" - creates it if necessary
     */
    public CE getObx3_ObservationIdentifier() { 
		CE retVal = this.getTypedField(3, 0);
		return retVal;
    }



    /**
     * Returns
     * OBX-4: "Observation Sub-ID" - creates it if necessary
     */
    public ST getObservationSubID() { 
		ST retVal = this.getTypedField(4, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OBX-4: "Observation Sub-ID" - creates it if necessary
     */
    public ST getObx4_ObservationSubID() { 
		ST retVal = this.getTypedField(4, 0);
		return retVal;
    }



    /**
     * Returns
     * OBX-5: "Observation Value" - creates it if necessary
     */
    public Varies getObservationValue() { 
		Varies retVal = this.getTypedField(5, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OBX-5: "Observation Value" - creates it if necessary
     */
    public Varies getObx5_ObservationValue() { 
		Varies retVal = this.getTypedField(5, 0);
		return retVal;
    }



    /**
     * Returns
     * OBX-6: "Units" - creates it if necessary
     */
    public CE getUnits() { 
		CE retVal = this.getTypedField(6, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OBX-6: "Units" - creates it if necessary
     */
    public CE getObx6_Units() { 
		CE retVal = this.getTypedField(6, 0);
		return retVal;
    }



    /**
     * Returns
     * OBX-7: "References Range" - creates it if necessary
     */
    public ST getReferencesRange() { 
		ST retVal = this.getTypedField(7, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OBX-7: "References Range" - creates it if necessary
     */
    public ST getObx7_ReferencesRange() { 
		ST retVal = this.getTypedField(7, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Abnormal Flags (OBX-8).
     */
    public ID[] getAbnormalFlags() {
    	ID[] retVal = this.getTypedField(8, new ID[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Abnormal Flags (OBX-8).
     */
    public ID[] getObx8_AbnormalFlags() {
    	ID[] retVal = this.getTypedField(8, new ID[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Abnormal Flags (OBX-8).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getAbnormalFlagsReps() {
    	return this.getReps(8);
    }


    /**
     * Returns a specific repetition of
     * OBX-8: "Abnormal Flags" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public ID getAbnormalFlags(int rep) { 
		ID retVal = this.getTypedField(8, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * OBX-8: "Abnormal Flags" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public ID getObx8_AbnormalFlags(int rep) { 
		ID retVal = this.getTypedField(8, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Abnormal Flags (OBX-8).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getObx8_AbnormalFlagsReps() {
    	return this.getReps(8);
    }


    /**
     * Inserts a repetition of
     * OBX-8: "Abnormal Flags" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ID insertAbnormalFlags(int rep) throws HL7Exception { 
        return (ID) super.insertRepetition(8, rep);
    }


    /**
     * Inserts a repetition of
     * OBX-8: "Abnormal Flags" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ID insertObx8_AbnormalFlags(int rep) throws HL7Exception { 
        return (ID) super.insertRepetition(8, rep);
    }


    /**
     * Removes a repetition of
     * OBX-8: "Abnormal Flags" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ID removeAbnormalFlags(int rep) throws HL7Exception { 
        return (ID) super.removeRepetition(8, rep);
    }


    /**
     * Removes a repetition of
     * OBX-8: "Abnormal Flags" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ID removeObx8_AbnormalFlags(int rep) throws HL7Exception { 
        return (ID) super.removeRepetition(8, rep);
    }




    /**
     * Returns
     * OBX-9: "Probability" - creates it if necessary
     */
    public NM getProbability() { 
		NM retVal = this.getTypedField(9, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OBX-9: "Probability" - creates it if necessary
     */
    public NM getObx9_Probability() { 
		NM retVal = this.getTypedField(9, 0);
		return retVal;
    }



    /**
     * Returns
     * OBX-10: "Nature of Abnormal Test" - creates it if necessary
     */
    public ID getNatureOfAbnormalTest() { 
		ID retVal = this.getTypedField(10, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OBX-10: "Nature of Abnormal Test" - creates it if necessary
     */
    public ID getObx10_NatureOfAbnormalTest() { 
		ID retVal = this.getTypedField(10, 0);
		return retVal;
    }



    /**
     * Returns
     * OBX-11: "Observation result status" - creates it if necessary
     */
    public ID getObservationResultStatus() { 
		ID retVal = this.getTypedField(11, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OBX-11: "Observation result status" - creates it if necessary
     */
    public ID getObx11_ObservationResultStatus() { 
		ID retVal = this.getTypedField(11, 0);
		return retVal;
    }



    /**
     * Returns
     * OBX-12: "Effective date last observation normal values" - creates it if necessary
     */
    public TS getEffectiveDateLastObservationNormalValues() { 
		TS retVal = this.getTypedField(12, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OBX-12: "Effective date last observation normal values" - creates it if necessary
     */
    public TS getObx12_EffectiveDateLastObservationNormalValues() { 
		TS retVal = this.getTypedField(12, 0);
		return retVal;
    }



    /**
     * Returns
     * OBX-13: "User Defined Access Checks" - creates it if necessary
     */
    public ST getUserDefinedAccessChecks() { 
		ST retVal = this.getTypedField(13, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OBX-13: "User Defined Access Checks" - creates it if necessary
     */
    public ST getObx13_UserDefinedAccessChecks() { 
		ST retVal = this.getTypedField(13, 0);
		return retVal;
    }



    /**
     * Returns
     * OBX-14: "Date / time of the observation" - creates it if necessary
     */
    public TS getDateTimeOfTheObservation() { 
		TS retVal = this.getTypedField(14, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OBX-14: "Date / time of the observation" - creates it if necessary
     */
    public TS getObx14_DateTimeOfTheObservation() { 
		TS retVal = this.getTypedField(14, 0);
		return retVal;
    }



    /**
     * Returns
     * OBX-15: "Producer's ID" - creates it if necessary
     */
    public CE getProducerSID() { 
		CE retVal = this.getTypedField(15, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OBX-15: "Producer's ID" - creates it if necessary
     */
    public CE getObx15_ProducerSID() { 
		CE retVal = this.getTypedField(15, 0);
		return retVal;
    }



    /**
     * Returns
     * OBX-16: "Responsible Observer" - creates it if necessary
     */
    public CN getResponsibleObserver() { 
		CN retVal = this.getTypedField(16, 0);
		return retVal;
    }
    
    /**
     * Returns
     * OBX-16: "Responsible Observer" - creates it if necessary
     */
    public CN getObx16_ResponsibleObserver() { 
		CN retVal = this.getTypedField(16, 0);
		return retVal;
    }





    /** {@inheritDoc} */   
    protected Type createNewTypeWithoutReflection(int field) {
       switch (field) {
          case 0: return new SI(getMessage());
          case 1: return new ID(getMessage(), new Integer( 125 ));
          case 2: return new CE(getMessage());
          case 3: return new ST(getMessage());
          case 4: return new Varies(getMessage());
          case 5: return new CE(getMessage());
          case 6: return new ST(getMessage());
          case 7: return new ID(getMessage(), new Integer( 78 ));
          case 8: return new NM(getMessage());
          case 9: return new ID(getMessage(), new Integer( 80 ));
          case 10: return new ID(getMessage(), new Integer( 85 ));
          case 11: return new TS(getMessage());
          case 12: return new ST(getMessage());
          case 13: return new TS(getMessage());
          case 14: return new CE(getMessage());
          case 15: return new CN(getMessage());
          default: return null;
       }
   }


}

