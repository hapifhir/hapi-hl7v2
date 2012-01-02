package ca.uhn.hl7v2.util;

import org.junit.Assert;
import org.junit.Test;

public class StringUtilTest {

	@Test
	public void testChomp() {
		
		String expected = "TEST";
		Assert.assertEquals(expected, StringUtil.chomp("TEST"));
		Assert.assertEquals(expected, StringUtil.chomp("TEST\r"));
		Assert.assertEquals(expected, StringUtil.chomp("TEST\n"));
		Assert.assertEquals(expected, StringUtil.chomp("TEST\r\n"));
		
		expected = "TEST\rTEST";
		Assert.assertEquals(expected, StringUtil.chomp("TEST\rTEST"));
		Assert.assertEquals(expected, StringUtil.chomp("TEST\rTEST\r"));
		Assert.assertEquals(expected, StringUtil.chomp("TEST\rTEST\n"));
		Assert.assertEquals(expected, StringUtil.chomp("TEST\rTEST\r\n"));

	}
	
}
