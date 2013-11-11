/**
The contents of this file are subject to the Mozilla Public License Version 1.1 
(the "License"); you may not use this file except in compliance with the License. 
You may obtain a copy of the License at http://www.mozilla.org/MPL/ 
Software distributed under the License is distributed on an "AS IS" basis, 
WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the 
specific language governing rights and limitations under the License. 

The Original Code is "HapiContext.java".  Description: 
"HAPI configuration and factory" 

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
import ca.uhn.hl7v2.app.HL7Service;
import ca.uhn.hl7v2.app.ServerConfiguration;
import ca.uhn.hl7v2.conf.store.CodeStoreRegistry;
import ca.uhn.hl7v2.conf.store.ProfileStore;
import ca.uhn.hl7v2.llp.LowerLayerProtocol;
import ca.uhn.hl7v2.parser.GenericParser;
import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.parser.ParserConfiguration;
import ca.uhn.hl7v2.parser.PipeParser;
import ca.uhn.hl7v2.parser.XMLParser;
import ca.uhn.hl7v2.util.SocketFactory;
import ca.uhn.hl7v2.validation.ValidationContext;
import ca.uhn.hl7v2.validation.ValidationExceptionHandlerFactory;
import ca.uhn.hl7v2.validation.Validator;
import ca.uhn.hl7v2.validation.builder.ValidationRuleBuilder;

/**
 * Interface that provides a starting point for
 * <ul>
 * <li>Configuring HAPI core services (e.g. parsing)
 * <li>Obtaining correspondingly configured instances of HAPI core services
 * </ul>
 * 
 * HapiContext instances are not supposed to be singletons, i.e. if necessary, it is possible to
 * have several HapiContexts within one application.
 * <p>
 * HapiContext objects maintains the following configuration information
 * <ul>
 * <li>{@link ExecutorService}: thread executors used for the HAPI networking features in
 * ca.uhn.hl7v2.app
 * <li>{@link LowerLayerProtocol}: MLLP protocol used for the HAPI networking features in
 * ca.uhn.hl7v2.app
 * <li>{@link SocketFactory}: Socket factory used for the HAPI networking features in
 * ca.uhn.hl7v2.app
 * <li>{@link ParserConfiguration}: detail configuration for all HL7 parsers
 * <li>{@link ModelClassFactory}: lookup for message model classes during parsing or message
 * creation
 * <li>{@link ValidationContext}: validation rules used during parsing or during a dedcated
 * validation step
 * <li>{@link ValidationRuleBuilder}: alternative way of providing a ValidationContext
 * <li>{@link ValidationExceptionHandlerFactory}: factory for exception handler used during message validation
 * </ul>
 * <p>
 * HapiContext serves as factory for HAPI objects that refer to this configuration. Changing the
 * configuration automatically influence all HAPI objects that were created and will be created
 * using the given factory instance:
 * <ul>
 * <li>{@link PipeParser}
 * <li>{@link XMLParser}
 * <li>{@link GenericParser}
 * <li>{@link Validator}
 * <li>{@link ConnectionHub}
 * <li>{@link ca.uhn.hl7v2.app.SimpleServer}
 * <li>{@link ca.uhn.hl7v2.app.TwoPortService}
 * </ul>
 * 
 */
public interface HapiContext {

	/**
	 * @return the {@link ExecutorService} to be used by all services that spawn threads
	 */
	ExecutorService getExecutorService();

	/**
	 * @param executorService the {@link ExecutorService} to be used by all services that spawn
	 *            threads
	 */
	void setExecutorService(ExecutorService executorService);

	/**
	 * @return a new ConnectionHub instance
	 */
	ConnectionHub getConnectionHub();

	/**
	 * @return the {@link ParserConfiguration} to be used by all parsers obtained from this class.
	 */
	ParserConfiguration getParserConfiguration();

	/**
	 * @return the {@link ServerConfiguration} to be used by all HL7 servers obtained from this class.
	 * @see #newServer(int, boolean)
	 * @see #newServer(int, int, boolean)
	 */
	ServerConfiguration getServerConfiguration();

	/**
	 * Sets the {@link ServerConfiguration} to be used by all HL7 servers obtained from this class.
	 * 
	 * @see #newServer(int, boolean)
	 * @see #newServer(int, int, boolean)
	 */
	void setServerConfiguration(ServerConfiguration theServerConfiguration);
	
	/**
	 * @param configuration {@link ParserConfiguration} to be used by all parsers obtained from this
	 *            class.
	 */
	void setParserConfiguration(ParserConfiguration configuration);

	/**
	 * @return the {@link ValidationContext} to be used by all parsers obtained from this class.
	 */
	ValidationContext getValidationContext();

	/**
	 * @param context {@link ValidationContext} to be used by all parsers obtained from this class.
	 */
	void setValidationContext(ValidationContext context);

	/**
	 * Sets a default {@link ValidationContext}. Note that a default {@link ValidationRuleBuilder}
	 * has precedence of this ValidationContext.
	 * 
	 * @param contextClassName class name of the {@link ValidationContext} to be used by all parsers
	 *            obtained from this class.
	 */
	void setValidationContext(String contextClassName);

	/**
	 * @return the {@link ValidationRuleBuilder} to be used by all parsers obtained from this class.
	 */
	ValidationRuleBuilder getValidationRuleBuilder();

	/**
	 * Sets a default {@link ValidationRuleBuilder}. Note that this {@link ValidationRuleBuilder}
	 * has precedence over a default {@link ValidationContext} set with
	 * {@link #setValidationContext(ValidationContext)} or {@link #setValidationContext(String)}
	 * 
	 * @param ruleBuilder {@link ValidationRuleBuilder} to be used by all parsers obtained from this
	 *            class.
	 */
	void setValidationRuleBuilder(ValidationRuleBuilder ruleBuilder);

	/**
	 * Sets a new instance of {@link ValidationRuleBuilder} as default. Note that this
	 * {@link ValidationRuleBuilder} has precedence over a default {@link ValidationContext} set
	 * with {@link #setValidationContext(ValidationContext)} or
	 * {@link #setValidationContext(String)}
	 * 
	 * @param builderClassName class name of the {@link ValidationRuleBuilder} to be used by all
	 *            parsers obtained from this class.
	 */
	void setValidationRuleBuilder(String builderClassName);

	/**
	 * @return the {@link ModelClassFactory} to be used by all parsers obtained from this class.
	 */
	ModelClassFactory getModelClassFactory();

	/**
	 * @param modelClassFactory the {@link ModelClassFactory} to be used by all parsers obtained
	 *            from this class.
	 */
	void setModelClassFactory(ModelClassFactory modelClassFactory);
	
	/**
	 * @return the {@link ProfileStore} to be used for loading conformance profile files
	 */
	ProfileStore getProfileStore();
	
	/**
	 * @param store the {@link ProfileStore} to be used for loading conformance profile files
	 */
	void setProfileStore(ProfileStore store);
	
    /**
     * @return the {@link CodeStoreRegistry} to be used for serving codes for conformance profiles
     */
	CodeStoreRegistry getCodeStoreRegistry();
    
    /**
     * @param store the {@link CodeStoreRegistry} to be used for serving codes for conformance profiles
     */
    void setCodeStoreRegistry(CodeStoreRegistry store);	

	// Default instances of business objects

	/**
	 * @return a new PipeParser instance initialized as set with
	 *         {@link #setModelClassFactory(ModelClassFactory)},
	 *         {@link #setValidationContext(String)} and
	 *         {@link #setParserConfiguration(ParserConfiguration)}.
	 */
	PipeParser getPipeParser();

	/**
	 * @return a new XMLParser instance initialized as set with
	 *         {@link #setModelClassFactory(ModelClassFactory)},
	 *         {@link #setValidationContext(String)} and
	 *         {@link #setParserConfiguration(ParserConfiguration)}.
	 */
	XMLParser getXMLParser();

	/**
	 * @return a new GenericParser instance initialized as set with
	 *         {@link #setModelClassFactory(ModelClassFactory)},
	 *         {@link #setValidationContext(String)} and
	 *         {@link #setParserConfiguration(ParserConfiguration)}.
	 */
	GenericParser getGenericParser();

    /**
     * Returns a ca.uhn.hl7v2.conf.check.Validator instance. It is recommended to
     * use {@link #getMessageValidator()} and configure a Validation rule that checks
     * a message against a conformance profile
     * 
     * @return a ca.uhn.hl7v2.conf.check.Validator instance initialized as set with
     * {@link #setCodeStoreRegistry(CodeStoreRegistry)}
     */
    ca.uhn.hl7v2.conf.check.Validator getConformanceValidator();
    
	/**
	 * @return a MessageValidator instance initialized with the {@link ValidationContext} as set
	 *         using {@link #setValidationContext(ValidationContext)}. For each validation it will
	 *         use a new instance of {@link ca.uhn.hl7v2.validation.ValidationExceptionHandler ValidationExceptionHandler} as obtained by
	 *         {@link #getValidationExceptionHandlerFactory()}.
	 */
	<R> Validator<R> getMessageValidator();
	
	<R> ValidationExceptionHandlerFactory<R> getValidationExceptionHandlerFactory();

	/**
	 * @param factory a {@link ValidationExceptionHandlerFactory} that is used to create
	 * a {@link ca.uhn.hl7v2.validation.ValidationExceptionHandler ValidationExceptionHandler} during message validation.
	 */
	<R> void setValidationExceptionHandlerFactory(ValidationExceptionHandlerFactory<R> factory);

	/**
	 * @return the {@link LowerLayerProtocol} instance used by all HL7 MLLP operations
	 */
	LowerLayerProtocol getLowerLayerProtocol();

	/**
	 * @param llp the {@link LowerLayerProtocol} instance used by all HL7 MLLP operations
	 */
	void setLowerLayerProtocol(LowerLayerProtocol llp);

	/**
	 * @return the {@link SocketFactory} instance used by HL7 networking operations
	 */
	SocketFactory getSocketFactory();

	/**
	 * @param socketFactory the {@link SocketFactory} instance used by HL7 networking operations
	 */
	void setSocketFactory(SocketFactory socketFactory);

	/**
	 * Construct a new HL7 Server which will listen for incoming connections
	 * 
	 * @param port The port on which to listen for new connections
	 * @param tls Whether or not to use SSL/TLS
	 * @return HL7 service running on the configured port using the default parser and executor
	 *         service instances provided by this interface. Note that the returned service <b>will not
	 *         be started</b>, and must manually be started using {@link HL7Service#start()} or
	 *         {@link HL7Service#startAndWait()}
	 * @see <a href="http://hl7api.sourceforge.net/xref/ca/uhn/hl7v2/examples/SendAndReceiveAMessage.html">here</a> for an example of how to use this method
	 * @see #setSocketFactory(SocketFactory)
	 */
	HL7Service newServer(int port, boolean tls);

	/**
	 * Construct a new HL7 Server which will listen for a pair of connections (one for
	 * incoming messages, one for outgoing)
	 * 
	 * @param inboundPort The port on which to listen for connections for inbound messages
	 * @param outboundPort The port on which to listen for connections for outgoing messages
	 * @param tls Whether or not to use SSL/TLS
	 * @return HL7 service running on the configured ports using the default parser and executor
	 *         service instances provided by this interface. Note that the returned service <b>will not
	 *         be started</b>, and must manually be started using {@link HL7Service#start()} or
	 *         {@link HL7Service#startAndWait()}
	 * @see <a href="http://hl7api.sourceforge.net/xref/ca/uhn/hl7v2/examples/SendAndReceiveAMessage.html">here</a> for an example of how to use this method
	 * @see #setSocketFactory(SocketFactory)
	 */
	HL7Service newServer(int inboundPort, int outboundPort, boolean tls);
	
	/**
	 * Construct a new HL7 Client which will connect to an external TCP server for
	 * the purpose of sending messages (and receiving responses). Unless otherwise
	 * stated, the connection is established by the time this method
	 * returns, or an exception should be thrown if the connection can not be
	 * established. If a connection to this server already exists, it is reused.
	 * <p>
	 * Note that connections are pooled by the HapiContext by default. If multiple
	 * concurrent connections to the same server are required, the easiest way
	 * to accomplish this is currently to create multiple HapiContext instances.
	 * </p>
	 * 
	 * @param host The host IP/hostname to connect to
	 * @param port The port to connect to
	 * @param tls Whether or not to use SSL/TLS
	 * @return Returns a connection which can be used to transmit messages. Note that this method
	 *         will attempt to connect to the specified address, and will throw an exception
	 *         if it fails to connect.
	 * @see <a href="http://hl7api.sourceforge.net/xref/ca/uhn/hl7v2/examples/SendAndReceiveAMessage.html">here</a> for an example of how to use this method
	 * @throws HL7Exception If the connection can not be initialized for any reason 
	 */
	Connection newClient(String host, int port, boolean tls) throws HL7Exception;

    /**
     * Construct a new HL7 Client which will connect to an external TCP server for
     * the purpose of sending messages (and receiving responses). The connection
     * should be established by the time the first message is sent.
	 * <p>
	 * Note that connections are pooled by the HapiContext by default. If multiple
	 * concurrent connections to the same server are required, the easiest way
	 * to accomplish this is currently to create multiple HapiContext instances.
	 * </p>
     *
     * @param host The host IP/hostname to connect to
     * @param port The port to connect to
     * @param tls Whether or not to use SSL/TLS
     * @return Returns a connection which can be used to transmit messages.
     * @see <a href="http://hl7api.sourceforge.net/xref/ca/uhn/hl7v2/examples/SendAndReceiveAMessage.html">here</a> for an example of how to use this method
     * @throws HL7Exception If the connection can not be initialized for any reason
     */
    Connection newLazyClient(String host, int port, boolean tls) throws HL7Exception;

    /**
     * Construct a new HL7 two-port client which will connect to an external TCP server for
     * the purpose of sending messages (and receiving responses). Unless otherwise
     * stated, the connection is established by the time this method
     * returns, or an exception should be thrown if the connection can not be
     * established. If a connection to this server already exists, it is reused.
	 * <p>
	 * Note that connections are pooled by the HapiContext by default. If multiple
	 * concurrent connections to the same server are required, the easiest way
	 * to accomplish this is currently to create multiple HapiContext instances.
	 * </p>
     *
     * @param host The host IP/hostname to connect to
     * @param outboundPort The port to connect to for outgoing messages
     * @param inboundPort The port to connect to for inbound (response) messages
     * @param tls Whether or not to use SSL/TLS
     * @return Returns a connection which can be used to transmit messages. Note that this method
     *         will attempt to connect to the specified address, and will throw an exception
     *         if it fails to connect.
     * @throws HL7Exception If the connection can not be initialized for any reason
     */
    Connection newClient(String host, int outboundPort, int inboundPort, boolean tls) throws HL7Exception;

    /**
     * Construct a new HL7 two-port client which will connect to an external TCP server for
     * the purpose of sending messages (and receiving responses). The connection
     * should be established by the time the first message is sent.
	 * <p>
	 * Note that connections are pooled by the HapiContext by default. If multiple
	 * concurrent connections to the same server are required, the easiest way
	 * to accomplish this is currently to create multiple HapiContext instances.
	 * </p>
     *
     * @param host The host IP/hostname to connect to
     * @param outboundPort The port to connect to for outgoing messages
     * @param inboundPort The port to connect to for inbound (response) messages
     * @param tls Whether or not to use SSL/TLS
     * @return Returns a connection which can be used to transmit messages.
     * @throws HL7Exception If the connection can not be initialized for any reason
     */
    Connection newLazyClient(String host, int outboundPort, int inboundPort, boolean tls) throws HL7Exception;

}
