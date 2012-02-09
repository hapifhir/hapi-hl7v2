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

import static org.junit.Assert.*;

import java.beans.PropertyVetoException;
import java.io.CharArrayWriter;
import java.io.IOException;
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;

import ca.uhn.hl7v2.conf.ProfileException;
import ca.uhn.hl7v2.model.DataTypeException;
import ca.uhn.hl7v2.model.v23.message.ORU_R01;
import ca.uhn.hl7v2.testpanel.model.UnknownMessage;
import ca.uhn.hl7v2.testpanel.model.conf.ConformanceMessage;
import ca.uhn.hl7v2.testpanel.model.conf.ProfileGroup;
import ca.uhn.hl7v2.testpanel.util.FileUtils;
import ca.uhn.hl7v2.testpanel.util.LineEndingsEnum;
import ca.uhn.hl7v2.testpanel.util.Range;
import ca.uhn.hl7v2.testpanel.xsd.Hl7V2EncodingTypeEnum;

public class Hl7V2MessageCollectionTest {
	
	@Test
	public void testTwoMessagesAgainstEachOther() {

		String fullMsg = "MSH|^~\\&|ULTRA|TML|OLIS|OLIS|200905011130||ORU^R01|20169838|T|2.3\r" + "MSH|^~\\&|ULTRA|TML|OLIS|OLIS|200905011130||ORU^R01|20169838|T|2.3\r";

		Hl7V2MessageCollection col = new Hl7V2MessageCollection();
		col.setSourceMessage(fullMsg);

		List<AbstractMessage<?>> msgs = col.getMessages();
		assertEquals(2, msgs.size());

	}

	@Test
	public void testFirstLineComment() {

		String fullMsg = 
				"MSH|^~\\&|ULTRA|TML|OLIS|OLIS|200905011130||ORU^R01|20169838|T|2.3\r" + 
				"MSH|^~\\&|ULTRA|TML|OLIS|OLIS|200905011130||ORU^R01|20169838|T|2.3\r";
		Hl7V2MessageCollection col = new Hl7V2MessageCollection();
		col.setSourceMessage(fullMsg);
		assertTrue(col.getMessageDescription().contains("2"));

		fullMsg =
				"#THIS\r" +
				"MSH|^~\\&|ULTRA|TML|OLIS|OLIS|200905011130||ORU^R01|20169838|T|2.3\r" + 
				"MSH|^~\\&|ULTRA|TML|OLIS|OLIS|200905011130||ORU^R01|20169838|T|2.3\r";
		col = new Hl7V2MessageCollection();
		col.setSourceMessage(fullMsg);
		assertTrue(col.getMessageDescription(), col.getMessageDescription().equals("THIS"));

		fullMsg =
				"#THIS IS A COMMENT\r" +
				"MSH|^~\\&|ULTRA|TML|OLIS|OLIS|200905011130||ORU^R01|20169838|T|2.3\r" + 
				"MSH|^~\\&|ULTRA|TML|OLIS|OLIS|200905011130||ORU^R01|20169838|T|2.3\r";
		col = new Hl7V2MessageCollection();
		col.setSourceMessage(fullMsg);
		assertTrue(col.getMessageDescription(), col.getMessageDescription().equals("THIS IS A COMMENT"));

		fullMsg =
				"#     THIS IS A COMMENT\r" +
				"MSH|^~\\&|ULTRA|TML|OLIS|OLIS|200905011130||ORU^R01|20169838|T|2.3\r" + 
				"MSH|^~\\&|ULTRA|TML|OLIS|OLIS|200905011130||ORU^R01|20169838|T|2.3\r";
		col = new Hl7V2MessageCollection();
		col.setSourceMessage(fullMsg);
		assertTrue(col.getMessageDescription(), col.getMessageDescription().equals("THIS IS A COMMENT"));

		fullMsg =
				"#     THIS IS A COMMENT     \r" +
				"MSH|^~\\&|ULTRA|TML|OLIS|OLIS|200905011130||ORU^R01|20169838|T|2.3\r" + 
				"MSH|^~\\&|ULTRA|TML|OLIS|OLIS|200905011130||ORU^R01|20169838|T|2.3\r";
		col = new Hl7V2MessageCollection();
		col.setSourceMessage(fullMsg);
		assertTrue(col.getMessageDescription(), col.getMessageDescription().equals("THIS IS A COMMENT"));

		fullMsg =
				"#\r" +
				"MSH|^~\\&|ULTRA|TML|OLIS|OLIS|200905011130||ORU^R01|20169838|T|2.3\r" + 
				"MSH|^~\\&|ULTRA|TML|OLIS|OLIS|200905011130||ORU^R01|20169838|T|2.3\r";
		col = new Hl7V2MessageCollection();
		col.setSourceMessage(fullMsg);
		assertTrue(col.getMessageDescription(), col.getMessageDescription().contains("2"));

		fullMsg =
				"#  \r" +
				"MSH|^~\\&|ULTRA|TML|OLIS|OLIS|200905011130||ORU^R01|20169838|T|2.3\r" + 
				"MSH|^~\\&|ULTRA|TML|OLIS|OLIS|200905011130||ORU^R01|20169838|T|2.3\r";
		col = new Hl7V2MessageCollection();
		col.setSourceMessage(fullMsg);
		assertTrue(col.getMessageDescription(), col.getMessageDescription().contains("2"));

		fullMsg =
				"MSH|^~\\&|ULTRA|TML|OLIS|OLIS|200905011130||ORU^R01|20169838|T|2.3\r" + 
				"#  \r" +
				"MSH|^~\\&|ULTRA|TML|OLIS|OLIS|200905011130||ORU^R01|20169838|T|2.3\r";
		col = new Hl7V2MessageCollection();
		col.setSourceMessage(fullMsg);
		assertTrue(col.getMessageDescription(), col.getMessageDescription().contains("2"));

		fullMsg =
				"MSH|^~\\&|ULTRA|TML|OLIS|OLIS|200905011130||ORU^R01|20169838|T|2.3\r" + 
				"# BLAH \r" +
				"MSH|^~\\&|ULTRA|TML|OLIS|OLIS|200905011130||ORU^R01|20169838|T|2.3\r";
		col = new Hl7V2MessageCollection();
		col.setSourceMessage(fullMsg);
		assertTrue(col.getMessageDescription(), col.getMessageDescription().contains("2"));
	
	}

	@Test
	public void testAddMessage() throws PropertyVetoException {

		String fullMessages = "MSH|^~\\&|ULTRA|TML|OLIS|OLIS|200905011130||ORU^R01|20169838|T|2.3\r";

		Hl7V2MessageCollection col = new Hl7V2MessageCollection();
		col.setSourceMessage(fullMessages);

		List<AbstractMessage<?>> msgs = col.getMessages();
		assertEquals(1, msgs.size());
		assertEquals(fullMessages, col.getSourceMessage());

		Hl7V2MessageEr7 newMessage = new Hl7V2MessageEr7();
		newMessage.setEncoding(Hl7V2EncodingTypeEnum.ER_7);
		newMessage.setIndexWithinCollection(1);
		newMessage.setSourceMessage(fullMessages);

		col.addMessage(newMessage);

		msgs = col.getMessages();
		assertEquals(2, msgs.size());
		assertEquals(fullMessages + fullMessages, col.getSourceMessage());

	}

	@Test
	public void testSaveMessage() throws PropertyVetoException, IOException {

		String fullMessages //-
				= "MSH|^~\\&|ULTRA|TML|OLIS|OLIS|200905011130||ORU^R01|20169838|T|2.3\r"  //- 
				+ "# This is a comment\r"  //-
				+ "MSH|^~\\&|ULTRA|TML|OLIS|OLIS|200905011130||ORU^R01|20169838|T|2.3\r"; 

		String fullMessagesManyComments //-
			= "# This is a comment\r"  //-
			+ "   \r"  //-
			+ "MSH|^~\\&|ULTRA|TML|OLIS|OLIS|200905011130||ORU^R01|20169838|T|2.3\r"  //- 
			+ "# This is a comment\r"  //-
			+ "# This is a comment\r"  //-
			+ "   \r"  //-
			+ "   \r"  //-
			+ "# This is a comment\r"  //-
			+ "MSH|^~\\&|ULTRA|TML|OLIS|OLIS|200905011130||ORU^R01|20169838|T|2.3\r" //- 
			+ "# This is a comment\r"  //-
			+ "# This is a comment\r";

		String fullMessagesNoComment 
			= "MSH|^~\\&|ULTRA|TML|OLIS|OLIS|200905011130||ORU^R01|20169838|T|2.3\r" 
			+ "MSH|^~\\&|ULTRA|TML|OLIS|OLIS|200905011130||ORU^R01|20169838|T|2.3\r";

		Hl7V2MessageCollection col = new Hl7V2MessageCollection();
		col.setSourceMessage(fullMessages);

		{
			CharArrayWriter w = new CharArrayWriter();
			col.writeToFile(w, false, LineEndingsEnum.HL7);
			String actual = w.toString();
			assertEquals(fullMessages, actual);
		}

		{
			CharArrayWriter w = new CharArrayWriter();
			col.writeToFile(w, false, LineEndingsEnum.UNIX);
			String actual = w.toString();
			assertEquals(fullMessages.replace("\r", "\n"), actual);
		}

		{
			CharArrayWriter w = new CharArrayWriter();
			col.writeToFile(w, false, LineEndingsEnum.WINDOWS);
			String actual = w.toString();
			assertEquals(fullMessages.replace("\r", "\r\n"), actual);
		}

		col = new Hl7V2MessageCollection();
		col.setSourceMessage(fullMessagesManyComments);
		
		{
			CharArrayWriter w = new CharArrayWriter();
			col.writeToFile(w, true, LineEndingsEnum.WINDOWS);
			String actual = w.toString();
			assertEquals(fullMessagesNoComment.replace("\r", "\r\n"), actual);
		}

	}

	@Test
	public void testParseMixedMessagesAndComments() throws PropertyVetoException {

		String normalMsgLine = "MSH|^~\\&|ULTRA|TML|OLIS|OLIS|200905011130||ORU^R01|20169838|T|2.3\rPID|1\r";
		String commentLine = "#COMMENT\r";
		String junkLine = "0123456789\r";
		String emptyLine = "\r";

		// 1 message
		{
			Hl7V2MessageCollection col = new Hl7V2MessageCollection();
			col.setSourceMessage(normalMsgLine);
			List<AbstractMessage<?>> msgs = col.getMessages();
			assertEquals(1, msgs.size());

			assertEquals(Hl7V2MessageEr7.class, msgs.get(0).getClass());
			assertEquals(new Range(0, normalMsgLine.length()), col.getMessageRanges().get(0));
		}

		// 1 message, 1 comment
		{
			int start0 = 0;
			String string = normalMsgLine;
			int start1 = string.length();
			string += commentLine;
			int start2 = string.length();

			Hl7V2MessageCollection col = new Hl7V2MessageCollection();
			col.setSourceMessage(string);
			List<AbstractMessage<?>> msgs = col.getMessages();
			assertEquals(2, msgs.size());

			assertEquals(Hl7V2MessageEr7.class, msgs.get(0).getClass());
			assertEquals(new Range(start0, start1), col.getMessageRanges().get(0));

			assertEquals(Comment.class, msgs.get(1).getClass());
			assertEquals(new Range(start1, start2), col.getMessageRanges().get(1));
		}

		// 1 message, 2 comments
		{
			int start0 = 0;
			String string = normalMsgLine;
			int start1 = string.length();
			string += commentLine;
			string += commentLine;
			int start2 = string.length();

			Hl7V2MessageCollection col = new Hl7V2MessageCollection();
			col.setSourceMessage(string);
			List<AbstractMessage<?>> msgs = col.getMessages();
			assertEquals(2, msgs.size());

			assertEquals(Hl7V2MessageEr7.class, msgs.get(0).getClass());
			assertEquals(new Range(start0, start1), col.getMessageRanges().get(0));

			assertEquals(Comment.class, msgs.get(1).getClass());
			assertEquals(new Range(start1, start2), col.getMessageRanges().get(1));
		}

		// 1 message, 2 comments, 2 empty
		{
			int start0 = 0;
			String string = normalMsgLine;
			int start1 = string.length();
			string += commentLine;
			string += commentLine;
			int start2 = string.length();
			string += emptyLine;
			string += emptyLine;

			Hl7V2MessageCollection col = new Hl7V2MessageCollection();
			col.setSourceMessage(string);
			List<AbstractMessage<?>> msgs = col.getMessages();
			assertEquals(2, msgs.size());

			assertEquals(Hl7V2MessageEr7.class, msgs.get(0).getClass());
			assertEquals(new Range(start0, start1), col.getMessageRanges().get(0));

			assertEquals(Comment.class, msgs.get(1).getClass());
			assertEquals(new Range(start1, start2), col.getMessageRanges().get(1));
		}

		// 1 message, 2 comments, 2 empty, 1 message
		{
			int start0 = 0;
			String string = normalMsgLine;
			int start1 = string.length();
			string += commentLine;
			string += commentLine;
			int start2 = string.length();
			string += emptyLine;
			string += emptyLine;
			int start3 = string.length();
			string += normalMsgLine;
			int start4 = string.length();

			Hl7V2MessageCollection col = new Hl7V2MessageCollection();
			col.setSourceMessage(string);
			List<AbstractMessage<?>> msgs = col.getMessages();
			assertEquals(3, msgs.size());

			assertEquals(Hl7V2MessageEr7.class, msgs.get(0).getClass());
			assertEquals(new Range(start0, start1), col.getMessageRanges().get(0));

			assertEquals(Comment.class, msgs.get(1).getClass());
			assertEquals(new Range(start1, start2), col.getMessageRanges().get(1));

			assertEquals(Hl7V2MessageEr7.class, msgs.get(2).getClass());
			assertEquals(new Range(start3, start4), col.getMessageRanges().get(2));

		}

		// 2 empty, 1 message
		{
			int start0 = 0;
			String string = "";
			string += emptyLine;
			string += emptyLine;
			int start1 = string.length();
			string += normalMsgLine;
			int start2 = string.length();

			Hl7V2MessageCollection col = new Hl7V2MessageCollection();
			col.setSourceMessage(string);
			List<AbstractMessage<?>> msgs = col.getMessages();
			assertEquals(1, msgs.size());

			assertEquals(Hl7V2MessageEr7.class, msgs.get(0).getClass());
			assertEquals(new Range(start1, start2), col.getMessageRanges().get(0));
		}

	}

	@Test
	public void testEr7TwoMessagesWithBlankLinesBetween() {

		String fullMessages = "MSH|^~\\&|ULTRA|TML|OLIS|OLIS|200905011130||ORU^R01|20169838|T|2.3\r" + "\r\r" + "MSH|^~\\&|ULTRA|TML|OLIS|OLIS|200905011130||ORU^R01|20169838|T|2.3";
		Hl7V2MessageCollection col = new Hl7V2MessageCollection();
		col.setSourceMessage(fullMessages);

		List<AbstractMessage<?>> msgs = col.getMessages();
		assertEquals(2, msgs.size());
		assertEquals(Hl7V2MessageEr7.class, msgs.get(0).getClass());
		assertEquals(Hl7V2MessageEr7.class, msgs.get(1).getClass());

	}

	@Test
	public void testEr7TwoMessagesWithContentInBetween() {

		String fullMessages = "MSH|^~\\&|ULTRA|TML|OLIS|OLIS|200905011130||ORU^R01|20169838|T|2.3\r" + "\r\r" + "AAAA\r" + "MSH|^~\\&|ULTRA|TML|OLIS|OLIS|200905011130||ORU^R01|20169838|T|2.3";
		Hl7V2MessageCollection col = new Hl7V2MessageCollection();
		col.setSourceMessage(fullMessages);

		List<AbstractMessage<?>> msgs = col.getMessages();
		assertEquals(3, msgs.size());
		assertEquals(Hl7V2MessageEr7.class, msgs.get(0).getClass());
		assertEquals(UnknownMessage.class, msgs.get(1).getClass());
		assertEquals(Hl7V2MessageEr7.class, msgs.get(2).getClass());

	}

	@Test
	public void testUpdadeSourceBasedOnParsedMessage() throws DataTypeException {

		String fullMessages = "MSH|^~\\&|ULTRA|TML|OLIS|OLIS|200905011130||ORU^R01|20169838|T|2.3\r";
		Hl7V2MessageCollection col = new Hl7V2MessageCollection();
		col.setSourceMessage(fullMessages);

		List<AbstractMessage<?>> msgs = col.getMessages();
		Hl7V2MessageEr7 msg = (Hl7V2MessageEr7) msgs.get(0);

		ORU_R01 oru = (ORU_R01) msg.getParsedMessage();
		oru.getMSH().getMsh3_SendingApplication().getHd3_UniversalIDType().setValue("AAA");

		col.updateSourceMessageBasedOnParsedMessage(0, oru);

		String sm = col.getSourceMessage();
		assertTrue(sm, sm.contains("ULTRA^^AAA"));
	}

	@Test
	public void testLoadProfile() throws ProfileException, IOException {

		String msg = "MSH|^~\\&|ULTRA|TML|OLIS|OLIS|200905011130||ORU^R01|20169838|T|2.3\r";

		Hl7V2MessageCollection col = new Hl7V2MessageCollection();
		ProfileGroup pg = ProfileGroup.createFromRuntimeProfile(FileUtils.loadResourceFromClasspath("testpanel/profiles/ADT_A01.xml"));
		col.setRuntimeProfile(pg);
		col.setSourceMessage(msg);

		Assert.assertEquals(ConformanceMessage.class, col.getMessages().get(0).getParsedMessage().getClass());
	}

	/**
	 * Replicating a malformed message that caused an exception in the parser
	 */
	@Test
	public void testMalformedBetweenMessage() {

		String msg = "MSH|^~\\&|ULTRA|TML|OLIS|OLIS|200905011130||ORU^R01|20169838|T|2.3\r\n"
				+ "ZPI|||7005728^^^TML^MR||TEST^RACHEL^DIAMOND||19310313|F|||200 ANYWHERE ST^^TORONTO^ON^M6G 2T9||(416)888-8888||||||1014071185^KR\r\n"
				+ "PID|||7005728^^^TML^MR||TEST^RACHEL^DIAMOND||19310313|F|||200 ANYWHERE ST^^TORONTO^ON^M6G 2T9||(416)888-8888||||||1014071185^KR\r\n"
				+ "PV1|1||OLIS||||OLIST^BLAKE^DONALD^THOR^^^^^921379^^^^OLIST\r\n"
				+ "ORC|RE||T09-100442-RET-0^^OLIS_Site_ID^ISO|||||||||OLIST^BLAKE^DONALD^THOR^^^^L^921379\r\n"
				+ "OBR|0||T09-100442-RET-0^^OLIS_Site_ID^ISO|RET^RETICULOCYTE COUNT^HL79901 literal|||200905011106|||||||200905011106||OLIST^BLAKE^DONALD^THOR^^^^L^921379||7870279|7870279|T09-100442|MOHLTC|200905011130||B7|F||1^^^200905011106^^R\r\n"
				+ "OBX|1|IS|Z114099^Erc^L||ABC||||||F|||200905011111|PMH\r\n" + "				next.addPropertyChangeListener(Hl7V2MessageCollection.PROP_DESCRIPTION, myMessageDescriptionListener);\r\n"
				+ "				next.addPropertyChangeListener(Hl7V2MessageCollection.PROP_DESCRIPTION, myMessageDescriptionListener);\r\n"
				+ "				next.addPropertyChangeListener(Hl7V2MessageCollection.PROP_DESCRIPTION, myMessageDescriptionListener);\r\n" + "M";
		Hl7V2MessageCollection col = new Hl7V2MessageCollection();
		col.setSourceMessage(msg);

		msg += "S";
		col.setSourceMessage(msg);

		msg += "H";
		col.setSourceMessage(msg);

		msg += "|";
		col.setSourceMessage(msg);
	}

	@Test
	public void testXmlMessage() {

		String message = "<ORU_R01 xmlns=\"urn:hl7-org:v2xml\">\r\n" + "    <MSH>\r\n" + "        <MSH.1>|</MSH.1>\r\n" + "        <MSH.2>^~\\&amp;</MSH.2>\r\n" + "        <MSH.3>LABMI1</MSH.3>\r\n"
				+ "        <MSH.5>DMCRES</MSH.5>\r\n" + "        <MSH.7>\r\n" + "            <TS.1>19951010134000</TS.1>\r\n" + "        </MSH.7>\r\n" + "        <MSH.9>\r\n"
				+ "            <CM_MSG.1>ORU</CM_MSG.1>\r\n" + "            <CM_MSG.2>R01</CM_MSG.2>\r\n" + "        </MSH.9>\r\n" + "        <MSH.10>CONTROL001</MSH.10>\r\n"
				+ "        <MSH.11>D</MSH.11>\r\n" + "        <MSH.12>2.2</MSH.12>\r\n" + "        <MSH.15>AL</MSH.15>\r\n" + "    </MSH>\r\n" + "</ORU_R01>";
		int messageLen = message.replace("\r\n", "\r").length();

		Hl7V2MessageCollection col = new Hl7V2MessageCollection();
		col.setEncoding(Hl7V2EncodingTypeEnum.XML);

		col.setSourceMessage(message);

		assertEquals(1, col.getMessages().size());
		assertEquals(Hl7V2MessageXml.class, col.getMessages().get(0).getClass());

		ca.uhn.hl7v2.model.v22.message.ORU_R01 pmsg = (ca.uhn.hl7v2.model.v22.message.ORU_R01) ((Hl7V2MessageXml) col.getMessages().get(0)).getParsedMessage();
		assertEquals("CONTROL001", pmsg.getMSH().getMessageControlID().getValue());
		assertEquals(new Range(0, messageLen), col.getMessageRanges().get(0));
	}

	@Test
	public void testXmlMessageWithTwoBackToBack() {

		String message = "<ORU_R01 xmlns=\"urn:hl7-org:v2xml\">\r\n" + "    <MSH>\r\n" + "        <MSH.1>|</MSH.1>\r\n" + "        <MSH.2>^~\\&amp;</MSH.2>\r\n" + "        <MSH.3>LABMI1</MSH.3>\r\n"
				+ "        <MSH.5>DMCRES</MSH.5>\r\n" + "        <MSH.7>\r\n" + "            <TS.1>19951010134000</TS.1>\r\n" + "        </MSH.7>\r\n" + "        <MSH.9>\r\n"
				+ "            <CM_MSG.1>ORU</CM_MSG.1>\r\n" + "            <CM_MSG.2>R01</CM_MSG.2>\r\n" + "        </MSH.9>\r\n" + "        <MSH.10>CONTROL001</MSH.10>\r\n"
				+ "        <MSH.11>D</MSH.11>\r\n" + "        <MSH.12>2.2</MSH.12>\r\n" + "        <MSH.15>AL</MSH.15>\r\n" + "    </MSH>\r\n" + "</ORU_R01>";
		int messageLen = message.replace("\r\n", "\r").length();

		Hl7V2MessageCollection col = new Hl7V2MessageCollection();
		col.setEncoding(Hl7V2EncodingTypeEnum.XML);

		String fullMsg = message + message.replace("CONTROL001", "CONTROL002");
		col.setSourceMessage(fullMsg);

		assertEquals(2, col.getMessages().size());
		assertEquals(Hl7V2MessageXml.class, col.getMessages().get(0).getClass());
		assertEquals(Hl7V2MessageXml.class, col.getMessages().get(1).getClass());

		ca.uhn.hl7v2.model.v22.message.ORU_R01 pmsg = (ca.uhn.hl7v2.model.v22.message.ORU_R01) ((Hl7V2MessageXml) col.getMessages().get(0)).getParsedMessage();
		assertEquals("CONTROL001", pmsg.getMSH().getMessageControlID().getValue());
		assertEquals(new Range(0, messageLen), col.getMessageRanges().get(0));

		pmsg = (ca.uhn.hl7v2.model.v22.message.ORU_R01) ((Hl7V2MessageXml) col.getMessages().get(1)).getParsedMessage();
		assertEquals("CONTROL002", pmsg.getMSH().getMessageControlID().getValue());
		assertEquals(new Range(messageLen, (messageLen * 2)), col.getMessageRanges().get(1));

	}

	@Test
	public void testChangeEncoding() {

		String fullMsg = "MSH|^~\\&|ULTRA|TML|OLIS|OLIS|200905011130||ORU^R01|20169838|T|2.3\r" + "MSH|^~\\&|ULTRA|TML|OLIS|OLIS|200905011130||ORU^R01|20169838|T|2.3\r";

		Hl7V2MessageCollection col = new Hl7V2MessageCollection();
		col.setSourceMessage(fullMsg);

		List<AbstractMessage<?>> msgs = col.getMessages();
		assertEquals(2, msgs.size());

		// nothing should happen
		col.setEncoding(Hl7V2EncodingTypeEnum.ER_7);
		assertTrue(col.getSourceMessage().contains("MSH|"));
		
		// convert to XML
		col.setEncoding(Hl7V2EncodingTypeEnum.XML);
		assertFalse(col.getSourceMessage().contains("MSH|"));
		assertTrue(col.getSourceMessage().contains("<MSH>"));

		// convert to ER7
		col.setEncoding(Hl7V2EncodingTypeEnum.ER_7);
		assertFalse(col.getSourceMessage().contains("<MSH>"));
		assertTrue(col.getSourceMessage().contains("MSH|"));

	}

}
