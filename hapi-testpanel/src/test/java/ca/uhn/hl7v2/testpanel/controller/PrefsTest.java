package ca.uhn.hl7v2.testpanel.controller;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import ca.uhn.hl7v2.testpanel.model.msg.Hl7V2MessageCollection;

public class PrefsTest {

	@Test
	public void testRecentFiles() {
		Prefs.getInstance().clearRecentMessageXmlFiles();
		List<Hl7V2MessageCollection> files = Prefs.getInstance().getRecentMessageXmlFiles(null);
		assertEquals(0, files.size());
		
		Hl7V2MessageCollection c1 = new Hl7V2MessageCollection();
		c1.setSaveFileName("file1.txt");
		
		Hl7V2MessageCollection c2 = new Hl7V2MessageCollection();
		c2.setSaveFileName("file2.txt");
		
		Prefs.getInstance().addMessagesFileXmlToRecents(null, Arrays.asList(c1, c2));
		
		files = Prefs.getInstance().getRecentMessageXmlFiles(null);
		assertEquals(2, files.size());
		assertTrue(files.contains(c1));
		assertTrue(files.contains(c2));
		
	}
	
}
