package ca.uhn.hl7v2.util;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

import static org.junit.Assert.*;

public class MessageIDGeneratorTest {

	@Test
	public void testNeverFail() throws IOException {
		
		File file = new File(MessageIDGenerator.DEFAULT_ID_FILE);
		if (!file.delete()) {
			fail();
		}
		
		if (!file.createNewFile()) {
			fail();
		}
		
		file.setReadable(false);
		file.setWritable(false);
		
		System.setProperty(MessageIDGenerator.NEVER_FAIL_PROPERTY, Boolean.TRUE.toString());
		MessageIDGenerator instance = MessageIDGenerator.getInstance();
		String id = instance.getNewID();
		
		assertEquals("1", id);
		
	}
	
}
