/**
The contents of this file are subject to the Mozilla Public License Version 1.1 
(the "License"); you may not use this file except in compliance with the License. 
You may obtain a copy of the License at http://www.mozilla.org/MPL/ 
Software distributed under the License is distributed on an "AS IS" basis, 
WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the 
specific language governing rights and limitations under the License. 

The Original Code is "HL7Exception.java".  Description: 
"Represents an exception encountered while processing 
  an HL7 message" 

The Initial Developer of the Original Code is University Health Network. Copyright (C) 
2001.  All Rights Reserved. 

Contributor(s): ______________________________________. 

Alternatively, the contents of this file may be used under the terms of the 
GNU General Public License (the  "GPL"), in which case the provisions of the GPL are 
applicable instead of those above.  If you wish to allow use of your version of this 
file only under the terms of the GPL and not to allow others to use your version 
of this file under the MPL, indicate your decision by deleting  the provisions above 
and replace  them with the notice and other provisions required by the GPL License.  
If you do not delete the provisions above, a recipient may use your version of 
this file under either the MPL or the GPL. 

 */

package ca.uhn.hl7v2;


/**
 * Represents an exception encountered while processing an HL7 message.
 * 
 * @author Bryan Tripp (bryan_tripp@sourceforge.net)
 */
@SuppressWarnings("serial")
public class HL7Exception extends AbstractHL7Exception {

	/** Original mode: Application Accept - Enhanced mode: Application acknowledgment: Accept
     *
     * @deprecated use {@link AcknowledgmentCode}
     */
	public static final int ACK_AA = 1;

	/** Original mode: Application Error - Enhanced mode: Application acknowledgment: Error
    *
    * @deprecated use {@link AcknowledgmentCode}
    */
    public static final int ACK_AE = 2;

	/** Original mode: Application Reject - Enhanced mode: Application acknowledgment: Reject 
     *
     * @deprecated use {@link AcknowledgmentCode}
     */	
    public static final int ACK_AR = 3;

	/** Enhanced mode: Accept acknowledgment: Commit Accept 
     *
     * @deprecated use {@link AcknowledgmentCode}
     */	
    public static final int ACK_CA = 4;

	/** Enhanced mode: Accept acknowledgment: Commit Error 
     *
     * @deprecated use {@link AcknowledgmentCode}
     */	
    public static final int ACK_CE = 5;

	/** Enhanced mode: Accept acknowledgment: Commit Reject 
     *
     * @deprecated use {@link AcknowledgmentCode}
     */	
    public static final int ACK_CR = 6;

	/**
	 * @deprecated use {@link ErrorCode}
	 */
	public static final int MESSAGE_ACCEPTED = 0;
	/**
	 * @deprecated use {@link ErrorCode}
	 */	
	public static final int SEGMENT_SEQUENCE_ERROR = 100;
	/**
	 * @deprecated use {@link ErrorCode}
	 */	
	public static final int REQUIRED_FIELD_MISSING = 101;
	/**
	 * @deprecated use {@link ErrorCode}
	 */	
	public static final int DATA_TYPE_ERROR = 102;
	/**
	 * @deprecated use {@link ErrorCode}
	 */	
	public static final int TABLE_VALUE_NOT_FOUND = 103;
	/**
	 * @deprecated use {@link ErrorCode}
	 */
	public static final int UNSUPPORTED_MESSAGE_TYPE = 200;
	/**
	 * @deprecated use {@link ErrorCode}
	 */
	public static final int UNSUPPORTED_EVENT_CODE = 201;
	/**
	 * @deprecated use {@link ErrorCode}
	 */
	public static final int UNSUPPORTED_PROCESSING_ID = 202;
	/**
	 * @deprecated use {@link ErrorCode}
	 */
	public static final int UNSUPPORTED_VERSION_ID = 203;
	/**
	 * @deprecated use {@link ErrorCode}
	 */
	public static final int UNKNOWN_KEY_IDENTIFIER = 204;
	/**
	 * @deprecated use {@link ErrorCode}
	 */
	public static final int DUPLICATE_KEY_IDENTIFIER = 205;
	/**
	 * @deprecated use {@link ErrorCode}
	 */
	public static final int APPLICATION_RECORD_LOCKED = 206;
	/**
	 * @deprecated use {@link ErrorCode}
	 */
	public static final int APPLICATION_INTERNAL_ERROR = 207;

	private Object detail;
	
	
	/**
	 * Creates an HL7Exception.
	 * 
	 * @param errorCondition a code describing the the error condition, from HL7 table 0357 (see
	 *            section 2.16.8 of standard v 2.4) - ErrorCode defines these codes 
	 *            that can be used here (e.g. ErrorCode.UNSUPPORTED_MESSAGE_TYPE.getCode())
	 * 
	 * @param cause The exception that caused this exception to be thrown.
	 * @deprecated use HL7Exception(String, ErrorCode, Throwable)
	 */
	public HL7Exception(String message, int errorCondition, Throwable cause) {
		super(message, cause);
		setErrorCode(errorCondition);
	}
	
	/**
	 * Creates an HL7Exception.
	 * @param message error message
	 * @param error a code describing the the error condition, from HL7 table 0357 (see
	 *            section 2.16.8 of standard v 2.4)
	 * 
	 * @param cause The exception that caused this exception to be thrown.
	 */
	public HL7Exception(String message, ErrorCode error, Throwable cause) {
		super(message, cause);
		setError(error);
	}

	/**
	 * Creates an HL7Exception.
	 * 
	 * @param errorCondition a code describing the the error condition, from HL7 table 0357 (see
	 *            section 2.16.8 of standard v 2.4) - ErrorCode defines these codes 
	 *            that can be used here (e.g. ErrorCode.UNSUPPORTED_MESSAGE_TYPE.getCode())
	 * @deprecated use HL7Exception(String, ErrorCode)
	 */
	public HL7Exception(String message, int errorCondition) {
		super(message);
		setErrorCode(errorCondition);
	}
	
	/**
	 * Creates an HL7Exception.
	 *
     * @param message error message
	 * @param error a code describing the the error condition, from HL7 table 0357 (see
	 *            section 2.16.8 of standard v 2.4).
	 */
	public HL7Exception(String message, ErrorCode error) {
		super(message);
		setError(error);
	}	

	/**
	 * Creates an HL7Exception with the code APPLICATION_INTERNAL_ERROR
     *
	 * @param message error message
	 * @param cause The excption that caused this exception tobe thrown.
	 */
	public HL7Exception(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Creates an HL7Exception with the code APPLICATION_INTERNAL_ERROR
	 * 
	 * @param cause The excption that caused this exception tobe thrown.
	 */
	public HL7Exception(Throwable cause) {
		super(cause);
	}

	/**
	 * Creates an HL7Exception with the code APPLICATION_INTERNAL_ERROR
     *
     * @param message error message
	 */
	public HL7Exception(String message) {
		super(message);
	}

    public Object getDetail() {
        return detail;
    }

    /**
     * @param detail context details for this exception instance
     */
    public void setDetail(Object detail) {
        this.detail = detail;
    }

	

}