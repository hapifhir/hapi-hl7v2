/**
The contents of this file are subject to the Mozilla Public License Version 1.1 
(the "License"); you may not use this file except in compliance with the License. 
You may obtain a copy of the License at http://www.mozilla.org/MPL/ 
Software distributed under the License is distributed on an "AS IS" basis, 
WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the 
specific language governing rights and limitations under the License. 

The Original Code is "EncodingRuleBuilder.java".  Description: 
"Rule Builder for EncodingRules." 

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
package ca.uhn.hl7v2.validation.builder;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import ca.uhn.hl7v2.Version;
import ca.uhn.hl7v2.validation.EncodingRule;
import ca.uhn.hl7v2.validation.Rule;
import ca.uhn.hl7v2.validation.impl.EncodingRuleBinding;
import ca.uhn.hl7v2.validation.impl.RuleBinding;
import ca.uhn.hl7v2.validation.impl.XMLSchemaRule;

/**
 * Rule builder for {@link EncodingRule}s.
 * 
 * @author Christian Ohr
 */
@SuppressWarnings("serial")
public class EncodingRuleBuilder extends RuleTypeBuilder<EncodingRuleBuilder, EncodingRule> {

	private String encoding;

	protected EncodingRuleBuilder(List<RuleBinding<? extends Rule<?>>> rules, Set<Version> versions,
			String encoding) {
		super(rules, versions);
		this.encoding = encoding;
	}

	/**
	 * Adds {@link XMLSchemaRule} for the configured versions
	 * 
	 * @return this instance to build more rules
	 */
	public EncodingRuleBuilder xsd() {
		return test(prepareRule(new XMLSchemaRule()));
	}	
	
	// for tests only
	String getEncoding() {
		return encoding;
	}

	@Override
	protected Collection<RuleBinding<EncodingRule>> getRuleBindings(EncodingRule rule,
			String version) {
		RuleBinding<EncodingRule> binding = new EncodingRuleBinding(version, encoding, rule);
		return activate(Collections.singletonList(binding));
	}

}
