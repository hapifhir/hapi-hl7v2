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
 * The Original Code is "XON.java".  Description:
 * "Composite class XON"
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

package ca.uhn.hl7v2.model.v23.datatype;

import ca.uhn.hl7v2.model.DataTypeException;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.Type;
import ca.uhn.hl7v2.model.AbstractComposite;


/**
 * <p>Represents an HL7 XON (Extended Composite Name and ID for organizations (2.8.47)) data type. 
 * This type consists of the following components:</p>
 * <ul>
 * <li>organization name (ST)
 * <li>organization name type code (IS)
 * <li>ID number (NM) (NM)
 * <li>check digit (ST)
 * <li>code identifying the check digit scheme employed (ID)
 * <li>assigning authority (HD)
 * <li>identifier type code (IS)
 * <li>assigning facility ID (HD)
 * </ul>
 */
@SuppressWarnings("unused")
public class XON extends AbstractComposite {

    private Type[] data;

    /** 
     * Creates a new XON type
     */
    public XON(Message message) {
        super(message);
        init();
    }

    private void init() {
        data = new Type[8];    
        data[0] = new ST(getMessage());
        data[1] = new IS(getMessage(), 0);
        data[2] = new NM(getMessage());
        data[3] = new ST(getMessage());
        data[4] = new ID(getMessage(), 0);
        data[5] = new HD(getMessage());
        data[6] = new IS(getMessage(), 0);
        data[7] = new HD(getMessage());
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
     * Returns organization name (component 1).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ST getOrganizationName() {
       return getTyped(0, ST.class);
    }

    
    /**
     * Returns organization name (component 1).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ST getXon1_OrganizationName() {
       return getTyped(0, ST.class);
    }


    /**
     * Returns organization name type code (component 2).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public IS getOrganizationNameTypeCode() {
       return getTyped(1, IS.class);
    }

    
    /**
     * Returns organization name type code (component 2).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public IS getXon2_OrganizationNameTypeCode() {
       return getTyped(1, IS.class);
    }


    /**
     * Returns ID number (NM) (component 3).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public NM getIDNumber() {
       return getTyped(2, NM.class);
    }

    
    /**
     * Returns ID number (NM) (component 3).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public NM getXon3_IDNumber() {
       return getTyped(2, NM.class);
    }


    /**
     * Returns check digit (component 4).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ST getCheckDigit() {
       return getTyped(3, ST.class);
    }

    
    /**
     * Returns check digit (component 4).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ST getXon4_CheckDigit() {
       return getTyped(3, ST.class);
    }


    /**
     * Returns code identifying the check digit scheme employed (component 5).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ID getCodeIdentifyingTheCheckDigitSchemeEmployed() {
       return getTyped(4, ID.class);
    }

    
    /**
     * Returns code identifying the check digit scheme employed (component 5).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ID getXon5_CodeIdentifyingTheCheckDigitSchemeEmployed() {
       return getTyped(4, ID.class);
    }


    /**
     * Returns assigning authority (component 6).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public HD getAssigningAuthority() {
       return getTyped(5, HD.class);
    }

    
    /**
     * Returns assigning authority (component 6).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public HD getXon6_AssigningAuthority() {
       return getTyped(5, HD.class);
    }


    /**
     * Returns identifier type code (component 7).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public IS getIdentifierTypeCode() {
       return getTyped(6, IS.class);
    }

    
    /**
     * Returns identifier type code (component 7).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public IS getXon7_IdentifierTypeCode() {
       return getTyped(6, IS.class);
    }


    /**
     * Returns assigning facility ID (component 8).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public HD getAssigningFacilityID() {
       return getTyped(7, HD.class);
    }

    
    /**
     * Returns assigning facility ID (component 8).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public HD getXon8_AssigningFacilityID() {
       return getTyped(7, HD.class);
    }



}

