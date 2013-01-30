package ca.uhn.hl7v2.mvnplugin;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.maven.plugin.logging.Log;
import org.junit.BeforeClass;
import org.junit.Test;

public class SuperStructureMojoTest {

	private static final org.slf4j.Logger ourLog = org.slf4j.LoggerFactory.getLogger(SuperStructureMojoTest.class);
	private static SuperStructureMojo ourMojo;

	@Test
	public void testMergeStringList() {
		ArrayList<List<String>> allLists = new ArrayList<List<String>>();
		allLists.add(Arrays.asList("A", "B", "D", "E", "F", "G"));
		allLists.add(Arrays.asList("A", "B", "C", "D", "E", "F"));

		ArrayList<String> actual = ourMojo.mergeStringLists(allLists);
		List<String> expected = Arrays.asList("A", "B", "C", "D", "E", "F", "G");

		assertEquals(expected, actual);
	}

	@Test
	public void testMergeStringList2() {
		ArrayList<List<String>> allLists = new ArrayList<List<String>>();
		allLists.add(Arrays.asList("A", "B", "C", "D"));
		allLists.add(Arrays.asList("A", "B", "C", "D", "E", "F", "G"));

		ArrayList<String> actual = ourMojo.mergeStringLists(allLists);
		List<String> expected = Arrays.asList("A", "B", "C", "D", "E", "F", "G");

		assertEquals(expected, actual);
	}

	@Test
	public void testMergeStringList3() {
		ArrayList<List<String>> allLists = new ArrayList<List<String>>();
		allLists.add(Arrays.asList("A", "B", "C", "D"));
		allLists.add(Arrays.asList("A", "E", "F", "G"));

		ArrayList<String> actual = ourMojo.mergeStringLists(allLists);
		List<String> expected = Arrays.asList("A", "B", "C", "D", "E", "F", "G");

		assertEquals(expected, actual);
	}

	@Test
	public void testMergeStringList4() {
		ArrayList<List<String>> allLists = new ArrayList<List<String>>();
		allLists.add(Arrays.asList("A", "F", "G"));
		allLists.add(Arrays.asList("A", "B", "C", "D", "E", "F"));

		ArrayList<String> actual = ourMojo.mergeStringLists(allLists);
		List<String> expected = Arrays.asList("A", "B", "C", "D", "E", "F", "G");

		assertEquals(expected, actual);
	}

	@Test
	public void testMergeStringList5() {
		ArrayList<List<String>> allLists = new ArrayList<List<String>>();
		allLists.add(Arrays.asList("A", "B", "C", "D"));
		allLists.add(Arrays.asList("A", "D"));

		ArrayList<String> actual = ourMojo.mergeStringLists(allLists);
		List<String> expected = Arrays.asList("A", "B", "C", "D");

		assertEquals(expected, actual);
	}

	@Test
	public void testMergeStringList6() {
		ArrayList<List<String>> allLists = new ArrayList<List<String>>();
		allLists.add(Arrays.asList("A", "B", "C", "D", "E", "F"));
		allLists.add(Arrays.asList("A", "D", "F", "G"));

		ArrayList<String> actual = ourMojo.mergeStringLists(allLists);
		List<String> expected = Arrays.asList("A", "B", "C", "D", "E", "F", "G");

		assertEquals(expected, actual);
	}

	@BeforeClass
	public static void beforeClass() {
		ourMojo = new SuperStructureMojo();
		ourMojo.setLog(new Log() {

			public void debug(CharSequence theArg0) {
				ourLog.info(theArg0.toString());
			}

			public void debug(CharSequence theArg0, Throwable theArg1) {
				ourLog.info(theArg0.toString());
			}

			public void debug(Throwable theArg0) {
				ourLog.info(theArg0.toString());
			}

			public void error(CharSequence theArg0) {
				ourLog.info(theArg0.toString());
			}

			public void error(CharSequence theArg0, Throwable theArg1) {
				ourLog.info(theArg0.toString());
			}

			public void error(Throwable theArg0) {
				ourLog.info(theArg0.toString());
			}

			public void info(CharSequence theArg0) {
				ourLog.info(theArg0.toString());
			}

			public void info(CharSequence theArg0, Throwable theArg1) {
				ourLog.info(theArg0.toString());
			}

			public void info(Throwable theArg0) {
				ourLog.info(theArg0.toString());
			}

			public boolean isDebugEnabled() {
				return true;
			}

			public boolean isErrorEnabled() {
				return true;
			}

			public boolean isInfoEnabled() {
				return true;
			}

			public boolean isWarnEnabled() {
				return true;
			}

			public void warn(CharSequence theArg0) {
				ourLog.info(theArg0.toString());
			}

			public void warn(CharSequence theArg0, Throwable theArg1) {
				ourLog.info(theArg0.toString());
			}

			public void warn(Throwable theArg0) {
				ourLog.info(theArg0.toString());
			}
		});
	}

}
