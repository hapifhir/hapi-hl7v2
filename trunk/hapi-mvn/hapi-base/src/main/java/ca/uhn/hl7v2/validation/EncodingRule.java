/**
The contents of this file are subject to the Mozilla Public License Version 1.1 
(the "License"); you may not use this file except in compliance with the License. 
You may obtain a copy of the License at http://www.mozilla.org/MPL/ 
Software distributed under the License is distributed on an "AS IS" basis, 
WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the 
specific language governing rights and limitations under the License. 

The Original Code is "EncodingRule.java".  Description: 
"A validation rule that applies to encoded message strings.  " 

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

/**
 * A validation rule that applies to encoded message strings.  Rules that 
 * apply to message content are not included in this category (they are MessageRules
 * and are evaluated against parsed Message object).  EncodingRules are intended 
 * for criteria that are specific to the encoded form of a message, e.g. "no empty 
 * tags in an XML message".  
 * @author Bryan Tripp
 */
public interface EncodingRule extends Rule<String> {
    
    /**
     * Tests the given encoded message text against the criteria 
     * defined by this rule class.  
     * @return a list of exceptions indicating points at which the given 
     *      message failed to validate (empty if validation succeeds; may 
     *      not be a complete list as testing may be aborted after failure).  
     */
    public ValidationException[] test(String msg);
    
}
