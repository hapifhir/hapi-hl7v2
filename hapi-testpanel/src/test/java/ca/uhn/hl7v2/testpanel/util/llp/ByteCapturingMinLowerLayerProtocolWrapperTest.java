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
package ca.uhn.hl7v2.testpanel.util.llp;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;

import org.junit.Assert;
import org.junit.Test;

import ca.uhn.hl7v2.llp.HL7Reader;
import ca.uhn.hl7v2.llp.LLPException;
import ca.uhn.hl7v2.llp.MinLLPWriter;
import ca.uhn.hl7v2.llp.MinLowerLayerProtocol;

public class ByteCapturingMinLowerLayerProtocolWrapperTest {

	@Test
	public void testRead() throws IOException, LLPException {
		
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		MinLLPWriter w = new MinLLPWriter(bos);
		w.writeMessage("TESTMESSAGE");
		
		String expected = bos.toString();
		
		InputStream iis = new ByteArrayInputStream(expected.getBytes());

		ByteCapturingMinLowerLayerProtocolWrapper cap = new ByteCapturingMinLowerLayerProtocolWrapper(new MinLowerLayerProtocol());
		HL7Reader reader = cap.getReader(iis);
		String message = reader.getMessage();
		
		Assert.assertEquals("TESTMESSAGE", message);
		byte[] bytes = expected.getBytes();
		byte[] readBytes = cap.getReadBytes();
		
		Assert.assertEquals(bytes.length, readBytes.length);
		for (int i = 0; i < bytes.length; i++) {
			Assert.assertEquals(bytes[i], readBytes[i]);
		}
	}
	
}
