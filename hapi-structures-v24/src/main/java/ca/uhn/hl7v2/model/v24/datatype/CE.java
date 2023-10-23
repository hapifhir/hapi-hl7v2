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
 * The Original Code is "CE.java".  Description:
 * "Composite class CE"
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

package ca.uhn.hl7v2.model.v24.datatype;

import ca.uhn.hl7v2.model.DataTypeException;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.Type;
import ca.uhn.hl7v2.model.AbstractComposite;


/**
 * <p>Represents an HL7 CE (coded element) data type. 
 * This type consists of the following components:</p>
 * <ul>
 * <li>identifier (ST) (ST)
 * <li>text (ST)
 * <li>name of coding system (IS)
 * <li>alternate identifier (ST) (ST)
 * <li>alternate text (ST)
 * <li>name of alternate coding system (IS)
 * </ul>
 */
@SuppressWarnings("unused")
public class CE extends AbstractComposite {

    private Type[] data;

    /** 
     * Creates a new CE type
     */
    public CE(Message message) {
        super(message);
        init();
    }

    private void init() {
        data = new Type[6];    
        data[0] = new ST(getMessage());
        data[1] = new ST(getMessage());
        data[2] = new IS(getMessage(), 0);
        data[3] = new ST(getMessage());
        data[4] = new ST(getMessage());
        data[5] = new IS(getMessage(), 0);
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
     * Returns identifier (ST) (component 1).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ST getIdentifier() {
       return getTyped(0, ST.class);
    }

    
    /**
     * Returns identifier (ST) (component 1).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ST getCe1_Identifier() {
       return getTyped(0, ST.class);
    }


    /**
     * Returns text (component 2).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ST getText() {
       return getTyped(1, ST.class);
    }

    
    /**
     * Returns text (component 2).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ST getCe2_Text() {
       return getTyped(1, ST.class);
    }


    /**
     * Returns name of coding system (component 3).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public IS getNameOfCodingSystem() {
       return getTyped(2, IS.class);
    }

    
    /**
     * Returns name of coding system (component 3).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public IS getCe3_NameOfCodingSystem() {
       return getTyped(2, IS.class);
    }


    /**
     * Returns alternate identifier (ST) (component 4).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ST getAlternateIdentifier() {
       return getTyped(3, ST.class);
    }

    
    /**
     * Returns alternate identifier (ST) (component 4).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ST getCe4_AlternateIdentifier() {
       return getTyped(3, ST.class);
    }


    /**
     * Returns alternate text (component 5).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ST getAlternateText() {
       return getTyped(4, ST.class);
    }

    
    /**
     * Returns alternate text (component 5).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ST getCe5_AlternateText() {
       return getTyped(4, ST.class);
    }


    /**
     * Returns name of alternate coding system (component 6).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public IS getNameOfAlternateCodingSystem() {
       return getTyped(5, IS.class);
    }

    
    /**
     * Returns name of alternate coding system (component 6).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public IS getCe6_NameOfAlternateCodingSystem() {
       return getTyped(5, IS.class);
    }



}

