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
 * The Original Code is "XAD.java".  Description:
 * "Composite class XAD"
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
 * <p>Represents an HL7 XAD (Extended Address) data type. 
 * This type consists of the following components:</p>
 * <ul>
 * <li>Street Address (SAD)
 * <li>Other Designation (ST)
 * <li>City (ST)
 * <li>State or Province (ST)
 * <li>Zip or Postal Code (ST)
 * <li>Country (ID)
 * <li>Address Type (ID)
 * <li>Other Geographic Designation (ST)
 * <li>County/Parish Code (IS)
 * <li>Census Tract (IS)
 * <li>Address Representation Code (ID)
 * <li>Address Validity Range (DR)
 * <li>Effective Date (DTM)
 * <li>Expiration Date (DTM)
 * <li>Expiration Reason (CWE)
 * <li>Temporary Indicator (ID)
 * <li>Bad Address Indicator (ID)
 * <li>Address Usage (ID)
 * <li>Addressee (ST)
 * <li>Comment (ST)
 * <li>Preference Order (NM)
 * <li>Protection Code (CWE)
 * <li>Address Identifier (EI)
 * </ul>
 */
@SuppressWarnings("unused")
public class XAD extends AbstractComposite {

    private Type[] data;

    /** 
     * Creates a new XAD type
     */
    public XAD(Message message) {
        super(message);
        init();
    }

    private void init() {
        data = new Type[23];    
        data[0] = new SAD(getMessage());
        data[1] = new ST(getMessage());
        data[2] = new ST(getMessage());
        data[3] = new ST(getMessage());
        data[4] = new ST(getMessage());
        data[5] = new ID(getMessage(), 399);
        data[6] = new ID(getMessage(), 190);
        data[7] = new ST(getMessage());
        data[8] = new IS(getMessage(), 289);
        data[9] = new IS(getMessage(), 288);
        data[10] = new ID(getMessage(), 465);
        data[11] = new DR(getMessage());
        data[12] = new DTM(getMessage());
        data[13] = new DTM(getMessage());
        data[14] = new CWE(getMessage());
        data[15] = new ID(getMessage(), 136);
        data[16] = new ID(getMessage(), 136);
        data[17] = new ID(getMessage(), 617);
        data[18] = new ST(getMessage());
        data[19] = new ST(getMessage());
        data[20] = new NM(getMessage());
        data[21] = new CWE(getMessage());
        data[22] = new EI(getMessage());
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
     * Returns Street Address (component 1).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public SAD getStreetAddress() {
       return getTyped(0, SAD.class);
    }

    
    /**
     * Returns Street Address (component 1).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public SAD getXad1_StreetAddress() {
       return getTyped(0, SAD.class);
    }


    /**
     * Returns Other Designation (component 2).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ST getOtherDesignation() {
       return getTyped(1, ST.class);
    }

    
    /**
     * Returns Other Designation (component 2).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ST getXad2_OtherDesignation() {
       return getTyped(1, ST.class);
    }


    /**
     * Returns City (component 3).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ST getCity() {
       return getTyped(2, ST.class);
    }

    
    /**
     * Returns City (component 3).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ST getXad3_City() {
       return getTyped(2, ST.class);
    }


    /**
     * Returns State or Province (component 4).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ST getStateOrProvince() {
       return getTyped(3, ST.class);
    }

    
    /**
     * Returns State or Province (component 4).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ST getXad4_StateOrProvince() {
       return getTyped(3, ST.class);
    }


    /**
     * Returns Zip or Postal Code (component 5).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ST getZipOrPostalCode() {
       return getTyped(4, ST.class);
    }

    
    /**
     * Returns Zip or Postal Code (component 5).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ST getXad5_ZipOrPostalCode() {
       return getTyped(4, ST.class);
    }


    /**
     * Returns Country (component 6).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ID getCountry() {
       return getTyped(5, ID.class);
    }

    
    /**
     * Returns Country (component 6).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ID getXad6_Country() {
       return getTyped(5, ID.class);
    }


    /**
     * Returns Address Type (component 7).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ID getAddressType() {
       return getTyped(6, ID.class);
    }

    
    /**
     * Returns Address Type (component 7).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ID getXad7_AddressType() {
       return getTyped(6, ID.class);
    }


    /**
     * Returns Other Geographic Designation (component 8).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ST getOtherGeographicDesignation() {
       return getTyped(7, ST.class);
    }

    
    /**
     * Returns Other Geographic Designation (component 8).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ST getXad8_OtherGeographicDesignation() {
       return getTyped(7, ST.class);
    }


    /**
     * Returns County/Parish Code (component 9).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public IS getCountyParishCode() {
       return getTyped(8, IS.class);
    }

    
    /**
     * Returns County/Parish Code (component 9).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public IS getXad9_CountyParishCode() {
       return getTyped(8, IS.class);
    }


    /**
     * Returns Census Tract (component 10).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public IS getCensusTract() {
       return getTyped(9, IS.class);
    }

    
    /**
     * Returns Census Tract (component 10).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public IS getXad10_CensusTract() {
       return getTyped(9, IS.class);
    }


    /**
     * Returns Address Representation Code (component 11).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ID getAddressRepresentationCode() {
       return getTyped(10, ID.class);
    }

    
    /**
     * Returns Address Representation Code (component 11).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ID getXad11_AddressRepresentationCode() {
       return getTyped(10, ID.class);
    }


    /**
     * Returns Address Validity Range (component 12).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public DR getAddressValidityRange() {
       return getTyped(11, DR.class);
    }

    
    /**
     * Returns Address Validity Range (component 12).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public DR getXad12_AddressValidityRange() {
       return getTyped(11, DR.class);
    }


    /**
     * Returns Effective Date (component 13).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public DTM getEffectiveDate() {
       return getTyped(12, DTM.class);
    }

    
    /**
     * Returns Effective Date (component 13).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public DTM getXad13_EffectiveDate() {
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
    public DTM getXad14_ExpirationDate() {
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
    public CWE getXad15_ExpirationReason() {
       return getTyped(14, CWE.class);
    }


    /**
     * Returns Temporary Indicator (component 16).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ID getTemporaryIndicator() {
       return getTyped(15, ID.class);
    }

    
    /**
     * Returns Temporary Indicator (component 16).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ID getXad16_TemporaryIndicator() {
       return getTyped(15, ID.class);
    }


    /**
     * Returns Bad Address Indicator (component 17).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ID getBadAddressIndicator() {
       return getTyped(16, ID.class);
    }

    
    /**
     * Returns Bad Address Indicator (component 17).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ID getXad17_BadAddressIndicator() {
       return getTyped(16, ID.class);
    }


    /**
     * Returns Address Usage (component 18).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ID getAddressUsage() {
       return getTyped(17, ID.class);
    }

    
    /**
     * Returns Address Usage (component 18).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ID getXad18_AddressUsage() {
       return getTyped(17, ID.class);
    }


    /**
     * Returns Addressee (component 19).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ST getAddressee() {
       return getTyped(18, ST.class);
    }

    
    /**
     * Returns Addressee (component 19).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ST getXad19_Addressee() {
       return getTyped(18, ST.class);
    }


    /**
     * Returns Comment (component 20).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ST getComment() {
       return getTyped(19, ST.class);
    }

    
    /**
     * Returns Comment (component 20).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ST getXad20_Comment() {
       return getTyped(19, ST.class);
    }


    /**
     * Returns Preference Order (component 21).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public NM getPreferenceOrder() {
       return getTyped(20, NM.class);
    }

    
    /**
     * Returns Preference Order (component 21).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public NM getXad21_PreferenceOrder() {
       return getTyped(20, NM.class);
    }


    /**
     * Returns Protection Code (component 22).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public CWE getProtectionCode() {
       return getTyped(21, CWE.class);
    }

    
    /**
     * Returns Protection Code (component 22).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public CWE getXad22_ProtectionCode() {
       return getTyped(21, CWE.class);
    }


    /**
     * Returns Address Identifier (component 23).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public EI getAddressIdentifier() {
       return getTyped(22, EI.class);
    }

    
    /**
     * Returns Address Identifier (component 23).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public EI getXad23_AddressIdentifier() {
       return getTyped(22, EI.class);
    }



}

