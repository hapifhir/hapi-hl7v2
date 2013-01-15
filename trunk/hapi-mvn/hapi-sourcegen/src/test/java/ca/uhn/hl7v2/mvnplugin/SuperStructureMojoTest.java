package ca.uhn.hl7v2.mvnplugin;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;


public class SuperStructureMojoTest {

	@Test
	public void testMergeStringList() {
		ArrayList<List<String>> allLists = new ArrayList<List<String>>();
		allLists.add(Arrays.asList("A", "B", "D", "E", "F", "G"));
		allLists.add(Arrays.asList("A", "B", "C", "D", "E", "F"));
		
		ArrayList<String> actual = SuperStructureMojo.mergeStringLists(allLists);
		List<String> expected = Arrays.asList("A", "B", "C", "D", "E", "F", "G");
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testMergeStringList2() {
		ArrayList<List<String>> allLists = new ArrayList<List<String>>();
		allLists.add(Arrays.asList("A", "B", "C", "D"));
		allLists.add(Arrays.asList("A", "B", "C", "D", "E", "F", "G"));
		
		ArrayList<String> actual = SuperStructureMojo.mergeStringLists(allLists);
		List<String> expected = Arrays.asList("A", "B", "C", "D", "E", "F", "G");
		
		assertEquals(expected, actual);
	}

	@Test
	public void testMergeStringList3() {
		ArrayList<List<String>> allLists = new ArrayList<List<String>>();
		allLists.add(Arrays.asList("A", "B", "C", "D"));
		allLists.add(Arrays.asList("A", "E", "F", "G"));
		
		ArrayList<String> actual = SuperStructureMojo.mergeStringLists(allLists);
		List<String> expected = Arrays.asList("A", "B", "C", "D", "E", "F", "G");
		
		assertEquals(expected, actual);
	}

	@Test
	public void testMergeStringList4() {
		ArrayList<List<String>> allLists = new ArrayList<List<String>>();
		allLists.add(Arrays.asList("A", "F", "G"));
		allLists.add(Arrays.asList("A", "B", "C", "D", "E", "F"));
		
		ArrayList<String> actual = SuperStructureMojo.mergeStringLists(allLists);
		List<String> expected = Arrays.asList("A", "B", "C", "D", "E", "F", "G");
		
		assertEquals(expected, actual);
	}

	@Test
	public void testMergeStringList5() {
		ArrayList<List<String>> allLists = new ArrayList<List<String>>();
		allLists.add(Arrays.asList("A", "B", "C", "D"));
		allLists.add(Arrays.asList("A", "D"));
		
		ArrayList<String> actual = SuperStructureMojo.mergeStringLists(allLists);
		List<String> expected = Arrays.asList("A", "B", "C", "D");
		
		assertEquals(expected, actual);
	}

	@Test
	public void testMergeStringList6() {
		ArrayList<List<String>> allLists = new ArrayList<List<String>>();
		allLists.add(Arrays.asList("A", "B", "C", "D", "E", "F"));
		allLists.add(Arrays.asList("A", "D", "F", "G"));
		
		ArrayList<String> actual = SuperStructureMojo.mergeStringLists(allLists);
		List<String> expected = Arrays.asList("A", "B", "C", "D", "E", "F", "G");
		
		assertEquals(expected, actual);
	}

}
