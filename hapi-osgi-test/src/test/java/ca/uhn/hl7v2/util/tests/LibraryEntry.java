/**
 * The contents of this file are subject to the Mozilla Public License Version 1.1
 * (the "License"); you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at http://www.mozilla.org/MPL/
 * Software distributed under the License is distributed on an "AS IS" basis,
 * WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the
 * specific language governing rights and limitations under the License.
 *
 * The Original Code is "LibraryEntry.java".  Description:
 * "HL7 message library entry."
 *
 * The Initial Developer of the Original Code is Leslie Mann. Copyright (C)
 * 2002.  All Rights Reserved.
 *
 * Contributor(s): ______________________________________.
 *
 * Alternatively, the contents of this file may be used under the terms of the
 * GNU General Public License (the  “GPL”), in which case the provisions of the GPL are
 * applicable instead of those above.  If you wish to allow use of your version of this
 * file only under the terms of the GPL and not to allow others to use your version
 * of this file under the MPL, indicate your decision by deleting  the provisions above
 * and replace  them with the notice and other provisions required by the GPL License.
 * If you do not delete the provisions above, a recipient may use your version of
 * this file under either the MPL or the GPL.
 *
 */
package ca.uhn.hl7v2.util.tests;

import java.util.HashMap;

import ca.uhn.hl7v2.model.Message;

/**
 * HL7 message library entry.
 * Each entry is comprised of the HL7 message string, a hashmap
 * of the message's segment strings keyed by segment ID (and 
 * optionally setid if segment repeats), and parsed message.
 * Parsed message will be null if unable to parse HL7 message
 * string.
 * 
 * @author Leslie Mann
 */
public class LibraryEntry {
	private String messageString;
	private Message message;
	private HashMap segments;
	
	/**
	 * Constructor
	 * 
	 * @param msgString	HL7 message string
	 * @param segments		hashmap of message's segment's as strings
	 * @param messsage		parsed message
	 */
	public LibraryEntry(String msgStr, HashMap segments, Message msg) {
		this.messageString = msgStr;
		this.message = msg;
		this.segments = segments;
	}
	
	/**
	 * Returns HL7 message as string.
	 */
	public String messageString() {
		return messageString;
	}
	
	/**
	 * Returns parsed message.
	 */
	public Message message() {
		return message;
	}
	
	/**
	 * Returns hashmap of message segments.
	 */
	public HashMap segments() {
		return segments;
	}
}
