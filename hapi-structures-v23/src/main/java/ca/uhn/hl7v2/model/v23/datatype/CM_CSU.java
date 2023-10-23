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
 * The Original Code is "CM_CSU.java".  Description:
 * "Composite class CM_CSU"
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
 * <p>Represents an HL7 CM_CSU (channel sensitivity/units) data type. 
 * This type consists of the following components:</p>
 * <ul>
 * <li>sensitivity (NM)
 * <li>units identifier (ID)
 * <li>units text (ST)
 * <li>units name of coding system (ST)
 * <li>units alternate identifier (ID)
 * <li>units alternate text (ST)
 * <li>units name of alternate coding system (ST)
 * </ul>
 */
@SuppressWarnings("unused")
public class CM_CSU extends AbstractComposite {

    private Type[] data;

    /** 
     * Creates a new CM_CSU type
     */
    public CM_CSU(Message message) {
        super(message);
        init();
    }

    private void init() {
        data = new Type[7];    
        data[0] = new NM(getMessage());
        data[1] = new ID(getMessage(), 0);
        data[2] = new ST(getMessage());
        data[3] = new ST(getMessage());
        data[4] = new ID(getMessage(), 0);
        data[5] = new ST(getMessage());
        data[6] = new ST(getMessage());
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
     * Returns sensitivity (component 1).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public NM getSensitivity() {
       return getTyped(0, NM.class);
    }

    
    /**
     * Returns sensitivity (component 1).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public NM getCm_csu1_Sensitivity() {
       return getTyped(0, NM.class);
    }


    /**
     * Returns units identifier (component 2).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ID getUnitsIdentifier() {
       return getTyped(1, ID.class);
    }

    
    /**
     * Returns units identifier (component 2).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ID getCm_csu2_UnitsIdentifier() {
       return getTyped(1, ID.class);
    }


    /**
     * Returns units text (component 3).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ST getUnitsText() {
       return getTyped(2, ST.class);
    }

    
    /**
     * Returns units text (component 3).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ST getCm_csu3_UnitsText() {
       return getTyped(2, ST.class);
    }


    /**
     * Returns units name of coding system (component 4).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ST getUnitsNameOfCodingSystem() {
       return getTyped(3, ST.class);
    }

    
    /**
     * Returns units name of coding system (component 4).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ST getCm_csu4_UnitsNameOfCodingSystem() {
       return getTyped(3, ST.class);
    }


    /**
     * Returns units alternate identifier (component 5).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ID getUnitsAlternateIdentifier() {
       return getTyped(4, ID.class);
    }

    
    /**
     * Returns units alternate identifier (component 5).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ID getCm_csu5_UnitsAlternateIdentifier() {
       return getTyped(4, ID.class);
    }


    /**
     * Returns units alternate text (component 6).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ST getUnitsAlternateText() {
       return getTyped(5, ST.class);
    }

    
    /**
     * Returns units alternate text (component 6).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ST getCm_csu6_UnitsAlternateText() {
       return getTyped(5, ST.class);
    }


    /**
     * Returns units name of alternate coding system (component 7).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ST getUnitsNameOfAlternateCodingSystem() {
       return getTyped(6, ST.class);
    }

    
    /**
     * Returns units name of alternate coding system (component 7).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ST getCm_csu7_UnitsNameOfAlternateCodingSystem() {
       return getTyped(6, ST.class);
    }



}

