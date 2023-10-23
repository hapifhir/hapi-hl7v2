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
 * The Original Code is "XPN.java".  Description:
 * "Composite class XPN"
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
 * <p>Represents an HL7 XPN (Extended Person Name) data type. 
 * This type consists of the following components:</p>
 * <ul>
 * <li>Family Name (FN)
 * <li>Given Name (ST)
 * <li>Second and Further Given Names or Initials Thereof (ST)
 * <li>Suffix (e.g., JR or III) (ST)
 * <li>Prefix (e.g., DR) (ST)
 * <li>Degree (e.g., MD) (ST)
 * <li>Name Type Code (ID)
 * <li>Name Representation Code (ID)
 * <li>Name Context (CWE)
 * <li>Name Validity Range (ST)
 * <li>Name Assembly Order (ID)
 * <li>Effective Date (DTM)
 * <li>Expiration Date (DTM)
 * <li>Professional Suffix (ST)
 * <li>Called By (ST)
 * </ul>
 */
@SuppressWarnings("unused")
public class XPN extends AbstractComposite {

    private Type[] data;

    /** 
     * Creates a new XPN type
     */
    public XPN(Message message) {
        super(message);
        init();
    }

    private void init() {
        data = new Type[15];    
        data[0] = new FN(getMessage());
        data[1] = new ST(getMessage());
        data[2] = new ST(getMessage());
        data[3] = new ST(getMessage());
        data[4] = new ST(getMessage());
        data[5] = new ST(getMessage());
        data[6] = new ID(getMessage(), 200);
        data[7] = new ID(getMessage(), 465);
        data[8] = new CWE(getMessage());
        data[9] = new ST(getMessage());
        data[10] = new ID(getMessage(), 444);
        data[11] = new DTM(getMessage());
        data[12] = new DTM(getMessage());
        data[13] = new ST(getMessage());
        data[14] = new ST(getMessage());
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
     * Returns Family Name (component 1).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public FN getFamilyName() {
       return getTyped(0, FN.class);
    }

    
    /**
     * Returns Family Name (component 1).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public FN getXpn1_FamilyName() {
       return getTyped(0, FN.class);
    }


    /**
     * Returns Given Name (component 2).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ST getGivenName() {
       return getTyped(1, ST.class);
    }

    
    /**
     * Returns Given Name (component 2).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ST getXpn2_GivenName() {
       return getTyped(1, ST.class);
    }


    /**
     * Returns Second and Further Given Names or Initials Thereof (component 3).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ST getSecondAndFurtherGivenNamesOrInitialsThereof() {
       return getTyped(2, ST.class);
    }

    
    /**
     * Returns Second and Further Given Names or Initials Thereof (component 3).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ST getXpn3_SecondAndFurtherGivenNamesOrInitialsThereof() {
       return getTyped(2, ST.class);
    }


    /**
     * Returns Suffix (e.g., JR or III) (component 4).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ST getSuffixEgJRorIII() {
       return getTyped(3, ST.class);
    }

    
    /**
     * Returns Suffix (e.g., JR or III) (component 4).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ST getXpn4_SuffixEgJRorIII() {
       return getTyped(3, ST.class);
    }


    /**
     * Returns Prefix (e.g., DR) (component 5).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ST getPrefixEgDR() {
       return getTyped(4, ST.class);
    }

    
    /**
     * Returns Prefix (e.g., DR) (component 5).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ST getXpn5_PrefixEgDR() {
       return getTyped(4, ST.class);
    }


    /**
     * Returns Degree (e.g., MD) (component 6).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ST getDegreeEgMD() {
       return getTyped(5, ST.class);
    }

    
    /**
     * Returns Degree (e.g., MD) (component 6).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ST getXpn6_DegreeEgMD() {
       return getTyped(5, ST.class);
    }


    /**
     * Returns Name Type Code (component 7).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ID getNameTypeCode() {
       return getTyped(6, ID.class);
    }

    
    /**
     * Returns Name Type Code (component 7).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ID getXpn7_NameTypeCode() {
       return getTyped(6, ID.class);
    }


    /**
     * Returns Name Representation Code (component 8).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ID getNameRepresentationCode() {
       return getTyped(7, ID.class);
    }

    
    /**
     * Returns Name Representation Code (component 8).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ID getXpn8_NameRepresentationCode() {
       return getTyped(7, ID.class);
    }


    /**
     * Returns Name Context (component 9).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public CWE getNameContext() {
       return getTyped(8, CWE.class);
    }

    
    /**
     * Returns Name Context (component 9).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public CWE getXpn9_NameContext() {
       return getTyped(8, CWE.class);
    }


    /**
     * Returns Name Validity Range (component 10).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ST getNameValidityRange() {
       return getTyped(9, ST.class);
    }

    
    /**
     * Returns Name Validity Range (component 10).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ST getXpn10_NameValidityRange() {
       return getTyped(9, ST.class);
    }


    /**
     * Returns Name Assembly Order (component 11).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ID getNameAssemblyOrder() {
       return getTyped(10, ID.class);
    }

    
    /**
     * Returns Name Assembly Order (component 11).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ID getXpn11_NameAssemblyOrder() {
       return getTyped(10, ID.class);
    }


    /**
     * Returns Effective Date (component 12).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public DTM getEffectiveDate() {
       return getTyped(11, DTM.class);
    }

    
    /**
     * Returns Effective Date (component 12).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public DTM getXpn12_EffectiveDate() {
       return getTyped(11, DTM.class);
    }


    /**
     * Returns Expiration Date (component 13).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public DTM getExpirationDate() {
       return getTyped(12, DTM.class);
    }

    
    /**
     * Returns Expiration Date (component 13).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public DTM getXpn13_ExpirationDate() {
       return getTyped(12, DTM.class);
    }


    /**
     * Returns Professional Suffix (component 14).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ST getProfessionalSuffix() {
       return getTyped(13, ST.class);
    }

    
    /**
     * Returns Professional Suffix (component 14).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ST getXpn14_ProfessionalSuffix() {
       return getTyped(13, ST.class);
    }


    /**
     * Returns Called By (component 15).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ST getCalledBy() {
       return getTyped(14, ST.class);
    }

    
    /**
     * Returns Called By (component 15).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ST getXpn15_CalledBy() {
       return getTyped(14, ST.class);
    }



}

