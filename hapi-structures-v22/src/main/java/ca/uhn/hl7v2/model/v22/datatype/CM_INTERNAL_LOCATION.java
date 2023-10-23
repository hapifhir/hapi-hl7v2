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
 * The Original Code is "CM_INTERNAL_LOCATION.java".  Description:
 * "Composite class CM_INTERNAL_LOCATION"
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

package ca.uhn.hl7v2.model.v22.datatype;

import ca.uhn.hl7v2.model.DataTypeException;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.Type;
import ca.uhn.hl7v2.model.AbstractComposite;


/**
 * <p>Represents an HL7 CM_INTERNAL_LOCATION (CM für Ortsangaben im Krankenhaus) data type. 
 * This type consists of the following components:</p>
 * <ul>
 * <li>nurse unit (Station) (ID)
 * <li>Room (ID)
 * <li>Bed (ID)
 * <li>Facility ID (ID)
 * <li>Bed Status (ID)
 * <li>Etage (ID)
 * <li>Klinik (ID)
 * <li>Zentrum (ID)
 * </ul>
 */
@SuppressWarnings("unused")
public class CM_INTERNAL_LOCATION extends AbstractComposite {

    private Type[] data;

    /** 
     * Creates a new CM_INTERNAL_LOCATION type
     */
    public CM_INTERNAL_LOCATION(Message message) {
        super(message);
        init();
    }

    private void init() {
        data = new Type[8];    
        data[0] = new ID(getMessage(), 0);
        data[1] = new ID(getMessage(), 0);
        data[2] = new ID(getMessage(), 0);
        data[3] = new ID(getMessage(), 0);
        data[4] = new ID(getMessage(), 0);
        data[5] = new ID(getMessage(), 0);
        data[6] = new ID(getMessage(), 0);
        data[7] = new ID(getMessage(), 0);
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
     * Returns nurse unit (Station) (component 1).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ID getNurseUnitStation() {
       return getTyped(0, ID.class);
    }

    
    /**
     * Returns nurse unit (Station) (component 1).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ID getCm_internal_location1_NurseUnitStation() {
       return getTyped(0, ID.class);
    }


    /**
     * Returns Room (component 2).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ID getRoom() {
       return getTyped(1, ID.class);
    }

    
    /**
     * Returns Room (component 2).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ID getCm_internal_location2_Room() {
       return getTyped(1, ID.class);
    }


    /**
     * Returns Bed (component 3).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ID getBed() {
       return getTyped(2, ID.class);
    }

    
    /**
     * Returns Bed (component 3).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ID getCm_internal_location3_Bed() {
       return getTyped(2, ID.class);
    }


    /**
     * Returns Facility ID (component 4).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ID getFacilityID() {
       return getTyped(3, ID.class);
    }

    
    /**
     * Returns Facility ID (component 4).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ID getCm_internal_location4_FacilityID() {
       return getTyped(3, ID.class);
    }


    /**
     * Returns Bed Status (component 5).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ID getBedStatus() {
       return getTyped(4, ID.class);
    }

    
    /**
     * Returns Bed Status (component 5).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ID getCm_internal_location5_BedStatus() {
       return getTyped(4, ID.class);
    }


    /**
     * Returns Etage (component 6).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ID getEtage() {
       return getTyped(5, ID.class);
    }

    
    /**
     * Returns Etage (component 6).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ID getCm_internal_location6_Etage() {
       return getTyped(5, ID.class);
    }


    /**
     * Returns Klinik (component 7).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ID getKlinik() {
       return getTyped(6, ID.class);
    }

    
    /**
     * Returns Klinik (component 7).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ID getCm_internal_location7_Klinik() {
       return getTyped(6, ID.class);
    }


    /**
     * Returns Zentrum (component 8).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ID getZentrum() {
       return getTyped(7, ID.class);
    }

    
    /**
     * Returns Zentrum (component 8).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ID getCm_internal_location8_Zentrum() {
       return getTyped(7, ID.class);
    }



}

