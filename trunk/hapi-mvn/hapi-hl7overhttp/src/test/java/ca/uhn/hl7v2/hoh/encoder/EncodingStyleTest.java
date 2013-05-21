package ca.uhn.hl7v2.hoh.encoder;

import org.junit.Assert;
import org.junit.Test;

public class EncodingStyleTest {

	@Test
	public void testIt() {
		
		Assert.assertEquals(EncodingStyle.ER7, EncodingStyle.getEncodingStyleForContentType("application/hl7-v2"));
		Assert.assertEquals(EncodingStyle.XML, EncodingStyle.getEncodingStyleForContentType("application/hl7-v2+xml"));
		
		
	}
	
}
