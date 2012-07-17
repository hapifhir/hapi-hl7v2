/**
The contents of this file are subject to the Mozilla Public License Version 1.1 
(the "License"); you may not use this file except in compliance with the License. 
You may obtain a copy of the License at http://www.mozilla.org/MPL/ 
Software distributed under the License is distributed on an "AS IS" basis, 
WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the 
specific language governing rights and limitations under the License. 

The Original Code is "IDGenerator.java".  Description: 
"Interface providing methods for generating message IDs" 

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

/**
 * MessageID generator interface. This is a replacement for the legacy
 * MessageIDGenerator class, which should not be used anymore.
 * <p>
 * An instance implementing this interface can be configured by setting the
 * property in the {@link ca.uhn.hl7v2.parser.ParserConfiguration} class and
 * will then be used to generate IDs for all messages created by HAPI. The
 * default implementation is {@link FileBasedHiLoGenerator}.
 * <p>
 * HAPI does not provide ID generators that depend on external resources (except
 * for files). Implementors are encouraged to add their own classes
 * (implementing {@link IDGenerator.Ordered}, e.g. based on database tables
 * or sequences, and use it as delegate in {@link DelegatingHiLoGenerator}.
 * 
 * @see DelegatingHiLoGenerator
 * @see FileBasedHiLoGenerator
 * 
 * @author Christian Ohr
 */
public interface IDGenerator {

	/**
	 * Generates and returns a new ID. Note: This method must be implemented to
	 * be thread-safe.
	 * 
	 * @return a new ID.
	 * 
	 * @throws IOException
	 */
	String getID() throws IOException;

	/**
	 * Extension for continuous ID sequences
	 */
	public interface Ordered extends IDGenerator {

		void reset();
		int getIncrement();

	}

	/**
	 * Ordered ID sequences with a configurable increment
	 */
	public abstract class OrderedSupport implements Ordered {

		private int increment = 1;

		OrderedSupport(int increment) {
			super();
			this.increment = increment;
		}

		public OrderedSupport() {
			this(1);
		}

		public void reset() {
		}

		public int getIncrement() {
			return increment;
		}

	}

}
