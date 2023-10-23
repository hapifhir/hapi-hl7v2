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
 * The Original Code is "TQ.java".  Description:
 * "Composite class TQ"
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
 * <p>Represents an HL7 TQ (Timing Quantity) data type. 
 * This type consists of the following components:</p>
 * <ul>
 * <li>Quantity (CQ)
 * <li>Interval (RI)
 * <li>Duration (ST)
 * <li>Start Date/Time (TS)
 * <li>End Date/Time (TS)
 * <li>Priority (ST)
 * <li>Condition (ST)
 * <li>Text (TX)
 * <li>Conjunction (ID)
 * <li>Order Sequencing (OSD)
 * <li>Occurrence Duration (CE)
 * <li>Total Occurrences (NM)
 * </ul>
 */
@SuppressWarnings("unused")
public class TQ extends AbstractComposite {

    private Type[] data;

    /** 
     * Creates a new TQ type
     */
    public TQ(Message message) {
        super(message);
        init();
    }

    private void init() {
        data = new Type[12];    
        data[0] = new CQ(getMessage());
        data[1] = new RI(getMessage());
        data[2] = new ST(getMessage());
        data[3] = new TS(getMessage());
        data[4] = new TS(getMessage());
        data[5] = new ST(getMessage());
        data[6] = new ST(getMessage());
        data[7] = new TX(getMessage());
        data[8] = new ID(getMessage(), 472);
        data[9] = new OSD(getMessage());
        data[10] = new CE(getMessage());
        data[11] = new NM(getMessage());
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
     * Returns Quantity (component 1).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public CQ getQuantity() {
       return getTyped(0, CQ.class);
    }

    
    /**
     * Returns Quantity (component 1).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public CQ getTq1_Quantity() {
       return getTyped(0, CQ.class);
    }


    /**
     * Returns Interval (component 2).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public RI getInterval() {
       return getTyped(1, RI.class);
    }

    
    /**
     * Returns Interval (component 2).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public RI getTq2_Interval() {
       return getTyped(1, RI.class);
    }


    /**
     * Returns Duration (component 3).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ST getDuration() {
       return getTyped(2, ST.class);
    }

    
    /**
     * Returns Duration (component 3).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ST getTq3_Duration() {
       return getTyped(2, ST.class);
    }


    /**
     * Returns Start Date/Time (component 4).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public TS getStartDateTime() {
       return getTyped(3, TS.class);
    }

    
    /**
     * Returns Start Date/Time (component 4).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public TS getTq4_StartDateTime() {
       return getTyped(3, TS.class);
    }


    /**
     * Returns End Date/Time (component 5).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public TS getEndDateTime() {
       return getTyped(4, TS.class);
    }

    
    /**
     * Returns End Date/Time (component 5).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public TS getTq5_EndDateTime() {
       return getTyped(4, TS.class);
    }


    /**
     * Returns Priority (component 6).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ST getPriority() {
       return getTyped(5, ST.class);
    }

    
    /**
     * Returns Priority (component 6).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ST getTq6_Priority() {
       return getTyped(5, ST.class);
    }


    /**
     * Returns Condition (component 7).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ST getCondition() {
       return getTyped(6, ST.class);
    }

    
    /**
     * Returns Condition (component 7).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ST getTq7_Condition() {
       return getTyped(6, ST.class);
    }


    /**
     * Returns Text (component 8).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public TX getText() {
       return getTyped(7, TX.class);
    }

    
    /**
     * Returns Text (component 8).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public TX getTq8_Text() {
       return getTyped(7, TX.class);
    }


    /**
     * Returns Conjunction (component 9).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ID getConjunction() {
       return getTyped(8, ID.class);
    }

    
    /**
     * Returns Conjunction (component 9).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ID getTq9_Conjunction() {
       return getTyped(8, ID.class);
    }


    /**
     * Returns Order Sequencing (component 10).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public OSD getOrderSequencing() {
       return getTyped(9, OSD.class);
    }

    
    /**
     * Returns Order Sequencing (component 10).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public OSD getTq10_OrderSequencing() {
       return getTyped(9, OSD.class);
    }


    /**
     * Returns Occurrence Duration (component 11).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public CE getOccurrenceDuration() {
       return getTyped(10, CE.class);
    }

    
    /**
     * Returns Occurrence Duration (component 11).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public CE getTq11_OccurrenceDuration() {
       return getTyped(10, CE.class);
    }


    /**
     * Returns Total Occurrences (component 12).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public NM getTotalOccurrences() {
       return getTyped(11, NM.class);
    }

    
    /**
     * Returns Total Occurrences (component 12).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public NM getTq12_TotalOccurrences() {
       return getTyped(11, NM.class);
    }



}

