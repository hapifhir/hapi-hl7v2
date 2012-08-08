/**
The contents of this file are subject to the Mozilla Public License Version 1.1 
(the "License"); you may not use this file except in compliance with the License. 
You may obtain a copy of the License at http://www.mozilla.org/MPL/ 
Software distributed under the License is distributed on an "AS IS" basis, 
WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the 
specific language governing rights and limitations under the License. 

The Original Code is "ValidationRuleBuilder.java".  Description: 
"RuleBuilder that determines which kind of rule shall be built" 

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
package ca.uhn.hl7v2.validation.builder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import ca.uhn.hl7v2.Version;
import ca.uhn.hl7v2.validation.Rule;
import ca.uhn.hl7v2.validation.impl.RuleBinding;

/**
 * Base class every rule builder starts with. All rules being built are bound to the HL7 versions
 * that are specified here.
 * 
 * @author Christian Ohr
 */
@SuppressWarnings("serial")
public class ValidationRuleBuilder extends BuilderSupport {

	protected List<RuleBinding<? extends Rule<?>>> rules = new ArrayList<RuleBinding<? extends Rule<?>>>();
	
	public ValidationRuleBuilder() {}
	
	protected ValidationRuleBuilder(List<RuleBinding<? extends Rule<?>>> rules) {
		this.rules = rules;
	}

	/**
	 * Implement this method to add validation rules to the builder
	 */
	public void configure() {
	}
	
	public List<RuleBinding<? extends Rule<?>>> getRules() {
		return Collections.unmodifiableList(rules);
	}

	/**
	 * Binds the rules to a subset of HL7 versions
	 * 
	 * @param version HL7 versions to bind the rules to
	 * @return RuleTypeBuilder instance to continue rule building
	 */	
	public <T extends Rule<?>> RuleTypeBuilder<T> forVersion(Version... version) {
		return new RuleTypeBuilder<T>(rules, version);
	}

	/**
	 * Binds the rules to a subset of HL7 versions
	 * 
	 * @param version HL7 versions to bind the rules to
	 * @return RuleTypeBuilder instance to continue rule building
	 */
	public <T extends Rule<?>> RuleTypeBuilder<T> forVersion(String... version) {
		Version[] versions = new Version[version.length];
		for (int i = 0; i < versions.length; i++) {
			versions[i] = Version.valueOf(version[i]);
		}
		return new RuleTypeBuilder<T>(rules, versions);
	}

	/**
	 * Binds the rules to a subset of HL7 versions
	 * 
	 * @return VersionExpressionBuilder instance to continue rule building
	 */
	public VersionExpressionBuilder forVersion() {
		return new VersionExpressionBuilder();
	}

	/**
	 * Binds the rules to all available HL7 versions
	 * 
	 * @return RuleTypeBuilder instance to continue rule building
	 */
	public <T extends Rule<?>> RuleTypeBuilder<T> forAllVersions() {
		return new RuleTypeBuilder<T>(rules, Version.values());
	}

	/**
	 * Helper builder when the versions are not given explicitly but in form of
	 * an expression.
	 */
	public class VersionExpressionBuilder {

		public <T extends Rule<?>> RuleTypeBuilder<T> asOf(String version) {
			return asOf(Version.versionOf(version));
		}

		public <T extends Rule<?>> RuleTypeBuilder<T> asOf(Version version) {
			return new RuleTypeBuilder<T>(rules, Version.asOf(version));
		}

		public <T extends Rule<?>> RuleTypeBuilder<T> before(String version) {
			return before(Version.versionOf(version));
		}

		public <T extends Rule<?>> RuleTypeBuilder<T> before(Version version) {
			return new RuleTypeBuilder<T>(rules, Version.before(version));
		}

		public <T extends Rule<?>> RuleTypeBuilder<T> except(String version) {
			return except(Version.versionOf(version));
		}

		public <T extends Rule<?>> RuleTypeBuilder<T> except(Version version) {
			return new RuleTypeBuilder<T>(rules, Version.except(version));
		}

	}

}
