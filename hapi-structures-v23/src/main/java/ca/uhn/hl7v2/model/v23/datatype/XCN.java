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

package ca.uhn.hl7v2.model.v23.datatype;

import ca.uhn.hl7v2.model.DataTypeException;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.Type;
import ca.uhn.hl7v2.model.AbstractComposite;


/**
 * <p>Represents an HL7 XCN (Extended Composite ID number and name (2.8.46)) data type. 
 * This type consists of the following components:</p>
 * <ul>
 * <li>ID number (ST) (ST)
 * <li>family name (ST)
 * <li>given name (ST)
 * <li>middle initial or name (ST)
 * <li>suffix (e.g., JR or III) (ST)
 * <li>prefix (e.g., DR) (ST)
 * <li>degree (e.g., MD) (ST)
 * <li>source table (ID)
 * <li>assigning authority (HD)
 * <li>name type (ID)
 * <li>identifier check digit (ST)
 * <li>code identifying the check digit scheme employed (ID)
 * <li>identifier type code (IS)
 * <li>assigning facility ID (HD)
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
        data = new Type[14];    
        data[0] = new ST(getMessage());
        data[1] = new ST(getMessage());
        data[2] = new ST(getMessage());
        data[3] = new ST(getMessage());
        data[4] = new ST(getMessage());
        data[5] = new ST(getMessage());
        data[6] = new ST(getMessage());
        data[7] = new ID(getMessage(), 0);
        data[8] = new HD(getMessage());
        data[9] = new ID(getMessage(), 0);
        data[10] = new ST(getMessage());
        data[11] = new ID(getMessage(), 0);
        data[12] = new IS(getMessage(), 0);
        data[13] = new HD(getMessage());
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
     * Returns ID number (ST) (component 1).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ST getIDNumber() {
       return getTyped(0, ST.class);
    }

    
    /**
     * Returns ID number (ST) (component 1).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ST getXcn1_IDNumber() {
       return getTyped(0, ST.class);
    }


    /**
     * Returns family name (component 2).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ST getFamilyName() {
       return getTyped(1, ST.class);
    }

    
    /**
     * Returns family name (component 2).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ST getXcn2_FamilyName() {
       return getTyped(1, ST.class);
    }


    /**
     * Returns given name (component 3).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ST getGivenName() {
       return getTyped(2, ST.class);
    }

    
    /**
     * Returns given name (component 3).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ST getXcn3_GivenName() {
       return getTyped(2, ST.class);
    }


    /**
     * Returns middle initial or name (component 4).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ST getMiddleInitialOrName() {
       return getTyped(3, ST.class);
    }

    
    /**
     * Returns middle initial or name (component 4).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ST getXcn4_MiddleInitialOrName() {
       return getTyped(3, ST.class);
    }


    /**
     * Returns suffix (e.g., JR or III) (component 5).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ST getSuffixEgJRorIII() {
       return getTyped(4, ST.class);
    }

    
    /**
     * Returns suffix (e.g., JR or III) (component 5).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ST getXcn5_SuffixEgJRorIII() {
       return getTyped(4, ST.class);
    }


    /**
     * Returns prefix (e.g., DR) (component 6).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ST getPrefixEgDR() {
       return getTyped(5, ST.class);
    }

    
    /**
     * Returns prefix (e.g., DR) (component 6).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ST getXcn6_PrefixEgDR() {
       return getTyped(5, ST.class);
    }


    /**
     * Returns degree (e.g., MD) (component 7).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ST getDegreeEgMD() {
       return getTyped(6, ST.class);
    }

    
    /**
     * Returns degree (e.g., MD) (component 7).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ST getXcn7_DegreeEgMD() {
       return getTyped(6, ST.class);
    }


    /**
     * Returns source table (component 8).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ID getSourceTable() {
       return getTyped(7, ID.class);
    }

    
    /**
     * Returns source table (component 8).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ID getXcn8_SourceTable() {
       return getTyped(7, ID.class);
    }


    /**
     * Returns assigning authority (component 9).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public HD getAssigningAuthority() {
       return getTyped(8, HD.class);
    }

    
    /**
     * Returns assigning authority (component 9).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public HD getXcn9_AssigningAuthority() {
       return getTyped(8, HD.class);
    }


    /**
     * Returns name type (component 10).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ID getNameType() {
       return getTyped(9, ID.class);
    }

    
    /**
     * Returns name type (component 10).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ID getXcn10_NameType() {
       return getTyped(9, ID.class);
    }


    /**
     * Returns identifier check digit (component 11).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ST getIdentifierCheckDigit() {
       return getTyped(10, ST.class);
    }

    
    /**
     * Returns identifier check digit (component 11).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ST getXcn11_IdentifierCheckDigit() {
       return getTyped(10, ST.class);
    }


    /**
     * Returns code identifying the check digit scheme employed (component 12).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ID getCodeIdentifyingTheCheckDigitSchemeEmployed() {
       return getTyped(11, ID.class);
    }

    
    /**
     * Returns code identifying the check digit scheme employed (component 12).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ID getXcn12_CodeIdentifyingTheCheckDigitSchemeEmployed() {
       return getTyped(11, ID.class);
    }


    /**
     * Returns identifier type code (component 13).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public IS getIdentifierTypeCode() {
       return getTyped(12, IS.class);
    }

    
    /**
     * Returns identifier type code (component 13).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public IS getXcn13_IdentifierTypeCode() {
       return getTyped(12, IS.class);
    }


    /**
     * Returns assigning facility ID (component 14).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public HD getAssigningFacilityID() {
       return getTyped(13, HD.class);
    }

    
    /**
     * Returns assigning facility ID (component 14).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public HD getXcn14_AssigningFacilityID() {
       return getTyped(13, HD.class);
    }



}

