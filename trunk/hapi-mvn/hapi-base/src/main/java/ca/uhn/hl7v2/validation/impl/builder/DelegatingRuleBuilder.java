package ca.uhn.hl7v2.validation.impl.builder;

/**
 * Delegating Rule Builder that additionally allows to delegate
 * rule building. 
 *
 * @author Christian Ohr
 */
@SuppressWarnings("serial")
public class DelegatingRuleBuilder extends ValidationRuleBuilder {

	private ValidationRuleBuilder delegate;

	public DelegatingRuleBuilder(ValidationRuleBuilder delegate) {
		super();
		this.delegate = delegate;
	}

	@Override
	public void configure() {
		delegate.configure();
	}

}
