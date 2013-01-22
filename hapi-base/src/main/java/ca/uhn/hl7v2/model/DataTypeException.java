/**
The contents of this file are subject to the Mozilla Public License Version 1.1 
(the "License"); you may not use this file except in compliance with the License. 
You may obtain a copy of the License at http://www.mozilla.org/MPL/ 
Software distributed under the License is distributed on an "AS IS" basis, 
WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the 
specific language governing rights and limitations under the License. 

The Original Code is "DataTypeException.java".  Description: 
"Represents a problem with the validity of a data type, such as an attempt 
  to set the value of a primitive type to something invalid for that type" 

The Initial Developer of the Original Code is University Health Network. Copyright (C) 
2001.  All Rights Reserved. 

Contributor(s): ______________________________________. 

Alternatively, the contents of this file may be used under the terms of the 
GNU General Public License (the "GPL"), in which case the provisions of the GPL are 
applicable instead of those above.  If you wish to allow use of your version of this 
file only under the terms of the GPL and not to allow others to use your version 
of this file under the MPL, indicate your decision by deleting  the provisions above 
and replace  them with the notice and other provisions required by the GPL License.  
If you do not delete the provisions above, a recipient may use your version of 
this file under either the MPL or the GPL. 

*/

package ca.uhn.hl7v2.model;

import ca.uhn.hl7v2.ErrorCode;
import ca.uhn.hl7v2.HL7Exception;

/**
 * Represents a problem with the validity of a data type, such as an attempt 
 * to set the value of a primitive type to something invalid for that type. 
 * @author Bryan Tripp (bryan_tripp@sourceforge.net)
 */ 
@SuppressWarnings("serial")
public class DataTypeException extends HL7Exception {


    /**
     * @param message
     * @param errorCondition
     * @param cause
     * @deprecated
     */
    public DataTypeException(String message, int errorCondition, Throwable cause) {
        super(message, errorCondition, cause);
    }
    
    public DataTypeException(String message, ErrorCode error, Throwable cause) {
		super(message, error, cause);
	}

	/**
     * @param message
     * @param errorCondition
     * @deprecated
     */
    public DataTypeException(String message, int errorCondition) {
        super(message, errorCondition);
    }

	public DataTypeException(String message, ErrorCode error) {
		super(message, error);
	}    

    public DataTypeException(String message, Throwable cause) {
        super(message, cause);
    }

    public DataTypeException( Throwable cause ) {
        super(cause);
    }

    public DataTypeException(String message) {
        super(message);
    }

} 