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
 * The Original Code is "MSG.java".  Description:
 * "Composite class MSG"
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

package ca.uhn.hl7v2.model.v27.datatype;

import ca.uhn.hl7v2.model.DataTypeException;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.Type;
import ca.uhn.hl7v2.model.AbstractComposite;


/**
 * <p>Represents an HL7 MSG (Message Type) data type. 
 * This type consists of the following components:</p>
 * <ul>
 * <li>Message Code (ID)
 * <li>Trigger Event (ID)
 * <li>Message Structure (ID)
 * </ul>
 */
@SuppressWarnings("unused")
public class MSG extends AbstractComposite {

    private Type[] data;

    /** 
     * Creates a new MSG type
     */
    public MSG(Message message) {
        super(message);
        init();
    }

    private void init() {
        data = new Type[3];    
        data[0] = new ID(getMessage(), 76);
        data[1] = new ID(getMessage(), 3);
        data[2] = new ID(getMessage(), 354);
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
     * Returns Message Code (component 1).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ID getMessageCode() {
       return getTyped(0, ID.class);
    }

    
    /**
     * Returns Message Code (component 1).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ID getMsg1_MessageCode() {
       return getTyped(0, ID.class);
    }


    /**
     * Returns Trigger Event (component 2).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ID getTriggerEvent() {
       return getTyped(1, ID.class);
    }

    
    /**
     * Returns Trigger Event (component 2).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ID getMsg2_TriggerEvent() {
       return getTyped(1, ID.class);
    }


    /**
     * Returns Message Structure (component 3).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ID getMessageStructure() {
       return getTyped(2, ID.class);
    }

    
    /**
     * Returns Message Structure (component 3).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ID getMsg3_MessageStructure() {
       return getTyped(2, ID.class);
    }



}

