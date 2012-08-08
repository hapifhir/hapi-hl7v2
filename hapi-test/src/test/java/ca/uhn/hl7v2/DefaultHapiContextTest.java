package ca.uhn.hl7v2;

import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.fail;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ca.uhn.hl7v2.app.ConnectionHub;
import ca.uhn.hl7v2.app.HL7Service;
import ca.uhn.hl7v2.llp.MinLowerLayerProtocol;
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
		HL7Service s = context1.getSimpleService(RandomServerPortProvider.findFreePort(), false);
		assertSame(executor, s.getExecutorService());
	}

	@Test
	public void testGetTwoPortServer() {
		int port1 = RandomServerPortProvider.findFreePort();
		int port2 = RandomServerPortProvider.findFreePort();
		HL7Service s = context1.getTwoPortService(port1, port2, false);
		assertSame(executor, s.getExecutorService());
	}

	@Test
	public void testGetMessageValidator() {
		DefaultValidator v = (DefaultValidator) context1.getMessageValidator();
		assertSame(validation, v.getValidationContext());
		v = (DefaultValidator) context2.getMessageValidator();
		assertNotSame(validation, v.getValidationContext());
	}
	
	@Test
	public void testConnectionHubUsesCorrectExecutorService() throws Exception {
		int port = RandomServerPortProvider.findFreePort();
		ReceiveAndCloseImmediatelyThread t = new ReceiveAndCloseImmediatelyThread(port);
		t.start();

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

		public ReceiveAndCloseImmediatelyThread(int thePort) {
			myPort = thePort;
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
				}
			}
		}

	}
	
	
}
