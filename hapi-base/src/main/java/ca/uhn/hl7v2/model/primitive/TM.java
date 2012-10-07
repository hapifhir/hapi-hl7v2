/**
 * The contents of this file are subject to the Mozilla Public License Version 1.1
 * (the "License"); you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at http://www.mozilla.org/MPL/
 * Software distributed under the License is distributed on an "AS IS" basis,
 * WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the
 * specific language governing rights and limitations under the License.
 *
 * The Original Code is "TM.java".  Description:
 * "Represents an HL7 TM (time) datatype."
 *
 * The Initial Developer of the Original Code is University Health Network. Copyright (C)
 * 2005.  All Rights Reserved.
 *
 * Contributor(s): ______________________________________.
 *
 * Alternatively, the contents of this file may be used under the terms of the
 * GNU General Public License (the "GPL"), in which case the provisions of the GPL are
 * applicable instead of those above.  If you wish to allow use of your version of this
 * file only under the terms of the GPL and not to allow others to use your version
 * of this file under the MPL, indicate your decision by deleting  the provisions above
 * and replace  them with the notice and other provisions required by the GPL License.
 * If you do not delete the provisions above, a recipient may use your version of
 * this file under either the MPL or the GPL.
 */
package ca.uhn.hl7v2.model.primitive;

import ca.uhn.hl7v2.model.AbstractPrimitive;
import ca.uhn.hl7v2.model.DataTypeException;
import ca.uhn.hl7v2.model.Message;

/**
 * Represents an HL7 TM (time) datatype. 
 * 
 * @author <a href="mailto:neal.acharya@uhn.on.ca">Neal Acharya</a>
 * @author <a href="mailto:bryan.tripp@uhn.on.ca">Bryan Tripp</a>
 * @version $Revision: 1.1 $ updated on $Date: 2007-02-19 02:24:51 $ by $Author: jamesagnew $
 */
@SuppressWarnings("serial")
public abstract class TM extends AbstractPrimitive {

    private CommonTM myDetail;
    
    /**
     * @param theMessage message to which this Type belongs
     */
    public TM(Message theMessage) {
        super(theMessage);
    }

    private CommonTM getDetail() throws DataTypeException {
        if (myDetail == null) {
            myDetail = new CommonTM(getValue());
        }
        return myDetail;
    }
    
    /**
     * @see AbstractPrimitive#setValue(java.lang.String)
     * @throws DataTypeException if the value is incorrectly formatted and either validation is 
     *      enabled for this primitive or detail setters / getters have been called, forcing further
     *      parsing.   
     */
    public void setValue(String theValue) throws DataTypeException {
        super.setValue(theValue);
        
        if (myDetail != null) {
            myDetail.setValue(theValue);
        }
    }
    
    /**
     * @see AbstractPrimitive#getValue
     */
    public String getValue() {
        String result = super.getValue();
        
        if (myDetail != null) {
            result = myDetail.getValue();
        }
        
        return result;
    }
    
    /**
     * @see CommonTM#setHourPrecision(int)
     * @throws DataTypeException if the value is incorrectly formatted.  If validation is enabled, this 
     *      exception should be thrown at setValue(), but if not, detailed parsing may be deferred until 
     *      this method is called.  
     */
    public void setHourPrecision(int hr) throws DataTypeException {
        getDetail().setHourPrecision(hr);       
    }    
    
    /**
     * @see CommonTM#setHourMinutePrecision(int, int)
     * @throws DataTypeException if the value is incorrectly formatted.  If validation is enabled, this 
     *      exception should be thrown at setValue(), but if not, detailed parsing may be deferred until 
     *      this method is called.  
     */
    public void setHourMinutePrecision(int hr, int min) throws DataTypeException {
        getDetail().setHourMinutePrecision(hr,min);        
    }
        
    /**
     * @see CommonTM#setHourMinSecondPrecision(int, int, float)
     * @throws DataTypeException if the value is incorrectly formatted.  If validation is enabled, this 
     *      exception should be thrown at setValue(), but if not, detailed parsing may be deferred until 
     *      this method is called.  
     */
    public void setHourMinSecondPrecision(int hr, int min, float sec) throws DataTypeException {
        getDetail().setHourMinSecondPrecision(hr,min,sec);        
    }
    
    /**
     * @see CommonTM#setOffset(int)
     * @throws DataTypeException if the value is incorrectly formatted.  If validation is enabled, this 
     *      exception should be thrown at setValue(), but if not, detailed parsing may be deferred until 
     *      this method is called.  
     */
    public void setOffset(int signedOffset) throws DataTypeException {
        getDetail().setOffset(signedOffset);        
    }
    
    /**
     * Returns the hour as an integer.
     * @throws DataTypeException if the value is incorrectly formatted.  If validation is enabled, this 
     *      exception should be thrown at setValue(), but if not, detailed parsing may be deferred until 
     *      this method is called.  
     */
    public int getHour() throws DataTypeException {
        return getDetail().getHour();
    }
    
    /**
     * Returns the minute as an integer.
     * @throws DataTypeException if the value is incorrectly formatted.  If validation is enabled, this 
     *      exception should be thrown at setValue(), but if not, detailed parsing may be deferred until 
     *      this method is called.  
     */
    public int getMinute() throws DataTypeException {
        return getDetail().getMinute();
    }
    
    /**
     * Returns the second as an integer.
     * @throws DataTypeException if the value is incorrectly formatted.  If validation is enabled, this 
     *      exception should be thrown at setValue(), but if not, detailed parsing may be deferred until 
     *      this method is called.  
     */
    public int getSecond() throws DataTypeException {
        return getDetail().getSecond();
    }
    
    /**
     * Returns the fractional second value as a float.
     * @throws DataTypeException if the value is incorrectly formatted.  If validation is enabled, this 
     *      exception should be thrown at setValue(), but if not, detailed parsing may be deferred until 
     *      this method is called.  
     */
    public float getFractSecond() throws DataTypeException {
        return getDetail().getFractSecond();
    }
    
    /**
     * Returns the GMT offset value as an integer.
     * @throws DataTypeException if the value is incorrectly formatted.  If validation is enabled, this 
     *      exception should be thrown at setValue(), but if not, detailed parsing may be deferred until 
     *      this method is called.  
     */
    public int getGMTOffset() throws DataTypeException {
        return getDetail().getGMTOffset();
    }
    
}
