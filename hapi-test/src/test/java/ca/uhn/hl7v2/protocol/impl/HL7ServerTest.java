/*
 * Created on 25-May-2004
 */
package ca.uhn.hl7v2.protocol.impl;

import static org.junit.Assert.*;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.app.SimpleServer;
import ca.uhn.hl7v2.app.TestUtils;
import ca.uhn.hl7v2.llp.MinLLPReader;
import ca.uhn.hl7v2.llp.MinLLPWriter;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.v26.message.ADT_A01;
import ca.uhn.hl7v2.protocol.ApplicationRouter;
import ca.uhn.hl7v2.protocol.MockApp;
import ca.uhn.hl7v2.protocol.ReceivingApplication;
import ca.uhn.hl7v2.protocol.ReceivingApplicationException;
import ca.uhn.hl7v2.protocol.SafeStorage;
import ca.uhn.hl7v2.protocol.StreamSource;
import ca.uhn.hl7v2.protocol.Transportable;
import ca.uhn.hl7v2.util.RandomServerPortProvider;

/**
 * Unit tests for <code>HL7Server</code>. 
 * 
 * @author <a href="mailto:bryan.tripp@uhn.on.ca">Bryan Tripp</a>
 * @version $Revision: 1.2 $ updated on $Date: 2010-04-25 16:22:52 $ by $Author: jamesagnew $
 */
public class HL7ServerTest implements ReceivingApplication<Message> {
	private static final org.slf4j.Logger ourLog = org.slf4j.LoggerFactory.getLogger(HL7ServerTest.class);
	private int myMsgCount;

	@Before
	public void setUp() {
		myMsgCount = 0;
	}
	
	@Test
    public void testResponse() throws Exception {
        int port = 9878;
        String localhost = "127.0.0.1";
        ServerSocket ss = new ServerSocket(port);
        SafeStorage storage = new NullSafeStorage();
        ApplicationRouter router = new ApplicationRouterImpl();
        router.bindApplication(new AppRoutingDataImpl("*", "*", "*", "*"), new MockApp());

        HL7Server server = new HL7Server(ss, router, storage);
        server.start(localhost);
                
        StreamSource sender = new ClientSocketStreamSource(new InetSocketAddress(localhost, port));
        MLLPTransport transport = new MLLPTransport(sender);
        transport.connect();
        
        String message = "MSH|^~\\&|LABGL1||DMCRES||19951002180700||ORU^R01|LABGL1199510021807427|P|2.2\rPID|||T12345||TEST^PATIENT^P||19601002|M||||||||||123456";
        transport.send(new TransportableImpl(message));
        Transportable inbound = transport.receive();
        
        assertTrue(inbound.getMessage().indexOf("mock") > -1);     
        
        transport.disconnect();
        ss.close();
        
        try {
            Thread.sleep(100); //give it time to start before we stop it
        } catch (InterruptedException e) {}
        server.stop();
        
    }
    
//	@Test
//    public void testResponseToInvalidMessage() throws Exception {
//        int port = RandomServerPortProvider.findFreePort();
//        String localhost = "127.0.0.1";
//        ServerSocket ss = new ServerSocket(port);
//        SafeStorage storage = new NullSafeStorage();
//        ApplicationRouter router = new ApplicationRouterImpl();
//        router.bindApplication(new AppRoutingDataImpl("*", "*", "*", "*"), new MockApp());
//
//        HL7Server server = new HL7Server(ss, router, storage);
//        server.start(localhost);
//                
//        StreamSource sender = new ClientSocketStreamSource(new InetSocketAddress(localhost, port));
//        MLLPTransport transport = new MLLPTransport(sender);
//        transport.connect();
//        
//        String message = "MSH{{{{{|LABGL1||DMCRES||19951002180700||ORU^R01|LABGL1199510021807427|P|2.2\rPID|||T12345||TEST^PATIENT^P||19601002|M||||||||||123456";
//        transport.send(new TransportableImpl(message));
//        Transportable inbound = transport.receive();
//        
//        assertTrue(inbound.getMessage().indexOf("mock") > -1);     
//        
//        transport.disconnect();
//        ss.close();
//        
//        try {
//            Thread.sleep(100); //give it time to start before we stop it
//        } catch (InterruptedException e) {}
//        server.stop();
//        
//    }

	@Test
	public void testReceiveWithDelayInBetween() throws Exception {

		int port = RandomServerPortProvider.findFreePort();
//		SimpleServer server = new SimpleServer(port, new MinLowerLayerProtocol(), PipeParser.getInstanceWithNoValidation());
//		server.registerApplication("*", "*", this);
//		server.start();
		
        ServerSocket ss = new ServerSocket(port);
        SafeStorage storage = new NullSafeStorage();
        ApplicationRouter router = new ApplicationRouterImpl();
        router.bindApplication(new AppRoutingDataImpl("*", "*", "*", "*"), this);

        HL7Server server = new HL7Server(ss, router, storage);
        String localhost = "127.0.0.1";
        server.start(localhost);
        
		Socket socket = TestUtils.acquireClientSocket(port);
		
		MinLLPWriter w = new MinLLPWriter(socket.getOutputStream());
		MinLLPReader r = new MinLLPReader(socket.getInputStream());
		
		ADT_A01 msg = new ADT_A01();
		msg.initQuickstart("ADT", "A01", "T");
		w.writeMessage(msg.encode());
		
		String resp = r.getMessage();
		ourLog.info(resp.replace("\r", "\n"));
		
		Thread.sleep(SimpleServer.SO_TIMEOUT + 500);
		
		msg = new ADT_A01();
		msg.initQuickstart("ADT", "A01", "T");
		w.writeMessage(msg.encode());
		resp = r.getMessage();
		ourLog.info(resp.replace("\r", "\n"));
		
		assertEquals(2, myMsgCount);

		assertFalse(server.getProcessors().length == 0);

		socket.close();
		
	}

	public Message processMessage(Message theMessage, Map<String, Object> theMetadata) throws ReceivingApplicationException, HL7Exception {
		try {
			Message generateACK = theMessage.generateACK();
			myMsgCount++;
			return generateACK;
		} catch (IOException e) {
			throw new HL7Exception(e);
		}
	}

	public boolean canProcess(Message theMessage) {
		return true;
	}

    
}
