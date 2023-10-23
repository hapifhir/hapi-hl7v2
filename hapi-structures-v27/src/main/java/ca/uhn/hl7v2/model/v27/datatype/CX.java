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
 * The Original Code is "CX.java".  Description:
 * "Composite class CX"
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

package ca.uhn.hl7v2.model.v27.datatype;

import ca.uhn.hl7v2.model.DataTypeException;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.Type;
import ca.uhn.hl7v2.model.AbstractComposite;


/**
 * <p>Represents an HL7 CX (Extended Composite ID with Check Digit) data type. 
 * This type consists of the following components:</p>
 * <ul>
 * <li>ID Number (ST)
 * <li>Identifier Check Digit (ST)
 * <li>Check Digit Scheme (ID)
 * <li>Assigning Authority (HD)
 * <li>Identifier Type Code (ID)
 * <li>Assigning Facility (HD)
 * <li>Effective Date (DT)
 * <li>Expiration Date (DT)
 * <li>Assigning Jurisdiction (CWE)
 * <li>Assigning Agency or Department (CWE)
 * <li>Security Check (ST)
 * <li>Security Check Scheme (ID)
 * </ul>
 */
@SuppressWarnings("unused")
public class CX extends AbstractComposite {

    private Type[] data;

    /** 
     * Creates a new CX type
     */
    public CX(Message message) {
        super(message);
        init();
    }

    private void init() {
        data = new Type[12];    
        data[0] = new ST(getMessage());
        data[1] = new ST(getMessage());
        data[2] = new ID(getMessage(), 61);
        data[3] = new HD(getMessage());
        data[4] = new ID(getMessage(), 203);
        data[5] = new HD(getMessage());
        data[6] = new DT(getMessage());
        data[7] = new DT(getMessage());
        data[8] = new CWE(getMessage());
        data[9] = new CWE(getMessage());
        data[10] = new ST(getMessage());
        data[11] = new ID(getMessage(), 904);
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
    public ST getCx1_IDNumber() {
       return getTyped(0, ST.class);
    }


    /**
     * Returns Identifier Check Digit (component 2).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ST getIdentifierCheckDigit() {
       return getTyped(1, ST.class);
    }

    
    /**
     * Returns Identifier Check Digit (component 2).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ST getCx2_IdentifierCheckDigit() {
       return getTyped(1, ST.class);
    }


    /**
     * Returns Check Digit Scheme (component 3).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ID getCheckDigitScheme() {
       return getTyped(2, ID.class);
    }

    
    /**
     * Returns Check Digit Scheme (component 3).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ID getCx3_CheckDigitScheme() {
       return getTyped(2, ID.class);
    }


    /**
     * Returns Assigning Authority (component 4).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public HD getAssigningAuthority() {
       return getTyped(3, HD.class);
    }

    
    /**
     * Returns Assigning Authority (component 4).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public HD getCx4_AssigningAuthority() {
       return getTyped(3, HD.class);
    }


    /**
     * Returns Identifier Type Code (component 5).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ID getIdentifierTypeCode() {
       return getTyped(4, ID.class);
    }

    
    /**
     * Returns Identifier Type Code (component 5).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ID getCx5_IdentifierTypeCode() {
       return getTyped(4, ID.class);
    }


    /**
     * Returns Assigning Facility (component 6).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public HD getAssigningFacility() {
       return getTyped(5, HD.class);
    }

    
    /**
     * Returns Assigning Facility (component 6).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public HD getCx6_AssigningFacility() {
       return getTyped(5, HD.class);
    }


    /**
     * Returns Effective Date (component 7).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public DT getEffectiveDate() {
       return getTyped(6, DT.class);
    }

    
    /**
     * Returns Effective Date (component 7).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public DT getCx7_EffectiveDate() {
       return getTyped(6, DT.class);
    }


    /**
     * Returns Expiration Date (component 8).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public DT getExpirationDate() {
       return getTyped(7, DT.class);
    }

    
    /**
     * Returns Expiration Date (component 8).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public DT getCx8_ExpirationDate() {
       return getTyped(7, DT.class);
    }


    /**
     * Returns Assigning Jurisdiction (component 9).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public CWE getAssigningJurisdiction() {
       return getTyped(8, CWE.class);
    }

    
    /**
     * Returns Assigning Jurisdiction (component 9).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public CWE getCx9_AssigningJurisdiction() {
       return getTyped(8, CWE.class);
    }


    /**
     * Returns Assigning Agency or Department (component 10).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public CWE getAssigningAgencyOrDepartment() {
       return getTyped(9, CWE.class);
    }

    
    /**
     * Returns Assigning Agency or Department (component 10).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public CWE getCx10_AssigningAgencyOrDepartment() {
       return getTyped(9, CWE.class);
    }


    /**
     * Returns Security Check (component 11).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ST getSecurityCheck() {
       return getTyped(10, ST.class);
    }

    
    /**
     * Returns Security Check (component 11).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ST getCx11_SecurityCheck() {
       return getTyped(10, ST.class);
    }


    /**
     * Returns Security Check Scheme (component 12).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ID getSecurityCheckScheme() {
       return getTyped(11, ID.class);
    }

    
    /**
     * Returns Security Check Scheme (component 12).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ID getCx12_SecurityCheckScheme() {
       return getTyped(11, ID.class);
    }



}

