/*
 * Created on Dec 12, 2006
 */
package ca.uhn.hl7v2.app;

import java.io.IOException;
import java.net.Socket;
import java.util.Map;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.llp.LLPException;
import ca.uhn.hl7v2.llp.MinLLPReader;
import ca.uhn.hl7v2.llp.MinLLPWriter;
import ca.uhn.hl7v2.llp.MinLowerLayerProtocol;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.parser.GenericParser;
import ca.uhn.hl7v2.protocol.ReceivingApplication;
import ca.uhn.hl7v2.protocol.ReceivingApplicationException;
import ca.uhn.hl7v2.util.RandomServerPortProvider;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Test case for responder
 * 
 * @version $Revision: 1.1 $ updated on $Date: 2007-02-19 02:24:40 $ by $Author:
 *          jamesagnew $
 */
public class ResponderTest {

	private static SimpleServer server;
	private static Socket socket;
	private static MinLLPWriter writer;
	private static MinLLPReader reader;

	@BeforeClass
	public static void setUp() throws Exception {
		int port = RandomServerPortProvider.findFreePort();
		server = new SimpleServer(port, new MinLowerLayerProtocol(),
				new GenericParser());
		server.registerApplication("*", "*", new DummyApplication());
		server.start();
		
		socket = TestUtils.acquireClientSocket(port);
		
		writer = new MinLLPWriter(socket.getOutputStream());
		reader = new MinLLPReader(socket.getInputStream());
	}

	@AfterClass
	public static void tearDown() throws Exception {
		server.stopAndWait();
		socket.close();
	}

	@Test
	public void testResponseEncoding() throws HL7Exception, LLPException,
			IOException {

		String outMsg = "MSH|^~\\&|||||20061212094425.814-0500||ACK|2059434|P|2.2\r\n"
				+ "MAS|AA|20167098";

		writer.writeMessage(outMsg);
		String inMsg = reader.getMessage();

		assertTrue(inMsg.indexOf("MSH|") == 0);

	}

	@Test
	public void testResponseEncodingXml() throws LLPException, IOException {
		String outMsg = "<?xml version=\"1.0\"?>\r\n"
				+ "<ACK xmlns=\"urn:hl7-org:v2xml\">\r\n" + "    <MSH>\r\n"
				+ "        <MSH.1>|</MSH.1>\r\n"
				+ "        <MSH.2>^~\\&amp;</MSH.2>\r\n"
				+ "        <MSH.7>\r\n"
				+ "            <TS.1>20061212094425.814-0500</TS.1>\r\n"
				+ "        </MSH.7>\r\n" + "        <MSH.9>\r\n"
				+ "            <CM_MSG.1>ACK</CM_MSG.1>\r\n"
				+ "        </MSH.9>\r\n"
				+ "        <MSH.10>2059434</MSH.10>\r\n"
				+ "        <MSH.11>P</MSH.11>\r\n"
				+ "        <MSH.12>2.2</MSH.12>\r\n" + "    </MSH>\r\n"
				+ "    <MSA/>\r\n" + "    <ERR/>\r\n" + "    <MAS>\r\n"
				+ "        <MAS.1>AA</MAS.1>\r\n"
				+ "        <MAS.2>20167098</MAS.2>\r\n" + "    </MAS>\r\n"
				+ "</ACK>";

		writer.writeMessage(outMsg);
		String inMsg = reader.getMessage();

		assertTrue(inMsg.indexOf("<?xml") == 0);

	}

	/**
	 * Application which always throws an HL7 exception
	 * 
	 * @author <a href="mailto:james.agnew@uhn.on.ca">James Agnew</a>
	 * @version $Revision: 1.1 $ updated on $Date: 2007-02-19 02:24:40 $ by
	 *          $Author: jamesagnew $
	 */
	public static class DummyApplication implements ReceivingApplication<Message> {

		/**
		 * {@inheritDoc}
		 */
		public boolean canProcess(Message theIn) {
			return true;
		}

		/**
		 * {@inheritDoc}
		 */
		public Message processMessage(Message theIn, Map<String, Object> metadata)
				throws ReceivingApplicationException, HL7Exception {
			throw new HL7Exception("Test error");
		}

	}
	
}
