package ca.uhn.hl7v2.validation.impl.builder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import ca.uhn.hl7v2.Version;
import ca.uhn.hl7v2.validation.Rule;
import ca.uhn.hl7v2.validation.impl.RuleBinding;

/**
 * ValidationRuleBuilder
 */
@SuppressWarnings("serial")
public class ValidationRuleBuilder extends BuilderSupport {

	protected List<RuleBinding<? extends Rule>> rules = new ArrayList<RuleBinding<? extends Rule>>();
	
	public ValidationRuleBuilder() {
		super();
	}
	
	protected ValidationRuleBuilder(List<RuleBinding<? extends Rule>> rules) {
		this.rules = rules;
	}

	/**
	 * Overwrite this method to add validation rules to the builder
	 */
	public void configure() {
	}
	
	public List<RuleBinding<? extends Rule>> getRules() {
		return Collections.unmodifiableList(rules);
	}


	public <T extends Rule> RuleTypeBuilder<T> forVersion(Version... version) {
		return new RuleTypeBuilder<T>(rules, version);
	}

	public <T extends Rule> RuleTypeBuilder<T> forVersion(String... version) {
		Version[] versions = new Version[version.length];
		for (int i = 0; i < versions.length; i++) {
			versions[i] = Version.valueOf(version[i]);
		}
		return new RuleTypeBuilder<T>(rules, versions);
	}

	public VersionExpressionBuilder forVersion() {
		return new VersionExpressionBuilder();
	}

	public <T extends Rule> RuleTypeBuilder<T> forAllVersions() {
		return new RuleTypeBuilder<T>(rules, Version.values());
	}

	/**
	 * Helper builder when the versions are not given explicitly but in form of
	 * an expression.
	 */
	public class VersionExpressionBuilder {

		public <T extends Rule> RuleTypeBuilder<T> asOf(String version) {
			return asOf(Version.versionOf(version));
		}

		public <T extends Rule> RuleTypeBuilder<T> asOf(Version version) {
			return new RuleTypeBuilder<T>(rules, Version.asOf(version));
		}

		public <T extends Rule> RuleTypeBuilder<T> before(String version) {
			return before(Version.versionOf(version));
		}

		public <T extends Rule> RuleTypeBuilder<T> before(Version version) {
			return new RuleTypeBuilder<T>(rules, Version.before(version));
		}

		public <T extends Rule> RuleTypeBuilder<T> except(String version) {
			return except(Version.versionOf(version));
		}

		public <T extends Rule> RuleTypeBuilder<T> except(Version version) {
			return new RuleTypeBuilder<T>(rules, Version.except(version));
		}

	}

}
