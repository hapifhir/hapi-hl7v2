package ca.uhn.hl7v2.hoh.llp;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Map;
import java.util.Map.Entry;

import ca.uhn.hl7v2.protocol.ReceivingApplication;
import ca.uhn.hl7v2.protocol.ReceivingApplicationException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ca.uhn.hl7v2.AcknowledgmentCode;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.app.Application;
import ca.uhn.hl7v2.app.ApplicationException;
import ca.uhn.hl7v2.app.Connection;
import ca.uhn.hl7v2.app.ConnectionListener;
import ca.uhn.hl7v2.app.SimpleServer;
import ca.uhn.hl7v2.hoh.encoder.EncodingStyle;
import ca.uhn.hl7v2.hoh.encoder.Hl7OverHttpRequestEncoder;
import ca.uhn.hl7v2.hoh.sign.BouncyCastleCmsMessageSignerTest;
import ca.uhn.hl7v2.hoh.util.RandomServerPortProvider;
import ca.uhn.hl7v2.hoh.util.ServerRoleEnum;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.parser.DefaultXMLParser;
import ca.uhn.hl7v2.parser.GenericParser;
import ca.uhn.hl7v2.parser.PipeParser;

public class LlpServerTest implements ReceivingApplication<Message>, ConnectionListener {

	private int myPort;
	private Hl7OverHttpLowerLayerProtocol myLlp;
	private SimpleServer myServer;
	private Message myMessage;
	private int myConnections;
	private Message myResponse;

	@Before
	public void before() throws InterruptedException {
		myPort = RandomServerPortProvider.findFreePort();

		myLlp = new Hl7OverHttpLowerLayerProtocol(ServerRoleEnum.SERVER);
		myServer = new SimpleServer(myPort, myLlp, GenericParser.getInstanceWithNoValidation());
		myServer.registerApplication("*", "*", this);
		myServer.registerConnectionListener(this);
		myMessage = (Message) null;
		myResponse = (Message) null;
		myConnections = 0;
	}

	@Test
	public void testSendSimple() throws Exception {
		myServer.startAndWait();

		String message = // -
		"MSH|^~\\&|||||200803051508||ADT^A31|2|P|2.5\r" + // -
				"EVN||200803051509\r" + // -
				"PID|||ZZZZZZ83M64Z148R^^^SSN^SSN^^20070103\r"; // -

		Hl7OverHttpRequestEncoder enc = new Hl7OverHttpRequestEncoder();
		String charsetName = "ISO-8859-2";
		enc.setCharset(Charset.forName(charsetName));
		enc.setUsername("hello");
		enc.setPassword("world");
		enc.setMessage(message);
		enc.encode();

		String urlString = "http://localhost:" + myPort + "/";
		ourLog.info("URL: {}", urlString);
		URL url = new URL(urlString);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("POST");

		conn.setUseCaches(false);
		conn.setDoInput(true);
		conn.setDoOutput(true);
		for (Entry<String, String> next : enc.getHeaders().entrySet()) {
			conn.setRequestProperty(next.getKey(), next.getValue());
		}

		DataOutputStream wr = new DataOutputStream(conn.getOutputStream());
		wr.write(enc.getData());
		wr.flush();

		// Get Response
		InputStream is = conn.getInputStream();
		BufferedReader rd = new BufferedReader(new InputStreamReader(is));
		String line;
		StringBuffer response = new StringBuffer();
		while ((line = rd.readLine()) != null) {
			response.append(line);
			response.append('\r');
		}
		String responseString = response.toString();
		ourLog.info("Response:\n{}", responseString);

		assertEquals(EncodingStyle.ER7.getContentType(), conn.getHeaderField("Content-Type").replaceAll(";.*", ""));
		assertEquals(charsetName, conn.getHeaderField("Content-Type").replaceAll(".*;.*charset=", ""));
		assertEquals(200, conn.getResponseCode());
		assertEquals(message, myMessage.encode());
		assertEquals(myResponse.encode(), responseString);

	}

	@Test
	public void testSendSimpleXml() throws Exception {
		myServer.startAndWait();

		String message = // -
		"MSH|^~\\&|||||200803051508||ADT^A31|2|P|2.5\r" + // -
				"EVN||200803051509\r" + // -
				"PID|||ZZZZZZ83M64Z148R^^^SSN^SSN^^20070103\r"; // -
		message = DefaultXMLParser.getInstanceWithNoValidation().encode(PipeParser.getInstanceWithNoValidation().parse(message));
		
		Hl7OverHttpRequestEncoder enc = new Hl7OverHttpRequestEncoder();
		String charsetName = "ISO-8859-2";
		enc.setCharset(Charset.forName(charsetName));
		enc.setUsername("hello");
		enc.setPassword("world");
		enc.setMessage(message);
		enc.encode();

		String urlString = "http://localhost:" + myPort + "/";
		ourLog.info("URL: {}", urlString);
		URL url = new URL(urlString);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("POST");

		conn.setUseCaches(false);
		conn.setDoInput(true);
		conn.setDoOutput(true);
		for (Entry<String, String> next : enc.getHeaders().entrySet()) {
			conn.setRequestProperty(next.getKey(), next.getValue());
		}

		DataOutputStream wr = new DataOutputStream(conn.getOutputStream());
		wr.write(enc.getData());
		wr.flush();

		// Get Response
		InputStream is = conn.getInputStream();
		BufferedReader rd = new BufferedReader(new InputStreamReader(is));
		String line;
		StringBuffer response = new StringBuffer();
		while ((line = rd.readLine()) != null) {
			response.append(line);
			response.append('\r');
		}
		String responseString = response.toString();
		ourLog.info("Response:\n{}", responseString);

		assertEquals(EncodingStyle.XML.getContentType(), conn.getHeaderField("Content-Type").replaceAll(";.*", ""));
		assertEquals(charsetName, conn.getHeaderField("Content-Type").replaceAll(".*;.*charset=", ""));
		assertEquals(200, conn.getResponseCode());
		assertEquals(message, myMessage.encode());
		
		String expected = myResponse.encode().replaceAll("<\\?.*\\?>", "").replaceAll("(\\r|\\n)+", "\n").trim();
		String actual = responseString.replaceAll("<\\?.*\\?>", "").replaceAll("(\\r|\\n)+", "\n").trim();
		assertEquals(expected, actual);

	}

	@Test
	public void testReplyWithAE() throws Exception {
		myServer.startAndWait();

		String message = // -
		"MSH|^~\\&|||||200803051508||ADT^A31|2|P|2.5\r" + // -
				"EVN||200803051509\r" + // -
				"PID|||ZZZZZZ83M64Z148R^^^SSN^SSN^^20070103\r"; // -

		myResponse = PipeParser.getInstanceWithNoValidation().parse(message).generateACK(AcknowledgmentCode.AE, new HL7Exception("blah"));
		
		Hl7OverHttpRequestEncoder enc = new Hl7OverHttpRequestEncoder();
		String charsetName = "ISO-8859-2";
		enc.setCharset(Charset.forName(charsetName));
		enc.setUsername("hello");
		enc.setPassword("world");
		enc.setMessage(message);
		enc.encode();

		String urlString = "http://localhost:" + myPort + "/";
		ourLog.info("URL: {}", urlString);
		URL url = new URL(urlString);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("POST");

		conn.setUseCaches(false);
		conn.setDoInput(true);
		conn.setDoOutput(true);
		for (Entry<String, String> next : enc.getHeaders().entrySet()) {
			conn.setRequestProperty(next.getKey(), next.getValue());
		}

		DataOutputStream wr = new DataOutputStream(conn.getOutputStream());
		wr.write(enc.getData());
		wr.flush();

		// Get Response
		InputStream is;
		try {
			is = conn.getInputStream();
		} catch (IOException e) {
			if (conn.getResponseCode() == 400 || conn.getResponseCode() == 500) {
				is = conn.getErrorStream();
			} else {
				throw e;
			}
		}
		BufferedReader rd = new BufferedReader(new InputStreamReader(is));
		String line;
		StringBuffer response = new StringBuffer();
		while ((line = rd.readLine()) != null) {
			response.append(line);
			response.append('\r');
		}
		String responseString = response.toString();
		ourLog.info("Response:\n{}", responseString);

		assertEquals(EncodingStyle.ER7.getContentType(), conn.getHeaderField("Content-Type").replaceAll(";.*", ""));
		assertEquals(charsetName, conn.getHeaderField("Content-Type").replaceAll(".*;.*charset=", ""));
		assertEquals(200, conn.getResponseCode());
		assertEquals(message, myMessage.encode());
		assertEquals(myResponse.encode(), responseString);

	}

	@Test
	public void testReplyWithAR() throws Exception {
		myServer.startAndWait();

		String message = // -
		"MSH|^~\\&|||||200803051508||ADT^A31|2|P|2.5\r" + // -
				"EVN||200803051509\r" + // -
				"PID|||ZZZZZZ83M64Z148R^^^SSN^SSN^^20070103\r"; // -

		myResponse = PipeParser.getInstanceWithNoValidation().parse(message)
				.generateACK(AcknowledgmentCode.AR, new HL7Exception("blah"));
		
		Hl7OverHttpRequestEncoder enc = new Hl7OverHttpRequestEncoder();
		String charsetName = "ISO-8859-2";
		enc.setCharset(Charset.forName(charsetName));
		enc.setUsername("hello");
		enc.setPassword("world");
		enc.setMessage(message);
		enc.encode();

		String urlString = "http://localhost:" + myPort + "/";
		ourLog.info("URL: {}", urlString);
		URL url = new URL(urlString);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("POST");

		conn.setUseCaches(false);
		conn.setDoInput(true);
		conn.setDoOutput(true);
		for (Entry<String, String> next : enc.getHeaders().entrySet()) {
			conn.setRequestProperty(next.getKey(), next.getValue());
		}

		DataOutputStream wr = new DataOutputStream(conn.getOutputStream());
		wr.write(enc.getData());
		wr.flush();

		// Get Response
		InputStream is;
		try {
			is = conn.getInputStream();
		} catch (IOException e) {
			if (conn.getResponseCode() == 400 || conn.getResponseCode() == 500) {
				is = conn.getErrorStream();
			} else {
				throw e;
			}
		}
		BufferedReader rd = new BufferedReader(new InputStreamReader(is));
		String line;
		StringBuffer response = new StringBuffer();
		while ((line = rd.readLine()) != null) {
			response.append(line);
			response.append('\r');
		}
		String responseString = response.toString();
		ourLog.info("Response:\n{}", responseString);

		assertEquals(EncodingStyle.ER7.getContentType(), conn.getHeaderField("Content-Type").replaceAll(";.*", ""));
		assertEquals(charsetName, conn.getHeaderField("Content-Type").replaceAll(".*;.*charset=", ""));
		assertEquals(200, conn.getResponseCode());
		assertEquals(message, myMessage.encode());
		assertEquals(myResponse.encode(), responseString);

	}
	
	@Test
	public void testSendPersistentConnection() throws Exception {
		myServer.startAndWait();

		String message = // -
		"MSH|^~\\&|||||200803051508||ADT^A31|2|P|2.5\r" + // -
				"EVN||200803051509\r" + // -
				"PID|||ZZZZZZ83M64Z148R^^^SSN^SSN^^20070103\r"; // -

		Hl7OverHttpRequestEncoder enc = new Hl7OverHttpRequestEncoder();
		enc.setCharset(Charset.forName("ISO-8859-1"));
		enc.setUsername("hello");
		enc.setPassword("world");
		enc.setMessage(message);
		enc.encode();

		String urlString = "http://localhost:" + myPort + "/";
		ourLog.info("URL: {}", urlString);
		URL url = new URL(urlString);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("POST");

		conn.setUseCaches(false);
		conn.setDoInput(true);
		conn.setDoOutput(true);
		for (Entry<String, String> next : enc.getHeaders().entrySet()) {
			conn.setRequestProperty(next.getKey(), next.getValue());
		}

		DataOutputStream wr = new DataOutputStream(conn.getOutputStream());
		wr.write(enc.getData());
		wr.flush();
		wr.close();

		// Get Response
		InputStream is = conn.getInputStream();
		BufferedReader rd = new BufferedReader(new InputStreamReader(is));
		String line;
		StringBuffer response = new StringBuffer();
		while ((line = rd.readLine()) != null) {
			response.append(line);
			response.append('\r');
		}
		is.close();
		String responseString = response.toString();
		ourLog.info("Response:\n{}", responseString);

		assertEquals(200, conn.getResponseCode());
		assertEquals(message, myMessage.encode());
		assertEquals(myResponse.encode(), responseString);

		// Send a second message
		message = // -
		"MSH|^~\\&|||||200803051508||ADT^A31|99999|P|2.5\r" + // -
				"EVN||200803051509\r" + // -
				"PID|||ZZZZZZ83M64Z148R^^^SSN^SSN^^20070103\r"; // -

		enc = new Hl7OverHttpRequestEncoder();
		enc.setCharset(Charset.forName("ISO-8859-1"));
		enc.setUsername("hello");
		enc.setPassword("world");
		enc.setMessage(message);
		enc.encode();

		conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("POST");

		conn.setUseCaches(false);
		conn.setDoInput(true);
		conn.setDoOutput(true);
		for (Entry<String, String> next : enc.getHeaders().entrySet()) {
			conn.setRequestProperty(next.getKey(), next.getValue());
		}

		wr = new DataOutputStream(conn.getOutputStream());
		wr.write(enc.getData());
		wr.flush();

		// Get Response
		is = conn.getInputStream();
		rd = new BufferedReader(new InputStreamReader(is));
		response = new StringBuffer();
		while ((line = rd.readLine()) != null) {
			response.append(line);
			response.append('\r');
		}
		responseString = response.toString();
		ourLog.info("Response:\n{}", responseString);

		assertEquals(200, conn.getResponseCode());
		assertEquals(message, myMessage.encode());
		assertEquals(myResponse.encode(), responseString);
		assertEquals(1, myConnections);
	}

	private static final org.slf4j.Logger ourLog = org.slf4j.LoggerFactory.getLogger(LlpServerTest.class);

	@After
	public void after() {
		myServer.stopAndWait();
	}

	public boolean canProcess(Message theArg0) {
		return true;
	}

	public Message processMessage(Message theArg0, Map<String, Object> metadata)
            throws ReceivingApplicationException, HL7Exception {
		myMessage = theArg0;
		if (myResponse != null) {
			return myResponse;
		}
		try {
			myResponse = theArg0.generateACK();
			return myResponse;
		} catch (IOException e) {
			fail(e.getMessage());
			throw new HL7Exception(e);
		}
	}

	public void connectionDiscarded(Connection theArg0) {
		// ignore
	}

	public void connectionReceived(Connection theArg0) {
		myConnections++;
	}

	
	@Test
	public void testSendWithClientSigner() throws Exception {
		myLlp.setSigner(BouncyCastleCmsMessageSignerTest.createVerifier());
		myServer.startAndWait();

		String message = // -
		"MSH|^~\\&|||||200803051508||ADT^A31|2|P|2.5\r" + // -
				"EVN||200803051509\r" + // -
				"PID|||ZZZZZZ83M64Z148R^^^SSN^SSN^^20070103\r"; // -

		Hl7OverHttpRequestEncoder enc = new Hl7OverHttpRequestEncoder();
		enc.setCharset(Charset.forName("ISO-8859-1"));
		enc.setUsername("hello");
		enc.setPassword("world");
		enc.setMessage(message);
		enc.setSigner(BouncyCastleCmsMessageSignerTest.createSigner());
		enc.encode();

		String urlString = "http://localhost:" + myPort + "/";
		ourLog.info("URL: {}", urlString);
		URL url = new URL(urlString);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("POST");

		conn.setUseCaches(false);
		conn.setDoInput(true);
		conn.setDoOutput(true);
		for (Entry<String, String> next : enc.getHeaders().entrySet()) {
			conn.setRequestProperty(next.getKey(), next.getValue());
		}

		DataOutputStream wr = new DataOutputStream(conn.getOutputStream());
		wr.write(enc.getData());
		wr.flush();

		// Get Response
		InputStream is = conn.getInputStream();
		BufferedReader rd = new BufferedReader(new InputStreamReader(is));
		String line;
		StringBuffer response = new StringBuffer();
		while ((line = rd.readLine()) != null) {
			response.append(line);
			response.append('\r');
		}
		String responseString = response.toString();
		ourLog.info("Response:\n{}", responseString);

		assertEquals(200, conn.getResponseCode());
		assertEquals(message, myMessage.encode());
		assertEquals(myResponse.encode(), responseString);

	}

}
