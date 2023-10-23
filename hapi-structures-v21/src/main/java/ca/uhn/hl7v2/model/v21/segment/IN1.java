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
 *<p>Represents an HL7 IN1 message segment (INSURANCE). 
 * This segment has the following fields:</p>
 * <ul>
     * <li>IN1-1: SET ID - INSURANCE (SI) <b> </b>
     * <li>IN1-2: INSURANCE PLAN ID (ID) <b> </b>
     * <li>IN1-3: INSURANCE COMPANY ID (ST) <b> </b>
     * <li>IN1-4: INSURANCE COMPANY NAME (ST) <b>optional </b>
     * <li>IN1-5: INSURANCE COMPANY ADDRESS (AD) <b>optional </b>
     * <li>IN1-6: INSURANCE CO. CONTACT PERS (PN) <b>optional </b>
     * <li>IN1-7: INSURANCE CO PHONE NUMBER (TN) <b>optional </b>
     * <li>IN1-8: GROUP NUMBER (ST) <b>optional </b>
     * <li>IN1-9: GROUP NAME (ST) <b>optional </b>
     * <li>IN1-10: INSURED'S GROUP EMP. ID (ST) <b>optional </b>
     * <li>IN1-11: INSURED'S GROUP EMP. NAME (ST) <b>optional </b>
     * <li>IN1-12: PLAN EFFECTIVE DATE (DT) <b>optional </b>
     * <li>IN1-13: PLAN EXPIRATION DATE (DT) <b>optional </b>
     * <li>IN1-14: AUTHORIZATION INFORMATION (ST) <b>optional </b>
     * <li>IN1-15: PLAN TYPE (ID) <b>optional </b>
     * <li>IN1-16: NAME OF INSURED (PN) <b>optional </b>
     * <li>IN1-17: INSURED'S RELATIONSHIP TO PATIENT (ID) <b>optional </b>
     * <li>IN1-18: INSURED'S DATE OF BIRTH (DT) <b>optional </b>
     * <li>IN1-19: INSURED'S ADDRESS (AD) <b>optional </b>
     * <li>IN1-20: ASSIGNMENT OF BENEFITS (ID) <b>optional </b>
     * <li>IN1-21: COORDINATION OF BENEFITS (ID) <b>optional </b>
     * <li>IN1-22: COORD OF BEN. PRIORITY (ST) <b>optional </b>
     * <li>IN1-23: NOTICE OF ADMISSION CODE (ID) <b>optional </b>
     * <li>IN1-24: NOTICE OF ADMISSION DATE (DT) <b>optional </b>
     * <li>IN1-25: RPT OF ELIGIBILITY CODE (ID) <b>optional </b>
     * <li>IN1-26: RPT OF ELIGIBILITY DATE (DT) <b>optional </b>
     * <li>IN1-27: RELEASE INFORMATION CODE (ID) <b>optional </b>
     * <li>IN1-28: PRE-ADMIT CERT. (PAC) (ST) <b>optional </b>
     * <li>IN1-29: VERIFICATION DATE (DT) <b>optional </b>
     * <li>IN1-30: VERIFICATION BY (CM) <b>optional </b>
     * <li>IN1-31: TYPE OF AGREEMENT CODE (ID) <b>optional </b>
     * <li>IN1-32: BILLING STATUS (ID) <b>optional </b>
     * <li>IN1-33: LIFETIME RESERVE DAYS (NM) <b>optional </b>
     * <li>IN1-34: DELAY BEFORE L. R. DAY (NM) <b>optional </b>
     * <li>IN1-35: COMPANY PLAN CODE (ST) <b>optional </b>
     * <li>IN1-36: POLICY NUMBER (ST) <b>optional </b>
     * <li>IN1-37: POLICY DEDUCTIBLE (NM) <b>optional </b>
     * <li>IN1-38: POLICY LIMIT - AMOUNT (NM) <b>optional </b>
     * <li>IN1-39: POLICY LIMIT - DAYS (NM) <b>optional </b>
     * <li>IN1-40: ROOM RATE - SEMI-PRIVATE (NM) <b>optional </b>
     * <li>IN1-41: ROOM RATE - PRIVATE (NM) <b>optional </b>
     * <li>IN1-42: INSURED'S EMPLOYMENT STATUS (ID) <b>optional </b>
     * <li>IN1-43: INSURED'S SEX (ID) <b>optional </b>
     * <li>IN1-44: INSURED'S EMPLOYER ADDRESS (AD) <b>optional </b>
 * </ul>
 */
@SuppressWarnings("unused")
public class IN1 extends AbstractSegment {

    /** 
     * Creates a new IN1 segment
     */
    public IN1(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(SI.class, true, 1, 4, new Object[]{ getMessage() }, "SET ID - INSURANCE");
                                              this.add(ID.class, true, 1, 8, new Object[]{ getMessage(), new Integer(72) }, "INSURANCE PLAN ID");
                                  this.add(ST.class, true, 1, 6, new Object[]{ getMessage() }, "INSURANCE COMPANY ID");
                                  this.add(ST.class, false, 1, 45, new Object[]{ getMessage() }, "INSURANCE COMPANY NAME");
                                  this.add(AD.class, false, 1, 106, new Object[]{ getMessage() }, "INSURANCE COMPANY ADDRESS");
                                  this.add(PN.class, false, 1, 48, new Object[]{ getMessage() }, "INSURANCE CO. CONTACT PERS");
                                  this.add(TN.class, false, 1, 40, new Object[]{ getMessage() }, "INSURANCE CO PHONE NUMBER");
                                  this.add(ST.class, false, 1, 12, new Object[]{ getMessage() }, "GROUP NUMBER");
                                  this.add(ST.class, false, 1, 35, new Object[]{ getMessage() }, "GROUP NAME");
                                  this.add(ST.class, false, 1, 12, new Object[]{ getMessage() }, "INSURED'S GROUP EMP. ID");
                                  this.add(ST.class, false, 1, 45, new Object[]{ getMessage() }, "INSURED'S GROUP EMP. NAME");
                                  this.add(DT.class, false, 1, 8, new Object[]{ getMessage() }, "PLAN EFFECTIVE DATE");
                                  this.add(DT.class, false, 1, 8, new Object[]{ getMessage() }, "PLAN EXPIRATION DATE");
                                  this.add(ST.class, false, 1, 55, new Object[]{ getMessage() }, "AUTHORIZATION INFORMATION");
                                              this.add(ID.class, false, 1, 2, new Object[]{ getMessage(), new Integer(86) }, "PLAN TYPE");
                                  this.add(PN.class, false, 1, 48, new Object[]{ getMessage() }, "NAME OF INSURED");
                                              this.add(ID.class, false, 1, 2, new Object[]{ getMessage(), new Integer(63) }, "INSURED'S RELATIONSHIP TO PATIENT");
                                  this.add(DT.class, false, 1, 8, new Object[]{ getMessage() }, "INSURED'S DATE OF BIRTH");
                                  this.add(AD.class, false, 1, 106, new Object[]{ getMessage() }, "INSURED'S ADDRESS");
                                              this.add(ID.class, false, 1, 2, new Object[]{ getMessage(), new Integer(0) }, "ASSIGNMENT OF BENEFITS");
                                              this.add(ID.class, false, 1, 2, new Object[]{ getMessage(), new Integer(0) }, "COORDINATION OF BENEFITS");
                                  this.add(ST.class, false, 1, 2, new Object[]{ getMessage() }, "COORD OF BEN. PRIORITY");
                                              this.add(ID.class, false, 1, 2, new Object[]{ getMessage(), new Integer(81) }, "NOTICE OF ADMISSION CODE");
                                  this.add(DT.class, false, 1, 8, new Object[]{ getMessage() }, "NOTICE OF ADMISSION DATE");
                                              this.add(ID.class, false, 1, 2, new Object[]{ getMessage(), new Integer(94) }, "RPT OF ELIGIBILITY CODE");
                                  this.add(DT.class, false, 1, 8, new Object[]{ getMessage() }, "RPT OF ELIGIBILITY DATE");
                                              this.add(ID.class, false, 1, 2, new Object[]{ getMessage(), new Integer(93) }, "RELEASE INFORMATION CODE");
                                  this.add(ST.class, false, 1, 15, new Object[]{ getMessage() }, "PRE-ADMIT CERT. (PAC)");
                                  this.add(DT.class, false, 1, 8, new Object[]{ getMessage() }, "VERIFICATION DATE");
                                  this.add(CM.class, false, 1, 60, new Object[]{ getMessage() }, "VERIFICATION BY");
                                              this.add(ID.class, false, 1, 2, new Object[]{ getMessage(), new Integer(98) }, "TYPE OF AGREEMENT CODE");
                                              this.add(ID.class, false, 1, 2, new Object[]{ getMessage(), new Integer(22) }, "BILLING STATUS");
                                  this.add(NM.class, false, 1, 4, new Object[]{ getMessage() }, "LIFETIME RESERVE DAYS");
                                  this.add(NM.class, false, 1, 4, new Object[]{ getMessage() }, "DELAY BEFORE L. R. DAY");
                                  this.add(ST.class, false, 1, 8, new Object[]{ getMessage() }, "COMPANY PLAN CODE");
                                  this.add(ST.class, false, 1, 15, new Object[]{ getMessage() }, "POLICY NUMBER");
                                  this.add(NM.class, false, 1, 12, new Object[]{ getMessage() }, "POLICY DEDUCTIBLE");
                                  this.add(NM.class, false, 1, 12, new Object[]{ getMessage() }, "POLICY LIMIT - AMOUNT");
                                  this.add(NM.class, false, 1, 4, new Object[]{ getMessage() }, "POLICY LIMIT - DAYS");
                                  this.add(NM.class, false, 1, 12, new Object[]{ getMessage() }, "ROOM RATE - SEMI-PRIVATE");
                                  this.add(NM.class, false, 1, 12, new Object[]{ getMessage() }, "ROOM RATE - PRIVATE");
                                              this.add(ID.class, false, 1, 1, new Object[]{ getMessage(), new Integer(66) }, "INSURED'S EMPLOYMENT STATUS");
                                              this.add(ID.class, false, 1, 1, new Object[]{ getMessage(), new Integer(1) }, "INSURED'S SEX");
                                  this.add(AD.class, false, 1, 106, new Object[]{ getMessage() }, "INSURED'S EMPLOYER ADDRESS");
       } catch(HL7Exception e) {
          log.error("Unexpected error creating IN1 - this is probably a bug in the source code generator.", e);
       }
    }



    /**
     * Returns
     * IN1-1: "SET ID - INSURANCE" - creates it if necessary
     */
    public SI getSETIDINSURANCE() { 
		SI retVal = this.getTypedField(1, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN1-1: "SET ID - INSURANCE" - creates it if necessary
     */
    public SI getIn11_SETIDINSURANCE() { 
		SI retVal = this.getTypedField(1, 0);
		return retVal;
    }



    /**
     * Returns
     * IN1-2: "INSURANCE PLAN ID" - creates it if necessary
     */
    public ID getINSURANCEPLANID() { 
		ID retVal = this.getTypedField(2, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN1-2: "INSURANCE PLAN ID" - creates it if necessary
     */
    public ID getIn12_INSURANCEPLANID() { 
		ID retVal = this.getTypedField(2, 0);
		return retVal;
    }



    /**
     * Returns
     * IN1-3: "INSURANCE COMPANY ID" - creates it if necessary
     */
    public ST getINSURANCECOMPANYID() { 
		ST retVal = this.getTypedField(3, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN1-3: "INSURANCE COMPANY ID" - creates it if necessary
     */
    public ST getIn13_INSURANCECOMPANYID() { 
		ST retVal = this.getTypedField(3, 0);
		return retVal;
    }



    /**
     * Returns
     * IN1-4: "INSURANCE COMPANY NAME" - creates it if necessary
     */
    public ST getINSURANCECOMPANYNAME() { 
		ST retVal = this.getTypedField(4, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN1-4: "INSURANCE COMPANY NAME" - creates it if necessary
     */
    public ST getIn14_INSURANCECOMPANYNAME() { 
		ST retVal = this.getTypedField(4, 0);
		return retVal;
    }



    /**
     * Returns
     * IN1-5: "INSURANCE COMPANY ADDRESS" - creates it if necessary
     */
    public AD getINSURANCECOMPANYADDRESS() { 
		AD retVal = this.getTypedField(5, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN1-5: "INSURANCE COMPANY ADDRESS" - creates it if necessary
     */
    public AD getIn15_INSURANCECOMPANYADDRESS() { 
		AD retVal = this.getTypedField(5, 0);
		return retVal;
    }



    /**
     * Returns
     * IN1-6: "INSURANCE CO. CONTACT PERS" - creates it if necessary
     */
    public PN getINSURANCECOCONTACTPERS() { 
		PN retVal = this.getTypedField(6, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN1-6: "INSURANCE CO. CONTACT PERS" - creates it if necessary
     */
    public PN getIn16_INSURANCECOCONTACTPERS() { 
		PN retVal = this.getTypedField(6, 0);
		return retVal;
    }



    /**
     * Returns
     * IN1-7: "INSURANCE CO PHONE NUMBER" - creates it if necessary
     */
    public TN getINSURANCECOPHONENUMBER() { 
		TN retVal = this.getTypedField(7, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN1-7: "INSURANCE CO PHONE NUMBER" - creates it if necessary
     */
    public TN getIn17_INSURANCECOPHONENUMBER() { 
		TN retVal = this.getTypedField(7, 0);
		return retVal;
    }



    /**
     * Returns
     * IN1-8: "GROUP NUMBER" - creates it if necessary
     */
    public ST getGROUPNUMBER() { 
		ST retVal = this.getTypedField(8, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN1-8: "GROUP NUMBER" - creates it if necessary
     */
    public ST getIn18_GROUPNUMBER() { 
		ST retVal = this.getTypedField(8, 0);
		return retVal;
    }



    /**
     * Returns
     * IN1-9: "GROUP NAME" - creates it if necessary
     */
    public ST getGROUPNAME() { 
		ST retVal = this.getTypedField(9, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN1-9: "GROUP NAME" - creates it if necessary
     */
    public ST getIn19_GROUPNAME() { 
		ST retVal = this.getTypedField(9, 0);
		return retVal;
    }



    /**
     * Returns
     * IN1-10: "INSURED'S GROUP EMP. ID" - creates it if necessary
     */
    public ST getINSUREDSGROUPEMPID() { 
		ST retVal = this.getTypedField(10, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN1-10: "INSURED'S GROUP EMP. ID" - creates it if necessary
     */
    public ST getIn110_INSUREDSGROUPEMPID() { 
		ST retVal = this.getTypedField(10, 0);
		return retVal;
    }



    /**
     * Returns
     * IN1-11: "INSURED'S GROUP EMP. NAME" - creates it if necessary
     */
    public ST getINSUREDSGROUPEMPNAME() { 
		ST retVal = this.getTypedField(11, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN1-11: "INSURED'S GROUP EMP. NAME" - creates it if necessary
     */
    public ST getIn111_INSUREDSGROUPEMPNAME() { 
		ST retVal = this.getTypedField(11, 0);
		return retVal;
    }



    /**
     * Returns
     * IN1-12: "PLAN EFFECTIVE DATE" - creates it if necessary
     */
    public DT getPLANEFFECTIVEDATE() { 
		DT retVal = this.getTypedField(12, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN1-12: "PLAN EFFECTIVE DATE" - creates it if necessary
     */
    public DT getIn112_PLANEFFECTIVEDATE() { 
		DT retVal = this.getTypedField(12, 0);
		return retVal;
    }



    /**
     * Returns
     * IN1-13: "PLAN EXPIRATION DATE" - creates it if necessary
     */
    public DT getPLANEXPIRATIONDATE() { 
		DT retVal = this.getTypedField(13, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN1-13: "PLAN EXPIRATION DATE" - creates it if necessary
     */
    public DT getIn113_PLANEXPIRATIONDATE() { 
		DT retVal = this.getTypedField(13, 0);
		return retVal;
    }



    /**
     * Returns
     * IN1-14: "AUTHORIZATION INFORMATION" - creates it if necessary
     */
    public ST getAUTHORIZATIONINFORMATION() { 
		ST retVal = this.getTypedField(14, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN1-14: "AUTHORIZATION INFORMATION" - creates it if necessary
     */
    public ST getIn114_AUTHORIZATIONINFORMATION() { 
		ST retVal = this.getTypedField(14, 0);
		return retVal;
    }



    /**
     * Returns
     * IN1-15: "PLAN TYPE" - creates it if necessary
     */
    public ID getPLANTYPE() { 
		ID retVal = this.getTypedField(15, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN1-15: "PLAN TYPE" - creates it if necessary
     */
    public ID getIn115_PLANTYPE() { 
		ID retVal = this.getTypedField(15, 0);
		return retVal;
    }



    /**
     * Returns
     * IN1-16: "NAME OF INSURED" - creates it if necessary
     */
    public PN getNAMEOFINSURED() { 
		PN retVal = this.getTypedField(16, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN1-16: "NAME OF INSURED" - creates it if necessary
     */
    public PN getIn116_NAMEOFINSURED() { 
		PN retVal = this.getTypedField(16, 0);
		return retVal;
    }



    /**
     * Returns
     * IN1-17: "INSURED'S RELATIONSHIP TO PATIENT" - creates it if necessary
     */
    public ID getINSUREDSRELATIONSHIPTOPATIENT() { 
		ID retVal = this.getTypedField(17, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN1-17: "INSURED'S RELATIONSHIP TO PATIENT" - creates it if necessary
     */
    public ID getIn117_INSUREDSRELATIONSHIPTOPATIENT() { 
		ID retVal = this.getTypedField(17, 0);
		return retVal;
    }



    /**
     * Returns
     * IN1-18: "INSURED'S DATE OF BIRTH" - creates it if necessary
     */
    public DT getINSUREDSDATEOFBIRTH() { 
		DT retVal = this.getTypedField(18, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN1-18: "INSURED'S DATE OF BIRTH" - creates it if necessary
     */
    public DT getIn118_INSUREDSDATEOFBIRTH() { 
		DT retVal = this.getTypedField(18, 0);
		return retVal;
    }



    /**
     * Returns
     * IN1-19: "INSURED'S ADDRESS" - creates it if necessary
     */
    public AD getINSUREDSADDRESS() { 
		AD retVal = this.getTypedField(19, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN1-19: "INSURED'S ADDRESS" - creates it if necessary
     */
    public AD getIn119_INSUREDSADDRESS() { 
		AD retVal = this.getTypedField(19, 0);
		return retVal;
    }



    /**
     * Returns
     * IN1-20: "ASSIGNMENT OF BENEFITS" - creates it if necessary
     */
    public ID getASSIGNMENTOFBENEFITS() { 
		ID retVal = this.getTypedField(20, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN1-20: "ASSIGNMENT OF BENEFITS" - creates it if necessary
     */
    public ID getIn120_ASSIGNMENTOFBENEFITS() { 
		ID retVal = this.getTypedField(20, 0);
		return retVal;
    }



    /**
     * Returns
     * IN1-21: "COORDINATION OF BENEFITS" - creates it if necessary
     */
    public ID getCOORDINATIONOFBENEFITS() { 
		ID retVal = this.getTypedField(21, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN1-21: "COORDINATION OF BENEFITS" - creates it if necessary
     */
    public ID getIn121_COORDINATIONOFBENEFITS() { 
		ID retVal = this.getTypedField(21, 0);
		return retVal;
    }



    /**
     * Returns
     * IN1-22: "COORD OF BEN. PRIORITY" - creates it if necessary
     */
    public ST getCOORDOFBENPRIORITY() { 
		ST retVal = this.getTypedField(22, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN1-22: "COORD OF BEN. PRIORITY" - creates it if necessary
     */
    public ST getIn122_COORDOFBENPRIORITY() { 
		ST retVal = this.getTypedField(22, 0);
		return retVal;
    }



    /**
     * Returns
     * IN1-23: "NOTICE OF ADMISSION CODE" - creates it if necessary
     */
    public ID getNOTICEOFADMISSIONCODE() { 
		ID retVal = this.getTypedField(23, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN1-23: "NOTICE OF ADMISSION CODE" - creates it if necessary
     */
    public ID getIn123_NOTICEOFADMISSIONCODE() { 
		ID retVal = this.getTypedField(23, 0);
		return retVal;
    }



    /**
     * Returns
     * IN1-24: "NOTICE OF ADMISSION DATE" - creates it if necessary
     */
    public DT getNOTICEOFADMISSIONDATE() { 
		DT retVal = this.getTypedField(24, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN1-24: "NOTICE OF ADMISSION DATE" - creates it if necessary
     */
    public DT getIn124_NOTICEOFADMISSIONDATE() { 
		DT retVal = this.getTypedField(24, 0);
		return retVal;
    }



    /**
     * Returns
     * IN1-25: "RPT OF ELIGIBILITY CODE" - creates it if necessary
     */
    public ID getRPTOFELIGIBILITYCODE() { 
		ID retVal = this.getTypedField(25, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN1-25: "RPT OF ELIGIBILITY CODE" - creates it if necessary
     */
    public ID getIn125_RPTOFELIGIBILITYCODE() { 
		ID retVal = this.getTypedField(25, 0);
		return retVal;
    }



    /**
     * Returns
     * IN1-26: "RPT OF ELIGIBILITY DATE" - creates it if necessary
     */
    public DT getRPTOFELIGIBILITYDATE() { 
		DT retVal = this.getTypedField(26, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN1-26: "RPT OF ELIGIBILITY DATE" - creates it if necessary
     */
    public DT getIn126_RPTOFELIGIBILITYDATE() { 
		DT retVal = this.getTypedField(26, 0);
		return retVal;
    }



    /**
     * Returns
     * IN1-27: "RELEASE INFORMATION CODE" - creates it if necessary
     */
    public ID getRELEASEINFORMATIONCODE() { 
		ID retVal = this.getTypedField(27, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN1-27: "RELEASE INFORMATION CODE" - creates it if necessary
     */
    public ID getIn127_RELEASEINFORMATIONCODE() { 
		ID retVal = this.getTypedField(27, 0);
		return retVal;
    }



    /**
     * Returns
     * IN1-28: "PRE-ADMIT CERT. (PAC)" - creates it if necessary
     */
    public ST getPREADMITCERT() { 
		ST retVal = this.getTypedField(28, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN1-28: "PRE-ADMIT CERT. (PAC)" - creates it if necessary
     */
    public ST getIn128_PREADMITCERT() { 
		ST retVal = this.getTypedField(28, 0);
		return retVal;
    }



    /**
     * Returns
     * IN1-29: "VERIFICATION DATE" - creates it if necessary
     */
    public DT getVERIFICATIONDATE() { 
		DT retVal = this.getTypedField(29, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN1-29: "VERIFICATION DATE" - creates it if necessary
     */
    public DT getIn129_VERIFICATIONDATE() { 
		DT retVal = this.getTypedField(29, 0);
		return retVal;
    }



    /**
     * Returns
     * IN1-30: "VERIFICATION BY" - creates it if necessary
     */
    public CM getVERIFICATIONBY() { 
		CM retVal = this.getTypedField(30, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN1-30: "VERIFICATION BY" - creates it if necessary
     */
    public CM getIn130_VERIFICATIONBY() { 
		CM retVal = this.getTypedField(30, 0);
		return retVal;
    }



    /**
     * Returns
     * IN1-31: "TYPE OF AGREEMENT CODE" - creates it if necessary
     */
    public ID getTYPEOFAGREEMENTCODE() { 
		ID retVal = this.getTypedField(31, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN1-31: "TYPE OF AGREEMENT CODE" - creates it if necessary
     */
    public ID getIn131_TYPEOFAGREEMENTCODE() { 
		ID retVal = this.getTypedField(31, 0);
		return retVal;
    }



    /**
     * Returns
     * IN1-32: "BILLING STATUS" - creates it if necessary
     */
    public ID getBILLINGSTATUS() { 
		ID retVal = this.getTypedField(32, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN1-32: "BILLING STATUS" - creates it if necessary
     */
    public ID getIn132_BILLINGSTATUS() { 
		ID retVal = this.getTypedField(32, 0);
		return retVal;
    }



    /**
     * Returns
     * IN1-33: "LIFETIME RESERVE DAYS" - creates it if necessary
     */
    public NM getLIFETIMERESERVEDAYS() { 
		NM retVal = this.getTypedField(33, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN1-33: "LIFETIME RESERVE DAYS" - creates it if necessary
     */
    public NM getIn133_LIFETIMERESERVEDAYS() { 
		NM retVal = this.getTypedField(33, 0);
		return retVal;
    }



    /**
     * Returns
     * IN1-34: "DELAY BEFORE L. R. DAY" - creates it if necessary
     */
    public NM getDELAYBEFORELRDAY() { 
		NM retVal = this.getTypedField(34, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN1-34: "DELAY BEFORE L. R. DAY" - creates it if necessary
     */
    public NM getIn134_DELAYBEFORELRDAY() { 
		NM retVal = this.getTypedField(34, 0);
		return retVal;
    }



    /**
     * Returns
     * IN1-35: "COMPANY PLAN CODE" - creates it if necessary
     */
    public ST getCOMPANYPLANCODE() { 
		ST retVal = this.getTypedField(35, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN1-35: "COMPANY PLAN CODE" - creates it if necessary
     */
    public ST getIn135_COMPANYPLANCODE() { 
		ST retVal = this.getTypedField(35, 0);
		return retVal;
    }



    /**
     * Returns
     * IN1-36: "POLICY NUMBER" - creates it if necessary
     */
    public ST getPOLICYNUMBER() { 
		ST retVal = this.getTypedField(36, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN1-36: "POLICY NUMBER" - creates it if necessary
     */
    public ST getIn136_POLICYNUMBER() { 
		ST retVal = this.getTypedField(36, 0);
		return retVal;
    }



    /**
     * Returns
     * IN1-37: "POLICY DEDUCTIBLE" - creates it if necessary
     */
    public NM getPOLICYDEDUCTIBLE() { 
		NM retVal = this.getTypedField(37, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN1-37: "POLICY DEDUCTIBLE" - creates it if necessary
     */
    public NM getIn137_POLICYDEDUCTIBLE() { 
		NM retVal = this.getTypedField(37, 0);
		return retVal;
    }



    /**
     * Returns
     * IN1-38: "POLICY LIMIT - AMOUNT" - creates it if necessary
     */
    public NM getPOLICYLIMITAMOUNT() { 
		NM retVal = this.getTypedField(38, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN1-38: "POLICY LIMIT - AMOUNT" - creates it if necessary
     */
    public NM getIn138_POLICYLIMITAMOUNT() { 
		NM retVal = this.getTypedField(38, 0);
		return retVal;
    }



    /**
     * Returns
     * IN1-39: "POLICY LIMIT - DAYS" - creates it if necessary
     */
    public NM getPOLICYLIMITDAYS() { 
		NM retVal = this.getTypedField(39, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN1-39: "POLICY LIMIT - DAYS" - creates it if necessary
     */
    public NM getIn139_POLICYLIMITDAYS() { 
		NM retVal = this.getTypedField(39, 0);
		return retVal;
    }



    /**
     * Returns
     * IN1-40: "ROOM RATE - SEMI-PRIVATE" - creates it if necessary
     */
    public NM getROOMRATESEMIPRIVATE() { 
		NM retVal = this.getTypedField(40, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN1-40: "ROOM RATE - SEMI-PRIVATE" - creates it if necessary
     */
    public NM getIn140_ROOMRATESEMIPRIVATE() { 
		NM retVal = this.getTypedField(40, 0);
		return retVal;
    }



    /**
     * Returns
     * IN1-41: "ROOM RATE - PRIVATE" - creates it if necessary
     */
    public NM getROOMRATEPRIVATE() { 
		NM retVal = this.getTypedField(41, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN1-41: "ROOM RATE - PRIVATE" - creates it if necessary
     */
    public NM getIn141_ROOMRATEPRIVATE() { 
		NM retVal = this.getTypedField(41, 0);
		return retVal;
    }



    /**
     * Returns
     * IN1-42: "INSURED'S EMPLOYMENT STATUS" - creates it if necessary
     */
    public ID getINSUREDSEMPLOYMENTSTATUS() { 
		ID retVal = this.getTypedField(42, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN1-42: "INSURED'S EMPLOYMENT STATUS" - creates it if necessary
     */
    public ID getIn142_INSUREDSEMPLOYMENTSTATUS() { 
		ID retVal = this.getTypedField(42, 0);
		return retVal;
    }



    /**
     * Returns
     * IN1-43: "INSURED'S SEX" - creates it if necessary
     */
    public ID getINSUREDSSEX() { 
		ID retVal = this.getTypedField(43, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN1-43: "INSURED'S SEX" - creates it if necessary
     */
    public ID getIn143_INSUREDSSEX() { 
		ID retVal = this.getTypedField(43, 0);
		return retVal;
    }



    /**
     * Returns
     * IN1-44: "INSURED'S EMPLOYER ADDRESS" - creates it if necessary
     */
    public AD getINSUREDSEMPLOYERADDRESS() { 
		AD retVal = this.getTypedField(44, 0);
		return retVal;
    }
    
    /**
     * Returns
     * IN1-44: "INSURED'S EMPLOYER ADDRESS" - creates it if necessary
     */
    public AD getIn144_INSUREDSEMPLOYERADDRESS() { 
		AD retVal = this.getTypedField(44, 0);
		return retVal;
    }





    /** {@inheritDoc} */   
    protected Type createNewTypeWithoutReflection(int field) {
       switch (field) {
          case 0: return new SI(getMessage());
          case 1: return new ID(getMessage(), new Integer( 72 ));
          case 2: return new ST(getMessage());
          case 3: return new ST(getMessage());
          case 4: return new AD(getMessage());
          case 5: return new PN(getMessage());
          case 6: return new TN(getMessage());
          case 7: return new ST(getMessage());
          case 8: return new ST(getMessage());
          case 9: return new ST(getMessage());
          case 10: return new ST(getMessage());
          case 11: return new DT(getMessage());
          case 12: return new DT(getMessage());
          case 13: return new ST(getMessage());
          case 14: return new ID(getMessage(), new Integer( 86 ));
          case 15: return new PN(getMessage());
          case 16: return new ID(getMessage(), new Integer( 63 ));
          case 17: return new DT(getMessage());
          case 18: return new AD(getMessage());
          case 19: return new ID(getMessage(), new Integer( 0 ));
          case 20: return new ID(getMessage(), new Integer( 0 ));
          case 21: return new ST(getMessage());
          case 22: return new ID(getMessage(), new Integer( 81 ));
          case 23: return new DT(getMessage());
          case 24: return new ID(getMessage(), new Integer( 94 ));
          case 25: return new DT(getMessage());
          case 26: return new ID(getMessage(), new Integer( 93 ));
          case 27: return new ST(getMessage());
          case 28: return new DT(getMessage());
          case 29: return new CM(getMessage());
          case 30: return new ID(getMessage(), new Integer( 98 ));
          case 31: return new ID(getMessage(), new Integer( 22 ));
          case 32: return new NM(getMessage());
          case 33: return new NM(getMessage());
          case 34: return new ST(getMessage());
          case 35: return new ST(getMessage());
          case 36: return new NM(getMessage());
          case 37: return new NM(getMessage());
          case 38: return new NM(getMessage());
          case 39: return new NM(getMessage());
          case 40: return new NM(getMessage());
          case 41: return new ID(getMessage(), new Integer( 66 ));
          case 42: return new ID(getMessage(), new Integer( 1 ));
          case 43: return new AD(getMessage());
          default: return null;
       }
   }


}

