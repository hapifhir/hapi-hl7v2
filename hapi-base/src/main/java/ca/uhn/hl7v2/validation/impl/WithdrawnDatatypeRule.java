package ca.uhn.hl7v2.validation.impl;

/**
 * <p>
 * Validation Rule which will not accept any content (i.e. length must be 0).
 * </p>
 * <p>
 * This class is expected to be used for withdrawn fields/components, and will
 * provide a failure description indicating that the type is withdrawn.
 * </p>
 * <p>
 * If you wish to disable this rule globally, invoke the following code:
 * </p>
 * <code>System.setProperty(ca.uhn.hl7v2.validation.impl.WithdrawnDatatypeRule.PROP_DISABLE_RULE, "true");</code>
 * </p> Note that this property is only checked the first time the class is
 * loaded (i.e. not at runtime). To disable for an individual parser at runtime,
 * call </p> <code>parser.setValidationContext(new NoValidation());</code>
 * 
 * @deprecated use {@link ca.uhn.hl7v2.validation.builder.BuilderSupport#withdrawn()} instead
 */
@SuppressWarnings("serial")
public class WithdrawnDatatypeRule extends SizeRule {

	/**
	 * Set the value of a system property to "true" to disable this rule
	 * globally.
	 */
	public static final String PROP_DISABLE_RULE = "ca.uhn.hl7v2.validation.impl.WithdrawnDatatypeRule";

	private static final int RULE_SIZE;

	static {
		if (Boolean.getBoolean(PROP_DISABLE_RULE)) {
			RULE_SIZE = Integer.MAX_VALUE;
		} else {
			RULE_SIZE = 0;
		}
	}

	/**
	 * Constructor
	 */
	public WithdrawnDatatypeRule() {
		super(RULE_SIZE);
	}

	/**
	 * {@inheritDoc}
	 */
	public String getDescription() {
		return "The field/component is withdrawn from the current HL7 version and should not be used. See the JavaDoc for WithdrawnDatatypeRule for information on disabling this rule.";
	}

}
