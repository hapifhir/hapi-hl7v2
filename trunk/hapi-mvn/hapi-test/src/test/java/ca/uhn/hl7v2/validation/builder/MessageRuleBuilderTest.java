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
import ca.uhn.hl7v2.validation.ValidationException;
import ca.uhn.hl7v2.validation.ValidationException.ErrorCode;
import ca.uhn.hl7v2.validation.impl.ConformanceProfileRule;

public class MessageRuleBuilderTest {

	private MessageRuleBuilder b1;

	@Before
	public void setUp() throws Exception {
		b1 = new ValidationRuleBuilder().forVersion("2.5").message("ADT", "A01");
	}

	@Test
	public void testTerser() throws HL7Exception, IOException {
		ADT_A01 a01 = new ADT_A01();
		a01.initQuickstart("ADT", "A01", "P");
		a01.getPID().getPatientName(0).getGivenName().setValue("GivenName");
		b1.terser("PID-5-2", b1.isEqual("GivenName"));
		MessageRule r = ((MessageRule) b1.getRules().iterator().next().getRule());
		assertEquals(0, r.apply(a01).length);
		a01.getPID().getPatientName(0).getGivenName().setValue("XX");
		ValidationException[] exceptions = r.apply(a01);
		assertEquals(1, exceptions.length);
		exceptions[0].printStackTrace();
	}

	@Test
	public void testOnlyKnownSegments() throws HL7Exception, IOException {
		ADT_A01 a01 = new ADT_A01();
		a01.initQuickstart("ADT", "A01", "P");
		b1.onlyKnownSegments();
		MessageRule r = ((MessageRule) b1.getRules().iterator().next().getRule());
		assertEquals(0, r.apply(a01).length);
		a01.addNonstandardSegment("XYZ");
		Terser.set((Segment)a01.get("XYZ"), 1, 0, 1, 1, "XX");
		assertEquals(1, r.apply(a01).length);
	}
	
	@Test
	public void testWrongVersion() throws HL7Exception, IOException {
		ADT_A01 a01 = new ADT_A01();
		a01.initQuickstart("ADT", "A01", "P");
		b1.wrongVersion();
		MessageRule r = ((MessageRule) b1.getRules().iterator().next().getRule());
		ValidationException[] ve = r.apply(a01);
		assertEquals(1, ve.length);
		assertTrue(ve[0].getLocation().toString().contains("MSH-12"));
		assertEquals(ErrorCode.UNSUPPORTED_VERSION_ID, ve[0].getErrorCode());
	}	

	@Test
	public void testConformance() {
		b1.conformance();
		ConformanceProfileRule r = (ConformanceProfileRule)b1.getRules().iterator().next().getRule();
		assertNull(r.getProfileID());
	}

	@Test
	public void testConformanceString() {
		b1.conformance("XX");
		ConformanceProfileRule r = (ConformanceProfileRule)b1.getRules().iterator().next().getRule();
		assertEquals("XX", r.getProfileID());
	}

}
