package ca.uhn.hl7v2.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import ca.uhn.hl7v2.Version;

public class GenericMessageTest {

	@Test
	public void testGetGenericMessageClass() {
		for (Version version : Version.values()) {
			Class<? extends Message> c = GenericMessage
					.getGenericMessageClass(version.getVersion());
			assertTrue(c.getSimpleName().endsWith(version.name()));
		}
	}

	@Test
	public void testGetGenericMessageClassForInvalidVersion() {
		assertEquals(GenericMessage.UnknownVersion.class,
				GenericMessage.getGenericMessageClass("2.29"));
	}
}
