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

package ca.uhn.hl7v2.model.v25.datatype;

import ca.uhn.hl7v2.model.DataTypeException;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.Type;
import ca.uhn.hl7v2.model.AbstractComposite;


/**
 * <p>Represents an HL7 PL (Person Location) data type. 
 * This type consists of the following components:</p>
 * <ul>
 * <li>Point of Care (IS)
 * <li>Room (IS)
 * <li>Bed (IS)
 * <li>Facility (HD)
 * <li>Location Status (IS)
 * <li>Person Location Type (IS)
 * <li>Building (IS)
 * <li>Floor (IS)
 * <li>Location Description (ST)
 * <li>Comprehensive Location Identifier (EI)
 * <li>Assigning Authority for Location (HD)
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
        data = new Type[11];    
        data[0] = new IS(getMessage(), 302);
        data[1] = new IS(getMessage(), 303);
        data[2] = new IS(getMessage(), 304);
        data[3] = new HD(getMessage());
        data[4] = new IS(getMessage(), 306);
        data[5] = new IS(getMessage(), 305);
        data[6] = new IS(getMessage(), 307);
        data[7] = new IS(getMessage(), 308);
        data[8] = new ST(getMessage());
        data[9] = new EI(getMessage());
        data[10] = new HD(getMessage());
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
     * Returns Point of Care (component 1).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public IS getPointOfCare() {
       return getTyped(0, IS.class);
    }

    
    /**
     * Returns Point of Care (component 1).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public IS getPl1_PointOfCare() {
       return getTyped(0, IS.class);
    }


    /**
     * Returns Room (component 2).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public IS getRoom() {
       return getTyped(1, IS.class);
    }

    
    /**
     * Returns Room (component 2).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public IS getPl2_Room() {
       return getTyped(1, IS.class);
    }


    /**
     * Returns Bed (component 3).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public IS getBed() {
       return getTyped(2, IS.class);
    }

    
    /**
     * Returns Bed (component 3).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public IS getPl3_Bed() {
       return getTyped(2, IS.class);
    }


    /**
     * Returns Facility (component 4).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public HD getFacility() {
       return getTyped(3, HD.class);
    }

    
    /**
     * Returns Facility (component 4).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public HD getPl4_Facility() {
       return getTyped(3, HD.class);
    }


    /**
     * Returns Location Status (component 5).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public IS getLocationStatus() {
       return getTyped(4, IS.class);
    }

    
    /**
     * Returns Location Status (component 5).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public IS getPl5_LocationStatus() {
       return getTyped(4, IS.class);
    }


    /**
     * Returns Person Location Type (component 6).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public IS getPersonLocationType() {
       return getTyped(5, IS.class);
    }

    
    /**
     * Returns Person Location Type (component 6).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public IS getPl6_PersonLocationType() {
       return getTyped(5, IS.class);
    }


    /**
     * Returns Building (component 7).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public IS getBuilding() {
       return getTyped(6, IS.class);
    }

    
    /**
     * Returns Building (component 7).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public IS getPl7_Building() {
       return getTyped(6, IS.class);
    }


    /**
     * Returns Floor (component 8).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public IS getFloor() {
       return getTyped(7, IS.class);
    }

    
    /**
     * Returns Floor (component 8).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public IS getPl8_Floor() {
       return getTyped(7, IS.class);
    }


    /**
     * Returns Location Description (component 9).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ST getLocationDescription() {
       return getTyped(8, ST.class);
    }

    
    /**
     * Returns Location Description (component 9).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ST getPl9_LocationDescription() {
       return getTyped(8, ST.class);
    }


    /**
     * Returns Comprehensive Location Identifier (component 10).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public EI getComprehensiveLocationIdentifier() {
       return getTyped(9, EI.class);
    }

    
    /**
     * Returns Comprehensive Location Identifier (component 10).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public EI getPl10_ComprehensiveLocationIdentifier() {
       return getTyped(9, EI.class);
    }


    /**
     * Returns Assigning Authority for Location (component 11).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public HD getAssigningAuthorityForLocation() {
       return getTyped(10, HD.class);
    }

    
    /**
     * Returns Assigning Authority for Location (component 11).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public HD getPl11_AssigningAuthorityForLocation() {
       return getTyped(10, HD.class);
    }



}

