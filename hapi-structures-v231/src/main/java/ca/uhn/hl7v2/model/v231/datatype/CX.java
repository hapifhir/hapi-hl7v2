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

package ca.uhn.hl7v2.model.v231.datatype;

import ca.uhn.hl7v2.model.DataTypeException;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.Type;
import ca.uhn.hl7v2.model.AbstractComposite;


/**
 * <p>Represents an HL7 CX (extended composite ID with check digit) data type. 
 * This type consists of the following components:</p>
 * <ul>
 * <li>ID (ST)
 * <li>check digit (ST)
 * <li>code identifying the check digit scheme employed (ID)
 * <li>assigning authority (HD)
 * <li>identifier type code (IS)
 * <li>assigning facility (HD)
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
        data = new Type[6];    
        data[0] = new ST(getMessage());
        data[1] = new ST(getMessage());
        data[2] = new ID(getMessage(), 0);
        data[3] = new HD(getMessage());
        data[4] = new IS(getMessage(), 203);
        data[5] = new HD(getMessage());
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
     * Returns ID (component 1).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ST getID() {
       return getTyped(0, ST.class);
    }

    
    /**
     * Returns ID (component 1).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ST getCx1_ID() {
       return getTyped(0, ST.class);
    }


    /**
     * Returns check digit (component 2).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ST getCheckDigit() {
       return getTyped(1, ST.class);
    }

    
    /**
     * Returns check digit (component 2).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ST getCx2_CheckDigit() {
       return getTyped(1, ST.class);
    }


    /**
     * Returns code identifying the check digit scheme employed (component 3).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ID getCodeIdentifyingTheCheckDigitSchemeEmployed() {
       return getTyped(2, ID.class);
    }

    
    /**
     * Returns code identifying the check digit scheme employed (component 3).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ID getCx3_CodeIdentifyingTheCheckDigitSchemeEmployed() {
       return getTyped(2, ID.class);
    }


    /**
     * Returns assigning authority (component 4).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public HD getAssigningAuthority() {
       return getTyped(3, HD.class);
    }

    
    /**
     * Returns assigning authority (component 4).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public HD getCx4_AssigningAuthority() {
       return getTyped(3, HD.class);
    }


    /**
     * Returns identifier type code (component 5).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public IS getIdentifierTypeCode() {
       return getTyped(4, IS.class);
    }

    
    /**
     * Returns identifier type code (component 5).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public IS getCx5_IdentifierTypeCode() {
       return getTyped(4, IS.class);
    }


    /**
     * Returns assigning facility (component 6).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public HD getAssigningFacility() {
       return getTyped(5, HD.class);
    }

    
    /**
     * Returns assigning facility (component 6).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public HD getCx6_AssigningFacility() {
       return getTyped(5, HD.class);
    }



}

