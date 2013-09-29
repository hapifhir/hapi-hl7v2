/**
The contents of this file are subject to the Mozilla Public License Version 1.1 
(the "License"); you may not use this file except in compliance with the License. 
You may obtain a copy of the License at http://www.mozilla.org/MPL/ 
Software distributed under the License is distributed on an "AS IS" basis, 
WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the 
specific language governing rights and limitations under the License. 

The Original Code is "DelegatingHiLoGenerator.java".  Description: 
"Generator that delegates generation of hi IDs " 

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
 * Default implementation of a HiLo ID generator that allows to use another
 * (non-HiLo) ID generator for generating the "hi" part of the ID. The delegate
 * must increment its ID is discrete steps > 1, so that the gaps can be filled
 * with "lo" IDs.
 * <p>
 *     Example:
 * </p>
 * <pre>
 *     Hi IDs: 0, 100, 200, 300 (increment = 100)
 *     Lo IDs: 1,2,3,...,100,1,2,3,....
 *     Resulting ID (Hi + Lo): 1,2,3,99,100,101,102,...
 * </pre>
 * 
 * @see FileBasedHiLoGenerator
 * @author Christian Ohr
 */
public class DelegatingHiLoGenerator extends HiLoGenerator {

	private IDGenerator.Ordered delegate;

	public DelegatingHiLoGenerator() {
		super();
	}

	public DelegatingHiLoGenerator(IDGenerator.Ordered delegate) {
		super();
		this.delegate = delegate;
	}

	@Override
	protected int getNextHiId() throws IOException {
		if (delegate == null)
			throw new NullPointerException(
					"Must initialize delegate IDGenerator");
		return Integer.parseInt(delegate.getID());
	}

	public void setDelegate(IDGenerator.Ordered delegate) {
		this.delegate = delegate;
	}

	@Override
	protected void resetHiId() {
		delegate.reset();
	}

    /**
     * THe maximum "lo" ID is the increment of the hi ID.
     * @return
     */
	@Override
	public int getMaxLo() {
		return delegate.getIncrement();
	}

}
