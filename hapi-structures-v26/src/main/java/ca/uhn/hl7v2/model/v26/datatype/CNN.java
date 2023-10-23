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
 * The Original Code is "CNN.java".  Description:
 * "Composite class CNN"
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

package ca.uhn.hl7v2.model.v26.datatype;

import ca.uhn.hl7v2.model.DataTypeException;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.Type;
import ca.uhn.hl7v2.model.AbstractComposite;


/**
 * <p>Represents an HL7 CNN (Composite ID Number and Name Simplified) data type. 
 * This type consists of the following components:</p>
 * <ul>
 * <li>ID Number (ST)
 * <li>Family Name (ST)
 * <li>Given Name (ST)
 * <li>Second and Further Given Names or Initials Thereof (ST)
 * <li>Suffix (e.g., JR or III) (ST)
 * <li>Prefix (e.g., DR) (ST)
 * <li>Degree (e.g., MD (IS)
 * <li>Source Table (IS)
 * <li>Assigning Authority   - Namespace ID (IS)
 * <li>Assigning Authority  - Universal ID (ST)
 * <li>Assigning Authority  - Universal ID Type (ID)
 * </ul>
 */
@SuppressWarnings("unused")
public class CNN extends AbstractComposite {

    private Type[] data;

    /** 
     * Creates a new CNN type
     */
    public CNN(Message message) {
        super(message);
        init();
    }

    private void init() {
        data = new Type[11];    
        data[0] = new ST(getMessage());
        data[1] = new ST(getMessage());
        data[2] = new ST(getMessage());
        data[3] = new ST(getMessage());
        data[4] = new ST(getMessage());
        data[5] = new ST(getMessage());
        data[6] = new IS(getMessage(), 360);
        data[7] = new IS(getMessage(), 297);
        data[8] = new IS(getMessage(), 363);
        data[9] = new ST(getMessage());
        data[10] = new ID(getMessage(), 301);
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
     * Returns ID Number (component 1).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ST getIDNumber() {
       return getTyped(0, ST.class);
    }

    
    /**
     * Returns ID Number (component 1).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ST getCnn1_IDNumber() {
       return getTyped(0, ST.class);
    }


    /**
     * Returns Family Name (component 2).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ST getFamilyName() {
       return getTyped(1, ST.class);
    }

    
    /**
     * Returns Family Name (component 2).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ST getCnn2_FamilyName() {
       return getTyped(1, ST.class);
    }


    /**
     * Returns Given Name (component 3).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ST getGivenName() {
       return getTyped(2, ST.class);
    }

    
    /**
     * Returns Given Name (component 3).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ST getCnn3_GivenName() {
       return getTyped(2, ST.class);
    }


    /**
     * Returns Second and Further Given Names or Initials Thereof (component 4).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ST getSecondAndFurtherGivenNamesOrInitialsThereof() {
       return getTyped(3, ST.class);
    }

    
    /**
     * Returns Second and Further Given Names or Initials Thereof (component 4).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ST getCnn4_SecondAndFurtherGivenNamesOrInitialsThereof() {
       return getTyped(3, ST.class);
    }


    /**
     * Returns Suffix (e.g., JR or III) (component 5).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ST getSuffixEgJRorIII() {
       return getTyped(4, ST.class);
    }

    
    /**
     * Returns Suffix (e.g., JR or III) (component 5).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ST getCnn5_SuffixEgJRorIII() {
       return getTyped(4, ST.class);
    }


    /**
     * Returns Prefix (e.g., DR) (component 6).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ST getPrefixEgDR() {
       return getTyped(5, ST.class);
    }

    
    /**
     * Returns Prefix (e.g., DR) (component 6).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ST getCnn6_PrefixEgDR() {
       return getTyped(5, ST.class);
    }


    /**
     * Returns Degree (e.g., MD (component 7).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public IS getDegreeEgMD() {
       return getTyped(6, IS.class);
    }

    
    /**
     * Returns Degree (e.g., MD (component 7).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public IS getCnn7_DegreeEgMD() {
       return getTyped(6, IS.class);
    }


    /**
     * Returns Source Table (component 8).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public IS getSourceTable() {
       return getTyped(7, IS.class);
    }

    
    /**
     * Returns Source Table (component 8).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public IS getCnn8_SourceTable() {
       return getTyped(7, IS.class);
    }


    /**
     * Returns Assigning Authority   - Namespace ID (component 9).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public IS getAssigningAuthorityNamespaceID() {
       return getTyped(8, IS.class);
    }

    
    /**
     * Returns Assigning Authority   - Namespace ID (component 9).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public IS getCnn9_AssigningAuthorityNamespaceID() {
       return getTyped(8, IS.class);
    }


    /**
     * Returns Assigning Authority  - Universal ID (component 10).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ST getAssigningAuthorityUniversalID() {
       return getTyped(9, ST.class);
    }

    
    /**
     * Returns Assigning Authority  - Universal ID (component 10).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ST getCnn10_AssigningAuthorityUniversalID() {
       return getTyped(9, ST.class);
    }


    /**
     * Returns Assigning Authority  - Universal ID Type (component 11).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ID getAssigningAuthorityUniversalIDType() {
       return getTyped(10, ID.class);
    }

    
    /**
     * Returns Assigning Authority  - Universal ID Type (component 11).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ID getCnn11_AssigningAuthorityUniversalIDType() {
       return getTyped(10, ID.class);
    }



}

