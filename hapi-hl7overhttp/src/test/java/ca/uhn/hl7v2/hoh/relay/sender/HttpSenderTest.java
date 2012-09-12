package ca.uhn.hl7v2.hoh.relay.sender;

import static org.junit.Assert.*;

import org.junit.Test;

public class HttpSenderTest {

	@Test
	public void testSetUrl() throws Exception {
		
		HttpSender s = new HttpSender();
		s.setUrlString("http://localhost:8888/path");
		
		assertEquals("localhost", s.getHost());
		assertEquals(8888, s.getPort());
		assertEquals("/path", s.getUri());
		
		s.afterPropertiesSet();
		
	}
	

}
