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
 * The Original Code is "NDL.java".  Description:
 * "Composite class NDL"
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
 * <p>Represents an HL7 NDL (observing practitioner) data type. 
 * This type consists of the following components:</p>
 * <ul>
 * <li>OP name (CN)
 * <li>start date/time (TS)
 * <li>end date/time (TS)
 * <li>point of care (IS) (IS)
 * <li>room (IS)
 * <li>bed (IS)
 * <li>facility (HD) (HD)
 * <li>location status (IS)
 * <li>person location type (IS)
 * <li>building (IS)
 * <li>floor (IS)
 * </ul>
 */
@SuppressWarnings("unused")
public class NDL extends AbstractComposite {

    private Type[] data;

    /** 
     * Creates a new NDL type
     */
    public NDL(Message message) {
        super(message);
        init();
    }

    private void init() {
        data = new Type[11];    
        data[0] = new CN(getMessage());
        data[1] = new TS(getMessage());
        data[2] = new TS(getMessage());
        data[3] = new IS(getMessage(), 0);
        data[4] = new IS(getMessage(), 0);
        data[5] = new IS(getMessage(), 0);
        data[6] = new HD(getMessage());
        data[7] = new IS(getMessage(), 0);
        data[8] = new IS(getMessage(), 0);
        data[9] = new IS(getMessage(), 0);
        data[10] = new IS(getMessage(), 0);
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
     * Returns OP name (component 1).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public CN getOPName() {
       return getTyped(0, CN.class);
    }

    
    /**
     * Returns OP name (component 1).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public CN getNdl1_OPName() {
       return getTyped(0, CN.class);
    }


    /**
     * Returns start date/time (component 2).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public TS getStartDateTime() {
       return getTyped(1, TS.class);
    }

    
    /**
     * Returns start date/time (component 2).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public TS getNdl2_StartDateTime() {
       return getTyped(1, TS.class);
    }


    /**
     * Returns end date/time (component 3).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public TS getEndDateTime() {
       return getTyped(2, TS.class);
    }

    
    /**
     * Returns end date/time (component 3).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public TS getNdl3_EndDateTime() {
       return getTyped(2, TS.class);
    }


    /**
     * Returns point of care (IS) (component 4).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public IS getPointOfCare() {
       return getTyped(3, IS.class);
    }

    
    /**
     * Returns point of care (IS) (component 4).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public IS getNdl4_PointOfCare() {
       return getTyped(3, IS.class);
    }


    /**
     * Returns room (component 5).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public IS getRoom() {
       return getTyped(4, IS.class);
    }

    
    /**
     * Returns room (component 5).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public IS getNdl5_Room() {
       return getTyped(4, IS.class);
    }


    /**
     * Returns bed (component 6).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public IS getBed() {
       return getTyped(5, IS.class);
    }

    
    /**
     * Returns bed (component 6).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public IS getNdl6_Bed() {
       return getTyped(5, IS.class);
    }


    /**
     * Returns facility (HD) (component 7).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public HD getFacility() {
       return getTyped(6, HD.class);
    }

    
    /**
     * Returns facility (HD) (component 7).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public HD getNdl7_Facility() {
       return getTyped(6, HD.class);
    }


    /**
     * Returns location status (component 8).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public IS getLocationStatus() {
       return getTyped(7, IS.class);
    }

    
    /**
     * Returns location status (component 8).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public IS getNdl8_LocationStatus() {
       return getTyped(7, IS.class);
    }


    /**
     * Returns person location type (component 9).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public IS getPersonLocationType() {
       return getTyped(8, IS.class);
    }

    
    /**
     * Returns person location type (component 9).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public IS getNdl9_PersonLocationType() {
       return getTyped(8, IS.class);
    }


    /**
     * Returns building (component 10).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public IS getBuilding() {
       return getTyped(9, IS.class);
    }

    
    /**
     * Returns building (component 10).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public IS getNdl10_Building() {
       return getTyped(9, IS.class);
    }


    /**
     * Returns floor (component 11).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public IS getFloor() {
       return getTyped(10, IS.class);
    }

    
    /**
     * Returns floor (component 11).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public IS getNdl11_Floor() {
       return getTyped(10, IS.class);
    }



}

