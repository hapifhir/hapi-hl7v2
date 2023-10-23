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
 * The Original Code is "CN.java".  Description:
 * "Composite class CN"
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
 * <p>Represents an HL7 CN (CN für Ärzte) data type. 
 * This type consists of the following components:</p>
 * <ul>
 * <li>ID number (ID)
 * <li>family name (ST)
 * <li>given name (ST)
 * <li>middle initial or name (ST)
 * <li>suffix (e.g. JR or III) (ST)
 * <li>prefix (e.g. DR) (ST)
 * <li>degree (e.g. MD) (ST)
 * <li>source table id (ID)
 * <li>Adresse (AD)
 * <li>Telefon (TN)
 * <li>Faxnummer (TN)
 * <li>Online-Nummer (TN)
 * <li>E-Mail (ST)
 * </ul>
 */
@SuppressWarnings("unused")
public class CN extends AbstractComposite {

    private Type[] data;

    /** 
     * Creates a new CN type
     */
    public CN(Message message) {
        super(message);
        init();
    }

    private void init() {
        data = new Type[13];    
        data[0] = new ID(getMessage(), 0);
        data[1] = new ST(getMessage());
        data[2] = new ST(getMessage());
        data[3] = new ST(getMessage());
        data[4] = new ST(getMessage());
        data[5] = new ST(getMessage());
        data[6] = new ST(getMessage());
        data[7] = new ID(getMessage(), 0);
        data[8] = new AD(getMessage());
        data[9] = new TN(getMessage());
        data[10] = new TN(getMessage());
        data[11] = new TN(getMessage());
        data[12] = new ST(getMessage());
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
     * Returns ID number (component 1).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ID getIDNumber() {
       return getTyped(0, ID.class);
    }

    
    /**
     * Returns ID number (component 1).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ID getCn1_IDNumber() {
       return getTyped(0, ID.class);
    }


    /**
     * Returns family name (component 2).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ST getFamilyName() {
       return getTyped(1, ST.class);
    }

    
    /**
     * Returns family name (component 2).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ST getCn2_FamilyName() {
       return getTyped(1, ST.class);
    }


    /**
     * Returns given name (component 3).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ST getGivenName() {
       return getTyped(2, ST.class);
    }

    
    /**
     * Returns given name (component 3).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ST getCn3_GivenName() {
       return getTyped(2, ST.class);
    }


    /**
     * Returns middle initial or name (component 4).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ST getMiddleInitialOrName() {
       return getTyped(3, ST.class);
    }

    
    /**
     * Returns middle initial or name (component 4).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ST getCn4_MiddleInitialOrName() {
       return getTyped(3, ST.class);
    }


    /**
     * Returns suffix (e.g. JR or III) (component 5).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ST getSuffixEgJRorIII() {
       return getTyped(4, ST.class);
    }

    
    /**
     * Returns suffix (e.g. JR or III) (component 5).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ST getCn5_SuffixEgJRorIII() {
       return getTyped(4, ST.class);
    }


    /**
     * Returns prefix (e.g. DR) (component 6).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ST getPrefixEgDR() {
       return getTyped(5, ST.class);
    }

    
    /**
     * Returns prefix (e.g. DR) (component 6).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ST getCn6_PrefixEgDR() {
       return getTyped(5, ST.class);
    }


    /**
     * Returns degree (e.g. MD) (component 7).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ST getDegreeEgMD() {
       return getTyped(6, ST.class);
    }

    
    /**
     * Returns degree (e.g. MD) (component 7).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ST getCn7_DegreeEgMD() {
       return getTyped(6, ST.class);
    }


    /**
     * Returns source table id (component 8).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ID getSourceTableId() {
       return getTyped(7, ID.class);
    }

    
    /**
     * Returns source table id (component 8).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ID getCn8_SourceTableId() {
       return getTyped(7, ID.class);
    }


    /**
     * Returns Adresse (component 9).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public AD getAdresse() {
       return getTyped(8, AD.class);
    }

    
    /**
     * Returns Adresse (component 9).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public AD getCn9_Adresse() {
       return getTyped(8, AD.class);
    }


    /**
     * Returns Telefon (component 10).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public TN getTelefon() {
       return getTyped(9, TN.class);
    }

    
    /**
     * Returns Telefon (component 10).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public TN getCn10_Telefon() {
       return getTyped(9, TN.class);
    }


    /**
     * Returns Faxnummer (component 11).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public TN getFaxnummer() {
       return getTyped(10, TN.class);
    }

    
    /**
     * Returns Faxnummer (component 11).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public TN getCn11_Faxnummer() {
       return getTyped(10, TN.class);
    }


    /**
     * Returns Online-Nummer (component 12).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public TN getOnlineNummer() {
       return getTyped(11, TN.class);
    }

    
    /**
     * Returns Online-Nummer (component 12).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public TN getCn12_OnlineNummer() {
       return getTyped(11, TN.class);
    }


    /**
     * Returns E-Mail (component 13).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ST getEMail() {
       return getTyped(12, ST.class);
    }

    
    /**
     * Returns E-Mail (component 13).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ST getCn13_EMail() {
       return getTyped(12, ST.class);
    }



}

