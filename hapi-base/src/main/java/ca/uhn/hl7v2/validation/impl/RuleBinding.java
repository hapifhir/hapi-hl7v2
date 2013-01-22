/**
The contents of this file are subject to the Mozilla Public License Version 1.1 
(the "License"); you may not use this file except in compliance with the License. 
You may obtain a copy of the License at http://www.mozilla.org/MPL/ 
Software distributed under the License is distributed on an "AS IS" basis, 
WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the 
specific language governing rights and limitations under the License. 

The Original Code is "RuleBinding.java".  Description: 
"An association between a type of item to be validated (eg a datatype or message) and a validation Rule." 

The Initial Developer of the Original Code is University Health Network. Copyright (C) 
2004.  All Rights Reserved. 

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
package ca.uhn.hl7v2.validation.impl;

import java.io.Serializable;

import ca.uhn.hl7v2.validation.Rule;

/**
 * An association between a type of item to be validated (eg a datatype or
 * message) and a validation <code>Rule</code>.
 * 
 * @author Bryan Tripp
 * @author James Agnew
 * @author Christian Ohr
 * */
public class RuleBinding<T extends Rule<?>> implements Serializable {

	private static final long serialVersionUID = 1L;

	private boolean myActiveFlag;
	private String myVersion;
	private String myScope;
	private T myRule;

	/**
	 * Active by default.
	 * 
	 * @param theVersion
	 *            see {@link #getVersion()}
	 * @param theScope
	 *            see {@link #getScope()}
	 * @param theRule
	 *            see {@link #getRule()}
	 */
	public RuleBinding(String theVersion, String theScope, T theRule) {
		myActiveFlag = true;
		myVersion = theVersion;
		myScope = theScope;
		myRule = theRule;
	}

	/**
	 * @return true if the binding is currently active
	 */
	public boolean getActive() {
		return myActiveFlag;
	}

	/**
	 * @param isActive
	 *            true if the binding is currently active
	 */
	public void setActive(boolean isActive) {
		myActiveFlag = isActive;
	}

	/**
	 * @return the version to which the binding applies (* means all versions)
	 */
	public String getVersion() {
		return myVersion;
	}

	/**
	 * @return the scope of item types to which the rule applies. For
	 *         <code>MessageRule</code>s this is the message type and trigger
	 *         event, separated by a ^ (either value may be *, meaning any). For
	 *         <code>PrimitiveTypeRule</code>s this is the datatype name (*
	 *         means any). For <code>EncodingRule</code>s this is the encoding
	 *         name (again, * means any).
	 */
	public String getScope() {
		return myScope;
	}

	/**
	 * @return a <code>Rule</code> that applies to the associated version and
	 *         scope
	 */
	public T getRule() {
		return myRule;
	}

	/**
	 * @param theVersion
	 *            an HL7 version
	 * @return true if this binding applies to the given version (ie
	 *         getVersion() matches or is *)
	 */
	public boolean appliesToVersion(String theVersion) {
		return applies(getVersion(), theVersion);
	}

	/**
	 * @param theType
	 *            an item description to be checked against getScope()
	 * @return true if the given type is within scope, ie if it matches
	 *         getScope() or getScope() is *
	 */
	public boolean appliesToScope(String theType) {
		return applies(getScope(), theType);
	}

	/**
	 * An abstraction of appliesToVersion() and appliesToScope(). Compares two values
     * and returns true if they are equal or if the binding data is "*"
	 */
	protected static boolean applies(String theBindingData, String theItemData) {
		return (theBindingData.equals(theItemData) || theBindingData.equals("*"));
	}

	@Override
	public String toString() {
		return myRule.toString() + " for " + myScope + " in version " + myVersion;
	}
	
	
}
