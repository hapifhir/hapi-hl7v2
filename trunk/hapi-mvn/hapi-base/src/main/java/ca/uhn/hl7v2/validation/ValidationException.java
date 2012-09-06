/**
The contents of this file are subject to the Mozilla Public License Version 1.1 
(the "License"); you may not use this file except in compliance with the License. 
You may obtain a copy of the License at http://www.mozilla.org/MPL/ 
Software distributed under the License is distributed on an "AS IS" basis, 
WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the 
specific language governing rights and limitations under the License. 

The Original Code is "ValidationException.java".  Description: 
"A failure to validate against a rule. " 

The Initial Developer of the Original Code is University Health Network. Copyright (C) 
2002.  All Rights Reserved. 

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

package ca.uhn.hl7v2.validation;

import ca.uhn.hl7v2.HL7Exception;

/**
 * A failure to validate against a rule.
 * 
 * @author Bryan Tripp
 */
@SuppressWarnings("serial")
public class ValidationException extends java.lang.Exception {

	private Location location;
	private ErrorCode errorCode = ErrorCode.APPLICATION_INTERNAL_ERROR;
	
	/**
	 * Creates a new instance of <code>ValidationException</code> without detail message.
	 */
	public ValidationException() {
	}

	/**
	 * @param message
	 * @param cause
	 */
	public ValidationException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param cause
	 */
	public ValidationException(Throwable cause) {
		super(cause);
	}

	/**
	 * Constructs an instance of <code>ValidationException</code> with the specified detail message.
	 * 
	 * @param msg the detail message.
	 */
	public ValidationException(String msg) {
		super(msg);
	}
	
	public static ValidationException fromHL7Exception(HL7Exception e) {
		ValidationException ve = new ValidationException(e.getMessage(), e);
		ve.setErrorCode(ErrorCode.errorCodeFor(e.getErrorCode()));
		ve.setLocation(new Location(e));
		return ve;
	}

	public ErrorCode getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(ErrorCode errorCode) {
		this.errorCode = errorCode;
	}	
	
	// More details about the validation error

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}
	

	@Override
	public String getMessage() {
		String message = super.getMessage();
		if (location != null) {
			String l = location.toString();
			if (l.length() > 0) {
				message += " at " + l;
			}
		}
		return message;
	}



	/**
	 * Error code table
	 *
	 */
	public enum ErrorCode {
		MESSAGE_ACCEPTED(0, "Message accepted"), 
		SEGMENT_SEQUENCE_ERROR(100, "Segment sequence error"), 
		REQUIRED_FIELD_MISSING(101, "Required field missing"), 
		DATA_TYPE_ERROR(102, "Data type error"), 
		TABLE_VALUE_NOT_FOUND(103, "Table value not found"),
		UNSUPPORTED_MESSAGE_TYPE(200, "Unsupported message type"),
		UNSUPPORTED_EVENT_CODE(201, "Unsupported event code"),
		UNSUPPORTED_PROCESSING_ID(202, "Unsupported processing id"),
		UNSUPPORTED_VERSION_ID(203, "Unsupported version id"),
		UNKNOWN_KEY_IDENTIFIER(204, "Unknown key identifier"),
		DUPLICATE_KEY_IDENTIFIER(205, "Duplicate key identifier"),
		APPLICATION_RECORD_LOCKED(206, "Application record locked"),
		APPLICATION_INTERNAL_ERROR(207, "Application internal error");

		private final int code;
		private final String message;

		ErrorCode(int errCode, String message) {
			this.code = errCode;
			this.message = message;
		}

		public int getCode() {
			return code;
		}

		public String getMessage() {
			return message;
		}

		public static ErrorCode errorCodeFor(int errCode) {
			for (ErrorCode err : ErrorCode.values()) {
				if (err.code == errCode) {
					return err;
				}
			}
			return null;
		}
		
		public static String errorCodeTable() {
			return "HL70357";
		}
	}
}
