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

import java.io.IOException;
import java.io.StringReader;

import jsyntaxpane.Token;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import testpanel.Er7Lexer;

public class FormatUtil {

	private static final Logger ourLog = LoggerFactory.getLogger(FormatUtil.class);
	
	public static String formatEr7(String theEr7, boolean theIsType) {
		StringBuilder b = new StringBuilder();
		b.append("<html>");

		Er7Lexer lexer = new Er7Lexer(new StringReader(theEr7));

		if (theIsType) {
			lexer.yybegin(Er7Lexer.AT_START_OF_VALUE);
		}
		
		Token next;
		do {
			try {
				next = lexer.yylex();
			} catch (IOException e) {
				ourLog.error("Failed to parse", e);
				break;
			}

			if (next != null) {
				switch (next.type) {
				case KEYWORD:
				case KEYWORD2:
					b.append("<span style=\"color: #3333EE;\">");
					b.append(theEr7, next.start, next.end());
					b.append("</span>");
					break;
				case TYPE:
					b.append("<span style=\"color: #A0A0A0;\">");
					b.append(theEr7, next.start, next.end());
					b.append("</span>");
					break;
				case TYPE2:
					b.append("<span style=\"color: #990033;\">");
					b.append(theEr7, next.start, next.end());
					b.append("</span>");
					break;
				case TYPE3:
					b.append("<span style=\"color: #00A000;\">");
					b.append(theEr7, next.start, next.end());
					b.append("</span>");
					break;
				default:
					b.append(theEr7, next.start, next.end());
					break;
				}
			}

		} while (next != null);

		b.append("</html>");
		String html = b.toString().replace("\r", "<br>");
		
		return html;
	}
	
}
