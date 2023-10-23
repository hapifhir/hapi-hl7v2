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
 * The Original Code is "PL.java".  Description:
 * "Composite class PL"
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
 * <p>Represents an HL7 PL (person location) data type. 
 * This type consists of the following components:</p>
 * <ul>
 * <li>point of care (ID) (ID)
 * <li>room (IS)
 * <li>bed (IS)
 * <li>facility (HD) (HD)
 * <li>location status (IS)
 * <li>person location type (IS)
 * <li>building (IS)
 * <li>floor (ST)
 * <li>Location type (ST)
 * </ul>
 */
@SuppressWarnings("unused")
public class PL extends AbstractComposite {

    private Type[] data;

    /** 
     * Creates a new PL type
     */
    public PL(Message message) {
        super(message);
        init();
    }

    private void init() {
        data = new Type[9];    
        data[0] = new ID(getMessage(), 0);
        data[1] = new IS(getMessage(), 0);
        data[2] = new IS(getMessage(), 0);
        data[3] = new HD(getMessage());
        data[4] = new IS(getMessage(), 0);
        data[5] = new IS(getMessage(), 0);
        data[6] = new IS(getMessage(), 0);
        data[7] = new ST(getMessage());
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
     * Returns point of care (ID) (component 1).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ID getPointOfCare() {
       return getTyped(0, ID.class);
    }

    
    /**
     * Returns point of care (ID) (component 1).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ID getPl1_PointOfCare() {
       return getTyped(0, ID.class);
    }


    /**
     * Returns room (component 2).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public IS getRoom() {
       return getTyped(1, IS.class);
    }

    
    /**
     * Returns room (component 2).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public IS getPl2_Room() {
       return getTyped(1, IS.class);
    }


    /**
     * Returns bed (component 3).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public IS getBed() {
       return getTyped(2, IS.class);
    }

    
    /**
     * Returns bed (component 3).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public IS getPl3_Bed() {
       return getTyped(2, IS.class);
    }


    /**
     * Returns facility (HD) (component 4).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public HD getFacility() {
       return getTyped(3, HD.class);
    }

    
    /**
     * Returns facility (HD) (component 4).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public HD getPl4_Facility() {
       return getTyped(3, HD.class);
    }


    /**
     * Returns location status (component 5).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public IS getLocationStatus() {
       return getTyped(4, IS.class);
    }

    
    /**
     * Returns location status (component 5).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public IS getPl5_LocationStatus() {
       return getTyped(4, IS.class);
    }


    /**
     * Returns person location type (component 6).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public IS getPersonLocationType() {
       return getTyped(5, IS.class);
    }

    
    /**
     * Returns person location type (component 6).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public IS getPl6_PersonLocationType() {
       return getTyped(5, IS.class);
    }


    /**
     * Returns building (component 7).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public IS getBuilding() {
       return getTyped(6, IS.class);
    }

    
    /**
     * Returns building (component 7).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public IS getPl7_Building() {
       return getTyped(6, IS.class);
    }


    /**
     * Returns floor (component 8).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ST getFloor() {
       return getTyped(7, ST.class);
    }

    
    /**
     * Returns floor (component 8).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ST getPl8_Floor() {
       return getTyped(7, ST.class);
    }


    /**
     * Returns Location type (component 9).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ST getLocationType() {
       return getTyped(8, ST.class);
    }

    
    /**
     * Returns Location type (component 9).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ST getPl9_LocationType() {
       return getTyped(8, ST.class);
    }



}

