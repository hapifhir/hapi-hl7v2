/**
The contents of this file are subject to the Mozilla Public License Version 1.1 
(the "License"); you may not use this file except in compliance with the License. 
You may obtain a copy of the License at http://www.mozilla.org/MPL/ 
Software distributed under the License is distributed on an "AS IS" basis, 
WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the 
specific language governing rights and limitations under the License. 

The Initial Developer of the Original Code is University Health Network. Copyright (C) 
2001.  All Rights Reserved. 

Contributor(s): Jens Kristian Villadsen from Cetrea A/S

Alternatively, the contents of this file may be used under the terms of the 
GNU General Public License (the  "GPL"), in which case the provisions of the GPL are 
applicable instead of those above.  If you wish to allow use of your version of this 
file only under the terms of the GPL and not to allow others to use your version 
of this file under the MPL, indicate your decision by deleting  the provisions above 
and replace  them with the notice and other provisions required by the GPL License.  
If you do not delete the provisions above, a recipient may use your version of 
this file under either the MPL or the GPL. 

 */

package ca.uhn.hl7v2.llp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * <p>
 * Minimal Lower Layer Protocol implementation which is detects the text
 * character set being used by reading in the MSH-18 value. For example, if
 * MSH-18 contains "ISO-8859-1", the message is parsed using 8859/1 charset
 * encoding. If MSH-18 contains "UNICODE UTF-8", the message is parsed using
 * UTF-8 charset encoding.
 * </p>
 * <p>
 * Please note the following warnings regarding the use of this class:
 * <ul>
 * <li>
 * At present, this class supports only the ER7 (pipe and hat) message style.
 * Using it to receive an XML style message will result in undefined behaviour.</li>
 * <li>
 * This class attempts to detect UTF-16 encoding by searching for a byte order
 * mark at the beginning of the string. While the BOM is optional in UTF-16
 * encoding, this class will not correctly detect UTF-16 if it is missing. Both
 * big-endian and little-endian byte order is supported for UTF-16.
 * </li>
 * </ul>
 * </p>
 * 
 * @author Jens Kristian Villadsen from Cetrea A/S
 */
public class ExtendedMinLowerLayerProtocol extends LowerLayerProtocol {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public HL7Reader getReader(InputStream in) throws LLPException {
		try {
			return new ExtendedMinLLPReader(in);
		} catch (IOException e) {
			throw new LLPException("Can't create MinLLPReader with the given input stream: " + e.getMessage(), e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public HL7Writer getWriter(OutputStream theOut) throws LLPException {
		return new ExtendedMinLLPWriter(theOut);
	}
}
