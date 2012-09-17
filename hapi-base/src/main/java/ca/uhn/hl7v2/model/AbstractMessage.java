/**
The contents of this file are subject to the Mozilla Public License Version 1.1 
(the "License"); you may not use this file except in compliance with the License. 
You may obtain a copy of the License at http://www.mozilla.org/MPL/ 
Software distributed under the License is distributed on an "AS IS" basis, 
WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the 
specific language governing rights and limitations under the License. 

The Original Code is "AbstractMessage.java".  Description: 
"A default implementation of Message" 

The Initial Developer of the Original Code is University Health Network. Copyright (C) 
2001.  All Rights Reserved. 

Contributor(s): ______________________________________. 

Alternatively, the contents of this file may be used under the terms of the 
GNU General Public License (the  �GPL�), in which case the provisions of the GPL are 
applicable instead of those above.  If you wish to allow use of your version of this 
file only under the terms of the GPL and not to allow others to use your version 
of this file under the MPL, indicate your decision by deleting  the provisions above 
and replace  them with the notice and other provisions required by the GPL License.  
If you do not delete the provisions above, a recipient may use your version of 
this file under either the MPL or the GPL. 

*/

package ca.uhn.hl7v2.model;

import java.io.IOException;
import java.util.GregorianCalendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.Version;
import ca.uhn.hl7v2.app.DefaultApplication;
import ca.uhn.hl7v2.model.primitive.CommonTS;
import ca.uhn.hl7v2.model.primitive.ID;
import ca.uhn.hl7v2.parser.ModelClassFactory;
import ca.uhn.hl7v2.parser.Parser;
import ca.uhn.hl7v2.parser.PipeParser;
import ca.uhn.hl7v2.util.Terser;
import ca.uhn.hl7v2.util.idgenerator.IDGenerator;
import ca.uhn.hl7v2.validation.ValidationContext;

/**
 * A default implementation of Message. 
 * @author Bryan Tripp (bryan_tripp@sourceforge.net)
 */
@SuppressWarnings("serial")
public abstract class AbstractMessage extends AbstractGroup implements Message {
    
    private ValidationContext myContext;
	private static final Pattern ourVersionPattern = Pattern.compile("\\.(v2[0-9][0-9]?)\\.");
	private String myVersion;
    private transient Parser myParser;
	
    /**
     * @param theFactory factory for model classes (e.g. group, segment) for this message 
     */
    public AbstractMessage(ModelClassFactory theFactory) {
        super(null, theFactory);
    }
    
    /** 
     * Returns this Message object.  
     */
    public Message getMessage() {
       return this; 
    }
    
	public Group getParent() {
		return this;
	}

	/**
     * Returns the version number.  This default implementation inspects 
     * this.getClass().getName().  This should be overridden if you are putting
     * a custom message definition in your own package, or it will default.  
     * @see Message#getVersion()
     * 
     * @returns lowest available version if not obvious from package name
     */
    public String getVersion() {
    	if (myVersion != null) {
    		return myVersion;
    	}
    	
        String version = null;
        Pattern p = ourVersionPattern;
        Matcher m = p.matcher(this.getClass().getName());
        if (m.find()) {
            String verFolder = m.group(1);
            if (verFolder.length() > 0) {
                char[] chars = verFolder.toCharArray();
                StringBuffer buf = new StringBuffer();
                for (int i = 1; i < chars.length; i++) { //start at 1 to avoid the 'v'
                    buf.append(chars[i]);
                    if (i < chars.length - 1) buf.append('.');
                }
                version = buf.toString();
            }
        }
        
        if (version == null) 
            version = Version.lowestAvailableVersion().getVersion();
        
        myVersion = version;
        return version;
    }
    
    /**
     * @return the set of validation rules that applies to this message
     */
    public ValidationContext getValidationContext() {
        return myContext;
    }
    
    /**
     * @param theContext the set of validation rules that are to apply to this message
     */
    public void setValidationContext(ValidationContext theContext) {
        myContext = theContext;
    }

    /**
     * {@inheritDoc }
     */
    public Character getFieldSeparatorValue() throws HL7Exception {
        Segment firstSegment = (Segment) get(getNames()[0]);
        Primitive value = (Primitive) firstSegment.getField(1, 0);
        String valueString = value.getValue();
        if (valueString == null || valueString.length() == 0) {
            return null;
        }
        return valueString.charAt(0);
    }


    /**
     * {@inheritDoc }
     */
    public String getEncodingCharactersValue() throws HL7Exception {
        Segment firstSegment = (Segment) get(getNames()[0]);
        Primitive value = (Primitive) firstSegment.getField(2, 0);
        return value.getValue();
    }


    /**
     * <p>Sets the parser to be used when parse/encode methods are called on this
     * Message, as well as its children. It is recommended that if these methods
     * are going to be called, a parser be supplied with the validation context
     * wanted. Where possible, the parser should be reused for best performance,
     * unless thread safety is an issue.</p>
     *
     * <p>Note that not all parsers can be used. As of version 1.0, only {@link PipeParser}
     * supports this functionality</p>
     * 
     * <p>Serialization note: The message parser is marked as transient, so it will not
     * survive serialization.</p>
     */
    public void setParser(Parser parser) {
        if (parser == null) {
            throw new NullPointerException("Value may not be null");
        }

        myParser = parser;
    }


    /**
     * <p>Returns the parser to be used when parse/encode methods are called on this
     * Message, as well as its children. The default value is a new {@link PipeParser}.</p>
     * 
     * <p>Serialization note: The message parser is marked as transient, so it will not
     * survive serialization.</p>
     */
    public Parser getParser() {
        if (myParser == null) {
            myParser = new PipeParser();
        }

        return myParser;
    }


    /**
     * {@inheritDoc }
     */
    public void parse(String string) throws HL7Exception {
        clear();
		getParser().parse(this, string);
    }

    
    /**
     * {@inheritDoc }
     */
    public String encode() throws HL7Exception {
        return getParser().encode(this);
    }

    
    /**
     * {@inheritDoc }
     */
    public Message generateACK() throws HL7Exception, IOException {
        return generateACK(null, null);
    }


    /**
     * {@inheritDoc }
     */
    public Message generateACK(String theAcknowledgementCode, HL7Exception theException) throws HL7Exception, IOException {
        Message retVal = DefaultApplication.makeACK(this);
        retVal.setParser(getParser());
        
        if (theAcknowledgementCode == null) {
            theAcknowledgementCode = "AA";
        }

        Segment msa = (Segment)retVal.get("MSA");
        ID ackCode = (ID) msa.getField(1, 0);
        ackCode.setValue(theAcknowledgementCode);

        if (theException != null) {
            Segment err = (Segment) retVal.get("ERR");
            theException.populate(err, null);
        }

        return retVal;
    }

    /**
     * Provides an overview of the type and structure of this message
     */
    @Override
    public String toString() {
        try {
            return encode();
        } catch (HL7Exception e) {
            return (getClass().getName() + " - Failed to create toString(): " + e.getMessage());
        }
    }

    /**
     * {@inheritDoc}
     */
    public String printStructure() throws HL7Exception {
        StringBuilder builder = new StringBuilder();    
        appendStructureDescription(builder, 0, false, false, true, true);
        return builder.toString();
    }
    
    /**
     * Quickly initializes this message with common values in the first (MSH) segment.
     * 
     * <p>
     * Settings include:
     * 	<ul>
     * 		<li>MSH-1 (Field Separator) is set to "|"</li>
     * 		<li>MSH-2 (Encoding Characters) is set to "^~\&"</li>
     * 		<li>MSH-7 (Date/Time of Message) is set to current time</li>
     * 		<li>MSH-10 (Control ID) is populated using next value generated by a {@link IDGenerator}</li>
     * 	</ul>
     * </p>
     * 
     * @param messageCode The message code (aka message type) to insert into MSH-9-1. Example: "ADT"
     * @param messageTriggerEvent The message trigger event to insert into MSG-9-2. Example: "A01"
     * @param processingId The message processing ID to insert into MSH-11. Examples: "T" (for TEST) or "P" for (PRODUCTION)
     * 
     * @throws IOException If the message ID generation fails for some reason 
     * @throws HL7Exception If the message rejects any of the values which are generated to setting
     */
    public void initQuickstart(String messageCode, String messageTriggerEvent, String processingId) throws HL7Exception, IOException {
    	Segment msh = (Segment) get("MSH");
    	Terser.set(msh, 1, 0, 1, 1, "|");
        Terser.set(msh, 2, 0, 1, 1, "^~\\&");
        GregorianCalendar now = new GregorianCalendar();
        Terser.set(msh, 7, 0, 1, 1, CommonTS.toHl7TSFormat(now));
        Terser.set(msh, 9, 0, 1, 1, messageCode);
        Terser.set(msh, 9, 0, 2, 1, messageTriggerEvent);
        Terser.set(msh, 10, 0, 1, 1, getParser().getParserConfiguration().getIdGenerator().getID());
        Terser.set(msh, 11, 0, 1, 1, processingId);
        Terser.set(msh, 12, 0, 1, 1, getVersion());
        
        // Add structure information if version is 2.4 or better
        if (!Version.V24.isGreaterThan(Version.versionOf(getVersion()))) {
        	String className = getClass().getName();
        	int lastIndexOf = className.lastIndexOf('.');
			className = className.substring(lastIndexOf + 1);
			if (className.matches("[A-Z]{3}_[A-Z0-9]{3}")) {
		        Terser.set(msh, 9, 0, 3, 1, className);
        	}
        }
        
    }
    
}
