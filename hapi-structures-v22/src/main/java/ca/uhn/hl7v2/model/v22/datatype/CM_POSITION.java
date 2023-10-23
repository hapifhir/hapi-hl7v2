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
 * The Original Code is "CM_POSITION.java".  Description:
 * "Composite class CM_POSITION"
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
 * <p>Represents an HL7 CM_POSITION (Sitzplatz bzw. Saal / Tisch / Stuhl) data type. 
 * This type consists of the following components:</p>
 * <ul>
 * <li>Saal (ST)
 * <li>Tisch (ST)
 * <li>Stuhl (ST)
 * </ul>
 */
@SuppressWarnings("unused")
public class CM_POSITION extends AbstractComposite {

    private Type[] data;

    /** 
     * Creates a new CM_POSITION type
     */
    public CM_POSITION(Message message) {
        super(message);
        init();
    }

    private void init() {
        data = new Type[3];    
        data[0] = new ST(getMessage());
        data[1] = new ST(getMessage());
        data[2] = new ST(getMessage());
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
     * Returns Saal (component 1).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ST getSaal() {
       return getTyped(0, ST.class);
    }

    
    /**
     * Returns Saal (component 1).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ST getCm_position1_Saal() {
       return getTyped(0, ST.class);
    }


    /**
     * Returns Tisch (component 2).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ST getTisch() {
       return getTyped(1, ST.class);
    }

    
    /**
     * Returns Tisch (component 2).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ST getCm_position2_Tisch() {
       return getTyped(1, ST.class);
    }


    /**
     * Returns Stuhl (component 3).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ST getStuhl() {
       return getTyped(2, ST.class);
    }

    
    /**
     * Returns Stuhl (component 3).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ST getCm_position3_Stuhl() {
       return getTyped(2, ST.class);
    }



}

