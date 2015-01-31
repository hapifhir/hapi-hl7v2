package ca.uhn.hl7v2.validation.builder;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertSame;

import org.junit.Before;
import org.junit.Ignore;
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
		assertEquals("A01", b.message("ADT", "A01").getTriggerEvents()[0]);
        assertEquals("A04", b.message("ADT", "A01", "A04").getTriggerEvents()[1]);
		assertEquals("*", b.message("ADT", "*").getTriggerEvents()[0]);
	}

	@Test
	public void testEncoding() {
		assertEquals("XML", b.encoding("XML").getEncoding());
	}

	@Test
	public void testGetRuleBindings() {
		assertTrue(b.getRuleBindings(new DummyRule(), "2.5").isEmpty());
	}

    @Ignore
	public void testAddRuleBinding() {
		DummyRule rule = new DummyRule();
		b.addRuleBindings(rule);
		assertEquals(1, b.getRules().size());
		RuleBinding<?> binding = b.getRules().iterator().next();
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
