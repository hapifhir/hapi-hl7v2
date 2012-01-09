/**
The contents of this file are subject to the Mozilla Public License Version 1.1 
(the "License"); you may not use this file except in compliance with the License. 
You may obtain a copy of the License at http://www.mozilla.org/MPL/ 
Software distributed under the License is distributed on an "AS IS" basis, 
WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the 
specific language governing rights and limitations under the License. 

The Original Code is "AbstractComposite.java".  Description: 
"A partial implementation of Composite" 

The Initial Developer of the Original Code is University Health Network. Copyright (C) 
2012.  All Rights Reserved. 

Contributor(s): ______________________________________. 

Alternatively, the contents of this file may be used under the terms of the 
GNU General Public License (the  "GPL"), in which case the provisions of the GPL are 
applicable instead of those above.  If you wish to allow use of your version of this 
file only under the terms of the GPL and not to allow others to use your version 
of this file under the MPL, indicate your decision by deleting  the provisions above 
and replace  them with the notice and other provisions required by the GPL License.  
If you do not delete the provisions above, a recipient may use your version of 
this file under either the MPL or the GPL. 
*/
package ca.uhn.hl7v2.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ca.uhn.hl7v2.HL7Exception;

/**
 * @author i000161
 *
 */
public abstract class AbstractComposite extends AbstractType implements
		Composite {

	private static final long serialVersionUID = -2657103285266475699L;
	
	protected Logger log;
	
	public AbstractComposite(Message message) {
		super(message);
		log = LoggerFactory.getLogger(getClass());
	}

	@Override
	public void clear() {
		super.clear();
		for (Type component : getComponents()) {
			component.clear();
		}
	}
	
	protected <T extends Type> T getTyped(int idx, Class<T> type) {
		try {
			@SuppressWarnings("unchecked") T ret = (T)getComponent(idx);
			return ret;
		} catch (HL7Exception e) {
	         log.error("Unexpected problem accessing known data type component - this is a bug.", e);
	         throw new RuntimeException(e);
		}
	}

}
