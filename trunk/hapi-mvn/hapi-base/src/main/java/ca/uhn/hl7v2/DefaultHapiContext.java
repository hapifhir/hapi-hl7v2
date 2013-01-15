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

import ca.uhn.hl7v2.app.Connection;
import ca.uhn.hl7v2.app.ConnectionHub;
import ca.uhn.hl7v2.app.SimpleServer;
import ca.uhn.hl7v2.app.TwoPortService;
import ca.uhn.hl7v2.concurrent.DefaultExecutorService;
import ca.uhn.hl7v2.conf.store.CodeStoreRegistry;
import ca.uhn.hl7v2.conf.store.DefaultCodeStoreRegistry;
import ca.uhn.hl7v2.conf.store.ProfileStore;
import ca.uhn.hl7v2.conf.store.ProfileStoreFactory;
import ca.uhn.hl7v2.llp.LowerLayerProtocol;
import ca.uhn.hl7v2.llp.MinLowerLayerProtocol;
import ca.uhn.hl7v2.parser.DefaultModelClassFactory;
import ca.uhn.hl7v2.parser.DefaultXMLParser;
import ca.uhn.hl7v2.parser.GenericParser;
import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.parser.ParserConfiguration;
import ca.uhn.hl7v2.parser.PipeParser;
import ca.uhn.hl7v2.parser.XMLParser;
import ca.uhn.hl7v2.util.SocketFactory;
import ca.uhn.hl7v2.util.StandardSocketFactory;
import ca.uhn.hl7v2.validation.DefaultValidationExceptionHandler;
import ca.uhn.hl7v2.validation.DefaultValidator;
import ca.uhn.hl7v2.validation.ReportingValidationExceptionHandler;
import ca.uhn.hl7v2.validation.ValidationContext;
import ca.uhn.hl7v2.validation.ValidationExceptionHandlerFactory;
import ca.uhn.hl7v2.validation.Validator;
import ca.uhn.hl7v2.validation.builder.ValidationRuleBuilder;
import ca.uhn.hl7v2.validation.impl.ValidationContextFactory;

/**
 * Default implementation for {@link HapiContext}.
 * 
 * With this class you can configure HAPI and obtain all major HAPI business
 * objects that are initialized accordingly. All configuration objects already
 * have reasonable defaults.
 * <p>
 * When using Spring Framework for initializing objects, you can use the factory
 * methods like this:
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
public class DefaultHapiContext implements HapiContext {

    private ExecutorService executorService;
    private ParserConfiguration parserConfiguration;
    private ValidationContext validationContext;
    private ValidationRuleBuilder validationRuleBuilder;
    private ModelClassFactory modelClassFactory;
    private ConnectionHub connectionHub;
    private LowerLayerProtocol llp;
    private SocketFactory socketFactory;
    private ProfileStore profileStore;
    private CodeStoreRegistry codeStoreRegistry;
    private PipeParser pipeParser;
    private XMLParser xmlParser;
    private GenericParser genericParser;
    private Validator<?> validator;
    private ValidationExceptionHandlerFactory<?> validationExceptionHandlerFactory;

    public DefaultHapiContext() {
        this(new DefaultModelClassFactory());
    }

    public DefaultHapiContext(ExecutorService executorService) {
        this();
        setExecutorService(executorService);
    }

    public DefaultHapiContext(ModelClassFactory modelClassFactory) {
        this(new ParserConfiguration(), ValidationContextFactory.defaultValidation(),
                modelClassFactory);
    }

    public DefaultHapiContext(ValidationContext validationContext) {
        this(new ParserConfiguration(), validationContext, new DefaultModelClassFactory());
    }

    public DefaultHapiContext(ValidationRuleBuilder builder) {
        this(new ParserConfiguration(), builder, new DefaultModelClassFactory());
    }

    public DefaultHapiContext(ParserConfiguration parserConfiguration,
            ValidationContext validationContext, ModelClassFactory modelClassFactory) {
        VersionLogger.init();
        setParserConfiguration(parserConfiguration);
        setValidationContext(validationContext);
        setModelClassFactory(modelClassFactory);
        setLowerLayerProtocol(new MinLowerLayerProtocol());
        setSocketFactory(new StandardSocketFactory());
        setValidationExceptionHandlerFactory(new ReportingValidationExceptionHandler(true));
        setProfileStore(ProfileStoreFactory.getProfileStore());
        setCodeStoreRegistry(new DefaultCodeStoreRegistry());
    }

    public DefaultHapiContext(ParserConfiguration parserConfiguration,
            ValidationRuleBuilder builder, ModelClassFactory modelClassFactory) {
        VersionLogger.init();
        setParserConfiguration(parserConfiguration);
        setValidationRuleBuilder(builder);
        setModelClassFactory(modelClassFactory);
        setLowerLayerProtocol(new MinLowerLayerProtocol());
        setSocketFactory(new StandardSocketFactory());
        setProfileStore(ProfileStoreFactory.getProfileStore());
        setCodeStoreRegistry(new DefaultCodeStoreRegistry());
    }

    public DefaultHapiContext(HapiContext context) {
        this(context.getParserConfiguration(), context.getValidationContext(), context
                .getModelClassFactory());
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

    public synchronized void setExecutorService(ExecutorService executorService) {
        this.executorService = executorService;
    }

    public ConnectionHub getConnectionHub() {
        if (this.connectionHub == null) {
            this.connectionHub = ConnectionHub.getNewInstance(this);
        }
        return this.connectionHub;
    }

    public ParserConfiguration getParserConfiguration() {
        return parserConfiguration;
    }

    public void setParserConfiguration(ParserConfiguration configuration) {
        if (configuration == null)
            throw new IllegalArgumentException("ParserConfiguration must not be null");
        this.parserConfiguration = configuration;
    }

    /**
     * Returns the ValidationContext. If none has been explicitly set,
     * {@link #getValidationRuleBuilder()} is called in order to to contruct a
     * context. If this is also null, the ca.uhn.hl7v2.validation.context_class
     * system property is evaluated, otherwise it returns the DefaultValidation
     * context.
     */
    public ValidationContext getValidationContext() {
        if (validationContext == null) {

            if (getValidationRuleBuilder() != null) {
                setValidationContext(ValidationContextFactory
                        .fromBuilder(getValidationRuleBuilder()));
            } else {
                try {
                    setValidationContext(ValidationContextFactory.getContext());
                } catch (HL7Exception e) {
                    setValidationContext(ValidationContextFactory.defaultValidation());
                }
            }
        }
        return validationContext;
    }

    public void setValidationContext(ValidationContext context) {
        this.validationContext = context;
    }

    public void setValidationContext(String contextClassName) {
        try {
            this.validationContext = ValidationContextFactory.customValidation(contextClassName);
        } catch (HL7Exception e) {
            throw new IllegalArgumentException(e);
        }
    }

    public ValidationRuleBuilder getValidationRuleBuilder() {
        return validationRuleBuilder;
    }

    public void setValidationRuleBuilder(ValidationRuleBuilder validationRuleBuilder) {
        this.validationRuleBuilder = validationRuleBuilder;
        setValidationContext(ValidationContextFactory.fromBuilder(validationRuleBuilder));
    }

    public void setValidationRuleBuilder(String builderClassName) {
        try {
            setValidationRuleBuilder(ValidationContextFactory.customBuilder(builderClassName));
        } catch (HL7Exception e) {
            throw new IllegalArgumentException(e);
        }
    }

    public ModelClassFactory getModelClassFactory() {
        return modelClassFactory == null ? new DefaultModelClassFactory() : modelClassFactory;
    }

    public void setModelClassFactory(ModelClassFactory modelClassFactory) {
        this.modelClassFactory = modelClassFactory;
    }
    
    public ProfileStore getProfileStore() {
        return profileStore;
    }

    public void setProfileStore(ProfileStore profileStore) {
        this.profileStore = profileStore;
    }

    public CodeStoreRegistry getCodeStoreRegistry() {
        return codeStoreRegistry;
    }

    public void setCodeStoreRegistry(CodeStoreRegistry codeStoreRegistry) {
        this.codeStoreRegistry = codeStoreRegistry;
    }
    
    public ca.uhn.hl7v2.conf.check.Validator getConformanceValidator() {
        return new ca.uhn.hl7v2.conf.check.DefaultValidator(this);
    }

    public synchronized PipeParser getPipeParser() {
        if (pipeParser == null) {
            pipeParser = new PipeParser(this);
        }
        return pipeParser;
    }

    public synchronized XMLParser getXMLParser() {
        if (xmlParser == null) {
            xmlParser = new DefaultXMLParser(this);
        }
        return xmlParser;
    }

    public synchronized GenericParser getGenericParser() {
        if (genericParser == null) {
            genericParser = new GenericParser(this);
        }
        return genericParser;
    }

    @SuppressWarnings("unchecked")
    public synchronized <R> Validator<R> getMessageValidator() {
        if (validator == null) {
            validator = new DefaultValidator<R>(this);
        }
        return (Validator<R>) validator;
    }

    @SuppressWarnings("unchecked")
    public <R> ValidationExceptionHandlerFactory<R> getValidationExceptionHandlerFactory() {
    	if (validationExceptionHandlerFactory == null) {
    		validationExceptionHandlerFactory = new DefaultValidationExceptionHandler(this);
    	}
        return (ValidationExceptionHandlerFactory<R>) validationExceptionHandlerFactory;
    }

    public <R> void setValidationExceptionHandlerFactory(
            ValidationExceptionHandlerFactory<R> factory) {
    	if (factory == null) {
    		throw new NullPointerException("ValidationExceptionHandlerFactory can not be null");
    	}
        this.validationExceptionHandlerFactory = factory;
    }

    public LowerLayerProtocol getLowerLayerProtocol() {
        return llp;
    }

    public void setLowerLayerProtocol(LowerLayerProtocol llp) {
        this.llp = llp;
    }

    public SocketFactory getSocketFactory() {
        return socketFactory;
    }

    public void setSocketFactory(SocketFactory socketFactory) {
        this.socketFactory = socketFactory;
    }

    public SimpleServer newServer(int port, boolean tls) {
        return new SimpleServer(this, port, tls);
    }

    public TwoPortService newServer(int port1, int port2, boolean tls) {
        return new TwoPortService(this, port1, port2, tls);
    }

	public Connection newClient(String host, int port, boolean tls) throws HL7Exception {
		return getConnectionHub().attach(this, host, port, tls);
	}

	public Connection newClient(String host, int outboundPort, int inboundPort, boolean tls) throws HL7Exception {
		return getConnectionHub().attach(this, host, outboundPort, inboundPort, tls);
	}

}
