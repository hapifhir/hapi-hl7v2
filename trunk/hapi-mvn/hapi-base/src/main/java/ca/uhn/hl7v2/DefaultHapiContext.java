/**
The contents of this file are subject to the Mozilla Public License Version 1.1 
(the "License"); you may not use this file except in compliance with the License. 
You may obtain a copy of the License at http://www.mozilla.org/MPL/ 
Software distributed under the License is distributed on an "AS IS" basis, 
WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the 
specific language governing rights and limitations under the License. 

The Original Code is "DefaultHapiContext.java".  Description: 
"Default implementation of HAPI configuration and factory" 

The Initial Developer of the Original Code is University Health Network. Copyright (C) 
2001.  All Rights Reserved. 

Contributor(s): ______________________________________. 

Alternatively, the contents of this file may be used under the terms of the 
GNU General Public License (the  "GPL"), in which case the provisions of the GPL are 
applicable instead of those above.  If you wish to allow use of your version of this 
file only under the terms of the GPL and not to allow others to use your version 
of this file under the MPL, indicate your decision by deleting  the provisions above 
and replace  them with the notice and other provisions required by the GPL License.  
If you do not delete the provisions above, a recipient may use your version of 
this file under either the MPL or the GPL. 
 */
package ca.uhn.hl7v2;

import java.util.concurrent.ExecutorService;

import ca.uhn.hl7v2.app.ConnectionHub;
import ca.uhn.hl7v2.app.HL7Service;
import ca.uhn.hl7v2.app.SimpleServer;
import ca.uhn.hl7v2.app.TwoPortService;
import ca.uhn.hl7v2.concurrent.DefaultExecutorService;
import ca.uhn.hl7v2.llp.MinLowerLayerProtocol;
import ca.uhn.hl7v2.parser.DefaultModelClassFactory;
import ca.uhn.hl7v2.parser.DefaultXMLParser;
import ca.uhn.hl7v2.parser.GenericParser;
import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.parser.ParserConfiguration;
import ca.uhn.hl7v2.parser.PipeParser;
import ca.uhn.hl7v2.parser.XMLParser;
import ca.uhn.hl7v2.validation.MessageValidator;
import ca.uhn.hl7v2.validation.ValidationContext;
import ca.uhn.hl7v2.validation.ValidationException;
import ca.uhn.hl7v2.validation.impl.ValidationContextFactory;
import ca.uhn.hl7v2.validation.impl.builder.ValidationRuleBuilder;

/**
 * Default implementation for {@link HapiContext}.
 * 
 * With this class you can configure HAPI and obtain all major HAPI business objects that are
 * initialized accordingly. All configuration objects already have reasonable defaults.
 * <p>
 * When using Spring Framework for initializing objects, you can use the factory methods like this:
 * 
 * <pre>
 * &lt;!-- Define the context --&gt;
 * &lt;bean id="hapiContext" class="ca.uhn.hl7v2.DefaultHapiContext"&gt;
 *    ...
 * &lt;/bean&gt;
 * 
 * &lt;!-- Obtain the default PipeParser instance --&gt;
 * &lt;bean id="pipeParser" factory-bean="hapiContext" factory-method="getPipeParser"/&gt;
 * ...
 * </pre>
 * 
 */
@SuppressWarnings("serial")
public class DefaultHapiContext implements HapiContext {

	private ExecutorService executorService;
	private ParserConfiguration parserConfiguration;
	private ValidationContext validationContext;
	private ValidationRuleBuilder validationRuleBuilder;
	private ModelClassFactory modelClassFactory;

	public DefaultHapiContext() {
		this(new ParserConfiguration(), ValidationContextFactory.defaultValidation(),
				new DefaultModelClassFactory());
	}

	public DefaultHapiContext(ParserConfiguration parserConfiguration,
			ValidationContext validationContext, ModelClassFactory modelClassFactory) {
		VersionLogger.init();
		this.parserConfiguration = parserConfiguration;
		this.validationContext = validationContext;
		this.modelClassFactory = modelClassFactory;
	}
	
	public DefaultHapiContext(ParserConfiguration parserConfiguration,
			ValidationRuleBuilder builder, ModelClassFactory modelClassFactory) {
		VersionLogger.init();
		this.parserConfiguration = parserConfiguration;
		this.validationRuleBuilder = builder;
		this.modelClassFactory = modelClassFactory;
	}	

	public synchronized ExecutorService getExecutorService() {
		if (executorService == null) {
			executorService = DefaultExecutorService.getDefaultService();
			Runtime.getRuntime().addShutdownHook(new Thread() {

				@Override
				public void run() {
					executorService.shutdownNow();
				}

			});
		}
		return executorService;
	}

	public void setExecutorService(ExecutorService executorService) {
		this.executorService = executorService;
	}

	public ConnectionHub getConnectionHub() {
		return ConnectionHub.getInstance(getExecutorService());
	}

	public ParserConfiguration getDefaultParserConfiguration() {
		return parserConfiguration;
	}

	public void setDefaultParserConfiguration(ParserConfiguration configuration) {
		this.parserConfiguration = configuration;
	}

	public ValidationContext getDefaultValidationContext() {
		return validationContext == null ? ValidationContextFactory.defaultValidation()
				: validationContext;
	}

	public void setDefaultValidationContext(ValidationContext context) {
		this.validationContext = context;
	}

	public void setDefaultValidationContext(String contextClassName) {
		try {
			this.validationContext = ValidationContextFactory.customValidation(contextClassName);
		} catch (ValidationException e) {
			throw new IllegalArgumentException(e);
		}
	}

	public ValidationRuleBuilder getDefaultValidationRuleBuilder() {
		return validationRuleBuilder;
	}

	public void setDefaultValidationRuleBuilder(ValidationRuleBuilder validationRuleBuilder) {
		this.validationRuleBuilder = validationRuleBuilder;
	}

	public void setDefaultValidationRuleBuilder(String builderClassName) {
		try {
			this.validationRuleBuilder = ValidationContextFactory.customBuilder(builderClassName);
		} catch (ValidationException e) {
			throw new IllegalArgumentException(e);
		}
	}

	public ModelClassFactory getDefaultModelClassFactory() {
		return modelClassFactory;
	}

	public void setDefaultModelClassFactory(ModelClassFactory modelClassFactory) {
		this.modelClassFactory = modelClassFactory;
	}

	public PipeParser getPipeParser() {
		return new PipeParser(this);
	}

	public XMLParser getXMLParser() {
		return new DefaultXMLParser(this);
	}

	public GenericParser getGenericParser() {
		return new GenericParser(this);
	}

	public MessageValidator getMessageValidator() {
		return new MessageValidator(this);
	}

	public HL7Service getSimpleService(int port, boolean tls) {
		return new SimpleServer(port, new MinLowerLayerProtocol(), getPipeParser(), tls,
				getExecutorService());
	}

	public HL7Service getTwoPortService(int port1, int port2, boolean tls) {
		return new TwoPortService(getPipeParser(), new MinLowerLayerProtocol(), port1, port2, tls,
				getExecutorService());
	}

}
