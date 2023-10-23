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
 * The Original Code is "PN.java".  Description:
 * "Composite class PN"
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

package ca.uhn.hl7v2.model.v24.datatype;

import ca.uhn.hl7v2.model.DataTypeException;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.Type;
import ca.uhn.hl7v2.model.AbstractComposite;


/**
 * <p>Represents an HL7 PN (person name) data type. 
 * This type consists of the following components:</p>
 * <ul>
 * <li>family name (FN)
 * <li>given name (ST)
 * <li>second and further given names or initials thereof (ST)
 * <li>suffix (e.g., JR or III) (ST)
 * <li>prefix (e.g., DR) (ST)
 * <li>degree (e.g., MD) (IS)
 * </ul>
 */
@SuppressWarnings("unused")
public class PN extends AbstractComposite {

    private Type[] data;

    /** 
     * Creates a new PN type
     */
    public PN(Message message) {
        super(message);
        init();
    }

    private void init() {
        data = new Type[6];    
        data[0] = new FN(getMessage());
        data[1] = new ST(getMessage());
        data[2] = new ST(getMessage());
        data[3] = new ST(getMessage());
        data[4] = new ST(getMessage());
        data[5] = new IS(getMessage(), 0);
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
     * Returns family name (component 1).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public FN getFamilyName() {
       return getTyped(0, FN.class);
    }

    
    /**
     * Returns family name (component 1).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public FN getPn1_FamilyName() {
       return getTyped(0, FN.class);
    }


    /**
     * Returns given name (component 2).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ST getGivenName() {
       return getTyped(1, ST.class);
    }

    
    /**
     * Returns given name (component 2).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ST getPn2_GivenName() {
       return getTyped(1, ST.class);
    }


    /**
     * Returns second and further given names or initials thereof (component 3).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ST getSecondAndFurtherGivenNamesOrInitialsThereof() {
       return getTyped(2, ST.class);
    }

    
    /**
     * Returns second and further given names or initials thereof (component 3).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ST getPn3_SecondAndFurtherGivenNamesOrInitialsThereof() {
       return getTyped(2, ST.class);
    }


    /**
     * Returns suffix (e.g., JR or III) (component 4).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ST getSuffixEgJRorIII() {
       return getTyped(3, ST.class);
    }

    
    /**
     * Returns suffix (e.g., JR or III) (component 4).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ST getPn4_SuffixEgJRorIII() {
       return getTyped(3, ST.class);
    }


    /**
     * Returns prefix (e.g., DR) (component 5).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ST getPrefixEgDR() {
       return getTyped(4, ST.class);
    }

    
    /**
     * Returns prefix (e.g., DR) (component 5).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ST getPn5_PrefixEgDR() {
       return getTyped(4, ST.class);
    }


    /**
     * Returns degree (e.g., MD) (component 6).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public IS getDegreeEgMD() {
       return getTyped(5, IS.class);
    }

    
    /**
     * Returns degree (e.g., MD) (component 6).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public IS getPn6_DegreeEgMD() {
       return getTyped(5, IS.class);
    }



}

