package ca.uhn.hl7v2.validation.builder;

import static ca.uhn.hl7v2.Version.V22;
import static ca.uhn.hl7v2.Version.V231;
import static ca.uhn.hl7v2.Version.V24;
import static ca.uhn.hl7v2.Version.V25;
import static ca.uhn.hl7v2.Version.V26;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import ca.uhn.hl7v2.Version;

public class ValidationRuleBuilderTest {

	private ValidationRuleBuilder b;

	@Before
	public void setup() {
		b = new ValidationRuleBuilder();
	}

	@Test
	public void testForVersionVersion() {
		assertTrue(b.forVersion(V22).versions.contains(V22));
		assertTrue(b.forVersion(V22, V25).versions.contains(V25));
		assertFalse(b.forVersion(V22, V25).versions.contains(V24));
		assertEquals(1, b.forVersion(V22, V22).versions.size());
	}

	@Test
	public void testForVersionString() {
		assertTrue(b.forVersion("2.2").versions.contains(V22));
		assertTrue(b.forVersion("2.2", "2.5").versions.contains(V25));
		assertFalse(b.forVersion("2.2", "2.5").versions.contains(V24));
		assertEquals(1, b.forVersion("2.2", "2.2").versions.size());
	}

	@Test
	public void testForAllVersions() {
		Set<Version> v = b.forAllVersions().versions;
		for (Version version : v) {
			assertTrue(Arrays.asList(Version.values()).contains(version));
		}
	}
	
	@Test
	public void testForVersionAsOf() {
		assertTrue(b.forVersion().asOf(V25).versions.contains(V25));
		assertTrue(b.forVersion().asOf(V25).versions.contains(V26));
		assertFalse(b.forVersion().asOf(V25).versions.contains(V231));
	}
	
	@Test
	public void testForVersionBeforeVersion() {
		assertFalse(b.forVersion().before(V25).versions.contains(V25));
		assertTrue(b.forVersion().before(V25).versions.contains(V231));
		assertFalse(b.forVersion().before(V25).versions.contains(V26));
	}
	
	@Test
	public void testForVersionBeforeString() {
		assertFalse(b.forVersion().before("2.5").versions.contains(V25));
		assertTrue(b.forVersion().before("2.5").versions.contains(V231));
		assertFalse(b.forVersion().before("2.5").versions.contains(V26));
	}

	@Test
	public void testForVersionExceptionVersion() {
		assertFalse(b.forVersion().except(V25).versions.contains(V25));
		assertTrue(b.forVersion().except(V25).versions.contains(V231));
		assertTrue(b.forVersion().except(V25).versions.contains(V26));
	}
	
	@Test
	public void testForVersionExceptString() {
		assertFalse(b.forVersion().except("2.5").versions.contains(V25));
		assertTrue(b.forVersion().except("2.5").versions.contains(V231));
		assertTrue(b.forVersion().except("2.5").versions.contains(V26));
	}	

}
