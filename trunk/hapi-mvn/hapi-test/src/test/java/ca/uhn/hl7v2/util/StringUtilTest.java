package ca.uhn.hl7v2.util;

import static org.junit.Assert.*;
import static ca.uhn.hl7v2.util.StringUtil.*;
import org.junit.Test;

public class StringUtilTest {

	@Test
	public void testChomp() {
		
		String expected = "TEST";
		assertEquals(expected, chomp("TEST"));
		assertEquals(expected, chomp("TEST\r"));
		assertEquals(expected, chomp("TEST\n"));
		assertEquals(expected, chomp("TEST\r\n"));
		
		expected = "TEST\rTEST";
		assertEquals(expected, chomp("TEST\rTEST"));
		assertEquals(expected, chomp("TEST\rTEST\r"));
		assertEquals(expected, chomp("TEST\rTEST\n"));
		assertEquals(expected, chomp("TEST\rTEST\r\n"));

	}
	
	@Test
	public void testConcatenate() {
		String[] array0 = new String[] {  };
		String[] array1 = new String[] { "A",  "B" };
		String[] array2 = new String[] { "C" };
		String[] array12 = new String[] { "A",  "B", "C" };
		String[] array21 = new String[] { "C",  "A", "B" };
		assertNull(concatenate(null, null));
		assertArrayEquals(array0, concatenate(array0, null));
		assertArrayEquals(array0, concatenate(null, array0));
		assertArrayEquals(array1, concatenate(array1, null));
		assertArrayEquals(array1, concatenate(null, array1));
		assertArrayEquals(array1, concatenate(array1, array0));
		assertArrayEquals(array1, concatenate(array0, array1));
		assertArrayEquals(array12, concatenate(array1, array2));
		assertArrayEquals(array21, concatenate(array2, array1));
	}
	
}
