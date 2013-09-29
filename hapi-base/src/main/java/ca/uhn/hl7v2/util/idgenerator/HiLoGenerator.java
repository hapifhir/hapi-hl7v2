/**
The contents of this file are subject to the Mozilla Public License Version 1.1 
(the "License"); you may not use this file except in compliance with the License. 
You may obtain a copy of the License at http://www.mozilla.org/MPL/ 
Software distributed under the License is distributed on an "AS IS" basis, 
WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the 
specific language governing rights and limitations under the License. 

The Original Code is "HiLoGenerator.java".  Description: 
"Abstract base class for HiLo ID Generators" 

The Initial Developer of the Original Code is University Health Network. Copyright (C) 
2001.  All Rights Reserved. 

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
package ca.uhn.hl7v2.util.idgenerator;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Abstract base class for a HiLo-style generator that cheaply generates "lo"
 * IDs in memory but only seldomly increments (potentially more expensive) a
 * "hi" ID, e.g. in a persistent store. The combination of "lo" and "hi" ID
 * becomes the final ID returned to the caller.
 * 
 * @author Christian Ohr
 */
public abstract class HiLoGenerator extends IDGenerator.OrderedSupport {

	private static final Logger LOG = LoggerFactory
			.getLogger(HiLoGenerator.class.getName());

	private int lo = 0;
	private int base = -1;

	public synchronized String getID() throws IOException {
		if (base < 0) {
			LOG.debug("Obtain next hi ID");
			base = nextBase();
		}
		if (getNextLoId() >= getMaxLo()) {
			LOG.debug("Obtain next hi ID");
			base = nextBase();
		}
		return Integer.toString(base + lo);
	}

	private int nextBase() throws IOException {
		int base = getNextHiId();
		lo = 0;
		return base;
	}

    /**
     * Returns the next Hi ID
     * @return the next Hi ID
     * @throws IOException
     */
	protected abstract int getNextHiId() throws IOException;

    /**
     * Resets the Hi ID
     */
	protected abstract void resetHiId();

    /**
     * Returns then next Lo ID
     * @return
     */
	protected int getNextLoId() {
		return ++lo;
	}

    /**
     * Resets the generator
     */
	public void reset() {
		lo = 0;
		base = -1;
		resetHiId();
	}

    /**
     * Returns the maximum Lo ID (expect the Hi ID be incremented afterwards)
     * @return the maximum Lo ID
     */
	abstract public int getMaxLo();

}
