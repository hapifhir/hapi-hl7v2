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
 * The Original Code is "CM_RFR.java".  Description:
 * "Composite class CM_RFR"
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
 * <p>Represents an HL7 CM_RFR (reference range) data type. 
 * This type consists of the following components:</p>
 * <ul>
 * <li>Reference Range (CM_RANGE)
 * <li>Sex (ID)
 * <li>Age Range (CM_RANGE)
 * <li>Gestational Age Range (CM_RANGE)
 * <li>Species (ST)
 * <li>Race / Subspecies (ID)
 * <li>Text Condition (ST)
 * </ul>
 */
@SuppressWarnings("unused")
public class CM_RFR extends AbstractComposite {

    private Type[] data;

    /** 
     * Creates a new CM_RFR type
     */
    public CM_RFR(Message message) {
        super(message);
        init();
    }

    private void init() {
        data = new Type[7];    
        data[0] = new CM_RANGE(getMessage());
        data[1] = new ID(getMessage(), 0);
        data[2] = new CM_RANGE(getMessage());
        data[3] = new CM_RANGE(getMessage());
        data[4] = new ST(getMessage());
        data[5] = new ID(getMessage(), 0);
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
     * Returns Reference Range (component 1).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public CM_RANGE getReferenceRange() {
       return getTyped(0, CM_RANGE.class);
    }

    
    /**
     * Returns Reference Range (component 1).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public CM_RANGE getCm_rfr1_ReferenceRange() {
       return getTyped(0, CM_RANGE.class);
    }


    /**
     * Returns Sex (component 2).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ID getSex() {
       return getTyped(1, ID.class);
    }

    
    /**
     * Returns Sex (component 2).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ID getCm_rfr2_Sex() {
       return getTyped(1, ID.class);
    }


    /**
     * Returns Age Range (component 3).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public CM_RANGE getAgeRange() {
       return getTyped(2, CM_RANGE.class);
    }

    
    /**
     * Returns Age Range (component 3).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public CM_RANGE getCm_rfr3_AgeRange() {
       return getTyped(2, CM_RANGE.class);
    }


    /**
     * Returns Gestational Age Range (component 4).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public CM_RANGE getGestationalAgeRange() {
       return getTyped(3, CM_RANGE.class);
    }

    
    /**
     * Returns Gestational Age Range (component 4).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public CM_RANGE getCm_rfr4_GestationalAgeRange() {
       return getTyped(3, CM_RANGE.class);
    }


    /**
     * Returns Species (component 5).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ST getSpecies() {
       return getTyped(4, ST.class);
    }

    
    /**
     * Returns Species (component 5).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ST getCm_rfr5_Species() {
       return getTyped(4, ST.class);
    }


    /**
     * Returns Race / Subspecies (component 6).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ID getRaceSubspecies() {
       return getTyped(5, ID.class);
    }

    
    /**
     * Returns Race / Subspecies (component 6).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ID getCm_rfr6_RaceSubspecies() {
       return getTyped(5, ID.class);
    }


    /**
     * Returns Text Condition (component 7).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ST getTextCondition() {
       return getTyped(6, ST.class);
    }

    
    /**
     * Returns Text Condition (component 7).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ST getCm_rfr7_TextCondition() {
       return getTyped(6, ST.class);
    }



}

