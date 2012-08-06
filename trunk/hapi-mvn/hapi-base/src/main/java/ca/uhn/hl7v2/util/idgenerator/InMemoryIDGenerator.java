/**
The contents of this file are subject to the Mozilla Public License Version 1.1 
(the "License"); you may not use this file except in compliance with the License. 
You may obtain a copy of the License at http://www.mozilla.org/MPL/ 
Software distributed under the License is distributed on an "AS IS" basis, 
WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the 
specific language governing rights and limitations under the License. 

The Original Code is "InMemoryIDGenerator.java".  Description: 
"Simple generator that uses AtomicLong as ID source" 

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
import java.util.concurrent.atomic.AtomicLong;

/**
 * In-memory variant of an message ID generator. Particularly useful for tests
 * and deployments when duplicate IDs after a restart do no matter.
 * <p>
 * 
 * @author Christian Ohr
 */
public class InMemoryIDGenerator extends IDGenerator.OrderedSupport {

	private AtomicLong al = new AtomicLong(0l);

	public InMemoryIDGenerator() {
		super();
	}

	InMemoryIDGenerator(int increment) {
		super(increment);
	}

	public String getID() throws IOException {
		return Long.toString(al.getAndAdd(getIncrement()));
	}

	public synchronized void reset() {
		set(0l);
	}
	
	protected void set(long l) {
		al.set(l);
	}

}