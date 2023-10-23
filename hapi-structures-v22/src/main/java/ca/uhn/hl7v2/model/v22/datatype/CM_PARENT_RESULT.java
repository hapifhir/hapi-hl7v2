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
 * The Original Code is "CM_PARENT_RESULT.java".  Description:
 * "Composite class CM_PARENT_RESULT"
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
 * <p>Represents an HL7 CM_PARENT_RESULT (undefined CM data type) data type. 
 * This type consists of the following components:</p>
 * <ul>
 * <li>observation identifier (OBX-3) of parent result (CE)
 * <li>sub-ID (OBX-4) of parent result (ST)
 * <li>result (OBX-5) from parent (CE)
 * </ul>
 */
@SuppressWarnings("unused")
public class CM_PARENT_RESULT extends AbstractComposite {

    private Type[] data;

    /** 
     * Creates a new CM_PARENT_RESULT type
     */
    public CM_PARENT_RESULT(Message message) {
        super(message);
        init();
    }

    private void init() {
        data = new Type[3];    
        data[0] = new CE(getMessage());
        data[1] = new ST(getMessage());
        data[2] = new CE(getMessage());
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
     * Returns observation identifier (OBX-3) of parent result (component 1).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public CE getObservationIdentifierOBX3OfParentResult() {
       return getTyped(0, CE.class);
    }

    
    /**
     * Returns observation identifier (OBX-3) of parent result (component 1).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public CE getCm_parent_result1_ObservationIdentifierOBX3OfParentResult() {
       return getTyped(0, CE.class);
    }


    /**
     * Returns sub-ID (OBX-4) of parent result (component 2).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ST getSubIDOBX4OfParentResult() {
       return getTyped(1, ST.class);
    }

    
    /**
     * Returns sub-ID (OBX-4) of parent result (component 2).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ST getCm_parent_result2_SubIDOBX4OfParentResult() {
       return getTyped(1, ST.class);
    }


    /**
     * Returns result (OBX-5) from parent (component 3).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public CE getResultOBX5FromParent() {
       return getTyped(2, CE.class);
    }

    
    /**
     * Returns result (OBX-5) from parent (component 3).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public CE getCm_parent_result3_ResultOBX5FromParent() {
       return getTyped(2, CE.class);
    }



}

