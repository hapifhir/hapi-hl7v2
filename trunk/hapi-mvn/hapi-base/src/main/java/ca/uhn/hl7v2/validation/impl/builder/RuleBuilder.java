package ca.uhn.hl7v2.validation.impl.builder;

import ca.uhn.hl7v2.Version;
import ca.uhn.hl7v2.validation.Rule;
import ca.uhn.hl7v2.validation.impl.builder.ValidationRuleBuilder.VersionExpressionBuilder;

public interface RuleBuilder {

	<T extends Rule<?>> RuleTypeBuilder<T> forVersion(Version... version);

	<T extends Rule<?>> RuleTypeBuilder<T> forVersion(String... version);

	VersionExpressionBuilder forVersion();

	<T extends Rule<?>> RuleTypeBuilder<T> forAllVersions();

}