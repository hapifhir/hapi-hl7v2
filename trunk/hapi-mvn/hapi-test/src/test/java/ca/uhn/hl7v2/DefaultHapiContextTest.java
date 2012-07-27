package ca.uhn.hl7v2;

import static org.junit.Assert.assertSame;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ca.uhn.hl7v2.app.HL7Service;
import ca.uhn.hl7v2.parser.DefaultModelClassFactory;
import ca.uhn.hl7v2.parser.GenericParser;
import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.parser.ParserConfiguration;
import ca.uhn.hl7v2.parser.PipeParser;
import ca.uhn.hl7v2.parser.XMLParser;
import ca.uhn.hl7v2.util.RandomServerPortProvider;
import ca.uhn.hl7v2.validation.DefaultValidator;
import ca.uhn.hl7v2.validation.ValidationContext;
import ca.uhn.hl7v2.validation.impl.DefaultValidation;

public class DefaultHapiContextTest {

	private HapiContext context;
	private ModelClassFactory modelClassFactory;
	private ParserConfiguration config;
	private ValidationContext validation;
	private ExecutorService executor;
	
	@Before
	public void before() {
		modelClassFactory = new DefaultModelClassFactory();
		config = new ParserConfiguration();
		validation = new DefaultValidation();
		executor = Executors.newCachedThreadPool();
		context = new DefaultHapiContext(config, validation, modelClassFactory);
		context.setExecutorService(executor);
	}
	
	@After
	public void after() {
		executor.shutdownNow();
	}
	
	@Test
	public void testGetPipeParser() {
		PipeParser p = context.getPipeParser();
		assertSame(modelClassFactory, p.getFactory());
		assertSame(config, p.getParserConfiguration());
		assertSame(validation, p.getValidationContext());
	}
	
	@Test
	public void testGetXMLParser() {
		XMLParser p = context.getXMLParser();
		assertSame(modelClassFactory, p.getFactory());
		assertSame(config, p.getParserConfiguration());
		assertSame(validation, p.getValidationContext());
	}
	
	@Test
	public void testGetGenericParser() {
		GenericParser p = context.getGenericParser();
		assertSame(modelClassFactory, p.getFactory());
		assertSame(config, p.getParserConfiguration());
		assertSame(validation, p.getValidationContext());
	}
	
	@Test
	public void testGetSimpleServer() {
		HL7Service s = context.getSimpleService(RandomServerPortProvider.findFreePort(), false);
		assertSame(executor, s.getExecutorService());
	}

	@Test
	public void testGetTwoPortServer() {
		int port1 = RandomServerPortProvider.findFreePort();
		int port2 = RandomServerPortProvider.findFreePort();
		HL7Service s = context.getTwoPortService(port1, port2, false);
		assertSame(executor, s.getExecutorService());
	}
	
	@Test
	public void testGetMessageValidator() {
		DefaultValidator v = (DefaultValidator)context.getMessageValidator();
		assertSame(validation, v.getValidationContext());
	}	
}
