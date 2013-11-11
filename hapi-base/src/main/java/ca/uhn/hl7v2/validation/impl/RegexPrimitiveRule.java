/**
The contents of this file are subject to the Mozilla Public License Version 1.1 
(the "License"); you may not use this file except in compliance with the License. 
You may obtain a copy of the License at http://www.mozilla.org/MPL/ 
Software distributed under the License is distributed on an "AS IS" basis, 
WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the 
specific language governing rights and limitations under the License. 

The Original Code is "RegexPrimitiveRule.java".  Description: 
"A PrimitiveTypeRule that validates primitive values using a regular expression" 

The Initial Developer of the Original Code is University Health Network. Copyright (C) 
2004.  All Rights Reserved. 

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
package ca.uhn.hl7v2.validation.impl;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import ca.uhn.hl7v2.validation.ValidationException;

/**
 * A <code>PrimitiveTypeRule</code> that validates primitive values using a regular expression.
 * 
 * @author Bryan Tripp
 * @version $Revision: 1.1 $ updated on $Date: 2007-02-19 02:24:40 $ by $Author: jamesagnew $
 * 
 * @deprecated use {@link ca.uhn.hl7v2.validation.builder.BuilderSupport#matches(String)} instead
 */
@SuppressWarnings("serial")
public class RegexPrimitiveRule extends AbstractPrimitiveTypeRule {

	private final Pattern myPattern;
	private final String mySectionReference;

	/**
	 * @param theRegex a regular expression against which to validate primitive values
	 * @param theSectionReference to be returned by <code>getSectionReference()</code>
	 */
	public RegexPrimitiveRule(String theRegex, String theSectionReference) {
		myPattern = Pattern.compile(theRegex);
		mySectionReference = theSectionReference;
	}

	/**
	 * Empty string, null, and the HL7 explicit null (two double-quotes) are passed.
	 */
	public ValidationException[] apply(String value) {
		if (value == null || value.equals("\"\"") || value.equals("")) {
			return passed();
		}
		Matcher matcher = myPattern.matcher(value);
		return result(matcher.matches(), value);

	}

	/**
	 * @see ca.uhn.hl7v2.validation.Rule#getDescription()
	 */
	public String getDescription() {
		return "%s does not match the regular expression " + myPattern.pattern();
	}

	/**
	 * @see ca.uhn.hl7v2.validation.Rule#getSectionReference()
	 */
	public String getSectionReference() {
		return mySectionReference;
	}

}
