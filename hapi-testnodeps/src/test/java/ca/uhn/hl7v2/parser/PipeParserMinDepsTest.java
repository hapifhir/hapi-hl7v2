package ca.uhn.hl7v2.parser;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ca.uhn.hl7v2.DefaultHapiContext;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.app.Application;
import ca.uhn.hl7v2.app.ApplicationException;
import ca.uhn.hl7v2.app.SimpleServer;
import ca.uhn.hl7v2.llp.MinLLPReader;
import ca.uhn.hl7v2.llp.MinLLPWriter;
import ca.uhn.hl7v2.model.Message;

public class PipeParserMinDepsTest implements Application<Message> {

	private static final Logger ourLog = LoggerFactory.getLogger(PipeParserMinDepsTest.class);
	private boolean myGotMessage;


	@Before
	public void before() {
		myGotMessage = false;
	}

	/**
	 * See 3545139
	 * 
	 * Should pass
	 */
	@Test
	public void testGoodVersion() throws Exception {

		int port1 = RandomServerPortProvider.findFreePort();
		SimpleServer ss = new SimpleServer(port1);
		ss.registerApplication("*", "*", this);

		ss.startAndWait();
		try {

			String messageText = "MSH|^~\\&|4265-ADT|4265|eReferral|eReferral|201004141020||ADT^A45^ADT_A45|102416|T^|2.5\r" //- 
					+ "EVN|A45|201004141020|\r"  //-
					+ "PID|1||7010226^^^4265^MR~0000000000^^^CANON^JHN^^^^^^GP~1736465^^^4265^VN||Park^Green^^^MS.^^L||19890812|F|||123 TestingLane^^TORONTO^CA-ON^M5G2C2^CAN^H^~^^^^^^^||^PRN^PH^^1^416^2525252^|^^^^^^^||||||||||||||||N\r" //-
			        + "PV1|1|I||||^^^WP^1469^^^^^^^^|||||||||||^Derkach^Peter.^^^Dr.||20913000131|||||||||||||||||||||||||201004011340|201004141018"; //-
			Socket s = new Socket();
			s.setSoTimeout(1000);
			s.connect(new InetSocketAddress("localhost", port1));

			ourLog.info("Sending message");
			new MinLLPWriter(s.getOutputStream()).writeMessage(messageText);

			ourLog.info("Reading response");

			String response = new MinLLPReader(s.getInputStream()).getMessage();

			ourLog.info("Response: " + response);
			Assert.assertTrue(response.contains("MSH|"));
			Assert.assertTrue(response.contains("|2.5"));
			Assert.assertTrue(myGotMessage);

		} finally {
			ss.stop();
		}
	}


	/**
	 * See 3545139
	 * 
	 * Doesn't pass yet!
	 */
	@Test
	public void testNoVersion() throws Exception {

		int port1 = RandomServerPortProvider.findFreePort();
		
		DefaultHapiContext ctx = new DefaultHapiContext();
		SimpleServer ss = ctx.newServer(port1, false);
		ctx.getParserConfiguration().setAllowUnknownVersions(true);
		
		ss.registerApplication("*", "*", this);

		ss.startAndWait();
		try {

			String messageText = "MSH|^~\\&|4265-ADT|4265|eReferral|eReferral|201004141020||ADT^A45^ADT_A45|102416|T^|\r" //- 
					+ "EVN|A45|201004141020|\r"  //-
					+ "PID|1||7010226^^^4265^MR~0000000000^^^CANON^JHN^^^^^^GP~1736465^^^4265^VN||Park^Green^^^MS.^^L||19890812|F|||123 TestingLane^^TORONTO^CA-ON^M5G2C2^CAN^H^~^^^^^^^||^PRN^PH^^1^416^2525252^|^^^^^^^||||||||||||||||N\r" //-
			        + "PV1|1|I||||^^^WP^1469^^^^^^^^|||||||||||^Derkach^Peter.^^^Dr.||20913000131|||||||||||||||||||||||||201004011340|201004141018"; //-
			Socket s = new Socket();
			s.setSoTimeout(1000);
			s.connect(new InetSocketAddress("localhost", port1));

			ourLog.info("Sending message");
			new MinLLPWriter(s.getOutputStream()).writeMessage(messageText);

			ourLog.info("Reading response");

			String response = new MinLLPReader(s.getInputStream()).getMessage();

			ourLog.info("Response: " + response);
			Assert.assertTrue(response.contains("MSH|"));
			Assert.assertTrue(response.contains("|2.5"));
			Assert.assertTrue(myGotMessage);

		} finally {
			ss.stop();
		}
	}

	/**
	 * See 3545139
	 * 
	 * Doesn't pass yet!
	 */
	@Test
	public void testUnknownVersion() throws Exception {

		int port1 = RandomServerPortProvider.findFreePort();
		SimpleServer ss = new SimpleServer(port1);
		ss.registerApplication("*", "*", this);

		ss.startAndWait();
		try {

			String messageText = "MSH|^~\\&|4265-ADT|4265|eReferral|eReferral|201004141020||ADT^A45^ADT_A45|102416|T^|2.6\r" //- 
					+ "EVN|A45|201004141020|\r"  //-
					+ "PID|1||7010226^^^4265^MR~0000000000^^^CANON^JHN^^^^^^GP~1736465^^^4265^VN||Park^Green^^^MS.^^L||19890812|F|||123 TestingLane^^TORONTO^CA-ON^M5G2C2^CAN^H^~^^^^^^^||^PRN^PH^^1^416^2525252^|^^^^^^^||||||||||||||||N\r" //-
			        + "PV1|1|I||||^^^WP^1469^^^^^^^^|||||||||||^Derkach^Peter.^^^Dr.||20913000131|||||||||||||||||||||||||201004011340|201004141018"; //-
			Socket s = new Socket();
			s.setSoTimeout(1000);
			s.connect(new InetSocketAddress("localhost", port1));

			ourLog.info("Sending message");
			new MinLLPWriter(s.getOutputStream()).writeMessage(messageText);

			ourLog.info("Reading response");

			String response = new MinLLPReader(s.getInputStream()).getMessage();

			ourLog.info("Response: " + response);
			Assert.assertTrue(response.contains("MSH|"));
			Assert.assertTrue(myGotMessage);
			Assert.assertTrue(response.contains("|2.6"));

		} finally {
			ss.stop();
		}
	}

	public boolean canProcess(Message theArg0) {
		return true;
	}


	public Message processMessage(Message theArg0) throws ApplicationException, HL7Exception {
		try {
			myGotMessage = true;
			ourLog.info("Received message: " + theArg0.encode());
			return theArg0.generateACK();
		} catch (IOException e) {
			Assert.fail(e.getMessage());
			throw new HL7Exception(e);
		}
	}

}
