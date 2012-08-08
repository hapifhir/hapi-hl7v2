/**
 * The contents of this file are subject to the Mozilla Public License Version 1.1
 * (the "License"); you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at http://www.mozilla.org/MPL/
 * Software distributed under the License is distributed on an "AS IS" basis,
 * WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the
 * specific language governing rights and limitations under the License.
 *
 * The Original Code is "MessageLibraryTest.java".  Description:
 * "Unit test class for ca.uhn.hl7v2.util.MessageLibrary"
 *
 * The Initial Developer of the Original Code is Leslie Mann. Copyright (C)
 * 2002.  All Rights Reserved.
 *
 * Contributor(s): ______________________________________.
 *
 * Alternatively, the contents of this file may be used under the terms of the
 * GNU General Public License (the  �GPL�), in which case the provisions of the GPL are
 * applicable instead of those above.  If you wish to allow use of your version of this
 * file only under the terms of the GPL and not to allow others to use your version
 * of this file under the MPL, indicate your decision by deleting  the provisions above
 * and replace  them with the notice and other provisions required by the GPL License.
 * If you do not delete the provisions above, a recipient may use your version of
 * this file under either the MPL or the GPL.
 *
 */
package ca.uhn.hl7v2.util;

import java.util.Iterator;

import junit.framework.TestCase;

/**
 * Unit test class for ca.uhn.hl7v2.util.MessageLibrary
 *
 * @author lmann
 */
public class MessageLibraryTest extends TestCase {

	/**
	 * Constructor for MessageLibraryTest.
	 * @param testName
	 */
	public MessageLibraryTest(String testName) {
		super(testName);
	}

	public static void main(String[] args) {
		junit.textui.TestRunner.run(MessageLibraryTest.class);
	}

	public void testMessageLibrary() {
		String path = "ca/uhn/hl7v2/util/messages.txt";
		MessageLibrary msgLib = new MessageLibrary(path, "VB");
		Iterator<LibraryEntry> msgs = msgLib.iterator();
		for (int i=0; i<msgLib.size(); i++) {
			LibraryEntry entry = msgs.next();
			System.out.println("Message: " + i);
			System.out.println("As String:");
			System.out.println(entry.messageString());
			System.out.println("Segments: ");
			System.out.println(entry.segments());
			System.out.println("Hapi Message: ");
			System.out.println(entry.message());
		}
		System.out.println("Number parsing errors: " + msgLib.getNumParsingErrors());
	}
	
	public void testGetMessageFilePath() {
		String path = "ca/uhn/hl7v2/util/messages.txt";
		MessageLibrary msgGen = new MessageLibrary(path, "XML");
		assertEquals("Should get message file path back", path, msgGen.getMessageFilePath());
	}			
}
