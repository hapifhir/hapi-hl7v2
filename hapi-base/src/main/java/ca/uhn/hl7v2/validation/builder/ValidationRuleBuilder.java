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
public class ValidationRuleBuilder extends RuleTypeBuilder<ValidationRuleBuilder, Rule<?>> {

	protected ValidationRuleBuilder() {
		super();
	}

	private ValidationRuleBuilder(List<RuleBinding<? extends Rule<?>>> rules, Version... versions) {
		super(rules, versions);
	}

	public final void initialize() {
		if (rules.isEmpty()) configure();
	}

	/**
	 * Extend this method to add validation rules to the builder
	 */
	protected void configure() {
	}

	public ValidationRuleBuilder forVersion(
			Version... version) {
		return new ValidationRuleBuilder(rules, version);
	}

	public ValidationRuleBuilder forVersion(
			String... version) {
		Version[] versions = new Version[version.length];
		for (int i = 0; i < versions.length; i++) {
			versions[i] = Version.versionOf(version[i]);
		}
		return new ValidationRuleBuilder(rules, versions);
	}

	public VersionExpressionBuilder forVersion() {
		return new VersionExpressionBuilder();
	}

	public ValidationRuleBuilder forAllVersions() {
		return forVersion().all();
	}

	/**
	 * Helper builder when the versions are not given explicitly but in form of an expression.
	 */
	public class VersionExpressionBuilder {

		public ValidationRuleBuilder all() {
			return new ValidationRuleBuilder(rules, Version.values());
		}

		public ValidationRuleBuilder asOf(
				String version) {
			return asOf(Version.versionOf(version));
		}

		public ValidationRuleBuilder asOf(
				Version version) {
			return new ValidationRuleBuilder(rules, Version.asOf(version));
		}

		public ValidationRuleBuilder before(
				String version) {
			return before(Version.versionOf(version));
		}

		public ValidationRuleBuilder before(
				Version version) {
			return new ValidationRuleBuilder(rules, Version.before(version));
		}

		public ValidationRuleBuilder except(
				String version) {
			return except(Version.versionOf(version));
		}

		public ValidationRuleBuilder except(
				Version version) {
			return new ValidationRuleBuilder(rules, Version.except(version));
		}

	}

}
