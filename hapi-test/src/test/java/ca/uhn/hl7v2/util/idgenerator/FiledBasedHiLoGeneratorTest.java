package ca.uhn.hl7v2.util.idgenerator;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

import ca.uhn.hl7v2.util.Home;


public class FiledBasedHiLoGeneratorTest extends AbstractContinuousGeneratorTest<FileBasedHiLoGenerator> {

	private static final org.slf4j.Logger ourLog = org.slf4j.LoggerFactory.getLogger(FiledBasedHiLoGeneratorTest.class);
	
	@Override
	protected FileBasedHiLoGenerator getGenerator() {
		return new FileBasedHiLoGenerator(100);
	}

	
	@Test
	public void testNeverFail() throws IOException {

		FileBasedHiLoGenerator generator = getGenerator();
		ourLog.info("Generated {}", generator.getID());
		ourLog.info("Generated {}", generator.getID());

		File file = new File(Home.getHomeDirectory().getAbsolutePath(), "id_file");

		try {

			if (!file.delete()) {
				fail();
			}

			if (!file.createNewFile()) {
				fail();
			}

			generator = getGenerator();
			String id = generator.getID();
			assertEquals("1", id);

			file.setReadable(false);
			file.setWritable(false);

			generator = getGenerator();
			id = generator.getID();
			assertEquals("101", id);
			
			file.setReadable(true);
			file.setWritable(true);
			
			generator = getGenerator();
			id = generator.getID();
			assertEquals(Integer.toString(FileBasedHiLoGenerator.DEFAULT_MAXLO + 1), id);
			
			generator = getGenerator();
			id = generator.getID();
			assertEquals(Integer.toString((FileBasedHiLoGenerator.DEFAULT_MAXLO * 2) + 1), id);

		} finally {
			if (file != null) {
				file.setWritable(true);
				file.setReadable(true);
			}
		}
	}


}
