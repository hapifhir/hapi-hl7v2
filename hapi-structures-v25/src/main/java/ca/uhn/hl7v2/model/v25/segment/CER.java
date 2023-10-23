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


package ca.uhn.hl7v2.model.v25.segment;

// import ca.uhn.hl7v2.model.v25.group.*;
import ca.uhn.hl7v2.model.v25.datatype.*;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.parser.DefaultModelClassFactory;
import ca.uhn.hl7v2.model.AbstractMessage;
import ca.uhn.hl7v2.model.Group;
import ca.uhn.hl7v2.model.Type;
import ca.uhn.hl7v2.model.AbstractSegment;
import ca.uhn.hl7v2.model.Varies;


/**
 *<p>Represents an HL7 CER message segment (Certificate Detail). 
 * This segment has the following fields:</p>
 * <ul>
     * <li>CER-1: Set ID _ CER (SI) <b> </b>
     * <li>CER-2: Serial Number (ST) <b>optional </b>
     * <li>CER-3: Version (ST) <b>optional </b>
     * <li>CER-4: Granting Authority (XON) <b>optional </b>
     * <li>CER-5: Issuing Authority (XCN) <b>optional </b>
     * <li>CER-6: Signature of Issuing Authority (ED) <b>optional </b>
     * <li>CER-7: Granting Country (ID) <b>optional </b>
     * <li>CER-8: Granting State/Province (CWE) <b>optional </b>
     * <li>CER-9: Granting County/Parish (CWE) <b>optional </b>
     * <li>CER-10: Certificate Type (CWE) <b>optional </b>
     * <li>CER-11: Certificate Domain (CWE) <b>optional </b>
     * <li>CER-12: Subject ID (ID) <b>optional </b>
     * <li>CER-13: Subject Name (ST) <b> </b>
     * <li>CER-14: Subject Directory Attribute Extension (Health Professional Data) (CWE) <b>optional repeating</b>
     * <li>CER-15: Subject Public Key Info (CWE) <b>optional </b>
     * <li>CER-16: Authority Key Identifier (CWE) <b>optional </b>
     * <li>CER-17: Basic Constraint (ID) <b>optional </b>
     * <li>CER-18: CRL Distribution Point (CWE) <b>optional repeating</b>
     * <li>CER-19: Jurisdiction Country (ID) <b>optional </b>
     * <li>CER-20: Jurisdiction State/Province (CWE) <b>optional </b>
     * <li>CER-21: Jurisdiction County/Parish (CWE) <b>optional </b>
     * <li>CER-22: Jurisdiction Breadth (CWE) <b>optional repeating</b>
     * <li>CER-23: Granting Date (TS) <b>optional </b>
     * <li>CER-24: Issuing Date (TS) <b>optional </b>
     * <li>CER-25: Activation Date (TS) <b>optional </b>
     * <li>CER-26: Inactivation Date (TS) <b>optional </b>
     * <li>CER-27: Expiration Date (TS) <b>optional </b>
     * <li>CER-28: Renewal Date (TS) <b>optional </b>
     * <li>CER-29: Revocation Date (TS) <b>optional </b>
     * <li>CER-30: Revocation Reason Code (CE) <b>optional </b>
     * <li>CER-31: Certificate Status (CWE) <b>optional </b>
 * </ul>
 */
@SuppressWarnings("unused")
public class CER extends AbstractSegment {

    /** 
     * Creates a new CER segment
     */
    public CER(Group parent, ModelClassFactory factory) {
       super(parent, factory);
       init(factory);
    }

    private void init(ModelClassFactory factory) {
       try {
                                  this.add(SI.class, true, 1, 4, new Object[]{ getMessage() }, "Set ID _ CER");
                                  this.add(ST.class, false, 1, 80, new Object[]{ getMessage() }, "Serial Number");
                                  this.add(ST.class, false, 1, 80, new Object[]{ getMessage() }, "Version");
                                  this.add(XON.class, false, 1, 250, new Object[]{ getMessage() }, "Granting Authority");
                                  this.add(XCN.class, false, 1, 250, new Object[]{ getMessage() }, "Issuing Authority");
                                  this.add(ED.class, false, 1, 65536, new Object[]{ getMessage() }, "Signature of Issuing Authority");
                                              this.add(ID.class, false, 1, 3, new Object[]{ getMessage(), new Integer(399) }, "Granting Country");
                                  this.add(CWE.class, false, 1, 250, new Object[]{ getMessage() }, "Granting State/Province");
                                  this.add(CWE.class, false, 1, 250, new Object[]{ getMessage() }, "Granting County/Parish");
                                  this.add(CWE.class, false, 1, 250, new Object[]{ getMessage() }, "Certificate Type");
                                  this.add(CWE.class, false, 1, 250, new Object[]{ getMessage() }, "Certificate Domain");
                                              this.add(ID.class, false, 1, 250, new Object[]{ getMessage(), new Integer(0) }, "Subject ID");
                                  this.add(ST.class, true, 1, 250, new Object[]{ getMessage() }, "Subject Name");
                                  this.add(CWE.class, false, 0, 250, new Object[]{ getMessage() }, "Subject Directory Attribute Extension (Health Professional Data)");
                                  this.add(CWE.class, false, 1, 250, new Object[]{ getMessage() }, "Subject Public Key Info");
                                  this.add(CWE.class, false, 1, 250, new Object[]{ getMessage() }, "Authority Key Identifier");
                                              this.add(ID.class, false, 1, 250, new Object[]{ getMessage(), new Integer(136) }, "Basic Constraint");
                                  this.add(CWE.class, false, 0, 250, new Object[]{ getMessage() }, "CRL Distribution Point");
                                              this.add(ID.class, false, 1, 3, new Object[]{ getMessage(), new Integer(399) }, "Jurisdiction Country");
                                  this.add(CWE.class, false, 1, 250, new Object[]{ getMessage() }, "Jurisdiction State/Province");
                                  this.add(CWE.class, false, 1, 250, new Object[]{ getMessage() }, "Jurisdiction County/Parish");
                                  this.add(CWE.class, false, 0, 250, new Object[]{ getMessage() }, "Jurisdiction Breadth");
                                  this.add(TS.class, false, 1, 26, new Object[]{ getMessage() }, "Granting Date");
                                  this.add(TS.class, false, 1, 26, new Object[]{ getMessage() }, "Issuing Date");
                                  this.add(TS.class, false, 1, 26, new Object[]{ getMessage() }, "Activation Date");
                                  this.add(TS.class, false, 1, 26, new Object[]{ getMessage() }, "Inactivation Date");
                                  this.add(TS.class, false, 1, 26, new Object[]{ getMessage() }, "Expiration Date");
                                  this.add(TS.class, false, 1, 26, new Object[]{ getMessage() }, "Renewal Date");
                                  this.add(TS.class, false, 1, 26, new Object[]{ getMessage() }, "Revocation Date");
                                  this.add(CE.class, false, 1, 250, new Object[]{ getMessage() }, "Revocation Reason Code");
                                  this.add(CWE.class, false, 1, 250, new Object[]{ getMessage() }, "Certificate Status");
       } catch(HL7Exception e) {
          log.error("Unexpected error creating CER - this is probably a bug in the source code generator.", e);
       }
    }



    /**
     * Returns
     * CER-1: "Set ID _ CER" - creates it if necessary
     */
    public SI getSetIDCER() { 
		SI retVal = this.getTypedField(1, 0);
		return retVal;
    }
    
    /**
     * Returns
     * CER-1: "Set ID _ CER" - creates it if necessary
     */
    public SI getCer1_SetIDCER() { 
		SI retVal = this.getTypedField(1, 0);
		return retVal;
    }



    /**
     * Returns
     * CER-2: "Serial Number" - creates it if necessary
     */
    public ST getSerialNumber() { 
		ST retVal = this.getTypedField(2, 0);
		return retVal;
    }
    
    /**
     * Returns
     * CER-2: "Serial Number" - creates it if necessary
     */
    public ST getCer2_SerialNumber() { 
		ST retVal = this.getTypedField(2, 0);
		return retVal;
    }



    /**
     * Returns
     * CER-3: "Version" - creates it if necessary
     */
    public ST getVersion() { 
		ST retVal = this.getTypedField(3, 0);
		return retVal;
    }
    
    /**
     * Returns
     * CER-3: "Version" - creates it if necessary
     */
    public ST getCer3_Version() { 
		ST retVal = this.getTypedField(3, 0);
		return retVal;
    }



    /**
     * Returns
     * CER-4: "Granting Authority" - creates it if necessary
     */
    public XON getGrantingAuthority() { 
		XON retVal = this.getTypedField(4, 0);
		return retVal;
    }
    
    /**
     * Returns
     * CER-4: "Granting Authority" - creates it if necessary
     */
    public XON getCer4_GrantingAuthority() { 
		XON retVal = this.getTypedField(4, 0);
		return retVal;
    }



    /**
     * Returns
     * CER-5: "Issuing Authority" - creates it if necessary
     */
    public XCN getIssuingAuthority() { 
		XCN retVal = this.getTypedField(5, 0);
		return retVal;
    }
    
    /**
     * Returns
     * CER-5: "Issuing Authority" - creates it if necessary
     */
    public XCN getCer5_IssuingAuthority() { 
		XCN retVal = this.getTypedField(5, 0);
		return retVal;
    }



    /**
     * Returns
     * CER-6: "Signature of Issuing Authority" - creates it if necessary
     */
    public ED getSignatureOfIssuingAuthority() { 
		ED retVal = this.getTypedField(6, 0);
		return retVal;
    }
    
    /**
     * Returns
     * CER-6: "Signature of Issuing Authority" - creates it if necessary
     */
    public ED getCer6_SignatureOfIssuingAuthority() { 
		ED retVal = this.getTypedField(6, 0);
		return retVal;
    }



    /**
     * Returns
     * CER-7: "Granting Country" - creates it if necessary
     */
    public ID getGrantingCountry() { 
		ID retVal = this.getTypedField(7, 0);
		return retVal;
    }
    
    /**
     * Returns
     * CER-7: "Granting Country" - creates it if necessary
     */
    public ID getCer7_GrantingCountry() { 
		ID retVal = this.getTypedField(7, 0);
		return retVal;
    }



    /**
     * Returns
     * CER-8: "Granting State/Province" - creates it if necessary
     */
    public CWE getGrantingStateProvince() { 
		CWE retVal = this.getTypedField(8, 0);
		return retVal;
    }
    
    /**
     * Returns
     * CER-8: "Granting State/Province" - creates it if necessary
     */
    public CWE getCer8_GrantingStateProvince() { 
		CWE retVal = this.getTypedField(8, 0);
		return retVal;
    }



    /**
     * Returns
     * CER-9: "Granting County/Parish" - creates it if necessary
     */
    public CWE getGrantingCountyParish() { 
		CWE retVal = this.getTypedField(9, 0);
		return retVal;
    }
    
    /**
     * Returns
     * CER-9: "Granting County/Parish" - creates it if necessary
     */
    public CWE getCer9_GrantingCountyParish() { 
		CWE retVal = this.getTypedField(9, 0);
		return retVal;
    }



    /**
     * Returns
     * CER-10: "Certificate Type" - creates it if necessary
     */
    public CWE getCertificateType() { 
		CWE retVal = this.getTypedField(10, 0);
		return retVal;
    }
    
    /**
     * Returns
     * CER-10: "Certificate Type" - creates it if necessary
     */
    public CWE getCer10_CertificateType() { 
		CWE retVal = this.getTypedField(10, 0);
		return retVal;
    }



    /**
     * Returns
     * CER-11: "Certificate Domain" - creates it if necessary
     */
    public CWE getCertificateDomain() { 
		CWE retVal = this.getTypedField(11, 0);
		return retVal;
    }
    
    /**
     * Returns
     * CER-11: "Certificate Domain" - creates it if necessary
     */
    public CWE getCer11_CertificateDomain() { 
		CWE retVal = this.getTypedField(11, 0);
		return retVal;
    }



    /**
     * Returns
     * CER-12: "Subject ID" - creates it if necessary
     */
    public ID getSubjectID() { 
		ID retVal = this.getTypedField(12, 0);
		return retVal;
    }
    
    /**
     * Returns
     * CER-12: "Subject ID" - creates it if necessary
     */
    public ID getCer12_SubjectID() { 
		ID retVal = this.getTypedField(12, 0);
		return retVal;
    }



    /**
     * Returns
     * CER-13: "Subject Name" - creates it if necessary
     */
    public ST getSubjectName() { 
		ST retVal = this.getTypedField(13, 0);
		return retVal;
    }
    
    /**
     * Returns
     * CER-13: "Subject Name" - creates it if necessary
     */
    public ST getCer13_SubjectName() { 
		ST retVal = this.getTypedField(13, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Subject Directory Attribute Extension (Health Professional Data) (CER-14).
     */
    public CWE[] getSubjectDirectoryAttributeExtensionHealthProfessionalData() {
    	CWE[] retVal = this.getTypedField(14, new CWE[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Subject Directory Attribute Extension (Health Professional Data) (CER-14).
     */
    public CWE[] getCer14_SubjectDirectoryAttributeExtensionHealthProfessionalData() {
    	CWE[] retVal = this.getTypedField(14, new CWE[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Subject Directory Attribute Extension (Health Professional Data) (CER-14).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getSubjectDirectoryAttributeExtensionHealthProfessionalDataReps() {
    	return this.getReps(14);
    }


    /**
     * Returns a specific repetition of
     * CER-14: "Subject Directory Attribute Extension (Health Professional Data)" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CWE getSubjectDirectoryAttributeExtensionHealthProfessionalData(int rep) { 
		CWE retVal = this.getTypedField(14, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * CER-14: "Subject Directory Attribute Extension (Health Professional Data)" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CWE getCer14_SubjectDirectoryAttributeExtensionHealthProfessionalData(int rep) { 
		CWE retVal = this.getTypedField(14, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Subject Directory Attribute Extension (Health Professional Data) (CER-14).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getCer14_SubjectDirectoryAttributeExtensionHealthProfessionalDataReps() {
    	return this.getReps(14);
    }


    /**
     * Inserts a repetition of
     * CER-14: "Subject Directory Attribute Extension (Health Professional Data)" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE insertSubjectDirectoryAttributeExtensionHealthProfessionalData(int rep) throws HL7Exception { 
        return (CWE) super.insertRepetition(14, rep);
    }


    /**
     * Inserts a repetition of
     * CER-14: "Subject Directory Attribute Extension (Health Professional Data)" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE insertCer14_SubjectDirectoryAttributeExtensionHealthProfessionalData(int rep) throws HL7Exception { 
        return (CWE) super.insertRepetition(14, rep);
    }


    /**
     * Removes a repetition of
     * CER-14: "Subject Directory Attribute Extension (Health Professional Data)" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE removeSubjectDirectoryAttributeExtensionHealthProfessionalData(int rep) throws HL7Exception { 
        return (CWE) super.removeRepetition(14, rep);
    }


    /**
     * Removes a repetition of
     * CER-14: "Subject Directory Attribute Extension (Health Professional Data)" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE removeCer14_SubjectDirectoryAttributeExtensionHealthProfessionalData(int rep) throws HL7Exception { 
        return (CWE) super.removeRepetition(14, rep);
    }




    /**
     * Returns
     * CER-15: "Subject Public Key Info" - creates it if necessary
     */
    public CWE getSubjectPublicKeyInfo() { 
		CWE retVal = this.getTypedField(15, 0);
		return retVal;
    }
    
    /**
     * Returns
     * CER-15: "Subject Public Key Info" - creates it if necessary
     */
    public CWE getCer15_SubjectPublicKeyInfo() { 
		CWE retVal = this.getTypedField(15, 0);
		return retVal;
    }



    /**
     * Returns
     * CER-16: "Authority Key Identifier" - creates it if necessary
     */
    public CWE getAuthorityKeyIdentifier() { 
		CWE retVal = this.getTypedField(16, 0);
		return retVal;
    }
    
    /**
     * Returns
     * CER-16: "Authority Key Identifier" - creates it if necessary
     */
    public CWE getCer16_AuthorityKeyIdentifier() { 
		CWE retVal = this.getTypedField(16, 0);
		return retVal;
    }



    /**
     * Returns
     * CER-17: "Basic Constraint" - creates it if necessary
     */
    public ID getBasicConstraint() { 
		ID retVal = this.getTypedField(17, 0);
		return retVal;
    }
    
    /**
     * Returns
     * CER-17: "Basic Constraint" - creates it if necessary
     */
    public ID getCer17_BasicConstraint() { 
		ID retVal = this.getTypedField(17, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of CRL Distribution Point (CER-18).
     */
    public CWE[] getCRLDistributionPoint() {
    	CWE[] retVal = this.getTypedField(18, new CWE[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of CRL Distribution Point (CER-18).
     */
    public CWE[] getCer18_CRLDistributionPoint() {
    	CWE[] retVal = this.getTypedField(18, new CWE[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of CRL Distribution Point (CER-18).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getCRLDistributionPointReps() {
    	return this.getReps(18);
    }


    /**
     * Returns a specific repetition of
     * CER-18: "CRL Distribution Point" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CWE getCRLDistributionPoint(int rep) { 
		CWE retVal = this.getTypedField(18, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * CER-18: "CRL Distribution Point" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CWE getCer18_CRLDistributionPoint(int rep) { 
		CWE retVal = this.getTypedField(18, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of CRL Distribution Point (CER-18).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getCer18_CRLDistributionPointReps() {
    	return this.getReps(18);
    }


    /**
     * Inserts a repetition of
     * CER-18: "CRL Distribution Point" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE insertCRLDistributionPoint(int rep) throws HL7Exception { 
        return (CWE) super.insertRepetition(18, rep);
    }


    /**
     * Inserts a repetition of
     * CER-18: "CRL Distribution Point" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE insertCer18_CRLDistributionPoint(int rep) throws HL7Exception { 
        return (CWE) super.insertRepetition(18, rep);
    }


    /**
     * Removes a repetition of
     * CER-18: "CRL Distribution Point" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE removeCRLDistributionPoint(int rep) throws HL7Exception { 
        return (CWE) super.removeRepetition(18, rep);
    }


    /**
     * Removes a repetition of
     * CER-18: "CRL Distribution Point" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE removeCer18_CRLDistributionPoint(int rep) throws HL7Exception { 
        return (CWE) super.removeRepetition(18, rep);
    }




    /**
     * Returns
     * CER-19: "Jurisdiction Country" - creates it if necessary
     */
    public ID getJurisdictionCountry() { 
		ID retVal = this.getTypedField(19, 0);
		return retVal;
    }
    
    /**
     * Returns
     * CER-19: "Jurisdiction Country" - creates it if necessary
     */
    public ID getCer19_JurisdictionCountry() { 
		ID retVal = this.getTypedField(19, 0);
		return retVal;
    }



    /**
     * Returns
     * CER-20: "Jurisdiction State/Province" - creates it if necessary
     */
    public CWE getJurisdictionStateProvince() { 
		CWE retVal = this.getTypedField(20, 0);
		return retVal;
    }
    
    /**
     * Returns
     * CER-20: "Jurisdiction State/Province" - creates it if necessary
     */
    public CWE getCer20_JurisdictionStateProvince() { 
		CWE retVal = this.getTypedField(20, 0);
		return retVal;
    }



    /**
     * Returns
     * CER-21: "Jurisdiction County/Parish" - creates it if necessary
     */
    public CWE getJurisdictionCountyParish() { 
		CWE retVal = this.getTypedField(21, 0);
		return retVal;
    }
    
    /**
     * Returns
     * CER-21: "Jurisdiction County/Parish" - creates it if necessary
     */
    public CWE getCer21_JurisdictionCountyParish() { 
		CWE retVal = this.getTypedField(21, 0);
		return retVal;
    }


    /**
     * Returns all repetitions of Jurisdiction Breadth (CER-22).
     */
    public CWE[] getJurisdictionBreadth() {
    	CWE[] retVal = this.getTypedField(22, new CWE[0]);
    	return retVal;
    }


    /**
     * Returns all repetitions of Jurisdiction Breadth (CER-22).
     */
    public CWE[] getCer22_JurisdictionBreadth() {
    	CWE[] retVal = this.getTypedField(22, new CWE[0]);
    	return retVal;
    }


    /**
     * Returns a count of the current number of repetitions of Jurisdiction Breadth (CER-22).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getJurisdictionBreadthReps() {
    	return this.getReps(22);
    }


    /**
     * Returns a specific repetition of
     * CER-22: "Jurisdiction Breadth" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CWE getJurisdictionBreadth(int rep) { 
		CWE retVal = this.getTypedField(22, rep);
		return retVal;
    }

    /**
     * Returns a specific repetition of
     * CER-22: "Jurisdiction Breadth" - creates it if necessary
     *
     * @param rep The repetition index (0-indexed)
     */
    public CWE getCer22_JurisdictionBreadth(int rep) { 
		CWE retVal = this.getTypedField(22, rep);
		return retVal;
    }

    /**
     * Returns a count of the current number of repetitions of Jurisdiction Breadth (CER-22).
     * This method does not create a repetition, so if no repetitions have currently been defined or accessed,
     * it will return zero.
     */
    public int getCer22_JurisdictionBreadthReps() {
    	return this.getReps(22);
    }


    /**
     * Inserts a repetition of
     * CER-22: "Jurisdiction Breadth" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE insertJurisdictionBreadth(int rep) throws HL7Exception { 
        return (CWE) super.insertRepetition(22, rep);
    }


    /**
     * Inserts a repetition of
     * CER-22: "Jurisdiction Breadth" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE insertCer22_JurisdictionBreadth(int rep) throws HL7Exception { 
        return (CWE) super.insertRepetition(22, rep);
    }


    /**
     * Removes a repetition of
     * CER-22: "Jurisdiction Breadth" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE removeJurisdictionBreadth(int rep) throws HL7Exception { 
        return (CWE) super.removeRepetition(22, rep);
    }


    /**
     * Removes a repetition of
     * CER-22: "Jurisdiction Breadth" at a specific index
     *
     * @param rep The repetition index (0-indexed)
     * @throws HL7Exception If the rep is invalid (below 0, or too high for the allowable repetitions)
     */
    public CWE removeCer22_JurisdictionBreadth(int rep) throws HL7Exception { 
        return (CWE) super.removeRepetition(22, rep);
    }




    /**
     * Returns
     * CER-23: "Granting Date" - creates it if necessary
     */
    public TS getGrantingDate() { 
		TS retVal = this.getTypedField(23, 0);
		return retVal;
    }
    
    /**
     * Returns
     * CER-23: "Granting Date" - creates it if necessary
     */
    public TS getCer23_GrantingDate() { 
		TS retVal = this.getTypedField(23, 0);
		return retVal;
    }



    /**
     * Returns
     * CER-24: "Issuing Date" - creates it if necessary
     */
    public TS getIssuingDate() { 
		TS retVal = this.getTypedField(24, 0);
		return retVal;
    }
    
    /**
     * Returns
     * CER-24: "Issuing Date" - creates it if necessary
     */
    public TS getCer24_IssuingDate() { 
		TS retVal = this.getTypedField(24, 0);
		return retVal;
    }



    /**
     * Returns
     * CER-25: "Activation Date" - creates it if necessary
     */
    public TS getActivationDate() { 
		TS retVal = this.getTypedField(25, 0);
		return retVal;
    }
    
    /**
     * Returns
     * CER-25: "Activation Date" - creates it if necessary
     */
    public TS getCer25_ActivationDate() { 
		TS retVal = this.getTypedField(25, 0);
		return retVal;
    }



    /**
     * Returns
     * CER-26: "Inactivation Date" - creates it if necessary
     */
    public TS getInactivationDate() { 
		TS retVal = this.getTypedField(26, 0);
		return retVal;
    }
    
    /**
     * Returns
     * CER-26: "Inactivation Date" - creates it if necessary
     */
    public TS getCer26_InactivationDate() { 
		TS retVal = this.getTypedField(26, 0);
		return retVal;
    }



    /**
     * Returns
     * CER-27: "Expiration Date" - creates it if necessary
     */
    public TS getExpirationDate() { 
		TS retVal = this.getTypedField(27, 0);
		return retVal;
    }
    
    /**
     * Returns
     * CER-27: "Expiration Date" - creates it if necessary
     */
    public TS getCer27_ExpirationDate() { 
		TS retVal = this.getTypedField(27, 0);
		return retVal;
    }



    /**
     * Returns
     * CER-28: "Renewal Date" - creates it if necessary
     */
    public TS getRenewalDate() { 
		TS retVal = this.getTypedField(28, 0);
		return retVal;
    }
    
    /**
     * Returns
     * CER-28: "Renewal Date" - creates it if necessary
     */
    public TS getCer28_RenewalDate() { 
		TS retVal = this.getTypedField(28, 0);
		return retVal;
    }



    /**
     * Returns
     * CER-29: "Revocation Date" - creates it if necessary
     */
    public TS getRevocationDate() { 
		TS retVal = this.getTypedField(29, 0);
		return retVal;
    }
    
    /**
     * Returns
     * CER-29: "Revocation Date" - creates it if necessary
     */
    public TS getCer29_RevocationDate() { 
		TS retVal = this.getTypedField(29, 0);
		return retVal;
    }



    /**
     * Returns
     * CER-30: "Revocation Reason Code" - creates it if necessary
     */
    public CE getRevocationReasonCode() { 
		CE retVal = this.getTypedField(30, 0);
		return retVal;
    }
    
    /**
     * Returns
     * CER-30: "Revocation Reason Code" - creates it if necessary
     */
    public CE getCer30_RevocationReasonCode() { 
		CE retVal = this.getTypedField(30, 0);
		return retVal;
    }



    /**
     * Returns
     * CER-31: "Certificate Status" - creates it if necessary
     */
    public CWE getCertificateStatus() { 
		CWE retVal = this.getTypedField(31, 0);
		return retVal;
    }
    
    /**
     * Returns
     * CER-31: "Certificate Status" - creates it if necessary
     */
    public CWE getCer31_CertificateStatus() { 
		CWE retVal = this.getTypedField(31, 0);
		return retVal;
    }





    /** {@inheritDoc} */   
    protected Type createNewTypeWithoutReflection(int field) {
       switch (field) {
          case 0: return new SI(getMessage());
          case 1: return new ST(getMessage());
          case 2: return new ST(getMessage());
          case 3: return new XON(getMessage());
          case 4: return new XCN(getMessage());
          case 5: return new ED(getMessage());
          case 6: return new ID(getMessage(), new Integer( 399 ));
          case 7: return new CWE(getMessage());
          case 8: return new CWE(getMessage());
          case 9: return new CWE(getMessage());
          case 10: return new CWE(getMessage());
          case 11: return new ID(getMessage(), new Integer( 0 ));
          case 12: return new ST(getMessage());
          case 13: return new CWE(getMessage());
          case 14: return new CWE(getMessage());
          case 15: return new CWE(getMessage());
          case 16: return new ID(getMessage(), new Integer( 136 ));
          case 17: return new CWE(getMessage());
          case 18: return new ID(getMessage(), new Integer( 399 ));
          case 19: return new CWE(getMessage());
          case 20: return new CWE(getMessage());
          case 21: return new CWE(getMessage());
          case 22: return new TS(getMessage());
          case 23: return new TS(getMessage());
          case 24: return new TS(getMessage());
          case 25: return new TS(getMessage());
          case 26: return new TS(getMessage());
          case 27: return new TS(getMessage());
          case 28: return new TS(getMessage());
          case 29: return new CE(getMessage());
          case 30: return new CWE(getMessage());
          default: return null;
       }
   }


}

