/**
The contents of this file are subject to the Mozilla Public License Version 1.1 
(the "License"); you may not use this file except in compliance with the License. 
You may obtain a copy of the License at http://www.mozilla.org/MPL/ 
Software distributed under the License is distributed on an "AS IS" basis, 
WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the 
specific language governing rights and limitations under the License. 

The Original Code is "MessageRule.java".  Description: 
"A rule that applies to a fully populated message object. " 

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

import ca.uhn.hl7v2.model.Message;

/**
 * A validation rule that applies to a fully populated message object.  Message rules 
 * may be called (depending on runtime configuration) just after an inbound message
 * is parsed, or just before an outbound message is encoded.  
 * @author Bryan Tripp 
 */
public interface MessageRule extends Rule<Message> {
    
    /**
     * Tests the given (fully populated) message against the criteria 
     * defined by this rule class.
     * @param msg message to be tested
     * @return a list of exceptions indicating points at which the given 
     *      message failed to validate (empty if validation succeeds; may 
     *      not be a complete list as testing may be aborted after failure).  
     *      The list should be empty if this rule is evaluated against a type 
     *      of message to which it doesn't apply.  
     */
    public ValidationException[] test(Message msg);
    
}
