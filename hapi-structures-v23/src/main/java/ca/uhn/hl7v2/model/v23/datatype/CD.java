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
 * The Original Code is "CD.java".  Description:
 * "Composite class CD"
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

package ca.uhn.hl7v2.model.v23.datatype;

import ca.uhn.hl7v2.model.DataTypeException;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.Type;
import ca.uhn.hl7v2.model.AbstractComposite;


/**
 * <p>Represents an HL7 CD (Channel Definition (2.8.2)) data type. 
 * This type consists of the following components:</p>
 * <ul>
 * <li>channel identifier (CM_WVI)
 * <li>electrode names (CM_CD_ELECTRODE)
 * <li>channel sensitivity/units (CM_CSU)
 * <li>calibration parameters (CM_CCP)
 * <li>sampling frequency (NM)
 * <li>minimum/maximum data values (CM_MDV)
 * </ul>
 */
@SuppressWarnings("unused")
public class CD extends AbstractComposite {

    private Type[] data;

    /** 
     * Creates a new CD type
     */
    public CD(Message message) {
        super(message);
        init();
    }

    private void init() {
        data = new Type[6];    
        data[0] = new CM_WVI(getMessage());
        data[1] = new CM_CD_ELECTRODE(getMessage());
        data[2] = new CM_CSU(getMessage());
        data[3] = new CM_CCP(getMessage());
        data[4] = new NM(getMessage());
        data[5] = new CM_MDV(getMessage());
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
     * Returns channel identifier (component 1).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public CM_WVI getChannelIdentifier() {
       return getTyped(0, CM_WVI.class);
    }

    
    /**
     * Returns channel identifier (component 1).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public CM_WVI getCd1_ChannelIdentifier() {
       return getTyped(0, CM_WVI.class);
    }


    /**
     * Returns electrode names (component 2).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public CM_CD_ELECTRODE getElectrodeNames() {
       return getTyped(1, CM_CD_ELECTRODE.class);
    }

    
    /**
     * Returns electrode names (component 2).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public CM_CD_ELECTRODE getCd2_ElectrodeNames() {
       return getTyped(1, CM_CD_ELECTRODE.class);
    }


    /**
     * Returns channel sensitivity/units (component 3).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public CM_CSU getChannelSensitivityUnits() {
       return getTyped(2, CM_CSU.class);
    }

    
    /**
     * Returns channel sensitivity/units (component 3).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public CM_CSU getCd3_ChannelSensitivityUnits() {
       return getTyped(2, CM_CSU.class);
    }


    /**
     * Returns calibration parameters (component 4).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public CM_CCP getCalibrationParameters() {
       return getTyped(3, CM_CCP.class);
    }

    
    /**
     * Returns calibration parameters (component 4).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public CM_CCP getCd4_CalibrationParameters() {
       return getTyped(3, CM_CCP.class);
    }


    /**
     * Returns sampling frequency (component 5).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public NM getSamplingFrequency() {
       return getTyped(4, NM.class);
    }

    
    /**
     * Returns sampling frequency (component 5).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public NM getCd5_SamplingFrequency() {
       return getTyped(4, NM.class);
    }


    /**
     * Returns minimum/maximum data values (component 6).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public CM_MDV getMinimumMaximumDataValues() {
       return getTyped(5, CM_MDV.class);
    }

    
    /**
     * Returns minimum/maximum data values (component 6).  This is a convenience method that saves you from 
     * casting and handling an exception.
     */
    public CM_MDV getCd6_MinimumMaximumDataValues() {
       return getTyped(5, CM_MDV.class);
    }



}

