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
 * The Original Code is "XTN.java".  Description:
 * "Composite class XTN"
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
 * <p>Represents an HL7 XTN (extended telecommunication number) data type. 
 * This type consists of the following components:</p>
 * <ul>
 * <li>[(999)] 999-9999 [X99999][C any text] (TN)
 * <li>telecommunication use code (ID)
 * <li>telecommunication equipment type (ID) (ID)
 * <li>Email address (ST)
 * <li>Country Code (NM)
 * <li>Area/city code (NM)
 * <li>Phone number (NM)
 * <li>Extension (NM)
 * <li>any text (ST)
 * </ul>
 */
@SuppressWarnings("unused")
public class XTN extends AbstractComposite {

    private Type[] data;

    /** 
     * Creates a new XTN type
     */
    public XTN(Message message) {
        super(message);
        init();
    }

    private void init() {
        data = new Type[9];    
        data[0] = new TN(getMessage());
        data[1] = new ID(getMessage(), 0);
        data[2] = new ID(getMessage(), 0);
        data[3] = new ST(getMessage());
        data[4] = new NM(getMessage());
        data[5] = new NM(getMessage());
        data[6] = new NM(getMessage());
        data[7] = new NM(getMessage());
        data[8] = new ST(getMessage());
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
     * Returns [(999)] 999-9999 [X99999][C any text] (component 1).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public TN get9999999X99999CAnyText() {
       return getTyped(0, TN.class);
    }

    
    /**
     * Returns [(999)] 999-9999 [X99999][C any text] (component 1).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public TN getXtn1_9999999X99999CAnyText() {
       return getTyped(0, TN.class);
    }


    /**
     * Returns telecommunication use code (component 2).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ID getTelecommunicationUseCode() {
       return getTyped(1, ID.class);
    }

    
    /**
     * Returns telecommunication use code (component 2).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ID getXtn2_TelecommunicationUseCode() {
       return getTyped(1, ID.class);
    }


    /**
     * Returns telecommunication equipment type (ID) (component 3).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ID getTelecommunicationEquipmentType() {
       return getTyped(2, ID.class);
    }

    
    /**
     * Returns telecommunication equipment type (ID) (component 3).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ID getXtn3_TelecommunicationEquipmentType() {
       return getTyped(2, ID.class);
    }


    /**
     * Returns Email address (component 4).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ST getEmailAddress() {
       return getTyped(3, ST.class);
    }

    
    /**
     * Returns Email address (component 4).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ST getXtn4_EmailAddress() {
       return getTyped(3, ST.class);
    }


    /**
     * Returns Country Code (component 5).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public NM getCountryCode() {
       return getTyped(4, NM.class);
    }

    
    /**
     * Returns Country Code (component 5).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public NM getXtn5_CountryCode() {
       return getTyped(4, NM.class);
    }


    /**
     * Returns Area/city code (component 6).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public NM getAreaCityCode() {
       return getTyped(5, NM.class);
    }

    
    /**
     * Returns Area/city code (component 6).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public NM getXtn6_AreaCityCode() {
       return getTyped(5, NM.class);
    }


    /**
     * Returns Phone number (component 7).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public NM getPhoneNumber() {
       return getTyped(6, NM.class);
    }

    
    /**
     * Returns Phone number (component 7).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public NM getXtn7_PhoneNumber() {
       return getTyped(6, NM.class);
    }


    /**
     * Returns Extension (component 8).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public NM getExtension() {
       return getTyped(7, NM.class);
    }

    
    /**
     * Returns Extension (component 8).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public NM getXtn8_Extension() {
       return getTyped(7, NM.class);
    }


    /**
     * Returns any text (component 9).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ST getAnyText() {
       return getTyped(8, ST.class);
    }

    
    /**
     * Returns any text (component 9).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ST getXtn9_AnyText() {
       return getTyped(8, ST.class);
    }



}

