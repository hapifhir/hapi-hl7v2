/**
The contents of this file are subject to the Mozilla Public License Version 1.1 
(the "License"); you may not use this file except in compliance with the License. 
You may obtain a copy of the License at http://www.mozilla.org/MPL/ 
Software distributed under the License is distributed on an "AS IS" basis, 
WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the 
specific language governing rights and limitations under the License. 

The Original Code is "Parser.java".  Description: 
"Parses HL7 message Strings into HL7 Message objects and 
  encodes HL7 Message objects into HL7 message Strings" 

The Initial Developer of the Original Code is University Health Network. Copyright (C) 
2001.  All Rights Reserved. 

Contributor(s): ______________________________________. 

Alternatively, the contents of this file may be used under the terms of the 
GNU General Public License (the "GPL"), in which case the provisions of the GPL are 
applicable instead of those above.  If you wish to allow use of your version of this 
file only under the terms of the GPL and not to allow others to use your version 
of this file under the MPL, indicate your decision by deleting  the provisions above 
and replace  them with the notice and other provisions required by the GPL License.  
If you do not delete the provisions above, a recipient may use your version of 
this file under either the MPL or the GPL. 
*/

package ca.uhn.hl7v2.parser;

import java.lang.reflect.Constructor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ca.uhn.hl7v2.DefaultHapiContext;
import ca.uhn.hl7v2.ErrorCode;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.HapiContext;
import ca.uhn.hl7v2.HapiContextSupport;
import ca.uhn.hl7v2.Version;
import ca.uhn.hl7v2.model.AbstractSuperMessage;
import ca.uhn.hl7v2.model.GenericMessage;
import ca.uhn.hl7v2.model.GenericSegment;
import ca.uhn.hl7v2.model.Group;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.Segment;
import ca.uhn.hl7v2.model.Type;
import ca.uhn.hl7v2.util.ReflectionUtil;
import ca.uhn.hl7v2.util.StringUtil;
import ca.uhn.hl7v2.util.Terser;
import ca.uhn.hl7v2.validation.ValidationContext;
import ca.uhn.hl7v2.validation.ValidationExceptionHandler;
import ca.uhn.hl7v2.validation.ValidationExceptionHandlerFactory;
import ca.uhn.hl7v2.validation.Validator;

/**
 * Parses HL7 message Strings into HL7 Message objects and encodes HL7 Message objects into HL7
 * message Strings.
 * 
 * @author Bryan Tripp (bryan_tripp@sourceforge.net)
 * @author Christian Ohr
 */
public abstract class Parser extends HapiContextSupport {

	private static final Logger log = LoggerFactory.getLogger(Parser.class);
	
	/**
	 * Uses DefaultModelClassFactory for model class lookup.
	 */
	public Parser() {
		this(new DefaultHapiContext());
	}

	/**
	 * Creates a new parser, using the {@link ModelClassFactory}, the {@link ParserConfiguration}
	 * and the {@link ValidationContext} as defined in the context.
	 * 
	 * @param context HapiContext
	 */
	public Parser(HapiContext context) {
		super(context);
	}

	/**
	 * Initialize parser with custom ModelClassFactory and default ValidationContext
	 * 
	 * @param modelClassFactory custom factory to use for model class lookup
	 */
	public Parser(ModelClassFactory modelClassFactory) {
		this(new DefaultHapiContext(modelClassFactory));
	}

	/**
	 * @return the factory used by this Parser for model class lookup
	 */
	public ModelClassFactory getFactory() {
		return getHapiContext().getModelClassFactory();
	}

	/**
	 * @return the set of validation rules that is applied to messages parsed or encoded by this
	 *         parser. Note that this method may return <code>null</code>
	 */
	public ValidationContext getValidationContext() {
		return isValidating() ? getHapiContext().getValidationContext() : null;
	}

	/**
	 * @param context the set of validation rules to be applied to messages parsed or encoded by
	 *            this parser (defaults to ValidationContextFactory.DefaultValidation)
	 * 
	 * @deprecated use a dedicated {@link HapiContext} and set its ValidationContext property
	 */
	public void setValidationContext(ValidationContext context) {
		HapiContext newContext = new DefaultHapiContext(getHapiContext());
		newContext.setValidationContext(context);
		setHapiContext(newContext);
	}

	/**
	 * <p>
	 * Returns the parser configuration. This is a bean which contains configuration
	 * instructions relating to how a parser should be parsing or encoding messages it deals
	 * with.
	 * </p>
	 * <p>
	 * <b>Note that the parser configuration comes from the {@link #getHapiContext() HAPI Context}.</b>
	 * Changes to the configuration for one parser will affect all parsers which share the same
	 * context.
	 * </p>
     *
     * @return the current parser configuration
	 */
	public ParserConfiguration getParserConfiguration() {
		return getHapiContext().getParserConfiguration();
	}

	/**
	 * Sets the parser configuration for this parser (may not be null). This is a bean which
	 * contains configuration instructions relating to how a parser should be parsing or encoding
	 * messages it deals with.
	 * 
	 * @param configuration The parser configuration
	 * 
	 * @deprecated use a dedicated {@link HapiContext} and set its ParserConfiguration property
	 */
	public void setParserConfiguration(ParserConfiguration configuration) {
		HapiContext newContext = new DefaultHapiContext(getHapiContext());
		newContext.setParserConfiguration(configuration);
		setHapiContext(newContext);
	}

	/**
	 * Returns a String representing the encoding of the given message, if the encoding is
	 * recognized. For example if the given message appears to be encoded using HL7 2.x XML rules
	 * then "XML" would be returned. If the encoding is not recognized then null is returned. That
	 * this method returns a specific encoding does not guarantee that the message is correctly
	 * encoded (e.g. well formed XML) - just that it is not encoded using any other encoding than
	 * the one returned. Returns null if the encoding is not recognized.
     *
     * @param message message string
     * @return string representing the encoding of the given message, i.e. "XML" or "ER7"
	 */
	public abstract String getEncoding(String message);

	/**
	 * Returns true if and only if the given encoding is supported by this Parser.
     * @param encoding the encoding, "XML" or "ER7"
     * @return true if this parser supports parsing message encoded this way
	 */
	public boolean supportsEncoding(String encoding) {
		return getDefaultEncoding().equalsIgnoreCase(encoding);
	}
	
	/**
	 * @return the preferred encoding of this Parser ("XML" or "ER7")
	 */
	public abstract String getDefaultEncoding();

	/**
	 * Parses a message string and returns the corresponding Message object.
	 * 
	 * @param message a String that contains an HL7 message
	 * @return a HAPI Message object parsed from the given String
	 * @throws HL7Exception if the message is not correctly formatted.
	 * @throws EncodingNotSupportedException if the message encoded is not supported by this parser.
	 */
	public Message parse(String message) throws HL7Exception {
		String encoding = getEncoding(message);
		if (!supportsEncoding(encoding)) {
			String startOfMessage = null;
			if (message.startsWith("MSH")) {
				int indexOfCR = message.indexOf('\r');
				if (indexOfCR > 0) {
					startOfMessage = message.substring(0, indexOfCR);
				}
			} 
			if (startOfMessage == null) {
				startOfMessage = message.substring(0, Math.min(message.length(), 50));
			}
			throw new EncodingNotSupportedException("Determine encoding for message. The following is the first 50 chars of the message for reference, although this may not be where the issue is: "
					+ startOfMessage);
		}

		String version = getVersion(message);
		
		if (!getParserConfiguration().isAllowUnknownVersions()) {
			assertVersionExists(version);
		}

		assertMessageValidates(message, encoding, version);
		Message result = doParse(message, version);
		assertMessageValidates(result);

		result.setParser(this);

		applySuperStructureName(result);
		
		return result;
	}

	/**
	 * Called by parse() to perform implementation-specific parsing work.
	 * 
	 * @param message a String that contains an HL7 message
	 * @param version the name of the HL7 version to which the message belongs (eg "2.5")
	 * @return a HAPI Message object parsed from the given String
	 * @throws HL7Exception if the message is not correctly formatted.
	 * @throws EncodingNotSupportedException if the message encoded is not supported by this parser.
	 */
	protected abstract Message doParse(String message, String version) throws HL7Exception;

	/**
	 * Formats a Message object into an HL7 message string using the given encoding.
	 * 
	 * @param source a Message object from which to construct an encoded message string
	 * @param encoding the name of the HL7 encoding to use (eg "XML"; most implementations support
	 *            only one encoding)
	 * @return the encoded message
	 * @throws HL7Exception if the data fields in the message do not permit encoding (e.g. required
	 *             fields are null)
	 * @throws EncodingNotSupportedException if the requested encoding is not supported by this
	 *             parser.
	 */
	public String encode(Message source, String encoding) throws HL7Exception {
		assertMessageValidates(source);
		String result = doEncode(source, encoding);
	    assertMessageValidates(result, encoding, source.getVersion());
		return result;
	}

	/**
	 * Called by encode(Message, String) to perform implementation-specific encoding work.
	 * 
	 * @param source a Message object from which to construct an encoded message string
	 * @param encoding the name of the HL7 encoding to use (eg "XML"; most implementations support
	 *            only one encoding)
	 * @return the encoded message
	 * @throws HL7Exception if the data fields in the message do not permit encoding (e.g. required
	 *             fields are null)
	 * @throws EncodingNotSupportedException if the requested encoding is not supported by this
	 *             parser.
	 */
	protected abstract String doEncode(Message source, String encoding) throws HL7Exception;

	/**
	 * Formats a Message object into an HL7 message string using this parser's default encoding.
	 * 
	 * @param source a Message object from which to construct an encoded message string
	 * @return the encoded message
	 * @throws HL7Exception if the data fields in the message do not permit encoding (e.g. required
	 *             fields are null)
	 */
	public String encode(Message source) throws HL7Exception {
		assertMessageValidates(source);
		String result = doEncode(source);
		assertMessageValidates(result, getDefaultEncoding(), source.getVersion());
		return result;
	}

	/**
	 * Called by encode(Message) to perform implementation-specific encoding work.
	 * 
	 * @param source a Message object from which to construct an encoded message string
	 * @return the encoded message
	 * @throws HL7Exception if the data fields in the message do not permit encoding (e.g. required
	 *             fields are null)
	 * @throws EncodingNotSupportedException if the requested encoding is not supported by this
	 *             parser.
	 */
	protected abstract String doEncode(Message source) throws HL7Exception;

	/**
	 * <p>
	 * Returns a minimal amount of data from a message string, including only the data needed to
	 * send a response to the remote system. This includes the following fields:
	 * <ul>
	 * <li>field separator</li>
	 * <li>encoding characters</li>
	 * <li>processing ID</li>
	 * <li>message control ID</li>
	 * </ul>
	 * This method is intended for use when there is an error parsing a message, (so the Message
	 * object is unavailable) but an error message must be sent back to the remote system including
	 * some of the information in the inbound message. This method parses only that required
	 * information, hopefully avoiding the condition that caused the original error.
	 * </p>
	 *
     * @param message the message
	 * @return an MSH segment
     * @throws HL7Exception if no MSH segment could be created
	 */
	public abstract Segment getCriticalResponseData(String message) throws HL7Exception;

	/**
	 * For response messages, returns the value of MSA-2 (the message ID of the message sent by the
	 * sending system). This value may be needed prior to main message parsing, so that
	 * (particularly in a multi-threaded scenario) the message can be routed to the thread that sent
	 * the request. We need this information first so that any parse exceptions are thrown to the
	 * correct thread. Implementers of Parsers should take care to make the implementation of this
	 * method very fast and robust. Returns null if MSA-2 can not be found (e.g. if the message is
	 * not a response message).
     *
     * @param message the message
     * @return the value of MSA-2
	 */
	public abstract String getAckID(String message);

	/**
	 * Returns the version ID (MSH-12) from the given message, without fully parsing the message.
	 * The version is needed prior to parsing in order to determine the message class into which the
	 * text of the message should be parsed.
	 *
     * @param message the message
     * @return the value of MSH-12
	 * @throws HL7Exception if the version field can not be found.
	 */
	public abstract String getVersion(String message) throws HL7Exception;

	/**
	 * Encodes a particular segment and returns the encoded structure
	 * 
	 * @param structure The structure to encode
	 * @param encodingCharacters The encoding characters
	 * @return The encoded segment
	 * @throws HL7Exception If there is a problem encoding
	 * @since 1.0
	 */
	public abstract String doEncode(Segment structure, EncodingCharacters encodingCharacters)
			throws HL7Exception;

	/**
	 * Encodes a particular type and returns the encoded structure
	 * 
	 * @param type The type to encode
	 * @param encodingCharacters The encoding characters
	 * @return The encoded type
	 * @throws HL7Exception If there is a problem encoding
	 * @since 1.0
	 */
	public abstract String doEncode(Type type, EncodingCharacters encodingCharacters)
			throws HL7Exception;

	/**
	 * Parses a particular type and returns the encoded structure
	 * 
	 * @param string The string to parse
	 * @param type The type to encode
	 * @param encodingCharacters The encoding characters
	 * @throws HL7Exception If there is a problem encoding
	 * @since 1.0
	 */
	public abstract void parse(Type type, String string, EncodingCharacters encodingCharacters)
			throws HL7Exception;

	/**
	 * Parse a message using a specific model package instead of the default, using
	 * {@link ModelClassFactory#getMessageClassInASpecificPackage(String, String, boolean, String)}
	 * .
	 * 
	 * <b>WARNING: This method is only implemented in some parser implementations</b>. Currently it
	 * will only work with the PipeParser parser implementation. Use with caution.
     *
     * @param message message string
     * @param packageName name of the package of the models
     * @return parsed message
     * @throws HL7Exception if an error occurred while parsing
	 */
	public Message parseForSpecificPackage(String message, String packageName) throws HL7Exception {
		String encoding = getEncoding(message);
		if (!supportsEncoding(encoding)) {
			throw new EncodingNotSupportedException("Can't parse message beginning "
					+ message.substring(0, Math.min(message.length(), 50)));
		}

		String version = getVersion(message);
		assertVersionExists(version);

		assertMessageValidates(message, encoding, version);
		Message result = doParseForSpecificPackage(message, version, packageName);
		assertMessageValidates(result);

		result.setParser(this);
		return result;
	}

	/**
	 * Attempt the parse a message using a specific model package
	 */
	protected abstract Message doParseForSpecificPackage(String message, String version,
			String packageName) throws HL7Exception;

	/**
	 * Instantiate a message type using a specific package name
	 * 
	 * @see ModelClassFactory#getMessageClassInASpecificPackage(String, String, boolean, String)
	 */
	protected Message instantiateMessageInASpecificPackage(String theName, String theVersion,
		boolean isExplicit, String packageName) throws HL7Exception {
		Class<? extends Message> messageClass = getFactory().getMessageClassInASpecificPackage(
				theName, theVersion, isExplicit, packageName);
		if (messageClass == null) {
			throw new HL7Exception("Can't find message class in current package list: " + theName);
		}
	    return ReflectionUtil.instantiateMessage(messageClass, getFactory());
	}

	/**
	 * Parses a particular segment and returns the encoded structure
	 *
     * @param segment The segment to encode
     * @param string The string to parse
	 * @param encodingCharacters The encoding characters
	 * @throws HL7Exception If there is a problem encoding
	 */
	public abstract void parse(Segment segment, String string, EncodingCharacters encodingCharacters)
			throws HL7Exception;

	/**
	 * Parses a particular message and returns the encoded structure
	 *
     * @param message The message to encode
     * @param string The string to parse
	 * @throws HL7Exception If there is a problem encoding
	 * @since 1.0
	 */
	public abstract void parse(Message message, String string) throws HL7Exception;

	/**
	 * <p>
	 * Creates a version-specific MSH object and returns it as a
	 * version-independent MSH interface. 
	 * </p>
	 * <p>
	 * Since HAPI 2.1, if a version specific MSH
	 * segment can't be found (for example because the specific
	 * structure JAR is not found on the classpath), an instance of
	 * {@link GenericSegment} is returned.
	 * </p>
     *
     * @param version HL7 version
     * @param factory model class factory to be used
     * @return MSH segment for this version returned by the model class factory
     * @throws HL7Exception if no matching segment could be found
	 */
	public static Segment makeControlMSH(String version, ModelClassFactory factory)
			throws HL7Exception {
		Segment msh;

		try {
			Class<? extends Message> genericMessageClass;
			genericMessageClass = GenericMessage.getGenericMessageClass(version);
			
			Message dummy = genericMessageClass
					.getConstructor(new Class[] { ModelClassFactory.class })
					.newInstance(factory);

			Class<? extends Segment> c = null;
			
			if (Version.supportsVersion(version)) {
				c = factory.getSegmentClass("MSH", version);
			}
			
			if (c != null) {
				if (GenericSegment.class.isAssignableFrom(c)) {
					Class<?>[] constructorParamTypes = { Group.class, String.class };
					Object[] constructorParamArgs = { dummy, "MSH" };
					Constructor<? extends Segment> constructor = c.getConstructor(constructorParamTypes);
					msh = constructor.newInstance(constructorParamArgs);
				} else {
					Class<?>[] constructorParamTypes = { Group.class, ModelClassFactory.class };
					Object[] constructorParamArgs = { dummy, factory };
					Constructor<? extends Segment> constructor = c.getConstructor(constructorParamTypes);
					msh = constructor.newInstance(constructorParamArgs);
				}
			} else {
				msh = new GenericSegment(dummy, "MSH");    	
			}
		} catch (Exception e) {
			throw new HL7Exception("Couldn't create MSH for version " + version
					+ " (does your classpath include this version?) ... ", e);
		}
		return msh;
	}

	/**
	 * Returns true if the given string represents a valid 2.x version. Valid versions include
	 * "2.1", "2.2", "2.3", "2.3.1", "2.4", "2.5", "2.5.1", "2.6"
	 *
	 * @param version HL7 version string
	 * @return <code>true</code> if version is known
	 * @deprecated Use {@link Version#supportsVersion(String)}
	 */
	@Deprecated
	public static boolean validVersion(String version) {
		return Version.supportsVersion(version);
	}
	
	/**
	 * Like {@link #validVersion(String)} but throws an HL7Exception instead
	 * 
	 * @param version HL7 version
	 * @throws HL7Exception if version is unknown
	 */
	public static void assertVersionExists(String version) throws HL7Exception {
		if (!Version.supportsVersion(version))
            throw new HL7Exception(
                    "The HL7 version " + version + " is not recognized",
                    ErrorCode.UNSUPPORTED_VERSION_ID);
	}

	/**
	 * Given a concatenation of message type and event (e.g. ADT_A04), and the version, finds the
	 * corresponding message structure (e.g. ADT_A01). This is needed because some events share
	 * message structures, although it is not needed when the message structure is explicitly valued
	 * in MSH-9-3. If no mapping is found, returns the original name.
	 * 
	 * @throws HL7Exception if there is an error retrieving the map, or if the given version is
	 *             invalid
	 *             
	 * @deprecated use {@link ModelClassFactory#getMessageStructureForEvent(String, Version)}
	 */
	public String getMessageStructureForEvent(String name, String version)
			throws HL7Exception {
		assertVersionExists(version);
		return getHapiContext().getModelClassFactory().
				getMessageStructureForEvent(name, Version.versionOf(version));
	}

	/**
	 * Note that the validation context of the resulting message is set to this parser's validation
	 * context. The validation context is used within Primitive.setValue().
	 * 
	 * @param theName name of the desired structure in the form XXX_YYY
	 * @param theVersion HL7 version (e.g. "2.3")
	 * @param isExplicit true if the structure was specified explicitly in MSH-9-3, false if it was
	 *            inferred from MSH-9-1 and MSH-9-2. If false, a lookup may be performed to find an
	 *            alternate structure corresponding to that message type and event.
	 * @return a Message instance
	 * @throws HL7Exception if the version is not recognized or no appropriate class can be found or
	 *             the Message class throws an exception on instantiation (e.g. if args are not as
	 *             expected)
	 */
	protected Message instantiateMessage(String theName, String theVersion, boolean isExplicit)
			throws HL7Exception {
		Class<? extends Message> messageClass = getFactory().getMessageClass(theName, theVersion, isExplicit);
		if (messageClass == null)
			throw new HL7Exception("Can't find message class in current package list: " + theName);
		return ReflectionUtil.instantiateMessage(messageClass, getFactory());
	}
	
	protected void applySuperStructureName(Message theMessage) throws HL7Exception {
        if (theMessage instanceof AbstractSuperMessage) {
        	if (theMessage.getName() == null) {
        		Terser t = new Terser(theMessage);
        		String name = null;
				try {
					name = t.get("/MSH-9-3");
				} catch (HL7Exception e) {
					// ignore
				}
				
				if (StringUtil.isBlank(name)) {
					name = t.get("/MSH-9-1") + "_" + t.get("/MSH-9-2");
				}
				
				((AbstractSuperMessage)theMessage).setName(name);
        	}
        }

	}
	
	private <R> void assertMessageValidates(String message, String encoding, String version) throws HL7Exception {
	    if (isValidating()) {
	        Validator<R> validator = getHapiContext().getMessageValidator();
	        ValidationExceptionHandlerFactory<R> factory  = getHapiContext().getValidationExceptionHandlerFactory();
	        ValidationExceptionHandler<R> handler = factory.getNewInstance(getHapiContext());
	        R result = validator.validate(message, encoding.equals("XML"), version, handler);
            handleException(handler, result);
	    }
	}
	
    private <R> void assertMessageValidates(Message message) throws HL7Exception {
        if (isValidating()) {
            Validator<R> validator = getHapiContext().getMessageValidator();
            ValidationExceptionHandlerFactory<R> factory  = getHapiContext().getValidationExceptionHandlerFactory();
            if (factory == null) {
            	throw new NullPointerException("Validation is enabled for this parser, but ValidationExceptionHandlerFactory is null");
            }
            ValidationExceptionHandler<R> handler = factory.getNewInstance(getHapiContext());
            R result = validator.validate(message, handler);
            handleException(handler, result);
        }
    }

    private <R> void handleException(ValidationExceptionHandler<R> handler, R result)
            throws HL7Exception {
        if (handler.hasFailed()) {
            HL7Exception e = new HL7Exception("Validation has failed");
            e.setDetail(result);
            if (result instanceof Message) e.setResponseMessage((Message)result);
            throw e;
        }
    }
    
    private boolean isValidating() {
        return getHapiContext().getParserConfiguration().isValidating();
    }
    

}