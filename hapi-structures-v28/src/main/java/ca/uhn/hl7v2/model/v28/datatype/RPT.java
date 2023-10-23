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
 * The Original Code is "RPT.java".  Description:
 * "Composite class RPT"
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

package ca.uhn.hl7v2.model.v28.datatype;

import ca.uhn.hl7v2.model.DataTypeException;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.Type;
import ca.uhn.hl7v2.model.AbstractComposite;


/**
 * <p>Represents an HL7 RPT (Repeat Pattern) data type. 
 * This type consists of the following components:</p>
 * <ul>
 * <li>Repeat Pattern Code (CWE)
 * <li>Calendar Alignment (ID)
 * <li>Phase Range Begin Value (NM)
 * <li>Phase Range End Value (NM)
 * <li>Period Quantity (NM)
 * <li>Period Units (CWE)
 * <li>Institution Specified Time (ID)
 * <li>Event (ID)
 * <li>Event Offset Quantity (NM)
 * <li>Event Offset Units (CWE)
 * <li>General Timing Specification (GTS)
 * </ul>
 */
@SuppressWarnings("unused")
public class RPT extends AbstractComposite {

    private Type[] data;

    /** 
     * Creates a new RPT type
     */
    public RPT(Message message) {
        super(message);
        init();
    }

    private void init() {
        data = new Type[11];    
        data[0] = new CWE(getMessage());
        data[1] = new ID(getMessage(), 527);
        data[2] = new NM(getMessage());
        data[3] = new NM(getMessage());
        data[4] = new NM(getMessage());
        data[5] = new CWE(getMessage());
        data[6] = new ID(getMessage(), 136);
        data[7] = new ID(getMessage(), 528);
        data[8] = new NM(getMessage());
        data[9] = new CWE(getMessage());
        data[10] = new GTS(getMessage());
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
     * Returns Repeat Pattern Code (component 1).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public CWE getRepeatPatternCode() {
       return getTyped(0, CWE.class);
    }

    
    /**
     * Returns Repeat Pattern Code (component 1).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public CWE getRpt1_RepeatPatternCode() {
       return getTyped(0, CWE.class);
    }


    /**
     * Returns Calendar Alignment (component 2).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ID getCalendarAlignment() {
       return getTyped(1, ID.class);
    }

    
    /**
     * Returns Calendar Alignment (component 2).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ID getRpt2_CalendarAlignment() {
       return getTyped(1, ID.class);
    }


    /**
     * Returns Phase Range Begin Value (component 3).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public NM getPhaseRangeBeginValue() {
       return getTyped(2, NM.class);
    }

    
    /**
     * Returns Phase Range Begin Value (component 3).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public NM getRpt3_PhaseRangeBeginValue() {
       return getTyped(2, NM.class);
    }


    /**
     * Returns Phase Range End Value (component 4).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public NM getPhaseRangeEndValue() {
       return getTyped(3, NM.class);
    }

    
    /**
     * Returns Phase Range End Value (component 4).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public NM getRpt4_PhaseRangeEndValue() {
       return getTyped(3, NM.class);
    }


    /**
     * Returns Period Quantity (component 5).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public NM getPeriodQuantity() {
       return getTyped(4, NM.class);
    }

    
    /**
     * Returns Period Quantity (component 5).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public NM getRpt5_PeriodQuantity() {
       return getTyped(4, NM.class);
    }


    /**
     * Returns Period Units (component 6).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public CWE getPeriodUnits() {
       return getTyped(5, CWE.class);
    }

    
    /**
     * Returns Period Units (component 6).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public CWE getRpt6_PeriodUnits() {
       return getTyped(5, CWE.class);
    }


    /**
     * Returns Institution Specified Time (component 7).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ID getInstitutionSpecifiedTime() {
       return getTyped(6, ID.class);
    }

    
    /**
     * Returns Institution Specified Time (component 7).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ID getRpt7_InstitutionSpecifiedTime() {
       return getTyped(6, ID.class);
    }


    /**
     * Returns Event (component 8).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ID getEvent() {
       return getTyped(7, ID.class);
    }

    
    /**
     * Returns Event (component 8).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public ID getRpt8_Event() {
       return getTyped(7, ID.class);
    }


    /**
     * Returns Event Offset Quantity (component 9).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public NM getEventOffsetQuantity() {
       return getTyped(8, NM.class);
    }

    
    /**
     * Returns Event Offset Quantity (component 9).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public NM getRpt9_EventOffsetQuantity() {
       return getTyped(8, NM.class);
    }


    /**
     * Returns Event Offset Units (component 10).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public CWE getEventOffsetUnits() {
       return getTyped(9, CWE.class);
    }

    
    /**
     * Returns Event Offset Units (component 10).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public CWE getRpt10_EventOffsetUnits() {
       return getTyped(9, CWE.class);
    }


    /**
     * Returns General Timing Specification (component 11).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public GTS getGeneralTimingSpecification() {
       return getTyped(10, GTS.class);
    }

    
    /**
     * Returns General Timing Specification (component 11).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public GTS getRpt11_GeneralTimingSpecification() {
       return getTyped(10, GTS.class);
    }



}

