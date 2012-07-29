package ca.uhn.hl7v2.util.idgenerator;

import java.io.IOException;

import static org.junit.Assert.*;
import org.junit.Test;


public class FiledBasedGeneratorTest extends AbstractContinuousGeneratorTest<FileBasedGenerator> {

	@Override
	protected FileBasedGenerator getGenerator() {
		return new FileBasedGenerator();
	}
	
	@Test(expected=IOException.class)
	public void testFailedFile() throws IOException {
		FileBasedGenerator gen = getGenerator();
		gen.setDirectory("::::?::::");
		gen.setFileName("::::?::::");
		gen.getID();
	}

	@Test
	public void testFailedFileIgnored() throws IOException {
		FileBasedGenerator gen = getGenerator();
		gen.setDirectory("::::?::::");
		gen.setFileName("::::?::::");
		gen.setNeverFail(true);
		assertEquals("0", gen.getID());
		assertEquals("1", gen.getID());
	}
}
