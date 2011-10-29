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
GNU General Public License (the "GPL"), in which case the provisions of the GPL are 
applicable instead of those above.  If you wish to allow use of your version of this 
file only under the terms of the GPL and not to allow others to use your version 
of this file under the MPL, indicate your decision by deleting  the provisions above 
and replace  them with the notice and other provisions required by the GPL License.  
If you do not delete the provisions above, a recipient may use your version of 
this file under either the MPL or the GPL. 

*/


package ca.uhn.hl7v2.llp;

import java.nio.charset.Charset;

import ca.uhn.hl7v2.parser.EncodingNotSupportedException;

/**
 * Charset utility class
 * 
 * @author Jens Kristian Villadsen from Cetrea A/S
 */
public class CharSetUtil
{
	/**
	 * Accepts a charset name as defined by HL7 (ie. an MSH-18 value) into
	 * a Java charset corresponding to that name
	 * 
	 * @param value
	 *            The MSH-18 field
	 * @return The MSH-18 field represented as CharSet
	 * @throws EncodingNotSupportedException
	 */
	public static Charset convertHL7CharacterEncodingToCharSetvalue(String value) throws EncodingNotSupportedException
	{
		if(value == null)
		{
			return Charset.forName("US-ASCII");
		}

		String trimmedString = value.trim().toUpperCase();
		{
			if("".equals(trimmedString))
				return Charset.forName("US-ASCII");
			if("ASCII".equals(trimmedString))
				return Charset.forName("US-ASCII");
			if("8859/1".equals(trimmedString))
				return Charset.forName("ISO-8859-1");
			if("8859/2".equals(trimmedString))
				return Charset.forName("ISO-8859-2");
			if("8859/3".equals(trimmedString))
				return Charset.forName("ISO-8859-3");
			if("8859/4".equals(trimmedString))
				return Charset.forName("ISO-8859-4");
			if("8859/5".equals(trimmedString))
				return Charset.forName("ISO-8859-5");
			if("8859/6".equals(trimmedString))
				return Charset.forName("ISO-8859-6");
			if("8859/7".equals(trimmedString))
				return Charset.forName("ISO-8859-7");
			if("8859/8".equals(trimmedString))
				return Charset.forName("ISO-8859-8");
			if("8859/9".equals(trimmedString))
				return Charset.forName("ISO-8859-9");
			if("8859/15".equals(trimmedString))
				return Charset.forName("ISO-8859-15");
			if("UNICODE UTF-8".equals(trimmedString))
				return Charset.forName("UTF-8");
			if("UNICODE UTF-16".equals(trimmedString))
				return Charset.forName("UTF-16");
			if("UNICODE".equals(trimmedString))
				return Charset.forName("UTF-8");
		}
		throw new EncodingNotSupportedException(value);
	}
}
