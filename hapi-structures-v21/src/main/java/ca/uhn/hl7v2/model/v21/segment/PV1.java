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
 *<p>Represents an HL7 PV1 message segment (PATIENT VISIT). 
 * This segment has the following fields:</p>
 * <ul>
     * <li>PV1-1: SET ID - PATIENT VISIT (SI) <b>optional </b>
     * <li>PV1-2: PATIENT CLASS (ID) <b> </b>
     * <li>PV1-3: ASSIGNED PATIENT LOCATION (ID) <b> </b>
     * <li>PV1-4: ADMISSION TYPE (ID) <b>optional </b>
     * <li>PV1-5: PRE-ADMIT NUMBER (ST) <b>optional </b>
     * <li>PV1-6: PRIOR PATIENT LOCATION (ID) <b>optional </b>
     * <li>PV1-7: ATTENDING DOCTOR (CN) <b>optional </b>
     * <li>PV1-8: REFERRING DOCTOR (CN) <b>optional </b>
     * <li>PV1-9: CONSULTING DOCTOR (CN) <b>optional repeating</b>
     * <li>PV1-10: HOSPITAL SERVICE (ID) <b>optional </b>
     * <li>PV1-11: TEMPORARY LOCATION (ID) <b>optional </b>
     * <li>PV1-12: PRE-ADMIT TEST INDICATOR (ID) <b>optional </b>
     * <li>PV1-13: RE-ADMISSION INDICATOR (ID) <b>optional </b>
     * <li>PV1-14: ADMIT SOURCE (ID) <b>optional </b>
     * <li>PV1-15: AMBULATORY STATUS (ID) <b>optional </b>
     * <li>PV1-16: VIP INDICATOR (ID) <b>optional </b>
     * <li>PV1-17: ADMITTING DOCTOR (CN) <b>optional </b>
     * <li>PV1-18: PATIENT TYPE (ID) <b>optional </b>
     * <li>PV1-19: VISIT NUMBER (NM) <b>optional </b>
     * <li>PV1-20: FINANCIAL CLASS (ID) <b>optional repeating</b>
     * <li>PV1-21: CHARGE PRICE INDICATOR (ID) <b>optional </b>
     * <li>PV1-22: COURTESY CODE (ID) <b>optional </b>
     * <li>PV1-23: CREDIT RATING (ID) <b>optional </b>
     * <li>PV1-24: CONTRACT CODE (ID) <b>optional repeating</b>
     * <li>PV1-25: CONTRACT EFFECTIVE DATE (DT) <b>optional repeating</b>
     * <li>PV1-26: CONTRACT AMOUNT (NM) <b>optional repeating</b>
     * <li>PV1-27: CONTRACT PERIOD (NM) <b>optional repeating</b>
     * <li>PV1-28: INTEREST CODE (ID) <b>optional </b>
     * <li>PV1-29: TRANSFER TO BAD DEBT CODE (ID) <b>optional </b>
     * <li>PV1-30: TRANSFER TO BAD DEBT DATE (DT) <b>optional </b>
     * <li>PV1-31: BAD DEBT AGENCY CODE (ST) <b>optional </b>
     * <li>PV1-32: BAD DEBT TRANSFER AMOUNT (NM) <b>optional </b>
     * <li>PV1-33: BAD DEBT RECOVERY AMOUNT (NM) <b>optional </b>
     * <li>PV1-34: DELETE ACCOUNT INDICATOR (ID) <b>optional </b>
     * <li>PV1-35: DELETE ACCOUNT DATE (DT) <b>optional </b>
     * <li>PV1-36: DISCHARGE DISPOSITION (ID) <b>optional </b>
     * <li>PV1-37: DISCHARGED TO LOCATION (ID) <b>optional </b>
     * <li>PV1-38: DIET TYPE (ID) <b>optional </b>
     * <li>PV1-39: SERVICING FACILITY (ID) <b>optional </b>
     * <li>PV1-40: BED STATUS (ID) <b>optional </b>
     * <li>PV1-41: ACCOUNT STATUS (ID) <b>optional </b>
     * <li>PV1-42: PENDING LOCATION (ID) <b>optional </b>
     * <li>PV1-43: PRIOR TEMPORARY LOCATION (ID) <b>optional </b>
     * <li>PV1-44: ADMIT DATE/TIME (TS) <b>optional </b>
     * <li>PV1-45: DISCHARGE DATE/TIME (TS) <b>optional </b>
     * <li>PV1-46: CURRENT PATIENT BALANCE (NM) <b>optional </b>
     * <li>PV1-47: TOTAL CHARGES (NM) <b>optional </b>
     * <li>PV1-48: TOTAL ADJUSTMENTS (NM) <b>optional </b>
     * <li>PV1-49: TOTAL PAYMENTS (NM) <b>optional </b>
 * </ul>
 */
@SuppressWarnings("unused")
public class PV1 extends AbstractSegment {

    /** 
     * Creates a new PV1 segment
     */
    public PV1(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(SI.class, false, 1, 4, new Object[]{ getMessage() }, "SET ID - PATIENT VISIT");
                                              this.add(ID.class, true, 1, 1, new Object[]{ getMessage(), new Integer(4) }, "PATIENT CLASS");
                                              this.add(ID.class, true, 1, 12, new Object[]{ getMessage(), new Integer(79) }, "ASSIGNED PATIENT LOCATION");
                                              this.add(ID.class, false, 1, 2, new Object[]{ getMessage(), new Integer(7) }, "ADMISSION TYPE");
                                  this.add(ST.class, false, 1, 20, new Object[]{ getMessage() }, "PRE-ADMIT NUMBER");
                                              this.add(ID.class, false, 1, 12, new Object[]{ getMessage(), new Integer(79) }, "PRIOR PATIENT LOCATION");
                                  this.add(CN.class, false, 1, 60, new Object[]{ getMessage() }, "ATTENDING DOCTOR");
                                  this.add(CN.class, false, 1, 60, new Object[]{ getMessage() }, "REFERRING DOCTOR");
                                  this.add(CN.class, false, 0, 60, new Object[]{ getMessage() }, "CONSULTING DOCTOR");
                                              this.add(ID.class, false, 1, 3, new Object[]{ getMessage(), new Integer(69) }, "HOSPITAL SERVICE");
                                              this.add(ID.class, false, 1, 12, new Object[]{ getMessage(), new Integer(79) }, "TEMPORARY LOCATION");
                                              this.add(ID.class, false, 1, 2, new Object[]{ getMessage(), new Integer(87) }, "PRE-ADMIT TEST INDICATOR");
                                              this.add(ID.class, false, 1, 2, new Object[]{ getMessage(), new Integer(92) }, "RE-ADMISSION INDICATOR");
                                              this.add(ID.class, false, 1, 3, new Object[]{ getMessage(), new Integer(23) }, "ADMIT SOURCE");
                                              this.add(ID.class, false, 1, 2, new Object[]{ getMessage(), new Integer(9) }, "AMBULATORY STATUS");
                                              this.add(ID.class, false, 1, 2, new Object[]{ getMessage(), new Integer(99) }, "VIP INDICATOR");
                                  this.add(CN.class, false, 1, 60, new Object[]{ getMessage() }, "ADMITTING DOCTOR");
                                              this.add(ID.class, false, 1, 2, new Object[]{ getMessage(), new Integer(18) }, "PATIENT TYPE");
                                  this.add(NM.class, false, 1, 4, new Object[]{ getMessage() }, "VISIT NUMBER");
                                              this.add(ID.class, false, 4, 11, new Object[]{ getMessage(), new Integer(64) }, "FINANCIAL CLASS");
                                              this.add(ID.class, false, 1, 2, new Object[]{ getMessage(), new Integer(32) }, "CHARGE PRICE INDICATOR");
                                              this.add(ID.class, false, 1, 2, new Object[]{ getMessage(), new Integer(45) }, "COURTESY CODE");
                                              this.add(ID.class, false, 1, 2, new Object[]{ getMessage(), new Integer(46) }, "CREDIT RATING");
                                              this.add(ID.class, false, 0, 2, new Object[]{ getMessage(), new Integer(44) }, "CONTRACT CODE");
                                  this.add(DT.class, false, 0, 8, new Object[]{ getMessage() }, "CONTRACT EFFECTIVE DATE");
                                  this.add(NM.class, false, 0, 12, new Object[]{ getMessage() }, "CONTRACT AMOUNT");
                                  this.add(NM.class, false, 0, 3, new Object[]{ getMessage() }, "CONTRACT PERIOD");
                                              this.add(ID.class, false, 1, 2, new Object[]{ getMessage(), new Integer(73) }, "INTEREST CODE");
                                              this.add(ID.class, false, 1, 1, new Object[]{ getMessage(), new Integer(110) }, "TRANSFER TO BAD DEBT CODE");
                                  this.add(DT.class, false, 1, 8, new Object[]{ getMessage() }, "TRANSFER TO BAD DEBT DATE");
                                  this.add(ST.class, false, 1, 10, new Object[]{ getMessage() }, "BAD DEBT AGENCY CODE");
                                  this.add(NM.class, false, 1, 12, new Object[]{ getMessage() }, "BAD DEBT TRANSFER AMOUNT");
                                  this.add(NM.class, false, 1, 12, new Object[]{ getMessage() }, "BAD DEBT RECOVERY AMOUNT");
                                              this.add(ID.class, false, 1, 1, new Object[]{ getMessage(), new Integer(111) }, "DELETE ACCOUNT INDICATOR");
                                  this.add(DT.class, false, 1, 8, new Object[]{ getMessage() }, "DELETE ACCOUNT DATE");
                                              this.add(ID.class, false, 1, 2, new Object[]{ getMessage(), new Integer(112) }, "DISCHARGE DISPOSITION");
                                              this.add(ID.class, false, 1, 2, new Object[]{ getMessage(), new Integer(113) }, "DISCHARGED TO LOCATION");
                                              this.add(ID.class, false, 1, 2, new Object[]{ getMessage(), new Integer(114) }, "DIET TYPE");
                                              this.add(ID.class, false, 1, 2, new Object[]{ getMessage(), new Integer(115) }, "SERVICING FACILITY");
                                              this.add(ID.class, false, 1, 1, new Object[]{ getMessage(), new Integer(116) }, "BED STATUS");
                                              this.add(ID.class, false, 1, 2, new Object[]{ getMessage(), new Integer(117) }, "ACCOUNT STATUS");
                                              this.add(ID.class, false, 1, 12, new Object[]{ getMessage(), new Integer(79) }, "PENDING LOCATION");
                                              this.add(ID.class, false, 1, 12, new Object[]{ getMessage(), new Integer(79) }, "PRIOR TEMPORARY LOCATION");
                                  this.add(TS.class, false, 1, 19, new Object[]{ getMessage() }, "ADMIT DATE/TIME");
                                  this.add(TS.class, false, 1, 19, new Object[]{ getMessage() }, "DISCHARGE DATE/TIME");
                                  this.add(NM.class, false, 1, 12, new Object[]{ getMessage() }, "CURRENT PATIENT BALANCE");
                                  this.add(NM.class, false, 1, 12, new Object[]{ getMessage() }, "TOTAL CHARGES");
                                  this.add(NM.class, false, 1, 12, new Object[]{ getMessage() }, "TOTAL ADJUSTMENTS");
                                  this.add(NM.class, false, 1, 12, new Object[]{ getMessage() }, "TOTAL PAYMENTS");
       } catch(HL7Exception e) {
          log.error("Unexpected error creating PV1 - this is probably a bug in the source code generator.", e);
       }
    }



    /**
     * Returns
     * PV1-1: "SET ID - PATIENT VISIT" - creates it if necessary
     */
    public SI getSETIDPATIENTVISIT() { 
		SI retVal = this.getTypedField(1, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PV1-1: "SET ID - PATIENT VISIT" - creates it if necessary
     */
    public SI getPv11_SETIDPATIENTVISIT() { 
		SI retVal = this.getTypedField(1, 0);
		return retVal;
    }



    /**
     * Returns
     * PV1-2: "PATIENT CLASS" - creates it if necessary
     */
    public ID getPATIENTCLASS() { 
		ID retVal = this.getTypedField(2, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PV1-2: "PATIENT CLASS" - creates it if necessary
     */
    public ID getPv12_PATIENTCLASS() { 
		ID retVal = this.getTypedField(2, 0);
		return retVal;
    }



    /**
     * Returns
     * PV1-3: "ASSIGNED PATIENT LOCATION" - creates it if necessary
     */
    public ID getASSIGNEDPATIENTLOCATION() { 
		ID retVal = this.getTypedField(3, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PV1-3: "ASSIGNED PATIENT LOCATION" - creates it if necessary
     */
    public ID getPv13_ASSIGNEDPATIENTLOCATION() { 
		ID retVal = this.getTypedField(3, 0);
		return retVal;
    }



    /**
     * Returns
     * PV1-4: "ADMISSION TYPE" - creates it if necessary
     */
    public ID getADMISSIONTYPE() { 
		ID retVal = this.getTypedField(4, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PV1-4: "ADMISSION TYPE" - creates it if necessary
     */
    public ID getPv14_ADMISSIONTYPE() { 
		ID retVal = this.getTypedField(4, 0);
		return retVal;
    }



    /**
     * Returns
     * PV1-5: "PRE-ADMIT NUMBER" - creates it if necessary
     */
    public ST getPREADMITNUMBER() { 
		ST retVal = this.getTypedField(5, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PV1-5: "PRE-ADMIT NUMBER" - creates it if necessary
     */
    public ST getPv15_PREADMITNUMBER() { 
		ST retVal = this.getTypedField(5, 0);
		return retVal;
    }



    /**
     * Returns
     * PV1-6: "PRIOR PATIENT LOCATION" - creates it if necessary
     */
    public ID getPRIORPATIENTLOCATION() { 
		ID retVal = this.getTypedField(6, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PV1-6: "PRIOR PATIENT LOCATION" - creates it if necessary
     */
    public ID getPv16_PRIORPATIENTLOCATION() { 
		ID retVal = this.getTypedField(6, 0);
		return retVal;
    }



    /**
     * Returns
     * PV1-7: "ATTENDING DOCTOR" - creates it if necessary
     */
    public CN getATTENDINGDOCTOR() { 
		CN retVal = this.getTypedField(7, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PV1-7: "ATTENDING DOCTOR" - creates it if necessary
     */
    public CN getPv17_ATTENDINGDOCTOR() { 
		CN retVal = this.getTypedField(7, 0);
		return retVal;
    }



    /**
     * Returns
     * PV1-8: "REFERRING DOCTOR" - creates it if necessary
     */
    public CN getREFERRINGDOCTOR() { 
		CN retVal = this.getTypedField(8, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PV1-8: "REFERRING DOCTOR" - creates it if necessary
     */
    public CN getPv18_REFERRINGDOCTOR() { 
		CN retVal = this.getTypedField(8, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of CONSULTING DOCTOR (PV1-9).
     */
    public CN[] getCONSULTINGDOCTOR() {
    	CN[] retVal = this.getTypedField(9, new CN[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of CONSULTING DOCTOR (PV1-9).
     */
    public CN[] getPv19_CONSULTINGDOCTOR() {
    	CN[] retVal = this.getTypedField(9, new CN[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of CONSULTING DOCTOR (PV1-9).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getCONSULTINGDOCTORReps() {
    	return this.getReps(9);
    }


    /**
     * Returns a specific repetition of
     * PV1-9: "CONSULTING DOCTOR" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CN getCONSULTINGDOCTOR(int rep) { 
		CN retVal = this.getTypedField(9, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * PV1-9: "CONSULTING DOCTOR" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CN getPv19_CONSULTINGDOCTOR(int rep) { 
		CN retVal = this.getTypedField(9, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of CONSULTING DOCTOR (PV1-9).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getPv19_CONSULTINGDOCTORReps() {
    	return this.getReps(9);
    }


    /**
     * Inserts a repetition of
     * PV1-9: "CONSULTING DOCTOR" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CN insertCONSULTINGDOCTOR(int rep) throws HL7Exception { 
        return (CN) super.insertRepetition(9, rep);
    }


    /**
     * Inserts a repetition of
     * PV1-9: "CONSULTING DOCTOR" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CN insertPv19_CONSULTINGDOCTOR(int rep) throws HL7Exception { 
        return (CN) super.insertRepetition(9, rep);
    }


    /**
     * Removes a repetition of
     * PV1-9: "CONSULTING DOCTOR" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CN removeCONSULTINGDOCTOR(int rep) throws HL7Exception { 
        return (CN) super.removeRepetition(9, rep);
    }


    /**
     * Removes a repetition of
     * PV1-9: "CONSULTING DOCTOR" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CN removePv19_CONSULTINGDOCTOR(int rep) throws HL7Exception { 
        return (CN) super.removeRepetition(9, rep);
    }




    /**
     * Returns
     * PV1-10: "HOSPITAL SERVICE" - creates it if necessary
     */
    public ID getHOSPITALSERVICE() { 
		ID retVal = this.getTypedField(10, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PV1-10: "HOSPITAL SERVICE" - creates it if necessary
     */
    public ID getPv110_HOSPITALSERVICE() { 
		ID retVal = this.getTypedField(10, 0);
		return retVal;
    }



    /**
     * Returns
     * PV1-11: "TEMPORARY LOCATION" - creates it if necessary
     */
    public ID getTEMPORARYLOCATION() { 
		ID retVal = this.getTypedField(11, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PV1-11: "TEMPORARY LOCATION" - creates it if necessary
     */
    public ID getPv111_TEMPORARYLOCATION() { 
		ID retVal = this.getTypedField(11, 0);
		return retVal;
    }



    /**
     * Returns
     * PV1-12: "PRE-ADMIT TEST INDICATOR" - creates it if necessary
     */
    public ID getPREADMITTESTINDICATOR() { 
		ID retVal = this.getTypedField(12, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PV1-12: "PRE-ADMIT TEST INDICATOR" - creates it if necessary
     */
    public ID getPv112_PREADMITTESTINDICATOR() { 
		ID retVal = this.getTypedField(12, 0);
		return retVal;
    }



    /**
     * Returns
     * PV1-13: "RE-ADMISSION INDICATOR" - creates it if necessary
     */
    public ID getREADMISSIONINDICATOR() { 
		ID retVal = this.getTypedField(13, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PV1-13: "RE-ADMISSION INDICATOR" - creates it if necessary
     */
    public ID getPv113_READMISSIONINDICATOR() { 
		ID retVal = this.getTypedField(13, 0);
		return retVal;
    }



    /**
     * Returns
     * PV1-14: "ADMIT SOURCE" - creates it if necessary
     */
    public ID getADMITSOURCE() { 
		ID retVal = this.getTypedField(14, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PV1-14: "ADMIT SOURCE" - creates it if necessary
     */
    public ID getPv114_ADMITSOURCE() { 
		ID retVal = this.getTypedField(14, 0);
		return retVal;
    }



    /**
     * Returns
     * PV1-15: "AMBULATORY STATUS" - creates it if necessary
     */
    public ID getAMBULATORYSTATUS() { 
		ID retVal = this.getTypedField(15, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PV1-15: "AMBULATORY STATUS" - creates it if necessary
     */
    public ID getPv115_AMBULATORYSTATUS() { 
		ID retVal = this.getTypedField(15, 0);
		return retVal;
    }



    /**
     * Returns
     * PV1-16: "VIP INDICATOR" - creates it if necessary
     */
    public ID getVIPINDICATOR() { 
		ID retVal = this.getTypedField(16, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PV1-16: "VIP INDICATOR" - creates it if necessary
     */
    public ID getPv116_VIPINDICATOR() { 
		ID retVal = this.getTypedField(16, 0);
		return retVal;
    }



    /**
     * Returns
     * PV1-17: "ADMITTING DOCTOR" - creates it if necessary
     */
    public CN getADMITTINGDOCTOR() { 
		CN retVal = this.getTypedField(17, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PV1-17: "ADMITTING DOCTOR" - creates it if necessary
     */
    public CN getPv117_ADMITTINGDOCTOR() { 
		CN retVal = this.getTypedField(17, 0);
		return retVal;
    }



    /**
     * Returns
     * PV1-18: "PATIENT TYPE" - creates it if necessary
     */
    public ID getPATIENTTYPE() { 
		ID retVal = this.getTypedField(18, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PV1-18: "PATIENT TYPE" - creates it if necessary
     */
    public ID getPv118_PATIENTTYPE() { 
		ID retVal = this.getTypedField(18, 0);
		return retVal;
    }



    /**
     * Returns
     * PV1-19: "VISIT NUMBER" - creates it if necessary
     */
    public NM getVISITNUMBER() { 
		NM retVal = this.getTypedField(19, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PV1-19: "VISIT NUMBER" - creates it if necessary
     */
    public NM getPv119_VISITNUMBER() { 
		NM retVal = this.getTypedField(19, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of FINANCIAL CLASS (PV1-20).
     */
    public ID[] getFINANCIALCLASS() {
    	ID[] retVal = this.getTypedField(20, new ID[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of FINANCIAL CLASS (PV1-20).
     */
    public ID[] getPv120_FINANCIALCLASS() {
    	ID[] retVal = this.getTypedField(20, new ID[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of FINANCIAL CLASS (PV1-20).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getFINANCIALCLASSReps() {
    	return this.getReps(20);
    }


    /**
     * Returns a specific repetition of
     * PV1-20: "FINANCIAL CLASS" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public ID getFINANCIALCLASS(int rep) { 
		ID retVal = this.getTypedField(20, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * PV1-20: "FINANCIAL CLASS" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public ID getPv120_FINANCIALCLASS(int rep) { 
		ID retVal = this.getTypedField(20, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of FINANCIAL CLASS (PV1-20).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getPv120_FINANCIALCLASSReps() {
    	return this.getReps(20);
    }


    /**
     * Inserts a repetition of
     * PV1-20: "FINANCIAL CLASS" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ID insertFINANCIALCLASS(int rep) throws HL7Exception { 
        return (ID) super.insertRepetition(20, rep);
    }


    /**
     * Inserts a repetition of
     * PV1-20: "FINANCIAL CLASS" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ID insertPv120_FINANCIALCLASS(int rep) throws HL7Exception { 
        return (ID) super.insertRepetition(20, rep);
    }


    /**
     * Removes a repetition of
     * PV1-20: "FINANCIAL CLASS" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ID removeFINANCIALCLASS(int rep) throws HL7Exception { 
        return (ID) super.removeRepetition(20, rep);
    }


    /**
     * Removes a repetition of
     * PV1-20: "FINANCIAL CLASS" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ID removePv120_FINANCIALCLASS(int rep) throws HL7Exception { 
        return (ID) super.removeRepetition(20, rep);
    }




    /**
     * Returns
     * PV1-21: "CHARGE PRICE INDICATOR" - creates it if necessary
     */
    public ID getCHARGEPRICEINDICATOR() { 
		ID retVal = this.getTypedField(21, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PV1-21: "CHARGE PRICE INDICATOR" - creates it if necessary
     */
    public ID getPv121_CHARGEPRICEINDICATOR() { 
		ID retVal = this.getTypedField(21, 0);
		return retVal;
    }



    /**
     * Returns
     * PV1-22: "COURTESY CODE" - creates it if necessary
     */
    public ID getCOURTESYCODE() { 
		ID retVal = this.getTypedField(22, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PV1-22: "COURTESY CODE" - creates it if necessary
     */
    public ID getPv122_COURTESYCODE() { 
		ID retVal = this.getTypedField(22, 0);
		return retVal;
    }



    /**
     * Returns
     * PV1-23: "CREDIT RATING" - creates it if necessary
     */
    public ID getCREDITRATING() { 
		ID retVal = this.getTypedField(23, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PV1-23: "CREDIT RATING" - creates it if necessary
     */
    public ID getPv123_CREDITRATING() { 
		ID retVal = this.getTypedField(23, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of CONTRACT CODE (PV1-24).
     */
    public ID[] getCONTRACTCODE() {
    	ID[] retVal = this.getTypedField(24, new ID[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of CONTRACT CODE (PV1-24).
     */
    public ID[] getPv124_CONTRACTCODE() {
    	ID[] retVal = this.getTypedField(24, new ID[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of CONTRACT CODE (PV1-24).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getCONTRACTCODEReps() {
    	return this.getReps(24);
    }


    /**
     * Returns a specific repetition of
     * PV1-24: "CONTRACT CODE" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public ID getCONTRACTCODE(int rep) { 
		ID retVal = this.getTypedField(24, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * PV1-24: "CONTRACT CODE" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public ID getPv124_CONTRACTCODE(int rep) { 
		ID retVal = this.getTypedField(24, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of CONTRACT CODE (PV1-24).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getPv124_CONTRACTCODEReps() {
    	return this.getReps(24);
    }


    /**
     * Inserts a repetition of
     * PV1-24: "CONTRACT CODE" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ID insertCONTRACTCODE(int rep) throws HL7Exception { 
        return (ID) super.insertRepetition(24, rep);
    }


    /**
     * Inserts a repetition of
     * PV1-24: "CONTRACT CODE" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ID insertPv124_CONTRACTCODE(int rep) throws HL7Exception { 
        return (ID) super.insertRepetition(24, rep);
    }


    /**
     * Removes a repetition of
     * PV1-24: "CONTRACT CODE" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ID removeCONTRACTCODE(int rep) throws HL7Exception { 
        return (ID) super.removeRepetition(24, rep);
    }


    /**
     * Removes a repetition of
     * PV1-24: "CONTRACT CODE" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public ID removePv124_CONTRACTCODE(int rep) throws HL7Exception { 
        return (ID) super.removeRepetition(24, rep);
    }



    /**
     * Returns all repetitions of CONTRACT EFFECTIVE DATE (PV1-25).
     */
    public DT[] getCONTRACTEFFECTIVEDATE() {
    	DT[] retVal = this.getTypedField(25, new DT[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of CONTRACT EFFECTIVE DATE (PV1-25).
     */
    public DT[] getPv125_CONTRACTEFFECTIVEDATE() {
    	DT[] retVal = this.getTypedField(25, new DT[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of CONTRACT EFFECTIVE DATE (PV1-25).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getCONTRACTEFFECTIVEDATEReps() {
    	return this.getReps(25);
    }


    /**
     * Returns a specific repetition of
     * PV1-25: "CONTRACT EFFECTIVE DATE" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public DT getCONTRACTEFFECTIVEDATE(int rep) { 
		DT retVal = this.getTypedField(25, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * PV1-25: "CONTRACT EFFECTIVE DATE" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public DT getPv125_CONTRACTEFFECTIVEDATE(int rep) { 
		DT retVal = this.getTypedField(25, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of CONTRACT EFFECTIVE DATE (PV1-25).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getPv125_CONTRACTEFFECTIVEDATEReps() {
    	return this.getReps(25);
    }


    /**
     * Inserts a repetition of
     * PV1-25: "CONTRACT EFFECTIVE DATE" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public DT insertCONTRACTEFFECTIVEDATE(int rep) throws HL7Exception { 
        return (DT) super.insertRepetition(25, rep);
    }


    /**
     * Inserts a repetition of
     * PV1-25: "CONTRACT EFFECTIVE DATE" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public DT insertPv125_CONTRACTEFFECTIVEDATE(int rep) throws HL7Exception { 
        return (DT) super.insertRepetition(25, rep);
    }


    /**
     * Removes a repetition of
     * PV1-25: "CONTRACT EFFECTIVE DATE" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public DT removeCONTRACTEFFECTIVEDATE(int rep) throws HL7Exception { 
        return (DT) super.removeRepetition(25, rep);
    }


    /**
     * Removes a repetition of
     * PV1-25: "CONTRACT EFFECTIVE DATE" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public DT removePv125_CONTRACTEFFECTIVEDATE(int rep) throws HL7Exception { 
        return (DT) super.removeRepetition(25, rep);
    }



    /**
     * Returns all repetitions of CONTRACT AMOUNT (PV1-26).
     */
    public NM[] getCONTRACTAMOUNT() {
    	NM[] retVal = this.getTypedField(26, new NM[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of CONTRACT AMOUNT (PV1-26).
     */
    public NM[] getPv126_CONTRACTAMOUNT() {
    	NM[] retVal = this.getTypedField(26, new NM[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of CONTRACT AMOUNT (PV1-26).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getCONTRACTAMOUNTReps() {
    	return this.getReps(26);
    }


    /**
     * Returns a specific repetition of
     * PV1-26: "CONTRACT AMOUNT" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public NM getCONTRACTAMOUNT(int rep) { 
		NM retVal = this.getTypedField(26, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * PV1-26: "CONTRACT AMOUNT" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public NM getPv126_CONTRACTAMOUNT(int rep) { 
		NM retVal = this.getTypedField(26, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of CONTRACT AMOUNT (PV1-26).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getPv126_CONTRACTAMOUNTReps() {
    	return this.getReps(26);
    }


    /**
     * Inserts a repetition of
     * PV1-26: "CONTRACT AMOUNT" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public NM insertCONTRACTAMOUNT(int rep) throws HL7Exception { 
        return (NM) super.insertRepetition(26, rep);
    }


    /**
     * Inserts a repetition of
     * PV1-26: "CONTRACT AMOUNT" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public NM insertPv126_CONTRACTAMOUNT(int rep) throws HL7Exception { 
        return (NM) super.insertRepetition(26, rep);
    }


    /**
     * Removes a repetition of
     * PV1-26: "CONTRACT AMOUNT" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public NM removeCONTRACTAMOUNT(int rep) throws HL7Exception { 
        return (NM) super.removeRepetition(26, rep);
    }


    /**
     * Removes a repetition of
     * PV1-26: "CONTRACT AMOUNT" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public NM removePv126_CONTRACTAMOUNT(int rep) throws HL7Exception { 
        return (NM) super.removeRepetition(26, rep);
    }



    /**
     * Returns all repetitions of CONTRACT PERIOD (PV1-27).
     */
    public NM[] getCONTRACTPERIOD() {
    	NM[] retVal = this.getTypedField(27, new NM[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of CONTRACT PERIOD (PV1-27).
     */
    public NM[] getPv127_CONTRACTPERIOD() {
    	NM[] retVal = this.getTypedField(27, new NM[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of CONTRACT PERIOD (PV1-27).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getCONTRACTPERIODReps() {
    	return this.getReps(27);
    }


    /**
     * Returns a specific repetition of
     * PV1-27: "CONTRACT PERIOD" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public NM getCONTRACTPERIOD(int rep) { 
		NM retVal = this.getTypedField(27, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * PV1-27: "CONTRACT PERIOD" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public NM getPv127_CONTRACTPERIOD(int rep) { 
		NM retVal = this.getTypedField(27, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of CONTRACT PERIOD (PV1-27).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getPv127_CONTRACTPERIODReps() {
    	return this.getReps(27);
    }


    /**
     * Inserts a repetition of
     * PV1-27: "CONTRACT PERIOD" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public NM insertCONTRACTPERIOD(int rep) throws HL7Exception { 
        return (NM) super.insertRepetition(27, rep);
    }


    /**
     * Inserts a repetition of
     * PV1-27: "CONTRACT PERIOD" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public NM insertPv127_CONTRACTPERIOD(int rep) throws HL7Exception { 
        return (NM) super.insertRepetition(27, rep);
    }


    /**
     * Removes a repetition of
     * PV1-27: "CONTRACT PERIOD" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public NM removeCONTRACTPERIOD(int rep) throws HL7Exception { 
        return (NM) super.removeRepetition(27, rep);
    }


    /**
     * Removes a repetition of
     * PV1-27: "CONTRACT PERIOD" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public NM removePv127_CONTRACTPERIOD(int rep) throws HL7Exception { 
        return (NM) super.removeRepetition(27, rep);
    }




    /**
     * Returns
     * PV1-28: "INTEREST CODE" - creates it if necessary
     */
    public ID getINTERESTCODE() { 
		ID retVal = this.getTypedField(28, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PV1-28: "INTEREST CODE" - creates it if necessary
     */
    public ID getPv128_INTERESTCODE() { 
		ID retVal = this.getTypedField(28, 0);
		return retVal;
    }



    /**
     * Returns
     * PV1-29: "TRANSFER TO BAD DEBT CODE" - creates it if necessary
     */
    public ID getTRANSFERTOBADDEBTCODE() { 
		ID retVal = this.getTypedField(29, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PV1-29: "TRANSFER TO BAD DEBT CODE" - creates it if necessary
     */
    public ID getPv129_TRANSFERTOBADDEBTCODE() { 
		ID retVal = this.getTypedField(29, 0);
		return retVal;
    }



    /**
     * Returns
     * PV1-30: "TRANSFER TO BAD DEBT DATE" - creates it if necessary
     */
    public DT getTRANSFERTOBADDEBTDATE() { 
		DT retVal = this.getTypedField(30, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PV1-30: "TRANSFER TO BAD DEBT DATE" - creates it if necessary
     */
    public DT getPv130_TRANSFERTOBADDEBTDATE() { 
		DT retVal = this.getTypedField(30, 0);
		return retVal;
    }



    /**
     * Returns
     * PV1-31: "BAD DEBT AGENCY CODE" - creates it if necessary
     */
    public ST getBADDEBTAGENCYCODE() { 
		ST retVal = this.getTypedField(31, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PV1-31: "BAD DEBT AGENCY CODE" - creates it if necessary
     */
    public ST getPv131_BADDEBTAGENCYCODE() { 
		ST retVal = this.getTypedField(31, 0);
		return retVal;
    }



    /**
     * Returns
     * PV1-32: "BAD DEBT TRANSFER AMOUNT" - creates it if necessary
     */
    public NM getBADDEBTTRANSFERAMOUNT() { 
		NM retVal = this.getTypedField(32, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PV1-32: "BAD DEBT TRANSFER AMOUNT" - creates it if necessary
     */
    public NM getPv132_BADDEBTTRANSFERAMOUNT() { 
		NM retVal = this.getTypedField(32, 0);
		return retVal;
    }



    /**
     * Returns
     * PV1-33: "BAD DEBT RECOVERY AMOUNT" - creates it if necessary
     */
    public NM getBADDEBTRECOVERYAMOUNT() { 
		NM retVal = this.getTypedField(33, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PV1-33: "BAD DEBT RECOVERY AMOUNT" - creates it if necessary
     */
    public NM getPv133_BADDEBTRECOVERYAMOUNT() { 
		NM retVal = this.getTypedField(33, 0);
		return retVal;
    }



    /**
     * Returns
     * PV1-34: "DELETE ACCOUNT INDICATOR" - creates it if necessary
     */
    public ID getDELETEACCOUNTINDICATOR() { 
		ID retVal = this.getTypedField(34, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PV1-34: "DELETE ACCOUNT INDICATOR" - creates it if necessary
     */
    public ID getPv134_DELETEACCOUNTINDICATOR() { 
		ID retVal = this.getTypedField(34, 0);
		return retVal;
    }



    /**
     * Returns
     * PV1-35: "DELETE ACCOUNT DATE" - creates it if necessary
     */
    public DT getDELETEACCOUNTDATE() { 
		DT retVal = this.getTypedField(35, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PV1-35: "DELETE ACCOUNT DATE" - creates it if necessary
     */
    public DT getPv135_DELETEACCOUNTDATE() { 
		DT retVal = this.getTypedField(35, 0);
		return retVal;
    }



    /**
     * Returns
     * PV1-36: "DISCHARGE DISPOSITION" - creates it if necessary
     */
    public ID getDISCHARGEDISPOSITION() { 
		ID retVal = this.getTypedField(36, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PV1-36: "DISCHARGE DISPOSITION" - creates it if necessary
     */
    public ID getPv136_DISCHARGEDISPOSITION() { 
		ID retVal = this.getTypedField(36, 0);
		return retVal;
    }



    /**
     * Returns
     * PV1-37: "DISCHARGED TO LOCATION" - creates it if necessary
     */
    public ID getDISCHARGEDTOLOCATION() { 
		ID retVal = this.getTypedField(37, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PV1-37: "DISCHARGED TO LOCATION" - creates it if necessary
     */
    public ID getPv137_DISCHARGEDTOLOCATION() { 
		ID retVal = this.getTypedField(37, 0);
		return retVal;
    }



    /**
     * Returns
     * PV1-38: "DIET TYPE" - creates it if necessary
     */
    public ID getDIETTYPE() { 
		ID retVal = this.getTypedField(38, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PV1-38: "DIET TYPE" - creates it if necessary
     */
    public ID getPv138_DIETTYPE() { 
		ID retVal = this.getTypedField(38, 0);
		return retVal;
    }



    /**
     * Returns
     * PV1-39: "SERVICING FACILITY" - creates it if necessary
     */
    public ID getSERVICINGFACILITY() { 
		ID retVal = this.getTypedField(39, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PV1-39: "SERVICING FACILITY" - creates it if necessary
     */
    public ID getPv139_SERVICINGFACILITY() { 
		ID retVal = this.getTypedField(39, 0);
		return retVal;
    }



    /**
     * Returns
     * PV1-40: "BED STATUS" - creates it if necessary
     */
    public ID getBEDSTATUS() { 
		ID retVal = this.getTypedField(40, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PV1-40: "BED STATUS" - creates it if necessary
     */
    public ID getPv140_BEDSTATUS() { 
		ID retVal = this.getTypedField(40, 0);
		return retVal;
    }



    /**
     * Returns
     * PV1-41: "ACCOUNT STATUS" - creates it if necessary
     */
    public ID getACCOUNTSTATUS() { 
		ID retVal = this.getTypedField(41, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PV1-41: "ACCOUNT STATUS" - creates it if necessary
     */
    public ID getPv141_ACCOUNTSTATUS() { 
		ID retVal = this.getTypedField(41, 0);
		return retVal;
    }



    /**
     * Returns
     * PV1-42: "PENDING LOCATION" - creates it if necessary
     */
    public ID getPENDINGLOCATION() { 
		ID retVal = this.getTypedField(42, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PV1-42: "PENDING LOCATION" - creates it if necessary
     */
    public ID getPv142_PENDINGLOCATION() { 
		ID retVal = this.getTypedField(42, 0);
		return retVal;
    }



    /**
     * Returns
     * PV1-43: "PRIOR TEMPORARY LOCATION" - creates it if necessary
     */
    public ID getPRIORTEMPORARYLOCATION() { 
		ID retVal = this.getTypedField(43, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PV1-43: "PRIOR TEMPORARY LOCATION" - creates it if necessary
     */
    public ID getPv143_PRIORTEMPORARYLOCATION() { 
		ID retVal = this.getTypedField(43, 0);
		return retVal;
    }



    /**
     * Returns
     * PV1-44: "ADMIT DATE/TIME" - creates it if necessary
     */
    public TS getADMITDATETIME() { 
		TS retVal = this.getTypedField(44, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PV1-44: "ADMIT DATE/TIME" - creates it if necessary
     */
    public TS getPv144_ADMITDATETIME() { 
		TS retVal = this.getTypedField(44, 0);
		return retVal;
    }



    /**
     * Returns
     * PV1-45: "DISCHARGE DATE/TIME" - creates it if necessary
     */
    public TS getDISCHARGEDATETIME() { 
		TS retVal = this.getTypedField(45, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PV1-45: "DISCHARGE DATE/TIME" - creates it if necessary
     */
    public TS getPv145_DISCHARGEDATETIME() { 
		TS retVal = this.getTypedField(45, 0);
		return retVal;
    }



    /**
     * Returns
     * PV1-46: "CURRENT PATIENT BALANCE" - creates it if necessary
     */
    public NM getCURRENTPATIENTBALANCE() { 
		NM retVal = this.getTypedField(46, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PV1-46: "CURRENT PATIENT BALANCE" - creates it if necessary
     */
    public NM getPv146_CURRENTPATIENTBALANCE() { 
		NM retVal = this.getTypedField(46, 0);
		return retVal;
    }



    /**
     * Returns
     * PV1-47: "TOTAL CHARGES" - creates it if necessary
     */
    public NM getTOTALCHARGES() { 
		NM retVal = this.getTypedField(47, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PV1-47: "TOTAL CHARGES" - creates it if necessary
     */
    public NM getPv147_TOTALCHARGES() { 
		NM retVal = this.getTypedField(47, 0);
		return retVal;
    }



    /**
     * Returns
     * PV1-48: "TOTAL ADJUSTMENTS" - creates it if necessary
     */
    public NM getTOTALADJUSTMENTS() { 
		NM retVal = this.getTypedField(48, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PV1-48: "TOTAL ADJUSTMENTS" - creates it if necessary
     */
    public NM getPv148_TOTALADJUSTMENTS() { 
		NM retVal = this.getTypedField(48, 0);
		return retVal;
    }



    /**
     * Returns
     * PV1-49: "TOTAL PAYMENTS" - creates it if necessary
     */
    public NM getTOTALPAYMENTS() { 
		NM retVal = this.getTypedField(49, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PV1-49: "TOTAL PAYMENTS" - creates it if necessary
     */
    public NM getPv149_TOTALPAYMENTS() { 
		NM retVal = this.getTypedField(49, 0);
		return retVal;
    }





    /** {@inheritDoc} */   
    protected Type createNewTypeWithoutReflection(int field) {
       switch (field) {
          case 0: return new SI(getMessage());
          case 1: return new ID(getMessage(), new Integer( 4 ));
          case 2: return new ID(getMessage(), new Integer( 79 ));
          case 3: return new ID(getMessage(), new Integer( 7 ));
          case 4: return new ST(getMessage());
          case 5: return new ID(getMessage(), new Integer( 79 ));
          case 6: return new CN(getMessage());
          case 7: return new CN(getMessage());
          case 8: return new CN(getMessage());
          case 9: return new ID(getMessage(), new Integer( 69 ));
          case 10: return new ID(getMessage(), new Integer( 79 ));
          case 11: return new ID(getMessage(), new Integer( 87 ));
          case 12: return new ID(getMessage(), new Integer( 92 ));
          case 13: return new ID(getMessage(), new Integer( 23 ));
          case 14: return new ID(getMessage(), new Integer( 9 ));
          case 15: return new ID(getMessage(), new Integer( 99 ));
          case 16: return new CN(getMessage());
          case 17: return new ID(getMessage(), new Integer( 18 ));
          case 18: return new NM(getMessage());
          case 19: return new ID(getMessage(), new Integer( 64 ));
          case 20: return new ID(getMessage(), new Integer( 32 ));
          case 21: return new ID(getMessage(), new Integer( 45 ));
          case 22: return new ID(getMessage(), new Integer( 46 ));
          case 23: return new ID(getMessage(), new Integer( 44 ));
          case 24: return new DT(getMessage());
          case 25: return new NM(getMessage());
          case 26: return new NM(getMessage());
          case 27: return new ID(getMessage(), new Integer( 73 ));
          case 28: return new ID(getMessage(), new Integer( 110 ));
          case 29: return new DT(getMessage());
          case 30: return new ST(getMessage());
          case 31: return new NM(getMessage());
          case 32: return new NM(getMessage());
          case 33: return new ID(getMessage(), new Integer( 111 ));
          case 34: return new DT(getMessage());
          case 35: return new ID(getMessage(), new Integer( 112 ));
          case 36: return new ID(getMessage(), new Integer( 113 ));
          case 37: return new ID(getMessage(), new Integer( 114 ));
          case 38: return new ID(getMessage(), new Integer( 115 ));
          case 39: return new ID(getMessage(), new Integer( 116 ));
          case 40: return new ID(getMessage(), new Integer( 117 ));
          case 41: return new ID(getMessage(), new Integer( 79 ));
          case 42: return new ID(getMessage(), new Integer( 79 ));
          case 43: return new TS(getMessage());
          case 44: return new TS(getMessage());
          case 45: return new NM(getMessage());
          case 46: return new NM(getMessage());
          case 47: return new NM(getMessage());
          case 48: return new NM(getMessage());
          default: return null;
       }
   }


}

