/**
The contents of this file are subject to the Mozilla Public License Version 1.1 
(the "License"); you may not use this file except in compliance with the License. 
You may obtain a copy of the License at http://www.mozilla.org/MPL/ 
Software distributed under the License is distributed on an "AS IS" basis, 
WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the 
specific language governing rights and limitations under the License. 

The Original Code is "MessageRuleBinding.java".  Description: 
"A RuleBinding that applies to MessageRules." 

The Initial Developer of the Original Code is University Health Network. Copyright (C) 
2004.  All Rights Reserved. 

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
package ca.uhn.hl7v2.validation.impl;

import java.util.StringTokenizer;

import ca.uhn.hl7v2.validation.MessageRule;

/**
 * A <code>RuleBinding</code> that applies to <code>MessageRule</code>s. 
 * <p>
 * In general there is no need to use this class directly. Instead use the
 * Validation builder classes to generate rules and rule bindings.
 *  
 * @author Bryan Tripp
 */
@SuppressWarnings("serial")
public class MessageRuleBinding extends RuleBinding<MessageRule> {

    private String myMessageType;
    private String myTriggerEvent;
    private static final String delim = "^"; 
    
    /**
     * @param theVersion see {@link RuleBinding#getVersion()}
     * @param theMessageType a value valid for MSH-9-1 or * for all
     * @param theTriggerEvent a value valid for MSH-9-2 or * for all
     * @param theRule rule to be used for binding
     */
    public MessageRuleBinding(String theVersion, String theMessageType, String theTriggerEvent, MessageRule theRule) {
        super(theVersion, theMessageType + "^" + theTriggerEvent, theRule);
        myMessageType = theMessageType;
        myTriggerEvent = theTriggerEvent;
    }
    
    /**
     * @param theScope must be in the form type^event (ie message type and trigger event separated
     *      by a carat)
     */
    public boolean appliesToScope(String theScope) {
        
        if (!theScope.matches(".*\\^.*")) {
            throw new IllegalArgumentException("arg theScope must be of the form type^event");
        }
        
        StringTokenizer tok = new StringTokenizer(theScope, delim, false);
        String itemType = tok.nextToken();
        String itemEvent = tok.nextToken();
        
        return applies(myMessageType, itemType) && applies(myTriggerEvent, itemEvent);
    }

}
