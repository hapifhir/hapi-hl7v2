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


package ca.uhn.hl7v2.model.v281.segment;

// import ca.uhn.hl7v2.model.v281.group.*;
import ca.uhn.hl7v2.model.v281.datatype.*;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.parser.DefaultModelClassFactory;
import ca.uhn.hl7v2.model.AbstractMessage;
import ca.uhn.hl7v2.model.Group;
import ca.uhn.hl7v2.model.Type;
import ca.uhn.hl7v2.model.AbstractSegment;
import ca.uhn.hl7v2.model.Varies;


/**
 *<p>Represents an HL7 SCD message segment (Anti-Microbial Cycle Data). 
 * This segment has the following fields:</p>
 * <ul>
     * <li>SCD-1: Cycle Start Time (TM) <b>optional </b>
     * <li>SCD-2: Cycle Count (NM) <b>optional </b>
     * <li>SCD-3: Temp Max (CQ) <b>optional </b>
     * <li>SCD-4: Temp Min (CQ) <b>optional </b>
     * <li>SCD-5: Load Number (NM) <b>optional </b>
     * <li>SCD-6: Condition Time (CQ) <b>optional </b>
     * <li>SCD-7: Sterilize Time (CQ) <b>optional </b>
     * <li>SCD-8: Exhaust Time (CQ) <b>optional </b>
     * <li>SCD-9: Total Cycle Time (CQ) <b>optional </b>
     * <li>SCD-10: Device Status (CWE) <b>optional </b>
     * <li>SCD-11: Cycle Start Date/Time (DTM) <b>optional </b>
     * <li>SCD-12: Dry Time (CQ) <b>optional </b>
     * <li>SCD-13: Leak Rate (CQ) <b>optional </b>
     * <li>SCD-14: Control Temperature (CQ) <b>optional </b>
     * <li>SCD-15: Sterilizer Temperature (CQ) <b>optional </b>
     * <li>SCD-16: Cycle Complete Time (TM) <b>optional </b>
     * <li>SCD-17: Under Temperature (CQ) <b>optional </b>
     * <li>SCD-18: Over Temperature (CQ) <b>optional </b>
     * <li>SCD-19: Abort Cycle (CNE) <b>optional </b>
     * <li>SCD-20: Alarm (CNE) <b>optional </b>
     * <li>SCD-21: Long in Charge Phase (CNE) <b>optional </b>
     * <li>SCD-22: Long in Exhaust Phase (CNE) <b>optional </b>
     * <li>SCD-23: Long in Fast Exhaust Phase (CNE) <b>optional </b>
     * <li>SCD-24: Reset (CNE) <b>optional </b>
     * <li>SCD-25: Operator - Unload (XCN) <b>optional </b>
     * <li>SCD-26: Door Open (CNE) <b>optional </b>
     * <li>SCD-27: Reading Failure (CNE) <b>optional </b>
     * <li>SCD-28: Cycle Type (CWE) <b>optional </b>
     * <li>SCD-29: Thermal Rinse Time (CQ) <b>optional </b>
     * <li>SCD-30: Wash Time (CQ) <b>optional </b>
     * <li>SCD-31: Injection Rate (CQ) <b>optional </b>
     * <li>SCD-32: Procedure Code (CNE) <b>optional </b>
     * <li>SCD-33: Patient Identifier List (CX) <b>optional repeating</b>
     * <li>SCD-34: Attending Doctor (XCN) <b>optional </b>
     * <li>SCD-35: Dilution Factor (SN) <b>optional </b>
     * <li>SCD-36: Fill Time (CQ) <b>optional </b>
     * <li>SCD-37: Inlet Temperature (CQ) <b>optional </b>
 * </ul>
 */
@SuppressWarnings("unused")
public class SCD extends AbstractSegment {

    /** 
     * Creates a new SCD segment
     */
    public SCD(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(TM.class, false, 1, 0, new Object[]{ getMessage() }, "Cycle Start Time");
                                  this.add(NM.class, false, 1, 0, new Object[]{ getMessage() }, "Cycle Count");
                                  this.add(CQ.class, false, 1, 0, new Object[]{ getMessage() }, "Temp Max");
                                  this.add(CQ.class, false, 1, 0, new Object[]{ getMessage() }, "Temp Min");
                                  this.add(NM.class, false, 1, 0, new Object[]{ getMessage() }, "Load Number");
                                  this.add(CQ.class, false, 1, 0, new Object[]{ getMessage() }, "Condition Time");
                                  this.add(CQ.class, false, 1, 0, new Object[]{ getMessage() }, "Sterilize Time");
                                  this.add(CQ.class, false, 1, 0, new Object[]{ getMessage() }, "Exhaust Time");
                                  this.add(CQ.class, false, 1, 0, new Object[]{ getMessage() }, "Total Cycle Time");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "Device Status");
                                  this.add(DTM.class, false, 1, 0, new Object[]{ getMessage() }, "Cycle Start Date/Time");
                                  this.add(CQ.class, false, 1, 0, new Object[]{ getMessage() }, "Dry Time");
                                  this.add(CQ.class, false, 1, 0, new Object[]{ getMessage() }, "Leak Rate");
                                  this.add(CQ.class, false, 1, 0, new Object[]{ getMessage() }, "Control Temperature");
                                  this.add(CQ.class, false, 1, 0, new Object[]{ getMessage() }, "Sterilizer Temperature");
                                  this.add(TM.class, false, 1, 0, new Object[]{ getMessage() }, "Cycle Complete Time");
                                  this.add(CQ.class, false, 1, 0, new Object[]{ getMessage() }, "Under Temperature");
                                  this.add(CQ.class, false, 1, 0, new Object[]{ getMessage() }, "Over Temperature");
                                  this.add(CNE.class, false, 1, 0, new Object[]{ getMessage() }, "Abort Cycle");
                                  this.add(CNE.class, false, 1, 0, new Object[]{ getMessage() }, "Alarm");
                                  this.add(CNE.class, false, 1, 0, new Object[]{ getMessage() }, "Long in Charge Phase");
                                  this.add(CNE.class, false, 1, 0, new Object[]{ getMessage() }, "Long in Exhaust Phase");
                                  this.add(CNE.class, false, 1, 0, new Object[]{ getMessage() }, "Long in Fast Exhaust Phase");
                                  this.add(CNE.class, false, 1, 0, new Object[]{ getMessage() }, "Reset");
                                  this.add(XCN.class, false, 1, 0, new Object[]{ getMessage() }, "Operator - Unload");
                                  this.add(CNE.class, false, 1, 0, new Object[]{ getMessage() }, "Door Open");
                                  this.add(CNE.class, false, 1, 0, new Object[]{ getMessage() }, "Reading Failure");
                                  this.add(CWE.class, false, 1, 0, new Object[]{ getMessage() }, "Cycle Type");
                                  this.add(CQ.class, false, 1, 0, new Object[]{ getMessage() }, "Thermal Rinse Time");
                                  this.add(CQ.class, false, 1, 0, new Object[]{ getMessage() }, "Wash Time");
                                  this.add(CQ.class, false, 1, 0, new Object[]{ getMessage() }, "Injection Rate");
                                  this.add(CNE.class, false, 1, 0, new Object[]{ getMessage() }, "Procedure Code");
                                  this.add(CX.class, false, 0, 0, new Object[]{ getMessage() }, "Patient Identifier List");
                                  this.add(XCN.class, false, 1, 0, new Object[]{ getMessage() }, "Attending Doctor");
                                  this.add(SN.class, false, 1, 0, new Object[]{ getMessage() }, "Dilution Factor");
                                  this.add(CQ.class, false, 1, 0, new Object[]{ getMessage() }, "Fill Time");
                                  this.add(CQ.class, false, 1, 0, new Object[]{ getMessage() }, "Inlet Temperature");
       } catch(HL7Exception e) {
          log.error("Unexpected error creating SCD - this is probably a bug in the source code generator.", e);
       }
    }



    /**
     * Returns
     * SCD-1: "Cycle Start Time" - creates it if necessary
     */
    public TM getCycleStartTime() { 
		TM retVal = this.getTypedField(1, 0);
		return retVal;
    }
    
    /**
     * Returns
     * SCD-1: "Cycle Start Time" - creates it if necessary
     */
    public TM getScd1_CycleStartTime() { 
		TM retVal = this.getTypedField(1, 0);
		return retVal;
    }



    /**
     * Returns
     * SCD-2: "Cycle Count" - creates it if necessary
     */
    public NM getCycleCount() { 
		NM retVal = this.getTypedField(2, 0);
		return retVal;
    }
    
    /**
     * Returns
     * SCD-2: "Cycle Count" - creates it if necessary
     */
    public NM getScd2_CycleCount() { 
		NM retVal = this.getTypedField(2, 0);
		return retVal;
    }



    /**
     * Returns
     * SCD-3: "Temp Max" - creates it if necessary
     */
    public CQ getTempMax() { 
		CQ retVal = this.getTypedField(3, 0);
		return retVal;
    }
    
    /**
     * Returns
     * SCD-3: "Temp Max" - creates it if necessary
     */
    public CQ getScd3_TempMax() { 
		CQ retVal = this.getTypedField(3, 0);
		return retVal;
    }



    /**
     * Returns
     * SCD-4: "Temp Min" - creates it if necessary
     */
    public CQ getTempMin() { 
		CQ retVal = this.getTypedField(4, 0);
		return retVal;
    }
    
    /**
     * Returns
     * SCD-4: "Temp Min" - creates it if necessary
     */
    public CQ getScd4_TempMin() { 
		CQ retVal = this.getTypedField(4, 0);
		return retVal;
    }



    /**
     * Returns
     * SCD-5: "Load Number" - creates it if necessary
     */
    public NM getLoadNumber() { 
		NM retVal = this.getTypedField(5, 0);
		return retVal;
    }
    
    /**
     * Returns
     * SCD-5: "Load Number" - creates it if necessary
     */
    public NM getScd5_LoadNumber() { 
		NM retVal = this.getTypedField(5, 0);
		return retVal;
    }



    /**
     * Returns
     * SCD-6: "Condition Time" - creates it if necessary
     */
    public CQ getConditionTime() { 
		CQ retVal = this.getTypedField(6, 0);
		return retVal;
    }
    
    /**
     * Returns
     * SCD-6: "Condition Time" - creates it if necessary
     */
    public CQ getScd6_ConditionTime() { 
		CQ retVal = this.getTypedField(6, 0);
		return retVal;
    }



    /**
     * Returns
     * SCD-7: "Sterilize Time" - creates it if necessary
     */
    public CQ getSterilizeTime() { 
		CQ retVal = this.getTypedField(7, 0);
		return retVal;
    }
    
    /**
     * Returns
     * SCD-7: "Sterilize Time" - creates it if necessary
     */
    public CQ getScd7_SterilizeTime() { 
		CQ retVal = this.getTypedField(7, 0);
		return retVal;
    }



    /**
     * Returns
     * SCD-8: "Exhaust Time" - creates it if necessary
     */
    public CQ getExhaustTime() { 
		CQ retVal = this.getTypedField(8, 0);
		return retVal;
    }
    
    /**
     * Returns
     * SCD-8: "Exhaust Time" - creates it if necessary
     */
    public CQ getScd8_ExhaustTime() { 
		CQ retVal = this.getTypedField(8, 0);
		return retVal;
    }



    /**
     * Returns
     * SCD-9: "Total Cycle Time" - creates it if necessary
     */
    public CQ getTotalCycleTime() { 
		CQ retVal = this.getTypedField(9, 0);
		return retVal;
    }
    
    /**
     * Returns
     * SCD-9: "Total Cycle Time" - creates it if necessary
     */
    public CQ getScd9_TotalCycleTime() { 
		CQ retVal = this.getTypedField(9, 0);
		return retVal;
    }



    /**
     * Returns
     * SCD-10: "Device Status" - creates it if necessary
     */
    public CWE getDeviceStatus() { 
		CWE retVal = this.getTypedField(10, 0);
		return retVal;
    }
    
    /**
     * Returns
     * SCD-10: "Device Status" - creates it if necessary
     */
    public CWE getScd10_DeviceStatus() { 
		CWE retVal = this.getTypedField(10, 0);
		return retVal;
    }



    /**
     * Returns
     * SCD-11: "Cycle Start Date/Time" - creates it if necessary
     */
    public DTM getCycleStartDateTime() { 
		DTM retVal = this.getTypedField(11, 0);
		return retVal;
    }
    
    /**
     * Returns
     * SCD-11: "Cycle Start Date/Time" - creates it if necessary
     */
    public DTM getScd11_CycleStartDateTime() { 
		DTM retVal = this.getTypedField(11, 0);
		return retVal;
    }



    /**
     * Returns
     * SCD-12: "Dry Time" - creates it if necessary
     */
    public CQ getDryTime() { 
		CQ retVal = this.getTypedField(12, 0);
		return retVal;
    }
    
    /**
     * Returns
     * SCD-12: "Dry Time" - creates it if necessary
     */
    public CQ getScd12_DryTime() { 
		CQ retVal = this.getTypedField(12, 0);
		return retVal;
    }



    /**
     * Returns
     * SCD-13: "Leak Rate" - creates it if necessary
     */
    public CQ getLeakRate() { 
		CQ retVal = this.getTypedField(13, 0);
		return retVal;
    }
    
    /**
     * Returns
     * SCD-13: "Leak Rate" - creates it if necessary
     */
    public CQ getScd13_LeakRate() { 
		CQ retVal = this.getTypedField(13, 0);
		return retVal;
    }



    /**
     * Returns
     * SCD-14: "Control Temperature" - creates it if necessary
     */
    public CQ getControlTemperature() { 
		CQ retVal = this.getTypedField(14, 0);
		return retVal;
    }
    
    /**
     * Returns
     * SCD-14: "Control Temperature" - creates it if necessary
     */
    public CQ getScd14_ControlTemperature() { 
		CQ retVal = this.getTypedField(14, 0);
		return retVal;
    }



    /**
     * Returns
     * SCD-15: "Sterilizer Temperature" - creates it if necessary
     */
    public CQ getSterilizerTemperature() { 
		CQ retVal = this.getTypedField(15, 0);
		return retVal;
    }
    
    /**
     * Returns
     * SCD-15: "Sterilizer Temperature" - creates it if necessary
     */
    public CQ getScd15_SterilizerTemperature() { 
		CQ retVal = this.getTypedField(15, 0);
		return retVal;
    }



    /**
     * Returns
     * SCD-16: "Cycle Complete Time" - creates it if necessary
     */
    public TM getCycleCompleteTime() { 
		TM retVal = this.getTypedField(16, 0);
		return retVal;
    }
    
    /**
     * Returns
     * SCD-16: "Cycle Complete Time" - creates it if necessary
     */
    public TM getScd16_CycleCompleteTime() { 
		TM retVal = this.getTypedField(16, 0);
		return retVal;
    }



    /**
     * Returns
     * SCD-17: "Under Temperature" - creates it if necessary
     */
    public CQ getUnderTemperature() { 
		CQ retVal = this.getTypedField(17, 0);
		return retVal;
    }
    
    /**
     * Returns
     * SCD-17: "Under Temperature" - creates it if necessary
     */
    public CQ getScd17_UnderTemperature() { 
		CQ retVal = this.getTypedField(17, 0);
		return retVal;
    }



    /**
     * Returns
     * SCD-18: "Over Temperature" - creates it if necessary
     */
    public CQ getOverTemperature() { 
		CQ retVal = this.getTypedField(18, 0);
		return retVal;
    }
    
    /**
     * Returns
     * SCD-18: "Over Temperature" - creates it if necessary
     */
    public CQ getScd18_OverTemperature() { 
		CQ retVal = this.getTypedField(18, 0);
		return retVal;
    }



    /**
     * Returns
     * SCD-19: "Abort Cycle" - creates it if necessary
     */
    public CNE getAbortCycle() { 
		CNE retVal = this.getTypedField(19, 0);
		return retVal;
    }
    
    /**
     * Returns
     * SCD-19: "Abort Cycle" - creates it if necessary
     */
    public CNE getScd19_AbortCycle() { 
		CNE retVal = this.getTypedField(19, 0);
		return retVal;
    }



    /**
     * Returns
     * SCD-20: "Alarm" - creates it if necessary
     */
    public CNE getAlarm() { 
		CNE retVal = this.getTypedField(20, 0);
		return retVal;
    }
    
    /**
     * Returns
     * SCD-20: "Alarm" - creates it if necessary
     */
    public CNE getScd20_Alarm() { 
		CNE retVal = this.getTypedField(20, 0);
		return retVal;
    }



    /**
     * Returns
     * SCD-21: "Long in Charge Phase" - creates it if necessary
     */
    public CNE getLongInChargePhase() { 
		CNE retVal = this.getTypedField(21, 0);
		return retVal;
    }
    
    /**
     * Returns
     * SCD-21: "Long in Charge Phase" - creates it if necessary
     */
    public CNE getScd21_LongInChargePhase() { 
		CNE retVal = this.getTypedField(21, 0);
		return retVal;
    }



    /**
     * Returns
     * SCD-22: "Long in Exhaust Phase" - creates it if necessary
     */
    public CNE getLongInExhaustPhase() { 
		CNE retVal = this.getTypedField(22, 0);
		return retVal;
    }
    
    /**
     * Returns
     * SCD-22: "Long in Exhaust Phase" - creates it if necessary
     */
    public CNE getScd22_LongInExhaustPhase() { 
		CNE retVal = this.getTypedField(22, 0);
		return retVal;
    }



    /**
     * Returns
     * SCD-23: "Long in Fast Exhaust Phase" - creates it if necessary
     */
    public CNE getLongInFastExhaustPhase() { 
		CNE retVal = this.getTypedField(23, 0);
		return retVal;
    }
    
    /**
     * Returns
     * SCD-23: "Long in Fast Exhaust Phase" - creates it if necessary
     */
    public CNE getScd23_LongInFastExhaustPhase() { 
		CNE retVal = this.getTypedField(23, 0);
		return retVal;
    }



    /**
     * Returns
     * SCD-24: "Reset" - creates it if necessary
     */
    public CNE getReset() { 
		CNE retVal = this.getTypedField(24, 0);
		return retVal;
    }
    
    /**
     * Returns
     * SCD-24: "Reset" - creates it if necessary
     */
    public CNE getScd24_Reset() { 
		CNE retVal = this.getTypedField(24, 0);
		return retVal;
    }



    /**
     * Returns
     * SCD-25: "Operator - Unload" - creates it if necessary
     */
    public XCN getOperatorUnload() { 
		XCN retVal = this.getTypedField(25, 0);
		return retVal;
    }
    
    /**
     * Returns
     * SCD-25: "Operator - Unload" - creates it if necessary
     */
    public XCN getScd25_OperatorUnload() { 
		XCN retVal = this.getTypedField(25, 0);
		return retVal;
    }



    /**
     * Returns
     * SCD-26: "Door Open" - creates it if necessary
     */
    public CNE getDoorOpen() { 
		CNE retVal = this.getTypedField(26, 0);
		return retVal;
    }
    
    /**
     * Returns
     * SCD-26: "Door Open" - creates it if necessary
     */
    public CNE getScd26_DoorOpen() { 
		CNE retVal = this.getTypedField(26, 0);
		return retVal;
    }



    /**
     * Returns
     * SCD-27: "Reading Failure" - creates it if necessary
     */
    public CNE getReadingFailure() { 
		CNE retVal = this.getTypedField(27, 0);
		return retVal;
    }
    
    /**
     * Returns
     * SCD-27: "Reading Failure" - creates it if necessary
     */
    public CNE getScd27_ReadingFailure() { 
		CNE retVal = this.getTypedField(27, 0);
		return retVal;
    }



    /**
     * Returns
     * SCD-28: "Cycle Type" - creates it if necessary
     */
    public CWE getCycleType() { 
		CWE retVal = this.getTypedField(28, 0);
		return retVal;
    }
    
    /**
     * Returns
     * SCD-28: "Cycle Type" - creates it if necessary
     */
    public CWE getScd28_CycleType() { 
		CWE retVal = this.getTypedField(28, 0);
		return retVal;
    }



    /**
     * Returns
     * SCD-29: "Thermal Rinse Time" - creates it if necessary
     */
    public CQ getThermalRinseTime() { 
		CQ retVal = this.getTypedField(29, 0);
		return retVal;
    }
    
    /**
     * Returns
     * SCD-29: "Thermal Rinse Time" - creates it if necessary
     */
    public CQ getScd29_ThermalRinseTime() { 
		CQ retVal = this.getTypedField(29, 0);
		return retVal;
    }



    /**
     * Returns
     * SCD-30: "Wash Time" - creates it if necessary
     */
    public CQ getWashTime() { 
		CQ retVal = this.getTypedField(30, 0);
		return retVal;
    }
    
    /**
     * Returns
     * SCD-30: "Wash Time" - creates it if necessary
     */
    public CQ getScd30_WashTime() { 
		CQ retVal = this.getTypedField(30, 0);
		return retVal;
    }



    /**
     * Returns
     * SCD-31: "Injection Rate" - creates it if necessary
     */
    public CQ getInjectionRate() { 
		CQ retVal = this.getTypedField(31, 0);
		return retVal;
    }
    
    /**
     * Returns
     * SCD-31: "Injection Rate" - creates it if necessary
     */
    public CQ getScd31_InjectionRate() { 
		CQ retVal = this.getTypedField(31, 0);
		return retVal;
    }



    /**
     * Returns
     * SCD-32: "Procedure Code" - creates it if necessary
     */
    public CNE getProcedureCode() { 
		CNE retVal = this.getTypedField(32, 0);
		return retVal;
    }
    
    /**
     * Returns
     * SCD-32: "Procedure Code" - creates it if necessary
     */
    public CNE getScd32_ProcedureCode() { 
		CNE retVal = this.getTypedField(32, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Patient Identifier List (SCD-33).
     */
    public CX[] getPatientIdentifierList() {
    	CX[] retVal = this.getTypedField(33, new CX[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Patient Identifier List (SCD-33).
     */
    public CX[] getScd33_PatientIdentifierList() {
    	CX[] retVal = this.getTypedField(33, new CX[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Patient Identifier List (SCD-33).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getPatientIdentifierListReps() {
    	return this.getReps(33);
    }


    /**
     * Returns a specific repetition of
     * SCD-33: "Patient Identifier List" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CX getPatientIdentifierList(int rep) { 
		CX retVal = this.getTypedField(33, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * SCD-33: "Patient Identifier List" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CX getScd33_PatientIdentifierList(int rep) { 
		CX retVal = this.getTypedField(33, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Patient Identifier List (SCD-33).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getScd33_PatientIdentifierListReps() {
    	return this.getReps(33);
    }


    /**
     * Inserts a repetition of
     * SCD-33: "Patient Identifier List" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CX insertPatientIdentifierList(int rep) throws HL7Exception { 
        return (CX) super.insertRepetition(33, rep);
    }


    /**
     * Inserts a repetition of
     * SCD-33: "Patient Identifier List" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CX insertScd33_PatientIdentifierList(int rep) throws HL7Exception { 
        return (CX) super.insertRepetition(33, rep);
    }


    /**
     * Removes a repetition of
     * SCD-33: "Patient Identifier List" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CX removePatientIdentifierList(int rep) throws HL7Exception { 
        return (CX) super.removeRepetition(33, rep);
    }


    /**
     * Removes a repetition of
     * SCD-33: "Patient Identifier List" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CX removeScd33_PatientIdentifierList(int rep) throws HL7Exception { 
        return (CX) super.removeRepetition(33, rep);
    }




    /**
     * Returns
     * SCD-34: "Attending Doctor" - creates it if necessary
     */
    public XCN getAttendingDoctor() { 
		XCN retVal = this.getTypedField(34, 0);
		return retVal;
    }
    
    /**
     * Returns
     * SCD-34: "Attending Doctor" - creates it if necessary
     */
    public XCN getScd34_AttendingDoctor() { 
		XCN retVal = this.getTypedField(34, 0);
		return retVal;
    }



    /**
     * Returns
     * SCD-35: "Dilution Factor" - creates it if necessary
     */
    public SN getDilutionFactor() { 
		SN retVal = this.getTypedField(35, 0);
		return retVal;
    }
    
    /**
     * Returns
     * SCD-35: "Dilution Factor" - creates it if necessary
     */
    public SN getScd35_DilutionFactor() { 
		SN retVal = this.getTypedField(35, 0);
		return retVal;
    }



    /**
     * Returns
     * SCD-36: "Fill Time" - creates it if necessary
     */
    public CQ getFillTime() { 
		CQ retVal = this.getTypedField(36, 0);
		return retVal;
    }
    
    /**
     * Returns
     * SCD-36: "Fill Time" - creates it if necessary
     */
    public CQ getScd36_FillTime() { 
		CQ retVal = this.getTypedField(36, 0);
		return retVal;
    }



    /**
     * Returns
     * SCD-37: "Inlet Temperature" - creates it if necessary
     */
    public CQ getInletTemperature() { 
		CQ retVal = this.getTypedField(37, 0);
		return retVal;
    }
    
    /**
     * Returns
     * SCD-37: "Inlet Temperature" - creates it if necessary
     */
    public CQ getScd37_InletTemperature() { 
		CQ retVal = this.getTypedField(37, 0);
		return retVal;
    }





    /** {@inheritDoc} */   
    protected Type createNewTypeWithoutReflection(int field) {
       switch (field) {
          case 0: return new TM(getMessage());
          case 1: return new NM(getMessage());
          case 2: return new CQ(getMessage());
          case 3: return new CQ(getMessage());
          case 4: return new NM(getMessage());
          case 5: return new CQ(getMessage());
          case 6: return new CQ(getMessage());
          case 7: return new CQ(getMessage());
          case 8: return new CQ(getMessage());
          case 9: return new CWE(getMessage());
          case 10: return new DTM(getMessage());
          case 11: return new CQ(getMessage());
          case 12: return new CQ(getMessage());
          case 13: return new CQ(getMessage());
          case 14: return new CQ(getMessage());
          case 15: return new TM(getMessage());
          case 16: return new CQ(getMessage());
          case 17: return new CQ(getMessage());
          case 18: return new CNE(getMessage());
          case 19: return new CNE(getMessage());
          case 20: return new CNE(getMessage());
          case 21: return new CNE(getMessage());
          case 22: return new CNE(getMessage());
          case 23: return new CNE(getMessage());
          case 24: return new XCN(getMessage());
          case 25: return new CNE(getMessage());
          case 26: return new CNE(getMessage());
          case 27: return new CWE(getMessage());
          case 28: return new CQ(getMessage());
          case 29: return new CQ(getMessage());
          case 30: return new CQ(getMessage());
          case 31: return new CNE(getMessage());
          case 32: return new CX(getMessage());
          case 33: return new XCN(getMessage());
          case 34: return new SN(getMessage());
          case 35: return new CQ(getMessage());
          case 36: return new CQ(getMessage());
          default: return null;
       }
   }


}

