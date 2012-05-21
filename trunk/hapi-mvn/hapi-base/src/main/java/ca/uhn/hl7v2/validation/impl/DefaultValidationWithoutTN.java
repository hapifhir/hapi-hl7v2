/**
The contents of this file are subject to the Mozilla Public License Version 1.1 
(the "License"); you may not use this file except in compliance with the License. 
You may obtain a copy of the License at http://www.mozilla.org/MPL/ 
Software distributed under the License is distributed on an "AS IS" basis, 
WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the 
specific language governing rights and limitations under the License. 

The Original Code is "DefaultValidationWithoutTN.java".  Description: 
"A ValidationContext with a default set of rules initially defined except for
the TN data type." 

The Initial Developer of the Original Code is University Health Network. Copyright (C) 
2012.  All Rights Reserved. 

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
package ca.uhn.hl7v2.validation.impl;

import ca.uhn.hl7v2.validation.PrimitiveTypeRule;

/**
 * A <code>ValidationContext</code> with a default set of rules initially
 * defined. This can be used as-is for a reasonable level of primitive type
 * validation.
 * 
 * @author <a href="mailto:bryan.tripp@uhn.on.ca">Bryan Tripp</a>
 * @author Christian Ohr
 */
@SuppressWarnings("serial")
public class DefaultValidationWithoutTN extends ValidationContextImpl {

	public DefaultValidationWithoutTN() {
		super();

		PrimitiveTypeRule trim = new TrimLeadingWhitespace();
		getPrimitiveRuleBindings().add(new RuleBinding<PrimitiveTypeRule>("*", "FT", trim));
		getPrimitiveRuleBindings().add(new RuleBinding<PrimitiveTypeRule>("*", "ST", trim));
		getPrimitiveRuleBindings().add(new RuleBinding<PrimitiveTypeRule>("*", "TX", trim));

		PrimitiveTypeRule size200 = new SizeRule(200);
		PrimitiveTypeRule size32000 = new SizeRule(32000);
		getPrimitiveRuleBindings().add(new RuleBinding<PrimitiveTypeRule>("*", "FT", size32000));
		getPrimitiveRuleBindings().add(new RuleBinding<PrimitiveTypeRule>("*", "ID", size200));
		getPrimitiveRuleBindings().add(new RuleBinding<PrimitiveTypeRule>("*", "IS", size200));

		PrimitiveTypeRule nonNegativeInteger = new RegexPrimitiveRule("\\d*", "");
		getPrimitiveRuleBindings().add(new RuleBinding<PrimitiveTypeRule>("*", "SI", nonNegativeInteger));

		PrimitiveTypeRule number = new RegexPrimitiveRule("(\\+|\\-)?\\d*\\.?\\d*", "");
		getPrimitiveRuleBindings().add(new RuleBinding<PrimitiveTypeRule>("*", "NM", number));

		String datePattern = "(\\d{4}([01]\\d(\\d{2})?)?)?"; // YYYY[MM[DD]]
		PrimitiveTypeRule date = new RegexPrimitiveRule(datePattern, "Version 2.5 Section 2.A.21");
		getPrimitiveRuleBindings().add(new RuleBinding<PrimitiveTypeRule>("*", "DT", date));

		String timePattern // HH[MM[SS[.S[S[S[S]]]]]][+/-ZZZZ]
		= "([012]\\d([0-5]\\d([0-5]\\d(\\.\\d(\\d(\\d(\\d)?)?)?)?)?)?)?([\\+\\-]\\d{4})?";
		PrimitiveTypeRule time = new RegexPrimitiveRule(timePattern, "Version 2.5 Section 2.A.75");
		getPrimitiveRuleBindings().add(new RuleBinding<PrimitiveTypeRule>("*", "TM", time));

		String datetimePattern // YYYY[MM[DD[HHMM[SS[.S[S[S[S]]]]]]]][+/-ZZZZ]
		= "(\\d{4}([01]\\d(\\d{2}([012]\\d[0-5]\\d([0-5]\\d(\\.\\d(\\d(\\d(\\d)?)?)?)?)?)?)?)?)?([\\+\\-]\\d{4})?";
		PrimitiveTypeRule datetime = new RegexPrimitiveRule(datetimePattern, "Version 2.4 Section 2.9.47");
		getPrimitiveRuleBindings().add(new RuleBinding<PrimitiveTypeRule>("2.2", "TSComponentOne", datetime));
		getPrimitiveRuleBindings().add(new RuleBinding<PrimitiveTypeRule>("2.3", "TSComponentOne", datetime));
		getPrimitiveRuleBindings().add(new RuleBinding<PrimitiveTypeRule>("2.3.1", "TSComponentOne", datetime));
		getPrimitiveRuleBindings().add(new RuleBinding<PrimitiveTypeRule>("2.4", "TSComponentOne", datetime));

		String datetimePattern25 // YYYY[MM[DD[HH[MM[SS[.S[S[S[S]]]]]]]]][+/-ZZZZ]
		= "(\\d{4}([01]\\d(\\d{2}([012]\\d([0-5]\\d([0-5]\\d(\\.\\d(\\d(\\d(\\d)?)?)?)?)?)?)?)?)?)?([\\+\\-]\\d{4})?";
		PrimitiveTypeRule datetime25 = new RegexPrimitiveRule(datetimePattern25, "Version 2.5 Section 2.A.22");
		getPrimitiveRuleBindings().add(new RuleBinding<PrimitiveTypeRule>("2.5", "TSComponentOne", datetime25));
		getPrimitiveRuleBindings().add(new RuleBinding<PrimitiveTypeRule>("2.5", "DTM", datetime25));
		getPrimitiveRuleBindings().add(new RuleBinding<PrimitiveTypeRule>("2.5.1", "TSComponentOne", datetime25));
		getPrimitiveRuleBindings().add(new RuleBinding<PrimitiveTypeRule>("2.5.1", "DTM", datetime25));
		getPrimitiveRuleBindings().add(new RuleBinding<PrimitiveTypeRule>("2.6", "TSComponentOne", datetime25));
		getPrimitiveRuleBindings().add(new RuleBinding<PrimitiveTypeRule>("2.6", "DTM", datetime25));
		
		// NULLDT shouldn't have a value
		getPrimitiveRuleBindings().add(new RuleBinding<PrimitiveTypeRule>("*", "NULLDT", new WithdrawnDatatypeRule()));
	}
}
