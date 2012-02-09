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
package ca.uhn.hl7v2.testpanel.model.conf;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.conf.ProfileException;
import ca.uhn.hl7v2.conf.parser.ProfileParser;
import ca.uhn.hl7v2.conf.spec.RuntimeProfile;
import ca.uhn.hl7v2.conf.spec.message.StaticDef;

public class ConformanceStructuresTest {

	
	
	@Test
	public void testInstantiateStructure() throws ProfileException, IOException, HL7Exception {
		
		ProfileParser parser = new ProfileParser(false);
		RuntimeProfile profile = parser.parseClasspath("testpanel/profiles/ADT_A01.xml");
		StaticDef staticDef = profile.getMessage();
		
		ConformanceMessage msg = ConformanceMessage.newInstanceFromStaticDef(staticDef, null);
		System.out.println(msg.printStructure());
		
		String string = "MSH|^~\\&|ULTRA|TML|OLIS|OLIS|200905011130||ORU^R01|20169838|T|2.3\r" // -
				+ "ZPI|||7005728^^^TML^MR||TEST^RACHEL^DIAMOND||19310313|F|||200 ANYWHERE ST^^TORONTO^ON^M6G 2T9||(416)888-8888||||||1014071185^KR\r" // -
				+ "PID|||7005728^^^TML^MR||TEST^RACHEL^DIAMOND||19310313|F|||200 ANYWHERE ST^^TORONTO^ON^M6G 2T9||(416)888-8888||||||1014071185^KR\r" // -
				+ "PV1|1||OLIS||||OLIST^BLAKE^DONALD^THOR^^^^^921379^^^^OLIST\r" // -
				+ "ORC|RE||T09-100442-RET-0^^OLIS_Site_ID^ISO|||||||||OLIST^BLAKE^DONALD^THOR^^^^L^921379\r" // -
				+ "OBR|0||T09-100442-RET-0^^OLIS_Site_ID^ISO|RET^RETICULOCYTE COUNT^HL79901 literal|||200905011106|||||||200905011106||OLIST^BLAKE^DONALD^THOR^^^^L^921379||7870279|7870279|T09-100442|MOHLTC|200905011130||B7|F||1^^^200905011106^^R\r" // -
				+ "OBX|1|IS|Z114099^Erc^L||ABC||||||F|||200905011111|PMH\r";
		msg.parse(string);
		
		System.out.println(msg.printStructure());

		// This was failing
		assertEquals(1, msg.getAll("ZPI").length);
	}
	
	@Test
	public void testInstantiateStructureWithRepeat() throws ProfileException, IOException, HL7Exception {
		
		ProfileParser parser = new ProfileParser(false);
		RuntimeProfile profile = parser.parseClasspath("testpanel/profiles/ADT_A01.xml");
		StaticDef staticDef = profile.getMessage();
		
		ConformanceMessage msg = ConformanceMessage.newInstanceFromStaticDef(staticDef, null);
		System.out.println(msg.printStructure());
		
		String string = "MSH|^~\\&|ULTRA~AAA|TML|OLIS|OLIS|200905011130||ORU^R01|20169838|T|2.3\r" // -
				+ "ZPI|||7005728^^^TML^MR||TEST^RACHEL^DIAMOND||19310313|F|||200 ANYWHERE ST^^TORONTO^ON^M6G 2T9||(416)888-8888||||||1014071185^KR\r" // -
				+ "PID|||7005728^^^TML^MR||TEST^RACHEL^DIAMOND||19310313|F|||200 ANYWHERE ST^^TORONTO^ON^M6G 2T9||(416)888-8888||||||1014071185^KR\r" // -
				+ "ROL|1\r"
				+ "ROL|2\r"
				+ "PV1|1||OLIS||||OLIST^BLAKE^DONALD^THOR^^^^^921379^^^^OLIST\r" // -
				+ "ORC|RE||T09-100442-RET-0^^OLIS_Site_ID^ISO|||||||||OLIST^BLAKE^DONALD^THOR^^^^L^921379\r" // -
				+ "OBR|0||T09-100442-RET-0^^OLIS_Site_ID^ISO|RET^RETICULOCYTE COUNT^HL79901 literal|||200905011106|||||||200905011106||OLIST^BLAKE^DONALD^THOR^^^^L^921379||7870279|7870279|T09-100442|MOHLTC|200905011130||B7|F||1^^^200905011106^^R\r" // -
				+ "OBX|1|IS|Z114099^Erc^L||ABC||||||F|||200905011111|PMH\r"
				+ "PR1|1\r"
				+ "PR1|2\r";
		msg.parse(string);
		
		System.out.println(msg.printStructure());

		// This was failing
		assertEquals(1, msg.getAll("ZPI").length);
	}

}
