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
 * The Original Code is "CF.java".  Description:
 * "Composite class CF"
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

package ca.uhn.hl7v2.model.v26.datatype;

import ca.uhn.hl7v2.model.DataTypeException;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.Type;
import ca.uhn.hl7v2.model.AbstractComposite;


/**
 * <p>Represents an HL7 CF (Coded Element with Formatted Values) data type. 
 * This type consists of the following components:</p>
 * <ul>
 * <li>Identifier (ST)
 * <li>Formatted Text (FT)
 * <li>Name of Coding System (ID)
 * <li>Alternate Identifier (ST)
 * <li>Alternate Formatted Text (FT)
 * <li>Name of Alternate Coding System (ID)
 * </ul>
 */
@SuppressWarnings("unused")
public class CF extends AbstractComposite {

    private Type[] data;

    /** 
     * Creates a new CF type
     */
    public CF(Message message) {
        super(message);
        init();
    }

    private void init() {
        data = new Type[6];    
        data[0] = new ST(getMessage());
        data[1] = new FT(getMessage());
        data[2] = new ID(getMessage(), 396);
        data[3] = new ST(getMessage());
        data[4] = new FT(getMessage());
        data[5] = new ID(getMessage(), 396);
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
    public ST getCf1_Identifier() {
       return getTyped(0, ST.class);
    }


    /**
     * Returns Formatted Text (component 2).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public FT getFormattedText() {
       return getTyped(1, FT.class);
    }

    
    /**
     * Returns Formatted Text (component 2).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public FT getCf2_FormattedText() {
       return getTyped(1, FT.class);
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
    public ID getCf3_NameOfCodingSystem() {
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
    public ST getCf4_AlternateIdentifier() {
       return getTyped(3, ST.class);
    }


    /**
     * Returns Alternate Formatted Text (component 5).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public FT getAlternateFormattedText() {
       return getTyped(4, FT.class);
    }

    
    /**
     * Returns Alternate Formatted Text (component 5).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public FT getCf5_AlternateFormattedText() {
       return getTyped(4, FT.class);
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
    public ID getCf6_NameOfAlternateCodingSystem() {
       return getTyped(5, ID.class);
    }



}

