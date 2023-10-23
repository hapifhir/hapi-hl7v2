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
 * The Original Code is "XCN.java".  Description:
 * "Composite class XCN"
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

package ca.uhn.hl7v2.model.v251.datatype;

import ca.uhn.hl7v2.model.DataTypeException;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.Type;
import ca.uhn.hl7v2.model.AbstractComposite;


/**
 * <p>Represents an HL7 XCN (Extended Composite ID Number and Name for Persons) data type. 
 * This type consists of the following components:</p>
 * <ul>
 * <li>ID Number (ST)
 * <li>Family Name (FN)
 * <li>Given Name (ST)
 * <li>Second and Further Given Names or Initials Thereof (ST)
 * <li>Suffix (e.g., JR or III) (ST)
 * <li>Prefix (e.g., DR) (ST)
 * <li>Degree (e.g., MD) (IS)
 * <li>Source Table (IS)
 * <li>Assigning Authority (HD)
 * <li>Name Type Code (ID)
 * <li>Identifier Check Digit (ST)
 * <li>Check Digit Scheme (ID)
 * <li>Identifier Type Code (ID)
 * <li>Assigning Facility (HD)
 * <li>Name Representation Code (ID)
 * <li>Name Context (CE)
 * <li>Name Validity Range (DR)
 * <li>Name Assembly Order (ID)
 * <li>Effective Date (TS)
 * <li>Expiration Date (TS)
 * <li>Professional Suffix (ST)
 * <li>Assigning Jurisdiction (CWE)
 * <li>Assigning Agency or Department (CWE)
 * </ul>
 */
@SuppressWarnings("unused")
public class XCN extends AbstractComposite {

    private Type[] data;

    /** 
     * Creates a new XCN type
     */
    public XCN(Message message) {
        super(message);
        init();
    }

    private void init() {
        data = new Type[23];    
        data[0] = new ST(getMessage());
        data[1] = new FN(getMessage());
        data[2] = new ST(getMessage());
        data[3] = new ST(getMessage());
        data[4] = new ST(getMessage());
        data[5] = new ST(getMessage());
        data[6] = new IS(getMessage(), 360);
        data[7] = new IS(getMessage(), 297);
        data[8] = new HD(getMessage());
        data[9] = new ID(getMessage(), 200);
        data[10] = new ST(getMessage());
        data[11] = new ID(getMessage(), 61);
        data[12] = new ID(getMessage(), 203);
        data[13] = new HD(getMessage());
        data[14] = new ID(getMessage(), 465);
        data[15] = new CE(getMessage());
        data[16] = new DR(getMessage());
        data[17] = new ID(getMessage(), 444);
        data[18] = new TS(getMessage());
        data[19] = new TS(getMessage());
        data[20] = new ST(getMessage());
        data[21] = new CWE(getMessage());
        data[22] = new CWE(getMessage());
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
     * Returns ID Number (component 1).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ST getIDNumber() {
       return getTyped(0, ST.class);
    }

    
    /**
     * Returns ID Number (component 1).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ST getXcn1_IDNumber() {
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
    public FN getXcn2_FamilyName() {
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
    public ST getXcn3_GivenName() {
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
    public ST getXcn4_SecondAndFurtherGivenNamesOrInitialsThereof() {
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
    public ST getXcn5_SuffixEgJRorIII() {
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
    public ST getXcn6_PrefixEgDR() {
       return getTyped(5, ST.class);
    }


    /**
     * Returns Degree (e.g., MD) (component 7).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public IS getDegreeEgMD() {
       return getTyped(6, IS.class);
    }

    
    /**
     * Returns Degree (e.g., MD) (component 7).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public IS getXcn7_DegreeEgMD() {
       return getTyped(6, IS.class);
    }


    /**
     * Returns Source Table (component 8).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public IS getSourceTable() {
       return getTyped(7, IS.class);
    }

    
    /**
     * Returns Source Table (component 8).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public IS getXcn8_SourceTable() {
       return getTyped(7, IS.class);
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
    public HD getXcn9_AssigningAuthority() {
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
    public ID getXcn10_NameTypeCode() {
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
    public ST getXcn11_IdentifierCheckDigit() {
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
    public ID getXcn12_CheckDigitScheme() {
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
    public ID getXcn13_IdentifierTypeCode() {
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
    public HD getXcn14_AssigningFacility() {
       return getTyped(13, HD.class);
    }


    /**
     * Returns Name Representation Code (component 15).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ID getNameRepresentationCode() {
       return getTyped(14, ID.class);
    }

    
    /**
     * Returns Name Representation Code (component 15).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ID getXcn15_NameRepresentationCode() {
       return getTyped(14, ID.class);
    }


    /**
     * Returns Name Context (component 16).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public CE getNameContext() {
       return getTyped(15, CE.class);
    }

    
    /**
     * Returns Name Context (component 16).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public CE getXcn16_NameContext() {
       return getTyped(15, CE.class);
    }


    /**
     * Returns Name Validity Range (component 17).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public DR getNameValidityRange() {
       return getTyped(16, DR.class);
    }

    
    /**
     * Returns Name Validity Range (component 17).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public DR getXcn17_NameValidityRange() {
       return getTyped(16, DR.class);
    }


    /**
     * Returns Name Assembly Order (component 18).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ID getNameAssemblyOrder() {
       return getTyped(17, ID.class);
    }

    
    /**
     * Returns Name Assembly Order (component 18).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ID getXcn18_NameAssemblyOrder() {
       return getTyped(17, ID.class);
    }


    /**
     * Returns Effective Date (component 19).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public TS getEffectiveDate() {
       return getTyped(18, TS.class);
    }

    
    /**
     * Returns Effective Date (component 19).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public TS getXcn19_EffectiveDate() {
       return getTyped(18, TS.class);
    }


    /**
     * Returns Expiration Date (component 20).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public TS getExpirationDate() {
       return getTyped(19, TS.class);
    }

    
    /**
     * Returns Expiration Date (component 20).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public TS getXcn20_ExpirationDate() {
       return getTyped(19, TS.class);
    }


    /**
     * Returns Professional Suffix (component 21).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ST getProfessionalSuffix() {
       return getTyped(20, ST.class);
    }

    
    /**
     * Returns Professional Suffix (component 21).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ST getXcn21_ProfessionalSuffix() {
       return getTyped(20, ST.class);
    }


    /**
     * Returns Assigning Jurisdiction (component 22).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public CWE getAssigningJurisdiction() {
       return getTyped(21, CWE.class);
    }

    
    /**
     * Returns Assigning Jurisdiction (component 22).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public CWE getXcn22_AssigningJurisdiction() {
       return getTyped(21, CWE.class);
    }


    /**
     * Returns Assigning Agency or Department (component 23).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public CWE getAssigningAgencyOrDepartment() {
       return getTyped(22, CWE.class);
    }

    
    /**
     * Returns Assigning Agency or Department (component 23).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public CWE getXcn23_AssigningAgencyOrDepartment() {
       return getTyped(22, CWE.class);
    }



}

