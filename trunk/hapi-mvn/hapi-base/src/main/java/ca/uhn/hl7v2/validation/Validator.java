/**
The contents of this file are subject to the Mozilla Public License Version 1.1 
(the "License"); you may not use this file except in compliance with the License. 
You may obtain a copy of the License at http://www.mozilla.org/MPL/ 
Software distributed under the License is distributed on an "AS IS" basis, 
WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the 
specific language governing rights and limitations under the License. 

The Original Code is "Validator.java".  Description: 
"Interface for validating messages." 

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

package ca.uhn.hl7v2.validation;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.model.Message;

/**
 * Interface to validates messages.
 * 
 * @author Bryan Tripp
 * @author Christian Ohr
 */
public interface Validator<R> {

	/**
	 * Validates a {@link Message}
	 * 
	 * @param message message to be validated
	 * @return <code>true</code> if message is valid
	 * @throws HL7Exception if an unexpected error occurs while validating
	 * @throws NullPointerException if the message is null
	 */
	public R validate(Message message) throws HL7Exception;

	/**
	 * 
	 * Validates a String representing an encoded message
	 * 
	 * @param message message to be validated
	 * @param isXML true if message is supposed to be XML
	 * @param version message version
	 * @return <code>true</code> if message is valid
	 * @throws HL7Exception if an unexpected error occurs while validating
	 * @throws NullPointerException if the message is null
	 */
	public R validate(String message, boolean isXML, String version) throws HL7Exception;

	/**
	 * Validates a {@link Message} using a custom {@link ValidationExceptionHandler}. The handler
	 * provides the possibility to react on the outcome of the validation process and its individual
	 * steps, e.g. collecting all validation, issues, aggregating them to a single issue, logging,
	 * throwing exceptions etc.
	 * <p>
	 * As the handler usually maintains state, a new instance is required for every validation call.
	 * 
	 * @param message message to be validated
	 * @param handler message validation handler
	 * @return <code>true</code> if message is valid
	 * @throws HL7Exception if an unexpected error occurs while validating
	 * @throws NullPointerException if the message or handler is <code>null</code>
	 */
	public R validate(Message message, ValidationExceptionHandler<R> handler)
			throws HL7Exception;

	/**
	 * 
	 * Validates a String representing an encoded message. As the handler usually maintains state, a
	 * new instance is required for every validation call.
	 * 
	 * @param message message to be validated
	 * @param isXML true if message is supposed to be XML
	 * @param version message version
	 * @param handler message validation handler
	 * @return <code>true</code> if message is valid
	 * @throws HL7Exception if an unexpected error occurs while validating
	 * @throws NullPointerException if the message or handler is <code>null</code>
	 */
	public R validate(String message, boolean isXML, String version,
			ValidationExceptionHandler<R> handler) throws HL7Exception;

}
