package ca.uhn.hl7v2.mvnplugin;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

import org.junit.Test;
import org.springframework.util.ResourceUtils;

/**
 * JUnit tests for conformance profile parser
 * 
 * @author bryan
 */
public class ProfileParserTest {

	/**
	 * See https://sourceforge.net/p/hl7api/bugs/160/
	 */
	@Test
	public void testParseFailed() throws IOException {

		/*
		 * Profile has a misspelled attribute (name instead of Name)
		 */
		
		ConfGenMojo m = new ConfGenMojo();
		m.packageName = "hapi.unittest";
		File file = ResourceUtils.getFile(ResourceUtils.CLASSPATH_URL_PREFIX + "ca/uhn/hl7v2/conf/parser/ADT_A01_with_problem.xml");
		m.profile = file.getAbsolutePath();
		m.targetDirectory = "target/sourcegen";

		try {
			m.execute();
			fail();
		} catch (Exception e) {
			assertTrue(e.getMessage(), e.getMessage().contains("XPN"));
		}
	}

}
