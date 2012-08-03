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

import java.io.Serializable;
import java.util.concurrent.ExecutorService;

import ca.uhn.hl7v2.app.ConnectionHub;
import ca.uhn.hl7v2.app.HL7Service;
import ca.uhn.hl7v2.parser.GenericParser;
import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.parser.ParserConfiguration;
import ca.uhn.hl7v2.parser.PipeParser;
import ca.uhn.hl7v2.parser.XMLParser;
import ca.uhn.hl7v2.validation.MessageValidator;
import ca.uhn.hl7v2.validation.ValidationContext;
import ca.uhn.hl7v2.validation.impl.builder.ValidationRuleBuilder;

/**
 * Interface that provides a starting point for
 * <ul>
 * <li>Configuring HAPI core services (e.g. parsing)
 * <li>Plugging in singleton services (e.g. executor service)
 * <li>Obtaining correspondingly configured instances of HAPI core services
 * </ul>
 * 
 * HapiContext instances are not supposed to be singletons, i.e. if necessary, it is possible to
 * have several HapiContexts within one application.
 */
public interface HapiContext extends Serializable {

	// Singleton services
	ExecutorService getExecutorService();

	void setExecutorService(ExecutorService executorService);

	ConnectionHub getConnectionHub();

	/**
	 * @return the {@link ParserConfiguration} to be used by all parsers obtained from this class.
	 */
	ParserConfiguration getDefaultParserConfiguration();

	/**
	 * @param configuration {@link ParserConfiguration} to be used by all parsers obtained from this
	 *            class.
	 */
	void setDefaultParserConfiguration(ParserConfiguration configuration);

	/**
	 * @return the {@link ValidationContext} to be used by all parsers obtained from this class.
	 */
	ValidationContext getDefaultValidationContext();

	/**
	 * @param context {@link ValidationContext} to be used by all parsers obtained from this class.
	 */
	void setDefaultValidationContext(ValidationContext context);

	/**
	 * Sets a default {@link ValidationContext}. Note that a default {@link ValidationRuleBuilder}
	 * has precedence of this ValidationContext.
	 * 
	 * @param contextClassName class name of the {@link ValidationContext} to be used by all parsers
	 *            obtained from this class.
	 */
	void setDefaultValidationContext(String contextClassName);

	/**
	 * @return the {@link ValidationRuleBuilder} to be used by all parsers obtained from this class.
	 */
	ValidationRuleBuilder getDefaultValidationRuleBuilder();

	/**
	 * Sets a default {@link ValidationRuleBuilder}. Note that this {@link ValidationRuleBuilder}
	 * has precedence over a default {@link ValidationContext} set with
	 * {@link #setDefaultValidationContext(ValidationContext)} or
	 * {@link #setDefaultValidationContext(String)}
	 * 
	 * @param context {@link ValidationRuleBuilder} to be used by all parsers obtained from this
	 *            class.
	 */
	void setDefaultValidationRuleBuilder(ValidationRuleBuilder ruleBuilder);

	/**
	 * Sets a new instance of {@link ValidationRuleBuilder} as default. Note that this
	 * {@link ValidationRuleBuilder} has precedence over a default {@link ValidationContext} set
	 * with {@link #setDefaultValidationContext(ValidationContext)} or
	 * {@link #setDefaultValidationContext(String)}
	 * 
	 * @param builderClassName class name of the {@link ValidationRuleBuilder} to be used by all
	 *            parsers obtained from this class.
	 */
	void setDefaultValidationRuleBuilder(String builderClassName);

	/**
	 * @return the {@link ModelClassFactory} to be used by all parsers obtained from this class.
	 */
	ModelClassFactory getDefaultModelClassFactory();

	/**
	 * @param modelClassFactory the {@link ModelClassFactory} to be used by all parsers obtained
	 *            from this class.
	 */
	void setDefaultModelClassFactory(ModelClassFactory modelClassFactory);

	// Default instances of business objects

	/**
	 * @return a PipeParser instance initialized as set with
	 *         {@link #setDefaultModelClassFactory(ModelClassFactory)},
	 *         {@link #setDefaultValidationContext(String)} and
	 *         {@link #setDefaultParserConfiguration(ParserConfiguration)}.
	 */
	PipeParser getPipeParser();

	/**
	 * @return a XMLParser instance initialized as set with
	 *         {@link #setDefaultModelClassFactory(ModelClassFactory)},
	 *         {@link #setDefaultValidationContext(String)} and
	 *         {@link #setDefaultParserConfiguration(ParserConfiguration)}.
	 */
	XMLParser getXMLParser();

	/**
	 * @return a GenericParser instance initialized as set with
	 *         {@link #setDefaultModelClassFactory(ModelClassFactory)},
	 *         {@link #setDefaultValidationContext(String)} and
	 *         {@link #setDefaultParserConfiguration(ParserConfiguration)}.
	 */
	GenericParser getGenericParser();

	/**
	 * @return MessageValidator instance initialized with the {@link ValidationContext} as set using
	 *         {@link #setDefaultValidationContext(ValidationContext)}.
	 */
	MessageValidator getMessageValidator();

	/**
	 * @param port
	 * @param tls
	 * @return HL7 service running on the configured port using the default parser and executor
	 *         service instances provided by this interface.
	 */
	HL7Service getSimpleService(int port, boolean tls);

	/**
	 * @param port
	 * @param tls
	 * @return HL7 service running on the configured ports using the default parser and executor
	 *         service instances provided by this interface.
	 */
	HL7Service getTwoPortService(int inbound, int outbound, boolean tls);
}
