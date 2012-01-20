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
package ca.uhn.hl7v2.testpanel.model.msg;

import java.beans.PropertyVetoException;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import ca.uhn.hl7v2.testpanel.util.Range;

public class Hl7V2MessageEr7Test {

	@Test
	public void testFindRanges() throws PropertyVetoException {

		String line1 = "MSH|^~\\&|NES|NINTENDO|AGNEW|CORNERCUBICLE|20010101000000||ADT^A04|Q123456789T123456789X123456|P|2.3";
		String line2 = "EVN|A04|20010101000000|||^KOOPA^BOWSER^^^^^^^CURRENT";
		String line3 = "PID|1||123456789|0123456789^AA^^JP|BROS^MARIO||19850101000000|M|||123 FAKE STREET^MARIO \\T\\ LUIGI BROS PLACE^TOADSTOOL KINGDOM^NES^A1B2C3^JP^HOME^^1234|1234|(555)555-0123^HOME^JP:1234567|||S|MSH|12345678|||||||0|||||N";
		String line4 = "NK1|1|PEACH^PRINCESS|SO|ANOTHER CASTLE^^TOADSTOOL KINGDOM^NES^^JP|(123)555-1234|(123)555-2345|NOK";
		String line5 = "NK1|2|TOADSTOOL^PRINCESS|SO|YET ANOTHER CASTLE^^TOADSTOOL KINGDOM^NES^^JP|(123)555-3456|(123)555-4567|EMC";
		String line6 = "PV1|1|O|ABCD^EFGH||||123456^DINO^YOSHI^^^^^^MSRM^CURRENT^^^NEIGHBOURHOOD DR NBR|^DOG^DUCKHUNT^^^^^^^CURRENT||CRD|||||||123456^DINO^YOSHI^^^^^^MSRM^CURRENT^^^NEIGHBOURHOOD DR NBR|AO|0123456789|1|||||||||||||||||||MSH||A|||20010101000000";

		String msgString = line1 + '\r' + line2 + '\r' + line3 + '\r' + line4 + '\r' + line5 + '\r' + line6;

		Hl7V2MessageEr7 msg = new Hl7V2MessageEr7(0);
		msg.setSourceMessage(msgString);
		List<Range> ranges = msg.getSegmentRanges();

		Assert.assertEquals(line1, ranges.get(0).applyTo(msgString));
		Assert.assertEquals(line2, ranges.get(1).applyTo(msgString));
		Assert.assertEquals(line3, ranges.get(2).applyTo(msgString));
		Assert.assertEquals(line4, ranges.get(3).applyTo(msgString));
		Assert.assertEquals(line5, ranges.get(4).applyTo(msgString));
		Assert.assertEquals(line6, ranges.get(5).applyTo(msgString));

	}
}
