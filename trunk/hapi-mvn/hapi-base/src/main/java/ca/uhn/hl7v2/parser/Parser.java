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
GNU General Public License (the  "GPL"), in which case the provisions of the GPL are 
applicable instead of those above.  If you wish to allow use of your version of this 
file only under the terms of the GPL and not to allow others to use your version 
of this file under the MPL, indicate your decision by deleting  the provisions above 
and replace  them with the notice and other provisions required by the GPL License.  
If you do not delete the provisions above, a recipient may use your version of 
this file under either the MPL or the GPL. 

*/

package ca.uhn.hl7v2.parser;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.model.GenericMessage;
import ca.uhn.hl7v2.model.Group;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.Segment;
import ca.uhn.hl7v2.validation.MessageValidator;
import ca.uhn.hl7v2.validation.ValidationContext;
import ca.uhn.hl7v2.validation.ValidationException;
import ca.uhn.hl7v2.validation.impl.DefaultValidation;
import ca.uhn.hl7v2.validation.impl.ValidationContextFactory;
import ca.uhn.log.HapiLog;
import ca.uhn.log.HapiLogFactory;

/**
 * Parses HL7 message Strings into HL7 Message objects and 
 * encodes HL7 Message objects into HL7 message Strings.  
 * @author Bryan Tripp (bryan_tripp@sourceforge.net)
 */
public abstract class Parser {

    private static final HapiLog log = HapiLogFactory.getHapiLog(Parser.class);
    private static Map messageStructures = null;    
    private static final String[] versions = { "2.0", "2.0D", "2.1", "2.2", "2.3", "2.3.1", "2.4", "2.5", "2.5.1", "2.6" };
    
    private ModelClassFactory myFactory;
    private ValidationContext myContext;
    private MessageValidator myValidator;
    
    /**
     * Uses DefaultModelClassFactory for model class lookup. 
     */
    public Parser() {
        this(null);
    }
    
    /**
     * @param theFactory custom factory to use for model class lookup 
     */
    public Parser(ModelClassFactory theFactory) {
    	if (theFactory == null) {
    		theFactory = new DefaultModelClassFactory();
    	}
    	
        myFactory = theFactory;
        ValidationContext validationContext;
		try {
			validationContext = ValidationContextFactory.getContext();
		} catch (ValidationException e) {
			log.warn("Failed to get a validation context from the " + 
					"ValidationContextFactory", e);
			validationContext = new DefaultValidation();
		}
        setValidationContext(validationContext);
    }
    
    /**
     * @return the factory used by this Parser for model class lookup
     */
    public ModelClassFactory getFactory() {
        return myFactory;
    }
    
    /**
     * @return the set of validation rules that is applied to messages parsed or encoded by this parser. Note that this method may return <code>null</code>
     */
    public ValidationContext getValidationContext() {
        return myContext;
    }
    
    /**
     * @param theContext the set of validation rules to be applied to messages parsed or 
     *      encoded by this parser (defaults to ValidationContextFactory.DefaultValidation)
     */
    public void setValidationContext(ValidationContext theContext) {
        myContext = theContext;
        myValidator = new MessageValidator(theContext, true);
    }

    /**
     * Returns a String representing the encoding of the given message, if 
     * the encoding is recognized.  For example if the given message appears 
     * to be encoded using HL7 2.x XML rules then "XML" would be returned.  
     * If the encoding is not recognized then null is returned.  That this 
     * method returns a specific encoding does not guarantee that the 
     * message is correctly encoded (e.g. well formed XML) - just that  
     * it is not encoded using any other encoding than the one returned.  
     * Returns null if the encoding is not recognized.  
     */
    public abstract String getEncoding(String message);

    /** 
     * Returns true if and only if the given encoding is supported 
     * by this Parser.  
     */
    public abstract boolean supportsEncoding(String encoding);
    
    /**
     * @return the preferred encoding of this Parser
     */
    public abstract String getDefaultEncoding();

    /**
     * Parses a message string and returns the corresponding Message object.
     *   
     * @param message a String that contains an HL7 message 
     * @return a HAPI Message object parsed from the given String 
     * @throws HL7Exception if the message is not correctly formatted.  
     * @throws EncodingNotSupportedException if the message encoded 
     *      is not supported by this parser.   
     */
    public Message parse(String message) throws HL7Exception, EncodingNotSupportedException {
        String encoding = getEncoding(message);
        if (!supportsEncoding(encoding)) {
            throw new EncodingNotSupportedException(
                    "Can't parse message beginning " + message.substring(0, Math.min(message.length(), 50)));
        }
        
        String version = getVersion(message);
        if (!validVersion(version)) {
            throw new HL7Exception("Can't process message of version '" + version + "' - version not recognized",
                    HL7Exception.UNSUPPORTED_VERSION_ID);
        }
        
        myValidator.validate(message, encoding.equals("XML"), version);        
        Message result = doParse(message, version);
        myValidator.validate(result);
        
        return result;
    }
    
    /**
     * Called by parse() to perform implementation-specific parsing work.  
     * 
     * @param message a String that contains an HL7 message 
     * @param version the name of the HL7 version to which the message belongs (eg "2.5") 
     * @return a HAPI Message object parsed from the given String 
     * @throws HL7Exception if the message is not correctly formatted.  
     * @throws EncodingNotSupportedException if the message encoded 
     *      is not supported by this parser.   
     */
    protected abstract Message doParse(String message, String version) 
        throws HL7Exception, EncodingNotSupportedException;

    /** 
     * Formats a Message object into an HL7 message string using the given 
     * encoding. 
     * 
     * @param source a Message object from which to construct an encoded message string 
     * @param encoding the name of the HL7 encoding to use (eg "XML"; most implementations support only  
     *      one encoding) 
     * @return the encoded message 
     * @throws HL7Exception if the data fields in the message do not permit encoding 
     *      (e.g. required fields are null)
     * @throws EncodingNotSupportedException if the requested encoding is not 
     *      supported by this parser.  
     */
    public String encode(Message source, String encoding) throws HL7Exception, EncodingNotSupportedException {
        myValidator.validate(source);        
        String result = doEncode(source, encoding);
        myValidator.validate(result, encoding.equals("XML"), source.getVersion());
        
        return result;
    }

    /**
     * Called by encode(Message, String) to perform implementation-specific encoding work. 
     * 
     * @param source a Message object from which to construct an encoded message string 
     * @param encoding the name of the HL7 encoding to use (eg "XML"; most implementations support only 
     *      one encoding) 
     * @return the encoded message 
     * @throws HL7Exception if the data fields in the message do not permit encoding 
     *      (e.g. required fields are null)
     * @throws EncodingNotSupportedException if the requested encoding is not 
     *      supported by this parser.  
     */
    protected abstract String doEncode(Message source, String encoding) 
        throws HL7Exception, EncodingNotSupportedException;
    
    /** 
     * Formats a Message object into an HL7 message string using this parser's  
     * default encoding. 
     * 
     * @param source a Message object from which to construct an encoded message string 
     * @param encoding the name of the encoding to use (eg "XML"; most implementations support only one 
     *      encoding) 
     * @return the encoded message 
     * @throws HL7Exception if the data fields in the message do not permit encoding 
     *      (e.g. required fields are null)
     */
    public String encode(Message source) throws HL7Exception {
        String encoding = getDefaultEncoding();
        
        myValidator.validate(source);        
        String result = doEncode(source);
        myValidator.validate(result, encoding.equals("XML"), source.getVersion());
        
        return result;
    }

    /**
     * Called by encode(Message) to perform implementation-specific encoding work. 
     * 
     * @param source a Message object from which to construct an encoded message string 
     * @return the encoded message 
     * @throws HL7Exception if the data fields in the message do not permit encoding 
     *      (e.g. required fields are null)
     * @throws EncodingNotSupportedException if the requested encoding is not 
     *      supported by this parser.  
     */
    protected abstract String doEncode(Message source) throws HL7Exception;
    
    /**
     * <p>Returns a minimal amount of data from a message string, including only the 
     * data needed to send a response to the remote system.  This includes the 
     * following fields: 
     * <ul><li>field separator</li>
     * <li>encoding characters</li>
     * <li>processing ID</li>
     * <li>message control ID</li></ul>
     * This method is intended for use when there is an error parsing a message, 
     * (so the Message object is unavailable) but an error message must be sent 
     * back to the remote system including some of the information in the inbound
     * message.  This method parses only that required information, hopefully 
     * avoiding the condition that caused the original error.</p>  
     * @return an MSH segment 
     */
    public abstract Segment getCriticalResponseData(String message) throws HL7Exception;

    /**
     * For response messages, returns the value of MSA-2 (the message ID of the message 
     * sent by the sending system).  This value may be needed prior to main message parsing, 
     * so that (particularly in a multi-threaded scenario) the message can be routed to 
     * the thread that sent the request.  We need this information first so that any 
     * parse exceptions are thrown to the correct thread.  Implementers of Parsers should 
     * take care to make the implementation of this method very fast and robust.  
     * Returns null if MSA-2 can not be found (e.g. if the message is not a 
     * response message). 
     */
    public abstract String getAckID(String message);

    /**
     * Returns the version ID (MSH-12) from the given message, without fully parsing the message. 
     * The version is needed prior to parsing in order to determine the message class
     * into which the text of the message should be parsed. 
     * @throws HL7Exception if the version field can not be found. 
     */
    public abstract String getVersion(String message) throws HL7Exception;


    /**
     * Creates a version-specific MSH object and returns it as a version-independent 
     * MSH interface. 
     * throws HL7Exception if there is a problem, e.g. invalid version, code not available 
     *     for given version. 
     */
    public static Segment makeControlMSH(String version, ModelClassFactory factory) throws HL7Exception {
        Segment msh = null;
        String className = null;
        
        
        try {
            Message dummy = (Message) GenericMessage.getGenericMessageClass(version)
                .getConstructor(new Class[]{ModelClassFactory.class}).newInstance(new Object[]{factory});
            
            Class[] constructorParamTypes = { Group.class, ModelClassFactory.class };
            Object[] constructorParamArgs = { dummy, factory };
            Class c = factory.getSegmentClass("MSH", version);
            Constructor constructor = c.getConstructor(constructorParamTypes);
            msh = (Segment) constructor.newInstance(constructorParamArgs);
        }
        catch (Exception e) {
            throw new HL7Exception(
                "Couldn't create MSH for version " + version + " (does your classpath include this version?) ... ",
                HL7Exception.APPLICATION_INTERNAL_ERROR,
                e);
        }
        return msh;
    }

    /** 
     * Returns true if the given string represents a valid 2.x version.  Valid versions 
     * include "2.0", "2.0D", "2.1", "2.2", "2.3", "2.3.1", "2.4", "2.5", etc 
     */
    public static boolean validVersion(String version) {
        boolean versionOK = false;
        int c = 0;
        while (versionOK == false && c < versions.length) {
            if (versions[c++].equals(version))
                versionOK = true;
        }
        return versionOK;
    }
    
    
    /**
     * @return A list of strings containing the valid versions of HL7 supported by HAPI ("2.1", "2.2", etc)
     */
    public static List getValidVersions() {
        return Collections.unmodifiableList(Arrays.asList(versions));
    }
    
    
    
    /**
     * Given a concatenation of message type and event (e.g. ADT_A04), and the 
     * version, finds the corresponding message structure (e.g. ADT_A01).  This  
     * is needed because some events share message structures, although it is not needed
     * when the message structure is explicitly valued in MSH-9-3. 
     * If no mapping is found, returns the original name.
     * @throws HL7Exception if there is an error retrieving the map, or if the given 
     *      version is invalid  
     */
    public static String getMessageStructureForEvent(String name, String version) throws HL7Exception {
        String structure = null;
        
        if (!validVersion(version)) 
            throw new HL7Exception("The version " + version + " is unknown");
        
        Properties p = null; 
        try {
            p = (Properties) getMessageStructures().get(version);            
            
            if (p == null) 
                throw new HL7Exception("No map found for version " + version + ". Only the following are available: " + getMessageStructures().keySet());
            
        } catch (IOException ioe) {
            throw new HL7Exception(ioe);
        }
        
        structure = p.getProperty(name);
        
        if (structure == null) { 
            structure = name;
        }
        
        return structure;
    }
    
    /**
     * Returns event->structure maps.  
     */
    private synchronized static Map getMessageStructures() throws IOException {
        if (messageStructures == null) {
            messageStructures = loadMessageStructures();
        }
        return messageStructures;
    }
    
    private synchronized static Map loadMessageStructures() throws IOException {
        Map map = new HashMap();
        for (int i = 0; i < versions.length; i++) {
            String resource = "ca/uhn/hl7v2/parser/eventmap/" + versions[i] + ".properties";
            InputStream in = Parser.class.getClassLoader().getResourceAsStream(resource);
            
            Properties structures = null;
            if (in != null) {            
                structures = new Properties();
                structures.load(in);
            }
            
            map.put(versions[i], structures);
        }
        return map;
    }
    
    /**
     * Note that the validation context of the resulting message is set to this parser's validation 
     * context.  The validation context is used within Primitive.setValue().
     *   
     * @param name name of the desired structure in the form XXX_YYY
     * @param version HL7 version (e.g. "2.3")  
     * @param isExplicit true if the structure was specified explicitly in MSH-9-3, false if it 
     *      was inferred from MSH-9-1 and MSH-9-2.  If false, a lookup may be performed to find 
     *      an alternate structure corresponding to that message type and event.   
     * @return a Message instance 
     * @throws HL7Exception if the version is not recognized or no appropriate class can be found or the Message 
     *      class throws an exception on instantiation (e.g. if args are not as expected) 
     */
    protected Message instantiateMessage(String theName, String theVersion, boolean isExplicit) throws HL7Exception {
        Message result = null;
        
        try {
            Class messageClass = myFactory.getMessageClass(theName, theVersion, isExplicit);
            if (messageClass == null)
                throw new ClassNotFoundException("Can't find message class in current package list: " 
                    + theName);
            log.info("Instantiating msg of class " + messageClass.getName());
            Constructor constructor = messageClass.getConstructor(new Class[]{ModelClassFactory.class});
            result = (Message) constructor.newInstance(new Object[]{myFactory});
        } catch (Exception e) {            
            throw new HL7Exception("Couldn't create Message object of type " + theName,
                HL7Exception.UNSUPPORTED_MESSAGE_TYPE, e);
        }
        
        result.setValidationContext(myContext);
        
        return result;
    }
    
}