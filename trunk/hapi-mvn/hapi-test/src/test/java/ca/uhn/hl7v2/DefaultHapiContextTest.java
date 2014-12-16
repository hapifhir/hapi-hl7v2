package ca.uhn.hl7v2;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import ca.uhn.hl7v2.app.Connection;
import ca.uhn.hl7v2.app.ConnectionHub;
import ca.uhn.hl7v2.app.ConnectionHubTest;
import ca.uhn.hl7v2.app.HL7Service;
import ca.uhn.hl7v2.conf.store.ProfileStoreFactory;
import ca.uhn.hl7v2.llp.LLPException;
import ca.uhn.hl7v2.llp.MinLowerLayerProtocol;
import ca.uhn.hl7v2.model.v25.message.ADT_A45;
import ca.uhn.hl7v2.parser.DefaultModelClassFactory;
import ca.uhn.hl7v2.parser.GenericParser;
import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.parser.ParserConfiguration;
import ca.uhn.hl7v2.parser.PipeParser;
import ca.uhn.hl7v2.parser.XMLParser;
import ca.uhn.hl7v2.util.RandomServerPortProvider;
import ca.uhn.hl7v2.validation.DefaultValidator;
import ca.uhn.hl7v2.validation.ValidationContext;
import ca.uhn.hl7v2.validation.builder.ValidationRuleBuilder;
import ca.uhn.hl7v2.validation.builder.support.DefaultValidationBuilder;
import ca.uhn.hl7v2.validation.impl.DefaultValidation;

public class DefaultHapiContextTest {

	private HapiContext context1;
	private HapiContext context2;
	private ModelClassFactory modelClassFactory;
	private ParserConfiguration config;
	private ValidationContext validation;
	private ValidationRuleBuilder builder;
	private ExecutorService executor;

	@Before
	public void before() {
		modelClassFactory = new DefaultModelClassFactory();
		config = new ParserConfiguration();
		validation = new DefaultValidation();
		builder = new DefaultValidationBuilder();
		executor = Executors.newCachedThreadPool();
		context1 = new DefaultHapiContext(config, validation, modelClassFactory);
		context1.setExecutorService(executor);
		context2 = new DefaultHapiContext(config, builder, modelClassFactory);
		context2.setExecutorService(executor);
	}

	@After
	public void after() {
		executor.shutdownNow();
	}

	@Test
	public void testClose() throws IOException {
		new DefaultHapiContext().close();
	}

	/**
	 * Creating a HAPI context shouldn't have the side effect of
	 * creating a profiles directory
	 */
	@Test
	public void testContextDoesntCreateProfileDirectory() {
		String dir = ProfileStoreFactory.DEFAULT_PROFILE_STORE_DIRECTORY;
		assertFalse('"' + dir + "\" exists! Remove this directory and try the unit test again (it should not be auto-created).", new File(dir).exists());
	}

	@AfterClass
	public static void afterClass() {
		String dir = ProfileStoreFactory.DEFAULT_PROFILE_STORE_DIRECTORY;
		new File(dir).delete();
	}
	
	@Test
	public void testGetPipeParser() {
		PipeParser p = context1.getPipeParser();
		assertSame(modelClassFactory, p.getFactory());
		assertSame(config, p.getParserConfiguration());
		assertSame(validation, p.getValidationContext());
		p = context2.getPipeParser();
		assertSame(modelClassFactory, p.getFactory());
		assertSame(config, p.getParserConfiguration());
		assertNotSame(validation, p.getValidationContext());
	}

	@Test
	public void testGetXMLParser() {
		XMLParser p = context1.getXMLParser();
		assertSame(modelClassFactory, p.getFactory());
		assertSame(config, p.getParserConfiguration());
		assertSame(validation, p.getValidationContext());
		p = context2.getXMLParser();
		assertSame(modelClassFactory, p.getFactory());
		assertSame(config, p.getParserConfiguration());
		assertNotSame(validation, p.getValidationContext());
	}

	@Test
	public void testGetGenericParser() {
		GenericParser p = context1.getGenericParser();
		assertSame(modelClassFactory, p.getFactory());
		assertSame(config, p.getParserConfiguration());
		assertSame(validation, p.getValidationContext());
		p = context2.getGenericParser();
		assertSame(modelClassFactory, p.getFactory());
		assertSame(config, p.getParserConfiguration());
		assertNotSame(validation, p.getValidationContext());
	}

	@Test
	public void testGetSimpleServer() {
		HL7Service s = context1.newServer(RandomServerPortProvider.findFreePort(), false);
		assertSame(executor, s.getExecutorService());
	}

	@Test
	public void testGetTwoPortServer() {
		int port1 = RandomServerPortProvider.findFreePort();
		int port2 = RandomServerPortProvider.findFreePort();
		HL7Service s = context1.newServer(port1, port2, false);
		assertSame(executor, s.getExecutorService());
	}

	@Test
	public void testGetMessageValidator() {
		DefaultValidator<?> v = (DefaultValidator<?>) context1.getMessageValidator();
		assertSame(validation, v.getValidationContext());
		v = (DefaultValidator<?>) context2.getMessageValidator();
		assertNotSame(validation, v.getValidationContext());
	}
	
	/**
	 * Make sure that connection hub doesn't try to reuse a connection which is already closed
	 * 
	 * @throws IOException
	 * @throws LLPException
	 * @throws InterruptedException 
	 */
	@Test
	public void testGetClient() throws HL7Exception, LLPException, IOException, InterruptedException {

		int port1 = RandomServerPortProvider.findFreePort();
		int port2 = RandomServerPortProvider.findFreePort();
		HL7Service ss1 = context1.newServer(port1, false);
		ss1.registerApplication("*", "*", new ConnectionHubTest.MyApp());
		ss1.startAndWait();

		try {
			context1.newClient("localhost", port2, false);
			fail("This should throw an exception, nothing listening on port " + port2);
		} catch (HL7Exception e) {
			
		}
		
		Connection i1 = context1.newClient("localhost", port1, false);

		String messageText = "MSH|^~\\&|4265-ADT|4265|eReferral|eReferral|201004141020||ADT^A45^ADT_A45|102416|T^|2.5^^|||NE|AL|CAN|8859/1\r"
				+ "EVN|A45|201004141020|\r"
				+ "PID|1||7010226^^^4265^MR~0000000000^^^CANON^JHN^^^^^^GP~1736465^^^4265^VN||Park^Green^^^MS.^^L||19890812|F|||123 TestingLane^^TORONTO^CA-ON^M5G2C2^CAN^H^~^^^^^^^||^PRN^PH^^1^416^2525252^|^^^^^^^||||||||||||||||N\r"
				+ "PV1|1|I||||^^^WP^1469^^^^^^^^|||||||||||^Derkach^Peter.^^^Dr.||20913000131|||||||||||||||||||||||||201004011340|201004141018";
		ADT_A45 msg = new ADT_A45();
		msg.setParser(context1.getPipeParser());
		msg.parse(messageText);
		i1.getInitiator().sendAndReceive(msg);
		
		Connection i1again = context1.newClient("localhost", port1, false);
		assertThat(i1, is(i1again));
		
		i1.close(); // PROBLEM: connection still in hub table
		System.out.println("Connection closed 1");

		i1again = context1.newClient("localhost", port1, false);
		assertThat(i1, not(i1again));
		i1again.getInitiator().sendAndReceive(msg);
		i1again.close();
		System.out.println("Connection closed 2");
	}

    @Test
    public void testGetLazyClient() throws HL7Exception, LLPException, IOException, InterruptedException {

        int port1 = RandomServerPortProvider.findFreePort();
        int port2 = RandomServerPortProvider.findFreePort();


        Connection i1 = context1.newLazyClient("localhost", port1, false);
        Connection i2 = context1.newLazyClient("localhost", port2, false);

        HL7Service ss1 = context1.newServer(port1, false);
        ss1.registerApplication("*", "*", new ConnectionHubTest.MyApp());
        ss1.startAndWait();

        String messageText = "MSH|^~\\&|4265-ADT|4265|eReferral|eReferral|201004141020||ADT^A45^ADT_A45|102416|T^|2.5^^|||NE|AL|CAN|8859/1\r"
                + "EVN|A45|201004141020|\r"
                + "PID|1||7010226^^^4265^MR~0000000000^^^CANON^JHN^^^^^^GP~1736465^^^4265^VN||Park^Green^^^MS.^^L||19890812|F|||123 TestingLane^^TORONTO^CA-ON^M5G2C2^CAN^H^~^^^^^^^||^PRN^PH^^1^416^2525252^|^^^^^^^||||||||||||||||N\r"
                + "PV1|1|I||||^^^WP^1469^^^^^^^^|||||||||||^Derkach^Peter.^^^Dr.||20913000131|||||||||||||||||||||||||201004011340|201004141018";
        ADT_A45 msg = new ADT_A45();
        msg.setParser(context1.getPipeParser());
        msg.parse(messageText);
        i1.getInitiator().sendAndReceive(msg);

        Connection i1again = context1.newLazyClient("localhost", port1, false);
        assertThat(i1, is(i1again));

        // Returns the previous connection even if it's a lazy one
        i1again = context1.newClient("localhost", port1, false);
        assertThat(i1, is(i1again));

        i1.close();

        i1again = context1.newClient("localhost", port1, false);
        assertThat(i1, not(i1again)); // Closed connection are discarded
        i1again.getInitiator().sendAndReceive(msg);
        i1again.close();
    }

	@Test
	public void testConnectionHubUsesCorrectExecutorService() throws Exception {
		int port = RandomServerPortProvider.findFreePort();
		ReceiveAndCloseImmediatelyThread t = new ReceiveAndCloseImmediatelyThread(port);
		t.start();
		t.awaitForStart();

		try {

			ExecutorService executor = Executors.newCachedThreadPool();
			DefaultHapiContext context = new DefaultHapiContext();
			context.setExecutorService(executor);
			ConnectionHub connectionHub = context.getConnectionHub();
			PipeParser pipeParser = PipeParser.getInstanceWithNoValidation();
			MinLowerLayerProtocol llp = new MinLowerLayerProtocol();
			connectionHub.attach("localhost", port, pipeParser, llp, false);
			executor.shutdown();

			Thread.sleep(100);
			
			executor = Executors.newCachedThreadPool();
			context = new DefaultHapiContext();
			context.setExecutorService(executor);
			connectionHub = context.getConnectionHub();

			/*
			 * This fails if a new connectionhub hasn't been created, or
			 * if the old executor service is used by the new hub. 
			 */
			connectionHub.attach("localhost", port, pipeParser, llp, false);

		} finally {
			t.finish();
		}
	}

	private class ReceiveAndCloseImmediatelyThread extends Thread {

		private int myPort;
		private boolean myDone;
		private CountDownLatch myLatch = new CountDownLatch(1);

		public ReceiveAndCloseImmediatelyThread(int thePort) {
			myPort = thePort;
		}

		public void awaitForStart() throws InterruptedException {
			myLatch.await();
		}

		public void finish() {
			myDone = true;
		}

		@Override
		public void run() {

			ServerSocket ss;
			try {
				ss = new ServerSocket(myPort);
			} catch (IOException e1) {
				e1.printStackTrace();
				fail(e1.getMessage());
				return;
			}

			while (!myDone) {
				try {
					ss.setSoTimeout(500);
					Socket s = ss.accept();
					s.close();
				} catch (SocketTimeoutException e) {
					// ignore
				} catch (IOException e) {
					e.printStackTrace();
					fail(e.getMessage());
				} finally {
					myLatch.countDown();
				}
			}
		}

	}
	
	
}
