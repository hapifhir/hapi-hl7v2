/**
 * The contents of this file are subject to the Mozilla Public License Version 1.1
 * (the "License"); you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at http://www.mozilla.org/MPL/
 * Software distributed under the License is distributed on an "AS IS" basis,
 * WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the
 * specific language governing rights and limitations under the License.
 *
 * The Original Code is ""  Description:
 * ""
 *
 * The Initial Developer of the Original Code is University Health Network. Copyright (C)
 * 2001.  All Rights Reserved.
 *
 * Contributor(s): ______________________________________.
 *
 * Alternatively, the contents of this file may be used under the terms of the
 * GNU General Public License (the  "GPL"), in which case the provisions of the GPL are
 * applicable instead of those above.  If you wish to allow use of your version of this
 * file only under the terms of the GPL and not to allow others to use your version
 * of this file under the MPL, indicate your decision by deleting  the provisions above
 * and replace  them with the notice and other provisions required by the GPL License.
 * If you do not delete the provisions above, a recipient may use your version of
 * this file under either the MPL or the GPL.
 */
package ca.uhn.hl7v2.testpanel.util;

import org.junit.Test;
import static org.junit.Assert.*;

public class XmlScannerTest {

	@Test
	public void testFindEnclosingTag() {
		
        String message = "<ORU_R01 xmlns=\"urn:hl7-org:v2xml\">\r\n" + 
                "    <MSH>\r\n" + 
                "        <MSH.1>|</MSH.1>\r\n" + 
                "        <MSH.2>^~\\&amp;</MSH.2>\r\n" + 
                "        <MSH.3>LABMI1</MSH.3>\r\n" + 
                "        <MSH.5>DMCRES</MSH.5>\r\n" + 
                "        <MSH.7>\r\n" + 
                "            <TS.1>19951010134000</TS.1>\r\n" + 
                "        </MSH.7>\r\n" + 
                "        <MSH.9>\r\n" + 
                "            <CM_MSG.1>ORU</CM_MSG.1>\r\n" + 
                "            <CM_MSG.2>R01</CM_MSG.2>\r\n" + 
                "        </MSH.9>\r\n" + 
                "        <MSH.10>LABMI1199510101340007</MSH.10>\r\n" + 
                "        <MSH.11>D</MSH.11>\r\n" + 
                "        <MSH.12>2.2</MSH.12>\r\n" + 
                "        <MSH.15>AL</MSH.15>\r\n" + 
                "    </MSH>";
        
        XmlScanner s = new XmlScanner(message);
        s.setPosition(message.indexOf("19951010134000"));
        
        assertTrue(s.findTagEnclosingCurrentPosition());
		assertEquals("TS.1", s.getCurrentTagName());
		
	}

	@Test
	public void testFindEnclosingTagWithParent() {
		
		String message = "<AAA><BBB>1</BBB><BBB>2</BBB></AAA>";
		
        XmlScanner s = new XmlScanner(message);
        s.setCalculateRepetitions(true);
        s.setPosition(message.indexOf("2"));
        
        assertTrue(s.findTagEnclosingCurrentPosition());
		assertEquals("BBB", s.getCurrentTagName());
		assertEquals(2, s.getCurrentTagRepetition());

	}
	
}
