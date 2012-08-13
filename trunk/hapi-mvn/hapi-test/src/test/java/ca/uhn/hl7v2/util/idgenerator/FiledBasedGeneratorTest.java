package ca.uhn.hl7v2.util.idgenerator;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.*;
import org.junit.Test;


public class FiledBasedGeneratorTest extends AbstractContinuousGeneratorTest<FileBasedGenerator> {

	@Override
	protected FileBasedGenerator getGenerator() {
		FileBasedGenerator fbg = new FileBasedGenerator();
		fbg.reset();
		return fbg;
	}
	
	@Test(expected=IOException.class)
	public void testFailedFile() throws IOException {
		FileBasedGenerator gen = getGenerator();
		gen.setNeverFail(false);
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
	
	@Test
	public void testContinueAfterRestart() throws IOException {
		FileBasedGenerator gen = getGenerator();
		assertEquals("0", gen.getID());
		assertEquals("1", gen.getID());
		FileBasedGenerator gen2 = new FileBasedGenerator();
		assertEquals("2", gen2.getID());
	}
	
	@Test
	public void testReadFromUnknownFile() throws IOException {
		FileBasedGenerator gen2 = new FileBasedGenerator();
		File f = File.createTempFile("gentest", null);
		assertTrue(f.delete());
		gen2.setDirectory(f.getParent());
		gen2.setFileName(f.getName());
		assertEquals("0", gen2.getID());
	}	
}
