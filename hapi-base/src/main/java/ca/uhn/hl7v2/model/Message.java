/**
The contents of this file are subject to the Mozilla Public License Version 1.1 
(the "License"); you may not use this file except in compliance with the License. 
You may obtain a copy of the License at http://www.mozilla.org/MPL/ 
Software distributed under the License is distributed on an "AS IS" basis, 
WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the 
specific language governing rights and limitations under the License. 

The Original Code is "Message.java".  Description: 
"Represents a complete HL7 message including all structures, segments, and fields" 

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

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.parser.Parser;
import ca.uhn.hl7v2.parser.PipeParser;
import ca.uhn.hl7v2.validation.ValidationContext;
import java.io.IOException;


/**
 * <p>
 * Represents a complete HL7 message including all structures, segments, and fields.  
 * </p><p>
 * Note this it is not recommended to implement this interface directly, as it is
 * subject to change. Instead, extend abstract implementations for your
 * model classes, such as {@link AbstractMessage} and {@link AbstractGroup}
 * </p>
 * 
 * @author Bryan Tripp (bryan_tripp@sourceforge.net)
 */
public interface Message extends Group {

    /**
     * Returns the version number of the HL7 version in which this 
     * message structure is defined (e.g. "2.4")
     */
    public abstract String getVersion();
    
    /**
     * @return the set of validation rules that applies to this message
     */
    public abstract ValidationContext getValidationContext();

    /**
     * @param theContext the set of validation rules that are to apply to this message
     */
    public void setValidationContext(ValidationContext theContext);


    /**
     * Convenience method which retrieves the field separator value from the first field of the first segment.
     *
     * Typically, the first segment is MSH, so this method will retrieve the
     * value of MSH-1.
     *
     * @return The field separator
     * @throws HL7Exception If an error occurs
     * @since 1.0
     */
    public Character getFieldSeparatorValue() throws HL7Exception;


    /**
     * Convenience method which retrieves the encoding characters value from the second field of the first segment.
     *
     * Typically, the first segment is MSH, so this method will retrieve the
     * value of MSH-2.
     *
     * @return The encoding characters
     * @throws HL7Exception If an error occurs
     * @since 1.0
     */
    public String getEncodingCharactersValue() throws HL7Exception;


    /**
     * Sets the parser to be used when parse/encode methods are called on this
     * Message, as well as its children. It is recommended that if these methods
     * are going to be called, a parser be supplied with the validation context
     * wanted. Where possible, the parser should be reused for best performance,
     * unless thread safety is an issue.
     *
     * Note that not all parsers can be used. As of version 1.0, only {@link PipeParser}
     * supports this functionality
     */
    public void setParser(Parser parser);

    
    /**
     * Returns the parser to be used when parse/encode methods are called on this
     * Message, as well as its children. The default value is a new {@link PipeParser}
     */
    public Parser getParser();

    
    /**
     * Parses the string into this message using the parser returned by {@link #getParser() }
     */
    public void parse(String string) throws HL7Exception;


    /**
     * Encodes this message using the parser returned by {@link #getParser() }
     */
    public String encode() throws HL7Exception;


    /**
     * <p>
     * Generates and returns an ACK message which would be used to
     * acknowledge this message successfully, with an MSA-1 code of "AA".
     * The ACK generated will be of the same version as the value of MSH-12 in this message (as opposed
     * to the version of the message class instance, if they are different)
     * </p>
     *
     * <p>
     * Note that this method will fail if it is not possible to
     * generate an ACK for any reason, such as
     * <ul>
     * <li>Message version is invalid</li>
     * <li>First segment is not an MSH</li>
     * </p>
     *
     * @throws HL7Exception If the message can not be constructed
     * @throws IOException If a failure occurs in generating a control ID for the message
     */
    public Message generateACK() throws HL7Exception, IOException;


    /**
     * <p>
     * Generates and returns an ACK message which would be used to
     * acknowledge this message successfully. The ACK generated will be
     * of the same version as the value of MSH-12 in this message (as opposed
     * to the version of the message class instance, if they are different)
     * </p>
     *
     * <p>
     * Note that this method will fail if it is not possible to
     * generate an ACK for any reason, such as
     * <ul>
     * <li>Message version is invalid</li>
     * <li>First segment is not an MSH</li>
     * </p>
     *
     * @param theAcknowldegementCode The acknowledement code (MSA-1) to supply. If null, defaults to "AA". To generate a typical NAK, use "AE"
     * @param theException The exceptions used to populate the ERR segment (if any)
     * @throws HL7Exception If the message can not be constructed
     * @throws IOException If a failure occurs in generating a control ID for the message
     */
    public Message generateACK(String theAcknowldegementCode, HL7Exception theException) throws HL7Exception, IOException;

    /**
     * <p>
     * Prints a summary of the contents and structure of this message. This is useful for
     * debugging purposes, if you want to figure out where in the structure of a message
     * a given segment has been placed.
     * </p>
     * <p>
     * For instance, the following message (containing a few quirks for demonstration purposes):
     * <code>
     * <pre>MSH|^~\\&|^QueryServices||||20021011161756.297-0500||ADT^A01|1|D|2.4\r
     * EVN|R01
     * EVN|R02
     * PID|1
     * IN1|1
     * IN1|2
     * PID|2</pre></code>
     * ...produces the following output:
     * <code>
     * <pre>ADT_A01 (start)
     *    MSH - MSH|^~\&|^QueryServices||||20021011161756.297-0500||ADT^A01|1|D|2.4
     *    EVN - EVN|R01
     *    [ { EVN2 } ] (non-standard) - EVN|R02
     *    PID - PID|1
     *    [ PD1 ] - Not populated
     *    [ { ROL } ] - Not populated
     *    [ { NK1 } ] - Not populated
     *    PV1 - Not populated
     *    [ PV2 ] - Not populated
     *    [ { ROL2 } ] - Not populated
     *    [ { DB1 } ] - Not populated
     *    [ { OBX } ] - Not populated
     *    [ { AL1 } ] - Not populated
     *    [ { DG1 } ] - Not populated
     *    [ DRG ] - Not populated
     *    PROCEDURE (start)
     *    [{
     *       PR1 - Not populated
     *       [ { ROL } ] - Not populated
     *    }]
     *    PROCEDURE (end)
     *    [ { GT1 } ] - Not populated
     *    INSURANCE (start)
     *    [{
     *       IN1 - IN1|1
     *       [ IN2 ] - Not populated
     *       [ { IN3 } ] - Not populated
     *       [ { ROL } ] - Not populated
     *    }]
     *    [{
     *       IN1 - IN1|2
     *       [ { PID } ] (non-standard) - PID|2
     *       [ IN2 ] - Not populated
     *       [ { IN3 } ] - Not populated
     *       [ { ROL } ] - Not populated
     *    }]
     *    INSURANCE (end)
     *    [ ACC ] - Not populated
     *    [ UB1 ] - Not populated
     *    [ UB2 ] - Not populated
     *    [ PDA ] - Not populated
     * ADT_A01 (end)
     * </pre></code>
     * </p>
     * 
     * @return A summary of the structure
     * @throws HL7Exception If any problems occur encoding the structure
     */
    public String printStructure() throws HL7Exception;
    
} 