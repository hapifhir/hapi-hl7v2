/**
The contents of this file are subject to the Mozilla Public License Version 1.1 
(the "License"); you may not use this file except in compliance with the License. 
You may obtain a copy of the License at http://www.mozilla.org/MPL/ 
Software distributed under the License is distributed on an "AS IS" basis, 
WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the 
specific language governing rights and limitations under the License. 

The Original Code is "Expression.java".  Description: 
"Expressions used for validation rules" 

The Initial Developer of the Original Code is University Health Network. Copyright (C) 
2012.  All Rights Reserved. 

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
package ca.uhn.hl7v2.validation.builder;


import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.Location;
import ca.uhn.hl7v2.model.Structure;

/**
 * Expression used to obtain values from a message structure
 *
 * @param <T>
 */
public interface Expression<T extends Structure> {

	/**
	 * Applies this expression on the structure
	 * 
	 * @param structure
	 * @return the result value
	 * @throws HL7Exception
	 */
	Object evaluate(T structure) throws HL7Exception;

	/**
	 * Returns the expression description used for describing the Rule this expression
	 * is used in.
	 * 
	 * @return description 
	 */
	String getDescription();

	/**
	 * Returns the location of the structure to which is expression is applied to
	 * 
	 * @param structure
	 * @return the location of the structure
	 * @throws HL7Exception if the structure refers to an invalid location
	 */
	Location getLocation(T structure) throws HL7Exception;
}
