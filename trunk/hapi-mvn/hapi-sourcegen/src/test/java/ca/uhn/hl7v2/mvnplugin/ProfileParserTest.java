package ca.uhn.hl7v2.mvnplugin;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.junit.Before;
import org.junit.Test;
import org.springframework.util.ResourceUtils;

import ca.uhn.hl7v2.conf.ProfileException;
import ca.uhn.hl7v2.conf.parser.ProfileParser;
import ca.uhn.hl7v2.conf.spec.RuntimeProfile;
import ca.uhn.hl7v2.conf.spec.message.Component;
import ca.uhn.hl7v2.conf.spec.message.Field;
import ca.uhn.hl7v2.conf.spec.message.Seg;
import ca.uhn.hl7v2.conf.spec.message.StaticDef;
import ca.uhn.hl7v2.conf.spec.message.SubComponent;

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
	public void testParseFailed() throws ProfileException, IOException, MojoExecutionException, MojoFailureException {

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
