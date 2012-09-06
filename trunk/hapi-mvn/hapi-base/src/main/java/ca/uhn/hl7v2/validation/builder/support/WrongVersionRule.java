/**
The contents of this file are subject to the Mozilla Public License Version 1.1 
(the "License"); you may not use this file except in compliance with the License. 
You may obtain a copy of the License at http://www.mozilla.org/MPL/ 
Software distributed under the License is distributed on an "AS IS" basis, 
WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the 
specific language governing rights and limitations under the License. 

The Original Code is "WrongVersionRule.java".  Description: 
"Validation rule for blaming a wring HL7 version"

The Initial Developer of the Original Code is University Health Network. Copyright (C) 
2012.  All Rights Reserved. 

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
package ca.uhn.hl7v2.validation.builder.support;

import java.util.ArrayList;
import java.util.List;

import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.validation.Location;
import ca.uhn.hl7v2.validation.MessageRule;
import ca.uhn.hl7v2.validation.ValidationException;
import ca.uhn.hl7v2.validation.ValidationException.ErrorCode;
import ca.uhn.hl7v2.validation.impl.AbstractMessageRule;

/**
 * Validation rule for blaming a wring HL7 version
 * 
 * @author Christian Ohr
 */
@SuppressWarnings("serial")
public class WrongVersionRule extends AbstractMessageRule {

	public static final MessageRule WRONG_VERSION = new WrongVersionRule();
	
	public ValidationException[] apply(Message msg) {
		List<ValidationException> exceptions = new ArrayList<ValidationException>();

		ValidationException ve = new ValidationException("Invalid version: " + msg.getVersion());
		Location location = new Location();
		location.setSegmentName("MSH");
		location.setField(12);
		ve.setLocation(location);
		ve.setErrorCode(ErrorCode.UNSUPPORTED_VERSION_ID);
		exceptions.add(ve);

		return exceptions.toArray(new ValidationException[exceptions.size()]);
	}

}