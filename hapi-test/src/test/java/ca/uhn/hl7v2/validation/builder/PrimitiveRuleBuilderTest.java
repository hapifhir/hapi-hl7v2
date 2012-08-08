package ca.uhn.hl7v2.validation.builder;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import ca.uhn.hl7v2.validation.ValidationException;
import ca.uhn.hl7v2.validation.impl.RuleBinding;

public class PrimitiveRuleBuilderTest {

	private static final String XX = "   XX";
	private PrimitiveRuleBuilder b;
	
	@Before
	public void setUp() throws Exception {
		b = new ValidationRuleBuilder().forVersion("2.5").primitive("ST");
	}

	@Test
	public void testIs() {
		b.is(b.maxLength(3));
		RuleBinding<?> binding = b.getRules().iterator().next();
		PredicatePrimitiveTypeRule r = (PredicatePrimitiveTypeRule)binding.getRule();
		assertEquals(1, r.apply(XX).length);
		assertEquals(XX, r.correct(XX));
	}

	@Test
	public void testTrimmedPredicate() {
		b.trimmed(b.maxLength(3));
		RuleBinding<?> binding = b.getRules().iterator().next();
		PredicatePrimitiveTypeRule r = (PredicatePrimitiveTypeRule)binding.getRule();
		assertEquals(0, r.apply(XX).length);
		assertEquals("XX", r.correct(XX));
	}

	@Test
	public void testTrimmed() throws ValidationException {
		b.trimmed();
		RuleBinding<?> binding = b.getRules().iterator().next();
		PredicatePrimitiveTypeRule r = (PredicatePrimitiveTypeRule)binding.getRule();
		assertTrue(r.getPredicate().evaluate(XX));
		assertEquals("XX", r.correct(XX));
	}

}
