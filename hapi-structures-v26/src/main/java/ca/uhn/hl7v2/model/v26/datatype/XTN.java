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
 * The Original Code is "XTN.java".  Description:
 * "Composite class XTN"
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
 * <p>Represents an HL7 XTN (Extended Telecommunication Number) data type. 
 * This type consists of the following components:</p>
 * <ul>
 * <li>Telephone Number (NULLDT)
 * <li>Telecommunication Use Code (ID)
 * <li>Telecommunication Equipment Type (ID)
 * <li>Communication Address (ST)
 * <li>Country Code (NM)
 * <li>Area/City Code (NM)
 * <li>Local Number (NM)
 * <li>Extension (NM)
 * <li>Any Text (ST)
 * <li>Extension Prefix (ST)
 * <li>Speed Dial Code (ST)
 * <li>Unformatted Telephone number (ST)
 * <li>Effective Start Date (DTM)
 * <li>Expiration Date (DTM)
 * <li>Expiration Reason (CWE)
 * <li>Protection Code (CWE)
 * <li>Shared Telecommunication Identifier (EI)
 * <li>Preference Order (NM)
 * </ul>
 */
@SuppressWarnings("unused")
public class XTN extends AbstractComposite {

    private Type[] data;

    /** 
     * Creates a new XTN type
     */
    public XTN(Message message) {
        super(message);
        init();
    }

    private void init() {
        data = new Type[18];    
        data[0] = new NULLDT(getMessage());
        data[1] = new ID(getMessage(), 201);
        data[2] = new ID(getMessage(), 202);
        data[3] = new ST(getMessage());
        data[4] = new NM(getMessage());
        data[5] = new NM(getMessage());
        data[6] = new NM(getMessage());
        data[7] = new NM(getMessage());
        data[8] = new ST(getMessage());
        data[9] = new ST(getMessage());
        data[10] = new ST(getMessage());
        data[11] = new ST(getMessage());
        data[12] = new DTM(getMessage());
        data[13] = new DTM(getMessage());
        data[14] = new CWE(getMessage());
        data[15] = new CWE(getMessage());
        data[16] = new EI(getMessage());
        data[17] = new NM(getMessage());
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
     * Returns Telephone Number (component 1).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public NULLDT getTelephoneNumber() {
       return getTyped(0, NULLDT.class);
    }

    
    /**
     * Returns Telephone Number (component 1).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public NULLDT getXtn1_TelephoneNumber() {
       return getTyped(0, NULLDT.class);
    }


    /**
     * Returns Telecommunication Use Code (component 2).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ID getTelecommunicationUseCode() {
       return getTyped(1, ID.class);
    }

    
    /**
     * Returns Telecommunication Use Code (component 2).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ID getXtn2_TelecommunicationUseCode() {
       return getTyped(1, ID.class);
    }


    /**
     * Returns Telecommunication Equipment Type (component 3).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ID getTelecommunicationEquipmentType() {
       return getTyped(2, ID.class);
    }

    
    /**
     * Returns Telecommunication Equipment Type (component 3).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ID getXtn3_TelecommunicationEquipmentType() {
       return getTyped(2, ID.class);
    }


    /**
     * Returns Communication Address (component 4).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ST getCommunicationAddress() {
       return getTyped(3, ST.class);
    }

    
    /**
     * Returns Communication Address (component 4).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ST getXtn4_CommunicationAddress() {
       return getTyped(3, ST.class);
    }


    /**
     * Returns Country Code (component 5).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public NM getCountryCode() {
       return getTyped(4, NM.class);
    }

    
    /**
     * Returns Country Code (component 5).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public NM getXtn5_CountryCode() {
       return getTyped(4, NM.class);
    }


    /**
     * Returns Area/City Code (component 6).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public NM getAreaCityCode() {
       return getTyped(5, NM.class);
    }

    
    /**
     * Returns Area/City Code (component 6).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public NM getXtn6_AreaCityCode() {
       return getTyped(5, NM.class);
    }


    /**
     * Returns Local Number (component 7).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public NM getLocalNumber() {
       return getTyped(6, NM.class);
    }

    
    /**
     * Returns Local Number (component 7).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public NM getXtn7_LocalNumber() {
       return getTyped(6, NM.class);
    }


    /**
     * Returns Extension (component 8).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public NM getExtension() {
       return getTyped(7, NM.class);
    }

    
    /**
     * Returns Extension (component 8).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public NM getXtn8_Extension() {
       return getTyped(7, NM.class);
    }


    /**
     * Returns Any Text (component 9).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ST getAnyText() {
       return getTyped(8, ST.class);
    }

    
    /**
     * Returns Any Text (component 9).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ST getXtn9_AnyText() {
       return getTyped(8, ST.class);
    }


    /**
     * Returns Extension Prefix (component 10).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ST getExtensionPrefix() {
       return getTyped(9, ST.class);
    }

    
    /**
     * Returns Extension Prefix (component 10).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ST getXtn10_ExtensionPrefix() {
       return getTyped(9, ST.class);
    }


    /**
     * Returns Speed Dial Code (component 11).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ST getSpeedDialCode() {
       return getTyped(10, ST.class);
    }

    
    /**
     * Returns Speed Dial Code (component 11).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ST getXtn11_SpeedDialCode() {
       return getTyped(10, ST.class);
    }


    /**
     * Returns Unformatted Telephone number (component 12).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ST getUnformattedTelephoneNumber() {
       return getTyped(11, ST.class);
    }

    
    /**
     * Returns Unformatted Telephone number (component 12).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ST getXtn12_UnformattedTelephoneNumber() {
       return getTyped(11, ST.class);
    }


    /**
     * Returns Effective Start Date (component 13).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public DTM getEffectiveStartDate() {
       return getTyped(12, DTM.class);
    }

    
    /**
     * Returns Effective Start Date (component 13).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public DTM getXtn13_EffectiveStartDate() {
       return getTyped(12, DTM.class);
    }


    /**
     * Returns Expiration Date (component 14).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public DTM getExpirationDate() {
       return getTyped(13, DTM.class);
    }

    
    /**
     * Returns Expiration Date (component 14).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public DTM getXtn14_ExpirationDate() {
       return getTyped(13, DTM.class);
    }


    /**
     * Returns Expiration Reason (component 15).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public CWE getExpirationReason() {
       return getTyped(14, CWE.class);
    }

    
    /**
     * Returns Expiration Reason (component 15).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public CWE getXtn15_ExpirationReason() {
       return getTyped(14, CWE.class);
    }


    /**
     * Returns Protection Code (component 16).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public CWE getProtectionCode() {
       return getTyped(15, CWE.class);
    }

    
    /**
     * Returns Protection Code (component 16).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public CWE getXtn16_ProtectionCode() {
       return getTyped(15, CWE.class);
    }


    /**
     * Returns Shared Telecommunication Identifier (component 17).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public EI getSharedTelecommunicationIdentifier() {
       return getTyped(16, EI.class);
    }

    
    /**
     * Returns Shared Telecommunication Identifier (component 17).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public EI getXtn17_SharedTelecommunicationIdentifier() {
       return getTyped(16, EI.class);
    }


    /**
     * Returns Preference Order (component 18).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public NM getPreferenceOrder() {
       return getTyped(17, NM.class);
    }

    
    /**
     * Returns Preference Order (component 18).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public NM getXtn18_PreferenceOrder() {
       return getTyped(17, NM.class);
    }



}

