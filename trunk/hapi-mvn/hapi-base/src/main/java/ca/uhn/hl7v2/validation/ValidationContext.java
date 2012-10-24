/**
The contents of this file are subject to the Mozilla Public License Version 1.1 
(the "License"); you may not use this file except in compliance with the License. 
You may obtain a copy of the License at http://www.mozilla.org/MPL/ 
Software distributed under the License is distributed on an "AS IS" basis, 
WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the 
specific language governing rights and limitations under the License. 

The Original Code is "ValidationContext.java".  Description: 
"A set of rules for message validation" 

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
package ca.uhn.hl7v2.validation;

import java.util.Collection;

import ca.uhn.hl7v2.model.Primitive;

/**
 * A set of rules for message validation.  
 * 
 * @author <a href="mailto:bryan.tripp@uhn.on.ca">Bryan Tripp</a>
 * @version $Revision: 1.1 $ updated on $Date: 2007-02-19 02:24:41 $ by $Author: jamesagnew $
 */
public interface ValidationContext {

    /**
     * @param theVersion an HL7 version (eg "2.1")
     * @param theTypeName a primitive datatype name (eg "ST")
     * @param theType the Primitive being validated 
     * @return active rules for checking the given type in the given version 
     */
    public Collection<PrimitiveTypeRule> getPrimitiveRules(String theVersion, String theTypeName, Primitive theType);

    /**
     * @param theVersion an HL7 version (eg "2.1")
     * @param theMessageType a value valid for MSH-9-1
     * @param theTriggerEvent a value valid fro MSH-9-2
     * @return the active rules that apply to message of the given version, message type, 
     *      and trigger event 
     */    
    public Collection<MessageRule> getMessageRules(String theVersion, String theMessageType, String theTriggerEvent);
    
    /**
     * @param theVersion an HL7 version (eg "2.1")
     * @param theEncoding an encoding name (eg "VB", "XML)
     * @return the active encoding rules that apply to the given version and encoding
     */
    public Collection<EncodingRule> getEncodingRules(String theVersion, String theEncoding);
    
}
