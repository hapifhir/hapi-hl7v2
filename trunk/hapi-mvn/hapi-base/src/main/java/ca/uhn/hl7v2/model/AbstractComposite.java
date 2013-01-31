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
import ca.uhn.hl7v2.Location;


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

	@Override
	public boolean isEmpty() throws HL7Exception {
		for (Type type : getComponents()) {
			if (!type.isEmpty()) return false;
		}
		return super.isEmpty(); // for the ExtraComponents
	}

    public boolean accept(MessageVisitor visitor, Location location) throws HL7Exception {
        if (visitor.start(this, location)) {
            Type[] types = getComponents();
            for (int i = 0; i < types.length; i++) {
                Type t = getComponent(i);
                Location nextLocation = t.provideLocation(location, i+1, -1);
                if (!t.accept(visitor, nextLocation)) break;
            }
            ExtraComponents ec = getExtraComponents();
            for (int i = 0; i < ec.numComponents(); i++) {
               Varies v = ec.getComponent(i);
               Location nextLocation = v.provideLocation(location, i + types.length, -1);
               if (!v.accept(visitor, nextLocation)) break;
            }
        }
        return visitor.end(this, location);
    }
  
    
}
