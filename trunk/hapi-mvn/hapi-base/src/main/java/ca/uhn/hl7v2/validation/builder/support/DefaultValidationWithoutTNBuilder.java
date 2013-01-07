/**
The contents of this file are subject to the Mozilla Public License Version 1.1 
(the "License"); you may not use this file except in compliance with the License. 
You may obtain a copy of the License at http://www.mozilla.org/MPL/ 
Software distributed under the License is distributed on an "AS IS" basis, 
WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the 
specific language governing rights and limitations under the License. 

The Original Code is "DefaultValidationWithoutTNBuilder.java".  Description: 
"Builder for what was DefaultValidationWithoutTN before" 

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

import ca.uhn.hl7v2.Version;
import ca.uhn.hl7v2.validation.builder.ValidationRuleBuilder;

/**
 * Builder implementing the default validation rules as described in the
 * HL7 standard except for the TN data type, which is not appropriate anywhere
 * outside the U.S.
 * 
 * @author Christian Ohr
 */
@SuppressWarnings("serial")
public class DefaultValidationWithoutTNBuilder extends ValidationRuleBuilder {

	/**
	 * @see ca.uhn.hl7v2.validation.builder.ValidationRuleBuilder#configure()
	 */
	protected void configure() {
		
		forAllVersions()
			.message().all().choiceElementsRespected()
			.primitive("FT").leftTrim(maxLength(32000))
			.primitive("ST").leftTrim()
			.primitive("TX").rightTrim()
			.primitive("ID", "IS").is(maxLength(200))
			.primitive("SI").is(emptyOr(nonNegativeInteger()))
			.primitive("NM").is(emptyOr(number()))
			.primitive("DT")
				.refersToSection("Version 2.5 Section 2.A.21")
				.is(emptyOr(date()))
			.primitive("TM")
				.refersToSection("Version 2.5 Section 2.A.75")
				.is(emptyOr(time()))
			.primitive("NULLDT").is(withdrawn());
		
		forVersion().before(Version.V25)
			.primitive("TSComponentOne")
				.refersToSection("Version 2.4 Section 2.9.47")
				.is(emptyOr(dateTime()));
		
		forVersion().asOf(Version.V25)
			.primitive("TSComponentOne", "DTM")
				.refersToSection("Version 2.5 Section 2.A.22")
				.is(emptyOr(dateTime25()));
	}
}
