package ca.uhn.hl7v2.testpanel.model.conf;

import static junit.framework.Assert.*;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

public class TablePersistenceTest {

	@Test
	public void testSaveAndRestore() throws IOException {
		File tempFile = File.createTempFile("tmp", "xml");
		tempFile.deleteOnExit();
		
		TableFile actual = new TableFile();
		
		actual.getTables().add(new Table());
		actual.getTables().get(0).setCodeSystemId("CS.1");
		actual.getTables().get(0).setCodeSystemId("CodeSys.1");
		actual.getTables().get(0).getCodes().add(new Code("CD.1", "TheCode1"));
		actual.getTables().get(0).getCodes().add(new Code("CD.2", "TheCode2"));
		
		actual.getTables().add(new Table());
		actual.getTables().get(1).setCodeSystemId("CS.2");
		actual.getTables().get(1).setCodeSystemId("CodeSys.2");
		actual.getTables().get(1).getCodes().add(new Code("CD.3", "TheCode3"));
		actual.getTables().get(1).getCodes().add(new Code("CD.4", "TheCode4"));

		actual.setFileName(tempFile);
		actual.flushToFile();
		
		TableFile expected = TableFile.readFromFile(tempFile);
		assertEquals(expected.getId(), actual.getId());
		assertEquals(expected.getName(), actual.getName());
		assertEquals(expected.getTables(), actual.getTables());
		
	}
	
	
}
