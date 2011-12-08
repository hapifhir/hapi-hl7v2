/**
 * The contents of this file are subject to the Mozilla Public License Version 1.1
 * (the "License"); you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at http://www.mozilla.org/MPL/
 * Software distributed under the License is distributed on an "AS IS" basis,
 * WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the
 * specific language governing rights and limitations under the License.
 *
 * The Original Code is "AbstractConformanceDataType.java".  Description:
 * "This class contains the functionality for a Data Type in the Conformance class set"
 *
 * The Initial Developer of the Original Code is University Health Network. Copyright (C)
 * 2001.  All Rights Reserved.
 *
 * Contributor(s): James Agnew
 * Paul Brohman
 * Mitch Delachevrotiere
 * Shawn Dyck
 * Cory Metcalf
 *
 * Alternatively, the contents of this file may be used under the terms of the
 * GNU General Public License (the "GPL"), in which case the provisions of the GPL are
 * applicable instead of those above.  If you wish to allow use of your version of this
 * file only under the terms of the GPL and not to allow others to use your version
 * of this file under the MPL, indicate your decision by deleting  the provisions above
 * and replace  them with the notice and other provisions required by the GPL License.
 * If you do not delete the provisions above, a recipient may use your version of
 * this file under either the MPL or the GPL.
 *
 */

package ca.uhn.hl7v2.conf.classes.abs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ca.uhn.hl7v2.conf.classes.exceptions.ConfDataException;
import ca.uhn.hl7v2.model.DataTypeException;
import ca.uhn.hl7v2.model.Primitive;

/** This class contains the functionality for a Data Type in the Conformance class set
 * @author <table><tr>James Agnew</tr>
 *                <tr>Paul Brohman</tr>
 *                <tr>Mitch Delachevrotiere</tr>
 *                <tr>Shawn Dyck</tr>
 * 		  <tr>Cory Metcalf</tr></table>
 */
public abstract class AbstractConformanceDataType {
	
	private static final Logger log = LoggerFactory.getLogger(AbstractConformanceDataType.class);
    
    private Primitive hapiPrimitive;
    
    /** Constructor for AbstractConformanceDataType
     * @param hapiPrimitive the underlying primitive that the extending class represents
     */
    public AbstractConformanceDataType(Primitive hapiPrimitive) {
        this.hapiPrimitive = hapiPrimitive;
        
        try {
            if ( getConstantValue() != null )
                setValue( getConstantValue() );
        } catch ( ConfDataException e ) {
			log.error( "Could not enforce constant value.", e );
        }
    }
    
    /** This method returns the constant value for the extending class.
     *  @return the constant value
     */
    public abstract String getConstantValue();
    
    /** This method returns the Maximum length of the extending object.
     *  @return the maximum length
     */
    public abstract long getMaxLength();
    
    /** This method validates the <code>String</code> value passed in to be no greater then the
     * maximum allowable length for the extending class.  If the <code>String</code> value is valid, this
     * method will set the underlying HAPI class's value. If the data passed in is invalid for the given
     * data type, a ConfDataException is thrown.
     * @throws ConformaceException
     * @param value the value of the Data Type
     */
    protected void setValue(java.lang.String value) throws ConfDataException {
        if ((this.getMaxLength() > 0)
        && (value.length() > this.getMaxLength())) {
            throw new ConfDataException("DataType length exceeds the Maximum allowable length");
        }
        
        try {
            this.hapiPrimitive.setValue(value);
        } catch (DataTypeException e) {
            throw new ConfDataException("Invalid Data Populated");
        }
    }
    
}
