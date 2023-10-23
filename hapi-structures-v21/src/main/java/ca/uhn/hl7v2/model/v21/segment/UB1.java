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


package ca.uhn.hl7v2.model.v21.segment;

// import ca.uhn.hl7v2.model.v21.group.*;
import ca.uhn.hl7v2.model.v21.datatype.*;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.parser.DefaultModelClassFactory;
import ca.uhn.hl7v2.model.AbstractMessage;
import ca.uhn.hl7v2.model.Group;
import ca.uhn.hl7v2.model.Type;
import ca.uhn.hl7v2.model.AbstractSegment;
import ca.uhn.hl7v2.model.Varies;


/**
 *<p>Represents an HL7 UB1 message segment (UB82 DATA). 
 * This segment has the following fields:</p>
 * <ul>
     * <li>UB1-1: SET ID - UB82 (SI) <b>optional </b>
     * <li>UB1-2: BLOOD DEDUCTIBLE (ST) <b>optional </b>
     * <li>UB1-3: BLOOD FURN.-PINTS OF (40) (ST) <b>optional </b>
     * <li>UB1-4: BLOOD REPLACED-PINTS (41) (ST) <b>optional </b>
     * <li>UB1-5: BLOOD NOT RPLCD-PINTS(42) (ST) <b>optional </b>
     * <li>UB1-6: CO-INSURANCE DAYS (25) (ST) <b>optional </b>
     * <li>UB1-7: CONDITION CODE (ID) <b>optional repeating</b>
     * <li>UB1-8: COVERED DAYS - (23) (ST) <b>optional </b>
     * <li>UB1-9: NON COVERED DAYS - (24) (ST) <b>optional </b>
     * <li>UB1-10: VALUE AMOUNT & CODE (CM) <b>optional repeating</b>
     * <li>UB1-11: NUMBER OF GRACE DAYS (90) (ST) <b>optional </b>
     * <li>UB1-12: SPEC. PROG. INDICATOR(44) (ID) <b>optional </b>
     * <li>UB1-13: PSRO/UR APPROVAL IND. (87) (ID) <b>optional </b>
     * <li>UB1-14: PSRO/UR APRVD STAY-FM(88) (DT) <b>optional </b>
     * <li>UB1-15: PSRO/UR APRVD STAY-TO(89) (DT) <b>optional </b>
     * <li>UB1-16: OCCURRENCE (28-32) (ID) <b>optional repeating</b>
     * <li>UB1-17: OCCURRENCE SPAN (33) (ID) <b>optional </b>
     * <li>UB1-18: OCCURRENCE SPAN START DATE(33) (DT) <b>optional </b>
     * <li>UB1-19: OCCUR. SPAN END DATE (33) (DT) <b>optional </b>
     * <li>UB1-20: UB-82 LOCATOR 2 (ST) <b>optional </b>
     * <li>UB1-21: UB-82 LOCATOR 9 (ST) <b>optional </b>
     * <li>UB1-22: UB-82 LOCATOR 27 (ST) <b>optional </b>
     * <li>UB1-23: UB-82 LOCATOR 45 (ST) <b>optional </b>
 * </ul>
 */
@SuppressWarnings("unused")
public class UB1 extends AbstractSegment {

    /** 
     * Creates a new UB1 segment
     */
    public UB1(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(SI.class, false, 1, 4, new Object[]{ getMessage() }, "SET ID - UB82");
                                  this.add(ST.class, false, 1, 1, new Object[]{ getMessage() }, "BLOOD DEDUCTIBLE");
                                  this.add(ST.class, false, 1, 2, new Object[]{ getMessage() }, "BLOOD FURN.-PINTS OF (40)");
                                  this.add(ST.class, false, 1, 2, new Object[]{ getMessage() }, "BLOOD REPLACED-PINTS (41)");
                                  this.add(ST.class, false, 1, 2, new Object[]{ getMessage() }, "BLOOD NOT RPLCD-PINTS(42)");
                                  this.add(ST.class, false, 1, 2, new Object[]{ getMessage() }, "CO-INSURANCE DAYS (25)");
                                              this.add(ID.class, false, 5, 2, new Object[]{ getMessage(), new Integer(43) }, "CONDITION CODE");
                                  this.add(ST.class, false, 1, 3, new Object[]{ getMessage() }, "COVERED DAYS - (23)");
                                  this.add(ST.class, false, 1, 3, new Object[]{ getMessage() }, "NON COVERED DAYS - (24)");
                                  this.add(CM.class, false, 8, 12, new Object[]{ getMessage() }, "VALUE AMOUNT & CODE");
                                  this.add(ST.class, false, 1, 2, new Object[]{ getMessage() }, "NUMBER OF GRACE DAYS (90)");
                                              this.add(ID.class, false, 1, 2, new Object[]{ getMessage(), new Integer(0) }, "SPEC. PROG. INDICATOR(44)");
                                              this.add(ID.class, false, 1, 1, new Object[]{ getMessage(), new Integer(0) }, "PSRO/UR APPROVAL IND. (87)");
                                  this.add(DT.class, false, 1, 8, new Object[]{ getMessage() }, "PSRO/UR APRVD STAY-FM(88)");
                                  this.add(DT.class, false, 1, 8, new Object[]{ getMessage() }, "PSRO/UR APRVD STAY-TO(89)");
                                              this.add(ID.class, false, 5, 20, new Object[]{ getMessage(), new Integer(0) }, "OCCURRENCE (28-32)");
                                              this.add(ID.class, false, 1, 2, new Object[]{ getMessage(), new Integer(0) }, "OCCURRENCE SPAN (33)");
                                  this.add(DT.class, false, 1, 8, new Object[]{ getMessage() }, "OCCURRENCE SPAN START DATE(33)");
                                  this.add(DT.class, false, 1, 8, new Object[]{ getMessage() }, "OCCUR. SPAN END DATE (33)");
                                  this.add(ST.class, false, 1, 30, new Object[]{ getMessage() }, "UB-82 LOCATOR 2");
                                  this.add(ST.class, false, 1, 7, new Object[]{ getMessage() }, "UB-82 LOCATOR 9");
                                  this.add(ST.class, false, 1, 8, new Object[]{ getMessage() }, "UB-82 LOCATOR 27");
                                  this.add(ST.class, false, 1, 17, new Object[]{ getMessage() }, "UB-82 LOCATOR 45");
       } catch(HL7Exception e) {
          log.error("Unexpected error creating UB1 - this is probably a bug in the source code generator.", e);
       }
    }



    /**
     * Returns
     * UB1-1: "SET ID - UB82" - creates it if necessary
     */
    public SI getSETIDUB82() { 
		SI retVal = this.getTypedField(1, 0);
		return retVal;
    }
    
    /**
     * Returns
     * UB1-1: "SET ID - UB82" - creates it if necessary
     */
    public SI getUb11_SETIDUB82() { 
		SI retVal = this.getTypedField(1, 0);
		return retVal;
    }



    /**
     * Returns
     * UB1-2: "BLOOD DEDUCTIBLE" - creates it if necessary
     */
    public ST getBLOODDEDUCTIBLE() { 
		ST retVal = this.getTypedField(2, 0);
		return retVal;
    }
    
    /**
     * Returns
     * UB1-2: "BLOOD DEDUCTIBLE" - creates it if necessary
     */
    public ST getUb12_BLOODDEDUCTIBLE() { 
		ST retVal = this.getTypedField(2, 0);
		return retVal;
    }



    /**
     * Returns
     * UB1-3: "BLOOD FURN.-PINTS OF (40)" - creates it if necessary
     */
    public ST getBLOODFURNPINTSOF() { 
		ST retVal = this.getTypedField(3, 0);
		return retVal;
    }
    
    /**
     * Returns
     * UB1-3: "BLOOD FURN.-PINTS OF (40)" - creates it if necessary
     */
    public ST getUb13_BLOODFURNPINTSOF() { 
		ST retVal = this.getTypedField(3, 0);
		return retVal;
    }



    /**
     * Returns
     * UB1-4: "BLOOD REPLACED-PINTS (41)" - creates it if necessary
     */
    public ST getBLOODREPLACEDPINTS() { 
		ST retVal = this.getTypedField(4, 0);
		return retVal;
    }
    
    /**
     * Returns
     * UB1-4: "BLOOD REPLACED-PINTS (41)" - creates it if necessary
     */
    public ST getUb14_BLOODREPLACEDPINTS() { 
		ST retVal = this.getTypedField(4, 0);
		return retVal;
    }



    /**
     * Returns
     * UB1-5: "BLOOD NOT RPLCD-PINTS(42)" - creates it if necessary
     */
    public ST getBLOODNOTRPLCDPINTS() { 
		ST retVal = this.getTypedField(5, 0);
		return retVal;
    }
    
    /**
     * Returns
     * UB1-5: "BLOOD NOT RPLCD-PINTS(42)" - creates it if necessary
     */
    public ST getUb15_BLOODNOTRPLCDPINTS() { 
		ST retVal = this.getTypedField(5, 0);
		return retVal;
    }



    /**
     * Returns
     * UB1-6: "CO-INSURANCE DAYS (25)" - creates it if necessary
     */
    public ST getCOINSURANCEDAYS() { 
		ST retVal = this.getTypedField(6, 0);
		return retVal;
    }
    
    /**
     * Returns
     * UB1-6: "CO-INSURANCE DAYS (25)" - creates it if necessary
     */
    public ST getUb16_COINSURANCEDAYS() { 
		ST retVal = this.getTypedField(6, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of CONDITION CODE (UB1-7).
     */
    public ID[] getCONDITIONCODE() {
    	ID[] retVal = this.getTypedField(7, new ID[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of CONDITION CODE (UB1-7).
     */
    public ID[] getUb17_CONDITIONCODE() {
    	ID[] retVal = this.getTypedField(7, new ID[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of CONDITION CODE (UB1-7).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getCONDITIONCODEReps() {
    	return this.getReps(7);
    }


    /**
     * Returns a specific repetition of
     * UB1-7: "CONDITION CODE" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public ID getCONDITIONCODE(int rep) { 
		ID retVal = this.getTypedField(7, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * UB1-7: "CONDITION CODE" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public ID getUb17_CONDITIONCODE(int rep) { 
		ID retVal = this.getTypedField(7, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of CONDITION CODE (UB1-7).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getUb17_CONDITIONCODEReps() {
    	return this.getReps(7);
    }


    /**
     * Inserts a repetition of
     * UB1-7: "CONDITION CODE" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ID insertCONDITIONCODE(int rep) throws HL7Exception { 
        return (ID) super.insertRepetition(7, rep);
    }


    /**
     * Inserts a repetition of
     * UB1-7: "CONDITION CODE" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ID insertUb17_CONDITIONCODE(int rep) throws HL7Exception { 
        return (ID) super.insertRepetition(7, rep);
    }


    /**
     * Removes a repetition of
     * UB1-7: "CONDITION CODE" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ID removeCONDITIONCODE(int rep) throws HL7Exception { 
        return (ID) super.removeRepetition(7, rep);
    }


    /**
     * Removes a repetition of
     * UB1-7: "CONDITION CODE" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ID removeUb17_CONDITIONCODE(int rep) throws HL7Exception { 
        return (ID) super.removeRepetition(7, rep);
    }




    /**
     * Returns
     * UB1-8: "COVERED DAYS - (23)" - creates it if necessary
     */
    public ST getCOVEREDDAYS() { 
		ST retVal = this.getTypedField(8, 0);
		return retVal;
    }
    
    /**
     * Returns
     * UB1-8: "COVERED DAYS - (23)" - creates it if necessary
     */
    public ST getUb18_COVEREDDAYS() { 
		ST retVal = this.getTypedField(8, 0);
		return retVal;
    }



    /**
     * Returns
     * UB1-9: "NON COVERED DAYS - (24)" - creates it if necessary
     */
    public ST getNONCOVEREDDAYS() { 
		ST retVal = this.getTypedField(9, 0);
		return retVal;
    }
    
    /**
     * Returns
     * UB1-9: "NON COVERED DAYS - (24)" - creates it if necessary
     */
    public ST getUb19_NONCOVEREDDAYS() { 
		ST retVal = this.getTypedField(9, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of VALUE AMOUNT & CODE (UB1-10).
     */
    public CM[] getVALUEAMOUNTCODE() {
    	CM[] retVal = this.getTypedField(10, new CM[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of VALUE AMOUNT & CODE (UB1-10).
     */
    public CM[] getUb110_VALUEAMOUNTCODE() {
    	CM[] retVal = this.getTypedField(10, new CM[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of VALUE AMOUNT & CODE (UB1-10).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getVALUEAMOUNTCODEReps() {
    	return this.getReps(10);
    }


    /**
     * Returns a specific repetition of
     * UB1-10: "VALUE AMOUNT & CODE" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CM getVALUEAMOUNTCODE(int rep) { 
		CM retVal = this.getTypedField(10, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * UB1-10: "VALUE AMOUNT & CODE" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CM getUb110_VALUEAMOUNTCODE(int rep) { 
		CM retVal = this.getTypedField(10, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of VALUE AMOUNT & CODE (UB1-10).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getUb110_VALUEAMOUNTCODEReps() {
    	return this.getReps(10);
    }


    /**
     * Inserts a repetition of
     * UB1-10: "VALUE AMOUNT & CODE" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CM insertVALUEAMOUNTCODE(int rep) throws HL7Exception { 
        return (CM) super.insertRepetition(10, rep);
    }


    /**
     * Inserts a repetition of
     * UB1-10: "VALUE AMOUNT & CODE" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CM insertUb110_VALUEAMOUNTCODE(int rep) throws HL7Exception { 
        return (CM) super.insertRepetition(10, rep);
    }


    /**
     * Removes a repetition of
     * UB1-10: "VALUE AMOUNT & CODE" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CM removeVALUEAMOUNTCODE(int rep) throws HL7Exception { 
        return (CM) super.removeRepetition(10, rep);
    }


    /**
     * Removes a repetition of
     * UB1-10: "VALUE AMOUNT & CODE" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CM removeUb110_VALUEAMOUNTCODE(int rep) throws HL7Exception { 
        return (CM) super.removeRepetition(10, rep);
    }




    /**
     * Returns
     * UB1-11: "NUMBER OF GRACE DAYS (90)" - creates it if necessary
     */
    public ST getNUMBEROFGRACEDAYS() { 
		ST retVal = this.getTypedField(11, 0);
		return retVal;
    }
    
    /**
     * Returns
     * UB1-11: "NUMBER OF GRACE DAYS (90)" - creates it if necessary
     */
    public ST getUb111_NUMBEROFGRACEDAYS() { 
		ST retVal = this.getTypedField(11, 0);
		return retVal;
    }



    /**
     * Returns
     * UB1-12: "SPEC. PROG. INDICATOR(44)" - creates it if necessary
     */
    public ID getSPECPROGINDICATOR() { 
		ID retVal = this.getTypedField(12, 0);
		return retVal;
    }
    
    /**
     * Returns
     * UB1-12: "SPEC. PROG. INDICATOR(44)" - creates it if necessary
     */
    public ID getUb112_SPECPROGINDICATOR() { 
		ID retVal = this.getTypedField(12, 0);
		return retVal;
    }



    /**
     * Returns
     * UB1-13: "PSRO/UR APPROVAL IND. (87)" - creates it if necessary
     */
    public ID getPSROURAPPROVALIND() { 
		ID retVal = this.getTypedField(13, 0);
		return retVal;
    }
    
    /**
     * Returns
     * UB1-13: "PSRO/UR APPROVAL IND. (87)" - creates it if necessary
     */
    public ID getUb113_PSROURAPPROVALIND() { 
		ID retVal = this.getTypedField(13, 0);
		return retVal;
    }



    /**
     * Returns
     * UB1-14: "PSRO/UR APRVD STAY-FM(88)" - creates it if necessary
     */
    public DT getPSROURAPRVDSTAYFM() { 
		DT retVal = this.getTypedField(14, 0);
		return retVal;
    }
    
    /**
     * Returns
     * UB1-14: "PSRO/UR APRVD STAY-FM(88)" - creates it if necessary
     */
    public DT getUb114_PSROURAPRVDSTAYFM() { 
		DT retVal = this.getTypedField(14, 0);
		return retVal;
    }



    /**
     * Returns
     * UB1-15: "PSRO/UR APRVD STAY-TO(89)" - creates it if necessary
     */
    public DT getPSROURAPRVDSTAYTO() { 
		DT retVal = this.getTypedField(15, 0);
		return retVal;
    }
    
    /**
     * Returns
     * UB1-15: "PSRO/UR APRVD STAY-TO(89)" - creates it if necessary
     */
    public DT getUb115_PSROURAPRVDSTAYTO() { 
		DT retVal = this.getTypedField(15, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of OCCURRENCE (28-32) (UB1-16).
     */
    public ID[] getOCCURRENCE2832() {
    	ID[] retVal = this.getTypedField(16, new ID[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of OCCURRENCE (28-32) (UB1-16).
     */
    public ID[] getUb116_OCCURRENCE2832() {
    	ID[] retVal = this.getTypedField(16, new ID[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of OCCURRENCE (28-32) (UB1-16).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getOCCURRENCE2832Reps() {
    	return this.getReps(16);
    }


    /**
     * Returns a specific repetition of
     * UB1-16: "OCCURRENCE (28-32)" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public ID getOCCURRENCE2832(int rep) { 
		ID retVal = this.getTypedField(16, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * UB1-16: "OCCURRENCE (28-32)" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public ID getUb116_OCCURRENCE2832(int rep) { 
		ID retVal = this.getTypedField(16, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of OCCURRENCE (28-32) (UB1-16).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getUb116_OCCURRENCE2832Reps() {
    	return this.getReps(16);
    }


    /**
     * Inserts a repetition of
     * UB1-16: "OCCURRENCE (28-32)" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ID insertOCCURRENCE2832(int rep) throws HL7Exception { 
        return (ID) super.insertRepetition(16, rep);
    }


    /**
     * Inserts a repetition of
     * UB1-16: "OCCURRENCE (28-32)" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ID insertUb116_OCCURRENCE2832(int rep) throws HL7Exception { 
        return (ID) super.insertRepetition(16, rep);
    }


    /**
     * Removes a repetition of
     * UB1-16: "OCCURRENCE (28-32)" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ID removeOCCURRENCE2832(int rep) throws HL7Exception { 
        return (ID) super.removeRepetition(16, rep);
    }


    /**
     * Removes a repetition of
     * UB1-16: "OCCURRENCE (28-32)" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ID removeUb116_OCCURRENCE2832(int rep) throws HL7Exception { 
        return (ID) super.removeRepetition(16, rep);
    }




    /**
     * Returns
     * UB1-17: "OCCURRENCE SPAN (33)" - creates it if necessary
     */
    public ID getOCCURRENCESPAN() { 
		ID retVal = this.getTypedField(17, 0);
		return retVal;
    }
    
    /**
     * Returns
     * UB1-17: "OCCURRENCE SPAN (33)" - creates it if necessary
     */
    public ID getUb117_OCCURRENCESPAN() { 
		ID retVal = this.getTypedField(17, 0);
		return retVal;
    }



    /**
     * Returns
     * UB1-18: "OCCURRENCE SPAN START DATE(33)" - creates it if necessary
     */
    public DT getOCCURRENCESPANSTARTDATE() { 
		DT retVal = this.getTypedField(18, 0);
		return retVal;
    }
    
    /**
     * Returns
     * UB1-18: "OCCURRENCE SPAN START DATE(33)" - creates it if necessary
     */
    public DT getUb118_OCCURRENCESPANSTARTDATE() { 
		DT retVal = this.getTypedField(18, 0);
		return retVal;
    }



    /**
     * Returns
     * UB1-19: "OCCUR. SPAN END DATE (33)" - creates it if necessary
     */
    public DT getOCCURSPANENDDATE() { 
		DT retVal = this.getTypedField(19, 0);
		return retVal;
    }
    
    /**
     * Returns
     * UB1-19: "OCCUR. SPAN END DATE (33)" - creates it if necessary
     */
    public DT getUb119_OCCURSPANENDDATE() { 
		DT retVal = this.getTypedField(19, 0);
		return retVal;
    }



    /**
     * Returns
     * UB1-20: "UB-82 LOCATOR 2" - creates it if necessary
     */
    public ST getUB82LOCATOR2() { 
		ST retVal = this.getTypedField(20, 0);
		return retVal;
    }
    
    /**
     * Returns
     * UB1-20: "UB-82 LOCATOR 2" - creates it if necessary
     */
    public ST getUb120_UB82LOCATOR2() { 
		ST retVal = this.getTypedField(20, 0);
		return retVal;
    }



    /**
     * Returns
     * UB1-21: "UB-82 LOCATOR 9" - creates it if necessary
     */
    public ST getUB82LOCATOR9() { 
		ST retVal = this.getTypedField(21, 0);
		return retVal;
    }
    
    /**
     * Returns
     * UB1-21: "UB-82 LOCATOR 9" - creates it if necessary
     */
    public ST getUb121_UB82LOCATOR9() { 
		ST retVal = this.getTypedField(21, 0);
		return retVal;
    }



    /**
     * Returns
     * UB1-22: "UB-82 LOCATOR 27" - creates it if necessary
     */
    public ST getUB82LOCATOR27() { 
		ST retVal = this.getTypedField(22, 0);
		return retVal;
    }
    
    /**
     * Returns
     * UB1-22: "UB-82 LOCATOR 27" - creates it if necessary
     */
    public ST getUb122_UB82LOCATOR27() { 
		ST retVal = this.getTypedField(22, 0);
		return retVal;
    }



    /**
     * Returns
     * UB1-23: "UB-82 LOCATOR 45" - creates it if necessary
     */
    public ST getUB82LOCATOR45() { 
		ST retVal = this.getTypedField(23, 0);
		return retVal;
    }
    
    /**
     * Returns
     * UB1-23: "UB-82 LOCATOR 45" - creates it if necessary
     */
    public ST getUb123_UB82LOCATOR45() { 
		ST retVal = this.getTypedField(23, 0);
		return retVal;
    }





    /** {@inheritDoc} */   
    protected Type createNewTypeWithoutReflection(int field) {
       switch (field) {
          case 0: return new SI(getMessage());
          case 1: return new ST(getMessage());
          case 2: return new ST(getMessage());
          case 3: return new ST(getMessage());
          case 4: return new ST(getMessage());
          case 5: return new ST(getMessage());
          case 6: return new ID(getMessage(), new Integer( 43 ));
          case 7: return new ST(getMessage());
          case 8: return new ST(getMessage());
          case 9: return new CM(getMessage());
          case 10: return new ST(getMessage());
          case 11: return new ID(getMessage(), new Integer( 0 ));
          case 12: return new ID(getMessage(), new Integer( 0 ));
          case 13: return new DT(getMessage());
          case 14: return new DT(getMessage());
          case 15: return new ID(getMessage(), new Integer( 0 ));
          case 16: return new ID(getMessage(), new Integer( 0 ));
          case 17: return new DT(getMessage());
          case 18: return new DT(getMessage());
          case 19: return new ST(getMessage());
          case 20: return new ST(getMessage());
          case 21: return new ST(getMessage());
          case 22: return new ST(getMessage());
          default: return null;
       }
   }


}

