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
 * The Original Code is "DLT.java".  Description:
 * "Composite class DLT"
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
 * <p>Represents an HL7 DLT (delta check) data type. 
 * This type consists of the following components:</p>
 * <ul>
 * <li>Range (NR)
 * <li>numeric threshold (NM)
 * <li>change computation (ST)
 * <li>length of time-days (NM)
 * </ul>
 */
@SuppressWarnings("unused")
public class DLT extends AbstractComposite {

    private Type[] data;

    /** 
     * Creates a new DLT type
     */
    public DLT(Message message) {
        super(message);
        init();
    }

    private void init() {
        data = new Type[4];    
        data[0] = new NR(getMessage());
        data[1] = new NM(getMessage());
        data[2] = new ST(getMessage());
        data[3] = new NM(getMessage());
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
     * Returns Range (component 1).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public NR getRange() {
       return getTyped(0, NR.class);
    }

    
    /**
     * Returns Range (component 1).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public NR getDlt1_Range() {
       return getTyped(0, NR.class);
    }


    /**
     * Returns numeric threshold (component 2).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public NM getNumericThreshold() {
       return getTyped(1, NM.class);
    }

    
    /**
     * Returns numeric threshold (component 2).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public NM getDlt2_NumericThreshold() {
       return getTyped(1, NM.class);
    }


    /**
     * Returns change computation (component 3).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ST getChangeComputation() {
       return getTyped(2, ST.class);
    }

    
    /**
     * Returns change computation (component 3).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ST getDlt3_ChangeComputation() {
       return getTyped(2, ST.class);
    }


    /**
     * Returns length of time-days (component 4).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public NM getLengthOfTimeDays() {
       return getTyped(3, NM.class);
    }

    
    /**
     * Returns length of time-days (component 4).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public NM getDlt4_LengthOfTimeDays() {
       return getTyped(3, NM.class);
    }



}

