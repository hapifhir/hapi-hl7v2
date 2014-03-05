package ca.uhn.hl7v2.hoh.raw.server;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Map.Entry;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mortbay.jetty.Server;
import org.mortbay.jetty.servlet.Context;
import org.mortbay.jetty.servlet.ServletHolder;

import ca.uhn.hl7v2.AcknowledgmentCode;
import ca.uhn.hl7v2.DefaultHapiContext;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.hoh.api.IAuthorizationServerCallback;
import ca.uhn.hl7v2.hoh.api.IMessageHandler;
import ca.uhn.hl7v2.hoh.api.IReceivable;
import ca.uhn.hl7v2.hoh.api.IResponseSendable;
import ca.uhn.hl7v2.hoh.api.MessageProcessingException;
import ca.uhn.hl7v2.hoh.encoder.EncodingStyle;
import ca.uhn.hl7v2.hoh.encoder.Hl7OverHttpRequestEncoder;
import ca.uhn.hl7v2.hoh.llp.Hl7OverHttpLowerLayerProtocol;
import ca.uhn.hl7v2.hoh.raw.api.RawSendable;
import ca.uhn.hl7v2.hoh.util.RandomServerPortProvider;
import ca.uhn.hl7v2.hoh.util.ServerRoleEnum;
import ca.uhn.hl7v2.hoh.util.StringUtils;
import ca.uhn.hl7v2.model.v25.message.ADT_A05;
import ca.uhn.hl7v2.parser.DefaultXMLParser;
import ca.uhn.hl7v2.parser.EncodingNotSupportedException;
import ca.uhn.hl7v2.parser.GenericParser;

public class HohRawServletTest implements IAuthorizationServerCallback, IMessageHandler<String> {

	private static DefaultHapiContext ourHapiContext;
	private static final org.slf4j.Logger ourLog = org.slf4j.LoggerFactory.getLogger(HohRawServletTest.class);
	private String myExpectedPassword;
	private String myExpectedUri;
	private String myExpectedUsername;
	private String myMessage;
	private String myResponse;
	private int myPort;
	private Server myServer;

	@After
	public void after() throws Exception {
		myServer.stop();
	}

	public boolean authorize(String theUri, String theUsername, String thePassword) {
		if (myExpectedUsername == null) {
			return true;
		} else {
			if (!StringUtils.equals(myExpectedUri, theUri)) {
				return false;
			}
			if (!StringUtils.equals(myExpectedUsername, theUsername)) {
				return false;
			}
			if (!StringUtils.equals(myExpectedPassword, thePassword)) {
				return false;
			}
			return true;
		}

	}

	@Before
	public void before() throws Exception {
		myPort = RandomServerPortProvider.findFreePort();
		myServer = new Server(myPort);
		Context context = new Context(myServer, "/", Context.SESSIONS);
		HohRawServlet servlet = new HohRawServlet();
		servlet.setAuthorizationCallback(this);
		servlet.setMessageHandler(this);
		context.addServlet(new ServletHolder(servlet), "/*");

		myServer.start();

		while (myServer.isStarting()) {
			ourLog.info("Waiting for server to start...");
			Thread.sleep(100);
		}

		myResponse = null;
	}

	public IResponseSendable<String> messageReceived(IReceivable<String> theMessage) throws MessageProcessingException {

		myMessage = theMessage.getMessage();
		try {
			if (myResponse == null) {
				myResponse = GenericParser.getInstanceWithNoValidation().parse(myMessage).generateACK().encode();
			}
			return new RawSendable(myResponse);
		} catch (EncodingNotSupportedException e) {
			throw new MessageProcessingException(e);
		} catch (HL7Exception e) {
			throw new MessageProcessingException(e);
		} catch (IOException e) {
			throw new MessageProcessingException(e);
		}

	}

	@Test
	public void testSuccessWhenRequestHasNoCharsetSpecified() throws Exception {

		String message = // -
		"MSH|^~\\&|||||200803051508||ADT^A31|2|P|2.5\r" + // -
				"EVN||200803051509\r" + // -
				"PID|||ZZZZZZ83M64Z148R^^^SSN^SSN^^20070103\r"; // -
		ADT_A05 msg = new ADT_A05();
		msg.parse(message);

		Hl7OverHttpLowerLayerProtocol llp = new Hl7OverHttpLowerLayerProtocol(ServerRoleEnum.CLIENT);
		String charsetName = "ISO-8859-1";
		llp.setPreferredCharset(Charset.forName(charsetName));

		Hl7OverHttpRequestEncoder enc = new Hl7OverHttpRequestEncoder();
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
			if (next.getKey().toLowerCase().equals("content-type")) {
				conn.setRequestProperty(next.getKey(), "application/hl7-v2");
			} else {
				conn.setRequestProperty(next.getKey(), next.getValue());
			}
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
		assertEquals("UTF-8", conn.getHeaderField("Content-Type").replaceAll(".*;.*charset=", ""));
		assertEquals(200, conn.getResponseCode());
		assertEquals(message, myMessage);
		assertEquals(myResponse, responseString);
	}

	@Test
	public void testServlet() throws Exception {

		String message = // -
		"MSH|^~\\&|||||200803051508||ADT^A31|2|P|2.5\r" + // -
				"EVN||200803051509\r" + // -
				"PID|||ZZZZZZ83M64Z148R^^^SSN^SSN^^20070103\r"; // -
		ADT_A05 msg = new ADT_A05();
		msg.parse(message);

		Hl7OverHttpLowerLayerProtocol llp = new Hl7OverHttpLowerLayerProtocol(ServerRoleEnum.CLIENT);
		String charsetName = "ISO-8859-2";
		llp.setPreferredCharset(Charset.forName(charsetName));

		Hl7OverHttpRequestEncoder enc = new Hl7OverHttpRequestEncoder();
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
		assertEquals(message, myMessage);
		assertEquals(myResponse, responseString);

	}

	@Test
	public void testLargeMessage() throws Exception {

		StringBuilder b= new StringBuilder();
		for (int a = 0; a < 100000; a++) {
			b.append('a');
		}
		
		String message = // -
		"MSH|^~\\&|||||200803051508||ADT^A31|2|P|2.5\r" + // -
				"EVN||200803051509\r" + // -
				"PID|||" + b + "^^^SSN^SSN^^20070103\r"; // -
		ADT_A05 msg = new ADT_A05();
		msg.parse(message);

		Hl7OverHttpLowerLayerProtocol llp = new Hl7OverHttpLowerLayerProtocol(ServerRoleEnum.CLIENT);
		String charsetName = "ISO-8859-2";
		llp.setPreferredCharset(Charset.forName(charsetName));

		Hl7OverHttpRequestEncoder enc = new Hl7OverHttpRequestEncoder();
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
		assertEquals(message, myMessage);
		assertEquals(myResponse, responseString);

	}

	@Test
	public void testServletAR() throws Exception {

		String message = // -
		"MSH|^~\\&|||||200803051508||ADT^A31|2|P|2.5\r" + // -
				"EVN||200803051509\r" + // -
				"PID|||ZZZZZZ83M64Z148R^^^SSN^SSN^^20070103\r"; // -
		ADT_A05 msg = new ADT_A05();
		msg.parse(message);

		myResponse = msg.generateACK(AcknowledgmentCode.AR, new HL7Exception("ewrerwe")).encode();

		Hl7OverHttpLowerLayerProtocol llp = new Hl7OverHttpLowerLayerProtocol(ServerRoleEnum.CLIENT);
		String charsetName = "ISO-8859-2";
		llp.setPreferredCharset(Charset.forName(charsetName));

		Hl7OverHttpRequestEncoder enc = new Hl7OverHttpRequestEncoder();
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
		assertEquals(message, myMessage);
		assertEquals(myResponse, responseString);

	}

	@Test
	public void testServletAE() throws Exception {

		String message = // -
		"MSH|^~\\&|||||200803051508||ADT^A31|2|P|2.5\r" + // -
				"EVN||200803051509\r" + // -
				"PID|||ZZZZZZ83M64Z148R^^^SSN^SSN^^20070103\r"; // -
		ADT_A05 msg = new ADT_A05();
		msg.parse(message);

		myResponse = msg.generateACK(AcknowledgmentCode.AE, new HL7Exception("ewrerwe")).encode();

		Hl7OverHttpLowerLayerProtocol llp = new Hl7OverHttpLowerLayerProtocol(ServerRoleEnum.CLIENT);
		String charsetName = "ISO-8859-2";
		llp.setPreferredCharset(Charset.forName(charsetName));

		Hl7OverHttpRequestEncoder enc = new Hl7OverHttpRequestEncoder();
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
		assertEquals(message, myMessage);
		assertEquals(myResponse, responseString);

	}

	@Test
	public void testServletSimpleXml() throws Exception {

		String message = // -
		"MSH|^~\\&|||||200803051508||ADT^A31|2|P|2.5\r" + // -
				"EVN||200803051509\r" + // -
				"PID|||ZZZZZZ83M64Z148R^^^SSN^SSN^^20070103\r"; // -
		ADT_A05 msg = new ADT_A05();
		msg.parse(message);

		message = DefaultXMLParser.getInstanceWithNoValidation().encode(msg);

		Hl7OverHttpLowerLayerProtocol llp = new Hl7OverHttpLowerLayerProtocol(ServerRoleEnum.CLIENT);
		String charsetName = "ISO-8859-2";
		llp.setPreferredCharset(Charset.forName(charsetName));

		Hl7OverHttpRequestEncoder enc = new Hl7OverHttpRequestEncoder();
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

		assertEquals(EncodingStyle.XML.getContentType(), conn.getHeaderField("Content-Type").replaceAll(";.*", ""));
		assertEquals(charsetName, conn.getHeaderField("Content-Type").replaceAll(".*;.*charset=", ""));
		assertEquals(200, conn.getResponseCode());
		assertEquals(message, myMessage);
		assertEquals(myResponse.replaceAll("(\\r|\\n)+", " "), responseString.replaceAll("(\\r|\\n)+", " "));

	}

	@AfterClass
	public static void afterClass() throws InterruptedException {
		// Thread.sleep(1000000);
		ourHapiContext.getExecutorService().shutdown();
	}

	@BeforeClass
	public static void beforeClass() {
		System.setProperty("DEBUG", "true");

		ourHapiContext = new DefaultHapiContext();
	}

}
