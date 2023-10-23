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
 *<p>Represents an HL7 PID message segment (PATIENT IDENTIFICATION). 
 * This segment has the following fields:</p>
 * <ul>
     * <li>PID-1: SET ID - PATIENT ID (SI) <b>optional </b>
     * <li>PID-2: PATIENT ID EXTERNAL (EXTERNAL ID) (CK) <b>optional </b>
     * <li>PID-3: PATIENT ID INTERNAL (INTERNAL ID) (CK) <b> </b>
     * <li>PID-4: ALTERNATE PATIENT ID (ST) <b>optional </b>
     * <li>PID-5: PATIENT NAME (PN) <b> </b>
     * <li>PID-6: MOTHER'S MAIDEN NAME (ST) <b>optional </b>
     * <li>PID-7: DATE OF BIRTH (DT) <b>optional </b>
     * <li>PID-8: SEX (ID) <b>optional </b>
     * <li>PID-9: PATIENT ALIAS (PN) <b>optional repeating</b>
     * <li>PID-10: ETHNIC GROUP (ID) <b>optional </b>
     * <li>PID-11: PATIENT ADDRESS (AD) <b>optional </b>
     * <li>PID-12: COUNTY CODE (ID) <b>optional </b>
     * <li>PID-13: PHONE NUMBER - HOME (TN) <b>optional repeating</b>
     * <li>PID-14: PHONE NUMBER - BUSINESS (TN) <b>optional repeating</b>
     * <li>PID-15: LANGUAGE - PATIENT (ST) <b>optional </b>
     * <li>PID-16: MARITAL STATUS (ID) <b>optional </b>
     * <li>PID-17: RELIGION (ID) <b>optional </b>
     * <li>PID-18: PATIENT ACCOUNT NUMBER (CK) <b>optional </b>
     * <li>PID-19: SSN NUMBER - PATIENT (ST) <b>optional </b>
     * <li>PID-20: DRIVER'S LIC NUM - PATIENT (CM) <b>optional </b>
 * </ul>
 */
@SuppressWarnings("unused")
public class PID extends AbstractSegment {

    /** 
     * Creates a new PID segment
     */
    public PID(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(SI.class, false, 1, 4, new Object[]{ getMessage() }, "SET ID - PATIENT ID");
                                  this.add(CK.class, false, 1, 16, new Object[]{ getMessage() }, "PATIENT ID EXTERNAL (EXTERNAL ID)");
                                  this.add(CK.class, true, 1, 16, new Object[]{ getMessage() }, "PATIENT ID INTERNAL (INTERNAL ID)");
                                  this.add(ST.class, false, 1, 12, new Object[]{ getMessage() }, "ALTERNATE PATIENT ID");
                                  this.add(PN.class, true, 1, 48, new Object[]{ getMessage() }, "PATIENT NAME");
                                  this.add(ST.class, false, 1, 30, new Object[]{ getMessage() }, "MOTHER'S MAIDEN NAME");
                                  this.add(DT.class, false, 1, 8, new Object[]{ getMessage() }, "DATE OF BIRTH");
                                              this.add(ID.class, false, 1, 1, new Object[]{ getMessage(), new Integer(1) }, "SEX");
                                  this.add(PN.class, false, 0, 48, new Object[]{ getMessage() }, "PATIENT ALIAS");
                                              this.add(ID.class, false, 1, 1, new Object[]{ getMessage(), new Integer(5) }, "ETHNIC GROUP");
                                  this.add(AD.class, false, 1, 106, new Object[]{ getMessage() }, "PATIENT ADDRESS");
                                              this.add(ID.class, false, 1, 4, new Object[]{ getMessage(), new Integer(0) }, "COUNTY CODE");
                                  this.add(TN.class, false, 3, 40, new Object[]{ getMessage() }, "PHONE NUMBER - HOME");
                                  this.add(TN.class, false, 3, 40, new Object[]{ getMessage() }, "PHONE NUMBER - BUSINESS");
                                  this.add(ST.class, false, 1, 25, new Object[]{ getMessage() }, "LANGUAGE - PATIENT");
                                              this.add(ID.class, false, 1, 1, new Object[]{ getMessage(), new Integer(2) }, "MARITAL STATUS");
                                              this.add(ID.class, false, 1, 3, new Object[]{ getMessage(), new Integer(6) }, "RELIGION");
                                  this.add(CK.class, false, 1, 20, new Object[]{ getMessage() }, "PATIENT ACCOUNT NUMBER");
                                  this.add(ST.class, false, 1, 16, new Object[]{ getMessage() }, "SSN NUMBER - PATIENT");
                                  this.add(CM.class, false, 1, 25, new Object[]{ getMessage() }, "DRIVER'S LIC NUM - PATIENT");
       } catch(HL7Exception e) {
          log.error("Unexpected error creating PID - this is probably a bug in the source code generator.", e);
       }
    }



    /**
     * Returns
     * PID-1: "SET ID - PATIENT ID" - creates it if necessary
     */
    public SI getSETIDPATIENTID() { 
		SI retVal = this.getTypedField(1, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PID-1: "SET ID - PATIENT ID" - creates it if necessary
     */
    public SI getPid1_SETIDPATIENTID() { 
		SI retVal = this.getTypedField(1, 0);
		return retVal;
    }



    /**
     * Returns
     * PID-2: "PATIENT ID EXTERNAL (EXTERNAL ID)" - creates it if necessary
     */
    public CK getPATIENTIDEXTERNALEXTERNALID() { 
		CK retVal = this.getTypedField(2, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PID-2: "PATIENT ID EXTERNAL (EXTERNAL ID)" - creates it if necessary
     */
    public CK getPid2_PATIENTIDEXTERNALEXTERNALID() { 
		CK retVal = this.getTypedField(2, 0);
		return retVal;
    }



    /**
     * Returns
     * PID-3: "PATIENT ID INTERNAL (INTERNAL ID)" - creates it if necessary
     */
    public CK getPATIENTIDINTERNALINTERNALID() { 
		CK retVal = this.getTypedField(3, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PID-3: "PATIENT ID INTERNAL (INTERNAL ID)" - creates it if necessary
     */
    public CK getPid3_PATIENTIDINTERNALINTERNALID() { 
		CK retVal = this.getTypedField(3, 0);
		return retVal;
    }



    /**
     * Returns
     * PID-4: "ALTERNATE PATIENT ID" - creates it if necessary
     */
    public ST getALTERNATEPATIENTID() { 
		ST retVal = this.getTypedField(4, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PID-4: "ALTERNATE PATIENT ID" - creates it if necessary
     */
    public ST getPid4_ALTERNATEPATIENTID() { 
		ST retVal = this.getTypedField(4, 0);
		return retVal;
    }



    /**
     * Returns
     * PID-5: "PATIENT NAME" - creates it if necessary
     */
    public PN getPATIENTNAME() { 
		PN retVal = this.getTypedField(5, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PID-5: "PATIENT NAME" - creates it if necessary
     */
    public PN getPid5_PATIENTNAME() { 
		PN retVal = this.getTypedField(5, 0);
		return retVal;
    }



    /**
     * Returns
     * PID-6: "MOTHER'S MAIDEN NAME" - creates it if necessary
     */
    public ST getMOTHERSMAIDENNAME() { 
		ST retVal = this.getTypedField(6, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PID-6: "MOTHER'S MAIDEN NAME" - creates it if necessary
     */
    public ST getPid6_MOTHERSMAIDENNAME() { 
		ST retVal = this.getTypedField(6, 0);
		return retVal;
    }



    /**
     * Returns
     * PID-7: "DATE OF BIRTH" - creates it if necessary
     */
    public DT getDATEOFBIRTH() { 
		DT retVal = this.getTypedField(7, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PID-7: "DATE OF BIRTH" - creates it if necessary
     */
    public DT getPid7_DATEOFBIRTH() { 
		DT retVal = this.getTypedField(7, 0);
		return retVal;
    }



    /**
     * Returns
     * PID-8: "SEX" - creates it if necessary
     */
    public ID getSEX() { 
		ID retVal = this.getTypedField(8, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PID-8: "SEX" - creates it if necessary
     */
    public ID getPid8_SEX() { 
		ID retVal = this.getTypedField(8, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of PATIENT ALIAS (PID-9).
     */
    public PN[] getPATIENTALIAS() {
    	PN[] retVal = this.getTypedField(9, new PN[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of PATIENT ALIAS (PID-9).
     */
    public PN[] getPid9_PATIENTALIAS() {
    	PN[] retVal = this.getTypedField(9, new PN[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of PATIENT ALIAS (PID-9).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getPATIENTALIASReps() {
    	return this.getReps(9);
    }


    /**
     * Returns a specific repetition of
     * PID-9: "PATIENT ALIAS" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public PN getPATIENTALIAS(int rep) { 
		PN retVal = this.getTypedField(9, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * PID-9: "PATIENT ALIAS" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public PN getPid9_PATIENTALIAS(int rep) { 
		PN retVal = this.getTypedField(9, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of PATIENT ALIAS (PID-9).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getPid9_PATIENTALIASReps() {
    	return this.getReps(9);
    }


    /**
     * Inserts a repetition of
     * PID-9: "PATIENT ALIAS" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public PN insertPATIENTALIAS(int rep) throws HL7Exception { 
        return (PN) super.insertRepetition(9, rep);
    }


    /**
     * Inserts a repetition of
     * PID-9: "PATIENT ALIAS" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public PN insertPid9_PATIENTALIAS(int rep) throws HL7Exception { 
        return (PN) super.insertRepetition(9, rep);
    }


    /**
     * Removes a repetition of
     * PID-9: "PATIENT ALIAS" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public PN removePATIENTALIAS(int rep) throws HL7Exception { 
        return (PN) super.removeRepetition(9, rep);
    }


    /**
     * Removes a repetition of
     * PID-9: "PATIENT ALIAS" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public PN removePid9_PATIENTALIAS(int rep) throws HL7Exception { 
        return (PN) super.removeRepetition(9, rep);
    }




    /**
     * Returns
     * PID-10: "ETHNIC GROUP" - creates it if necessary
     */
    public ID getETHNICGROUP() { 
		ID retVal = this.getTypedField(10, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PID-10: "ETHNIC GROUP" - creates it if necessary
     */
    public ID getPid10_ETHNICGROUP() { 
		ID retVal = this.getTypedField(10, 0);
		return retVal;
    }



    /**
     * Returns
     * PID-11: "PATIENT ADDRESS" - creates it if necessary
     */
    public AD getPATIENTADDRESS() { 
		AD retVal = this.getTypedField(11, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PID-11: "PATIENT ADDRESS" - creates it if necessary
     */
    public AD getPid11_PATIENTADDRESS() { 
		AD retVal = this.getTypedField(11, 0);
		return retVal;
    }



    /**
     * Returns
     * PID-12: "COUNTY CODE" - creates it if necessary
     */
    public ID getCOUNTYCODE() { 
		ID retVal = this.getTypedField(12, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PID-12: "COUNTY CODE" - creates it if necessary
     */
    public ID getPid12_COUNTYCODE() { 
		ID retVal = this.getTypedField(12, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of PHONE NUMBER - HOME (PID-13).
     */
    public TN[] getPHONENUMBERHOME() {
    	TN[] retVal = this.getTypedField(13, new TN[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of PHONE NUMBER - HOME (PID-13).
     */
    public TN[] getPid13_PHONENUMBERHOME() {
    	TN[] retVal = this.getTypedField(13, new TN[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of PHONE NUMBER - HOME (PID-13).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getPHONENUMBERHOMEReps() {
    	return this.getReps(13);
    }


    /**
     * Returns a specific repetition of
     * PID-13: "PHONE NUMBER - HOME" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public TN getPHONENUMBERHOME(int rep) { 
		TN retVal = this.getTypedField(13, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * PID-13: "PHONE NUMBER - HOME" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public TN getPid13_PHONENUMBERHOME(int rep) { 
		TN retVal = this.getTypedField(13, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of PHONE NUMBER - HOME (PID-13).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getPid13_PHONENUMBERHOMEReps() {
    	return this.getReps(13);
    }


    /**
     * Inserts a repetition of
     * PID-13: "PHONE NUMBER - HOME" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public TN insertPHONENUMBERHOME(int rep) throws HL7Exception { 
        return (TN) super.insertRepetition(13, rep);
    }


    /**
     * Inserts a repetition of
     * PID-13: "PHONE NUMBER - HOME" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public TN insertPid13_PHONENUMBERHOME(int rep) throws HL7Exception { 
        return (TN) super.insertRepetition(13, rep);
    }


    /**
     * Removes a repetition of
     * PID-13: "PHONE NUMBER - HOME" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public TN removePHONENUMBERHOME(int rep) throws HL7Exception { 
        return (TN) super.removeRepetition(13, rep);
    }


    /**
     * Removes a repetition of
     * PID-13: "PHONE NUMBER - HOME" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public TN removePid13_PHONENUMBERHOME(int rep) throws HL7Exception { 
        return (TN) super.removeRepetition(13, rep);
    }



    /**
     * Returns all repetitions of PHONE NUMBER - BUSINESS (PID-14).
     */
    public TN[] getPHONENUMBERBUSINESS() {
    	TN[] retVal = this.getTypedField(14, new TN[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of PHONE NUMBER - BUSINESS (PID-14).
     */
    public TN[] getPid14_PHONENUMBERBUSINESS() {
    	TN[] retVal = this.getTypedField(14, new TN[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of PHONE NUMBER - BUSINESS (PID-14).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getPHONENUMBERBUSINESSReps() {
    	return this.getReps(14);
    }


    /**
     * Returns a specific repetition of
     * PID-14: "PHONE NUMBER - BUSINESS" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public TN getPHONENUMBERBUSINESS(int rep) { 
		TN retVal = this.getTypedField(14, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * PID-14: "PHONE NUMBER - BUSINESS" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public TN getPid14_PHONENUMBERBUSINESS(int rep) { 
		TN retVal = this.getTypedField(14, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of PHONE NUMBER - BUSINESS (PID-14).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getPid14_PHONENUMBERBUSINESSReps() {
    	return this.getReps(14);
    }


    /**
     * Inserts a repetition of
     * PID-14: "PHONE NUMBER - BUSINESS" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public TN insertPHONENUMBERBUSINESS(int rep) throws HL7Exception { 
        return (TN) super.insertRepetition(14, rep);
    }


    /**
     * Inserts a repetition of
     * PID-14: "PHONE NUMBER - BUSINESS" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public TN insertPid14_PHONENUMBERBUSINESS(int rep) throws HL7Exception { 
        return (TN) super.insertRepetition(14, rep);
    }


    /**
     * Removes a repetition of
     * PID-14: "PHONE NUMBER - BUSINESS" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public TN removePHONENUMBERBUSINESS(int rep) throws HL7Exception { 
        return (TN) super.removeRepetition(14, rep);
    }


    /**
     * Removes a repetition of
     * PID-14: "PHONE NUMBER - BUSINESS" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public TN removePid14_PHONENUMBERBUSINESS(int rep) throws HL7Exception { 
        return (TN) super.removeRepetition(14, rep);
    }




    /**
     * Returns
     * PID-15: "LANGUAGE - PATIENT" - creates it if necessary
     */
    public ST getLANGUAGEPATIENT() { 
		ST retVal = this.getTypedField(15, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PID-15: "LANGUAGE - PATIENT" - creates it if necessary
     */
    public ST getPid15_LANGUAGEPATIENT() { 
		ST retVal = this.getTypedField(15, 0);
		return retVal;
    }



    /**
     * Returns
     * PID-16: "MARITAL STATUS" - creates it if necessary
     */
    public ID getMARITALSTATUS() { 
		ID retVal = this.getTypedField(16, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PID-16: "MARITAL STATUS" - creates it if necessary
     */
    public ID getPid16_MARITALSTATUS() { 
		ID retVal = this.getTypedField(16, 0);
		return retVal;
    }



    /**
     * Returns
     * PID-17: "RELIGION" - creates it if necessary
     */
    public ID getRELIGION() { 
		ID retVal = this.getTypedField(17, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PID-17: "RELIGION" - creates it if necessary
     */
    public ID getPid17_RELIGION() { 
		ID retVal = this.getTypedField(17, 0);
		return retVal;
    }



    /**
     * Returns
     * PID-18: "PATIENT ACCOUNT NUMBER" - creates it if necessary
     */
    public CK getPATIENTACCOUNTNUMBER() { 
		CK retVal = this.getTypedField(18, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PID-18: "PATIENT ACCOUNT NUMBER" - creates it if necessary
     */
    public CK getPid18_PATIENTACCOUNTNUMBER() { 
		CK retVal = this.getTypedField(18, 0);
		return retVal;
    }



    /**
     * Returns
     * PID-19: "SSN NUMBER - PATIENT" - creates it if necessary
     */
    public ST getSSNNUMBERPATIENT() { 
		ST retVal = this.getTypedField(19, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PID-19: "SSN NUMBER - PATIENT" - creates it if necessary
     */
    public ST getPid19_SSNNUMBERPATIENT() { 
		ST retVal = this.getTypedField(19, 0);
		return retVal;
    }



    /**
     * Returns
     * PID-20: "DRIVER'S LIC NUM - PATIENT" - creates it if necessary
     */
    public CM getDRIVERSLICNUMPATIENT() { 
		CM retVal = this.getTypedField(20, 0);
		return retVal;
    }
    
    /**
     * Returns
     * PID-20: "DRIVER'S LIC NUM - PATIENT" - creates it if necessary
     */
    public CM getPid20_DRIVERSLICNUMPATIENT() { 
		CM retVal = this.getTypedField(20, 0);
		return retVal;
    }





    /** {@inheritDoc} */   
    protected Type createNewTypeWithoutReflection(int field) {
       switch (field) {
          case 0: return new SI(getMessage());
          case 1: return new CK(getMessage());
          case 2: return new CK(getMessage());
          case 3: return new ST(getMessage());
          case 4: return new PN(getMessage());
          case 5: return new ST(getMessage());
          case 6: return new DT(getMessage());
          case 7: return new ID(getMessage(), new Integer( 1 ));
          case 8: return new PN(getMessage());
          case 9: return new ID(getMessage(), new Integer( 5 ));
          case 10: return new AD(getMessage());
          case 11: return new ID(getMessage(), new Integer( 0 ));
          case 12: return new TN(getMessage());
          case 13: return new TN(getMessage());
          case 14: return new ST(getMessage());
          case 15: return new ID(getMessage(), new Integer( 2 ));
          case 16: return new ID(getMessage(), new Integer( 6 ));
          case 17: return new CK(getMessage());
          case 18: return new ST(getMessage());
          case 19: return new CM(getMessage());
          default: return null;
       }
   }


}

