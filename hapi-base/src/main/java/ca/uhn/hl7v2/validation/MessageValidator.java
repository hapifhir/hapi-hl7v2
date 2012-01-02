/**
The contents of this file are subject to the Mozilla Public License Version 1.1 
(the "License"); you may not use this file except in compliance with the License. 
You may obtain a copy of the License at http://www.mozilla.org/MPL/ 
Software distributed under the License is distributed on an "AS IS" basis, 
WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the 
specific language governing rights and limitations under the License. 

The Original Code is "MessageValidator.java".  Description: 
"Validates parsed message against MessageRules that are enabled according to runtime 
 configuration information."
 
The Initial Developer of the Original Code is University Health Network. Copyright (C) 
2002.  All Rights Reserved. 

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

package ca.uhn.hl7v2.validation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.util.Terser;

/**
 * Validation utilities for parsed and encoded messages.  
 *  
 * @author Bryan Tripp
 */
public class MessageValidator {

    private static final MessageRule[] EMPTY_MESSAGE_RULES_ARRAY = new MessageRule[0];
    private static final EncodingRule[] EMPTY_ENCODING_RULES_ARRAY = new EncodingRule[0];
	private static final Logger ourLog = LoggerFactory.getLogger(MessageValidator.class);
    
    private ValidationContext myContext;
    private boolean failOnError;

    /**
     * @param theContext context that determines which validation rules apply 
     * @param theFailOnErrorFlag
     */
    public MessageValidator(ValidationContext theContext, boolean theFailOnErrorFlag) {
        myContext = theContext;
        failOnError = theFailOnErrorFlag;
    }
    
    /**
     * @param message a parsed message to validate (note that MSH-9-1 and MSH-9-2 must be valued)
     * @return true if the message is OK
     * @throws HL7Exception if there is at least one error and this validator is set to fail on errors
     */
    public boolean validate(Message message) throws HL7Exception {
    	if (message == null) {
    		throw new NullPointerException("Message may not be null");
    	}
    	
        Terser t = new Terser(message);
        
        MessageRule[] rules = EMPTY_MESSAGE_RULES_ARRAY;
        if (myContext != null) {
        	rules = myContext.getMessageRules(message.getVersion(), t.get("MSH-9-1"), t.get("MSH-9-2"));
        }
        
        ValidationException toThrow = null;
        boolean result = true;
        for (int i = 0; i < rules.length; i++) {
            ValidationException[] ex = rules[i].test(message);
            for (int j = 0; j < ex.length; j++) {
                result = false;
                ourLog.error("Invalid message", ex[j]);
                if (failOnError && toThrow == null) {
                    toThrow = ex[j];
                }
            }
        }
        
        if (toThrow != null) {
            throw new HL7Exception("Invalid message", toThrow);
        }
        
        return result;
    }
    
    /**
     * @param message an ER7 or XML encoded message to validate 
     * @param isXML true if XML, false if ER7
     * @param version HL7 version (e.g. "2.2") to which the message belongs
     * @return true if the message is OK
     * @throws HL7Exception if there is at least one error and this validator is set to fail on errors
     */
    public boolean validate(String message, boolean isXML, String version) throws HL7Exception {
        
    	EncodingRule[] rules = EMPTY_ENCODING_RULES_ARRAY;
        if (myContext != null) {
        	rules = myContext.getEncodingRules(version, isXML ? "XML" : "ER7");
        }
    	
        ValidationException toThrow = null;
        boolean result = true;
        for (int i = 0; i < rules.length; i++) {
            ValidationException[] ex = rules[i].test(message);
            for (int j = 0; j < ex.length; j++) {
                result = false;
                ourLog.error("Invalid message", ex[j]);
                if (failOnError && toThrow == null) {
                    toThrow = ex[j];
                }
            }
        }
        
        if (toThrow != null) {
            throw new HL7Exception("Invalid message", toThrow);
        }

        return result;
    }
}
