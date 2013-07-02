/**
The contents of this file are subject to the Mozilla Public License Version 1.1 
(the "License"); you may not use this file except in compliance with the License. 
You may obtain a copy of the License at http://www.mozilla.org/MPL/ 
Software distributed under the License is distributed on an "AS IS" basis, 
WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the 
specific language governing rights and limitations under the License. 

The Original Code is "HapiContextSupport.java".  Description: 
"Abstract base class for subclasses supporting the access to a HapiContext." 

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
import ca.uhn.hl7v2.parser.*;
import ca.uhn.hl7v2.util.SocketFactory;
import ca.uhn.hl7v2.validation.ValidationContext;
import ca.uhn.hl7v2.validation.ValidationExceptionHandlerFactory;
import ca.uhn.hl7v2.validation.Validator;
import ca.uhn.hl7v2.validation.builder.ValidationRuleBuilder;

/**
 * Abstract base class for subclasses supporting the access to a HapiContext.
 * 
 * @author Christian Ohr
 */
public abstract class HapiContextSupport {

	private HapiContext context;

	public HapiContextSupport(HapiContext context) {
		super();
		this.context = context;
	}

	/**
	 * Returns a unmodifiable instance of HapiContext
	 */
	public final HapiContext getHapiContext() {
		return unmodifiableContext(context);
	}

	/**
	 * Only for internal purposes: associate a new {@link HapiContext} with an existing
	 * service object.
	 * 
	 * @param context new {@link HapiContext}
	 */
	protected void setHapiContext(HapiContext context) {
		this.context = context;
	}

	/**
	 * Supports the intention that HapiContext instances should not be altered e.g. from within a
	 * Parser instance, but only explicitly from where the HapiContext instance is actually owned.
	 * 
	 * @param context context to be made unmodifiable
	 * @return an unmodifiable HapiContext
	 */
	private static HapiContext unmodifiableContext(HapiContext context) {
		return new UnmodifiableHapiContext(context);
	}

	private static class UnmodifiableHapiContext implements HapiContext {

		private HapiContext context;
		
		public UnmodifiableHapiContext(HapiContext context) {
			this.context = context;
		}

		public CodeStoreRegistry getCodeStoreRegistry() {
            return context.getCodeStoreRegistry();
        }

		public ca.uhn.hl7v2.conf.check.Validator getConformanceValidator() {
            return context.getConformanceValidator();
        }

		public ConnectionHub getConnectionHub() {
			return context.getConnectionHub();
		}

		public ExecutorService getExecutorService() {
			return context.getExecutorService();
		}

		public GenericParser getGenericParser() {
			return context.getGenericParser();
		}

		public LowerLayerProtocol getLowerLayerProtocol() {
			return context.getLowerLayerProtocol();
		}

		public <R> Validator<R> getMessageValidator() {
			return context.getMessageValidator();
		}

		public ModelClassFactory getModelClassFactory() {
			return context.getModelClassFactory();
		}

		public ParserConfiguration getParserConfiguration() {
			return context.getParserConfiguration();
		}

		public PipeParser getPipeParser() {
			return context.getPipeParser();
		}

		public ProfileStore getProfileStore() {
            return context.getProfileStore();
        }

		public SocketFactory getSocketFactory() {
			return context.getSocketFactory();
		}

		public ValidationContext getValidationContext() {
			return context.getValidationContext();
		}

		public <R> ValidationExceptionHandlerFactory<R> getValidationExceptionHandlerFactory() {
			return context.getValidationExceptionHandlerFactory();
		}

		public ValidationRuleBuilder getValidationRuleBuilder() {
			return context.getValidationRuleBuilder();
		}

		public XMLParser getXMLParser() {
			return context.getXMLParser();
		}

		public Connection newClient(String host, int port, boolean tls) throws HL7Exception {
			return context.newClient(host, port, tls);
		}

        public Connection newClient(String host, int outboundPort, int inboundPort, boolean tls) throws HL7Exception {
			return context.newClient(host, outboundPort, inboundPort, tls);
		}

        public Connection newLazyClient(String host, int port, boolean tls) throws HL7Exception {
            return context.newLazyClient(host, port, tls);
        }

        public Connection newLazyClient(String host, int outboundPort, int inboundPort, boolean tls) throws HL7Exception {
            return context.newLazyClient(host, outboundPort, inboundPort, tls);
        }

        public HL7Service newServer(int port, boolean tls) {
			return context.newServer(port, tls);
		}

        public HL7Service newServer(int inboundPort, int outboundPort, boolean tls) {
			return context.newServer(inboundPort, outboundPort, tls);
		}

        public void setCodeStoreRegistry(CodeStoreRegistry store) {
            throw new UnsupportedOperationException("Read-only instance");
        }

        public void setExecutorService(ExecutorService executorService) {
			throw new UnsupportedOperationException("Read-only instance");
		}
        
        public void setLowerLayerProtocol(LowerLayerProtocol llp) {
			throw new UnsupportedOperationException("Read-only instance");
		}

		public void setModelClassFactory(ModelClassFactory modelClassFactory) {
			throw new UnsupportedOperationException("Read-only instance");
		}

		public void setParserConfiguration(ParserConfiguration configuration) {
			throw new UnsupportedOperationException("Read-only instance");
		}

		public void setProfileStore(ProfileStore store) {
            throw new UnsupportedOperationException("Read-only instance");
        }

		public void setSocketFactory(SocketFactory socketFactory) {
			throw new UnsupportedOperationException("Read-only instance");
		}

		public void setValidationContext(String contextClassName) {
			throw new UnsupportedOperationException("Read-only instance");
		}

		public void setValidationContext(ValidationContext context) {
			throw new UnsupportedOperationException("Read-only instance");
		}

		public <R> void setValidationExceptionHandlerFactory(
				ValidationExceptionHandlerFactory<R> factory) {
			context.setValidationExceptionHandlerFactory(factory);
		}

		public void setValidationRuleBuilder(String builderClassName) {
			throw new UnsupportedOperationException("Read-only instance");
		}

		public void setValidationRuleBuilder(ValidationRuleBuilder ruleBuilder) {
			throw new UnsupportedOperationException("Read-only instance");
		}

		public ServerConfiguration getServerConfiguration() {
			return context.getServerConfiguration();
		}
		
		
	}

}
