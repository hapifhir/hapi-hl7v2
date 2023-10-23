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
 * The Original Code is "SPS.java".  Description:
 * "Composite class SPS"
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

package ca.uhn.hl7v2.model.v251.datatype;

import ca.uhn.hl7v2.model.DataTypeException;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.Type;
import ca.uhn.hl7v2.model.AbstractComposite;


/**
 * <p>Represents an HL7 SPS (Specimen Source) data type. 
 * This type consists of the following components:</p>
 * <ul>
 * <li>Specimen Source Name or Code (CWE)
 * <li>Additives (CWE)
 * <li>Specimen Collection Method (TX)
 * <li>Body Site (CWE)
 * <li>Site Modifier (CWE)
 * <li>Collection Method Modifier Code (CWE)
 * <li>Specimen Role (CWE)
 * </ul>
 */
@SuppressWarnings("unused")
public class SPS extends AbstractComposite {

    private Type[] data;

    /** 
     * Creates a new SPS type
     */
    public SPS(Message message) {
        super(message);
        init();
    }

    private void init() {
        data = new Type[7];    
        data[0] = new CWE(getMessage());
        data[1] = new CWE(getMessage());
        data[2] = new TX(getMessage());
        data[3] = new CWE(getMessage());
        data[4] = new CWE(getMessage());
        data[5] = new CWE(getMessage());
        data[6] = new CWE(getMessage());
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
     * Returns Specimen Source Name or Code (component 1).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public CWE getSpecimenSourceNameOrCode() {
       return getTyped(0, CWE.class);
    }

    
    /**
     * Returns Specimen Source Name or Code (component 1).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public CWE getSps1_SpecimenSourceNameOrCode() {
       return getTyped(0, CWE.class);
    }


    /**
     * Returns Additives (component 2).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public CWE getAdditives() {
       return getTyped(1, CWE.class);
    }

    
    /**
     * Returns Additives (component 2).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public CWE getSps2_Additives() {
       return getTyped(1, CWE.class);
    }


    /**
     * Returns Specimen Collection Method (component 3).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public TX getSpecimenCollectionMethod() {
       return getTyped(2, TX.class);
    }

    
    /**
     * Returns Specimen Collection Method (component 3).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public TX getSps3_SpecimenCollectionMethod() {
       return getTyped(2, TX.class);
    }


    /**
     * Returns Body Site (component 4).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public CWE getBodySite() {
       return getTyped(3, CWE.class);
    }

    
    /**
     * Returns Body Site (component 4).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public CWE getSps4_BodySite() {
       return getTyped(3, CWE.class);
    }


    /**
     * Returns Site Modifier (component 5).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public CWE getSiteModifier() {
       return getTyped(4, CWE.class);
    }

    
    /**
     * Returns Site Modifier (component 5).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public CWE getSps5_SiteModifier() {
       return getTyped(4, CWE.class);
    }


    /**
     * Returns Collection Method Modifier Code (component 6).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public CWE getCollectionMethodModifierCode() {
       return getTyped(5, CWE.class);
    }

    
    /**
     * Returns Collection Method Modifier Code (component 6).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public CWE getSps6_CollectionMethodModifierCode() {
       return getTyped(5, CWE.class);
    }


    /**
     * Returns Specimen Role (component 7).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public CWE getSpecimenRole() {
       return getTyped(6, CWE.class);
    }

    
    /**
     * Returns Specimen Role (component 7).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public CWE getSps7_SpecimenRole() {
       return getTyped(6, CWE.class);
    }



}

