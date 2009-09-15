/**
The contents of this file are subject to the Mozilla Public License Version 1.1 
(the "License"); you may not use this file except in compliance with the License. 
You may obtain a copy of the License at http://www.mozilla.org/MPL/ 
Software distributed under the License is distributed on an "AS IS" basis, 
WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the 
specific language governing rights and limitations under the License. 

The Original Code is "DBTableRepository.java".  Description: 
"Implements TableRepository by looking up values from the default HL7
  normative database" 

The Initial Developer of the Original Code is University Health Network. Copyright (C) 
2001.  All Rights Reserved. 

Contributor(s): ______________________________________. 

Alternatively, the contents of this file may be used under the terms of the 
GNU General Public License (the  “GPL”), in which case the provisions of the GPL are 
applicable instead of those above.  If you wish to allow use of your version of this 
file only under the terms of the GPL and not to allow others to use your version 
of this file under the MPL, indicate your decision by deleting  the provisions above 
and replace  them with the notice and other provisions required by the GPL License.  
If you do not delete the provisions above, a recipient may use your version of 
this file under either the MPL or the GPL. 
*/
package ca.uhn.hl7v2.parser.mock.tests;

import java.io.InputStream;

/**
 * Mock class loader, it only implements the <code> getResourceAsStream </code> method. 
 * 
 * @author <a href="mailto:alexei.guevara@uhn.on.ca">Alexei Guevara</a>
 * @version $Revision: 1.2 $ updated on $Date: 2009-09-15 12:11:20 $ by $Author: jamesagnew $
 */
public class MockClassLoader extends ClassLoader {
	
	private final InputStream myResourceInputStream;
	private String myResourceName;

	/**
	 * The <code> getResourceAsStream </code> method will return <code> theResourceInputStream </code> 
	 * only of the specified resource name (when the method is invoked) matches <code> theResourceName </code>.
	 *    	 
	 * @param theResourceName
	 * @param theResourceInputStream
	 */
	public MockClassLoader( String theResourceName, InputStream theResourceInputStream ) {
		super();
		myResourceName = theResourceName;
		myResourceInputStream = theResourceInputStream;
	}

	/* (non-Javadoc)
	 * @see java.lang.ClassLoader#getResourceAsStream(java.lang.String)
	 */
	public InputStream getResourceAsStream( String theResourceName ) {
		InputStream retVal = null;
		
		if (myResourceName.equalsIgnoreCase( theResourceName )) {
			retVal = myResourceInputStream;
		}
		
		return retVal;
	}
}
