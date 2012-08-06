package ca.uhn.hl7v2.util;

import java.io.File;
import java.io.IOException;

import org.junit.After;
import org.junit.Test;

import static org.junit.Assert.*;

public class MessageIDGeneratorTest {

	@Test
	public void testNeverFail() throws IOException {

		MessageIDGenerator.getInstance().getNewID();
		MessageIDGenerator.getInstance().getNewID();

		File file = new File(MessageIDGenerator.DEFAULT_ID_FILE);

		try {

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
			instance.initialize();

			String id = instance.getNewID();

			assertEquals("1", id);
		} finally {
			if (file != null) {
				file.setWritable(true);
				file.setReadable(true);
			}
		}
	}

}
