package ca.uhn.hl7v2.validation.builder;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.model.Segment;
import ca.uhn.hl7v2.model.v25.message.ADT_A01;
import ca.uhn.hl7v2.util.Terser;
import ca.uhn.hl7v2.validation.MessageRule;
import ca.uhn.hl7v2.validation.impl.ConformanceProfileRule;

public class MessageRuleBuilderTest {

	private MessageRuleBuilder b;

	@Before
	public void setUp() throws Exception {
		b = new ValidationRuleBuilder().forVersion("2.5").message("ADT", "A01");
	}

	@Test
	public void testTerser() throws HL7Exception, IOException {
		ADT_A01 a01 = new ADT_A01();
		a01.initQuickstart("ADT", "A01", "P");
		a01.getPID().getPatientName(0).getGivenName().setValue("GivenName");
		b.terser("PID-5-2", b.isEqual("GivenName"));
		MessageRule r = ((MessageRule) b.getRules().iterator().next().getRule());
		assertEquals(0, r.apply(a01).length);
		a01.getPID().getPatientName(0).getGivenName().setValue("XX");
		assertEquals(1, r.apply(a01).length);
	}

	@Test
	public void testOnlyKnownSegments() throws HL7Exception, IOException {
		ADT_A01 a01 = new ADT_A01();
		a01.initQuickstart("ADT", "A01", "P");
		b.onlyKnownSegments();
		MessageRule r = ((MessageRule) b.getRules().iterator().next().getRule());
		assertEquals(0, r.apply(a01).length);
		a01.addNonstandardSegment("XYZ");
		Terser.set((Segment)a01.get("XYZ"), 1, 0, 1, 1, "XX");
		assertEquals(1, r.apply(a01).length);
	}

	@Test
	public void testConformance() {
		b.conformance();
		ConformanceProfileRule r = (ConformanceProfileRule)b.getRules().iterator().next().getRule();
		assertNull(r.getProfileID());
	}

	@Test
	public void testConformanceString() {
		b.conformance("XX");
		ConformanceProfileRule r = (ConformanceProfileRule)b.getRules().iterator().next().getRule();
		assertEquals("XX", r.getProfileID());
	}

}
