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
 * The Original Code is "FN.java".  Description:
 * "Composite class FN"
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
 * <p>Represents an HL7 FN (Family Name) data type. 
 * This type consists of the following components:</p>
 * <ul>
 * <li>Surname (ST)
 * <li>Own Surname Prefix (ST)
 * <li>Own Surname (ST)
 * <li>Surname Prefix from Partner/Spouse (ST)
 * <li>Surname from Partner/Spouse (ST)
 * </ul>
 */
@SuppressWarnings("unused")
public class FN extends AbstractComposite {

    private Type[] data;

    /** 
     * Creates a new FN type
     */
    public FN(Message message) {
        super(message);
        init();
    }

    private void init() {
        data = new Type[5];    
        data[0] = new ST(getMessage());
        data[1] = new ST(getMessage());
        data[2] = new ST(getMessage());
        data[3] = new ST(getMessage());
        data[4] = new ST(getMessage());
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
     * Returns Surname (component 1).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ST getSurname() {
       return getTyped(0, ST.class);
    }

    
    /**
     * Returns Surname (component 1).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ST getFn1_Surname() {
       return getTyped(0, ST.class);
    }


    /**
     * Returns Own Surname Prefix (component 2).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ST getOwnSurnamePrefix() {
       return getTyped(1, ST.class);
    }

    
    /**
     * Returns Own Surname Prefix (component 2).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ST getFn2_OwnSurnamePrefix() {
       return getTyped(1, ST.class);
    }


    /**
     * Returns Own Surname (component 3).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ST getOwnSurname() {
       return getTyped(2, ST.class);
    }

    
    /**
     * Returns Own Surname (component 3).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ST getFn3_OwnSurname() {
       return getTyped(2, ST.class);
    }


    /**
     * Returns Surname Prefix from Partner/Spouse (component 4).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ST getSurnamePrefixFromPartnerSpouse() {
       return getTyped(3, ST.class);
    }

    
    /**
     * Returns Surname Prefix from Partner/Spouse (component 4).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ST getFn4_SurnamePrefixFromPartnerSpouse() {
       return getTyped(3, ST.class);
    }


    /**
     * Returns Surname from Partner/Spouse (component 5).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ST getSurnameFromPartnerSpouse() {
       return getTyped(4, ST.class);
    }

    
    /**
     * Returns Surname from Partner/Spouse (component 5).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ST getFn5_SurnameFromPartnerSpouse() {
       return getTyped(4, ST.class);
    }



}

