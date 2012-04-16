/**
The contents of this file are subject to the Mozilla Public License Version 1.1 
(the "License"); you may not use this file except in compliance with the License. 
You may obtain a copy of the License at http://www.mozilla.org/MPL/ 
Software distributed under the License is distributed on an "AS IS" basis, 
WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the 
specific language governing rights and limitations under the License. 

The Original Code is "Rule.java".  Description: 
"A testable rule to which HL7 messages should conform" 

The Initial Developer of the Original Code is University Health Network. Copyright (C) 
2002.  All Rights Reserved. 

Contributor(s): ______________________________________. 

Alternatively, the contents of this file may be used under the terms of the 
GNU General Public License (the  �GPL�), in which case the provisions of the GPL are 
applicable instead of those above.  If you wish to allow use of your version of this 
file only under the terms of the GPL and not to allow others to use your version 
of this file under the MPL, indicate your decision by deleting  the provisions above 
and replace  them with the notice and other provisions required by the GPL License.  
If you do not delete the provisions above, a recipient may use your version of 
this file under either the MPL or the GPL. 
 */

package ca.uhn.hl7v2.validation;

import java.io.Serializable;

/**
 * <p>
 * A testable rule to which HL7 messages (at least certain specific message)
 * should conform. This is the central interface of the new HAPI validation
 * model (as of HAPI 0.4). Previously, the only run-time message validation HAPI
 * performs is within the setValue() methods of the Primitive datatype classes.
 * For example when you called setValue() on a DT an exception was thrown if the
 * String arg was not in the correct DT format. This method served well
 * initially but left us with the following limitations:
 * <ol>
 * <li>Sometimes validation is inappropriate (e.g. some of the standard rules,
 * like phone number format, don't make sense in some regions).</li>
 * <li>Couldn't add further optional constraints (such as all timestamps must
 * have a time zone).</li>
 * <li>Couldn't turn off validation to improve performance.</li>
 * <li>Other forms of validation (e.g. conformance profiles, standard DTDs) were
 * not covered.</li>
 * </ol>
 * </p>
 * <p>
 * Thus the new validation model is broader in scope, and is based on validation
 * rules implemented as Rule objects, which can be configured to run or not, as
 * needed, depending on run-time configuration.
 * </p>
 * <p>
 * There are three kinds of rules:
 * <ol>
 * <li>PrimitiveTypeRule: Called when the values of simple datatypes are set,
 * like the existing hard-coded datatype validations (e.g.
 * TNFollowsNorthAmericanFormat).</li>
 * <li>MessageRule: Called when complete message content is to be checked on a
 * parsed message (e.g. conformance profile).</li>
 * <li>EncodingRule: Applied to an encoded message (e.g. validation against a
 * 2.xml Schema, a rule that prohibits empty tags, etc.).</li>
 * </ol>
 * </p>
 * 
 * @author Bryan Tripp
 */
public interface Rule extends Serializable {

	/**
	 * Returns a text description of the rule. This description may be used as a
	 * message in exceptions generated if validation against the rule fails, or
	 * in a user interface for rule configuration.
	 */
	public String getDescription();

	/**
	 * A string indicating the section of the HL7 standard from which this rule
	 * is derived (if applicable). Like the description, this may be used in an
	 * exception message or configuration UI.
	 */
	public String getSectionReference();
		

}
