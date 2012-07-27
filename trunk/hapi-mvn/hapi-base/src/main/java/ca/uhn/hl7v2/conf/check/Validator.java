/**
The contents of this file are subject to the Mozilla Public License Version 1.1 
(the "License"); you may not use this file except in compliance with the License. 
You may obtain a copy of the License at http://www.mozilla.org/MPL/ 
Software distributed under the License is distributed on an "AS IS" basis, 
WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the 
specific language governing rights and limitations under the License. 

The Original Code is "Validator.java".  Description: 
"Validates messages against message profiles." 

The Initial Developer of the Original Code is University Health Network. Copyright (C) 
2003.  All Rights Reserved. 

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

package ca.uhn.hl7v2.conf.check;

import ca.uhn.hl7v2.conf.spec.message.StaticDef;
import ca.uhn.hl7v2.model.Message ;
import ca.uhn.hl7v2.conf.ProfileException;
import ca.uhn.hl7v2.HL7Exception;

/**
 * Validates messages against message profiles. In general you use this by
 * formulating a ConformanceProfileRule and validating a message using this rule.
 *  
 * @author Bryan Tripp
 */
public interface Validator {
    
    /**
     * Validates the given message against the given static definition from 
     * a conformance profile.  Conformance profiles are XML representations of   
     * domain-specific constraints on a message (see HL7 2.5 section 2.12).  
     * @throws ProfileException if a problem is encountered that interferes with evaluation 
     * @return a list of exceptions representing points of non-conformance (may not be a complete list)
     */
    public HL7Exception[] validate(Message message, StaticDef profile) throws ProfileException, HL7Exception;
    
}
