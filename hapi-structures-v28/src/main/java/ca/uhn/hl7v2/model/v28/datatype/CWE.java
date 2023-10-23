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
 * The Original Code is "CWE.java".  Description:
 * "Composite class CWE"
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
 * <p>Represents an HL7 CWE (Coded with Exceptions) data type. 
 * This type consists of the following components:</p>
 * <ul>
 * <li>Identifier (ST)
 * <li>Text (ST)
 * <li>Name of Coding System (ID)
 * <li>Alternate Identifier (ST)
 * <li>Alternate Text (ST)
 * <li>Name of Alternate Coding System (ID)
 * <li>Coding System Version ID (ST)
 * <li>Alternate Coding System Version ID (ST)
 * <li>Original Text (ST)
 * <li>Second Alternate Identifier (ST)
 * <li>Second Alternate Text (ST)
 * <li>Name of Second Alternate Coding System (ID)
 * <li>Second Alternate Coding System Version ID (ST)
 * <li>Coding System OID (ST)
 * <li>Value Set OID (ST)
 * <li>Value Set Version ID (DTM)
 * <li>Alternate Coding System OID (ST)
 * <li>Alternate Value Set OID (ST)
 * <li>Alternate Value Set Version ID (DTM)
 * <li>Second Alternate Coding System OID (ST)
 * <li>Second Alternate Value Set OID (ST)
 * <li>Second Alternate Value Set Version ID (DTM)
 * </ul>
 */
@SuppressWarnings("unused")
public class CWE extends AbstractComposite {

    private Type[] data;

    /** 
     * Creates a new CWE type
     */
    public CWE(Message message) {
        super(message);
        init();
    }

    private void init() {
        data = new Type[22];    
        data[0] = new ST(getMessage());
        data[1] = new ST(getMessage());
        data[2] = new ID(getMessage(), 396);
        data[3] = new ST(getMessage());
        data[4] = new ST(getMessage());
        data[5] = new ID(getMessage(), 396);
        data[6] = new ST(getMessage());
        data[7] = new ST(getMessage());
        data[8] = new ST(getMessage());
        data[9] = new ST(getMessage());
        data[10] = new ST(getMessage());
        data[11] = new ID(getMessage(), 396);
        data[12] = new ST(getMessage());
        data[13] = new ST(getMessage());
        data[14] = new ST(getMessage());
        data[15] = new DTM(getMessage());
        data[16] = new ST(getMessage());
        data[17] = new ST(getMessage());
        data[18] = new DTM(getMessage());
        data[19] = new ST(getMessage());
        data[20] = new ST(getMessage());
        data[21] = new DTM(getMessage());
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
     * Returns Identifier (component 1).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ST getIdentifier() {
       return getTyped(0, ST.class);
    }

    
    /**
     * Returns Identifier (component 1).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ST getCwe1_Identifier() {
       return getTyped(0, ST.class);
    }


    /**
     * Returns Text (component 2).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ST getText() {
       return getTyped(1, ST.class);
    }

    
    /**
     * Returns Text (component 2).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ST getCwe2_Text() {
       return getTyped(1, ST.class);
    }


    /**
     * Returns Name of Coding System (component 3).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ID getNameOfCodingSystem() {
       return getTyped(2, ID.class);
    }

    
    /**
     * Returns Name of Coding System (component 3).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ID getCwe3_NameOfCodingSystem() {
       return getTyped(2, ID.class);
    }


    /**
     * Returns Alternate Identifier (component 4).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ST getAlternateIdentifier() {
       return getTyped(3, ST.class);
    }

    
    /**
     * Returns Alternate Identifier (component 4).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ST getCwe4_AlternateIdentifier() {
       return getTyped(3, ST.class);
    }


    /**
     * Returns Alternate Text (component 5).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ST getAlternateText() {
       return getTyped(4, ST.class);
    }

    
    /**
     * Returns Alternate Text (component 5).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ST getCwe5_AlternateText() {
       return getTyped(4, ST.class);
    }


    /**
     * Returns Name of Alternate Coding System (component 6).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ID getNameOfAlternateCodingSystem() {
       return getTyped(5, ID.class);
    }

    
    /**
     * Returns Name of Alternate Coding System (component 6).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ID getCwe6_NameOfAlternateCodingSystem() {
       return getTyped(5, ID.class);
    }


    /**
     * Returns Coding System Version ID (component 7).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ST getCodingSystemVersionID() {
       return getTyped(6, ST.class);
    }

    
    /**
     * Returns Coding System Version ID (component 7).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ST getCwe7_CodingSystemVersionID() {
       return getTyped(6, ST.class);
    }


    /**
     * Returns Alternate Coding System Version ID (component 8).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ST getAlternateCodingSystemVersionID() {
       return getTyped(7, ST.class);
    }

    
    /**
     * Returns Alternate Coding System Version ID (component 8).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ST getCwe8_AlternateCodingSystemVersionID() {
       return getTyped(7, ST.class);
    }


    /**
     * Returns Original Text (component 9).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ST getOriginalText() {
       return getTyped(8, ST.class);
    }

    
    /**
     * Returns Original Text (component 9).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ST getCwe9_OriginalText() {
       return getTyped(8, ST.class);
    }


    /**
     * Returns Second Alternate Identifier (component 10).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ST getSecondAlternateIdentifier() {
       return getTyped(9, ST.class);
    }

    
    /**
     * Returns Second Alternate Identifier (component 10).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ST getCwe10_SecondAlternateIdentifier() {
       return getTyped(9, ST.class);
    }


    /**
     * Returns Second Alternate Text (component 11).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ST getSecondAlternateText() {
       return getTyped(10, ST.class);
    }

    
    /**
     * Returns Second Alternate Text (component 11).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ST getCwe11_SecondAlternateText() {
       return getTyped(10, ST.class);
    }


    /**
     * Returns Name of Second Alternate Coding System (component 12).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ID getNameOfSecondAlternateCodingSystem() {
       return getTyped(11, ID.class);
    }

    
    /**
     * Returns Name of Second Alternate Coding System (component 12).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ID getCwe12_NameOfSecondAlternateCodingSystem() {
       return getTyped(11, ID.class);
    }


    /**
     * Returns Second Alternate Coding System Version ID (component 13).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ST getSecondAlternateCodingSystemVersionID() {
       return getTyped(12, ST.class);
    }

    
    /**
     * Returns Second Alternate Coding System Version ID (component 13).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ST getCwe13_SecondAlternateCodingSystemVersionID() {
       return getTyped(12, ST.class);
    }


    /**
     * Returns Coding System OID (component 14).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ST getCodingSystemOID() {
       return getTyped(13, ST.class);
    }

    
    /**
     * Returns Coding System OID (component 14).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ST getCwe14_CodingSystemOID() {
       return getTyped(13, ST.class);
    }


    /**
     * Returns Value Set OID (component 15).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ST getValueSetOID() {
       return getTyped(14, ST.class);
    }

    
    /**
     * Returns Value Set OID (component 15).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ST getCwe15_ValueSetOID() {
       return getTyped(14, ST.class);
    }


    /**
     * Returns Value Set Version ID (component 16).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public DTM getValueSetVersionID() {
       return getTyped(15, DTM.class);
    }

    
    /**
     * Returns Value Set Version ID (component 16).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public DTM getCwe16_ValueSetVersionID() {
       return getTyped(15, DTM.class);
    }


    /**
     * Returns Alternate Coding System OID (component 17).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ST getAlternateCodingSystemOID() {
       return getTyped(16, ST.class);
    }

    
    /**
     * Returns Alternate Coding System OID (component 17).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ST getCwe17_AlternateCodingSystemOID() {
       return getTyped(16, ST.class);
    }


    /**
     * Returns Alternate Value Set OID (component 18).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ST getAlternateValueSetOID() {
       return getTyped(17, ST.class);
    }

    
    /**
     * Returns Alternate Value Set OID (component 18).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ST getCwe18_AlternateValueSetOID() {
       return getTyped(17, ST.class);
    }


    /**
     * Returns Alternate Value Set Version ID (component 19).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public DTM getAlternateValueSetVersionID() {
       return getTyped(18, DTM.class);
    }

    
    /**
     * Returns Alternate Value Set Version ID (component 19).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public DTM getCwe19_AlternateValueSetVersionID() {
       return getTyped(18, DTM.class);
    }


    /**
     * Returns Second Alternate Coding System OID (component 20).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ST getSecondAlternateCodingSystemOID() {
       return getTyped(19, ST.class);
    }

    
    /**
     * Returns Second Alternate Coding System OID (component 20).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ST getCwe20_SecondAlternateCodingSystemOID() {
       return getTyped(19, ST.class);
    }


    /**
     * Returns Second Alternate Value Set OID (component 21).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ST getSecondAlternateValueSetOID() {
       return getTyped(20, ST.class);
    }

    
    /**
     * Returns Second Alternate Value Set OID (component 21).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ST getCwe21_SecondAlternateValueSetOID() {
       return getTyped(20, ST.class);
    }


    /**
     * Returns Second Alternate Value Set Version ID (component 22).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public DTM getSecondAlternateValueSetVersionID() {
       return getTyped(21, DTM.class);
    }

    
    /**
     * Returns Second Alternate Value Set Version ID (component 22).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public DTM getCwe22_SecondAlternateValueSetVersionID() {
       return getTyped(21, DTM.class);
    }



}

