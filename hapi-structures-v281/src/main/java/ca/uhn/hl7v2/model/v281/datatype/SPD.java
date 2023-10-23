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
 * The Original Code is "SPD.java".  Description:
 * "Composite class SPD"
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

package ca.uhn.hl7v2.model.v281.datatype;

import ca.uhn.hl7v2.model.DataTypeException;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.Type;
import ca.uhn.hl7v2.model.AbstractComposite;


/**
 * <p>Represents an HL7 SPD (Specialty Description) data type. 
 * This type consists of the following components:</p>
 * <ul>
 * <li>Specialty Name (ST)
 * <li>Governing Board (ST)
 * <li>Eligible or Certified (ID)
 * <li>Date of Certification (DT)
 * </ul>
 */
@SuppressWarnings("unused")
public class SPD extends AbstractComposite {

    private Type[] data;

    /** 
     * Creates a new SPD type
     */
    public SPD(Message message) {
        super(message);
        init();
    }

    private void init() {
        data = new Type[4];    
        data[0] = new ST(getMessage());
        data[1] = new ST(getMessage());
        data[2] = new ID(getMessage(), 337);
        data[3] = new DT(getMessage());
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
     * Returns Specialty Name (component 1).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ST getSpecialtyName() {
       return getTyped(0, ST.class);
    }

    
    /**
     * Returns Specialty Name (component 1).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ST getSpd1_SpecialtyName() {
       return getTyped(0, ST.class);
    }


    /**
     * Returns Governing Board (component 2).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ST getGoverningBoard() {
       return getTyped(1, ST.class);
    }

    
    /**
     * Returns Governing Board (component 2).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ST getSpd2_GoverningBoard() {
       return getTyped(1, ST.class);
    }


    /**
     * Returns Eligible or Certified (component 3).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ID getEligibleOrCertified() {
       return getTyped(2, ID.class);
    }

    
    /**
     * Returns Eligible or Certified (component 3).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ID getSpd3_EligibleOrCertified() {
       return getTyped(2, ID.class);
    }


    /**
     * Returns Date of Certification (component 4).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public DT getDateOfCertification() {
       return getTyped(3, DT.class);
    }

    
    /**
     * Returns Date of Certification (component 4).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public DT getSpd4_DateOfCertification() {
       return getTyped(3, DT.class);
    }



}

