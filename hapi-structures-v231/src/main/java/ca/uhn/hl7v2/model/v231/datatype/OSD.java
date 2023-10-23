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
 * The Original Code is "OSD.java".  Description:
 * "Composite class OSD"
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

package ca.uhn.hl7v2.model.v231.datatype;

import ca.uhn.hl7v2.model.DataTypeException;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.Type;
import ca.uhn.hl7v2.model.AbstractComposite;


/**
 * <p>Represents an HL7 OSD (order sequence) data type. 
 * This type consists of the following components:</p>
 * <ul>
 * <li>sequence/results flag (ID)
 * <li>placer order number: entity identifier (ST)
 * <li>placer order number: namespace ID (IS)
 * <li>filler order number: entity identifier (ST)
 * <li>filler order number: namespace ID (IS)
 * <li>sequence condition value (ST)
 * <li>maximum number of repeats (NM)
 * <li>placer order number: universal ID (ST)
 * <li>placer order number; universal ID type (ID)
 * <li>filler order number: universal ID (ST)
 * <li>filler order number: universal ID type (ID)
 * </ul>
 */
@SuppressWarnings("unused")
public class OSD extends AbstractComposite {

    private Type[] data;

    /** 
     * Creates a new OSD type
     */
    public OSD(Message message) {
        super(message);
        init();
    }

    private void init() {
        data = new Type[11];    
        data[0] = new ID(getMessage(), 0);
        data[1] = new ST(getMessage());
        data[2] = new IS(getMessage(), 0);
        data[3] = new ST(getMessage());
        data[4] = new IS(getMessage(), 0);
        data[5] = new ST(getMessage());
        data[6] = new NM(getMessage());
        data[7] = new ST(getMessage());
        data[8] = new ID(getMessage(), 0);
        data[9] = new ST(getMessage());
        data[10] = new ID(getMessage(), 0);
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
     * Returns sequence/results flag (component 1).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ID getSequenceResultsFlag() {
       return getTyped(0, ID.class);
    }

    
    /**
     * Returns sequence/results flag (component 1).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ID getOsd1_SequenceResultsFlag() {
       return getTyped(0, ID.class);
    }


    /**
     * Returns placer order number: entity identifier (component 2).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ST getPlacerOrderNumberEntityIdentifier() {
       return getTyped(1, ST.class);
    }

    
    /**
     * Returns placer order number: entity identifier (component 2).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ST getOsd2_PlacerOrderNumberEntityIdentifier() {
       return getTyped(1, ST.class);
    }


    /**
     * Returns placer order number: namespace ID (component 3).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public IS getPlacerOrderNumberNamespaceID() {
       return getTyped(2, IS.class);
    }

    
    /**
     * Returns placer order number: namespace ID (component 3).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public IS getOsd3_PlacerOrderNumberNamespaceID() {
       return getTyped(2, IS.class);
    }


    /**
     * Returns filler order number: entity identifier (component 4).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ST getFillerOrderNumberEntityIdentifier() {
       return getTyped(3, ST.class);
    }

    
    /**
     * Returns filler order number: entity identifier (component 4).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ST getOsd4_FillerOrderNumberEntityIdentifier() {
       return getTyped(3, ST.class);
    }


    /**
     * Returns filler order number: namespace ID (component 5).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public IS getFillerOrderNumberNamespaceID() {
       return getTyped(4, IS.class);
    }

    
    /**
     * Returns filler order number: namespace ID (component 5).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public IS getOsd5_FillerOrderNumberNamespaceID() {
       return getTyped(4, IS.class);
    }


    /**
     * Returns sequence condition value (component 6).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ST getSequenceConditionValue() {
       return getTyped(5, ST.class);
    }

    
    /**
     * Returns sequence condition value (component 6).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ST getOsd6_SequenceConditionValue() {
       return getTyped(5, ST.class);
    }


    /**
     * Returns maximum number of repeats (component 7).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public NM getMaximumNumberOfRepeats() {
       return getTyped(6, NM.class);
    }

    
    /**
     * Returns maximum number of repeats (component 7).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public NM getOsd7_MaximumNumberOfRepeats() {
       return getTyped(6, NM.class);
    }


    /**
     * Returns placer order number: universal ID (component 8).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ST getPlacerOrderNumberUniversalID() {
       return getTyped(7, ST.class);
    }

    
    /**
     * Returns placer order number: universal ID (component 8).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ST getOsd8_PlacerOrderNumberUniversalID() {
       return getTyped(7, ST.class);
    }


    /**
     * Returns placer order number; universal ID type (component 9).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ID getPlacerOrderNumberUniversalIDType() {
       return getTyped(8, ID.class);
    }

    
    /**
     * Returns placer order number; universal ID type (component 9).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ID getOsd9_PlacerOrderNumberUniversalIDType() {
       return getTyped(8, ID.class);
    }


    /**
     * Returns filler order number: universal ID (component 10).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ST getFillerOrderNumberUniversalID() {
       return getTyped(9, ST.class);
    }

    
    /**
     * Returns filler order number: universal ID (component 10).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ST getOsd10_FillerOrderNumberUniversalID() {
       return getTyped(9, ST.class);
    }


    /**
     * Returns filler order number: universal ID type (component 11).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ID getFillerOrderNumberUniversalIDType() {
       return getTyped(10, ID.class);
    }

    
    /**
     * Returns filler order number: universal ID type (component 11).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ID getOsd11_FillerOrderNumberUniversalIDType() {
       return getTyped(10, ID.class);
    }



}

