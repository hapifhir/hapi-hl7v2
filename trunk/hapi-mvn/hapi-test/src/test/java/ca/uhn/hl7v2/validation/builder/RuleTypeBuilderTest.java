package ca.uhn.hl7v2.validation.builder;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertSame;

import org.junit.Before;
import org.junit.Test;

import ca.uhn.hl7v2.validation.Rule;
import ca.uhn.hl7v2.validation.ValidationException;
import ca.uhn.hl7v2.validation.impl.RuleBinding;

public class RuleTypeBuilderTest {

	private ValidationRuleBuilder b;

	@Before
	public void setUp() throws Exception {
		b = new ValidationRuleBuilder().forAllVersions();
	}

	@Test
	public void testPrimitive() {
		assertTrue(b.primitive("ST").getTypes().contains("ST"));
		assertEquals(1, b.primitive("ST", "ST").getTypes().size());
	}

	@Test
	public void testMessage() {
		assertEquals("ADT", b.message("ADT", "A01").getMessageType());
		assertEquals("A01", b.message("ADT", "A01").getTriggerEvent());
		assertEquals("*", b.message("ADT", "*").getTriggerEvent());
	}

	@Test
	public void testEncoding() {
		assertEquals("XML", b.encoding("XML").getEncoding());
	}

	@Test
	public void testGetRuleBindings() {
		assertTrue(b.getRuleBindings(new DummyRule(), "2.5").isEmpty());
	}

	public void testAddRuleBinding() {
		DummyRule rule = new DummyRule();
		b.addRuleBindings(rule);
		assertEquals(1, b.rules.size());
		RuleBinding<?> binding = b.rules.iterator().next();
		assertEquals(binding.getVersion(), b.getVersions().iterator().next().getVersion());
		assertSame(binding.getRule(), rule);
	}

	@SuppressWarnings("serial")
	private class DummyRule implements Rule<Object> {

		public String getDescription() {
			return null;
		}

		public String getSectionReference() {
			return null;
		}

		public ValidationException[] apply(Object value) {
			return null;
		}

	}
}
