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
 * The Original Code is "PPN.java".  Description:
 * "Composite class PPN"
 * 
 * The Initial Developer of the Original Code is University Health Network. Copyright (C) 
 * 2013.  All Rights Reserved.
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

package ca.uhn.hl7v2.model.v28.datatype;

import ca.uhn.hl7v2.model.DataTypeException;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.Type;
import ca.uhn.hl7v2.model.AbstractComposite;


/**
 * <p>Represents an HL7 PPN (Performing Person Time Stamp) data type. 
 * This type consists of the following components:</p>
 * <ul>
 * <li>Person Identifier (ST)
 * <li>Family Name (FN)
 * <li>Given Name (ST)
 * <li>Second and Further Given Names or Initials Thereof (ST)
 * <li>Suffix (e.g., JR or III) (ST)
 * <li>Prefix (e.g., DR) (ST)
 * <li>Degree (e.g., MD) (ST)
 * <li>Source Table (CWE)
 * <li>Assigning Authority (HD)
 * <li>Name Type Code (ID)
 * <li>Identifier Check Digit (ST)
 * <li>Check Digit Scheme (ID)
 * <li>Identifier Type Code (ID)
 * <li>Assigning Facility (HD)
 * <li>Date/Time Action Performed (DTM)
 * <li>Name Representation Code (ID)
 * <li>Name Context (CWE)
 * <li>Name Validity Range (ST)
 * <li>Name Assembly Order (ID)
 * <li>Effective Date (DTM)
 * <li>Expiration Date (DTM)
 * <li>Professional Suffix (ST)
 * <li>Assigning Jurisdiction (CWE)
 * <li>Assigning Agency or Department (CWE)
 * <li>Security Check (ST)
 * <li>Security Check Scheme (ID)
 * </ul>
 */
@SuppressWarnings("unused")
public class PPN extends AbstractComposite {

    private Type[] data;

    /** 
     * Creates a new PPN type
     */
    public PPN(Message message) {
        super(message);
        init();
    }

    private void init() {
        data = new Type[26];    
        data[0] = new ST(getMessage());
        data[1] = new FN(getMessage());
        data[2] = new ST(getMessage());
        data[3] = new ST(getMessage());
        data[4] = new ST(getMessage());
        data[5] = new ST(getMessage());
        data[6] = new ST(getMessage());
        data[7] = new CWE(getMessage());
        data[8] = new HD(getMessage());
        data[9] = new ID(getMessage(), 200);
        data[10] = new ST(getMessage());
        data[11] = new ID(getMessage(), 61);
        data[12] = new ID(getMessage(), 203);
        data[13] = new HD(getMessage());
        data[14] = new DTM(getMessage());
        data[15] = new ID(getMessage(), 465);
        data[16] = new CWE(getMessage());
        data[17] = new ST(getMessage());
        data[18] = new ID(getMessage(), 444);
        data[19] = new DTM(getMessage());
        data[20] = new DTM(getMessage());
        data[21] = new ST(getMessage());
        data[22] = new CWE(getMessage());
        data[23] = new CWE(getMessage());
        data[24] = new ST(getMessage());
        data[25] = new ID(getMessage(), 904);
    }


    /**
     * Returns an array containing the data elements.
     */
    public Type[] getComponents() { 
        return this.data; 
    }

    /**
     * Returns an individual data component.
     *
     * @param number The component number (0-indexed)
     * @throws DataTypeException if the given element number is out of range.
     */
    public Type getComponent(int number) throws DataTypeException { 

        try { 
            return this.data[number]; 
        } catch (ArrayIndexOutOfBoundsException e) { 
            throw new DataTypeException("Element " + number + " doesn't exist (Type " + getClass().getName() + " has only " + this.data.length + " components)"); 
        } 
    } 


    /**
     * Returns Person Identifier (component 1).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ST getPersonIdentifier() {
       return getTyped(0, ST.class);
    }

    
    /**
     * Returns Person Identifier (component 1).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ST getPpn1_PersonIdentifier() {
       return getTyped(0, ST.class);
    }


    /**
     * Returns Family Name (component 2).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public FN getFamilyName() {
       return getTyped(1, FN.class);
    }

    
    /**
     * Returns Family Name (component 2).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public FN getPpn2_FamilyName() {
       return getTyped(1, FN.class);
    }


    /**
     * Returns Given Name (component 3).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ST getGivenName() {
       return getTyped(2, ST.class);
    }

    
    /**
     * Returns Given Name (component 3).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ST getPpn3_GivenName() {
       return getTyped(2, ST.class);
    }


    /**
     * Returns Second and Further Given Names or Initials Thereof (component 4).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ST getSecondAndFurtherGivenNamesOrInitialsThereof() {
       return getTyped(3, ST.class);
    }

    
    /**
     * Returns Second and Further Given Names or Initials Thereof (component 4).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ST getPpn4_SecondAndFurtherGivenNamesOrInitialsThereof() {
       return getTyped(3, ST.class);
    }


    /**
     * Returns Suffix (e.g., JR or III) (component 5).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ST getSuffixEgJRorIII() {
       return getTyped(4, ST.class);
    }

    
    /**
     * Returns Suffix (e.g., JR or III) (component 5).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ST getPpn5_SuffixEgJRorIII() {
       return getTyped(4, ST.class);
    }


    /**
     * Returns Prefix (e.g., DR) (component 6).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ST getPrefixEgDR() {
       return getTyped(5, ST.class);
    }

    
    /**
     * Returns Prefix (e.g., DR) (component 6).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ST getPpn6_PrefixEgDR() {
       return getTyped(5, ST.class);
    }


    /**
     * Returns Degree (e.g., MD) (component 7).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ST getDegreeEgMD() {
       return getTyped(6, ST.class);
    }

    
    /**
     * Returns Degree (e.g., MD) (component 7).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ST getPpn7_DegreeEgMD() {
       return getTyped(6, ST.class);
    }


    /**
     * Returns Source Table (component 8).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public CWE getSourceTable() {
       return getTyped(7, CWE.class);
    }

    
    /**
     * Returns Source Table (component 8).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public CWE getPpn8_SourceTable() {
       return getTyped(7, CWE.class);
    }


    /**
     * Returns Assigning Authority (component 9).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public HD getAssigningAuthority() {
       return getTyped(8, HD.class);
    }

    
    /**
     * Returns Assigning Authority (component 9).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public HD getPpn9_AssigningAuthority() {
       return getTyped(8, HD.class);
    }


    /**
     * Returns Name Type Code (component 10).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ID getNameTypeCode() {
       return getTyped(9, ID.class);
    }

    
    /**
     * Returns Name Type Code (component 10).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ID getPpn10_NameTypeCode() {
       return getTyped(9, ID.class);
    }


    /**
     * Returns Identifier Check Digit (component 11).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ST getIdentifierCheckDigit() {
       return getTyped(10, ST.class);
    }

    
    /**
     * Returns Identifier Check Digit (component 11).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ST getPpn11_IdentifierCheckDigit() {
       return getTyped(10, ST.class);
    }


    /**
     * Returns Check Digit Scheme (component 12).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ID getCheckDigitScheme() {
       return getTyped(11, ID.class);
    }

    
    /**
     * Returns Check Digit Scheme (component 12).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ID getPpn12_CheckDigitScheme() {
       return getTyped(11, ID.class);
    }


    /**
     * Returns Identifier Type Code (component 13).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ID getIdentifierTypeCode() {
       return getTyped(12, ID.class);
    }

    
    /**
     * Returns Identifier Type Code (component 13).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ID getPpn13_IdentifierTypeCode() {
       return getTyped(12, ID.class);
    }


    /**
     * Returns Assigning Facility (component 14).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public HD getAssigningFacility() {
       return getTyped(13, HD.class);
    }

    
    /**
     * Returns Assigning Facility (component 14).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public HD getPpn14_AssigningFacility() {
       return getTyped(13, HD.class);
    }


    /**
     * Returns Date/Time Action Performed (component 15).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public DTM getDateTimeActionPerformed() {
       return getTyped(14, DTM.class);
    }

    
    /**
     * Returns Date/Time Action Performed (component 15).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public DTM getPpn15_DateTimeActionPerformed() {
       return getTyped(14, DTM.class);
    }


    /**
     * Returns Name Representation Code (component 16).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ID getNameRepresentationCode() {
       return getTyped(15, ID.class);
    }

    
    /**
     * Returns Name Representation Code (component 16).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ID getPpn16_NameRepresentationCode() {
       return getTyped(15, ID.class);
    }


    /**
     * Returns Name Context (component 17).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public CWE getNameContext() {
       return getTyped(16, CWE.class);
    }

    
    /**
     * Returns Name Context (component 17).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public CWE getPpn17_NameContext() {
       return getTyped(16, CWE.class);
    }


    /**
     * Returns Name Validity Range (component 18).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ST getNameValidityRange() {
       return getTyped(17, ST.class);
    }

    
    /**
     * Returns Name Validity Range (component 18).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ST getPpn18_NameValidityRange() {
       return getTyped(17, ST.class);
    }


    /**
     * Returns Name Assembly Order (component 19).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ID getNameAssemblyOrder() {
       return getTyped(18, ID.class);
    }

    
    /**
     * Returns Name Assembly Order (component 19).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ID getPpn19_NameAssemblyOrder() {
       return getTyped(18, ID.class);
    }


    /**
     * Returns Effective Date (component 20).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public DTM getEffectiveDate() {
       return getTyped(19, DTM.class);
    }

    
    /**
     * Returns Effective Date (component 20).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public DTM getPpn20_EffectiveDate() {
       return getTyped(19, DTM.class);
    }


    /**
     * Returns Expiration Date (component 21).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public DTM getExpirationDate() {
       return getTyped(20, DTM.class);
    }

    
    /**
     * Returns Expiration Date (component 21).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public DTM getPpn21_ExpirationDate() {
       return getTyped(20, DTM.class);
    }


    /**
     * Returns Professional Suffix (component 22).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ST getProfessionalSuffix() {
       return getTyped(21, ST.class);
    }

    
    /**
     * Returns Professional Suffix (component 22).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ST getPpn22_ProfessionalSuffix() {
       return getTyped(21, ST.class);
    }


    /**
     * Returns Assigning Jurisdiction (component 23).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public CWE getAssigningJurisdiction() {
       return getTyped(22, CWE.class);
    }

    
    /**
     * Returns Assigning Jurisdiction (component 23).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public CWE getPpn23_AssigningJurisdiction() {
       return getTyped(22, CWE.class);
    }


    /**
     * Returns Assigning Agency or Department (component 24).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public CWE getAssigningAgencyOrDepartment() {
       return getTyped(23, CWE.class);
    }

    
    /**
     * Returns Assigning Agency or Department (component 24).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public CWE getPpn24_AssigningAgencyOrDepartment() {
       return getTyped(23, CWE.class);
    }


    /**
     * Returns Security Check (component 25).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ST getSecurityCheck() {
       return getTyped(24, ST.class);
    }

    
    /**
     * Returns Security Check (component 25).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ST getPpn25_SecurityCheck() {
       return getTyped(24, ST.class);
    }


    /**
     * Returns Security Check Scheme (component 26).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ID getSecurityCheckScheme() {
       return getTyped(25, ID.class);
    }

    
    /**
     * Returns Security Check Scheme (component 26).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ID getPpn26_SecurityCheckScheme() {
       return getTyped(25, ID.class);
    }



}

